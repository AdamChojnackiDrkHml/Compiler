// Calc.g4
grammar zad2;

// Tokens
COMMENT: '#';
ENDLINE: [\n];
BACKSLASH: '\\';
WHITESPACE: [ \r\t];
CHARACTERS: [a-zA-Z]+;
LBRACKET: '(';
RBRACKET: ')';
PWR: '^';
MUL: '*';
DIV: '/';
MOD: '%';
ADD: '+';
SUB: '-';
NUMBER: [0-9]+;






// Rules
dupa
   : dupa line
   | EOF?;

line
    : ENDLINE #Nothing
    | COMMENT comment #Commentary
    | expression ENDLINE #Print
    ;

comment
    : BACKSLASH ENDLINE|EOF comment
    | (CHARACTERS|NUMBER|PWR|ADD|SUB|DIV|MUL|COMMENT|LBRACKET|RBRACKET|WHITESPACE) comment
    | ENDLINE
    ;

expression
    : operator=SUB? NUMBER #Numer
    | LBRACKET inner=expression RBRACKET #Parentheses
    | left=afterpwr operator=PWR right=afterpwr #Pwr
    | left=expression operator=(MUL|DIV) right=expression # MulDiv
    | left=expression operator=(ADD|SUB) right=expression # AddSub
    ;

afterpwr
    : operator=SUB? NUMBER #APwrNumer
    | LBRACKET inner=afterpwr RBRACKET #APwrParentheses
    | left=afterpwr operator=(MUL|DIV) right=afterpwr # APwrMulDiv
    | left=afterpwr operator=(ADD|SUB) right=afterpwr # APwrAddSub
    ;
