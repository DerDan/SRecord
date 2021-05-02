package com.github.derdan.explorerextension

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class SRecordFileType private constructor() : LanguageFileType(SRecordLanguage.INSTANCE) {
    override fun getName(): String {
        return "SRecord File"
    }

    override fun getDescription(): String {
        return "SRecord text file containing binary data"
    }

    override fun getDefaultExtension(): String {
        return "srec"
    }

    override fun getIcon(): Icon? {
        return SRecordIcon.FILE
    }

    companion object {
        @JvmField
        val INSTANCE = SRecordFileType()
    }
}
