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

model	returns [String example] @init{$example = "";}
	:	'(model'
		('(define-fun' id = IDENT  '('(IDENT '!'  TYPE)*')' TYPE val = value ')'
       			 {$example += $id.text + "=" + $val.content + "\n";} )*
		{HashMap m = new HashMap();}
		('(define-fun'  id = IDENT '(' ')' {$example = $id.text;}
        		'(Array'(TYPE {$example += "[ ]";})+ TYPE  ')'
		'(_as-array'  id2 = (IDENT '!' INT)')'')' {m.put($id2.text,$id.text);}{$example += "\n";})*
		('(define-fun' id3 = (IDENT '!' INT) '('('('IDENT '!' INT TYPE')')+')' TYPE
        '('ass = ite[(String)m.get($id3.text)] {$example += $ass.assignment;}')'')')*
		')'
	;

ite	[String id] returns[String assignment] @init{$assignment = id;}
	:	'(''=' IDENT '!' INT i = INT')'  val = value
        {$assignment = "[" + $i.text + "]" + "=" + $val.content + "\n";}
        (value | '('as=ite[id]')'{$assignment += $as.assignment;})
	|	'(and'('(''=' IDENT '!' INT i = INT')'{$assignment += "["+$i.text+"]";})+')'
        val=value {$assignment += "=" + $val.content + "\n";}(value | '('as=ite[id]')'{$assignment += as;})
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

INT :	('-')?('0'..'9')+
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
