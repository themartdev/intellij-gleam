package com.github.themartdev.intellijgleam.parser

class ConstTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/const"

    fun testSanity() = assertParsedCorrectly()

    fun testModuleRefs() = assertParsedCorrectly()
}
