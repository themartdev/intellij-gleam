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

public class GleamLiteralExprConstImpl extends GleamExpressionConstImpl implements GleamLiteralExprConst {

  public GleamLiteralExprConstImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitLiteralExprConst(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamFloatLiteral getFloatLiteral() {
    return findChildByClass(GleamFloatLiteral.class);
  }

  @Override
  @Nullable
  public GleamIntegerLiteral getIntegerLiteral() {
    return findChildByClass(GleamIntegerLiteral.class);
  }

  @Override
  @Nullable
  public GleamStringLiteral getStringLiteral() {
    return findChildByClass(GleamStringLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getBooleanLiteral() {
    return findChildByType(BOOLEAN_LITERAL);
  }

}
