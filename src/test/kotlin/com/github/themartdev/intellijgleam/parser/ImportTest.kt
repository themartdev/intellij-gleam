package com.github.themartdev.intellijgleam.parser

class ImportTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/import"

    fun testQualified() = assertParsedCorrectly()

    fun testQualifiedAlias() = assertParsedCorrectly()

    fun testUnqualified() = assertParsedCorrectly()

    fun testUnqualifiedAlias() = assertParsedCorrectly()

    fun testUnqualifiedType() = assertParsedCorrectly()

    fun testUnqualifiedTypeAlias() = assertParsedCorrectly()

    fun testAll() = assertParsedCorrectly()
}