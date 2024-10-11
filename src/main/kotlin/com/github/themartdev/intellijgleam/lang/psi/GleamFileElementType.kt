package com.github.themartdev.intellijgleam.lang.psi

import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.github.themartdev.intellijgleam.lang.psi.impl.GleamFileStub
import com.intellij.psi.tree.IStubFileElementType

private const val STUB_VERSION = 1

object GleamFileElementType : IStubFileElementType<GleamFileStub>("GLEAM_FILE", GleamLanguage) {
    override fun getExternalId(): String = "${language.id}.file"

    override fun getStubVersion(): Int = super.stubVersion + STUB_VERSION
}
