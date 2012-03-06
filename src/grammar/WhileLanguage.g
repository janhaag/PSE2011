grammar WhileLanguage;

@header {
	package parser;
	import ast.*;
	import java.util.LinkedList;

    import static misc.WhileLanguageParserUtils.*;
    import misc.Pair;
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
        : (a=axiom_statement {if (!error) axiom.add($a.result);})*
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
        : 'main' '(' parameter_list? ')' main_body
                {LinkedList<FunctionParameter> params = error ? null :
        		$parameter_list.params != null ? $parameter_list.params : new LinkedList<FunctionParameter>();
        	$ast = error ? null : new Function(new Position($start.getLine(), $start.getCharPositionInLine()), null, "main",
        		params.toArray(new FunctionParameter[params.size()]),
        		$main_body.ast, $main_body.pre.toArray(new Assumption[$main_body.pre.size()]),
        		$main_body.post.toArray(new Ensure[$main_body.post.size()]));}
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
          '{' ( statement {if (!error) { s.addAll(possibleDivByZero($statement.divisors)); s.addAll(possibleNotPositive($statement.positive));
            s.addAll(possibleArrayOutOfBounds($statement.arrayIndices)); s.add($statement.ast); }} )*
            r=return_statement{s.addAll(possibleArrayOutOfBounds(r.arrayIndices)); s.add(r.ast);}  '}'
              {$ast = error ?null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position($start.getLine(), $start.getCharPositionInLine()));}
          e=ensure_statement? {$post = error ? null : $e.result != null ? $e.result : new LinkedList<Ensure>();}
        ;


main_body returns [ StatementBlock ast, LinkedList<Assumption> pre, LinkedList<Ensure> post ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : a=assume_statement? {$pre = error ? null : $a.result != null ? $a.result : new LinkedList<Assumption>();}
          '{' {s.add(new Assertion(new Position($start.getLine(), $start.getCharPositionInLine()), new BooleanLiteral(new Position($start.getLine(), $start.getCharPositionInLine()), "true")));}
            ( statement {if (!error) { s.addAll(possibleDivByZero($statement.divisors)); s.addAll(possibleNotPositive($statement.positive));
            s.addAll(possibleArrayOutOfBounds($statement.arrayIndices)); s.add($statement.ast); }} )* '}'
              {$ast = error ?null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position($start.getLine(), $start.getCharPositionInLine()));}
          e=ensure_statement? {$post = error ? null : $e.result != null ? $e.result : new LinkedList<Ensure>();}
        ;

if_body returns [ StatementBlock ast ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : '{' ( statement {if (!error) {s.addAll(possibleDivByZero($statement.divisors));
            s.addAll(possibleArrayOutOfBounds($statement.arrayIndices)); s.addAll(possibleNotPositive($statement.positive));
            s.add($statement.ast);}} )* '}'
            {$ast = error ? null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position($start.getLine(), $start.getCharPositionInLine()));}
        ;

loop_body returns [ StatementBlock ast, LinkedList<Invariant> pre, LinkedList<Ensure> post ]
	@init {LinkedList<Statement> s = new LinkedList<Statement>();}
        : i=invariant_statement? {$pre = error ? null : $i.result != null ? $i.result : new LinkedList<Invariant>();}
          '{' ( statement {if (!error) {s.addAll(possibleDivByZero($statement.divisors));
            s.addAll(possibleArrayOutOfBounds($statement.arrayIndices)); s.addAll(possibleNotPositive($statement.positive));
            s.add($statement.ast);}} )* '}'
              {$ast = error ? null : new StatementBlock(s.toArray(new Statement[s.size()]),
              new Position($start.getLine(), $start.getCharPositionInLine()));}
       	  e=ensure_statement? {$post = error ? null : $e.result != null ? $e.result : new LinkedList<Ensure>();}
        ;

statement returns [ Statement ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices,
				LinkedList<Expression> positive ]
        : e1=assert_statement {if (!error) {$ast = $e1.ast; $divisors = new LinkedList<Expression>();
                                $arrayIndices = new LinkedList<Pair<ArrayRead, Expression>>();}}
        | e2=variable_declaration {if (!error) {$ast = $e2.ast; $divisors = $e2.divisors; $arrayIndices = $e2.arrayIndices;}}
        | e3=array_declaration {if (!error) {$ast = $e3.ast; $divisors = $e3.divisors; $arrayIndices = $e3.arrayIndices; $positive = $e3.positive;}}
        | e4=assignment {if (!error) {$ast = $e4.ast; $divisors = $e4.divisors; $arrayIndices = $e4.arrayIndices;}}
        | e5=if_statement {if (!error) {$ast = $e5.ast; $divisors = $e5.divisors; $arrayIndices = $e5.arrayIndices;}}
        | e6=while_statement {if (!error) {$ast = $e6.ast; $divisors = $e6.divisors; $arrayIndices = $e6.arrayIndices;}}
        ;

invariant_statement returns [ LinkedList<Invariant> result ]
	@init {$result = new LinkedList<Invariant>();}
        : 'invariant' e1=quantified_expression ';' {if (!error) {
            $result.add(new Invariant(new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast));}}
        | 'invariant' '{' (e2=quantified_expression ';' {if (!error) {
            $result.add(new Invariant(new Position($start.getLine(), $start.getCharPositionInLine()), $e2.ast));}} )+ '}'
        ;

axiom_statement returns [ Axiom result ]
        : 'axiom' e1=quantified_expression ';' {if (!error) {
            $result = new Axiom(new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast);}}
        ;

assert_statement returns [ Assertion ast ]
        : 'assert' e1=quantified_expression ';' {if (!error) {$ast = new Assertion(
                    new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast);}}
        ;

assume_statement returns [ LinkedList<Assumption> result ]
	@init {$result = new LinkedList<Assumption>();}
        : 'assume' e1=quantified_expression ';' {if (!error) {
            $result.add(new Assumption(new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast));}}
        | 'assume' '{' (e2=quantified_expression ';' {if (!error) {
            $result.add(new Assumption(new Position($start.getLine(), $start.getCharPositionInLine()), $e2.ast));}} )+ '}'
        ;

ensure_statement returns [ LinkedList<Ensure> result ]
	@init {$result = new LinkedList<Ensure>();}
       	: 'ensure' e1=quantified_expression ';' {if (!error) {
            $result.add(new Ensure(new Position($start.getLine(), $start.getCharPositionInLine()), $e1.ast));}}
        | 'ensure' '{' (e2=quantified_expression ';' {if (!error) {
            $result.add(new Ensure(new Position($start.getLine(), $start.getCharPositionInLine()), $e2.ast));}} )+ '}'
        ;

assignment returns [ Assignment ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
    @init {$divisors = new LinkedList<Expression>();  LinkedList<Expression> currentIndices = new LinkedList<Expression>();
	$arrayIndices = new LinkedList<Pair<ArrayRead, Expression>>();}
        : IDENT '=' expression ';' {if (!error) {$ast = new Assignment(new Position($start.getLine(), $start.getCharPositionInLine()),
                $expression.ast, new Identifier($IDENT.text));
            $divisors = $expression.divisors; $arrayIndices = $expression.arrayIndices;}}
        | IDENT {LinkedList<Expression> idx = new LinkedList<Expression>();}
        	( '[' e1=expression {if (!error) {idx.add($e1.ast);
        	$arrayIndices.add(new Pair<ArrayRead, Expression>(new ArrayRead(new Position($start.getLine(), $start.getCharPositionInLine()),
        		new Identifier($IDENT.text), currentIndices.toArray(new Expression[currentIndices.size()])), $e1.ast));
                currentIndices.add($e1.ast); $divisors.addAll($e1.divisors); $arrayIndices.addAll($e1.arrayIndices);}}
          ']' )+ '=' e2=expression ';'
            {if (!error) {$ast = new ArrayAssignment(new Position($start.getLine(), $start.getCharPositionInLine()),
                           $e2.ast, new Identifier($IDENT.text),
        				   idx.toArray(new Expression[idx.size()]));
            $divisors.addAll($e2.divisors);
            $arrayIndices.addAll($e2.arrayIndices);}}
        ;

variable_declaration returns [ VariableDeclaration ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : type IDENT ( '=' expression )? ';' {if (!error) {
        	Expression init = $expression.ast != null ? $expression.ast : null;
        	$ast = new VariableDeclaration(new Position($start.getLine(), $start.getCharPositionInLine()), $IDENT.text, init, $type.ast);
            $divisors = $expression.ast != null ? $expression.divisors : new LinkedList<Expression>();
            $arrayIndices = $expression.ast != null ? $expression.arrayIndices : null;}}
        ;

array_declaration returns [ ArrayDeclaration ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices,
				LinkedList<Expression> positive ]
        : type IDENT '=' array_init ';' {if (!error) {
        	Expression[] dim = $array_init.dim.toArray(new Expression[$array_init.dim.size()]);
        	$ast = new ArrayDeclaration(new Position($start.getLine(), $start.getCharPositionInLine()), $IDENT.text, $type.ast, dim);
            $divisors = $array_init.divisors;$arrayIndices = $array_init.arrayIndices; $positive = $array_init.dim;}}
        ;

array_init returns [ LinkedList<Expression> dim, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
    @init {$divisors = new LinkedList<Expression>();$dim = new LinkedList<Expression>();$arrayIndices = new LinkedList<Pair<ArrayRead, Expression>>();}
	: 'array' ( '[' expression {if (!error) {$dim.add($expression.ast); $divisors.addAll($expression.divisors);
        $arrayIndices.addAll($expression.arrayIndices);}} ']' )+
	;

if_statement returns [ Conditional ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : 'if' '(' expression ')' b1=if_body ( 'else' b2=if_body )? {if (!error) {
        	$ast = new Conditional(new Position($start.getLine(), $start.getCharPositionInLine()), $expression.ast, $b1.ast, $b2.ast);
            $divisors = $expression.divisors;$arrayIndices = $expression.arrayIndices;}}
        ;

while_statement returns [ Loop ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : 'while' '(' expression ')' loop_body {if (!error) {
		Invariant[] i = new Invariant[0];
		i = $loop_body.pre != null ? $loop_body.pre.toArray(new Invariant[$loop_body.pre.size()]) : null;
		Ensure[] e = new Ensure[0];
		e = $loop_body.post != null ? $loop_body.post.toArray(new Ensure[$loop_body.post.size()]) : null;
       	$ast = new Loop(new Position($start.getLine(), $start.getCharPositionInLine()), $expression.ast, $loop_body.ast, i, e);
        $divisors = $expression.divisors;$arrayIndices = $expression.arrayIndices;}}
        ;

return_statement returns [ ReturnStatement ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
	: 'return' expression ';' {if (!error) {
        $ast = new ReturnStatement(new Position($start.getLine(), $start.getCharPositionInLine()), $expression.ast);
        $divisors = $expression.divisors;$arrayIndices = $expression.arrayIndices;}}
	;

quantified_expression returns [ Expression ast ]
        : qe_helper[new LinkedList<Expression>(), new LinkedList<Pair<ArrayRead, Expression>>()]
          { if (!error) $ast = $qe_helper.ast; }
        ;

qe_helper [ LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ] returns [ Expression ast ]
       @init {Range r = null;}
        : QUANTIFIER IDENT '(' (range {if (!error) {
        		r = new Range($range.e1, $range.e2);
        		$divisors.addAll($range.divisors);
                $arrayIndices.addAll($range.arrayIndices);
        	}})? ')' ex=qe_helper[divisors, arrayIndices] {if (!error) {
        	if ("forall".equals($QUANTIFIER.text))
        	    $ast = new ForAllQuantifier(new Position($start.getLine(), $start.getCharPositionInLine()), r, new Identifier($IDENT.text),
        				$ex.ast);
            else $ast = new ExistsQuantifier(new Position($start.getLine(), $start.getCharPositionInLine()), r, new Identifier($IDENT.text),
        				$ex.ast);
        	}}
        | expression {if (!error) {
            $divisors.addAll($expression.divisors);
            $arrayIndices.addAll($expression.arrayIndices);
            $ast = $expression.ast;
            for (Expression e : divisors) {
                $ast = new LogicalExpression(e.getPosition(), new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new NotEqual()), $ast, new Conjunction());
            }
            for (Pair<ArrayRead, Expression> p : arrayIndices) {
                Expression e = p.getValue2();
                ArrayRead a = p.getValue1();
                LogicalExpression lower = new LogicalExpression(e.getPosition(), e,
                        new NumericLiteral(e.getPosition(), "0"), new GreaterEqual());
                LogicalExpression upper = new LogicalExpression(e.getPosition(), e,
                        new FunctionCall(new Identifier("length"), new Expression[] {a},
                            e.getPosition()), new Less());
                $ast = new LogicalExpression(e.getPosition(), new LogicalExpression(e.getPosition(), lower, upper, new Conjunction()),
                        $ast, new Conjunction());
            }
        }}
        ;

range returns [ Expression e1, Expression e2, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : l=expression ',' u=expression {if (!error) {
        	$e1=l.ast; $e2=u.ast;
        	$divisors = l.divisors;
        	$divisors.addAll(u.divisors);
            $arrayIndices = $l.arrayIndices;
            $arrayIndices.addAll($u.arrayIndices);}}
        ;

expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : e1=rel_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}} (
        	  '==' e2=rel_expression {if (!error && $e2.ast != null) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Equal());
        	  	$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '!=' e2=rel_expression {if (!error && $e2.ast != null) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new NotEqual());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        )*
        ;


rel_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : e1=add_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}} (
        	  '<'  e2=add_expression {if (!error && $e2.ast != null) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Less());
        	  	$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '<=' e2=add_expression {if (!error && $e2.ast != null) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new LessEqual());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '>'  e2=add_expression {if (!error && $e2.ast != null) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Greater());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '>=' e2=add_expression {if (!error && $e2.ast != null) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new GreaterEqual());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        )*
        ;

add_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : e1=mul_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}} (
        	  '|' e2=mul_expression {if (!error && $e2.ast != null) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Disjunction());
        	  	$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '+' e2=mul_expression {if (!error && $e2.ast != null) {$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Addition());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        	| '-' e2=mul_expression {if (!error && $e2.ast != null) {$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Subtraction());
        		$divisors.addAll(e2.divisors);$arrayIndices.addAll($e2.arrayIndices);}}
        )*
        ;

mul_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : e1=unary_expression {if (!error) {$ast = e1.ast; $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}} (
        	  '&' e2=unary_expression {if (!error && $e2.ast != null) {$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Conjunction());
        	  	$divisors.addAll(e2.divisors);
                $arrayIndices.addAll($e2.arrayIndices);}}
        	| '*' e2=unary_expression {if (!error && $e2.ast != null) {$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Multiplication());
        		$divisors.addAll(e2.divisors);
                $arrayIndices.addAll($e2.arrayIndices);}}
        	| '/' e2=unary_expression {if (!error && $e2.ast != null) {$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()),
                    $ast, $e2.ast, new Division());
        		$divisors.addAll(e2.divisors);
        		$divisors.add($e2.ast);
                $arrayIndices.addAll($e2.arrayIndices);}}
        	| '%' e2=unary_expression {if (!error && $e2.ast != null) {
        		$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()), $ast, $e2.ast, new Modulo());
        		$divisors.addAll(e2.divisors);
        		$divisors.add($e2.ast);
                $arrayIndices.addAll($e2.arrayIndices);}}
        )*
        ;

unary_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : '!'  e=parenthesized_expression {if (!error && $e.ast != null) {
        	$ast = new LogicalExpression(new Position($start.getLine(), $start.getCharPositionInLine()), $e.ast, null, new Negation());
        	$divisors = e.divisors; $arrayIndices = $e.arrayIndices;}}
        | '-'  e=parenthesized_expression {if (!error && $e.ast != null) {
        	$ast = new ArithmeticExpression(new Position($start.getLine(), $start.getCharPositionInLine()), $e.ast, null, new UnaryMinus());
        	$divisors = $e.divisors; $arrayIndices = $e.arrayIndices;}}
        | '+'? e=parenthesized_expression {if (!error && $e.ast != null) {
        	$ast = $e.ast;
        	$divisors = $e.divisors;
            $arrayIndices = $e.arrayIndices;}}
        ;

parenthesized_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : '(' expression ')' {if (!error) {$ast = $expression.ast; $divisors = $expression.divisors;
                $arrayIndices = $expression.arrayIndices;}}
        | function_call {if (!error) {$ast = $function_call.ast; $divisors = $function_call.divisors;
                            $arrayIndices = $function_call.arrayIndices;}}
        | array_read {if (!error) {$ast = $array_read.ast; $divisors = $array_read.divisors;
                        $arrayIndices = $array_read.arrayIndices;}}
        | IDENT {if (!error) {$ast = new VariableRead(new Position($start.getLine(), $start.getCharPositionInLine()),
            new Identifier($IDENT.text)); $divisors = new LinkedList<Expression>();
            $arrayIndices = new LinkedList<Pair<ArrayRead, Expression>>();}}
        | literal_expression {if (!error) {$ast = $literal_expression.ast; $divisors = $literal_expression.divisors;
            $arrayIndices = $literal_expression.arrayIndices;}}
        ;

function_call returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
        : IDENT '(' arglist? ')' {if (!error) {
        	Expression[] params = new Expression[0];
            boolean args = false;
        	if ($arglist.params != null) args = true;
            if (args) params = $arglist.params.toArray(new Expression[$arglist.params.size()]);
        	$ast = new FunctionCall(new Identifier($IDENT.text), params , new Position($start.getLine(), $start.getCharPositionInLine()));
        	$divisors = args ? $arglist.divisors : new LinkedList<Expression>();
            $arrayIndices = args ? $arglist.arrayIndices : new LinkedList<Pair<ArrayRead, Expression>>();}}
        ;

arglist returns [ LinkedList<Expression> params, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
	@init {$params = new LinkedList<Expression>();}
        : e1=expression {if (!error) {$params.add((Expression) e1.ast); $divisors = $e1.divisors; $arrayIndices = $e1.arrayIndices;}}
        	( ',' e2=expression {if (!error) {$params.add((Expression) $e2.ast); $divisors.addAll($e2.divisors);
                                $arrayIndices.addAll($e2.arrayIndices);}} )*
        ;

array_read returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
	@init {LinkedList<Expression> l = new LinkedList<Expression>(); LinkedList<Expression> currentIndices = new LinkedList<Expression>();
	$arrayIndices = new LinkedList<Pair<ArrayRead, Expression>>();}
        : IDENT '[' e1=expression {if (!error) {l.add($e1.ast);
        	$arrayIndices.add(new Pair<ArrayRead, Expression>(new ArrayRead(new Position($start.getLine(), $start.getCharPositionInLine()),
        		new Identifier($IDENT.text), currentIndices.toArray(new Expression[currentIndices.size()])), $e1.ast));
                currentIndices.add($e1.ast); $arrayIndices.addAll($e1.arrayIndices);
        		$divisors = $e1.divisors;}} ']'
        	( '[' e2=expression {if (!error) {l.add($e2.ast);
        	$arrayIndices.add(new Pair<ArrayRead, Expression>(new ArrayRead(new Position($start.getLine(), $start.getCharPositionInLine()),
        		new Identifier($IDENT.text), currentIndices.toArray(new Expression[currentIndices.size()])), $e2.ast));
                currentIndices.add($e2.ast); $arrayIndices.addAll($e2.arrayIndices);
        		$divisors.addAll($e2.divisors);}} ']' )*
        {if (!error) {$ast = new ArrayRead(new Position($start.getLine(), $start.getCharPositionInLine()),
            new Identifier($IDENT.text), l.toArray(new Expression[l.size()]));}}
        ;

literal_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Pair<ArrayRead, Expression>> arrayIndices ]
    @init {$divisors = new LinkedList<Expression>(); $arrayIndices = new LinkedList<Pair<ArrayRead, Expression>>();}
        : INT_LITERAL {if (!error) {$ast = new NumericLiteral(new Position($start.getLine(), $start.getCharPositionInLine()),
            $INT_LITERAL.text);}}
        | BOOL_LITERAL {if (!error) {$ast = new BooleanLiteral(new Position($start.getLine(), $start.getCharPositionInLine()),
            $BOOL_LITERAL.text);}}
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
