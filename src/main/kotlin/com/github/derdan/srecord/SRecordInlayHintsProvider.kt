package com.github.derdan.srecord

import com.github.derdan.srecord.psi.*
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

    data class Settings(
        var showCount: Boolean = true,
        var showAddress: Boolean = true,
        var showBytes: Boolean = true,
        var showData: Boolean = true,
        var showChecksum: Boolean = true,
    )

    companion object {
        private val KEY: SettingsKey<Settings> = SettingsKey("srecord.record.hints")
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
                ImmediateConfigurable.Case("show Checksum", "showChecksum", settings::showChecksum),
            )

        override fun createComponent(listener: ChangeListener): JComponent = JPanel()
    }

    override fun createSettings(): Settings = Settings()

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: Settings, sink: InlayHintsSink):
        InlayHintsCollector = object : FactoryInlayHintsCollector(editor) {
            val typeHintsFactory = SRecordTypeHintsPresentationFactory(factory)
            override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
                if (file.project.service<DumbService>().isDumb) return true
                when (element) {
                    is SRecordCount_ -> if (settings.showCount) sink.addInlineElement(
                        element.startOffset, true,
                        typeHintsFactory.textHint("count:"), false
                    )
                    is SRecordAddress_ -> if (settings.showAddress) sink.addInlineElement(
                        element.startOffset,
                        true,
                        typeHintsFactory.textHint("addr:"), false
                    )
                    is SRecordByte_ -> {
                        if (settings.showBytes) {
                            sink.addInlineElement(
                                element.startOffset,
                                true,
                                factory.textSpacePlaceholder(1, true),
                                false
                            )
                        }
                    }
                    is SRecordData_ -> {
                        if (settings.showData) {
                            sink.addInlineElement(element.startOffset, false, typeHintsFactory.textHint("data:"), false)
                            sink.addInlineElement(element.endOffset, true, typeHintsFactory.textHint("<-end"), false)
                        }
                    }
                    is SRecordChecksum_ -> if (settings.showChecksum) sink.addInlineElement(
                        element.startOffset,
                        true,
                        typeHintsFactory.textHint("chk:"), false
                    )
                }
                return true
            }
        }
}
