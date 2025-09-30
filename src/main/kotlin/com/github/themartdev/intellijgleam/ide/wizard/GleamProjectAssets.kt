package com.github.themartdev.intellijgleam.ide.wizard

class GleamProjectAssets {
    companion object {
        fun assetDirs(): List<String> = listOf("src")
        fun fileAssets(): List<Pair<String, String>> = listOf(
            Pair("gleam.toml", "gleam.toml"),
            Pair(".gitignore", "gleam.gitignore"),
            Pair("src/main.gleam", "main.gleam")
        )

        fun assetProps(name: String, target: String): Array<Pair<String, String>> =
            arrayOf(
                Pair("gleamProjectName", name),
                Pair("gleamProjectTarget", target),
            )
    }
}