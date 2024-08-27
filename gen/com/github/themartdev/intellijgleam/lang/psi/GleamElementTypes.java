// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.themartdev.intellijgleam.lang.psi.impl.*;

public interface GleamElementTypes {

  IElementType ARGUMENT_LIST = new GleamElementType("ARGUMENT_LIST");
  IElementType BLOCK = new GleamElementType("BLOCK");
  IElementType EXPRESSION = new GleamElementType("EXPRESSION");
  IElementType FUNCTION_CALL = new GleamElementType("FUNCTION_CALL");
  IElementType FUNCTION_DECLARATION = new GleamElementType("FUNCTION_DECLARATION");
  IElementType IMPORT_DECLARATION = new GleamElementType("IMPORT_DECLARATION");
  IElementType IMPORT_LIST = new GleamElementType("IMPORT_LIST");
  IElementType IMPORT_PATH = new GleamElementType("IMPORT_PATH");
  IElementType PARAMETER = new GleamElementType("PARAMETER");
  IElementType PARAMETER_LIST = new GleamElementType("PARAMETER_LIST");
  IElementType STATEMENT = new GleamElementType("STATEMENT");
  IElementType STRING_LITERAL = new GleamElementType("STRING_LITERAL");

  IElementType AS = new IElementType("as", null);
  IElementType COMMA = new IElementType(",", null);
  IElementType DOT = new IElementType(".", null);
  IElementType FN = new IElementType("fn", null);
  IElementType FUNCTION_COMMENT = new IElementType("FUNCTION_COMMENT", null);
  IElementType IDENTIFIER = new IElementType("IDENTIFIER", null);
  IElementType IMPORT = new IElementType("import", null);
  IElementType LBRACE = new IElementType("{", null);
  IElementType LBRACK = new IElementType("[", null);
  IElementType LINE_COMMENT = new IElementType("LINE_COMMENT", null);
  IElementType LPAREN = new IElementType("(", null);
  IElementType MODULE_COMMENT = new IElementType("MODULE_COMMENT", null);
  IElementType PUB = new IElementType("pub", null);
  IElementType RBRACE = new IElementType("}", null);
  IElementType RBRACK = new IElementType("]", null);
  IElementType RPAREN = new IElementType(")", null);

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT_LIST) {
        return new GleamArgumentListImpl(node);
      }
      else if (type == BLOCK) {
        return new GleamBlockImpl(node);
      }
      else if (type == EXPRESSION) {
        return new GleamExpressionImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new GleamFunctionCallImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new GleamFunctionDeclarationImpl(node);
      }
      else if (type == IMPORT_DECLARATION) {
        return new GleamImportDeclarationImpl(node);
      }
      else if (type == IMPORT_LIST) {
        return new GleamImportListImpl(node);
      }
      else if (type == IMPORT_PATH) {
        return new GleamImportPathImpl(node);
      }
      else if (type == PARAMETER) {
        return new GleamParameterImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new GleamParameterListImpl(node);
      }
      else if (type == STATEMENT) {
        return new GleamStatementImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new GleamStringLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
