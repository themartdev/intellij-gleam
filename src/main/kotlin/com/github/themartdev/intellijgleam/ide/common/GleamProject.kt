package com.github.themartdev.intellijgleam.ide.common

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import java.io.File

/**
 * Single source of truth for "where is the Gleam package" — anchored on its manifest,
 * `gleam.toml`. The manifest's presence is what makes a directory a Gleam project, so this is
 * also how the plugin decides whether to activate at all (see [isGleamProject]).
 *
 * Most helpers are [File]/path-based so the cheap boolean checks don't touch the VFS (avoiding
 * read-action / threading concerns); the VFS is used only where a [VirtualFile] is required.
 */
object GleamProject {
    const val MANIFEST_NAME = "gleam.toml"

    /**
     * The package manifest, or `null` if this isn't a Gleam project. Looks for `gleam.toml` at the
     * project root first; failing that, does a *shallow* scan of the root's immediate child
     * directories (handles opening the parent of a single package). No deep recursion.
     */
    fun manifestFile(project: Project): File? {
        val base = project.basePath ?: return null
        val atRoot = File(base, MANIFEST_NAME)
        if (atRoot.isFile) return atRoot
        return File(base).listFiles()
            ?.filter { it.isDirectory }
            ?.sortedBy { it.name }
            ?.map { File(it, MANIFEST_NAME) }
            ?.firstOrNull { it.isFile }
    }

    /** Whether [project] contains a `gleam.toml`, i.e. is a real Gleam package. */
    fun isGleamProject(project: Project): Boolean = manifestFile(project) != null

    /**
     * The Gleam package root: the directory containing `gleam.toml`. Falls back to
     * [Project.getBasePath] when no manifest is found, so callers never regress to `null` where
     * they previously had the base path.
     */
    fun rootPath(project: Project): String? = manifestFile(project)?.parent ?: project.basePath

    /** The package root as a [VirtualFile], for callers that need to walk or watch the VFS. */
    fun rootDir(project: Project): VirtualFile? =
        rootPath(project)?.let { LocalFileSystem.getInstance().findFileByPath(it) }

    /** The package's `src` directory (`<root>/src`). */
    fun getSrcDir(project: Project): String? = rootPath(project)?.let { "$it/src" }

    /**
     * The nearest enclosing `gleam.toml` for [file], walking up the directory tree. Used for
     * per-file resolution so a file in a nested package is anchored on *that* package rather than
     * the IDE root. Returns `null` if no manifest is found at or above [file].
     */
    fun manifestFor(file: VirtualFile): File? {
        var dir: File? = (if (file.isDirectory) file else file.parent)?.let { File(it.path) }
        while (dir != null) {
            val manifest = File(dir, MANIFEST_NAME)
            if (manifest.isFile) return manifest
            dir = dir.parentFile
        }
        return null
    }
}
