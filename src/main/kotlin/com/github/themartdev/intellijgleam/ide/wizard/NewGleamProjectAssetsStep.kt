package com.github.themartdev.intellijgleam.ide.wizard

import com.intellij.ide.projectWizard.generators.AssetsNewProjectWizardStep;
import com.intellij.ide.starters.local.GeneratorResourceFile
import com.intellij.ide.wizard.NewProjectWizardBaseStep
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir

class NewGleamProjectAssetsStep(private val parent: NewProjectWizardBaseStep) : AssetsNewProjectWizardStep(parent) {
    override fun setupAssets(project: Project) {
        if (project.name.startsWith("gleam_")) {
            error("We were not able to create your project as `${project.name}` has the reserved " +
                    "prefix `gleam_`. This prefix is intended for official Gleam packages only.")
        }
        if (!project.name.matches(Regex("[a-z][a-z0-9_]*"))) {
            error("Invalid project name: `${project.name}`. Project names must start with a lowercase letter and may " +
                    "only contain lowercase letters, numbers and underscores.")
        }

        setOutputDirectory(project.guessProjectDir()?.path!!)
        val props = arrayOf(Pair("gleamProjectName", project.name))

        if (context.isCreatingNewProject) {
            addTemplateAsset("gleam.toml", "gleam.toml", *props)

            addEmptyDirectoryAsset("src")
            addTemplateAsset("src/main.gleam", "main.gleam", *props)
        }
    }
}