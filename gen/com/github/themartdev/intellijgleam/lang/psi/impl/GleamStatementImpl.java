// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.themartdev.intellijgleam.lang.psi.GleamElementTypes.*;
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
  public GleamExpression getExpression() {
    return findChildByClass(GleamExpression.class);
  }

  @Override
  @Nullable
  public GleamFunctionDeclaration getFunctionDeclaration() {
    return findChildByClass(GleamFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public GleamImportDeclaration getImportDeclaration() {
    return findChildByClass(GleamImportDeclaration.class);
  }

}
