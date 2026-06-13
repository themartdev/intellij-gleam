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
    }

    override fun tearDown() {
        try {
            settings().erlangPath = ""
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

    private fun assertThrowsConfigError(block: () -> Unit) {
        try {
            block()
            fail("Expected RuntimeConfigurationException")
        } catch (_: RuntimeConfigurationException) {
            // expected
        }
    }
}
