package com.github.themartdev.intellijgleam.parser

class Tuple : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/tuple"

    fun testSimple() = assertParsedCorrectly()
}