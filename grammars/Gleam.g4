grammar Gleam;

source_file: (statement | expression_seq | target_group)* EOF;

// Enforce javascript | erlang with an intellij annotator
target_group: IF (identifier) LEFT_BRACE (statement)* RIGHT_BRACE;

module : NAME (SLASH NAME)*;
unqualified_import
    : NAME (AS NAME)?
    | UP_NAME (AS UP_NAME)?
    ;
unqualified_imports
    : LEFT_BRACE (unqualified_import (COMMA unqualified_import)* (COMMA)?)? RIGHT_BRACE
    ;
imports
    : IMPORT module (DOT unqualified_imports)? (AS NAME)?
    ;

constant_function_parameter_types
    : LEFT_PAREN (constant_type_special (COMMA constant_type_special)* (COMMA)?)? RIGHT_PAREN;
constant_type_function
    : FN (constant_function_parameter_types)? R_ARROW constant_type_special
    ;

constant_tuple: HASH LEFT_PAREN (constant_value (COMMA constant_value)* (COMMA)?)? RIGHT_PAREN;
constant_type_tuple
    : HASH LEFT_PAREN (constant_type_special (COMMA constant_type_special)* (COMMA)?)? RIGHT_PAREN;

constant_type_arguement: constant_type_special;
constant_type_arguements: LEFT_PAREN (constant_type_arguement (COMMA constant_type_arguement)* (COMMA)?)? RIGHT_PAREN;

constant_list: LEFT_SQUARE (constant_value (COMMA constant_value )* (COMMA)?)? RIGHT_SQUARE;

constant_record_argument: (label COLON)? constant_value;
constant_record_arguments: LEFT_PAREN (constant_record_argument (COMMA (constant_record_argument)* (COMMA)?))? RIGHT_PAREN;
constant_record : (constructor_name | remote_constructor_name) (constant_record_arguments)?;

bit_string_segment_option_size : identifier LEFT_PAREN INTEGER RIGHT_PAREN;
// 'binary' | 'bytes' | 'int' | 'float' | 'bit_string' | 'bits' | 'utf8' | 'utf16' | 'utf32' | 'utf8_codepoint' | 'utf16_codepoint' | 'utf32_codepoint' | 'signed' | 'unsigned' | 'big' | 'little' | 'native' | 'unit' '(' INTEGER ')';
// enforce value for identifier for these surrounding 2 rules with an intelliJ annotator
bit_string_named_segment_option: identifier | bit_string_segment_option_size;
bit_string_segment_option: bit_string_named_segment_option | INTEGER;
bit_string_segment_options: bit_string_segment_option (MINUS bit_string_segment_option)*  (MINUS)?;
constant_bit_string_segment: constant_value (COLON bit_string_segment_options)?;
constant_bit_string: LT_LT  (constant_bit_string_segment (COMMA constant_bit_string_segment)* (COMMA)?)? GT_GT;

constant_type: (type_identifier | remote_type_identifier) (constant_type_arguements)?;
constant_type_special
    : type_hole
    | constant_type_tuple
    | constant_type_function
    | constant_type
    ;
constant_type_annotation: COLON constant_type;
constant_field_access: identifier DOT label;
constant_value: constant_tuple | constant_list | constant_bit_string | constant_record | identifier | constant_field_access | expression_literal;
constant
    : (visibility_modifier)? CONST NAME (constant_type_annotation)? EQUAL constant_value
    ;

type_parameters: LEFT_PAREN (type_parameter (COMMA type_parameter)* (COMMA)?)? RIGHT_PAREN;
type_name: (type_identifier | remote_type_identifier) (type_parameters)?  ;
external_type: (visibility_modifier)? EXTERNAL TYPE type_name;

function_parameter_types : LEFT_PAREN (type_base (COMMA type_base)* (COMMA)?)? RIGHT_PAREN;
tuple_type: HASH LEFT_PAREN (type_base (COMMA type_base)* (COMMA)?)? RIGHT_PAREN;
function_type: FN (function_parameter_types)? R_ARROW type_base;

type_base: type_hole | tuple_type | function_type | type | type_var;
type_annotation: COLON type_base;
type_argument: type_base;
type_arguments: LEFT_PAREN (type_argument (COMMA type_argument)* (COMMA)?)? RIGHT_PAREN;
type: (type_identifier | remote_type_identifier) (type_arguments)?;

external_function_body: STRING STRING;
external_function_parameter: (identifier COLON)? type_base;
external_function_parameters: LEFT_PAREN (external_function_parameter (COMMA external_function_parameter)* (COMMA)?)? RIGHT_PAREN;
external_function: (visibility_modifier)? EXTERNAL FN identifier external_function_parameters R_ARROW type_base EQUAL external_function_body;

function_parameter_args: labeled_discard_param | discard_param | labeled_name_param | name_param;
function_parameter: function_parameter_args (type_annotation)?;
function_parameters: LEFT_PAREN (function_parameter (COMMA function_parameter)* (COMMA)?)? RIGHT_PAREN;
function_body: LEFT_BRACE (expression_seq)? RIGHT_BRACE;
function: (visibility_modifier)? FN identifier function_parameters (R_ARROW type_base)? function_body;

list_pattern_tail: DOT_DOT (identifier | discard)?;
list_pattern: LEFT_SQUARE (pattern (COMMA pattern)* (COMMA)?)? (list_pattern_tail)? RIGHT_SQUARE;

pattern_bit_string_segment: pattern (COLON bit_string_segment_options)?;
pattern_bit_string: LT_LT (pattern_bit_string_segment (COMMA pattern_bit_string_segment)* (COMMA)?)? GT_GT;

tuple_pattern: HASH LEFT_PAREN (pattern (COMMA pattern)* (COMMA)?)? RIGHT_PAREN;
pattern_spread: (DOT_DOT (COMMA)?);
record_pattern_argument: (label COLON)? pattern;
record_pattern_arguments: LEFT_PAREN (record_pattern_argument (COMMA record_pattern_argument)* (COMMA)?)? (pattern_spread)? RIGHT_PAREN;
record_pattern: (constructor_name | remote_constructor_name) (record_pattern_arguments)?;
pattern: (identifier | discard | record_pattern | expression_literal | tuple_pattern | pattern_bit_string | list_pattern) (AS identifier)?;

try: TRY pattern (type_annotation)? EQUAL expression;
expression_seq: (expression | try)+;

argument: (label ':')? (hole | expression);
arguments: LEFT_PAREN (argument (COMMA argument)* (COMMA)?)? RIGHT_PAREN;
record: (constructor_name | remote_constructor_name) (arguments)?;

expression_bit_string_segment: expression_unit (COLON bit_string_segment_options)?;
expression_bit_string: LT_LT (expression_bit_string_segment (COMMA expression_bit_string_segment)* (COMMA)?)? GT_GT;

todo: TODO (LEFT_PAREN STRING RIGHT_PAREN)?;
tuple: HASH LEFT_PAREN (expression (COMMA expression)* (COMMA)?)? RIGHT_PAREN;
list: LEFT_SQUARE (expression ((COMMA expression)*)? (COMMA)? ('..' expression)?)? RIGHT_SQUARE;

anonymous_function_parameter_args: discard_param | name_param;
anonymous_function_parameter: anonymous_function_parameter_args (type_annotation)?;
anonymous_function_parameters: LEFT_PAREN (anonymous_function_parameter (COMMA anonymous_function_parameter)* (COMMA)?)? RIGHT_PAREN;
anonymous_function: FN anonymous_function_parameters (R_ARROW type)? function_body;

expression_group: LEFT_BRACE expression_seq RIGHT_BRACE;

case_clause_tuple_access: identifier DOT INTEGER;
case_clause_guard_unit: identifier | case_clause_tuple_access | LEFT_BRACE case_clause_guard_expression RIGHT_BRACE | constant_value;
case_clause_guard_binary_operator: VBAR_VBAR | AMPER_AMPER | EQUAL_EQUAL | NOT_EQUAL | LESS | LESS_EQUAL | LESS_DOT
    | LESS_EQUAL_DOT | GREATER | GREATER_EQUAL | GREATER_DOT | GREATER_EQUAL_DOT;
case_clause_guard_expression
    : case_clause_guard_expression case_clause_guard_binary_operator case_clause_guard_expression
    | case_clause_guard_unit;
case_clause_guard: IF case_clause_guard_expression;
case_clause_pattern: pattern (COMMA pattern)*  (COMMA)?;
case_clause_patterns: case_clause_pattern (VBAR case_clause_pattern)* (VBAR)?;
case_clause: case_clause_patterns (case_clause_guard)? R_ARROW expression;
case_clauses: (case_clause)+;
case_subjects: expression_seq;
case: CASE case_subjects LEFT_BRACE case_clauses RIGHT_BRACE;

use_args: identifier | identifier COMMA use_args;
use: USE (use_args)? L_ARROW expression;

assignment: pattern (type_annotation)? EQUAL expression;
let: LET assignment;
assert: ASSERT assignment;
negation: BANG expression_unit;

record_update_argument: label COLON expression;
record_update_arguments: record_update_argument (COMMA record_update_argument)* (COMMA)?;
record_update: (constructor_name | remote_constructor_name) LEFT_PAREN DOT_DOT expression COMMA record_update_arguments RIGHT_PAREN;

call_or_access_options: arguments | (DOT label) | (DOT INTEGER);
// this deviates from the treesitter spec - it is function_call + field_access + tuple_access all in one rule to avoid indirect left recursion
call_or_access
     : call_or_access   call_or_access_options
     | case             call_or_access_options
     | identifier       call_or_access_options
     | expression_group call_or_access_options
     | record DOT label
     | record_update DOT label
     | tuple DOT INTEGER
     | anonymous_function arguments
     ;

expression_literal: STRING | INTEGER | FLOAT | TRUE | FALSE;
expression_unit
    : record
    | anonymous_function
    | identifier
    | todo
    | tuple
    | list
    | expression_bit_string
    | expression_group
    | case
    | let
    | use
    | assert
    | negation
    | record_update
    | call_or_access
    | expression_literal
    ;

expression
    : expression_unit #unit
    | left=expression EQUAL_EQUAL right=expression #eq
    | left=expression NOT_EQUAL right=expression #neq
    | left=expression LESS right=expression #lt
    | left=expression LESS_EQUAL right=expression #lte
    | left=expression LESS_DOT right=expression #ltf
    | left=expression LESS_EQUAL_DOT right=expression #ltef
    | left=expression GREATER right=expression #gt
    | left=expression GREATER_EQUAL right=expression #gte
    | left=expression GREATER_DOT right=expression #gtf
    | left=expression GREATER_EQUAL_DOT right=expression #gtef
    | left=expression LT_GT right=expression #ltgt
    | left=expression PIPE right=expression #pipe
    | left=expression PLUS right=expression #plus
    | left=expression PLUS_DOT right=expression #plusf
    | left=expression MINUS right=expression #minus
    | left=expression MINUS_DOT right=expression #minusf
    | left=expression STAR right=expression #star
    | left=expression STAR_DOT right=expression #starf
    | left=expression SLASH right=expression #slash
    | left=expression SLASH_DOT right=expression #slashf
    | left=expression PERCENT right=expression #percent
    | left=expression AMPER_AMPER right=expression #and
    | left=expression VBAR_VBAR right=expression #or
    ;

data_constructor_argument: (label COLON)? type_base;
data_constructor_arguments: LEFT_PAREN (data_constructor_argument (COMMA data_constructor_argument)* (COMMA)?)? RIGHT_PAREN;
data_constructor: constructor_name (data_constructor_arguments)?;
data_constructors: (data_constructor)+;

type_definition: (visibility_modifier)? (opacity_modifier)? TYPE type_name LEFT_BRACE data_constructors RIGHT_BRACE;
type_alias: (visibility_modifier)? (opacity_modifier)? TYPE type_name EQUAL type;

statement
    : imports
    | constant
    | external_type
    | external_function
    | function
    | type_definition
    | type_alias
    ;

///// Aliases (maybe not needed by why not have them for now and we can delete later
identifier: NAME;
constructor_name: UP_NAME;
type_identifier: UP_NAME;
discard: DISCARD_NAME;
label: NAME;
type_parameter: NAME;
type_var: NAME;
type_hole: NAME;
hole: DISCARD_NAME;
discard_param: discard;
name_param: identifier;
labeled_name_param: label identifier;
labeled_discard_param: label discard;
remote_constructor_name: identifier DOT constructor_name;
remote_type_identifier: identifier DOT type_identifier;
visibility_modifier: PUB;
opacity_modifier: OPAQUE;

// Keywords
AS: 'as';
ASSERT: 'assert';
CASE: 'case';
CONST: 'const';
EXTERNAL: 'external';
FN: 'fn';
IF: 'if';
IMPORT: 'import';
LET: 'let';
OPAQUE: 'opaque';
PUB: 'pub';
TODO: 'todo';
TRY: 'try';
TYPE: 'type';
USE: 'use';

// Unofficial Tokens
TRUE: 'True';
FALSE: 'False';

// Groupings
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_SQUARE: '[';
RIGHT_SQUARE: ']';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';

// Operators
// Int
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
LESS: '<';
GREATER: '>';
LESS_EQUAL: '<=';
GREATER_EQUAL: '>=';
PERCENT: '%';
// Float
PLUS_DOT: '+.';
MINUS_DOT: '-.';
STAR_DOT: '*.';
SLASH_DOT: '/.';
LESS_DOT: '<.';
GREATER_DOT: '>.';
LESS_EQUAL_DOT: '<=.';
GREATER_EQUAL_DOT: '>=.';
// String
LT_GT: '<>';

// Other Punctuation
COLON: ':';
COMMA: ',';
HASH: '#';
BANG: '!';
EQUAL: '=';
EQUAL_EQUAL: '==';
NOT_EQUAL: '!=';
VBAR: '|';
VBAR_VBAR: '||';
AMPER_AMPER: '&&';
LT_LT: '<<';
GT_GT: '>>';
PIPE: '|>';
DOT: '.';
R_ARROW: '->';
L_ARROW: '<-';
DOT_DOT: '..';
END_OF_FILE: 'EOF';

// Extra
COMMENT_NORMAL: '//'    .*? ('\n'|EOF)  -> channel(HIDDEN) ;
COMMENT_DOC:    '///'   .*? ('\n'|EOF)	-> channel(HIDDEN) ;
COMMENT_MODULE: '////'  .*? ('\n'|EOF)	-> channel(HIDDEN) ;

// Identifiers
NAME: [a-z_][_0-9a-z]*;
UP_NAME: [A-Z][0-9a-zA-Z]*;
DISCARD_NAME: '_'[_0-9a-z]*;
ID: NAME | UP_NAME | DISCARD_NAME;

// Literals
INTEGER: '-'? (BINARY | HEX | OCTAL | DECIMAL);
DECIMAL:    [0-9][0-9_]*;
BINARY:  '0'[bB][0-1_]+;
HEX:     '0'[xX][0-9a-fA-F_]+;
OCTAL:   '0'[oO][0-7_]+;

FLOAT
    :   '-'? DECIMAL '.' [0-9_]+ DECIMAL?   // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? DECIMAL '.'
    |   '-'? DECIMAL EXP                    // 1e10 -3e4
    ;
    fragment EXP: [Ee] [+\-]? DECIMAL;

STRING: '"' (ESC | ~["\\])* '"' ;
    fragment ESC: '\\' ["\bfnrt] ;

WHITESPACE: [ \t\n\r]+ -> channel(HIDDEN) ;

/** "catch all" rule for any char not matche in a token rule of your
 *  grammar. Lexers in Intellij must return all tokens good and bad.
 *  There must be a token to cover all characters, which makes sense, for
 *  an IDE. The parser however should not see these bad tokens because
 *  it just confuses the issue. Hence, the hidden channel.
 */
ERRCHAR
    :	.	-> channel(HIDDEN)
    ;