package com.github.themartdev.intellijgleam.parser.partial

import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionDeclaration
import com.github.themartdev.intellijgleam.parser.GleamParsingTestCase
import com.intellij.psi.PsiErrorElement

/**
 * Recovery tests for incomplete member access (`expr.` with no field name yet) — the
 * canonical mid-edit state where the user has typed the dot but not the label.
 *
 * Recovery tests assert three properties, in increasing order of importance:
 *   1. an error element is produced (the input IS invalid),
 *   2. the error is LOCALISED — it doesn't swallow the construct it sits in, and
 *   3. CONTINUATION — valid code AFTER the broken point is still parsed into real nodes.
 *
 * Property 3 is the one that catches the worst parser bugs, where a single error
 * cascades and drops the rest of the file. The committed .txt snapshots pin the exact
 * recovered tree; regenerate them with the snapshot script when the grammar changes.
 *
 * These currently FAIL until the incompleteAccessExpr recovery rule lands in Gleam.bnf.
 */
class AccessPartialTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/partial/access"

    /** `wibble.` alone in a block: error exists and is the only one. */
    fun testTrailingDotEndOfBlock() {
        doTest(true)
        assertSingleErrorElement()
    }

    /** `Wibble("a").` — trailing dot on a call result (mirrors the compiler snapshot). */
    fun testTrailingDotOnCall() {
        doTest(true)
        assertSingleErrorElement()
    }

    /**
     * Continuation within a block: the `let x = 1` after the broken access must still
     * parse. If recovery is wrong, the error eats the let and this assertion fails.
     */
    fun testTrailingDotThenStatement() {
        doTest(true)
        assertSingleErrorElement()
        val letKeywords = getPsiElementsInFile { it.text == "let" }
        assertTrue("Statement after incomplete access was not recovered", letKeywords.isNotEmpty())
    }

    /**
     * Continuation across declarations — the strongest property. After a broken body the
     * parser must resynchronise at the top level and parse the next `fn` fully.
     */
    fun testTrailingDotThenDeclaration() {
        doTest(true)
        assertSingleErrorElement()
        val functions = getPsiElementsInFile { it is GleamFunctionDeclaration }
        assertEquals("Both declarations should be present after recovery", 2, functions.size)
        val intact = functions.first { it.text.contains("intact") }
        assertNoErrorElementIn(intact)
    }

    private fun assertSingleErrorElement() {
        val errors = getPsiElementsInFile { it is PsiErrorElement }
        assertEquals("Expected exactly one PsiErrorElement, got ${errors.size}", 1, errors.size)
    }

    private fun assertNoErrorElementIn(element: com.intellij.psi.PsiElement) {
        val errors = getPsiElements(element) { it is PsiErrorElement }
        assertTrue("Expected no PsiErrorElement under intact declaration: $element", errors.isEmpty())
    }
}
