package com.github.themartdev.intellijgleam.ide.completion

import com.github.themartdev.intellijgleam.lang.psi.GleamPsiPatterns
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

object FileScopeCompletionProvider : GleamCompletionProvider() {
    override val pattern = GleamPsiPatterns.TOP_KEYWORD

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        result.addElement(LookupElementBuilder.create("hello"))
    }
}