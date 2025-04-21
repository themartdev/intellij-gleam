package com.github.themartdev.intellijgleam.ide.ui.components

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.ColoredListCellRenderer
import com.intellij.ui.MutableCollectionComboBoxModel
import com.intellij.ui.SimpleTextAttributes
import com.intellij.ui.components.fields.ExtendableTextField
import java.util.concurrent.ConcurrentHashMap
import javax.swing.JList
import javax.swing.JTextField
import javax.swing.plaf.basic.BasicComboBoxEditor

abstract class AbstractExecutablePathComboBox(protected val project: Project?) :
    ComboBox<String>(MutableCollectionComboBoxModel()) {

    private val versionHints = ConcurrentHashMap<String, String?>()
    private val collectionModel: MutableCollectionComboBoxModel<String>
        get() = model as MutableCollectionComboBoxModel<String>

    init {
        editor = object : BasicComboBoxEditor() {
            override fun createEditorComponent(): JTextField? {
                val editor = ExtendableTextField().addBrowseExtension(::showBrowseDialog, null);
                editor.setBorder(null);
                return editor;
            }
        };
        setEditor(editor);
        setEditable(true);

        renderer = object : ColoredListCellRenderer<String>() {
            override fun customizeCellRenderer(
                list: JList<out String?>,
                value: String?,
                index: Int,
                selected: Boolean,
                hasFocus: Boolean
            ) {
                append(value ?: "<not set>")
                (value?.let { versionHints[it] })?.let {
                    append(" (", SimpleTextAttributes.GRAYED_ATTRIBUTES)
                    append(it, SimpleTextAttributes.GRAYED_ATTRIBUTES)
                    append(")", SimpleTextAttributes.GRAYED_ATTRIBUTES)
                }
            }
        }

        selectedItem = ""
    }

    var selectedPath: String?
        get() = selectedItem as String?
        set(value) {
            if (value == null || value.isEmpty()) {
                selectedItem = null
                return
            }
            addItem(value)
            selectedItem = value
        }

    abstract fun showBrowseDialog()

    /** Expensive version lookup; should return the version string or null */
    protected abstract fun computeVersionInline(path: String): String?

    fun addItems(options: List<String>) {
        options.forEach { addItem(it) }
    }

    override fun addItem(item: String) {
        if (collectionModel.items.contains(item)) return
        collectionModel.add(item)
        ensureVersion(item)
    }

    fun addItem(item: String, version: String?) {
        if (collectionModel.items.contains(item)) return
        collectionModel.add(item)
        versionHints[item] = version
    }

    override fun setSelectedItem(anObject: Any?) {
        if (anObject is String) {
            if (anObject.isNotEmpty()) ensureVersion(anObject)
        }
        super.setSelectedItem(anObject)
    }

    private fun ensureVersion(path: String) {
        if (versionHints.containsKey(path)) return
        val modality = ModalityState.current()
        ApplicationManager.getApplication().executeOnPooledThread {
            val version = computeVersionInline(path)
            ApplicationManager.getApplication().invokeLater({
                versionHints[path] = version
                collectionModel.contentsChanged(path)
            }, modality)
        }
    }
}
