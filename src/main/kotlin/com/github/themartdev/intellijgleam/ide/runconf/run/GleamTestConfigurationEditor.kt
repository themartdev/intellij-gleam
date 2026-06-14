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
import com.intellij.ui.dsl.builder.Row
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.builder.selected
import javax.swing.JComponent

class GleamTestConfigurationEditor(project: Project) : SettingsEditor<GleamTestConfiguration>() {
    // Display label "Default" maps to the empty target/runtime (let gleam.toml decide).
    private val targetLabels = listOf(GleamTarget.DEFAULT_LABEL) + GleamTarget.entries.map { it.cliValue }
    private val runtimeLabels = listOf(GleamJsRuntime.DEFAULT_LABEL) + GleamJsRuntime.entries.map { it.cliValue }

    private lateinit var targetField: Cell<ComboBox<String>>
    private lateinit var runtimeField: Cell<ComboBox<String>>
    private lateinit var runtimeRow: Row
    private val customGleamField = GleamPathComboBox(project)
    lateinit var useCustomGleam: Cell<JBCheckBox>

    override fun resetEditorFrom(s: GleamTestConfiguration) {
        val target = s.getOptions().target ?: ""
        targetField.component.selectedItem = if (target.isBlank()) GleamTarget.DEFAULT_LABEL else target
        val runtime = s.getOptions().runtime ?: ""
        runtimeField.component.selectedItem = if (runtime.isBlank()) GleamJsRuntime.DEFAULT_LABEL else runtime
        customGleamField.selectedItem = s.getOptions().customGleamPath ?: ""
        useCustomGleam.component.isSelected = s.getOptions().useCustomGleam
        updateRuntimeRowEnabled()
    }

    override fun applyEditorTo(s: GleamTestConfiguration) {
        val selected = targetField.component.selectedItem as? String ?: GleamTarget.DEFAULT_LABEL
        s.getOptions().target = if (selected == GleamTarget.DEFAULT_LABEL) "" else selected
        val runtime = runtimeField.component.selectedItem as? String ?: GleamJsRuntime.DEFAULT_LABEL
        s.getOptions().runtime = if (runtime == GleamJsRuntime.DEFAULT_LABEL) "" else runtime
        s.getOptions().customGleamPath = customGleamField.selectedItem as String
        s.getOptions().useCustomGleam = useCustomGleam.component.isSelected
    }

    override fun createEditor(): JComponent {
        loadDetectedGleamPaths()
        return panel {
            group(GleamBundle.message("gleam.configuration.editor.test.label")) {
                row(GleamBundle.message("gleam.configuration.editor.target.label")) {
                    targetField = comboBox(targetLabels)
                    targetField.component.addItemListener { updateRuntimeRowEnabled() }
                }
                runtimeRow = row(GleamBundle.message("gleam.configuration.editor.runtime.label")) {
                    runtimeField = comboBox(runtimeLabels)
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

    /** The runtime only applies to the JavaScript target. */
    private fun updateRuntimeRowEnabled() {
        val selected = targetField.component.selectedItem as? String
        runtimeRow.enabled(selected == GleamTarget.JAVASCRIPT.cliValue)
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
