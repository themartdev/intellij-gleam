package com.github.themartdev.intellijgleam.ide.wizard

import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.ide.wizard.GeneratorNewProjectWizard
import com.intellij.ide.wizard.GitNewProjectWizardStep
import com.intellij.ide.wizard.NewProjectWizardChainStep.Companion.nextStep
import com.intellij.ide.wizard.NewProjectWizardStep
import com.intellij.ide.wizard.RootNewProjectWizardStep

class GleamNewProjectWizard : GeneratorNewProjectWizard {

    override val id: String = "GleamArchetype"
    override val name = "Gleam"
    override val icon = GleamIcons.GLEAM

    override fun createStep(context: WizardContext): NewProjectWizardStep {
        return RootNewProjectWizardStep(context)
            .nextStep(::NewGleamProjectStep)
            .nextStep(::NewGleamProjectGitStep)
            .nextStep(::NewGleamProjectTargetStep)
            .nextStep(::NewGleamProjectAssetsStep)
    }

}