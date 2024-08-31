package com.github.themartdev.intellijgleam.lang.psi

import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.github.themartdev.intellijgleam.lang.psi.GleamTypes.*
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet.create

class GleamTokenType(debugName: String) : IElementType(debugName, GleamLanguage)

val GLEAM_KEYWORDS = create(
    AS, ASSERT, AUTO, CASE, CONST, DELEGATE, DERIVE, ECHO, ELSE, EXTERNAL, FN, IF, IMPLEMENT, IMPORT, LET, MACRO,
    OPAQUE, PANIC, PUB, TEST, TODO, TRY, TYPE, USE
)


val GLEAM_BRACES = create(LBRACE, RBRACE)
val GLEAM_PARENTHESES = create(LPAREN, RPAREN)
val GLEAM_BRACKETS = create(LBRACK, RBRACK)

val GLEAM_COMMENTS = create(MODULE_COMMENT, FUNCTION_COMMENT, LINE_COMMENT)

//val GLEAM_STRINGS = create(OPEN_QUOTE, CLOSE_QUOTE, REGULAR_STRING_PART)
val GLEAM_STRINGS = create(OPEN_QUOTE, CLOSE_QUOTE, REGULAR_STRING_PART)
val GLEAM_ESCAPE = create(ESCAPE, ESCAPE_CHAR, UNICODE_ESCAPE_CHAR, UNICODE_CODEPOINT)

