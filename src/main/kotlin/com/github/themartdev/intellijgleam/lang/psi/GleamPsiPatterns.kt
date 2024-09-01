package com.github.themartdev.intellijgleam.lang.psi

import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement

object GleamPsiPatterns {
    val TOP_KEYWORD: PsiElementPattern.Capture<PsiElement> =
        psiElement(GleamTypes.IDENTIFIER).withParent(
            psiElement(PsiErrorElement::class.java).withParent(psiElement(GleamTypes.SOURCE_FILE))
        )
}