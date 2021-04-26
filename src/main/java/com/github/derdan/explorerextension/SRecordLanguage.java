package com.github.derdan.explorerextension;

import com.intellij.lang.Language;

public class SRecordLanguage extends Language {
    public static final SRecordLanguage INSTANCE = new SRecordLanguage();

    private SRecordLanguage() {
        super("SRecord");
    }
}
