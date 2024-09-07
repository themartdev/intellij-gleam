package com.github.themartdev.intellijgleam.ide.annotator

import com.github.themartdev.intellijgleam.ide.highlighting.GleamColors
import com.github.themartdev.intellijgleam.lang.psi.GleamImportDeclaration
import com.github.themartdev.intellijgleam.lang.psi.GleamLabeledArgument
import com.github.themartdev.intellijgleam.lang.psi.GleamShortHandLabeledArgument
import com.github.themartdev.intellijgleam.lang.psi.GleamTypes
import com.intellij.codeInspection.util.InspectionMessage
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

class GleamHighlightingAnnotator : Annotator, DumbAware {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element.elementType) {
            GleamTypes.FUNCTION_NAME_DEFINITION -> newAnnotation(holder, element, GleamColors.FUNCTION_DECLARATION)
            GleamTypes.STRING_ESCAPE_SEGMENT -> newAnnotation(holder, element, GleamColors.STRING_ESCAPE)
            GleamTypes.TYPE_DECLARATION_NAME -> newAnnotation(holder, element, GleamColors.TYPE_DECLARATION)
        }

        when (element) {
            is GleamImportDeclaration -> {
                element.unqualifiedImports?.typeUnqualifiedImportList?.forEach {
                    it.nameOrAlias?.let { nameOrAlias ->
                        newAnnotation(
                            holder,
                            nameOrAlias,
                            GleamColors.TYPE_DECLARATION
                        )
                    }
                }
            }
        }

        highlightLabels(element, holder)
    }

    private fun highlightLabels(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is GleamLabeledArgument -> {
                newAnnotationBuilder(holder, GleamColors.LABEL.externalName)
                    .textAttributes(GleamColors.LABEL)
                    .range(element.identifier)
                    .create()
            }

            is GleamShortHandLabeledArgument -> {
                newAnnotationBuilder(holder, GleamColors.LABEL.externalName)
                    .textAttributes(GleamColors.LABEL)
                    .range(element)
                    .create()
            }
        }
    }

    private fun newAnnotation(
        holder: AnnotationHolder, element: PsiElement, textAttributesKey: TextAttributesKey
    ) {
        newAnnotationBuilder(holder, textAttributesKey.externalName)
            .textAttributes(textAttributesKey)
            .range(element)
            .create()
    }

    private fun newAnnotationBuilder(holder: AnnotationHolder, @InspectionMessage tag: String) =
        if (ApplicationManager.getApplication().isUnitTestMode)
            holder.newAnnotation(HighlightSeverity.INFORMATION, tag)
        else
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
}