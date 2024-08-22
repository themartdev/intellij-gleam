package com.github.themartdev.intellijgleam

import com.intellij.DynamicBundle
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey

@NonNls
private const val GLEAM_BUNDLE = "messages.GleamBundle"

object GleamBundle : DynamicBundle(GLEAM_BUNDLE) {

    @JvmStatic
    fun message(@PropertyKey(resourceBundle = GLEAM_BUNDLE) key: String, vararg params: Any) =
        getMessage(key, *params)

    @Suppress("unused")
    @JvmStatic
    fun messagePointer(@PropertyKey(resourceBundle = GLEAM_BUNDLE) key: String, vararg params: Any) =
        getLazyMessage(key, *params)
}
