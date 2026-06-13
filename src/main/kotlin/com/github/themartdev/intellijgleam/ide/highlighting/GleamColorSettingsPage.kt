package com.github.themartdev.intellijgleam.ide.highlighting

import com.github.themartdev.intellijgleam.GleamIcons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class GleamColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon = GleamIcons.GLEAM

    override fun getHighlighter(): SyntaxHighlighter = GleamSyntaxHighlighter()

    override fun getDemoText(): String = DEMO_TEXT

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> = TAGS

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "Gleam"
}

private val DESCRIPTORS = arrayOf(
    AttributesDescriptor("Comments//Line comment", GleamColors.LINE_COMMENT),
    AttributesDescriptor("Comments//Statement doc comment", GleamColors.FUNCTION_COMMENT),
    AttributesDescriptor("Comments//Module doc comment", GleamColors.MODULE_COMMENT),
    AttributesDescriptor("Keyword", GleamColors.KEYWORD),
    AttributesDescriptor("Annotation", GleamColors.DECORATOR),
    AttributesDescriptor("Identifiers//Type declaration", GleamColors.TYPE_DECLARATION),
    AttributesDescriptor("Identifiers//Type reference", GleamColors.TYPE_REFERENCE),
    AttributesDescriptor("Identifiers//Function declaration", GleamColors.FUNCTION_DECLARATION),
    AttributesDescriptor("Identifiers//Function call", GleamColors.FUNCTION_CALL),
    AttributesDescriptor("Identifiers//Function parameter", GleamColors.FUNCTION_PARAMETERS),
    AttributesDescriptor("Identifiers//Label", GleamColors.LABEL),
    AttributesDescriptor("Strings//String", GleamColors.STRING),
    AttributesDescriptor("Strings//Escape sequence", GleamColors.STRING_ESCAPE),
    AttributesDescriptor("Numbers//Number", GleamColors.VALID_DIGIT),
    AttributesDescriptor("Numbers//Base prefix", GleamColors.BASE_PREFIX),
    AttributesDescriptor("Numbers//Number base", GleamColors.VALID_BASE),
    AttributesDescriptor("Numbers//Invalid number", GleamColors.INVALID_DIGIT),
    AttributesDescriptor("Numbers//Invalid base", GleamColors.INVALID_BASE),
    AttributesDescriptor("Braces and operators//Braces", GleamColors.BRACES),
    AttributesDescriptor("Braces and operators//Brackets", GleamColors.BRACKETS),
    AttributesDescriptor("Braces and operators//Parentheses", GleamColors.PARENTHESES),
    AttributesDescriptor("Braces and operators//Operator", GleamColors.OPERATOR),
    AttributesDescriptor("Braces and operators//Dot", GleamColors.DOT),
    AttributesDescriptor("Braces and operators//Comma", GleamColors.COMMA),
)

// Tags used in DEMO_TEXT for colors that come from the annotator rather than the lexer.
private val TAGS = mapOf(
    "typeDecl" to GleamColors.TYPE_DECLARATION,
    "funcDecl" to GleamColors.FUNCTION_DECLARATION,
    "funcCall" to GleamColors.FUNCTION_CALL,
    "param" to GleamColors.FUNCTION_PARAMETERS,
    "label" to GleamColors.LABEL,
)

private val DEMO_TEXT = """
//// Module documentation comment.

import gleam/io
import gleam/list

/// Documentation for a custom type.
pub type <typeDecl>Shape</typeDecl> {
  <typeDecl>Circle</typeDecl>(radius: Float)
  <typeDecl>Square</typeDecl>
}

const <funcDecl>pi</funcDecl> = 3.14159

@external(erlang, "shapes", "area")
pub fn <funcDecl>area</funcDecl>(<param>shape</param>: Shape) -> Float {
  // A regular line comment.
  let hex = 0xFF
  let invalid = 0z9
  let greeting = "Hello,\t" <> "world!"
  case <param>shape</param> {
    Circle(<label>radius:</label> r) -> pi *. r *. r
    Square -> 0.0
  }
}

pub fn <funcDecl>main</funcDecl>() -> Nil {
  io.<funcCall>println</funcCall>(<funcCall>greeting</funcCall>())
}
""".trimIndent()
