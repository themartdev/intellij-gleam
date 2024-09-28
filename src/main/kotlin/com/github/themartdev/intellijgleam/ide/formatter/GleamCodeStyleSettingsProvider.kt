package com.github.themartdev.intellijgleam.ide.formatter

import com.github.themartdev.intellijgleam.lang.GleamLanguage
import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.IndentOptionsEditor
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.*
import com.intellij.psi.codeStyle.CommonCodeStyleSettings.IndentOptions

class GleamLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
    override fun getLanguage() = GleamLanguage

    override fun getConfigurableDisplayName(): String = GleamLanguage.displayName

    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings =
        GleamCodeStyleSettings(settings)

    override fun customizeDefaults(commonSettings: CommonCodeStyleSettings, indentOptions: IndentOptions) {
        indentOptions.apply {
            INDENT_SIZE = 2
            CONTINUATION_INDENT_SIZE = 2
            TAB_SIZE = 2
            USE_TAB_CHARACTER = false
        }
    }


    override fun createConfigurable(
        baseSettings: CodeStyleSettings,
        modelSettings: CodeStyleSettings
    ): CodeStyleConfigurable {
        return object : CodeStyleAbstractConfigurable(baseSettings, modelSettings, configurableDisplayName) {
            override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel =
                GleamCodeStyleMainPanel(currentSettings, settings)
        }
    }

    override fun getCodeSample(settingsType: SettingsType): String {
        return """
        type MyType {
            MyTypeConstructor(Int, String)
        }
            
        fn example_function() {
          let x = 1
          x + 2
          case x {
            1 -> "one"
            2 -> {
              "two"
            }
            _ -> "other"
          }
        }
        """
    }

    override fun getIndentOptionsEditor(): IndentOptionsEditor? {
        return IndentOptionsEditor()
    }
}

class GleamCodeStyleMainPanel(currentSettings: CodeStyleSettings, settings: CodeStyleSettings) :
    TabbedLanguageCodeStylePanel(GleamLanguage, currentSettings, settings) {
    override fun initTabs(settings: CodeStyleSettings) {
        addIndentOptionsTab(settings)
//        addTab(PrismaCodeStyleOtherPanel(settings))
    }
}
