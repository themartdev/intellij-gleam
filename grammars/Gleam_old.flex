package com.github.themartdev.intellijgleam.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.SimpleTypes;
import com.intellij.psi.TokenType;


import static org.intellij.prisma.lang.psi.PrismaElementTypes.*;

%%

%public
%class _GleamLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{
    return;
%eof}

%{
  StringBuffer buffer = new StringBuffer();
%}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
STRING_LITERAL=\"([^\\\"]|\\.)*\"

IMPORT="import"
PUB="pub"
FN="fn"
LPAREN="("
RPAREN=")"
LBRACE="{"
RBRACE="}"
LBRACKET="["
RBRACKET="]"
COMMA=","
DOT="."

%state WAITING_VALUE

%%

<YYINITIAL> {
  {IMPORT}                { return GleamTypes.IMPORT; }
  {PUB}                   { return GleamTypes.PUB; }
  {FN}                    { return GleamTypes.FN; }
  {LPAREN}                { return GleamTypes.LPAREN; }
  {RPAREN}                { return GleamTypes.RPAREN; }
  {LBRACE}                { return GleamTypes.LBRACE; }
  {RBRACE}                { return GleamTypes.RBRACE; }
  {LBRACKET}              { return GleamTypes.LBRACKET; }
  {RBRACKET}              { return GleamTypes.RBRACKET; }
  {COMMA}                 { return GleamTypes.COMMA; }
  {DOT}                   { return GleamTypes.DOT; }

  {IDENTIFIER}            { return GleamTypes.IDENTIFIER; }
  {STRING_LITERAL}        { return GleamTypes.STRING_LITERAL; }

  {WHITE_SPACE}+          { return TokenType.WHITE_SPACE; }
}

[^] { return TokenType.BAD_CHARACTER; }