package com.github.themartdev.intellijgleam.ide.common

import com.github.themartdev.intellijgleam.ide.runconf.run.GleamJsRuntime
import com.intellij.openapi.util.SystemInfo
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.isExecutable
import kotlin.io.path.isRegularFile
import kotlin.io.path.listDirectoryEntries

class JsRuntime(val path: String, val runtime: GleamJsRuntime, val version: String? = null)

/**
 * Locates installed JavaScript runtimes (node/deno/bun) that Gleam can target. Mirrors
 * [ErlangSdkFinder]: it gathers candidate executables from `PATH`, asdf, version managers and the
 * usual install locations, then captures a version string by running `<runtime> --version`.
 */
object JsRuntimeFinder {
    fun findJsRuntimes(): List<JsRuntime> =
        GleamJsRuntime.entries.flatMap { runtime ->
            candidatePaths(runtime)
                .filter { it.exists() && it.isRegularFile() && it.isExecutable() }
                .distinct()
                .mapNotNull { captureJsRuntime(it, runtime) }
        }

    private fun candidatePaths(runtime: GleamJsRuntime): List<Path> {
        val exe = exeName(runtime.executable)
        val candidates = mutableListOf<Path>()
        findInPath(exe)?.let { candidates.add(it) }
        candidates.addAll(findInAsdf(runtime, exe))
        candidates.addAll(findInVersionManagers(runtime, exe))
        candidates.addAll(findInCommonPaths(runtime, exe))
        return candidates
    }

    private fun findInPath(exe: String): Path? {
        val pathDirs = (System.getenv("PATH") ?: "").split(File.pathSeparator)
        for (dir in pathDirs) {
            val cleaned = FsUtils.sanitizeUserPath(dir)
            if (cleaned.isEmpty()) continue
            val candidate = try {
                Path(cleaned).toAbsolutePath().resolve(exe)
            } catch (_: Exception) {
                continue
            }
            if (candidate.exists() && candidate.isRegularFile() && candidate.isExecutable()) {
                return candidate
            }
        }
        return null
    }

    // asdf layout: <asdf>/installs/<plugin>/<version>/bin/<exe>
    private fun findInAsdf(runtime: GleamJsRuntime, exe: String): List<Path> {
        val asdfPath = FsUtils.detectAsdf() ?: return emptyList()
        val plugin = when (runtime) {
            GleamJsRuntime.NODE -> "nodejs"
            GleamJsRuntime.DENO -> "deno"
            GleamJsRuntime.BUN -> "bun"
        }
        val installs = asdfPath.resolve("installs").resolve(plugin)
        if (!FsUtils.isValidDir(installs)) return emptyList()
        return installs.listDirectoryEntries()
            .filter { it.isDirectory() }
            .map { it.resolve("bin").resolve(exe) }
    }

    private fun findInVersionManagers(runtime: GleamJsRuntime, exe: String): List<Path> {
        if (runtime != GleamJsRuntime.NODE) return emptyList()
        val home = System.getenv("HOME") ?: return emptyList()
        // nvm layout: ~/.nvm/versions/node/<version>/bin/node
        val nvmNode = Path(home).resolve(".nvm").resolve("versions").resolve("node")
        if (!FsUtils.isValidDir(nvmNode)) return emptyList()
        return nvmNode.listDirectoryEntries()
            .filter { it.isDirectory() }
            .map { it.resolve("bin").resolve(exe) }
    }

    private fun findInCommonPaths(runtime: GleamJsRuntime, exe: String): List<Path> {
        val home = System.getenv("HOME")
        val dirs = mutableListOf<Path>()
        when {
            SystemInfo.isWindows -> {
                System.getenv("ProgramFiles")?.let { dirs.add(Path(it).resolve("nodejs")) }
            }
            else -> {
                dirs.add(Path("/usr/local/bin"))
                dirs.add(Path("/usr/bin"))
                dirs.add(Path("/opt/homebrew/bin"))
                if (home != null) {
                    when (runtime) {
                        GleamJsRuntime.DENO -> dirs.add(Path(home).resolve(".deno").resolve("bin"))
                        GleamJsRuntime.BUN -> dirs.add(Path(home).resolve(".bun").resolve("bin"))
                        GleamJsRuntime.NODE -> {}
                    }
                }
            }
        }
        return dirs.map { it.resolve(exe) }
    }
}

/**
 * Best-effort version lookup for an arbitrary user-entered runtime path: infers the runtime from
 * the executable file name (falling back to node) and runs `--version`. Returns null on failure.
 */
fun jsRuntimeVersion(path: String): String? {
    val sanitized = FsUtils.sanitizeUserPath(path)
    if (sanitized.isBlank()) return null
    val name = File(sanitized).name.removeSuffix(".exe").lowercase()
    val runtime = GleamJsRuntime.entries.firstOrNull { it.executable == name } ?: GleamJsRuntime.NODE
    return captureJsRuntime(Path(sanitized), runtime)?.version
}

fun captureJsRuntime(path: Path, runtime: GleamJsRuntime): JsRuntime? {
    val output = PsUtil.runAndGetOutput(path.toString(), "--version")?.stdout
        ?: return JsRuntime(path.toString(), runtime, null)
    return JsRuntime(path.toString(), runtime, parseRuntimeVersion(runtime, output))
}

/** Extracts a version like `20.11.0` from each runtime's `--version` output. */
private fun parseRuntimeVersion(runtime: GleamJsRuntime, raw: String): String? {
    val text = raw.trim()
    if (text.isEmpty()) return null
    return when (runtime) {
        // node: "v20.11.0"
        GleamJsRuntime.NODE -> text.removePrefix("v").ifBlank { null }
        // bun: "1.0.0"
        GleamJsRuntime.BUN -> text.lineSequence().firstOrNull()?.trim()?.ifBlank { null }
        // deno: "deno 1.40.0\nv8 ...\ntypescript ..."
        GleamJsRuntime.DENO -> text.lineSequence().firstOrNull()
            ?.removePrefix("deno")?.trim()?.ifBlank { null }
    }
}
