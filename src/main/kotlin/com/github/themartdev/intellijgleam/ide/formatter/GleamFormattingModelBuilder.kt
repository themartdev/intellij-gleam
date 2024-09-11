package com.github.themartdev.intellijgleam.ide.formatter

import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider

class GleamFormattingModelBuilder : FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            GleamFormatBlock(formattingContext.node, null, null),
            formattingContext.codeStyleSettings
        )
    }
}