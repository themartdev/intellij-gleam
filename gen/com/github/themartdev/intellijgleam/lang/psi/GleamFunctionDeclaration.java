// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamFunctionDeclaration extends PsiElement {

  @NotNull
  List<GleamAnnotation> getAnnotationList();

  @Nullable
  GleamFunctionBody getFunctionBody();

  @Nullable
  GleamFunctionNameDefinition getFunctionNameDefinition();

  @Nullable
  GleamFunctionParameters getFunctionParameters();

  @Nullable
  GleamTypeBase getTypeBase();

  @Nullable
  GleamVisibilityModifier getVisibilityModifier();

}
