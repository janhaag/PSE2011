tree grammar WhileLanguageTreeParser;

options {
	tokenVocab = WhileLanguageT;
	ASTLabelType = CommonTree;
}

@header {
	import java.util.HashMap;
	import ast.*;
}

@members {
	HashMap<String, Value> vars = new HashMap<String, Value>();
}

program returns[String output] @init{String Builder out = new StringBuilder("new Program(new Position(),"); StringBuilder temp = new StringBuilder("'new Axiom[]{'");}	
	: (s1 = axiom_statement{temp.add(s1).add(",")})* {temp.add("}");}
	   {out.add('new Function[]{');}(s2 = function_declaration{out.add(s2).add(',');})* {out.add("},");}
	   s3 = main {out.add(s3).add(",").add(temp).add(")");} {output = out.toString();}
	;
	
function_declaration returns[String s]        
	:  ^('f()' 'a')	
	;
	
main returns[String s]	
	:  ^('main' '('')' '{''}')
	;
	
axiom_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new Axiom(new Position(), new Expression(");}
	: ^('axiom' e = quantified_expression) {sb.add(e).add("))"); s = sb.toString();}	
	;

quantified_expression returns [String s]
	:  {String r = ""; StringBuilder sb = new StringBuilder("new Position(),");} QUANTIFIER IDENT  '(' r = range?')' {sb.add(r).add(",").add($IDENT.text).add(",");}
	qe = quantified_expression {sb.add(qe);}
        	| e = expression {s = e;}
        	;

 range	returns [String s]
 	: e1 = expression  e2 = expression {s = "new Range(" + e1 + "," +  e2 + ")";}	
 	;
expression returns [String s]
        	: ^('==' e1 = expression e2 = expression) {s = "new LogicalExpression(new Position()," + e1 + ","  + e2 + "'," + "new Equal())");}
        	| ^('!=' e1 = expression e2 = expression) {s = "new LogicalExpression(new Position()," + e1 + ","  + e2 + "'," + "new NotEqual())");}
  	| ^('<' e1 = expression e2 = expression)  {s = "new LogicalExpression(new Position()," + e1 + ","  + e2 + "'," + "new Less())");}
  	| ^('<=' e1 = expression e2 = expression) {s = "new LogicalExpression(new Position()," + e1 + ","  + e2 + "'," + "new LessEqual())");}
  	| ^('>' e1 = expression e2 = expression)  {s = "new LogicalExpression(new Position()," + e1 + ","  + e2 + "'," + "new Greater())");}
  	| ^('>=' e1 = expression e2 = expression) {s = "new LogicalExpression(new Position()," + e1 + ","  + e2 + "'," + "new GreaterEqual())");}
	| ^('|' e1 = expression e2 = expression)    {s = "new LogicalExpression(new Position()," + e1 + ","  + e2 + "'," + "new Disjunction())");}
  	| ^('+' e1 = expression e2 = expression)   {s = "new ArithmeticExpression(new Position()," + e1 + ","  + e2 + "'," + "new Addition())");}
  	| ^('-' e1 = expression e2 = expression)   {s = "new ArithmeticExpression(new Position()," + e1 + ","  + e2 + "'," + "new Subtraction())");}
  	| ^('&' e1 = expression e2 = expression)  {s = "new LogicalExpression(new Position()," + e1 + ","  + e2 + "'," + "new Conjunction())");}
  	| ^('*' e1 = expression e2 = expression)   {s = "new ArithmeticExpression(new Position()," + e1 + ","  + e2 + "'," + "new Multiplication())");}
  	| ^('/' e1 = expression e2 = expression)    {s = "new ArithmeticExpression(new Position()," + e1 + ","  + e2 + "'," + "new Division())");}
  	| ^('%' e1 = expression e2 = expression) {s = "new ArithmeticExpression(new Position()," + e1 + ","  + e2 + "'," + "new Modulo())");}
  	|^('!' e1 = expression) {s = "new LogicalExpression(new Position()," + e1 + ","  + "null" + "'," + "new Negation())");}
  	|'+'e1 = expression     {s = e1;}
  	|'-'e1 = expression     {s = "new ArithmeticExpression(new Position()," + e1 + ","  + "null" + "'," + "new UnaryMinus())");}
  	| IDENT	             {s = "new VariableRead(new Position(),"+$IDENT.text+")";}
  	| fc = function_call {s = fc;}
  	| ar = array_read {s = ar;}
  	|  l = literal_expression {s = l;}
  	;
  function_call returns [String s] @init{StringBuilder sb = new StringBuilder("new FunctionCall(");}
  	:  IDENT {sb.add($IDENT.text).add(",").add("new Expression[]{")} '('al = arglist {sb.add(al)}?')' {sb.add("},").add("new Position())"); s = sb.toString();}	
  	;
  arglist	returns [String s] @init{StringBuilder sb = new StringBuilder();}
  	: e1 = expression {sb.add(e1);} (e2 = expression {sb.add(",").add(e2)})*{ s = sb.toString();}	
  	;
  array_read returns [String s] @init{StringBuilder sb = new StringBuilder("new ArrayRead(new Position(),");}
  	: IDENT {sb.add($IDENT.text).add(",").add("new Expression[]{");} 
  	'[' e1 = expression {sb.add(e1);} ']' ( '[' e2 = expression ']'{sb.add(",").add(e2)} )* {sb.add("})";); s = sb.toString();}	
  	;	
  literal_expression returns [String s]
  	: INT_LITERAL {s = $INT_LITERAL.text;}
        	| BOOL_LITERAL {s = $ BOOL_LITERAL.text;}
        	;