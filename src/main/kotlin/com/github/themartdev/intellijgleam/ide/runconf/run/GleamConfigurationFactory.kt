package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project

class GleamConfigurationFactory(type: GleamRunConfigurationType) : ConfigurationFactory(type) {
    override fun getId() = GleamRunConfigurationType.ID

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return GleamRunConfiguration(project, this, "Gleam")
    }

    override fun getOptionsClass(): Class<out BaseState?>? {
        return GleamRunConfigurationOptions::class.java
    }

}