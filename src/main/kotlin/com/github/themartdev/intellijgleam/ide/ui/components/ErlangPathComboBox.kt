package com.github.themartdev.intellijgleam.ide.ui.components

import com.github.themartdev.intellijgleam.ide.common.captureErlang
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import kotlin.io.path.Path

class ErlangPathComboBox(project: Project) : AbstractExecutablePathComboBox(project) {
    override fun computeVersionInline(path: String): String? {
        val executable = captureErlang(Path(path))
        return executable?.version
    }

    override fun showBrowseDialog() {
        val fileChooserDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor()
        fileChooserDescriptor.title = "Select Erlang SDK"
        val selectedFiles = FileChooser.chooseFiles(fileChooserDescriptor, project, null)
        if (selectedFiles.isNotEmpty()) {
            val path = selectedFiles[0].path
            selectedPath = path
        }
    }
}
