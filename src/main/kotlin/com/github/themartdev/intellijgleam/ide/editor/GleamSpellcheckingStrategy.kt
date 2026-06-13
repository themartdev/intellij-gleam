package com.github.themartdev.intellijgleam.ide.editor

import com.github.themartdev.intellijgleam.lang.psi.GleamTypes
import com.intellij.psi.PsiElement
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy
import com.intellij.spellchecker.tokenizer.Tokenizer

/**
 * Spellchecks the natural-language content of Gleam sources: comments (line and doc) and the
 * textual parts of string literals. Everything else falls back to the platform default.
 */
class GleamSpellcheckingStrategy : SpellcheckingStrategy() {
    override fun getTokenizer(element: PsiElement): Tokenizer<*> {
        return when (element.node?.elementType) {
            GleamTypes.LINE_COMMENT,
            GleamTypes.FUNCTION_COMMENT,
            GleamTypes.MODULE_COMMENT,
            GleamTypes.REGULAR_STRING_PART -> TEXT_TOKENIZER

            else -> super.getTokenizer(element)
        }
    }
}
