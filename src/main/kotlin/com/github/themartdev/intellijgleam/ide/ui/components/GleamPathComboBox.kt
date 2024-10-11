package com.github.themartdev.intellijgleam.ide.ui.components

import com.github.themartdev.intellijgleam.ide.common.GleamExecutable
import com.github.themartdev.intellijgleam.ide.common.captureGleam
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import kotlin.io.path.Path

class GleamPathComboBox(project: Project) : AbstractPathComboBox(project) {
    override fun computeVersionInline(item: PathItem.Value) {
        val executable = captureGleam(Path(item.path))
        item.version = executable?.version?.toString()
    }

    override fun showBrowseDialog() {
        val fileChooserDescriptor = FileChooserDescriptorFactory.createSingleFileOrExecutableAppDescriptor()
        fileChooserDescriptor.title = "Select Gleam Binary"
        val selectedFiles = FileChooser.chooseFiles(fileChooserDescriptor, project, null)
        if (selectedFiles.isNotEmpty()) {
            val path = selectedFiles[0].path
            val customItem = PathItem.Value(path, "Custom")
            addItem(customItem)
            selectedItem = customItem
        }
    }
}

fun PathItem.Value.Companion.fromExecutable(executable: GleamExecutable): PathItem.Value {
    val versionString = if (executable.valid) executable.version?.toString() ?: "Unknown" else "Invalid"
    return PathItem.Value(executable.path, versionString)
}
