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

public class GleamTypeValueImpl extends ASTWrapperPsiElement implements GleamTypeValue {

  public GleamTypeValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitTypeValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamCustomTypeValue getCustomTypeValue() {
    return findChildByClass(GleamCustomTypeValue.class);
  }

  @Override
  @Nullable
  public GleamOmittedTypeValue getOmittedTypeValue() {
    return findChildByClass(GleamOmittedTypeValue.class);
  }

  @Override
  @Nullable
  public GleamReferenceTypeValue getReferenceTypeValue() {
    return findChildByClass(GleamReferenceTypeValue.class);
  }

}
