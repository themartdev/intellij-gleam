package com.github.themartdev.intellijgleam.ide.lifecycle

import com.github.themartdev.intellijgleam.ide.common.GleamDependencyRoots
import com.github.themartdev.intellijgleam.ide.common.GleamProject
import com.github.themartdev.intellijgleam.ide.lsp.GleamGlobalSettings
import com.github.themartdev.intellijgleam.ide.lsp.GleamLspLifecycleListener
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
import com.redhat.devtools.lsp4ij.lifecycle.LanguageServerLifecycleManager

class GleamStartupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        // Toolchain migration and peer-dependency health are project-agnostic; always run them.
        seedGlobalToolchainFromProject(project)
        checkLSP4IJVersion()

        // Everything below is package-specific: only engage for real Gleam projects so the plugin
        // doesn't notify about or watch folders that aren't Gleam packages.
        if (!GleamProject.isGleamProject(project)) return

        checkLSPEnabled(project)
        // Watch the language server lifecycle so an unexpected crash surfaces a one-click restart
        // instead of silently breaking navigation/completion.
        LanguageServerLifecycleManager.getInstance(project)
            .addLanguageServerLifecycleListener(GleamLspLifecycleListener(project))
        // Instantiate eagerly so its VFS watch for added/removed dependencies is active
        // from project open, not only once the library roots are first queried.
        GleamDependencyRoots.getInstance(project)
    }

    /**
     * Migration for users upgrading from the project-only settings model: if the global toolchain
     * paths are still empty but this project has paths saved in workspace.xml, copy them up so the
     * global defaults are populated and existing projects keep working.
     */
    private fun seedGlobalToolchainFromProject(project: Project) {
        val global = GleamGlobalSettings.getInstance()
        val proj = GleamServiceSettings.getInstance(project)
        if (global.gleamPath.isEmpty() && proj.gleamPath.isNotEmpty()) global.gleamPath = proj.gleamPath
        if (global.erlangPath.isEmpty() && proj.erlangPath.isNotEmpty()) global.erlangPath = proj.erlangPath
    }

    private fun checkLSP4IJVersion() {
        val pluginId = PluginId.getId("com.redhat.devtools.lsp4ij")
        val descriptor = PluginManagerCore.getPlugin(pluginId)

        when {
            descriptor == null -> notifyError(
                "Gleam language server",
                "Required peer dependency LSP4IJ is not installed. Please install it."
            )

            VersionComparatorUtil.compare(descriptor.version, "0.19.4") < 0 -> notifyError(
                "Gleam language server",
                "The installed version of peer dependency LSP4IJ is ${descriptor.version}," +
                        " but a minimum version of 0.19.4 is required. Please upgrade to 0.19.4 or newer."
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