package com.github.themartdev.intellijgleam.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock

class GleamFormatBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
) : AbstractBlock(node, wrap, alignment) {
    private val currentIndent = GleamIndentProcessor.getIndent(node)

    override fun getSpacing(p0: Block?, p1: Block): Spacing? {
        return null
    }

    override fun isLeaf(): Boolean {
        return node.firstChildNode == null
    }

    override fun buildChildren(): MutableList<Block> {
        val blocks = mutableListOf<Block>()
        for (child in node.getChildren(null)) {
            if (child.elementType != TokenType.WHITE_SPACE) {
                processBlock(blocks, child)
            }
        }
        return blocks
    }

    private fun processBlock(blocks: MutableList<Block>, child: ASTNode) {
        blocks.add(GleamFormatBlock(child, wrap, alignment))
    }


    override fun getIndent(): Indent = currentIndent

    override fun getChildIndent(): Indent? = GleamIndentProcessor.getChildIndent(node)

}