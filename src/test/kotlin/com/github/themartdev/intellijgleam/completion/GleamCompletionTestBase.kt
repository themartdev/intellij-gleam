package com.github.themartdev.intellijgleam.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase

abstract class GleamCompletionTestBase : LightPlatformCodeInsightFixture4TestCase() {
    override fun getTestDataPath(): String = "src/test/testData/completion"

    protected fun validateCompletionContains(text: String, expected: List<String>) {
        myFixture.configureByText("main.gleam", text)
        val lookupElements = myFixture.completeBasic()
        assertSameLookupElements(expected, lookupElements)
    }

    protected fun completeBasic(source: String, expected: String) {
        myFixture.configureByText("main.gleam", source)
        myFixture.completeBasic()
        myFixture.checkResult(expected)
    }

    protected fun assertSameLookupElements(expected: List<String>, lookupElements: Array<LookupElement>?) {
        val actual = lookupElements?.map { it.lookupString } ?: emptyList()
        assertSameElements(actual, expected)
    }
}