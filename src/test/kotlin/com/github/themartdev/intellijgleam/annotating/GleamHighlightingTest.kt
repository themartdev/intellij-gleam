package com.github.themartdev.intellijgleam.annotating

import org.junit.Test

class GleamHighlightingTest : GleamHighlightingTestBase() {
    override fun getTestDataPath() = "src/test/testData/highlighting"

    @Test
    fun testFunctionCall() = testHighlighting("function_call.gleam")
}