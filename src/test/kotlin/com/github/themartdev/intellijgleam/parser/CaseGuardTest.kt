package com.github.themartdev.intellijgleam.parser

class CaseGuardTest : GleamParsingTestCase() {
    override fun getTestDataPath(): String = super.getTestDataPath() + "/case_guard"

    fun testSimpleGuard() = assertParsedCorrectly()

    fun testIndexAccessGuard() = assertParsedCorrectly()

    fun testFieldAccessGuard() = assertParsedCorrectly()
}
