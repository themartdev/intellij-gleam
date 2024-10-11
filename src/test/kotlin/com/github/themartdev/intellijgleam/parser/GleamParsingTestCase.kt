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

    protected fun <T : PsiElement> getSinglePsiOfType(
        root: PsiElement,
        type: Class<T>,
    ): T {
        return getSinglePsiElement(root) { element -> type.isInstance(element) } as T
    }

    protected fun getSinglePsiElement(
        root: PsiElement,
        predicate: ((element: PsiElement) -> Boolean)
    ): PsiElement {
        val elements = mutableListOf<PsiElement>()
        root.accept(object : PsiRecursiveElementWalkingVisitor() {
            override fun visitElement(element: PsiElement) {
                if (predicate(element)) {
                    elements.add(element)
                }
                super.visitElement(element)
            }
        })
        assertEquals("Expected to find 1 element but got ${elements.size}", 1, elements.size)
        return elements[0]
    }

    protected fun getPsiElementsInFile(
        predicate: ((element: PsiElement) -> Boolean)
    ): List<PsiElement> {
        val root = myFile.viewProvider.getPsi(GleamLanguage)
        return getPsiElements(root, predicate)
    }

    protected fun getPsiElements(
        root: PsiElement,
        predicate: ((element: PsiElement) -> Boolean)
    ): List<PsiElement> {
        val elements = mutableListOf<PsiElement>()
        root.accept(object : PsiRecursiveElementWalkingVisitor() {
            override fun visitElement(element: PsiElement) {
                if (predicate(element)) {
                    elements.add(element)
                }
                super.visitElement(element)
            }
        })
        return elements
    }

    protected fun assertErrorElementIn(element: PsiElement) {
        val errors = getPsiElements(element) { it is PsiErrorElement }
        assertTrue("Expected child PsiErrorElement of $element", errors.isNotEmpty())
    }
}
