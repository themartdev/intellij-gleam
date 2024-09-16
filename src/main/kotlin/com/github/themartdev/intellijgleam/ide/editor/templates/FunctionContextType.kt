package com.github.themartdev.intellijgleam.ide.editor.templates

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionBody
import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import com.intellij.psi.util.PsiTreeUtil

class FunctionContextType :
    TemplateContextType(GleamBundle.message("template.context.function.name")) {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        val file = templateActionContext.file
        val element = file.findElementAt(templateActionContext.startOffset)
        val fn = PsiTreeUtil.getParentOfType(element, GleamFunctionBody::class.java)
        return fn != null
    }
}
