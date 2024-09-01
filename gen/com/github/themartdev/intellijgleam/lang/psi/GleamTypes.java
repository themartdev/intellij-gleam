// This is a generated file. Not intended for manual editing.
package com.github.themartdev.intellijgleam.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.themartdev.intellijgleam.lang.psi.impl.*;

public interface GleamTypes {

  IElementType ACCESS_EXPR = new GleamType("ACCESS_EXPR");
  IElementType ANONYMOUS_FUNCTION_EXPR = new GleamType("ANONYMOUS_FUNCTION_EXPR");
  IElementType ANONYMOUS_FUNCTION_PARAMETER = new GleamType("ANONYMOUS_FUNCTION_PARAMETER");
  IElementType ANONYMOUS_FUNCTION_PARAMETERS = new GleamType("ANONYMOUS_FUNCTION_PARAMETERS");
  IElementType ANONYMOUS_FUNCTION_PARAMETER_ARGS = new GleamType("ANONYMOUS_FUNCTION_PARAMETER_ARGS");
  IElementType ARGUMENT = new GleamType("ARGUMENT");
  IElementType ARGUMENTS = new GleamType("ARGUMENTS");
  IElementType ASSERT_LET_EXPR = new GleamType("ASSERT_LET_EXPR");
  IElementType ASSIGNMENT = new GleamType("ASSIGNMENT");
  IElementType BINARY_EXPR = new GleamType("BINARY_EXPR");
  IElementType BINARY_INTEGER_LITERAL = new GleamType("BINARY_INTEGER_LITERAL");
  IElementType BINARY_OPERATOR = new GleamType("BINARY_OPERATOR");
  IElementType BIT_STRING_NAMED_SEGMENT_OPTION = new GleamType("BIT_STRING_NAMED_SEGMENT_OPTION");
  IElementType BIT_STRING_SEGMENT_OPTION = new GleamType("BIT_STRING_SEGMENT_OPTION");
  IElementType BIT_STRING_SEGMENT_OPTIONS = new GleamType("BIT_STRING_SEGMENT_OPTIONS");
  IElementType BIT_STRING_SEGMENT_OPTION_SIZE = new GleamType("BIT_STRING_SEGMENT_OPTION_SIZE");
  IElementType BLOCK_EXPR = new GleamType("BLOCK_EXPR");
  IElementType CALL_EXPR = new GleamType("CALL_EXPR");
  IElementType CASE_CLAUSE = new GleamType("CASE_CLAUSE");
  IElementType CASE_CLAUSES = new GleamType("CASE_CLAUSES");
  IElementType CASE_CLAUSE_GUARD = new GleamType("CASE_CLAUSE_GUARD");
  IElementType CASE_CLAUSE_GUARD_BINARY_OPERATOR = new GleamType("CASE_CLAUSE_GUARD_BINARY_OPERATOR");
  IElementType CASE_CLAUSE_GUARD_EXPRESSION = new GleamType("CASE_CLAUSE_GUARD_EXPRESSION");
  IElementType CASE_CLAUSE_GUARD_TAIL = new GleamType("CASE_CLAUSE_GUARD_TAIL");
  IElementType CASE_CLAUSE_GUARD_UNIT = new GleamType("CASE_CLAUSE_GUARD_UNIT");
  IElementType CASE_CLAUSE_PATTERN = new GleamType("CASE_CLAUSE_PATTERN");
  IElementType CASE_CLAUSE_PATTERNS = new GleamType("CASE_CLAUSE_PATTERNS");
  IElementType CASE_CLAUSE_TUPLE_ACCESS = new GleamType("CASE_CLAUSE_TUPLE_ACCESS");
  IElementType CASE_EXPR = new GleamType("CASE_EXPR");
  IElementType CASE_SUBJECTS = new GleamType("CASE_SUBJECTS");
  IElementType CONSTANT = new GleamType("CONSTANT");
  IElementType CONSTANT_BIT_STRING = new GleamType("CONSTANT_BIT_STRING");
  IElementType CONSTANT_BIT_STRING_SEGMENT = new GleamType("CONSTANT_BIT_STRING_SEGMENT");
  IElementType CONSTANT_FIELD_ACCESS = new GleamType("CONSTANT_FIELD_ACCESS");
  IElementType CONSTANT_FUNCTION_PARAMETER_TYPES = new GleamType("CONSTANT_FUNCTION_PARAMETER_TYPES");
  IElementType CONSTANT_LIST = new GleamType("CONSTANT_LIST");
  IElementType CONSTANT_RECORD = new GleamType("CONSTANT_RECORD");
  IElementType CONSTANT_RECORD_ARGUMENT = new GleamType("CONSTANT_RECORD_ARGUMENT");
  IElementType CONSTANT_RECORD_ARGUMENTS = new GleamType("CONSTANT_RECORD_ARGUMENTS");
  IElementType CONSTANT_TUPLE = new GleamType("CONSTANT_TUPLE");
  IElementType CONSTANT_TYPE = new GleamType("CONSTANT_TYPE");
  IElementType CONSTANT_TYPE_ANNOTATION = new GleamType("CONSTANT_TYPE_ANNOTATION");
  IElementType CONSTANT_TYPE_ARGUMENT = new GleamType("CONSTANT_TYPE_ARGUMENT");
  IElementType CONSTANT_TYPE_ARGUMENTS = new GleamType("CONSTANT_TYPE_ARGUMENTS");
  IElementType CONSTANT_TYPE_FUNCTION = new GleamType("CONSTANT_TYPE_FUNCTION");
  IElementType CONSTANT_TYPE_SPECIAL = new GleamType("CONSTANT_TYPE_SPECIAL");
  IElementType CONSTANT_TYPE_TUPLE = new GleamType("CONSTANT_TYPE_TUPLE");
  IElementType CONSTANT_VALUE = new GleamType("CONSTANT_VALUE");
  IElementType CONSTRUCTOR_IDENTIFIER = new GleamType("CONSTRUCTOR_IDENTIFIER");
  IElementType DATA_CONSTRUCTOR = new GleamType("DATA_CONSTRUCTOR");
  IElementType DATA_CONSTRUCTORS = new GleamType("DATA_CONSTRUCTORS");
  IElementType DATA_CONSTRUCTOR_ARGUMENT = new GleamType("DATA_CONSTRUCTOR_ARGUMENT");
  IElementType DATA_CONSTRUCTOR_ARGUMENTS = new GleamType("DATA_CONSTRUCTOR_ARGUMENTS");
  IElementType DECIMAL_INTEGER_LITERAL = new GleamType("DECIMAL_INTEGER_LITERAL");
  IElementType DISCARD = new GleamType("DISCARD");
  IElementType DISCARD_PARAM = new GleamType("DISCARD_PARAM");
  IElementType EXPRESSION = new GleamType("EXPRESSION");
  IElementType EXPRESSION_BIT_STRING_EXPR = new GleamType("EXPRESSION_BIT_STRING_EXPR");
  IElementType EXPRESSION_BIT_STRING_SEGMENT = new GleamType("EXPRESSION_BIT_STRING_SEGMENT");
  IElementType EXPRESSION_SEQ = new GleamType("EXPRESSION_SEQ");
  IElementType FLOAT_LITERAL = new GleamType("FLOAT_LITERAL");
  IElementType FUNCTION = new GleamType("FUNCTION");
  IElementType FUNCTION_BODY = new GleamType("FUNCTION_BODY");
  IElementType FUNCTION_NAME_DEFINITION = new GleamType("FUNCTION_NAME_DEFINITION");
  IElementType FUNCTION_PARAMETER = new GleamType("FUNCTION_PARAMETER");
  IElementType FUNCTION_PARAMETERS = new GleamType("FUNCTION_PARAMETERS");
  IElementType FUNCTION_PARAMETER_ARGS = new GleamType("FUNCTION_PARAMETER_ARGS");
  IElementType FUNCTION_PARAMETER_TYPES = new GleamType("FUNCTION_PARAMETER_TYPES");
  IElementType FUNCTION_TYPE = new GleamType("FUNCTION_TYPE");
  IElementType HEX_INTEGER_LITERAL = new GleamType("HEX_INTEGER_LITERAL");
  IElementType HOLE = new GleamType("HOLE");
  IElementType IMPORT_STATEMENT = new GleamType("IMPORT_STATEMENT");
  IElementType INTEGER_LITERAL = new GleamType("INTEGER_LITERAL");
  IElementType LABEL = new GleamType("LABEL");
  IElementType LABELED_DISCARD_PARAM = new GleamType("LABELED_DISCARD_PARAM");
  IElementType LABELED_NAME_PARAM = new GleamType("LABELED_NAME_PARAM");
  IElementType LET_EXPR = new GleamType("LET_EXPR");
  IElementType LIST_EXPR = new GleamType("LIST_EXPR");
  IElementType LIST_PATTERN = new GleamType("LIST_PATTERN");
  IElementType LIST_PATTERN_TAIL = new GleamType("LIST_PATTERN_TAIL");
  IElementType LITERAL_EXPR = new GleamType("LITERAL_EXPR");
  IElementType MODULE = new GleamType("MODULE");
  IElementType NAME_PARAM = new GleamType("NAME_PARAM");
  IElementType OCTAL_INTEGER_LITERAL = new GleamType("OCTAL_INTEGER_LITERAL");
  IElementType OPACITY_MODIFIER = new GleamType("OPACITY_MODIFIER");
  IElementType PANIC_EXPR = new GleamType("PANIC_EXPR");
  IElementType PARENTHESIZED_EXPR = new GleamType("PARENTHESIZED_EXPR");
  IElementType PATTERN = new GleamType("PATTERN");
  IElementType PATTERN_BIT_STRING = new GleamType("PATTERN_BIT_STRING");
  IElementType PATTERN_BIT_STRING_SEGMENT = new GleamType("PATTERN_BIT_STRING_SEGMENT");
  IElementType PATTERN_SPREAD = new GleamType("PATTERN_SPREAD");
  IElementType RECORD_EXPR = new GleamType("RECORD_EXPR");
  IElementType RECORD_PATTERN = new GleamType("RECORD_PATTERN");
  IElementType RECORD_PATTERN_ARGUMENT = new GleamType("RECORD_PATTERN_ARGUMENT");
  IElementType RECORD_PATTERN_ARGUMENTS = new GleamType("RECORD_PATTERN_ARGUMENTS");
  IElementType RECORD_UPDATE_ARGUMENT = new GleamType("RECORD_UPDATE_ARGUMENT");
  IElementType RECORD_UPDATE_ARGUMENTS = new GleamType("RECORD_UPDATE_ARGUMENTS");
  IElementType RECORD_UPDATE_EXPR = new GleamType("RECORD_UPDATE_EXPR");
  IElementType REFERENCE_EXPR = new GleamType("REFERENCE_EXPR");
  IElementType REMOTE_CONSTRUCTOR_IDENTIFIER = new GleamType("REMOTE_CONSTRUCTOR_IDENTIFIER");
  IElementType REMOTE_TYPE_IDENTIFIER = new GleamType("REMOTE_TYPE_IDENTIFIER");
  IElementType SIMPLE_LET_EXPR = new GleamType("SIMPLE_LET_EXPR");
  IElementType STRING_ESCAPE_SEGMENT = new GleamType("STRING_ESCAPE_SEGMENT");
  IElementType STRING_LITERAL = new GleamType("STRING_LITERAL");
  IElementType TODO_EXPR = new GleamType("TODO_EXPR");
  IElementType TOP_LEVEL_STATEMENT = new GleamType("TOP_LEVEL_STATEMENT");
  IElementType TUPLE_EXPR = new GleamType("TUPLE_EXPR");
  IElementType TUPLE_PATTERN = new GleamType("TUPLE_PATTERN");
  IElementType TUPLE_TYPE = new GleamType("TUPLE_TYPE");
  IElementType TYPE_ALIAS = new GleamType("TYPE_ALIAS");
  IElementType TYPE_ANNOTATION = new GleamType("TYPE_ANNOTATION");
  IElementType TYPE_ARGUMENT = new GleamType("TYPE_ARGUMENT");
  IElementType TYPE_ARGUMENTS = new GleamType("TYPE_ARGUMENTS");
  IElementType TYPE_BASE = new GleamType("TYPE_BASE");
  IElementType TYPE_DECLARATION = new GleamType("TYPE_DECLARATION");
  IElementType TYPE_DEFINITION = new GleamType("TYPE_DEFINITION");
  IElementType TYPE_HOLE = new GleamType("TYPE_HOLE");
  IElementType TYPE_IDENTIFIER = new GleamType("TYPE_IDENTIFIER");
  IElementType TYPE_NAME = new GleamType("TYPE_NAME");
  IElementType TYPE_PARAMETER = new GleamType("TYPE_PARAMETER");
  IElementType TYPE_PARAMETERS = new GleamType("TYPE_PARAMETERS");
  IElementType TYPE_RULE = new GleamType("TYPE_RULE");
  IElementType TYPE_VAR = new GleamType("TYPE_VAR");
  IElementType UNARY_EXPR = new GleamType("UNARY_EXPR");
  IElementType UNARY_OPERATOR = new GleamType("UNARY_OPERATOR");
  IElementType UNQUALIFIED_IMPORT = new GleamType("UNQUALIFIED_IMPORT");
  IElementType UNQUALIFIED_IMPORTS = new GleamType("UNQUALIFIED_IMPORTS");
  IElementType USE_ARGS = new GleamType("USE_ARGS");
  IElementType USE_EXPR = new GleamType("USE_EXPR");
  IElementType VISIBILITY_MODIFIER = new GleamType("VISIBILITY_MODIFIER");
  IElementType WHOLE_NUMBER = new GleamType("WHOLE_NUMBER");

  IElementType AMPER_AMPER = new IElementType("&&", null);
  IElementType AS = new IElementType("as", null);
  IElementType ASSERT = new IElementType("assert", null);
  IElementType BANG = new IElementType("!", null);
  IElementType BASE_NUMBER_PREFIX = new IElementType("0", null);
  IElementType BINARY_NUMBER_BASE = new IElementType("BINARY_NUMBER_BASE", null);
  IElementType BOOLEAN_LITERAL = new IElementType("BOOLEAN_LITERAL", null);
  IElementType CASE = new IElementType("case", null);
  IElementType CLOSE_QUOTE = new IElementType("\"", null);
  IElementType COLON = new IElementType(":", null);
  IElementType COMMA = new IElementType(",", null);
  IElementType CONST = new IElementType("const", null);
  IElementType DECIMAL_MARK = new IElementType(". (decimal separator)", null);
  IElementType DISCARD_NAME = new IElementType("DISCARD_NAME", null);
  IElementType DOT = new IElementType(".", null);
  IElementType DOT_DOT = new IElementType("..", null);
  IElementType EOL = new IElementType("\\\\n, \\\\r\\\\n", null);
  IElementType EQUAL = new IElementType("=", null);
  IElementType EQUAL_EQUAL = new IElementType("==", null);
  IElementType ESCAPE = new IElementType("ESCAPE", null);
  IElementType ESCAPE_CHAR = new IElementType("ESCAPE_CHAR", null);
  IElementType EXPONENT_MARK = new IElementType("e (exponent)", null);
  IElementType EXPONENT_SIGN = new IElementType("EXPONENT_SIGN", null);
  IElementType FN = new IElementType("fn", null);
  IElementType FUNCTION_COMMENT = new IElementType("FUNCTION_COMMENT", null);
  IElementType GREATER = new IElementType(">", null);
  IElementType GREATER_DOT = new IElementType(">.", null);
  IElementType GREATER_EQUAL = new IElementType(">=", null);
  IElementType GREATER_EQUAL_DOT = new IElementType(">=.", null);
  IElementType GT_GT = new IElementType(">>", null);
  IElementType HASH = new IElementType("#", null);
  IElementType HEX_NUMBER_BASE = new IElementType("HEX_NUMBER_BASE", null);
  IElementType IDENTIFIER = new IElementType("IDENTIFIER", null);
  IElementType IF = new IElementType("if", null);
  IElementType IMPORT = new IElementType("import", null);
  IElementType INVALID_BINARY_DIGIT = new IElementType("INVALID_BINARY_DIGIT", null);
  IElementType INVALID_DECIMAL_DIGIT = new IElementType("INVALID_DECIMAL_DIGIT", null);
  IElementType INVALID_HEX_DIGIT = new IElementType("INVALID_HEX_DIGIT", null);
  IElementType INVALID_OCTAL_DIGIT = new IElementType("INVALID_OCTAL_DIGIT", null);
  IElementType INVALID_UNICODE_ESCAPE_SEQUENCE = new IElementType("INVALID_UNICODE_ESCAPE_SEQUENCE", null);
  IElementType INVALID_UNKNOWN_BASE_DIGIT = new IElementType("INVALID_UNKNOWN_BASE_DIGIT", null);
  IElementType LBRACE = new IElementType("{", null);
  IElementType LBRACK = new IElementType("[", null);
  IElementType LESS = new IElementType("<", null);
  IElementType LESS_DOT = new IElementType("<.", null);
  IElementType LESS_EQUAL = new IElementType("<=", null);
  IElementType LESS_EQUAL_DOT = new IElementType("<=.", null);
  IElementType LET = new IElementType("let", null);
  IElementType LINE_COMMENT = new IElementType("LINE_COMMENT", null);
  IElementType LPAREN = new IElementType("(", null);
  IElementType LT_GT = new IElementType("<>", null);
  IElementType LT_LT = new IElementType("<<", null);
  IElementType L_ARROW = new IElementType("<-", null);
  IElementType MINUS = new IElementType("-", null);
  IElementType MINUS_DOT = new IElementType("-.", null);
  IElementType MODULE_COMMENT = new IElementType("MODULE_COMMENT", null);
  IElementType NOT_EQUAL = new IElementType("!=", null);
  IElementType NUMBER_SEPARATOR = new IElementType("_", null);
  IElementType OCTAL_NUMBER_BASE = new IElementType("OCTAL_NUMBER_BASE", null);
  IElementType OPAQUE = new IElementType("opaque", null);
  IElementType OPEN_QUOTE = new IElementType("OPEN_QUOTE", null);
  IElementType PANIC = new IElementType("panic", null);
  IElementType PERCENT = new IElementType("%", null);
  IElementType PIPE = new IElementType("|>", null);
  IElementType PLUS = new IElementType("+", null);
  IElementType PLUS_DOT = new IElementType("+.", null);
  IElementType PUB = new IElementType("pub", null);
  IElementType RBRACE = new IElementType("}", null);
  IElementType RBRACK = new IElementType("]", null);
  IElementType REGULAR_STRING_PART = new IElementType("REGULAR_STRING_PART", null);
  IElementType RPAREN = new IElementType(")", null);
  IElementType R_ARROW = new IElementType("->", null);
  IElementType SLASH = new IElementType("/", null);
  IElementType SLASH_DOT = new IElementType("/.", null);
  IElementType STAR = new IElementType("*", null);
  IElementType STAR_DOT = new IElementType("*.", null);
  IElementType TEST = new IElementType("test", null);
  IElementType TODO = new IElementType("todo", null);
  IElementType TYPE = new IElementType("type", null);
  IElementType UNICODE_CODEPOINT = new IElementType("UNICODE_CODEPOINT", null);
  IElementType UNICODE_ESCAPE_CHAR = new IElementType("u", null);
  IElementType UNKNOWN_NUMBER_BASE = new IElementType("UNKNOWN_NUMBER_BASE", null);
  IElementType UP_IDENTIFIER = new IElementType("UP_IDENTIFIER", null);
  IElementType USE = new IElementType("use", null);
  IElementType VALID_BINARY_DIGIT = new IElementType("VALID_BINARY_DIGIT", null);
  IElementType VALID_DECIMAL_DIGIT = new IElementType("VALID_DECIMAL_DIGIT", null);
  IElementType VALID_HEX_DIGIT = new IElementType("VALID_HEX_DIGIT", null);
  IElementType VALID_OCTAL_DIGIT = new IElementType("VALID_OCTAL_DIGIT", null);
  IElementType VBAR = new IElementType("|", null);
  IElementType VBAR_VBAR = new IElementType("||", null);

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
      else if (type == TOP_LEVEL_STATEMENT) {
        return new GleamTopLevelStatementImpl(node);
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
