package com.github.themartdev.intellijgleam.lexer

import com.github.themartdev.intellijgleam.lang.lexer.GleamLexer
import org.junit.Test

class GleamLexerTest {
    @Test
    fun test() {
        val lexer = GleamLexer()
        lexer.start("""
        1123_234.123e-12
        """.trimIndent())
        while (lexer.tokenType != null) {
            println("${lexer.tokenType}: ${lexer.tokenText}")
            lexer.advance()
        }

    }
}