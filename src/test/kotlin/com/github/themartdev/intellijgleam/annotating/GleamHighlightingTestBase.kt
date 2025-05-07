package com.github.themartdev.intellijgleam.annotating

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase

abstract class GleamHighlightingTestBase : LightPlatformCodeInsightFixture4TestCase() {
    override fun getTestDataPath() = "src/test/testData/highlighting"

    protected fun testHighlighting(fileName: String) {
        myFixture.configureByFile(fileName)
        myFixture.checkHighlighting(false, true, false, true)
    }
}