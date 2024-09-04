package com.github.themartdev.intellijgleam.parser

class BitArrayTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/bitarray"

    fun testSanity() = assertParsedCorrectly()
}