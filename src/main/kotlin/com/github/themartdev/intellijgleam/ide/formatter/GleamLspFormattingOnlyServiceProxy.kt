package com.github.themartdev.intellijgleam.ide.formatter

import com.intellij.formatting.service.FormattingService
import com.redhat.devtools.lsp4ij.LanguageServerItem
import com.redhat.devtools.lsp4ij.features.formatting.AbstractLSPFormattingService
import com.redhat.devtools.lsp4ij.features.formatting.LSPFormattingOnlyService
import org.eclipse.lsp4j.ServerCapabilities

class GleamLspFormattingOnlyServiceProxy : GleamAbstractLspFormattingServiceProxy() {
    override fun getProxiedService(): AbstractLSPFormattingService {
        return FormattingService.EP_NAME.findExtension<LSPFormattingOnlyService>(LSPFormattingOnlyService::class.java)!!
    }

    override fun canSupportFormatting(serverCapabilities: ServerCapabilities?): Boolean {
        return LanguageServerItem.isDocumentFormattingSupported(serverCapabilities) && !LanguageServerItem.isDocumentRangeFormattingSupported(
            serverCapabilities
        )
    }
}
