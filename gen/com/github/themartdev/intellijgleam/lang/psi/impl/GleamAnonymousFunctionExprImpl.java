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

public class GleamAnonymousFunctionExprImpl extends GleamExpressionImpl implements GleamAnonymousFunctionExpr {

  public GleamAnonymousFunctionExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitAnonymousFunctionExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GleamAnonymousFunctionParameters getAnonymousFunctionParameters() {
    return findNotNullChildByClass(GleamAnonymousFunctionParameters.class);
  }

  @Override
  @NotNull
  public GleamFunctionBody getFunctionBody() {
    return findNotNullChildByClass(GleamFunctionBody.class);
  }

  @Override
  @Nullable
  public GleamTypeReference getTypeReference() {
    return findChildByClass(GleamTypeReference.class);
  }

}
