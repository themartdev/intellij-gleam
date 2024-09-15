// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamImportDeclaration extends PsiElement {

  @Nullable
  GleamModulePath getModulePath();

  @Nullable
  GleamUnqualifiedImports getUnqualifiedImports();

  @Nullable
  PsiElement getIdentifier();

  @Nullable PsiElement getNameOrAlias();

}
