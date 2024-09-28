package com.github.themartdev.intellijgleam.ide.runconf.run

import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.openapi.util.NotNullLazyValue


class GleamRunConfigurationType :
    ConfigurationTypeBase(ID, "Gleam", "Run Gleam configuration", NotNullLazyValue.createValue {
        GleamIcons.GLEAM
    }) {

    companion object {
        const val ID = "GleamRunConfiguration"
    }

    init {
        addFactory(GleamConfigurationFactory(this))
    }

}