%{
#include <stdio.h>
#include <math.h>

#include"utils.h"

extern int yylineno;

int err = 0;
char* default_err = "invalid syntax";
char* err_msg = "invalid syntax";
int yylex();
void yyerror(const char *s);

%}

%token NUM
%token NEWLINE
%left PLUS MINUS
%left MULT MOD DIV
%token LBRACKET
%token RBRACKET
%right PWR
%precedence NEG

%%
input:
    %empty
    | input line
;

line:
    NEWLINE
    | expr NEWLINE   {
                        if(!err) {
                            printf("\nResult: %d \n", $1);
                        } else {
                            printf("\n");
                        }
                    }
    | error NEWLINE 
;

expr:
    NUM                         { $$ = converge($1); printf(" %d ", $1);}
    | expr PLUS expr            { $$ = add(converge($1), converge($3)); printf(" + ");}
    | expr MINUS expr           { $$ = substract(converge($1), converge($3)); printf(" - "); }
    | expr MULT expr            { $$ = multiply(converge($1), converge($3)); printf(" * ");}
    | expr DIV expr             { 
                                    if($3 == 0) {
                                        err_msg = "dividing by 0 is not allowed";
                                        yyerror("");
                                    } else {
                                        $$ = divide(converge($1), converge($3));
                                    }
                                     printf(" / ");
                                }
    | expr MOD expr             {
                                    if(converge($3) == 0) {
                                        err_msg = "dividing by 0 is not allowed";
                                        yyerror("");
                                    } else {
                                        $$ = modulo(converge($1), converge($3));
                                    }
                                     printf(" % ");
                                }
    | MINUS expr %prec NEG      { $$ = neg(converge($2));  printf(" - ");}
    | expr PWR expr             {
                                    if(converge($3) < 0) {
                                        err_msg = "negative exponent is not allowed";
                                        yyerror("");
                                    } else {
                                        $$ = power(converge($1), converge($3));
                                    }
                                     printf(" ^ ");
                                }
    | LBRACKET expr RBRACKET   { $$ = $2; }
;
%%

void yyerror(const char *s) {
    err = 1;
    printf("\033[0;31mError: %s \033[0;0m", err_msg);
    err_msg = default_err;
    return;
}

int main() {
    return yyparse();
}