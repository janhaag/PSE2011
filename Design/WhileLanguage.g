grammar WhileLanguage;

program
        : assume_statement* method_declaration* main_method
        ;

method_declaration
        : type IDENT '(' parameter_list? ')' method_body
        ;

main_method
        : 'main' '(' parameter_list? ')' method_body
        ;

parameter_list
        : parameter ( ',' parameter )*
        ;

parameter
        : type IDENT
        ;

method_body
        : '{' assume_statement* statement* ensure_statement* '}'
        ;

statement
        : assert_statement
        | variable_declaration
        | array_declaration
        | assignment
        | if_statement
        | while_statement
        | 'return' expression ';'
        ;

invariant_statement
        : 'invariant' expression ';'
        ;

assert_statement
        : 'assert' expression ';'
        ;

assume_statement
        : 'assume' expression ';'
        ;

ensure_statement
        : 'ensure' expression ';'
        ;

assignment
        : IDENT ( '[' expression ']' )* '=' expression ';'
        ;

variable_declaration
        : type IDENT ( '=' expression )? ';'
        ;

array_declaration
        : type IDENT ( '[' ']' )+ ';'
        ;

if_statement
        : 'if' '(' expression ')' statement_block ( 'else' statement_block )?
        ;

statement_block
        : '{' statement* '}'
        ;

while_statement
        : 'while' '(' expression ')' loop_body
        ;

loop_body
        : '{' invariant_statement* statement* ensure_statement* '}'
        ;

expression
        : rel_expression ( ( '==' | '!=' ) rel_expression )*
        ;


rel_expression
        : add_expression ( ( '<' | '<=' | '>' | '>=' ) add_expression )*
        ;

add_expression
        : mul_expression ( ( '|' | '+' | '-' ) mul_expression )*
        ;

mul_expression
        : unary_expression ( ('&' | '*' | '/' | '%') unary_expression )*
        ;

unary_expression
        : ( '!' | '+' | '-' )? parenthesized_expression
        ;

parenthesized_expression
        : '(' expression ')'
        | method_call
        | array_access
        | IDENT
        | literal_expression
        ;

method_call
        : IDENT '(' arglist? ')'
        ;

arglist
        : expression ( ',' expression )*
        ;

array_access
        : IDENT '[' expression ']' ( '[' expression ']' )*
        ;

literal_expression
        : INT_LITERAL
        | BOOL_LITERAL
        ;

type
        : ('int' | 'bool') ( '[' ']')*
        ;

INT_LITERAL  : ('0'..'9' )+;
BOOL_LITERAL : 'true' | 'false';
COMMENT      : '#' .* ( '\n' | '\r' ) {skip();};
WS           : ('\n' | '\r' | ' ' | '\t')+ {skip();};
IDENT        : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
