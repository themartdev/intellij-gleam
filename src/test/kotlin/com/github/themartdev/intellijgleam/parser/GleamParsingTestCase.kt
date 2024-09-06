package com.github.themartdev.intellijgleam.parser

import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.github.themartdev.intellijgleam.lang.parser.GleamParserDefinition
import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiRecursiveElementWalkingVisitor
import com.intellij.testFramework.ParsingTestCase

abstract class GleamParsingTestCase : ParsingTestCase(
    "",
    "gleam",
    true,
    GleamParserDefinition()
) {
    override fun getTestDataPath(): String = "src/test/testData/parser"

    override fun skipSpaces(): Boolean = false

    override fun includeRanges(): Boolean = true

    protected fun assertParsedCorrectly() {
        doTest(true, true)
    }

    protected fun assertParsedWithErrors() {
        doTest(true)
        val errors = localErrors(GleamLanguage)
        assertTrue("No PsiErrorElements found in parsed file PSI", errors.isNotEmpty())
    }

    private fun localErrors(language: Language): List<PsiElement> {
        val fileViewProvider = myFile.viewProvider
        val root = fileViewProvider.getPsi(language)
        val errorElementList = mutableListOf<PsiElement>()
        root.accept(object : PsiRecursiveElementWalkingVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is PsiErrorElement) {
                    errorElementList.add(element)
                }
                super.visitElement(element)
            }
        })
        return errorElementList
    }
}
