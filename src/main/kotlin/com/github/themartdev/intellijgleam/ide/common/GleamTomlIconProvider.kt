package com.github.themartdev.intellijgleam.ide.common

import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.ide.FileIconProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

/**
 * Gives `gleam.toml` the Gleam icon in the project view and elsewhere, so a Gleam package is
 * recognizable at a glance. Works whether or not the TOML language plugin is installed, since it
 * keys off the file name rather than any PSI.
 */
class GleamTomlIconProvider : FileIconProvider {
    override fun getIcon(file: VirtualFile, flags: Int, project: Project?): Icon? =
        if (file.name == GleamProject.MANIFEST_NAME) GleamIcons.GLEAM else null
}
