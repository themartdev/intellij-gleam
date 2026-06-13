package com.github.themartdev.intellijgleam.ide.runconf.run

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

/**
 * Runs the project test suite via `gleam test`. Output goes to a plain console: gleeunit prints
 * passing tests as bare dots (no names, no per-test events), so a structured test tree is not
 * possible. See [GleamTestOutputFilter] for making failure lines navigable.
 */
class GleamTestConfiguration(project: Project, configurationFactory: ConfigurationFactory, name: String) :
    RunConfigurationBase<GleamTestConfigurationOptions>(project, configurationFactory, name) {

    fun getActualGleamPath(): String {
        return if (getOptions().useCustomGleam) {
            getOptions().customGleamPath ?: ""
        } else {
            GleamServiceSettings.getInstance(project).gleamPath
        }
    }

    public override fun getOptions(): GleamTestConfigurationOptions {
        return super.options as GleamTestConfigurationOptions
    }

    override fun getState(
        executor: Executor, environment: ExecutionEnvironment
    ): RunProfileState = GleamTestConfigurationState(environment, this)

    @Throws(RuntimeConfigurationException::class)
    override fun checkConfiguration() {
        val gleamPath = getActualGleamPath()
        if (!FsUtils.validateGleamPath(gleamPath)) {
            throw RuntimeConfigurationException("Gleam executable is invalid: '$gleamPath'")
        }
        GleamToolchain.validateErlangSdkRoot(project)
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?> {
        return GleamTestConfigurationEditor(project)
    }
}
