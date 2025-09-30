package com.github.themartdev.intellijgleam.ide.wizard

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.intellij.ide.projectWizard.NewProjectWizardCollector.Base.logGitChanged
import com.intellij.ide.projectWizard.NewProjectWizardCollector.Base.logGitFinished
import com.intellij.ide.projectWizard.generators.AssetsNewProjectWizardStep
import com.intellij.ide.wizard.AbstractNewProjectWizardStep
import com.intellij.ide.wizard.NewProjectWizardStep
import com.intellij.ide.wizard.NewProjectWizardStep.Companion.GIT_PROPERTY_NAME
import com.intellij.openapi.observable.properties.GraphProperty
import com.intellij.openapi.observable.util.bindBooleanStorage
import com.intellij.ui.UIBundle
import com.intellij.ui.dsl.builder.BottomGap
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.bindSelected
import com.intellij.ui.dsl.builder.selected
import com.intellij.ui.dsl.builder.whenStateChangedFromUi

class NewGleamProjectTargetStep(private val parent: NewProjectWizardStep) : AbstractNewProjectWizardStep(parent) {
    val targetProperty: GraphProperty<String> = propertyGraph.property("")
    var target: String by targetProperty

    override fun setupUI(builder: Panel) {
        with(builder) {
            group(GleamBundle.message("gleam.wizard.newproject.configurable.group.target")) {
                buttonsGroup {
                    row {
                        radioButton(
                            GleamBundle.message("gleam.wizard.newproject.configurable.target.erlang"), ""
                        ).comment(GleamBundle.message("gleam.wizard.newproject.configurable.target.erlang.help"))
                    }
                    row {
                        radioButton(
                            GleamBundle.message("gleam.wizard.newproject.configurable.target.javascript"), "target = \"javascript\"\n"
                        ).comment(GleamBundle.message("gleam.wizard.newproject.configurable.target.javascript.help"))
                    }
                }.apply {
                    bind(::target)
                }
            }
        }
    }

}