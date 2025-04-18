package com.github.themartdev.intellijgleam.ide.formatter

import com.github.themartdev.intellijgleam.lang.psi.GleamTypes
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock

class GleamFormatBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    private val context: GleamFormatBlockContext
) : AbstractBlock(node, wrap, alignment) {
    private val spacingProcessor = GleamSpacingProcessor(this, context)
    private val indentProcessor = GleamIndentProcessor()

    private var subBlocks: List<Block>? = null

    override fun buildChildren(): List<Block> {
        if (subBlocks == null) {
            val blocks = mutableListOf<Block>()
            var child = node.firstChildNode
            while (child != null) {
                if (child.elementType != TokenType.WHITE_SPACE) {
                    val childBlock = GleamFormatBlock(
                        child,
                        null,
                        null,
                        context
                    )
                    blocks.add(childBlock)
                }
                child = child.treeNext
            }
            subBlocks = if (blocks.isNotEmpty()) blocks else EMPTY
        }
        return subBlocks!!
    }

    override fun getIndent(): Indent? {
        return indentProcessor.getChildIndent(node)
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingProcessor.createSpacing(child1, child2)
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        val parentType = node.elementType

        val indent = when {
            parentType == GleamTypes.FUNCTION_BODY ||
                    parentType == GleamTypes.BLOCK_EXPR ||
                    parentType == GleamTypes.CASE_EXPR_BODY ||
                    parentType == GleamTypes.CUSTOM_TYPE -> Indent.getNormalIndent()

            else -> Indent.getNoneIndent()
        }

        return ChildAttributes(indent, null)
    }

    override fun isLeaf(): Boolean = node.firstChildNode == null

    companion object {
        private val EMPTY = emptyList<Block>()
    }
}
