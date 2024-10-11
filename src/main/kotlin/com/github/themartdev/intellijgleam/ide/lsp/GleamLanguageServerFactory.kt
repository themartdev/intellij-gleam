package com.github.themartdev.intellijgleam.ide.lsp

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project
import com.redhat.devtools.lsp4ij.LanguageServerEnablementSupport
import com.redhat.devtools.lsp4ij.LanguageServerFactory
import com.redhat.devtools.lsp4ij.client.features.LSPClientFeatures
import com.redhat.devtools.lsp4ij.server.StreamConnectionProvider

class GleamLanguageServerFactory : LanguageServerFactory, LanguageServerEnablementSupport {
    override fun createConnectionProvider(project: Project): StreamConnectionProvider {
        return GleamLanguageServer(project)
    }

    override fun isEnabled(project: Project): Boolean {
        if (!validateLSP4IJCompatibility()) {
            return false
        }
        val settings = GleamServiceSettings.getInstance(project)
        if (settings.lspMode != GleamLspMode.ENABLED) {
            return false
        }
        val isValidPath = FsUtils.validateGleamPath(settings.gleamPath)
        if (isValidPath) {
            return true
        } else {
            settings.lspMode = GleamLspMode.DISABLED
            Notifications.Bus.notify(
                Notification(
                    "intellij-gleam.gleam-ls",
                    "Gleam language server",
                    "Gleam path is invalid. Please configure it in settings. LSP services have been disabled",
                    NotificationType.ERROR
                )
            )
            return false
        }
    }

    private fun validateLSP4IJCompatibility(): Boolean {
        try {
            Class.forName("com.redhat.devtools.lsp4ij.server.OSProcessStreamConnectionProvider")
            return true
        } catch (_: ClassNotFoundException) {
            return false
        }
    }

    override fun setEnabled(enabled: Boolean, project: Project) {
        val settings = GleamServiceSettings.getInstance(project)
        if (enabled) {
            settings.lspMode = GleamLspMode.ENABLED
        } else {
            settings.lspMode = GleamLspMode.DISABLED
        }
    }

    override fun createClientFeatures(): LSPClientFeatures {
        return LSPClientFeatures()
            .setFormattingFeature(GleamLSPFormatFeature())
    }
}