package com.github.themartdev.intellijgleam.lang.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.themartdev.intellijgleam.lang.psi.GleamElementTypes.*;

%%

%{
  public _GleamLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _GleamLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

STRING_LITERAL=\"([^\"\\]|\\.)*\"
INTEGER_LITERAL=-?(0[bB][0-1_]+|0[xX][0-9a-fA-F_]+|0[oO][0-7_]+|[0-9][0-9_]*)
FLOAT_LITERAL=-?([0-9][0-9_]*\.[0-9_]+[0-9]*([Ee][+\-]?[0-9]+)?|[0-9][0-9_]*[Ee][+\-]?[0-9]+)
BOOLEAN_LITERAL=True|False
DISCARD_NAME=_[_0-9a-z]*
UP_IDENTIFIER=[A-Z][a-zA-Z0-9_]*
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
MODULE_COMMENT="////"[^\n]*
FUNCTION_COMMENT="///"[^\n]*
LINE_COMMENT="//"[^\n]*
WHITE_SPACE=[ \t\n\x0B\f\r]+

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  "as"                     { return AS; }
  "assert"                 { return ASSERT; }
  "auto"                   { return AUTO; }
  "case"                   { return CASE; }
  "const"                  { return CONST; }
  "delegate"               { return DELEGATE; }
  "derive"                 { return DERIVE; }
  "echo"                   { return ECHO; }
  "else"                   { return ELSE; }
  "external"               { return EXTERNAL; }
  "fn"                     { return FN; }
  "if"                     { return IF; }
  "implement"              { return IMPLEMENT; }
  "import"                 { return IMPORT; }
  "let"                    { return LET; }
  "macro"                  { return MACRO; }
  "opaque"                 { return OPAQUE; }
  "panic"                  { return PANIC; }
  "pub"                    { return PUB; }
  "test"                   { return TEST; }
  "todo"                   { return TODO; }
  "try"                    { return TRY; }
  "type"                   { return TYPE; }
  "use"                    { return USE; }
  "{"                      { return LBRACE; }
  "}"                      { return RBRACE; }
  "("                      { return LPAREN; }
  ")"                      { return RPAREN; }
  "["                      { return LBRACK; }
  "]"                      { return RBRACK; }
  "."                      { return DOT; }
  ","                      { return COMMA; }
  ":"                      { return COLON; }
  "#"                      { return HASH; }
  "!"                      { return BANG; }
  "="                      { return EQUAL; }
  "=="                     { return EQUAL_EQUAL; }
  "!="                     { return NOT_EQUAL; }
  "|"                      { return VBAR; }
  "||"                     { return VBAR_VBAR; }
  "&&"                     { return AMPER_AMPER; }
  "<<"                     { return LT_LT; }
  ">>"                     { return GT_GT; }
  "|>"                     { return PIPE; }
  "->"                     { return R_ARROW; }
  "<-"                     { return L_ARROW; }
  ".."                     { return DOT_DOT; }
  "+"                      { return PLUS; }
  "-"                      { return MINUS; }
  "*"                      { return STAR; }
  "/"                      { return SLASH; }
  "<"                      { return LESS; }
  ">"                      { return GREATER; }
  "<="                     { return LESS_EQUAL; }
  ">="                     { return GREATER_EQUAL; }
  "%"                      { return PERCENT; }
  "+."                     { return PLUS_DOT; }
  "-."                     { return MINUS_DOT; }
  "*."                     { return STAR_DOT; }
  "/."                     { return SLASH_DOT; }
  "<."                     { return LESS_DOT; }
  ">."                     { return GREATER_DOT; }
  "<=."                    { return LESS_EQUAL_DOT; }
  ">=."                    { return GREATER_EQUAL_DOT; }
  "<>"                     { return LT_GT; }

  {STRING_LITERAL}         { return STRING_LITERAL; }
  {INTEGER_LITERAL}        { return INTEGER_LITERAL; }
  {FLOAT_LITERAL}          { return FLOAT_LITERAL; }
  {BOOLEAN_LITERAL}        { return BOOLEAN_LITERAL; }
  {DISCARD_NAME}           { return DISCARD_NAME; }
  {UP_IDENTIFIER}          { return UP_IDENTIFIER; }
  {IDENTIFIER}             { return IDENTIFIER; }
  {MODULE_COMMENT}         { return MODULE_COMMENT; }
  {FUNCTION_COMMENT}       { return FUNCTION_COMMENT; }
  {LINE_COMMENT}           { return LINE_COMMENT; }
  {WHITE_SPACE}            { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
