package com.github.themartdev.intellijgleam.ide.wizard

import com.intellij.ide.projectWizard.generators.AssetsNewProjectWizardStep
import com.intellij.ide.wizard.NewProjectWizardStep
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir

class NewGleamProjectAssetsStep(private val parent: NewGleamProjectTargetStep) : AssetsNewProjectWizardStep(parent) {
    override fun setupAssets(project: Project) {
        setOutputDirectory(project.guessProjectDir()?.path!!)
        val props = arrayOf(
            Pair("gleamProjectName", project.name),
            Pair("gleamProjectTarget", parent.target),
        )

        if (context.isCreatingNewProject) {
            addTemplateAsset("gleam.toml", "gleam.toml", *props)
            addTemplateAsset(".gitignore", "gleam.gitignore", *props)

            addEmptyDirectoryAsset("src")
            addTemplateAsset("src/main.gleam", "main.gleam", *props)
        }
    }
}