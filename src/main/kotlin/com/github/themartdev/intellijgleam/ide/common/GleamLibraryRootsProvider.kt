package com.github.themartdev.intellijgleam.ide.common

import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.AdditionalLibraryRootsProvider
import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

/**
 * Exposes the source of every fetched Gleam dependency as a read-only library root.
 *
 * Gleam unpacks each dependency into `<project>/build/packages/<dep>/src/`, including
 * the standard library (`gleam_stdlib`), the test runner (`gleeunit`), and every hex
 * package. Registering those `src` directories as library roots makes the files indexed,
 * searchable and fully highlighted, and lets `gleam lsp` Go-to-Definition land in a
 * first-class buffer instead of a degraded "non-project file".
 *
 * The root set itself is owned by [GleamDependencyRoots], which also keeps it fresh as
 * dependencies come and go.
 */
class GleamLibraryRootsProvider : AdditionalLibraryRootsProvider() {
    override fun getAdditionalProjectLibraries(project: Project): Collection<SyntheticLibrary> {
        val srcRoots = GleamDependencyRoots.getInstance(project).roots()
        return if (srcRoots.isEmpty()) emptyList() else listOf(GleamSyntheticLibrary(srcRoots))
    }

    override fun getRootsToWatch(project: Project): Collection<VirtualFile> =
        listOfNotNull(project.basePath?.let {
            LocalFileSystem.getInstance().findFileByPath("$it/build/packages")
        })
}

internal class GleamSyntheticLibrary(
    private val roots: List<VirtualFile>,
) : SyntheticLibrary(), ItemPresentation {
    override fun getSourceRoots(): Collection<VirtualFile> = roots

    override fun getPresentableText(): String = GleamDependencyRoots.LIBRARY_NAME

    override fun getLocationString(): String? = null

    override fun getIcon(unused: Boolean): Icon = GleamIcons.GLEAM

    // equals/hashCode are load-bearing: the platform diffs library instances by equality
    // to decide whether to re-index. Identity must follow the set of roots.
    override fun equals(other: Any?): Boolean = other is GleamSyntheticLibrary && other.roots == roots

    override fun hashCode(): Int = roots.hashCode()
}
