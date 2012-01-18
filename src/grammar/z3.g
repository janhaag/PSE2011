grammar z3;

@header {
    package verifier;
}

@lexer::header {
    package verifier;
}

start	:	block+
	;

block	: 'unsat'
	   .*
	|  'sat'
	   model
	| 'unknown'
	 .*
	;

model
	:	'(model'
		('(define-fun' IDENT  '('(IDENT  TYPE)*')' TYPE value ')')*
		('define-fun' IDENT '()' '(Array'('Int')+ TYPE  ')'
		'(_as-array' IDENT '!' INT')')*
		('(define-fun' IDENT '!' INT '('('('IDENT '!' INT TYPE')')+')' TYPE  '('ite'))')*
		')'
	;

ite	:	'(=' IDENT '!' INT')'  value (value | ite)
	|	'(and'('(=' IDENT '!' INT')')+')' value (value | ite)
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
