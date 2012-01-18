grammar z3;

@header {
    package verifier;
}

@lexer::header {
    package verifier;
}

start	returns[LinkedList list] @init{list = new LinkedList();}
	:(pair = block {$list.add($pair);})+
	;

block	returns[misc.Pair<Boolean, String> result] 
	:'unsat'
	   .* {result = new Pair(true,"");}
	|  'sat'
	   example = model {result = new Pair(false, $example);}
	| 'unknown' 
	 .* {result = new Pair(true,"unknown");}
	;

model	returns [String example]	
	:	'(model'
		('(define-fun' id = IDENT  '('(IDENT  TYPE)*')' TYPE val = value ')' {$example += $id.text + "=" + $val + "\n";} )*
		{HashMap m = new HashMap()}('(define-fun'  id = IDENT '()' {$example = $id.text;} '(Array'('Int'{$example += "[ ]";})+ TYPE  ')'	
		'(_as-array'  id2 = (IDENT '!' INT)'))' {m.put($id2.text,$id.text;)}{$example += "\n";})*
		('(define-fun' id3 = (IDENT '!' INT) '('('('IDENT '!' INT TYPE')')+')' TYPE  '('ass = ite {$example += m.get($id3.text) + $ass;}'))')*
		')' 
	;

ite	returns[String assignment]
	:	'(=' IDENT '!' INT i = INT')'  val = value {$assignment = "[" + $i.text + "]" + "=" + $val + "\n"}(value | '('as=ite')'{$assignment += as;})
	|	'(and'('(=' IDENT '!' INT i = INT')'{$assignment += "["+$i.text+"]";})+')' val=value {$assignment += "=" + $val + "\n";}(value | '('as=ite')'{$assignment += as;})		
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

INT :	'0'..'9'+
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

IDENT:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
