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

public class SRecordDataRecord24Impl extends ASTWrapperPsiElement implements SRecordDataRecord24 {

  public SRecordDataRecord24Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SRecordVisitor visitor) {
    visitor.visitDataRecord24(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SRecordVisitor) accept((SRecordVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SRecordAddress24 getAddress24() {
    return findNotNullChildByClass(SRecordAddress24.class);
  }

  @Override
  @NotNull
  public SRecordByteCount getByteCount() {
    return findNotNullChildByClass(SRecordByteCount.class);
  }

  @Override
  @NotNull
  public SRecordData getData() {
    return findNotNullChildByClass(SRecordData.class);
  }

}
