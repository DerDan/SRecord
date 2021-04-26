package com.github.derdan.explorerextension.psi;

import com.github.derdan.explorerextension.SRecordLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


public class SRecordElementType extends IElementType {

    public SRecordElementType(@NotNull @NonNls String debugName) {
        super(debugName, SRecordLanguage.INSTANCE);
    }

}