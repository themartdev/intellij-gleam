package com.github.themartdev.intellijgleam.ide.runconf.run

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.github.themartdev.intellijgleam.ide.common.GleamProjectUtils
import com.github.themartdev.intellijgleam.ide.common.validateErlangSdkShape
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.File
import kotlin.io.path.Path
import kotlin.jvm.Throws

class GleamRunConfiguration(project: Project, configurationFactory: ConfigurationFactory, name: String) :
    RunConfigurationBase<GleamRunConfigurationOptions>(project, configurationFactory, name) {

    fun getActualGleamPath(): String {
        return if (options.useCustomGleam) {
            options.customGleamPath ?: ""
        } else {
            GleamServiceSettings.getInstance(project).gleamPath
        }
    }

    fun getActualErlangPath(): String {
        return GleamServiceSettings.getInstance(project).erlangPath
    }

    fun getModuleQualifier(): String? {
        val srcDir = GleamProjectUtils.getSrcDir(project) ?: return ""
        val fp = options.filePath ?: return null
        return fp.removePrefix(srcDir + File.separator).removeSuffix(".gleam").replace(File.separator, "/")
    }

    public override fun getOptions(): GleamRunConfigurationOptions {
        return super.options as GleamRunConfigurationOptions
    }

    override fun getState(
        executor: Executor, environment: ExecutionEnvironment
    ): RunProfileState? = GleamRunConfigurationState(environment, this)

    @Throws(RuntimeConfigurationException::class)
    override fun checkConfiguration() {
        val gleamPath = getActualGleamPath()
        if (!FsUtils.validateGleamPath(gleamPath)) {
            throw RuntimeConfigurationException("Gleam executable is invalid: '$gleamPath'")
        }

        val erlangPath = getActualErlangPath()
        if (!validateErlangSdkShape(Path(erlangPath))) {
            throw RuntimeConfigurationException("Erlang executable is invalid: '$erlangPath'")
        }
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?> {
        return GleamRunConfigurationEditor(project)
    }

}