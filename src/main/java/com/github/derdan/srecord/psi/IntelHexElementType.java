package com.github.derdan.srecord.psi;

import com.github.derdan.srecord.SRecordLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


public class IntelHexElementType extends IElementType {

    public IntelHexElementType(@NotNull @NonNls String debugName) {
        super(debugName, SRecordLanguage.INSTANCE);
    }

}