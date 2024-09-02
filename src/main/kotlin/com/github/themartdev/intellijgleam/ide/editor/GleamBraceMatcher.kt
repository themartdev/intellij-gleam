package com.github.themartdev.intellijgleam.ide.editor

import com.github.themartdev.intellijgleam.lang.psi.GleamTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class GleamBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = BRACES

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int = openingBraceOffset
}

private val BRACES = arrayOf(
    BracePair(GleamTypes.LBRACE, GleamTypes.RBRACE, true),
    BracePair(GleamTypes.LBRACK, GleamTypes.RBRACK, false),
    BracePair(GleamTypes.LPAREN, GleamTypes.RPAREN, false),
)