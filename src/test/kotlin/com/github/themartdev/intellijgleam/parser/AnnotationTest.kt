package com.github.themartdev.intellijgleam.parser

class AnnotationTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/annotation"

    fun testDeprecated() = assertParsedCorrectly()

    fun testExternalFallback() = assertParsedCorrectly()

    fun testExternalDoubleNoFallback() = assertParsedCorrectly()

    fun testExternalNoFallback() = assertParsedCorrectly()

    // Unknown decorator should not be an error
    fun testUnknown() = assertParsedCorrectly()

    fun testTarget() = assertParsedCorrectly()

    // Should be parsed as an "otherAnnotation"
    fun testInternal() = assertParsedCorrectly()

    fun testUnknownNoParen() = assertParsedCorrectly()

    fun testEveryDeclaration() = assertParsedCorrectly()
}