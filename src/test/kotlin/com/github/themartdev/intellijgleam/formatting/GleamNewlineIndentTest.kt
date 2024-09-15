package com.github.themartdev.intellijgleam.formatting

import com.github.themartdev.intellijgleam.lang.GleamFileType
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test

class GleamNewlineIndentTest : LightPlatformCodeInsightFixture4TestCase() {
    override fun getTestDataPath() = "src/test/testData/formatting"

    @Test
    fun customTypeDefinition() {
        val before = """
            type MyType {<caret>}
        """.trimIndent()

        val after = """
            type MyType {
              <caret>
            }
        """.trimIndent()
        testNewlineIndentation(before, after)
    }

    @Test
    fun function() {
        val before = """
            fn my_func() {<caret>}
        """.trimIndent()

        val after = """
            fn my_func() {
              <caret>
            }
        """.trimIndent()
        testNewlineIndentation(before, after)
    }

    @Test
    fun caseExpression() {
        val before = """
            fn my_func() {
                case x {<caret>}
            }
        """.trimIndent()

        val after = """
            fn my_func() {
                case x {
                  <caret>
                }
            }
        """.trimIndent()
        testNewlineIndentation(before, after)
    }

    @Test
    fun blockExpression() {
        val before = """
            fn my_func() {
                let x = {<caret>}
            }
        """.trimIndent()

        val after = """
            fn my_func() {
                let x = {
                  <caret>
                }
            }
        """.trimIndent()
        testNewlineIndentation(before, after)
    }

    @Test
    fun testAnonymousFn() {
        val before = """
            fn main() {
              let x = fn() {<caret>}
            }
        """.trimIndent()

        val after = """
            fn main() {
              let x = fn() {
                <caret>
              }
            }
        """.trimIndent()
        testNewlineIndentation(before, after)
    }

    private fun testNewlineIndentation(before: String, after: String) {
        myFixture.configureByText(GleamFileType, before)
        myFixture.type('\n')
        myFixture.checkResult(after)
    }
}