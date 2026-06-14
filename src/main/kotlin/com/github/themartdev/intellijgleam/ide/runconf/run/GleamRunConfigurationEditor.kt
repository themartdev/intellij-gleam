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

class GleamRunConfigurationEditor(project: Project) : SettingsEditor<GleamRunConfiguration>() {
    private val modulePathField = GleamModulePathSelect(project)
    private val customGleamField = GleamPathComboBox(project)
    lateinit var useCustomGleam: Cell<JBCheckBox>

    // Display label "Default" maps to the empty target/runtime (let gleam.toml decide).
    private val targetLabels = listOf(GleamTarget.DEFAULT_LABEL) + GleamTarget.entries.map { it.cliValue }
    private val runtimeLabels = listOf(GleamJsRuntime.DEFAULT_LABEL) + GleamJsRuntime.entries.map { it.cliValue }

    private lateinit var targetField: Cell<ComboBox<String>>
    private lateinit var runtimeField: Cell<ComboBox<String>>
    private lateinit var runtimeRow: Row

    override fun resetEditorFrom(s: GleamRunConfiguration) {
        modulePathField.text = s.options.filePath ?: ""
        val target = s.getOptions().target ?: ""
        targetField.component.selectedItem = if (target.isBlank()) GleamTarget.DEFAULT_LABEL else target
        val runtime = s.getOptions().runtime ?: ""
        runtimeField.component.selectedItem = if (runtime.isBlank()) GleamJsRuntime.DEFAULT_LABEL else runtime
        customGleamField.selectedItem = s.options.customGleamPath ?: ""
        useCustomGleam.component.isSelected = s.options.useCustomGleam
        updateRuntimeRowEnabled()
    }

    override fun applyEditorTo(s: GleamRunConfiguration) {
        s.options.filePath = modulePathField.text
        val target = targetField.component.selectedItem as? String ?: GleamTarget.DEFAULT_LABEL
        s.getOptions().target = if (target == GleamTarget.DEFAULT_LABEL) "" else target
        val runtime = runtimeField.component.selectedItem as? String ?: GleamJsRuntime.DEFAULT_LABEL
        s.getOptions().runtime = if (runtime == GleamJsRuntime.DEFAULT_LABEL) "" else runtime
        s.options.customGleamPath = customGleamField.selectedItem as String
        s.options.useCustomGleam = useCustomGleam.component.isSelected
    }

    override fun createEditor(): JComponent {
        loadDetectedGleamPaths()
        return panel {
            group(GleamBundle.message("gleam.configuration.editor.run.label")) {
                row(GleamBundle.message("gleam.configuration.editor.modulePath.label")) {
                    cell(modulePathField).align(AlignX.FILL)
                }
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
            val pathItems = detectedGleamPaths.map { it -> it.path }
            ApplicationManager.getApplication().invokeLater({
                customGleamField.addItems(pathItems)
            }, modalityState)
        }
    }
}
