package com.github.themartdev.intellijgleam

import com.github.themartdev.intellijgleam.lang.parser.GleamParserDefinition
import com.intellij.testFramework.ParsingTestCase

class GleamParserTest : ParsingTestCase(
    "parser",
    "gleam",
    true,
    GleamParserDefinition()
) {
    override fun getTestDataPath(): String = "src/test/testData"

    fun testSimple() = doTest(true, true)
//
//    fun testSanityCheck() {
//        TestCase.assertEquals(1, 1)
//    }
}