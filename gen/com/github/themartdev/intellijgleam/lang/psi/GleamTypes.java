// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.themartdev.intellijgleam.lang.psi.impl.*;

public interface GleamTypes {

  IElementType ACCESS_EXPR = new GleamElementType("ACCESS_EXPR");
  IElementType ANONYMOUS_FUNCTION_EXPR = new GleamElementType("ANONYMOUS_FUNCTION_EXPR");
  IElementType ANONYMOUS_FUNCTION_PARAMETER = new GleamElementType("ANONYMOUS_FUNCTION_PARAMETER");
  IElementType ANONYMOUS_FUNCTION_PARAMETERS = new GleamElementType("ANONYMOUS_FUNCTION_PARAMETERS");
  IElementType ANONYMOUS_FUNCTION_PARAMETER_ARGS = new GleamElementType("ANONYMOUS_FUNCTION_PARAMETER_ARGS");
  IElementType ARGUMENT = new GleamElementType("ARGUMENT");
  IElementType ARGUMENTS = new GleamElementType("ARGUMENTS");
  IElementType ASSERT_LET_EXPR = new GleamElementType("ASSERT_LET_EXPR");
  IElementType ASSIGNMENT = new GleamElementType("ASSIGNMENT");
  IElementType BINARY_EXPR = new GleamElementType("BINARY_EXPR");
  IElementType BINARY_INTEGER_LITERAL = new GleamElementType("BINARY_INTEGER_LITERAL");
  IElementType BINARY_OPERATOR = new GleamElementType("BINARY_OPERATOR");
  IElementType BIT_STRING_NAMED_SEGMENT_OPTION = new GleamElementType("BIT_STRING_NAMED_SEGMENT_OPTION");
  IElementType BIT_STRING_SEGMENT_OPTION = new GleamElementType("BIT_STRING_SEGMENT_OPTION");
  IElementType BIT_STRING_SEGMENT_OPTIONS = new GleamElementType("BIT_STRING_SEGMENT_OPTIONS");
  IElementType BIT_STRING_SEGMENT_OPTION_SIZE = new GleamElementType("BIT_STRING_SEGMENT_OPTION_SIZE");
  IElementType BLOCK_EXPR = new GleamElementType("BLOCK_EXPR");
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
  IElementType CASE_SUBJECTS = new GleamElementType("CASE_SUBJECTS");
  IElementType CONSTANT = new GleamElementType("CONSTANT");
  IElementType CONSTANT_BIT_STRING = new GleamElementType("CONSTANT_BIT_STRING");
  IElementType CONSTANT_BIT_STRING_SEGMENT = new GleamElementType("CONSTANT_BIT_STRING_SEGMENT");
  IElementType CONSTANT_FIELD_ACCESS = new GleamElementType("CONSTANT_FIELD_ACCESS");
  IElementType CONSTANT_FUNCTION_PARAMETER_TYPES = new GleamElementType("CONSTANT_FUNCTION_PARAMETER_TYPES");
  IElementType CONSTANT_LIST = new GleamElementType("CONSTANT_LIST");
  IElementType CONSTANT_RECORD = new GleamElementType("CONSTANT_RECORD");
  IElementType CONSTANT_RECORD_ARGUMENT = new GleamElementType("CONSTANT_RECORD_ARGUMENT");
  IElementType CONSTANT_RECORD_ARGUMENTS = new GleamElementType("CONSTANT_RECORD_ARGUMENTS");
  IElementType CONSTANT_TUPLE = new GleamElementType("CONSTANT_TUPLE");
  IElementType CONSTANT_TYPE = new GleamElementType("CONSTANT_TYPE");
  IElementType CONSTANT_TYPE_ANNOTATION = new GleamElementType("CONSTANT_TYPE_ANNOTATION");
  IElementType CONSTANT_TYPE_ARGUMENT = new GleamElementType("CONSTANT_TYPE_ARGUMENT");
  IElementType CONSTANT_TYPE_ARGUMENTS = new GleamElementType("CONSTANT_TYPE_ARGUMENTS");
  IElementType CONSTANT_TYPE_FUNCTION = new GleamElementType("CONSTANT_TYPE_FUNCTION");
  IElementType CONSTANT_TYPE_SPECIAL = new GleamElementType("CONSTANT_TYPE_SPECIAL");
  IElementType CONSTANT_TYPE_TUPLE = new GleamElementType("CONSTANT_TYPE_TUPLE");
  IElementType CONSTANT_VALUE = new GleamElementType("CONSTANT_VALUE");
  IElementType CONSTRUCTOR_IDENTIFIER = new GleamElementType("CONSTRUCTOR_IDENTIFIER");
  IElementType DATA_CONSTRUCTOR = new GleamElementType("DATA_CONSTRUCTOR");
  IElementType DATA_CONSTRUCTORS = new GleamElementType("DATA_CONSTRUCTORS");
  IElementType DATA_CONSTRUCTOR_ARGUMENT = new GleamElementType("DATA_CONSTRUCTOR_ARGUMENT");
  IElementType DATA_CONSTRUCTOR_ARGUMENTS = new GleamElementType("DATA_CONSTRUCTOR_ARGUMENTS");
  IElementType DECIMAL_INTEGER_LITERAL = new GleamElementType("DECIMAL_INTEGER_LITERAL");
  IElementType DISCARD = new GleamElementType("DISCARD");
  IElementType DISCARD_PARAM = new GleamElementType("DISCARD_PARAM");
  IElementType EXPRESSION = new GleamElementType("EXPRESSION");
  IElementType EXPRESSION_BIT_STRING_EXPR = new GleamElementType("EXPRESSION_BIT_STRING_EXPR");
  IElementType EXPRESSION_BIT_STRING_SEGMENT = new GleamElementType("EXPRESSION_BIT_STRING_SEGMENT");
  IElementType EXPRESSION_SEQ = new GleamElementType("EXPRESSION_SEQ");
  IElementType FLOAT_LITERAL = new GleamElementType("FLOAT_LITERAL");
  IElementType FUNCTION = new GleamElementType("FUNCTION");
  IElementType FUNCTION_BODY = new GleamElementType("FUNCTION_BODY");
  IElementType FUNCTION_NAME_DEFINITION = new GleamElementType("FUNCTION_NAME_DEFINITION");
  IElementType FUNCTION_PARAMETER = new GleamElementType("FUNCTION_PARAMETER");
  IElementType FUNCTION_PARAMETERS = new GleamElementType("FUNCTION_PARAMETERS");
  IElementType FUNCTION_PARAMETER_ARGS = new GleamElementType("FUNCTION_PARAMETER_ARGS");
  IElementType FUNCTION_PARAMETER_TYPES = new GleamElementType("FUNCTION_PARAMETER_TYPES");
  IElementType FUNCTION_TYPE = new GleamElementType("FUNCTION_TYPE");
  IElementType HEX_INTEGER_LITERAL = new GleamElementType("HEX_INTEGER_LITERAL");
  IElementType HOLE = new GleamElementType("HOLE");
  IElementType IMPORT_STATEMENT = new GleamElementType("IMPORT_STATEMENT");
  IElementType INTEGER_LITERAL = new GleamElementType("INTEGER_LITERAL");
  IElementType LABEL = new GleamElementType("LABEL");
  IElementType LABELED_DISCARD_PARAM = new GleamElementType("LABELED_DISCARD_PARAM");
  IElementType LABELED_NAME_PARAM = new GleamElementType("LABELED_NAME_PARAM");
  IElementType LET_EXPR = new GleamElementType("LET_EXPR");
  IElementType LIST_EXPR = new GleamElementType("LIST_EXPR");
  IElementType LIST_PATTERN = new GleamElementType("LIST_PATTERN");
  IElementType LIST_PATTERN_TAIL = new GleamElementType("LIST_PATTERN_TAIL");
  IElementType LITERAL_EXPR = new GleamElementType("LITERAL_EXPR");
  IElementType MODULE = new GleamElementType("MODULE");
  IElementType NAME_PARAM = new GleamElementType("NAME_PARAM");
  IElementType OCTAL_INTEGER_LITERAL = new GleamElementType("OCTAL_INTEGER_LITERAL");
  IElementType OPACITY_MODIFIER = new GleamElementType("OPACITY_MODIFIER");
  IElementType PANIC_EXPR = new GleamElementType("PANIC_EXPR");
  IElementType PARENTHESIZED_EXPR = new GleamElementType("PARENTHESIZED_EXPR");
  IElementType PATTERN = new GleamElementType("PATTERN");
  IElementType PATTERN_BIT_STRING = new GleamElementType("PATTERN_BIT_STRING");
  IElementType PATTERN_BIT_STRING_SEGMENT = new GleamElementType("PATTERN_BIT_STRING_SEGMENT");
  IElementType PATTERN_SPREAD = new GleamElementType("PATTERN_SPREAD");
  IElementType RECORD_EXPR = new GleamElementType("RECORD_EXPR");
  IElementType RECORD_PATTERN = new GleamElementType("RECORD_PATTERN");
  IElementType RECORD_PATTERN_ARGUMENT = new GleamElementType("RECORD_PATTERN_ARGUMENT");
  IElementType RECORD_PATTERN_ARGUMENTS = new GleamElementType("RECORD_PATTERN_ARGUMENTS");
  IElementType RECORD_UPDATE_ARGUMENT = new GleamElementType("RECORD_UPDATE_ARGUMENT");
  IElementType RECORD_UPDATE_ARGUMENTS = new GleamElementType("RECORD_UPDATE_ARGUMENTS");
  IElementType RECORD_UPDATE_EXPR = new GleamElementType("RECORD_UPDATE_EXPR");
  IElementType REFERENCE_EXPR = new GleamElementType("REFERENCE_EXPR");
  IElementType REMOTE_CONSTRUCTOR_IDENTIFIER = new GleamElementType("REMOTE_CONSTRUCTOR_IDENTIFIER");
  IElementType REMOTE_TYPE_IDENTIFIER = new GleamElementType("REMOTE_TYPE_IDENTIFIER");
  IElementType SIMPLE_LET_EXPR = new GleamElementType("SIMPLE_LET_EXPR");
  IElementType STRING_ESCAPE_SEGMENT = new GleamElementType("STRING_ESCAPE_SEGMENT");
  IElementType STRING_LITERAL = new GleamElementType("STRING_LITERAL");
  IElementType TODO_EXPR = new GleamElementType("TODO_EXPR");
  IElementType TUPLE_EXPR = new GleamElementType("TUPLE_EXPR");
  IElementType TUPLE_PATTERN = new GleamElementType("TUPLE_PATTERN");
  IElementType TUPLE_TYPE = new GleamElementType("TUPLE_TYPE");
  IElementType TYPE_ALIAS = new GleamElementType("TYPE_ALIAS");
  IElementType TYPE_ANNOTATION = new GleamElementType("TYPE_ANNOTATION");
  IElementType TYPE_ARGUMENT = new GleamElementType("TYPE_ARGUMENT");
  IElementType TYPE_ARGUMENTS = new GleamElementType("TYPE_ARGUMENTS");
  IElementType TYPE_BASE = new GleamElementType("TYPE_BASE");
  IElementType TYPE_DECLARATION = new GleamElementType("TYPE_DECLARATION");
  IElementType TYPE_DEFINITION = new GleamElementType("TYPE_DEFINITION");
  IElementType TYPE_HOLE = new GleamElementType("TYPE_HOLE");
  IElementType TYPE_IDENTIFIER = new GleamElementType("TYPE_IDENTIFIER");
  IElementType TYPE_NAME = new GleamElementType("TYPE_NAME");
  IElementType TYPE_PARAMETER = new GleamElementType("TYPE_PARAMETER");
  IElementType TYPE_PARAMETERS = new GleamElementType("TYPE_PARAMETERS");
  IElementType TYPE_RULE = new GleamElementType("TYPE_RULE");
  IElementType TYPE_VAR = new GleamElementType("TYPE_VAR");
  IElementType UNARY_EXPR = new GleamElementType("UNARY_EXPR");
  IElementType UNARY_OPERATOR = new GleamElementType("UNARY_OPERATOR");
  IElementType UNQUALIFIED_IMPORT = new GleamElementType("UNQUALIFIED_IMPORT");
  IElementType UNQUALIFIED_IMPORTS = new GleamElementType("UNQUALIFIED_IMPORTS");
  IElementType USE_ARGS = new GleamElementType("USE_ARGS");
  IElementType USE_EXPR = new GleamElementType("USE_EXPR");
  IElementType VISIBILITY_MODIFIER = new GleamElementType("VISIBILITY_MODIFIER");
  IElementType WHOLE_NUMBER = new GleamElementType("WHOLE_NUMBER");

  IElementType AMPER_AMPER = new GleamTokenType("&&");
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
      else if (type == ANONYMOUS_FUNCTION_EXPR) {
        return new GleamAnonymousFunctionExprImpl(node);
      }
      else if (type == ANONYMOUS_FUNCTION_PARAMETER) {
        return new GleamAnonymousFunctionParameterImpl(node);
      }
      else if (type == ANONYMOUS_FUNCTION_PARAMETERS) {
        return new GleamAnonymousFunctionParametersImpl(node);
      }
      else if (type == ANONYMOUS_FUNCTION_PARAMETER_ARGS) {
        return new GleamAnonymousFunctionParameterArgsImpl(node);
      }
      else if (type == ARGUMENT) {
        return new GleamArgumentImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new GleamArgumentsImpl(node);
      }
      else if (type == ASSERT_LET_EXPR) {
        return new GleamAssertLetExprImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new GleamAssignmentImpl(node);
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
      else if (type == BIT_STRING_NAMED_SEGMENT_OPTION) {
        return new GleamBitStringNamedSegmentOptionImpl(node);
      }
      else if (type == BIT_STRING_SEGMENT_OPTION) {
        return new GleamBitStringSegmentOptionImpl(node);
      }
      else if (type == BIT_STRING_SEGMENT_OPTIONS) {
        return new GleamBitStringSegmentOptionsImpl(node);
      }
      else if (type == BIT_STRING_SEGMENT_OPTION_SIZE) {
        return new GleamBitStringSegmentOptionSizeImpl(node);
      }
      else if (type == BLOCK_EXPR) {
        return new GleamBlockExprImpl(node);
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
      else if (type == CASE_SUBJECTS) {
        return new GleamCaseSubjectsImpl(node);
      }
      else if (type == CONSTANT) {
        return new GleamConstantImpl(node);
      }
      else if (type == CONSTANT_BIT_STRING) {
        return new GleamConstantBitStringImpl(node);
      }
      else if (type == CONSTANT_BIT_STRING_SEGMENT) {
        return new GleamConstantBitStringSegmentImpl(node);
      }
      else if (type == CONSTANT_FIELD_ACCESS) {
        return new GleamConstantFieldAccessImpl(node);
      }
      else if (type == CONSTANT_FUNCTION_PARAMETER_TYPES) {
        return new GleamConstantFunctionParameterTypesImpl(node);
      }
      else if (type == CONSTANT_LIST) {
        return new GleamConstantListImpl(node);
      }
      else if (type == CONSTANT_RECORD) {
        return new GleamConstantRecordImpl(node);
      }
      else if (type == CONSTANT_RECORD_ARGUMENT) {
        return new GleamConstantRecordArgumentImpl(node);
      }
      else if (type == CONSTANT_RECORD_ARGUMENTS) {
        return new GleamConstantRecordArgumentsImpl(node);
      }
      else if (type == CONSTANT_TUPLE) {
        return new GleamConstantTupleImpl(node);
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
      else if (type == CONSTANT_VALUE) {
        return new GleamConstantValueImpl(node);
      }
      else if (type == CONSTRUCTOR_IDENTIFIER) {
        return new GleamConstructorIdentifierImpl(node);
      }
      else if (type == DATA_CONSTRUCTOR) {
        return new GleamDataConstructorImpl(node);
      }
      else if (type == DATA_CONSTRUCTORS) {
        return new GleamDataConstructorsImpl(node);
      }
      else if (type == DATA_CONSTRUCTOR_ARGUMENT) {
        return new GleamDataConstructorArgumentImpl(node);
      }
      else if (type == DATA_CONSTRUCTOR_ARGUMENTS) {
        return new GleamDataConstructorArgumentsImpl(node);
      }
      else if (type == DECIMAL_INTEGER_LITERAL) {
        return new GleamDecimalIntegerLiteralImpl(node);
      }
      else if (type == DISCARD) {
        return new GleamDiscardImpl(node);
      }
      else if (type == DISCARD_PARAM) {
        return new GleamDiscardParamImpl(node);
      }
      else if (type == EXPRESSION_BIT_STRING_EXPR) {
        return new GleamExpressionBitStringExprImpl(node);
      }
      else if (type == EXPRESSION_BIT_STRING_SEGMENT) {
        return new GleamExpressionBitStringSegmentImpl(node);
      }
      else if (type == EXPRESSION_SEQ) {
        return new GleamExpressionSeqImpl(node);
      }
      else if (type == FLOAT_LITERAL) {
        return new GleamFloatLiteralImpl(node);
      }
      else if (type == FUNCTION) {
        return new GleamFunctionImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new GleamFunctionBodyImpl(node);
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
      else if (type == FUNCTION_PARAMETER_ARGS) {
        return new GleamFunctionParameterArgsImpl(node);
      }
      else if (type == FUNCTION_PARAMETER_TYPES) {
        return new GleamFunctionParameterTypesImpl(node);
      }
      else if (type == FUNCTION_TYPE) {
        return new GleamFunctionTypeImpl(node);
      }
      else if (type == HEX_INTEGER_LITERAL) {
        return new GleamHexIntegerLiteralImpl(node);
      }
      else if (type == HOLE) {
        return new GleamHoleImpl(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new GleamImportStatementImpl(node);
      }
      else if (type == INTEGER_LITERAL) {
        return new GleamIntegerLiteralImpl(node);
      }
      else if (type == LABEL) {
        return new GleamLabelImpl(node);
      }
      else if (type == LABELED_DISCARD_PARAM) {
        return new GleamLabeledDiscardParamImpl(node);
      }
      else if (type == LABELED_NAME_PARAM) {
        return new GleamLabeledNameParamImpl(node);
      }
      else if (type == LIST_EXPR) {
        return new GleamListExprImpl(node);
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
      else if (type == MODULE) {
        return new GleamModuleImpl(node);
      }
      else if (type == NAME_PARAM) {
        return new GleamNameParamImpl(node);
      }
      else if (type == OCTAL_INTEGER_LITERAL) {
        return new GleamOctalIntegerLiteralImpl(node);
      }
      else if (type == OPACITY_MODIFIER) {
        return new GleamOpacityModifierImpl(node);
      }
      else if (type == PANIC_EXPR) {
        return new GleamPanicExprImpl(node);
      }
      else if (type == PARENTHESIZED_EXPR) {
        return new GleamParenthesizedExprImpl(node);
      }
      else if (type == PATTERN) {
        return new GleamPatternImpl(node);
      }
      else if (type == PATTERN_BIT_STRING) {
        return new GleamPatternBitStringImpl(node);
      }
      else if (type == PATTERN_BIT_STRING_SEGMENT) {
        return new GleamPatternBitStringSegmentImpl(node);
      }
      else if (type == PATTERN_SPREAD) {
        return new GleamPatternSpreadImpl(node);
      }
      else if (type == RECORD_EXPR) {
        return new GleamRecordExprImpl(node);
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
      else if (type == REMOTE_TYPE_IDENTIFIER) {
        return new GleamRemoteTypeIdentifierImpl(node);
      }
      else if (type == SIMPLE_LET_EXPR) {
        return new GleamSimpleLetExprImpl(node);
      }
      else if (type == STRING_ESCAPE_SEGMENT) {
        return new GleamStringEscapeSegmentImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new GleamStringLiteralImpl(node);
      }
      else if (type == TODO_EXPR) {
        return new GleamTodoExprImpl(node);
      }
      else if (type == TUPLE_EXPR) {
        return new GleamTupleExprImpl(node);
      }
      else if (type == TUPLE_PATTERN) {
        return new GleamTuplePatternImpl(node);
      }
      else if (type == TUPLE_TYPE) {
        return new GleamTupleTypeImpl(node);
      }
      else if (type == TYPE_ALIAS) {
        return new GleamTypeAliasImpl(node);
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
      else if (type == TYPE_DEFINITION) {
        return new GleamTypeDefinitionImpl(node);
      }
      else if (type == TYPE_HOLE) {
        return new GleamTypeHoleImpl(node);
      }
      else if (type == TYPE_IDENTIFIER) {
        return new GleamTypeIdentifierImpl(node);
      }
      else if (type == TYPE_NAME) {
        return new GleamTypeNameImpl(node);
      }
      else if (type == TYPE_PARAMETER) {
        return new GleamTypeParameterImpl(node);
      }
      else if (type == TYPE_PARAMETERS) {
        return new GleamTypeParametersImpl(node);
      }
      else if (type == TYPE_RULE) {
        return new GleamTypeRuleImpl(node);
      }
      else if (type == TYPE_VAR) {
        return new GleamTypeVarImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new GleamUnaryExprImpl(node);
      }
      else if (type == UNARY_OPERATOR) {
        return new GleamUnaryOperatorImpl(node);
      }
      else if (type == UNQUALIFIED_IMPORT) {
        return new GleamUnqualifiedImportImpl(node);
      }
      else if (type == UNQUALIFIED_IMPORTS) {
        return new GleamUnqualifiedImportsImpl(node);
      }
      else if (type == USE_ARGS) {
        return new GleamUseArgsImpl(node);
      }
      else if (type == USE_EXPR) {
        return new GleamUseExprImpl(node);
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
