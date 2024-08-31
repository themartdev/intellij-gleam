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

public class GleamStatementImpl extends ASTWrapperPsiElement implements GleamStatement {

  public GleamStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamConstant getConstant() {
    return findChildByClass(GleamConstant.class);
  }

  @Override
  @Nullable
  public GleamExternalFunction getExternalFunction() {
    return findChildByClass(GleamExternalFunction.class);
  }

  @Override
  @Nullable
  public GleamFunction getFunction() {
    return findChildByClass(GleamFunction.class);
  }

  @Override
  @Nullable
  public GleamImports getImports() {
    return findChildByClass(GleamImports.class);
  }

  @Override
  @Nullable
  public GleamTypeAlias getTypeAlias() {
    return findChildByClass(GleamTypeAlias.class);
  }

  @Override
  @Nullable
  public GleamTypeDefinition getTypeDefinition() {
    return findChildByClass(GleamTypeDefinition.class);
  }

}
