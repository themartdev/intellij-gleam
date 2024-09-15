package com.github.themartdev.intellijgleam.formatting

import com.github.themartdev.intellijgleam.lang.GleamFileType
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test

class GleamFormattingTest : LightPlatformCodeInsightFixture4TestCase() {
    override fun getTestDataPath() = "src/test/testData/formatting"

    @Test
    fun testTypeDefinitionIndentation() {
        val before = """
            type MyType {<caret>
            }
        """.trimIndent()

        val after = """
            type MyType {
              <caret>
            }
        """.trimIndent()

        myFixture.configureByText(GleamFileType, before)
        myFixture.type('\n')
        myFixture.checkResult(after)
    }
}