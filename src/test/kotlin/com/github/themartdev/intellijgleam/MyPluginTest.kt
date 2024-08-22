package com.github.themartdev.intellijgleam

import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.BasePlatformTestCase

@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class MyPluginTest : BasePlatformTestCase() {

    override fun getTestDataPath() = "src/test/testData/rename"
}
