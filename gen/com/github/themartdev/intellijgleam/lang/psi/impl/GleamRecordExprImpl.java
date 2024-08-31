// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.themartdev.intellijgleam.lang.psi.GleamTypes.*;
import com.github.themartdev.intellijgleam.lang.psi.*;

public class GleamRecordExprImpl extends GleamExpressionImpl implements GleamRecordExpr {

  public GleamRecordExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitRecordExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamArguments getArguments() {
    return findChildByClass(GleamArguments.class);
  }

  @Override
  @Nullable
  public GleamConstructorIdentifier getConstructorIdentifier() {
    return findChildByClass(GleamConstructorIdentifier.class);
  }

  @Override
  @Nullable
  public GleamRemoteConstructorIdentifier getRemoteConstructorIdentifier() {
    return findChildByClass(GleamRemoteConstructorIdentifier.class);
  }

}
