// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.themartdev.intellijgleam.lang.psi.impl.*;

public interface GleamTypes {

  IElementType ACCESS_EXPR = new GleamElementType("ACCESS_EXPR");
  IElementType ALIAS_IDENTIFIER = new GleamElementType("ALIAS_IDENTIFIER");
  IElementType ALIAS_TYPE_VALUE = new GleamElementType("ALIAS_TYPE_VALUE");
  IElementType ALIAS_UP_IDENTIFIER = new GleamElementType("ALIAS_UP_IDENTIFIER");
  IElementType ANNOTATION = new GleamElementType("ANNOTATION");
  IElementType ANONYMOUS_FUNCTION_EXPR = new GleamElementType("ANONYMOUS_FUNCTION_EXPR");
  IElementType ANONYMOUS_FUNCTION_PARAMETER = new GleamElementType("ANONYMOUS_FUNCTION_PARAMETER");
  IElementType ANONYMOUS_FUNCTION_PARAMETERS = new GleamElementType("ANONYMOUS_FUNCTION_PARAMETERS");
  IElementType BINARY_EXPR = new GleamElementType("BINARY_EXPR");
  IElementType BINARY_INTEGER_LITERAL = new GleamElementType("BINARY_INTEGER_LITERAL");
  IElementType BINARY_OPERATOR = new GleamElementType("BINARY_OPERATOR");
  IElementType BIT_ARRAY_EXPR = new GleamElementType("BIT_ARRAY_EXPR");
  IElementType BIT_ARRAY_EXPR_CONST = new GleamElementType("BIT_ARRAY_EXPR_CONST");
  IElementType BIT_ARRAY_OPTION_NAME = new GleamElementType("BIT_ARRAY_OPTION_NAME");
  IElementType BIT_ARRAY_PATTERN = new GleamElementType("BIT_ARRAY_PATTERN");
  IElementType BIT_ARRAY_SEGMENT = new GleamElementType("BIT_ARRAY_SEGMENT");
  IElementType BIT_ARRAY_SEGMENT_OPTION = new GleamElementType("BIT_ARRAY_SEGMENT_OPTION");
  IElementType BIT_ARRAY_SEGMENT_OPTIONS = new GleamElementType("BIT_ARRAY_SEGMENT_OPTIONS");
  IElementType BLOCK_EXPR = new GleamElementType("BLOCK_EXPR");
  IElementType CALL_ARGUMENT = new GleamElementType("CALL_ARGUMENT");
  IElementType CALL_ARGUMENTS = new GleamElementType("CALL_ARGUMENTS");
  IElementType CALL_EXPR = new GleamElementType("CALL_EXPR");
  IElementType CASE_CLAUSE = new GleamElementType("CASE_CLAUSE");
  IElementType CASE_CLAUSES = new GleamElementType("CASE_CLAUSES");
  IElementType CASE_CLAUSE_GUARD = new GleamElementType("CASE_CLAUSE_GUARD");
  IElementType CASE_CLAUSE_GUARD_BINARY_OPERATOR = new GleamElementType("CASE_CLAUSE_GUARD_BINARY_OPERATOR");
  IElementType CASE_CLAUSE_GUARD_EXPRESSION = new GleamElementType("CASE_CLAUSE_GUARD_EXPRESSION");
  IElementType CASE_CLAUSE_GUARD_TAIL = new GleamElementType("CASE_CLAUSE_GUARD_TAIL");
  IElementType CASE_CLAUSE_GUARD_UNIT = new GleamElementType("CASE_CLAUSE_GUARD_UNIT");
  IElementType CASE_CLAUSE_PATTERN = new GleamElementType("CASE_CLAUSE_PATTERN");
  IElementType CASE_CLAUSE_PATTERNS = new GleamElementType("CASE_CLAUSE_PATTERNS");
  IElementType CASE_CLAUSE_TUPLE_ACCESS = new GleamElementType("CASE_CLAUSE_TUPLE_ACCESS");
  IElementType CASE_EXPR = new GleamElementType("CASE_EXPR");
  IElementType CASE_EXPR_BODY = new GleamElementType("CASE_EXPR_BODY");
  IElementType CASE_SUBJECTS = new GleamElementType("CASE_SUBJECTS");
  IElementType CONSTANT_BIT_ARRAY_SEGMENT = new GleamElementType("CONSTANT_BIT_ARRAY_SEGMENT");
  IElementType CONSTANT_DECLARATION = new GleamElementType("CONSTANT_DECLARATION");
  IElementType CONSTANT_FUNCTION_PARAMETER_TYPES = new GleamElementType("CONSTANT_FUNCTION_PARAMETER_TYPES");
  IElementType CONSTANT_RECORD_ARGUMENT = new GleamElementType("CONSTANT_RECORD_ARGUMENT");
  IElementType CONSTANT_RECORD_ARGUMENTS = new GleamElementType("CONSTANT_RECORD_ARGUMENTS");
  IElementType CONSTANT_TYPE = new GleamElementType("CONSTANT_TYPE");
  IElementType CONSTANT_TYPE_ANNOTATION = new GleamElementType("CONSTANT_TYPE_ANNOTATION");
  IElementType CONSTANT_TYPE_ARGUMENT = new GleamElementType("CONSTANT_TYPE_ARGUMENT");
  IElementType CONSTANT_TYPE_ARGUMENTS = new GleamElementType("CONSTANT_TYPE_ARGUMENTS");
  IElementType CONSTANT_TYPE_FUNCTION = new GleamElementType("CONSTANT_TYPE_FUNCTION");
  IElementType CONSTANT_TYPE_SPECIAL = new GleamElementType("CONSTANT_TYPE_SPECIAL");
  IElementType CONSTANT_TYPE_TUPLE = new GleamElementType("CONSTANT_TYPE_TUPLE");
  IElementType CONSTRUCTOR_IDENTIFIER = new GleamElementType("CONSTRUCTOR_IDENTIFIER");
  IElementType CUSTOM_TYPE_VALUE = new GleamElementType("CUSTOM_TYPE_VALUE");
  IElementType DECIMAL_INTEGER_LITERAL = new GleamElementType("DECIMAL_INTEGER_LITERAL");
  IElementType DEPRECATED_ANNOTATION = new GleamElementType("DEPRECATED_ANNOTATION");
  IElementType DEPRECATED_ANNOTATION_NAME = new GleamElementType("DEPRECATED_ANNOTATION_NAME");
  IElementType EXPRESSION = new GleamElementType("EXPRESSION");
  IElementType EXPRESSION_CONST = new GleamElementType("EXPRESSION_CONST");
  IElementType EXTERNAL_ANNOTATION = new GleamElementType("EXTERNAL_ANNOTATION");
  IElementType EXTERNAL_ANNOTATION_NAME = new GleamElementType("EXTERNAL_ANNOTATION_NAME");
  IElementType EXTERNAL_TARGET = new GleamElementType("EXTERNAL_TARGET");
  IElementType FIELD_ACCESS_EXPR_CONST = new GleamElementType("FIELD_ACCESS_EXPR_CONST");
  IElementType FLOAT_LITERAL = new GleamElementType("FLOAT_LITERAL");
  IElementType FUNCTION_BODY = new GleamElementType("FUNCTION_BODY");
  IElementType FUNCTION_DECLARATION = new GleamElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_NAME_DEFINITION = new GleamElementType("FUNCTION_NAME_DEFINITION");
  IElementType FUNCTION_PARAMETER = new GleamElementType("FUNCTION_PARAMETER");
  IElementType FUNCTION_PARAMETERS = new GleamElementType("FUNCTION_PARAMETERS");
  IElementType FUNCTION_PARAMETER_TYPES = new GleamElementType("FUNCTION_PARAMETER_TYPES");
  IElementType FUNCTION_TYPE = new GleamElementType("FUNCTION_TYPE");
  IElementType GENERIC_TYPE = new GleamElementType("GENERIC_TYPE");
  IElementType HEX_INTEGER_LITERAL = new GleamElementType("HEX_INTEGER_LITERAL");
  IElementType HOLE_PATTERN = new GleamElementType("HOLE_PATTERN");
  IElementType IDENTIFIER_DISCARDABLE = new GleamElementType("IDENTIFIER_DISCARDABLE");
  IElementType IDENTIFIER_EXPR_CONST = new GleamElementType("IDENTIFIER_EXPR_CONST");
  IElementType IDENTIFIER_PATTERN = new GleamElementType("IDENTIFIER_PATTERN");
  IElementType IMPORT_DECLARATION = new GleamElementType("IMPORT_DECLARATION");
  IElementType INTEGER_LITERAL = new GleamElementType("INTEGER_LITERAL");
  IElementType LABEL = new GleamElementType("LABEL");
  IElementType LABELED_ARGUMENT = new GleamElementType("LABELED_ARGUMENT");
  IElementType LABELED_PARAMETER = new GleamElementType("LABELED_PARAMETER");
  IElementType LET_EXPR = new GleamElementType("LET_EXPR");
  IElementType LIST_EXPR = new GleamElementType("LIST_EXPR");
  IElementType LIST_EXPR_CONST = new GleamElementType("LIST_EXPR_CONST");
  IElementType LIST_PATTERN = new GleamElementType("LIST_PATTERN");
  IElementType LIST_PATTERN_TAIL = new GleamElementType("LIST_PATTERN_TAIL");
  IElementType LITERAL_EXPR = new GleamElementType("LITERAL_EXPR");
  IElementType LITERAL_EXPR_CONST = new GleamElementType("LITERAL_EXPR_CONST");
  IElementType LITERAL_PATTERN = new GleamElementType("LITERAL_PATTERN");
  IElementType MODULE_PATH = new GleamElementType("MODULE_PATH");
  IElementType NEGATIVE_DECIMAL_INTEGER_LITERAL = new GleamElementType("NEGATIVE_DECIMAL_INTEGER_LITERAL");
  IElementType OCTAL_INTEGER_LITERAL = new GleamElementType("OCTAL_INTEGER_LITERAL");
  IElementType OMITTED_TYPE_VALUE = new GleamElementType("OMITTED_TYPE_VALUE");
  IElementType OTHER_ANNOTATION = new GleamElementType("OTHER_ANNOTATION");
  IElementType PANIC_EXPR = new GleamElementType("PANIC_EXPR");
  IElementType PATTERN = new GleamElementType("PATTERN");
  IElementType PATTERN_ALIASABLE = new GleamElementType("PATTERN_ALIASABLE");
  IElementType PATTERN_BIT_ARRAY_SEGMENT = new GleamElementType("PATTERN_BIT_ARRAY_SEGMENT");
  IElementType PATTERN_SPREAD = new GleamElementType("PATTERN_SPREAD");
  IElementType QUALIFIED_TYPE_NAME = new GleamElementType("QUALIFIED_TYPE_NAME");
  IElementType RECORD_ARGUMENT = new GleamElementType("RECORD_ARGUMENT");
  IElementType RECORD_ARGUMENTS = new GleamElementType("RECORD_ARGUMENTS");
  IElementType RECORD_CONSTRUCTOR = new GleamElementType("RECORD_CONSTRUCTOR");
  IElementType RECORD_CONSTRUCTOR_PARAMETERS = new GleamElementType("RECORD_CONSTRUCTOR_PARAMETERS");
  IElementType RECORD_EXPR = new GleamElementType("RECORD_EXPR");
  IElementType RECORD_EXPR_CONST = new GleamElementType("RECORD_EXPR_CONST");
  IElementType RECORD_PATTERN = new GleamElementType("RECORD_PATTERN");
  IElementType RECORD_PATTERN_ARGUMENT = new GleamElementType("RECORD_PATTERN_ARGUMENT");
  IElementType RECORD_PATTERN_ARGUMENTS = new GleamElementType("RECORD_PATTERN_ARGUMENTS");
  IElementType RECORD_UPDATE = new GleamElementType("RECORD_UPDATE");
  IElementType RECORD_UPDATE_ARGUMENT = new GleamElementType("RECORD_UPDATE_ARGUMENT");
  IElementType RECORD_UPDATE_ARGUMENTS = new GleamElementType("RECORD_UPDATE_ARGUMENTS");
  IElementType RECORD_UPDATE_EXPR = new GleamElementType("RECORD_UPDATE_EXPR");
  IElementType REFERENCE_EXPR = new GleamElementType("REFERENCE_EXPR");
  IElementType REMOTE_CONSTRUCTOR_IDENTIFIER = new GleamElementType("REMOTE_CONSTRUCTOR_IDENTIFIER");
  IElementType SHORT_HAND_LABELED_ARGUMENT = new GleamElementType("SHORT_HAND_LABELED_ARGUMENT");
  IElementType STRING_ESCAPE_SEGMENT = new GleamElementType("STRING_ESCAPE_SEGMENT");
  IElementType STRING_LITERAL = new GleamElementType("STRING_LITERAL");
  IElementType STRING_PATTERN = new GleamElementType("STRING_PATTERN");
  IElementType TARGET_ANNOTATION = new GleamElementType("TARGET_ANNOTATION");
  IElementType TODO_EXPR = new GleamElementType("TODO_EXPR");
  IElementType TUPLE_EXPR = new GleamElementType("TUPLE_EXPR");
  IElementType TUPLE_EXPR_CONST = new GleamElementType("TUPLE_EXPR_CONST");
  IElementType TUPLE_PATTERN = new GleamElementType("TUPLE_PATTERN");
  IElementType TUPLE_TYPE = new GleamElementType("TUPLE_TYPE");
  IElementType TYPE_ANNOTATION = new GleamElementType("TYPE_ANNOTATION");
  IElementType TYPE_ARGUMENT = new GleamElementType("TYPE_ARGUMENT");
  IElementType TYPE_ARGUMENTS = new GleamElementType("TYPE_ARGUMENTS");
  IElementType TYPE_BASE = new GleamElementType("TYPE_BASE");
  IElementType TYPE_DECLARATION = new GleamElementType("TYPE_DECLARATION");
  IElementType TYPE_DECLARATION_NAME = new GleamElementType("TYPE_DECLARATION_NAME");
  IElementType TYPE_GENERICS = new GleamElementType("TYPE_GENERICS");
  IElementType TYPE_REFERENCE = new GleamElementType("TYPE_REFERENCE");
  IElementType TYPE_UNQUALIFIED_IMPORT = new GleamElementType("TYPE_UNQUALIFIED_IMPORT");
  IElementType TYPE_VALUE = new GleamElementType("TYPE_VALUE");
  IElementType UNARY_EXPR = new GleamElementType("UNARY_EXPR");
  IElementType UNARY_OPERATOR = new GleamElementType("UNARY_OPERATOR");
  IElementType UNKNOWN_ANNOTATION_NAME = new GleamElementType("UNKNOWN_ANNOTATION_NAME");
  IElementType UNLABELED_ARGUMENT = new GleamElementType("UNLABELED_ARGUMENT");
  IElementType UNLABELED_PARAMETER = new GleamElementType("UNLABELED_PARAMETER");
  IElementType UNQUALIFIED_IMPORT = new GleamElementType("UNQUALIFIED_IMPORT");
  IElementType UNQUALIFIED_IMPORTS = new GleamElementType("UNQUALIFIED_IMPORTS");
  IElementType UNQUALIFIED_TYPE_NAME = new GleamElementType("UNQUALIFIED_TYPE_NAME");
  IElementType UP_UNQUALIFIED_IMPORT = new GleamElementType("UP_UNQUALIFIED_IMPORT");
  IElementType USE_ARGS = new GleamElementType("USE_ARGS");
  IElementType USE_EXPR = new GleamElementType("USE_EXPR");
  IElementType VARIABLE_REFERENCE = new GleamElementType("VARIABLE_REFERENCE");
  IElementType VISIBILITY_MODIFIER = new GleamElementType("VISIBILITY_MODIFIER");
  IElementType WHOLE_NUMBER = new GleamElementType("WHOLE_NUMBER");

  IElementType AMPER_AMPER = new GleamTokenType("&&");
  IElementType ANNOTATION_MARK = new GleamTokenType("@");
  IElementType ANNOTATION_NAME = new GleamTokenType("ANNOTATION_NAME");
  IElementType AS = new GleamTokenType("as");
  IElementType ASSERT = new GleamTokenType("assert");
  IElementType BANG = new GleamTokenType("!");
  IElementType BASE_NUMBER_PREFIX = new GleamTokenType("0");
  IElementType BINARY_NUMBER_BASE = new GleamTokenType("BINARY_NUMBER_BASE");
  IElementType BOOLEAN_LITERAL = new GleamTokenType("BOOLEAN_LITERAL");
  IElementType CASE = new GleamTokenType("case");
  IElementType CLOSE_QUOTE = new GleamTokenType("\"");
  IElementType COLON = new GleamTokenType(":");
  IElementType COMMA = new GleamTokenType(",");
  IElementType CONST = new GleamTokenType("const");
  IElementType DECIMAL_MARK = new GleamTokenType(". (decimal separator)");
  IElementType DISCARD_NAME = new GleamTokenType("DISCARD_NAME");
  IElementType DOT = new GleamTokenType(".");
  IElementType DOT_DOT = new GleamTokenType("..");
  IElementType EOL = new GleamTokenType("\\\\n, \\\\r\\\\n");
  IElementType EQUAL = new GleamTokenType("=");
  IElementType EQUAL_EQUAL = new GleamTokenType("==");
  IElementType ESCAPE = new GleamTokenType("ESCAPE");
  IElementType ESCAPE_CHAR = new GleamTokenType("ESCAPE_CHAR");
  IElementType EXPONENT_MARK = new GleamTokenType("e (exponent)");
  IElementType EXPONENT_SIGN = new GleamTokenType("EXPONENT_SIGN");
  IElementType FN = new GleamTokenType("fn");
  IElementType FUNCTION_COMMENT = new GleamTokenType("FUNCTION_COMMENT");
  IElementType GREATER = new GleamTokenType(">");
  IElementType GREATER_DOT = new GleamTokenType(">.");
  IElementType GREATER_EQUAL = new GleamTokenType(">=");
  IElementType GREATER_EQUAL_DOT = new GleamTokenType(">=.");
  IElementType GT_GT = new GleamTokenType(">>");
  IElementType HASH = new GleamTokenType("#");
  IElementType HEX_NUMBER_BASE = new GleamTokenType("HEX_NUMBER_BASE");
  IElementType HOLE = new GleamTokenType("HOLE");
  IElementType IDENTIFIER = new GleamTokenType("IDENTIFIER");
  IElementType IF = new GleamTokenType("if");
  IElementType IMPORT = new GleamTokenType("import");
  IElementType INVALID_BINARY_DIGIT = new GleamTokenType("INVALID_BINARY_DIGIT");
  IElementType INVALID_DECIMAL_DIGIT = new GleamTokenType("INVALID_DECIMAL_DIGIT");
  IElementType INVALID_HEX_DIGIT = new GleamTokenType("INVALID_HEX_DIGIT");
  IElementType INVALID_OCTAL_DIGIT = new GleamTokenType("INVALID_OCTAL_DIGIT");
  IElementType INVALID_UNICODE_ESCAPE_SEQUENCE = new GleamTokenType("INVALID_UNICODE_ESCAPE_SEQUENCE");
  IElementType INVALID_UNKNOWN_BASE_DIGIT = new GleamTokenType("INVALID_UNKNOWN_BASE_DIGIT");
  IElementType LBRACE = new GleamTokenType("{");
  IElementType LBRACK = new GleamTokenType("[");
  IElementType LESS = new GleamTokenType("<");
  IElementType LESS_DOT = new GleamTokenType("<.");
  IElementType LESS_EQUAL = new GleamTokenType("<=");
  IElementType LESS_EQUAL_DOT = new GleamTokenType("<=.");
  IElementType LET = new GleamTokenType("let");
  IElementType LINE_COMMENT = new GleamTokenType("LINE_COMMENT");
  IElementType LPAREN = new GleamTokenType("(");
  IElementType LT_GT = new GleamTokenType("<>");
  IElementType LT_LT = new GleamTokenType("<<");
  IElementType L_ARROW = new GleamTokenType("<-");
  IElementType MINUS = new GleamTokenType("-");
  IElementType MINUS_DOT = new GleamTokenType("-.");
  IElementType MODULE_COMMENT = new GleamTokenType("MODULE_COMMENT");
  IElementType NOT_EQUAL = new GleamTokenType("!=");
  IElementType NUMBER_SEPARATOR = new GleamTokenType("_");
  IElementType OCTAL_NUMBER_BASE = new GleamTokenType("OCTAL_NUMBER_BASE");
  IElementType OPAQUE = new GleamTokenType("opaque");
  IElementType OPEN_QUOTE = new GleamTokenType("OPEN_QUOTE");
  IElementType PANIC = new GleamTokenType("panic");
  IElementType PERCENT = new GleamTokenType("%");
  IElementType PIPE = new GleamTokenType("|>");
  IElementType PLUS = new GleamTokenType("+");
  IElementType PLUS_DOT = new GleamTokenType("+.");
  IElementType PUB = new GleamTokenType("pub");
  IElementType RBRACE = new GleamTokenType("}");
  IElementType RBRACK = new GleamTokenType("]");
  IElementType REGULAR_STRING_PART = new GleamTokenType("REGULAR_STRING_PART");
  IElementType RPAREN = new GleamTokenType(")");
  IElementType R_ARROW = new GleamTokenType("->");
  IElementType SLASH = new GleamTokenType("/");
  IElementType SLASH_DOT = new GleamTokenType("/.");
  IElementType STAR = new GleamTokenType("*");
  IElementType STAR_DOT = new GleamTokenType("*.");
  IElementType TEST = new GleamTokenType("test");
  IElementType TODO = new GleamTokenType("todo");
  IElementType TYPE = new GleamTokenType("type");
  IElementType UNICODE_CODEPOINT = new GleamTokenType("UNICODE_CODEPOINT");
  IElementType UNICODE_ESCAPE_CHAR = new GleamTokenType("u");
  IElementType UNKNOWN_NUMBER_BASE = new GleamTokenType("UNKNOWN_NUMBER_BASE");
  IElementType UP_IDENTIFIER = new GleamTokenType("UP_IDENTIFIER");
  IElementType USE = new GleamTokenType("use");
  IElementType VALID_BINARY_DIGIT = new GleamTokenType("VALID_BINARY_DIGIT");
  IElementType VALID_DECIMAL_DIGIT = new GleamTokenType("VALID_DECIMAL_DIGIT");
  IElementType VALID_HEX_DIGIT = new GleamTokenType("VALID_HEX_DIGIT");
  IElementType VALID_OCTAL_DIGIT = new GleamTokenType("VALID_OCTAL_DIGIT");
  IElementType VBAR = new GleamTokenType("|");
  IElementType VBAR_VBAR = new GleamTokenType("||");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACCESS_EXPR) {
        return new GleamAccessExprImpl(node);
      }
      else if (type == ALIAS_IDENTIFIER) {
        return new GleamAliasIdentifierImpl(node);
      }
      else if (type == ALIAS_TYPE_VALUE) {
        return new GleamAliasTypeValueImpl(node);
      }
      else if (type == ALIAS_UP_IDENTIFIER) {
        return new GleamAliasUpIdentifierImpl(node);
      }
      else if (type == ANONYMOUS_FUNCTION_EXPR) {
        return new GleamAnonymousFunctionExprImpl(node);
      }
      else if (type == ANONYMOUS_FUNCTION_PARAMETER) {
        return new GleamAnonymousFunctionParameterImpl(node);
      }
      else if (type == ANONYMOUS_FUNCTION_PARAMETERS) {
        return new GleamAnonymousFunctionParametersImpl(node);
      }
      else if (type == BINARY_EXPR) {
        return new GleamBinaryExprImpl(node);
      }
      else if (type == BINARY_INTEGER_LITERAL) {
        return new GleamBinaryIntegerLiteralImpl(node);
      }
      else if (type == BINARY_OPERATOR) {
        return new GleamBinaryOperatorImpl(node);
      }
      else if (type == BIT_ARRAY_EXPR) {
        return new GleamBitArrayExprImpl(node);
      }
      else if (type == BIT_ARRAY_EXPR_CONST) {
        return new GleamBitArrayExprConstImpl(node);
      }
      else if (type == BIT_ARRAY_OPTION_NAME) {
        return new GleamBitArrayOptionNameImpl(node);
      }
      else if (type == BIT_ARRAY_PATTERN) {
        return new GleamBitArrayPatternImpl(node);
      }
      else if (type == BIT_ARRAY_SEGMENT) {
        return new GleamBitArraySegmentImpl(node);
      }
      else if (type == BIT_ARRAY_SEGMENT_OPTION) {
        return new GleamBitArraySegmentOptionImpl(node);
      }
      else if (type == BIT_ARRAY_SEGMENT_OPTIONS) {
        return new GleamBitArraySegmentOptionsImpl(node);
      }
      else if (type == BLOCK_EXPR) {
        return new GleamBlockExprImpl(node);
      }
      else if (type == CALL_ARGUMENT) {
        return new GleamCallArgumentImpl(node);
      }
      else if (type == CALL_ARGUMENTS) {
        return new GleamCallArgumentsImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new GleamCallExprImpl(node);
      }
      else if (type == CASE_CLAUSE) {
        return new GleamCaseClauseImpl(node);
      }
      else if (type == CASE_CLAUSES) {
        return new GleamCaseClausesImpl(node);
      }
      else if (type == CASE_CLAUSE_GUARD) {
        return new GleamCaseClauseGuardImpl(node);
      }
      else if (type == CASE_CLAUSE_GUARD_BINARY_OPERATOR) {
        return new GleamCaseClauseGuardBinaryOperatorImpl(node);
      }
      else if (type == CASE_CLAUSE_GUARD_EXPRESSION) {
        return new GleamCaseClauseGuardExpressionImpl(node);
      }
      else if (type == CASE_CLAUSE_GUARD_TAIL) {
        return new GleamCaseClauseGuardTailImpl(node);
      }
      else if (type == CASE_CLAUSE_GUARD_UNIT) {
        return new GleamCaseClauseGuardUnitImpl(node);
      }
      else if (type == CASE_CLAUSE_PATTERN) {
        return new GleamCaseClausePatternImpl(node);
      }
      else if (type == CASE_CLAUSE_PATTERNS) {
        return new GleamCaseClausePatternsImpl(node);
      }
      else if (type == CASE_CLAUSE_TUPLE_ACCESS) {
        return new GleamCaseClauseTupleAccessImpl(node);
      }
      else if (type == CASE_EXPR) {
        return new GleamCaseExprImpl(node);
      }
      else if (type == CASE_EXPR_BODY) {
        return new GleamCaseExprBodyImpl(node);
      }
      else if (type == CASE_SUBJECTS) {
        return new GleamCaseSubjectsImpl(node);
      }
      else if (type == CONSTANT_BIT_ARRAY_SEGMENT) {
        return new GleamConstantBitArraySegmentImpl(node);
      }
      else if (type == CONSTANT_DECLARATION) {
        return new GleamConstantDeclarationImpl(node);
      }
      else if (type == CONSTANT_FUNCTION_PARAMETER_TYPES) {
        return new GleamConstantFunctionParameterTypesImpl(node);
      }
      else if (type == CONSTANT_RECORD_ARGUMENT) {
        return new GleamConstantRecordArgumentImpl(node);
      }
      else if (type == CONSTANT_RECORD_ARGUMENTS) {
        return new GleamConstantRecordArgumentsImpl(node);
      }
      else if (type == CONSTANT_TYPE) {
        return new GleamConstantTypeImpl(node);
      }
      else if (type == CONSTANT_TYPE_ANNOTATION) {
        return new GleamConstantTypeAnnotationImpl(node);
      }
      else if (type == CONSTANT_TYPE_ARGUMENT) {
        return new GleamConstantTypeArgumentImpl(node);
      }
      else if (type == CONSTANT_TYPE_ARGUMENTS) {
        return new GleamConstantTypeArgumentsImpl(node);
      }
      else if (type == CONSTANT_TYPE_FUNCTION) {
        return new GleamConstantTypeFunctionImpl(node);
      }
      else if (type == CONSTANT_TYPE_SPECIAL) {
        return new GleamConstantTypeSpecialImpl(node);
      }
      else if (type == CONSTANT_TYPE_TUPLE) {
        return new GleamConstantTypeTupleImpl(node);
      }
      else if (type == CONSTRUCTOR_IDENTIFIER) {
        return new GleamConstructorIdentifierImpl(node);
      }
      else if (type == CUSTOM_TYPE_VALUE) {
        return new GleamCustomTypeValueImpl(node);
      }
      else if (type == DECIMAL_INTEGER_LITERAL) {
        return new GleamDecimalIntegerLiteralImpl(node);
      }
      else if (type == DEPRECATED_ANNOTATION) {
        return new GleamDeprecatedAnnotationImpl(node);
      }
      else if (type == DEPRECATED_ANNOTATION_NAME) {
        return new GleamDeprecatedAnnotationNameImpl(node);
      }
      else if (type == EXPRESSION) {
        return new GleamExpressionImpl(node);
      }
      else if (type == EXTERNAL_ANNOTATION) {
        return new GleamExternalAnnotationImpl(node);
      }
      else if (type == EXTERNAL_ANNOTATION_NAME) {
        return new GleamExternalAnnotationNameImpl(node);
      }
      else if (type == EXTERNAL_TARGET) {
        return new GleamExternalTargetImpl(node);
      }
      else if (type == FIELD_ACCESS_EXPR_CONST) {
        return new GleamFieldAccessExprConstImpl(node);
      }
      else if (type == FLOAT_LITERAL) {
        return new GleamFloatLiteralImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new GleamFunctionBodyImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new GleamFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_NAME_DEFINITION) {
        return new GleamFunctionNameDefinitionImpl(node);
      }
      else if (type == FUNCTION_PARAMETER) {
        return new GleamFunctionParameterImpl(node);
      }
      else if (type == FUNCTION_PARAMETERS) {
        return new GleamFunctionParametersImpl(node);
      }
      else if (type == FUNCTION_PARAMETER_TYPES) {
        return new GleamFunctionParameterTypesImpl(node);
      }
      else if (type == FUNCTION_TYPE) {
        return new GleamFunctionTypeImpl(node);
      }
      else if (type == GENERIC_TYPE) {
        return new GleamGenericTypeImpl(node);
      }
      else if (type == HEX_INTEGER_LITERAL) {
        return new GleamHexIntegerLiteralImpl(node);
      }
      else if (type == HOLE_PATTERN) {
        return new GleamHolePatternImpl(node);
      }
      else if (type == IDENTIFIER_DISCARDABLE) {
        return new GleamIdentifierDiscardableImpl(node);
      }
      else if (type == IDENTIFIER_EXPR_CONST) {
        return new GleamIdentifierExprConstImpl(node);
      }
      else if (type == IDENTIFIER_PATTERN) {
        return new GleamIdentifierPatternImpl(node);
      }
      else if (type == IMPORT_DECLARATION) {
        return new GleamImportDeclarationImpl(node);
      }
      else if (type == INTEGER_LITERAL) {
        return new GleamIntegerLiteralImpl(node);
      }
      else if (type == LABEL) {
        return new GleamLabelImpl(node);
      }
      else if (type == LABELED_ARGUMENT) {
        return new GleamLabeledArgumentImpl(node);
      }
      else if (type == LABELED_PARAMETER) {
        return new GleamLabeledParameterImpl(node);
      }
      else if (type == LET_EXPR) {
        return new GleamLetExprImpl(node);
      }
      else if (type == LIST_EXPR) {
        return new GleamListExprImpl(node);
      }
      else if (type == LIST_EXPR_CONST) {
        return new GleamListExprConstImpl(node);
      }
      else if (type == LIST_PATTERN) {
        return new GleamListPatternImpl(node);
      }
      else if (type == LIST_PATTERN_TAIL) {
        return new GleamListPatternTailImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new GleamLiteralExprImpl(node);
      }
      else if (type == LITERAL_EXPR_CONST) {
        return new GleamLiteralExprConstImpl(node);
      }
      else if (type == LITERAL_PATTERN) {
        return new GleamLiteralPatternImpl(node);
      }
      else if (type == MODULE_PATH) {
        return new GleamModulePathImpl(node);
      }
      else if (type == NEGATIVE_DECIMAL_INTEGER_LITERAL) {
        return new GleamNegativeDecimalIntegerLiteralImpl(node);
      }
      else if (type == OCTAL_INTEGER_LITERAL) {
        return new GleamOctalIntegerLiteralImpl(node);
      }
      else if (type == OMITTED_TYPE_VALUE) {
        return new GleamOmittedTypeValueImpl(node);
      }
      else if (type == OTHER_ANNOTATION) {
        return new GleamOtherAnnotationImpl(node);
      }
      else if (type == PANIC_EXPR) {
        return new GleamPanicExprImpl(node);
      }
      else if (type == PATTERN_ALIASABLE) {
        return new GleamPatternAliasableImpl(node);
      }
      else if (type == PATTERN_BIT_ARRAY_SEGMENT) {
        return new GleamPatternBitArraySegmentImpl(node);
      }
      else if (type == PATTERN_SPREAD) {
        return new GleamPatternSpreadImpl(node);
      }
      else if (type == QUALIFIED_TYPE_NAME) {
        return new GleamQualifiedTypeNameImpl(node);
      }
      else if (type == RECORD_ARGUMENT) {
        return new GleamRecordArgumentImpl(node);
      }
      else if (type == RECORD_ARGUMENTS) {
        return new GleamRecordArgumentsImpl(node);
      }
      else if (type == RECORD_CONSTRUCTOR) {
        return new GleamRecordConstructorImpl(node);
      }
      else if (type == RECORD_CONSTRUCTOR_PARAMETERS) {
        return new GleamRecordConstructorParametersImpl(node);
      }
      else if (type == RECORD_EXPR) {
        return new GleamRecordExprImpl(node);
      }
      else if (type == RECORD_EXPR_CONST) {
        return new GleamRecordExprConstImpl(node);
      }
      else if (type == RECORD_PATTERN) {
        return new GleamRecordPatternImpl(node);
      }
      else if (type == RECORD_PATTERN_ARGUMENT) {
        return new GleamRecordPatternArgumentImpl(node);
      }
      else if (type == RECORD_PATTERN_ARGUMENTS) {
        return new GleamRecordPatternArgumentsImpl(node);
      }
      else if (type == RECORD_UPDATE) {
        return new GleamRecordUpdateImpl(node);
      }
      else if (type == RECORD_UPDATE_ARGUMENT) {
        return new GleamRecordUpdateArgumentImpl(node);
      }
      else if (type == RECORD_UPDATE_ARGUMENTS) {
        return new GleamRecordUpdateArgumentsImpl(node);
      }
      else if (type == RECORD_UPDATE_EXPR) {
        return new GleamRecordUpdateExprImpl(node);
      }
      else if (type == REFERENCE_EXPR) {
        return new GleamReferenceExprImpl(node);
      }
      else if (type == REMOTE_CONSTRUCTOR_IDENTIFIER) {
        return new GleamRemoteConstructorIdentifierImpl(node);
      }
      else if (type == SHORT_HAND_LABELED_ARGUMENT) {
        return new GleamShortHandLabeledArgumentImpl(node);
      }
      else if (type == STRING_ESCAPE_SEGMENT) {
        return new GleamStringEscapeSegmentImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new GleamStringLiteralImpl(node);
      }
      else if (type == STRING_PATTERN) {
        return new GleamStringPatternImpl(node);
      }
      else if (type == TARGET_ANNOTATION) {
        return new GleamTargetAnnotationImpl(node);
      }
      else if (type == TODO_EXPR) {
        return new GleamTodoExprImpl(node);
      }
      else if (type == TUPLE_EXPR) {
        return new GleamTupleExprImpl(node);
      }
      else if (type == TUPLE_EXPR_CONST) {
        return new GleamTupleExprConstImpl(node);
      }
      else if (type == TUPLE_PATTERN) {
        return new GleamTuplePatternImpl(node);
      }
      else if (type == TUPLE_TYPE) {
        return new GleamTupleTypeImpl(node);
      }
      else if (type == TYPE_ANNOTATION) {
        return new GleamTypeAnnotationImpl(node);
      }
      else if (type == TYPE_ARGUMENT) {
        return new GleamTypeArgumentImpl(node);
      }
      else if (type == TYPE_ARGUMENTS) {
        return new GleamTypeArgumentsImpl(node);
      }
      else if (type == TYPE_BASE) {
        return new GleamTypeBaseImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new GleamTypeDeclarationImpl(node);
      }
      else if (type == TYPE_DECLARATION_NAME) {
        return new GleamTypeDeclarationNameImpl(node);
      }
      else if (type == TYPE_GENERICS) {
        return new GleamTypeGenericsImpl(node);
      }
      else if (type == TYPE_REFERENCE) {
        return new GleamTypeReferenceImpl(node);
      }
      else if (type == TYPE_UNQUALIFIED_IMPORT) {
        return new GleamTypeUnqualifiedImportImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new GleamUnaryExprImpl(node);
      }
      else if (type == UNARY_OPERATOR) {
        return new GleamUnaryOperatorImpl(node);
      }
      else if (type == UNKNOWN_ANNOTATION_NAME) {
        return new GleamUnknownAnnotationNameImpl(node);
      }
      else if (type == UNLABELED_ARGUMENT) {
        return new GleamUnlabeledArgumentImpl(node);
      }
      else if (type == UNLABELED_PARAMETER) {
        return new GleamUnlabeledParameterImpl(node);
      }
      else if (type == UNQUALIFIED_IMPORT) {
        return new GleamUnqualifiedImportImpl(node);
      }
      else if (type == UNQUALIFIED_IMPORTS) {
        return new GleamUnqualifiedImportsImpl(node);
      }
      else if (type == UNQUALIFIED_TYPE_NAME) {
        return new GleamUnqualifiedTypeNameImpl(node);
      }
      else if (type == UP_UNQUALIFIED_IMPORT) {
        return new GleamUpUnqualifiedImportImpl(node);
      }
      else if (type == USE_ARGS) {
        return new GleamUseArgsImpl(node);
      }
      else if (type == USE_EXPR) {
        return new GleamUseExprImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new GleamVariableReferenceImpl(node);
      }
      else if (type == VISIBILITY_MODIFIER) {
        return new GleamVisibilityModifierImpl(node);
      }
      else if (type == WHOLE_NUMBER) {
        return new GleamWholeNumberImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
