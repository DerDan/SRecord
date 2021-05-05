package com.github.derdan.explorerextension.linepainter

import com.github.derdan.explorerextension.SRecordFileType
import com.github.derdan.explorerextension.psi.SRecordRecord
import com.intellij.openapi.editor.EditorLinePainter
import com.intellij.openapi.editor.LineExtensionInfo
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.xdebugger.ui.DebuggerColors

class SRecordLinePainter : EditorLinePainter() {
    override fun getLineExtensions(
        project: Project,
        file: VirtualFile,
        lineNumber: Int,
    ): Collection<LineExtensionInfo>? {
        if (file.fileType == SRecordFileType.INSTANCE) {
            val psi = PsiManager.getInstance(project).findFile(file)
            if (psi != null) {
                val record = psi.findElementAt(0)
                if (record is SRecordRecord) {
                    val attributes =
                        EditorColorsManager.getInstance().globalScheme.getAttributes(DebuggerColors.INLINED_VALUES)
                    return listOf(LineExtensionInfo("  Hallo Welt", attributes))
                }
            }
        }
        return null
    }
}
