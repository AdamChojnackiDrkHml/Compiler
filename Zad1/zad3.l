
%{

#include "zad3.tab.h"

%}

%x COMMENT
%option noyywrap
%%
^#                              BEGIN(COMMENT);
\\\n                            ;
[ \t]+                          ;
<COMMENT>{
    .|\\\n                      ;
    \n                          BEGIN(INITIAL);
}
\n                              return NEWLINE;
[0-9]+                          { yylval = atoi(yytext); return NUM; }
\+                              return PLUS;
\-                              return MINUS;
\*                              return MULT;
\/                              return DIV;
\%                              return MOD;
\^                              return PWR;
\(                              return LBRACKET;
\)                              return RBRACKET;
.                               ;
%%