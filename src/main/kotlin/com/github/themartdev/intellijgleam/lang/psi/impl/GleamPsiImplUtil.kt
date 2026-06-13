package com.github.themartdev.intellijgleam.lang.psi.impl

import com.github.themartdev.intellijgleam.lang.psi.*
import com.intellij.psi.PsiElement

class GleamPsiImplUtil {
    companion object {
        @JvmStatic
        fun getModuleName(gleamModulePath: GleamModulePath): PsiElement {
            return gleamModulePath.lastChild
        }

        @JvmStatic
        fun getNameOrAlias(importDeclaration: GleamImportDeclaration): PsiElement? {
            return importDeclaration.identifierDiscardable ?: importDeclaration.modulePath?.moduleName
        }

        @JvmStatic
        fun getNameOrAlias(unqualifiedImport: GleamUnqualifiedImport): PsiElement? {
            return unqualifiedImport.aliasIdentifier ?: unqualifiedImport.identifierDiscardable.actualElement
        }

        @JvmStatic
        fun getNameOrAlias(typeUnqualifiedImport: GleamTypeUnqualifiedImport): PsiElement? {
            return typeUnqualifiedImport.aliasUpIdentifier ?: typeUnqualifiedImport.upIdentifier
        }

        @JvmStatic
        fun getNameOrAlias(upUnqualifiedImport: GleamUpUnqualifiedImport): PsiElement {
            return upUnqualifiedImport.aliasUpIdentifier ?: upUnqualifiedImport.upIdentifier
        }

        @JvmStatic
        fun isDiscard(identifierDiscardable: GleamIdentifierDiscardable): Boolean {
            return identifierDiscardable.identifier == null
        }

        @JvmStatic
        fun getActualElement(identifierDiscardable: GleamIdentifierDiscardable): PsiElement? {
            return identifierDiscardable.identifier ?: identifierDiscardable.discardName
        }
    }
}