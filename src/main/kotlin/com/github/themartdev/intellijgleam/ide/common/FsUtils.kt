package com.github.themartdev.intellijgleam.ide.common

import com.intellij.execution.processTools.getResultStdout
import com.intellij.openapi.util.SystemInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.isExecutable
import kotlin.io.path.isRegularFile

object FsUtils {

    fun findGleamInPath(): Path? {
        val name = if (SystemInfo.isWindows) "gleam.exe" else "gleam"
        val pathDirs = System.getenv("PATH").split(File.pathSeparator)

        for (dir in pathDirs) {
            var path = Path(dir);
            try {
                path = path.toAbsolutePath()
            } catch (_: Exception) {
                continue
            }
            if (!path.exists() || !path.isDirectory()) {
                continue
            }
            val executablePath = path.resolve(name)

            if (!executablePath.exists() || !executablePath.isRegularFile() || !executablePath.isExecutable()) {
                continue
            }
            return executablePath
        }
        return null
    }

    fun validateGleamPath(path: String): Boolean {
        val path = Path(path)
        if (!(path.exists() && path.isRegularFile() && path.isExecutable())) {
            return false
        }

        val result = runBlocking(Dispatchers.IO) {
            val builder = ProcessBuilder(path.toString(), "--version")
            val process = builder.start()
            process.getResultStdout()
        }
        val output = result.getOrElse { return false }
        return String(output).contains("gleam")
    }
}