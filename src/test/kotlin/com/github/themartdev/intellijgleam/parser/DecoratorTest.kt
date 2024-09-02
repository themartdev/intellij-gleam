package com.github.themartdev.intellijgleam.parser

class DecoratorTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/decorator"

    fun testDeprecated() = assertParsedCorrectly()

    fun testExternalFallback() = assertParsedCorrectly()

    fun testExternalDoubleNoFallback() = assertParsedCorrectly()

    fun testExternalNoFallback() = assertParsedCorrectly()

    // Unknown decorator should not be an error
    fun testUnknown() = assertParsedCorrectly()

    fun testWithoutFunction() = assertParsedWithErrors()
}