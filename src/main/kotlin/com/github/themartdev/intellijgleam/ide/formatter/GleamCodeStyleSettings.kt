package com.github.themartdev.intellijgleam.ide.formatter

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class GleamCodeStyleSettings(container: CodeStyleSettings) :
    CustomCodeStyleSettings(GleamCodeStyleSettings::class.java.simpleName, container) {
}