package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.filters.Filter
import com.intellij.execution.filters.OpenFileHyperlinkInfo
import com.intellij.openapi.application.runReadAction
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import org.jetbrains.annotations.VisibleForTesting

/**
 * Links gleeunit failure lines like ` test: my_module.some_test` back to the test function in source.
 *
 * gleeunit (both the Erlang and JavaScript runners) reports a failure as a block whose second line
 * is ` test: <module>.<function>`. Passing tests are only ever rendered as bare dots, so this is the
 * one navigable signal the runner emits. The `panic ... should.gleam:line` line in the same block
 * points into the gleeunit assertion helper, not the user's test, so we resolve via the qualified
 * test name instead.
 */
class GleamTestOutputFilter(private val project: Project) : Filter {

    private val testLine = Regex("""test:\s+(\S+)""")

    override fun applyFilter(line: String, entireLength: Int): Filter.Result? {
        val match = testLine.find(line) ?: return null
        val qualified = match.groupValues[1]
        val lastDot = qualified.lastIndexOf('.')
        if (lastDot <= 0 || lastDot == qualified.length - 1) return null
        val moduleRef = qualified.substring(0, lastDot)
        val functionName = qualified.substring(lastDot + 1)

        val target = runReadAction { resolve(moduleRef, functionName) } ?: return null

        val lineStart = entireLength - line.length
        val nameRange = match.groups[1]!!.range
        return Filter.Result(
            lineStart + nameRange.first,
            lineStart + nameRange.last + 1,
            OpenFileHyperlinkInfo(project, target.file, target.line)
        )
    }

    @VisibleForTesting
    data class Target(val file: VirtualFile, val line: Int)

    /**
     * Resolves a gleeunit module reference (e.g. `foo@bar_test` on Erlang or `foo/bar_test`) and a
     * test function name to the source file and the 0-based line of the function declaration.
     */
    @VisibleForTesting
    fun resolve(moduleRef: String, functionName: String): Target? {
        val modulePath = moduleRef.replace('@', '/')
        val fileName = modulePath.substringAfterLast('/') + ".gleam"
        val candidates = FilenameIndex.getVirtualFilesByName(fileName, GlobalSearchScope.allScope(project))
        if (candidates.isEmpty()) return null
        val file = candidates.firstOrNull { it.path.replace('\\', '/').endsWith("$modulePath.gleam") }
            ?: candidates.first()
        return Target(file, findFunctionLine(file, functionName))
    }

    private fun findFunctionLine(file: VirtualFile, functionName: String): Int {
        val document = FileDocumentManager.getInstance().getDocument(file) ?: return 0
        val decl = Regex("""(?m)^[ \t]*(?:pub[ \t]+)?fn[ \t]+${Regex.escape(functionName)}[ \t]*\(""")
        val match = decl.find(document.charsSequence) ?: return 0
        return document.getLineNumber(match.range.first)
    }
}
