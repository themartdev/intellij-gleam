package com.github.themartdev.intellijgleam.parser

class LiteralNumberTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/literal_number"

    fun testBasic() = assertParsedCorrectly()
    fun testBinary() = assertParsedCorrectly()
    fun testExponents() = assertParsedCorrectly()
    fun testHex() = assertParsedCorrectly()
    fun testOctal() = assertParsedCorrectly()

}