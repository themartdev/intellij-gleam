// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.themartdev.intellijgleam.lang.psi.GleamElementTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GleamParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // Expression (',' Expression)*
  public static boolean ArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList")) return false;
    if (!nextTokenIs(b, "<argument list>", IDENTIFIER, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = Expression(b, l + 1);
    r = r && ArgumentList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' Expression)*
  private static boolean ArgumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArgumentList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArgumentList_1", c)) break;
    }
    return true;
  }

  // ',' Expression
  private static boolean ArgumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' Statement* '}'
  public static boolean Block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && Block_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // Statement*
  private static boolean Block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // FunctionCall | StringLiteral | IDENTIFIER
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    if (!nextTokenIs(b, "<expression>", IDENTIFIER, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = FunctionCall(b, l + 1);
    if (!r) r = StringLiteral(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [IDENTIFIER '.'] IDENTIFIER '(' [ArgumentList] ')'
  public static boolean FunctionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionCall_0(b, l + 1);
    r = r && consumeTokens(b, 0, IDENTIFIER, LPAREN);
    r = r && FunctionCall_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  // [IDENTIFIER '.']
  private static boolean FunctionCall_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall_0")) return false;
    parseTokens(b, 0, IDENTIFIER, DOT);
    return true;
  }

  // [ArgumentList]
  private static boolean FunctionCall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall_3")) return false;
    ArgumentList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ['pub'] 'fn' IDENTIFIER '(' [ParameterList] ')' Block
  public static boolean FunctionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration")) return false;
    if (!nextTokenIs(b, "<function declaration>", FN, PUB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, "<function declaration>");
    r = FunctionDeclaration_0(b, l + 1);
    r = r && consumeTokens(b, 0, FN, IDENTIFIER, LPAREN);
    r = r && FunctionDeclaration_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && Block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ['pub']
  private static boolean FunctionDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_0")) return false;
    consumeToken(b, PUB);
    return true;
  }

  // [ParameterList]
  private static boolean FunctionDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_4")) return false;
    ParameterList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'import' ImportPath ['as' IDENTIFIER] [DOT ImportList]
  public static boolean ImportDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDeclaration")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && ImportPath(b, l + 1);
    r = r && ImportDeclaration_2(b, l + 1);
    r = r && ImportDeclaration_3(b, l + 1);
    exit_section_(b, m, IMPORT_DECLARATION, r);
    return r;
  }

  // ['as' IDENTIFIER]
  private static boolean ImportDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDeclaration_2")) return false;
    parseTokens(b, 0, AS, IDENTIFIER);
    return true;
  }

  // [DOT ImportList]
  private static boolean ImportDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDeclaration_3")) return false;
    ImportDeclaration_3_0(b, l + 1);
    return true;
  }

  // DOT ImportList
  private static boolean ImportDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && ImportList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' IDENTIFIER (',' IDENTIFIER)* '}'
  public static boolean ImportList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportList")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACE, IDENTIFIER);
    r = r && ImportList_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, IMPORT_LIST, r);
    return r;
  }

  // (',' IDENTIFIER)*
  private static boolean ImportList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportList_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ImportList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportList_2", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean ImportList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ('/' IDENTIFIER)*
  public static boolean ImportPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportPath")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ImportPath_1(b, l + 1);
    exit_section_(b, m, IMPORT_PATH, r);
    return r;
  }

  // ('/' IDENTIFIER)*
  private static boolean ImportPath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportPath_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ImportPath_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportPath_1", c)) break;
    }
    return true;
  }

  // '/' IDENTIFIER
  private static boolean ImportPath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportPath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean Parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // Parameter (',' Parameter)*
  public static boolean ParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Parameter(b, l + 1);
    r = r && ParameterList_1(b, l + 1);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // (',' Parameter)*
  private static boolean ParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterList_1", c)) break;
    }
    return true;
  }

  // ',' Parameter
  private static boolean ParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ImportDeclaration | FunctionDeclaration | Expression
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = ImportDeclaration(b, l + 1);
    if (!r) r = FunctionDeclaration(b, l + 1);
    if (!r) r = Expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean StringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringLiteral")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // Statement*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

}
