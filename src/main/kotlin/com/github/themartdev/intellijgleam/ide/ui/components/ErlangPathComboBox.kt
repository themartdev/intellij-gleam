package com.github.themartdev.intellijgleam.ide.ui.components

import com.github.themartdev.intellijgleam.ide.common.ErlangSdk
import com.github.themartdev.intellijgleam.ide.common.captureGleam
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import kotlin.io.path.Path

class ErlangPathComboBox(val project: Project) : AbstractPathComboBox(project) {
    override fun computeVersionInline(item: PathItem.Value) {
        val executable = captureGleam(Path(item.path))
        item.version = executable?.version?.toString()
    }

    override fun showBrowseDialog() {
        val fileChooserDescriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor()
        fileChooserDescriptor.title = "Select Erlang SDK"
        val selectedFiles = FileChooser.chooseFiles(fileChooserDescriptor, project, null)
        if (selectedFiles.isNotEmpty()) {
            val path = selectedFiles[0].path
            val customItem = PathItem.Value(path, "unknown")
            addItem(customItem)
            selectedItem = customItem
        }
    }
}

fun PathItem.Value.Companion.fromErlangSdk(sdk: ErlangSdk): PathItem.Value {
    val versionString = if (sdk.valid) sdk.version?.toString() ?: "Unknown" else "Invalid"
    return PathItem.Value(sdk.path, versionString)
}
