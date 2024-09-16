package com.github.themartdev.intellijgleam.ide.completion

import com.intellij.codeInsight.completion.CompletionContributor

class GleamCompletionContributor : CompletionContributor() {
    private val providers = listOf(
        FileScopeCompletionProvider,
        FunctionScopeCompletionProvider
    )

    init {
        providers.forEach { doExtend(it) }
    }

    private fun doExtend(provider: GleamCompletionProvider) {
        extend(provider.type, provider.pattern, provider)
    }
}