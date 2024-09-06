package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.redhat.devtools.lsp4ij.LanguageServerFactory
import com.redhat.devtools.lsp4ij.server.StreamConnectionProvider

val LOG = Logger.getInstance(GleamLanguageServer::class.java)

class GleamLanguageServerFactory : LanguageServerFactory {
    override fun createConnectionProvider(project: Project): StreamConnectionProvider {
        val settings = GleamServiceSettings.getInstance(project)
        val gleamPath = settings.lspPath
        return GleamLanguageServer(gleamPath)
    }
}