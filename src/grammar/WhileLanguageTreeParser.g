tree grammar WhileLanguageTreeParser;

options {
	tokenVocab = WhileLanguage;
	ASTLabelType = CommonTree;
}

@header {
	import java.util.HashMap;
	import ast.*;
}

@members {
	HashMap<String, Value> vars = new HashMap<String, Value>();
	Position p = new Position();
}

program returns[Program program] @init{LinkedList<Function> functions = new LinkedList<Funktion>();
	LinkedList<Axiom> axioms = new LinkedList<Axiom>();}	
	:  (a = axiom_statement {axioms.add(a);})* (f = function_declaration {functions.add(f);})*  m = main	{program = new Program(p,  functions.toArray(), m, axioms.toArray());}
	;
	
function_declaration returns[Function f]        
	:  'f()'	
	;
	
main returns[Function m]	
	:  'main''('')''{''}'
	;
	
axiom_statement returns [Axiom a]
	: 'axiom'	
	;
