package com.github.themartdev.intellijgleam.parser

/**
 * Regression tests for valid Gleam syntax that the grammar historically failed to parse.
 * Each fixture was verified against the compiler's parser (compiler-core/src/parse.rs).
 */
class DormantSyntaxTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/dormantSyntax"

    fun testEchoMessage() = assertParsedCorrectly()
    fun testNegativeIntPattern() = assertParsedCorrectly()
    fun testStringPrefixAlias() = assertParsedCorrectly()
    fun testUseAnnotations() = assertParsedCorrectly()
    fun testConstConcatenation() = assertParsedCorrectly()
    fun testConstRecordUpdate() = assertParsedCorrectly()
    fun testConstTodo() = assertParsedCorrectly()
    fun testImportDiscardAlias() = assertParsedCorrectly()
}