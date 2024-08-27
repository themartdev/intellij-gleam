package com.github.themartdev.intellijgleam.lang.lexer

import com.github.themartdev.intellijgleam.lang.parser._GleamLexer
import com.intellij.lexer.FlexAdapter

class GleamLexer : FlexAdapter(_GleamLexer(null))
