package com.github.themartdev.intellijgleam.ide.template

import com.github.themartdev.intellijgleam.lang.GleamFileType
import com.intellij.ide.fileTemplates.DefaultCreateFromTemplateHandler
import com.intellij.ide.fileTemplates.FileTemplate

class CreateGleamFileFromTemplateHandler : DefaultCreateFromTemplateHandler() {
    override fun handlesTemplate(templateName: FileTemplate): Boolean {
        return templateName.isTemplateOfType(GleamFileType)
    }
}