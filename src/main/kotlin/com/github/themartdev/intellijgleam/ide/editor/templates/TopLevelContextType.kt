package com.github.themartdev.intellijgleam.ide.editor.templates

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.lang.psi.GleamConstantDeclaration
import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionDeclaration
import com.github.themartdev.intellijgleam.lang.psi.GleamImportDeclaration
import com.github.themartdev.intellijgleam.lang.psi.GleamTypeDeclaration
import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import com.intellij.psi.util.PsiTreeUtil

class TopLevelContextType :
    TemplateContextType(GleamBundle.message("template.context.topLevelDeclaration.name")) {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        val file = templateActionContext.file
        val element = file.findElementAt(templateActionContext.startOffset)

        val declaration = PsiTreeUtil.getParentOfType(element, *TOP_LEVEL_CONTAINERS)

        return declaration == null
    }
}

private val TOP_LEVEL_CONTAINERS = arrayOf(
    GleamFunctionDeclaration::class.java,
    GleamTypeDeclaration::class.java,
    GleamConstantDeclaration::class.java,
    GleamImportDeclaration::class.java,
)