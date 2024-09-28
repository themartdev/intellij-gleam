package com.github.themartdev.intellijgleam.ide.common

import com.intellij.openapi.util.SystemInfo
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.isExecutable
import kotlin.io.path.isRegularFile
import kotlin.io.path.listDirectoryEntries

class GleamExecutable(val path: String, val valid: Boolean, val version: String? = null)

object GleamExecutableFinder {
    fun findGleamInstalls(): List<GleamExecutable> {
        val candidates = mutableListOf<Path>()
        findGleamInPath()?.let { candidates.add(it) }
        findGleamInAsdf().forEach { candidates.add(it) }
        return candidates
            .filter { it.isExecutable() }
            .map { captureGleam(it) }
            .filterNotNull()
    }

    private fun findGleamInAsdf(): List<Path> {
        val res = mutableListOf<Path>()
        val asdfPath = FsUtils.detectAsdf() ?: return res
        val gleamPath = asdfPath.resolve("installs/gleam")
        if (!FsUtils.isValidDir(gleamPath)) return res
        return gleamPath.listDirectoryEntries()
            .map { it.resolve("bin").resolve("gleam") }
    }

    private fun findGleamInPath(): Path? {
        val name = if (SystemInfo.isWindows) "gleam.exe" else "gleam"
        val pathDirs = System.getenv("PATH").split(File.pathSeparator)

        for (dir in pathDirs) {
            var path = Path(dir)
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
}

fun captureGleam(path: Path): GleamExecutable? {
    val res =
        PsUtil.runAndGetOutput(path.toString(), "--version")?.stdout ?: return GleamExecutable(path.toString(), false)
    val version = res.split(" ").lastOrNull()
    return GleamExecutable(path.toString(), true, version)
}