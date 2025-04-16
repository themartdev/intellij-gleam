package com.github.themartdev.intellijgleam.parser

class TupleTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/tuple"

    fun testSimple() = assertParsedCorrectly()

    fun testChainAccess() = assertParsedCorrectly()
}