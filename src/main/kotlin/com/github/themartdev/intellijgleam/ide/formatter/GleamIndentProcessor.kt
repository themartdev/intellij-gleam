package com.github.themartdev.intellijgleam.ide.formatter

import com.github.themartdev.intellijgleam.lang.psi.GLEAM_BLOCKS
import com.github.themartdev.intellijgleam.lang.psi.GLEAM_BRACES
import com.github.themartdev.intellijgleam.lang.psi.GleamBlockExpr
import com.github.themartdev.intellijgleam.lang.psi.GleamCaseExprBody
import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionBody
import com.github.themartdev.intellijgleam.lang.psi.GleamTypeValue
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiFile

object GleamIndentProcessor {
    fun getIndent(node: ASTNode): Indent {
        val elementType = node.elementType
        val parent: ASTNode? = node.treeParent

        if (parent == null || parent.treeParent == null) {
            return Indent.getNoneIndent()
        }

        val parentType = parent.elementType
        if (parentType in GLEAM_BLOCKS) {
            if (elementType in GLEAM_BRACES) {
                return Indent.getNoneIndent()
            }
            return Indent.getSpaceIndent(2)
        }

        return Indent.getNoneIndent()
    }

    fun getChildIndent(node: ASTNode): Indent? {
        return when (node.psi) {
            is PsiFile -> Indent.getNoneIndent()
            is GleamFunctionBody, is GleamTypeValue, is GleamBlockExpr, is GleamCaseExprBody -> Indent.getSpaceIndent(2)
            else -> Indent.getNoneIndent()
        }
    }
}