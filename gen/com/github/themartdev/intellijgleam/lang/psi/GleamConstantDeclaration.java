// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamConstantDeclaration extends PsiElement {

  @NotNull
  List<GleamAnnotation> getAnnotationList();

  @Nullable
  GleamConstantType getConstantType();

  @Nullable
  GleamExpressionConst getExpressionConst();

  @Nullable
  GleamVisibilityModifier getVisibilityModifier();

  @Nullable
  PsiElement getIdentifier();

}
