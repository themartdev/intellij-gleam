package com.github.themartdev.intellijgleam.ide.formatter.lsp

import com.intellij.formatting.service.FormattingService
import com.redhat.devtools.lsp4ij.LanguageServerItem
import com.redhat.devtools.lsp4ij.features.formatting.AbstractLSPFormattingService
import com.redhat.devtools.lsp4ij.features.formatting.LSPFormattingAndRangeBothService
import org.eclipse.lsp4j.ServerCapabilities

class GleamLspFormattingAndRangeBothServiceProxy : GleamAbstractLspFormattingServiceProxy() {
    override fun getProxiedService(): AbstractLSPFormattingService {
        return FormattingService.EP_NAME.findExtension<LSPFormattingAndRangeBothService>(
            LSPFormattingAndRangeBothService::class.java
        )!!
    }

    override fun canSupportFormatting(serverCapabilities: ServerCapabilities?): Boolean {
        return LanguageServerItem.isDocumentRangeFormattingSupported(serverCapabilities)
    }
}
