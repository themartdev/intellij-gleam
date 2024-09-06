package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
@State(name = "GleamLspSettings", storages = [Storage(StoragePathMacros.WORKSPACE_FILE)])
class GleamServiceSettings(val project: Project) :
    SimplePersistentStateComponent<GleamLspSettings>(GleamLspSettings()) {
    var serviceMode
        get() = state.serviceMode
        set(value) {
            state.serviceMode = value
        }

    var lspPath
        get() = state.lspPath ?: ""
        set(value) {
            state.lspPath = value
        }

    companion object {
        fun getInstance(project: Project): GleamServiceSettings = project.service()
    }
}

class GleamLspSettings : BaseState() {
    var serviceMode by enum(GleamLspMode.ENABLED)
    var lspPath by string("")
}

enum class GleamLspMode {
    ENABLED,
    DISABLED
}
