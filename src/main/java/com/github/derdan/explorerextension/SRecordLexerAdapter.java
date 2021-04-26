package com.github.derdan.explorerextension;

import com.intellij.lexer.FlexAdapter;

public class SRecordLexerAdapter extends FlexAdapter {
    public SRecordLexerAdapter() {
        super(new SRecordLexer(null));
    }
}
