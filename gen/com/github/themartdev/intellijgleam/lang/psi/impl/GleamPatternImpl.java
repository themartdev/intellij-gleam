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

public class GleamPatternImpl extends ASTWrapperPsiElement implements GleamPattern {

  public GleamPatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitPattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamDiscard getDiscard() {
    return findChildByClass(GleamDiscard.class);
  }

  @Override
  @Nullable
  public GleamListPattern getListPattern() {
    return findChildByClass(GleamListPattern.class);
  }

  @Override
  @Nullable
  public GleamLiteralExpr getLiteralExpr() {
    return findChildByClass(GleamLiteralExpr.class);
  }

  @Override
  @Nullable
  public GleamPatternBitString getPatternBitString() {
    return findChildByClass(GleamPatternBitString.class);
  }

  @Override
  @Nullable
  public GleamRecordPattern getRecordPattern() {
    return findChildByClass(GleamRecordPattern.class);
  }

  @Override
  @Nullable
  public GleamStringPattern getStringPattern() {
    return findChildByClass(GleamStringPattern.class);
  }

  @Override
  @Nullable
  public GleamTuplePattern getTuplePattern() {
    return findChildByClass(GleamTuplePattern.class);
  }

}
