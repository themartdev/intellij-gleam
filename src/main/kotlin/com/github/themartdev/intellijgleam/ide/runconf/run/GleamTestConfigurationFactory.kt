package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project

class GleamTestConfigurationFactory(type: GleamRunConfigurationType) : ConfigurationFactory(type) {
    override fun getId() = ID

    override fun getName() = "Gleam Test"

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return GleamTestConfiguration(project, this, "Gleam Test")
    }

    override fun getOptionsClass(): Class<out BaseState?> {
        return GleamTestConfigurationOptions::class.java
    }

    companion object {
        const val ID = "GleamTestConfiguration"
    }
}
