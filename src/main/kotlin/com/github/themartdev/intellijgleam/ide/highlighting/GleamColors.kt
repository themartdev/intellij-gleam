package com.github.themartdev.intellijgleam.ide.highlighting

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
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
    val FUNCTION_DECLARATION =
        createTextAttributesKey("GLEAM_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
    val STRING = createTextAttributesKey("GLEAM_STRING", DefaultLanguageHighlighterColors.STRING)
    val STRING_ESCAPE =
        createTextAttributesKey("GLEAM_STRING_ESCAPE", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE)

    val VALID_DIGIT = createTextAttributesKey("GLEAM_VALID_DIGIT", DefaultLanguageHighlighterColors.NUMBER)
    val INVALID_DIGIT = createTextAttributesKey("GLEAM_INVALID_DIGIT", HighlighterColors.BAD_CHARACTER)
    val VALID_BASE = createTextAttributesKey("GLEAM_NUMBER_BASE", DefaultLanguageHighlighterColors.NUMBER)
    val BASE_PREFIX = createTextAttributesKey("GLEAM_BASE_PREFIX", DefaultLanguageHighlighterColors.NUMBER)
    val INVALID_BASE = createTextAttributesKey("GLEAM_INVALID_BASE", HighlighterColors.BAD_CHARACTER)
    val DECORATOR = createTextAttributesKey("GLEAM_DECORATOR", DefaultLanguageHighlighterColors.METADATA)
    val TYPE_DECLARATION =
        createTextAttributesKey("GLEAM_TYPE_DECLARATION", DefaultLanguageHighlighterColors.CLASS_NAME)
    val TYPE_REFERENCE = createTextAttributesKey("GLEAM_TYPE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE)
    val LABEL = createTextAttributesKey("GLEAM_LABEL", DefaultLanguageHighlighterColors.LABEL)
}