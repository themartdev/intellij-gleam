package com.github.themartdev.intellijgleam.ide.navigation

import com.github.themartdev.intellijgleam.lang.psi.GleamConstantDeclaration
import com.github.themartdev.intellijgleam.lang.psi.GleamFile
import com.github.themartdev.intellijgleam.lang.psi.GleamFunctionDeclaration
import com.github.themartdev.intellijgleam.lang.psi.GleamTypeDeclaration
import com.intellij.icons.AllIcons
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import javax.swing.Icon

/** The kinds of top-level declaration exposed to "Go to Symbol". */
enum class GleamSymbolKind(val icon: Icon) {
    FUNCTION(AllIcons.Nodes.Function),
    CONSTANT(AllIcons.Nodes.Constant),
    TYPE(AllIcons.Nodes.Class),
    CONSTRUCTOR(AllIcons.Nodes.AbstractClass),
}

/** A navigable top-level symbol: its name, kind, and the identifier element to jump to. */
class GleamSymbol(val name: String, val kind: GleamSymbolKind, val navigationElement: PsiElement)

/**
 * Extracts the top-level symbols of a Gleam file: public and private functions, constants, custom
 * types, and their record constructors. Used both by the symbol index (names only) and by the
 * "Go to Symbol" contributor (which navigates to [GleamSymbol.navigationElement]).
 *
 * The grammar collapses `topLevelDeclaration` into the file, so the declarations are direct
 * children of [GleamFile]; we only walk one level deep (plus into a type's constructors).
 */
object GleamSymbols {
    fun collect(file: GleamFile): List<GleamSymbol> {
        val symbols = ArrayList<GleamSymbol>()
        for (child in file.children) {
            when (child) {
                is GleamFunctionDeclaration ->
                    child.functionNameDefinition?.identifier?.let {
                        symbols.add(GleamSymbol(it.text, GleamSymbolKind.FUNCTION, it))
                    }

                is GleamConstantDeclaration ->
                    child.identifier?.let {
                        symbols.add(GleamSymbol(it.text, GleamSymbolKind.CONSTANT, it))
                    }

                is GleamTypeDeclaration -> {
                    child.typeDeclarationName?.upIdentifier?.let {
                        symbols.add(GleamSymbol(it.text, GleamSymbolKind.TYPE, it))
                    }
                    child.customType?.recordConstructorList?.forEach { ctor ->
                        val id = ctor.constructorIdentifier.upIdentifier
                        symbols.add(GleamSymbol(id.text, GleamSymbolKind.CONSTRUCTOR, id))
                    }
                }
            }
        }
        return symbols
    }

    /**
     * The Gleam module name of a `.gleam` file, e.g. `gleam/io` — the path relative to its source
     * root, slash-separated, without the extension. This is the form Gleam uses in `import`
     * statements. The nearest ancestor directory named `src` or `test` is treated as the root,
     * which covers project sources, tests, and dependencies under `build/packages/<dep>/src/`.
     * Falls back to the bare file name for files outside any such root.
     */
    fun moduleNameOf(file: VirtualFile): String {
        val parts = ArrayDeque<String>()
        var node: VirtualFile? = file
        while (node != null) {
            val parent = node.parent ?: break
            parts.addFirst(if (node === file) node.nameWithoutExtension else node.name)
            if (parent.name == "src" || parent.name == "test") {
                return parts.joinToString("/")
            }
            node = parent
        }
        return file.nameWithoutExtension
    }
}
