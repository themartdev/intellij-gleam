package com.github.themartdev.intellijgleam.ide.formatter.lsp

import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.intellij.formatting.FormattingRangesInfo
import com.intellij.formatting.service.FormattingService
import com.intellij.lang.ImportOptimizer
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.redhat.devtools.lsp4ij.LanguageServerWrapper
import com.redhat.devtools.lsp4ij.LanguageServersRegistry
import com.redhat.devtools.lsp4ij.LanguageServiceAccessor
import com.redhat.devtools.lsp4ij.features.formatting.AbstractLSPFormattingService
import org.eclipse.lsp4j.ServerCapabilities
import java.util.function.Predicate

/**
 * Taken from https://github.com/FalsePattern/ZigBrains/blob/master/modules/zig/src/main/java/com/falsepattern/zigbrains/zig/formatter/ZigAbstractLSPFormattingServiceProxy.java
 * TODO: Remove once https://github.com/redhat-developer/lsp4ij/issues/424 is fixed
 */
abstract class GleamAbstractLspFormattingServiceProxy : FormattingService {
    protected abstract fun getProxiedService(): AbstractLSPFormattingService
    protected abstract fun canSupportFormatting(serverCapabilities: ServerCapabilities?): Boolean

    override fun getFeatures(): MutableSet<FormattingService.Feature?> {
        return getProxiedService().features
    }

    override fun canFormat(file: PsiFile): Boolean {
        if (file.language != GleamLanguage) return false

        if (!LanguageServersRegistry.getInstance().isFileSupported(file)) {
            return false
        } else {
            val project = file.project
            return LanguageServiceAccessor.getInstance(project).hasAny(
                file.virtualFile,
                Predicate { ls: LanguageServerWrapper? -> this.canSupportFormatting(ls?.serverCapabilitiesSync) })
        }
    }

    override fun formatElement(psiElement: PsiElement, b: Boolean): PsiElement {
        return getProxiedService().formatElement(psiElement, b)
    }

    override fun formatElement(psiElement: PsiElement, textRange: TextRange, b: Boolean): PsiElement {
        return getProxiedService().formatElement(psiElement, textRange, b)
    }

    override fun formatRanges(psiFile: PsiFile, formattingRangesInfo: FormattingRangesInfo, b: Boolean, b1: Boolean) {
        getProxiedService().formatRanges(psiFile, formattingRangesInfo, b, b1)
    }

    override fun getImportOptimizers(psiFile: PsiFile): MutableSet<ImportOptimizer?> {
        return getProxiedService().getImportOptimizers(psiFile)
    }
}
