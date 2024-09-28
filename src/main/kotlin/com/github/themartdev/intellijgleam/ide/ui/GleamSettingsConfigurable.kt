package com.github.themartdev.intellijgleam.ide.ui

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.common.ErlangSdkFinder
import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.github.themartdev.intellijgleam.ide.common.GleamExecutableFinder
import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.github.themartdev.intellijgleam.ide.ui.components.ErlangPathComboBox
import com.github.themartdev.intellijgleam.ide.ui.components.GleamPathComboBox
import com.github.themartdev.intellijgleam.ide.ui.components.PathItem
import com.github.themartdev.intellijgleam.ide.ui.components.fromErlangSdk
import com.github.themartdev.intellijgleam.ide.ui.components.fromExecutable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.UiDslUnnamedConfigurable
import com.intellij.openapi.project.Project
import com.intellij.ui.JBColor
import com.intellij.ui.components.Label
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.toMutableProperty

val LOG = com.intellij.openapi.diagnostic.Logger.getInstance(GleamSettingsConfigurable::class.java)

class GleamSettingsConfigurable(project: Project) : UiDslUnnamedConfigurable.Simple(), Configurable {
    private val settings = GleamServiceSettings.getInstance(project)

    private val errorLabel = Label("Invalid path", null)
    private val gleamPathComboBox = GleamPathComboBox(project)
    private val erlangPathComboBox = ErlangPathComboBox(project)

    private fun runPathValidation() {
        if (!gleamPathComboBox.isEnabled) return

        LOG.warn("Running path validation")

        val path = gleamPathComboBox.selectedPath ?: ""
        val valid = FsUtils.validateGleamPath(path)
        errorLabel.isVisible = true
        if (!valid) {
            errorLabel.foreground = JBColor.RED
            errorLabel.text = "Invalid gleam path"
        } else {
            errorLabel.foreground = JBColor.GREEN
            errorLabel.text = "Valid gleam path"
        }
    }

    override fun Panel.createContent() {
        loadDetectedGleamPaths()
        loadDetectedErlangPaths()
        errorLabel.isVisible = false
        group(GleamBundle.message("gleam.settings.configurable.group.sdk")) {
            row(GleamBundle.message("gleam.settings.configurable.sdk.gleamPath")) {
                cell(gleamPathComboBox)
                    .align(AlignX.FILL)
                    .onChanged { runPathValidation() }
                    .bind(
                        { it.selectedPath ?: "" },
                        { a, b -> a.selectedPath = b },
                        settings::gleamPath.toMutableProperty()
                    )
            }

            row(GleamBundle.message("gleam.settings.configurable.sdk.erlangPath")) {
                cell(erlangPathComboBox)
                    .align(AlignX.FILL)
                    .onChanged { runPathValidation() }
                    .bind(
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
                        GleamBundle.message("gleam.settings.lsp.configurable.lsp.enabled"),
                        GleamLspMode.ENABLED
                    )
                        .comment(GleamBundle.message("gleam.settings.lsp.configurable.lsp.enabled.help"))
                }
                row {
                    radioButton(
                        GleamBundle.message("gleam.settings.lsp.configurable.lsp.disabled"),
                        GleamLspMode.DISABLED
                    )
                        .comment(GleamBundle.message("gleam.settings.lsp.configurable.lsp.disabled.help"))
                }
            }.apply {
                bind(settings::lspMode)
            }
        }
        runPathValidation()
    }

    override fun getDisplayName() = GleamBundle.message("gleam.settings.configurable.title")

    private fun loadDetectedGleamPaths() {
        val modalityState = ModalityState.current()
        ApplicationManager.getApplication().executeOnPooledThread {
            val detectedGleamPaths = GleamExecutableFinder.findGleamInstalls()
            val pathItems = detectedGleamPaths.map { PathItem.Value.fromExecutable(it) }
            ApplicationManager.getApplication().invokeLater({
                gleamPathComboBox.addItems(pathItems)
            }, modalityState);
        }
    }

    private fun loadDetectedErlangPaths() {
        val modalityState = ModalityState.current()
        ApplicationManager.getApplication().executeOnPooledThread {
            val detectedErlangPaths = ErlangSdkFinder.findErlangSdks()
            val pathItems = detectedErlangPaths.map { PathItem.Value.fromErlangSdk(it) }
            ApplicationManager.getApplication().invokeLater({
                erlangPathComboBox.addItems(pathItems)
            }, modalityState);
        }
    }
}
