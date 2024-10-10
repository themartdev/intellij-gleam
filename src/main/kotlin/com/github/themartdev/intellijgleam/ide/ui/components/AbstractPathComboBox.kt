package com.github.themartdev.intellijgleam.ide.ui.components

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.ColoredListCellRenderer
import com.intellij.ui.MutableCollectionComboBoxModel
import com.intellij.ui.SimpleTextAttributes
import com.intellij.util.ui.JBInsets
import javax.swing.JList

abstract class AbstractPathComboBox(
    protected val project: Project?
) : ComboBox<PathItem>(MutableCollectionComboBoxModel()) {
    protected val collectionModel: MutableCollectionComboBoxModel<PathItem>
        get() = model as MutableCollectionComboBoxModel

    init {
        collectionModel.add(PathItem.None)
        collectionModel.add(PathItem.BrowseAction)
        renderer = PathCellRenderer()
        isEditable = false
        addActionListener {
            val selected = selectedItem
            if (selected is PathItem.BrowseAction) {
                hidePopup()
                showBrowseDialog()
            }
        }

        selectedItem = PathItem.None
    }

    abstract fun showBrowseDialog()


    /**
     * Compute version for item and update it inline. Runs in background thread.
     */
    abstract fun computeVersionInline(item: PathItem.Value)


    fun addItems(options: List<PathItem.Value>) {
        options.forEach { addItem(it) }
    }

    fun addItem(item: PathItem.Value) {
        val existingItem = collectionModel.items.find { it is PathItem.Value && it.path == item.path }
        if (existingItem != null) return
        val browseIndex = collectionModel.getElementIndex(PathItem.BrowseAction)
        collectionModel.add(browseIndex, item)
    }

    var selectedPath: String?
        get() {
            val item = selectedItem as? PathItem
            return when (item) {
                is PathItem.Value -> item.path
                else -> null
            }
        }
        set(value) {
            if (value != null && value != "") {
                // Try to find existing item
                val existingItem = collectionModel.items.find {
                    it is PathItem.Value && it.path == value
                } as? PathItem.Value
                if (existingItem != null) {
                    selectedItem = existingItem
                } else {
                    val customItem = PathItem.Value(value, "unknown")
                    addItem(customItem)
                    selectedItem = customItem
                    computeVersionFor(customItem)
                }
            } else {
                selectedItem = PathItem.None
            }
        }


    private fun computeVersionFor(item: PathItem.Value) {
        val modalityState = ModalityState.current()
        ApplicationManager.getApplication().executeOnPooledThread {
            computeVersionInline(item)
            ApplicationManager.getApplication().invokeLater({
                collectionModel.contentsChanged(item)
            }, modalityState)
        }
    }

    override fun setSelectedItem(anObject: Any?) {
        if (anObject is PathItem.BrowseAction) {
            hidePopup()
            showBrowseDialog()
            return
        }
        super.setSelectedItem(anObject)
    }
}

sealed class PathItem {
    class Value(val path: String, var version: String?) : PathItem() {
        override fun toString(): String = "${shortPath(path)} ($version)"

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Value) return false
            return path == other.path && version == other.version
        }

        override fun hashCode(): Int {
            return path.hashCode()
        }

        fun shortPath(): String {
            return shortPath(path)
        }

        companion object {
            var homePath = System.getenv("HOME") ?: ""
            private fun shortPath(path: String): String {
                return if (path.startsWith(homePath)) {
                    "~" + path.substring(homePath.length)
                } else {
                    path
                }
            }

        }
    }

    object None : PathItem() {
        override fun toString(): String = "<not set>"
    }

    object BrowseAction : PathItem() {
        override fun toString(): String = "Browse..."
    }
}

private class PathCellRenderer : ColoredListCellRenderer<PathItem>() {
    override fun customizeCellRenderer(
        list: JList<out PathItem?>,
        value: PathItem?,
        index: Int,
        selected: Boolean,
        hasFocus: Boolean
    ) {
        ipad = JBInsets(0, 0, 0, 0)
        myBorder = null

        when (value) {
            is PathItem.None -> append("<unset>")
            is PathItem.Value -> {
                append(value.shortPath())
                val version = value.version
                if (version != null) {
                    append(" ")
                    append("(", SimpleTextAttributes.GRAYED_ATTRIBUTES)
                    append(version, SimpleTextAttributes.GRAYED_ATTRIBUTES)
                    append(")", SimpleTextAttributes.GRAYED_ATTRIBUTES)
                }
            }

            is PathItem.BrowseAction -> append("Browse...")
            else -> append("")
        }
    }
}
