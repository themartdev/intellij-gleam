@file:Suppress("UnstableApiUsage")

package com.github.themartdev.intellijgleam.ide.lsp

import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServer
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.lsWidget.LspServerWidgetItem

private val LOG = logger<GleamLspServerProvider>()

internal class GleamLspServerProvider : LspServerSupportProvider {
    override fun fileOpened(
        project: Project,
        file: VirtualFile,
        serverStarter: LspServerSupportProvider.LspServerStarter
    ) {

        if (file.extension != "gleam") {
            LOG.warn("Not a Gleam file, skipping LSP server start")
            return
        }

        LOG.warn("Ensuring server started")
        serverStarter.ensureServerStarted(GleamLspServerDescriptor(project))
    }

    override fun createLspServerWidgetItem(lspServer: LspServer, currentFile: VirtualFile?): LspServerWidgetItem? {
        return LspServerWidgetItem(lspServer, currentFile, GleamIcons.GLEAM, null)
    }
}