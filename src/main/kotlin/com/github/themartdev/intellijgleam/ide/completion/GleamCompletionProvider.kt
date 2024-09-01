package com.github.themartdev.intellijgleam.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.ElementPattern
import com.intellij.psi.PsiElement

abstract class GleamCompletionProvider : CompletionProvider<CompletionParameters>() {
    abstract val pattern: ElementPattern<out PsiElement>
    open val type: CompletionType = CompletionType.BASIC
}