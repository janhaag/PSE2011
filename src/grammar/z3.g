grammar z3;

@header {
    package verifier.smtlib.z3;

    import java.util.LinkedList;
    import java.util.HashMap;
    import misc.Pair;
}

@lexer::header {
    package verifier.smtlib.z3;
}

start	returns[LinkedList<Pair<Boolean,String>> list] @init{list = new LinkedList<Pair<Boolean,String>>();}
	:(pair = block{$list.add($pair.result);})+
	;

block	returns[Pair<Boolean, String> result]
	:'unsat'
	   .* {$result = new Pair(true,"");}
	|  'sat'
	   example = model {$result = new Pair(false, $example.example);}
	| 'unknown'
	 .* {$result = new Pair(true,"unknown");}
	;

model	returns [String example] @init{$example = ""; HashMap<String,String> m = new HashMap<String,String>(); String h; Int i, Int m = 0;}
	:	'(model' (
		('(define-fun' id = IDENT  '('('('IDENT('!' INT)*  TYPE')')*')' TYPE val = value ')'
       			 {$example += $id.text + "=" + $val.content + "; ";} )
	|	('(define-fun'  id = IDENT '(' ')' {$example = $id.text;}
        		'(Array'(TYPE {$example += "[ ]";})+ TYPE  ')'
		'(' '_' 'as-array'  id2 = (IDENT ('!' INT)*)')'')' {m.put($id2.text,$id.text);}{$example += "; ";})
	|	('(define-fun' id3 = IDENT ('!' INT)+ {i = 0;}'('('('IDENT ('!' INT)+ TYPE')'{i++;})*')' TYPE {h = m.get($id3.text);
		h = (h != null? h : $id3.text); if(i > 1){h += "!" + Integer.toString(m++);}}
       		( '('  ass = ite[h] {$example += $ass.assignment;}')' 
       		| '('f = function[h] {$example += $f.assignment;}')')?(v = value{$example += h + "=" + $v.content;})?')'))*
		')'
	;

ite	[String id] returns[String assignment] @init{$assignment = id;}
	:	'ite' '(' '=' IDENT '!' INT i = INT')'  val = value
        {$assignment += "[" + $i.text + "]" + "=" + $val.content;}
        (v = value {$assignment += " else " + $v.content + "; ";} | '('as=ite[id]')'{$assignment += $as.assignment;})
	|	'ite''(''and'('(''=' IDENT '!' INT i = INT')'{$assignment += "["+$i.text+"]";})+')'
        val=value {$assignment += "=" + $val.content + "; ";}(v = value {$assignment += " else " + $v.content + "; ";}| '('as=ite[id]')'{$assignment += as;})
	;



function	[String id] returns [String assignment]
	: id1 = IDENT ('!' INT)* {$assignment = id + '=' + $id1.text;} (val = value {$assignment += $val.content;}| id2 = IDENT{$assignment += $id2.text;} ('!' INT)* 
	| '('f = functionvalue')' {$assignment += '(' + $f.assignment + ')';}) {$assignment += ';';}	
	;
functionvalue returns [String assignment]
	: id1 = IDENT ('!' INT)* {$assignment = $id1.text+'(';} (val = value {$assignment += $val.content;}| id2 = IDENT{$assignment += $id2.text;} ('!' INT)* 
	| '('f = functionvalue')' {$assignment += $f.assignment + ')';})	
	;

value	returns [String content]
	:	INT {$content =$INT.text;}
	|	BOOL  {$content = $BOOL.text;}
	;

TYPE	:	'Int'
	|	'Bool'

	;

BOOL	: 'true' | 'false'
	;

INT :	('0'..'9')+ | ('(- ' ('0'..'9')+ ')')
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        | '"'
        | ':'
        ) {$channel=HIDDEN;}
    ;


IDENT:	('a'..'z'|'A'..'Z'|'_'|'#'|'$') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'#'|'$')*
    ;
