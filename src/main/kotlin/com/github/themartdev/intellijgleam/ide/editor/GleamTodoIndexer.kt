package com.github.themartdev.intellijgleam.ide.editor

import com.github.themartdev.intellijgleam.lang.lexer.GleamLexer
import com.github.themartdev.intellijgleam.lang.psi.GLEAM_COMMENTS
import com.github.themartdev.intellijgleam.lang.psi.GleamFile
import com.intellij.lexer.Lexer
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.search.IndexPatternBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

/**
 * Lets `TODO`/`FIXME` patterns inside Gleam comments surface in the TODO tool window and get
 * highlighted, by exposing the comment token set to the platform's index-pattern machinery.
 */
class GleamTodoIndexer : IndexPatternBuilder {
    override fun getIndexingLexer(file: PsiFile): Lexer? =
        if (file is GleamFile) GleamLexer() else null

    override fun getCommentTokenSet(file: PsiFile): TokenSet? =
        if (file is GleamFile) GLEAM_COMMENTS else null

    override fun getCommentStartDelta(tokenType: IElementType?): Int = 0

    override fun getCommentEndDelta(tokenType: IElementType?): Int = 0
}
