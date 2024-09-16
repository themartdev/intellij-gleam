package com.github.themartdev.intellijgleam.ide.completion

import com.github.themartdev.intellijgleam.lang.psi.GleamPsiPatterns
import com.github.themartdev.intellijgleam.lang.psi.IN_FUNCTION_KEYWORDS
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

object FunctionScopeCompletionProvider : GleamCompletionProvider() {
    override val pattern = GleamPsiPatterns.inFunction

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        result.addAllElements(IN_FUNCTION_KEYWORDS.types.map { LookupElementBuilder.create(it) })
    }
}
