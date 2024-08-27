package com.github.themartdev.intellijgleam.lang

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object GleamFileType : LanguageFileType(GleamLanguage) {
    override fun getName(): String = "Gleam"

    override fun getDescription(): String = GleamBundle.message("gleam.fileType.description")

    override fun getDefaultExtension(): String = "gleam"

    override fun getIcon(): Icon = GleamIcons.GLEAM
}