package com.github.themartdev.intellijgleam.ide.ui

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.common.ErlangSdkFinder
import com.github.themartdev.intellijgleam.ide.common.GleamExecutableFinder
import com.github.themartdev.intellijgleam.ide.lsp.GleamGlobalSettings
import com.github.themartdev.intellijgleam.ide.ui.components.ErlangPathComboBox
import com.github.themartdev.intellijgleam.ide.ui.components.GleamPathComboBox
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.options.Configurable
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.builder.toMutableProperty

/**
 * Application-level settings for the global Gleam toolchain (Gleam executable + Erlang SDK paths).
 * Projects use these defaults unless they opt into a per-project override (see [GleamSettingsConfigurable]).
 */
class GleamGlobalSettingsConfigurable :
    BoundConfigurable(GleamBundle.message("gleam.settings.global.configurable.title")), Configurable {

    private val settings = GleamGlobalSettings.getInstance()

    private val gleamPathComboBox = GleamPathComboBox(null)
    private val erlangPathComboBox = ErlangPathComboBox(null)

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
}
