package com.github.themartdev.intellijgleam.parser

class CaseTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/case"

    fun testConstBitArray() = assertParsedCorrectly()
    fun testConstCapture() = assertParsedCorrectly()
    fun testConstFloat() = assertParsedCorrectly()
    fun testConstInt() = assertParsedCorrectly()
    fun testConstList() = assertParsedCorrectly()
    fun testConstRecord() = assertParsedCorrectly()
    fun testConstString() = assertParsedCorrectly()
    fun testConstTuple() = assertParsedCorrectly()
    fun testMultiSubject() = assertParsedCorrectly()
    fun testVarList() = assertParsedCorrectly()
    fun testVarString() = assertParsedCorrectly()
    fun testVarTuple() = assertParsedCorrectly()
}