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
    put(GleamElementTypes.LINE_COMMENT, GleamColors.LINE_COMMENT)
    put(GleamElementTypes.MODULE_COMMENT, GleamColors.MODULE_COMMENT)
    put(GleamElementTypes.FUNCTION_COMMENT, GleamColors.FUNCTION_COMMENT)

    SyntaxHighlighterBase.fillMap(this, GLEAM_KEYWORDS, GleamColors.KEYWORD)
    SyntaxHighlighterBase.fillMap(this, GLEAM_BRACKETS, GleamColors.BRACKETS)
    SyntaxHighlighterBase.fillMap(this, GLEAM_BRACES, GleamColors.BRACES)
    SyntaxHighlighterBase.fillMap(this, GLEAM_PARENTHESES, GleamColors.PARENTHESES)
}

