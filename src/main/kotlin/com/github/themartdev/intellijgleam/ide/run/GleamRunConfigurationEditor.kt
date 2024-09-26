package com.github.themartdev.intellijgleam.ide.run

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.common.GleamExecutableFinder
import com.github.themartdev.intellijgleam.ide.ui.components.GleamPathComboBox
import com.github.themartdev.intellijgleam.ide.ui.components.PathItem
import com.github.themartdev.intellijgleam.ide.ui.components.fromExecutable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.Cell
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.builder.selected
import javax.swing.JComponent

class GleamRunConfigurationEditor(project: Project) : SettingsEditor<GleamRunConfiguration>() {
    private val modulePathField = GleamModulePathSelect(project)
    private val customGleamField = GleamPathComboBox(project)
    lateinit var useCustomGleam: Cell<JBCheckBox>

    override fun resetEditorFrom(s: GleamRunConfiguration) {
        modulePathField.text = s.options.modulePath ?: ""
        customGleamField.selectedPath = s.options.customGleamPath ?: ""
        useCustomGleam.component.isSelected = s.options.useCustomGleam
    }

    override fun applyEditorTo(s: GleamRunConfiguration) {
        s.options.modulePath = modulePathField.text
        s.options.customGleamPath = customGleamField.selectedPath
        s.options.useCustomGleam = useCustomGleam.component.isSelected
    }

    override fun createEditor(): JComponent {
        loadDetectedGleamPaths()
        return panel {
            group(GleamBundle.message("gleam.configuration.editor.run.label")) {
                row(GleamBundle.message("gleam.configuration.editor.modulePath.label")) {
                    cell(modulePathField).align(AlignX.FILL)
                }
            }
            group(GleamBundle.message("gleam.configuration.editor.sdk.label")) {
                row {
                    useCustomGleam =
                        checkBox(GleamBundle.message("gleam.configuration.editor.customGleam.checkbox.label"))
                }
                row(GleamBundle.message("gleam.configuration.editor.customGleamPath.label")) {
                    cell(customGleamField).align(AlignX.FILL)
                }.enabledIf(useCustomGleam.selected)
            }
        }
    }

    private fun loadDetectedGleamPaths() {
        val modalityState = ModalityState.current()
        ApplicationManager.getApplication().executeOnPooledThread {
            val detectedGleamPaths = GleamExecutableFinder.findGleamInstalls()
            val pathItems = detectedGleamPaths.map { PathItem.Value.fromExecutable(it) }
            ApplicationManager.getApplication().invokeLater({
                customGleamField.addItems(pathItems)
            }, modalityState);
        }
    }
}