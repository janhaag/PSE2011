grammar WhileLanguage;

@header {
	package parser;
	import ast.*;
	import java.util.LinkedList;
}

@lexer::header {
	package parser;
}

program returns [Program p]
	@init {LinkedList<Axiom> axiom = new LinkedList<Axiom>();
	       LinkedList<Function> function = new LinkedList<Function>();}
        : (a=axiom_statement {axiom.add($a.ast);})* (f=function_declaration {function.add($f.ast);})* main
        	{$p = new Program(new Position(), function.toArray(new Function[function.size()]), $main.ast,
        		axiom.toArray(new Axiom[axiom.size()]));}
        ;

single_expression returns [ Expression ast ]
	: expression {ast = $expression.ast;}
	;

function_declaration returns [ Function ast ]
        : type IDENT '(' parameter_list? ')' function_body
        	{if ("main".equals($IDENT.text)) throw new TreeGeneratorException("Main must only be declared once.");
        	 $ast = new Function(new Position(), null, "main", 
        		$parameter_list.params.toArray(new FunctionParameter[$parameter_list.params.size()]),
        		$function_body.ast, $function_body.pre.toArray(new Assumption[$function_body.pre.size()]),
        		$function_body.post.toArray(new Ensure[$function_body.post.size()]));}
        ;

main returns [ Function ast ]
        : 'main' '(' parameter_list? ')' function_body 
        	{$ast = new Function(new Position(), null, "main", 
        		$parameter_list.params.toArray(new FunctionParameter[$parameter_list.params.size()]),
        		$function_body.ast, $function_body.pre.toArray(new Assumption[$function_body.pre.size()]),
        		$function_body.post.toArray(new Ensure[$function_body.post.size()]));}
        ;

parameter_list returns [ LinkedList<FunctionParameter> params ]
	@init {$params = new LinkedList<FunctionParameter>();}
        : p1=parameter {$params.add($p1.ast);} ( ',' p2=parameter {$params.add($p2.ast);} )*
        ;

parameter returns [ FunctionParameter ast ]
        : type IDENT {$ast = new FunctionParameter($IDENT.text, $type.ast);}
        ;

function_body returns [ StatementBlock ast, LinkedList<Assumption> pre, LinkedList<Ensure> post ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : assume_statement? 
          '{' ( statement {s.add($statement.ast);} )* '}' {$ast = new StatementBlock(s.toArray(new Statement[s.size()]), new Position());}
          ensure_statement?
        ;

if_body returns [ StatementBlock ast ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : ( '{' statement* '}' {s.add($statement.ast);} ) {$ast = new StatementBlock(s.toArray(new Statement[s.size()]), new Position());}
        ;

loop_body returns [ StatementBlock ast, LinkedList<Invariant> pre, LinkedList<Ensure> post ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : invariant_statement? {$pre = $invariant_statement.result;} 
          '{' ( statement {s.add($statement.ast);} )* '}' {$ast = new StatementBlock(s.toArray(new Statement[s.size()]), new Position());}
       	  ensure_statement? {$post = $ensure_statement.result;}
        ;

statement returns [ Statement ast ]
        : e1=assert_statement {$ast = $e1.ast;}
        | e2=variable_declaration {$ast = $e2.ast;}
        | e3=array_declaration {$ast = $e3.ast;}
        | e4=assignment {$ast = $e4.ast;}
        | e5=if_statement {$ast = $e5.ast;}
        | e6=while_statement {$ast = $e6.ast;}
        | e7=return_statement {$ast = $e7.ast;}
        ;

invariant_statement returns [ LinkedList<Invariant> result ]
	@init {$result = new LinkedList<Invariant>();}
        : 'invariant' e1=quantified_expression ';' {$result.add(new Invariant(new Position(), $e1.ast));}
        | 'invariant' '{' (e2=quantified_expression ';' {$result.add(new Invariant(new Position(), $e2.ast));} )+ '}'
        ;

axiom_statement returns [ Axiom ast ]
        : 'axiom' e1=quantified_expression ';' {$ast = new Axiom(new Position(), $e1.ast);}
        ;

assert_statement returns [ Assertion ast ]
        : 'assert' e1=quantified_expression ';' {$ast = new Assertion(new Position(), $e1.ast);}
        ;

assume_statement returns [ LinkedList<Assumption> result ]
	@init {$result = new LinkedList<Assumption>();}
        : 'assume' e1=quantified_expression ';' {$result.add(new Assumption(new Position(), $e1.ast));}
        | 'assume' '{' (e2=quantified_expression ';' {$result.add(new Assumption(new Position(), $e2.ast));} )+ '}'
        ;
        
ensure_statement returns [ LinkedList<Ensure> result ]
	@init {$result = new LinkedList<Ensure>();}
	: 'ensure' e1=quantified_expression ';' {$result.add(new Ensure(new Position(), $e1.ast));}
        | 'ensure' '{' (e2=quantified_expression ';' {$result.add(new Ensure(new Position(), $e2.ast));} )+ '}'
        ;

assignment returns [ Assignment ast ]
        : IDENT '=' expression ';' {$ast = new Assignment(new Position(), $expression.ast, new Identifier($IDENT.text));}
        | IDENT {LinkedList<Expression> idx = new LinkedList<Expression>();} 
        	( '[' e1=expression {idx.add($e1.ast);} ']' )+ '=' e2=expression ';' {
        	$ast = new ArrayAssignment(new Position(), $e2.ast, new Identifier($IDENT.text),
        				   idx.toArray(new Expression[idx.size()]));}
        ;

variable_declaration returns [ VariableDeclaration ast ]
        : type IDENT ( '=' expression )? ';' {
        	$ast = new VariableDeclaration(new Position(), $IDENT.text, $expression.ast, $type.ast);}
        ;

array_declaration returns [ ArrayDeclaration ast ]
        : type IDENT '=' array_init ';' {
        	Expression[] dim = $array_init.dim.toArray(new Expression[$array_init.dim.size()]);
        	$ast = new ArrayDeclaration(new Position(), $IDENT.text, $type.ast, dim);}
        ;
        
array_init returns [ LinkedList<Expression> dim]
	: {dim = new LinkedList<Expression>();}
	'array' ( '[' expression {dim.add($expression.ast);} ']' )+
	;

if_statement returns [ Conditional ast ]
        : 'if' '(' expression ')' b1=if_body ( 'else' b2=if_body )? {
        	$ast = new Conditional(new Position(), $expression.ast, $b1.ast, $b2.ast);}
        ;

while_statement returns [ Loop ast ]
        : 'while' '(' expression ')' loop_body {
		Invariant[] i = new Invariant[0];
		i = $loop_body.pre != null ? $loop_body.pre.toArray(new Invariant[$loop_body.pre.size()]) : null; 
		Ensure[] e = new Ensure[0];
		e = $loop_body.post != null ? $loop_body.post.toArray(new Ensure[$loop_body.post.size()]) : null;       
        	$ast = new Loop(new Position(), $expression.ast, $loop_body.ast, i, e);}
        ;
        
return_statement returns [ ReturnStatement ast ]
	: 'return' expression ';' {$ast = new ReturnStatement(new Position(), $expression.ast);}
	;

quantified_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : QUANTIFIER IDENT '(' range? ')' e=quantified_expression {
        	Range r = null;
        	$divisors = $e.divisors;
        	if ($range.e1 != null) {
        		r = new Range($range.e1, $range.e2);
        		$divisors.addAll($range.divisors);
        	}
        	switch ($QUANTIFIER.text) {
        		case "forall":
        			$ast = new ForAllQuantifier(new Position(), r, new Identifier($IDENT.text), 
        				$e.ast);
        		case "exists":
        			$ast = new ExistsQuantifier(new Position(), r, new Identifier($IDENT.text), 
        				$e.ast);
        	}
        }
        | expression {if (!($expression.ast instanceof LogicalExpression)) 
        		throw new TreeGeneratorException("Expected a logical expression.");
        	LogicalExpression conj = (LogicalExpression) $expression.ast;
        	for (Expression exp : $expression.divisors) {
        		LogicalExpression x = new LogicalExpression(new Position(), exp, 
        			new NumericLiteral(new Position(), "0"), new NotEqual());
        		conj = new LogicalExpression(new Position(), x, conj, new Conjunction());
        	}
        	$ast = conj;
        	$divisors = new LinkedList<Expression>();
        	}
        ;
range returns [ ArithmeticExpression e1, ArithmeticExpression e2, LinkedList<Expression> divisors ]
        : e11=expression ',' e22=expression {
        	if (!($e11.ast instanceof ArithmeticExpression || $e22.ast instanceof ArithmeticExpression))
        		throw new TreeGeneratorException("Expected an arithmetic expression.");
        	$e1 = (ArithmeticExpression)$e11.ast; 
        	$e2 = (ArithmeticExpression)$e22.ast; 
        	$divisors = $e11.divisors;
        	$divisors.addAll(e22.divisors);}
        ;

expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=rel_expression {$ast = e1.ast; $divisors = $e1.divisors;} ( 
        	  '==' e2=rel_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Equal());
        	  	$divisors.addAll(e2.divisors);}
        	| '!=' e2=rel_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new NotEqual());
        		$divisors.addAll(e2.divisors);}
        )*
        ;


rel_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=add_expression {$ast = e1.ast; $divisors = $e1.divisors;} ( 
        	  '<'  e2=add_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Less());
        	  	$divisors.addAll(e2.divisors);}
        	| '<=' e2=add_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new LessEqual());
        		$divisors.addAll(e2.divisors);}
        	| '>'  e2=add_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Greater());
        		$divisors.addAll(e2.divisors);}
        	| '>=' e2=add_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new GreaterEqual());
        		$divisors.addAll(e2.divisors);}
        )*
        ;

add_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=mul_expression {$ast = e1.ast; $divisors = $e1.divisors;} ( 
        	  '|' e2=mul_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Disjunction());
        	  	$divisors.addAll(e2.divisors);}
        	| '+' e2=mul_expression {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Addition());
        		$divisors.addAll(e2.divisors);}
        	| '-' e2=mul_expression {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Subtraction());
        		$divisors.addAll(e2.divisors);}
        )*
        ;

mul_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=unary_expression {$ast = e1.ast; $divisors = $e1.divisors;} ( 
        	  '&' e2=unary_expression {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Conjunction());
        	  	$divisors.addAll(e2.divisors);}
        	| '*' e2=unary_expression {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Multiplication());
        		$divisors.addAll(e2.divisors);}
        	| '/' e2=unary_expression {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Division());
        		$divisors.addAll(e2.divisors);
        		$divisors.add($e2.ast);}
        	| '%' e2=unary_expression {if (!($e1.ast instanceof ArithmeticExpression)) 
        			throw new TreeGeneratorException("Expected an arithmetic expression.");
        		$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Modulo());
        		$divisors.addAll(e2.divisors);
        		$divisors.add($e2.ast);}
        )*
        ;

unary_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : '!'  e=parenthesized_expression {
        	$ast = new LogicalExpression(new Position(), $e.ast, null, new Negation());
        	$divisors = e.divisors;}
        | '-'  e=parenthesized_expression {if (!($e.ast instanceof LogicalExpression)) 
        		throw new TreeGeneratorException("Expected an arithmetic expression.");
        	$ast = new ArithmeticExpression(new Position(), $e.ast, null, new UnaryMinus());
        	$divisors = e.divisors;}
        | '+'? e=parenthesized_expression {
        	$ast = $e.ast;
        	$divisors = e.divisors;}
        ;

parenthesized_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : '(' expression ')' {$ast = $expression.ast; $divisors = $expression.divisors;}
        | function_call {$ast = $function_call.ast; $divisors = $function_call.divisors;}
        | array_read {$ast = $array_read.ast; $divisors = $array_read.divisors;}
        | IDENT {$ast = new VariableRead(new Position(), new Identifier($IDENT.text)); $divisors = new LinkedList<Expression>();}
        | literal_expression {$ast = $literal_expression.ast; $divisors= $literal_expression.divisors;}
        ;

function_call returns [ Expression ast, LinkedList<Expression> divisors ]
        : IDENT '(' arglist? ')' {
        	Expression[] params = new Expression[0];
        	if ($arglist.params != null) params = $arglist.params.toArray(new Expression[$arglist.params.size()]);
        	$ast = new FunctionCall(new Identifier($IDENT.text), params , new Position());
        	$divisors = $arglist.divisors;}
        ;

arglist returns [ LinkedList<Expression> params, LinkedList<Expression> divisors ]
	@init {LinkedList<Expression> params = new LinkedList<Expression>();}
        : e1=expression {params.add((Expression) e1.ast); $divisors = $e1.divisors;} 
        	( ',' e2=expression {params.add((Expression) $e2.ast); $divisors.addAll($e2.divisors);} )*
        ;

array_read returns [ Expression ast, LinkedList<Expression> divisors ]
	@init {LinkedList<ArithmeticExpression> l = new LinkedList<ArithmeticExpression>();}
        : IDENT '[' e1=expression {if ($e1.ast instanceof ArithmeticExpression) l.add((ArithmeticExpression)$e1.ast);
        			else throw new TreeGeneratorException("expected an arithmetic expression, got a logical expression");
        		$divisors = $e1.divisors;} ']' 
        	( '[' e2=expression {if ($e2.ast instanceof ArithmeticExpression) l.add((ArithmeticExpression)$e2.ast);
        			else throw new TreeGeneratorException("expected an arithmetic expression, got a logical expression");
        		$divisors.addAll($e2.divisors);} ']' )* 
        {$ast = new ArrayRead(new Position(), new Identifier($IDENT.text), l.toArray(new ArithmeticExpression[l.size()]));}
        ;

literal_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : INT_LITERAL {$ast = new NumericLiteral(new Position(), $INT_LITERAL.text); $divisors = new LinkedList<Expression>();}
        | BOOL_LITERAL {$ast = new BooleanLiteral(new Position(), $BOOL_LITERAL.text); $divisors = new LinkedList<Expression>();}
        ;

type returns [ Type ast ]
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
