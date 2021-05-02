package com.github.derdan.explorerextension

import com.intellij.lang.Language

class SRecordLanguage : Language("SRecord") {
    companion object {
        @kotlin.jvm.JvmField
        var INSTANCE: Language = SRecordLanguage()
    }
}
