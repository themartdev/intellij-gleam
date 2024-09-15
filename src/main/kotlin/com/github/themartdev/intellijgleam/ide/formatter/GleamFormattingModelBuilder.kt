package com.github.themartdev.intellijgleam.ide.formatter

import com.intellij.formatting.*

class GleamFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val settings = formattingContext.codeStyleSettings
        val context = GleamFormatBlockContext(settings)
        val block = GleamFormatBlock(
            formattingContext.node,
            null,
            null,
            context
        )
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            block,
            settings
        )
    }
}
