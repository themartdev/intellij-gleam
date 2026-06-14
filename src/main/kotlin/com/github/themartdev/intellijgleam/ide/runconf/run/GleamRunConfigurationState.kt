package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.PtyCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.github.themartdev.intellijgleam.ide.common.GleamProject
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment

class GleamRunConfigurationState(
    environment: ExecutionEnvironment,
    private val configuration: GleamRunConfiguration
) : CommandLineState(environment) {
    override fun startProcess(): ProcessHandler {
        val cmdLine = buildCommandLine()
        val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(cmdLine)
        ProcessTerminatedListener.attach(processHandler)
        return processHandler
    }

    private fun buildCommandLine(): GeneralCommandLine {
        val options = configuration.getOptions()
        return PtyCommandLine()
            .withExePath(configuration.getActualGleamPath())
            .withParameters(gleamRunParameters(configuration.getModuleQualifier(), options.target, options.runtime))
            .withWorkDirectory(GleamProject.rootPath(configuration.project) ?: configuration.project.basePath)
            .withEnvironment(GleamToolchain.environmentForTarget(configuration.project, options.target))
    }

    companion object {
        /** Builds the `gleam` arguments for a run. `-m`, `--target` and `--runtime` are added only when set. */
        fun gleamRunParameters(moduleQualifier: String?, target: String?, runtime: String?): List<String> {
            val params = mutableListOf("run")
            moduleQualifier?.takeIf { it.isNotBlank() }?.let { params += listOf("-m", it) }
            target?.takeIf { it.isNotBlank() }?.let { params += listOf("--target", it) }
            runtime?.takeIf { it.isNotBlank() }?.let { params += listOf("--runtime", it) }
            return params
        }
    }
}
