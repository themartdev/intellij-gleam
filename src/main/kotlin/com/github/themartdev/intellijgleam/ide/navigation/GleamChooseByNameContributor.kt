package com.github.themartdev.intellijgleam.ide.navigation

import com.github.themartdev.intellijgleam.lang.psi.GleamFile
import com.intellij.ide.util.PsiNavigationSupport
import com.intellij.navigation.ChooseByNameContributorEx
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.Processor
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FindSymbolParameters
import com.intellij.util.indexing.IdFilter
import javax.swing.Icon

/** Feeds Gleam top-level symbols into the IDE's "Go to Symbol" popup, backed by [GleamSymbolIndex]. */
class GleamChooseByNameContributor : ChooseByNameContributorEx {
    override fun processNames(processor: Processor<in String>, scope: GlobalSearchScope, filter: IdFilter?) {
        FileBasedIndex.getInstance().processAllKeys(GleamSymbolIndex.NAME, processor, scope, filter)
    }

    override fun processElementsWithName(
        name: String,
        processor: Processor<in NavigationItem>,
        parameters: FindSymbolParameters,
    ) {
        val project = parameters.project
        val psiManager = PsiManager.getInstance(project)
        val files = FileBasedIndex.getInstance()
            .getContainingFiles(GleamSymbolIndex.NAME, name, parameters.searchScope)
            .toSet()
        for (virtualFile in files) {
            if (!virtualFile.isValid) continue
            val gleamFile = psiManager.findFile(virtualFile) as? GleamFile ?: continue
            for (symbol in GleamSymbols.collect(gleamFile)) {
                if (symbol.name != name) continue
                val item = GleamSymbolNavigationItem(
                    name = symbol.name,
                    icon = symbol.kind.icon,
                    project = project,
                    virtualFile = virtualFile,
                    offset = symbol.navigationElement.textOffset,
                    location = GleamSymbols.moduleNameOf(virtualFile),
                )
                if (!processor.process(item)) return
            }
        }
    }
}

/**
 * A [NavigationItem] for a Gleam symbol. Navigation is captured as a (file, offset) pair rather
 * than holding the PSI element, so it stays valid even if the PSI is reparsed before the user picks
 * a result.
 */
private class GleamSymbolNavigationItem(
    private val name: String,
    private val icon: Icon,
    private val project: Project,
    private val virtualFile: VirtualFile,
    private val offset: Int,
    private val location: String,
) : NavigationItem, ItemPresentation {
    override fun getName(): String = name

    override fun getPresentation(): ItemPresentation = this

    override fun getPresentableText(): String = name

    override fun getLocationString(): String = location

    override fun getIcon(unused: Boolean): Icon = icon

    override fun navigate(requestFocus: Boolean) {
        if (virtualFile.isValid) {
            PsiNavigationSupport.getInstance()
                .createNavigatable(project, virtualFile, offset)
                .navigate(requestFocus)
        }
    }

    override fun canNavigate(): Boolean = virtualFile.isValid

    override fun canNavigateToSource(): Boolean = canNavigate()

    // The Go to Symbol popup de-duplicates results via a set keyed on equals/hashCode. PSI-backed
    // items get this for free; this wrapper must define identity by its target (file + offset +
    // name) so the same declaration isn't listed once per scope/search pass.
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GleamSymbolNavigationItem) return false
        return offset == other.offset && name == other.name && virtualFile == other.virtualFile
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + virtualFile.hashCode()
        result = 31 * result + offset
        return result
    }
}
