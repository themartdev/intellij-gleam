// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamRecordConstructorParameters extends PsiElement {

  @NotNull
  List<GleamLabeledParameter> getLabeledParameterList();

  @NotNull
  List<GleamUnlabeledParameter> getUnlabeledParameterList();

}
