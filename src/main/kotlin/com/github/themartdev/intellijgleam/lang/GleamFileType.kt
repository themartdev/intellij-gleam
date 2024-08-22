package com.github.themartdev.intellijgleam.lang

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class GleamFileType : LanguageFileType(GleamLanguage) {
    override fun getName(): String = "Prisma"

    override fun getDescription(): String = GleamBundle.message("gleam.fileType.description")

    override fun getDefaultExtension(): String = "prisma"

    override fun getIcon(): Icon = GleamIcons.GLEAM
}