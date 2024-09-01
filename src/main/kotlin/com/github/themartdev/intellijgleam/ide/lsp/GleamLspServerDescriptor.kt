@file:Suppress("UnstableApiUsage")

package com.github.themartdev.intellijgleam.ide.lsp

import com.github.themartdev.intellijgleam.lang.GleamFileType
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class GleamLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "gleam") {
    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file.fileType == GleamFileType
    }

    override fun createCommandLine(): GeneralCommandLine {
        return GeneralCommandLine("/home/simon/.asdf/shims/gleam", "lsp")
    }
}