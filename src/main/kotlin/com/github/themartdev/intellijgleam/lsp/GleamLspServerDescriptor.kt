package com.github.themartdev.intellijgleam.lsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerDescriptor

private val logger = logger<GleamLspServerProvider>()
k
class GleamLspServerDescriptor(project: Project) : LspServerDescriptor(project, "gleam") {
    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file.extension == "gleam"
    }

    override fun createCommandLine(): GeneralCommandLine {
        logger.warn("Creating command line for Gleam LSP server")
        return GeneralCommandLine("/home/simon/bin/gleam", "lsp")
    }
}