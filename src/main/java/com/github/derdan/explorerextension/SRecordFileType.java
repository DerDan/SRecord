package com.github.derdan.explorerextension;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SRecordFileType extends LanguageFileType {
    public static final SRecordFileType INSTANCE = new SRecordFileType();

    private SRecordFileType() {
        super(SRecordLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "SRecord File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "SRecord text file containing binary data";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "srec";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SRecordIcon.FILE;
    }

}

