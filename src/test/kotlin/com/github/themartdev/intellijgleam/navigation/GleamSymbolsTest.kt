package com.github.themartdev.intellijgleam.navigation

import com.github.themartdev.intellijgleam.ide.navigation.GleamSymbolKind
import com.github.themartdev.intellijgleam.ide.navigation.GleamSymbols
import com.github.themartdev.intellijgleam.lang.psi.GleamFile
import com.github.themartdev.intellijgleam.parser.GleamParsingTestCase

class GleamSymbolsTest : GleamParsingTestCase() {
    private fun collect(source: String): List<Pair<String, GleamSymbolKind>> {
        parseFile("symbols.gleam", source)
        return GleamSymbols.collect(myFile as GleamFile).map { it.name to it.kind }
    }

    fun testCollectsAllTopLevelKinds() {
        val symbols = collect(
            """
            import gleam/io

            pub const greeting = "hi"

            const answer = 42

            pub type Shape {
              Circle(radius: Int)
              Square(side: Int)
            }

            pub type Alias = Int

            pub fn main() {
              io.println(greeting)
            }

            fn helper(x) {
              x
            }
            """.trimIndent()
        )

        assertEquals(
            listOf(
                "greeting" to GleamSymbolKind.CONSTANT,
                "answer" to GleamSymbolKind.CONSTANT,
                "Shape" to GleamSymbolKind.TYPE,
                "Circle" to GleamSymbolKind.CONSTRUCTOR,
                "Square" to GleamSymbolKind.CONSTRUCTOR,
                "Alias" to GleamSymbolKind.TYPE,
                "main" to GleamSymbolKind.FUNCTION,
                "helper" to GleamSymbolKind.FUNCTION,
            ),
            symbols,
        )
    }

    fun testIgnoresImportsAndEmptyFile() {
        assertEquals(emptyList<Pair<String, GleamSymbolKind>>(), collect("import gleam/io\nimport gleam/list"))
        assertEquals(emptyList<Pair<String, GleamSymbolKind>>(), collect(""))
    }
}
