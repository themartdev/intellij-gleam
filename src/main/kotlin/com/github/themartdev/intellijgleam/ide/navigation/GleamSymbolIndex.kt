package com.github.themartdev.intellijgleam.ide.navigation

import com.github.themartdev.intellijgleam.lang.GleamFileType
import com.github.themartdev.intellijgleam.lang.psi.GleamFile
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.DefaultFileTypeSpecificInputFilter
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FileContent
import com.intellij.util.indexing.ID
import com.intellij.util.indexing.ScalarIndexExtension
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor

/**
 * A lightweight name index over the top-level symbols of every `.gleam` file (project sources and
 * indexed dependency libraries). It powers "Go to Symbol" via [GleamChooseByNameContributor].
 *
 * The index stores symbol names only (no value); navigation re-walks the matching files' PSI to
 * recover offsets and kinds, which keeps the index cheap and immune to stale offsets. This is the
 * deliberately lighter alternative to PSI stubs: the language server already provides resolution,
 * completion, and find-usages, so the only gap to fill natively is `workspace/symbol`.
 */
class GleamSymbolIndex : ScalarIndexExtension<String>() {
    override fun getName(): ID<String, Void> = NAME

    override fun getIndexer(): DataIndexer<String, Void, FileContent> = DataIndexer { content ->
        val file = content.psiFile as? GleamFile ?: return@DataIndexer emptyMap()
        val result = HashMap<String, Void?>()
        for (symbol in GleamSymbols.collect(file)) {
            result[symbol.name] = null
        }
        result
    }

    override fun getKeyDescriptor(): KeyDescriptor<String> = EnumeratorStringDescriptor.INSTANCE

    override fun getInputFilter(): FileBasedIndex.InputFilter =
        DefaultFileTypeSpecificInputFilter(GleamFileType)

    override fun dependsOnFileContent(): Boolean = true

    override fun getVersion(): Int = 1

    companion object {
        val NAME: ID<String, Void> = ID.create("gleam.symbol.index")
    }
}
