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

public class GleamExternalDecoratorImpl extends GleamDecoratorImpl implements GleamExternalDecorator {

  public GleamExternalDecoratorImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitExternalDecorator(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GleamExternalDecoratorName getExternalDecoratorName() {
    return findNotNullChildByClass(GleamExternalDecoratorName.class);
  }

  @Override
  @NotNull
  public GleamExternalTarget getExternalTarget() {
    return findNotNullChildByClass(GleamExternalTarget.class);
  }

  @Override
  @NotNull
  public List<GleamStringLiteral> getStringLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GleamStringLiteral.class);
  }

}
