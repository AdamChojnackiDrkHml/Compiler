%{
#include <stdio.h>
#include <math.h>

#include"utils.h"

extern int yylineno;
int N = 1234577;
int err = 0;
char* default_err = "invalid syntax";
char* err_msg = "invalid syntax";
int yylex();
void yyerror(const char *s);
int resHolder = 0;
%}

%token NUM
%token NEWLINE
%left PLUS MINUS
%left MULT DIV
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
    NUM                         { $$ = converge($1, N); printf(" %d ", $1);}
    | expr PLUS expr            { $$ = add(converge($1, N), converge($3, N), N); printf(" + ");}
    | expr MINUS expr           { $$ = substract(converge($1, N), converge($3, N), N); printf(" - "); }
    | expr MULT expr            { $$ = multiply(converge($1, N), converge($3, N), N); printf(" * ");}
    | expr DIV expr             { 
                                    if((resHolder = divide(converge($1, N), converge($3, N), N)) == -1) {
                                        err_msg = "dividing is not allowed";
                                        yyerror("");
                                    } else {
                                        $$ = resHolder;
                                    }
                                    printf(" / ");
                                }
    | MINUS expr %prec NEG      { $$ = neg($2, N);  printf(" - ");}
    | expr PWR afterpwr             {
                                    if(converge($3, N) < 0) {
                                        err_msg = "negative exponent is not allowed";
                                        yyerror("");
                                    } else {
                                        $$ = power(converge($1, N), converge($3, N), N);
                                    }
                                     printf(" ^ ");
                                }
    | LBRACKET expr RBRACKET   { $$ = $2; }
;


afterpwr:
    NUM                         { $$ = converge($1, N-1); printf(" %d ", $1);}
    | afterpwr PLUS afterpwr            { $$ = add(converge($1, N-1), converge($3, N-1), N); printf(" + ");}
    | afterpwr MINUS afterpwr           { $$ = substract(converge($1, N-1), converge($3, N-1), N-1); printf(" - "); }
    | afterpwr MULT afterpwr            { $$ = multiply(converge($1, N-1), converge($3, N-1), N-1); printf(" * ");}
    | afterpwr DIV afterpwr     { 
                                    if((resHolder = divide(converge($1, N-1), converge($3, N-1), N-1)) == -1) {
                                        err_msg = "dividing is not allowed";
                                        yyerror("");
                                    } else {
                                        $$ = resHolder;
                                    }
                                    printf(" / ");
                                }
    | MINUS afterpwr %prec NEG      { $$ = neg($2, N-1);  printf(" - ");}

    | LBRACKET afterpwr RBRACKET   { $$ = $2; }
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