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
        	{$p = error ? null : new Program(new Position(),
                function.toArray(new Function[function.size()]), $main.ast,
        		axiom.toArray(new Axiom[axiom.size()]));}
        ;

single_expression returns [ Expression ast ]
	: expression {ast = error ? null : $expression.ast;}
	;

function_declaration returns [ Function ast ]
        : type IDENT '(' p=parameter_list? ')' function_body
        	{if ("main".equals($IDENT.text)) throw new TreeGeneratorException("\"main\" must only be declared once.");
             if ("length".equals($IDENT.text)) throw new TreeGeneratorException("\"length\" is a reserved name.");
        	LinkedList<FunctionParameter> params = error ? null :
        		$parameter_list.params != null ? $parameter_list.params : new LinkedList<FunctionParameter>();
        	 $ast = error ? null :
                new Function(new Position($start.getLine(), $start.getCharPositionInLine()), $type.ast, $IDENT.text,
        		params.toArray(new FunctionParameter[params.size()]),
        		$function_body.ast, $function_body.pre.toArray(new Assumption[$function_body.pre.size()]),
        		$function_body.post.toArray(new Ensure[$function_body.post.size()]));}
        ;

main returns [ Function ast ]
        : 'main' '(' parameter_list? ')' function_body
                {LinkedList<FunctionParameter> params = error ? null :
        		$parameter_list.params != null ? $parameter_list.params : new LinkedList<FunctionParameter>();
        	$ast = error ? null : new Function(new Position($start.getLine(), $start.getCharPositionInLine()), null, "main",
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
          '{' ( statement {if (!error) { s.addAll(possibleDivByZero($statement.divisors));
            s.addAll(possibleArrayOutOfBounds($statement.arrayIndices); s.add($statement.ast); }} )* '}'
              {$ast = error ?null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position($start.getLine(), $start.getCharPositionInLine()));}
          e=ensure_statement? {$post = error ? null : $e.result != null ? $e.result : new LinkedList<Ensure>();}
        ;

if_body returns [ StatementBlock ast ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : '{' ( statement {if (!error) {s.addAll(possibleDivByZero($statement.divisors));
            s.addAll(possibleArrayOutOfBounds($statement.arrayIndices); s.add($statement.ast);}} )* '}'
            {$ast = error ? null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position($start.getLine(), $start.getCharPositionInLine()));}
        ;

loop_body returns [ StatementBlock ast, LinkedList<Invariant> pre, LinkedList<Ensure> post ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : i=invariant_statement? {$pre = error ? null : $i.result != null ? $i.result : new LinkedList<Invariant>();}
          '{' ( statement {if (!error) {s.addAll(possibleDivByZero($statement.divisors));
            s.addAll(possibleArrayOutOfBounds($statement.arrayIndices); s.add($statement.ast);}} )* '}'
              {$ast = error ? null : new StatementBlock(s.toArray(new Statement[s.size()]),
              new Position($start.getLine(), $start.getCharPositionInLine()));}
       	  e=ensure_statement? {$post = error ? null : $e.result != null ? $e.result : new LinkedList<Ensure>();}
        ;

statement returns [ Statement ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : e=assert_statement {if (!error) {$ast = $e.ast; $divisors = $e.divisors; $arrayIndices = $e.arrayIndices;}}
        | e=variable_declaration {if (!error) {$ast = $e.ast; $divisors = $e.divisors; $arrayIndices = $e.arrayIndices;}}
        | e=array_declaration {if (!error) {$ast = $e.ast; $divisors = $e.divisors; $arrayIndices = $e.arrayIndices;}}
        | e=assignment {if (!error) {$ast = $e.ast; $divisors = $e.divisors; $arrayIndices = $e.arrayIndices;}}
        | e=if_statement {if (!error) {$ast = $e.ast; $divisors = $e.divisors; $arrayIndices = $e.arrayIndices;}}
        | e=while_statement {if (!error) {$ast = $e.ast; $divisors = $e.divisors; $arrayIndices = $e.arrayIndices;}}
        | e=return_statement {if (!error) {$ast = $e.ast; $divisors = $e.divisors; $arrayIndices = $e.arrayIndices;}}
        ;

invariant_statement returns [ LinkedList<Invariant> result ]
	@init {$result = new LinkedList<Invariant>();}
        : 'invariant' e1=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroI($e1.divisors));
            $result.addAll(possibleArrayOutOfBoundsI($e1.arrayIndices);
            $result.add(new Invariant(new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast));}}
        | 'invariant' '{' (e2=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroI($e2.divisors));
            $result.addAll(possibleArrayOutOfBoundsI($e2.arrayIndices);
            $result.add(new Invariant(new Position($start.getLine(), $start.getCharPositionInLine()), $e2.ast));}} )+ '}'
        ;

axiom_statement returns [ LinkedList<Axiom> result ]
    @init {$result = new LinkedList<Axiom>();}
        : 'axiom' e1=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroAx($e1.divisors));
            $result.addAll(possibleArrayOutOfBoundsAx($e1.arrayIndices);
            $result.add(new Axiom(new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast));}}
        ;

assert_statement returns [ Assertion ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : 'assert' e1=quantified_expression ';' {if (!error) {$ast = new Assertion(
                    new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast);
                $divisors = $e1.divisors;
                $arrayIndices = $e1.arrayIndices;}}
        ;

assume_statement returns [ LinkedList<Assumption> result ]
	@init {$result = new LinkedList<Assumption>();}
        : 'assume' e1=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroA($e1.divisors));
            $result.addAll(possibleArrayOutOfBoundsA($e1.arrayIndices);
            $result.add(new Assumption(new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast));}}
        | 'assume' '{' (e2=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroA($e2.divisors));
            $result.addAll(possibleArrayOutOfBoundsA($e2.arrayIndices);
            $result.add(new Assumption(new Position($start.getLine(), $start.getCharPositionInLine()), $e2.ast));}} )+ '}'
        ;

ensure_statement returns [ LinkedList<Ensure> result ]
	@init {$result = new LinkedList<Ensure>();}
       	: 'ensure' e1=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroE($e1.divisors));
            $result.addAll(possibleArrayOutOfBoundsE($e1.arrayIndices);
            $result.add(new Ensure(new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast));}}
        | 'ensure' '{' (e2=quantified_expression ';' {if (!error) {$result.addAll(possibleDivByZeroE($e2.divisors));
            $result.addAll(possibleArrayOutOfBoundsE($e2.arrayIndices);
            $result.add(new Ensure(new Position($start.getLine(), $start.getCharPositionInLine()), $e2.ast));}} )+ '}'
        ;

assignment returns [ Assignment ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
    @init {$divisors = new LinkedList<Expression>(); $arrayIndices = new LinkedList<Expression();}
        : IDENT '=' expression ';' {if (!error) {$ast = new Assignment(new Position($start.getLine(), $start.getCharPositionInLine()),
                $expression.ast, new Identifier($IDENT.text));
            $divisors = $expression.divisors; $arrayIndices = $expression.arrayIndices;}}
        | IDENT {LinkedList<Expression> idx = new LinkedList<Expression>();}
        	( '[' e1=expression {if (!error) {idx.add($e1.ast); $divisors.addAll($e1.divisors); $arrayIndices.addAll($e1.arrayIndices);}}
          ']' )+ '=' e2=expression ';'
            {if (!error) {$ast = new ArrayAssignment(new Position($start.getLine(), $start.getCharPositionInLine()),
                           $e2.ast, new Identifier($IDENT.text),
        				   idx.toArray(new Expression[idx.size()]));
            $divisors.addAll($e2.divisors);
            $arrayIndices.addAll($e2.arrayIndices);}}
        ;

variable_declaration returns [ VariableDeclaration ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : type IDENT ( '=' expression )? ';' {if (!error) {
        	Expression init = $expression.ast != null ? $expression.ast : null;
        	$ast = new VariableDeclaration(new Position($start.getLine(), $start.getCharPositionInLine()), $IDENT.text, init, $type.ast);
            $divisors = $expression.ast != null ? $expression.divisors : new LinkedList<Expression>();
            $arrayIndices = $expression.ast != null ? $expression.arrayIndices : null;}}
        ;

array_declaration returns [ ArrayDeclaration ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : type IDENT '=' array_init ';' {if (!error) {
        	Expression[] dim = $array_init.dim.toArray(new Expression[$array_init.dim.size()]);
        	$ast = new ArrayDeclaration(new Position($start.getLine(), $start.getCharPositionInLine()), $IDENT.text, $type.ast, dim);
            $divisors = $array_init.divisors;$arrayIndices = $array_init.arrayIndices;}}
        ;

array_init returns [ LinkedList<Expression> dim, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
    @init {$divisors = new LinkedList<Expression>();$dim = new LinkedList<Expression>(); $arrayIndices = new LinkedList<Expression>();}
	: 'array' ( '[' expression {if (!error) {$dim.add($expression.ast); $divisors.addAll($expression.divisors);
        $arrayIndices.addAll($expression.arrayIndices);}} ']' )+
	;

if_statement returns [ Conditional ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : 'if' '(' expression ')' b1=if_body ( 'else' b2=if_body )? {if (!error) {
        	$ast = new Conditional(new Position($start.getLine(), $start.getCharPositionInLine()), $expression.ast, $b1.ast, $b2.ast);
            $divisors = $expression.divisors;$arrayIndices = $expression.arrayIndices;}}
        ;

while_statement returns [ Loop ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : 'while' '(' expression ')' loop_body {if (!error) {
		Invariant[] i = new Invariant[0];
		i = $loop_body.pre != null ? $loop_body.pre.toArray(new Invariant[$loop_body.pre.size()]) : null;
		Ensure[] e = new Ensure[0];
		e = $loop_body.post != null ? $loop_body.post.toArray(new Ensure[$loop_body.post.size()]) : null;
       	$ast = new Loop(new Position($start.getLine(), $start.getCharPositionInLine()), $expression.ast, $loop_body.ast, i, e);
        $divisors = $expression.divisors;$arrayIndices = $expression.arrayIndices;}}
        ;

return_statement returns [ ReturnStatement ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
	: 'return' expression ';' {if (!error) {
        $ast = new ReturnStatement(new Position($start.getLine(), $start.getCharPositionInLine()), $expression.ast);
        $divisors = $expression.divisors;$arrayIndices = $expression.arrayIndices;}}
	;

quantified_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : QUANTIFIER IDENT '(' range? ')' e=quantified_expression {if (!error) {
        	Range r = null;
        	$divisors = $e.divisors;
            $arrayIndices = $e.arrayIndices;
        	if ($range.e1 != null) {
        		r = new Range($range.e1, $range.e2);
        		$divisors.addAll($range.divisors);
                $arrayIndices.addAll($range.arrayIndices);
        	}
        	if ("forall".equals($QUANTIFIER.text))
        			$ast = new ForAllQuantifier(new Position($start.getLine(), $start.getCharPositionInLine()), r, new Identifier($IDENT.text),
        				$e.ast);
            else $ast = new ExistsQuantifier(new Position($start.getLine(), $start.getCharPositionInLine()), r, new Identifier($IDENT.text),
        				$e.ast);
        	}}
        | expression {if (!error) {
            $divisors = $expression.divisors;
        	$ast = $expression.ast;
            $arrayIndices = $expression.arrayIndices;
        }}
        ;

range returns [ Expression e1, Expression e2, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : l=expression ',' u=expression {if (!error) {
        	$e1=l.ast; $e2=u.ast;
        	$divisors = l.divisors;
        	$divisors.addAll(u.divisors);
            $arrayIndices = $l.arrayIndices;
            $arrayIndices.addAll($u.arrayIndices);}}
        ;

expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : e1=rel_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}} (
        	  '==' e2=rel_expression {if (!error) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Equal());
        	  	$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '!=' e2=rel_expression {if (!error) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new NotEqual());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        )*
        ;


rel_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : e1=add_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}} (
        	  '<'  e2=add_expression {if (!error) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Less());
        	  	$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '<=' e2=add_expression {if (!error) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new LessEqual());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '>'  e2=add_expression {if (!error) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Greater());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '>=' e2=add_expression {if (!error) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new GreaterEqual());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        )*
        ;

add_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : e1=mul_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}} (
        	  '|' e2=mul_expression {if (!error) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Disjunction());
        	  	$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '+' e2=mul_expression {if (!error) {$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Addition());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '-' e2=mul_expression {if (!error) {$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Subtraction());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        )*
        ;

mul_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : e1=unary_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}} (
        	  '&' e2=unary_expression {if (!error) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Conjunction());
        	  	$divisors.addAll(e2.divisors);
                $arrayIndices.addAll($e2.arrayIndices);}}
        	| '*' e2=unary_expression {if (!error) {$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Multiplication());
        		$divisors.addAll(e2.divisors);
                $arrayIndices.addAll($e2.arrayIndices);}}
        	| '/' e2=unary_expression {if (!error) {$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Division());
        		$divisors.addAll(e2.divisors);
        		$divisors.add($e2.ast);
                $arrayIndices.addAll($e2.arrayIndices);}}
        	| '%' e2=unary_expression {if (!error) {
        		$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()), $ast, $e2.ast, new Modulo());
        		$divisors.addAll(e2.divisors);
        		$divisors.add($e2.ast);
                $arrayIndices.addAll($e2.arrayIndices);}}
        )*
        ;

unary_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : '!'  e=parenthesized_expression {if (!error) {
        	$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()), $e.ast, null, new Negation());
        	$divisors = e.divisors; $arrayIndices = $e.arrayIndices;}}
        | '-'  e=parenthesized_expression {if (!error) {
        	$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()), $e.ast, null, new UnaryMinus());
        	$divisors = e.divisors; $arrayIndices = $e.arrayIndices;}}
        | '+'? e=parenthesized_expression {if (!error) {
        	$ast = $e.ast;
        	$divisors = e.divisors;
            $arrayIndices = $e.arrayIndices}}
        ;

parenthesized_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : '(' expression ')' {if (!error) {$ast = $expression.ast; $divisors = $expression.divisors;
                $arrayIndices = $expression.arrayIndices;}}
        | function_call {if (!error) {$ast = $function_call.ast; $divisors = $function_call.divisors;
                            $arrayIndices = $functionCall.arrayIndices;}}
        | array_read {if (!error) {$ast = $array_read.ast; $divisors = $array_read.divisors;
                        $arrayIndices = $functionCall.arrayIndices;}}
        | IDENT {if (!error) {$ast = new VariableRead(new Position($start.getLine(), $start.getCharPositionInLine()),
            new Identifier($IDENT.text)); $divisors = new LinkedList<Expression>();
            $arrayIndices = new LinkedList<Expression>();}}
        | literal_expression {if (!error) {$ast = $literal_expression.ast; $divisors = $literal_expression.divisors;
            $arrayIndices = $literalExpression.arrayIndices;}}
        ;

function_call returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
        : IDENT '(' arglist? ')' {if (!error) {
        	Expression[] params = new Expression[0];
        	if ($arglist.params != null) params = $arglist.params.toArray(new Expression[$arglist.params.size()]);
        	$ast = new FunctionCall(new Identifier($IDENT.text), params , new Position($start.getLine(), $start.getCharPositionInLine()));
        	$divisors = $arglist.divisors;
            $arrayIndices = $arglist.arrayIndices}}
        ;

arglist returns [ LinkedList<Expression> params, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
	@init {$params = new LinkedList<Expression>();}
        : e1=expression {if (!error) {$params.add((Expression) e1.ast); $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices}}
        	( ',' e2=expression {if (!error) {$params.add((Expression) $e2.ast); $divisors.addAll($e2.divisors);
                                $arrayIndices.addAll($e2.arrayIndices);}} )*
        ;

array_read returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
	@init {LinkedList<Expression> l = new LinkedList<Expression>(); $arrayIndices = new LinkedList<Expression>()}
        : IDENT '[' e1=expression {if (!error) {l.add($e1.ast); $arrayIndices.add($e1.ast);
                $arrayIndices.addAll($e1.arrayIndices);
        		$divisors = $e1.divisors;}} ']'
        	( '[' e2=expression {if (!error) {l.add($e2.ast); $arrayIndices.add($e2.ast);
                $arrayIndices.addAll($e2.arrayIndices);
        		$divisors.addAll($e2.divisors);}} ']' )*
        {if (!error) {$ast = new ArrayRead(new Position($start.getLine(), $start.getCharPositionInLine()),
            new Identifier($IDENT.text), l.toArray(new Expression[l.size()]));}}
        ;

literal_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ]
    @init {$divisors = new LinkedList<Expression>(); $arrayIndices = new LinkedList<Expression>();}
        : INT_LITERAL {if (!error) {$ast = new NumericLiteral(new Position($start.getLine(), $start.getCharPositionInLine()),
            $INT_LITERAL.text);}}
        | BOOL_LITERAL {if (!error) {$ast = new BooleanLiteral(new Position($start.getLine(), $start.getCharPositionInLine()),
            $BOOL_LITERAL.text); $divisors = new LinkedList<Expression>();}}
        ;

type returns [ Type ast ]
        : ('int' {$ast = error ? null : new IntegerType();}
        | 'bool'{$ast = error ? null : new BooleanType();}) ( '[' ']' {$ast = error ? null : new ArrayType(ast);})*
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
