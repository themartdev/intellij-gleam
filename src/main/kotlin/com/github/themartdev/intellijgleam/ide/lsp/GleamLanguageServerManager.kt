package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.openapi.project.Project
import com.redhat.devtools.lsp4ij.LanguageServerManager

/**
 * Thin wrapper over LSP4IJ's [LanguageServerManager] for the Gleam server, so callers (the manual
 * restart action and the crash-recovery notification) don't repeat the server id / start-options
 * boilerplate.
 */
object GleamLanguageServerManager {
    /** Must match the `id` of the `<server>` registered in `plugin.xml`. */
    const val SERVER_ID = "gleam-ls"

    /**
     * (Re)start `gleam lsp`, tearing down any existing process first. Ensures the project's LSP
     * mode is [GleamLspMode.ENABLED] so a restart issued after the server was auto-disabled (or a
     * manual restart) actually brings the server back up.
     */
    fun restart(project: Project) {
        GleamServiceSettings.getInstance(project).lspMode = GleamLspMode.ENABLED
        LanguageServerManager.getInstance(project).start(
            SERVER_ID,
            LanguageServerManager.StartOptions()
                .setForceRestart(true)
                .setWillEnable(true)
        )
    }
}
