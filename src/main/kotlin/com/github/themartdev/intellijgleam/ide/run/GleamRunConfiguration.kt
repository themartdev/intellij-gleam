package com.github.themartdev.intellijgleam.ide.run

import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.execution.Executor
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.PtyCommandLine
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.File

val LOG = com.intellij.openapi.diagnostic.Logger.getInstance(GleamRunConfiguration::class.java)

class GleamRunConfiguration(project: Project, configurationFactory: ConfigurationFactory, name: String) :
    RunConfigurationBase<GleamRunConfigurationOptions>(project, configurationFactory, name) {

    public override fun getOptions(): GleamRunConfigurationOptions {
        return super.options as GleamRunConfigurationOptions
    }

    override fun getState(
        executor: Executor, environment: ExecutionEnvironment
    ): RunProfileState? {
        return (object : CommandLineState(environment) {
            override fun startProcess(): ProcessHandler {
                val cmdLine = buildCommandLine()
                val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(cmdLine)
                ProcessTerminatedListener.attach(processHandler)
                return processHandler
            }
        })
    }

    private fun buildCommandLine(): GeneralCommandLine {
        val cmdLine = PtyCommandLine()
            .withExePath(computeGleamPath())
            .withParameters("run", options.modulePath ?: "")
            .withWorkDirectory(project.basePath)
            .withEnvironment(computeEnvironment())
        return cmdLine
    }

    private fun computeEnvironment(): Map<String, String> {
        val env = System.getenv().toMutableMap()
        val currentPath = env["PATH"] ?: ""
        env.put("PATH", adjustPathWithErlang(currentPath))
        return env
    }

    private fun adjustPathWithErlang(path: String): String {
        val pathDirs = path.split(File.pathSeparator).toMutableList()
        val erlangSdkPath = GleamServiceSettings.getInstance(project).erlangPath
        val erlangBin = File(erlangSdkPath).resolve("bin").absolutePath
        if (erlangSdkPath.isNotEmpty()) {
            pathDirs.add(0, erlangBin)
        }
        return pathDirs.joinToString(File.pathSeparator)
    }

    private fun computeGleamPath(): String {
        return if (options.useCustomGleam) {
            LOG.info("Using custom gleam path: ${options.customGleamPath}")
            options.customGleamPath ?: ""
        } else {
            LOG.info("Using default gleam path: ${GleamServiceSettings(project).gleamPath}")
            GleamServiceSettings.getInstance(project).gleamPath
        }
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?> {
        return GleamRunConfigurationEditor(project)
    }

}