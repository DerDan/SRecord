// This is a generated file. Not intended for manual editing.
package com.github.derdan.explorerextension.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.derdan.explorerextension.psi.SRecordTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.derdan.explorerextension.psi.*;

public class SRecordRecordImpl extends ASTWrapperPsiElement implements SRecordRecord {

  public SRecordRecordImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SRecordVisitor visitor) {
    visitor.visitRecord(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SRecordVisitor) accept((SRecordVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SRecordBlockRecord getBlockRecord() {
    return findChildByClass(SRecordBlockRecord.class);
  }

  @Override
  @Nullable
  public SRecordCountRecord16 getCountRecord16() {
    return findChildByClass(SRecordCountRecord16.class);
  }

  @Override
  @Nullable
  public SRecordCountRecord24 getCountRecord24() {
    return findChildByClass(SRecordCountRecord24.class);
  }

  @Override
  @Nullable
  public SRecordDataRecord16 getDataRecord16() {
    return findChildByClass(SRecordDataRecord16.class);
  }

  @Override
  @Nullable
  public SRecordDataRecord24 getDataRecord24() {
    return findChildByClass(SRecordDataRecord24.class);
  }

  @Override
  @Nullable
  public SRecordDataRecord32 getDataRecord32() {
    return findChildByClass(SRecordDataRecord32.class);
  }

  @Override
  @Nullable
  public SRecordStartRecord16 getStartRecord16() {
    return findChildByClass(SRecordStartRecord16.class);
  }

  @Override
  @Nullable
  public SRecordStartRecord24 getStartRecord24() {
    return findChildByClass(SRecordStartRecord24.class);
  }

  @Override
  @Nullable
  public SRecordStartRecord32 getStartRecord32() {
    return findChildByClass(SRecordStartRecord32.class);
  }

}
