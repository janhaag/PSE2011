grammar z3;

Start	:	Block+
	;
	
Block	: 'unsat'
	   .*
	|  'sat'
	   Model
	| 'unknown'
	 .*
	;

Model	:	'(model'
		('(define-fun' ID  '('(ID  TYPE)*')' TYPE VALUE ')')*
		('define-fun' ID '()' '(ArrayIntInt)'
		'(_as-array' ID '!' INT')')*
		('(define-fun' ID '!' INT '('('('ID '!' INT TYPE')')+')' TYPE '(' ITE ')' VALUE VALUE '))')*
		')'
	;
ITE
	:	'(=' ID '!' INT')'
	|	'(and'('(=' ID '!' INT')')+')' 		
	;
	
TYPE	:	'INT'
	|	'BOOL'
	
	;

VALUE	:	INT
	|	'true'
	|	'false'
	;			

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
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