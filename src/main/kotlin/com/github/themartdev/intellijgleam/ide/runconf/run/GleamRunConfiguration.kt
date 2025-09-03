package com.github.themartdev.intellijgleam.ide.runconf.run

import com.github.themartdev.intellijgleam.ide.common.FsUtils
import com.github.themartdev.intellijgleam.ide.common.GleamProjectUtils
import com.github.themartdev.intellijgleam.ide.common.validateErlangSdkShape
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import java.io.File
import java.nio.file.Path

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
        return GleamServiceSettings.getInstance(project).erlangPath
    }

    // Returns Erlang SDK root directory normalized from user-provided path.
    fun getNormalizedErlangSdkRoot(): String {
        val raw = getActualErlangPath().trim()
        if (raw.isEmpty()) return ""
        val p = java.nio.file.Paths.get(raw)
        val f = p.toFile()
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
        val fp = options.filePath ?: return null
        // If user typed module name directly
        if (!fp.contains('/') && !fp.contains('\\')) {
            return fp.removeSuffix(".gleam")
        }
        val srcDirStr = GleamProjectUtils.getSrcDir(project) ?: return null
        val srcDir = java.nio.file.Paths.get(srcDirStr).normalize()
        val normFilePath = java.nio.file.Paths.get(fp.replace('/', File.separatorChar)).normalize()
        val rel = if (normFilePath.startsWith(srcDir)) srcDir.relativize(normFilePath) else normFilePath.fileName
        val withoutExt = rel.toString().removeSuffix(".gleam")
        return withoutExt.replace('\\', '/')
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
        val sdkPath = try {
            Path.of(erlangSdkRoot)
        } catch (_: Exception) {
            throw RuntimeConfigurationException("Erlang SDK path is malformed: '${getActualErlangPath()}'")
        }
        if (!validateErlangSdkShape(sdkPath)) {
            throw RuntimeConfigurationException("Erlang SDK path is invalid: '${getActualErlangPath()}' (expected a directory containing bin, lib, and releases)")
        }
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?> {
        return GleamRunConfigurationEditor(project)
    }

}