import com.github.derdan.explorerextension.psi.*
import com.intellij.codeInsight.hints.*
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbService
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.suggested.startOffset
import javax.swing.JComponent
import javax.swing.JPanel

@Suppress("UnstableApiUsage")
class SRecordInlayHintsProvider : InlayHintsProvider<SRecordInlayHintsProvider.Settings> {
    override val key: SettingsKey<Settings> get() = KEY
    override val name: String get() = "SRecord hints"

    data class Settings(
        var showAddress: Boolean = true,
        var showBytes: Boolean = true,
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
                ImmediateConfigurable.Case("show Address", "showAddress", settings::showAddress),
                ImmediateConfigurable.Case("show Bytes", "showBytes", settings::showBytes),
            )

        override fun createComponent(listener: ChangeListener): JComponent = JPanel()
    }

    override fun createSettings(): Settings = Settings()

    override fun getCollectorFor(
        file: PsiFile, editor: Editor, settings: Settings, sink: InlayHintsSink
    ): InlayHintsCollector = object : FactoryInlayHintsCollector(editor) {
        val typeHintsFactory = SRecordTypeHintsPresentationFactory(factory)
        override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
            if (file.project.service<DumbService>().isDumb) return true
            when (element) {
                is SRecordCount_ -> sink.addInlineElement(element.startOffset, true, typeHintsFactory.textHint("count:"))
                is SRecordAddress_ -> sink.addInlineElement(element.startOffset, true, typeHintsFactory.textHint("addr:"))
                is SRecordData_ -> sink.addInlineElement(element.startOffset, true, typeHintsFactory.textHint("data:"))
                is SRecordChecksum_ -> sink.addInlineElement(element.startOffset, true, typeHintsFactory.textHint("chk:"))
                is SRecordByte_ -> sink.addInlineElement(element.startOffset, true, typeHintsFactory.textHint(""))
            }
//            if ((element is LuxSend
//                        || element is LuxSendLn)
//                && settings.showAddress
//            ) {
//                presentSend(element)
//            }
//            if ((element is LuxExpectRegex
//                        || element is LuxExpectMaybeRegex
//                        || element is LuxExpectTemplate
//                        || element is LuxExpectVerbatim)
//                && settings.showForExpect
//            ) {
//                presentExpect(element)
//            }

            return true
        }

/*
        private fun presentSend(element: PsiElement) {
            when (element) {
                is LuxSend -> {
                    val presentation = typeHintsFactory.textHint("send:")
                    sink.addInlineElement(
                        offset = element.startOffset + 1,
                        relatesToPrecedingText = false,
                        presentation = presentation,
                        placeAtTheEndOfLine = false
                    )
                }
                is LuxSendLn -> {
                    val presentation = typeHintsFactory.textHint("sendln:")
                    sink.addInlineElement(
                        offset = element.startOffset + 1,
                        relatesToPrecedingText = false,
                        presentation = presentation,
                        placeAtTheEndOfLine = false
                    )
                }
            }
        }
*/

/*
        private fun presentExpect(element: PsiElement) {
            when (element) {
                is LuxExpectRegex -> {
                    val presentation =
                        typeHintsFactory.textHint("regex:")
                    sink.addInlineElement(
                        offset = element.startOffset + 1,
                        relatesToPrecedingText = false,
                        presentation = presentation,
                        placeAtTheEndOfLine = false
                    )
                }
                is LuxExpectMaybeRegex -> {
                    val presentation =
                        typeHintsFactory.textHint("maybe regex:")
                    sink.addInlineElement(
                        offset = element.startOffset + 2,
                        relatesToPrecedingText = false,
                        presentation = presentation,
                        placeAtTheEndOfLine = false
                    )
                }
                is LuxExpectTemplate -> {
                    val presentation =
                        typeHintsFactory.textHint("template:")
                    sink.addInlineElement(
                        offset = element.startOffset + 2,
                        relatesToPrecedingText = false,
                        presentation = presentation,
                        placeAtTheEndOfLine = false
                    )
                }
                is LuxExpectVerbatim -> {
                    val presentation =
                        typeHintsFactory.textHint("verbatim:")
                    sink.addInlineElement(
                        offset = element.startOffset + 3,
                        relatesToPrecedingText = false,
                        presentation = presentation,
                        placeAtTheEndOfLine = false
                    )
                }
            }
        }
*/
    }

}


