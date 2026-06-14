package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.PtyCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment

class GleamTestConfigurationState(
    environment: ExecutionEnvironment,
    private val configuration: GleamTestConfiguration
) : CommandLineState(environment) {

    init {
        // Make `test: <module>.<function>` failure lines from gleeunit clickable.
        addConsoleFilters(GleamTestOutputFilter(environment.project))
    }

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
            .withParameters(gleamTestParameters(options.target, options.runtime))
            .withWorkDirectory(configuration.project.basePath)
            .withEnvironment(GleamToolchain.environmentForTarget(configuration.project, options.target))
    }

    companion object {
        /** Builds the `gleam` arguments for a test run. `--target` and `--runtime` are added only when set. */
        fun gleamTestParameters(target: String?, runtime: String? = null): List<String> {
            val params = mutableListOf("test")
            target?.takeIf { it.isNotBlank() }?.let { params += listOf("--target", it) }
            runtime?.takeIf { it.isNotBlank() }?.let { params += listOf("--runtime", it) }
            return params
        }
    }
}
