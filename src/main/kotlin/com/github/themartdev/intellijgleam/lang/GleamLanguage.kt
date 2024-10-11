package com.github.themartdev.intellijgleam.lang

import com.intellij.lang.Language

@Suppress("JavaIoSerializableObjectMustHaveReadResolve")
object GleamLanguage : Language("Gleam") {
    override fun getDisplayName(): String = "Gleam"
}
