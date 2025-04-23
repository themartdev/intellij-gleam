package com.github.themartdev.intellijgleam.parser

class EchoTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/echo"

    fun testSimple() = assertParsedCorrectly()

    fun testChain() = assertParsedCorrectly()
}
