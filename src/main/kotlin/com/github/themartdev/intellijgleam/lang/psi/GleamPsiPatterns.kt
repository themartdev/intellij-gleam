package com.github.themartdev.intellijgleam.lang.psi

import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.util.ProcessingContext

object GleamPsiPatterns {
    val topLevel: PsiElementPattern.Capture<PsiElement> =
        psiElement().withParent(
            psiElement(PsiErrorElement::class.java).withParent(GleamFile::class.java).with(AfterNewLine)
        )

    val inFunction: PsiElementPattern.Capture<PsiElement> =
        psiElement().inside(GleamFunctionBody::class.java)
}

private object NewLine : PatternCondition<PsiElement>("newLine") {
    override fun accepts(element: PsiElement, context: ProcessingContext?): Boolean {
        return element is PsiWhiteSpace && element.textContains('\n')
    }
}

private object AfterNewLine : PatternCondition<PsiElement>("afterNewLine") {
    override fun accepts(element: PsiElement, context: ProcessingContext?): Boolean {
        val prev = GleamPsiUtil.skipWhitespacesBackwardWithoutNewLines(element) ?: return true
        return NewLine.accepts(prev, context)
    }
}

