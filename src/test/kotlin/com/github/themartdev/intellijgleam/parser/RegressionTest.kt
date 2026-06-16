package com.github.themartdev.intellijgleam.parser

class RegressionTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/regression"

    fun test35constructorExpression() = assertParsedCorrectly()

    fun test52misc() = assertParsedCorrectly()

    // A byte order mark (U+FEFF) mid-source is treated as whitespace, like the Gleam compiler.
    fun testByteOrderMark() = assertParsedCorrectly()
}