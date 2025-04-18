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

public class GleamUseExprImpl extends GleamExpressionImpl implements GleamUseExpr {

  public GleamUseExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitUseExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamExpression getExpression() {
    return findChildByClass(GleamExpression.class);
  }

  @Override
  @NotNull
  public List<GleamPatternAliasable> getPatternAliasableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GleamPatternAliasable.class);
  }

  @Override
  @Nullable
  public GleamTypeAnnotation getTypeAnnotation() {
    return findChildByClass(GleamTypeAnnotation.class);
  }

}
