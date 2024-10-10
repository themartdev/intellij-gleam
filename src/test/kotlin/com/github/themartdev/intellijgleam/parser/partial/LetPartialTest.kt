package com.github.themartdev.intellijgleam.parser.partial

import com.github.themartdev.intellijgleam.lang.psi.GleamIdentifierPattern
import com.github.themartdev.intellijgleam.lang.psi.GleamLetExpr
import com.github.themartdev.intellijgleam.lang.psi.GleamTuplePattern
import com.github.themartdev.intellijgleam.parser.GleamParsingTestCase

class LetPartialTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/partial/let"

    fun testNoExpression() {
        doTest(true)
        val letExpr = getSinglePsiOfType(myFile, GleamLetExpr::class.java)
        assertErrorElementIn(letExpr)
        val identifierPattern: GleamIdentifierPattern =
            letExpr.patternAliasable?.pattern as? GleamIdentifierPattern ?: error("Expected identifier pattern")
        assertEquals("asdf", identifierPattern.text)
    }

    fun testNoEquals() {
        doTest(true)
        val letExpr = getSinglePsiOfType(myFile, GleamLetExpr::class.java)
        assertErrorElementIn(letExpr)
        val identifierPattern: GleamIdentifierPattern =
            letExpr.patternAliasable?.pattern as? GleamIdentifierPattern ?: error("Expected identifier pattern")
        assertEquals("asdf", identifierPattern.text)
    }

    fun testTuplePatternNoEquals() {
        doTest(true)
        val letExpr = getSinglePsiOfType(myFile, GleamLetExpr::class.java)
        assertErrorElementIn(letExpr)
        val identifierPattern: GleamTuplePattern =
            letExpr.patternAliasable?.pattern as? GleamTuplePattern ?: error("Expected tuple pattern")
        assertEquals("#(a, b)", identifierPattern.text)
    }
}