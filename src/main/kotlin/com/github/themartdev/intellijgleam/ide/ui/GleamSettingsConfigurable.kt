package com.github.themartdev.intellijgleam.ide.ui

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.common.ErlangSdkFinder
import com.github.themartdev.intellijgleam.ide.common.GleamExecutableFinder
import com.github.themartdev.intellijgleam.ide.common.JsRuntimeFinder
import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.github.themartdev.intellijgleam.ide.ui.components.ErlangPathComboBox
import com.github.themartdev.intellijgleam.ide.ui.components.GleamPathComboBox
import com.github.themartdev.intellijgleam.ide.ui.components.JsRuntimePathComboBox
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.dsl.builder.*
import com.redhat.devtools.lsp4ij.LanguageServerManager

class GleamSettingsConfigurable(private val project: Project) :
    BoundConfigurable(GleamBundle.message("gleam.settings.configurable.title")), Configurable {

    private val settings = GleamServiceSettings.getInstance(project)
    private var originalGleamPath = settings.effectiveGleamPath

    private val gleamPathComboBox = GleamPathComboBox(project)
    private val erlangPathComboBox = ErlangPathComboBox(project)
    private val jsRuntimePathComboBox = JsRuntimePathComboBox(project)

    override fun createPanel() = panel {
        loadDetectedGleamPaths()
        loadDetectedErlangPaths()
        loadDetectedJsRuntimePaths()
        group(GleamBundle.message("gleam.settings.configurable.group.sdk")) {
            lateinit var overrideCheckBox: Cell<JBCheckBox>
            row {
                overrideCheckBox = checkBox(GleamBundle.message("gleam.settings.configurable.sdk.override"))
                    .comment(GleamBundle.message("gleam.settings.configurable.sdk.override.help"))
                    .bindSelected(settings::overrideGlobalToolchain)
            }
            row(GleamBundle.message("gleam.settings.configurable.sdk.gleamPath")) {
                cell(gleamPathComboBox).align(AlignX.FILL).bind(
                    { it.selectedPath ?: "" },
                    { a, b -> a.selectedPath = b },
                    settings::gleamPath.toMutableProperty()
                )
            }.enabledIf(overrideCheckBox.selected)

            row(GleamBundle.message("gleam.settings.configurable.sdk.erlangPath")) {
                cell(erlangPathComboBox).align(AlignX.FILL).bind(
                    { it.selectedPath ?: "" },
                    { a, b -> a.selectedPath = b },
                    settings::erlangPath.toMutableProperty()
                )
            }.enabledIf(overrideCheckBox.selected)

            row(GleamBundle.message("gleam.settings.configurable.sdk.jsRuntimePath")) {
                cell(jsRuntimePathComboBox).align(AlignX.FILL).bind(
                    { it.selectedPath ?: "" },
                    { a, b -> a.selectedPath = b },
                    settings::jsRuntimePath.toMutableProperty()
                )
            }.enabledIf(overrideCheckBox.selected)
                .rowComment(GleamBundle.message("gleam.settings.configurable.sdk.jsRuntimePath.help"))

        }
        group(GleamBundle.message("gleam.settings.configurable.group.lsp")) {
            row {
                checkBox(GleamBundle.message("gleam.settings.lsp.configurable.lsp.enabled"))
                    .comment(GleamBundle.message("gleam.settings.lsp.configurable.lsp.enabled.help"))
                    .bindSelected(
                        { settings.lspMode == GleamLspMode.ENABLED },
                        { settings.lspMode = if (it) GleamLspMode.ENABLED else GleamLspMode.DISABLED }
                    )
            }
        }
    }

    private fun loadDetectedGleamPaths() {
        val modalityState = ModalityState.current()
        ApplicationManager.getApplication().executeOnPooledThread {
            val detectedGleamPaths = GleamExecutableFinder.findGleamInstalls()
            ApplicationManager.getApplication().invokeLater({
                detectedGleamPaths.forEach { path ->
                    gleamPathComboBox.addItem(path.path, path.version)
                }
            }, modalityState)
        }
    }

    private fun loadDetectedErlangPaths() {
        val modalityState = ModalityState.current()
        ApplicationManager.getApplication().executeOnPooledThread {
            val detectedErlangPaths = ErlangSdkFinder.findErlangSdks()
            ApplicationManager.getApplication().invokeLater({
                detectedErlangPaths.forEach { path ->
                    erlangPathComboBox.addItem(path.path, path.version)
                }
            }, modalityState)
        }
    }

    private fun loadDetectedJsRuntimePaths() {
        val modalityState = ModalityState.current()
        ApplicationManager.getApplication().executeOnPooledThread {
            val detectedJsRuntimes = JsRuntimeFinder.findJsRuntimes()
            ApplicationManager.getApplication().invokeLater({
                detectedJsRuntimes.forEach { runtime ->
                    jsRuntimePathComboBox.addItem(runtime.path, runtime.version)
                }
            }, modalityState)
        }
    }

    override fun apply() {
        super.apply()
        val newPath = settings.effectiveGleamPath
        if (newPath != originalGleamPath) {
            originalGleamPath = newPath
            if (settings.lspMode == GleamLspMode.ENABLED) {
                restartLanguageServer()
            }
        }
    }

    private fun restartLanguageServer() {
        val stopOptions = LanguageServerManager.StopOptions()
        stopOptions.isWillDisable = false
        LanguageServerManager.getInstance(project).stop("gleam-ls", stopOptions)
        LanguageServerManager.getInstance(project).start("gleam-ls")
    }
}
