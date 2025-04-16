// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.themartdev.intellijgleam.lang.psi.GleamTypes.*;
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
    return root(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ALIAS_TYPE_VALUE, CUSTOM_TYPE_VALUE, OMITTED_TYPE_VALUE, TYPE_VALUE),
    create_token_set_(ANNOTATION, CONSTANT_TYPE_ANNOTATION, DEPRECATED_ANNOTATION, EXTERNAL_ANNOTATION,
      OTHER_ANNOTATION, TARGET_ANNOTATION, TYPE_ANNOTATION),
    create_token_set_(BIT_ARRAY_EXPR_CONST, EXPRESSION_CONST, FIELD_ACCESS_EXPR_CONST, IDENTIFIER_EXPR_CONST,
      LIST_EXPR_CONST, LITERAL_EXPR_CONST, RECORD_EXPR_CONST, TUPLE_EXPR_CONST),
    create_token_set_(BIT_ARRAY_PATTERN, CASE_CLAUSE_PATTERN, IDENTIFIER_PATTERN, LIST_PATTERN,
      LITERAL_PATTERN, PATTERN, RECORD_PATTERN, STRING_PATTERN,
      TUPLE_PATTERN),
    create_token_set_(ANONYMOUS_FUNCTION_EXPR, BINARY_EXPR, BIT_ARRAY_EXPR, BLOCK_EXPR,
      CALL_EXPR, CASE_EXPR, EXPRESSION, FIELD_ACCESS_EXPR,
      INDEX_ACCESS_EXPR, LET_EXPR, LIST_EXPR, LITERAL_EXPR,
      PANIC_EXPR, RECORD_EXPR, REFERENCE_EXPR, TODO_EXPR,
      TUPLE_EXPR, UNARY_EXPR, USE_EXPR),
  };

  /* ********************************************************** */
  // identifierDiscardable
  public static boolean aliasIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasIdentifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALIAS_IDENTIFIER, "<alias identifier>");
    r = identifierDiscardable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // typeGenerics? EQUAL typeBase
  public static boolean aliasTypeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasTypeValue")) return false;
    if (!nextTokenIs(b, "<alias type value>", EQUAL, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALIAS_TYPE_VALUE, "<alias type value>");
    r = aliasTypeValue_0(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && typeBase(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // typeGenerics?
  private static boolean aliasTypeValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasTypeValue_0")) return false;
    typeGenerics(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // upIdentifier
  public static boolean aliasUpIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasUpIdentifier")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = upIdentifier(b, l + 1);
    exit_section_(b, m, ALIAS_UP_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // externalAnnotation | deprecatedAnnotation | targetAnnotation | otherAnnotation
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, ANNOTATION_MARK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, ANNOTATION, null);
    r = externalAnnotation(b, l + 1);
    if (!r) r = deprecatedAnnotation(b, l + 1);
    if (!r) r = targetAnnotation(b, l + 1);
    if (!r) r = otherAnnotation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifierDiscardable [typeAnnotation]
  public static boolean anonymousFunctionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANONYMOUS_FUNCTION_PARAMETER, "<anonymous function parameter>");
    r = identifierDiscardable(b, l + 1);
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
  // BASE_NUMBER_PREFIX BINARY_NUMBER_BASE VALID_BINARY_DIGIT (NUMBER_SEPARATOR VALID_BINARY_DIGIT)*
  public static boolean binaryIntegerLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryIntegerLiteral")) return false;
    if (!nextTokenIs(b, BASE_NUMBER_PREFIX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BASE_NUMBER_PREFIX, BINARY_NUMBER_BASE, VALID_BINARY_DIGIT);
    r = r && binaryIntegerLiteral_3(b, l + 1);
    exit_section_(b, m, BINARY_INTEGER_LITERAL, r);
    return r;
  }

  // (NUMBER_SEPARATOR VALID_BINARY_DIGIT)*
  private static boolean binaryIntegerLiteral_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryIntegerLiteral_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!binaryIntegerLiteral_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binaryIntegerLiteral_3", c)) break;
    }
    return true;
  }

  // NUMBER_SEPARATOR VALID_BINARY_DIGIT
  private static boolean binaryIntegerLiteral_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryIntegerLiteral_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NUMBER_SEPARATOR, VALID_BINARY_DIGIT);
    exit_section_(b, m, null, r);
    return r;
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
  // LT_LT [constantBitArraySegment (COMMA constantBitArraySegment)* [COMMA]] GT_GT
  public static boolean bitArrayExprConst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExprConst")) return false;
    if (!nextTokenIs(b, LT_LT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BIT_ARRAY_EXPR_CONST, null);
    r = consumeToken(b, LT_LT);
    p = r; // pin = 1
    r = r && report_error_(b, bitArrayExprConst_1(b, l + 1));
    r = p && consumeToken(b, GT_GT) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [constantBitArraySegment (COMMA constantBitArraySegment)* [COMMA]]
  private static boolean bitArrayExprConst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExprConst_1")) return false;
    bitArrayExprConst_1_0(b, l + 1);
    return true;
  }

  // constantBitArraySegment (COMMA constantBitArraySegment)* [COMMA]
  private static boolean bitArrayExprConst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExprConst_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constantBitArraySegment(b, l + 1);
    r = r && bitArrayExprConst_1_0_1(b, l + 1);
    r = r && bitArrayExprConst_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA constantBitArraySegment)*
  private static boolean bitArrayExprConst_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExprConst_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitArrayExprConst_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitArrayExprConst_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA constantBitArraySegment
  private static boolean bitArrayExprConst_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExprConst_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constantBitArraySegment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean bitArrayExprConst_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExprConst_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean bitArrayOptionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayOptionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, BIT_ARRAY_OPTION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // LT_LT [patternBitArraySegment (COMMA patternBitArraySegment)* [COMMA]] GT_GT
  public static boolean bitArrayPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayPattern")) return false;
    if (!nextTokenIs(b, LT_LT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BIT_ARRAY_PATTERN, null);
    r = consumeToken(b, LT_LT);
    p = r; // pin = 1
    r = r && report_error_(b, bitArrayPattern_1(b, l + 1));
    r = p && consumeToken(b, GT_GT) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [patternBitArraySegment (COMMA patternBitArraySegment)* [COMMA]]
  private static boolean bitArrayPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayPattern_1")) return false;
    bitArrayPattern_1_0(b, l + 1);
    return true;
  }

  // patternBitArraySegment (COMMA patternBitArraySegment)* [COMMA]
  private static boolean bitArrayPattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayPattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = patternBitArraySegment(b, l + 1);
    r = r && bitArrayPattern_1_0_1(b, l + 1);
    r = r && bitArrayPattern_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA patternBitArraySegment)*
  private static boolean bitArrayPattern_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayPattern_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitArrayPattern_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitArrayPattern_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA patternBitArraySegment
  private static boolean bitArrayPattern_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayPattern_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && patternBitArraySegment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean bitArrayPattern_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayPattern_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // expression [COLON bitArraySegmentOptions]
  public static boolean bitArraySegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_ARRAY_SEGMENT, "<bit array segment>");
    r = expression(b, l + 1, -1);
    r = r && bitArraySegment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON bitArraySegmentOptions]
  private static boolean bitArraySegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegment_1")) return false;
    bitArraySegment_1_0(b, l + 1);
    return true;
  }

  // COLON bitArraySegmentOptions
  private static boolean bitArraySegment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && bitArraySegmentOptions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bitArrayOptionName [LPAREN wholeNumber RPAREN] | wholeNumber
  public static boolean bitArraySegmentOption(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegmentOption")) return false;
    if (!nextTokenIs(b, "<bit array segment option>", IDENTIFIER, VALID_DECIMAL_DIGIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_ARRAY_SEGMENT_OPTION, "<bit array segment option>");
    r = bitArraySegmentOption_0(b, l + 1);
    if (!r) r = wholeNumber(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // bitArrayOptionName [LPAREN wholeNumber RPAREN]
  private static boolean bitArraySegmentOption_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegmentOption_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bitArrayOptionName(b, l + 1);
    r = r && bitArraySegmentOption_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [LPAREN wholeNumber RPAREN]
  private static boolean bitArraySegmentOption_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegmentOption_0_1")) return false;
    bitArraySegmentOption_0_1_0(b, l + 1);
    return true;
  }

  // LPAREN wholeNumber RPAREN
  private static boolean bitArraySegmentOption_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegmentOption_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && wholeNumber(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bitArraySegmentOption (MINUS bitArraySegmentOption)*
  public static boolean bitArraySegmentOptions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegmentOptions")) return false;
    if (!nextTokenIs(b, "<bit array segment options>", IDENTIFIER, VALID_DECIMAL_DIGIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_ARRAY_SEGMENT_OPTIONS, "<bit array segment options>");
    r = bitArraySegmentOption(b, l + 1);
    r = r && bitArraySegmentOptions_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MINUS bitArraySegmentOption)*
  private static boolean bitArraySegmentOptions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegmentOptions_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitArraySegmentOptions_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitArraySegmentOptions_1", c)) break;
    }
    return true;
  }

  // MINUS bitArraySegmentOption
  private static boolean bitArraySegmentOptions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArraySegmentOptions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && bitArraySegmentOption(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // labeledArgument | unlabeledArgument | hole
  public static boolean callArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALL_ARGUMENT, "<call argument>");
    r = labeledArgument(b, l + 1);
    if (!r) r = unlabeledArgument(b, l + 1);
    if (!r) r = hole(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [callArgument (COMMA callArgument)* [COMMA]] RPAREN
  public static boolean callArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && callArguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CALL_ARGUMENTS, r);
    return r;
  }

  // [callArgument (COMMA callArgument)* [COMMA]]
  private static boolean callArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArguments_1")) return false;
    callArguments_1_0(b, l + 1);
    return true;
  }

  // callArgument (COMMA callArgument)* [COMMA]
  private static boolean callArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = callArgument(b, l + 1);
    r = r && callArguments_1_0_1(b, l + 1);
    r = r && callArguments_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA callArgument)*
  private static boolean callArguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!callArguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "callArguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA callArgument
  private static boolean callArguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && callArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean callArguments_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callArguments_1_0_2")) return false;
    consumeToken(b, COMMA);
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
  // IF expression
  public static boolean caseClauseGuard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauseGuard")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, CASE_CLAUSE_GUARD, r);
    return r;
  }

  /* ********************************************************** */
  // patternAliasable (COMMA patternAliasable)* [COMMA]
  public static boolean caseClausePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSE_PATTERN, "<case clause pattern>");
    r = patternAliasable(b, l + 1);
    r = r && caseClausePattern_1(b, l + 1);
    r = r && caseClausePattern_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA patternAliasable)*
  private static boolean caseClausePattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePattern_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseClausePattern_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseClausePattern_1", c)) break;
    }
    return true;
  }

  // COMMA patternAliasable
  private static boolean caseClausePattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClausePattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && patternAliasable(b, l + 1);
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
  // caseClause*
  public static boolean caseClauses(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseClauses")) return false;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLAUSES, "<case clauses>");
    while (true) {
      int c = current_position_(b);
      if (!caseClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseClauses", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // LBRACE caseClauses RBRACE
  public static boolean caseExprBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseExprBody")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CASE_EXPR_BODY, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, caseClauses(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // expression (COMMA expression)*
  public static boolean caseSubjects(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseSubjects")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_SUBJECTS, "<case subjects>");
    r = expression(b, l + 1, -1);
    r = r && caseSubjects_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA expression)*
  private static boolean caseSubjects_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseSubjects_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseSubjects_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseSubjects_1", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean caseSubjects_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseSubjects_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expressionConst [COLON bitArraySegmentOptions]
  public static boolean constantBitArraySegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitArraySegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_BIT_ARRAY_SEGMENT, "<constant bit array segment>");
    r = expressionConst(b, l + 1);
    r = r && constantBitArraySegment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON bitArraySegmentOptions]
  private static boolean constantBitArraySegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitArraySegment_1")) return false;
    constantBitArraySegment_1_0(b, l + 1);
    return true;
  }

  // COLON bitArraySegmentOptions
  private static boolean constantBitArraySegment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantBitArraySegment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && bitArraySegmentOptions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [visibilityModifier] CONST IDENTIFIER [constantTypeAnnotation] EQUAL expressionConst
  public static boolean constantDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantDeclaration")) return false;
    if (!nextTokenIs(b, "<constant declaration>", CONST, PUB)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_DECLARATION, "<constant declaration>");
    r = constantDeclaration_0(b, l + 1);
    r = r && consumeTokens(b, 1, CONST, IDENTIFIER);
    p = r; // pin = 2
    r = r && report_error_(b, constantDeclaration_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, EQUAL)) && r;
    r = p && expressionConst(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [visibilityModifier]
  private static boolean constantDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantDeclaration_0")) return false;
    visibilityModifier(b, l + 1);
    return true;
  }

  // [constantTypeAnnotation]
  private static boolean constantDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantDeclaration_3")) return false;
    constantTypeAnnotation(b, l + 1);
    return true;
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
  // [label COLON] expressionConst
  public static boolean constantRecordArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantRecordArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_RECORD_ARGUMENT, "<constant record argument>");
    r = constantRecordArgument_0(b, l + 1);
    r = r && expressionConst(b, l + 1);
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
  // typeName [constantTypeArguments]
  public static boolean constantType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_TYPE, "<constant type>");
    r = typeName(b, l + 1);
    r = r && constantType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // typeName
  //                       | constantTypeTuple
  //                       | constantTypeFunction
  //                       | constantType
  public static boolean constantTypeSpecial(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantTypeSpecial")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_TYPE_SPECIAL, "<constant type special>");
    r = typeName(b, l + 1);
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
  // typeGenerics? LBRACE recordConstructor* RBRACE
  public static boolean customTypeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customTypeValue")) return false;
    if (!nextTokenIs(b, "<custom type value>", LBRACE, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CUSTOM_TYPE_VALUE, "<custom type value>");
    r = customTypeValue_0(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    p = r; // pin = 2
    r = r && report_error_(b, customTypeValue_2(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // typeGenerics?
  private static boolean customTypeValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customTypeValue_0")) return false;
    typeGenerics(b, l + 1);
    return true;
  }

  // recordConstructor*
  private static boolean customTypeValue_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customTypeValue_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!recordConstructor(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "customTypeValue_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // wholeNumber
  public static boolean decimalIntegerLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimalIntegerLiteral")) return false;
    if (!nextTokenIs(b, VALID_DECIMAL_DIGIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wholeNumber(b, l + 1);
    exit_section_(b, m, DECIMAL_INTEGER_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // !topLevelKeyword
  static boolean declarationRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declarationRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !topLevelKeyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ANNOTATION_MARK deprecatedAnnotationName LPAREN stringLiteral RPAREN
  public static boolean deprecatedAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deprecatedAnnotation")) return false;
    if (!nextTokenIs(b, ANNOTATION_MARK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEPRECATED_ANNOTATION, null);
    r = consumeToken(b, ANNOTATION_MARK);
    r = r && deprecatedAnnotationName(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, LPAREN));
    r = p && report_error_(b, stringLiteral(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // "deprecated"
  public static boolean deprecatedAnnotationName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deprecatedAnnotationName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEPRECATED_ANNOTATION_NAME, "<deprecated annotation name>");
    r = consumeToken(b, "deprecated");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // literalExprConst
  //             | tupleExprConst
  //             | bitArrayExprConst
  //             | listExprConst
  //             | recordExprConst
  //             | fieldAccessExprConst
  //             // Can refer to another constant
  //             | identifierExprConst
  public static boolean expressionConst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionConst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION_CONST, "<expression const>");
    r = literalExprConst(b, l + 1);
    if (!r) r = tupleExprConst(b, l + 1);
    if (!r) r = bitArrayExprConst(b, l + 1);
    if (!r) r = listExprConst(b, l + 1);
    if (!r) r = recordExprConst(b, l + 1);
    if (!r) r = fieldAccessExprConst(b, l + 1);
    if (!r) r = identifierExprConst(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(RBRACE | RPAREN | RBRACK | EOL | LET | expression)
  static boolean expressionRecoverWhile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionRecoverWhile")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !expressionRecoverWhile_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RBRACE | RPAREN | RBRACK | EOL | LET | expression
  private static boolean expressionRecoverWhile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionRecoverWhile_0")) return false;
    boolean r;
    r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, RBRACK);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = expression(b, l + 1, -1);
    return r;
  }

  /* ********************************************************** */
  // ANNOTATION_MARK externalAnnotationName LPAREN externalTarget COMMA stringLiteral COMMA stringLiteral RPAREN
  public static boolean externalAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalAnnotation")) return false;
    if (!nextTokenIs(b, ANNOTATION_MARK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXTERNAL_ANNOTATION, null);
    r = consumeToken(b, ANNOTATION_MARK);
    r = r && externalAnnotationName(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, LPAREN));
    r = p && report_error_(b, externalTarget(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, COMMA)) && r;
    r = p && report_error_(b, stringLiteral(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, COMMA)) && r;
    r = p && report_error_(b, stringLiteral(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // "external"
  public static boolean externalAnnotationName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalAnnotationName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTERNAL_ANNOTATION_NAME, "<external annotation name>");
    r = consumeToken(b, "external");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "javascript" | "erlang"
  public static boolean externalTarget(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalTarget")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTERNAL_TARGET, "<external target>");
    r = consumeToken(b, "javascript");
    if (!r) r = consumeToken(b, "erlang");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER DOT label
  public static boolean fieldAccessExprConst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldAccessExprConst")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DOT);
    r = r && label(b, l + 1);
    exit_section_(b, m, FIELD_ACCESS_EXPR_CONST, r);
    return r;
  }

  /* ********************************************************** */
  // MINUS? wholeNumber DOT wholeNumber? (EXPONENT_MARK EXPONENT_SIGN? wholeNumber)?
  public static boolean floatLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floatLiteral")) return false;
    if (!nextTokenIs(b, "<float literal>", MINUS, VALID_DECIMAL_DIGIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLOAT_LITERAL, "<float literal>");
    r = floatLiteral_0(b, l + 1);
    r = r && wholeNumber(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && floatLiteral_3(b, l + 1);
    r = r && floatLiteral_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // MINUS?
  private static boolean floatLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floatLiteral_0")) return false;
    consumeToken(b, MINUS);
    return true;
  }

  // wholeNumber?
  private static boolean floatLiteral_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floatLiteral_3")) return false;
    wholeNumber(b, l + 1);
    return true;
  }

  // (EXPONENT_MARK EXPONENT_SIGN? wholeNumber)?
  private static boolean floatLiteral_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floatLiteral_4")) return false;
    floatLiteral_4_0(b, l + 1);
    return true;
  }

  // EXPONENT_MARK EXPONENT_SIGN? wholeNumber
  private static boolean floatLiteral_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floatLiteral_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPONENT_MARK);
    r = r && floatLiteral_4_0_1(b, l + 1);
    r = r && wholeNumber(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EXPONENT_SIGN?
  private static boolean floatLiteral_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floatLiteral_4_0_1")) return false;
    consumeToken(b, EXPONENT_SIGN);
    return true;
  }

  /* ********************************************************** */
  // LBRACE expression* RBRACE
  public static boolean functionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionBody")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_BODY, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, functionBody_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // expression*
  private static boolean functionBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionBody_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1, -1)) break;
      if (!empty_element_parsed_guard_(b, "functionBody_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (annotation)* [visibilityModifier] FN functionNameDefinition functionParameters [R_ARROW typeBase] functionBody?
  public static boolean functionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, "<function declaration>");
    r = functionDeclaration_0(b, l + 1);
    r = r && functionDeclaration_1(b, l + 1);
    r = r && consumeToken(b, FN);
    p = r; // pin = 3
    r = r && report_error_(b, functionNameDefinition(b, l + 1));
    r = p && report_error_(b, functionParameters(b, l + 1)) && r;
    r = p && report_error_(b, functionDeclaration_5(b, l + 1)) && r;
    r = p && functionDeclaration_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (annotation)*
  private static boolean functionDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionDeclaration_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionDeclaration_0", c)) break;
    }
    return true;
  }

  // (annotation)
  private static boolean functionDeclaration_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = annotation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [visibilityModifier]
  private static boolean functionDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_1")) return false;
    visibilityModifier(b, l + 1);
    return true;
  }

  // [R_ARROW typeBase]
  private static boolean functionDeclaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_5")) return false;
    functionDeclaration_5_0(b, l + 1);
    return true;
  }

  // R_ARROW typeBase
  private static boolean functionDeclaration_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, R_ARROW);
    r = r && typeBase(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // functionBody?
  private static boolean functionDeclaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_6")) return false;
    functionBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean functionNameDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionNameDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_NAME_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // (label identifierDiscardable | identifierDiscardable) [typeAnnotation]
  public static boolean functionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_PARAMETER, "<function parameter>");
    r = functionParameter_0(b, l + 1);
    r = r && functionParameter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // label identifierDiscardable | identifierDiscardable
  private static boolean functionParameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionParameter_0_0(b, l + 1);
    if (!r) r = identifierDiscardable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // label identifierDiscardable
  private static boolean functionParameter_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameter_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && identifierDiscardable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [typeAnnotation]
  private static boolean functionParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameter_1")) return false;
    typeAnnotation(b, l + 1);
    return true;
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_TYPE, null);
    r = consumeToken(b, FN);
    p = r; // pin = 1
    r = r && report_error_(b, functionType_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, R_ARROW)) && r;
    r = p && typeBase(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [functionParameterTypes]
  private static boolean functionType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionType_1")) return false;
    functionParameterTypes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifierDiscardable
  public static boolean genericType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_TYPE, "<generic type>");
    r = identifierDiscardable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BASE_NUMBER_PREFIX HEX_NUMBER_BASE VALID_HEX_DIGIT (NUMBER_SEPARATOR VALID_HEX_DIGIT)*
  public static boolean hexIntegerLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hexIntegerLiteral")) return false;
    if (!nextTokenIs(b, BASE_NUMBER_PREFIX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BASE_NUMBER_PREFIX, HEX_NUMBER_BASE, VALID_HEX_DIGIT);
    r = r && hexIntegerLiteral_3(b, l + 1);
    exit_section_(b, m, HEX_INTEGER_LITERAL, r);
    return r;
  }

  // (NUMBER_SEPARATOR VALID_HEX_DIGIT)*
  private static boolean hexIntegerLiteral_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hexIntegerLiteral_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!hexIntegerLiteral_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "hexIntegerLiteral_3", c)) break;
    }
    return true;
  }

  // NUMBER_SEPARATOR VALID_HEX_DIGIT
  private static boolean hexIntegerLiteral_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hexIntegerLiteral_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NUMBER_SEPARATOR, VALID_HEX_DIGIT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HOLE
  static boolean hole(PsiBuilder b, int l) {
    return consumeToken(b, HOLE);
  }

  /* ********************************************************** */
  // IDENTIFIER | DISCARD_NAME | HOLE
  public static boolean identifierDiscardable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierDiscardable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_DISCARDABLE, "<identifier discardable>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, DISCARD_NAME);
    if (!r) r = consumeToken(b, HOLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifierDiscardable
  public static boolean identifierExprConst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierExprConst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_EXPR_CONST, "<identifier expr const>");
    r = identifierDiscardable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifierDiscardable
  public static boolean identifierPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_PATTERN, "<identifier pattern>");
    r = identifierDiscardable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // targetAnnotation? IMPORT modulePath [DOT unqualifiedImports] [AS IDENTIFIER]
  public static boolean importDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importDeclaration")) return false;
    if (!nextTokenIs(b, "<import declaration>", ANNOTATION_MARK, IMPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_DECLARATION, "<import declaration>");
    r = importDeclaration_0(b, l + 1);
    r = r && consumeToken(b, IMPORT);
    p = r; // pin = 2
    r = r && report_error_(b, modulePath(b, l + 1));
    r = p && report_error_(b, importDeclaration_3(b, l + 1)) && r;
    r = p && importDeclaration_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // targetAnnotation?
  private static boolean importDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importDeclaration_0")) return false;
    targetAnnotation(b, l + 1);
    return true;
  }

  // [DOT unqualifiedImports]
  private static boolean importDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importDeclaration_3")) return false;
    importDeclaration_3_0(b, l + 1);
    return true;
  }

  // DOT unqualifiedImports
  private static boolean importDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && unqualifiedImports(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [AS IDENTIFIER]
  private static boolean importDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importDeclaration_4")) return false;
    parseTokens(b, 0, AS, IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // binaryIntegerLiteral | octalIntegerLiteral | hexIntegerLiteral | decimalIntegerLiteral
  public static boolean integerLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerLiteral")) return false;
    if (!nextTokenIs(b, "<integer literal>", BASE_NUMBER_PREFIX, VALID_DECIMAL_DIGIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_LITERAL, "<integer literal>");
    r = binaryIntegerLiteral(b, l + 1);
    if (!r) r = octalIntegerLiteral(b, l + 1);
    if (!r) r = hexIntegerLiteral(b, l + 1);
    if (!r) r = decimalIntegerLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // identifierDiscardable COLON expression
  public static boolean labeledArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABELED_ARGUMENT, "<labeled argument>");
    r = identifierDiscardable(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // label COLON typeBase
  public static boolean labeledParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LABELED_PARAMETER, null);
    r = label(b, l + 1);
    r = r && consumeToken(b, COLON);
    p = r; // pin = 2
    r = r && typeBase(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LBRACK [expressionConst (COMMA expressionConst)* [COMMA]] RBRACK
  public static boolean listExprConst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExprConst")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIST_EXPR_CONST, null);
    r = consumeToken(b, LBRACK);
    p = r; // pin = 1
    r = r && report_error_(b, listExprConst_1(b, l + 1));
    r = p && consumeToken(b, RBRACK) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [expressionConst (COMMA expressionConst)* [COMMA]]
  private static boolean listExprConst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExprConst_1")) return false;
    listExprConst_1_0(b, l + 1);
    return true;
  }

  // expressionConst (COMMA expressionConst)* [COMMA]
  private static boolean listExprConst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExprConst_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expressionConst(b, l + 1);
    r = r && listExprConst_1_0_1(b, l + 1);
    r = r && listExprConst_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expressionConst)*
  private static boolean listExprConst_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExprConst_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!listExprConst_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listExprConst_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA expressionConst
  private static boolean listExprConst_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExprConst_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expressionConst(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean listExprConst_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExprConst_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LBRACK [patternAliasable (COMMA patternAliasable)* [COMMA]] [listPatternTail] RBRACK
  public static boolean listPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIST_PATTERN, null);
    r = consumeToken(b, LBRACK);
    p = r; // pin = 1
    r = r && report_error_(b, listPattern_1(b, l + 1));
    r = p && report_error_(b, listPattern_2(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACK) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [patternAliasable (COMMA patternAliasable)* [COMMA]]
  private static boolean listPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1")) return false;
    listPattern_1_0(b, l + 1);
    return true;
  }

  // patternAliasable (COMMA patternAliasable)* [COMMA]
  private static boolean listPattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = patternAliasable(b, l + 1);
    r = r && listPattern_1_0_1(b, l + 1);
    r = r && listPattern_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA patternAliasable)*
  private static boolean listPattern_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!listPattern_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listPattern_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA patternAliasable
  private static boolean listPattern_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPattern_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && patternAliasable(b, l + 1);
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
  // DOT_DOT [identifierDiscardable]
  public static boolean listPatternTail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPatternTail")) return false;
    if (!nextTokenIs(b, DOT_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIST_PATTERN_TAIL, null);
    r = consumeToken(b, DOT_DOT);
    p = r; // pin = 1
    r = r && listPatternTail_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [identifierDiscardable]
  private static boolean listPatternTail_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listPatternTail_1")) return false;
    identifierDiscardable(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // floatLiteral
  //               | stringLiteral
  //               | integerLiteral
  //               | BOOLEAN_LITERAL
  static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    r = floatLiteral(b, l + 1);
    if (!r) r = stringLiteral(b, l + 1);
    if (!r) r = integerLiteral(b, l + 1);
    if (!r) r = consumeToken(b, BOOLEAN_LITERAL);
    return r;
  }

  /* ********************************************************** */
  // literal | negativeDecimalIntegerLiteral
  public static boolean literalExprConst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExprConst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR_CONST, "<literal expr const>");
    r = literal(b, l + 1);
    if (!r) r = negativeDecimalIntegerLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // literal
  public static boolean literalPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_PATTERN, "<literal pattern>");
    r = literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (SLASH IDENTIFIER)*
  public static boolean modulePath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modulePath")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_PATH, null);
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && modulePath_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (SLASH IDENTIFIER)*
  private static boolean modulePath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modulePath_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!modulePath_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modulePath_1", c)) break;
    }
    return true;
  }

  // SLASH IDENTIFIER
  private static boolean modulePath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modulePath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SLASH, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MINUS wholeNumber
  public static boolean negativeDecimalIntegerLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negativeDecimalIntegerLiteral")) return false;
    if (!nextTokenIs(b, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && wholeNumber(b, l + 1);
    exit_section_(b, m, NEGATIVE_DECIMAL_INTEGER_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // BASE_NUMBER_PREFIX OCTAL_NUMBER_BASE VALID_OCTAL_DIGIT (NUMBER_SEPARATOR VALID_OCTAL_DIGIT)*
  public static boolean octalIntegerLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "octalIntegerLiteral")) return false;
    if (!nextTokenIs(b, BASE_NUMBER_PREFIX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BASE_NUMBER_PREFIX, OCTAL_NUMBER_BASE, VALID_OCTAL_DIGIT);
    r = r && octalIntegerLiteral_3(b, l + 1);
    exit_section_(b, m, OCTAL_INTEGER_LITERAL, r);
    return r;
  }

  // (NUMBER_SEPARATOR VALID_OCTAL_DIGIT)*
  private static boolean octalIntegerLiteral_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "octalIntegerLiteral_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!octalIntegerLiteral_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "octalIntegerLiteral_3", c)) break;
    }
    return true;
  }

  // NUMBER_SEPARATOR VALID_OCTAL_DIGIT
  private static boolean octalIntegerLiteral_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "octalIntegerLiteral_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NUMBER_SEPARATOR, VALID_OCTAL_DIGIT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  public static boolean omittedTypeValue(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, OMITTED_TYPE_VALUE, true);
    return true;
  }

  /* ********************************************************** */
  // ANNOTATION_MARK unknownAnnotationName [LPAREN [unknownAnnotationArgument (COMMA unknownAnnotationArgument)*] RPAREN]
  public static boolean otherAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherAnnotation")) return false;
    if (!nextTokenIs(b, ANNOTATION_MARK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANNOTATION_MARK);
    r = r && unknownAnnotationName(b, l + 1);
    r = r && otherAnnotation_2(b, l + 1);
    exit_section_(b, m, OTHER_ANNOTATION, r);
    return r;
  }

  // [LPAREN [unknownAnnotationArgument (COMMA unknownAnnotationArgument)*] RPAREN]
  private static boolean otherAnnotation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherAnnotation_2")) return false;
    otherAnnotation_2_0(b, l + 1);
    return true;
  }

  // LPAREN [unknownAnnotationArgument (COMMA unknownAnnotationArgument)*] RPAREN
  private static boolean otherAnnotation_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherAnnotation_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && otherAnnotation_2_0_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // [unknownAnnotationArgument (COMMA unknownAnnotationArgument)*]
  private static boolean otherAnnotation_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherAnnotation_2_0_1")) return false;
    otherAnnotation_2_0_1_0(b, l + 1);
    return true;
  }

  // unknownAnnotationArgument (COMMA unknownAnnotationArgument)*
  private static boolean otherAnnotation_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherAnnotation_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unknownAnnotationArgument(b, l + 1);
    r = r && otherAnnotation_2_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA unknownAnnotationArgument)*
  private static boolean otherAnnotation_2_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherAnnotation_2_0_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!otherAnnotation_2_0_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "otherAnnotation_2_0_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA unknownAnnotationArgument
  private static boolean otherAnnotation_2_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherAnnotation_2_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && unknownAnnotationArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bitArrayPattern
  //             | tuplePattern
  //             | recordPattern
  //             | listPattern
  //             | stringPattern
  //             | literalPattern
  //             | identifierPattern
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PATTERN, "<pattern>");
    r = bitArrayPattern(b, l + 1);
    if (!r) r = tuplePattern(b, l + 1);
    if (!r) r = recordPattern(b, l + 1);
    if (!r) r = listPattern(b, l + 1);
    if (!r) r = stringPattern(b, l + 1);
    if (!r) r = literalPattern(b, l + 1);
    if (!r) r = identifierPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // pattern [AS IDENTIFIER]
  public static boolean patternAliasable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternAliasable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_ALIASABLE, "<pattern aliasable>");
    r = pattern(b, l + 1);
    r = r && patternAliasable_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [AS IDENTIFIER]
  private static boolean patternAliasable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternAliasable_1")) return false;
    parseTokens(b, 0, AS, IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // patternAliasable [COLON bitArraySegmentOptions]
  public static boolean patternBitArraySegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitArraySegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_BIT_ARRAY_SEGMENT, "<pattern bit array segment>");
    r = patternAliasable(b, l + 1);
    r = r && patternBitArraySegment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON bitArraySegmentOptions]
  private static boolean patternBitArraySegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitArraySegment_1")) return false;
    patternBitArraySegment_1_0(b, l + 1);
    return true;
  }

  // COLON bitArraySegmentOptions
  private static boolean patternBitArraySegment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternBitArraySegment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && bitArraySegmentOptions(b, l + 1);
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
  // identifierDiscardable DOT upIdentifier
  public static boolean qualifiedTypeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedTypeName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUALIFIED_TYPE_NAME, "<qualified type name>");
    r = identifierDiscardable(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && upIdentifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // labeledArgument | shortHandLabeledArgument | unlabeledArgument
  public static boolean recordArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_ARGUMENT, "<record argument>");
    r = labeledArgument(b, l + 1);
    if (!r) r = shortHandLabeledArgument(b, l + 1);
    if (!r) r = unlabeledArgument(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [recordArgument (COMMA recordArgument)* [COMMA]]
  static boolean recordArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArgumentList")) return false;
    recordArgumentList_0(b, l + 1);
    return true;
  }

  // recordArgument (COMMA recordArgument)* [COMMA]
  private static boolean recordArgumentList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArgumentList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recordArgument(b, l + 1);
    r = r && recordArgumentList_0_1(b, l + 1);
    r = r && recordArgumentList_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA recordArgument)*
  private static boolean recordArgumentList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArgumentList_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!recordArgumentList_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recordArgumentList_0_1", c)) break;
    }
    return true;
  }

  // COMMA recordArgument
  private static boolean recordArgumentList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArgumentList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && recordArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean recordArgumentList_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArgumentList_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LPAREN (recordUpdate COMMA recordArgumentList | recordUpdate | recordArgumentList) RPAREN
  public static boolean recordArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && recordArguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, RECORD_ARGUMENTS, r);
    return r;
  }

  // recordUpdate COMMA recordArgumentList | recordUpdate | recordArgumentList
  private static boolean recordArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArguments_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recordArguments_1_0(b, l + 1);
    if (!r) r = recordUpdate(b, l + 1);
    if (!r) r = recordArgumentList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // recordUpdate COMMA recordArgumentList
  private static boolean recordArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recordUpdate(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && recordArgumentList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // constructorIdentifier [recordConstructorParameters]
  public static boolean recordConstructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructor")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constructorIdentifier(b, l + 1);
    r = r && recordConstructor_1(b, l + 1);
    exit_section_(b, m, RECORD_CONSTRUCTOR, r);
    return r;
  }

  // [recordConstructorParameters]
  private static boolean recordConstructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructor_1")) return false;
    recordConstructorParameters(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // labeledParameter | unlabeledParameter
  static boolean recordConstructorParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructorParameter")) return false;
    boolean r;
    r = labeledParameter(b, l + 1);
    if (!r) r = unlabeledParameter(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [recordConstructorParameter (COMMA recordConstructorParameter)* [COMMA]] RPAREN
  public static boolean recordConstructorParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructorParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && recordConstructorParameters_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, RECORD_CONSTRUCTOR_PARAMETERS, r);
    return r;
  }

  // [recordConstructorParameter (COMMA recordConstructorParameter)* [COMMA]]
  private static boolean recordConstructorParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructorParameters_1")) return false;
    recordConstructorParameters_1_0(b, l + 1);
    return true;
  }

  // recordConstructorParameter (COMMA recordConstructorParameter)* [COMMA]
  private static boolean recordConstructorParameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructorParameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recordConstructorParameter(b, l + 1);
    r = r && recordConstructorParameters_1_0_1(b, l + 1);
    r = r && recordConstructorParameters_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA recordConstructorParameter)*
  private static boolean recordConstructorParameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructorParameters_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!recordConstructorParameters_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recordConstructorParameters_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA recordConstructorParameter
  private static boolean recordConstructorParameters_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructorParameters_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && recordConstructorParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean recordConstructorParameters_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordConstructorParameters_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // typeName [constantRecordArguments]
  public static boolean recordExprConst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordExprConst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_EXPR_CONST, "<record expr const>");
    r = typeName(b, l + 1);
    r = r && recordExprConst_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [constantRecordArguments]
  private static boolean recordExprConst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordExprConst_1")) return false;
    constantRecordArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (constructorIdentifier | remoteConstructorIdentifier) [recordPatternArguments]
  public static boolean recordPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPattern")) return false;
    if (!nextTokenIs(b, "<record pattern>", IDENTIFIER, UP_IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECORD_PATTERN, "<record pattern>");
    r = recordPattern_0(b, l + 1);
    p = r; // pin = 1
    r = r && recordPattern_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // [label COLON] patternAliasable
  public static boolean recordPatternArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordPatternArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_PATTERN_ARGUMENT, "<record pattern argument>");
    r = recordPatternArgument_0(b, l + 1);
    r = r && patternAliasable(b, l + 1);
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
  // DOT_DOT variableReference
  public static boolean recordUpdate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordUpdate")) return false;
    if (!nextTokenIs(b, DOT_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECORD_UPDATE, null);
    r = consumeToken(b, DOT_DOT);
    p = r; // pin = 1
    r = r && variableReference(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // topLevelDeclaration*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!topLevelDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifierDiscardable COLON
  public static boolean shortHandLabeledArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shortHandLabeledArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHORT_HAND_LABELED_ARGUMENT, "<short hand labeled argument>");
    r = identifierDiscardable(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ESCAPE ESCAPE_CHAR) | (ESCAPE UNICODE_ESCAPE_CHAR LBRACE UNICODE_CODEPOINT RBRACE)
  public static boolean stringEscapeSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringEscapeSegment")) return false;
    if (!nextTokenIs(b, ESCAPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringEscapeSegment_0(b, l + 1);
    if (!r) r = stringEscapeSegment_1(b, l + 1);
    exit_section_(b, m, STRING_ESCAPE_SEGMENT, r);
    return r;
  }

  // ESCAPE ESCAPE_CHAR
  private static boolean stringEscapeSegment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringEscapeSegment_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ESCAPE, ESCAPE_CHAR);
    exit_section_(b, m, null, r);
    return r;
  }

  // ESCAPE UNICODE_ESCAPE_CHAR LBRACE UNICODE_CODEPOINT RBRACE
  private static boolean stringEscapeSegment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringEscapeSegment_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ESCAPE, UNICODE_ESCAPE_CHAR, LBRACE, UNICODE_CODEPOINT, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OPEN_QUOTE (REGULAR_STRING_PART | stringEscapeSegment)* CLOSE_QUOTE
  public static boolean stringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral")) return false;
    if (!nextTokenIs(b, OPEN_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_QUOTE);
    r = r && stringLiteral_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_QUOTE);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  // (REGULAR_STRING_PART | stringEscapeSegment)*
  private static boolean stringLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!stringLiteral_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stringLiteral_1", c)) break;
    }
    return true;
  }

  // REGULAR_STRING_PART | stringEscapeSegment
  private static boolean stringLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral_1_0")) return false;
    boolean r;
    r = consumeToken(b, REGULAR_STRING_PART);
    if (!r) r = stringEscapeSegment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // stringLiteral LT_GT identifierDiscardable
  public static boolean stringPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringPattern")) return false;
    if (!nextTokenIs(b, OPEN_QUOTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRING_PATTERN, null);
    r = stringLiteral(b, l + 1);
    r = r && consumeToken(b, LT_GT);
    p = r; // pin = 2
    r = r && identifierDiscardable(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ANNOTATION_MARK "target" LPAREN IDENTIFIER RPAREN
  public static boolean targetAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetAnnotation")) return false;
    if (!nextTokenIs(b, ANNOTATION_MARK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TARGET_ANNOTATION, null);
    r = consumeToken(b, ANNOTATION_MARK);
    r = r && consumeToken(b, "target");
    p = r; // pin = 2
    r = r && report_error_(b, consumeTokens(b, -1, LPAREN, IDENTIFIER, RPAREN));
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // importDeclaration
  //                             | constantDeclaration
  //                             | typeDeclaration
  //                             | functionDeclaration
  static boolean topLevelDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = importDeclaration(b, l + 1);
    if (!r) r = constantDeclaration(b, l + 1);
    if (!r) r = typeDeclaration(b, l + 1);
    if (!r) r = functionDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, GleamParser::declarationRecover);
    return r;
  }

  /* ********************************************************** */
  // IMPORT | CONST | TYPE | FN | PUB | OPAQUE | ANNOTATION_MARK
  static boolean topLevelKeyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelKeyword")) return false;
    boolean r;
    r = consumeToken(b, IMPORT);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, TYPE);
    if (!r) r = consumeToken(b, FN);
    if (!r) r = consumeToken(b, PUB);
    if (!r) r = consumeToken(b, OPAQUE);
    if (!r) r = consumeToken(b, ANNOTATION_MARK);
    return r;
  }

  /* ********************************************************** */
  // HASH LPAREN [expressionConst (COMMA expressionConst)* [COMMA]] RPAREN
  public static boolean tupleExprConst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExprConst")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_EXPR_CONST, null);
    r = consumeTokens(b, 2, HASH, LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, tupleExprConst_2(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [expressionConst (COMMA expressionConst)* [COMMA]]
  private static boolean tupleExprConst_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExprConst_2")) return false;
    tupleExprConst_2_0(b, l + 1);
    return true;
  }

  // expressionConst (COMMA expressionConst)* [COMMA]
  private static boolean tupleExprConst_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExprConst_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expressionConst(b, l + 1);
    r = r && tupleExprConst_2_0_1(b, l + 1);
    r = r && tupleExprConst_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expressionConst)*
  private static boolean tupleExprConst_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExprConst_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tupleExprConst_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tupleExprConst_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA expressionConst
  private static boolean tupleExprConst_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExprConst_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expressionConst(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean tupleExprConst_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExprConst_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // HASH LPAREN [patternAliasable (COMMA patternAliasable)* [COMMA]] RPAREN
  public static boolean tuplePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_PATTERN, null);
    r = consumeTokens(b, 2, HASH, LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, tuplePattern_2(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [patternAliasable (COMMA patternAliasable)* [COMMA]]
  private static boolean tuplePattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2")) return false;
    tuplePattern_2_0(b, l + 1);
    return true;
  }

  // patternAliasable (COMMA patternAliasable)* [COMMA]
  private static boolean tuplePattern_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = patternAliasable(b, l + 1);
    r = r && tuplePattern_2_0_1(b, l + 1);
    r = r && tuplePattern_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA patternAliasable)*
  private static boolean tuplePattern_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuplePattern_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuplePattern_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA patternAliasable
  private static boolean tuplePattern_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuplePattern_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && patternAliasable(b, l + 1);
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_TYPE, null);
    r = consumeTokens(b, 2, HASH, LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, tupleType_2(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // tupleType | functionType | typeReference | genericType
  public static boolean typeBase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeBase")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_BASE, "<type base>");
    r = tupleType(b, l + 1);
    if (!r) r = functionType(b, l + 1);
    if (!r) r = typeReference(b, l + 1);
    if (!r) r = genericType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [visibilityModifier] [OPAQUE] TYPE typeDeclarationName typeValue
  public static boolean typeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECLARATION, "<type declaration>");
    r = typeDeclaration_0(b, l + 1);
    r = r && typeDeclaration_1(b, l + 1);
    r = r && consumeToken(b, TYPE);
    p = r; // pin = 3
    r = r && report_error_(b, typeDeclarationName(b, l + 1));
    r = p && typeValue(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [visibilityModifier]
  private static boolean typeDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDeclaration_0")) return false;
    visibilityModifier(b, l + 1);
    return true;
  }

  // [OPAQUE]
  private static boolean typeDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDeclaration_1")) return false;
    consumeToken(b, OPAQUE);
    return true;
  }

  /* ********************************************************** */
  // UP_IDENTIFIER
  public static boolean typeDeclarationName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDeclarationName")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UP_IDENTIFIER);
    exit_section_(b, m, TYPE_DECLARATION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN [IDENTIFIER (COMMA IDENTIFIER)* [COMMA]] RPAREN
  public static boolean typeGenerics(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeGenerics")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && typeGenerics_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TYPE_GENERICS, r);
    return r;
  }

  // [IDENTIFIER (COMMA IDENTIFIER)* [COMMA]]
  private static boolean typeGenerics_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeGenerics_1")) return false;
    typeGenerics_1_0(b, l + 1);
    return true;
  }

  // IDENTIFIER (COMMA IDENTIFIER)* [COMMA]
  private static boolean typeGenerics_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeGenerics_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && typeGenerics_1_0_1(b, l + 1);
    r = r && typeGenerics_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA IDENTIFIER)*
  private static boolean typeGenerics_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeGenerics_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeGenerics_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeGenerics_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean typeGenerics_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeGenerics_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean typeGenerics_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeGenerics_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // qualifiedTypeName | unqualifiedTypeName
  static boolean typeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeName")) return false;
    boolean r;
    r = qualifiedTypeName(b, l + 1);
    if (!r) r = unqualifiedTypeName(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // typeName [typeArguments]
  public static boolean typeReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_REFERENCE, "<type reference>");
    r = typeName(b, l + 1);
    r = r && typeReference_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [typeArguments]
  private static boolean typeReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeReference_1")) return false;
    typeArguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TYPE upIdentifier (AS aliasUpIdentifier)?
  public static boolean typeUnqualifiedImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeUnqualifiedImport")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_UNQUALIFIED_IMPORT, null);
    r = consumeToken(b, TYPE);
    p = r; // pin = 1
    r = r && report_error_(b, upIdentifier(b, l + 1));
    r = p && typeUnqualifiedImport_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (AS aliasUpIdentifier)?
  private static boolean typeUnqualifiedImport_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeUnqualifiedImport_2")) return false;
    typeUnqualifiedImport_2_0(b, l + 1);
    return true;
  }

  // AS aliasUpIdentifier
  private static boolean typeUnqualifiedImport_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeUnqualifiedImport_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && aliasUpIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // aliasTypeValue | customTypeValue | omittedTypeValue
  public static boolean typeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TYPE_VALUE, "<type value>");
    r = aliasTypeValue(b, l + 1);
    if (!r) r = customTypeValue(b, l + 1);
    if (!r) r = omittedTypeValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BANG | MINUS
  public static boolean unaryOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryOperator")) return false;
    if (!nextTokenIs(b, "<unary operator>", BANG, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OPERATOR, "<unary operator>");
    r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // literalExpr | IDENTIFIER
  static boolean unknownAnnotationArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknownAnnotationArgument")) return false;
    boolean r;
    r = literalExpr(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // ANNOTATION_NAME
  public static boolean unknownAnnotationName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknownAnnotationName")) return false;
    if (!nextTokenIs(b, ANNOTATION_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANNOTATION_NAME);
    exit_section_(b, m, UNKNOWN_ANNOTATION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean unlabeledArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unlabeledArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNLABELED_ARGUMENT, "<unlabeled argument>");
    r = expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // typeBase
  public static boolean unlabeledParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unlabeledParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNLABELED_PARAMETER, "<unlabeled parameter>");
    r = typeBase(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifierDiscardable (AS aliasIdentifier)?
  public static boolean unqualifiedImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNQUALIFIED_IMPORT, "<unqualified import>");
    r = identifierDiscardable(b, l + 1);
    r = r && unqualifiedImport_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AS aliasIdentifier)?
  private static boolean unqualifiedImport_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_1")) return false;
    unqualifiedImport_1_0(b, l + 1);
    return true;
  }

  // AS aliasIdentifier
  private static boolean unqualifiedImport_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImport_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && aliasIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unqualifiedImport | typeUnqualifiedImport | upUnqualifiedImport
  static boolean unqualifiedImportBase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImportBase")) return false;
    boolean r;
    r = unqualifiedImport(b, l + 1);
    if (!r) r = typeUnqualifiedImport(b, l + 1);
    if (!r) r = upUnqualifiedImport(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LBRACE [unqualifiedImportBase (COMMA unqualifiedImportBase)* [COMMA]] RBRACE
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

  // [unqualifiedImportBase (COMMA unqualifiedImportBase)* [COMMA]]
  private static boolean unqualifiedImports_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1")) return false;
    unqualifiedImports_1_0(b, l + 1);
    return true;
  }

  // unqualifiedImportBase (COMMA unqualifiedImportBase)* [COMMA]
  private static boolean unqualifiedImports_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unqualifiedImportBase(b, l + 1);
    r = r && unqualifiedImports_1_0_1(b, l + 1);
    r = r && unqualifiedImports_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA unqualifiedImportBase)*
  private static boolean unqualifiedImports_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unqualifiedImports_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unqualifiedImports_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA unqualifiedImportBase
  private static boolean unqualifiedImports_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedImports_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && unqualifiedImportBase(b, l + 1);
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
  // upIdentifier
  public static boolean unqualifiedTypeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unqualifiedTypeName")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = upIdentifier(b, l + 1);
    exit_section_(b, m, UNQUALIFIED_TYPE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // UP_IDENTIFIER
  static boolean upIdentifier(PsiBuilder b, int l) {
    return consumeToken(b, UP_IDENTIFIER);
  }

  /* ********************************************************** */
  // upIdentifier (AS aliasUpIdentifier)?
  public static boolean upUnqualifiedImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "upUnqualifiedImport")) return false;
    if (!nextTokenIs(b, UP_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = upIdentifier(b, l + 1);
    r = r && upUnqualifiedImport_1(b, l + 1);
    exit_section_(b, m, UP_UNQUALIFIED_IMPORT, r);
    return r;
  }

  // (AS aliasUpIdentifier)?
  private static boolean upUnqualifiedImport_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "upUnqualifiedImport_1")) return false;
    upUnqualifiedImport_1_0(b, l + 1);
    return true;
  }

  // AS aliasUpIdentifier
  private static boolean upUnqualifiedImport_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "upUnqualifiedImport_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && aliasUpIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifierDiscardable (COMMA identifierDiscardable)* [COMMA]
  public static boolean useArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useArgs")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE_ARGS, "<use args>");
    r = identifierDiscardable(b, l + 1);
    r = r && useArgs_1(b, l + 1);
    r = r && useArgs_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA identifierDiscardable)*
  private static boolean useArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useArgs_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!useArgs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "useArgs_1", c)) break;
    }
    return true;
  }

  // COMMA identifierDiscardable
  private static boolean useArgs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useArgs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && identifierDiscardable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean useArgs_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useArgs_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean variableReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_REFERENCE, r);
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
  // VALID_DECIMAL_DIGIT (NUMBER_SEPARATOR VALID_DECIMAL_DIGIT)*
  public static boolean wholeNumber(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wholeNumber")) return false;
    if (!nextTokenIs(b, VALID_DECIMAL_DIGIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VALID_DECIMAL_DIGIT);
    r = r && wholeNumber_1(b, l + 1);
    exit_section_(b, m, WHOLE_NUMBER, r);
    return r;
  }

  // (NUMBER_SEPARATOR VALID_DECIMAL_DIGIT)*
  private static boolean wholeNumber_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wholeNumber_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!wholeNumber_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wholeNumber_1", c)) break;
    }
    return true;
  }

  // NUMBER_SEPARATOR VALID_DECIMAL_DIGIT
  private static boolean wholeNumber_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wholeNumber_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NUMBER_SEPARATOR, VALID_DECIMAL_DIGIT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expression
  // Operator priority table:
  // 0: BINARY(binaryExpr)
  // 1: PREFIX(unaryExpr)
  // 2: POSTFIX(fieldAccessExpr) POSTFIX(indexAccessExpr) POSTFIX(callExpr)
  // 3: ATOM(recordExpr) ATOM(letExpr) ATOM(panicExpr) ATOM(todoExpr)
  //    PREFIX(useExpr) ATOM(caseExpr) ATOM(tupleExpr) ATOM(literalExpr)
  //    ATOM(bitArrayExpr) ATOM(anonymousFunctionExpr) ATOM(listExpr) ATOM(blockExpr)
  //    ATOM(referenceExpr)
  public static boolean expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = unaryExpr(b, l + 1);
    if (!r) r = recordExpr(b, l + 1);
    if (!r) r = letExpr(b, l + 1);
    if (!r) r = panicExpr(b, l + 1);
    if (!r) r = todoExpr(b, l + 1);
    if (!r) r = useExpr(b, l + 1);
    if (!r) r = caseExpr(b, l + 1);
    if (!r) r = tupleExpr(b, l + 1);
    if (!r) r = literalExpr(b, l + 1);
    if (!r) r = bitArrayExpr(b, l + 1);
    if (!r) r = anonymousFunctionExpr(b, l + 1);
    if (!r) r = listExpr(b, l + 1);
    if (!r) r = blockExpr(b, l + 1);
    if (!r) r = referenceExpr(b, l + 1);
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
      if (g < 0 && binaryOperator(b, l + 1)) {
        r = expression(b, l, 0);
        exit_section_(b, l, m, BINARY_EXPR, r, true, null);
      }
      else if (g < 2 && fieldAccessExpr_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, FIELD_ACCESS_EXPR, r, true, null);
      }
      else if (g < 2 && indexAccessExpr_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, INDEX_ACCESS_EXPR, r, true, null);
      }
      else if (g < 2 && callArguments(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean unaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr")) return false;
    if (!nextTokenIsSmart(b, BANG, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = unaryOperator(b, l + 1);
    p = r;
    r = p && expression(b, l, 1);
    exit_section_(b, l, m, UNARY_EXPR, r, p, null);
    return r || p;
  }

  // DOT label
  private static boolean fieldAccessExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldAccessExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && label(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT wholeNumber
  private static boolean indexAccessExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexAccessExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && wholeNumber(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (constructorIdentifier | remoteConstructorIdentifier) [recordArguments]
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

  // [recordArguments]
  private static boolean recordExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordExpr_1")) return false;
    recordArguments(b, l + 1);
    return true;
  }

  // LET ASSERT? patternAliasable [typeAnnotation] EQUAL expression
  public static boolean letExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "letExpr")) return false;
    if (!nextTokenIsSmart(b, LET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LET_EXPR, null);
    r = consumeTokenSmart(b, LET);
    p = r; // pin = 1
    r = r && report_error_(b, letExpr_1(b, l + 1));
    r = p && report_error_(b, patternAliasable(b, l + 1)) && r;
    r = p && report_error_(b, letExpr_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, EQUAL)) && r;
    r = p && expression(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ASSERT?
  private static boolean letExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "letExpr_1")) return false;
    consumeTokenSmart(b, ASSERT);
    return true;
  }

  // [typeAnnotation]
  private static boolean letExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "letExpr_3")) return false;
    typeAnnotation(b, l + 1);
    return true;
  }

  // PANIC (AS expression)?
  public static boolean panicExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "panicExpr")) return false;
    if (!nextTokenIsSmart(b, PANIC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, PANIC);
    r = r && panicExpr_1(b, l + 1);
    exit_section_(b, m, PANIC_EXPR, r);
    return r;
  }

  // (AS expression)?
  private static boolean panicExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "panicExpr_1")) return false;
    panicExpr_1_0(b, l + 1);
    return true;
  }

  // AS expression
  private static boolean panicExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "panicExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, AS);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TODO (AS expression)?
  public static boolean todoExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "todoExpr")) return false;
    if (!nextTokenIsSmart(b, TODO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, TODO);
    r = r && todoExpr_1(b, l + 1);
    exit_section_(b, m, TODO_EXPR, r);
    return r;
  }

  // (AS expression)?
  private static boolean todoExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "todoExpr_1")) return false;
    todoExpr_1_0(b, l + 1);
    return true;
  }

  // AS expression
  private static boolean todoExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "todoExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, AS);
    r = r && expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean useExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useExpr")) return false;
    if (!nextTokenIsSmart(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = useExpr_0(b, l + 1);
    p = r;
    r = p && expression(b, l, -1);
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

  // CASE caseSubjects caseExprBody
  public static boolean caseExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseExpr")) return false;
    if (!nextTokenIsSmart(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, CASE);
    r = r && caseSubjects(b, l + 1);
    r = r && caseExprBody(b, l + 1);
    exit_section_(b, m, CASE_EXPR, r);
    return r;
  }

  // HASH LPAREN [expression (COMMA expression)* [COMMA]] RPAREN
  public static boolean tupleExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupleExpr")) return false;
    if (!nextTokenIsSmart(b, HASH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_EXPR, null);
    r = consumeTokensSmart(b, 2, HASH, LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, tupleExpr_2(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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

  // literal
  public static boolean literalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LT_LT [bitArraySegment (COMMA bitArraySegment)* [COMMA]] GT_GT
  public static boolean bitArrayExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExpr")) return false;
    if (!nextTokenIsSmart(b, LT_LT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BIT_ARRAY_EXPR, null);
    r = consumeTokenSmart(b, LT_LT);
    p = r; // pin = 1
    r = r && report_error_(b, bitArrayExpr_1(b, l + 1));
    r = p && consumeToken(b, GT_GT) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [bitArraySegment (COMMA bitArraySegment)* [COMMA]]
  private static boolean bitArrayExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExpr_1")) return false;
    bitArrayExpr_1_0(b, l + 1);
    return true;
  }

  // bitArraySegment (COMMA bitArraySegment)* [COMMA]
  private static boolean bitArrayExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bitArraySegment(b, l + 1);
    r = r && bitArrayExpr_1_0_1(b, l + 1);
    r = r && bitArrayExpr_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA bitArraySegment)*
  private static boolean bitArrayExpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExpr_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitArrayExpr_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitArrayExpr_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA bitArraySegment
  private static boolean bitArrayExpr_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExpr_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && bitArraySegment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean bitArrayExpr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitArrayExpr_1_0_2")) return false;
    consumeTokenSmart(b, COMMA);
    return true;
  }

  // FN anonymousFunctionParameters [R_ARROW typeBase] functionBody
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

  // [R_ARROW typeBase]
  private static boolean anonymousFunctionExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionExpr_2")) return false;
    anonymousFunctionExpr_2_0(b, l + 1);
    return true;
  }

  // R_ARROW typeBase
  private static boolean anonymousFunctionExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousFunctionExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, R_ARROW);
    r = r && typeBase(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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

  // LBRACE expression* RBRACE
  public static boolean blockExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockExpr")) return false;
    if (!nextTokenIsSmart(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACE);
    r = r && blockExpr_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK_EXPR, r);
    return r;
  }

  // expression*
  private static boolean blockExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1, -1)) break;
      if (!empty_element_parsed_guard_(b, "blockExpr_1", c)) break;
    }
    return true;
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

}
