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

public class GleamConstantDeclarationImpl extends ASTWrapperPsiElement implements GleamConstantDeclaration {

  public GleamConstantDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitConstantDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamConstantTypeAnnotation getConstantTypeAnnotation() {
    return findChildByClass(GleamConstantTypeAnnotation.class);
  }

  @Override
  @Nullable
  public GleamExpressionConst getExpressionConst() {
    return findChildByClass(GleamExpressionConst.class);
  }

  @Override
  @Nullable
  public GleamVisibilityModifier getVisibilityModifier() {
    return findChildByClass(GleamVisibilityModifier.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
