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

public class GleamExternalFunctionNoFallbackDeclarationImpl extends ASTWrapperPsiElement implements GleamExternalFunctionNoFallbackDeclaration {

  public GleamExternalFunctionNoFallbackDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitExternalFunctionNoFallbackDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GleamExternalDecorator> getExternalDecoratorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GleamExternalDecorator.class);
  }

  @Override
  @Nullable
  public GleamExternalFunctionSignature getExternalFunctionSignature() {
    return findChildByClass(GleamExternalFunctionSignature.class);
  }

}
