package com.github.themartdev.intellijgleam.ide.runconf.run

import com.intellij.execution.configurations.RunConfigurationOptions

class GleamTestConfigurationOptions : RunConfigurationOptions() {
    // "" = project default (from gleam.toml), or "erlang" / "javascript"
    var target by string("")
    // "" = project default (from gleam.toml), or "node" / "deno" / "bun"; only used for the js target
    var runtime by string("")
    var useCustomGleam by property(false)
    var customGleamPath by string("")
}
