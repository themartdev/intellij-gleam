package com.github.themartdev.intellijgleam.lang.psi

import com.github.themartdev.intellijgleam.lang.GleamFileType
import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class GleamFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, GleamLanguage) {
    override fun getFileType(): FileType = GleamFileType

    override fun toString(): String = "Gleam File"
}