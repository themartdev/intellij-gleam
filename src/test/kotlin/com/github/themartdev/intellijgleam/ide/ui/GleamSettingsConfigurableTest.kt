package com.github.themartdev.intellijgleam.ide.ui

import com.github.themartdev.intellijgleam.ide.lsp.GleamLspMode
import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.intellij.testFramework.LightPlatformTestCase
import com.redhat.devtools.lsp4ij.LanguageServerManager
import io.mockk.*

class GleamSettingsConfigurableMockKTest : LightPlatformTestCase() {

    override fun setUp() {
        super.setUp()
        clearAllMocks()
    }

    fun `test if Gleam path changes and LS is enabled, then server is restarted`() {
        // arrange
        val settings = GleamServiceSettings.getInstance(project)
        settings.gleamPath = "old/path"
        settings.lspMode = GleamLspMode.ENABLED
        val configurable = GleamSettingsConfigurable(project)

        settings.gleamPath = "new/path"
        mockkStatic(LanguageServerManager::class)
        val manager = mockk<LanguageServerManager>(relaxed = true)
        every { LanguageServerManager.getInstance(project) } returns manager

        // act
        configurable.apply()

        // assert
        verify {
            manager.stop("gleam-ls", match { !it.isWillDisable })
            manager.start("gleam-ls")
        }

        unmockkStatic(LanguageServerManager::class)
    }

    fun `test if Gleam path is changed and LS is disabled, nothing changes`() {
        // arrange
        val settings = GleamServiceSettings.getInstance(project)
        settings.gleamPath = "old/path"
        settings.lspMode = GleamLspMode.DISABLED
        val configurable = GleamSettingsConfigurable(project)

        settings.gleamPath = "new/path"
        mockkStatic(LanguageServerManager::class)
        val manager = mockk<LanguageServerManager>(relaxed = true)
        every { LanguageServerManager.getInstance(project) } returns manager

        // act
        configurable.apply()

        // assert
        verify(exactly = 0) {
            manager.stop("gleam-ls", any())
            manager.start("gleam-ls")
        }

        unmockkStatic(LanguageServerManager::class)
    }
}
