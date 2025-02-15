package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.diagnostic.Logger
import com.redhat.devtools.lsp4ij.client.features.LSPCompletionFeature
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionItemKind

private val LOG = Logger.getInstance(GleamLSPCompletionFeature::class.java)

@Suppress("UnstableApiUsage")
class GleamLSPCompletionFeature : LSPCompletionFeature() {
    override fun createLookupElement(item: CompletionItem, context: LSPCompletionContext): LookupElement? {
        if (item.kind == CompletionItemKind.Function) {

        }
        item.insertTextMode
        return super.createLookupElement(item, context)
    }
}