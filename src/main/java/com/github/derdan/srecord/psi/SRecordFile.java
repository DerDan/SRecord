package com.github.derdan.srecord.psi;

import com.github.derdan.srecord.SRecordFileType;
import com.github.derdan.srecord.SRecordLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class SRecordFile extends PsiFileBase {

    public SRecordFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SRecordLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SRecordFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "SRecord File";
    }
}
