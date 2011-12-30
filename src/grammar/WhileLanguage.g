grammar WhileLanguage;

@header {
	package pse2011.parser;
	import pse2011.ast.*
	import java.util.LinkedList;
}

@lexer::header {
	package pse2011.parser;
}

program
        : assume_statement* method_declaration* main_method
        ;

single_expression returns [ ASTRoot ast ]
	: expression
	;

method_declaration returns [ ASTRoot ast ]
        : type IDENT '(' parameter_list? ')' method_body
        ;

main_method returns [ ASTRoot ast ]
        : 'main' '(' parameter_list? ')' method_body
        ;

parameter_list returns [ ASTRoot ast ]
        : parameter ( ',' parameter )*
        ;

parameter returns [ ASTRoot ast ]
        : type IDENT
        ;

method_body returns [ ASTRoot ast ]
        : '{' assume_statement* statement* ensure_statement* '}'
        ;

statement returns [ ASTRoot ast ]
        : assert_statement
        | variable_declaration
        | array_declaration
        | assignment
        | if_statement
        | while_statement
        | 'return' expression ';'
        ;

invariant_statement returns [ ASTRoot ast ]
        : 'invariant' quantified_expression ';'
        ;

assert_statement returns [ ASTRoot ast ]
        : 'assert' quantified_expression ';'
        ;

assume_statement returns [ ASTRoot ast ]
        : 'assume' quantified_expression ';'
        ;

ensure_statement returns [ ASTRoot ast ]
        : 'ensure' quantified_expression ';'
        ;

assignment returns [ ASTRoot ast ]
        : IDENT ( '[' expression ']' )* '=' expression ';'
        ;

variable_declaration returns [ ASTRoot ast ]
        : type IDENT ( '=' expression )? ';'
        ;

array_declaration returns [ ASTRoot ast ]
        : type IDENT ( '[' ']' )+ ';'
        ;

if_statement returns [ ASTRoot ast ]
        : 'if' '(' expression ')' statement_block ( 'else' statement_block )?
        ;

statement_block returns [ ASTRoot ast ]
        : '{' statement* '}'
        ;

while_statement returns [ ASTRoot ast ]
        : 'while' '(' expression ')' loop_body
        ;

loop_body returns [ ASTRoot ast ]
        : '{' invariant_statement* statement* ensure_statement* '}'
        ;

quantified_expression returns [ ASTRoot ast ]
        : quantifier IDENT '(' range? ')' quantified_expression
        | expression
        ;

quantifier returns [ ASTRoot ast ]
        : 'forall'
        | 'exists'
        ;

range returns [ ASTRoot ast ]
        : expression ',' expression;

expression returns [ ASTRoot ast ]
        : rel_expression ( ( '==' | '!=' ) rel_expression )*
        ;


rel_expression returns [ ASTRoot ast ]
        : add_expression ( ( '<' | '<=' | '>' | '>=' ) add_expression )*
        ;

add_expression returns [ ASTRoot ast ]
        : mul_expression ( ( '|' | '+' | '-' ) mul_expression )*
        ;

mul_expression returns [ ASTRoot ast ]
        : unary_expression ( ('&' | '*' | '/' | '%') unary_expression )*
        ;

unary_expression returns [ ASTRoot ast ]
        : ( '!' | '+' | '-' )? parenthesized_expression
        ;

parenthesized_expression returns [ ASTRoot ast ]
        : '(' expression ')' {$ast = $expression.ast;}
        | function_call {$ast = $function_call.ast;}
        | array_read {$ast = $array_read.ast;}
        | IDENT {$ast = new VariableRead(new Position(), new Identifier($IDENT.text));}
        | literal_expression {$ast = $literal_expression.ast;}
        ;

function_call returns [ ASTRoot ast ]
        : IDENT '(' arglist? ')' {
        	Expression[] params = new Expression[0]
        	if ($arglist.params != null) params = $arglist.params.toArray(new Expression[arglist.size()]);
        	$ast = new FuntionCall($IDENT.text, params , new Position()}
        ;

arglist returns [ LinkedList<Expression> params ]
	@init {params = new LinkedList<Expression>();}
        : e1=expression {params.add((Expression) e1);} ( ',' e2=expression {params.add((Expression) e2);} )*
        ;

array_read returns [ ASTRoot ast ]
	@init {LinkedList<ArithmeticExpression> l = LinkedList<ArithmeticExpression>();}
        : IDENT '[' e1=expression {if ($e1.ast isinstance ArithmeticExpression) l.add((ArithmeticExpression)e1);
        				else throw new RuntimeException("TODO");} ']' 
        	( '[' e2=expression {if ($e2.ast isinstance ArithmeticExpression) l.add((ArithmeticExpression)e2);
        				else throw new RuntimeException("TODO");} ']' )* 
        {$ast = new ArrayRead(new Position(), new Identifier($IDENT), l.toArray(new ArithmeticExpression[l.size()]));}
        ;

literal_expression returns [ ASTRoot ast ]
        : INT_LITERAL {$ast = new NumericLiteral($INT_LITERAL.text, new Position());}
        | BOOL_LITERAL {$ast = new BooleanLiteral($BOOL_LITERAL.text, new Position());}
        ;

type returns [ ASTRoot ast ]
        : ('int' {$ast = new IntegerType();} | 'bool'{$ast = new BooleanType();}) ( '[' ']' {$ast = new ArrayType(ast);})*
        ;

INT_LITERAL  : ('0'..'9' )+;
BOOL_LITERAL : 'true' | 'false';
COMMENT      : '#' .* ( '\n' | '\r' ) {skip();};
WS           : ('\n' | '\r' | ' ' | '\t')+ {skip();};
IDENT        : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
