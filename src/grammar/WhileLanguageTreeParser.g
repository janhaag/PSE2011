tree grammar WhileLanguageTreeParser;

options {
	tokenVocab = WhileLanguageT;
	ASTLabelType = CommonTree;
	backtrack = true;
}

@header {
	import java.util.HashMap;
	import ast.*;
}

@members {
	HashMap<String, Value> vars = new HashMap<String, Value>();
}


program returns[String output] @init{String Builder out = new StringBuilder("new Program(new Position(),"); StringBuilder temp = new StringBuilder("'new Axiom[]{'");}	
	: (s1 = axiom_statement{temp.append($s1.s).append(",")})* {temp.append("}");}
	   {out.append('new Function[]{');}(s2 = function_declaration{out.append($s2.s).append(',');})* {out.append("},");}
	   s3 = main {out.append($s3.s).append(",").append(temp.toString()).append(")");} {output = out.toString();}
	;
	
function_declaration returns[String s]    @init {StringBuilder sb = new StringBuilder("new Function(new Position(), "; String h = "null";}    
	:  t = type {sb.append($t.s).append(",");} IDENT {sb.append($IDENT.text).append(",");} '(' pl = parameter_list {h = $pl.s}?{sb.append(h).append(",")} ')'
	fb = function_body {sb.append($fb.s).append(")"); s = sb.toString();}	
	;
parameter_list returns [String s] @init {StringBuilder sb = new StringBuilder("new FunctionParameter[]{";}
	: p1 = parameter {sb.append($p1.s);} (p2 = parameter {sb.add(",").append($p2.s);})* {sb.append("}"); s = sb.toString();}	
	;
parameter returns [String s]
	: t = type IDENT {s = "new FunctionParameter(" + $IDENT.text + ","+$t.s+ ")";}	
	;
function_body returns [String s] @init {StringBuilder sb = new StringBuilder("new StatementBlock("; StringBuilder temp = new StringBuilder("new Assumption[]{");}
	: a = assume_statement{temp.append($a.s).append("}");} 
	{sb.append("new StatementBlock(new Statement[]{");}( s1 = statement {sb.append($s1.s).append(",");})* rs = return_statement {sb.append($rs.s).append("})").append(temp.toString());}  e = ensure_statement{sb.append($a.s).append("}");}{s = sb.toString();}
	|{temp.append("null")} 
	(statement)* return_statement {sb.append(temp.toString());}  e = ensure_statement{sb.append($a.s).append("}");}{s = sb.toString();}
	| a = assume_statement{temp.append($a.s).append("}")} 
	{sb.append("new StatementBlock(");}(statement)* return_statement {sb.append(")").append(temp.toString());} {sb.append("null");}{s = sb.toString();}
	|{temp.append("null");} {sb.append("new StatementBlock(");}(statement)* return_statement {sb.append(")").append(temp.toString());}  {sb.append("null");}{s = sb.toString();}
	;
	
main returns [String s] @init {StringBuilder sb = new StringBuilder("new Function(new Position(), null, main, "; String h = "null";}
        : ^('main' '(' pl = parameter_list {h = $pl.s}?{sb.append(h).append(",")} ')'  mb = main_body {sb.append($mb.s).append(")"); s = sb.toString();})
        ;
        
 main_body returns [String s]
        :	 a = assume_statement?{temp.append($a.s).append("}");} 
	{sb.append("new StatementBlock(new Statement[]{");} s1 = statement  {sb.append($s1.s);} ( s2 = statement {sb.append(",").append($s2.s);})*  {sb.append("})").append(temp.toString());}  e = ensure_statement?{sb.append($a.s).append("}");}{s = sb.toString();}
	;      
        
assume_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new Assuption(new Position(),";}
	: ^('assume' qe1 = quantified_expression {sb.append($qe1.s).append(")");}
	(qe2 = quantified_expression {sb.append(",new Assuption(new Position(),").append($qe2.s).append(")");})* ) {s = sb.toString();}
	;
ensure_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new Ensure(new Position(),";}
	: ^('ensure' qe1 = quantified_expression {sb.append($qe1.s).add(")");}
	(qe2 = quantified_expression {sb.append(",new Ensure(new Position(),").append($qe2.s).append(")");})* ) {s = sb.toString();}
	;
return_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new ReturnStatement(new Position(),";}
	: ^('return' e = expression {sb.append($e.s).append(")");}) {s = sb.toString();}
	;
statement returns [String s]
	: e1=assert_statement {s = $e1.s;}
        	| e2=variable_declaration {s = $e2.s;}
        	| e3=array_declaration {s = $e3.s;}
        	| e4=assignment {s = $e4.s;}
       	 |e5=if_statement {s = $e5.s;}
        	| e6=while_statement {s = $e6.s;}	
	;

assert_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new Assertion(new Position(),");}
	: ^('assert' e = quantified_expression{sb.append($e.s).append(")");s = sb.toString();})	
	;
	
variable_declaration returns [String s]
        	: ^('=' type IDENT e = expression) {s = "new VariableDeclaration(new Position(),"+$IDENT.text+", "+ $e.s +"," + $t.s+")";}
        	| t = type IDENT {s = "new VariableDeclaration(new Position(),"+$IDENT.text+", null," + $t.s+")";}
        	;
        	
array_declaration returns  [String s]
        : ^('=' t = type IDENT a = array_init) {s = "new ArrayDeclaration(new Position()," + $IDENT.text + "," + $t.s + "," + "new Expression[] {"+a+"})";}
        ;
        
array_init returns [String s] @init {StringBuilder sb = new StringBuilder();}
	: ^('array' e1 = expression {sb.append($e1.s);} (e2 = expression {sb.append(",").append($e2.s);})*) {s = sb.toString();}
	; 
	   
assignment returns [String s]
        	: ^('=' IDENT e = expression) {s = "new Assignment(new Position(),"+$e.s +", new Identifier("+$IDENT.text+"))"}
        	| {StringBuilder sb = new StringBuilder("new ArrayAssignment(new Position(),"); StringBuilder temp = new StringBuilder("newExpression[]{");} 
        	 ^('=' IDENT  '[' e1 = expression ']' {temp.append($e1.s);} ( '[' e2 = expression ']'{temp.append(",").append($e2.s)} )* {temp.append("}");} 
        	 e3 = expression {sb.append($e3.s).append(",new Identifier(").append($IDENT.text).append("),").append(temp.toString());}) {s = sb.toString();}
       	;
       	
if_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new Conditional(new Position(),");}
        : ^('if' e = expression {sb.append($e.s).append(", new StatementBlock(new Statement[]{");}   s1 = statement {sb.append($s1.s);}
        (s2 = statement {sb.append(",").append($s2.s)})*{sb.append("}, null)");}) {s = sb.toString()}
        | ^('if' e = expression {sb.append($e.s).append(", new StatementBlock(new Statement[]{");} {sb.append("},null)");}) {s = sb.toString()}
        | ^('if' e = expression   {sb.append($e.s).append(", new StatementBlock(new Statement[]{");} 
          s1 = statement {sb.append($s1.s);} (s2 = statement {sb.append(",").append($s2.s)})*
          'else'  {sb.append(", new StatementBlock(new Statement[]{");} 
          s1 = statement  {sb.append($s1.s);} (s2 = statement {sb.append(",").append($s2.s)})*) {sb.append("})");} {s = sb.toString();}
        | ^('if' e = expression  {sb.append($e.s).append(", new StatementBlock(new Statement[]{");} 
        'else'  {sb.append(", new StatementBlock(new Statement[]{");}
        s1 = statement {sb.append($s1.s);} {sb.append($s1.s);} (s2 = statement {sb.append(",").append($s2.s)})*) {sb.append("})");} {s = sb.toString();}
        | ^('if' e = expression   {sb.append($e.s).append(", new StatementBlock(new Statement[]{");}  
          s1 = statement  {sb.append($s1.s);} (s2 = statement {sb.append(",").append($s2.s)})* 'else' {sb.append(", new StatementBlock(new Statement[]{})");}) {s = sb.toString();}
        |^('if' e = expression    {sb.append($e.s).append(", new StatementBlock(new Statement[]{}");} 
         'else'{sb.append(", new StatementBlock(new Statement[]{})");}) {s = sb.toString();}
        ;
        

while_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new Loop(new Position(),");}
       	 : ^('while'  e = expression {sb.append($e.s).append(",");}
       	   i = invariant_statement  {sb.append($i.s).append(", new StatementBlock(new Statement{").append($l.s);}
       	   s1 = statement {sb.append($s1.s);} (s2 = statement {sb.append(",").append($s2.s)})*  {sb.append("}")} e = ensure_statement {sb.append($e.s);}) {s = sb.toString();}
       	   | ^('while'  e = expression {sb.append($e.s).append(",");}
       	   i = invariant_statement  {sb.append($i.s).append(", new StatementBlock(new Statement{").append($l.s);}
       	    {sb.append("}")} e = ensure_statement {sb.append($e.s);}) {s = sb.toString();}
        	;
        	
 invariant_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new Invariant(new Position(),";}
	: ^('invariant' qe1 = quantified_expression {sb.append($qe1.s).append(")");}
	(qe2 = quantified_expression {sb.append(",new Invariant(new Position(),").append($qe2.s).append(")");})* ) {s = sb.toString();}
	;
        	       	
axiom_statement returns [String s] @init {StringBuilder sb = new StringBuilder("new Axiom(new Position(),");}
	: ^('axiom' e = quantified_expression{sb.append($e.s).append(")");s = sb.toString();})	
	;

quantified_expression returns [String s]
	:  {String r = "null"; StringBuilder sb = new StringBuilder("new QuantifiedExpression(new Position(),");}
	QUANTIFIER IDENT  '(' r = range?')' {sb.append($r.s).append(",").append($IDENT.text).append(",");}
	qe = quantified_expression {sb.append($qe.s).append(")");}
        	| e = expression {s = $e.s;}
        	;

 range	returns [String s]
 	: e1 = expression  e2 = expression {s = "new Range(" + $e1.s + "," +  $e2.s + ")";}	
 	;
expression returns [String s]
        	: ^('==' e1 = expression e2 = expression) {s = "new LogicalExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Equal())");}
        	| ^('!=' e1 = expression e2 = expression) {s = "new LogicalExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new NotEqual())");}
  	| ^('<' e1 = expression e2 = expression)  {s = "new LogicalExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Less())");}
  	| ^('<=' e1 = expression e2 = expression) {s = "new LogicalExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new LessEqual())");}
  	| ^('>' e1 = expression e2 = expression)  {s = "new LogicalExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Greater())");}
  	| ^('>=' e1 = expression e2 = expression) {s = "new LogicalExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new GreaterEqual())");}
	| ^('|' e1 = expression e2 = expression)    {s = "new LogicalExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Disjunction())");}
  	| ^('+' e1 = expression e2 = expression)   {s = "new ArithmeticExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Addition())");}
  	| ^('-' e1 = expression e2 = expression)   {s = "new ArithmeticExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Subtraction())");}
  	| ^('&' e1 = expression e2 = expression)  {s = "new LogicalExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Conjunction())");}
  	| ^('*' e1 = expression e2 = expression)   {s = "new ArithmeticExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Multiplication())");}
  	| ^('/' e1 = expression e2 = expression)    {s = "new ArithmeticExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Division())");}
  	| ^('%' e1 = expression e2 = expression) {s = "new ArithmeticExpression(new Position()," + $e1.s + ","  + $e2.s  + "'," + "new Modulo())");}
  	|^('!' e1 = expression) {s = "new LogicalExpression(new Position()," + $e1.s + ","  + "null" + "'," + "new Negation())");}
  	|'+'e1 = expression     {s = $e1.s;}
  	|'-'e1 = expression     {s = "new ArithmeticExpression(new Position()," + $e1.s + ","  + "null" + "'," + "new UnaryMinus())");}
  	| IDENT	             {s = "new VariableRead(new Position(),"+$IDENT.text+")";}
  	| fc = function_call {s = $fc.s;}
  	| ar = array_read {s = $ar.s;}
  	|  l = literal_expression {s = $l.s;}
  	;
  function_call returns [String s] @init{StringBuilder sb = new StringBuilder("new FunctionCall(");}
  	:  IDENT {sb.add($IDENT.text).append(",").append("new Expression[]{")} '('al = arglist {sb.append($al.s)}?')' {sb.append("},").append("new Position())"); s = sb.toString();}	
  	;
  arglist	returns [String s] @init{StringBuilder sb = new StringBuilder();}
  	: e1 = expression {sb.append($e1.s );} (e2 = expression {sb.append(",").append($e2.s )})*{ s = sb.toString();}	
  	;
  array_read returns [String s] @init{StringBuilder sb = new StringBuilder("new ArrayRead(new Position(),");}
  	: IDENT {sb.append($IDENT.text).append(",").append("new Expression[]{");} 
  	'[' e1 = expression {sb.append($e1.s );} ']' ( '[' e2 = expression ']'{sb.append(",").append($e2.s )} )* {sb.append("})";); s = sb.toString();}	
  	;	
  literal_expression returns [String s]
  	: INT_LITERAL {s = $INT_LITERAL.text;}
        	| BOOL_LITERAL {s = $ BOOL_LITERAL.text;}
        	;
  type 	returns [String s]
  	:{String type;}('int' {type = "new IntegerType()";}| 'bool' {type = "new IntegerType()";}) ( '[' ']')+ {s = "new ArrayType("+type+")";}
  	| 'int' {s = "new IntegerType()"}
  	| 'bool' {s = "new BooleanType()"}	
  	;