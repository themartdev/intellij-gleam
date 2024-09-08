package com.github.themartdev.intellijgleam.parser

class FunctionTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/function"

    fun testAnonymous() = assertParsedCorrectly()

    fun testFnArgument() = assertParsedCorrectly()

    fun testFunctionCapture() = assertParsedCorrectly()

    fun testGeneric() = assertParsedCorrectly()

    fun testSimpleParams() = assertParsedCorrectly()

    fun testVoid() = assertParsedCorrectly()

    fun testLabeledArguments() = assertParsedCorrectly()

    fun testPipelines() = assertParsedCorrectly()
}