package com.github.themartdev.intellijgleam.lang.parser;

import java.util.*;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.github.themartdev.intellijgleam.lang.psi.GleamTypes;

%%

%{
  private static final class State {
    final int state;

    private State(int state) {
      this.state = state;
    }

    @Override
    public String toString() {
      return "yystate = " + state;
    }
  }

  protected final Stack<State> myStateStack = new Stack<>();

  private void pushState(int state) {
    myStateStack.push(new State(yystate()));
    yybegin(state);
  }

  private void popState() {
    State state = myStateStack.pop();
    yybegin(state.state);
  }

  private void handleInLastState() {
    yypushback(yylength());
    popState();
  }

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

EOL = \n|\r\n


HEXADECIMAL_DIGIT = [A-Fa-f0-9]
INTEGER_LITERAL=-?(0[bB][0-1_]+|0[xX][0-9a-fA-F_]+|0[oO][0-7_]+|[0-9][0-9_]*)
FLOAT_LITERAL=-?([0-9][0-9_]*\.[0-9_]+[0-9]*([Ee][+\-]?[0-9]+)?|[0-9][0-9_]*[Ee][+\-]?[0-9]+)
BOOLEAN_LITERAL=True|False
DISCARD_NAME=_[_0-9a-z]*
UP_IDENTIFIER=[A-Z][a-zA-Z0-9_]*
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
MODULE_COMMENT="////"[^\n]*
FUNCTION_COMMENT="///"[^\n]*
LINE_COMMENT="//"[^\n]*
WHITE_SPACE=[ \r\n\t\f]+
ANY=[^]

%state IN_STRING
%state ESCAPE_SEQUENCE
%state UNICODE_ESCAPE_SEQUENCE
%state UNICODE_CODEPOINT_SEQUENCE

%%
<YYINITIAL> {
  // Reserved keywords
  "as"                     { return GleamTypes.AS; }
  "assert"                 { return GleamTypes.ASSERT; }
  "auto"                   { return GleamTypes.AUTO; }
  "case"                   { return GleamTypes.CASE; }
  "const"                  { return GleamTypes.CONST; }
  "delegate"               { return GleamTypes.DELEGATE; }
  "derive"                 { return GleamTypes.DERIVE; }
  "echo"                   { return GleamTypes.ECHO; }
  "else"                   { return GleamTypes.ELSE; }
  "external"               { return GleamTypes.EXTERNAL; }
  "fn"                     { return GleamTypes.FN; }
  "if"                     { return GleamTypes.IF; }
  "implement"              { return GleamTypes.IMPLEMENT; }
  "import"                 { return GleamTypes.IMPORT; }
  "let"                    { return GleamTypes.LET; }
  "macro"                  { return GleamTypes.MACRO; }
  "opaque"                 { return GleamTypes.OPAQUE; }
  "panic"                  { return GleamTypes.PANIC; }
  "pub"                    { return GleamTypes.PUB; }
  "test"                   { return GleamTypes.TEST; }
  "todo"                   { return GleamTypes.TODO; }
  "try"                    { return GleamTypes.TRY; }
  "type"                   { return GleamTypes.TYPE; }
  "use"                    { return GleamTypes.USE; }

  "{"                      { return GleamTypes.LBRACE; }
  "}"                      { return GleamTypes.RBRACE; }
  "("                      { return GleamTypes.LPAREN; }
  ")"                      { return GleamTypes.RPAREN; }
  "["                      { return GleamTypes.LBRACK; }
  "]"                      { return GleamTypes.RBRACK; }
  "."                      { return GleamTypes.DOT; }
  ","                      { return GleamTypes.COMMA; }
  ":"                      { return GleamTypes.COLON; }
  "#"                      { return GleamTypes.HASH; }
  "!"                      { return GleamTypes.BANG; }
  "="                      { return GleamTypes.EQUAL; }
  "=="                     { return GleamTypes.EQUAL_EQUAL; }
  "!="                     { return GleamTypes.NOT_EQUAL; }
  "|"                      { return GleamTypes.VBAR; }
  "||"                     { return GleamTypes.VBAR_VBAR; }
  "&&"                     { return GleamTypes.AMPER_AMPER; }
  "<<"                     { return GleamTypes.LT_LT; }
  ">>"                     { return GleamTypes.GT_GT; }
  "|>"                     { return GleamTypes.PIPE; }
  "->"                     { return GleamTypes.R_ARROW; }
  "<-"                     { return GleamTypes.L_ARROW; }
  ".."                     { return GleamTypes.DOT_DOT; }
  "+"                      { return GleamTypes.PLUS; }
  "-"                      { return GleamTypes.MINUS; }
  "*"                      { return GleamTypes.STAR; }
  "/"                      { return GleamTypes.SLASH; }
  "<"                      { return GleamTypes.LESS; }
  ">"                      { return GleamTypes.GREATER; }
  "<="                     { return GleamTypes.LESS_EQUAL; }
  ">="                     { return GleamTypes.GREATER_EQUAL; }
  "%"                      { return GleamTypes.PERCENT; }
  "+."                     { return GleamTypes.PLUS_DOT; }
  "-."                     { return GleamTypes.MINUS_DOT; }
  "*."                     { return GleamTypes.STAR_DOT; }
  "/."                     { return GleamTypes.SLASH_DOT; }
  "<."                     { return GleamTypes.LESS_DOT; }
  ">."                     { return GleamTypes.GREATER_DOT; }
  "<=."                    { return GleamTypes.LESS_EQUAL_DOT; }
  ">=."                    { return GleamTypes.GREATER_EQUAL_DOT; }
  "<>"                     { return GleamTypes.LT_GT; }

  // Strings
  \"                       { pushState(IN_STRING); return GleamTypes.OPEN_QUOTE; }

  {INTEGER_LITERAL}        { return GleamTypes.INTEGER_LITERAL; }
  {FLOAT_LITERAL}          { return GleamTypes.FLOAT_LITERAL; }
  {BOOLEAN_LITERAL}        { return GleamTypes.BOOLEAN_LITERAL; }
  {DISCARD_NAME}           { return GleamTypes.DISCARD_NAME; }
  {UP_IDENTIFIER}          { return GleamTypes.UP_IDENTIFIER; }
  {IDENTIFIER}             { return GleamTypes.IDENTIFIER; }
  {MODULE_COMMENT}         { return GleamTypes.MODULE_COMMENT; }
  {FUNCTION_COMMENT}       { return GleamTypes.FUNCTION_COMMENT; }
  {LINE_COMMENT}           { return GleamTypes.LINE_COMMENT; }
  {WHITE_SPACE}            { return TokenType.WHITE_SPACE; }
}

<IN_STRING> {
  ([^\\\"])*  { return GleamTypes.REGULAR_STRING_PART; }
  \\           { pushState(ESCAPE_SEQUENCE); return GleamTypes.ESCAPE; }
  \"           { popState(); return GleamTypes.CLOSE_QUOTE; }
}

<ESCAPE_SEQUENCE> {
  {EOL}        { popState(); return GleamTypes.EOL; }
  "u"          { yybegin(UNICODE_ESCAPE_SEQUENCE); return GleamTypes.UNICODE_ESCAPE_CHAR; }
  .            { popState(); return GleamTypes.ESCAPE_CHAR; }
}

<UNICODE_ESCAPE_SEQUENCE> {
  "{"          { yybegin(UNICODE_CODEPOINT_SEQUENCE); return GleamTypes.LBRACE; }
  .            { popState(); return TokenType.BAD_CHARACTER; }
}

<UNICODE_CODEPOINT_SEQUENCE> {
  "}"                         { popState(); return GleamTypes.RBRACE; }
  {HEXADECIMAL_DIGIT}{1,6}    { return GleamTypes.UNICODE_CODEPOINT; }
  {ANY}                       { return TokenType.BAD_CHARACTER; }
}

[^] { return TokenType.BAD_CHARACTER; }
