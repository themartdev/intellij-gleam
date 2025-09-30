package com.github.themartdev.intellijgleam.ide.wizard

import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.ide.wizard.AbstractNewProjectWizardStep
import com.intellij.ide.wizard.NewProjectWizardBaseStep
import com.intellij.ide.wizard.NewProjectWizardStep
import com.intellij.openapi.project.DefaultProjectFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.platform.backend.workspace.WorkspaceModel
import com.intellij.platform.workspace.jps.entities.ContentRootEntity
import com.intellij.platform.workspace.jps.entities.ModuleEntity
import com.intellij.platform.workspace.jps.entities.SourceRootEntity
import com.intellij.platform.workspace.jps.entities.SourceRootTypeId
import com.intellij.platform.workspace.jps.entities.modifyModuleEntity
import java.util.concurrent.TimeUnit

public class NewGleamProjectStep(parentStep: NewProjectWizardStep) : AbstractNewProjectWizardStep(parentStep) {
    override fun setupProject(project: Project) {
        super.setupProject(project)
    }
}