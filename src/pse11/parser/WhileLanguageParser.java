// $ANTLR 3.4 C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g 2012-01-12 17:10:02

	package parser;
	import ast.*;
	import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class WhileLanguageParser extends DebugParser {
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


public static final String[] ruleNames = new String[] {
    "invalidRule", "arglist", "array_declaration", "array_init", "while_statement", 
    "function_declaration", "statement", "unary_expression", "ensure_statement", 
    "function_call", "rel_expression", "invariant_statement", "add_expression", 
    "return_statement", "array_read", "if_statement", "type", "assume_statement", 
    "assert_statement", "parameter", "assignment", "axiom_statement", "parenthesized_expression", 
    "literal_expression", "expression", "parameter_list", "if_body", "range", 
    "quantified_expression", "program", "function_body", "main", "mul_expression", 
    "variable_declaration", "single_expression", "loop_body"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public WhileLanguageParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public WhileLanguageParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public WhileLanguageParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return WhileLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g"; }



    // $ANTLR start "program"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:13:1: program returns [Program p] : (a= axiom_statement )* (f= function_declaration )* main ;
    public final Program program() throws RecognitionException {
        Program p = null;


        Axiom a =null;

        Function f =null;

        Function main1 =null;


        LinkedList<Axiom> axiom = new LinkedList<Axiom>();
        	       LinkedList<Function> function = new LinkedList<Function>();
        try { dbg.enterRule(getGrammarFileName(), "program");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(13, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:9: ( (a= axiom_statement )* (f= function_declaration )* main )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:11: (a= axiom_statement )* (f= function_declaration )* main
            {
            dbg.location(16,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:11: (a= axiom_statement )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==33) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:12: a= axiom_statement
            	    {
            	    dbg.location(16,13);
            	    pushFollow(FOLLOW_axiom_statement_in_program46);
            	    a=axiom_statement();

            	    state._fsp--;

            	    dbg.location(16,30);
            	    axiom.add(a);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(16,53);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:53: (f= function_declaration )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==34||LA2_0==38) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:54: f= function_declaration
            	    {
            	    dbg.location(16,55);
            	    pushFollow(FOLLOW_function_declaration_in_program55);
            	    f=function_declaration();

            	    state._fsp--;

            	    dbg.location(16,77);
            	    function.add(f);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}

            dbg.location(16,103);
            pushFollow(FOLLOW_main_in_program61);
            main1=main();

            state._fsp--;

            dbg.location(17,10);
            p = new Program(new Position(), function.toArray(new Function[function.size()]), main1,
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
        dbg.location(19, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "program");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return p;
    }
    // $ANTLR end "program"



    // $ANTLR start "single_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:21:1: single_expression returns [ Expression ast ] : expression ;
    public final Expression single_expression() throws RecognitionException {
        Expression ast = null;


        WhileLanguageParser.expression_return expression2 =null;


        try { dbg.enterRule(getGrammarFileName(), "single_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(21, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:22:2: ( expression )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:22:4: expression
            {
            dbg.location(22,4);
            pushFollow(FOLLOW_expression_in_single_expression94);
            expression2=expression();

            state._fsp--;

            dbg.location(22,15);
            ast = (expression2!=null?expression2.ast:null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(23, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "single_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "single_expression"



    // $ANTLR start "function_declaration"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:25:1: function_declaration returns [ Function ast ] : type IDENT '(' ( parameter_list )? ')' function_body ;
    public final Function function_declaration() throws RecognitionException {
        Function ast = null;


        Token IDENT3=null;
        LinkedList<FunctionParameter> parameter_list4 =null;

        WhileLanguageParser.function_body_return function_body5 =null;


        try { dbg.enterRule(getGrammarFileName(), "function_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(25, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:26:9: ( type IDENT '(' ( parameter_list )? ')' function_body )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:26:11: type IDENT '(' ( parameter_list )? ')' function_body
            {
            dbg.location(26,11);
            pushFollow(FOLLOW_type_in_function_declaration118);
            type();

            state._fsp--;

            dbg.location(26,16);
            IDENT3=(Token)match(input,IDENT,FOLLOW_IDENT_in_function_declaration120); 
            dbg.location(26,22);
            match(input,14,FOLLOW_14_in_function_declaration122); 
            dbg.location(26,26);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:26:26: ( parameter_list )?
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3, decisionCanBacktrack[3]);

            int LA3_0 = input.LA(1);

            if ( (LA3_0==34||LA3_0==38) ) {
                alt3=1;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:26:26: parameter_list
                    {
                    dbg.location(26,26);
                    pushFollow(FOLLOW_parameter_list_in_function_declaration124);
                    parameter_list4=parameter_list();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}

            dbg.location(26,42);
            match(input,15,FOLLOW_15_in_function_declaration127); 
            dbg.location(26,46);
            pushFollow(FOLLOW_function_body_in_function_declaration129);
            function_body5=function_body();

            state._fsp--;

            dbg.location(27,10);
            if ("main".equals((IDENT3!=null?IDENT3.getText():null))) throw new TreeGeneratorException("Main must only be declared once.");
                    	 ast = new Function(new Position(), null, "main", 
                    		parameter_list4.toArray(new FunctionParameter[parameter_list4.size()]),
                    		(function_body5!=null?function_body5.ast:null), (function_body5!=null?function_body5.pre:null).toArray(new Assumption[(function_body5!=null?function_body5.pre:null).size()]),
                    		(function_body5!=null?function_body5.post:null).toArray(new Ensure[(function_body5!=null?function_body5.post:null).size()]));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(32, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function_declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "function_declaration"



    // $ANTLR start "main"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:34:1: main returns [ Function ast ] : 'main' '(' ( parameter_list )? ')' function_body ;
    public final Function main() throws RecognitionException {
        Function ast = null;


        LinkedList<FunctionParameter> parameter_list6 =null;

        WhileLanguageParser.function_body_return function_body7 =null;


        try { dbg.enterRule(getGrammarFileName(), "main");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(34, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:35:9: ( 'main' '(' ( parameter_list )? ')' function_body )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:35:11: 'main' '(' ( parameter_list )? ')' function_body
            {
            dbg.location(35,11);
            match(input,40,FOLLOW_40_in_main169); 
            dbg.location(35,18);
            match(input,14,FOLLOW_14_in_main171); 
            dbg.location(35,22);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:35:22: ( parameter_list )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==34||LA4_0==38) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:35:22: parameter_list
                    {
                    dbg.location(35,22);
                    pushFollow(FOLLOW_parameter_list_in_main173);
                    parameter_list6=parameter_list();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}

            dbg.location(35,38);
            match(input,15,FOLLOW_15_in_main176); 
            dbg.location(35,42);
            pushFollow(FOLLOW_function_body_in_main178);
            function_body7=function_body();

            state._fsp--;

            dbg.location(36,10);
            ast = new Function(new Position(), null, "main", 
                    		parameter_list6.toArray(new FunctionParameter[parameter_list6.size()]),
                    		(function_body7!=null?function_body7.ast:null), (function_body7!=null?function_body7.pre:null).toArray(new Assumption[(function_body7!=null?function_body7.pre:null).size()]),
                    		(function_body7!=null?function_body7.post:null).toArray(new Ensure[(function_body7!=null?function_body7.post:null).size()]));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(40, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "main");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "main"



    // $ANTLR start "parameter_list"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:42:1: parameter_list returns [ LinkedList<FunctionParameter> params ] : p1= parameter ( ',' p2= parameter )* ;
    public final LinkedList<FunctionParameter> parameter_list() throws RecognitionException {
        LinkedList<FunctionParameter> params = null;


        FunctionParameter p1 =null;

        FunctionParameter p2 =null;


        params = new LinkedList<FunctionParameter>();
        try { dbg.enterRule(getGrammarFileName(), "parameter_list");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(42, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:44:9: (p1= parameter ( ',' p2= parameter )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:44:11: p1= parameter ( ',' p2= parameter )*
            {
            dbg.location(44,13);
            pushFollow(FOLLOW_parameter_in_parameter_list227);
            p1=parameter();

            state._fsp--;

            dbg.location(44,24);
            params.add(p1);
            dbg.location(44,48);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:44:48: ( ',' p2= parameter )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:44:50: ',' p2= parameter
            	    {
            	    dbg.location(44,50);
            	    match(input,18,FOLLOW_18_in_parameter_list233); 
            	    dbg.location(44,56);
            	    pushFollow(FOLLOW_parameter_in_parameter_list237);
            	    p2=parameter();

            	    state._fsp--;

            	    dbg.location(44,67);
            	    params.add(p2);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);
            } finally {dbg.exitSubRule(5);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(45, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameter_list");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return params;
    }
    // $ANTLR end "parameter_list"



    // $ANTLR start "parameter"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:47:1: parameter returns [ FunctionParameter ast ] : type IDENT ;
    public final FunctionParameter parameter() throws RecognitionException {
        FunctionParameter ast = null;


        Token IDENT8=null;
        Type type9 =null;


        try { dbg.enterRule(getGrammarFileName(), "parameter");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(47, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:48:9: ( type IDENT )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:48:11: type IDENT
            {
            dbg.location(48,11);
            pushFollow(FOLLOW_type_in_parameter271);
            type9=type();

            state._fsp--;

            dbg.location(48,16);
            IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_parameter273); 
            dbg.location(48,22);
            ast = new FunctionParameter((IDENT8!=null?IDENT8.getText():null), type9);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(49, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameter");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:51:1: function_body returns [ StatementBlock ast, LinkedList<Assumption> pre, LinkedList<Ensure> post ] : ( assume_statement )? '{' ( statement )* '}' ( ensure_statement )? ;
    public final WhileLanguageParser.function_body_return function_body() throws RecognitionException {
        WhileLanguageParser.function_body_return retval = new WhileLanguageParser.function_body_return();
        retval.start = input.LT(1);


        Statement statement10 =null;


        LinkedList<Statement> s = new LinkedList<Statement>();
        try { dbg.enterRule(getGrammarFileName(), "function_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(51, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:53:9: ( ( assume_statement )? '{' ( statement )* '}' ( ensure_statement )? )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:53:11: ( assume_statement )? '{' ( statement )* '}' ( ensure_statement )?
            {
            dbg.location(53,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:53:11: ( assume_statement )?
            int alt6=2;
            try { dbg.enterSubRule(6);
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==32) ) {
                alt6=1;
            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:53:11: assume_statement
                    {
                    dbg.location(53,11);
                    pushFollow(FOLLOW_assume_statement_in_function_body310);
                    assume_statement();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(6);}

            dbg.location(54,11);
            match(input,43,FOLLOW_43_in_function_body324); 
            dbg.location(54,15);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:54:15: ( statement )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT||LA7_0==31||LA7_0==34||(LA7_0 >= 37 && LA7_0 <= 38)||(LA7_0 >= 41 && LA7_0 <= 42)) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:54:17: statement
            	    {
            	    dbg.location(54,17);
            	    pushFollow(FOLLOW_statement_in_function_body328);
            	    statement10=statement();

            	    state._fsp--;

            	    dbg.location(54,27);
            	    s.add(statement10);

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}

            dbg.location(54,55);
            match(input,45,FOLLOW_45_in_function_body335); 
            dbg.location(54,59);
            retval.ast = new StatementBlock(s.toArray(new Statement[s.size()]), new Position());
            dbg.location(55,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:55:11: ( ensure_statement )?
            int alt8=2;
            try { dbg.enterSubRule(8);
            try { dbg.enterDecision(8, decisionCanBacktrack[8]);

            int LA8_0 = input.LA(1);

            if ( (LA8_0==36) ) {
                alt8=1;
            }
            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:55:11: ensure_statement
                    {
                    dbg.location(55,11);
                    pushFollow(FOLLOW_ensure_statement_in_function_body349);
                    ensure_statement();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(8);}


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
        dbg.location(56, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "function_body"



    // $ANTLR start "if_body"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:58:1: if_body returns [ StatementBlock ast ] : ( '{' ( statement )* '}' ) ;
    public final StatementBlock if_body() throws RecognitionException {
        StatementBlock ast = null;


        Statement statement11 =null;


        LinkedList<Statement> s = new LinkedList<Statement>();
        try { dbg.enterRule(getGrammarFileName(), "if_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(58, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:60:9: ( ( '{' ( statement )* '}' ) )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:60:11: ( '{' ( statement )* '}' )
            {
            dbg.location(60,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:60:11: ( '{' ( statement )* '}' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:60:13: '{' ( statement )* '}'
            {
            dbg.location(60,13);
            match(input,43,FOLLOW_43_in_if_body387); 
            dbg.location(60,17);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:60:17: ( statement )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDENT||LA9_0==31||LA9_0==34||(LA9_0 >= 37 && LA9_0 <= 38)||(LA9_0 >= 41 && LA9_0 <= 42)) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:60:17: statement
            	    {
            	    dbg.location(60,17);
            	    pushFollow(FOLLOW_statement_in_if_body389);
            	    statement11=statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}

            dbg.location(60,28);
            match(input,45,FOLLOW_45_in_if_body392); 
            dbg.location(60,32);
            s.add(statement11);

            }

            dbg.location(60,59);
            ast = new StatementBlock(s.toArray(new Statement[s.size()]), new Position());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(61, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "if_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "if_body"


    public static class loop_body_return extends ParserRuleReturnScope {
        public StatementBlock ast;
        public LinkedList<Invariant> pre;
        public LinkedList<Ensure> post;
    };


    // $ANTLR start "loop_body"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:63:1: loop_body returns [ StatementBlock ast, LinkedList<Invariant> pre, LinkedList<Ensure> post ] : ( invariant_statement )? '{' ( statement )* '}' ( ensure_statement )? ;
    public final WhileLanguageParser.loop_body_return loop_body() throws RecognitionException {
        WhileLanguageParser.loop_body_return retval = new WhileLanguageParser.loop_body_return();
        retval.start = input.LT(1);


        LinkedList<Invariant> invariant_statement12 =null;

        Statement statement13 =null;

        LinkedList<Ensure> ensure_statement14 =null;


        LinkedList<Statement> s = new LinkedList<Statement>();
        try { dbg.enterRule(getGrammarFileName(), "loop_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(63, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:65:9: ( ( invariant_statement )? '{' ( statement )* '}' ( ensure_statement )? )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:65:11: ( invariant_statement )? '{' ( statement )* '}' ( ensure_statement )?
            {
            dbg.location(65,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:65:11: ( invariant_statement )?
            int alt10=2;
            try { dbg.enterSubRule(10);
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            int LA10_0 = input.LA(1);

            if ( (LA10_0==39) ) {
                alt10=1;
            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:65:11: invariant_statement
                    {
                    dbg.location(65,11);
                    pushFollow(FOLLOW_invariant_statement_in_loop_body433);
                    invariant_statement12=invariant_statement();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(10);}

            dbg.location(65,32);
            retval.pre = invariant_statement12;
            dbg.location(66,11);
            match(input,43,FOLLOW_43_in_loop_body449); 
            dbg.location(66,15);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:66:15: ( statement )*
            try { dbg.enterSubRule(11);

            loop11:
            do {
                int alt11=2;
                try { dbg.enterDecision(11, decisionCanBacktrack[11]);

                int LA11_0 = input.LA(1);

                if ( (LA11_0==IDENT||LA11_0==31||LA11_0==34||(LA11_0 >= 37 && LA11_0 <= 38)||(LA11_0 >= 41 && LA11_0 <= 42)) ) {
                    alt11=1;
                }


                } finally {dbg.exitDecision(11);}

                switch (alt11) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:66:17: statement
            	    {
            	    dbg.location(66,17);
            	    pushFollow(FOLLOW_statement_in_loop_body453);
            	    statement13=statement();

            	    state._fsp--;

            	    dbg.location(66,27);
            	    s.add(statement13);

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);
            } finally {dbg.exitSubRule(11);}

            dbg.location(66,55);
            match(input,45,FOLLOW_45_in_loop_body460); 
            dbg.location(66,59);
            retval.ast = new StatementBlock(s.toArray(new Statement[s.size()]), new Position());
            dbg.location(67,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:67:11: ( ensure_statement )?
            int alt12=2;
            try { dbg.enterSubRule(12);
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            int LA12_0 = input.LA(1);

            if ( (LA12_0==36) ) {
                alt12=1;
            }
            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:67:11: ensure_statement
                    {
                    dbg.location(67,11);
                    pushFollow(FOLLOW_ensure_statement_in_loop_body474);
                    ensure_statement14=ensure_statement();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(12);}

            dbg.location(67,29);
            retval.post = ensure_statement14;

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
        dbg.location(68, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "loop_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "loop_body"



    // $ANTLR start "statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:70:1: statement returns [ Statement ast ] : (e1= assert_statement |e2= variable_declaration |e3= array_declaration |e4= assignment |e5= if_statement |e6= while_statement |e7= return_statement );
    public final Statement statement() throws RecognitionException {
        Statement ast = null;


        Assertion e1 =null;

        VariableDeclaration e2 =null;

        ArrayDeclaration e3 =null;

        Assignment e4 =null;

        Conditional e5 =null;

        Loop e6 =null;

        ReturnStatement e7 =null;


        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(70, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:71:9: (e1= assert_statement |e2= variable_declaration |e3= array_declaration |e4= assignment |e5= if_statement |e6= while_statement |e7= return_statement )
            int alt13=7;
            try { dbg.enterDecision(13, decisionCanBacktrack[13]);

            try {
                isCyclicDecision = true;
                alt13 = dfa13.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(13);}

            switch (alt13) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:71:11: e1= assert_statement
                    {
                    dbg.location(71,13);
                    pushFollow(FOLLOW_assert_statement_in_statement508);
                    e1=assert_statement();

                    state._fsp--;

                    dbg.location(71,31);
                    ast = e1;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:72:11: e2= variable_declaration
                    {
                    dbg.location(72,13);
                    pushFollow(FOLLOW_variable_declaration_in_statement524);
                    e2=variable_declaration();

                    state._fsp--;

                    dbg.location(72,35);
                    ast = e2;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:73:11: e3= array_declaration
                    {
                    dbg.location(73,13);
                    pushFollow(FOLLOW_array_declaration_in_statement540);
                    e3=array_declaration();

                    state._fsp--;

                    dbg.location(73,32);
                    ast = e3;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:74:11: e4= assignment
                    {
                    dbg.location(74,13);
                    pushFollow(FOLLOW_assignment_in_statement556);
                    e4=assignment();

                    state._fsp--;

                    dbg.location(74,25);
                    ast = e4;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:75:11: e5= if_statement
                    {
                    dbg.location(75,13);
                    pushFollow(FOLLOW_if_statement_in_statement572);
                    e5=if_statement();

                    state._fsp--;

                    dbg.location(75,27);
                    ast = e5;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:76:11: e6= while_statement
                    {
                    dbg.location(76,13);
                    pushFollow(FOLLOW_while_statement_in_statement588);
                    e6=while_statement();

                    state._fsp--;

                    dbg.location(76,30);
                    ast = e6;

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:77:11: e7= return_statement
                    {
                    dbg.location(77,13);
                    pushFollow(FOLLOW_return_statement_in_statement604);
                    e7=return_statement();

                    state._fsp--;

                    dbg.location(77,31);
                    ast = e7;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(78, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "statement"



    // $ANTLR start "invariant_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:80:1: invariant_statement returns [ LinkedList<Invariant> result ] : ( 'invariant' e1= quantified_expression ';' | 'invariant' '{' (e2= quantified_expression ';' )+ '}' );
    public final LinkedList<Invariant> invariant_statement() throws RecognitionException {
        LinkedList<Invariant> result = null;


        WhileLanguageParser.quantified_expression_return e1 =null;

        WhileLanguageParser.quantified_expression_return e2 =null;


        result = new LinkedList<Invariant>();
        try { dbg.enterRule(getGrammarFileName(), "invariant_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(80, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:82:9: ( 'invariant' e1= quantified_expression ';' | 'invariant' '{' (e2= quantified_expression ';' )+ '}' )
            int alt15=2;
            try { dbg.enterDecision(15, decisionCanBacktrack[15]);

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

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(15);}

            switch (alt15) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:82:11: 'invariant' e1= quantified_expression ';'
                    {
                    dbg.location(82,11);
                    match(input,39,FOLLOW_39_in_invariant_statement641); 
                    dbg.location(82,25);
                    pushFollow(FOLLOW_quantified_expression_in_invariant_statement645);
                    e1=quantified_expression();

                    state._fsp--;

                    dbg.location(82,48);
                    match(input,21,FOLLOW_21_in_invariant_statement647); 
                    dbg.location(82,52);
                    result.add(new Invariant(new Position(), (e1!=null?e1.ast:null)));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:83:11: 'invariant' '{' (e2= quantified_expression ';' )+ '}'
                    {
                    dbg.location(83,11);
                    match(input,39,FOLLOW_39_in_invariant_statement661); 
                    dbg.location(83,23);
                    match(input,43,FOLLOW_43_in_invariant_statement663); 
                    dbg.location(83,27);
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:83:27: (e2= quantified_expression ';' )+
                    int cnt14=0;
                    try { dbg.enterSubRule(14);

                    loop14:
                    do {
                        int alt14=2;
                        try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==BOOL_LITERAL||(LA14_0 >= IDENT && LA14_0 <= QUANTIFIER)||LA14_0==10||LA14_0==14||LA14_0==17||LA14_0==19) ) {
                            alt14=1;
                        }


                        } finally {dbg.exitDecision(14);}

                        switch (alt14) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:83:28: e2= quantified_expression ';'
                    	    {
                    	    dbg.location(83,30);
                    	    pushFollow(FOLLOW_quantified_expression_in_invariant_statement668);
                    	    e2=quantified_expression();

                    	    state._fsp--;

                    	    dbg.location(83,53);
                    	    match(input,21,FOLLOW_21_in_invariant_statement670); 
                    	    dbg.location(83,57);
                    	    result.add(new Invariant(new Position(), (e2!=null?e2.ast:null)));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt14++;
                    } while (true);
                    } finally {dbg.exitSubRule(14);}

                    dbg.location(83,115);
                    match(input,45,FOLLOW_45_in_invariant_statement677); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(84, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "invariant_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return result;
    }
    // $ANTLR end "invariant_statement"



    // $ANTLR start "axiom_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:86:1: axiom_statement returns [ Axiom ast ] : 'axiom' e1= quantified_expression ';' ;
    public final Axiom axiom_statement() throws RecognitionException {
        Axiom ast = null;


        WhileLanguageParser.quantified_expression_return e1 =null;


        try { dbg.enterRule(getGrammarFileName(), "axiom_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(86, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:87:9: ( 'axiom' e1= quantified_expression ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:87:11: 'axiom' e1= quantified_expression ';'
            {
            dbg.location(87,11);
            match(input,33,FOLLOW_33_in_axiom_statement706); 
            dbg.location(87,21);
            pushFollow(FOLLOW_quantified_expression_in_axiom_statement710);
            e1=quantified_expression();

            state._fsp--;

            dbg.location(87,44);
            match(input,21,FOLLOW_21_in_axiom_statement712); 
            dbg.location(87,48);
            ast = new Axiom(new Position(), (e1!=null?e1.ast:null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(88, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "axiom_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "axiom_statement"



    // $ANTLR start "assert_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:90:1: assert_statement returns [ Assertion ast ] : 'assert' e1= quantified_expression ';' ;
    public final Assertion assert_statement() throws RecognitionException {
        Assertion ast = null;


        WhileLanguageParser.quantified_expression_return e1 =null;


        try { dbg.enterRule(getGrammarFileName(), "assert_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(90, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:91:9: ( 'assert' e1= quantified_expression ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:91:11: 'assert' e1= quantified_expression ';'
            {
            dbg.location(91,11);
            match(input,31,FOLLOW_31_in_assert_statement743); 
            dbg.location(91,22);
            pushFollow(FOLLOW_quantified_expression_in_assert_statement747);
            e1=quantified_expression();

            state._fsp--;

            dbg.location(91,45);
            match(input,21,FOLLOW_21_in_assert_statement749); 
            dbg.location(91,49);
            ast = new Assertion(new Position(), (e1!=null?e1.ast:null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(92, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assert_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "assert_statement"



    // $ANTLR start "assume_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:94:1: assume_statement returns [ LinkedList<Assumption> result ] : ( 'assume' e1= quantified_expression ';' | 'assume' '{' (e2= quantified_expression ';' )+ '}' );
    public final LinkedList<Assumption> assume_statement() throws RecognitionException {
        LinkedList<Assumption> result = null;


        WhileLanguageParser.quantified_expression_return e1 =null;

        WhileLanguageParser.quantified_expression_return e2 =null;


        result = new LinkedList<Assumption>();
        try { dbg.enterRule(getGrammarFileName(), "assume_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(94, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:96:9: ( 'assume' e1= quantified_expression ';' | 'assume' '{' (e2= quantified_expression ';' )+ '}' )
            int alt17=2;
            try { dbg.enterDecision(17, decisionCanBacktrack[17]);

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

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(17);}

            switch (alt17) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:96:11: 'assume' e1= quantified_expression ';'
                    {
                    dbg.location(96,11);
                    match(input,32,FOLLOW_32_in_assume_statement786); 
                    dbg.location(96,22);
                    pushFollow(FOLLOW_quantified_expression_in_assume_statement790);
                    e1=quantified_expression();

                    state._fsp--;

                    dbg.location(96,45);
                    match(input,21,FOLLOW_21_in_assume_statement792); 
                    dbg.location(96,49);
                    result.add(new Assumption(new Position(), (e1!=null?e1.ast:null)));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:97:11: 'assume' '{' (e2= quantified_expression ';' )+ '}'
                    {
                    dbg.location(97,11);
                    match(input,32,FOLLOW_32_in_assume_statement806); 
                    dbg.location(97,20);
                    match(input,43,FOLLOW_43_in_assume_statement808); 
                    dbg.location(97,24);
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:97:24: (e2= quantified_expression ';' )+
                    int cnt16=0;
                    try { dbg.enterSubRule(16);

                    loop16:
                    do {
                        int alt16=2;
                        try { dbg.enterDecision(16, decisionCanBacktrack[16]);

                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==BOOL_LITERAL||(LA16_0 >= IDENT && LA16_0 <= QUANTIFIER)||LA16_0==10||LA16_0==14||LA16_0==17||LA16_0==19) ) {
                            alt16=1;
                        }


                        } finally {dbg.exitDecision(16);}

                        switch (alt16) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:97:25: e2= quantified_expression ';'
                    	    {
                    	    dbg.location(97,27);
                    	    pushFollow(FOLLOW_quantified_expression_in_assume_statement813);
                    	    e2=quantified_expression();

                    	    state._fsp--;

                    	    dbg.location(97,50);
                    	    match(input,21,FOLLOW_21_in_assume_statement815); 
                    	    dbg.location(97,54);
                    	    result.add(new Assumption(new Position(), (e2!=null?e2.ast:null)));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt16++;
                    } while (true);
                    } finally {dbg.exitSubRule(16);}

                    dbg.location(97,113);
                    match(input,45,FOLLOW_45_in_assume_statement822); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(98, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assume_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return result;
    }
    // $ANTLR end "assume_statement"



    // $ANTLR start "ensure_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:100:1: ensure_statement returns [ LinkedList<Ensure> result ] : ( 'ensure' e1= quantified_expression ';' | 'ensure' '{' (e2= quantified_expression ';' )+ '}' );
    public final LinkedList<Ensure> ensure_statement() throws RecognitionException {
        LinkedList<Ensure> result = null;


        WhileLanguageParser.quantified_expression_return e1 =null;

        WhileLanguageParser.quantified_expression_return e2 =null;


        result = new LinkedList<Ensure>();
        try { dbg.enterRule(getGrammarFileName(), "ensure_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(100, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:102:2: ( 'ensure' e1= quantified_expression ';' | 'ensure' '{' (e2= quantified_expression ';' )+ '}' )
            int alt19=2;
            try { dbg.enterDecision(19, decisionCanBacktrack[19]);

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

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(19);}

            switch (alt19) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:102:4: 'ensure' e1= quantified_expression ';'
                    {
                    dbg.location(102,4);
                    match(input,36,FOLLOW_36_in_ensure_statement858); 
                    dbg.location(102,15);
                    pushFollow(FOLLOW_quantified_expression_in_ensure_statement862);
                    e1=quantified_expression();

                    state._fsp--;

                    dbg.location(102,38);
                    match(input,21,FOLLOW_21_in_ensure_statement864); 
                    dbg.location(102,42);
                    result.add(new Ensure(new Position(), (e1!=null?e1.ast:null)));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:103:11: 'ensure' '{' (e2= quantified_expression ';' )+ '}'
                    {
                    dbg.location(103,11);
                    match(input,36,FOLLOW_36_in_ensure_statement878); 
                    dbg.location(103,20);
                    match(input,43,FOLLOW_43_in_ensure_statement880); 
                    dbg.location(103,24);
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:103:24: (e2= quantified_expression ';' )+
                    int cnt18=0;
                    try { dbg.enterSubRule(18);

                    loop18:
                    do {
                        int alt18=2;
                        try { dbg.enterDecision(18, decisionCanBacktrack[18]);

                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==BOOL_LITERAL||(LA18_0 >= IDENT && LA18_0 <= QUANTIFIER)||LA18_0==10||LA18_0==14||LA18_0==17||LA18_0==19) ) {
                            alt18=1;
                        }


                        } finally {dbg.exitDecision(18);}

                        switch (alt18) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:103:25: e2= quantified_expression ';'
                    	    {
                    	    dbg.location(103,27);
                    	    pushFollow(FOLLOW_quantified_expression_in_ensure_statement885);
                    	    e2=quantified_expression();

                    	    state._fsp--;

                    	    dbg.location(103,50);
                    	    match(input,21,FOLLOW_21_in_ensure_statement887); 
                    	    dbg.location(103,54);
                    	    result.add(new Ensure(new Position(), (e2!=null?e2.ast:null)));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt18++;
                    } while (true);
                    } finally {dbg.exitSubRule(18);}

                    dbg.location(103,109);
                    match(input,45,FOLLOW_45_in_ensure_statement894); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(104, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ensure_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return result;
    }
    // $ANTLR end "ensure_statement"



    // $ANTLR start "assignment"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:106:1: assignment returns [ Assignment ast ] : ( IDENT '=' expression ';' | IDENT ( '[' e1= expression ']' )+ '=' e2= expression ';' );
    public final Assignment assignment() throws RecognitionException {
        Assignment ast = null;


        Token IDENT16=null;
        Token IDENT17=null;
        WhileLanguageParser.expression_return e1 =null;

        WhileLanguageParser.expression_return e2 =null;

        WhileLanguageParser.expression_return expression15 =null;


        try { dbg.enterRule(getGrammarFileName(), "assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(106, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:107:9: ( IDENT '=' expression ';' | IDENT ( '[' e1= expression ']' )+ '=' e2= expression ';' )
            int alt21=2;
            try { dbg.enterDecision(21, decisionCanBacktrack[21]);

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

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(21);}

            switch (alt21) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:107:11: IDENT '=' expression ';'
                    {
                    dbg.location(107,11);
                    IDENT16=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment923); 
                    dbg.location(107,17);
                    match(input,24,FOLLOW_24_in_assignment925); 
                    dbg.location(107,21);
                    pushFollow(FOLLOW_expression_in_assignment927);
                    expression15=expression();

                    state._fsp--;

                    dbg.location(107,32);
                    match(input,21,FOLLOW_21_in_assignment929); 
                    dbg.location(107,36);
                    ast = new Assignment(new Position(), (expression15!=null?expression15.ast:null), new Identifier((IDENT16!=null?IDENT16.getText():null)));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:108:11: IDENT ( '[' e1= expression ']' )+ '=' e2= expression ';'
                    {
                    dbg.location(108,11);
                    IDENT17=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment943); 
                    dbg.location(108,17);
                    LinkedList<Expression> idx = new LinkedList<Expression>();
                    dbg.location(109,10);
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:109:10: ( '[' e1= expression ']' )+
                    int cnt20=0;
                    try { dbg.enterSubRule(20);

                    loop20:
                    do {
                        int alt20=2;
                        try { dbg.enterDecision(20, decisionCanBacktrack[20]);

                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==28) ) {
                            alt20=1;
                        }


                        } finally {dbg.exitDecision(20);}

                        switch (alt20) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:109:12: '[' e1= expression ']'
                    	    {
                    	    dbg.location(109,12);
                    	    match(input,28,FOLLOW_28_in_assignment959); 
                    	    dbg.location(109,18);
                    	    pushFollow(FOLLOW_expression_in_assignment963);
                    	    e1=expression();

                    	    state._fsp--;

                    	    dbg.location(109,30);
                    	    idx.add((e1!=null?e1.ast:null));
                    	    dbg.location(109,50);
                    	    match(input,29,FOLLOW_29_in_assignment967); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt20++;
                    } while (true);
                    } finally {dbg.exitSubRule(20);}

                    dbg.location(109,57);
                    match(input,24,FOLLOW_24_in_assignment972); 
                    dbg.location(109,63);
                    pushFollow(FOLLOW_expression_in_assignment976);
                    e2=expression();

                    state._fsp--;

                    dbg.location(109,75);
                    match(input,21,FOLLOW_21_in_assignment978); 
                    dbg.location(109,79);

                            	ast = new ArrayAssignment(new Position(), (e2!=null?e2.ast:null), new Identifier((IDENT17!=null?IDENT17.getText():null)),
                            				   idx.toArray(new Expression[idx.size()]));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(112, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "assignment"



    // $ANTLR start "variable_declaration"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:114:1: variable_declaration returns [ VariableDeclaration ast ] : type IDENT ( '=' expression )? ';' ;
    public final VariableDeclaration variable_declaration() throws RecognitionException {
        VariableDeclaration ast = null;


        Token IDENT18=null;
        WhileLanguageParser.expression_return expression19 =null;

        Type type20 =null;


        try { dbg.enterRule(getGrammarFileName(), "variable_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(114, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:115:9: ( type IDENT ( '=' expression )? ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:115:11: type IDENT ( '=' expression )? ';'
            {
            dbg.location(115,11);
            pushFollow(FOLLOW_type_in_variable_declaration1009);
            type20=type();

            state._fsp--;

            dbg.location(115,16);
            IDENT18=(Token)match(input,IDENT,FOLLOW_IDENT_in_variable_declaration1011); 
            dbg.location(115,22);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:115:22: ( '=' expression )?
            int alt22=2;
            try { dbg.enterSubRule(22);
            try { dbg.enterDecision(22, decisionCanBacktrack[22]);

            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            } finally {dbg.exitDecision(22);}

            switch (alt22) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:115:24: '=' expression
                    {
                    dbg.location(115,24);
                    match(input,24,FOLLOW_24_in_variable_declaration1015); 
                    dbg.location(115,28);
                    pushFollow(FOLLOW_expression_in_variable_declaration1017);
                    expression19=expression();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(22);}

            dbg.location(115,42);
            match(input,21,FOLLOW_21_in_variable_declaration1022); 
            dbg.location(115,46);

                    	ast = new VariableDeclaration(new Position(), (IDENT18!=null?IDENT18.getText():null), (expression19!=null?expression19.ast:null), type20);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(117, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "variable_declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "variable_declaration"



    // $ANTLR start "array_declaration"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:119:1: array_declaration returns [ ArrayDeclaration ast ] : type IDENT '=' array_init ';' ;
    public final ArrayDeclaration array_declaration() throws RecognitionException {
        ArrayDeclaration ast = null;


        Token IDENT22=null;
        LinkedList<Expression> array_init21 =null;

        Type type23 =null;


        try { dbg.enterRule(getGrammarFileName(), "array_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(119, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:120:9: ( type IDENT '=' array_init ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:120:11: type IDENT '=' array_init ';'
            {
            dbg.location(120,11);
            pushFollow(FOLLOW_type_in_array_declaration1053);
            type23=type();

            state._fsp--;

            dbg.location(120,16);
            IDENT22=(Token)match(input,IDENT,FOLLOW_IDENT_in_array_declaration1055); 
            dbg.location(120,22);
            match(input,24,FOLLOW_24_in_array_declaration1057); 
            dbg.location(120,26);
            pushFollow(FOLLOW_array_init_in_array_declaration1059);
            array_init21=array_init();

            state._fsp--;

            dbg.location(120,37);
            match(input,21,FOLLOW_21_in_array_declaration1061); 
            dbg.location(120,41);

                    	Expression[] dim = array_init21.toArray(new Expression[array_init21.size()]);
                    	ast = new ArrayDeclaration(new Position(), (IDENT22!=null?IDENT22.getText():null), type23, dim);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(123, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "array_declaration"



    // $ANTLR start "array_init"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:125:1: array_init returns [ LinkedList<Expression> dim] : 'array' ( '[' expression ']' )+ ;
    public final LinkedList<Expression> array_init() throws RecognitionException {
        LinkedList<Expression> dim = null;


        WhileLanguageParser.expression_return expression24 =null;


        try { dbg.enterRule(getGrammarFileName(), "array_init");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(125, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:126:2: ( 'array' ( '[' expression ']' )+ )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:126:4: 'array' ( '[' expression ']' )+
            {
            dbg.location(126,4);
            dim = new LinkedList<Expression>();
            dbg.location(127,2);
            match(input,30,FOLLOW_30_in_array_init1096); 
            dbg.location(127,10);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:127:10: ( '[' expression ']' )+
            int cnt23=0;
            try { dbg.enterSubRule(23);

            loop23:
            do {
                int alt23=2;
                try { dbg.enterDecision(23, decisionCanBacktrack[23]);

                int LA23_0 = input.LA(1);

                if ( (LA23_0==28) ) {
                    alt23=1;
                }


                } finally {dbg.exitDecision(23);}

                switch (alt23) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:127:12: '[' expression ']'
            	    {
            	    dbg.location(127,12);
            	    match(input,28,FOLLOW_28_in_array_init1100); 
            	    dbg.location(127,16);
            	    pushFollow(FOLLOW_expression_in_array_init1102);
            	    expression24=expression();

            	    state._fsp--;

            	    dbg.location(127,27);
            	    dim.add((expression24!=null?expression24.ast:null));
            	    dbg.location(127,55);
            	    match(input,29,FOLLOW_29_in_array_init1106); 

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt23++;
            } while (true);
            } finally {dbg.exitSubRule(23);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(128, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_init");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return dim;
    }
    // $ANTLR end "array_init"



    // $ANTLR start "if_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:130:1: if_statement returns [ Conditional ast ] : 'if' '(' expression ')' b1= if_body ( 'else' b2= if_body )? ;
    public final Conditional if_statement() throws RecognitionException {
        Conditional ast = null;


        StatementBlock b1 =null;

        StatementBlock b2 =null;

        WhileLanguageParser.expression_return expression25 =null;


        try { dbg.enterRule(getGrammarFileName(), "if_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(130, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:131:9: ( 'if' '(' expression ')' b1= if_body ( 'else' b2= if_body )? )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:131:11: 'if' '(' expression ')' b1= if_body ( 'else' b2= if_body )?
            {
            dbg.location(131,11);
            match(input,37,FOLLOW_37_in_if_statement1131); 
            dbg.location(131,16);
            match(input,14,FOLLOW_14_in_if_statement1133); 
            dbg.location(131,20);
            pushFollow(FOLLOW_expression_in_if_statement1135);
            expression25=expression();

            state._fsp--;

            dbg.location(131,31);
            match(input,15,FOLLOW_15_in_if_statement1137); 
            dbg.location(131,37);
            pushFollow(FOLLOW_if_body_in_if_statement1141);
            b1=if_body();

            state._fsp--;

            dbg.location(131,46);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:131:46: ( 'else' b2= if_body )?
            int alt24=2;
            try { dbg.enterSubRule(24);
            try { dbg.enterDecision(24, decisionCanBacktrack[24]);

            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            } finally {dbg.exitDecision(24);}

            switch (alt24) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:131:48: 'else' b2= if_body
                    {
                    dbg.location(131,48);
                    match(input,35,FOLLOW_35_in_if_statement1145); 
                    dbg.location(131,57);
                    pushFollow(FOLLOW_if_body_in_if_statement1149);
                    b2=if_body();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(24);}

            dbg.location(131,69);

                    	ast = new Conditional(new Position(), (expression25!=null?expression25.ast:null), b1, b2);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(133, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "if_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "if_statement"



    // $ANTLR start "while_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:135:1: while_statement returns [ Loop ast ] : 'while' '(' expression ')' loop_body ;
    public final Loop while_statement() throws RecognitionException {
        Loop ast = null;


        WhileLanguageParser.loop_body_return loop_body26 =null;

        WhileLanguageParser.expression_return expression27 =null;


        try { dbg.enterRule(getGrammarFileName(), "while_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(135, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:136:9: ( 'while' '(' expression ')' loop_body )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:136:11: 'while' '(' expression ')' loop_body
            {
            dbg.location(136,11);
            match(input,42,FOLLOW_42_in_while_statement1183); 
            dbg.location(136,19);
            match(input,14,FOLLOW_14_in_while_statement1185); 
            dbg.location(136,23);
            pushFollow(FOLLOW_expression_in_while_statement1187);
            expression27=expression();

            state._fsp--;

            dbg.location(136,34);
            match(input,15,FOLLOW_15_in_while_statement1189); 
            dbg.location(136,38);
            pushFollow(FOLLOW_loop_body_in_while_statement1191);
            loop_body26=loop_body();

            state._fsp--;

            dbg.location(136,48);

            		Invariant[] i = new Invariant[0];
            		i = (loop_body26!=null?loop_body26.pre:null) != null ? (loop_body26!=null?loop_body26.pre:null).toArray(new Invariant[(loop_body26!=null?loop_body26.pre:null).size()]) : null; 
            		Ensure[] e = new Ensure[0];
            		e = (loop_body26!=null?loop_body26.post:null) != null ? (loop_body26!=null?loop_body26.post:null).toArray(new Ensure[(loop_body26!=null?loop_body26.post:null).size()]) : null;       
                    	ast = new Loop(new Position(), (expression27!=null?expression27.ast:null), (loop_body26!=null?loop_body26.ast:null), i, e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(142, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "while_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "while_statement"



    // $ANTLR start "return_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:144:1: return_statement returns [ ReturnStatement ast ] : 'return' expression ';' ;
    public final ReturnStatement return_statement() throws RecognitionException {
        ReturnStatement ast = null;


        WhileLanguageParser.expression_return expression28 =null;


        try { dbg.enterRule(getGrammarFileName(), "return_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(144, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:145:2: ( 'return' expression ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:145:4: 'return' expression ';'
            {
            dbg.location(145,4);
            match(input,41,FOLLOW_41_in_return_statement1223); 
            dbg.location(145,13);
            pushFollow(FOLLOW_expression_in_return_statement1225);
            expression28=expression();

            state._fsp--;

            dbg.location(145,24);
            match(input,21,FOLLOW_21_in_return_statement1227); 
            dbg.location(145,28);
            ast = new ReturnStatement(new Position(), (expression28!=null?expression28.ast:null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(146, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "return_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "return_statement"


    public static class quantified_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "quantified_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:148:1: quantified_expression returns [ Expression ast, LinkedList<Expression> divisors ] : ( QUANTIFIER IDENT '(' ( range )? ')' e= quantified_expression | expression );
    public final WhileLanguageParser.quantified_expression_return quantified_expression() throws RecognitionException {
        WhileLanguageParser.quantified_expression_return retval = new WhileLanguageParser.quantified_expression_return();
        retval.start = input.LT(1);


        Token QUANTIFIER30=null;
        Token IDENT31=null;
        WhileLanguageParser.quantified_expression_return e =null;

        WhileLanguageParser.range_return range29 =null;

        WhileLanguageParser.expression_return expression32 =null;


        try { dbg.enterRule(getGrammarFileName(), "quantified_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(148, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:149:9: ( QUANTIFIER IDENT '(' ( range )? ')' e= quantified_expression | expression )
            int alt26=2;
            try { dbg.enterDecision(26, decisionCanBacktrack[26]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(26);}

            switch (alt26) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:149:11: QUANTIFIER IDENT '(' ( range )? ')' e= quantified_expression
                    {
                    dbg.location(149,11);
                    QUANTIFIER30=(Token)match(input,QUANTIFIER,FOLLOW_QUANTIFIER_in_quantified_expression1251); 
                    dbg.location(149,22);
                    IDENT31=(Token)match(input,IDENT,FOLLOW_IDENT_in_quantified_expression1253); 
                    dbg.location(149,28);
                    match(input,14,FOLLOW_14_in_quantified_expression1255); 
                    dbg.location(149,32);
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:149:32: ( range )?
                    int alt25=2;
                    try { dbg.enterSubRule(25);
                    try { dbg.enterDecision(25, decisionCanBacktrack[25]);

                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==BOOL_LITERAL||(LA25_0 >= IDENT && LA25_0 <= INT_LITERAL)||LA25_0==10||LA25_0==14||LA25_0==17||LA25_0==19) ) {
                        alt25=1;
                    }
                    } finally {dbg.exitDecision(25);}

                    switch (alt25) {
                        case 1 :
                            dbg.enterAlt(1);

                            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:149:32: range
                            {
                            dbg.location(149,32);
                            pushFollow(FOLLOW_range_in_quantified_expression1257);
                            range29=range();

                            state._fsp--;


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(25);}

                    dbg.location(149,39);
                    match(input,15,FOLLOW_15_in_quantified_expression1260); 
                    dbg.location(149,44);
                    pushFollow(FOLLOW_quantified_expression_in_quantified_expression1264);
                    e=quantified_expression();

                    state._fsp--;

                    dbg.location(149,67);

                            	Range r = null;
                            	retval.divisors = (e!=null?e.divisors:null);
                            	if ((range29!=null?range29.e1:null) != null) {
                            		r = new Range((range29!=null?range29.e1:null), (range29!=null?range29.e2:null));
                            		retval.divisors.addAll((range29!=null?range29.divisors:null));
                            	}
                            	/*switch ((QUANTIFIER30!=null?QUANTIFIER30.getText():null)) {
                            		case "forall":
                            			retval.ast = new ForAllQuantifier(new Position(), r, new Identifier((IDENT31!=null?IDENT31.getText():null)), 
                            				(e!=null?e.ast:null));
                            		case "exists":
                            			retval.ast = new ExistsQuantifier(new Position(), r, new Identifier((IDENT31!=null?IDENT31.getText():null)), 
                            				(e!=null?e.ast:null));
                            	}*/
                            

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:165:11: expression
                    {
                    dbg.location(165,11);
                    pushFollow(FOLLOW_expression_in_quantified_expression1278);
                    expression32=expression();

                    state._fsp--;

                    dbg.location(165,22);
                    if (!((expression32!=null?expression32.ast:null) instanceof LogicalExpression)) 
                            		throw new TreeGeneratorException("Expected a logical expression.");
                            	LogicalExpression conj = (LogicalExpression) (expression32!=null?expression32.ast:null);
                            	for (Expression exp : (expression32!=null?expression32.divisors:null)) {
                            		LogicalExpression x = new LogicalExpression(new Position(), exp, 
                            			new NumericLiteral(new Position(), "0"), new NotEqual());
                            		conj = new LogicalExpression(new Position(), x, conj, new Conjunction());
                            	}
                            	retval.ast = conj;
                            	retval.divisors = new LinkedList<Expression>();
                            	

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
        dbg.location(176, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "quantified_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "quantified_expression"


    public static class range_return extends ParserRuleReturnScope {
        public ArithmeticExpression e1;
        public ArithmeticExpression e2;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "range"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:177:1: range returns [ ArithmeticExpression e1, ArithmeticExpression e2, LinkedList<Expression> divisors ] : e11= expression ',' e22= expression ;
    public final WhileLanguageParser.range_return range() throws RecognitionException {
        WhileLanguageParser.range_return retval = new WhileLanguageParser.range_return();
        retval.start = input.LT(1);


        WhileLanguageParser.expression_return e11 =null;

        WhileLanguageParser.expression_return e22 =null;


        try { dbg.enterRule(getGrammarFileName(), "range");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(177, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:178:9: (e11= expression ',' e22= expression )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:178:11: e11= expression ',' e22= expression
            {
            dbg.location(178,14);
            pushFollow(FOLLOW_expression_in_range1310);
            e11=expression();

            state._fsp--;

            dbg.location(178,26);
            match(input,18,FOLLOW_18_in_range1312); 
            dbg.location(178,33);
            pushFollow(FOLLOW_expression_in_range1316);
            e22=expression();

            state._fsp--;

            dbg.location(178,45);

                    	if (!((e11!=null?e11.ast:null) instanceof ArithmeticExpression || (e22!=null?e22.ast:null) instanceof ArithmeticExpression))
                    		throw new TreeGeneratorException("Expected an arithmetic expression.");
                    	retval.e1 = (ArithmeticExpression)(e11!=null?e11.ast:null); 
                    	retval.e2 = (ArithmeticExpression)(e22!=null?e22.ast:null); 
                    	retval.divisors = (e11!=null?e11.divisors:null);
                    	retval.divisors.addAll(e22.divisors);

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
        dbg.location(185, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "range");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "range"


    public static class expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:187:1: expression returns [ Expression ast, LinkedList<Expression> divisors ] : e1= rel_expression ( '==' e2= rel_expression | '!=' e2= rel_expression )* ;
    public final WhileLanguageParser.expression_return expression() throws RecognitionException {
        WhileLanguageParser.expression_return retval = new WhileLanguageParser.expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.rel_expression_return e1 =null;

        WhileLanguageParser.rel_expression_return e2 =null;


        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(187, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:188:9: (e1= rel_expression ( '==' e2= rel_expression | '!=' e2= rel_expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:188:11: e1= rel_expression ( '==' e2= rel_expression | '!=' e2= rel_expression )*
            {
            dbg.location(188,13);
            pushFollow(FOLLOW_rel_expression_in_expression1349);
            e1=rel_expression();

            state._fsp--;

            dbg.location(188,29);
            retval.ast = e1.ast; retval.divisors = (e1!=null?e1.divisors:null);
            dbg.location(188,72);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:188:72: ( '==' e2= rel_expression | '!=' e2= rel_expression )*
            try { dbg.enterSubRule(27);

            loop27:
            do {
                int alt27=3;
                try { dbg.enterDecision(27, decisionCanBacktrack[27]);

                int LA27_0 = input.LA(1);

                if ( (LA27_0==25) ) {
                    alt27=1;
                }
                else if ( (LA27_0==11) ) {
                    alt27=2;
                }


                } finally {dbg.exitDecision(27);}

                switch (alt27) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:189:12: '==' e2= rel_expression
            	    {
            	    dbg.location(189,12);
            	    match(input,25,FOLLOW_25_in_expression1367); 
            	    dbg.location(189,19);
            	    pushFollow(FOLLOW_rel_expression_in_expression1371);
            	    e2=rel_expression();

            	    state._fsp--;

            	    dbg.location(189,35);
            	    retval.ast = new LogicalExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Equal());
            	            	  	retval.divisors.addAll(e2.divisors);

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:191:12: '!=' e2= rel_expression
            	    {
            	    dbg.location(191,12);
            	    match(input,11,FOLLOW_11_in_expression1386); 
            	    dbg.location(191,19);
            	    pushFollow(FOLLOW_rel_expression_in_expression1390);
            	    e2=rel_expression();

            	    state._fsp--;

            	    dbg.location(191,35);
            	    retval.ast = new LogicalExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new NotEqual());
            	            		retval.divisors.addAll(e2.divisors);

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);
            } finally {dbg.exitSubRule(27);}


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
        dbg.location(194, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expression"


    public static class rel_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "rel_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:197:1: rel_expression returns [ Expression ast, LinkedList<Expression> divisors ] : e1= add_expression ( '<' e2= add_expression | '<=' e2= add_expression | '>' e2= add_expression | '>=' e2= add_expression )* ;
    public final WhileLanguageParser.rel_expression_return rel_expression() throws RecognitionException {
        WhileLanguageParser.rel_expression_return retval = new WhileLanguageParser.rel_expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.add_expression_return e1 =null;

        WhileLanguageParser.add_expression_return e2 =null;


        try { dbg.enterRule(getGrammarFileName(), "rel_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(197, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:198:9: (e1= add_expression ( '<' e2= add_expression | '<=' e2= add_expression | '>' e2= add_expression | '>=' e2= add_expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:198:11: e1= add_expression ( '<' e2= add_expression | '<=' e2= add_expression | '>' e2= add_expression | '>=' e2= add_expression )*
            {
            dbg.location(198,13);
            pushFollow(FOLLOW_add_expression_in_rel_expression1435);
            e1=add_expression();

            state._fsp--;

            dbg.location(198,29);
            retval.ast = e1.ast; retval.divisors = (e1!=null?e1.divisors:null);
            dbg.location(198,72);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:198:72: ( '<' e2= add_expression | '<=' e2= add_expression | '>' e2= add_expression | '>=' e2= add_expression )*
            try { dbg.enterSubRule(28);

            loop28:
            do {
                int alt28=5;
                try { dbg.enterDecision(28, decisionCanBacktrack[28]);

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

                } finally {dbg.exitDecision(28);}

                switch (alt28) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:199:12: '<' e2= add_expression
            	    {
            	    dbg.location(199,12);
            	    match(input,22,FOLLOW_22_in_rel_expression1453); 
            	    dbg.location(199,19);
            	    pushFollow(FOLLOW_add_expression_in_rel_expression1458);
            	    e2=add_expression();

            	    state._fsp--;

            	    dbg.location(199,35);
            	    retval.ast = new LogicalExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Less());
            	            	  	retval.divisors.addAll(e2.divisors);

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:201:12: '<=' e2= add_expression
            	    {
            	    dbg.location(201,12);
            	    match(input,23,FOLLOW_23_in_rel_expression1473); 
            	    dbg.location(201,19);
            	    pushFollow(FOLLOW_add_expression_in_rel_expression1477);
            	    e2=add_expression();

            	    state._fsp--;

            	    dbg.location(201,35);
            	    retval.ast = new LogicalExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new LessEqual());
            	            		retval.divisors.addAll(e2.divisors);

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:203:12: '>' e2= add_expression
            	    {
            	    dbg.location(203,12);
            	    match(input,26,FOLLOW_26_in_rel_expression1492); 
            	    dbg.location(203,19);
            	    pushFollow(FOLLOW_add_expression_in_rel_expression1497);
            	    e2=add_expression();

            	    state._fsp--;

            	    dbg.location(203,35);
            	    retval.ast = new LogicalExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Greater());
            	            		retval.divisors.addAll(e2.divisors);

            	    }
            	    break;
            	case 4 :
            	    dbg.enterAlt(4);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:205:12: '>=' e2= add_expression
            	    {
            	    dbg.location(205,12);
            	    match(input,27,FOLLOW_27_in_rel_expression1512); 
            	    dbg.location(205,19);
            	    pushFollow(FOLLOW_add_expression_in_rel_expression1516);
            	    e2=add_expression();

            	    state._fsp--;

            	    dbg.location(205,35);
            	    retval.ast = new LogicalExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new GreaterEqual());
            	            		retval.divisors.addAll(e2.divisors);

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);
            } finally {dbg.exitSubRule(28);}


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
        dbg.location(208, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "rel_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "rel_expression"


    public static class add_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "add_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:210:1: add_expression returns [ Expression ast, LinkedList<Expression> divisors ] : e1= mul_expression ( '|' e2= mul_expression | '+' e2= mul_expression | '-' e2= mul_expression )* ;
    public final WhileLanguageParser.add_expression_return add_expression() throws RecognitionException {
        WhileLanguageParser.add_expression_return retval = new WhileLanguageParser.add_expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.mul_expression_return e1 =null;

        WhileLanguageParser.mul_expression_return e2 =null;


        try { dbg.enterRule(getGrammarFileName(), "add_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(210, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:211:9: (e1= mul_expression ( '|' e2= mul_expression | '+' e2= mul_expression | '-' e2= mul_expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:211:11: e1= mul_expression ( '|' e2= mul_expression | '+' e2= mul_expression | '-' e2= mul_expression )*
            {
            dbg.location(211,13);
            pushFollow(FOLLOW_mul_expression_in_add_expression1560);
            e1=mul_expression();

            state._fsp--;

            dbg.location(211,29);
            retval.ast = e1.ast; retval.divisors = (e1!=null?e1.divisors:null);
            dbg.location(211,72);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:211:72: ( '|' e2= mul_expression | '+' e2= mul_expression | '-' e2= mul_expression )*
            try { dbg.enterSubRule(29);

            loop29:
            do {
                int alt29=4;
                try { dbg.enterDecision(29, decisionCanBacktrack[29]);

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

                } finally {dbg.exitDecision(29);}

                switch (alt29) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:212:12: '|' e2= mul_expression
            	    {
            	    dbg.location(212,12);
            	    match(input,44,FOLLOW_44_in_add_expression1578); 
            	    dbg.location(212,18);
            	    pushFollow(FOLLOW_mul_expression_in_add_expression1582);
            	    e2=mul_expression();

            	    state._fsp--;

            	    dbg.location(212,34);
            	    retval.ast = new LogicalExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Disjunction());
            	            	  	retval.divisors.addAll(e2.divisors);

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:214:12: '+' e2= mul_expression
            	    {
            	    dbg.location(214,12);
            	    match(input,17,FOLLOW_17_in_add_expression1597); 
            	    dbg.location(214,18);
            	    pushFollow(FOLLOW_mul_expression_in_add_expression1601);
            	    e2=mul_expression();

            	    state._fsp--;

            	    dbg.location(214,34);
            	    retval.ast = new ArithmeticExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Addition());
            	            		retval.divisors.addAll(e2.divisors);

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:216:12: '-' e2= mul_expression
            	    {
            	    dbg.location(216,12);
            	    match(input,19,FOLLOW_19_in_add_expression1616); 
            	    dbg.location(216,18);
            	    pushFollow(FOLLOW_mul_expression_in_add_expression1620);
            	    e2=mul_expression();

            	    state._fsp--;

            	    dbg.location(216,34);
            	    retval.ast = new ArithmeticExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Subtraction());
            	            		retval.divisors.addAll(e2.divisors);

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);
            } finally {dbg.exitSubRule(29);}


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
        dbg.location(219, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "add_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "add_expression"


    public static class mul_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "mul_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:221:1: mul_expression returns [ Expression ast, LinkedList<Expression> divisors ] : e1= unary_expression ( '&' e2= unary_expression | '*' e2= unary_expression | '/' e2= unary_expression | '%' e2= unary_expression )* ;
    public final WhileLanguageParser.mul_expression_return mul_expression() throws RecognitionException {
        WhileLanguageParser.mul_expression_return retval = new WhileLanguageParser.mul_expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.unary_expression_return e1 =null;

        WhileLanguageParser.unary_expression_return e2 =null;


        try { dbg.enterRule(getGrammarFileName(), "mul_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(221, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:222:9: (e1= unary_expression ( '&' e2= unary_expression | '*' e2= unary_expression | '/' e2= unary_expression | '%' e2= unary_expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:222:11: e1= unary_expression ( '&' e2= unary_expression | '*' e2= unary_expression | '/' e2= unary_expression | '%' e2= unary_expression )*
            {
            dbg.location(222,13);
            pushFollow(FOLLOW_unary_expression_in_mul_expression1664);
            e1=unary_expression();

            state._fsp--;

            dbg.location(222,31);
            retval.ast = e1.ast; retval.divisors = (e1!=null?e1.divisors:null);
            dbg.location(222,74);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:222:74: ( '&' e2= unary_expression | '*' e2= unary_expression | '/' e2= unary_expression | '%' e2= unary_expression )*
            try { dbg.enterSubRule(30);

            loop30:
            do {
                int alt30=5;
                try { dbg.enterDecision(30, decisionCanBacktrack[30]);

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

                } finally {dbg.exitDecision(30);}

                switch (alt30) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:223:12: '&' e2= unary_expression
            	    {
            	    dbg.location(223,12);
            	    match(input,13,FOLLOW_13_in_mul_expression1682); 
            	    dbg.location(223,18);
            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1686);
            	    e2=unary_expression();

            	    state._fsp--;

            	    dbg.location(223,36);
            	    retval.ast = new LogicalExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Conjunction());
            	            	  	retval.divisors.addAll(e2.divisors);

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:225:12: '*' e2= unary_expression
            	    {
            	    dbg.location(225,12);
            	    match(input,16,FOLLOW_16_in_mul_expression1701); 
            	    dbg.location(225,18);
            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1705);
            	    e2=unary_expression();

            	    state._fsp--;

            	    dbg.location(225,36);
            	    retval.ast = new ArithmeticExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Multiplication());
            	            		retval.divisors.addAll(e2.divisors);

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:227:12: '/' e2= unary_expression
            	    {
            	    dbg.location(227,12);
            	    match(input,20,FOLLOW_20_in_mul_expression1720); 
            	    dbg.location(227,18);
            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1724);
            	    e2=unary_expression();

            	    state._fsp--;

            	    dbg.location(227,36);
            	    retval.ast = new ArithmeticExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Division());
            	            		retval.divisors.addAll(e2.divisors);
            	            		retval.divisors.add((e2!=null?e2.ast:null));

            	    }
            	    break;
            	case 4 :
            	    dbg.enterAlt(4);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:230:12: '%' e2= unary_expression
            	    {
            	    dbg.location(230,12);
            	    match(input,12,FOLLOW_12_in_mul_expression1739); 
            	    dbg.location(230,18);
            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1743);
            	    e2=unary_expression();

            	    state._fsp--;

            	    dbg.location(230,36);
            	    if (!((e1!=null?e1.ast:null) instanceof ArithmeticExpression)) 
            	            			throw new TreeGeneratorException("Expected an arithmetic expression.");
            	            		retval.ast = new ArithmeticExpression(new Position(), retval.ast, (e2!=null?e2.ast:null), new Modulo());
            	            		retval.divisors.addAll(e2.divisors);
            	            		retval.divisors.add((e2!=null?e2.ast:null));

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);
            } finally {dbg.exitSubRule(30);}


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
        dbg.location(236, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mul_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "mul_expression"


    public static class unary_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "unary_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:238:1: unary_expression returns [ Expression ast, LinkedList<Expression> divisors ] : ( '!' e= parenthesized_expression | '-' e= parenthesized_expression | ( '+' )? e= parenthesized_expression );
    public final WhileLanguageParser.unary_expression_return unary_expression() throws RecognitionException {
        WhileLanguageParser.unary_expression_return retval = new WhileLanguageParser.unary_expression_return();
        retval.start = input.LT(1);


        WhileLanguageParser.parenthesized_expression_return e =null;


        try { dbg.enterRule(getGrammarFileName(), "unary_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(238, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:239:9: ( '!' e= parenthesized_expression | '-' e= parenthesized_expression | ( '+' )? e= parenthesized_expression )
            int alt32=3;
            try { dbg.enterDecision(32, decisionCanBacktrack[32]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(32);}

            switch (alt32) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:239:11: '!' e= parenthesized_expression
                    {
                    dbg.location(239,11);
                    match(input,10,FOLLOW_10_in_unary_expression1785); 
                    dbg.location(239,17);
                    pushFollow(FOLLOW_parenthesized_expression_in_unary_expression1790);
                    e=parenthesized_expression();

                    state._fsp--;

                    dbg.location(239,43);

                            	retval.ast = new LogicalExpression(new Position(), (e!=null?e.ast:null), null, new Negation());
                            	retval.divisors = e.divisors;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:242:11: '-' e= parenthesized_expression
                    {
                    dbg.location(242,11);
                    match(input,19,FOLLOW_19_in_unary_expression1804); 
                    dbg.location(242,17);
                    pushFollow(FOLLOW_parenthesized_expression_in_unary_expression1809);
                    e=parenthesized_expression();

                    state._fsp--;

                    dbg.location(242,43);
                    if (!((e!=null?e.ast:null) instanceof LogicalExpression)) 
                            		throw new TreeGeneratorException("Expected an arithmetic expression.");
                            	retval.ast = new ArithmeticExpression(new Position(), (e!=null?e.ast:null), null, new UnaryMinus());
                            	retval.divisors = e.divisors;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:246:11: ( '+' )? e= parenthesized_expression
                    {
                    dbg.location(246,11);
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:246:11: ( '+' )?
                    int alt31=2;
                    try { dbg.enterSubRule(31);
                    try { dbg.enterDecision(31, decisionCanBacktrack[31]);

                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==17) ) {
                        alt31=1;
                    }
                    } finally {dbg.exitDecision(31);}

                    switch (alt31) {
                        case 1 :
                            dbg.enterAlt(1);

                            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:246:11: '+'
                            {
                            dbg.location(246,11);
                            match(input,17,FOLLOW_17_in_unary_expression1823); 

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(31);}

                    dbg.location(246,17);
                    pushFollow(FOLLOW_parenthesized_expression_in_unary_expression1828);
                    e=parenthesized_expression();

                    state._fsp--;

                    dbg.location(246,43);

                            	retval.ast = (e!=null?e.ast:null);
                            	retval.divisors = e.divisors;

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
        dbg.location(249, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "unary_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "unary_expression"


    public static class parenthesized_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "parenthesized_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:251:1: parenthesized_expression returns [ Expression ast, LinkedList<Expression> divisors ] : ( '(' expression ')' | function_call | array_read | IDENT | literal_expression );
    public final WhileLanguageParser.parenthesized_expression_return parenthesized_expression() throws RecognitionException {
        WhileLanguageParser.parenthesized_expression_return retval = new WhileLanguageParser.parenthesized_expression_return();
        retval.start = input.LT(1);


        Token IDENT36=null;
        WhileLanguageParser.expression_return expression33 =null;

        WhileLanguageParser.function_call_return function_call34 =null;

        WhileLanguageParser.array_read_return array_read35 =null;

        WhileLanguageParser.literal_expression_return literal_expression37 =null;


        try { dbg.enterRule(getGrammarFileName(), "parenthesized_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(251, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:252:9: ( '(' expression ')' | function_call | array_read | IDENT | literal_expression )
            int alt33=5;
            try { dbg.enterDecision(33, decisionCanBacktrack[33]);

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

                    dbg.recognitionException(nvae);
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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(33);}

            switch (alt33) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:252:11: '(' expression ')'
                    {
                    dbg.location(252,11);
                    match(input,14,FOLLOW_14_in_parenthesized_expression1859); 
                    dbg.location(252,15);
                    pushFollow(FOLLOW_expression_in_parenthesized_expression1861);
                    expression33=expression();

                    state._fsp--;

                    dbg.location(252,26);
                    match(input,15,FOLLOW_15_in_parenthesized_expression1863); 
                    dbg.location(252,30);
                    retval.ast = (expression33!=null?expression33.ast:null); retval.divisors = (expression33!=null?expression33.divisors:null);

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:253:11: function_call
                    {
                    dbg.location(253,11);
                    pushFollow(FOLLOW_function_call_in_parenthesized_expression1877);
                    function_call34=function_call();

                    state._fsp--;

                    dbg.location(253,25);
                    retval.ast = (function_call34!=null?function_call34.ast:null); retval.divisors = (function_call34!=null?function_call34.divisors:null);

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:254:11: array_read
                    {
                    dbg.location(254,11);
                    pushFollow(FOLLOW_array_read_in_parenthesized_expression1891);
                    array_read35=array_read();

                    state._fsp--;

                    dbg.location(254,22);
                    retval.ast = (array_read35!=null?array_read35.ast:null); retval.divisors = (array_read35!=null?array_read35.divisors:null);

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:255:11: IDENT
                    {
                    dbg.location(255,11);
                    IDENT36=(Token)match(input,IDENT,FOLLOW_IDENT_in_parenthesized_expression1905); 
                    dbg.location(255,17);
                    retval.ast = new VariableRead(new Position(), new Identifier((IDENT36!=null?IDENT36.getText():null))); retval.divisors = new LinkedList<Expression>();

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:256:11: literal_expression
                    {
                    dbg.location(256,11);
                    pushFollow(FOLLOW_literal_expression_in_parenthesized_expression1919);
                    literal_expression37=literal_expression();

                    state._fsp--;

                    dbg.location(256,30);
                    retval.ast = (literal_expression37!=null?literal_expression37.ast:null); retval.divisors = (literal_expression37!=null?literal_expression37.divisors:null);

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
        dbg.location(257, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parenthesized_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "parenthesized_expression"


    public static class function_call_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "function_call"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:259:1: function_call returns [ Expression ast, LinkedList<Expression> divisors ] : IDENT '(' ( arglist )? ')' ;
    public final WhileLanguageParser.function_call_return function_call() throws RecognitionException {
        WhileLanguageParser.function_call_return retval = new WhileLanguageParser.function_call_return();
        retval.start = input.LT(1);


        Token IDENT39=null;
        WhileLanguageParser.arglist_return arglist38 =null;


        try { dbg.enterRule(getGrammarFileName(), "function_call");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(259, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:260:9: ( IDENT '(' ( arglist )? ')' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:260:11: IDENT '(' ( arglist )? ')'
            {
            dbg.location(260,11);
            IDENT39=(Token)match(input,IDENT,FOLLOW_IDENT_in_function_call1950); 
            dbg.location(260,17);
            match(input,14,FOLLOW_14_in_function_call1952); 
            dbg.location(260,21);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:260:21: ( arglist )?
            int alt34=2;
            try { dbg.enterSubRule(34);
            try { dbg.enterDecision(34, decisionCanBacktrack[34]);

            int LA34_0 = input.LA(1);

            if ( (LA34_0==BOOL_LITERAL||(LA34_0 >= IDENT && LA34_0 <= INT_LITERAL)||LA34_0==10||LA34_0==14||LA34_0==17||LA34_0==19) ) {
                alt34=1;
            }
            } finally {dbg.exitDecision(34);}

            switch (alt34) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:260:21: arglist
                    {
                    dbg.location(260,21);
                    pushFollow(FOLLOW_arglist_in_function_call1954);
                    arglist38=arglist();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(34);}

            dbg.location(260,30);
            match(input,15,FOLLOW_15_in_function_call1957); 
            dbg.location(260,34);

                    	Expression[] params = new Expression[0];
                    	if ((arglist38!=null?arglist38.params:null) != null) params = (arglist38!=null?arglist38.params:null).toArray(new Expression[(arglist38!=null?arglist38.params:null).size()]);
                    	retval.ast = new FunctionCall(new Identifier((IDENT39!=null?IDENT39.getText():null)), params , new Position());
                    	retval.divisors = (arglist38!=null?arglist38.divisors:null);

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
        dbg.location(265, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function_call");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "function_call"


    public static class arglist_return extends ParserRuleReturnScope {
        public LinkedList<Expression> params;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "arglist"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:267:1: arglist returns [ LinkedList<Expression> params, LinkedList<Expression> divisors ] : e1= expression ( ',' e2= expression )* ;
    public final WhileLanguageParser.arglist_return arglist() throws RecognitionException {
        WhileLanguageParser.arglist_return retval = new WhileLanguageParser.arglist_return();
        retval.start = input.LT(1);


        WhileLanguageParser.expression_return e1 =null;

        WhileLanguageParser.expression_return e2 =null;


        LinkedList<Expression> params = new LinkedList<Expression>();
        try { dbg.enterRule(getGrammarFileName(), "arglist");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(267, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:269:9: (e1= expression ( ',' e2= expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:269:11: e1= expression ( ',' e2= expression )*
            {
            dbg.location(269,13);
            pushFollow(FOLLOW_expression_in_arglist1996);
            e1=expression();

            state._fsp--;

            dbg.location(269,25);
            params.add((Expression) e1.ast); retval.divisors = (e1!=null?e1.divisors:null);
            dbg.location(270,10);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:270:10: ( ',' e2= expression )*
            try { dbg.enterSubRule(35);

            loop35:
            do {
                int alt35=2;
                try { dbg.enterDecision(35, decisionCanBacktrack[35]);

                int LA35_0 = input.LA(1);

                if ( (LA35_0==18) ) {
                    alt35=1;
                }


                } finally {dbg.exitDecision(35);}

                switch (alt35) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:270:12: ',' e2= expression
            	    {
            	    dbg.location(270,12);
            	    match(input,18,FOLLOW_18_in_arglist2012); 
            	    dbg.location(270,18);
            	    pushFollow(FOLLOW_expression_in_arglist2016);
            	    e2=expression();

            	    state._fsp--;

            	    dbg.location(270,30);
            	    params.add((Expression) (e2!=null?e2.ast:null)); retval.divisors.addAll((e2!=null?e2.divisors:null));

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);
            } finally {dbg.exitSubRule(35);}


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
        dbg.location(271, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "arglist");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "arglist"


    public static class array_read_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "array_read"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:273:1: array_read returns [ Expression ast, LinkedList<Expression> divisors ] : IDENT '[' e1= expression ']' ( '[' e2= expression ']' )* ;
    public final WhileLanguageParser.array_read_return array_read() throws RecognitionException {
        WhileLanguageParser.array_read_return retval = new WhileLanguageParser.array_read_return();
        retval.start = input.LT(1);


        Token IDENT40=null;
        WhileLanguageParser.expression_return e1 =null;

        WhileLanguageParser.expression_return e2 =null;


        LinkedList<ArithmeticExpression> l = new LinkedList<ArithmeticExpression>();
        try { dbg.enterRule(getGrammarFileName(), "array_read");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(273, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:275:9: ( IDENT '[' e1= expression ']' ( '[' e2= expression ']' )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:275:11: IDENT '[' e1= expression ']' ( '[' e2= expression ']' )*
            {
            dbg.location(275,11);
            IDENT40=(Token)match(input,IDENT,FOLLOW_IDENT_in_array_read2056); 
            dbg.location(275,17);
            match(input,28,FOLLOW_28_in_array_read2058); 
            dbg.location(275,23);
            pushFollow(FOLLOW_expression_in_array_read2062);
            e1=expression();

            state._fsp--;

            dbg.location(275,35);
            if ((e1!=null?e1.ast:null) instanceof ArithmeticExpression) l.add((ArithmeticExpression)(e1!=null?e1.ast:null));
                    			else throw new TreeGeneratorException("expected an arithmetic expression, got a logical expression");
                    		retval.divisors = (e1!=null?e1.divisors:null);
            dbg.location(277,38);
            match(input,29,FOLLOW_29_in_array_read2066); 
            dbg.location(278,10);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:278:10: ( '[' e2= expression ']' )*
            try { dbg.enterSubRule(36);

            loop36:
            do {
                int alt36=2;
                try { dbg.enterDecision(36, decisionCanBacktrack[36]);

                int LA36_0 = input.LA(1);

                if ( (LA36_0==28) ) {
                    alt36=1;
                }


                } finally {dbg.exitDecision(36);}

                switch (alt36) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:278:12: '[' e2= expression ']'
            	    {
            	    dbg.location(278,12);
            	    match(input,28,FOLLOW_28_in_array_read2080); 
            	    dbg.location(278,18);
            	    pushFollow(FOLLOW_expression_in_array_read2084);
            	    e2=expression();

            	    state._fsp--;

            	    dbg.location(278,30);
            	    if ((e2!=null?e2.ast:null) instanceof ArithmeticExpression) l.add((ArithmeticExpression)(e2!=null?e2.ast:null));
            	            			else throw new TreeGeneratorException("expected an arithmetic expression, got a logical expression");
            	            		retval.divisors.addAll((e2!=null?e2.divisors:null));
            	    dbg.location(280,44);
            	    match(input,29,FOLLOW_29_in_array_read2088); 

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);
            } finally {dbg.exitSubRule(36);}

            dbg.location(281,9);
            retval.ast = new ArrayRead(new Position(), new Identifier((IDENT40!=null?IDENT40.getText():null)), l.toArray(new ArithmeticExpression[l.size()]));

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
        dbg.location(282, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_read");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "array_read"


    public static class literal_expression_return extends ParserRuleReturnScope {
        public Expression ast;
        public LinkedList<Expression> divisors;
    };


    // $ANTLR start "literal_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:284:1: literal_expression returns [ Expression ast, LinkedList<Expression> divisors ] : ( INT_LITERAL | BOOL_LITERAL );
    public final WhileLanguageParser.literal_expression_return literal_expression() throws RecognitionException {
        WhileLanguageParser.literal_expression_return retval = new WhileLanguageParser.literal_expression_return();
        retval.start = input.LT(1);


        Token INT_LITERAL41=null;
        Token BOOL_LITERAL42=null;

        try { dbg.enterRule(getGrammarFileName(), "literal_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(284, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:285:9: ( INT_LITERAL | BOOL_LITERAL )
            int alt37=2;
            try { dbg.enterDecision(37, decisionCanBacktrack[37]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(37);}

            switch (alt37) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:285:11: INT_LITERAL
                    {
                    dbg.location(285,11);
                    INT_LITERAL41=(Token)match(input,INT_LITERAL,FOLLOW_INT_LITERAL_in_literal_expression2131); 
                    dbg.location(285,23);
                    retval.ast = new NumericLiteral(new Position(), (INT_LITERAL41!=null?INT_LITERAL41.getText():null)); retval.divisors = new LinkedList<Expression>();

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:286:11: BOOL_LITERAL
                    {
                    dbg.location(286,11);
                    BOOL_LITERAL42=(Token)match(input,BOOL_LITERAL,FOLLOW_BOOL_LITERAL_in_literal_expression2145); 
                    dbg.location(286,24);
                    retval.ast = new BooleanLiteral(new Position(), (BOOL_LITERAL42!=null?BOOL_LITERAL42.getText():null)); retval.divisors = new LinkedList<Expression>();

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
        dbg.location(287, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "literal_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "literal_expression"



    // $ANTLR start "type"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:289:1: type returns [ Type ast ] : ( 'int' | 'bool' ) ( '[' ']' )* ;
    public final Type type() throws RecognitionException {
        Type ast = null;


        try { dbg.enterRule(getGrammarFileName(), "type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(289, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:290:9: ( ( 'int' | 'bool' ) ( '[' ']' )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:290:11: ( 'int' | 'bool' ) ( '[' ']' )*
            {
            dbg.location(290,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:290:11: ( 'int' | 'bool' )
            int alt38=2;
            try { dbg.enterSubRule(38);
            try { dbg.enterDecision(38, decisionCanBacktrack[38]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(38);}

            switch (alt38) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:290:12: 'int'
                    {
                    dbg.location(290,12);
                    match(input,38,FOLLOW_38_in_type2177); 
                    dbg.location(290,18);
                    ast = new IntegerType();

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:290:48: 'bool'
                    {
                    dbg.location(290,48);
                    match(input,34,FOLLOW_34_in_type2183); 
                    dbg.location(290,54);
                    ast = new BooleanType();

                    }
                    break;

            }
            } finally {dbg.exitSubRule(38);}

            dbg.location(290,83);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:290:83: ( '[' ']' )*
            try { dbg.enterSubRule(39);

            loop39:
            do {
                int alt39=2;
                try { dbg.enterDecision(39, decisionCanBacktrack[39]);

                int LA39_0 = input.LA(1);

                if ( (LA39_0==28) ) {
                    alt39=1;
                }


                } finally {dbg.exitDecision(39);}

                switch (alt39) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:290:85: '[' ']'
            	    {
            	    dbg.location(290,85);
            	    match(input,28,FOLLOW_28_in_type2189); 
            	    dbg.location(290,89);
            	    match(input,29,FOLLOW_29_in_type2191); 
            	    dbg.location(290,93);
            	    ast = new ArrayType(ast);

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);
            } finally {dbg.exitSubRule(39);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(291, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
            return "70:1: statement returns [ Statement ast ] : (e1= assert_statement |e2= variable_declaration |e3= array_declaration |e4= assignment |e5= if_statement |e6= while_statement |e7= return_statement );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_axiom_statement_in_program46 = new BitSet(new long[]{0x0000014600000000L});
    public static final BitSet FOLLOW_function_declaration_in_program55 = new BitSet(new long[]{0x0000014400000000L});
    public static final BitSet FOLLOW_main_in_program61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_single_expression94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_function_declaration118 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_function_declaration120 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_function_declaration122 = new BitSet(new long[]{0x0000004400008000L});
    public static final BitSet FOLLOW_parameter_list_in_function_declaration124 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_function_declaration127 = new BitSet(new long[]{0x0000080100000000L});
    public static final BitSet FOLLOW_function_body_in_function_declaration129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_main169 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_main171 = new BitSet(new long[]{0x0000004400008000L});
    public static final BitSet FOLLOW_parameter_list_in_main173 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_main176 = new BitSet(new long[]{0x0000080100000000L});
    public static final BitSet FOLLOW_function_body_in_main178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_parameter_list227 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parameter_list233 = new BitSet(new long[]{0x0000004400000000L});
    public static final BitSet FOLLOW_parameter_in_parameter_list237 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_type_in_parameter271 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_parameter273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assume_statement_in_function_body310 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_function_body324 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_statement_in_function_body328 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_45_in_function_body335 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ensure_statement_in_function_body349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_if_body387 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_statement_in_if_body389 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_45_in_if_body392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invariant_statement_in_loop_body433 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_loop_body449 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_statement_in_loop_body453 = new BitSet(new long[]{0x0000266480000040L});
    public static final BitSet FOLLOW_45_in_loop_body460 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ensure_statement_in_loop_body474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_declaration_in_statement524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_declaration_in_statement540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_statement_in_statement604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_invariant_statement641 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_invariant_statement645 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_invariant_statement647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_invariant_statement661 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_invariant_statement663 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_invariant_statement668 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_invariant_statement670 = new BitSet(new long[]{0x00002000000A45D0L});
    public static final BitSet FOLLOW_45_in_invariant_statement677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_axiom_statement706 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_axiom_statement710 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_axiom_statement712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_assert_statement743 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_assert_statement747 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assert_statement749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_assume_statement786 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_assume_statement790 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assume_statement792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_assume_statement806 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_assume_statement808 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_assume_statement813 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assume_statement815 = new BitSet(new long[]{0x00002000000A45D0L});
    public static final BitSet FOLLOW_45_in_assume_statement822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ensure_statement858 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_ensure_statement862 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ensure_statement864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ensure_statement878 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ensure_statement880 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_ensure_statement885 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ensure_statement887 = new BitSet(new long[]{0x00002000000A45D0L});
    public static final BitSet FOLLOW_45_in_ensure_statement894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignment923 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_assignment925 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_assignment927 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assignment929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignment943 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_assignment959 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_assignment963 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_assignment967 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_assignment972 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_assignment976 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assignment978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_variable_declaration1009 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_variable_declaration1011 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_variable_declaration1015 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_variable_declaration1017 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_variable_declaration1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_array_declaration1053 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_array_declaration1055 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_array_declaration1057 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_array_init_in_array_declaration1059 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_array_declaration1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_array_init1096 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_init1100 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_array_init1102 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_array_init1106 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_37_in_if_statement1131 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_statement1133 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_if_statement1135 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_if_statement1137 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_if_body_in_if_statement1141 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_if_statement1145 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_if_body_in_if_statement1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_while_statement1183 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_statement1185 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_while_statement1187 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_while_statement1189 = new BitSet(new long[]{0x0000088000000000L});
    public static final BitSet FOLLOW_loop_body_in_while_statement1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_return_statement1223 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_return_statement1225 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_return_statement1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUANTIFIER_in_quantified_expression1251 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_quantified_expression1253 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_quantified_expression1255 = new BitSet(new long[]{0x00000000000AC4D0L});
    public static final BitSet FOLLOW_range_in_quantified_expression1257 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_quantified_expression1260 = new BitSet(new long[]{0x00000000000A45D0L});
    public static final BitSet FOLLOW_quantified_expression_in_quantified_expression1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_quantified_expression1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_range1310 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_range1312 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_range1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_expression_in_expression1349 = new BitSet(new long[]{0x0000000002000802L});
    public static final BitSet FOLLOW_25_in_expression1367 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_rel_expression_in_expression1371 = new BitSet(new long[]{0x0000000002000802L});
    public static final BitSet FOLLOW_11_in_expression1386 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_rel_expression_in_expression1390 = new BitSet(new long[]{0x0000000002000802L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1435 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_22_in_rel_expression1453 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1458 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_23_in_rel_expression1473 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1477 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_26_in_rel_expression1492 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1497 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_27_in_rel_expression1512 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1516 = new BitSet(new long[]{0x000000000CC00002L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1560 = new BitSet(new long[]{0x00001000000A0002L});
    public static final BitSet FOLLOW_44_in_add_expression1578 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1582 = new BitSet(new long[]{0x00001000000A0002L});
    public static final BitSet FOLLOW_17_in_add_expression1597 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1601 = new BitSet(new long[]{0x00001000000A0002L});
    public static final BitSet FOLLOW_19_in_add_expression1616 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1620 = new BitSet(new long[]{0x00001000000A0002L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1664 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_13_in_mul_expression1682 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1686 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_16_in_mul_expression1701 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1705 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_20_in_mul_expression1720 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1724 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_12_in_mul_expression1739 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1743 = new BitSet(new long[]{0x0000000000113002L});
    public static final BitSet FOLLOW_10_in_unary_expression1785 = new BitSet(new long[]{0x00000000000040D0L});
    public static final BitSet FOLLOW_parenthesized_expression_in_unary_expression1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unary_expression1804 = new BitSet(new long[]{0x00000000000040D0L});
    public static final BitSet FOLLOW_parenthesized_expression_in_unary_expression1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unary_expression1823 = new BitSet(new long[]{0x00000000000040D0L});
    public static final BitSet FOLLOW_parenthesized_expression_in_unary_expression1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parenthesized_expression1859 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_parenthesized_expression1861 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parenthesized_expression1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_parenthesized_expression1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_read_in_parenthesized_expression1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_parenthesized_expression1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_expression_in_parenthesized_expression1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_function_call1950 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_function_call1952 = new BitSet(new long[]{0x00000000000AC4D0L});
    public static final BitSet FOLLOW_arglist_in_function_call1954 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_function_call1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_arglist1996 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_arglist2012 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_arglist2016 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_IDENT_in_array_read2056 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_read2058 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_array_read2062 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_array_read2066 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_array_read2080 = new BitSet(new long[]{0x00000000000A44D0L});
    public static final BitSet FOLLOW_expression_in_array_read2084 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_array_read2088 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_INT_LITERAL_in_literal_expression2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_LITERAL_in_literal_expression2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_type2177 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_34_in_type2183 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_type2189 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_type2191 = new BitSet(new long[]{0x0000000010000002L});

}