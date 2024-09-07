package com.github.themartdev.intellijgleam.lang.psi.impl

import com.github.themartdev.intellijgleam.lang.psi.GleamImportDeclaration
import com.github.themartdev.intellijgleam.lang.psi.GleamModulePath
import com.github.themartdev.intellijgleam.lang.psi.GleamTypeUnqualifiedImport
import com.github.themartdev.intellijgleam.lang.psi.GleamUnqualifiedImport
import com.intellij.psi.PsiElement

class GleamPsiImplUtil {
    companion object {
        @JvmStatic
        fun getModuleName(gleamModulePath: GleamModulePath): PsiElement {
            return gleamModulePath.lastChild;
        }

        @JvmStatic
        fun getNameOrAlias(importDeclaration: GleamImportDeclaration): PsiElement? {
            return importDeclaration.identifier ?: importDeclaration.modulePath?.moduleName
        }

        @JvmStatic
        fun getNameOrAlias(unqualifiedImport: GleamUnqualifiedImport): PsiElement? {
            return unqualifiedImport.aliasIdentifier ?: unqualifiedImport.identifier
        }

        @JvmStatic
        fun getNameOrAlias(typeUnqualifiedImport: GleamTypeUnqualifiedImport): PsiElement? {
            return typeUnqualifiedImport.aliasUpIdentifier ?: typeUnqualifiedImport.upIdentifier
        }

//        @JvmStatic
//        fun getAlias(importMixin: GleamImportMixin): String? {
//            return gleamModulePath.moduleName
//        }
    }
}