package com.github.themartdev.intellijgleam.ide.highlighting

import com.github.themartdev.intellijgleam.lang.lexer.GleamLexer
import com.github.themartdev.intellijgleam.lang.psi.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class GleamSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return GleamLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return pack(ATTRIBUTES[tokenType])
    }
}

val ATTRIBUTES = buildMap<IElementType, TextAttributesKey> {
    // Can only reference lexer tokens. IElementType items that come from grammar rules don't do anything here
    put(GleamTypes.LINE_COMMENT, GleamColors.LINE_COMMENT)
    put(GleamTypes.MODULE_COMMENT, GleamColors.MODULE_COMMENT)
    put(GleamTypes.FUNCTION_COMMENT, GleamColors.FUNCTION_COMMENT)
    put(GleamTypes.FUNCTION_NAME_DEFINITION, GleamColors.FUNCTION_DECLARATION)
    put(GleamTypes.BASE_NUMBER_PREFIX, GleamColors.BASE_PREFIX)
    put(GleamTypes.EXPONENT_MARK, GleamColors.VALID_DIGIT)
    put(GleamTypes.BOOLEAN_LITERAL, GleamColors.KEYWORD)
    put(GleamTypes.DOT, GleamColors.DOT)
    put(GleamTypes.COMMA, GleamColors.COMMA)
    put(GleamTypes.UP_IDENTIFIER, GleamColors.TYPE_REFERENCE)

    SyntaxHighlighterBase.fillMap(this, GLEAM_STRINGS, GleamColors.STRING)
    SyntaxHighlighterBase.fillMap(this, GLEAM_KEYWORDS, GleamColors.KEYWORD)
    SyntaxHighlighterBase.fillMap(this, GLEAM_BRACKETS, GleamColors.BRACKETS)
    SyntaxHighlighterBase.fillMap(this, GLEAM_BRACES, GleamColors.BRACES)
    SyntaxHighlighterBase.fillMap(this, GLEAM_PARENTHESES, GleamColors.PARENTHESES)
    SyntaxHighlighterBase.fillMap(this, GLEAM_ESCAPE, GleamColors.STRING_ESCAPE)
    SyntaxHighlighterBase.fillMap(this, GLEAM_VALID_DIGITS, GleamColors.VALID_DIGIT)
    SyntaxHighlighterBase.fillMap(this, GLEAM_INVALID_DIGITS, GleamColors.INVALID_DIGIT)
    SyntaxHighlighterBase.fillMap(this, GLEAM_VALID_BASE, GleamColors.VALID_BASE)
    SyntaxHighlighterBase.fillMap(this, GLEAM_UNKNOWN_BASE, GleamColors.INVALID_BASE)
    SyntaxHighlighterBase.fillMap(this, GLEAM_ANNOTATIONS, GleamColors.DECORATOR)
    SyntaxHighlighterBase.fillMap(this, GLEAM_OPERATOR, GleamColors.OPERATOR)
}
