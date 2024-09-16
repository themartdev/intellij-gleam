package com.github.themartdev.intellijgleam.completion

import org.junit.Test

class FunctionScopeCompletionTest : GleamCompletionTestBase() {

    @Test
    fun testEmptyFunction() = validateCompletionContains(
        """
        fn main() {
            <caret>
        }
        """,
        listOf("fn", "if", "let", "case", "assert", "todo", "panic", "use")
    )

    @Test
    fun testCompleteKeyword() = completeBasic(
        """
        fn main() {
            ca<caret>
        }
        """,
        """
        fn main() {
            case
        }
        """
    )

}