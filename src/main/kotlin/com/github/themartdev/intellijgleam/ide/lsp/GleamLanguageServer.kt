package com.github.themartdev.intellijgleam.ide.lsp

import com.redhat.devtools.lsp4ij.server.ProcessStreamConnectionProvider

class GleamLanguageServer() : ProcessStreamConnectionProvider() {
    init {
        super.setCommands(mutableListOf("/home/simon/.asdf/shims/gleam", "lsp"))
    }
}