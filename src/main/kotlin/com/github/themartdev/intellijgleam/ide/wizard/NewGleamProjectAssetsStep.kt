package com.github.themartdev.intellijgleam.ide.wizard

import com.intellij.ide.projectWizard.generators.AssetsNewProjectWizardStep
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir

class NewGleamProjectAssetsStep(private val parent: NewGleamProjectTargetStep) : AssetsNewProjectWizardStep(parent) {

    override fun setupAssets(project: Project) {
        setOutputDirectory(project.guessProjectDir()?.path!!)
        val props = GleamProjectAssets.assetProps(project.name, parent.target)

        if (context.isCreatingNewProject) {
            GleamProjectAssets.assetDirs().forEach { dir -> addEmptyDirectoryAsset(dir) }
            GleamProjectAssets.fileAssets().forEach { (sourcePath, templateName) -> addTemplateAsset(sourcePath, templateName, *props) }
        }
    }
}