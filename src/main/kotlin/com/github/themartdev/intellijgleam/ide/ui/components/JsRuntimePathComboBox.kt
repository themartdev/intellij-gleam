package com.github.themartdev.intellijgleam.ide.ui.components

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.github.themartdev.intellijgleam.ide.common.jsRuntimeVersion
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project

class JsRuntimePathComboBox(project: Project?) : AbstractExecutablePathComboBox(project) {
    override fun computeVersionInline(path: String): String? = jsRuntimeVersion(path)

    override fun showBrowseDialog() {
        val fileChooserDescriptor = FileChooserDescriptorFactory.createSingleFileDescriptor()
        fileChooserDescriptor.title = "Select JavaScript Runtime (node, deno, or bun)"
        val selectedFiles = FileChooser.chooseFiles(fileChooserDescriptor, project, null)
        if (selectedFiles.isNotEmpty()) {
            selectedPath = FsUtils.sanitizeUserPath(selectedFiles[0].path)
        }
    }
}
