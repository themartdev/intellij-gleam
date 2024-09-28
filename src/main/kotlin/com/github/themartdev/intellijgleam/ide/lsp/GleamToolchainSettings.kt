package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
@State(name = "GleamToolchainSettings", storages = [Storage(StoragePathMacros.WORKSPACE_FILE)])
class GleamServiceSettings(val project: Project) :
    SimplePersistentStateComponent<GleamToolchainSettings>(GleamToolchainSettings()) {
    var lspMode
        get() = state.lspMode
        set(value) {
            state.lspMode = value
        }

    var gleamPath
        get() = state.gleamPath ?: ""
        set(value) {
            state.gleamPath = value
        }

    var erlangPath
        get() = state.erlangPath ?: ""
        set(value) {
            state.erlangPath = value
        }

    companion object {
        fun getInstance(project: Project): GleamServiceSettings = project.service()
    }
}

class GleamToolchainSettings : BaseState() {
    var lspMode by enum(GleamLspMode.ENABLED)
    var gleamPath by string("")
    var erlangPath by string("")
}

enum class GleamLspMode {
    ENABLED,
    DISABLED
}
