package com.github.themartdev.intellijgleam.ide.common

import com.intellij.execution.processTools.getResultStdout
import com.intellij.openapi.util.SystemInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.isExecutable
import kotlin.io.path.isRegularFile

object FsUtils {
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

    fun isValidDir(path: Path): Boolean {
        return path.exists() && path.isDirectory()
    }

    fun isValidDir(path: String): Boolean {
        val path = Path(path)
        return path.exists() && path.isDirectory()
    }

    fun detectAsdf(): Path? {
        System.getenv("ASDF_DIR")?.let {
            if (isValidDir(it)) {
                return Path(it)
            }
        }
        val asdfPath = when {
            SystemInfo.isWindows -> Path(System.getenv("USERPROFILE")).resolve(".asdf")
            else -> Path(System.getenv("HOME")).resolve(".asdf")
        }
        return if (isValidDir(asdfPath)) asdfPath else null
    }
}