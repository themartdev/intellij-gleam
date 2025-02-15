package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.psi.PsiFile
import com.redhat.devtools.lsp4ij.client.features.LSPFormattingFeature

class GleamLSPFormatFeature : LSPFormattingFeature() {
    // Always use LSP formatter
    override fun isEnabled(file: PsiFile): Boolean {
        return true;
    }
}
