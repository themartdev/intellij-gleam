package com.github.themartdev.intellijgleam.ide.formatter

import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.intellij.psi.codeStyle.CodeStyleSettings

class GleamFormatBlockContext(settings: CodeStyleSettings) {
    val commonSettings = settings.getCommonSettings(GleamLanguage)
}
