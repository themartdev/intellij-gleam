package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.openapi.project.Project
import com.redhat.devtools.lsp4ij.LanguageServerEnablementSupport
import com.redhat.devtools.lsp4ij.LanguageServerFactory
import com.redhat.devtools.lsp4ij.server.StreamConnectionProvider

class GleamLanguageServerFactory : LanguageServerFactory, LanguageServerEnablementSupport {
    override fun createConnectionProvider(project: Project): StreamConnectionProvider {
        return GleamLanguageServer(project)
    }

    override fun isEnabled(project: Project): Boolean {
        val settings = GleamServiceSettings.getInstance(project)
        return settings.lspMode == GleamLspMode.ENABLED
    }

    override fun setEnabled(enabled: Boolean, project: Project) {
        val settings = GleamServiceSettings.getInstance(project)
        if (enabled) {
            settings.lspMode = GleamLspMode.ENABLED
        } else {
            settings.lspMode = GleamLspMode.DISABLED
        }
    }
}