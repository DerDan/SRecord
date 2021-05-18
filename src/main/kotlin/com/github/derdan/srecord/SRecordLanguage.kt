package com.github.derdan.srecord

import com.intellij.lang.Language

class SRecordLanguage : Language("SRecord") {
    companion object {
        @kotlin.jvm.JvmField
        var INSTANCE: Language = SRecordLanguage()
    }
}
