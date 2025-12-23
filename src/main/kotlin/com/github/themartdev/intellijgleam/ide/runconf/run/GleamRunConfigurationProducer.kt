package com.github.themartdev.intellijgleam.ide.runconf.run

import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionDeclaration
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeUtil.findConfigurationType
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class GleamRunConfigurationProducer : LazyRunConfigurationProducer<GleamRunConfiguration>() {

    override fun getConfigurationFactory(): ConfigurationFactory =
        GleamConfigurationFactory(findConfigurationType(GleamRunConfigurationType::class.java))

    override fun setupConfigurationFromContext(
        configuration: GleamRunConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement?>
    ): Boolean {
        val location = context.location ?: return false
        val psiElement = location.psiElement

        val functionDeclaration = PsiTreeUtil.getParentOfType(psiElement, GleamFunctionDeclaration::class.java)
            ?: return false

        if (!isPubMainFunction(functionDeclaration)) return false

        sourceElement.set(functionDeclaration)

        configuration.name = "Run ${functionDeclaration.containingFile.name}"
        configuration.options.filePath = getModulePath(functionDeclaration)

        return true
    }

    override fun isConfigurationFromContext(
        configuration: GleamRunConfiguration,
        context: ConfigurationContext
    ): Boolean {
        val location = context.location ?: return false
        val psiElement = location.psiElement

        val functionDeclaration = PsiTreeUtil.getParentOfType(psiElement, GleamFunctionDeclaration::class.java)
            ?: return false

        if (!isPubMainFunction(functionDeclaration)) return false

        val modulePath = getModulePath(functionDeclaration)
        return configuration.options.filePath == modulePath
    }

    private fun isPubMainFunction(element: GleamFunctionDeclaration): Boolean {
        val functionName = element.functionNameDefinition?.identifier?.text
        val visibility = element.visibilityModifier?.text
        return functionName == "main" && visibility == "pub"
    }

    private fun getModulePath(element: PsiElement): String {
        val virtualFile = element.containingFile.virtualFile ?: return ""
        //return virtualFile.path
        val projectBasePath = element.project.basePath ?: return ""
        return virtualFile.path.removePrefix(projectBasePath).trimStart('/')
    }
}
