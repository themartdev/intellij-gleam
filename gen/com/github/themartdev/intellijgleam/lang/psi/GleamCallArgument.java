// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamCallArgument extends PsiElement {

  @Nullable
  GleamLabeledArgument getLabeledArgument();

  @Nullable
  GleamShortHandLabeledArgument getShortHandLabeledArgument();

  @Nullable
  GleamUnlabeledArgument getUnlabeledArgument();

}
