package com.github.themartdev.intellijgleam.ide.formatter

import com.github.themartdev.intellijgleam.lang.psi.*
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode

class GleamIndentProcessor {
    fun getChildIndent(node: ASTNode): Indent? {
        val elementType = node.elementType
        val parent = node.treeParent
        val parentType = parent?.elementType

        if (parent == null) {
            return Indent.getNoneIndent()
        }

        if (parentType == GleamTypes.FUNCTION_BODY ||
            parentType == GleamTypes.BLOCK_EXPR ||
            parentType == GleamTypes.CASE_EXPR_BODY ||
            parentType == GleamTypes.CUSTOM_TYPE_VALUE
        ) {
            return if (elementType == GleamTypes.RBRACE || elementType == GleamTypes.LBRACE) {
                Indent.getNoneIndent()
            } else {
                Indent.getNormalIndent()
            }
        }

        return Indent.getNoneIndent()
    }
}
