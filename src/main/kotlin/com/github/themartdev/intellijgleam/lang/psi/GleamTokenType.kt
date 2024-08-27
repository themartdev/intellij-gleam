package com.github.themartdev.intellijgleam.lang.psi

import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.github.themartdev.intellijgleam.lang.psi.GleamElementTypes.*
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet.create

class GleamTokenType(debugName: String) : IElementType(debugName, GleamLanguage)

val GLEAM_KEYWORDS = create(FN, AS, IMPORT)
val GLEAM_BRACES = create(LBRACE, RBRACE)
val GLEAM_PARENTHESES = create(LPAREN, RPAREN)
val GLEAM_BRACKETS = create(LBRACK, RBRACK)

val GLEAM_COMMENTS = create(MODULE_COMMENT, FUNCTION_COMMENT, LINE_COMMENT)
val GLEAM_STRINGS = create(STRING_LITERAL)
