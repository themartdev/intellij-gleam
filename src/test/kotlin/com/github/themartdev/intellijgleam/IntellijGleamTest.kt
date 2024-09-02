package com.github.themartdev.intellijgleam

import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.BasePlatformTestCase

@TestDataPath("\$CONTENT_ROOT/src/test/testData")
abstract class IntellijGleamTest : BasePlatformTestCase() {
    override fun getTestDataPath() = "src/test/testData"
}
