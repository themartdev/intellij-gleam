package com.github.themartdev.intellijgleam.runconf

import com.github.themartdev.intellijgleam.ide.runconf.run.GleamTestOutputFilter
import com.intellij.execution.filters.OpenFileHyperlinkInfo
import com.intellij.openapi.application.runReadAction
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test

class GleamTestOutputFilterTest : LightPlatformCodeInsightFixture4TestCase() {

    private val moduleSource =
        "import gleeunit\n\npub fn main() { Nil }\n\npub fn some_test() {\n  Nil\n}\n"

    @Test
    fun `matching failure line is linkified over the qualified name`() {
        myFixture.addFileToProject("test/my_app_test.gleam", moduleSource)
        val filter = GleamTestOutputFilter(project)
        val line = " test: my_app_test.some_test"

        val result = filter.applyFilter(line, line.length)

        assertNotNull(result)
        val item = result!!.resultItems.single()
        assertTrue(item.hyperlinkInfo is OpenFileHyperlinkInfo)
        // Highlight covers exactly "my_app_test.some_test"
        assertEquals(line.indexOf("my_app_test"), item.highlightStartOffset)
        assertEquals(line.length, item.highlightEndOffset)
    }

    @Test
    fun `non-test line is ignored`() {
        val filter = GleamTestOutputFilter(project)
        val line = "Finished in 0.013 seconds"
        assertNull(filter.applyFilter(line, line.length))
    }

    @Test
    fun `resolve finds the module file and the function line`() {
        val file = myFixture.addFileToProject("test/my_app_test.gleam", moduleSource).virtualFile
        val filter = GleamTestOutputFilter(project)

        val target = runReadAction { filter.resolve("my_app_test", "some_test") }

        assertNotNull(target)
        assertEquals(file, target!!.file)
        assertEquals(4, target.line) // 0-based; `pub fn some_test` is the 5th line
    }

    @Test
    fun `resolve maps erlang at-separated module names to nested paths`() {
        myFixture.addFileToProject("test/foo/bar_test.gleam", "pub fn nested_test() {\n  Nil\n}\n")
        val filter = GleamTestOutputFilter(project)

        val target = runReadAction { filter.resolve("foo@bar_test", "nested_test") }

        assertNotNull(target)
        assertTrue(target!!.file.path.endsWith("foo/bar_test.gleam"))
        assertEquals(0, target.line)
    }

    @Test
    fun `resolve returns null when the module is unknown`() {
        val filter = GleamTestOutputFilter(project)
        val target = runReadAction { filter.resolve("does_not_exist", "x") }
        assertNull(target)
    }
}
