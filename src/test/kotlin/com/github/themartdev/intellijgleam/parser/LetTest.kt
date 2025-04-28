package com.github.themartdev.intellijgleam.parser

class LetTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/let"

    fun testSimple() = assertParsedCorrectly()

    fun testAssert() = assertParsedCorrectly()
}