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
        : axiom_statement* method_declaration* main_method
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

method_body returns [ ASTRoot ast, LinkedList<Invariant> pre, LinkedList<Ensure> post ]
        : assume_statement? '{' statement* '}' ensure_statement?
        ;

if_body returns [ ASTRoot ast ]
        : '{' statement* '}'
        ;

loop_body returns [ ASTRoot ast, Invariant pre, Ensure post ]
        : invariant_statement? '{' statement* '}' ensure_statement?
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

axiom_statement returns [ ASTRoot ast ]
        : 'axiom' quantified_expression ';'
        ;

assert_statement returns [ ASTRoot ast ]
        : 'assert' quantified_expression ';'
        | 'assert' '{' (quantified_expression ';')+ '}'
        ;

assume_statement returns [ ASTRoot ast ]
        : 'assume' quantified_expression ';'
        | 'assume' '{' (quantified_expression ';')+ '}'
        ;

ensure_statement returns [ ASTRoot ast ]
	: 'ensure' quantified_expression ';'
        | 'ensure' '{' (quantified_expression ';')+ '}'
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
        : 'if' '(' expression ')' if_body ( 'else' if_body )?
        ;

while_statement returns [ ASTRoot ast ]
        : 'while' '(' expression ')' loop_body {
        	$ast = new Loop(new Position(), (LogicalExpression)$expression.ast, $loop_body.ast, ));}
        ;

quantified_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : QUANTIFIER IDENT '(' range? ')' quantified_expression {
        	Range r;
        	$divisors = $quantified_expression.divisors
        	if ($range != null) {
        		r = new Range($range.e1, $range.e2);
        		$divisors.add($range.divisors);
        	}
        	switch ($QUANTIFIER.text) {
        		case "forall":
        			$ast = new ForallQuantifier(new Position(), r, new Identifier($IDENT.text), 
        				$quantified_expression.ast, null);
        		case "exists":
        			$ast = new ExistsQuantifier(new Position(), r, new Identifier($IDENT.text), 
        				$quantified_expression.ast, null);
        	}
        }
        | expression {if (!$expression instanceof LogicalExpression) 
        		throw new TreeGeneratorException("Expected a logical expression.");
        	LogicalExpression exp = (LogicalExpression) $expression.ast;
        	for (Expression e : $expression.divisors) {
        		LogicalExpression x = new LogicalExpression(new Position(), e, 
        			new NumericLiteral("0", new Position()), new NotEqual());
        		exp = new LogicalExpression(new Position(), x, exp, new Conjunction());
        	}
        	$ast = new QuantifiedExpression(new Position(), null, null, null, exp);
        	$divisors = new LinkedList<Expression>
        	}
        ;
range returns [ ArithmeticExpression e1, ArithmeticExpression e2, LinkedList<Expression> divisors ]
        : e11=expression ',' e22=expression {
        	if (!($e11.ast instanceof ArithmeticExpression || $e22.at instanceof ArithmeticExpression))
        		throw new TreeGeneratorException("Expected an arithmetic expression.");
        	$e1 = (ArithmeticExpression)$e11.ast; 
        	$e2 = (ArithmeticExpression)$e22.ast; 
        	$divisors = $e11.divisors.add(e22.divisors);}
        ;

expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=rel_expression {$ast = e1.ast; $divisors = $e1.divisors;} ( 
        	  '==' e2=rel_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Equal());
        	  	$divisors = $divisors.add(e2.divisors);}
        	| '!=' e2=rel_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new NotEqual());
        		$divisors = $divisors.add(e2.divisors);}
        )*
        ;


rel_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=add_expression {$ast = e1.ast; $divisors = $e1.divisors;} ( 
        	  '<'  e2=add_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Less());
        	  	$divisors = $divisors.add(e2.divisors);}
        	| '<=' e2=add_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new LessEqual());
        		$divisors = $divisors.add(e2.divisors);}
        	| '>'  e2=add_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Greater());
        		$divisors = $divisors.add(e2.divisors);}
        	| '>=' e2=add_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new GreaterEqual());
        		$divisors = $divisors.add(e2.divisors);}
        )*
        ;

add_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=mul_expression {$ast = e1.ast; $divisors = $e1.divisors;} ( 
        	  '|' e2=mul_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Disjunction());
        	  	$divisors = $divisors.add(e2.divisors);}
        	| '+' e2=mul_expression {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Addition());
        		$divisors = $divisors.add(e2.divisors);}
        	| '-' e2=mul_expression {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Subtraction());
        		$divisors = $divisors.add(e2.divisors);}
        )*
        ;

mul_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=unary_expression {$ast = e1.ast; $divisors = $e1.divisors;} ( 
        	  '&' e2=unary_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Conjunction());
        	  	$divisors = $divisors.add(e2.divisors);}
        	| '*' e2=unary_expression {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Multiplication());
        		$divisors = $divisors.add(e2.divisors);}
        	| '/' e2=unary_expression {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Division());
        		$divisors = $divisors.add(e2.divisors);
        		$divisors.add($e2.ast);}
        	| '%' e2=unary_expression {if (!$e1.ast instanceof ArithmeticExpression) 
        			throw new TreeGeneratorException("Expected an arithmetic expression.");
        		$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Modulo());
        		$divisors = $divisors.add(e2.divisors);
        		$divisors.add($e2.ast);}
        )*
        ;

unary_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : '!'  e=parenthesized_expression {if (!$e.ast instanceof ArithmeticExpression) 
        		throw new TreeGeneratorException("Expected an arithmetic expression.");
        	$ast = new LogicalExpression(new Position(), $e.ast, null, new Negation());
        	$divisors = e.divisors;}
        | '-'  e=parenthesized_expression {if (!$e.ast instanceof ArithmeticExpression) 
        		throw new TreeGeneratorException("Expected an arithmetic expression.");
        	$ast = new ArithmeticExpression(new Position(), $e.ast, null, new UnaryMinus());
        	$divisors = e.divisors;}
        | '+'? e=parenthesized_expression {if (!$e.ast instanceof ArithmeticExpression) 
        		throw new TreeGeneratorException("Expected an arithmetic expression.");
        	$ast = $e.ast;
        	$divisors = e.divisors;}
        ;

parenthesized_expression returns [ ASTRoot ast, LinkedList<Expression> divisors ]
        : '(' expression ')' {$ast = $expression.ast; $divisors = $expression.divisors;}
        | function_call {$ast = $function_call.ast; $divisors = $function_call.divisors;}
        | array_read {$ast = $array_read.ast; $divisors = $array_read.divisors;}
        | IDENT {$ast = new VariableRead(new Position(), new Identifier($IDENT.text)); $divisors = new LinkedList<Expression>();}
        | literal_expression {$ast = $literal_expression.ast; $divisors= $literal_expression.divisors;}
        ;

function_call returns [ Expression ast, LinkedList<Expression> divisors ]
        : IDENT '(' arglist? ')' {
        	Expression[] params = new Expression[0]
        	if ($arglist.params != null) params = $arglist.params.toArray(new Expression[arglist.size()]);
        	$ast = new FunctionCall($IDENT.text, params , new Position();
        	$divisors = $arglist.divisors;}
        ;

arglist returns [ LinkedList<Expression> params, LinkedList<Expression> divisors ]
	@init {params = new LinkedList<Expression>();}
        : e1=expression {params.add((Expression) e1); $divisors = $e1.divisors;} 
        	( ',' e2=expression {params.add((Expression) e2); $divisors.add($e2.divisors);} )*
        ;

array_read returns [ Expression ast, LinkedList<Expression> divisors ]
	@init {LinkedList<ArithmeticExpression> l = LinkedList<ArithmeticExpression>();}
        : IDENT '[' e1=expression {if ($e1.ast instanceof ArithmeticExpression) l.add((ArithmeticExpression)e1);
        			else throw new TreeGeneratorException("expected an arithmetic expression, got a logical expression");
        		$divisors = $e1.divisors;} ']' 
        	( '[' e2=expression {if ($e2.ast instanceof ArithmeticExpression) l.add((ArithmeticExpression)e2);
        			else throw new TreeGeneratorException("expected an arithmetic expression, got a logical expression");
        		$divisors.add($e2.divisors);} ']' )* 
        {$ast = new ArrayRead(new Position(), new Identifier($IDENT), l.toArray(new ArithmeticExpression[l.size()]));}
        ;

literal_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : INT_LITERAL {$ast = new NumericLiteral($INT_LITERAL.text, new Position()); $divisors = new LinkedList<Expression>();}
        | BOOL_LITERAL {$ast = new BooleanLiteral($BOOL_LITERAL.text, new Position()); $divisors = new LinkedList<Expression>();}
        ;

type returns [ ASTRoot ast ]
        : ('int' {$ast = new IntegerType();} | 'bool'{$ast = new BooleanType();}) ( '[' ']' {$ast = new ArrayType(ast);})*
        ;

INT_LITERAL  : ('0'..'9' )+;
BOOL_LITERAL : 'true' | 'false';
QUANTIFIER
        : 'forall'
        | 'exists'
        ;
COMMENT      : '#' .* ( '\n' | '\r' ) {skip();};
WS           : ('\n' | '\r' | ' ' | '\t')+ {skip();};
IDENT        : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
