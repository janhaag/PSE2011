grammar WhileLanguage;

@header {
	package parser;
	import ast.*;
	import java.util.LinkedList;

    import static misc.WhileLanguageParserUtils.*;
}

@members {
    private LinkedList<String> reporter;
    private boolean error = false;

    public void setErrorReporter(LinkedList<String> reporter) {
        this.reporter = reporter;
    }

    @Override
    public void emitErrorMessage(String msg) {
        reporter.add(msg);
    }

    @Override
    protected Object recoverFromMismatchedToken(IntStream input,
                                                int ttype,
                                                BitSet follow)
                                                throws RecognitionException {
        error = true;
        return super.recoverFromMismatchedToken(input, ttype, follow);
    }
}

@lexer::header {
	package parser;
    import java.util.LinkedList;
}

@lexer::members {
    private LinkedList<String> reporter;

    public void setErrorReporter(LinkedList<String> reporter) {
        this.reporter = reporter;
    }

    @Override
    public void emitErrorMessage(String msg) {
        reporter.add(msg);
    }
}

program returns [Program p]
	@init {LinkedList<Axiom> axiom = new LinkedList<Axiom>();
	       LinkedList<Function> function = new LinkedList<Function>();}
        : (a=axiom_statement {if (!error) axiom.addAll($a.result);})*
            (f=function_declaration {if (!error) function.add($f.ast);})* main
        	{$p = error ? null : new Program(new Position(), function.toArray(new Function[function.size()]), $main.ast,
        		axiom.toArray(new Axiom[axiom.size()]));}
        ;

single_expression returns [ Expression ast ]
	: expression {ast = error ? null : $expression.ast;}
	;

function_declaration returns [ Function ast ]
        : type IDENT '(' p=parameter_list? ')' function_body
        	{if ("main".equals($IDENT.text)) throw new TreeGeneratorException("Main must only be declared once.");
        	LinkedList<FunctionParameter> params = error ? null :
        		$parameter_list.params != null ? $parameter_list.params : new LinkedList<FunctionParameter>();
        	 $ast = error ? null :
                new Function(new Position(), $type.ast, $IDENT.text,
        		params.toArray(new FunctionParameter[params.size()]),
        		$function_body.ast, $function_body.pre.toArray(new Assumption[$function_body.pre.size()]),
        		$function_body.post.toArray(new Ensure[$function_body.post.size()]));}
        ;

main returns [ Function ast ]
        : 'main' '(' parameter_list? ')' function_body
                {LinkedList<FunctionParameter> params = error ? null :
        		$parameter_list.params != null ? $parameter_list.params : new LinkedList<FunctionParameter>();
        	$ast = error ? null : new Function(new Position(), null, "main",
        		params.toArray(new FunctionParameter[params.size()]),
        		$function_body.ast, $function_body.pre.toArray(new Assumption[$function_body.pre.size()]),
        		$function_body.post.toArray(new Ensure[$function_body.post.size()]));}
        ;

parameter_list returns [ LinkedList<FunctionParameter> params ]
	@init {$params = new LinkedList<FunctionParameter>();}
        : p1=parameter {if (!error) $params.add($p1.ast);} ( ',' p2=parameter {if (!error) $params.add($p2.ast);} )*
        ;

parameter returns [ FunctionParameter ast ]
        : type IDENT {$ast = error ? null : new FunctionParameter($IDENT.text, $type.ast);}
        ;

function_body returns [ StatementBlock ast, LinkedList<Assumption> pre, LinkedList<Ensure> post ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : a=assume_statement? {$pre = error ? null : $a.result != null ? $a.result : new LinkedList<Assumption>();}
          '{' ( statement {if (!error) { s.addAll(possibleDivByZero($statement.divisors)); s.add($statement.ast); }} )* '}'
              {$ast = error ?null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position());}
          e=ensure_statement? {$post = error ? null : $e.result != null ? $e.result : new LinkedList<Ensure>();}
        ;

if_body returns [ StatementBlock ast ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : '{' ( statement {if (!error) {s.addAll(possibleDivByZero($statement.divisors)); s.add($statement.ast);}} )* '}'
            {$ast = error ? null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position());}
        ;

loop_body returns [ StatementBlock ast, LinkedList<Invariant> pre, LinkedList<Ensure> post ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : i=invariant_statement? {$pre = error ? null : $i.result != null ? $i.result : new LinkedList<Invariant>();}
          '{' ( statement {if (!error) {s.addAll(possibleDivByZero($statement.divisors)); s.add($statement.ast);}} )* '}'
              {$ast = error ? null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position());}
       	  e=ensure_statement? {$post = error ? null : $e.result != null ? $e.result : new LinkedList<Ensure>();}
        ;

statement returns [ Statement ast, LinkedList<Expression> divisors ]
        : e1=assert_statement {if (!error) {$ast = $e1.ast; $divisors = $e1.divisors;}}
        | e2=variable_declaration {if (!error) {$ast = $e2.ast; $divisors = $e2.divisors;}}
        | e3=array_declaration {if (!error) {$ast = $e3.ast; $divisors = $e3.divisors;}}
        | e4=assignment {if (!error) {$ast = $e4.ast; $divisors = $e4.divisors;}}
        | e5=if_statement {if (!error) {$ast = $e5.ast; $divisors = $e5.divisors;}}
        | e6=while_statement {if (!error) {$ast = $e6.ast; $divisors = $e6.divisors;}}
        | e7=return_statement {if (!error) {$ast = $e7.ast; $divisors = $e7.divisors;}}
        ;

invariant_statement returns [ LinkedList<Invariant> result ]
	@init {$result = new LinkedList<Invariant>();}
        : 'invariant' e1=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroI($e1.divisors));
            $result.add(new Invariant(new Position(), $e1.ast));}}
        | 'invariant' '{' (e2=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroI($e2.divisors));
            $result.add(new Invariant(new Position(), $e2.ast));}} )+ '}'
        ;

axiom_statement returns [ LinkedList<Axiom> result ]
    @init {$result = new LinkedList<Axiom>();}
        : 'axiom' e1=quantified_expression ';' {if (!error) {
        for (Expression e : $e1.divisors) {
            $result.add(new Axiom(new Position(),
                new LogicalExpression(new Position(), e, new NumericLiteral(new Position(), "0"), new NotEqual())
                ));
        }
            $result.add(new Axiom(new Position(), $e1.ast));}}
        ;

assert_statement returns [ Assertion ast, LinkedList<Expression> divisors ]
        : 'assert' e1=quantified_expression ';' {if (!error) {$ast = new Assertion(new Position(), $e1.ast); $divisors = $e1.divisors;}}
        ;

assume_statement returns [ LinkedList<Assumption> result ]
	@init {$result = new LinkedList<Assumption>();}
        : 'assume' e1=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroA($e1.divisors));
            $result.add(new Assumption(new Position(), $e1.ast));}}
        | 'assume' '{' (e2=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroA($e2.divisors));
            $result.add(new Assumption(new Position(), $e2.ast));}} )+ '}'
        ;

ensure_statement returns [ LinkedList<Ensure> result ]
	@init {$result = new LinkedList<Ensure>();}
       	: 'ensure' e1=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroE($e1.divisors));
            $result.add(new Ensure(new Position(), $e1.ast));}}
        | 'ensure' '{' (e2=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroE($e2.divisors));
            $result.add(new Ensure(new Position(), $e2.ast));}} )+ '}'
        ;

assignment returns [ Assignment ast, LinkedList<Expression> divisors ]
    @init {$divisors = new LinkedList<Expression>();}
        : IDENT '=' expression ';' {if (!error) {$ast = new Assignment(new Position(), $expression.ast, new Identifier($IDENT.text));
            $divisors = $expression.divisors;}}
        | IDENT {LinkedList<Expression> idx = new LinkedList<Expression>();}
        	( '[' e1=expression {if (!error) {idx.add($e1.ast); $divisors.addAll($e1.divisors);}} ']' )+ '=' e2=expression ';'
            {if (!error) {$ast = new ArrayAssignment(new Position(), $e2.ast, new Identifier($IDENT.text),
        				   idx.toArray(new Expression[idx.size()]));
            $divisors.addAll($e2.divisors);}}
        ;

variable_declaration returns [ VariableDeclaration ast, LinkedList<Expression> divisors ]
        : type IDENT ( '=' expression )? ';' {if (!error) {
        	Expression init = $expression.ast != null ? $expression.ast : null;
        	$ast = new VariableDeclaration(new Position(), $IDENT.text, init, $type.ast);
            $divisors = $expression.ast != null ? $expression.divisors : new LinkedList<Expression>();}}
        ;

array_declaration returns [ ArrayDeclaration ast, LinkedList<Expression> divisors ]
        : type IDENT '=' array_init ';' {if (!error) {
        	Expression[] dim = $array_init.dim.toArray(new Expression[$array_init.dim.size()]);
        	$ast = new ArrayDeclaration(new Position(), $IDENT.text, $type.ast, dim);
            $divisors = $array_init.divisors;}}
        ;

array_init returns [ LinkedList<Expression> dim, LinkedList<Expression> divisors ]
    @init {$divisors = new LinkedList<Expression>();}
	: {$dim = new LinkedList<Expression>();}
	'array' ( '[' expression {if (!error) {$dim.add($expression.ast); $divisors.addAll($expression.divisors);}} ']' )+
	;

if_statement returns [ Conditional ast, LinkedList<Expression> divisors ]
        : 'if' '(' expression ')' b1=if_body ( 'else' b2=if_body )? {if (!error) {
        	$ast = new Conditional(new Position(), $expression.ast, $b1.ast, $b2.ast);
            $divisors = $expression.divisors;}}
        ;

while_statement returns [ Loop ast, LinkedList<Expression> divisors ]
        : 'while' '(' expression ')' loop_body {if (!error) {
		Invariant[] i = new Invariant[0];
		i = $loop_body.pre != null ? $loop_body.pre.toArray(new Invariant[$loop_body.pre.size()]) : null;
		Ensure[] e = new Ensure[0];
		e = $loop_body.post != null ? $loop_body.post.toArray(new Ensure[$loop_body.post.size()]) : null;
       	$ast = new Loop(new Position(), $expression.ast, $loop_body.ast, i, e);
        $divisors = $expression.divisors;}}
        ;

return_statement returns [ ReturnStatement ast, LinkedList<Expression> divisors ]
	: 'return' expression ';' {if (!error) {
        $ast = new ReturnStatement(new Position(), $expression.ast); $divisors = $expression.divisors;}}
	;

quantified_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : QUANTIFIER IDENT '(' range? ')' e=quantified_expression {if (!error) {
        	Range r = null;
        	$divisors = $e.divisors;
        	if ($range.e1 != null) {
        		r = new Range($range.e1, $range.e2);
        		$divisors.addAll($range.divisors);
        	}
        	if ("forall".equals($QUANTIFIER.text))
        			$ast = new ForAllQuantifier(new Position(), r, new Identifier($IDENT.text),
        				$e.ast);
            else $ast = new ExistsQuantifier(new Position(), r, new Identifier($IDENT.text),
        				$e.ast);
        	}}
        | expression {if (!error) {
            $divisors = $expression.divisors;
        	$ast = $expression.ast;
        }}
        ;

range returns [ Expression e1, Expression e2, LinkedList<Expression> divisors ]
        : l=expression ',' u=expression {if (!error) {
        	$e1=l.ast; $e2=u.ast;
        	$divisors = l.divisors;
        	$divisors.addAll(u.divisors);}}
        ;

expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=rel_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors;}} (
        	  '==' e2=rel_expression {if (!error) {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Equal());
        	  	$divisors.addAll(e2.divisors);}}
        	| '!=' e2=rel_expression {if (!error) {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new NotEqual());
        		$divisors.addAll(e2.divisors);}}
        )*
        ;


rel_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=add_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors;}} (
        	  '<'  e2=add_expression {if (!error) {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Less());
        	  	$divisors.addAll(e2.divisors);}}
        	| '<=' e2=add_expression {if (!error) {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new LessEqual());
        		$divisors.addAll(e2.divisors);}}
        	| '>'  e2=add_expression {if (!error) {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Greater());
        		$divisors.addAll(e2.divisors);}}
        	| '>=' e2=add_expression {if (!error) {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new GreaterEqual());
        		$divisors.addAll(e2.divisors);}}
        )*
        ;

add_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=mul_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors;}} (
        	  '|' e2=mul_expression {if (!error) {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Disjunction());
        	  	$divisors.addAll(e2.divisors);}}
        	| '+' e2=mul_expression {if (!error) {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Addition());
        		$divisors.addAll(e2.divisors);}}
        	| '-' e2=mul_expression {if (!error) {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Subtraction());
        		$divisors.addAll(e2.divisors);}}
        )*
        ;

mul_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : e1=unary_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors;}} (
        	  '&' e2=unary_expression {if (!error) {$ast = new LogicalExpression(new Position(), $ast, $e2.ast, new Conjunction());
        	  	$divisors.addAll(e2.divisors);}}
        	| '*' e2=unary_expression {if (!error) {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Multiplication());
        		$divisors.addAll(e2.divisors);}}
        	| '/' e2=unary_expression {if (!error) {$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Division());
        		$divisors.addAll(e2.divisors);
        		$divisors.add($e2.ast);}}
        	| '%' e2=unary_expression {if (!error) {
        		$ast = new ArithmeticExpression(new Position(), $ast, $e2.ast, new Modulo());
        		$divisors.addAll(e2.divisors);
        		$divisors.add($e2.ast);}}
        )*
        ;

unary_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : '!'  e=parenthesized_expression {if (!error) {
        	$ast = new LogicalExpression(new Position(), $e.ast, null, new Negation());
        	$divisors = e.divisors;}}
        | '-'  e=parenthesized_expression {if (!error) {
        	$ast = new ArithmeticExpression(new Position(), $e.ast, null, new UnaryMinus());
        	$divisors = e.divisors;}}
        | '+'? e=parenthesized_expression {if (!error) {
        	$ast = $e.ast;
        	$divisors = e.divisors;}}
        ;

parenthesized_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : '(' expression ')' {if (!error) {$ast = $expression.ast; $divisors = $expression.divisors;}}
        | function_call {if (!error) {$ast = $function_call.ast; $divisors = $function_call.divisors;}}
        | array_read {if (!error) {$ast = $array_read.ast; $divisors = $array_read.divisors;}}
        | IDENT {if (!error) {$ast = new VariableRead(new Position(), new Identifier($IDENT.text)); $divisors = new LinkedList<Expression>();}}
        | literal_expression {if (!error) {$ast = $literal_expression.ast; $divisors= $literal_expression.divisors;}}
        ;

function_call returns [ Expression ast, LinkedList<Expression> divisors ]
        : IDENT '(' arglist? ')' {if (!error) {
        	Expression[] params = new Expression[0];
        	if ($arglist.params != null) params = $arglist.params.toArray(new Expression[$arglist.params.size()]);
        	$ast = new FunctionCall(new Identifier($IDENT.text), params , new Position());
        	$divisors = $arglist.divisors;}}
        ;

arglist returns [ LinkedList<Expression> params, LinkedList<Expression> divisors ]
	@init {LinkedList<Expression> params = new LinkedList<Expression>();}
        : e1=expression {if (!error) {params.add((Expression) e1.ast); $divisors = $e1.divisors;}}
        	( ',' e2=expression {if (!error) {params.add((Expression) $e2.ast); $divisors.addAll($e2.divisors);}} )*
        ;

array_read returns [ Expression ast, LinkedList<Expression> divisors ]
	@init {LinkedList<Expression> l = new LinkedList<Expression>();}
        : IDENT '[' e1=expression {if (!error) {l.add($e1.ast);
        		$divisors = $e1.divisors;}} ']'
        	( '[' e2=expression {if (!error) {l.add($e2.ast);
        		$divisors.addAll($e2.divisors);}} ']' )*
        {if (!error) {$ast = new ArrayRead(new Position(), new Identifier($IDENT.text), l.toArray(new Expression[l.size()]));}}
        ;

literal_expression returns [ Expression ast, LinkedList<Expression> divisors ]
        : INT_LITERAL {if (!error) {$ast = new NumericLiteral(new Position(), $INT_LITERAL.text); $divisors = new LinkedList<Expression>();}}
        | BOOL_LITERAL {if (!error) {$ast = new BooleanLiteral(new Position(), $BOOL_LITERAL.text); $divisors = new LinkedList<Expression>();}}
        ;

type returns [ Type ast ]
        : ('int' {$ast = error ? null : new IntegerType();}
        | 'bool'{$ast = error ? null : new BooleanType();}) ( '[' ']' {$ast = error ? null : new ArrayType(ast);})*
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
