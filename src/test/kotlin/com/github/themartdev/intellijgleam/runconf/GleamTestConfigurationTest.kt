package com.github.themartdev.intellijgleam.runconf

import com.github.themartdev.intellijgleam.ide.lsp.GleamServiceSettings
import com.github.themartdev.intellijgleam.ide.runconf.run.*
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.testFramework.LightPlatformTestCase

class GleamTestConfigurationTest : LightPlatformTestCase() {

    override fun tearDown() {
        try {
            GleamServiceSettings.getInstance(project).gleamPath = ""
            GleamServiceSettings.getInstance(project).overrideGlobalToolchain = false
        } finally {
            super.tearDown()
        }
    }

    private fun newConfig(): GleamTestConfiguration {
        val type = GleamRunConfigurationType()
        return GleamTestConfiguration(project, GleamTestConfigurationFactory(type), "Gleam Test")
    }

    fun `test run configuration type registers a gleam test factory`() {
        val factory = GleamRunConfigurationType().configurationFactories
            .single { it.id == GleamTestConfigurationFactory.ID } as GleamTestConfigurationFactory

        assertEquals("Gleam Test", factory.name)
        assertEquals(GleamTestConfigurationOptions::class.java, factory.optionsClass)
        assertTrue(factory.createTemplateConfiguration(project) is GleamTestConfiguration)
    }

    fun `test getActualGleamPath uses settings path by default`() {
        GleamServiceSettings.getInstance(project).overrideGlobalToolchain = true
        GleamServiceSettings.getInstance(project).gleamPath = "/from/settings/gleam"
        val config = newConfig()
        config.getOptions().useCustomGleam = false
        assertEquals("/from/settings/gleam", config.getActualGleamPath())
    }

    fun `test getActualGleamPath uses custom path when enabled`() {
        val config = newConfig()
        config.getOptions().useCustomGleam = true
        config.getOptions().customGleamPath = "/custom/gleam"
        assertEquals("/custom/gleam", config.getActualGleamPath())
    }

    fun `test checkConfiguration rejects an invalid gleam path`() {
        val config = newConfig()
        config.getOptions().useCustomGleam = true
        config.getOptions().customGleamPath = "/nonexistent/gleam"
        try {
            config.checkConfiguration()
            fail("Expected RuntimeConfigurationException for an invalid gleam path")
        } catch (_: RuntimeConfigurationException) {
            // expected
        }
    }

    fun `test gleamTestParameters omits target by default`() {
        assertEquals(listOf("test"), GleamTestConfigurationState.gleamTestParameters(""))
        assertEquals(listOf("test"), GleamTestConfigurationState.gleamTestParameters(null))
    }

    fun `test gleamTestParameters adds the target flag when set`() {
        assertEquals(
            listOf("test", "--target", "javascript"),
            GleamTestConfigurationState.gleamTestParameters("javascript")
        )
    }

    fun `test gleamTestParameters adds the runtime flag for the js target`() {
        assertEquals(
            listOf("test", "--target", "javascript", "--runtime", "deno"),
            GleamTestConfigurationState.gleamTestParameters("javascript", "deno")
        )
    }

    fun `test gleamTestParameters omits a blank runtime`() {
        assertEquals(listOf("test"), GleamTestConfigurationState.gleamTestParameters("", ""))
    }

    fun `test gleamRunParameters omits optional flags by default`() {
        assertEquals(listOf("run"), GleamRunConfigurationState.gleamRunParameters(null, "", ""))
    }

    fun `test gleamRunParameters adds module target and runtime when set`() {
        assertEquals(
            listOf("run", "-m", "app", "--target", "javascript", "--runtime", "bun"),
            GleamRunConfigurationState.gleamRunParameters("app", "javascript", "bun")
        )
    }
}
