package com.github.themartdev.intellijgleam.ide.run

import com.github.themartdev.intellijgleam.lang.GleamFileType
import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionDeclaration
import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionNameDefinition
import com.github.themartdev.intellijgleam.lang.psi.GleamTypes
import com.intellij.execution.lineMarker.ExecutorAction
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

class GleamRunLineMarker : RunLineMarkerContributor(), DumbAware {

    override fun getInfo(element: PsiElement): Info? {
        if (element.containingFile.fileType !is GleamFileType) return null
        if (element.containingFile.name.endsWith("_test.gleam")) return null
        if (element.elementType != GleamTypes.IDENTIFIER) return null
        if (element.text != "main") return null
        if (element.parent !is GleamFunctionNameDefinition) return null
        val declaration = element.parent.parent as? GleamFunctionDeclaration ?: return null
        if (declaration.visibilityModifier?.text != "pub") return null

        val actions = ExecutorAction.getActions(0)

        return Info(
            AllIcons.RunConfigurations.TestState.Run,
            actions,
        )
    }
}
