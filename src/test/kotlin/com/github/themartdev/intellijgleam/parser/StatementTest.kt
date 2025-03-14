package com.github.themartdev.intellijgleam.parser

class StatementTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/statement"

    fun testPanicConst() = assertParsedCorrectly()

    fun testPanicWithExpression() = assertParsedCorrectly()

    fun testTodoConst() = assertParsedCorrectly()

    fun testTodoWithExpression() = assertParsedCorrectly()
}