package com.github.themartdev.intellijgleam.ide.lifecycle

import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.util.text.VersionComparatorUtil

class GleamStartupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        checkLSP4IJVersion()
        checkLSPEnabled(project)
    }

    private fun checkLSP4IJVersion() {
        val pluginId = PluginId.getId("com.redhat.devtools.lsp4ij")
        val descriptor = PluginManagerCore.getPlugin(pluginId)

        when {
            descriptor == null -> notifyError(
                "Gleam language server",
                "Required peer dependency LSP4IJ is not installed. Please install it."
            )

            VersionComparatorUtil.compare(descriptor.version, "0.12.0") < 0 -> notifyError(
                "Gleam language server",
                "The installed version of peer dependency LSP4IJ is ${descriptor.version}," +
                        " but a minimum version of 0.12.0 is required. Please upgrade to 0.12.0 or newer."
            )
        }
    }

    private fun notifyError(title: String, content: String) {
        Notifications.Bus.notify(
            Notification("intellij-gleam.gleam-ls", title, content, NotificationType.ERROR)
        )
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