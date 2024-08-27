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
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
WHITE_SPACE=[ \t\n\x0B\f\r]+
MODULE_COMMENT="////".*
FUNCTION_COMMENT="///".*
LINE_COMMENT="//".*

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  "{"                      { return LBRACE; }
  "}"                      { return RBRACE; }
  "("                      { return LPAREN; }
  ")"                      { return RPAREN; }
  "["                      { return LBRACK; }
  "]"                      { return RBRACK; }
  "import"                 { return IMPORT; }
  "as"                     { return AS; }
  "pub"                    { return PUB; }
  "fn"                     { return FN; }
  "."                      { return DOT; }
  ","                      { return COMMA; }

  {STRING_LITERAL}         { return STRING_LITERAL; }
  {IDENTIFIER}             { return IDENTIFIER; }
  {WHITE_SPACE}            { return WHITE_SPACE; }
  {MODULE_COMMENT}         { return MODULE_COMMENT; }
  {FUNCTION_COMMENT}       { return FUNCTION_COMMENT; }
  {LINE_COMMENT}           { return LINE_COMMENT; }

}

[^] { return BAD_CHARACTER; }
