package com.github.themartdev.intellijgleam.ide.common

import com.intellij.execution.processTools.getResultStdout
import com.intellij.openapi.util.SystemInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.nio.file.Path
import kotlin.io.path.*

object FsUtils {
    private val INVISIBLE_CONTROL_CHARS = "\u200E\u200F\u202A\u202B\u202C\u202D\u202E".toCharArray().toSet()

    fun sanitizeUserPath(input: String): String {
        var s = input.trim()
        // Remove invisible Unicode directionality/control marks that can sneak from clipboard
        s = s.filter { ch -> !INVISIBLE_CONTROL_CHARS.contains(ch) }
        // On Windows, normalize forward slashes to backslashes
        if (SystemInfo.isWindows) {
            s = s.replace('/', '\\')
            // Collapse duplicate backslashes (but keep UNC prefix if present)
            s = s.replace(Regex("""\\\\+"""), "\\") // Replace multiple backslashes with one
        }
        return s
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