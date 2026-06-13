package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.testFramework.LightPlatformTestCase

class GleamServiceSettingsTest : LightPlatformTestCase() {

    private fun project() = GleamServiceSettings.getInstance(project)
    private fun global() = GleamGlobalSettings.getInstance()

    override fun tearDown() {
        try {
            project().apply {
                overrideGlobalToolchain = false
                gleamPath = ""
                erlangPath = ""
            }
            global().apply {
                gleamPath = ""
                erlangPath = ""
            }
        } finally {
            super.tearDown()
        }
    }

    fun `test effective paths fall back to global when override is off`() {
        global().gleamPath = "/global/gleam"
        global().erlangPath = "/global/erlang"
        project().overrideGlobalToolchain = false
        project().gleamPath = "/project/gleam"
        project().erlangPath = "/project/erlang"

        assertEquals("/global/gleam", project().effectiveGleamPath)
        assertEquals("/global/erlang", project().effectiveErlangPath)
    }

    fun `test effective paths use project values when override is on`() {
        global().gleamPath = "/global/gleam"
        global().erlangPath = "/global/erlang"
        project().overrideGlobalToolchain = true
        project().gleamPath = "/project/gleam"
        project().erlangPath = "/project/erlang"

        assertEquals("/project/gleam", project().effectiveGleamPath)
        assertEquals("/project/erlang", project().effectiveErlangPath)
    }
}
