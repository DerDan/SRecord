package com.github.derdan.explorerextension.psi;

import com.github.derdan.explorerextension.SRecordLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SRecordTokenType extends IElementType {

    public SRecordTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SRecordLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SRecordTokenType." + super.toString();
    }

}