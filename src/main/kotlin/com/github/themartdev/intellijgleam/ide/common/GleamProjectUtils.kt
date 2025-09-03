package com.github.themartdev.intellijgleam.ide.common

import com.intellij.openapi.project.Project

object GleamProjectUtils {
    fun getSrcDir(project: Project): String? {
        val projectPath = project.basePath ?: return null
        val sep = java.io.File.separator
        return if (projectPath.endsWith(sep)) projectPath + "src" else projectPath + sep + "src"
    }
}