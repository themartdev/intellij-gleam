package com.github.themartdev.intellijgleam.parser

class UseTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/use"

    fun testSimple() = assertParsedCorrectly()

    fun testDiscardVariable() = assertParsedCorrectly()
}