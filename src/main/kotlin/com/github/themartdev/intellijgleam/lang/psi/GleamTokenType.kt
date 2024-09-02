package com.github.themartdev.intellijgleam.lang.psi

import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.github.themartdev.intellijgleam.lang.psi.GleamTypes.*
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet.create

class GleamTokenType(debugName: String) : IElementType(debugName, GleamLanguage)

val GLEAM_KEYWORDS = create(
    AS, ASSERT, CASE, CONST, FN, IF, IMPORT, LET,
    OPAQUE, PANIC, PUB, TEST, TODO, TYPE, USE
)

val TOP_LEVEL_KEYWORDS = create(
    IMPORT, TYPE, CONST, FN, PUB, OPAQUE
)


val GLEAM_BRACES = create(LBRACE, RBRACE)
val GLEAM_PARENTHESES = create(LPAREN, RPAREN)
val GLEAM_BRACKETS = create(LBRACK, RBRACK)

val GLEAM_COMMENTS = create(MODULE_COMMENT, FUNCTION_COMMENT, LINE_COMMENT)

val GLEAM_STRINGS = create(OPEN_QUOTE, CLOSE_QUOTE, REGULAR_STRING_PART)
val GLEAM_ESCAPE = create(ESCAPE, ESCAPE_CHAR, UNICODE_ESCAPE_CHAR, UNICODE_CODEPOINT)

val GLEAM_VALID_DIGITS = create(VALID_DECIMAL_DIGIT, VALID_BINARY_DIGIT, VALID_OCTAL_DIGIT, VALID_HEX_DIGIT)
val GLEAM_INVALID_DIGITS = create(
    INVALID_DECIMAL_DIGIT,
    INVALID_BINARY_DIGIT,
    INVALID_OCTAL_DIGIT,
    INVALID_HEX_DIGIT,
    INVALID_UNKNOWN_BASE_DIGIT
)
val GLEAM_VALID_BASE = create(BINARY_NUMBER_BASE, OCTAL_NUMBER_BASE, HEX_NUMBER_BASE)
val GLEAM_UNKNOWN_BASE = create(UNKNOWN_NUMBER_BASE)

val GLEAM_DECORATORS = create(DECORATOR_MARK, DECORATOR_NAME)

