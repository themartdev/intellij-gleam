package com.github.themartdev.intellijgleam.ide.lsp

import com.redhat.devtools.lsp4ij.server.ProcessStreamConnectionProvider

class GleamLanguageServer(gleamPath: String) : ProcessStreamConnectionProvider() {
    init {
        super.setCommands(mutableListOf(gleamPath, "lsp"))
    }
}