package com.github.themartdev.intellijgleam.ide.runconf.run

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.ide.common.GleamExecutableFinder
import com.github.themartdev.intellijgleam.ide.ui.components.GleamPathComboBox
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.Cell
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.builder.selected
import javax.swing.JComponent

class GleamTestConfigurationEditor(project: Project) : SettingsEditor<GleamTestConfiguration>() {
    // Display label "Default" maps to the empty target (let gleam.toml decide).
    private val defaultLabel = "Default"
    private val targetLabels = listOf(defaultLabel, "erlang", "javascript")

    private lateinit var targetField: Cell<ComboBox<String>>
    private val customGleamField = GleamPathComboBox(project)
    lateinit var useCustomGleam: Cell<JBCheckBox>

    override fun resetEditorFrom(s: GleamTestConfiguration) {
        val target = s.getOptions().target ?: ""
        targetField.component.selectedItem = if (target.isBlank()) defaultLabel else target
        customGleamField.selectedItem = s.getOptions().customGleamPath ?: ""
        useCustomGleam.component.isSelected = s.getOptions().useCustomGleam
    }

    override fun applyEditorTo(s: GleamTestConfiguration) {
        val selected = targetField.component.selectedItem as? String ?: defaultLabel
        s.getOptions().target = if (selected == defaultLabel) "" else selected
        s.getOptions().customGleamPath = customGleamField.selectedItem as String
        s.getOptions().useCustomGleam = useCustomGleam.component.isSelected
    }

    override fun createEditor(): JComponent {
        loadDetectedGleamPaths()
        return panel {
            group(GleamBundle.message("gleam.configuration.editor.test.label")) {
                row(GleamBundle.message("gleam.configuration.editor.target.label")) {
                    targetField = comboBox(targetLabels)
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
            val pathItems = detectedGleamPaths.map { it.path }
            ApplicationManager.getApplication().invokeLater({
                customGleamField.addItems(pathItems)
            }, modalityState)
        }
    }
}
