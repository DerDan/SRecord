package com.github.derdan.explorerextension.Annotator

import com.github.derdan.explorerextension.SRecordSyntaxHighlighter
import com.github.derdan.explorerextension.psi.SRecordByte_
import com.github.derdan.explorerextension.psi.SRecordData_
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.startOffset

class SRecordAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is SRecordByte_) {
            val parent = element.parent
            if (parent is SRecordData_) {
                val i = parent.children.indexOf(element)
                val rangeToHighlight =  TextRange(element.startOffset, element.startOffset+1)
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(rangeToHighlight).textAttributes(SRecordSyntaxHighlighter.BYTES_KEYS[i % 4]).create()
            }
        }
    }
}