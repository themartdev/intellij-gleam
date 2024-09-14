package com.github.themartdev.intellijgleam.parser

class LiteralStringTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/literal_string"

    fun testBasic() = assertParsedCorrectly()
    fun testEscape() = assertParsedCorrectly()
}