package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.PtyCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import java.io.File

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
        val cmdLine = PtyCommandLine()
            .withExePath(configuration.getActualGleamPath())
            .withParameters("run")
            .withWorkDirectory(configuration.project.basePath)
            .withEnvironment(computeEnvironment())

        configuration.getModuleQualifier()?.let {
            cmdLine.addParameters("-m", it)
        }

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
        val erlangSdkPath = configuration.getActualErlangPath()
        val erlangBin = File(erlangSdkPath).resolve("bin").absolutePath
        if (erlangSdkPath.isNotEmpty()) {
            pathDirs.add(0, erlangBin)
        }
        return pathDirs.joinToString(File.pathSeparator)
    }

}