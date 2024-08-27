package com.github.themartdev.intellijgleam.lang.psi.impl

import com.github.themartdev.intellijgleam.lang.psi.GleamElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

open class GleamElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), GleamElement
