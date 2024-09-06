package com.github.themartdev.intellijgleam.ide.ui

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.TextFieldWithBrowseButton

class GleamPathSelect : TextFieldWithBrowseButton() {
    init {
        addBrowseFolderListener(
            "Select the Gleam Binary",
            "Select the Gleam binary",
            null,
            GleamBinaryFileChooserDescriptor
        )
    }
}

object GleamBinaryFileChooserDescriptor : FileChooserDescriptor(true, false, false, false, false, false)
