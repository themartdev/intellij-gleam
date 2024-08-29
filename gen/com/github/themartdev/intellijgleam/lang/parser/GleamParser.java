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
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return sourceFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ACCESS_EXPR, ANONYMOUS_FUNCTION_EXPR, ASSERT_EXPR, BINARY_EXPR,
      BLOCK_EXPR, CALL_EXPR, CASE_EXPR, EXPRESSION,
      EXPRESSION_BIT_STRING_EXPR, LET_EXPR, LIST_EXPR, LITERAL_EXPR,
      NEGATION_EXPR, PARENTHESIZED_EXPR, RECORD_EXPR, RECORD_UPDATE_EXPR,
      REFERENCE_EXPR, TODO_RULE_EXPR, TUPLE_EXPR, USE_EXPR),
  };

  /* ********************************************************** */
  // anonymousFunctionParameterArgs [typeAnnotation]
  public static boolean anonymousFunctionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameter")) return false;
    if (!nextTokenIs(b, "<anonymous function parameter>", DISCARD_NAME, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANONYMOUS_FUNCTION_PARAMETER, "<anonymous function parameter>");
    r = anonymousFunctionParameterArgs(b, l + 1);
    r = r && anonymousFunctionParameter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [typeAnnotation]
  private static boolean anonymousFunctionParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameter_1")) return false;
    typeAnnotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // discardParam | nameParam
  public static boolean anonymousFunctionParameterArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameterArgs")) return false;
    if (!nextTokenIs(b, "<anonymous function parameter args>", DISCARD_NAME, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANONYMOUS_FUNCTION_PARAMETER_ARGS, "<anonymous function parameter args>");
    r = discardParam(b, l + 1);
    if (!r) r = nameParam(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [anonymousFunctionParameter (COMMA anonymousFunctionParameter)* [COMMA]] RPAREN
  public static boolean anonymousFunctionParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && anonymousFunctionParameters_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ANONYMOUS_FUNCTION_PARAMETERS, r);
    return r;
  }

  // [anonymousFunctionParameter (COMMA anonymousFunctionParameter)* [COMMA]]
  private static boolean anonymousFunctionParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameters_1")) return false;
    anonymousFunctionParameters_1_0(b, l + 1);
    return true;
  }

  // anonymousFunctionParameter (COMMA anonymousFunctionParameter)* [COMMA]
  private static boolean anonymousFunctionParameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = anonymousFunctionParameter(b, l + 1);
    r = r && anonymousFunctionParameters_1_0_1(b, l + 1);
    r = r && anonymousFunctionParameters_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA anonymousFunctionParameter)*
  private static boolean anonymousFunctionParameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameters_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!anonymousFunctionParameters_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "anonymousFunctionParameters_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA anonymousFunctionParameter
  private static boolean anonymousFunctionParameters_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameters_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && anonymousFunctionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean anonymousFunctionParameters_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameters_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // [label COLON] (hole | expression)
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = argument_0(b, l + 1);
    r = r && argument_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [label COLON]
  private static boolean argument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_0")) return false;
    argument_0_0(b, l + 1);
    return true;
  }

  // label COLON
  private static boolean argument_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // hole | expression
  private static boolean argument_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_1")) return false;
    boolean r;
    r = hole(b, l + 1);
    if (!r) r = expression(b, l + 1, -1);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [argument (COMMA argument)* [COMMA]] RPAREN
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && arguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ARGUMENTS, r);
    return r;
  }

  // [argument (COMMA argument)* [COMMA]]
  private static boolean arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1")) return false;
    arguments_1_0(b, l + 1);
    return true;
  }

  // argument (COMMA argument)* [COMMA]
  private static boolean arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument(b, l + 1);
    r = r && arguments_1_0_1(b, l + 1);
    r = r && arguments_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA argument)*
  private static boolean arguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA argument
  private static boolean arguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean arguments_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // pattern [typeAnnotation] EQUAL expression
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = pattern(b, l + 1);
    r = r && assignment_1(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [typeAnnotation]
  private static boolean assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1")) return false;
    typeAnnotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EQUAL_EQUAL | NOT_EQUAL | LESS | LESS_EQUAL | LESS_DOT
  //                  | LESS_EQUAL_DOT | GREATER | GREATER_EQUAL | GREATER_DOT
  //                  | GREATER_EQUAL_DOT | LT_GT | PIPE | PLUS | PLUS_DOT
  //                  | MINUS | MINUS_DOT | STAR | STAR_DOT | SLASH | SLASH_DOT
  //                  | PERCENT | AMPER_AMPER | VBAR_VBAR
  public static boolean binaryOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_OPERATOR, "<binary operator>");
    r = consumeToken(b, EQUAL_EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, LESS_EQUAL);
    if (!r) r = consumeToken(b, LESS_DOT);
    if (!r) r = consumeToken(b, LESS_EQUAL_DOT);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    if (!r) r = consumeToken(b, GREATER_DOT);
    if (!r) r = consumeToken(b, GREATER_EQUAL_DOT);
    if (!r) r = consumeToken(b, LT_GT);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, PLUS_DOT);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MINUS_DOT);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, STAR_DOT);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, SLASH_DOT);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, AMPER_AMPER);
    if (!r) r = consumeToken(b, VBAR_VBAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | bitStringSegmentOptionSize
  public static boolean bitStringNamedSegmentOption(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringNamedSegmentOption")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = bitStringSegmentOptionSize(b, l + 1);
    exit_section_(b, m, BIT_STRING_NAMED_SEGMENT_OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // bitStringNamedSegmentOption | INTEGER_LITERAL
  public static boolean bitStringSegmentOption(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringSegmentOption")) return false;
    if (!nextTokenIs(b, "<bit string segment option>", IDENTIFIER, INTEGER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_STRING_SEGMENT_OPTION, "<bit string segment option>");
    r = bitStringNamedSegmentOption(b, l + 1);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER LPAREN INTEGER_LITERAL RPAREN
  public static boolean bitStringSegmentOptionSize(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringSegmentOptionSize")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, LPAREN, INTEGER_LITERAL, RPAREN);
    exit_section_(b, m, BIT_STRING_SEGMENT_OPTION_SIZE, r);
    return r;
  }

  /* ********************************************************** */
  // bitStringSegmentOption (MINUS bitStringSegmentOption)* [MINUS]
  public static boolean bitStringSegmentOptions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringSegmentOptions")) return false;
    if (!nextTokenIs(b, "<bit string segment options>", IDENTIFIER, INTEGER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_STRING_SEGMENT_OPTIONS, "<bit string segment options>");
    r = bitStringSegmentOption(b, l + 1);
    r = r && bitStringSegmentOptions_1(b, l + 1);
    r = r && bitStringSegmentOptions_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MINUS bitStringSegmentOption)*
  private static boolean bitStringSegmentOptions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringSegmentOptions_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitStringSegmentOptions_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitStringSegmentOptions_1", c)) break;
    }
    return true;
  }

  // MINUS bitStringSegmentOption
  private static boolean bitStringSegmentOptions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringSegmentOptions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && bitStringSegmentOption(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [MINUS]
  private static boolean bitStringSegmentOptions_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringSegmentOptions_2")) return false;
    consumeToken(b, MINUS);
    return true;
  }

  /* ********************************************************** */
  // caseClausePatterns [caseClauseGuard] R_ARROW expression
  public static boolean caseClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSE, "<case clause>");
    r = caseClausePatterns(b, l + 1);
    r = r && caseClause_1(b, l + 1);
    r = r && consumeToken(b, R_ARROW);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [caseClauseGuard]
  private static boolean caseClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClause_1")) return false;
    caseClauseGuard(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IF caseClauseGuardExpression
  public static boolean caseClauseGuard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseGuard")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && caseClauseGuardExpression(b, l + 1);
    exit_section_(b, m, CASE_CLAUSE_GUARD, r);
    return r;
  }

  /* ********************************************************** */
  // VBAR_VBAR | AMPER_AMPER | EQUAL_EQUAL | NOT_EQUAL | LESS | LESS_EQUAL | LESS_DOT
  //                                 | LESS_EQUAL_DOT | GREATER | GREATER_EQUAL | GREATER_DOT | GREATER_EQUAL_DOT
  public static boolean caseClauseGuardBinaryOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseGuardBinaryOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSE_GUARD_BINARY_OPERATOR, "<case clause guard binary operator>");
    r = consumeToken(b, VBAR_VBAR);
    if (!r) r = consumeToken(b, AMPER_AMPER);
    if (!r) r = consumeToken(b, EQUAL_EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, LESS_EQUAL);
    if (!r) r = consumeToken(b, LESS_DOT);
    if (!r) r = consumeToken(b, LESS_EQUAL_DOT);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    if (!r) r = consumeToken(b, GREATER_DOT);
    if (!r) r = consumeToken(b, GREATER_EQUAL_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // caseClauseGuardUnit caseClauseGuardTail*
  public static boolean caseClauseGuardExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseGuardExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSE_GUARD_EXPRESSION, "<case clause guard expression>");
    r = caseClauseGuardUnit(b, l + 1);
    r = r && caseClauseGuardExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // caseClauseGuardTail*
  private static boolean caseClauseGuardExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseGuardExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseClauseGuardTail(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseClauseGuardExpression_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // caseClauseGuardBinaryOperator caseClauseGuardUnit
  public static boolean caseClauseGuardTail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseGuardTail")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSE_GUARD_TAIL, "<case clause guard tail>");
    r = caseClauseGuardBinaryOperator(b, l + 1);
    r = r && caseClauseGuardUnit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | caseClauseTupleAccess | LBRACE caseClauseGuardExpression RBRACE | constantValue
  public static boolean caseClauseGuardUnit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseGuardUnit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSE_GUARD_UNIT, "<case clause guard unit>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = caseClauseTupleAccess(b, l + 1);
    if (!r) r = caseClauseGuardUnit_2(b, l + 1);
    if (!r) r = constantValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE caseClauseGuardExpression RBRACE
  private static boolean caseClauseGuardUnit_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseGuardUnit_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && caseClauseGuardExpression(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // pattern (COMMA pattern)* [COMMA]
  public static boolean caseClausePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSE_PATTERN, "<case clause pattern>");
    r = pattern(b, l + 1);
    r = r && caseClausePattern_1(b, l + 1);
    r = r && caseClausePattern_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA pattern)*
  private static boolean caseClausePattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePattern_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseClausePattern_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseClausePattern_1", c)) break;
    }
    return true;
  }

  // COMMA pattern
  private static boolean caseClausePattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean caseClausePattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePattern_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // caseClausePattern (VBAR caseClausePattern)* [VBAR]
  public static boolean caseClausePatterns(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePatterns")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSE_PATTERNS, "<case clause patterns>");
    r = caseClausePattern(b, l + 1);
    r = r && caseClausePatterns_1(b, l + 1);
    r = r && caseClausePatterns_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VBAR caseClausePattern)*
  private static boolean caseClausePatterns_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePatterns_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseClausePatterns_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseClausePatterns_1", c)) break;
    }
    return true;
  }

  // VBAR caseClausePattern
  private static boolean caseClausePatterns_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePatterns_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VBAR);
    r = r && caseClausePattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [VBAR]
  private static boolean caseClausePatterns_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePatterns_2")) return false;
    consumeToken(b, VBAR);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER DOT INTEGER_LITERAL
  public static boolean caseClauseTupleAccess(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseTupleAccess")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DOT, INTEGER_LITERAL);
    exit_section_(b, m, CASE_CLAUSE_TUPLE_ACCESS, r);
    return r;
  }

  /* ********************************************************** */
  // caseClause+
  public static boolean caseClauses(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauses")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSES, "<case clauses>");
    r = caseClause(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!caseClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseClauses", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expressionSeq
  public static boolean caseSubjects(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseSubjects")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_SUBJECTS, "<case subjects>");
    r = expressionSeq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [visibilityModifier] CONST IDENTIFIER [constantTypeAnnotation] EQUAL constantValue
  public static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    if (!nextTokenIs(b, "<constant>", CONST, PUB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT, "<constant>");
    r = constant_0(b, l + 1);
    r = r && consumeTokens(b, 0, CONST, IDENTIFIER);
    r = r && constant_3(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && constantValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [visibilityModifier]
  private static boolean constant_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_0")) return false;
    visibilityModifier(b, l + 1);
    return true;
  }

  // [constantTypeAnnotation]
  private static boolean constant_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_3")) return false;
    constantTypeAnnotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LT_LT [constantBitStringSegment (COMMA constantBitStringSegment)* [COMMA]] GT_GT
  public static boolean constantBitString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitString")) return false;
    if (!nextTokenIs(b, LT_LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT_LT);
    r = r && constantBitString_1(b, l + 1);
    r = r && consumeToken(b, GT_GT);
    exit_section_(b, m, CONSTANT_BIT_STRING, r);
    return r;
  }

  // [constantBitStringSegment (COMMA constantBitStringSegment)* [COMMA]]
  private static boolean constantBitString_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitString_1")) return false;
    constantBitString_1_0(b, l + 1);
    return true;
  }

  // constantBitStringSegment (COMMA constantBitStringSegment)* [COMMA]
  private static boolean constantBitString_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitString_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constantBitStringSegment(b, l + 1);
    r = r && constantBitString_1_0_1(b, l + 1);
    r = r && constantBitString_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA constantBitStringSegment)*
  private static boolean constantBitString_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitString_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constantBitString_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constantBitString_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA constantBitStringSegment
  private static boolean constantBitString_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitString_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constantBitStringSegment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean constantBitString_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitString_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // constantValue [COLON bitStringSegmentOptions]
  public static boolean constantBitStringSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitStringSegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_BIT_STRING_SEGMENT, "<constant bit string segment>");
    r = constantValue(b, l + 1);
    r = r && constantBitStringSegment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON bitStringSegmentOptions]
  private static boolean constantBitStringSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitStringSegment_1")) return false;
    constantBitStringSegment_1_0(b, l + 1);
    return true;
  }

  // COLON bitStringSegmentOptions
  private static boolean constantBitStringSegment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitStringSegment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && bitStringSegmentOptions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER DOT label
  public static boolean constantFieldAccess(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantFieldAccess")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DOT);
    r = r && label(b, l + 1);
    exit_section_(b, m, CONSTANT_FIELD_ACCESS, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [constantTypeSpecial (COMMA constantTypeSpecial)* [COMMA]] RPAREN
  public static boolean constantFunctionParameterTypes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantFunctionParameterTypes")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && constantFunctionParameterTypes_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CONSTANT_FUNCTION_PARAMETER_TYPES, r);
    return r;
  }

  // [constantTypeSpecial (COMMA constantTypeSpecial)* [COMMA]]
  private static boolean constantFunctionParameterTypes_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantFunctionParameterTypes_1")) return false;
    constantFunctionParameterTypes_1_0(b, l + 1);
    return true;
  }

  // constantTypeSpecial (COMMA constantTypeSpecial)* [COMMA]
  private static boolean constantFunctionParameterTypes_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantFunctionParameterTypes_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constantTypeSpecial(b, l + 1);
    r = r && constantFunctionParameterTypes_1_0_1(b, l + 1);
    r = r && constantFunctionParameterTypes_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA constantTypeSpecial)*
  private static boolean constantFunctionParameterTypes_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantFunctionParameterTypes_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constantFunctionParameterTypes_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constantFunctionParameterTypes_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA constantTypeSpecial
  private static boolean constantFunctionParameterTypes_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantFunctionParameterTypes_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constantTypeSpecial(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean constantFunctionParameterTypes_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantFunctionParameterTypes_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LBRACK [constantValue (COMMA constantValue)* [COMMA]] RBRACK
  public static boolean constantList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantList")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && constantList_1(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, CONSTANT_LIST, r);
    return r;
  }

  // [constantValue (COMMA constantValue)* [COMMA]]
  private static boolean constantList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantList_1")) return false;
    constantList_1_0(b, l + 1);
    return true;
  }

  // constantValue (COMMA constantValue)* [COMMA]
  private static boolean constantList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constantValue(b, l + 1);
    r = r && constantList_1_0_1(b, l + 1);
    r = r && constantList_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA constantValue)*
  private static boolean constantList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantList_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constantList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constantList_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA constantValue
  private static boolean constantList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantList_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constantValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean constantList_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantList_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (constructorIdentifier | remoteConstructorIdentifier) [constantRecordArguments]
  public static boolean constantRecord(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecord")) return false;
    if (!nextTokenIs(b, "<constant record>", IDENTIFIER, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_RECORD, "<constant record>");
    r = constantRecord_0(b, l + 1);
    r = r && constantRecord_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // constructorIdentifier | remoteConstructorIdentifier
  private static boolean constantRecord_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecord_0")) return false;
    boolean r;
    r = constructorIdentifier(b, l + 1);
    if (!r) r = remoteConstructorIdentifier(b, l + 1);
    return r;
  }

  // [constantRecordArguments]
  private static boolean constantRecord_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecord_1")) return false;
    constantRecordArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [label COLON] constantValue
  public static boolean constantRecordArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_RECORD_ARGUMENT, "<constant record argument>");
    r = constantRecordArgument_0(b, l + 1);
    r = r && constantValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [label COLON]
  private static boolean constantRecordArgument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArgument_0")) return false;
    constantRecordArgument_0_0(b, l + 1);
    return true;
  }

  // label COLON
  private static boolean constantRecordArgument_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArgument_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [constantRecordArgument (COMMA constantRecordArgument)* [COMMA]] RPAREN
  public static boolean constantRecordArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && constantRecordArguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CONSTANT_RECORD_ARGUMENTS, r);
    return r;
  }

  // [constantRecordArgument (COMMA constantRecordArgument)* [COMMA]]
  private static boolean constantRecordArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArguments_1")) return false;
    constantRecordArguments_1_0(b, l + 1);
    return true;
  }

  // constantRecordArgument (COMMA constantRecordArgument)* [COMMA]
  private static boolean constantRecordArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constantRecordArgument(b, l + 1);
    r = r && constantRecordArguments_1_0_1(b, l + 1);
    r = r && constantRecordArguments_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA constantRecordArgument)*
  private static boolean constantRecordArguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constantRecordArguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constantRecordArguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA constantRecordArgument
  private static boolean constantRecordArguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constantRecordArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean constantRecordArguments_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArguments_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // HASH LPAREN [constantValue (COMMA constantValue)* [COMMA]] RPAREN
  public static boolean constantTuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTuple")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HASH, LPAREN);
    r = r && constantTuple_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CONSTANT_TUPLE, r);
    return r;
  }

  // [constantValue (COMMA constantValue)* [COMMA]]
  private static boolean constantTuple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTuple_2")) return false;
    constantTuple_2_0(b, l + 1);
    return true;
  }

  // constantValue (COMMA constantValue)* [COMMA]
  private static boolean constantTuple_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTuple_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constantValue(b, l + 1);
    r = r && constantTuple_2_0_1(b, l + 1);
    r = r && constantTuple_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA constantValue)*
  private static boolean constantTuple_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTuple_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constantTuple_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constantTuple_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA constantValue
  private static boolean constantTuple_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTuple_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constantValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean constantTuple_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTuple_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (typeIdentifier | remoteTypeIdentifier) [constantTypeArguments]
  public static boolean constantType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantType")) return false;
    if (!nextTokenIs(b, "<constant type>", IDENTIFIER, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_TYPE, "<constant type>");
    r = constantType_0(b, l + 1);
    r = r && constantType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // typeIdentifier | remoteTypeIdentifier
  private static boolean constantType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantType_0")) return false;
    boolean r;
    r = typeIdentifier(b, l + 1);
    if (!r) r = remoteTypeIdentifier(b, l + 1);
    return r;
  }

  // [constantTypeArguments]
  private static boolean constantType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantType_1")) return false;
    constantTypeArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON constantType
  public static boolean constantTypeAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeAnnotation")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && constantType(b, l + 1);
    exit_section_(b, m, CONSTANT_TYPE_ANNOTATION, r);
    return r;
  }

  /* ********************************************************** */
  // constantTypeSpecial
  public static boolean constantTypeArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_TYPE_ARGUMENT, "<constant type argument>");
    r = constantTypeSpecial(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [constantTypeArgument (COMMA constantTypeArgument)* [COMMA]] RPAREN
  public static boolean constantTypeArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && constantTypeArguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CONSTANT_TYPE_ARGUMENTS, r);
    return r;
  }

  // [constantTypeArgument (COMMA constantTypeArgument)* [COMMA]]
  private static boolean constantTypeArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeArguments_1")) return false;
    constantTypeArguments_1_0(b, l + 1);
    return true;
  }

  // constantTypeArgument (COMMA constantTypeArgument)* [COMMA]
  private static boolean constantTypeArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constantTypeArgument(b, l + 1);
    r = r && constantTypeArguments_1_0_1(b, l + 1);
    r = r && constantTypeArguments_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA constantTypeArgument)*
  private static boolean constantTypeArguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeArguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constantTypeArguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constantTypeArguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA constantTypeArgument
  private static boolean constantTypeArguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeArguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constantTypeArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean constantTypeArguments_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeArguments_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // FN [constantFunctionParameterTypes] R_ARROW constantTypeSpecial
  public static boolean constantTypeFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeFunction")) return false;
    if (!nextTokenIs(b, FN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FN);
    r = r && constantTypeFunction_1(b, l + 1);
    r = r && consumeToken(b, R_ARROW);
    r = r && constantTypeSpecial(b, l + 1);
    exit_section_(b, m, CONSTANT_TYPE_FUNCTION, r);
    return r;
  }

  // [constantFunctionParameterTypes]
  private static boolean constantTypeFunction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeFunction_1")) return false;
    constantFunctionParameterTypes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // typeHole
  //                       | constantTypeTuple
  //                       | constantTypeFunction
  //                       | constantType
  public static boolean constantTypeSpecial(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeSpecial")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_TYPE_SPECIAL, "<constant type special>");
    r = typeHole(b, l + 1);
    if (!r) r = constantTypeTuple(b, l + 1);
    if (!r) r = constantTypeFunction(b, l + 1);
    if (!r) r = constantType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // HASH LPAREN [constantTypeSpecial (COMMA constantTypeSpecial)* [COMMA]] RPAREN
  public static boolean constantTypeTuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeTuple")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HASH, LPAREN);
    r = r && constantTypeTuple_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CONSTANT_TYPE_TUPLE, r);
    return r;
  }

  // [constantTypeSpecial (COMMA constantTypeSpecial)* [COMMA]]
  private static boolean constantTypeTuple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeTuple_2")) return false;
    constantTypeTuple_2_0(b, l + 1);
    return true;
  }

  // constantTypeSpecial (COMMA constantTypeSpecial)* [COMMA]
  private static boolean constantTypeTuple_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeTuple_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constantTypeSpecial(b, l + 1);
    r = r && constantTypeTuple_2_0_1(b, l + 1);
    r = r && constantTypeTuple_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA constantTypeSpecial)*
  private static boolean constantTypeTuple_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeTuple_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constantTypeTuple_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constantTypeTuple_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA constantTypeSpecial
  private static boolean constantTypeTuple_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeTuple_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constantTypeSpecial(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean constantTypeTuple_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeTuple_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // constantTuple
  //                 | constantList
  //                 | constantBitString
  //                 | constantRecord
  //                 | IDENTIFIER
  //                 | constantFieldAccess
  //                 | literalExpr
  public static boolean constantValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_VALUE, "<constant value>");
    r = constantTuple(b, l + 1);
    if (!r) r = constantList(b, l + 1);
    if (!r) r = constantBitString(b, l + 1);
    if (!r) r = constantRecord(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = constantFieldAccess(b, l + 1);
    if (!r) r = literalExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UP_IDENTIFIER
  public static boolean constructorIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructorIdentifier")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UP_IDENTIFIER);
    exit_section_(b, m, CONSTRUCTOR_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // constructorIdentifier [dataConstructorArguments]
  public static boolean dataConstructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructor")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constructorIdentifier(b, l + 1);
    r = r && dataConstructor_1(b, l + 1);
    exit_section_(b, m, DATA_CONSTRUCTOR, r);
    return r;
  }

  // [dataConstructorArguments]
  private static boolean dataConstructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructor_1")) return false;
    dataConstructorArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [label COLON] typeBase
  public static boolean dataConstructorArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_CONSTRUCTOR_ARGUMENT, "<data constructor argument>");
    r = dataConstructorArgument_0(b, l + 1);
    r = r && typeBase(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [label COLON]
  private static boolean dataConstructorArgument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArgument_0")) return false;
    dataConstructorArgument_0_0(b, l + 1);
    return true;
  }

  // label COLON
  private static boolean dataConstructorArgument_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArgument_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [dataConstructorArgument (COMMA dataConstructorArgument)* [COMMA]] RPAREN
  public static boolean dataConstructorArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && dataConstructorArguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, DATA_CONSTRUCTOR_ARGUMENTS, r);
    return r;
  }

  // [dataConstructorArgument (COMMA dataConstructorArgument)* [COMMA]]
  private static boolean dataConstructorArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArguments_1")) return false;
    dataConstructorArguments_1_0(b, l + 1);
    return true;
  }

  // dataConstructorArgument (COMMA dataConstructorArgument)* [COMMA]
  private static boolean dataConstructorArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dataConstructorArgument(b, l + 1);
    r = r && dataConstructorArguments_1_0_1(b, l + 1);
    r = r && dataConstructorArguments_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA dataConstructorArgument)*
  private static boolean dataConstructorArguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dataConstructorArguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dataConstructorArguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA dataConstructorArgument
  private static boolean dataConstructorArguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && dataConstructorArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean dataConstructorArguments_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructorArguments_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // dataConstructor+
  public static boolean dataConstructors(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataConstructors")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dataConstructor(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!dataConstructor(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dataConstructors", c)) break;
    }
    exit_section_(b, m, DATA_CONSTRUCTORS, r);
    return r;
  }

  /* ********************************************************** */
  // DISCARD_NAME
  public static boolean discard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discard")) return false;
    if (!nextTokenIs(b, DISCARD_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DISCARD_NAME);
    exit_section_(b, m, DISCARD, r);
    return r;
  }

  /* ********************************************************** */
  // discard
  public static boolean discardParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discardParam")) return false;
    if (!nextTokenIs(b, DISCARD_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = discard(b, l + 1);
    exit_section_(b, m, DISCARD_PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // expression [COLON bitStringSegmentOptions]
  public static boolean expressionBitStringSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringSegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_BIT_STRING_SEGMENT, "<expression bit string segment>");
    r = expression(b, l + 1, -1);
    r = r && expressionBitStringSegment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON bitStringSegmentOptions]
  private static boolean expressionBitStringSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringSegment_1")) return false;
    expressionBitStringSegment_1_0(b, l + 1);
    return true;
  }

  // COLON bitStringSegmentOptions
  private static boolean expressionBitStringSegment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringSegment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && bitStringSegmentOptions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (expression | tryRule)+
  public static boolean expressionSeq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionSeq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_SEQ, "<expression seq>");
    r = expressionSeq_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!expressionSeq_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expressionSeq", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression | tryRule
  private static boolean expressionSeq_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionSeq_0")) return false;
    boolean r;
    r = expression(b, l + 1, -1);
    if (!r) r = tryRule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // [visibilityModifier] EXTERNAL FN IDENTIFIER externalFunctionParameters R_ARROW typeBase EQUAL externalFunctionBody
  public static boolean externalFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunction")) return false;
    if (!nextTokenIs(b, "<external function>", EXTERNAL, PUB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTERNAL_FUNCTION, "<external function>");
    r = externalFunction_0(b, l + 1);
    r = r && consumeTokens(b, 0, EXTERNAL, FN, IDENTIFIER);
    r = r && externalFunctionParameters(b, l + 1);
    r = r && consumeToken(b, R_ARROW);
    r = r && typeBase(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && externalFunctionBody(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [visibilityModifier]
  private static boolean externalFunction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunction_0")) return false;
    visibilityModifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRING_LITERAL STRING_LITERAL
  public static boolean externalFunctionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionBody")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STRING_LITERAL, STRING_LITERAL);
    exit_section_(b, m, EXTERNAL_FUNCTION_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // [IDENTIFIER COLON] typeBase
  public static boolean externalFunctionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTERNAL_FUNCTION_PARAMETER, "<external function parameter>");
    r = externalFunctionParameter_0(b, l + 1);
    r = r && typeBase(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [IDENTIFIER COLON]
  private static boolean externalFunctionParameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionParameter_0")) return false;
    parseTokens(b, 0, IDENTIFIER, COLON);
    return true;
  }

  /* ********************************************************** */
  // LPAREN [externalFunctionParameter (COMMA externalFunctionParameter)* [COMMA]] RPAREN
  public static boolean externalFunctionParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && externalFunctionParameters_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, EXTERNAL_FUNCTION_PARAMETERS, r);
    return r;
  }

  // [externalFunctionParameter (COMMA externalFunctionParameter)* [COMMA]]
  private static boolean externalFunctionParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionParameters_1")) return false;
    externalFunctionParameters_1_0(b, l + 1);
    return true;
  }

  // externalFunctionParameter (COMMA externalFunctionParameter)* [COMMA]
  private static boolean externalFunctionParameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionParameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = externalFunctionParameter(b, l + 1);
    r = r && externalFunctionParameters_1_0_1(b, l + 1);
    r = r && externalFunctionParameters_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA externalFunctionParameter)*
  private static boolean externalFunctionParameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionParameters_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!externalFunctionParameters_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "externalFunctionParameters_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA externalFunctionParameter
  private static boolean externalFunctionParameters_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionParameters_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && externalFunctionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean externalFunctionParameters_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalFunctionParameters_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // [visibilityModifier] FN IDENTIFIER functionParameters [R_ARROW typeBase] functionBody
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, "<function>", FN, PUB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION, "<function>");
    r = function_0(b, l + 1);
    r = r && consumeTokens(b, 0, FN, IDENTIFIER);
    r = r && functionParameters(b, l + 1);
    r = r && function_4(b, l + 1);
    r = r && functionBody(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [visibilityModifier]
  private static boolean function_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_0")) return false;
    visibilityModifier(b, l + 1);
    return true;
  }

  // [R_ARROW typeBase]
  private static boolean function_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_4")) return false;
    function_4_0(b, l + 1);
    return true;
  }

  // R_ARROW typeBase
  private static boolean function_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, R_ARROW);
    r = r && typeBase(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE [expressionSeq] RBRACE
  public static boolean functionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionBody")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && functionBody_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, FUNCTION_BODY, r);
    return r;
  }

  // [expressionSeq]
  private static boolean functionBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionBody_1")) return false;
    expressionSeq(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // functionParameterArgs [typeAnnotation]
  public static boolean functionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameter")) return false;
    if (!nextTokenIs(b, "<function parameter>", DISCARD_NAME, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_PARAMETER, "<function parameter>");
    r = functionParameterArgs(b, l + 1);
    r = r && functionParameter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [typeAnnotation]
  private static boolean functionParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameter_1")) return false;
    typeAnnotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // labeledDiscardParam | discardParam | labeledNameParam | nameParam
  public static boolean functionParameterArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameterArgs")) return false;
    if (!nextTokenIs(b, "<function parameter args>", DISCARD_NAME, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_PARAMETER_ARGS, "<function parameter args>");
    r = labeledDiscardParam(b, l + 1);
    if (!r) r = discardParam(b, l + 1);
    if (!r) r = labeledNameParam(b, l + 1);
    if (!r) r = nameParam(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [typeBase (COMMA typeBase)* [COMMA]] RPAREN
  public static boolean functionParameterTypes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameterTypes")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && functionParameterTypes_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FUNCTION_PARAMETER_TYPES, r);
    return r;
  }

  // [typeBase (COMMA typeBase)* [COMMA]]
  private static boolean functionParameterTypes_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameterTypes_1")) return false;
    functionParameterTypes_1_0(b, l + 1);
    return true;
  }

  // typeBase (COMMA typeBase)* [COMMA]
  private static boolean functionParameterTypes_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameterTypes_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeBase(b, l + 1);
    r = r && functionParameterTypes_1_0_1(b, l + 1);
    r = r && functionParameterTypes_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA typeBase)*
  private static boolean functionParameterTypes_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameterTypes_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionParameterTypes_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionParameterTypes_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA typeBase
  private static boolean functionParameterTypes_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameterTypes_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && typeBase(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean functionParameterTypes_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameterTypes_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LPAREN [functionParameter (COMMA functionParameter)* [COMMA]] RPAREN
  public static boolean functionParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && functionParameters_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FUNCTION_PARAMETERS, r);
    return r;
  }

  // [functionParameter (COMMA functionParameter)* [COMMA]]
  private static boolean functionParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameters_1")) return false;
    functionParameters_1_0(b, l + 1);
    return true;
  }

  // functionParameter (COMMA functionParameter)* [COMMA]
  private static boolean functionParameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionParameter(b, l + 1);
    r = r && functionParameters_1_0_1(b, l + 1);
    r = r && functionParameters_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA functionParameter)*
  private static boolean functionParameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameters_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionParameters_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionParameters_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA functionParameter
  private static boolean functionParameters_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameters_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && functionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean functionParameters_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameters_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // FN [functionParameterTypes] R_ARROW typeBase
  public static boolean functionType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionType")) return false;
    if (!nextTokenIs(b, FN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FN);
    r = r && functionType_1(b, l + 1);
    r = r && consumeToken(b, R_ARROW);
    r = r && typeBase(b, l + 1);
    exit_section_(b, m, FUNCTION_TYPE, r);
    return r;
  }

  // [functionParameterTypes]
  private static boolean functionType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionType_1")) return false;
    functionParameterTypes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DISCARD_NAME
  public static boolean hole(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hole")) return false;
    if (!nextTokenIs(b, DISCARD_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DISCARD_NAME);
    exit_section_(b, m, HOLE, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT module [DOT unqualifiedImports] [AS IDENTIFIER]
  public static boolean imports(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && module(b, l + 1);
    r = r && imports_2(b, l + 1);
    r = r && imports_3(b, l + 1);
    exit_section_(b, m, IMPORTS, r);
    return r;
  }

  // [DOT unqualifiedImports]
  private static boolean imports_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports_2")) return false;
    imports_2_0(b, l + 1);
    return true;
  }

  // DOT unqualifiedImports
  private static boolean imports_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && unqualifiedImports(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [AS IDENTIFIER]
  private static boolean imports_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports_3")) return false;
    parseTokens(b, 0, AS, IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, LABEL, r);
    return r;
  }

  /* ********************************************************** */
  // label discard
  public static boolean labeledDiscardParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledDiscardParam")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && discard(b, l + 1);
    exit_section_(b, m, LABELED_DISCARD_PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // label IDENTIFIER
  public static boolean labeledNameParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledNameParam")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, LABELED_NAME_PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACK [pattern (COMMA pattern)* [COMMA]] [listPatternTail] RBRACK
  public static boolean listPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && listPattern_1(b, l + 1);
    r = r && listPattern_2(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, LIST_PATTERN, r);
    return r;
  }

  // [pattern (COMMA pattern)* [COMMA]]
  private static boolean listPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1")) return false;
    listPattern_1_0(b, l + 1);
    return true;
  }

  // pattern (COMMA pattern)* [COMMA]
  private static boolean listPattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && listPattern_1_0_1(b, l + 1);
    r = r && listPattern_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA pattern)*
  private static boolean listPattern_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!listPattern_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listPattern_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA pattern
  private static boolean listPattern_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean listPattern_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // [listPatternTail]
  private static boolean listPattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_2")) return false;
    listPatternTail(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DOT_DOT [IDENTIFIER | discard]
  public static boolean listPatternTail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPatternTail")) return false;
    if (!nextTokenIs(b, DOT_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT_DOT);
    r = r && listPatternTail_1(b, l + 1);
    exit_section_(b, m, LIST_PATTERN_TAIL, r);
    return r;
  }

  // [IDENTIFIER | discard]
  private static boolean listPatternTail_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPatternTail_1")) return false;
    listPatternTail_1_0(b, l + 1);
    return true;
  }

  // IDENTIFIER | discard
  private static boolean listPatternTail_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPatternTail_1_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = discard(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (SLASH IDENTIFIER)*
  public static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && module_1(b, l + 1);
    exit_section_(b, m, MODULE, r);
    return r;
  }

  // (SLASH IDENTIFIER)*
  private static boolean module_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_1", c)) break;
    }
    return true;
  }

  // SLASH IDENTIFIER
  private static boolean module_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SLASH, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean nameParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameParam")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, NAME_PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // OPAQUE
  public static boolean opacityModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "opacityModifier")) return false;
    if (!nextTokenIs(b, OPAQUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPAQUE);
    exit_section_(b, m, OPACITY_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // (IDENTIFIER | discard | recordPattern | literalExpr | tuplePattern | patternBitString | listPattern) [AS IDENTIFIER]
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = pattern_0(b, l + 1);
    r = r && pattern_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER | discard | recordPattern | literalExpr | tuplePattern | patternBitString | listPattern
  private static boolean pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = discard(b, l + 1);
    if (!r) r = recordPattern(b, l + 1);
    if (!r) r = literalExpr(b, l + 1);
    if (!r) r = tuplePattern(b, l + 1);
    if (!r) r = patternBitString(b, l + 1);
    if (!r) r = listPattern(b, l + 1);
    return r;
  }

  // [AS IDENTIFIER]
  private static boolean pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_1")) return false;
    parseTokens(b, 0, AS, IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // LT_LT [patternBitStringSegment (COMMA patternBitStringSegment)* [COMMA]] GT_GT
  public static boolean patternBitString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitString")) return false;
    if (!nextTokenIs(b, LT_LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT_LT);
    r = r && patternBitString_1(b, l + 1);
    r = r && consumeToken(b, GT_GT);
    exit_section_(b, m, PATTERN_BIT_STRING, r);
    return r;
  }

  // [patternBitStringSegment (COMMA patternBitStringSegment)* [COMMA]]
  private static boolean patternBitString_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitString_1")) return false;
    patternBitString_1_0(b, l + 1);
    return true;
  }

  // patternBitStringSegment (COMMA patternBitStringSegment)* [COMMA]
  private static boolean patternBitString_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitString_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = patternBitStringSegment(b, l + 1);
    r = r && patternBitString_1_0_1(b, l + 1);
    r = r && patternBitString_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA patternBitStringSegment)*
  private static boolean patternBitString_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitString_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!patternBitString_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "patternBitString_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA patternBitStringSegment
  private static boolean patternBitString_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitString_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && patternBitStringSegment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean patternBitString_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitString_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // pattern [COLON bitStringSegmentOptions]
  public static boolean patternBitStringSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitStringSegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_BIT_STRING_SEGMENT, "<pattern bit string segment>");
    r = pattern(b, l + 1);
    r = r && patternBitStringSegment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON bitStringSegmentOptions]
  private static boolean patternBitStringSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitStringSegment_1")) return false;
    patternBitStringSegment_1_0(b, l + 1);
    return true;
  }

  // COLON bitStringSegmentOptions
  private static boolean patternBitStringSegment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitStringSegment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && bitStringSegmentOptions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOT_DOT [COMMA]
  public static boolean patternSpread(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternSpread")) return false;
    if (!nextTokenIs(b, DOT_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT_DOT);
    r = r && patternSpread_1(b, l + 1);
    exit_section_(b, m, PATTERN_SPREAD, r);
    return r;
  }

  // [COMMA]
  private static boolean patternSpread_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternSpread_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (constructorIdentifier | remoteConstructorIdentifier) [recordPatternArguments]
  public static boolean recordPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPattern")) return false;
    if (!nextTokenIs(b, "<record pattern>", IDENTIFIER, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_PATTERN, "<record pattern>");
    r = recordPattern_0(b, l + 1);
    r = r && recordPattern_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // constructorIdentifier | remoteConstructorIdentifier
  private static boolean recordPattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPattern_0")) return false;
    boolean r;
    r = constructorIdentifier(b, l + 1);
    if (!r) r = remoteConstructorIdentifier(b, l + 1);
    return r;
  }

  // [recordPatternArguments]
  private static boolean recordPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPattern_1")) return false;
    recordPatternArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [label COLON] pattern
  public static boolean recordPatternArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_PATTERN_ARGUMENT, "<record pattern argument>");
    r = recordPatternArgument_0(b, l + 1);
    r = r && pattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [label COLON]
  private static boolean recordPatternArgument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArgument_0")) return false;
    recordPatternArgument_0_0(b, l + 1);
    return true;
  }

  // label COLON
  private static boolean recordPatternArgument_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArgument_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [recordPatternArgument (COMMA recordPatternArgument)* [COMMA]] [patternSpread] RPAREN
  public static boolean recordPatternArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && recordPatternArguments_1(b, l + 1);
    r = r && recordPatternArguments_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, RECORD_PATTERN_ARGUMENTS, r);
    return r;
  }

  // [recordPatternArgument (COMMA recordPatternArgument)* [COMMA]]
  private static boolean recordPatternArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArguments_1")) return false;
    recordPatternArguments_1_0(b, l + 1);
    return true;
  }

  // recordPatternArgument (COMMA recordPatternArgument)* [COMMA]
  private static boolean recordPatternArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recordPatternArgument(b, l + 1);
    r = r && recordPatternArguments_1_0_1(b, l + 1);
    r = r && recordPatternArguments_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA recordPatternArgument)*
  private static boolean recordPatternArguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!recordPatternArguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recordPatternArguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA recordPatternArgument
  private static boolean recordPatternArguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && recordPatternArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean recordPatternArguments_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArguments_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // [patternSpread]
  private static boolean recordPatternArguments_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArguments_2")) return false;
    patternSpread(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // label COLON expression
  public static boolean recordUpdateArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateArgument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, RECORD_UPDATE_ARGUMENT, r);
    return r;
  }

  /* ********************************************************** */
  // recordUpdateArgument (COMMA recordUpdateArgument)* [COMMA]
  public static boolean recordUpdateArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateArguments")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recordUpdateArgument(b, l + 1);
    r = r && recordUpdateArguments_1(b, l + 1);
    r = r && recordUpdateArguments_2(b, l + 1);
    exit_section_(b, m, RECORD_UPDATE_ARGUMENTS, r);
    return r;
  }

  // (COMMA recordUpdateArgument)*
  private static boolean recordUpdateArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateArguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!recordUpdateArguments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recordUpdateArguments_1", c)) break;
    }
    return true;
  }

  // COMMA recordUpdateArgument
  private static boolean recordUpdateArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && recordUpdateArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean recordUpdateArguments_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateArguments_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER DOT constructorIdentifier
  public static boolean remoteConstructorIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remoteConstructorIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DOT);
    r = r && constructorIdentifier(b, l + 1);
    exit_section_(b, m, REMOTE_CONSTRUCTOR_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER DOT typeIdentifier
  public static boolean remoteTypeIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remoteTypeIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DOT);
    r = r && typeIdentifier(b, l + 1);
    exit_section_(b, m, REMOTE_TYPE_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // (statement | expressionSeq | targetGroup)*
  static boolean sourceFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sourceFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sourceFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sourceFile", c)) break;
    }
    return true;
  }

  // statement | expressionSeq | targetGroup
  private static boolean sourceFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sourceFile_0")) return false;
    boolean r;
    r = statement(b, l + 1);
    if (!r) r = expressionSeq(b, l + 1);
    if (!r) r = targetGroup(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // imports
  //             | constant
  //             | externalFunction
  //             | function
  //             | typeDefinition
  //             | typeAlias
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = imports(b, l + 1);
    if (!r) r = constant(b, l + 1);
    if (!r) r = externalFunction(b, l + 1);
    if (!r) r = function(b, l + 1);
    if (!r) r = typeDefinition(b, l + 1);
    if (!r) r = typeAlias(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF IDENTIFIER LBRACE statement* RBRACE
  public static boolean targetGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetGroup")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, IDENTIFIER, LBRACE);
    r = r && targetGroup_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, TARGET_GROUP, r);
    return r;
  }

  // statement*
  private static boolean targetGroup_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetGroup_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "targetGroup_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // TRY pattern [typeAnnotation] EQUAL expression
  public static boolean tryRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryRule")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY);
    r = r && pattern(b, l + 1);
    r = r && tryRule_2(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, TRY_RULE, r);
    return r;
  }

  // [typeAnnotation]
  private static boolean tryRule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryRule_2")) return false;
    typeAnnotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HASH LPAREN [pattern (COMMA pattern)* [COMMA]] RPAREN
  public static boolean tuplePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HASH, LPAREN);
    r = r && tuplePattern_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TUPLE_PATTERN, r);
    return r;
  }

  // [pattern (COMMA pattern)* [COMMA]]
  private static boolean tuplePattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2")) return false;
    tuplePattern_2_0(b, l + 1);
    return true;
  }

  // pattern (COMMA pattern)* [COMMA]
  private static boolean tuplePattern_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && tuplePattern_2_0_1(b, l + 1);
    r = r && tuplePattern_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA pattern)*
  private static boolean tuplePattern_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuplePattern_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuplePattern_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA pattern
  private static boolean tuplePattern_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean tuplePattern_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // HASH LPAREN [typeBase (COMMA typeBase)* [COMMA]] RPAREN
  public static boolean tupleType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleType")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HASH, LPAREN);
    r = r && tupleType_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TUPLE_TYPE, r);
    return r;
  }

  // [typeBase (COMMA typeBase)* [COMMA]]
  private static boolean tupleType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleType_2")) return false;
    tupleType_2_0(b, l + 1);
    return true;
  }

  // typeBase (COMMA typeBase)* [COMMA]
  private static boolean tupleType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeBase(b, l + 1);
    r = r && tupleType_2_0_1(b, l + 1);
    r = r && tupleType_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA typeBase)*
  private static boolean tupleType_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleType_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tupleType_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tupleType_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA typeBase
  private static boolean tupleType_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleType_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && typeBase(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean tupleType_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleType_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // [visibilityModifier] [opacityModifier] TYPE typeName EQUAL typeRule
  public static boolean typeAlias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAlias")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ALIAS, "<type alias>");
    r = typeAlias_0(b, l + 1);
    r = r && typeAlias_1(b, l + 1);
    r = r && consumeToken(b, TYPE);
    r = r && typeName(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && typeRule(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [visibilityModifier]
  private static boolean typeAlias_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAlias_0")) return false;
    visibilityModifier(b, l + 1);
    return true;
  }

  // [opacityModifier]
  private static boolean typeAlias_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAlias_1")) return false;
    opacityModifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON typeBase
  public static boolean typeAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAnnotation")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && typeBase(b, l + 1);
    exit_section_(b, m, TYPE_ANNOTATION, r);
    return r;
  }

  /* ********************************************************** */
  // typeBase
  public static boolean typeArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ARGUMENT, "<type argument>");
    r = typeBase(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [typeArgument (COMMA typeArgument)* [COMMA]] RPAREN
  public static boolean typeArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && typeArguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TYPE_ARGUMENTS, r);
    return r;
  }

  // [typeArgument (COMMA typeArgument)* [COMMA]]
  private static boolean typeArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeArguments_1")) return false;
    typeArguments_1_0(b, l + 1);
    return true;
  }

  // typeArgument (COMMA typeArgument)* [COMMA]
  private static boolean typeArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeArgument(b, l + 1);
    r = r && typeArguments_1_0_1(b, l + 1);
    r = r && typeArguments_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA typeArgument)*
  private static boolean typeArguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeArguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeArguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeArguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA typeArgument
  private static boolean typeArguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeArguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && typeArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean typeArguments_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeArguments_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // typeHole | tupleType | functionType | typeRule | typeVar
  public static boolean typeBase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeBase")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_BASE, "<type base>");
    r = typeHole(b, l + 1);
    if (!r) r = tupleType(b, l + 1);
    if (!r) r = functionType(b, l + 1);
    if (!r) r = typeRule(b, l + 1);
    if (!r) r = typeVar(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [visibilityModifier] [opacityModifier] TYPE typeName LBRACE dataConstructors RBRACE
  public static boolean typeDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DEFINITION, "<type definition>");
    r = typeDefinition_0(b, l + 1);
    r = r && typeDefinition_1(b, l + 1);
    r = r && consumeToken(b, TYPE);
    r = r && typeName(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && dataConstructors(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [visibilityModifier]
  private static boolean typeDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDefinition_0")) return false;
    visibilityModifier(b, l + 1);
    return true;
  }

  // [opacityModifier]
  private static boolean typeDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDefinition_1")) return false;
    opacityModifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean typeHole(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeHole")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_HOLE, r);
    return r;
  }

  /* ********************************************************** */
  // UP_IDENTIFIER
  public static boolean typeIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeIdentifier")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UP_IDENTIFIER);
    exit_section_(b, m, TYPE_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // (typeIdentifier | remoteTypeIdentifier) [typeParameters]
  public static boolean typeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeName")) return false;
    if (!nextTokenIs(b, "<type name>", IDENTIFIER, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_NAME, "<type name>");
    r = typeName_0(b, l + 1);
    r = r && typeName_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // typeIdentifier | remoteTypeIdentifier
  private static boolean typeName_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeName_0")) return false;
    boolean r;
    r = typeIdentifier(b, l + 1);
    if (!r) r = remoteTypeIdentifier(b, l + 1);
    return r;
  }

  // [typeParameters]
  private static boolean typeName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeName_1")) return false;
    typeParameters(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean typeParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeParameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [typeParameter (COMMA typeParameter)* [COMMA]] RPAREN
  public static boolean typeParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && typeParameters_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TYPE_PARAMETERS, r);
    return r;
  }

  // [typeParameter (COMMA typeParameter)* [COMMA]]
  private static boolean typeParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeParameters_1")) return false;
    typeParameters_1_0(b, l + 1);
    return true;
  }

  // typeParameter (COMMA typeParameter)* [COMMA]
  private static boolean typeParameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeParameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeParameter(b, l + 1);
    r = r && typeParameters_1_0_1(b, l + 1);
    r = r && typeParameters_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA typeParameter)*
  private static boolean typeParameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeParameters_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeParameters_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeParameters_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA typeParameter
  private static boolean typeParameters_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeParameters_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && typeParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean typeParameters_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeParameters_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (typeIdentifier | remoteTypeIdentifier) [typeArguments]
  public static boolean typeRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeRule")) return false;
    if (!nextTokenIs(b, "<type rule>", IDENTIFIER, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_RULE, "<type rule>");
    r = typeRule_0(b, l + 1);
    r = r && typeRule_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // typeIdentifier | remoteTypeIdentifier
  private static boolean typeRule_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeRule_0")) return false;
    boolean r;
    r = typeIdentifier(b, l + 1);
    if (!r) r = remoteTypeIdentifier(b, l + 1);
    return r;
  }

  // [typeArguments]
  private static boolean typeRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeRule_1")) return false;
    typeArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean typeVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeVar")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_VAR, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (AS IDENTIFIER)? | [TYPE] UP_IDENTIFIER (AS UP_IDENTIFIER)?
  public static boolean unqualifiedImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNQUALIFIED_IMPORT, "<unqualified import>");
    r = unqualifiedImport_0(b, l + 1);
    if (!r) r = unqualifiedImport_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER (AS IDENTIFIER)?
  private static boolean unqualifiedImport_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && unqualifiedImport_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AS IDENTIFIER)?
  private static boolean unqualifiedImport_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_0_1")) return false;
    unqualifiedImport_0_1_0(b, l + 1);
    return true;
  }

  // AS IDENTIFIER
  private static boolean unqualifiedImport_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AS, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // [TYPE] UP_IDENTIFIER (AS UP_IDENTIFIER)?
  private static boolean unqualifiedImport_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unqualifiedImport_1_0(b, l + 1);
    r = r && consumeToken(b, UP_IDENTIFIER);
    r = r && unqualifiedImport_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [TYPE]
  private static boolean unqualifiedImport_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_1_0")) return false;
    consumeToken(b, TYPE);
    return true;
  }

  // (AS UP_IDENTIFIER)?
  private static boolean unqualifiedImport_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_1_2")) return false;
    unqualifiedImport_1_2_0(b, l + 1);
    return true;
  }

  // AS UP_IDENTIFIER
  private static boolean unqualifiedImport_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AS, UP_IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE [unqualifiedImport (COMMA unqualifiedImport)* [COMMA]] RBRACE
  public static boolean unqualifiedImports(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && unqualifiedImports_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, UNQUALIFIED_IMPORTS, r);
    return r;
  }

  // [unqualifiedImport (COMMA unqualifiedImport)* [COMMA]]
  private static boolean unqualifiedImports_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1")) return false;
    unqualifiedImports_1_0(b, l + 1);
    return true;
  }

  // unqualifiedImport (COMMA unqualifiedImport)* [COMMA]
  private static boolean unqualifiedImports_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unqualifiedImport(b, l + 1);
    r = r && unqualifiedImports_1_0_1(b, l + 1);
    r = r && unqualifiedImports_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA unqualifiedImport)*
  private static boolean unqualifiedImports_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unqualifiedImports_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unqualifiedImports_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA unqualifiedImport
  private static boolean unqualifiedImports_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && unqualifiedImport(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean unqualifiedImports_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER | IDENTIFIER COMMA useArgs
  public static boolean useArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useArgs")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = useArgs_1(b, l + 1);
    exit_section_(b, m, USE_ARGS, r);
    return r;
  }

  // IDENTIFIER COMMA useArgs
  private static boolean useArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useArgs_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COMMA);
    r = r && useArgs(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PUB
  public static boolean visibilityModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "visibilityModifier")) return false;
    if (!nextTokenIs(b, PUB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PUB);
    exit_section_(b, m, VISIBILITY_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expression
  // Operator priority table:
  // 0: PREFIX(parenthesizedExpr)
  // 1: POSTFIX(callExpr)
  // 2: POSTFIX(accessExpr)
  // 3: BINARY(binaryExpr)
  // 4: ATOM(recordExpr)
  // 5: ATOM(anonymousFunctionExpr)
  // 6: ATOM(referenceExpr)
  // 7: ATOM(todoRuleExpr)
  // 8: ATOM(tupleExpr)
  // 9: ATOM(listExpr)
  // 10: ATOM(expressionBitStringExpr)
  // 11: ATOM(blockExpr)
  // 12: ATOM(caseExpr)
  // 13: ATOM(letExpr)
  // 14: PREFIX(useExpr)
  // 15: ATOM(assertExpr)
  // 16: PREFIX(negationExpr)
  // 17: PREFIX(recordUpdateExpr)
  // 18: ATOM(literalExpr)
  public static boolean expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = parenthesizedExpr(b, l + 1);
    if (!r) r = recordExpr(b, l + 1);
    if (!r) r = anonymousFunctionExpr(b, l + 1);
    if (!r) r = referenceExpr(b, l + 1);
    if (!r) r = todoRuleExpr(b, l + 1);
    if (!r) r = tupleExpr(b, l + 1);
    if (!r) r = listExpr(b, l + 1);
    if (!r) r = expressionBitStringExpr(b, l + 1);
    if (!r) r = blockExpr(b, l + 1);
    if (!r) r = caseExpr(b, l + 1);
    if (!r) r = letExpr(b, l + 1);
    if (!r) r = useExpr(b, l + 1);
    if (!r) r = assertExpr(b, l + 1);
    if (!r) r = negationExpr(b, l + 1);
    if (!r) r = recordUpdateExpr(b, l + 1);
    if (!r) r = literalExpr(b, l + 1);
    p = r;
    r = r && expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && arguments(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPR, r, true, null);
      }
      else if (g < 2 && accessExpr_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, ACCESS_EXPR, r, true, null);
      }
      else if (g < 3 && binaryOperator(b, l + 1)) {
        r = expression(b, l, 3);
        exit_section_(b, l, m, BINARY_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean parenthesizedExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesizedExpr")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r;
    r = p && expression(b, l, 0);
    r = p && report_error_(b, consumeToken(b, RPAREN)) && r;
    exit_section_(b, l, m, PARENTHESIZED_EXPR, r, p, null);
    return r || p;
  }

  // DOT label
  private static boolean accessExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "accessExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && label(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (constructorIdentifier | remoteConstructorIdentifier) [arguments]
  public static boolean recordExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordExpr")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_EXPR, "<record expr>");
    r = recordExpr_0(b, l + 1);
    r = r && recordExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // constructorIdentifier | remoteConstructorIdentifier
  private static boolean recordExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordExpr_0")) return false;
    boolean r;
    r = constructorIdentifier(b, l + 1);
    if (!r) r = remoteConstructorIdentifier(b, l + 1);
    return r;
  }

  // [arguments]
  private static boolean recordExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordExpr_1")) return false;
    arguments(b, l + 1);
    return true;
  }

  // FN anonymousFunctionParameters [R_ARROW typeRule] functionBody
  public static boolean anonymousFunctionExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionExpr")) return false;
    if (!nextTokenIsSmart(b, FN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, FN);
    r = r && anonymousFunctionParameters(b, l + 1);
    r = r && anonymousFunctionExpr_2(b, l + 1);
    r = r && functionBody(b, l + 1);
    exit_section_(b, m, ANONYMOUS_FUNCTION_EXPR, r);
    return r;
  }

  // [R_ARROW typeRule]
  private static boolean anonymousFunctionExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionExpr_2")) return false;
    anonymousFunctionExpr_2_0(b, l + 1);
    return true;
  }

  // R_ARROW typeRule
  private static boolean anonymousFunctionExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, R_ARROW);
    r = r && typeRule(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER
  public static boolean referenceExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpr")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENTIFIER);
    exit_section_(b, m, REFERENCE_EXPR, r);
    return r;
  }

  // TODO [LPAREN STRING_LITERAL RPAREN]
  public static boolean todoRuleExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "todoRuleExpr")) return false;
    if (!nextTokenIsSmart(b, TODO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, TODO);
    r = r && todoRuleExpr_1(b, l + 1);
    exit_section_(b, m, TODO_RULE_EXPR, r);
    return r;
  }

  // [LPAREN STRING_LITERAL RPAREN]
  private static boolean todoRuleExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "todoRuleExpr_1")) return false;
    parseTokensSmart(b, 0, LPAREN, STRING_LITERAL, RPAREN);
    return true;
  }

  // HASH LPAREN [expression (COMMA expression)* [COMMA]] RPAREN
  public static boolean tupleExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExpr")) return false;
    if (!nextTokenIsSmart(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, HASH, LPAREN);
    r = r && tupleExpr_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TUPLE_EXPR, r);
    return r;
  }

  // [expression (COMMA expression)* [COMMA]]
  private static boolean tupleExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExpr_2")) return false;
    tupleExpr_2_0(b, l + 1);
    return true;
  }

  // expression (COMMA expression)* [COMMA]
  private static boolean tupleExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1, -1);
    r = r && tupleExpr_2_0_1(b, l + 1);
    r = r && tupleExpr_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expression)*
  private static boolean tupleExpr_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExpr_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tupleExpr_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tupleExpr_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean tupleExpr_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExpr_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean tupleExpr_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExpr_2_0_2")) return false;
    consumeTokenSmart(b, COMMA);
    return true;
  }

  // LBRACK [expression ((COMMA expression)*)? [COMMA] [DOT_DOT expression]] RBRACK
  public static boolean listExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr")) return false;
    if (!nextTokenIsSmart(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACK);
    r = r && listExpr_1(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, LIST_EXPR, r);
    return r;
  }

  // [expression ((COMMA expression)*)? [COMMA] [DOT_DOT expression]]
  private static boolean listExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_1")) return false;
    listExpr_1_0(b, l + 1);
    return true;
  }

  // expression ((COMMA expression)*)? [COMMA] [DOT_DOT expression]
  private static boolean listExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1, -1);
    r = r && listExpr_1_0_1(b, l + 1);
    r = r && listExpr_1_0_2(b, l + 1);
    r = r && listExpr_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((COMMA expression)*)?
  private static boolean listExpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_1_0_1")) return false;
    listExpr_1_0_1_0(b, l + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean listExpr_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_1_0_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!listExpr_1_0_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listExpr_1_0_1_0", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean listExpr_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean listExpr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_1_0_2")) return false;
    consumeTokenSmart(b, COMMA);
    return true;
  }

  // [DOT_DOT expression]
  private static boolean listExpr_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_1_0_3")) return false;
    listExpr_1_0_3_0(b, l + 1);
    return true;
  }

  // DOT_DOT expression
  private static boolean listExpr_1_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_1_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT_DOT);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LT_LT [expressionBitStringSegment (COMMA expressionBitStringSegment)* [COMMA]] GT_GT
  public static boolean expressionBitStringExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringExpr")) return false;
    if (!nextTokenIsSmart(b, LT_LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LT_LT);
    r = r && expressionBitStringExpr_1(b, l + 1);
    r = r && consumeToken(b, GT_GT);
    exit_section_(b, m, EXPRESSION_BIT_STRING_EXPR, r);
    return r;
  }

  // [expressionBitStringSegment (COMMA expressionBitStringSegment)* [COMMA]]
  private static boolean expressionBitStringExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringExpr_1")) return false;
    expressionBitStringExpr_1_0(b, l + 1);
    return true;
  }

  // expressionBitStringSegment (COMMA expressionBitStringSegment)* [COMMA]
  private static boolean expressionBitStringExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expressionBitStringSegment(b, l + 1);
    r = r && expressionBitStringExpr_1_0_1(b, l + 1);
    r = r && expressionBitStringExpr_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expressionBitStringSegment)*
  private static boolean expressionBitStringExpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringExpr_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expressionBitStringExpr_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expressionBitStringExpr_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA expressionBitStringSegment
  private static boolean expressionBitStringExpr_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringExpr_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && expressionBitStringSegment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean expressionBitStringExpr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionBitStringExpr_1_0_2")) return false;
    consumeTokenSmart(b, COMMA);
    return true;
  }

  // LBRACE expressionSeq RBRACE
  public static boolean blockExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockExpr")) return false;
    if (!nextTokenIsSmart(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACE);
    r = r && expressionSeq(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK_EXPR, r);
    return r;
  }

  // CASE caseSubjects LBRACE caseClauses RBRACE
  public static boolean caseExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseExpr")) return false;
    if (!nextTokenIsSmart(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, CASE);
    r = r && caseSubjects(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && caseClauses(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, CASE_EXPR, r);
    return r;
  }

  // LET assignment
  public static boolean letExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "letExpr")) return false;
    if (!nextTokenIsSmart(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LET);
    r = r && assignment(b, l + 1);
    exit_section_(b, m, LET_EXPR, r);
    return r;
  }

  public static boolean useExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useExpr")) return false;
    if (!nextTokenIsSmart(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = useExpr_0(b, l + 1);
    p = r;
    r = p && expression(b, l, 14);
    exit_section_(b, l, m, USE_EXPR, r, p, null);
    return r || p;
  }

  // USE [useArgs] L_ARROW
  private static boolean useExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, USE);
    r = r && useExpr_0_1(b, l + 1);
    r = r && consumeToken(b, L_ARROW);
    exit_section_(b, m, null, r);
    return r;
  }

  // [useArgs]
  private static boolean useExpr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useExpr_0_1")) return false;
    useArgs(b, l + 1);
    return true;
  }

  // ASSERT assignment
  public static boolean assertExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assertExpr")) return false;
    if (!nextTokenIsSmart(b, ASSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, ASSERT);
    r = r && assignment(b, l + 1);
    exit_section_(b, m, ASSERT_EXPR, r);
    return r;
  }

  public static boolean negationExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negationExpr")) return false;
    if (!nextTokenIsSmart(b, BANG)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, BANG);
    p = r;
    r = p && expression(b, l, 16);
    exit_section_(b, l, m, NEGATION_EXPR, r, p, null);
    return r || p;
  }

  public static boolean recordUpdateExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateExpr")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER, UP_IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = recordUpdateExpr_0(b, l + 1);
    p = r;
    r = p && expression(b, l, 17);
    r = p && report_error_(b, recordUpdateExpr_1(b, l + 1)) && r;
    exit_section_(b, l, m, RECORD_UPDATE_EXPR, r, p, null);
    return r || p;
  }

  // (constructorIdentifier | remoteConstructorIdentifier) LPAREN DOT_DOT
  private static boolean recordUpdateExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recordUpdateExpr_0_0(b, l + 1);
    r = r && consumeTokensSmart(b, 0, LPAREN, DOT_DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // constructorIdentifier | remoteConstructorIdentifier
  private static boolean recordUpdateExpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateExpr_0_0")) return false;
    boolean r;
    r = constructorIdentifier(b, l + 1);
    if (!r) r = remoteConstructorIdentifier(b, l + 1);
    return r;
  }

  // COMMA recordUpdateArguments RPAREN
  private static boolean recordUpdateExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdateExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && recordUpdateArguments(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_LITERAL | INTEGER_LITERAL | FLOAT_LITERAL | BOOLEAN_LITERAL
  public static boolean literalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeTokenSmart(b, STRING_LITERAL);
    if (!r) r = consumeTokenSmart(b, INTEGER_LITERAL);
    if (!r) r = consumeTokenSmart(b, FLOAT_LITERAL);
    if (!r) r = consumeTokenSmart(b, BOOLEAN_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
