package com.github.themartdev.intellijgleam

import com.intellij.testFramework.fixtures.IdeaTestExecutionPolicy

fun getGleamTestDataPath(): String  {
    val homePath = IdeaTestExecutionPolicy.getHomePathWithPolicy()
    return "$homePath/src/test/testData"
}

