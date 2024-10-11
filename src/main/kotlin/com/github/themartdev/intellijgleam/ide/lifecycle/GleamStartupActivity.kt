package com.github.themartdev.intellijgleam.ide.lifecycle

import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class GleamStartupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        checkLSP4IJVersion()
        checkLSPEnabled(project)
    }

    private fun checkLSP4IJVersion() {
        try {
            Class.forName("com.redhat.devtools.lsp4ij.server.OSProcessStreamConnectionProvider")
        } catch (_: ClassNotFoundException) {
            Notifications.Bus.notify(
                Notification(
                    "intellij-gleam.gleam-ls",
                    "Gleam language server",
                    "This plugin depends on the LSP4IJ plugin version 0.6 and above. Please update the plugin.",
                    NotificationType.ERROR
                )
            )
        }
    }

    private fun checkLSPEnabled(project: Project) {
        val lspEnabled = GleamServiceSettings.getInstance(project).lspMode == GleamLspMode.ENABLED
        if (!lspEnabled) {
            Notifications.Bus.notify(
                Notification(
                    "intellij-gleam.gleam-ls",
                    "Gleam language server",
                    "Gleam language server is disabled. It can be enabled in the settings.",
                    NotificationType.INFORMATION
                )
            )
        }
    }
}