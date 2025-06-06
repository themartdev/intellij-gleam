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

public class GleamUnqualifiedImportsImpl extends ASTWrapperPsiElement implements GleamUnqualifiedImports {

  public GleamUnqualifiedImportsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitUnqualifiedImports(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GleamTypeUnqualifiedImport> getTypeUnqualifiedImportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GleamTypeUnqualifiedImport.class);
  }

  @Override
  @NotNull
  public List<GleamUnqualifiedImport> getUnqualifiedImportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GleamUnqualifiedImport.class);
  }

  @Override
  @NotNull
  public List<GleamUpUnqualifiedImport> getUpUnqualifiedImportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GleamUpUnqualifiedImport.class);
  }

}
