package com.github.themartdev.intellijgleam.ide.actions

import com.github.themartdev.intellijgleam.ide.common.GleamProject
import com.github.themartdev.intellijgleam.ide.lsp.GleamLanguageServerManager
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAware

/**
 * Manual "Restart Gleam Language Server" entry point (Tools menu). Lets the user recover from a
 * wedged but not-yet-crashed `gleam lsp` — the case the crash notification can't catch because the
 * process is still alive but no longer serving requests.
 */
class RestartGleamLanguageServerAction : AnAction(), DumbAware {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        GleamLanguageServerManager.restart(project)
    }

    override fun update(e: AnActionEvent) {
        val project = e.project
        e.presentation.isEnabledAndVisible = project != null && GleamProject.isGleamProject(project)
    }

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT
}
