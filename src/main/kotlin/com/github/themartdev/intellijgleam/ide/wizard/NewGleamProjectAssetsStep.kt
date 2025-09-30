package com.github.themartdev.intellijgleam.ide.wizard

import com.intellij.ide.projectWizard.generators.AssetsNewProjectWizardStep
import com.intellij.ide.wizard.NewProjectWizardStep
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir

class NewGleamProjectAssetsStep(private val parent: NewProjectWizardStep) : AssetsNewProjectWizardStep(parent) {
    override fun setupAssets(project: Project) {
        setOutputDirectory(project.guessProjectDir()?.path!!)
        val props = arrayOf(Pair("gleamProjectName", project.name))

        if (context.isCreatingNewProject) {
            addTemplateAsset("gleam.toml", "gleam.toml", *props)

            addEmptyDirectoryAsset("src")
            addTemplateAsset("src/main.gleam", "main.gleam", *props)
        }
    }
}