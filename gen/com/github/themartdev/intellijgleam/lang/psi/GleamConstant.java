// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamConstant extends PsiElement {

  @Nullable
  GleamConstantTypeAnnotation getConstantTypeAnnotation();

  @NotNull
  GleamConstantValue getConstantValue();

  @Nullable
  GleamVisibilityModifier getVisibilityModifier();

  @NotNull
  PsiElement getIdentifier();

}
