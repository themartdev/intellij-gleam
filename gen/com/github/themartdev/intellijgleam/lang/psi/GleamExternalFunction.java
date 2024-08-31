// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamExternalFunction extends PsiElement {

  @NotNull
  GleamExternalFunctionBody getExternalFunctionBody();

  @NotNull
  GleamExternalFunctionParameters getExternalFunctionParameters();

  @NotNull
  GleamTypeBase getTypeBase();

  @Nullable
  GleamVisibilityModifier getVisibilityModifier();

  @NotNull
  PsiElement getIdentifier();

}
