package com.github.themartdev.intellijgleam.parser

import com.github.themartdev.intellijgleam.lang.parser.GleamParserDefinition
import com.intellij.testFramework.ParsingTestCase

abstract class GleamParsingTestCase : ParsingTestCase(
    "",
    "gleam",
    true,
    GleamParserDefinition()
) {
    override fun getTestDataPath(): String = "src/test/testData/parser"

    override fun skipSpaces(): Boolean = false

    override fun includeRanges(): Boolean = true

    protected fun assertParsedCorrectly() {
        doTest(true, true)
    }
}
