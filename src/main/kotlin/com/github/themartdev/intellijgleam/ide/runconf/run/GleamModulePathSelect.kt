package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.ui.TextFieldWithBrowseButton

class GleamModulePathSelect(val project: Project? = null) : TextFieldWithBrowseButton() {
    private val fileChooserDescriptor =
        FileChooserDescriptor(true, false, false, false, false, false)

    init {

        if (project != null) {
            val projectRoot = ProjectRootManager.getInstance(project).contentRoots
            fileChooserDescriptor.withRoots(*projectRoot)
        }

        addBrowseFolderListener(
            project,
            fileChooserDescriptor
                .withTitle("Select the Gleam Module Path")
                .withDescription("Select the gleam module path")
        )
    }
}

