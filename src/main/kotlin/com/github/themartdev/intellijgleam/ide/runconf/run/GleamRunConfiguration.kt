package com.github.themartdev.intellijgleam.ide.runconf.run

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.github.themartdev.intellijgleam.ide.common.GleamProjectUtils
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.File

class GleamRunConfiguration(project: Project, configurationFactory: ConfigurationFactory, name: String) :
    RunConfigurationBase<GleamRunConfigurationOptions>(project, configurationFactory, name) {

    fun getActualGleamPath(): String {
        return if (options.useCustomGleam) {
            options.customGleamPath ?: ""
        } else {
            GleamServiceSettings.getInstance(project).gleamPath
        }
    }

    fun getActualErlangPath(): String {
        val raw = GleamServiceSettings.getInstance(project).erlangPath
        return FsUtils.sanitizeUserPath(raw)
    }

    // Returns Erlang SDK root directory normalized from user-provided path.
    fun getNormalizedErlangSdkRoot(): String {
        val raw = getActualErlangPath().trim()
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

    fun getModuleQualifier(): String? {
        val fpRaw = options.filePath ?: return null
        val fp = fpRaw.trim()

        // Case 1: User typed a plain module name
        if (!fp.contains('/') && !fp.contains('\\')) {
            return fp.removeSuffix(".gleam")
        }

        // Normalize separators to system default
        val sysSep = File.separatorChar
        val normInput = fp.replace('/', sysSep).replace('\\', sysSep)

        // Case 2: Project-relative path starting with src
        // Accept prefixes like: "src\", "\\src\\", "/src/"
        val srcPrefixes = listOf(
            "src$sysSep",
            "$sysSep" + "src$sysSep",
            "/src/",
            "src/",
            "src\\",
        )
        var relFromSrc: String? = null
        for (p in srcPrefixes) {
            if (normInput.startsWith(p)) {
                relFromSrc = normInput.substring(p.length)
                break
            }
        }

        // Case 3: Absolute path under project src directory
        if (relFromSrc == null) {
            val srcDirStr = GleamProjectUtils.getSrcDir(project)
            if (srcDirStr != null) {
                val normSrcAbs = File(srcDirStr).absolutePath.replace('/', sysSep).trimEnd(sysSep)
                val normAbs = File(normInput).absolutePath
                val isWindows = com.intellij.openapi.util.SystemInfo.isWindows
                val startsWith = if (isWindows) {
                    normAbs.lowercase().startsWith((normSrcAbs + File.separator).lowercase())
                } else {
                    normAbs.startsWith(normSrcAbs + File.separator)
                }
                if (startsWith) {
                    relFromSrc = normAbs.substring((normSrcAbs + File.separator).length)
                }
            }
        }

        // Fallback: if still null, use the input path as-is (not just basename)
        val rel = relFromSrc ?: normInput

        // Strip extension if present
        val withoutExt = if (rel.endsWith(".gleam", ignoreCase = true)) rel.dropLast(6) else rel
        // Emit Gleam module qualifier with forward slashes
        return withoutExt.replace('\\', '/').trim('/')
    }

    public override fun getOptions(): GleamRunConfigurationOptions {
        return super.options as GleamRunConfigurationOptions
    }

    override fun getState(
        executor: Executor, environment: ExecutionEnvironment
    ): RunProfileState? = GleamRunConfigurationState(environment, this)

    @Throws(RuntimeConfigurationException::class)
    override fun checkConfiguration() {
        val gleamPath = getActualGleamPath()
        if (!FsUtils.validateGleamPath(gleamPath)) {
            throw RuntimeConfigurationException("Gleam executable is invalid: '$gleamPath'")
        }

        val erlangSdkRoot = getNormalizedErlangSdkRoot()
        if (erlangSdkRoot.isEmpty()) {
            throw RuntimeConfigurationException("Erlang SDK path is not set")
        }
        val sdkRoot = File(erlangSdkRoot)
        if (!sdkRoot.exists() || !sdkRoot.isDirectory) {
            throw RuntimeConfigurationException("Erlang SDK path is invalid: '${getActualErlangPath()}' (expected a directory containing bin, lib, and releases)")
        }
        val binDir = File(sdkRoot, "bin")
        val libDir = File(sdkRoot, "lib")
        val releasesDir = File(sdkRoot, "releases")
        val erlExeName = if (com.intellij.openapi.util.SystemInfo.isWindows) "erl.exe" else "erl"
        val erlExecutable = File(binDir, erlExeName)
        if (!(binDir.exists() && binDir.isDirectory &&
                    libDir.exists() && libDir.isDirectory &&
                    releasesDir.exists() && releasesDir.isDirectory &&
                    erlExecutable.exists() && erlExecutable.canExecute())) {
            throw RuntimeConfigurationException("Erlang SDK path is invalid: '${getActualErlangPath()}' (expected a directory containing bin, lib, and releases)")
        }
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?> {
        return GleamRunConfigurationEditor(project)
    }

}