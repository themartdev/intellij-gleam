package com.github.themartdev.intellijgleam.ide.formatter

import com.github.themartdev.intellijgleam.lang.psi.GLEAM_BLOCKS
import com.github.themartdev.intellijgleam.lang.psi.GLEAM_BRACES
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock

class GleamFormatBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
) : AbstractBlock(node, wrap, alignment) {
    override fun getSpacing(p0: Block?, p1: Block): Spacing? {
        TODO("Not yet implemented")
    }

    override fun isLeaf(): Boolean {
        TODO("Not yet implemented")
    }

    override fun buildChildren(): MutableList<Block> {
        val blocks = mutableListOf<Block>()
        node.getChildren(null).asSequence()
            .filter { it.elementType != TokenType.WHITE_SPACE && (it.textLength > 0) }
            .forEach { createBlocks(blocks, it) }
        return blocks
    }

    private fun createBlocks(
        blocks: MutableList<in Block>,
        child: ASTNode,
    ) {
        val childElement = child.psi

//        blocks.add(GleamFormatBlock(child, null, newAlignment, context, newChildAlignment))
    }


    // indented: blockExpr, functionBody, caseExpr, customTypeValue
    // optional indented: unqualifiedImports
    override fun getIndent(): Indent? {
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
            return Indent.getNormalIndent()
        }

        return Indent.getNoneIndent()
    }

}