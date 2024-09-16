package com.github.themartdev.intellijgleam.completion

import org.junit.Test

class FileScopeCompletionTest : GleamCompletionTestBase() {
    @Test
    fun emptyFile() = validateCompletionContains(
        """<caret>""",
        listOf("import", "const", "type", "fn", "pub", "opaque")
    )


    @Test
    fun completeKeyword() = completeBasic(
        """im<caret>""",
        """import"""
    )
}