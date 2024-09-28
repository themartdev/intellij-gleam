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

class ErlangSdk(val path: String, val valid: Boolean, val version: String? = null)

object ErlangSdkFinder {
    fun findErlangSdks(): List<ErlangSdk> {
        val candidates = mutableSetOf<Path>()
        candidates.addAll(findErlangInAsdf())
        candidates.addAll(findErlangInCommonPaths())
        findErlangInPath()?.let { candidates.add(it) }
        return candidates
            .filter { validateErlangSdkShape(it) }
            .mapNotNull { captureErlang(it) }
    }

    private fun findErlangInAsdf(): List<Path> {
        val res = mutableListOf<Path>()
        val asdfPath = FsUtils.detectAsdf() ?: return res
        val erlangPath = asdfPath.resolve("installs/erlang")
        if (!FsUtils.isValidDir(erlangPath)) return res
        return erlangPath.listDirectoryEntries()
            .filter { it.isDirectory() }
            .map { it }
    }

    private fun findErlangInCommonPaths(): List<Path> {
        val res = mutableListOf<Path>()
        val possiblePaths = when {
            SystemInfo.isWindows -> listOf(
                Path("C:\\Program Files\\erl"),
                Path("C:\\Program Files (x86)\\erl")
            )

            SystemInfo.isMac -> listOf(
                Path("/usr/local/Cellar/erlang"),
                Path("/usr/local/opt/erlang"),
                Path("/usr/local/lib/erlang")
            )

            SystemInfo.isLinux -> listOf(
                Path("/usr/lib/erlang"),
                Path("/usr/local/lib/erlang"),
                Path("/usr/local/erlang")
            )

            else -> emptyList()
        }

        for (basePath in possiblePaths) {
            if (FsUtils.isValidDir(basePath)) {
                res.add(basePath)
            }
        }
        return res
    }

    private fun findErlangInPath(): Path? {
        val name = if (SystemInfo.isWindows) "erl.exe" else "erl"
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
            if (validateErlangSdkShape(executablePath.parent)) {
                return executablePath.parent
            }
            return executablePath.parent.parent // Assuming bin/erl, go up to SDK root
        }
        return null
    }
}

fun exeName(name: String): String {
    return if (SystemInfo.isWindows) {
        "$name.exe"
    } else {
        name
    }
}

fun validateErlangSdkShape(path: Path): Boolean {
    val binDir = path.resolve("bin")
    val libDir = path.resolve("lib")
    val releasesDir = path.resolve("releases")
    val erlExecutable = binDir.resolve(exeName("erl"))

    return binDir.exists() && binDir.isDirectory() &&
            libDir.exists() && libDir.isDirectory() &&
            releasesDir.exists() && releasesDir.isDirectory() &&
            erlExecutable.exists() && erlExecutable.isExecutable()
}

fun captureErlang(path: Path): ErlangSdk? {
    if (!path.exists() || !path.isDirectory()) {
        return ErlangSdk(path.toString(), false)
    }

    // releases/*/OTP_VERSION
    val releasesDir = path.resolve("releases")
    if (releasesDir.exists() && releasesDir.isDirectory()) {
        val releaseDirs = releasesDir.listDirectoryEntries().filter { it.isDirectory() }
        for (releaseDir in releaseDirs) {
            val otpVersionFile = releaseDir.resolve("OTP_VERSION")
            if (otpVersionFile.exists() && otpVersionFile.isRegularFile()) {
                val version = otpVersionFile.toFile().readText().trim()
                return ErlangSdk(path.toString(), true, version)
            }
        }
    }

    return ErlangSdk(path.toString(), false)
}

