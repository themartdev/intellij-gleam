package com.github.themartdev.intellijgleam.parser

class DiscardTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/discard"

    fun testLet() = assertParsedCorrectly()

    fun testAnonymousParameter() = assertParsedCorrectly()

    fun testUse() = assertParsedCorrectly()
}