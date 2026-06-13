package com.github.themartdev.intellijgleam.ide.runconf.run

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.SystemInfo
import java.io.File

/**
 * Shared toolchain resolution used by every Gleam run configuration (run, test, ...).
 *
 * Centralises the Erlang SDK root normalization, validation, and the PATH adjustment that puts
 * the Erlang `bin` directory ahead of the inherited environment, so the launched `gleam`
 * subprocess can find `erl`/`erlc`.
 */
object GleamToolchain {

    /** The Erlang path the user configured in settings, sanitized. */
    fun actualErlangPath(project: Project): String =
        FsUtils.sanitizeUserPath(GleamServiceSettings.getInstance(project).effectiveErlangPath)

    /**
     * Normalizes a user-provided Erlang path (which may point at `erl`, the `bin` directory, or the
     * SDK root) to the SDK root directory. Returns an empty string when no path is configured.
     */
    fun normalizedErlangSdkRoot(project: Project): String {
        val raw = actualErlangPath(project).trim()
        if (raw.isEmpty()) return ""
        val f = File(raw)
        // If user selected erl(.exe)
        if (f.isFile) {
            val parent = f.parentFile // bin
            val root = parent?.parentFile // SDK root
            return root?.absolutePath ?: parent?.absolutePath ?: f.absolutePath
        }
        // If user selected bin directory
        if (f.isDirectory && f.name.equals("bin", ignoreCase = true)) {
            return f.parentFile?.absolutePath ?: f.absolutePath
        }
        // If directory that already looks like SDK root (has bin)
        val binDir = File(f, "bin")
        if (binDir.exists() && binDir.isDirectory) {
            return f.absolutePath
        }
        // As a fallback return as-is
        return f.absolutePath
    }

    /** Validates that the configured Erlang SDK root looks like a real SDK, throwing otherwise. */
    @Throws(RuntimeConfigurationException::class)
    fun validateErlangSdkRoot(project: Project) {
        val erlangSdkRoot = normalizedErlangSdkRoot(project)
        if (erlangSdkRoot.isEmpty()) {
            throw RuntimeConfigurationException("Erlang SDK path is not set")
        }
        val sdkRoot = File(erlangSdkRoot)
        if (!sdkRoot.exists() || !sdkRoot.isDirectory) {
            throw RuntimeConfigurationException("Erlang SDK path is invalid: '${actualErlangPath(project)}' (expected a directory containing bin, lib, and releases)")
        }
        val binDir = File(sdkRoot, "bin")
        val libDir = File(sdkRoot, "lib")
        val releasesDir = File(sdkRoot, "releases")
        val erlExeName = if (SystemInfo.isWindows) "erl.exe" else "erl"
        val erlExecutable = File(binDir, erlExeName)
        if (!(binDir.exists() && binDir.isDirectory &&
                    libDir.exists() && libDir.isDirectory &&
                    releasesDir.exists() && releasesDir.isDirectory &&
                    erlExecutable.exists() && erlExecutable.canExecute())) {
            throw RuntimeConfigurationException("Erlang SDK path is invalid: '${actualErlangPath(project)}' (expected a directory containing bin, lib, and releases)")
        }
    }

    /**
     * Inherited process environment with the configured Erlang `bin` prepended to `PATH`.
     * No-op for PATH when no Erlang path is configured.
     */
    fun environmentWithErlang(project: Project): Map<String, String> {
        val env = System.getenv().toMutableMap()
        val erlangSdkRoot = normalizedErlangSdkRoot(project)
        if (erlangSdkRoot.isNotEmpty()) {
            val erlangBin = File(erlangSdkRoot).resolve("bin").absolutePath
            val pathDirs = (env["PATH"] ?: "").split(File.pathSeparator).toMutableList()
            pathDirs.add(0, erlangBin)
            env["PATH"] = pathDirs.joinToString(File.pathSeparator)
        }
        return env
    }
}
