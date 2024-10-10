package com.github.themartdev.intellijgleam.ide.actions

import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.InputValidatorEx
import com.intellij.openapi.util.NlsContexts
import com.intellij.psi.PsiDirectory
import org.jetbrains.annotations.NonNls

private const val DIALOG_TITLE = "Create new Gleam file"
private const val ACTION_TEXT = "Gleam File"

class CreateGleamFileAction : CreateFileFromTemplateAction(ACTION_TEXT, DIALOG_TITLE, GleamIcons.GLEAM) {
    override fun buildDialog(
        project: Project,
        directory: PsiDirectory,
        builder: CreateFileFromTemplateDialog.Builder
    ) {
        builder
            .setTitle(DIALOG_TITLE)
            .addKind("Empty file", GleamIcons.GLEAM, "Gleam Module")
            .setValidator(GleamFileValidator)
    }

    override fun getActionName(
        directory: PsiDirectory?,
        newName: @NonNls String,
        templateName: @NonNls String?
    ): @NlsContexts.Command String? {
        return "Create Gleam file $newName"
    }
}

private object GleamFileValidator : InputValidatorEx {
    override fun checkInput(inputString: String?): Boolean = getErrorText(inputString) == null

    override fun canClose(inputString: String?): Boolean = getErrorText(inputString) == null

    override fun getErrorText(inputString: @NonNls String?): @NlsContexts.DetailedDescription String? {
        if (inputString == null || inputString.isEmpty()) {
            return "Name must not be empty"
        }

        return null
    }
}