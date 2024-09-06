package com.github.themartdev.intellijgleam.parser

class RecordTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/record"

    fun testShorthand() = assertParsedCorrectly()
}