// $ANTLR 3.4 ../src/grammar/WhileLanguage.g 2012-01-29 17:34:51

	package parser;
	import ast.*;
	import java.util.LinkedList;

    import static misc.WhileLanguageParserUtils.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class WhileLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL_LITERAL", "COMMENT", "IDENT", "INT_LITERAL", "QUANTIFIER", "WS", "'!'", "'!='", "'%'", "'&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'array'", "'assert'", "'assume'", "'axiom'", "'bool'", "'else'", "'ensure'", "'if'", "'int'", "'invariant'", "'main'", "'return'", "'while'", "'{'", "'|'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int BOOL_LITERAL=4;
    public static final int COMMENT=5;
    public static final int IDENT=6;
    public static final int INT_LITERAL=7;
    public static final int QUANTIFIER=8;
    public static final int WS=9;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public WhileLanguageParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public WhileLanguageParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return WhileLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../src/grammar/WhileLanguage.g"; }


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



    // $ANTLR start "program"
    // ../src/grammar/WhileLanguage.g:52:1: program returns [Program p] : (a= axiom_statement )* (f= function_declaration )* main ;
    public final Program program() throws RecognitionException {
        Program p = null;


        WhileLanguageParser.axiom_statement_return a =null;

        WhileLanguageParser.function_declaration_return f =null;

        WhileLanguageParser.main_return main1 =null;


        LinkedList<Axiom> axiom = new LinkedList<Axiom>();
        	       LinkedList<Function> function = new LinkedList<Function>();
        try {
            // ../src/grammar/WhileLanguage.g:55:9: ( (a= axiom_statement )* (f= function_declaration )* main )
            // ../src/grammar/WhileLanguage.g:55:11: (a= axiom_statement )* (f= function_declaration )* main
            {
            // ../src/grammar/WhileLanguage.g:55:11: (a= axiom_statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==33) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:55:12: a= axiom_statement
            	    {
            	    pushFollow(FOLLOW_axiom_statement_in_program61);
            	    a=axiom_statement();

            	    state._fsp--;


            	    if (!error) axiom.addAll((a!=null?a.result:null));

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // ../src/grammar/WhileLanguage.g:56:13: (f= function_declaration )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==34||LA2_0==38) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:56:14: f= function_declaration
            	    {
            	    pushFollow(FOLLOW_function_declaration_in_program82);
            	    f=function_declaration();

            	    state._fsp--;


            	    if (!error) function.add((f!=null?f.ast:null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            pushFollow(FOLLOW_main_in_program88);
            main1=main();

            state._fsp--;


            p = error ? null : new Program(new Position(),
                            function.toArray(new Function[function.size()]), (main1!=null?main1.ast:null),
                    		axiom.toArray(new Axiom[axiom.size()]));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return p;
    }
    // $ANTLR end "program"



    // $ANTLR start "single_expression"
    // ../src/grammar/WhileLanguage.g:62:1: single_expression returns [ Expression ast ] : expression ;
    public final Expression single_expression() throws RecognitionException {
        Expression ast = null;


        WhileLanguageParser.expression_return expression2 =null;


        try {
            // ../src/grammar/WhileLanguage.g:63:2: ( expression )
            // ../src/grammar/WhileLanguage.g:63:4: expression
            {
            pushFollow(FOLLOW_expression_in_single_expression121);
            expression2=expression();

            state._fsp--;


            ast = error ? null : (expression2!=null?expression2.ast:null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ast;
    }
    // $ANTLR end "single_expression"


    public static class function_declaration_return extends ParserRuleReturnScope {
        public Function ast;
    };


    // $ANTLR start "function_declaration"
    // ../src/grammar/WhileLanguage.g:66:1: function_declaration returns [ Function ast ] : type IDENT '(' (p= parameter_list )? ')' function_body ;
    public final WhileLanguageParser.function_declaration_return function_declaration() throws RecognitionException {
        WhileLanguageParser.function_declaration_return retval = new WhileLanguageParser.function_declaration_return();
        retval.start = input.LT(1);


        Token IDENT3=null;
        LinkedList<FunctionParameter> p =null;

        Type type4 =null;

        WhileLanguageParser.function_body_return function_body5 =null;


        try {
            // ../src/grammar/WhileLanguage.g:67:9: ( type IDENT '(' (p= parameter_list )? ')' function_body )
            // ../src/grammar/WhileLanguage.g:67:11: type IDENT '(' (p= parameter_list )? ')' function_body
            {
            pushFollow(FOLLOW_type_in_function_declaration145);
            type4=type();

            state._fsp--;


            IDENT3=(Token)match(input,IDENT,FOLLOW_IDENT_in_function_declaration147); 

            match(input,14,FOLLOW_14_in_function_declaration149); 

            // ../src/grammar/WhileLanguage.g:67:27: (p= parameter_list )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==34||LA3_0==38) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:67:27: p= parameter_list
                    {
                    pushFollow(FOLLOW_parameter_list_in_function_declaration153);
                    p=parameter_list();

                    state._fsp--;


                    }
                    break;

            }


            match(input,15,FOLLOW_15_in_function_declaration156); 

            pushFollow(FOLLOW_function_body_in_function_declaration158);
            function_body5=function_body();

            state._fsp--;


            if ("main".equals((IDENT3!=null?IDENT3.getText():null))) throw new TreeGeneratorException("\"main\" must only be declared once.");
                         if ("length".equals((IDENT3!=null?IDENT3.getText():null))) throw new TreeGeneratorException("\"length\" is a reserved name.");
                    	LinkedList<FunctionParameter> params = error ? null :
                    		p != null ? p : new LinkedList<FunctionParameter>();
                    	 retval.ast = error ? null :
                            new Function(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), type4, (IDENT3!=null?IDENT3.getText():null),
                    		params.toArray(new FunctionParameter[params.size()]),
                    		(function_body5!=null?function_body5.ast:null), (function_body5!=null?function_body5.pre:null).toArray(new Assumption[(function_body5!=null?function_body5.pre:null).size()]),
                    		(function_body5!=null?function_body5.post:null).toArray(new Ensure[(function_body5!=null?function_body5.post:null).size()]));

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "function_declaration"


    public static class main_return extends ParserRuleReturnScope {
        public Function ast;
    };


    // $ANTLR start "main"
    // ../src/grammar/WhileLanguage.g:79:1: main returns [ Function ast ] : 'main' '(' ( parameter_list )? ')' function_body ;
    public final WhileLanguageParser.main_return main() throws RecognitionException {
        WhileLanguageParser.main_return retval = new WhileLanguageParser.main_return();
        retval.start = input.LT(1);


        LinkedList<FunctionParameter> parameter_list6 =null;

        WhileLanguageParser.function_body_return function_body7 =null;


        try {
            // ../src/grammar/WhileLanguage.g:80:9: ( 'main' '(' ( parameter_list )? ')' function_body )
            // ../src/grammar/WhileLanguage.g:80:11: 'main' '(' ( parameter_list )? ')' function_body
            {
            match(input,40,FOLLOW_40_in_main198); 

            match(input,14,FOLLOW_14_in_main200); 

            // ../src/grammar/WhileLanguage.g:80:22: ( parameter_list )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==34||LA4_0==38) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:80:22: parameter_list
                    {
                    pushFollow(FOLLOW_parameter_list_in_main202);
                    parameter_list6=parameter_list();

                    state._fsp--;


                    }
                    break;

            }


            match(input,15,FOLLOW_15_in_main205); 

            pushFollow(FOLLOW_function_body_in_main207);
            function_body7=function_body();

            state._fsp--;


            LinkedList<FunctionParameter> params = error ? null :
                    		parameter_list6 != null ? parameter_list6 : new LinkedList<FunctionParameter>();
                    	retval.ast = error ? null : new Function(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), null, "main",
                    		params.toArray(new FunctionParameter[params.size()]),
                    		(function_body7!=null?function_body7.ast:null), (function_body7!=null?function_body7.pre:null).toArray(new Assumption[(function_body7!=null?function_body7.pre:null).size()]),
                    		(function_body7!=null?function_body7.post:null).toArray(new Ensure[(function_body7!=null?function_body7.post:null).size()]));

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "main"



    // $ANTLR start "parameter_list"
    // ../src/grammar/WhileLanguage.g:89:1: parameter_list returns [ LinkedList<FunctionParameter> params ] : p1= parameter ( ',' p2= parameter )* ;
    public final LinkedList<FunctionParameter> parameter_list() throws RecognitionException {
        LinkedList<FunctionParameter> params = null;


        FunctionParameter p1 =null;

        FunctionParameter p2 =null;


        params = new LinkedList<FunctionParameter>();
        try {
            // ../src/grammar/WhileLanguage.g:91:9: (p1= parameter ( ',' p2= parameter )* )
            // ../src/grammar/WhileLanguage.g:91:11: p1= parameter ( ',' p2= parameter )*
            {
            pushFollow(FOLLOW_parameter_in_parameter_list262);
            p1=parameter();

            state._fsp--;


            if (!error) params.add(p1);

            // ../src/grammar/WhileLanguage.g:91:60: ( ',' p2= parameter )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:91:62: ',' p2= parameter
            	    {
            	    match(input,18,FOLLOW_18_in_parameter_list268); 

            	    pushFollow(FOLLOW_parameter_in_parameter_list272);
            	    p2=parameter();

            	    state._fsp--;


            	    if (!error) params.add(p2);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return params;
    }
    // $ANTLR end "parameter_list"



    // $ANTLR start "parameter"
    // ../src/grammar/WhileLanguage.g:94:1: parameter returns [ FunctionParameter ast ] : type IDENT ;
    public final FunctionParameter parameter() throws RecognitionException {
        FunctionParameter ast = null;


        Token IDENT8=null;
        Type type9 =null;


        try {
            // ../src/grammar/WhileLanguage.g:95:9: ( type IDENT )
            // ../src/grammar/WhileLanguage.g:95:11: type IDENT
            {
            pushFollow(FOLLOW_type_in_parameter306);
            type9=type();

            state._fsp--;


            IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_parameter308); 

            ast = error ? null : new FunctionParameter((IDENT8!=null?IDENT8.getText():null), type9);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ast;
    }
    // $ANTLR end "parameter"


    public static class function_body_return extends ParserRuleReturnScope {
        public StatementBlock ast;
        public LinkedList<Assumption> pre;
        public LinkedList<Ensure> post;
    };


    // $ANTLR start "function_body"
    // ../src/grammar/WhileLanguage.g:98:1: function_body returns [ StatementBlock ast, LinkedList<Assumption> pre, LinkedList<Ensure> post ] : (a= assume_statement )? '{' ( statement )* '}' (e= ensure_statement )? ;
    public final WhileLanguageParser.function_body_return function_body() throws RecognitionException {
        WhileLanguageParser.function_body_return retval = new WhileLanguageParser.function_body_return();
        retval.start = input.LT(1);


        WhileLanguageParser.assume_statement_return a =null;

        WhileLanguageParser.ensure_statement_return e =null;

        WhileLanguageParser.statement_return statement10 =null;


        LinkedList<Statement> s = new LinkedList<Statement>();
        try {
            // ../src/grammar/WhileLanguage.g:100:9: ( (a= assume_statement )? '{' ( statement )* '}' (e= ensure_statement )? )
            // ../src/grammar/WhileLanguage.g:100:11: (a= assume_statement )? '{' ( statement )* '}' (e= ensure_statement )?
            {
            // ../src/grammar/WhileLanguage.g:100:12: (a= assume_statement )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==32) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:100:12: a= assume_statement
                    {
                    pushFollow(FOLLOW_assume_statement_in_function_body347);
                    a=assume_statement();

                    state._fsp--;


                    }
                    break;

            }


            retval.pre = error ? null : (a!=null?a.result:null) != null ? (a!=null?a.result:null) : new LinkedList<Assumption>();

            match(input,43,FOLLOW_43_in_function_body362); 

            // ../src/grammar/WhileLanguage.g:101:15: ( statement )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT||LA7_0==31||LA7_0==34||(LA7_0 >= 37 && LA7_0 <= 38)||(LA7_0 >= 41 && LA7_0 <= 42)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:101:17: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function_body366);
            	    statement10=statement();

            	    state._fsp--;


            	    if (!error) { s.addAll(possibleDivByZero((statement10!=null?statement10.divisors:null)));
            	                s.addAll(possibleArrayOutOfBounds((statement10!=null?statement10.arrayIndices:null)); s.add((statement10!=null?statement10.ast:null)); }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match(input,45,FOLLOW_45_in_function_body373); 

            retval.ast = error ?null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()));

            // ../src/grammar/WhileLanguage.g:104:12: (e= ensure_statement )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==36) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:104:12: e= ensure_statement
                    {
                    pushFollow(FOLLOW_ensure_statement_in_function_body403);
                    e=ensure_statement();

                    state._fsp--;


                    }
                    break;

            }


            retval.post = error ? null : (e!=null?e.result:null) != null ? (e!=null?e.result:null) : new LinkedList<Ensure>();

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "function_body"


    public static class if_body_return extends ParserRuleReturnScope {
        public StatementBlock ast;
    };


    // $ANTLR start "if_body"
    // ../src/grammar/WhileLanguage.g:107:1: if_body returns [ StatementBlock ast ] : '{' ( statement )* '}' ;
    public final WhileLanguageParser.if_body_return if_body() throws RecognitionException {
        WhileLanguageParser.if_body_return retval = new WhileLanguageParser.if_body_return();
        retval.start = input.LT(1);


        WhileLanguageParser.statement_return statement11 =null;


        LinkedList<Statement> s = new LinkedList<Statement>();
        try {
            // ../src/grammar/WhileLanguage.g:109:9: ( '{' ( statement )* '}' )
            // ../src/grammar/WhileLanguage.g:109:11: '{' ( statement )* '}'
            {
            match(input,43,FOLLOW_43_in_if_body441); 

            // ../src/grammar/WhileLanguage.g:109:15: ( statement )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDENT||LA9_0==31||LA9_0==34||(LA9_0 >= 37 && LA9_0 <= 38)||(LA9_0 >= 41 && LA9_0 <= 42)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:109:17: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_if_body445);
            	    statement11=statement();

            	    state._fsp--;


            	    if (!error) {s.addAll(possibleDivByZero((statement11!=null?statement11.divisors:null)));
            	                s.addAll(possibleArrayOutOfBounds((statement11!=null?statement11.arrayIndices:null)); s.add((statement11!=null?statement11.ast:null));}

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match(input,45,FOLLOW_45_in_if_body452); 

            retval.ast = error ? null : new StatementBlock(s.toArray(new Statement[s.size()]), new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()));

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "if_body"


    public static class loop_body_return extends ParserRuleReturnScope {
        public StatementBlock ast;
        public LinkedList<Invariant> pre;
        public LinkedList<Ensure> post;
    };


    // $ANTLR start "loop_body"
    // ../src/grammar/WhileLanguage.g:114:1: loop_body returns [ StatementBlock ast, LinkedList<Invariant> pre, LinkedList<Ensure> post ] : (i= invariant_statement )? '{' ( statement )* '}' (e= ensure_statement )? ;
    public final WhileLanguageParser.loop_body_return loop_body() throws RecognitionException {
        WhileLanguageParser.loop_body_return retval = new WhileLanguageParser.loop_body_return();
        retval.start = input.LT(1);


        WhileLanguageParser.invariant_statement_return i =null;

        WhileLanguageParser.ensure_statement_return e =null;

        WhileLanguageParser.statement_return statement12 =null;


        LinkedList<Statement> s = new LinkedList<Statement>();
        try {
            // ../src/grammar/WhileLanguage.g:116:9: ( (i= invariant_statement )? '{' ( statement )* '}' (e= ensure_statement )? )
            // ../src/grammar/WhileLanguage.g:116:11: (i= invariant_statement )? '{' ( statement )* '}' (e= ensure_statement )?
            {
            // ../src/grammar/WhileLanguage.g:116:12: (i= invariant_statement )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==39) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:116:12: i= invariant_statement
                    {
                    pushFollow(FOLLOW_invariant_statement_in_loop_body503);
                    i=invariant_statement();

                    state._fsp--;


                    }
                    break;

            }


            retval.pre = error ? null : (i!=null?i.result:null) != null ? (i!=null?i.result:null) : new LinkedList<Invariant>();

            match(input,43,FOLLOW_43_in_loop_body518); 

            // ../src/grammar/WhileLanguage.g:117:15: ( statement )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==IDENT||LA11_0==31||LA11_0==34||(LA11_0 >= 37 && LA11_0 <= 38)||(LA11_0 >= 41 && LA11_0 <= 42)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:117:17: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_loop_body522);
            	    statement12=statement();

            	    state._fsp--;


            	    if (!error) {s.addAll(possibleDivByZero((statement12!=null?statement12.divisors:null)));
            	                s.addAll(possibleArrayOutOfBounds((statement12!=null?statement12.arrayIndices:null)); s.add((statement12!=null?statement12.ast:null));}

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match(input,45,FOLLOW_45_in_loop_body529); 

            retval.ast = error ? null : new StatementBlock(s.toArray(new Statement[s.size()]),
                          new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()));

            // ../src/grammar/WhileLanguage.g:121:12: (e= ensure_statement )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==36) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:121:12: e= ensure_statement
                    {
                    pushFollow(FOLLOW_ensure_statement_in_loop_body559);
                    e=ensure_statement();

                    state._fsp--;


                    }
                    break;

            }


            retval.post = error ? null : (e!=null?e.result:null) != null ? (e!=null?e.result:null) : new LinkedList<Ensure>();

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "loop_body"


    public static class statement_return extends ParserRuleReturnScope {
        public Statement ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "statement"
    // ../src/grammar/WhileLanguage.g:124:1: statement returns [ Statement ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : (e= assert_statement |e= variable_declaration |e= array_declaration |e= assignment |e= if_statement |e= while_statement |e= return_statement );
    public final WhileLanguageParser.statement_return statement() throws RecognitionException {
        WhileLanguageParser.statement_return retval = new WhileLanguageParser.statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.return_statement_return e =null;


        try {
            // ../src/grammar/WhileLanguage.g:125:9: (e= assert_statement |e= variable_declaration |e= array_declaration |e= assignment |e= if_statement |e= while_statement |e= return_statement )
            int alt13=7;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:125:11: e= assert_statement
                    {
                    pushFollow(FOLLOW_assert_statement_in_statement593);
                    e=assert_statement();

                    state._fsp--;


                    if (!error) {retval.ast = (e!=null?e.ast:null); retval.divisors = (e!=null?e.divisors:null); retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:126:11: e= variable_declaration
                    {
                    pushFollow(FOLLOW_variable_declaration_in_statement609);
                    e=variable_declaration();

                    state._fsp--;


                    if (!error) {retval.ast = (e!=null?e.ast:null); retval.divisors = (e!=null?e.divisors:null); retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;
                case 3 :
                    // ../src/grammar/WhileLanguage.g:127:11: e= array_declaration
                    {
                    pushFollow(FOLLOW_array_declaration_in_statement625);
                    e=array_declaration();

                    state._fsp--;


                    if (!error) {retval.ast = (e!=null?e.ast:null); retval.divisors = (e!=null?e.divisors:null); retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;
                case 4 :
                    // ../src/grammar/WhileLanguage.g:128:11: e= assignment
                    {
                    pushFollow(FOLLOW_assignment_in_statement641);
                    e=assignment();

                    state._fsp--;


                    if (!error) {retval.ast = (e!=null?e.ast:null); retval.divisors = (e!=null?e.divisors:null); retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;
                case 5 :
                    // ../src/grammar/WhileLanguage.g:129:11: e= if_statement
                    {
                    pushFollow(FOLLOW_if_statement_in_statement657);
                    e=if_statement();

                    state._fsp--;


                    if (!error) {retval.ast = (e!=null?e.ast:null); retval.divisors = (e!=null?e.divisors:null); retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;
                case 6 :
                    // ../src/grammar/WhileLanguage.g:130:11: e= while_statement
                    {
                    pushFollow(FOLLOW_while_statement_in_statement673);
                    e=while_statement();

                    state._fsp--;


                    if (!error) {retval.ast = (e!=null?e.ast:null); retval.divisors = (e!=null?e.divisors:null); retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;
                case 7 :
                    // ../src/grammar/WhileLanguage.g:131:11: e= return_statement
                    {
                    pushFollow(FOLLOW_return_statement_in_statement689);
                    e=return_statement();

                    state._fsp--;


                    if (!error) {retval.ast = (e!=null?e.ast:null); retval.divisors = (e!=null?e.divisors:null); retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class invariant_statement_return extends ParserRuleReturnScope {
        public LinkedList<Invariant> result;
    };


    // $ANTLR start "invariant_statement"
    // ../src/grammar/WhileLanguage.g:134:1: invariant_statement returns [ LinkedList<Invariant> result ] : ( 'invariant' e1= quantified_expression ';' | 'invariant' '{' (e2= quantified_expression ';' )+ '}' );
    public final WhileLanguageParser.invariant_statement_return invariant_statement() throws RecognitionException {
        WhileLanguageParser.invariant_statement_return retval = new WhileLanguageParser.invariant_statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.quantified_expression_return e1 =null;

        WhileLanguageParser.quantified_expression_return e2 =null;


        retval.result = new LinkedList<Invariant>();
        try {
            // ../src/grammar/WhileLanguage.g:136:9: ( 'invariant' e1= quantified_expression ';' | 'invariant' '{' (e2= quantified_expression ';' )+ '}' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==39) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==43) ) {
                    alt15=2;
                }
                else if ( (LA15_1==BOOL_LITERAL||(LA15_1 >= IDENT && LA15_1 <= QUANTIFIER)||LA15_1==10||LA15_1==14||LA15_1==17||LA15_1==19) ) {
                    alt15=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:136:11: 'invariant' e1= quantified_expression ';'
                    {
                    match(input,39,FOLLOW_39_in_invariant_statement726); 

                    pushFollow(FOLLOW_quantified_expression_in_invariant_statement730);
                    e1=quantified_expression();

                    state._fsp--;


                    match(input,21,FOLLOW_21_in_invariant_statement732); 

                    if (!error) {retval.result.addAll(possibleDivByZeroI((e1!=null?e1.divisors:null)));
                                retval.result.addAll(possibleArrayOutOfBoundsI((e1!=null?e1.arrayIndices:null));
                                retval.result.add(new Invariant(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e1!=null?e1.ast:null)));}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:139:11: 'invariant' '{' (e2= quantified_expression ';' )+ '}'
                    {
                    match(input,39,FOLLOW_39_in_invariant_statement746); 

                    match(input,43,FOLLOW_43_in_invariant_statement748); 

                    // ../src/grammar/WhileLanguage.g:139:27: (e2= quantified_expression ';' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==BOOL_LITERAL||(LA14_0 >= IDENT && LA14_0 <= QUANTIFIER)||LA14_0==10||LA14_0==14||LA14_0==17||LA14_0==19) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../src/grammar/WhileLanguage.g:139:28: e2= quantified_expression ';'
                    	    {
                    	    pushFollow(FOLLOW_quantified_expression_in_invariant_statement753);
                    	    e2=quantified_expression();

                    	    state._fsp--;


                    	    match(input,21,FOLLOW_21_in_invariant_statement755); 

                    	    if (!error) {retval.result.addAll(possibleDivByZeroI((e2!=null?e2.divisors:null)));
                    	                retval.result.addAll(possibleArrayOutOfBoundsI((e2!=null?e2.arrayIndices:null));
                    	                retval.result.add(new Invariant(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e2!=null?e2.ast:null)));}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    match(input,45,FOLLOW_45_in_invariant_statement762); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "invariant_statement"


    public static class axiom_statement_return extends ParserRuleReturnScope {
        public LinkedList<Axiom> result;
    };


    // $ANTLR start "axiom_statement"
    // ../src/grammar/WhileLanguage.g:144:1: axiom_statement returns [ LinkedList<Axiom> result ] : 'axiom' e1= quantified_expression ';' ;
    public final WhileLanguageParser.axiom_statement_return axiom_statement() throws RecognitionException {
        WhileLanguageParser.axiom_statement_return retval = new WhileLanguageParser.axiom_statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.quantified_expression_return e1 =null;


        retval.result = new LinkedList<Axiom>();
        try {
            // ../src/grammar/WhileLanguage.g:146:9: ( 'axiom' e1= quantified_expression ';' )
            // ../src/grammar/WhileLanguage.g:146:11: 'axiom' e1= quantified_expression ';'
            {
            match(input,33,FOLLOW_33_in_axiom_statement800); 

            pushFollow(FOLLOW_quantified_expression_in_axiom_statement804);
            e1=quantified_expression();

            state._fsp--;


            match(input,21,FOLLOW_21_in_axiom_statement806); 

            if (!error) {retval.result.addAll(possibleDivByZeroAx((e1!=null?e1.divisors:null)));
                        retval.result.addAll(possibleArrayOutOfBoundsAx((e1!=null?e1.arrayIndices:null));
                        retval.result.add(new Axiom(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e1!=null?e1.ast:null)));}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "axiom_statement"


    public static class assert_statement_return extends ParserRuleReturnScope {
        public Assertion ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "assert_statement"
    // ../src/grammar/WhileLanguage.g:151:1: assert_statement returns [ Assertion ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : 'assert' e1= quantified_expression ';' ;
    public final WhileLanguageParser.assert_statement_return assert_statement() throws RecognitionException {
        WhileLanguageParser.assert_statement_return retval = new WhileLanguageParser.assert_statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.quantified_expression_return e1 =null;


        try {
            // ../src/grammar/WhileLanguage.g:152:9: ( 'assert' e1= quantified_expression ';' )
            // ../src/grammar/WhileLanguage.g:152:11: 'assert' e1= quantified_expression ';'
            {
            match(input,31,FOLLOW_31_in_assert_statement837); 

            pushFollow(FOLLOW_quantified_expression_in_assert_statement841);
            e1=quantified_expression();

            state._fsp--;


            match(input,21,FOLLOW_21_in_assert_statement843); 

            if (!error) {retval.ast = new Assertion(
                                new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e1!=null?e1.ast:null));
                            retval.divisors = (e1!=null?e1.divisors:null);
                            retval.arrayIndices = (e1!=null?e1.arrayIndices:null);}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assert_statement"


    public static class assume_statement_return extends ParserRuleReturnScope {
        public LinkedList<Assumption> result;
    };


    // $ANTLR start "assume_statement"
    // ../src/grammar/WhileLanguage.g:158:1: assume_statement returns [ LinkedList<Assumption> result ] : ( 'assume' e1= quantified_expression ';' | 'assume' '{' (e2= quantified_expression ';' )+ '}' );
    public final WhileLanguageParser.assume_statement_return assume_statement() throws RecognitionException {
        WhileLanguageParser.assume_statement_return retval = new WhileLanguageParser.assume_statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.quantified_expression_return e1 =null;

        WhileLanguageParser.quantified_expression_return e2 =null;


        retval.result = new LinkedList<Assumption>();
        try {
            // ../src/grammar/WhileLanguage.g:160:9: ( 'assume' e1= quantified_expression ';' | 'assume' '{' (e2= quantified_expression ';' )+ '}' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==43) ) {
                    alt17=2;
                }
                else if ( (LA17_1==BOOL_LITERAL||(LA17_1 >= IDENT && LA17_1 <= QUANTIFIER)||LA17_1==10||LA17_1==14||LA17_1==17||LA17_1==19) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:160:11: 'assume' e1= quantified_expression ';'
                    {
                    match(input,32,FOLLOW_32_in_assume_statement880); 

                    pushFollow(FOLLOW_quantified_expression_in_assume_statement884);
                    e1=quantified_expression();

                    state._fsp--;


                    match(input,21,FOLLOW_21_in_assume_statement886); 

                    if (!error) {retval.result.addAll(possibleDivByZeroA((e1!=null?e1.divisors:null)));
                                retval.result.addAll(possibleArrayOutOfBoundsA((e1!=null?e1.arrayIndices:null));
                                retval.result.add(new Assumption(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e1!=null?e1.ast:null)));}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:163:11: 'assume' '{' (e2= quantified_expression ';' )+ '}'
                    {
                    match(input,32,FOLLOW_32_in_assume_statement900); 

                    match(input,43,FOLLOW_43_in_assume_statement902); 

                    // ../src/grammar/WhileLanguage.g:163:24: (e2= quantified_expression ';' )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==BOOL_LITERAL||(LA16_0 >= IDENT && LA16_0 <= QUANTIFIER)||LA16_0==10||LA16_0==14||LA16_0==17||LA16_0==19) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../src/grammar/WhileLanguage.g:163:25: e2= quantified_expression ';'
                    	    {
                    	    pushFollow(FOLLOW_quantified_expression_in_assume_statement907);
                    	    e2=quantified_expression();

                    	    state._fsp--;


                    	    match(input,21,FOLLOW_21_in_assume_statement909); 

                    	    if (!error) {retval.result.addAll(possibleDivByZeroA((e2!=null?e2.divisors:null)));
                    	                retval.result.addAll(possibleArrayOutOfBoundsA((e2!=null?e2.arrayIndices:null));
                    	                retval.result.add(new Assumption(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e2!=null?e2.ast:null)));}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    match(input,45,FOLLOW_45_in_assume_statement916); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assume_statement"


    public static class ensure_statement_return extends ParserRuleReturnScope {
        public LinkedList<Ensure> result;
    };


    // $ANTLR start "ensure_statement"
    // ../src/grammar/WhileLanguage.g:168:1: ensure_statement returns [ LinkedList<Ensure> result ] : ( 'ensure' e1= quantified_expression ';' | 'ensure' '{' (e2= quantified_expression ';' )+ '}' );
    public final WhileLanguageParser.ensure_statement_return ensure_statement() throws RecognitionException {
        WhileLanguageParser.ensure_statement_return retval = new WhileLanguageParser.ensure_statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.quantified_expression_return e1 =null;

        WhileLanguageParser.quantified_expression_return e2 =null;


        retval.result = new LinkedList<Ensure>();
        try {
            // ../src/grammar/WhileLanguage.g:170:9: ( 'ensure' e1= quantified_expression ';' | 'ensure' '{' (e2= quantified_expression ';' )+ '}' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==36) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==43) ) {
                    alt19=2;
                }
                else if ( (LA19_1==BOOL_LITERAL||(LA19_1 >= IDENT && LA19_1 <= QUANTIFIER)||LA19_1==10||LA19_1==14||LA19_1==17||LA19_1==19) ) {
                    alt19=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:170:11: 'ensure' e1= quantified_expression ';'
                    {
                    match(input,36,FOLLOW_36_in_ensure_statement951); 

                    pushFollow(FOLLOW_quantified_expression_in_ensure_statement955);
                    e1=quantified_expression();

                    state._fsp--;


                    match(input,21,FOLLOW_21_in_ensure_statement957); 

                    if (!error) {retval.result.addAll(possibleDivByZeroE((e1!=null?e1.divisors:null)));
                                retval.result.addAll(possibleArrayOutOfBoundsE((e1!=null?e1.arrayIndices:null));
                                retval.result.add(new Ensure(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e1!=null?e1.ast:null)));}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:173:11: 'ensure' '{' (e2= quantified_expression ';' )+ '}'
                    {
                    match(input,36,FOLLOW_36_in_ensure_statement971); 

                    match(input,43,FOLLOW_43_in_ensure_statement973); 

                    // ../src/grammar/WhileLanguage.g:173:24: (e2= quantified_expression ';' )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==BOOL_LITERAL||(LA18_0 >= IDENT && LA18_0 <= QUANTIFIER)||LA18_0==10||LA18_0==14||LA18_0==17||LA18_0==19) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../src/grammar/WhileLanguage.g:173:25: e2= quantified_expression ';'
                    	    {
                    	    pushFollow(FOLLOW_quantified_expression_in_ensure_statement978);
                    	    e2=quantified_expression();

                    	    state._fsp--;


                    	    match(input,21,FOLLOW_21_in_ensure_statement980); 

                    	    if (!error) {retval.result.addAll(possibleDivByZeroE((e2!=null?e2.divisors:null)));
                    	                retval.result.addAll(possibleArrayOutOfBoundsE((e2!=null?e2.arrayIndices:null));
                    	                retval.result.add(new Ensure(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e2!=null?e2.ast:null)));}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);


                    match(input,45,FOLLOW_45_in_ensure_statement987); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ensure_statement"


    public static class assignment_return extends ParserRuleReturnScope {
        public Assignment ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "assignment"
    // ../src/grammar/WhileLanguage.g:178:1: assignment returns [ Assignment ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : ( IDENT '=' expression ';' | IDENT ( '[' e1= expression ']' )+ '=' e2= expression ';' );
    public final WhileLanguageParser.assignment_return assignment() throws RecognitionException {
        WhileLanguageParser.assignment_return retval = new WhileLanguageParser.assignment_return();
        retval.start = input.LT(1);


        Token IDENT14=null;
        Token IDENT15=null;
        WhileLanguageParser.expression_return e1 =null;

        WhileLanguageParser.expression_return e2 =null;

        WhileLanguageParser.expression_return expression13 =null;


        retval.divisors = new LinkedList<Expression>(); retval.arrayIndices = new LinkedList<Expression();
        try {
            // ../src/grammar/WhileLanguage.g:180:9: ( IDENT '=' expression ';' | IDENT ( '[' e1= expression ']' )+ '=' e2= expression ';' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDENT) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==24) ) {
                    alt21=1;
                }
                else if ( (LA21_1==28) ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:180:11: IDENT '=' expression ';'
                    {
                    IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment1025); 

                    match(input,24,FOLLOW_24_in_assignment1027); 

                    pushFollow(FOLLOW_expression_in_assignment1029);
                    expression13=expression();

                    state._fsp--;


                    match(input,21,FOLLOW_21_in_assignment1031); 

                    if (!error) {retval.ast = new Assignment(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
                                    (expression13!=null?expression13.ast:null), new Identifier((IDENT14!=null?IDENT14.getText():null)));
                                retval.divisors = (expression13!=null?expression13.divisors:null); retval.arrayIndices = (expression13!=null?expression13.arrayIndices:null);}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:183:11: IDENT ( '[' e1= expression ']' )+ '=' e2= expression ';'
                    {
                    IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment1045); 

                    LinkedList<Expression> idx = new LinkedList<Expression>();

                    // ../src/grammar/WhileLanguage.g:184:10: ( '[' e1= expression ']' )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==28) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../src/grammar/WhileLanguage.g:184:12: '[' e1= expression ']'
                    	    {
                    	    match(input,28,FOLLOW_28_in_assignment1060); 

                    	    pushFollow(FOLLOW_expression_in_assignment1064);
                    	    e1=expression();

                    	    state._fsp--;


                    	    if (!error) {idx.add((e1!=null?e1.ast:null)); retval.divisors.addAll((e1!=null?e1.divisors:null)); retval.arrayIndices.addAll((e1!=null?e1.arrayIndices:null));}

                    	    match(input,29,FOLLOW_29_in_assignment1078); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    match(input,24,FOLLOW_24_in_assignment1083); 

                    pushFollow(FOLLOW_expression_in_assignment1087);
                    e2=expression();

                    state._fsp--;


                    match(input,21,FOLLOW_21_in_assignment1089); 

                    if (!error) {retval.ast = new ArrayAssignment(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
                                               (e2!=null?e2.ast:null), new Identifier((IDENT15!=null?IDENT15.getText():null)),
                            				   idx.toArray(new Expression[idx.size()]));
                                retval.divisors.addAll((e2!=null?e2.divisors:null));
                                retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignment"


    public static class variable_declaration_return extends ParserRuleReturnScope {
        public VariableDeclaration ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "variable_declaration"
    // ../src/grammar/WhileLanguage.g:193:1: variable_declaration returns [ VariableDeclaration ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : type IDENT ( '=' expression )? ';' ;
    public final WhileLanguageParser.variable_declaration_return variable_declaration() throws RecognitionException {
        WhileLanguageParser.variable_declaration_return retval = new WhileLanguageParser.variable_declaration_return();
        retval.start = input.LT(1);


        Token IDENT17=null;
        WhileLanguageParser.expression_return expression16 =null;

        Type type18 =null;


        try {
            // ../src/grammar/WhileLanguage.g:194:9: ( type IDENT ( '=' expression )? ';' )
            // ../src/grammar/WhileLanguage.g:194:11: type IDENT ( '=' expression )? ';'
            {
            pushFollow(FOLLOW_type_in_variable_declaration1132);
            type18=type();

            state._fsp--;


            IDENT17=(Token)match(input,IDENT,FOLLOW_IDENT_in_variable_declaration1134); 

            // ../src/grammar/WhileLanguage.g:194:22: ( '=' expression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:194:24: '=' expression
                    {
                    match(input,24,FOLLOW_24_in_variable_declaration1138); 

                    pushFollow(FOLLOW_expression_in_variable_declaration1140);
                    expression16=expression();

                    state._fsp--;


                    }
                    break;

            }


            match(input,21,FOLLOW_21_in_variable_declaration1145); 

            if (!error) {
                    	Expression init = (expression16!=null?expression16.ast:null) != null ? (expression16!=null?expression16.ast:null) : null;
                    	retval.ast = new VariableDeclaration(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (IDENT17!=null?IDENT17.getText():null), init, type18);
                        retval.divisors = (expression16!=null?expression16.ast:null) != null ? (expression16!=null?expression16.divisors:null) : new LinkedList<Expression>();
                        retval.arrayIndices = (expression16!=null?expression16.ast:null) != null ? (expression16!=null?expression16.arrayIndices:null) : null;}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variable_declaration"


    public static class array_declaration_return extends ParserRuleReturnScope {
        public ArrayDeclaration ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "array_declaration"
    // ../src/grammar/WhileLanguage.g:201:1: array_declaration returns [ ArrayDeclaration ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : type IDENT '=' array_init ';' ;
    public final WhileLanguageParser.array_declaration_return array_declaration() throws RecognitionException {
        WhileLanguageParser.array_declaration_return retval = new WhileLanguageParser.array_declaration_return();
        retval.start = input.LT(1);


        Token IDENT20=null;
        WhileLanguageParser.array_init_return array_init19 =null;

        Type type21 =null;


        try {
            // ../src/grammar/WhileLanguage.g:202:9: ( type IDENT '=' array_init ';' )
            // ../src/grammar/WhileLanguage.g:202:11: type IDENT '=' array_init ';'
            {
            pushFollow(FOLLOW_type_in_array_declaration1176);
            type21=type();

            state._fsp--;


            IDENT20=(Token)match(input,IDENT,FOLLOW_IDENT_in_array_declaration1178); 

            match(input,24,FOLLOW_24_in_array_declaration1180); 

            pushFollow(FOLLOW_array_init_in_array_declaration1182);
            array_init19=array_init();

            state._fsp--;


            match(input,21,FOLLOW_21_in_array_declaration1184); 

            if (!error) {
                    	Expression[] dim = (array_init19!=null?array_init19.dim:null).toArray(new Expression[(array_init19!=null?array_init19.dim:null).size()]);
                    	retval.ast = new ArrayDeclaration(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (IDENT20!=null?IDENT20.getText():null), type21, dim);
                        retval.divisors = (array_init19!=null?array_init19.divisors:null);retval.arrayIndices = (array_init19!=null?array_init19.arrayIndices:null);}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "array_declaration"


    public static class array_init_return extends ParserRuleReturnScope {
        public LinkedList<Expression> dim;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "array_init"
    // ../src/grammar/WhileLanguage.g:208:1: array_init returns [ LinkedList<Expression> dim, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : 'array' ( '[' expression ']' )+ ;
    public final WhileLanguageParser.array_init_return array_init() throws RecognitionException {
        WhileLanguageParser.array_init_return retval = new WhileLanguageParser.array_init_return();
        retval.start = input.LT(1);


        WhileLanguageParser.expression_return expression22 =null;


        retval.divisors = new LinkedList<Expression>();retval.dim = new LinkedList<Expression>(); retval.arrayIndices = new LinkedList<Expression>();
        try {
            // ../src/grammar/WhileLanguage.g:210:2: ( 'array' ( '[' expression ']' )+ )
            // ../src/grammar/WhileLanguage.g:210:4: 'array' ( '[' expression ']' )+
            {
            match(input,30,FOLLOW_30_in_array_init1217); 

            // ../src/grammar/WhileLanguage.g:210:12: ( '[' expression ']' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==28) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:210:14: '[' expression ']'
            	    {
            	    match(input,28,FOLLOW_28_in_array_init1221); 

            	    pushFollow(FOLLOW_expression_in_array_init1223);
            	    expression22=expression();

            	    state._fsp--;


            	    if (!error) {retval.dim.add((expression22!=null?expression22.ast:null)); retval.divisors.addAll((expression22!=null?expression22.divisors:null));
            	            retval.arrayIndices.addAll((expression22!=null?expression22.arrayIndices:null));}

            	    match(input,29,FOLLOW_29_in_array_init1227); 

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "array_init"


    public static class if_statement_return extends ParserRuleReturnScope {
        public Conditional ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "if_statement"
    // ../src/grammar/WhileLanguage.g:214:1: if_statement returns [ Conditional ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : 'if' '(' expression ')' b1= if_body ( 'else' b2= if_body )? ;
    public final WhileLanguageParser.if_statement_return if_statement() throws RecognitionException {
        WhileLanguageParser.if_statement_return retval = new WhileLanguageParser.if_statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.if_body_return b1 =null;

        WhileLanguageParser.if_body_return b2 =null;

        WhileLanguageParser.expression_return expression23 =null;


        try {
            // ../src/grammar/WhileLanguage.g:215:9: ( 'if' '(' expression ')' b1= if_body ( 'else' b2= if_body )? )
            // ../src/grammar/WhileLanguage.g:215:11: 'if' '(' expression ')' b1= if_body ( 'else' b2= if_body )?
            {
            match(input,37,FOLLOW_37_in_if_statement1252); 

            match(input,14,FOLLOW_14_in_if_statement1254); 

            pushFollow(FOLLOW_expression_in_if_statement1256);
            expression23=expression();

            state._fsp--;


            match(input,15,FOLLOW_15_in_if_statement1258); 

            pushFollow(FOLLOW_if_body_in_if_statement1262);
            b1=if_body();

            state._fsp--;


            // ../src/grammar/WhileLanguage.g:215:46: ( 'else' b2= if_body )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:215:48: 'else' b2= if_body
                    {
                    match(input,35,FOLLOW_35_in_if_statement1266); 

                    pushFollow(FOLLOW_if_body_in_if_statement1270);
                    b2=if_body();

                    state._fsp--;


                    }
                    break;

            }


            if (!error) {
                    	retval.ast = new Conditional(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (expression23!=null?expression23.ast:null), (b1!=null?b1.ast:null), (b2!=null?b2.ast:null));
                        retval.divisors = (expression23!=null?expression23.divisors:null);retval.arrayIndices = (expression23!=null?expression23.arrayIndices:null);}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "if_statement"


    public static class while_statement_return extends ParserRuleReturnScope {
        public Loop ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "while_statement"
    // ../src/grammar/WhileLanguage.g:220:1: while_statement returns [ Loop ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : 'while' '(' expression ')' loop_body ;
    public final WhileLanguageParser.while_statement_return while_statement() throws RecognitionException {
        WhileLanguageParser.while_statement_return retval = new WhileLanguageParser.while_statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.loop_body_return loop_body24 =null;

        WhileLanguageParser.expression_return expression25 =null;


        try {
            // ../src/grammar/WhileLanguage.g:221:9: ( 'while' '(' expression ')' loop_body )
            // ../src/grammar/WhileLanguage.g:221:11: 'while' '(' expression ')' loop_body
            {
            match(input,42,FOLLOW_42_in_while_statement1304); 

            match(input,14,FOLLOW_14_in_while_statement1306); 

            pushFollow(FOLLOW_expression_in_while_statement1308);
            expression25=expression();

            state._fsp--;


            match(input,15,FOLLOW_15_in_while_statement1310); 

            pushFollow(FOLLOW_loop_body_in_while_statement1312);
            loop_body24=loop_body();

            state._fsp--;


            if (!error) {
            		Invariant[] i = new Invariant[0];
            		i = (loop_body24!=null?loop_body24.pre:null) != null ? (loop_body24!=null?loop_body24.pre:null).toArray(new Invariant[(loop_body24!=null?loop_body24.pre:null).size()]) : null;
            		Ensure[] e = new Ensure[0];
            		e = (loop_body24!=null?loop_body24.post:null) != null ? (loop_body24!=null?loop_body24.post:null).toArray(new Ensure[(loop_body24!=null?loop_body24.post:null).size()]) : null;
                   	retval.ast = new Loop(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (expression25!=null?expression25.ast:null), (loop_body24!=null?loop_body24.ast:null), i, e);
                    retval.divisors = (expression25!=null?expression25.divisors:null);retval.arrayIndices = (expression25!=null?expression25.arrayIndices:null);}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "while_statement"


    public static class return_statement_return extends ParserRuleReturnScope {
        public ReturnStatement ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "return_statement"
    // ../src/grammar/WhileLanguage.g:230:1: return_statement returns [ ReturnStatement ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : 'return' expression ';' ;
    public final WhileLanguageParser.return_statement_return return_statement() throws RecognitionException {
        WhileLanguageParser.return_statement_return retval = new WhileLanguageParser.return_statement_return();
        retval.start = input.LT(1);


        WhileLanguageParser.expression_return expression26 =null;


        try {
            // ../src/grammar/WhileLanguage.g:231:2: ( 'return' expression ';' )
            // ../src/grammar/WhileLanguage.g:231:4: 'return' expression ';'
            {
            match(input,41,FOLLOW_41_in_return_statement1336); 

            pushFollow(FOLLOW_expression_in_return_statement1338);
            expression26=expression();

            state._fsp--;


            match(input,21,FOLLOW_21_in_return_statement1340); 

            if (!error) {
                    retval.ast = new ReturnStatement(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (expression26!=null?expression26.ast:null));
                    retval.divisors = (expression26!=null?expression26.divisors:null);retval.arrayIndices = (expression26!=null?expression26.arrayIndices:null);}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "return_statement"


    public static class quantified_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "quantified_expression"
    // ../src/grammar/WhileLanguage.g:236:1: quantified_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : ( QUANTIFIER IDENT '(' ( range )? ')' e= quantified_expression | expression );
    public final WhileLanguageParser.quantified_expression_return quantified_expression() throws RecognitionException {
        WhileLanguageParser.quantified_expression_return retval = new WhileLanguageParser.quantified_expression_return();
        retval.start = input.LT(1);


        Token QUANTIFIER28=null;
        Token IDENT29=null;
        WhileLanguageParser.quantified_expression_return e =null;

        WhileLanguageParser.range_return range27 =null;

        WhileLanguageParser.expression_return expression30 =null;


        try {
            // ../src/grammar/WhileLanguage.g:237:9: ( QUANTIFIER IDENT '(' ( range )? ')' e= quantified_expression | expression )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==QUANTIFIER) ) {
                alt26=1;
            }
            else if ( (LA26_0==BOOL_LITERAL||(LA26_0 >= IDENT && LA26_0 <= INT_LITERAL)||LA26_0==10||LA26_0==14||LA26_0==17||LA26_0==19) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:237:11: QUANTIFIER IDENT '(' ( range )? ')' e= quantified_expression
                    {
                    QUANTIFIER28=(Token)match(input,QUANTIFIER,FOLLOW_QUANTIFIER_in_quantified_expression1364); 

                    IDENT29=(Token)match(input,IDENT,FOLLOW_IDENT_in_quantified_expression1366); 

                    match(input,14,FOLLOW_14_in_quantified_expression1368); 

                    // ../src/grammar/WhileLanguage.g:237:32: ( range )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==BOOL_LITERAL||(LA25_0 >= IDENT && LA25_0 <= INT_LITERAL)||LA25_0==10||LA25_0==14||LA25_0==17||LA25_0==19) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../src/grammar/WhileLanguage.g:237:32: range
                            {
                            pushFollow(FOLLOW_range_in_quantified_expression1370);
                            range27=range();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,15,FOLLOW_15_in_quantified_expression1373); 

                    pushFollow(FOLLOW_quantified_expression_in_quantified_expression1377);
                    e=quantified_expression();

                    state._fsp--;


                    if (!error) {
                            	Range r = null;
                            	retval.divisors = (e!=null?e.divisors:null);
                                retval.arrayIndices = (e!=null?e.arrayIndices:null);
                            	if ((range27!=null?range27.e1:null) != null) {
                            		r = new Range((range27!=null?range27.e1:null), (range27!=null?range27.e2:null));
                            		retval.divisors.addAll((range27!=null?range27.divisors:null));
                                    retval.arrayIndices.addAll((range27!=null?range27.arrayIndices:null));
                            	}
                            	if ("forall".equals((QUANTIFIER28!=null?QUANTIFIER28.getText():null)))
                            			retval.ast = new ForAllQuantifier(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), r, new Identifier((IDENT29!=null?IDENT29.getText():null)),
                            				(e!=null?e.ast:null));
                                else retval.ast = new ExistsQuantifier(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), r, new Identifier((IDENT29!=null?IDENT29.getText():null)),
                            				(e!=null?e.ast:null));
                            	}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:252:11: expression
                    {
                    pushFollow(FOLLOW_expression_in_quantified_expression1391);
                    expression30=expression();

                    state._fsp--;


                    if (!error) {
                                retval.divisors = (expression30!=null?expression30.divisors:null);
                            	retval.ast = (expression30!=null?expression30.ast:null);
                                retval.arrayIndices = (expression30!=null?expression30.arrayIndices:null);
                            }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "quantified_expression"


    public static class range_return extends ParserRuleReturnScope {
        public Expression e1;
        public Expression e2;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "range"
    // ../src/grammar/WhileLanguage.g:259:1: range returns [ Expression e1, Expression e2, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : l= expression ',' u= expression ;
    public final WhileLanguageParser.range_return range() throws RecognitionException {
        WhileLanguageParser.range_return retval = new WhileLanguageParser.range_return();
        retval.start = input.LT(1);


        WhileLanguageParser.expression_return l =null;

        WhileLanguageParser.expression_return u =null;


        try {
            // ../src/grammar/WhileLanguage.g:260:9: (l= expression ',' u= expression )
            // ../src/grammar/WhileLanguage.g:260:11: l= expression ',' u= expression
            {
            pushFollow(FOLLOW_expression_in_range1424);
            l=expression();

            state._fsp--;


            match(input,18,FOLLOW_18_in_range1426); 

            pushFollow(FOLLOW_expression_in_range1430);
            u=expression();

            state._fsp--;


            if (!error) {
                    	retval.e1 =l.ast; retval.e2 =u.ast;
                    	retval.divisors = l.divisors;
                    	retval.divisors.addAll(u.divisors);
                        retval.arrayIndices = (l!=null?l.arrayIndices:null);
                        retval.arrayIndices.addAll((u!=null?u.arrayIndices:null));}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "range"


    public static class expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "expression"
    // ../src/grammar/WhileLanguage.g:268:1: expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : e1= rel_expression ( '==' e2= rel_expression | '!=' e2= rel_expression )* ;
    public final WhileLanguageParser.expression_return expression() throws RecognitionException {
        WhileLanguageParser.expression_return retval = new WhileLanguageParser.expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.rel_expression_return e1 =null;

        WhileLanguageParser.rel_expression_return e2 =null;


        try {
            // ../src/grammar/WhileLanguage.g:269:9: (e1= rel_expression ( '==' e2= rel_expression | '!=' e2= rel_expression )* )
            // ../src/grammar/WhileLanguage.g:269:11: e1= rel_expression ( '==' e2= rel_expression | '!=' e2= rel_expression )*
            {
            pushFollow(FOLLOW_rel_expression_in_expression1463);
            e1=rel_expression();

            state._fsp--;


            if (!error) {retval.ast = e1.ast; retval.divisors = (e1!=null?e1.divisors:null); retval.arrayIndices = (e1!=null?e1.arrayIndices:null);}

            // ../src/grammar/WhileLanguage.g:269:120: ( '==' e2= rel_expression | '!=' e2= rel_expression )*
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==25) ) {
                    alt27=1;
                }
                else if ( (LA27_0==11) ) {
                    alt27=2;
                }


                switch (alt27) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:270:12: '==' e2= rel_expression
            	    {
            	    match(input,25,FOLLOW_25_in_expression1480); 

            	    pushFollow(FOLLOW_rel_expression_in_expression1484);
            	    e2=rel_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Equal());
            	            	  	retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 2 :
            	    // ../src/grammar/WhileLanguage.g:273:12: '!=' e2= rel_expression
            	    {
            	    match(input,11,FOLLOW_11_in_expression1499); 

            	    pushFollow(FOLLOW_rel_expression_in_expression1503);
            	    e2=rel_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new NotEqual());
            	            		retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class rel_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "rel_expression"
    // ../src/grammar/WhileLanguage.g:280:1: rel_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : e1= add_expression ( '<' e2= add_expression | '<=' e2= add_expression | '>' e2= add_expression | '>=' e2= add_expression )* ;
    public final WhileLanguageParser.rel_expression_return rel_expression() throws RecognitionException {
        WhileLanguageParser.rel_expression_return retval = new WhileLanguageParser.rel_expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.add_expression_return e1 =null;

        WhileLanguageParser.add_expression_return e2 =null;


        try {
            // ../src/grammar/WhileLanguage.g:281:9: (e1= add_expression ( '<' e2= add_expression | '<=' e2= add_expression | '>' e2= add_expression | '>=' e2= add_expression )* )
            // ../src/grammar/WhileLanguage.g:281:11: e1= add_expression ( '<' e2= add_expression | '<=' e2= add_expression | '>' e2= add_expression | '>=' e2= add_expression )*
            {
            pushFollow(FOLLOW_add_expression_in_rel_expression1548);
            e1=add_expression();

            state._fsp--;


            if (!error) {retval.ast = e1.ast; retval.divisors = (e1!=null?e1.divisors:null); retval.arrayIndices = (e1!=null?e1.arrayIndices:null);}

            // ../src/grammar/WhileLanguage.g:281:120: ( '<' e2= add_expression | '<=' e2= add_expression | '>' e2= add_expression | '>=' e2= add_expression )*
            loop28:
            do {
                int alt28=5;
                switch ( input.LA(1) ) {
                case 22:
                    {
                    alt28=1;
                    }
                    break;
                case 23:
                    {
                    alt28=2;
                    }
                    break;
                case 26:
                    {
                    alt28=3;
                    }
                    break;
                case 27:
                    {
                    alt28=4;
                    }
                    break;

                }

                switch (alt28) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:282:12: '<' e2= add_expression
            	    {
            	    match(input,22,FOLLOW_22_in_rel_expression1565); 

            	    pushFollow(FOLLOW_add_expression_in_rel_expression1570);
            	    e2=add_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Less());
            	            	  	retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 2 :
            	    // ../src/grammar/WhileLanguage.g:285:12: '<=' e2= add_expression
            	    {
            	    match(input,23,FOLLOW_23_in_rel_expression1585); 

            	    pushFollow(FOLLOW_add_expression_in_rel_expression1589);
            	    e2=add_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new LessEqual());
            	            		retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 3 :
            	    // ../src/grammar/WhileLanguage.g:288:12: '>' e2= add_expression
            	    {
            	    match(input,26,FOLLOW_26_in_rel_expression1604); 

            	    pushFollow(FOLLOW_add_expression_in_rel_expression1609);
            	    e2=add_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Greater());
            	            		retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 4 :
            	    // ../src/grammar/WhileLanguage.g:291:12: '>=' e2= add_expression
            	    {
            	    match(input,27,FOLLOW_27_in_rel_expression1624); 

            	    pushFollow(FOLLOW_add_expression_in_rel_expression1628);
            	    e2=add_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new GreaterEqual());
            	            		retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_expression"


    public static class add_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "add_expression"
    // ../src/grammar/WhileLanguage.g:297:1: add_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : e1= mul_expression ( '|' e2= mul_expression | '+' e2= mul_expression | '-' e2= mul_expression )* ;
    public final WhileLanguageParser.add_expression_return add_expression() throws RecognitionException {
        WhileLanguageParser.add_expression_return retval = new WhileLanguageParser.add_expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.mul_expression_return e1 =null;

        WhileLanguageParser.mul_expression_return e2 =null;


        try {
            // ../src/grammar/WhileLanguage.g:298:9: (e1= mul_expression ( '|' e2= mul_expression | '+' e2= mul_expression | '-' e2= mul_expression )* )
            // ../src/grammar/WhileLanguage.g:298:11: e1= mul_expression ( '|' e2= mul_expression | '+' e2= mul_expression | '-' e2= mul_expression )*
            {
            pushFollow(FOLLOW_mul_expression_in_add_expression1672);
            e1=mul_expression();

            state._fsp--;


            if (!error) {retval.ast = e1.ast; retval.divisors = (e1!=null?e1.divisors:null); retval.arrayIndices = (e1!=null?e1.arrayIndices:null);}

            // ../src/grammar/WhileLanguage.g:298:120: ( '|' e2= mul_expression | '+' e2= mul_expression | '-' e2= mul_expression )*
            loop29:
            do {
                int alt29=4;
                switch ( input.LA(1) ) {
                case 44:
                    {
                    alt29=1;
                    }
                    break;
                case 17:
                    {
                    alt29=2;
                    }
                    break;
                case 19:
                    {
                    alt29=3;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:299:12: '|' e2= mul_expression
            	    {
            	    match(input,44,FOLLOW_44_in_add_expression1689); 

            	    pushFollow(FOLLOW_mul_expression_in_add_expression1693);
            	    e2=mul_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Disjunction());
            	            	  	retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 2 :
            	    // ../src/grammar/WhileLanguage.g:302:12: '+' e2= mul_expression
            	    {
            	    match(input,17,FOLLOW_17_in_add_expression1708); 

            	    pushFollow(FOLLOW_mul_expression_in_add_expression1712);
            	    e2=mul_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new ArithmeticExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Addition());
            	            		retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 3 :
            	    // ../src/grammar/WhileLanguage.g:305:12: '-' e2= mul_expression
            	    {
            	    match(input,19,FOLLOW_19_in_add_expression1727); 

            	    pushFollow(FOLLOW_mul_expression_in_add_expression1731);
            	    e2=mul_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new ArithmeticExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Subtraction());
            	            		retval.divisors.addAll(e2.divisors);retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "add_expression"


    public static class mul_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "mul_expression"
    // ../src/grammar/WhileLanguage.g:311:1: mul_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : e1= unary_expression ( '&' e2= unary_expression | '*' e2= unary_expression | '/' e2= unary_expression | '%' e2= unary_expression )* ;
    public final WhileLanguageParser.mul_expression_return mul_expression() throws RecognitionException {
        WhileLanguageParser.mul_expression_return retval = new WhileLanguageParser.mul_expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.unary_expression_return e1 =null;

        WhileLanguageParser.unary_expression_return e2 =null;


        try {
            // ../src/grammar/WhileLanguage.g:312:9: (e1= unary_expression ( '&' e2= unary_expression | '*' e2= unary_expression | '/' e2= unary_expression | '%' e2= unary_expression )* )
            // ../src/grammar/WhileLanguage.g:312:11: e1= unary_expression ( '&' e2= unary_expression | '*' e2= unary_expression | '/' e2= unary_expression | '%' e2= unary_expression )*
            {
            pushFollow(FOLLOW_unary_expression_in_mul_expression1775);
            e1=unary_expression();

            state._fsp--;


            if (!error) {retval.ast = e1.ast; retval.divisors = (e1!=null?e1.divisors:null); retval.arrayIndices = (e1!=null?e1.arrayIndices:null);}

            // ../src/grammar/WhileLanguage.g:312:122: ( '&' e2= unary_expression | '*' e2= unary_expression | '/' e2= unary_expression | '%' e2= unary_expression )*
            loop30:
            do {
                int alt30=5;
                switch ( input.LA(1) ) {
                case 13:
                    {
                    alt30=1;
                    }
                    break;
                case 16:
                    {
                    alt30=2;
                    }
                    break;
                case 20:
                    {
                    alt30=3;
                    }
                    break;
                case 12:
                    {
                    alt30=4;
                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:313:12: '&' e2= unary_expression
            	    {
            	    match(input,13,FOLLOW_13_in_mul_expression1792); 

            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1796);
            	    e2=unary_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Conjunction());
            	            	  	retval.divisors.addAll(e2.divisors);
            	                    retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 2 :
            	    // ../src/grammar/WhileLanguage.g:317:12: '*' e2= unary_expression
            	    {
            	    match(input,16,FOLLOW_16_in_mul_expression1811); 

            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1815);
            	    e2=unary_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new ArithmeticExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Multiplication());
            	            		retval.divisors.addAll(e2.divisors);
            	                    retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 3 :
            	    // ../src/grammar/WhileLanguage.g:321:12: '/' e2= unary_expression
            	    {
            	    match(input,20,FOLLOW_20_in_mul_expression1830); 

            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1834);
            	    e2=unary_expression();

            	    state._fsp--;


            	    if (!error) {retval.ast = new ArithmeticExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
            	                        retval.ast, (e2!=null?e2.ast:null), new Division());
            	            		retval.divisors.addAll(e2.divisors);
            	            		retval.divisors.add((e2!=null?e2.ast:null));
            	                    retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;
            	case 4 :
            	    // ../src/grammar/WhileLanguage.g:326:12: '%' e2= unary_expression
            	    {
            	    match(input,12,FOLLOW_12_in_mul_expression1849); 

            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1853);
            	    e2=unary_expression();

            	    state._fsp--;


            	    if (!error) {
            	            		retval.ast = new ArithmeticExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), retval.ast, (e2!=null?e2.ast:null), new Modulo());
            	            		retval.divisors.addAll(e2.divisors);
            	            		retval.divisors.add((e2!=null?e2.ast:null));
            	                    retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mul_expression"


    public static class unary_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "unary_expression"
    // ../src/grammar/WhileLanguage.g:334:1: unary_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : ( '!' e= parenthesized_expression | '-' e= parenthesized_expression | ( '+' )? e= parenthesized_expression );
    public final WhileLanguageParser.unary_expression_return unary_expression() throws RecognitionException {
        WhileLanguageParser.unary_expression_return retval = new WhileLanguageParser.unary_expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.parenthesized_expression_return e =null;


        try {
            // ../src/grammar/WhileLanguage.g:335:9: ( '!' e= parenthesized_expression | '-' e= parenthesized_expression | ( '+' )? e= parenthesized_expression )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 10:
                {
                alt32=1;
                }
                break;
            case 19:
                {
                alt32=2;
                }
                break;
            case BOOL_LITERAL:
            case IDENT:
            case INT_LITERAL:
            case 14:
            case 17:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }

            switch (alt32) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:335:11: '!' e= parenthesized_expression
                    {
                    match(input,10,FOLLOW_10_in_unary_expression1895); 

                    pushFollow(FOLLOW_parenthesized_expression_in_unary_expression1900);
                    e=parenthesized_expression();

                    state._fsp--;


                    if (!error) {
                            	retval.ast = new LogicalExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e!=null?e.ast:null), null, new Negation());
                            	retval.divisors = e.divisors; retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:338:11: '-' e= parenthesized_expression
                    {
                    match(input,19,FOLLOW_19_in_unary_expression1914); 

                    pushFollow(FOLLOW_parenthesized_expression_in_unary_expression1919);
                    e=parenthesized_expression();

                    state._fsp--;


                    if (!error) {
                            	retval.ast = new ArithmeticExpression(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()), (e!=null?e.ast:null), null, new UnaryMinus());
                            	retval.divisors = e.divisors; retval.arrayIndices = (e!=null?e.arrayIndices:null);}

                    }
                    break;
                case 3 :
                    // ../src/grammar/WhileLanguage.g:341:11: ( '+' )? e= parenthesized_expression
                    {
                    // ../src/grammar/WhileLanguage.g:341:11: ( '+' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==17) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../src/grammar/WhileLanguage.g:341:11: '+'
                            {
                            match(input,17,FOLLOW_17_in_unary_expression1933); 

                            }
                            break;

                    }


                    pushFollow(FOLLOW_parenthesized_expression_in_unary_expression1938);
                    e=parenthesized_expression();

                    state._fsp--;


                    if (!error) {
                            	retval.ast = (e!=null?e.ast:null);
                            	retval.divisors = e.divisors;
                                retval.arrayIndices = (e!=null?e.arrayIndices:null)}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unary_expression"


    public static class parenthesized_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "parenthesized_expression"
    // ../src/grammar/WhileLanguage.g:347:1: parenthesized_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : ( '(' expression ')' | function_call | array_read | IDENT | literal_expression );
    public final WhileLanguageParser.parenthesized_expression_return parenthesized_expression() throws RecognitionException {
        WhileLanguageParser.parenthesized_expression_return retval = new WhileLanguageParser.parenthesized_expression_return();
        retval.start = input.LT(1);


        Token IDENT34=null;
        WhileLanguageParser.expression_return expression31 =null;

        WhileLanguageParser.function_call_return function_call32 =null;

        WhileLanguageParser.array_read_return array_read33 =null;

        WhileLanguageParser.literal_expression_return literal_expression35 =null;


        try {
            // ../src/grammar/WhileLanguage.g:348:9: ( '(' expression ')' | function_call | array_read | IDENT | literal_expression )
            int alt33=5;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt33=1;
                }
                break;
            case IDENT:
                {
                switch ( input.LA(2) ) {
                case 14:
                    {
                    alt33=2;
                    }
                    break;
                case 28:
                    {
                    alt33=3;
                    }
                    break;
                case EOF:
                case 11:
                case 12:
                case 13:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 25:
                case 26:
                case 27:
                case 29:
                case 44:
                    {
                    alt33=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;

                }

                }
                break;
            case BOOL_LITERAL:
            case INT_LITERAL:
                {
                alt33=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }

            switch (alt33) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:348:11: '(' expression ')'
                    {
                    match(input,14,FOLLOW_14_in_parenthesized_expression1969); 

                    pushFollow(FOLLOW_expression_in_parenthesized_expression1971);
                    expression31=expression();

                    state._fsp--;


                    match(input,15,FOLLOW_15_in_parenthesized_expression1973); 

                    if (!error) {retval.ast = (expression31!=null?expression31.ast:null); retval.divisors = (expression31!=null?expression31.divisors:null);
                                    retval.arrayIndices = (expression31!=null?expression31.arrayIndices:null);}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:350:11: function_call
                    {
                    pushFollow(FOLLOW_function_call_in_parenthesized_expression1987);
                    function_call32=function_call();

                    state._fsp--;


                    if (!error) {retval.ast = (function_call32!=null?function_call32.ast:null); retval.divisors = (function_call32!=null?function_call32.divisors:null);
                                                retval.arrayIndices = $functionCall.arrayIndices;}

                    }
                    break;
                case 3 :
                    // ../src/grammar/WhileLanguage.g:352:11: array_read
                    {
                    pushFollow(FOLLOW_array_read_in_parenthesized_expression2001);
                    array_read33=array_read();

                    state._fsp--;


                    if (!error) {retval.ast = (array_read33!=null?array_read33.ast:null); retval.divisors = (array_read33!=null?array_read33.divisors:null);
                                            retval.arrayIndices = $functionCall.arrayIndices;}

                    }
                    break;
                case 4 :
                    // ../src/grammar/WhileLanguage.g:354:11: IDENT
                    {
                    IDENT34=(Token)match(input,IDENT,FOLLOW_IDENT_in_parenthesized_expression2015); 

                    if (!error) {retval.ast = new VariableRead(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
                                new Identifier((IDENT34!=null?IDENT34.getText():null))); retval.divisors = new LinkedList<Expression>();
                                retval.arrayIndices = new LinkedList<Expression>();}

                    }
                    break;
                case 5 :
                    // ../src/grammar/WhileLanguage.g:357:11: literal_expression
                    {
                    pushFollow(FOLLOW_literal_expression_in_parenthesized_expression2029);
                    literal_expression35=literal_expression();

                    state._fsp--;


                    if (!error) {retval.ast = (literal_expression35!=null?literal_expression35.ast:null); retval.divisors = (literal_expression35!=null?literal_expression35.divisors:null);
                                retval.arrayIndices = $literalExpression.arrayIndices;}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parenthesized_expression"


    public static class function_call_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "function_call"
    // ../src/grammar/WhileLanguage.g:361:1: function_call returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : IDENT '(' ( arglist )? ')' ;
    public final WhileLanguageParser.function_call_return function_call() throws RecognitionException {
        WhileLanguageParser.function_call_return retval = new WhileLanguageParser.function_call_return();
        retval.start = input.LT(1);


        Token IDENT37=null;
        WhileLanguageParser.arglist_return arglist36 =null;


        try {
            // ../src/grammar/WhileLanguage.g:362:9: ( IDENT '(' ( arglist )? ')' )
            // ../src/grammar/WhileLanguage.g:362:11: IDENT '(' ( arglist )? ')'
            {
            IDENT37=(Token)match(input,IDENT,FOLLOW_IDENT_in_function_call2060); 

            match(input,14,FOLLOW_14_in_function_call2062); 

            // ../src/grammar/WhileLanguage.g:362:21: ( arglist )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==BOOL_LITERAL||(LA34_0 >= IDENT && LA34_0 <= INT_LITERAL)||LA34_0==10||LA34_0==14||LA34_0==17||LA34_0==19) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:362:21: arglist
                    {
                    pushFollow(FOLLOW_arglist_in_function_call2064);
                    arglist36=arglist();

                    state._fsp--;


                    }
                    break;

            }


            match(input,15,FOLLOW_15_in_function_call2067); 

            if (!error) {
                    	Expression[] params = new Expression[0];
                    	if ((arglist36!=null?arglist36.params:null) != null) params = (arglist36!=null?arglist36.params:null).toArray(new Expression[(arglist36!=null?arglist36.params:null).size()]);
                    	retval.ast = new FunctionCall(new Identifier((IDENT37!=null?IDENT37.getText():null)), params , new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()));
                    	retval.divisors = (arglist36!=null?arglist36.divisors:null);
                        retval.arrayIndices = (arglist36!=null?arglist36.arrayIndices:null)}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "function_call"


    public static class arglist_return extends ParserRuleReturnScope {
        public LinkedList<Expression> params;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "arglist"
    // ../src/grammar/WhileLanguage.g:370:1: arglist returns [ LinkedList<Expression> params, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : e1= expression ( ',' e2= expression )* ;
    public final WhileLanguageParser.arglist_return arglist() throws RecognitionException {
        WhileLanguageParser.arglist_return retval = new WhileLanguageParser.arglist_return();
        retval.start = input.LT(1);


        WhileLanguageParser.expression_return e1 =null;

        WhileLanguageParser.expression_return e2 =null;


        retval.params = new LinkedList<Expression>();
        try {
            // ../src/grammar/WhileLanguage.g:372:9: (e1= expression ( ',' e2= expression )* )
            // ../src/grammar/WhileLanguage.g:372:11: e1= expression ( ',' e2= expression )*
            {
            pushFollow(FOLLOW_expression_in_arglist2106);
            e1=expression();

            state._fsp--;


            if (!error) {retval.params.add((Expression) e1.ast); retval.divisors = (e1!=null?e1.divisors:null); retval.arrayIndices = (e1!=null?e1.arrayIndices:null)}

            // ../src/grammar/WhileLanguage.g:373:10: ( ',' e2= expression )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==18) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:373:12: ',' e2= expression
            	    {
            	    match(input,18,FOLLOW_18_in_arglist2121); 

            	    pushFollow(FOLLOW_expression_in_arglist2125);
            	    e2=expression();

            	    state._fsp--;


            	    if (!error) {retval.params.add((Expression) (e2!=null?e2.ast:null)); retval.divisors.addAll((e2!=null?e2.divisors:null));
            	                                    retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));}

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arglist"


    public static class array_read_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "array_read"
    // ../src/grammar/WhileLanguage.g:377:1: array_read returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : IDENT '[' e1= expression ']' ( '[' e2= expression ']' )* ;
    public final WhileLanguageParser.array_read_return array_read() throws RecognitionException {
        WhileLanguageParser.array_read_return retval = new WhileLanguageParser.array_read_return();
        retval.start = input.LT(1);


        Token IDENT38=null;
        WhileLanguageParser.expression_return e1 =null;

        WhileLanguageParser.expression_return e2 =null;


        LinkedList<Expression> l = new LinkedList<Expression>(); retval.arrayIndices = new LinkedList<Expression>()
        try {
            // ../src/grammar/WhileLanguage.g:379:9: ( IDENT '[' e1= expression ']' ( '[' e2= expression ']' )* )
            // ../src/grammar/WhileLanguage.g:379:11: IDENT '[' e1= expression ']' ( '[' e2= expression ']' )*
            {
            IDENT38=(Token)match(input,IDENT,FOLLOW_IDENT_in_array_read2165); 

            match(input,28,FOLLOW_28_in_array_read2167); 

            pushFollow(FOLLOW_expression_in_array_read2171);
            e1=expression();

            state._fsp--;


            if (!error) {l.add((e1!=null?e1.ast:null)); retval.arrayIndices.add((e1!=null?e1.ast:null));
                            retval.arrayIndices.addAll((e1!=null?e1.arrayIndices:null));
                    		retval.divisors = (e1!=null?e1.divisors:null);}

            match(input,29,FOLLOW_29_in_array_read2175); 

            // ../src/grammar/WhileLanguage.g:382:10: ( '[' e2= expression ']' )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==28) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:382:12: '[' e2= expression ']'
            	    {
            	    match(input,28,FOLLOW_28_in_array_read2188); 

            	    pushFollow(FOLLOW_expression_in_array_read2192);
            	    e2=expression();

            	    state._fsp--;


            	    if (!error) {l.add((e2!=null?e2.ast:null)); retval.arrayIndices.add((e2!=null?e2.ast:null));
            	                    retval.arrayIndices.addAll((e2!=null?e2.arrayIndices:null));
            	            		retval.divisors.addAll((e2!=null?e2.divisors:null));}

            	    match(input,29,FOLLOW_29_in_array_read2196); 

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            if (!error) {retval.ast = new ArrayRead(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
                        new Identifier((IDENT38!=null?IDENT38.getText():null)), l.toArray(new Expression[l.size()]));}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "array_read"


    public static class literal_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
        public LinkedList<Expression> arrayIndices;
    };


    // $ANTLR start "literal_expression"
    // ../src/grammar/WhileLanguage.g:389:1: literal_expression returns [ Expression ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : ( INT_LITERAL | BOOL_LITERAL );
    public final WhileLanguageParser.literal_expression_return literal_expression() throws RecognitionException {
        WhileLanguageParser.literal_expression_return retval = new WhileLanguageParser.literal_expression_return();
        retval.start = input.LT(1);


        Token INT_LITERAL39=null;
        Token BOOL_LITERAL40=null;

        retval.divisors = new LinkedList<Expression>(); retval.arrayIndices = new LinkedList<Expression>();
        try {
            // ../src/grammar/WhileLanguage.g:391:9: ( INT_LITERAL | BOOL_LITERAL )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==INT_LITERAL) ) {
                alt37=1;
            }
            else if ( (LA37_0==BOOL_LITERAL) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:391:11: INT_LITERAL
                    {
                    INT_LITERAL39=(Token)match(input,INT_LITERAL,FOLLOW_INT_LITERAL_in_literal_expression2247); 

                    if (!error) {retval.ast = new NumericLiteral(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
                                (INT_LITERAL39!=null?INT_LITERAL39.getText():null));}

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:393:11: BOOL_LITERAL
                    {
                    BOOL_LITERAL40=(Token)match(input,BOOL_LITERAL,FOLLOW_BOOL_LITERAL_in_literal_expression2261); 

                    if (!error) {retval.ast = new BooleanLiteral(new Position(((Token)retval.start).getLine(), ((Token)retval.start).getCharPositionInLine()),
                                (BOOL_LITERAL40!=null?BOOL_LITERAL40.getText():null)); retval.divisors = new LinkedList<Expression>();}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal_expression"



    // $ANTLR start "type"
    // ../src/grammar/WhileLanguage.g:397:1: type returns [ Type ast ] : ( 'int' | 'bool' ) ( '[' ']' )* ;
    public final Type type() throws RecognitionException {
        Type ast = null;


        try {
            // ../src/grammar/WhileLanguage.g:398:9: ( ( 'int' | 'bool' ) ( '[' ']' )* )
            // ../src/grammar/WhileLanguage.g:398:11: ( 'int' | 'bool' ) ( '[' ']' )*
            {
            // ../src/grammar/WhileLanguage.g:398:11: ( 'int' | 'bool' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==38) ) {
                alt38=1;
            }
            else if ( (LA38_0==34) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }
            switch (alt38) {
                case 1 :
                    // ../src/grammar/WhileLanguage.g:398:12: 'int'
                    {
                    match(input,38,FOLLOW_38_in_type2293); 

                    ast = error ? null : new IntegerType();

                    }
                    break;
                case 2 :
                    // ../src/grammar/WhileLanguage.g:399:11: 'bool'
                    {
                    match(input,34,FOLLOW_34_in_type2307); 

                    ast = error ? null : new BooleanType();

                    }
                    break;

            }


            // ../src/grammar/WhileLanguage.g:399:61: ( '[' ']' )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==28) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../src/grammar/WhileLanguage.g:399:63: '[' ']'
            	    {
            	    match(input,28,FOLLOW_28_in_type2313); 

            	    match(input,29,FOLLOW_29_in_type2315); 

            	    ast = error ? null : new ArrayType(ast);

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ast;
    }
    // $ANTLR end "type"

    // Delegated rules


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\16\uffff";
    static final String DFA13_eofS =
        "\16\uffff";
    static final String DFA13_minS =
        "\1\6\1\uffff\2\6\4\uffff\1\35\1\25\1\6\1\4\2\uffff";
    static final String DFA13_maxS =
        "\1\52\1\uffff\2\34\4\uffff\1\35\1\30\1\34\1\36\2\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\6\1\7\4\uffff\1\2\1\3";
    static final String DFA13_specialS =
        "\16\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\4\30\uffff\1\1\2\uffff\1\3\2\uffff\1\5\1\2\2\uffff\1\7\1"+
            "\6",
            "",
            "\1\11\25\uffff\1\10",
            "\1\11\25\uffff\1\10",
            "",
            "",
            "",
            "",
            "\1\12",
            "\1\14\2\uffff\1\13",
            "\1\11\25\uffff\1\10",
            "\1\14\1\uffff\2\14\2\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1"+
            "\uffff\1\14\12\uffff\1\15",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "124:1: statement returns [ Statement ast, LinkedList<Expression> divisors, LinkedList<Expression> arrayIndices ] : (e= assert_statement |e= variable_declaration |e= array_declaration |e= assignment |e= if_statement |e= while_statement |e= return_statement );";
        }
    }
 

    public static final BitSet FOLLOW_axiom_statement_in_program61 = new BitSet(new long[]{0x0000014600000000L});
    public static final BitSet FOLLOW_function_declaration_in_program82 = new BitSet(new long[]{0x0000014400000000L});
    public static final BitSet FOLLOW_main_in_program88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_single_expression121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_function_declaration145 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_function_declaration147 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_function_declaration149 = new BitSet(new long[]{0x0000004400008000L});
    public static final BitSet FOLLOW_parameter_list_in_function_declaration153 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_function_declaration156 = new BitSet(new long[]{0x0000080100000000L});
    public static final BitSet FOLLOW_function_body_in_function_declaration158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_main198 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_main200 = new BitSet(new long[]{0x0000004400008000L});
    public static final BitSet FOLLOW_parameter_list_in_main202 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_main205 = new BitSet(new long[]{0x0000080100000000L});
    public static final BitSet FOLLOW_function_body_in_main207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_parameter_list262 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parameter_list268 = new BitSet(new long[]{0x0000004400000000L});
    public static final BitSet FOLLOW_parameter_in_parameter_list272 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_type_in_parameter306 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_parameter308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assume_statement_in_function_body347 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_function_body362 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_statement_in_function_body366 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_45_in_function_body373 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ensure_statement_in_function_body403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_if_body441 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_statement_in_if_body445 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_45_in_if_body452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invariant_statement_in_loop_body503 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_loop_body518 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_statement_in_loop_body522 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_45_in_loop_body529 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ensure_statement_in_loop_body559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_declaration_in_statement609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_declaration_in_statement625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_statement_in_statement689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_invariant_statement726 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_invariant_statement730 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_invariant_statement732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_invariant_statement746 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_invariant_statement748 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_invariant_statement753 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_invariant_statement755 = new BitSet(new long[]{0x00002000000A45D0L});
    public static final BitSet FOLLOW_45_in_invariant_statement762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_axiom_statement800 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_axiom_statement804 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_axiom_statement806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_assert_statement837 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_assert_statement841 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assert_statement843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_assume_statement880 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_assume_statement884 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assume_statement886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_assume_statement900 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_assume_statement902 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_assume_statement907 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assume_statement909 = new BitSet(new long[]{0x00002000000A45D0L});
    public static final BitSet FOLLOW_45_in_assume_statement916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ensure_statement951 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_ensure_statement955 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ensure_statement957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ensure_statement971 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ensure_statement973 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_ensure_statement978 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ensure_statement980 = new BitSet(new long[]{0x00002000000A45D0L});
    public static final BitSet FOLLOW_45_in_ensure_statement987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignment1025 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_assignment1027 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_assignment1029 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assignment1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignment1045 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_assignment1060 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_assignment1064 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_assignment1078 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_assignment1083 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_assignment1087 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assignment1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_variable_declaration1132 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_variable_declaration1134 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_variable_declaration1138 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_variable_declaration1140 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_variable_declaration1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_array_declaration1176 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_array_declaration1178 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_array_declaration1180 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_array_init_in_array_declaration1182 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_array_declaration1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_array_init1217 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_init1221 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_array_init1223 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_array_init1227 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_37_in_if_statement1252 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_statement1254 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_if_statement1256 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_if_statement1258 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_if_body_in_if_statement1262 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_if_statement1266 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_if_body_in_if_statement1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_while_statement1304 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_statement1306 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_while_statement1308 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_while_statement1310 = new BitSet(new long[]{0x0000088000000000L});
    public static final BitSet FOLLOW_loop_body_in_while_statement1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_statement1336 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_return_statement1338 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_return_statement1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUANTIFIER_in_quantified_expression1364 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_quantified_expression1366 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_quantified_expression1368 = new BitSet(new long[]{0x00000000000AC4D0L});
    public static final BitSet FOLLOW_range_in_quantified_expression1370 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_quantified_expression1373 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_quantified_expression1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_quantified_expression1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_range1424 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_range1426 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_range1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_expression_in_expression1463 = new BitSet(new long[]{0x0000000002000802L});
    public static final BitSet FOLLOW_25_in_expression1480 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_rel_expression_in_expression1484 = new BitSet(new long[]{0x0000000002000802L});
    public static final BitSet FOLLOW_11_in_expression1499 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_rel_expression_in_expression1503 = new BitSet(new long[]{0x0000000002000802L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1548 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_22_in_rel_expression1565 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1570 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_23_in_rel_expression1585 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1589 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_26_in_rel_expression1604 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1609 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_27_in_rel_expression1624 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1628 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1672 = new BitSet(new long[]{0x00001000000A0002L});
    public static final BitSet FOLLOW_44_in_add_expression1689 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1693 = new BitSet(new long[]{0x00001000000A0002L});
    public static final BitSet FOLLOW_17_in_add_expression1708 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1712 = new BitSet(new long[]{0x00001000000A0002L});
    public static final BitSet FOLLOW_19_in_add_expression1727 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1731 = new BitSet(new long[]{0x00001000000A0002L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1775 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_13_in_mul_expression1792 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1796 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_16_in_mul_expression1811 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1815 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_20_in_mul_expression1830 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1834 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_12_in_mul_expression1849 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1853 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_10_in_unary_expression1895 = new BitSet(new long[]{0x00000000000040D0L});
    public static final BitSet FOLLOW_parenthesized_expression_in_unary_expression1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unary_expression1914 = new BitSet(new long[]{0x00000000000040D0L});
    public static final BitSet FOLLOW_parenthesized_expression_in_unary_expression1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unary_expression1933 = new BitSet(new long[]{0x00000000000040D0L});
    public static final BitSet FOLLOW_parenthesized_expression_in_unary_expression1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parenthesized_expression1969 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_parenthesized_expression1971 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parenthesized_expression1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_parenthesized_expression1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_read_in_parenthesized_expression2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_parenthesized_expression2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_expression_in_parenthesized_expression2029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_function_call2060 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_function_call2062 = new BitSet(new long[]{0x00000000000AC4D0L});
    public static final BitSet FOLLOW_arglist_in_function_call2064 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_function_call2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_arglist2106 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_arglist2121 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_arglist2125 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_IDENT_in_array_read2165 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_read2167 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_array_read2171 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_array_read2175 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_array_read2188 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_array_read2192 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_array_read2196 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_INT_LITERAL_in_literal_expression2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_LITERAL_in_literal_expression2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_type2293 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_34_in_type2307 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_type2313 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_type2315 = new BitSet(new long[]{0x0000000010000002L});

}