package com.github.themartdev.intellijgleam.lexer

import com.github.themartdev.intellijgleam.lang.lexer.GleamLexer
import com.jetbrains.rd.util.string.PrettyPrinter
import com.jetbrains.rd.util.string.println
import org.junit.Test

class GleamLexerTest {
    @Test
    fun test() {
        val lexer = GleamLexer()
        lexer.start("test")
    }
}