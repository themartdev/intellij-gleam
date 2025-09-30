package com.github.themartdev.intellijgleam.ide.wizard

import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.ide.wizard.GeneratorNewProjectWizard
import com.intellij.ide.wizard.NewProjectWizardBaseStep
import com.intellij.ide.wizard.NewProjectWizardChainStep.Companion.nextStep
import com.intellij.ide.wizard.NewProjectWizardStep
import com.intellij.ide.wizard.RootNewProjectWizardStep
import com.intellij.ide.wizard.language.LanguageGeneratorNewProjectWizard
import org.jetbrains.annotations.NonNls

class GleamNewProjectWizard(override val id: @NonNls String) : GeneratorNewProjectWizard {

    override val name = "Gleam"
    override val icon = GleamIcons.GLEAM

    override fun createStep(context: WizardContext): NewProjectWizardStep {
        return RootNewProjectWizardStep(context)
            .nextStep(::NewGleamProjectStep)
            .nextStep(::NewProjectWizardBaseStep)
            .nextStep(::NewGleamProjectAssetsStep)
    }

    // override fun createStep(parent: NewProjectWizardStep): NewProjectWizardStep {
    //     return NewGleamProjectStep(parent).nextStep(::NewGleamProjectAssetsStep)
    // }

}