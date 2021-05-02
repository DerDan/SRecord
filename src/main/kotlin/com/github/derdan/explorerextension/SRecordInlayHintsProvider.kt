package com.github.derdan.explorerextension

import com.github.derdan.explorerextension.psi.*
import com.intellij.codeInsight.hints.*
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbService
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import javax.swing.JComponent
import javax.swing.JPanel

@Suppress("UnstableApiUsage")
class SRecordInlayHintsProvider : InlayHintsProvider<SRecordInlayHintsProvider.Settings> {
    override val key: SettingsKey<Settings> get() = KEY
    override val name: String get() = "SRecord hints"
    var numberOfRequiredAsciiChars = 2
    var firstPrintableChar = 0x20
    var lastPrintableChar = 0x7f
    var hexRadix = 16

    data class Settings(
        var showCount: Boolean = true,
        var showAddress: Boolean = true,
        var showBytes: Boolean = true,
        var showData: Boolean = true,
        var showAscii: Boolean = true,
        var showChecksum: Boolean = true,
    )

    companion object {
        private val KEY: SettingsKey<Settings> =
            SettingsKey("srecord.record.hints")
    }

    override val previewText: String
        get() = "S11308801073453001107393114168616E6E657089\n" +
                "S1130890856027003023011000702724261114BB23\n"

    override fun createConfigurable(settings: Settings): ImmediateConfigurable = object : ImmediateConfigurable {
        override val cases: List<ImmediateConfigurable.Case>
            get() = listOf(
                ImmediateConfigurable.Case("show Count", "showCount", settings::showCount),
                ImmediateConfigurable.Case("show Address", "showAddress", settings::showAddress),
                ImmediateConfigurable.Case("show Bytes", "showBytes", settings::showBytes),
                ImmediateConfigurable.Case("show Data", "showData", settings::showData),
                ImmediateConfigurable.Case("show ASCII", "showData", settings::showAscii),
                ImmediateConfigurable.Case("show Checksum", "showChecksum", settings::showChecksum),
            )

        override fun createComponent(listener: ChangeListener): JComponent = JPanel()
    }

    override fun createSettings(): Settings = Settings()

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: Settings, sink: InlayHintsSink):
            InlayHintsCollector =
        object : FactoryInlayHintsCollector(editor) {
            val typeHintsFactory = SRecordTypeHintsPresentationFactory(factory)
            override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
                if (file.project.service<DumbService>().isDumb) return true
                when (element) {
                    is SRecordCount_ -> if (settings.showCount) sink.addInlineElement(element.startOffset, true,
                        typeHintsFactory.textHint("count:"))
                    is SRecordAddress_ -> if (settings.showAddress) sink.addInlineElement(element.startOffset,
                        true,
                        typeHintsFactory.textHint("addr:"))
                    is SRecordByte_ -> {
                        if (settings.showBytes) {
                            sink.addInlineElement(element.startOffset, true, factory.textSpacePlaceholder(1, true))
                        }
                    }
                    is SRecordData_ -> {
                        if (settings.showData) {
                            sink.addInlineElement(element.startOffset, false, typeHintsFactory.textHint("data:"))
                            if (!settings.showAscii) {
                                sink.addInlineElement(element.endOffset, true, typeHintsFactory.textHint("<-end"))
                            }
                        }
                        if (settings.showAscii) {
                            var asciiHint = ""
                            element.byte_List.forEach(action = { asciiHint += getAscii(it.text) })
                            sink.addInlineElement(element.endOffset, true, factory.text(asciiHint))
                        }
                    }
                    is SRecordChecksum_ -> if (settings.showChecksum) sink.addInlineElement(element.startOffset,
                        true,
                        typeHintsFactory.textHint("chk:"))
                }
                return true
            }
        }

    private fun getAscii(text: String): String {
        if (text.length != numberOfRequiredAsciiChars) {
            return "?"
        }
        val hex = Integer.parseInt(text, hexRadix)
        if ((hex >= firstPrintableChar) && (hex <= lastPrintableChar)) return hex.toChar().toString()
        return "."
    }
}
