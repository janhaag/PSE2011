grammar WhileLanguage;

@header {
	package pse2011.parser;
	import pse2011.ast.*;
	import java.util.LinkedList;
}

@lexer::header {
	package pse2011.parser;
}

program
    @init {LinkedList<Assumption> as = new LinkedList<Assumption>();
     	   LinkedList<Function> funcs = new LinkedList<Function>();}
        : assume_statement* ( f=method_declaration {funcs.add((Function) f);} )* main_method
        ;

single_expression returns [ ASTRoot ast ]
	: expression {$ast = $expression.ast;}
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

parameter returns [ Parameter param ]
        : type IDENT {$param = new FunctionParameter($IDENT.text, $type.type);}
        ;

method_body returns [ ASTRoot ast ]
        : '{' assume_statement* statement_block ensure_statement* '}'
        ;

statement returns [ ASTRoot ast ]
        : assert_statement {$ast = $assert_statement.ast;}
        | variable_declaration {$ast = $variable_declaration.ast;}
        | array_declaration {$ast = $array_declaration.ast;}
        | assignment {$ast = $assignment.ast;}
        | if_statement {$ast = $if_statement.ast;}
        | while_statement {$ast = $while_statement.ast;}
        | 'return' expression ';'
        ;

invariant_statement returns [ ASTRoot ast ]
        : 'invariant' quantified_expression ';' {$ast = new Invariant(new Position(), (Expression) $quantified_expression.ast);}
        ;

assert_statement returns [ ASTRoot ast ]
        : 'assert' quantified_expression ';' {$ast = new Assertion(new Position(), (Expression) $quantified_expression.ast);}
        ;

assume_statement returns [ ASTRoot ast ]
        : 'assume' quantified_expression ';'
        ;

ensure_statement returns [ ASTRoot ast ]
        : 'ensure' quantified_expression ';' {$ast = new Ensure(new Position(), (Expression) $quantified_expression.ast);}
        ;

assignment returns [ ASTRoot ast ]
    @init {LinkedList<Expression> l = new LinkedList<Expression>();}
        : IDENT ( '[' e=expression ']' {l.add((Expression) e);} )* '=' value=expression ';'
        {if (l.isEmpty) $ast = new Assignment(new Position(), (Expression) value, new Identifier($IDENT.text));
        	else $ast = new ArrayAssignment(new Position(), (Expression) value, new Identifier($IDENT.text),
         					l.toArray(new Expression[l.size()]));}
        ;

variable_declaration returns [ ASTRoot ast ]
        : type IDENT ( '=' expression )? ';'
        {$ast = new VariableDeclaration(new Position(), $Ident.text, (Expression) $expression.ast, $type.type);}
        ;

array_declaration returns [ ASTRoot ast ]
        : type IDENT ( '[' expression ']' )+ ';'
        ;

if_statement returns [ ASTRoot ast ]
        : 'if' '(' expression ')' statement_block ( 'else' statement_block )?
        ;
        
while_statement returns [ ASTRoot ast ]
        : 'while' '(' expression ')' loop_body
        ;

loop_body returns [ ASTRoot ast ]
        : '{' invariant_statement* statement_block ensure_statement* '}'
        ;

statement_block returns [ ASTRoot ast ]
    @init {LinkedList<Statement> l = new LinkedList<Statement>();}
        : '{' ( s=statement {l.add((Statement) s);})* '}'
        {$ast = new StatementBlock(l.toArray(new Statement[l.size()]), new Position());}
        ;

quantified_expression returns [ ASTRoot ast ]
        : quantifier IDENT '(' range? ')' qe=quantified_expression
        {if ("forall".equals($quantifier.text)) $ast = new ForAllQuantifier(new Position(), $range.range,
       						 new Identifier($IDENT.text), (Expression) qe.ast);
   	 else $ast = new ExistsQuantifier(new Position(), $range.range, new Identifier($IDENT.text), 
        				   (Expression) $qe.ast);}
        | expression {$ast = $expression.ast;}
        ;

quantifier returns [ String text ]
        : 'forall' {$text = "forall";}
        | 'exists' {$text = "exists";}
        ;

range returns [ Range range ]
        : l=expression ',' u=expression {$range = new Range((Expression) l, (Expression) u);}
        ;

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
        	Expression[] params = new Expression[0];
        	if ($arglist.params != null) params = $arglist.params.toArray(new Expression[arglist.size()]);
        	$ast = new FuntionCall($IDENT.text, params , new Position());}
        ;

arglist returns [ LinkedList<Expression> params ]
	@init {params = new LinkedList<Expression>();}
        : e1=expression {params.add((Expression) e1);} ( ',' e2=expression {params.add((Expression) e2);} )*
        ;

array_read returns [ ASTRoot ast ]
	@init {LinkedList<ArithmeticExpression> l = new LinkedList<ArithmeticExpression>();}
        : IDENT '[' e1=expression {if ($e1.ast instanceof ArithmeticExpression) l.add((ArithmeticExpression)e1);
        				else throw new RuntimeException("TODO");} ']' 
        	( '[' e2=expression {if ($e2.ast instanceof ArithmeticExpression) l.add((ArithmeticExpression)e2);
        				else throw new RuntimeException("TODO");} ']' )* 
        {$ast = new ArrayRead(new Position(), new Identifier($IDENT), l.toArray(new ArithmeticExpression[l.size()]));}
        ;

literal_expression returns [ ASTRoot ast ]
        : INT_LITERAL {$ast = new NumericLiteral($INT_LITERAL.text, new Position());}
        | BOOL_LITERAL {$ast = new BooleanLiteral($BOOL_LITERAL.text, new Position());}
        ;

type returns [ Type type ]
        : ('int' {$type = new IntegerType();} | 'bool'{$type = new BooleanType();}) ( '[' ']' {$type = new ArrayType(type);})*
        ;

INT_LITERAL  : ('0'..'9' )+;
BOOL_LITERAL : 'true' | 'false';
COMMENT      : '#' .* ( '\n' | '\r' ) {skip();};
WS           : ('\n' | '\r' | ' ' | '\t')+ {skip();};
IDENT        : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
