grammar WhileLanguage;

program
        : axiom_statement* function_declaration* main
        ;

function_declaration
        : type IDENT '(' parameter_list? ')' function_body
        ;

main
        : 'main' '(' parameter_list? ')' main_body
        ;

parameter_list
        : parameter ( ',' parameter )*
        ;

parameter
        : type IDENT
        ;

function_body
        : assume_statement? '{' statement* return_statement '}' ensure_statement?
        ;


main_body
        : assume_statement? '{' statement* '}' ensure_statement?
        ;

if_body
        : '{' statement* '}'
        ;

loop_body
        : invariant_statement? '{' statement* '}' ensure_statement?
        ;

statement
        : e1=assert_statement
        | e2=variable_declaration
        | e3=array_declaration
        | e4=assignment
        | e5=if_statement
        | e6=while_statement
        ;

invariant_statement
        : 'invariant' quantified_expression ';'
        | 'invariant' '{' ( quantified_expression ';' )+ '}'
        ;

axiom_statement
        : 'axiom' quantified_expression ';'
        ;

assert_statement
        : 'assert' quantified_expression ';'
        ;

assume_statement
        : 'assume' quantified_expression ';'
        | 'assume' '{' ( quantified_expression ';' )+ '}'
        ;

ensure_statement
       	: 'ensure' equantified_expression ';'
        | 'ensure' '{' ( quantified_expression ';' )+ '}'
        ;

assignment
        : IDENT '=' expression ';'
        | IDENT ( '[' expression ']' )+ '=' expression ';'
        ;

variable_declaration
        : type IDENT ( '=' expression )? ';'
        ;

array_declaration
        : type IDENT '=' array_init ';'
        ;

array_init
	: 'array' ( '[' expression ']' )+
	;

if_statement
        : 'if' '(' expression ')' if_body ( 'else' if_body )?
        ;

while_statement
        : 'while' '(' expression ')' loop_body
        ;

return_statement
	: 'return' expression ';'
	;

quantified_expression
        : QUANTIFIER IDENT '(' range? ')' quantified_expression
        | expression
        ;

range
        : expression ',' expression
        ;

expression
        : rel_expression ( '==' rel_expression | '!=' rel_expression )*
        ;


rel_expression
        : add_expression ( '<' add_expression | '<=' add_expression | '>'  add_expression | '>=' add_expression )*
        ;

add_expression
        : mul_expression ( '|' mul_expression  | '+' mul_expression | '-' mul_expression )*
        ;

mul_expression
        : unary_expression ( '&' unary_expression | '*' unary_expression  | '/' unary_expression | '%' unary_expression )*
        ;

unary_expression
        : '!' parenthesized_expression
        | '-'  parenthesized_expression
        | '+'? parenthesized_expression
        ;

parenthesized_expression
        : '(' expression ')'
        | function_call
        | array_read
        | IDENT
        | literal_expression
        ;

function_call
        : IDENT '(' arglist? ')'
        ;

arglist
        : expression ( ',' expression )*
        ;

array_read
        : IDENT '[' expression ']' ( '[' expression ']' )*
        ;

literal_expression
        : INT_LITERAL
        | BOOL_LITERAL
        ;

type returns [ Type ast ]
        : ('int' | 'bool' ) ( '[' ']' )*
        ;

INT_LITERAL  : ( '0'..'9' )+;
BOOL_LITERAL : 'true' | 'false';
QUANTIFIER
        : 'forall'
        | 'exists'
        ;
COMMENT      : '#' .* ( '\n' | '\r' ) {skip();};
WS           : ('\n' | '\r' | ' ' | '\t')+ {skip();};
IDENT        : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
