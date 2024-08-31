// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GleamLiteralExpr extends GleamExpression {

  @Nullable
  GleamFloatLiteral getFloatLiteral();

  @Nullable
  GleamIntegerLiteral getIntegerLiteral();

  @Nullable
  GleamStringLiteral getStringLiteral();

  @Nullable
  PsiElement getBooleanLiteral();

}
