package com.github.derdan.explorerextension.psi;

import com.github.derdan.explorerextension.SRecordFileType;
import com.github.derdan.explorerextension.SRecordLanguage;
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