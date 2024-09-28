package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class GleamRunConfiguration(project: Project, configurationFactory: ConfigurationFactory, name: String) :
    RunConfigurationBase<GleamRunConfigurationOptions>(project, configurationFactory, name) {

    public override fun getOptions(): GleamRunConfigurationOptions {
        return super.options as GleamRunConfigurationOptions
    }

    override fun getState(
        executor: Executor, environment: ExecutionEnvironment
    ): RunProfileState? = GleamRunConfigurationState(environment, this)


    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?> {
        return GleamRunConfigurationEditor(project)
    }

}