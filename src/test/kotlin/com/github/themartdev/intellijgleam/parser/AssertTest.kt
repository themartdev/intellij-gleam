package com.github.themartdev.intellijgleam.parser

class AssertTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/assert"

    fun testSimple() = assertParsedCorrectly()

    fun testAs() = assertParsedCorrectly()
}