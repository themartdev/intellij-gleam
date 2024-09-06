package com.github.themartdev.intellijgleam.ide.ui

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.UiDslUnnamedConfigurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.bindText

class GleamSettingsConfigurable(project: Project) : UiDslUnnamedConfigurable.Simple(), Configurable {
    private val settings = GleamServiceSettings.getInstance(project)

    override fun Panel.createContent() {
        group(GleamBundle.message("gleam.settings.lsp.configurable.lsp.group")) {
            row(GleamBundle.message("gleam.settings.lsp.configurable.lsp.path")) {
                cell(GleamPathSelect())
                    .align(AlignX.FILL)
                    .bindText(settings::lspPath)
            }

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
                bind(settings::serviceMode)
            }
        }
    }

    override fun getDisplayName() = GleamBundle.message("gleam.settings.configurable.title")
}
