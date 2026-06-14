package com.github.themartdev.intellijgleam.ide.runconf.run

/**
 * The Gleam compilation targets, as passed to `gleam --target`.
 *
 * Run configurations store the target as a plain string ("" = "Default", i.e. let `gleam.toml`
 * decide). These helpers map between that wire value, the CLI value, and the editor combo labels.
 */
enum class GleamTarget(val cliValue: String, val label: String) {
    ERLANG("erlang", "erlang"),
    JAVASCRIPT("javascript", "javascript");

    companion object {
        /** Combo label for "no explicit target"; serialized as "". */
        const val DEFAULT_LABEL = "Default"

        fun fromCliValue(value: String?): GleamTarget? =
            entries.firstOrNull { it.cliValue == value }
    }
}

/**
 * The JavaScript runtimes Gleam can target, as passed to `gleam --runtime`.
 *
 * Only meaningful when the target is [GleamTarget.JAVASCRIPT]. Stored as a plain string
 * ("" = "Default", i.e. let `gleam.toml` decide). The [executable] is the binary name Gleam will
 * spawn, used by toolchain detection and PATH resolution.
 */
enum class GleamJsRuntime(val cliValue: String, val executable: String) {
    NODE("node", "node"),
    DENO("deno", "deno"),
    BUN("bun", "bun");

    companion object {
        /** Combo label for "no explicit runtime"; serialized as "". */
        const val DEFAULT_LABEL = "Default"

        fun fromCliValue(value: String?): GleamJsRuntime? =
            entries.firstOrNull { it.cliValue == value }
    }
}
