package com.github.themartdev.intellijgleam.ide.common

import com.intellij.openapi.project.Project
import kotlin.io.path.Path

object GleamProjectUtils {
    fun getSrcDir(project: Project): String? {
        val projectPath = project.basePath ?: return null
        return Path(projectPath).resolve("src").toString()
    }
}