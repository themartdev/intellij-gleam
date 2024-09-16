package com.github.themartdev.intellijgleam.lang.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil

object GleamPsiUtil {
    fun skipWhitespacesBackwardWithoutNewLines(element: PsiElement?) =
        PsiTreeUtil.skipMatching(element, { it.prevSibling }, { it is PsiWhiteSpace && !it.textContains('\n') })
}