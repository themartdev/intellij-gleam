package com.github.themartdev.intellijgleam.parser

class LiteralBoolTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/literal_bool"

    fun testBasic() = assertParsedCorrectly()
}