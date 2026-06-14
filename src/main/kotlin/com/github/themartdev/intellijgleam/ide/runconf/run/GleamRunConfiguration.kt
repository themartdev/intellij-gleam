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
            GleamServiceSettings.getInstance(project).effectiveGleamPath
        }
    }

    fun getActualErlangPath(): String = GleamToolchain.actualErlangPath(project)

    // Returns Erlang SDK root directory normalized from user-provided path.
    fun getNormalizedErlangSdkRoot(): String = GleamToolchain.normalizedErlangSdkRoot(project)

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

        GleamToolchain.validateForTarget(project, getOptions().target)
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?> {
        return GleamRunConfigurationEditor(project)
    }

}