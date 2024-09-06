package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.redhat.devtools.lsp4ij.LanguageServerFactory
import com.redhat.devtools.lsp4ij.server.StreamConnectionProvider

val LOG = Logger.getInstance(GleamLanguageServer::class.java)

class GleamLanguageServerFactory : LanguageServerFactory {
    override fun createConnectionProvider(project: Project): StreamConnectionProvider {
        LOG.warn("Creating Gleam Language Server")
        return GleamLanguageServer()
    }




}