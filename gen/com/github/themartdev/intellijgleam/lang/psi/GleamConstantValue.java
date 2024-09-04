// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamConstantValue extends PsiElement {

  @Nullable
  GleamConstantBitArray getConstantBitArray();

  @Nullable
  GleamConstantFieldAccess getConstantFieldAccess();

  @Nullable
  GleamConstantList getConstantList();

  @Nullable
  GleamConstantRecord getConstantRecord();

  @Nullable
  GleamConstantTuple getConstantTuple();

  @Nullable
  GleamLiteralExpr getLiteralExpr();

  @Nullable
  PsiElement getIdentifier();

}
