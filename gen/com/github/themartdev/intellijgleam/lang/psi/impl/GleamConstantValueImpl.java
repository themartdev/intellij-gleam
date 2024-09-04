// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.themartdev.intellijgleam.lang.psi.GleamTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.themartdev.intellijgleam.lang.psi.*;

public class GleamConstantValueImpl extends ASTWrapperPsiElement implements GleamConstantValue {

  public GleamConstantValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitConstantValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamConstantBitArray getConstantBitArray() {
    return findChildByClass(GleamConstantBitArray.class);
  }

  @Override
  @Nullable
  public GleamConstantFieldAccess getConstantFieldAccess() {
    return findChildByClass(GleamConstantFieldAccess.class);
  }

  @Override
  @Nullable
  public GleamConstantList getConstantList() {
    return findChildByClass(GleamConstantList.class);
  }

  @Override
  @Nullable
  public GleamConstantRecord getConstantRecord() {
    return findChildByClass(GleamConstantRecord.class);
  }

  @Override
  @Nullable
  public GleamConstantTuple getConstantTuple() {
    return findChildByClass(GleamConstantTuple.class);
  }

  @Override
  @Nullable
  public GleamLiteralExpr getLiteralExpr() {
    return findChildByClass(GleamLiteralExpr.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
