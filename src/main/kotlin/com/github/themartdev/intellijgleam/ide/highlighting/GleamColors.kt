package com.github.themartdev.intellijgleam.ide.highlighting

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object GleamColors {
    val FUNCTION_COMMENT =
        createTextAttributesKey("GLEAM_FUNCTION_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT)
    val MODULE_COMMENT =
        createTextAttributesKey("GLEAM_MODULE_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT)
    val LINE_COMMENT = createTextAttributesKey("GLEAM_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val KEYWORD = createTextAttributesKey("GLEAM_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val BRACKETS = createTextAttributesKey("GLEAM_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    val PARENTHESES = createTextAttributesKey("GLEAM_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
    val BRACES = createTextAttributesKey("GLEAM_BRACES", DefaultLanguageHighlighterColors.BRACES)
}