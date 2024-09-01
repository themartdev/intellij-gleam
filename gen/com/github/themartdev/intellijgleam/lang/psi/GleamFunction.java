// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamFunction extends PsiElement {

  @NotNull
  GleamFunctionBody getFunctionBody();

  @NotNull
  GleamFunctionNameDefinition getFunctionNameDefinition();

  @NotNull
  GleamFunctionParameters getFunctionParameters();

  @Nullable
  GleamTypeBase getTypeBase();

  @Nullable
  GleamVisibilityModifier getVisibilityModifier();

}
