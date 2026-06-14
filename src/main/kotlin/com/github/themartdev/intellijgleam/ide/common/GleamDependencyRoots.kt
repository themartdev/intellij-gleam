package com.github.themartdev.intellijgleam.ide.common

import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.AdditionalLibraryRootsListener
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileContentChangeEvent
import com.intellij.openapi.vfs.newvfs.events.VFileEvent

/**
 * Single source of truth for the set of Gleam dependency source roots
 * (`<project>/build/packages/<dep>/src`) and the keeper of its freshness.
 *
 * [GleamLibraryRootsProvider] reads [roots] when the platform asks which library roots
 * exist. This service additionally watches the VFS for *structural* changes under
 * `build/packages` (a dependency being added, removed or renamed by `gleam deps download`
 * / `gleam build`) and notifies the platform so the External Libraries node and indexes
 * refresh without an IDE restart. In-file edits are already covered by the provider's
 * `getRootsToWatch`, so content-change events are deliberately ignored here.
 */
@Service(Service.Level.PROJECT)
class GleamDependencyRoots(private val project: Project) : Disposable {
    private val lock = Any()

    /** The root set the platform was last told about; the baseline for diffing changes. */
    private var known: List<VirtualFile> = emptyList()

    init {
        project.messageBus.connect(this).subscribe(
            VirtualFileManager.VFS_CHANGES,
            object : BulkFileListener {
                override fun after(events: List<VFileEvent>) = onVfsChanges(events)
            },
        )
    }

    /** Current dependency source roots, recomputed live from the VFS. */
    fun roots(): List<VirtualFile> = synchronized(lock) {
        computeRoots().also { known = it }
    }

    private fun onVfsChanges(events: List<VFileEvent>) {
        val packagesPath = packagesPath() ?: return
        val touchesPackages = events.any { event ->
            event !is VFileContentChangeEvent && isUnderPackages(event.path, packagesPath)
        }
        if (touchesPackages) refresh()
    }

    private fun refresh() {
        val old: List<VirtualFile>
        val new: List<VirtualFile>
        synchronized(lock) {
            old = known
            new = computeRoots()
            if (old == new) return
            known = new
        }
        // Fire outside the VFS event dispatch, in a fresh top-level write action.
        ApplicationManager.getApplication().invokeLater({
            if (project.isDisposed) return@invokeLater
            WriteAction.run<RuntimeException> {
                AdditionalLibraryRootsListener.fireAdditionalLibraryChanged(
                    project, LIBRARY_NAME, old, new, EXTERNAL_ID,
                )
            }
        }, project.disposed)
    }

    private fun computeRoots(): List<VirtualFile> = gleamPackageSrcRoots(packagesDir())

    private fun packagesDir(): VirtualFile? =
        packagesPath()?.let { LocalFileSystem.getInstance().findFileByPath(it) }

    private fun packagesPath(): String? = project.basePath?.let { "$it/build/packages" }

    private fun isUnderPackages(path: String, packagesPath: String): Boolean =
        path == packagesPath || path.startsWith("$packagesPath/")

    override fun dispose() = Unit

    companion object {
        const val LIBRARY_NAME = "Gleam Dependencies"
        private const val EXTERNAL_ID = "gleam.dependencies"

        fun getInstance(project: Project): GleamDependencyRoots = project.service()
    }
}

/**
 * The `src` directory of every package under [packagesDir] that has one, sorted by path so
 * the resulting [SyntheticLibrary] identity is stable. Packages without a `src` directory and
 * non-directory entries (e.g. `packages.toml`) are skipped. Returns empty when [packagesDir]
 * is `null`, i.e. dependencies have not been fetched yet.
 */
internal fun gleamPackageSrcRoots(packagesDir: VirtualFile?): List<VirtualFile> =
    packagesDir?.children
        ?.mapNotNull { pkg -> pkg.findChild("src")?.takeIf(VirtualFile::isDirectory) }
        ?.sortedBy { it.path }
        ?: emptyList()
