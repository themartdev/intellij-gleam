package com.github.themartdev.intellijgleam.ide.ui.components

import com.github.themartdev.intellijgleam.ide.common.captureGleam
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import kotlin.io.path.Path

class GleamPathComboBox(project: Project) : AbstractExecutablePathComboBox(project) {
    override fun computeVersionInline(path: String): String? {
        val exe = captureGleam(Path(path))
        return exe?.version
    }

    override fun showBrowseDialog() {
        val desc = FileChooserDescriptorFactory.createSingleFileOrExecutableAppDescriptor().apply {
            title = "Select Gleam Binary"
        }
        val files = FileChooser.chooseFiles(desc, project, null)
        if (files.isNotEmpty()) {
            val p = files.first().path
            addItem(p)
            selectedItem = p
        }
    }
}
