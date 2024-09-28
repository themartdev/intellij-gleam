package com.github.themartdev.intellijgleam.ide.common

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.CapturingProcessHandler
import com.intellij.execution.process.ProcessOutput

private val LOG = com.intellij.openapi.diagnostic.Logger.getInstance(PsUtil::class.java)

object PsUtil {
    fun runAndGetOutput(vararg command: String, timeout: Int = 3000): ProcessOutput? {
        try {
            val cmdLine = GeneralCommandLine(*command)
            val processHandler = CapturingProcessHandler(cmdLine)
            val processOutput = processHandler.runProcess(timeout)
            if (processOutput.isCancelled || processOutput.isTimeout || processOutput.exitCode != 0) {
                return null
            }
            return processOutput
        } catch (e: Exception) {
            LOG.warn("Failed to run command: ${command.joinToString(" ")}", e)
            return null
        }
    }
}