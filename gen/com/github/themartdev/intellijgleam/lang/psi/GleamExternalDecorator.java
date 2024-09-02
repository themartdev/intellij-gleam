// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamExternalDecorator extends GleamDecorator {

  @NotNull
  GleamExternalDecoratorName getExternalDecoratorName();

  @NotNull
  GleamExternalTarget getExternalTarget();

  @NotNull
  List<GleamStringLiteral> getStringLiteralList();

}
