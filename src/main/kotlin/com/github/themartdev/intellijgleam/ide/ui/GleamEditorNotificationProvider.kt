package com.github.themartdev.intellijgleam.ide.ui

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.github.themartdev.intellijgleam.lang.GleamFileType
import com.intellij.CommonBundle
import com.intellij.ide.actions.ShowSettingsUtilImpl
import com.intellij.openapi.editor.colors.EditorColors
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotificationProvider
import kotlinx.coroutines.Runnable
import java.util.function.Function
import javax.swing.JComponent

class GleamEditorNotificationProvider : EditorNotificationProvider, DumbAware {

    override fun collectNotificationData(
        project: Project,
        file: VirtualFile
    ): Function<in FileEditor, out JComponent?>? {
        if (file.fileType != GleamFileType) return null


        val settings = GleamServiceSettings.getInstance(project)
        if (settings.gleamPath.isNotEmpty() && settings.erlangPath.isNotEmpty()) return null

        return Function {
            object : EditorNotificationPanel(EditorColors.GUTTER_BACKGROUND, Status.Info) {
                init {
                    text = GleamBundle.message("gleam.editor.sdk.configure.message")
                    createActionLabel(
                        CommonBundle.message("action.text.configure.ellipsis"),
                        Runnable { ShowSettingsUtilImpl.showSettingsDialog(project, "language", null) }
                    )
                }
            }
        }
    }
}