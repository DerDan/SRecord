package com.github.derdan.explorerextension.linepainter

import com.github.derdan.explorerextension.SRecordFileType
import com.github.derdan.explorerextension.SRecordUtils
import com.github.derdan.explorerextension.psi.SRecordRecord
import com.intellij.openapi.editor.EditorLinePainter
import com.intellij.openapi.editor.LineExtensionInfo
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.xdebugger.ui.DebuggerColors
import org.jetbrains.annotations.Nullable

class SRecordLinePainter : EditorLinePainter() {
    override fun getLineExtensions(
        project: Project,
        file: VirtualFile,
        lineNumber: Int,
    ): Collection<LineExtensionInfo>? {
        val record = getElement(file, project, lineNumber)
        val parent1 = record?.parent
        val parent2 = parent1?.parent
        val parent3 = parent2?.parent
        var text = ""
        if (parent3 is SRecordRecord) {
            val attributes =
                EditorColorsManager.getInstance().globalScheme.getAttributes(DebuggerColors.INLINED_VALUES)
            var data = parent3.blockRecord?.data_
            if (data == null) data = parent3.dataRecord16?.data_
            if (data == null) data = parent3.dataRecord24?.data_
            if (data == null) data = parent3.dataRecord32?.data_
            if (data != null) {
                text = SRecordUtils.getAsciiText(data)
            } else {
                if (parent3.startRecord16 != null) {
                    text = "= start address"
                }
                if (parent3.startRecord24 != null) {
                    text = "= start address"
                }
                if (parent3.startRecord32 != null) {
                    text = "= start address"
                }
            }
            if (text.isNotEmpty()) {
                return listOf(LineExtensionInfo("  " + text, attributes))
            }
        }
        return null
    }

    private fun getElement(
        file: VirtualFile,
        project: Project,
        lineNumber: Int
    ): @Nullable PsiElement? {
        if (file.fileType == SRecordFileType.INSTANCE) {
            val psi = PsiManager.getInstance(project).findFile(file)
            if (psi != null) {
                val doc = FileDocumentManager.getInstance().getDocument(file)
                if (doc != null) {
                    val offset = doc.getLineStartOffset(lineNumber)
                    return psi.findElementAt(offset)
                }
            }
        }
        return null
    }
}
