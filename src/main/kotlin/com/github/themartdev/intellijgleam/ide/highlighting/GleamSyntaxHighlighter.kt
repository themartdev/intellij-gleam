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
//    put(GleamTypes.STRING_LITERAL, GleamColors.STRING)
//    put(GleamTypes.STRING_ESCAPE_SEGMENT, GleamColors.STRING_ESCAPE)

    SyntaxHighlighterBase.fillMap(this, GLEAM_STRINGS, GleamColors.STRING)
    SyntaxHighlighterBase.fillMap(this, GLEAM_KEYWORDS, GleamColors.KEYWORD)
    SyntaxHighlighterBase.fillMap(this, GLEAM_BRACKETS, GleamColors.BRACKETS)
    SyntaxHighlighterBase.fillMap(this, GLEAM_BRACES, GleamColors.BRACES)
    SyntaxHighlighterBase.fillMap(this, GLEAM_PARENTHESES, GleamColors.PARENTHESES)
    SyntaxHighlighterBase.fillMap(this, GLEAM_ESCAPE, GleamColors.STRING_ESCAPE)
}

