// This is a generated file. Not intended for manual editing.
package com.github.derdan.explorerextension.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SRecordRecord extends PsiElement {

  @Nullable
  SRecordBlockRecord getBlockRecord();

  @Nullable
  SRecordCountRecord16 getCountRecord16();

  @Nullable
  SRecordCountRecord24 getCountRecord24();

  @Nullable
  SRecordDataRecord16 getDataRecord16();

  @Nullable
  SRecordDataRecord24 getDataRecord24();

  @Nullable
  SRecordDataRecord32 getDataRecord32();

  @Nullable
  SRecordStartRecord16 getStartRecord16();

  @Nullable
  SRecordStartRecord24 getStartRecord24();

  @Nullable
  SRecordStartRecord32 getStartRecord32();

}
