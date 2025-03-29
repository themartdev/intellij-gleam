package com.github.themartdev.intellijgleam.parser

class TypeTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/type"

    fun testAlias() = assertParsedCorrectly()

    fun testCustomType() = assertParsedCorrectly()

    fun testGenericAlias() = assertParsedCorrectly()

    fun testGenericCustom() = assertParsedCorrectly()

    fun testGenericUsage() = assertParsedCorrectly()

    fun testFunctionChain() = assertParsedCorrectly()

    fun testFunctionReturnTuple() = assertParsedCorrectly()
}