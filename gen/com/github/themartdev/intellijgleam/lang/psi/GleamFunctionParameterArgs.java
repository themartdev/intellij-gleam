// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamFunctionParameterArgs extends PsiElement {

  @Nullable
  GleamDiscardParam getDiscardParam();

  @Nullable
  GleamLabeledDiscardParam getLabeledDiscardParam();

  @Nullable
  GleamLabeledNameParam getLabeledNameParam();

  @Nullable
  GleamNameParam getNameParam();

}
