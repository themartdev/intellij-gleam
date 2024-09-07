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

public class GleamConstantTypeSpecialImpl extends ASTWrapperPsiElement implements GleamConstantTypeSpecial {

  public GleamConstantTypeSpecialImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GleamVisitor visitor) {
    visitor.visitConstantTypeSpecial(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GleamVisitor) accept((GleamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GleamConstantType getConstantType() {
    return findChildByClass(GleamConstantType.class);
  }

  @Override
  @Nullable
  public GleamConstantTypeFunction getConstantTypeFunction() {
    return findChildByClass(GleamConstantTypeFunction.class);
  }

  @Override
  @Nullable
  public GleamConstantTypeTuple getConstantTypeTuple() {
    return findChildByClass(GleamConstantTypeTuple.class);
  }

  @Override
  @Nullable
  public GleamQualifiedTypeName getQualifiedTypeName() {
    return findChildByClass(GleamQualifiedTypeName.class);
  }

  @Override
  @Nullable
  public GleamUnqualifiedTypeName getUnqualifiedTypeName() {
    return findChildByClass(GleamUnqualifiedTypeName.class);
  }

}
