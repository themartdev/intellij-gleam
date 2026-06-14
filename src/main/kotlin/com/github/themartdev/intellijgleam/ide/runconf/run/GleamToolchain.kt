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
        prependErlangBin(project, env)
        return env
    }

    /** The JS runtime path the user configured in settings, sanitized. */
    fun actualJsRuntimePath(project: Project): String =
        FsUtils.sanitizeUserPath(GleamServiceSettings.getInstance(project).effectiveJsRuntimePath)

    /**
     * Normalizes a user-provided JS runtime path (which may point at the runtime executable or at the
     * directory containing it) to the directory that should go on `PATH`. Returns an empty string
     * when no path is configured.
     */
    fun normalizedJsRuntimeBinDir(project: Project): String {
        val raw = actualJsRuntimePath(project).trim()
        if (raw.isEmpty()) return ""
        val f = File(raw)
        // If user selected the runtime executable itself, use its directory.
        if (f.isFile) return f.parentFile?.absolutePath ?: f.absolutePath
        // Otherwise treat it as the directory to add to PATH.
        return f.absolutePath
    }

    /**
     * Inherited process environment with the runtime directories for [target] prepended to `PATH`.
     *
     * - `erlang` adds the Erlang `bin`.
     * - `javascript` adds the configured JS runtime directory.
     * - `""` (let `gleam.toml` decide) adds both when configured, since we don't parse `gleam.toml`.
     *
     * Each is a no-op when the corresponding path is not configured.
     */
    fun environmentForTarget(project: Project, target: String?): Map<String, String> {
        val env = System.getenv().toMutableMap()
        when (GleamTarget.fromCliValue(target)) {
            GleamTarget.ERLANG -> prependErlangBin(project, env)
            GleamTarget.JAVASCRIPT -> prependJsRuntimeBin(project, env)
            null -> {
                // Default target: cover both, whichever gleam.toml ends up selecting.
                prependErlangBin(project, env)
                prependJsRuntimeBin(project, env)
            }
        }
        return env
    }

    /**
     * Validates the toolchain for [target] before launching, throwing on a misconfiguration.
     *
     * - `erlang` requires a valid Erlang SDK (strict, as Gleam needs `erl`/`erlc`).
     * - `javascript` validates the JS runtime path only when one is configured; an empty path is
     *   allowed so a runtime already on `PATH` can be used.
     * - `""` (let `gleam.toml` decide) is lenient: it validates whichever paths are configured but
     *   never fails merely because a runtime is unset.
     */
    @Throws(RuntimeConfigurationException::class)
    fun validateForTarget(project: Project, target: String?) {
        when (GleamTarget.fromCliValue(target)) {
            GleamTarget.ERLANG -> validateErlangSdkRoot(project)
            GleamTarget.JAVASCRIPT -> validateJsRuntimePath(project)
            null -> {
                if (actualErlangPath(project).isNotBlank()) validateErlangSdkRoot(project)
                validateJsRuntimePath(project)
            }
        }
    }

    /** Validates the configured JS runtime path, if any. An unset path is allowed (rely on PATH). */
    @Throws(RuntimeConfigurationException::class)
    fun validateJsRuntimePath(project: Project) {
        val raw = actualJsRuntimePath(project).trim()
        if (raw.isEmpty()) return
        if (!File(raw).exists()) {
            throw RuntimeConfigurationException("JavaScript runtime path is invalid: '$raw'")
        }
    }

    private fun prependErlangBin(project: Project, env: MutableMap<String, String>) {
        val erlangSdkRoot = normalizedErlangSdkRoot(project)
        if (erlangSdkRoot.isEmpty()) return
        prependPath(env, File(erlangSdkRoot).resolve("bin").absolutePath)
    }

    private fun prependJsRuntimeBin(project: Project, env: MutableMap<String, String>) {
        val jsBin = normalizedJsRuntimeBinDir(project)
        if (jsBin.isEmpty()) return
        prependPath(env, jsBin)
    }

    private fun prependPath(env: MutableMap<String, String>, dir: String) {
        val pathDirs = (env["PATH"] ?: "").split(File.pathSeparator).toMutableList()
        pathDirs.add(0, dir)
        env["PATH"] = pathDirs.joinToString(File.pathSeparator)
    }
}
