package com.github.themartdev.intellijgleam.parser

import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionBody
import com.github.themartdev.intellijgleam.lang.psi.GleamPipeExpr

class EchoTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/echo"

    fun testSimple() = assertParsedCorrectly()

    fun testChain() = assertParsedCorrectly()

    fun testPipe() = assertParsedCorrectly()

    fun testPipePrecedence() {
        doTest(true)
        val functionBody = getSinglePsiOfType(myFile, GleamFunctionBody::class.java)
        assertNotNull(functionBody)
        assertEquals(2, functionBody.expressionList.size)
        assertInstanceOf(functionBody.expressionList[0], GleamPipeExpr::class.java)
        assertInstanceOf(functionBody.expressionList[1], GleamPipeExpr::class.java)
    }
}
