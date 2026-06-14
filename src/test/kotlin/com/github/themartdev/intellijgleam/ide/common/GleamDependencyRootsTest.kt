package com.github.themartdev.intellijgleam.ide.common

import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.LightPlatformTestCase
import java.io.File

class GleamDependencyRootsTest : LightPlatformTestCase() {
    private lateinit var projectDir: File

    override fun setUp() {
        super.setUp()
        projectDir = FileUtil.createTempDirectory("gleam-project", null)
    }

    override fun tearDown() {
        try {
            FileUtil.delete(projectDir)
        } finally {
            super.tearDown()
        }
    }

    fun `test selects each package src dir, sorted, skipping packages without src and non-dirs`() {
        makePackage("gleeunit", withSrc = true)
        makePackage("gleam_stdlib", withSrc = true)
        makePackage("no_src_pkg", withSrc = false)
        writeFile("build/packages/packages.toml")

        val roots = gleamPackageSrcRoots(packagesDir())

        // sorted by path, so the alphabetically earlier package comes first
        assertEquals(listOf("gleam_stdlib", "gleeunit"), roots.map { it.parent.name })
        assertTrue("every root is a directory named 'src'", roots.all { it.name == "src" && it.isDirectory })
    }

    fun `test returns empty when packages dir is absent`() {
        assertEmpty(gleamPackageSrcRoots(packagesDir()))
    }

    fun `test synthetic library identity follows the root set`() {
        makePackage("a", withSrc = true)
        makePackage("b", withSrc = true)
        val roots = gleamPackageSrcRoots(packagesDir())

        // Equal even across distinct list instances with the same roots...
        assertEquals(GleamSyntheticLibrary(roots), GleamSyntheticLibrary(roots.toList()))
        assertEquals(GleamSyntheticLibrary(roots).hashCode(), GleamSyntheticLibrary(roots.toList()).hashCode())
        // ...and unequal when the root set differs, so the platform reindexes on change.
        assertFalse(GleamSyntheticLibrary(roots) == GleamSyntheticLibrary(roots.dropLast(1)))
    }

    private fun makePackage(name: String, withSrc: Boolean) {
        val pkg = File(projectDir, "build/packages/$name")
        if (withSrc) File(pkg, "src").mkdirs() else pkg.mkdirs()
    }

    private fun writeFile(relativePath: String) {
        File(projectDir, relativePath).apply { parentFile.mkdirs() }.writeText("")
    }

    private fun packagesDir(): VirtualFile? {
        val dir = File(projectDir, "build/packages")
        if (!dir.exists()) return null
        val vf = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(dir) ?: return null
        VfsUtil.markDirtyAndRefresh(false, true, true, vf)
        return vf
    }
}
