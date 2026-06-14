package com.github.themartdev.intellijgleam.runconf

import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.github.themartdev.intellijgleam.ide.runconf.run.GleamToolchain
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.openapi.util.SystemInfo
import com.intellij.openapi.util.io.FileUtil
import com.intellij.testFramework.LightPlatformTestCase
import java.io.File

class GleamToolchainTest : LightPlatformTestCase() {

    private lateinit var sdkRoot: File
    private lateinit var binDir: File
    private lateinit var erl: File

    override fun setUp() {
        super.setUp()
        // Fake Erlang SDK layout: <root>/{bin/erl, lib, releases}
        sdkRoot = FileUtil.createTempDirectory("erlang-sdk", null)
        binDir = File(sdkRoot, "bin").apply { mkdirs() }
        File(sdkRoot, "lib").mkdirs()
        File(sdkRoot, "releases").mkdirs()
        val erlName = if (SystemInfo.isWindows) "erl.exe" else "erl"
        erl = File(binDir, erlName).apply { writeText(""); setExecutable(true) }
        // Exercise project-supplied paths rather than the global toolchain defaults.
        settings().overrideGlobalToolchain = true
    }

    override fun tearDown() {
        try {
            settings().erlangPath = ""
            settings().jsRuntimePath = ""
            settings().overrideGlobalToolchain = false
            FileUtil.delete(sdkRoot)
        } finally {
            super.tearDown()
        }
    }

    private fun settings() = GleamServiceSettings.getInstance(project)

    fun `test normalizedErlangSdkRoot resolves erl executable to SDK root`() {
        settings().erlangPath = erl.absolutePath
        assertEquals(sdkRoot.absolutePath, GleamToolchain.normalizedErlangSdkRoot(project))
    }

    fun `test normalizedErlangSdkRoot resolves bin directory to SDK root`() {
        settings().erlangPath = binDir.absolutePath
        assertEquals(sdkRoot.absolutePath, GleamToolchain.normalizedErlangSdkRoot(project))
    }

    fun `test normalizedErlangSdkRoot keeps an SDK root directory`() {
        settings().erlangPath = sdkRoot.absolutePath
        assertEquals(sdkRoot.absolutePath, GleamToolchain.normalizedErlangSdkRoot(project))
    }

    fun `test normalizedErlangSdkRoot is empty when unset`() {
        settings().erlangPath = ""
        assertEquals("", GleamToolchain.normalizedErlangSdkRoot(project))
    }

    fun `test validateErlangSdkRoot passes for a valid SDK`() {
        settings().erlangPath = sdkRoot.absolutePath
        GleamToolchain.validateErlangSdkRoot(project) // should not throw
    }

    fun `test validateErlangSdkRoot throws when unset`() {
        settings().erlangPath = ""
        assertThrowsConfigError { GleamToolchain.validateErlangSdkRoot(project) }
    }

    fun `test validateErlangSdkRoot throws when bin is missing`() {
        FileUtil.delete(binDir)
        settings().erlangPath = sdkRoot.absolutePath
        assertThrowsConfigError { GleamToolchain.validateErlangSdkRoot(project) }
    }

    fun `test environmentWithErlang prepends erlang bin to PATH`() {
        settings().erlangPath = sdkRoot.absolutePath
        val path = GleamToolchain.environmentWithErlang(project)["PATH"] ?: ""
        assertTrue(
            "PATH should start with erlang bin but was: $path",
            path == binDir.absolutePath || path.startsWith(binDir.absolutePath + File.pathSeparator)
        )
    }

    fun `test environmentWithErlang leaves PATH unchanged when erlang unset`() {
        settings().erlangPath = ""
        val path = GleamToolchain.environmentWithErlang(project)["PATH"] ?: ""
        assertFalse(path.contains(binDir.absolutePath))
    }

    // --- JavaScript runtime ---

    fun `test normalizedJsRuntimeBinDir resolves an executable to its directory`() {
        val node = File(binDir, if (SystemInfo.isWindows) "node.exe" else "node").apply {
            writeText(""); setExecutable(true)
        }
        settings().jsRuntimePath = node.absolutePath
        assertEquals(binDir.absolutePath, GleamToolchain.normalizedJsRuntimeBinDir(project))
    }

    fun `test normalizedJsRuntimeBinDir keeps a directory`() {
        settings().jsRuntimePath = binDir.absolutePath
        assertEquals(binDir.absolutePath, GleamToolchain.normalizedJsRuntimeBinDir(project))
    }

    fun `test normalizedJsRuntimeBinDir is empty when unset`() {
        settings().jsRuntimePath = ""
        assertEquals("", GleamToolchain.normalizedJsRuntimeBinDir(project))
    }

    fun `test validateJsRuntimePath allows an unset path`() {
        settings().jsRuntimePath = ""
        GleamToolchain.validateJsRuntimePath(project) // should not throw
    }

    fun `test validateJsRuntimePath throws for a nonexistent path`() {
        settings().jsRuntimePath = File(sdkRoot, "does-not-exist").absolutePath
        assertThrowsConfigError { GleamToolchain.validateJsRuntimePath(project) }
    }

    // --- target-aware environment ---

    fun `test environmentForTarget erlang prepends erlang bin only`() {
        settings().erlangPath = sdkRoot.absolutePath
        settings().jsRuntimePath = jsBinDir().absolutePath
        val path = GleamToolchain.environmentForTarget(project, "erlang")["PATH"] ?: ""
        assertTrue(path.startsWith(binDir.absolutePath + File.pathSeparator) || path == binDir.absolutePath)
        assertFalse(path.contains(jsBinDir().absolutePath))
    }

    fun `test environmentForTarget javascript prepends the js runtime dir only`() {
        settings().erlangPath = sdkRoot.absolutePath
        val jsBin = jsBinDir()
        settings().jsRuntimePath = jsBin.absolutePath
        val path = GleamToolchain.environmentForTarget(project, "javascript")["PATH"] ?: ""
        assertTrue(path.startsWith(jsBin.absolutePath + File.pathSeparator) || path == jsBin.absolutePath)
        assertFalse(path.contains(binDir.absolutePath))
    }

    fun `test environmentForTarget default prepends both`() {
        settings().erlangPath = sdkRoot.absolutePath
        val jsBin = jsBinDir()
        settings().jsRuntimePath = jsBin.absolutePath
        val path = GleamToolchain.environmentForTarget(project, "")["PATH"] ?: ""
        assertTrue(path.contains(binDir.absolutePath))
        assertTrue(path.contains(jsBin.absolutePath))
    }

    // --- target-aware validation ---

    fun `test validateForTarget erlang requires the erlang sdk`() {
        settings().erlangPath = ""
        assertThrowsConfigError { GleamToolchain.validateForTarget(project, "erlang") }
    }

    fun `test validateForTarget javascript does not require erlang`() {
        settings().erlangPath = ""
        settings().jsRuntimePath = ""
        GleamToolchain.validateForTarget(project, "javascript") // should not throw
    }

    fun `test validateForTarget default does not require erlang when unset`() {
        settings().erlangPath = ""
        settings().jsRuntimePath = ""
        GleamToolchain.validateForTarget(project, "") // should not throw
    }

    private fun jsBinDir(): File = File(sdkRoot, "jsbin").apply { mkdirs() }

    private fun assertThrowsConfigError(block: () -> Unit) {
        try {
            block()
            fail("Expected RuntimeConfigurationException")
        } catch (_: RuntimeConfigurationException) {
            // expected
        }
    }
}
