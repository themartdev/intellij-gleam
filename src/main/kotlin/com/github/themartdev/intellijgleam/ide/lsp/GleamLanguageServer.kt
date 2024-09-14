package com.github.themartdev.intellijgleam.ide.lsp

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project
import com.redhat.devtools.lsp4ij.server.ProcessStreamConnectionProvider

val LOG = com.intellij.openapi.diagnostic.Logger.getInstance(GleamLanguageServer::class.java)

class GleamLanguageServer(private val project: Project) : ProcessStreamConnectionProvider() {
    private fun getGleamSettings(): GleamServiceSettings = GleamServiceSettings.getInstance(project)

    override fun start() {
        super.commands = buildCommands()
        super.start()
    }

    private fun buildCommands(): List<String?>? {
        val settings = getGleamSettings()

        autoSetGleamPathIfEmpty()
        val gleamPath = settings.lspPath
        if (gleamPath.isEmpty()) {
            LOG.warn("Gleam path is not set")
            Notifications.Bus.notify(
                Notification(
                    "intellij-gleam.gleam-ls",
                    "Gleam language server",
                    "Gleam path is not set. Please configure it in settings. LSP services have been disabled",
                    NotificationType.ERROR
                )
            )
            return null
        }

        if (!FsUtils.validateGleamPath(gleamPath)) {
            settings.serviceMode = GleamLspMode.DISABLED
            Notifications.Bus.notify(
                Notification(
                    "intellij-gleam.gleam-ls",
                    "Gleam language server",
                    "Gleam path is invalid. Please configure it in settings. LSP services have been disabled",
                    NotificationType.ERROR
                )
            )
            return null
        }

        return listOf(gleamPath, "lsp")
    }

    private fun autoSetGleamPathIfEmpty() {
        val settings = getGleamSettings()
        if (settings.lspPath.isNotEmpty()) return

        val gleamInPath = FsUtils.findGleamInPath()
        if (gleamInPath != null) {
            settings.lspPath = gleamInPath.toAbsolutePath().toString()
            Notifications.Bus.notify(
                Notification(
                    "intellij-gleam.gleam-ls",
                    "Gleam language server",
                    "Gleam Language Server path has been automatically set to $gleamInPath because it was found in PATH. You can change it in settings",
                    NotificationType.INFORMATION
                )
            )
        }
    }

}