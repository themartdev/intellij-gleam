package com.github.themartdev.intellijgleam.ide.ui

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.common.ErlangSdkFinder
import com.github.themartdev.intellijgleam.ide.common.GleamExecutableFinder
import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.github.themartdev.intellijgleam.ide.ui.components.ErlangPathComboBox
import com.github.themartdev.intellijgleam.ide.ui.components.GleamPathComboBox
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.builder.toMutableProperty
import com.redhat.devtools.lsp4ij.LanguageServerManager

class GleamSettingsConfigurable(private val project: Project) :
    BoundConfigurable(GleamBundle.message("gleam.settings.configurable.title")), Configurable {

    private val settings = GleamServiceSettings.getInstance(project)
    private var originalGleamPath = settings.gleamPath

    private val gleamPathComboBox = GleamPathComboBox(project)
    private val erlangPathComboBox = ErlangPathComboBox(project)

    override fun createPanel() = panel {
        loadDetectedGleamPaths()
        loadDetectedErlangPaths()
        group(GleamBundle.message("gleam.settings.configurable.group.sdk")) {
            row(GleamBundle.message("gleam.settings.configurable.sdk.gleamPath")) {
                cell(gleamPathComboBox).align(AlignX.FILL).bind(
                    { it.selectedPath ?: "" },
                    { a, b -> a.selectedPath = b },
                    settings::gleamPath.toMutableProperty()
                )
            }

            row(GleamBundle.message("gleam.settings.configurable.sdk.erlangPath")) {
                cell(erlangPathComboBox).align(AlignX.FILL).bind(
                    { it.selectedPath ?: "" },
                    { a, b -> a.selectedPath = b },
                    settings::erlangPath.toMutableProperty()
                )
            }

        }
        group(GleamBundle.message("gleam.settings.configurable.group.lsp")) {
            buttonsGroup {
                row {
                    radioButton(
                        GleamBundle.message("gleam.settings.lsp.configurable.lsp.enabled"), GleamLspMode.ENABLED
                    ).comment(GleamBundle.message("gleam.settings.lsp.configurable.lsp.enabled.help"))
                }
                row {
                    radioButton(
                        GleamBundle.message("gleam.settings.lsp.configurable.lsp.disabled"), GleamLspMode.DISABLED
                    ).comment(GleamBundle.message("gleam.settings.lsp.configurable.lsp.disabled.help"))
                }
            }.apply {
                bind(settings::lspMode)
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

    override fun apply() {
        super.apply()
        val newPath = settings.gleamPath
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
