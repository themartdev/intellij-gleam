package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.colors.CodeInsightColors
import com.redhat.devtools.lsp4ij.LSPIJUtils
import com.redhat.devtools.lsp4ij.client.features.LSPDiagnosticFeature
import org.eclipse.lsp4j.Diagnostic

private val LOG = Logger.getInstance(GleamLSPDiagnosticFeature::class.java)

class GleamLSPDiagnosticFeature : LSPDiagnosticFeature() {

    override fun createAnnotation(
        diagnostic: Diagnostic,
        document: Document,
        fixes: List<IntentionAction?>,
        holder: AnnotationHolder
    ) {
        val isUnused = diagnostic.message.startsWith("Unused variable") ||
                diagnostic.message.startsWith("Unused imported module")
        if (isUnused) {
            unusedAnnotation(diagnostic, document, fixes, holder)
            return
        }

        val isUnusedHint = diagnostic.message.startsWith("You can safely remove it.")
                || diagnostic.message.startsWith("You can ignore it with an underscore")
        if (isUnusedHint) {
            return
        }

        super.createAnnotation(diagnostic, document, fixes, holder)
    }

    private fun unusedAnnotation(
        diagnostic: Diagnostic,
        document: Document,
        fixes: List<IntentionAction?>,
        holder: AnnotationHolder
    ) {
        val range = LSPIJUtils.toTextRange(diagnostic.range, document, null, true);
        if (range != null) {
            val severity = HighlightSeverity.TEXT_ATTRIBUTES
            val message = this.getMessage(diagnostic);
            val builder = holder
                .newAnnotation(severity, message)
                .tooltip(this.getTooltip(diagnostic))
                .textAttributes(CodeInsightColors.NOT_USED_ELEMENT_ATTRIBUTES)
                .range(range);
            if (range.startOffset == range.endOffset) {
                builder.afterEndOfLine();
            }

            val highlightType = this.getProblemHighlightType(diagnostic.getTags());
            if (highlightType != null) {
                builder.highlightType(highlightType);
            }

            val iter = fixes.iterator();

            while (iter.hasNext()) {
                val fix = iter.next() as IntentionAction;
                builder.withFix(fix);
            }

            builder.create();
        }
    }

    private fun prettyPrintDiagnostic(diagnostic: Diagnostic): String =
        "Diagnostic[${diagnostic.code}, ${diagnostic.data}, ${diagnostic.severity}, ${diagnostic.tags}, ${diagnostic.message}]"
}