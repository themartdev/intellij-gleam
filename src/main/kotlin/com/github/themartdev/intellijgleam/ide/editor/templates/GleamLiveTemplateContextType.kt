package com.github.themartdev.intellijgleam.ide.editor.templates

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.lang.psi.GleamFile
import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class GleamLiveTemplateContextType : TemplateContextType(GleamBundle.message("template.context.name")) {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file is GleamFile
    }
}