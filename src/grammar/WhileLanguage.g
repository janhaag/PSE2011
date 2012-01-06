grammar WhileLanguage;

@header {
	package parser;
	import ast.*;
	import java.util.LinkedList;
}

@lexer::header {
	package parser;
}

program returns [ ASTRoot ast ]
    @init {LinkedList<Axiom> as = new LinkedList<Axiom>();
     	   LinkedList<Function> funcs = new LinkedList<Function>();}
        : (a=assume_statement {as.add(new Axiom(new Position(), (Expression) a));})*
        ( f=method_declaration {funcs.add((Function) f);} )* main_method
        {$ast = new Program(new Position(), funcs.toArray(new Function[funcs.size()]),
        		    (Function) $main_method.ast, as.toArray(new Axiom[funcs.size()]));}
        ;

single_expression returns [ ASTRoot ast ]
	: expression {$ast = $expression.ast;}
	;

method_declaration returns [ ASTRoot ast ]
        : type IDENT '(' parameter_list? ')' method_body
        {FunctionParameter[] params = new FunctionParameter[0];
        if ($parameter_list.params != null)
        	params = $parameter_list.params.toArray(new FunctionParameter[$parameter_list.params.size()]);
        $ast = new Function(new Position(), $type.type, $IDENT.text, params, (StatementBlock) $method_body.ast[1][0],
        	(Assumption[]) $method_body.ast[0], (Ensure[]) $method_body.ast[2]);}
        ;

main_method returns [ ASTRoot ast ]
        : 'main' '(' parameter_list? ')' method_body
        {FunctionParameter[] params = new FunctionParameter[0];
        if ($parameter_list.params != null)
        	params = $parameter_list.params.toArray(new FunctionParameter[$parameter_list.params.size()]);
        $ast = new Function(new Position(), null, "main", params, (StatementBlock) $method_body.ast[1][0],
        	(Assumption[]) $method_body.ast[0], (Ensure[]) $method_body.ast[2]);}
        ;

parameter_list returns [ LinkedList<FunctionParameter> params ]
    @init {params = new LinkedList<FunctionParameter>();}
        : p1=parameter {params.add(p1);} ( ',' p2=parameter {params.add(p2);})*
        ;

parameter returns [ FunctionParameter param ]
        : type IDENT {$param = new FunctionParameter($IDENT.text, $type.type);}
        ;

method_body returns [ ASTRoot[\][\] ast ]
    @init {LinkedList<Assumption> as = new LinkedList<Assumption>();
        LinkedList<Ensure> es = new LinkedList<Ensure>();}
        : '{' (a=assume_statement {as.add(new Assumption(new Position(), (Expression) a));})*
        statement_block 
        (e=ensure_statement {es.add((Ensure) e);})* '}'
        {$ast = new ASTRoot[3][];
        $ast[0] = as.toArray(new Assumption[as.size()]);
        $ast[1] = new ASTRoot[]{$statement_block.ast};
        $ast[0] = es.toArray(new Ensure[es.size()]);}
        ;

statement returns [ ASTRoot ast ]
        : assert_statement {$ast = $assert_statement.ast;}
        | variable_declaration {$ast = $variable_declaration.ast;}
        | array_declaration {$ast = $array_declaration.ast;}
        | assignment {$ast = $assignment.ast;}
        | if_statement {$ast = $if_statement.ast;}
        | while_statement {$ast = $while_statement.ast;}
        | 'return' expression ';' {$ast = new ReturnStatement(new Position(), (Expression) $expression.ast);}
        ;

invariant_statement returns [ ASTRoot ast ]
        : 'invariant' quantified_expression ';' {$ast = new Invariant(new Position(), (Expression) $quantified_expression.ast);}
        ;

assert_statement returns [ ASTRoot ast ]
        : 'assert' quantified_expression ';' {$ast = new Assertion(new Position(), (Expression) $quantified_expression.ast);}
        ;

assume_statement returns [ ASTRoot ast ]
        : 'assume' quantified_expression ';' {$ast = $quantified_expression.ast;}
        ;

ensure_statement returns [ ASTRoot ast ]
        : 'ensure' quantified_expression ';' {$ast = new Ensure(new Position(), (Expression) $quantified_expression.ast);}
        ;

assignment returns [ ASTRoot ast ]
    @init {LinkedList<ArithmeticExpression> l = new LinkedList<ArithmeticExpression>();}
        : IDENT ( '[' e=expression ']' {if (e instanceof ArithmeticExpression) l.add((ArithmeticExpression) e);
        				else throw new RuntimeException("TODO");} )* '=' value=expression ';'
        {if (l.isEmpty()) $ast = new Assignment(new Position(), (Expression) value, new Identifier($IDENT.text));
        	else $ast = new ArrayAssignment(new Position(), (Expression) value, new Identifier($IDENT.text),
         					l.toArray(new ArithmeticExpression[l.size()]));}
        ;

variable_declaration returns [ ASTRoot ast ]
        : type IDENT ( '=' expression )? ';'
        {$ast = new VariableDeclaration(new Position(), $IDENT.text, (Expression) $expression.ast, $type.type);}
        ;

array_declaration returns [ ASTRoot ast ]
    @init {LinkedList<ArithmeticExpression> indexes = new LinkedList<ArithmeticExpression>();}
        : type IDENT ( '[' e=expression {if (e instanceof ArithmeticExpression) indexes.add((ArithmeticExpression) e);
        				 else throw new RuntimeException("TODO");} ']' )+ ';'
        {$ast = new ArrayDeclaration(new Position(), $IDENT.text, $type.type,
        	indexes.toArray(new ArithmeticExpression[indexes.size()]));}
        ;

if_statement returns [ ASTRoot ast ]
        : 'if' '(' expression ')' s1=statement_block ( 'else' s2=statement_block )?
        {$ast = new Conditional(new Position(), (Expression) $expression.ast,
        	(StatementBlock) s1, (StatementBlock) s2);}
        ;
        
while_statement returns [ ASTRoot ast ]
        : 'while' '(' expression ')' loop_body
        {$ast = new Loop(new Position(), (Expression) $expression.ast,
        		 (StatementBlock) $loop_body.ast[1][0], (Invariant[]) $loop_body.ast[0]);}
        ;

loop_body returns [ ASTRoot[\][\] ast ]
    @init {LinkedList<Invariant> is = new LinkedList<Invariant>();}
        : '{' (i=invariant_statement {is.add((Invariant) i);})*
        statement_block '}'
        {$ast = new ASTRoot[2][];
        $ast[0] = is.toArray(new Invariant[is.size()]);
        $ast[1] = new ASTRoot[]{$statement_block.ast};}
        ;

statement_block returns [ ASTRoot ast ]
    @init {LinkedList<Statement> l = new LinkedList<Statement>();}
        : '{' ( s=statement {l.add((Statement) s);})* '}'
        {$ast = new StatementBlock(l.toArray(new Statement[l.size()]), new Position());}
        ;

quantified_expression returns [ ASTRoot ast ]
        : quantifier IDENT '(' range? ')' qe=quantified_expression
        {if ("forall".equals($quantifier.text)) $ast = new ForAllQuantifier(new Position(), $range.range,
       						 new Identifier($IDENT.text), (Expression) qe);
   	 else $ast = new ExistsQuantifier(new Position(), $range.range, new Identifier($IDENT.text), 
        				   (Expression) qe);}
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
        : r1=rel_expression {$ast = r1;}
        ( ( '==' {$ast = new LogicalExpression(new Position(), (Expression) $ast,
        	(Expression) r2, new Equal());}
        | '!=' {$ast = new LogicalExpression(new Position(), (Expression) $ast,
        	(Expression) r2, new NotEqual());})
        r2=rel_expression )*
        ;


rel_expression returns [ ASTRoot ast ]
        : a1=add_expression {$ast = a1;}
        ( ( '<' {$ast = new LogicalExpression(new Position(), (Expression) $ast,
        	(Expression) a2, new Less());}
        | '<=' {$ast = new LogicalExpression(new Position(), (Expression) $ast,
        	(Expression) a2, new LessEqual());}
        | '>' {$ast = new LogicalExpression(new Position(), (Expression) $ast,
        	(Expression) a2, new Greater());}
        | '>=' {$ast = new LogicalExpression(new Position(), (Expression) $ast,
        	(Expression) a2, new GreaterEqual());})
        a2=add_expression )*
        ;

add_expression returns [ ASTRoot ast ]
        : m1=mul_expression {$ast = m1;}
        ( ( '|' {$ast = new LogicalExpression(new Position(), (Expression) $ast,
        	(Expression) m2, new Disjunction());}
        | '+' {$ast = new ArithmeticExpression(new Position(), (Expression) $ast,
        	(Expression) m2, new Addition());}
        | '-' {$ast = new ArithmeticExpression(new Position(), (Expression) $ast,
        	(Expression) m2, new Subtraction());})
        m2=mul_expression )*
        ;

mul_expression returns [ ASTRoot ast ]
        : u1=unary_expression {$ast = u1;}
        ( ('&' {$ast = new LogicalExpression(new Position(), (Expression) $ast,
        	(Expression) u2, new Conjunction());}
        | '*' {$ast = new ArithmeticExpression(new Position(), (Expression) $ast,
        	(Expression) u2, new Multiplication());}
        | '/' {$ast = new ArithmeticExpression(new Position(), (Expression) $ast,
        	(Expression) u2, new Division());}
        | '%' {$ast = new ArithmeticExpression(new Position(), (Expression) $ast,
        	(Expression) u2, new Modulo());})
        u2=unary_expression )* 
        ;

unary_expression returns [ ASTRoot ast ]
   @init {boolean isLogical = false; ArithmeticOperator op = null;}
        : ( '!' {isLogical = true;}
        | '+'
        | '-' {op = new UnaryMinus();})?
        parenthesized_expression
        {if (isLogical) $ast = new LogicalExpression(new Position(), (Expression) $parenthesized_expression.ast, null, new Negation());
        else if (op != null) $ast = new ArithmeticExpression(new Position(), (Expression) $parenthesized_expression.ast, null, op);
        else $ast = $parenthesized_expression.ast;}
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
        	if ($arglist.params != null) params = $arglist.params.toArray(new Expression[$arglist.params.size()]);
        	$ast = new FunctionCall(new Identifier($IDENT.text), params , new Position());}
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
        {$ast = new ArrayRead(new Position(), new Identifier($IDENT.text), l.toArray(new ArithmeticExpression[l.size()]));}
        ;

literal_expression returns [ ASTRoot ast ]
        : INT_LITERAL {$ast = new NumericLiteral(new Position(), $INT_LITERAL.text);}
        | BOOL_LITERAL {$ast = new BooleanLiteral(new Position(), $BOOL_LITERAL.text);}
        ;

type returns [ Type type ]
        : ('int' {$type = new IntegerType();} | 'bool'{$type = new BooleanType();}) ( '[' ']' {$type = new ArrayType(type);})*
        ;

INT_LITERAL  : ('0'..'9' )+;
BOOL_LITERAL : 'true' | 'false';
COMMENT      : '#' .* ( '\n' | '\r' ) {skip();};
WS           : ('\n' | '\r' | ' ' | '\t')+ {skip();};
IDENT        : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
