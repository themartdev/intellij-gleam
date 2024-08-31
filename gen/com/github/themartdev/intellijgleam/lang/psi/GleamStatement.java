// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamStatement extends PsiElement {

  @Nullable
  GleamConstant getConstant();

  @Nullable
  GleamExternalFunction getExternalFunction();

  @Nullable
  GleamFunction getFunction();

  @Nullable
  GleamImports getImports();

  @Nullable
  GleamTypeAlias getTypeAlias();

  @Nullable
  GleamTypeDefinition getTypeDefinition();

}
