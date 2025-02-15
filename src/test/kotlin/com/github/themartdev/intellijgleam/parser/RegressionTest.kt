package com.github.themartdev.intellijgleam.parser

class RegressionTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/regression"

    fun test35constructorExpression() = assertParsedCorrectly()
}