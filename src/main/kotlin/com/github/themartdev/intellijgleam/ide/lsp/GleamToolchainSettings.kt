package com.github.themartdev.intellijgleam.ide.lsp

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

/**
 * Application-wide Gleam toolchain defaults (Gleam executable + Erlang SDK paths).
 *
 * Each project can opt out of these via [GleamServiceSettings.overrideGlobalToolchain]; otherwise
 * projects read the effective paths from here. Stored in the IDE-wide config (roamable), not the
 * per-project workspace file.
 */
@Service(Service.Level.APP)
@State(name = "GleamGlobalSettings", storages = [Storage("gleam.xml")])
class GleamGlobalSettings :
    SimplePersistentStateComponent<GleamGlobalState>(GleamGlobalState()) {
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
        fun getInstance(): GleamGlobalSettings = service()
    }
}

class GleamGlobalState : BaseState() {
    var gleamPath by string("")
    var erlangPath by string("")
}

@Service(Service.Level.PROJECT)
@State(name = "GleamToolchainSettings", storages = [Storage(StoragePathMacros.WORKSPACE_FILE)])
class GleamServiceSettings(val project: Project) :
    SimplePersistentStateComponent<GleamToolchainSettings>(GleamToolchainSettings()) {
    var lspMode
        get() = state.lspMode
        set(value) {
            state.lspMode = value
        }

    /** When true, this project supplies its own [gleamPath]/[erlangPath] instead of the global defaults. */
    var overrideGlobalToolchain
        get() = state.overrideGlobalToolchain
        set(value) {
            state.overrideGlobalToolchain = value
        }

    /** Project-level override value; only meaningful when [overrideGlobalToolchain] is true. */
    var gleamPath
        get() = state.gleamPath ?: ""
        set(value) {
            state.gleamPath = value
        }

    /** Project-level override value; only meaningful when [overrideGlobalToolchain] is true. */
    var erlangPath
        get() = state.erlangPath ?: ""
        set(value) {
            state.erlangPath = value
        }

    /** The Gleam executable path that should actually be used: project override or global default. */
    val effectiveGleamPath: String
        get() = if (state.overrideGlobalToolchain) gleamPath else GleamGlobalSettings.getInstance().gleamPath

    /** The Erlang SDK path that should actually be used: project override or global default. */
    val effectiveErlangPath: String
        get() = if (state.overrideGlobalToolchain) erlangPath else GleamGlobalSettings.getInstance().erlangPath

    companion object {
        fun getInstance(project: Project): GleamServiceSettings = project.service()
    }
}

class GleamToolchainSettings : BaseState() {
    var lspMode by enum(GleamLspMode.ENABLED)
    var overrideGlobalToolchain by property(false)
    var gleamPath by string("")
    var erlangPath by string("")
}

enum class GleamLspMode {
    ENABLED,
    DISABLED
}
