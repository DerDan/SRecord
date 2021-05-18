package com.github.derdan.srecord.psi;

import com.github.derdan.srecord.SRecordLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


public class SRecordElementType extends IElementType {

    public SRecordElementType(@NotNull @NonNls String debugName) {
        super(debugName, SRecordLanguage.INSTANCE);
    }

}