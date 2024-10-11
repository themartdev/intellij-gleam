package com.github.themartdev.intellijgleam.ide.formatter

import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.formatter.common.AbstractBlock

@Suppress("unused")
class GleamSpacingProcessor(
    private val block: AbstractBlock,
    context: GleamFormatBlockContext
) {
    private val spacingBuilder = SpacingBuilder(context.commonSettings)

    fun createSpacing(block1: Block?, block2: Block?): Spacing? {
        return null
    }
}
