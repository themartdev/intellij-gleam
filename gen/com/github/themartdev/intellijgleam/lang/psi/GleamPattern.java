// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamPattern extends PsiElement {

  @Nullable
  GleamDiscard getDiscard();

  @Nullable
  GleamListPattern getListPattern();

  @Nullable
  GleamLiteralExpr getLiteralExpr();

  @Nullable
  GleamPatternBitString getPatternBitString();

  @Nullable
  GleamRecordPattern getRecordPattern();

  @Nullable
  GleamStringPattern getStringPattern();

  @Nullable
  GleamTuplePattern getTuplePattern();

}
