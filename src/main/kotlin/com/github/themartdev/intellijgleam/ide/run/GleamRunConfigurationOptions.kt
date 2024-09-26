package com.github.themartdev.intellijgleam.ide.run

import com.intellij.execution.configurations.RunConfigurationOptions

class GleamRunConfigurationOptions : RunConfigurationOptions() {
    var filePath by string("")
    var useCustomGleam by property(false)
    var customGleamPath by string("")
}