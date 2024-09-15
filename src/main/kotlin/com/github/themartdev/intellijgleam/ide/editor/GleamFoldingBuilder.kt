package com.github.themartdev.intellijgleam.ide.editor

import com.github.themartdev.intellijgleam.lang.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveElementWalkingVisitor

class GleamFoldingBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(
        root: PsiElement,
        document: Document,
        quick: Boolean
    ): Array<FoldingDescriptor> {
        val descriptors = mutableListOf<FoldingDescriptor>()
        root.accept(GleamFoldingVisitor(descriptors, document))
        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String? {
        val element = node.psi
        return when (element) {
            is GleamFunctionBody,
            is GleamBlockExpr,
            is GleamCaseExprBody,
            is GleamTypeValue -> "{...}"
            else -> "..."
        }
    }

    override fun isCollapsedByDefault(node: ASTNode) = false

    private class GleamFoldingVisitor(
        private val descriptors: MutableList<FoldingDescriptor>,
        private val document: Document
    ) : PsiRecursiveElementWalkingVisitor() {

        override fun visitElement(element: PsiElement) {
            super.visitElement(element)
            when (element) {
                is GleamFunctionBody,
                is GleamBlockExpr,
                is GleamCaseExprBody -> addFoldingDescriptor(element)
                is GleamTypeValue -> addFoldingDescriptorIfApplicable(element)
            }
        }

        private fun addFoldingDescriptor(element: PsiElement) {
            val range = element.textRange
            if (range.length > 2) {
                descriptors.add(FoldingDescriptor(element.node, range))
            }
        }

        private fun addFoldingDescriptorIfApplicable(element: PsiElement) {
            val range = element.textRange
            val startLine = document.getLineNumber(range.startOffset)
            val endLine = document.getLineNumber(range.endOffset)
            if (endLine > startLine) {
                descriptors.add(FoldingDescriptor(element.node, range))
            }
        }
    }
}
