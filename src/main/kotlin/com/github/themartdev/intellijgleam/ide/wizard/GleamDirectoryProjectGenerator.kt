package com.github.themartdev.intellijgleam.ide.wizard

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupManager
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.DirectoryProjectGeneratorBase
import com.intellij.psi.PsiManager
import java.util.*
import javax.swing.Icon

class GleamDirectoryProjectGenerator : DirectoryProjectGeneratorBase<Object>() {
    override fun getName(): @NlsContexts.Label String = GleamBundle.message("gleam.wizard.directory.project.generator.name")

    override fun getLogo(): Icon = GleamIcons.GLEAM

    override fun generateProject(
        project: Project,
        baseDir: VirtualFile,
        settings: Object,
        module: Module
    ) {
        StartupManager.getInstance(project).runWhenProjectIsInitialized {
            ApplicationManager.getApplication().invokeLater {
                runWriteAction {
                    val psiBaseDir = PsiManager.getInstance(project).findDirectory(baseDir) ?: return@runWriteAction
                    val templateManager = FileTemplateManager.getInstance(project)

                    val properties = Properties()
                    GleamProjectAssets.assetProps(project.name, "")
                        .forEach { (key, value) -> properties[key] = value }

                    GleamProjectAssets.fileAssets().forEach { (sourcePath, templateName) ->
                        val pathParts = sourcePath.split("/").toMutableList()
                        val targetFile = pathParts.removeLast()
                        var dir = psiBaseDir
                        pathParts.forEach { dir = dir.createSubdirectory(it) }
                        val template = templateManager.getInternalTemplate(templateName)
                        FileTemplateUtil.createFromTemplate(template, targetFile, properties, dir)
                    }
                }
            }
        }
    }
}