package com.github.themartdev.intellijgleam.ide.editor

import com.github.themartdev.intellijgleam.lang.psi.GLEAM_STRINGS
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class GleamQuoteHandler : SimpleTokenSetQuoteHandler(GLEAM_STRINGS)
