package com.github.themartdev.intellijgleam.ide.ui

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton

class ErlangPathSelect(project: Project) : TextFieldWithBrowseButton() {
    private val descriptor = FileChooserDescriptor(
        false,
        true,
        false,
        false,
        false,
        false
    )

    init {
        addBrowseFolderListener(
            "Erlang SDK",
            "Select the Erlang SDK path",
            project,
            descriptor
        )
    }
}