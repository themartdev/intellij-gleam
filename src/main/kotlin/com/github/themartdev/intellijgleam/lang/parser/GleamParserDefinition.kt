package com.github.themartdev.intellijgleam.lang.parser

import com.github.themartdev.intellijgleam.lang.lexer.GleamLexer
import com.github.themartdev.intellijgleam.lang.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class GleamParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = GleamLexer()

    override fun createParser(project: Project?): PsiParser = GleamParser()

    override fun getFileNodeType(): IFileElementType = GleamFileElementType

    override fun getCommentTokens(): TokenSet = GLEAM_COMMENTS

    override fun getStringLiteralElements(): TokenSet = GLEAM_STRINGS

    override fun createElement(node: ASTNode?): PsiElement = GleamTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = GleamFile(viewProvider)
}