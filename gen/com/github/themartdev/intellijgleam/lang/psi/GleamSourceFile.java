// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamSourceFile extends PsiElement {

  @NotNull
  List<GleamExpressionSeq> getExpressionSeqList();

  @NotNull
  List<GleamStatement> getStatementList();

  @NotNull
  List<GleamTargetGroup> getTargetGroupList();

}
