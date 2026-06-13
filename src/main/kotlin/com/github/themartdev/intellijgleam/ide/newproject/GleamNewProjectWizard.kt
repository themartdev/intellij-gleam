package com.github.themartdev.intellijgleam.ide.newproject

import com.github.themartdev.intellijgleam.GleamBundle
import com.github.themartdev.intellijgleam.GleamIcons
import com.github.themartdev.intellijgleam.ide.common.GleamExecutableFinder
import com.github.themartdev.intellijgleam.ide.ui.components.GleamPathComboBox
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.CapturingProcessHandler
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.ide.wizard.*
import com.intellij.ide.wizard.NewProjectWizardBaseData.Companion.baseData
import com.intellij.ide.wizard.NewProjectWizardChainStep.Companion.nextStep
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.bindItem
import java.io.File
import javax.swing.Icon

private val LOG = logger<GleamNewProjectWizard>()

/** The `gleam new --template` choices. */
enum class GleamTemplate(val cliValue: String, private val label: String) {
    ERLANG("erlang", "Erlang"),
    JAVASCRIPT("javascript", "JavaScript");

    override fun toString(): String = label
}

/**
 * Adds "Gleam" to the New Project dialog. The project is scaffolded by delegating to
 * `gleam new` (rather than templating files ourselves), keeping the layout in lockstep with
 * whatever Gleam version the user has installed.
 */
class GleamNewProjectWizard : GeneratorNewProjectWizard {
    override val id: String = "Gleam"
    override val name: String = "Gleam"
    override val icon: Icon = GleamIcons.GLEAM

    override fun createStep(context: WizardContext): NewProjectWizardStep =
        RootNewProjectWizardStep(context)
            .nextStep(::NewProjectWizardBaseStep)
            .nextStep(::GleamNewProjectWizardStep)
}

class GleamNewProjectWizardStep(parent: NewProjectWizardStep) : AbstractNewProjectWizardStep(parent) {

    private val templateProperty = propertyGraph.property(GleamTemplate.ERLANG)

    private val gleamPathComboBox = GleamPathComboBox(context.project).apply {
        val paths = GleamExecutableFinder.findGleamExecutablePaths()
        addItems(paths)
        selectedPath = paths.firstOrNull()
    }

    override fun setupUI(builder: Panel) {
        with(builder) {
            row(GleamBundle.message("gleam.newProject.target.label")) {
                comboBox(GleamTemplate.entries)
                    .bindItem(templateProperty)
            }
            row(GleamBundle.message("gleam.newProject.gleamPath.label")) {
                cell(gleamPathComboBox)
                    .align(AlignX.FILL)
                    .validationOnApply {
                        val path = it.selectedPath
                        when {
                            path.isNullOrBlank() -> error(GleamBundle.message("gleam.newProject.gleamPath.required"))
                            !File(path).exists() -> error(GleamBundle.message("gleam.newProject.gleamPath.invalid"))
                            else -> null
                        }
                    }
            }
        }
    }

    override fun setupProject(project: Project) {
        val root = project.basePath ?: run {
            LOG.warn("Cannot scaffold Gleam project: project base path is null")
            return
        }
        val command = GeneralCommandLine(
            (gleamPathComboBox.selectedPath ?: "gleam").trim(),
            "new", root,
            "--name", sanitizePackageName(baseData?.name ?: project.name),
            "--template", templateProperty.get().cliValue,
            "--skip-github",
        )
        try {
            val output = CapturingProcessHandler(command).runProcess(30_000)
            if (output.exitCode != 0) {
                LOG.warn("`gleam new` failed (exit ${output.exitCode}): ${output.stderr.trim()}")
            }
        } catch (e: Exception) {
            LOG.warn("Failed to run `gleam new`", e)
        }
        VfsUtil.markDirtyAndRefresh(false, true, true, File(root))
    }
}

/**
 * Coerces an IDE project name into a valid Gleam package name: lowercase, `[a-z0-9_]` only, not
 * starting with a digit. Gleam package names are snake_case, so this usually leaves the name
 * untouched.
 */
internal fun sanitizePackageName(raw: String): String {
    val cleaned = raw.lowercase()
        .map { if (it in 'a'..'z' || it in '0'..'9' || it == '_') it else '_' }
        .joinToString("")
        .trim('_')
        .ifEmpty { "app" }
    return if (cleaned.first() in '0'..'9') "app_$cleaned" else cleaned
}
