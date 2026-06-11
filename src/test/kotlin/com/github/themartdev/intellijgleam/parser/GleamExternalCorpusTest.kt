package com.github.themartdev.intellijgleam.parser

import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiRecursiveElementWalkingVisitor
import java.io.File
import java.nio.file.FileSystems
import java.nio.file.Path
import kotlin.io.path.absolutePathString
import kotlin.io.path.readText

/**
 * Parses every `.gleam` file found under an external corpus directory and fails if any of them
 * produce a [PsiErrorElement]. Used to validate the grammar against real-world Gleam code,
 * primarily the `test/language` package of the gleam-lang/gleam repository at a given release tag.
 *
 * This test is a NO-OP unless the `gleam.corpus.dir` system property is set, so it never affects
 * regular `./gradlew test` runs. It is driven by CI (see `.github/workflows/gleam-release-watch.yml`)
 * or manually:
 *
 * ```
 * ./scripts/fetch-gleam-corpus.sh v1.14.0 build/gleam-corpus
 * ./gradlew test --tests '*GleamExternalCorpusTest' \
 *     -Pgleam.corpus.dir=$PWD/build/gleam-corpus \
 *     -Pgleam.corpus.report=$PWD/build/gleam-corpus-report.md
 * ```
 *
 * System properties (forwarded from Gradle `-P` properties of the same name, see build.gradle.kts):
 *  - `gleam.corpus.dir`        required to activate; directory scanned recursively for `.gleam` files
 *  - `gleam.corpus.report`     optional; path where a Markdown report is written (pass or fail)
 *  - `gleam.corpus.exclusions` optional; exclusions file, defaults to `scripts/corpus-exclusions.txt`
 */
class GleamExternalCorpusTest : GleamParsingTestCase() {

    private data class FileFailure(val relativePath: String, val errors: List<ErrorInfo>)

    private data class ErrorInfo(val line: Int, val column: Int, val description: String, val lineText: String)

    fun testExternalCorpus() {
        val corpusDirProp = System.getProperty("gleam.corpus.dir")
        if (corpusDirProp.isNullOrBlank()) {
            println("gleam.corpus.dir not set - skipping external corpus validation (this is normal for regular test runs)")
            return
        }

        val corpusDir = File(corpusDirProp).absoluteFile
        assertTrue("Corpus directory does not exist: $corpusDir", corpusDir.isDirectory)

        val exclusions = loadExclusions()
        val gleamFiles = corpusDir.walkTopDown()
            .filter { it.isFile && it.extension == "gleam" }
            .map { it.toPath() }
            .sortedBy { it.absolutePathString() }
            .toList()
        assertFalse("No .gleam files found under $corpusDir - corpus fetch likely failed", gleamFiles.isEmpty())

        val failures = mutableListOf<FileFailure>()
        val excluded = mutableListOf<String>()
        var passed = 0

        for (path in gleamFiles) {
            val relative = corpusDir.toPath().relativize(path).toString().replace(File.separatorChar, '/')
            if (isExcluded(relative, exclusions)) {
                excluded.add(relative)
                continue
            }
            val errors = parseAndCollectErrors(relative, path)
            if (errors.isEmpty()) passed++ else failures.add(FileFailure(relative, errors))
        }

        val report = buildReport(gleamFiles.size, passed, excluded, failures)
        writeReportIfRequested(report)
        println(report)

        if (failures.isNotEmpty()) {
            fail(
                "${failures.size} of ${gleamFiles.size} corpus files failed to parse cleanly " +
                        "(${excluded.size} excluded). See report above. " +
                        "First failure: ${failures.first().relativePath}"
            )
        }
    }

    private fun parseAndCollectErrors(relativePath: String, path: Path): List<ErrorInfo> {
        val text = path.readText().replace("\r\n", "\n")
        // Name only matters for error messages; ParsingTestCase appends the extension itself.
        val psiFile = createPsiFile(relativePath.removeSuffix(".gleam").replace('/', '_'), text)
        val errors = mutableListOf<ErrorInfo>()
        psiFile.accept(object : PsiRecursiveElementWalkingVisitor() {
            override fun visitElement(element: com.intellij.psi.PsiElement) {
                if (element is PsiErrorElement) {
                    errors.add(toErrorInfo(element, text))
                }
                super.visitElement(element)
            }
        })
        return errors
    }

    private fun toErrorInfo(error: PsiErrorElement, text: String): ErrorInfo {
        val offset = error.textRange.startOffset.coerceIn(0, text.length)
        var line = 0
        var lineStart = 0
        for (i in 0 until offset) {
            if (text[i] == '\n') {
                line++
                lineStart = i + 1
            }
        }
        val lineEnd = text.indexOf('\n', lineStart).let { if (it == -1) text.length else it }
        return ErrorInfo(
            line = line + 1,
            column = offset - lineStart + 1,
            description = error.errorDescription,
            lineText = text.substring(lineStart, lineEnd).trim(),
        )
    }

    private fun loadExclusions(): List<String> {
        val pathProp = System.getProperty("gleam.corpus.exclusions") ?: "scripts/corpus-exclusions.txt"
        val file = File(pathProp)
        if (!file.isFile) return emptyList()
        return file.readLines()
            .map { it.substringBefore('#').trim() }
            .filter { it.isNotEmpty() }
    }

    private fun isExcluded(relativePath: String, exclusions: List<String>): Boolean {
        val fs = FileSystems.getDefault()
        return exclusions.any { pattern ->
            relativePath == pattern || fs.getPathMatcher("glob:$pattern").matches(fs.getPath(relativePath))
        }
    }

    private fun buildReport(
        total: Int,
        passed: Int,
        excluded: List<String>,
        failures: List<FileFailure>,
    ): String = buildString {
        val maxErrorsPerFile = 10
        appendLine("## Gleam corpus parse report")
        appendLine()
        appendLine("| Total files | Passed | Failed | Excluded |")
        appendLine("|---|---|---|---|")
        appendLine("| $total | $passed | ${failures.size} | ${excluded.size} |")
        appendLine()
        if (failures.isEmpty()) {
            appendLine("All corpus files parsed without errors. :tada:")
        } else {
            for (failure in failures) {
                appendLine("### `${failure.relativePath}` - ${failure.errors.size} error(s)")
                appendLine()
                for (error in failure.errors.take(maxErrorsPerFile)) {
                    appendLine("- line ${error.line}, col ${error.column}: ${error.description}")
                    appendLine("  ```gleam")
                    appendLine("  ${error.lineText}")
                    appendLine("  ```")
                }
                if (failure.errors.size > maxErrorsPerFile) {
                    appendLine("- ... and ${failure.errors.size - maxErrorsPerFile} more")
                }
                appendLine()
            }
        }
        if (excluded.isNotEmpty()) {
            appendLine("<details><summary>Excluded files (${excluded.size})</summary>")
            appendLine()
            excluded.forEach { appendLine("- `$it`") }
            appendLine()
            appendLine("</details>")
        }
    }

    private fun writeReportIfRequested(report: String) {
        val reportPath = System.getProperty("gleam.corpus.report") ?: return
        val file = File(reportPath).absoluteFile
        file.parentFile?.mkdirs()
        file.writeText(report)
        println("Corpus report written to $file")
    }
}
