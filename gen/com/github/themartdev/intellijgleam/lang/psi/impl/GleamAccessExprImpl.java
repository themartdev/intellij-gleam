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

public class GleamAccessExprImpl extends GleamExpressionImpl implements GleamAccessExpr {

  public GleamAccessExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitAccessExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GleamExpression getExpression() {
    return findNotNullChildByClass(GleamExpression.class);
  }

  @Override
  @Nullable
  public GleamLabel getLabel() {
    return findChildByClass(GleamLabel.class);
  }

  @Override
  @Nullable
  public GleamWholeNumber getWholeNumber() {
    return findChildByClass(GleamWholeNumber.class);
  }

}
