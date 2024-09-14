package com.github.themartdev.intellijgleam.ide.ui

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.UiDslUnnamedConfigurable
import com.intellij.openapi.project.Project
import com.intellij.ui.JBColor
import com.intellij.ui.components.Label
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.bindText

val LOG = com.intellij.openapi.diagnostic.Logger.getInstance(GleamSettingsConfigurable::class.java)

class GleamSettingsConfigurable(project: Project) : UiDslUnnamedConfigurable.Simple(), Configurable {
    private val settings = GleamServiceSettings.getInstance(project)

    private val errorLabel = Label("Invalid path", null)
    private val gleamPathSelect = GleamPathSelect()

    private fun runPathValidation() {
        if (!gleamPathSelect.isEnabled) return

        LOG.warn("Running path validation")

        val path = gleamPathSelect.text
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

    private fun setPathWidgetEnabled(value: Boolean) {
        gleamPathSelect.isEnabled = value
        errorLabel.isVisible = value
    }

    override fun Panel.createContent() {
        errorLabel.isVisible = false
        group(GleamBundle.message("gleam.settings.lsp.configurable.lsp.group")) {
            row(GleamBundle.message("gleam.settings.lsp.configurable.lsp.path")) {
                cell(gleamPathSelect)
                    .align(AlignX.FILL)
                    .onChanged { runPathValidation() }
                    .bindText(settings::lspPath)
            }
            row("") {
                cell(errorLabel)
                    .align(AlignX.FILL)
            }

            buttonsGroup {
                row {
                    radioButton(
                        GleamBundle.message("gleam.settings.lsp.configurable.lsp.enabled"),
                        GleamLspMode.ENABLED
                    )
                        .comment(GleamBundle.message("gleam.settings.lsp.configurable.lsp.enabled.help"))
                        .onChanged { setPathWidgetEnabled(true) }
                }
                row {
                    radioButton(
                        GleamBundle.message("gleam.settings.lsp.configurable.lsp.disabled"),
                        GleamLspMode.DISABLED
                    )
                        .comment(GleamBundle.message("gleam.settings.lsp.configurable.lsp.disabled.help"))
                        .onChanged { setPathWidgetEnabled(false) }
                }
            }.apply {
                bind(settings::serviceMode)
            }
        }
        runPathValidation()
    }

    override fun getDisplayName() = GleamBundle.message("gleam.settings.configurable.title")
}
