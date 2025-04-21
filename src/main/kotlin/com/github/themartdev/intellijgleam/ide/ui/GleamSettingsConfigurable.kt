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
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.UiDslUnnamedConfigurable
import com.intellij.openapi.project.Project
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.toMutableProperty

class GleamSettingsConfigurable(project: Project) : UiDslUnnamedConfigurable.Simple(), Configurable {
    private val settings = GleamServiceSettings.getInstance(project)

    private val gleamPathComboBox = GleamPathComboBox(project)
    private val erlangPathComboBox = ErlangPathComboBox(project)

    override fun Panel.createContent() {
        loadDetectedGleamPaths()
        loadDetectedErlangPaths()
        group(GleamBundle.message("gleam.settings.configurable.group.sdk")) {
            row(GleamBundle.message("gleam.settings.configurable.sdk.gleamPath")) {
                cell(gleamPathComboBox)
                    .align(AlignX.FILL)
                    .bind(
                        { it.selectedPath ?: "" },
                        { a, b -> a.selectedPath = b },
                        settings::gleamPath.toMutableProperty()
                    )
            }

            row(GleamBundle.message("gleam.settings.configurable.sdk.erlangPath")) {
                cell(erlangPathComboBox)
                    .align(AlignX.FILL)
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
    }

    override fun getDisplayName() = GleamBundle.message("gleam.settings.configurable.title")

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
}
