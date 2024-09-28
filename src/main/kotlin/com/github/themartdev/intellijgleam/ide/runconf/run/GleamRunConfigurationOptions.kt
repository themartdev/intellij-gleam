package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.configurations.RunConfigurationOptions

class GleamRunConfigurationOptions : RunConfigurationOptions() {
    var filePath by string("")
    var useCustomGleam by property(false)
    var customGleamPath by string("")
}