package com.github.themartdev.intellijgleam.parser

class SmokeTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/smoke"

    fun testSmoke1() = assertParsedCorrectly()
}