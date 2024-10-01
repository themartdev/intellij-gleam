package com.github.themartdev.intellijgleam.ide.lsp

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project
import com.redhat.devtools.lsp4ij.server.OSProcessStreamConnectionProvider

class GleamLanguageServer(private val project: Project) : OSProcessStreamConnectionProvider() {
    private fun getGleamSettings(): GleamServiceSettings = GleamServiceSettings.getInstance(project)

    override fun start() {
        super.commandLine = buildCommandLine()
        super.start()
    }

    private fun buildCommandLine(): GeneralCommandLine? {
        val settings = getGleamSettings()

        autoSetGleamPathIfEmpty()
        val gleamPath = settings.gleamPath
        if (gleamPath.isEmpty()) {
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
            settings.lspMode = GleamLspMode.DISABLED
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

        return GeneralCommandLine(gleamPath, "lsp")
    }

    private fun autoSetGleamPathIfEmpty() {
        val settings = getGleamSettings()
        if (settings.gleamPath.isNotEmpty()) return
    }
}