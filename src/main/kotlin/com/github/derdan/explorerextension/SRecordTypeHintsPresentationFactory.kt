package com.github.derdan.explorerextension

import com.intellij.codeInsight.hints.presentation.InlayPresentation
import com.intellij.codeInsight.hints.presentation.PresentationFactory

@Suppress("UnstableApiUsage")
class SRecordTypeHintsPresentationFactory(private val factory: PresentationFactory) {
    fun textHint(t: String): InlayPresentation = factory.roundWithBackground(
        listOf(text(t)).join()
    )

    private fun text(text: String?): InlayPresentation = factory.smallText(text ?: "?")

    private fun List<InlayPresentation>.join(separator: String = ""): InlayPresentation {
        if (separator.isEmpty()) {
            return factory.seq(*toTypedArray())
        }
        val presentations = mutableListOf<InlayPresentation>()
        var first = true
        for (presentation in this) {
            if (!first) {
                presentations.add(text(separator))
            }
            presentations.add(presentation)
            first = false
        }
        return factory.seq(*presentations.toTypedArray())
    }

    fun asciiHint(asciiHint: String): InlayPresentation = factory.text(asciiHint)
}
