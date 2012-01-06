// $ANTLR 3.4 C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g 2012-01-06 14:28:30

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL_LITERAL", "COMMENT", "IDENT", "INT_LITERAL", "WS", "'!'", "'!='", "'%'", "'&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'assert'", "'assume'", "'bool'", "'else'", "'ensure'", "'exists'", "'forall'", "'if'", "'int'", "'invariant'", "'main'", "'return'", "'while'", "'{'", "'|'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__9=9;
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
    public static final int BOOL_LITERAL=4;
    public static final int COMMENT=5;
    public static final int IDENT=6;
    public static final int INT_LITERAL=7;
    public static final int WS=8;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "parameter_list", "assignment", "parenthesized_expression", 
    "parameter", "unary_expression", "main_method", "mul_expression", "loop_body", 
    "single_expression", "type", "assert_statement", "method_body", "literal_expression", 
    "if_statement", "array_read", "assume_statement", "quantified_expression", 
    "quantifier", "array_declaration", "variable_declaration", "statement", 
    "program", "statement_block", "method_declaration", "arglist", "range", 
    "add_expression", "function_call", "rel_expression", "while_statement", 
    "invariant_statement", "expression", "ensure_statement"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false
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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:13:1: program returns [ ASTRoot ast ] : (a= assume_statement )* (f= method_declaration )* main_method ;
    public final ASTRoot program() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot a =null;

        ASTRoot f =null;

        ASTRoot main_method1 =null;


        LinkedList<Axiom> as = new LinkedList<Axiom>();
             	   LinkedList<Function> funcs = new LinkedList<Function>();
        try { dbg.enterRule(getGrammarFileName(), "program");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(13, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:9: ( (a= assume_statement )* (f= method_declaration )* main_method )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:11: (a= assume_statement )* (f= method_declaration )* main_method
            {
            dbg.location(16,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:11: (a= assume_statement )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==30) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:12: a= assume_statement
            	    {
            	    dbg.location(16,13);
            	    pushFollow(FOLLOW_assume_statement_in_program49);
            	    a=assume_statement();

            	    state._fsp--;

            	    dbg.location(16,31);
            	    as.add(new Axiom(new Position(), (Expression) a));

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(17,9);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:17:9: (f= method_declaration )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==31||LA2_0==37) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:17:11: f= method_declaration
            	    {
            	    dbg.location(17,12);
            	    pushFollow(FOLLOW_method_declaration_in_program67);
            	    f=method_declaration();

            	    state._fsp--;

            	    dbg.location(17,32);
            	    funcs.add((Function) f);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}

            dbg.location(17,62);
            pushFollow(FOLLOW_main_method_in_program74);
            main_method1=main_method();

            state._fsp--;

            dbg.location(18,9);
            ast = new Program(new Position(), funcs.toArray(new Function[funcs.size()]),
                    		    (Function) main_method1, as.toArray(new Axiom[funcs.size()]));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(20, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "program");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "program"



    // $ANTLR start "single_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:22:1: single_expression returns [ ASTRoot ast ] : expression ;
    public final ASTRoot single_expression() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot expression2 =null;


        try { dbg.enterRule(getGrammarFileName(), "single_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(22, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:23:2: ( expression )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:23:4: expression
            {
            dbg.location(23,4);
            pushFollow(FOLLOW_expression_in_single_expression106);
            expression2=expression();

            state._fsp--;

            dbg.location(23,15);
            ast = expression2;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(24, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "single_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "single_expression"



    // $ANTLR start "method_declaration"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:26:1: method_declaration returns [ ASTRoot ast ] : type IDENT '(' ( parameter_list )? ')' method_body ;
    public final ASTRoot method_declaration() throws RecognitionException {
        ASTRoot ast = null;


        Token IDENT5=null;
        LinkedList<FunctionParameter> parameter_list3 =null;

        Type type4 =null;

        ASTRoot[][] method_body6 =null;


        try { dbg.enterRule(getGrammarFileName(), "method_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(26, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:27:9: ( type IDENT '(' ( parameter_list )? ')' method_body )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:27:11: type IDENT '(' ( parameter_list )? ')' method_body
            {
            dbg.location(27,11);
            pushFollow(FOLLOW_type_in_method_declaration130);
            type4=type();

            state._fsp--;

            dbg.location(27,16);
            IDENT5=(Token)match(input,IDENT,FOLLOW_IDENT_in_method_declaration132); 
            dbg.location(27,22);
            match(input,13,FOLLOW_13_in_method_declaration134); 
            dbg.location(27,26);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:27:26: ( parameter_list )?
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3, decisionCanBacktrack[3]);

            int LA3_0 = input.LA(1);

            if ( (LA3_0==31||LA3_0==37) ) {
                alt3=1;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:27:26: parameter_list
                    {
                    dbg.location(27,26);
                    pushFollow(FOLLOW_parameter_list_in_method_declaration136);
                    parameter_list3=parameter_list();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}

            dbg.location(27,42);
            match(input,14,FOLLOW_14_in_method_declaration139); 
            dbg.location(27,46);
            pushFollow(FOLLOW_method_body_in_method_declaration141);
            method_body6=method_body();

            state._fsp--;

            dbg.location(28,9);
            FunctionParameter[] params = new FunctionParameter[0];
                    if (parameter_list3 != null)
                    	params = parameter_list3.toArray(new FunctionParameter[parameter_list3.size()]);
                    ast = new Function(new Position(), type4, (IDENT5!=null?IDENT5.getText():null), params, (StatementBlock) method_body6[1][0],
                    	(Assumption[]) method_body6[0], (Ensure[]) method_body6[2]);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(33, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "method_declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "method_declaration"



    // $ANTLR start "main_method"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:35:1: main_method returns [ ASTRoot ast ] : 'main' '(' ( parameter_list )? ')' method_body ;
    public final ASTRoot main_method() throws RecognitionException {
        ASTRoot ast = null;


        LinkedList<FunctionParameter> parameter_list7 =null;

        ASTRoot[][] method_body8 =null;


        try { dbg.enterRule(getGrammarFileName(), "main_method");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(35, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:36:9: ( 'main' '(' ( parameter_list )? ')' method_body )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:36:11: 'main' '(' ( parameter_list )? ')' method_body
            {
            dbg.location(36,11);
            match(input,39,FOLLOW_39_in_main_method180); 
            dbg.location(36,18);
            match(input,13,FOLLOW_13_in_main_method182); 
            dbg.location(36,22);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:36:22: ( parameter_list )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==31||LA4_0==37) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:36:22: parameter_list
                    {
                    dbg.location(36,22);
                    pushFollow(FOLLOW_parameter_list_in_main_method184);
                    parameter_list7=parameter_list();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}

            dbg.location(36,38);
            match(input,14,FOLLOW_14_in_main_method187); 
            dbg.location(36,42);
            pushFollow(FOLLOW_method_body_in_main_method189);
            method_body8=method_body();

            state._fsp--;

            dbg.location(37,9);
            FunctionParameter[] params = new FunctionParameter[0];
                    if (parameter_list7 != null)
                    	params = parameter_list7.toArray(new FunctionParameter[parameter_list7.size()]);
                    ast = new Function(new Position(), null, "main", params, (StatementBlock) method_body8[1][0],
                    	(Assumption[]) method_body8[0], (Ensure[]) method_body8[2]);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(42, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "main_method");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "main_method"



    // $ANTLR start "parameter_list"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:44:1: parameter_list returns [ LinkedList<FunctionParameter> params ] : p1= parameter ( ',' p2= parameter )* ;
    public final LinkedList<FunctionParameter> parameter_list() throws RecognitionException {
        LinkedList<FunctionParameter> params = null;


        FunctionParameter p1 =null;

        FunctionParameter p2 =null;


        params = new LinkedList<FunctionParameter>();
        try { dbg.enterRule(getGrammarFileName(), "parameter_list");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(44, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:46:9: (p1= parameter ( ',' p2= parameter )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:46:11: p1= parameter ( ',' p2= parameter )*
            {
            dbg.location(46,13);
            pushFollow(FOLLOW_parameter_in_parameter_list239);
            p1=parameter();

            state._fsp--;

            dbg.location(46,24);
            params.add(p1);
            dbg.location(46,42);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:46:42: ( ',' p2= parameter )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:46:44: ',' p2= parameter
            	    {
            	    dbg.location(46,44);
            	    match(input,17,FOLLOW_17_in_parameter_list245); 
            	    dbg.location(46,50);
            	    pushFollow(FOLLOW_parameter_in_parameter_list249);
            	    p2=parameter();

            	    state._fsp--;

            	    dbg.location(46,61);
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
        dbg.location(47, 8);

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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:49:1: parameter returns [ FunctionParameter param ] : type IDENT ;
    public final FunctionParameter parameter() throws RecognitionException {
        FunctionParameter param = null;


        Token IDENT9=null;
        Type type10 =null;


        try { dbg.enterRule(getGrammarFileName(), "parameter");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(49, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:50:9: ( type IDENT )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:50:11: type IDENT
            {
            dbg.location(50,11);
            pushFollow(FOLLOW_type_in_parameter282);
            type10=type();

            state._fsp--;

            dbg.location(50,16);
            IDENT9=(Token)match(input,IDENT,FOLLOW_IDENT_in_parameter284); 
            dbg.location(50,22);
            param = new FunctionParameter((IDENT9!=null?IDENT9.getText():null), type10);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(51, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameter");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return param;
    }
    // $ANTLR end "parameter"



    // $ANTLR start "method_body"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:53:1: method_body returns [ ASTRoot[][] ast ] : '{' (a= assume_statement )* statement_block (e= ensure_statement )* '}' ;
    public final ASTRoot[][] method_body() throws RecognitionException {
        ASTRoot[][] ast = null;


        ASTRoot a =null;

        ASTRoot e =null;

        ASTRoot statement_block11 =null;


        LinkedList<Assumption> as = new LinkedList<Assumption>();
                LinkedList<Ensure> es = new LinkedList<Ensure>();
        try { dbg.enterRule(getGrammarFileName(), "method_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:56:9: ( '{' (a= assume_statement )* statement_block (e= ensure_statement )* '}' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:56:11: '{' (a= assume_statement )* statement_block (e= ensure_statement )* '}'
            {
            dbg.location(56,11);
            match(input,42,FOLLOW_42_in_method_body324); 
            dbg.location(56,15);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:56:15: (a= assume_statement )*
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=2;
                try { dbg.enterDecision(6, decisionCanBacktrack[6]);

                int LA6_0 = input.LA(1);

                if ( (LA6_0==30) ) {
                    alt6=1;
                }


                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:56:16: a= assume_statement
            	    {
            	    dbg.location(56,17);
            	    pushFollow(FOLLOW_assume_statement_in_method_body329);
            	    a=assume_statement();

            	    state._fsp--;

            	    dbg.location(56,35);
            	    as.add(new Assumption(new Position(), (Expression) a));

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}

            dbg.location(57,9);
            pushFollow(FOLLOW_statement_block_in_method_body343);
            statement_block11=statement_block();

            state._fsp--;

            dbg.location(58,9);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:58:9: (e= ensure_statement )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==33) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:58:10: e= ensure_statement
            	    {
            	    dbg.location(58,11);
            	    pushFollow(FOLLOW_ensure_statement_in_method_body357);
            	    e=ensure_statement();

            	    state._fsp--;

            	    dbg.location(58,29);
            	    es.add((Ensure) e);

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}

            dbg.location(58,53);
            match(input,44,FOLLOW_44_in_method_body363); 
            dbg.location(59,9);
            ast = new ASTRoot[3][];
                    ast[0] = as.toArray(new Assumption[as.size()]);
                    ast[1] = new ASTRoot[]{statement_block11};
                    ast[0] = es.toArray(new Ensure[es.size()]);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(63, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "method_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "method_body"



    // $ANTLR start "statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:65:1: statement returns [ ASTRoot ast ] : ( assert_statement | variable_declaration | array_declaration | assignment | if_statement | while_statement | 'return' expression ';' );
    public final ASTRoot statement() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot assert_statement12 =null;

        ASTRoot variable_declaration13 =null;

        ASTRoot array_declaration14 =null;

        ASTRoot assignment15 =null;

        ASTRoot if_statement16 =null;

        ASTRoot while_statement17 =null;

        ASTRoot expression18 =null;


        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(65, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:66:9: ( assert_statement | variable_declaration | array_declaration | assignment | if_statement | while_statement | 'return' expression ';' )
            int alt8=7;
            try { dbg.enterDecision(8, decisionCanBacktrack[8]);

            try {
                isCyclicDecision = true;
                alt8 = dfa8.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:66:11: assert_statement
                    {
                    dbg.location(66,11);
                    pushFollow(FOLLOW_assert_statement_in_statement402);
                    assert_statement12=assert_statement();

                    state._fsp--;

                    dbg.location(66,28);
                    ast = assert_statement12;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:67:11: variable_declaration
                    {
                    dbg.location(67,11);
                    pushFollow(FOLLOW_variable_declaration_in_statement416);
                    variable_declaration13=variable_declaration();

                    state._fsp--;

                    dbg.location(67,32);
                    ast = variable_declaration13;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:68:11: array_declaration
                    {
                    dbg.location(68,11);
                    pushFollow(FOLLOW_array_declaration_in_statement430);
                    array_declaration14=array_declaration();

                    state._fsp--;

                    dbg.location(68,29);
                    ast = array_declaration14;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:69:11: assignment
                    {
                    dbg.location(69,11);
                    pushFollow(FOLLOW_assignment_in_statement444);
                    assignment15=assignment();

                    state._fsp--;

                    dbg.location(69,22);
                    ast = assignment15;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:70:11: if_statement
                    {
                    dbg.location(70,11);
                    pushFollow(FOLLOW_if_statement_in_statement458);
                    if_statement16=if_statement();

                    state._fsp--;

                    dbg.location(70,24);
                    ast = if_statement16;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:71:11: while_statement
                    {
                    dbg.location(71,11);
                    pushFollow(FOLLOW_while_statement_in_statement472);
                    while_statement17=while_statement();

                    state._fsp--;

                    dbg.location(71,27);
                    ast = while_statement17;

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:72:11: 'return' expression ';'
                    {
                    dbg.location(72,11);
                    match(input,40,FOLLOW_40_in_statement486); 
                    dbg.location(72,20);
                    pushFollow(FOLLOW_expression_in_statement488);
                    expression18=expression();

                    state._fsp--;

                    dbg.location(72,31);
                    match(input,20,FOLLOW_20_in_statement490); 
                    dbg.location(72,35);
                    ast = new ReturnStatement(new Position(), (Expression) expression18);

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
        dbg.location(73, 8);

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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:75:1: invariant_statement returns [ ASTRoot ast ] : 'invariant' quantified_expression ';' ;
    public final ASTRoot invariant_statement() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot quantified_expression19 =null;


        try { dbg.enterRule(getGrammarFileName(), "invariant_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(75, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:76:9: ( 'invariant' quantified_expression ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:76:11: 'invariant' quantified_expression ';'
            {
            dbg.location(76,11);
            match(input,38,FOLLOW_38_in_invariant_statement521); 
            dbg.location(76,23);
            pushFollow(FOLLOW_quantified_expression_in_invariant_statement523);
            quantified_expression19=quantified_expression();

            state._fsp--;

            dbg.location(76,45);
            match(input,20,FOLLOW_20_in_invariant_statement525); 
            dbg.location(76,49);
            ast = new Invariant(new Position(), (Expression) quantified_expression19);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(77, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "invariant_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "invariant_statement"



    // $ANTLR start "assert_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:79:1: assert_statement returns [ ASTRoot ast ] : 'assert' quantified_expression ';' ;
    public final ASTRoot assert_statement() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot quantified_expression20 =null;


        try { dbg.enterRule(getGrammarFileName(), "assert_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(79, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:80:9: ( 'assert' quantified_expression ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:80:11: 'assert' quantified_expression ';'
            {
            dbg.location(80,11);
            match(input,29,FOLLOW_29_in_assert_statement556); 
            dbg.location(80,20);
            pushFollow(FOLLOW_quantified_expression_in_assert_statement558);
            quantified_expression20=quantified_expression();

            state._fsp--;

            dbg.location(80,42);
            match(input,20,FOLLOW_20_in_assert_statement560); 
            dbg.location(80,46);
            ast = new Assertion(new Position(), (Expression) quantified_expression20);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(81, 8);

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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:83:1: assume_statement returns [ ASTRoot ast ] : 'assume' quantified_expression ';' ;
    public final ASTRoot assume_statement() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot quantified_expression21 =null;


        try { dbg.enterRule(getGrammarFileName(), "assume_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(83, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:84:9: ( 'assume' quantified_expression ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:84:11: 'assume' quantified_expression ';'
            {
            dbg.location(84,11);
            match(input,30,FOLLOW_30_in_assume_statement591); 
            dbg.location(84,20);
            pushFollow(FOLLOW_quantified_expression_in_assume_statement593);
            quantified_expression21=quantified_expression();

            state._fsp--;

            dbg.location(84,42);
            match(input,20,FOLLOW_20_in_assume_statement595); 
            dbg.location(84,46);
            ast = quantified_expression21;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(85, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assume_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "assume_statement"



    // $ANTLR start "ensure_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:87:1: ensure_statement returns [ ASTRoot ast ] : 'ensure' quantified_expression ';' ;
    public final ASTRoot ensure_statement() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot quantified_expression22 =null;


        try { dbg.enterRule(getGrammarFileName(), "ensure_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(87, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:88:9: ( 'ensure' quantified_expression ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:88:11: 'ensure' quantified_expression ';'
            {
            dbg.location(88,11);
            match(input,33,FOLLOW_33_in_ensure_statement626); 
            dbg.location(88,20);
            pushFollow(FOLLOW_quantified_expression_in_ensure_statement628);
            quantified_expression22=quantified_expression();

            state._fsp--;

            dbg.location(88,42);
            match(input,20,FOLLOW_20_in_ensure_statement630); 
            dbg.location(88,46);
            ast = new Ensure(new Position(), (Expression) quantified_expression22);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(89, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ensure_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "ensure_statement"



    // $ANTLR start "assignment"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:91:1: assignment returns [ ASTRoot ast ] : IDENT ( '[' e= expression ']' )* '=' value= expression ';' ;
    public final ASTRoot assignment() throws RecognitionException {
        ASTRoot ast = null;


        Token IDENT23=null;
        ASTRoot e =null;

        ASTRoot value =null;


        LinkedList<ArithmeticExpression> l = new LinkedList<ArithmeticExpression>();
        try { dbg.enterRule(getGrammarFileName(), "assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(91, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:93:9: ( IDENT ( '[' e= expression ']' )* '=' value= expression ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:93:11: IDENT ( '[' e= expression ']' )* '=' value= expression ';'
            {
            dbg.location(93,11);
            IDENT23=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignment670); 
            dbg.location(93,17);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:93:17: ( '[' e= expression ']' )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==27) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:93:19: '[' e= expression ']'
            	    {
            	    dbg.location(93,19);
            	    match(input,27,FOLLOW_27_in_assignment674); 
            	    dbg.location(93,24);
            	    pushFollow(FOLLOW_expression_in_assignment678);
            	    e=expression();

            	    state._fsp--;

            	    dbg.location(93,36);
            	    match(input,28,FOLLOW_28_in_assignment680); 
            	    dbg.location(93,40);
            	    if (e instanceof ArithmeticExpression) l.add((ArithmeticExpression) e);
            	            				else throw new RuntimeException("TODO");

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}

            dbg.location(94,58);
            match(input,23,FOLLOW_23_in_assignment687); 
            dbg.location(94,67);
            pushFollow(FOLLOW_expression_in_assignment691);
            value=expression();

            state._fsp--;

            dbg.location(94,79);
            match(input,20,FOLLOW_20_in_assignment693); 
            dbg.location(95,9);
            if (l.isEmpty()) ast = new Assignment(new Position(), (Expression) value, new Identifier((IDENT23!=null?IDENT23.getText():null)));
                    	else ast = new ArrayAssignment(new Position(), (Expression) value, new Identifier((IDENT23!=null?IDENT23.getText():null)),
                     					l.toArray(new ArithmeticExpression[l.size()]));

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
            dbg.exitRule(getGrammarFileName(), "assignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "assignment"



    // $ANTLR start "variable_declaration"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:100:1: variable_declaration returns [ ASTRoot ast ] : type IDENT ( '=' expression )? ';' ;
    public final ASTRoot variable_declaration() throws RecognitionException {
        ASTRoot ast = null;


        Token IDENT24=null;
        ASTRoot expression25 =null;

        Type type26 =null;


        try { dbg.enterRule(getGrammarFileName(), "variable_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(100, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:101:9: ( type IDENT ( '=' expression )? ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:101:11: type IDENT ( '=' expression )? ';'
            {
            dbg.location(101,11);
            pushFollow(FOLLOW_type_in_variable_declaration732);
            type26=type();

            state._fsp--;

            dbg.location(101,16);
            IDENT24=(Token)match(input,IDENT,FOLLOW_IDENT_in_variable_declaration734); 
            dbg.location(101,22);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:101:22: ( '=' expression )?
            int alt10=2;
            try { dbg.enterSubRule(10);
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:101:24: '=' expression
                    {
                    dbg.location(101,24);
                    match(input,23,FOLLOW_23_in_variable_declaration738); 
                    dbg.location(101,28);
                    pushFollow(FOLLOW_expression_in_variable_declaration740);
                    expression25=expression();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(10);}

            dbg.location(101,42);
            match(input,20,FOLLOW_20_in_variable_declaration745); 
            dbg.location(102,9);
            ast = new VariableDeclaration(new Position(), (IDENT24!=null?IDENT24.getText():null), (Expression) expression25, type26);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(103, 8);

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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:105:1: array_declaration returns [ ASTRoot ast ] : type IDENT ( '[' e= expression ']' )+ ';' ;
    public final ASTRoot array_declaration() throws RecognitionException {
        ASTRoot ast = null;


        Token IDENT27=null;
        ASTRoot e =null;

        Type type28 =null;


        LinkedList<ArithmeticExpression> indexes = new LinkedList<ArithmeticExpression>();
        try { dbg.enterRule(getGrammarFileName(), "array_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(105, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:107:9: ( type IDENT ( '[' e= expression ']' )+ ';' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:107:11: type IDENT ( '[' e= expression ']' )+ ';'
            {
            dbg.location(107,11);
            pushFollow(FOLLOW_type_in_array_declaration793);
            type28=type();

            state._fsp--;

            dbg.location(107,16);
            IDENT27=(Token)match(input,IDENT,FOLLOW_IDENT_in_array_declaration795); 
            dbg.location(107,22);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:107:22: ( '[' e= expression ']' )+
            int cnt11=0;
            try { dbg.enterSubRule(11);

            loop11:
            do {
                int alt11=2;
                try { dbg.enterDecision(11, decisionCanBacktrack[11]);

                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                } finally {dbg.exitDecision(11);}

                switch (alt11) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:107:24: '[' e= expression ']'
            	    {
            	    dbg.location(107,24);
            	    match(input,27,FOLLOW_27_in_array_declaration799); 
            	    dbg.location(107,29);
            	    pushFollow(FOLLOW_expression_in_array_declaration803);
            	    e=expression();

            	    state._fsp--;

            	    dbg.location(107,41);
            	    if (e instanceof ArithmeticExpression) indexes.add((ArithmeticExpression) e);
            	            				 else throw new RuntimeException("TODO");
            	    dbg.location(108,56);
            	    match(input,28,FOLLOW_28_in_array_declaration807); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt11++;
            } while (true);
            } finally {dbg.exitSubRule(11);}

            dbg.location(108,63);
            match(input,20,FOLLOW_20_in_array_declaration812); 
            dbg.location(109,9);
            ast = new ArrayDeclaration(new Position(), (IDENT27!=null?IDENT27.getText():null), type28,
                    	indexes.toArray(new ArithmeticExpression[indexes.size()]));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(111, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "array_declaration"



    // $ANTLR start "if_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:113:1: if_statement returns [ ASTRoot ast ] : 'if' '(' expression ')' s1= statement_block ( 'else' s2= statement_block )? ;
    public final ASTRoot if_statement() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot s1 =null;

        ASTRoot s2 =null;

        ASTRoot expression29 =null;


        try { dbg.enterRule(getGrammarFileName(), "if_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(113, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:114:9: ( 'if' '(' expression ')' s1= statement_block ( 'else' s2= statement_block )? )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:114:11: 'if' '(' expression ')' s1= statement_block ( 'else' s2= statement_block )?
            {
            dbg.location(114,11);
            match(input,36,FOLLOW_36_in_if_statement851); 
            dbg.location(114,16);
            match(input,13,FOLLOW_13_in_if_statement853); 
            dbg.location(114,20);
            pushFollow(FOLLOW_expression_in_if_statement855);
            expression29=expression();

            state._fsp--;

            dbg.location(114,31);
            match(input,14,FOLLOW_14_in_if_statement857); 
            dbg.location(114,37);
            pushFollow(FOLLOW_statement_block_in_if_statement861);
            s1=statement_block();

            state._fsp--;

            dbg.location(114,54);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:114:54: ( 'else' s2= statement_block )?
            int alt12=2;
            try { dbg.enterSubRule(12);
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:114:56: 'else' s2= statement_block
                    {
                    dbg.location(114,56);
                    match(input,32,FOLLOW_32_in_if_statement865); 
                    dbg.location(114,65);
                    pushFollow(FOLLOW_statement_block_in_if_statement869);
                    s2=statement_block();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(12);}

            dbg.location(115,9);
            ast = new Conditional(new Position(), (Expression) expression29,
                    	(StatementBlock) s1, (StatementBlock) s2);

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
            dbg.exitRule(getGrammarFileName(), "if_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "if_statement"



    // $ANTLR start "while_statement"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:119:1: while_statement returns [ ASTRoot ast ] : 'while' '(' expression ')' loop_body ;
    public final ASTRoot while_statement() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot expression30 =null;

        ASTRoot[][] loop_body31 =null;


        try { dbg.enterRule(getGrammarFileName(), "while_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(119, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:120:9: ( 'while' '(' expression ')' loop_body )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:120:11: 'while' '(' expression ')' loop_body
            {
            dbg.location(120,11);
            match(input,41,FOLLOW_41_in_while_statement919); 
            dbg.location(120,19);
            match(input,13,FOLLOW_13_in_while_statement921); 
            dbg.location(120,23);
            pushFollow(FOLLOW_expression_in_while_statement923);
            expression30=expression();

            state._fsp--;

            dbg.location(120,34);
            match(input,14,FOLLOW_14_in_while_statement925); 
            dbg.location(120,38);
            pushFollow(FOLLOW_loop_body_in_while_statement927);
            loop_body31=loop_body();

            state._fsp--;

            dbg.location(121,9);
            ast = new Loop(new Position(), (Expression) expression30,
                    		 (StatementBlock) loop_body31[1][0], (Invariant[]) loop_body31[0]);

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
            dbg.exitRule(getGrammarFileName(), "while_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "while_statement"



    // $ANTLR start "loop_body"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:125:1: loop_body returns [ ASTRoot[][] ast ] : '{' (i= invariant_statement )* statement_block '}' ;
    public final ASTRoot[][] loop_body() throws RecognitionException {
        ASTRoot[][] ast = null;


        ASTRoot i =null;

        ASTRoot statement_block32 =null;


        LinkedList<Invariant> is = new LinkedList<Invariant>();
        try { dbg.enterRule(getGrammarFileName(), "loop_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(125, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:127:9: ( '{' (i= invariant_statement )* statement_block '}' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:127:11: '{' (i= invariant_statement )* statement_block '}'
            {
            dbg.location(127,11);
            match(input,42,FOLLOW_42_in_loop_body975); 
            dbg.location(127,15);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:127:15: (i= invariant_statement )*
            try { dbg.enterSubRule(13);

            loop13:
            do {
                int alt13=2;
                try { dbg.enterDecision(13, decisionCanBacktrack[13]);

                int LA13_0 = input.LA(1);

                if ( (LA13_0==38) ) {
                    alt13=1;
                }


                } finally {dbg.exitDecision(13);}

                switch (alt13) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:127:16: i= invariant_statement
            	    {
            	    dbg.location(127,17);
            	    pushFollow(FOLLOW_invariant_statement_in_loop_body980);
            	    i=invariant_statement();

            	    state._fsp--;

            	    dbg.location(127,38);
            	    is.add((Invariant) i);

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);
            } finally {dbg.exitSubRule(13);}

            dbg.location(128,9);
            pushFollow(FOLLOW_statement_block_in_loop_body994);
            statement_block32=statement_block();

            state._fsp--;

            dbg.location(128,25);
            match(input,44,FOLLOW_44_in_loop_body996); 
            dbg.location(129,9);
            ast = new ASTRoot[2][];
                    ast[0] = is.toArray(new Invariant[is.size()]);
                    ast[1] = new ASTRoot[]{statement_block32};

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(132, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "loop_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "loop_body"



    // $ANTLR start "statement_block"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:134:1: statement_block returns [ ASTRoot ast ] : '{' (s= statement )* '}' ;
    public final ASTRoot statement_block() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot s =null;


        LinkedList<Statement> l = new LinkedList<Statement>();
        try { dbg.enterRule(getGrammarFileName(), "statement_block");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(134, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:136:9: ( '{' (s= statement )* '}' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:136:11: '{' (s= statement )* '}'
            {
            dbg.location(136,11);
            match(input,42,FOLLOW_42_in_statement_block1044); 
            dbg.location(136,15);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:136:15: (s= statement )*
            try { dbg.enterSubRule(14);

            loop14:
            do {
                int alt14=2;
                try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                int LA14_0 = input.LA(1);

                if ( (LA14_0==IDENT||LA14_0==29||LA14_0==31||(LA14_0 >= 36 && LA14_0 <= 37)||(LA14_0 >= 40 && LA14_0 <= 41)) ) {
                    alt14=1;
                }


                } finally {dbg.exitDecision(14);}

                switch (alt14) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:136:17: s= statement
            	    {
            	    dbg.location(136,18);
            	    pushFollow(FOLLOW_statement_in_statement_block1050);
            	    s=statement();

            	    state._fsp--;

            	    dbg.location(136,29);
            	    l.add((Statement) s);

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);
            } finally {dbg.exitSubRule(14);}

            dbg.location(136,55);
            match(input,44,FOLLOW_44_in_statement_block1056); 
            dbg.location(137,9);
            ast = new StatementBlock(l.toArray(new Statement[l.size()]), new Position());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(138, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement_block");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "statement_block"



    // $ANTLR start "quantified_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:140:1: quantified_expression returns [ ASTRoot ast ] : ( quantifier IDENT '(' ( range )? ')' qe= quantified_expression | expression );
    public final ASTRoot quantified_expression() throws RecognitionException {
        ASTRoot ast = null;


        Token IDENT35=null;
        ASTRoot qe =null;

        String quantifier33 =null;

        Range range34 =null;

        ASTRoot expression36 =null;


        try { dbg.enterRule(getGrammarFileName(), "quantified_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(140, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:141:9: ( quantifier IDENT '(' ( range )? ')' qe= quantified_expression | expression )
            int alt16=2;
            try { dbg.enterDecision(16, decisionCanBacktrack[16]);

            int LA16_0 = input.LA(1);

            if ( ((LA16_0 >= 34 && LA16_0 <= 35)) ) {
                alt16=1;
            }
            else if ( (LA16_0==BOOL_LITERAL||(LA16_0 >= IDENT && LA16_0 <= INT_LITERAL)||LA16_0==9||LA16_0==13||LA16_0==16||LA16_0==18) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(16);}

            switch (alt16) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:141:11: quantifier IDENT '(' ( range )? ')' qe= quantified_expression
                    {
                    dbg.location(141,11);
                    pushFollow(FOLLOW_quantifier_in_quantified_expression1095);
                    quantifier33=quantifier();

                    state._fsp--;

                    dbg.location(141,22);
                    IDENT35=(Token)match(input,IDENT,FOLLOW_IDENT_in_quantified_expression1097); 
                    dbg.location(141,28);
                    match(input,13,FOLLOW_13_in_quantified_expression1099); 
                    dbg.location(141,32);
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:141:32: ( range )?
                    int alt15=2;
                    try { dbg.enterSubRule(15);
                    try { dbg.enterDecision(15, decisionCanBacktrack[15]);

                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==BOOL_LITERAL||(LA15_0 >= IDENT && LA15_0 <= INT_LITERAL)||LA15_0==9||LA15_0==13||LA15_0==16||LA15_0==18) ) {
                        alt15=1;
                    }
                    } finally {dbg.exitDecision(15);}

                    switch (alt15) {
                        case 1 :
                            dbg.enterAlt(1);

                            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:141:32: range
                            {
                            dbg.location(141,32);
                            pushFollow(FOLLOW_range_in_quantified_expression1101);
                            range34=range();

                            state._fsp--;


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(15);}

                    dbg.location(141,39);
                    match(input,14,FOLLOW_14_in_quantified_expression1104); 
                    dbg.location(141,45);
                    pushFollow(FOLLOW_quantified_expression_in_quantified_expression1108);
                    qe=quantified_expression();

                    state._fsp--;

                    dbg.location(142,9);
                    if ("forall".equals(quantifier33)) ast = new ForAllQuantifier(new Position(), range34,
                           						 new Identifier((IDENT35!=null?IDENT35.getText():null)), (Expression) qe);
                       	 else ast = new ExistsQuantifier(new Position(), range34, new Identifier((IDENT35!=null?IDENT35.getText():null)), 
                            				   (Expression) qe);

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:146:11: expression
                    {
                    dbg.location(146,11);
                    pushFollow(FOLLOW_expression_in_quantified_expression1130);
                    expression36=expression();

                    state._fsp--;

                    dbg.location(146,22);
                    ast = expression36;

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
        dbg.location(147, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "quantified_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "quantified_expression"



    // $ANTLR start "quantifier"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:149:1: quantifier returns [ String text ] : ( 'forall' | 'exists' );
    public final String quantifier() throws RecognitionException {
        String text = null;


        try { dbg.enterRule(getGrammarFileName(), "quantifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(149, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:150:9: ( 'forall' | 'exists' )
            int alt17=2;
            try { dbg.enterDecision(17, decisionCanBacktrack[17]);

            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            else if ( (LA17_0==34) ) {
                alt17=2;
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

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:150:11: 'forall'
                    {
                    dbg.location(150,11);
                    match(input,35,FOLLOW_35_in_quantifier1161); 
                    dbg.location(150,20);
                    text = "forall";

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:151:11: 'exists'
                    {
                    dbg.location(151,11);
                    match(input,34,FOLLOW_34_in_quantifier1175); 
                    dbg.location(151,20);
                    text = "exists";

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
        dbg.location(152, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "quantifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return text;
    }
    // $ANTLR end "quantifier"



    // $ANTLR start "range"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:154:1: range returns [ Range range ] : l= expression ',' u= expression ;
    public final Range range() throws RecognitionException {
        Range range = null;


        ASTRoot l =null;

        ASTRoot u =null;


        try { dbg.enterRule(getGrammarFileName(), "range");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(154, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:155:9: (l= expression ',' u= expression )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:155:11: l= expression ',' u= expression
            {
            dbg.location(155,12);
            pushFollow(FOLLOW_expression_in_range1208);
            l=expression();

            state._fsp--;

            dbg.location(155,24);
            match(input,17,FOLLOW_17_in_range1210); 
            dbg.location(155,29);
            pushFollow(FOLLOW_expression_in_range1214);
            u=expression();

            state._fsp--;

            dbg.location(155,41);
            range = new Range((Expression) l, (Expression) u);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(156, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "range");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return range;
    }
    // $ANTLR end "range"



    // $ANTLR start "expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:158:1: expression returns [ ASTRoot ast ] : r1= rel_expression ( ( '==' | '!=' ) r2= rel_expression )* ;
    public final ASTRoot expression() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot r1 =null;

        ASTRoot r2 =null;


        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(158, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:159:9: (r1= rel_expression ( ( '==' | '!=' ) r2= rel_expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:159:11: r1= rel_expression ( ( '==' | '!=' ) r2= rel_expression )*
            {
            dbg.location(159,13);
            pushFollow(FOLLOW_rel_expression_in_expression1247);
            r1=rel_expression();

            state._fsp--;

            dbg.location(159,29);
            ast = r1;
            dbg.location(160,9);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:160:9: ( ( '==' | '!=' ) r2= rel_expression )*
            try { dbg.enterSubRule(19);

            loop19:
            do {
                int alt19=2;
                try { dbg.enterDecision(19, decisionCanBacktrack[19]);

                int LA19_0 = input.LA(1);

                if ( (LA19_0==10||LA19_0==24) ) {
                    alt19=1;
                }


                } finally {dbg.exitDecision(19);}

                switch (alt19) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:160:11: ( '==' | '!=' ) r2= rel_expression
            	    {
            	    dbg.location(160,11);
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:160:11: ( '==' | '!=' )
            	    int alt18=2;
            	    try { dbg.enterSubRule(18);
            	    try { dbg.enterDecision(18, decisionCanBacktrack[18]);

            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==24) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==10) ) {
            	        alt18=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }
            	    } finally {dbg.exitDecision(18);}

            	    switch (alt18) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:160:13: '=='
            	            {
            	            dbg.location(160,13);
            	            match(input,24,FOLLOW_24_in_expression1263); 
            	            dbg.location(160,18);
            	            ast = new LogicalExpression(new Position(), (Expression) ast,
            	                    	(Expression) r2, new Equal());

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:162:11: '!='
            	            {
            	            dbg.location(162,11);
            	            match(input,10,FOLLOW_10_in_expression1277); 
            	            dbg.location(162,16);
            	            ast = new LogicalExpression(new Position(), (Expression) ast,
            	                    	(Expression) r2, new NotEqual());

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(18);}

            	    dbg.location(164,11);
            	    pushFollow(FOLLOW_rel_expression_in_expression1292);
            	    r2=rel_expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);
            } finally {dbg.exitSubRule(19);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(165, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "expression"



    // $ANTLR start "rel_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:168:1: rel_expression returns [ ASTRoot ast ] : a1= add_expression ( ( '<' | '<=' | '>' | '>=' ) a2= add_expression )* ;
    public final ASTRoot rel_expression() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot a1 =null;

        ASTRoot a2 =null;


        try { dbg.enterRule(getGrammarFileName(), "rel_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(168, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:169:9: (a1= add_expression ( ( '<' | '<=' | '>' | '>=' ) a2= add_expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:169:11: a1= add_expression ( ( '<' | '<=' | '>' | '>=' ) a2= add_expression )*
            {
            dbg.location(169,13);
            pushFollow(FOLLOW_add_expression_in_rel_expression1327);
            a1=add_expression();

            state._fsp--;

            dbg.location(169,29);
            ast = a1;
            dbg.location(170,9);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:170:9: ( ( '<' | '<=' | '>' | '>=' ) a2= add_expression )*
            try { dbg.enterSubRule(21);

            loop21:
            do {
                int alt21=2;
                try { dbg.enterDecision(21, decisionCanBacktrack[21]);

                int LA21_0 = input.LA(1);

                if ( ((LA21_0 >= 21 && LA21_0 <= 22)||(LA21_0 >= 25 && LA21_0 <= 26)) ) {
                    alt21=1;
                }


                } finally {dbg.exitDecision(21);}

                switch (alt21) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:170:11: ( '<' | '<=' | '>' | '>=' ) a2= add_expression
            	    {
            	    dbg.location(170,11);
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:170:11: ( '<' | '<=' | '>' | '>=' )
            	    int alt20=4;
            	    try { dbg.enterSubRule(20);
            	    try { dbg.enterDecision(20, decisionCanBacktrack[20]);

            	    switch ( input.LA(1) ) {
            	    case 21:
            	        {
            	        alt20=1;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt20=2;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt20=3;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt20=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }

            	    } finally {dbg.exitDecision(20);}

            	    switch (alt20) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:170:13: '<'
            	            {
            	            dbg.location(170,13);
            	            match(input,21,FOLLOW_21_in_rel_expression1343); 
            	            dbg.location(170,17);
            	            ast = new LogicalExpression(new Position(), (Expression) ast,
            	                    	(Expression) a2, new Less());

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:172:11: '<='
            	            {
            	            dbg.location(172,11);
            	            match(input,22,FOLLOW_22_in_rel_expression1357); 
            	            dbg.location(172,16);
            	            ast = new LogicalExpression(new Position(), (Expression) ast,
            	                    	(Expression) a2, new LessEqual());

            	            }
            	            break;
            	        case 3 :
            	            dbg.enterAlt(3);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:174:11: '>'
            	            {
            	            dbg.location(174,11);
            	            match(input,25,FOLLOW_25_in_rel_expression1371); 
            	            dbg.location(174,15);
            	            ast = new LogicalExpression(new Position(), (Expression) ast,
            	                    	(Expression) a2, new Greater());

            	            }
            	            break;
            	        case 4 :
            	            dbg.enterAlt(4);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:176:11: '>='
            	            {
            	            dbg.location(176,11);
            	            match(input,26,FOLLOW_26_in_rel_expression1385); 
            	            dbg.location(176,16);
            	            ast = new LogicalExpression(new Position(), (Expression) ast,
            	                    	(Expression) a2, new GreaterEqual());

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(20);}

            	    dbg.location(178,11);
            	    pushFollow(FOLLOW_add_expression_in_rel_expression1400);
            	    a2=add_expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);
            } finally {dbg.exitSubRule(21);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(179, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "rel_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "rel_expression"



    // $ANTLR start "add_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:181:1: add_expression returns [ ASTRoot ast ] : m1= mul_expression ( ( '|' | '+' | '-' ) m2= mul_expression )* ;
    public final ASTRoot add_expression() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot m1 =null;

        ASTRoot m2 =null;


        try { dbg.enterRule(getGrammarFileName(), "add_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(181, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:182:9: (m1= mul_expression ( ( '|' | '+' | '-' ) m2= mul_expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:182:11: m1= mul_expression ( ( '|' | '+' | '-' ) m2= mul_expression )*
            {
            dbg.location(182,13);
            pushFollow(FOLLOW_mul_expression_in_add_expression1434);
            m1=mul_expression();

            state._fsp--;

            dbg.location(182,29);
            ast = m1;
            dbg.location(183,9);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:183:9: ( ( '|' | '+' | '-' ) m2= mul_expression )*
            try { dbg.enterSubRule(23);

            loop23:
            do {
                int alt23=2;
                try { dbg.enterDecision(23, decisionCanBacktrack[23]);

                int LA23_0 = input.LA(1);

                if ( (LA23_0==16||LA23_0==18||LA23_0==43) ) {
                    alt23=1;
                }


                } finally {dbg.exitDecision(23);}

                switch (alt23) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:183:11: ( '|' | '+' | '-' ) m2= mul_expression
            	    {
            	    dbg.location(183,11);
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:183:11: ( '|' | '+' | '-' )
            	    int alt22=3;
            	    try { dbg.enterSubRule(22);
            	    try { dbg.enterDecision(22, decisionCanBacktrack[22]);

            	    switch ( input.LA(1) ) {
            	    case 43:
            	        {
            	        alt22=1;
            	        }
            	        break;
            	    case 16:
            	        {
            	        alt22=2;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt22=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }

            	    } finally {dbg.exitDecision(22);}

            	    switch (alt22) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:183:13: '|'
            	            {
            	            dbg.location(183,13);
            	            match(input,43,FOLLOW_43_in_add_expression1450); 
            	            dbg.location(183,17);
            	            ast = new LogicalExpression(new Position(), (Expression) ast,
            	                    	(Expression) m2, new Disjunction());

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:185:11: '+'
            	            {
            	            dbg.location(185,11);
            	            match(input,16,FOLLOW_16_in_add_expression1464); 
            	            dbg.location(185,15);
            	            ast = new ArithmeticExpression(new Position(), (Expression) ast,
            	                    	(Expression) m2, new Addition());

            	            }
            	            break;
            	        case 3 :
            	            dbg.enterAlt(3);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:187:11: '-'
            	            {
            	            dbg.location(187,11);
            	            match(input,18,FOLLOW_18_in_add_expression1478); 
            	            dbg.location(187,15);
            	            ast = new ArithmeticExpression(new Position(), (Expression) ast,
            	                    	(Expression) m2, new Subtraction());

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(22);}

            	    dbg.location(189,11);
            	    pushFollow(FOLLOW_mul_expression_in_add_expression1493);
            	    m2=mul_expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
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
        dbg.location(190, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "add_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "add_expression"



    // $ANTLR start "mul_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:192:1: mul_expression returns [ ASTRoot ast ] : u1= unary_expression ( ( '&' | '*' | '/' | '%' ) u2= unary_expression )* ;
    public final ASTRoot mul_expression() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot u1 =null;

        ASTRoot u2 =null;


        try { dbg.enterRule(getGrammarFileName(), "mul_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(192, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:193:9: (u1= unary_expression ( ( '&' | '*' | '/' | '%' ) u2= unary_expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:193:11: u1= unary_expression ( ( '&' | '*' | '/' | '%' ) u2= unary_expression )*
            {
            dbg.location(193,13);
            pushFollow(FOLLOW_unary_expression_in_mul_expression1527);
            u1=unary_expression();

            state._fsp--;

            dbg.location(193,31);
            ast = u1;
            dbg.location(194,9);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:194:9: ( ( '&' | '*' | '/' | '%' ) u2= unary_expression )*
            try { dbg.enterSubRule(25);

            loop25:
            do {
                int alt25=2;
                try { dbg.enterDecision(25, decisionCanBacktrack[25]);

                int LA25_0 = input.LA(1);

                if ( ((LA25_0 >= 11 && LA25_0 <= 12)||LA25_0==15||LA25_0==19) ) {
                    alt25=1;
                }


                } finally {dbg.exitDecision(25);}

                switch (alt25) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:194:11: ( '&' | '*' | '/' | '%' ) u2= unary_expression
            	    {
            	    dbg.location(194,11);
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:194:11: ( '&' | '*' | '/' | '%' )
            	    int alt24=4;
            	    try { dbg.enterSubRule(24);
            	    try { dbg.enterDecision(24, decisionCanBacktrack[24]);

            	    switch ( input.LA(1) ) {
            	    case 12:
            	        {
            	        alt24=1;
            	        }
            	        break;
            	    case 15:
            	        {
            	        alt24=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt24=3;
            	        }
            	        break;
            	    case 11:
            	        {
            	        alt24=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }

            	    } finally {dbg.exitDecision(24);}

            	    switch (alt24) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:194:12: '&'
            	            {
            	            dbg.location(194,12);
            	            match(input,12,FOLLOW_12_in_mul_expression1542); 
            	            dbg.location(194,16);
            	            ast = new LogicalExpression(new Position(), (Expression) ast,
            	                    	(Expression) u2, new Conjunction());

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:196:11: '*'
            	            {
            	            dbg.location(196,11);
            	            match(input,15,FOLLOW_15_in_mul_expression1556); 
            	            dbg.location(196,15);
            	            ast = new ArithmeticExpression(new Position(), (Expression) ast,
            	                    	(Expression) u2, new Multiplication());

            	            }
            	            break;
            	        case 3 :
            	            dbg.enterAlt(3);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:198:11: '/'
            	            {
            	            dbg.location(198,11);
            	            match(input,19,FOLLOW_19_in_mul_expression1570); 
            	            dbg.location(198,15);
            	            ast = new ArithmeticExpression(new Position(), (Expression) ast,
            	                    	(Expression) u2, new Division());

            	            }
            	            break;
            	        case 4 :
            	            dbg.enterAlt(4);

            	            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:200:11: '%'
            	            {
            	            dbg.location(200,11);
            	            match(input,11,FOLLOW_11_in_mul_expression1584); 
            	            dbg.location(200,15);
            	            ast = new ArithmeticExpression(new Position(), (Expression) ast,
            	                    	(Expression) u2, new Modulo());

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(24);}

            	    dbg.location(202,11);
            	    pushFollow(FOLLOW_unary_expression_in_mul_expression1599);
            	    u2=unary_expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);
            } finally {dbg.exitSubRule(25);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(203, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mul_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "mul_expression"



    // $ANTLR start "unary_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:205:1: unary_expression returns [ ASTRoot ast ] : ( '!' | '+' | '-' )? parenthesized_expression ;
    public final ASTRoot unary_expression() throws RecognitionException {
        ASTRoot ast = null;


        ASTRoot parenthesized_expression37 =null;


        boolean isLogical = false; ArithmeticOperator op = null;
        try { dbg.enterRule(getGrammarFileName(), "unary_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(205, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:207:9: ( ( '!' | '+' | '-' )? parenthesized_expression )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:207:11: ( '!' | '+' | '-' )? parenthesized_expression
            {
            dbg.location(207,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:207:11: ( '!' | '+' | '-' )?
            int alt26=4;
            try { dbg.enterSubRule(26);
            try { dbg.enterDecision(26, decisionCanBacktrack[26]);

            switch ( input.LA(1) ) {
                case 9:
                    {
                    alt26=1;
                    }
                    break;
                case 16:
                    {
                    alt26=2;
                    }
                    break;
                case 18:
                    {
                    alt26=3;
                    }
                    break;
            }

            } finally {dbg.exitDecision(26);}

            switch (alt26) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:207:13: '!'
                    {
                    dbg.location(207,13);
                    match(input,9,FOLLOW_9_in_unary_expression1642); 
                    dbg.location(207,17);
                    isLogical = true;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:208:11: '+'
                    {
                    dbg.location(208,11);
                    match(input,16,FOLLOW_16_in_unary_expression1656); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:209:11: '-'
                    {
                    dbg.location(209,11);
                    match(input,18,FOLLOW_18_in_unary_expression1668); 
                    dbg.location(209,15);
                    op = new UnaryMinus();

                    }
                    break;

            }
            } finally {dbg.exitSubRule(26);}

            dbg.location(210,9);
            pushFollow(FOLLOW_parenthesized_expression_in_unary_expression1682);
            parenthesized_expression37=parenthesized_expression();

            state._fsp--;

            dbg.location(211,9);
            if (isLogical) ast = new LogicalExpression(new Position(), (Expression) parenthesized_expression37, null, new Negation());
                    else if (op != null) ast = new ArithmeticExpression(new Position(), (Expression) parenthesized_expression37, null, op);
                    else ast = parenthesized_expression37;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(214, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "unary_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "unary_expression"



    // $ANTLR start "parenthesized_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:216:1: parenthesized_expression returns [ ASTRoot ast ] : ( '(' expression ')' | function_call | array_read | IDENT | literal_expression );
    public final ASTRoot parenthesized_expression() throws RecognitionException {
        ASTRoot ast = null;


        Token IDENT41=null;
        ASTRoot expression38 =null;

        ASTRoot function_call39 =null;

        ASTRoot array_read40 =null;

        ASTRoot literal_expression42 =null;


        try { dbg.enterRule(getGrammarFileName(), "parenthesized_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(216, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:217:9: ( '(' expression ')' | function_call | array_read | IDENT | literal_expression )
            int alt27=5;
            try { dbg.enterDecision(27, decisionCanBacktrack[27]);

            switch ( input.LA(1) ) {
            case 13:
                {
                alt27=1;
                }
                break;
            case IDENT:
                {
                switch ( input.LA(2) ) {
                case 13:
                    {
                    alt27=2;
                    }
                    break;
                case 27:
                    {
                    alt27=3;
                    }
                    break;
                case EOF:
                case 10:
                case 11:
                case 12:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 24:
                case 25:
                case 26:
                case 28:
                case 43:
                    {
                    alt27=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }

                }
                break;
            case BOOL_LITERAL:
            case INT_LITERAL:
                {
                alt27=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(27);}

            switch (alt27) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:217:11: '(' expression ')'
                    {
                    dbg.location(217,11);
                    match(input,13,FOLLOW_13_in_parenthesized_expression1721); 
                    dbg.location(217,15);
                    pushFollow(FOLLOW_expression_in_parenthesized_expression1723);
                    expression38=expression();

                    state._fsp--;

                    dbg.location(217,26);
                    match(input,14,FOLLOW_14_in_parenthesized_expression1725); 
                    dbg.location(217,30);
                    ast = expression38;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:218:11: function_call
                    {
                    dbg.location(218,11);
                    pushFollow(FOLLOW_function_call_in_parenthesized_expression1739);
                    function_call39=function_call();

                    state._fsp--;

                    dbg.location(218,25);
                    ast = function_call39;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:219:11: array_read
                    {
                    dbg.location(219,11);
                    pushFollow(FOLLOW_array_read_in_parenthesized_expression1753);
                    array_read40=array_read();

                    state._fsp--;

                    dbg.location(219,22);
                    ast = array_read40;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:220:11: IDENT
                    {
                    dbg.location(220,11);
                    IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_parenthesized_expression1767); 
                    dbg.location(220,17);
                    ast = new VariableRead(new Position(), new Identifier((IDENT41!=null?IDENT41.getText():null)));

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:221:11: literal_expression
                    {
                    dbg.location(221,11);
                    pushFollow(FOLLOW_literal_expression_in_parenthesized_expression1781);
                    literal_expression42=literal_expression();

                    state._fsp--;

                    dbg.location(221,30);
                    ast = literal_expression42;

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
        dbg.location(222, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parenthesized_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "parenthesized_expression"



    // $ANTLR start "function_call"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:224:1: function_call returns [ ASTRoot ast ] : IDENT '(' ( arglist )? ')' ;
    public final ASTRoot function_call() throws RecognitionException {
        ASTRoot ast = null;


        Token IDENT44=null;
        LinkedList<Expression> arglist43 =null;


        try { dbg.enterRule(getGrammarFileName(), "function_call");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(224, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:225:9: ( IDENT '(' ( arglist )? ')' )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:225:11: IDENT '(' ( arglist )? ')'
            {
            dbg.location(225,11);
            IDENT44=(Token)match(input,IDENT,FOLLOW_IDENT_in_function_call1812); 
            dbg.location(225,17);
            match(input,13,FOLLOW_13_in_function_call1814); 
            dbg.location(225,21);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:225:21: ( arglist )?
            int alt28=2;
            try { dbg.enterSubRule(28);
            try { dbg.enterDecision(28, decisionCanBacktrack[28]);

            int LA28_0 = input.LA(1);

            if ( (LA28_0==BOOL_LITERAL||(LA28_0 >= IDENT && LA28_0 <= INT_LITERAL)||LA28_0==9||LA28_0==13||LA28_0==16||LA28_0==18) ) {
                alt28=1;
            }
            } finally {dbg.exitDecision(28);}

            switch (alt28) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:225:21: arglist
                    {
                    dbg.location(225,21);
                    pushFollow(FOLLOW_arglist_in_function_call1816);
                    arglist43=arglist();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(28);}

            dbg.location(225,30);
            match(input,14,FOLLOW_14_in_function_call1819); 
            dbg.location(225,34);

                    	Expression[] params = new Expression[0];
                    	if (arglist43 != null) params = arglist43.toArray(new Expression[arglist43.size()]);
                    	ast = new FunctionCall(new Identifier((IDENT44!=null?IDENT44.getText():null)), params , new Position());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(229, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function_call");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "function_call"



    // $ANTLR start "arglist"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:231:1: arglist returns [ LinkedList<Expression> params ] : e1= expression ( ',' e2= expression )* ;
    public final LinkedList<Expression> arglist() throws RecognitionException {
        LinkedList<Expression> params = null;


        ASTRoot e1 =null;

        ASTRoot e2 =null;


        params = new LinkedList<Expression>();
        try { dbg.enterRule(getGrammarFileName(), "arglist");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(231, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:233:9: (e1= expression ( ',' e2= expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:233:11: e1= expression ( ',' e2= expression )*
            {
            dbg.location(233,13);
            pushFollow(FOLLOW_expression_in_arglist1858);
            e1=expression();

            state._fsp--;

            dbg.location(233,25);
            params.add((Expression) e1);
            dbg.location(233,56);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:233:56: ( ',' e2= expression )*
            try { dbg.enterSubRule(29);

            loop29:
            do {
                int alt29=2;
                try { dbg.enterDecision(29, decisionCanBacktrack[29]);

                int LA29_0 = input.LA(1);

                if ( (LA29_0==17) ) {
                    alt29=1;
                }


                } finally {dbg.exitDecision(29);}

                switch (alt29) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:233:58: ',' e2= expression
            	    {
            	    dbg.location(233,58);
            	    match(input,17,FOLLOW_17_in_arglist1864); 
            	    dbg.location(233,64);
            	    pushFollow(FOLLOW_expression_in_arglist1868);
            	    e2=expression();

            	    state._fsp--;

            	    dbg.location(233,76);
            	    params.add((Expression) e2);

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);
            } finally {dbg.exitSubRule(29);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(234, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "arglist");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return params;
    }
    // $ANTLR end "arglist"



    // $ANTLR start "array_read"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:236:1: array_read returns [ ASTRoot ast ] : IDENT '[' e1= expression ']' ( '[' e2= expression ']' )* ;
    public final ASTRoot array_read() throws RecognitionException {
        ASTRoot ast = null;


        Token IDENT45=null;
        ASTRoot e1 =null;

        ASTRoot e2 =null;


        LinkedList<ArithmeticExpression> l = new LinkedList<ArithmeticExpression>();
        try { dbg.enterRule(getGrammarFileName(), "array_read");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(236, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:238:9: ( IDENT '[' e1= expression ']' ( '[' e2= expression ']' )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:238:11: IDENT '[' e1= expression ']' ( '[' e2= expression ']' )*
            {
            dbg.location(238,11);
            IDENT45=(Token)match(input,IDENT,FOLLOW_IDENT_in_array_read1908); 
            dbg.location(238,17);
            match(input,27,FOLLOW_27_in_array_read1910); 
            dbg.location(238,23);
            pushFollow(FOLLOW_expression_in_array_read1914);
            e1=expression();

            state._fsp--;

            dbg.location(238,35);
            if (e1 instanceof ArithmeticExpression) l.add((ArithmeticExpression)e1);
                    				else throw new RuntimeException("TODO");
            dbg.location(239,55);
            match(input,28,FOLLOW_28_in_array_read1918); 
            dbg.location(240,10);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:240:10: ( '[' e2= expression ']' )*
            try { dbg.enterSubRule(30);

            loop30:
            do {
                int alt30=2;
                try { dbg.enterDecision(30, decisionCanBacktrack[30]);

                int LA30_0 = input.LA(1);

                if ( (LA30_0==27) ) {
                    alt30=1;
                }


                } finally {dbg.exitDecision(30);}

                switch (alt30) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:240:12: '[' e2= expression ']'
            	    {
            	    dbg.location(240,12);
            	    match(input,27,FOLLOW_27_in_array_read1932); 
            	    dbg.location(240,18);
            	    pushFollow(FOLLOW_expression_in_array_read1936);
            	    e2=expression();

            	    state._fsp--;

            	    dbg.location(240,30);
            	    if (e2 instanceof ArithmeticExpression) l.add((ArithmeticExpression)e2);
            	            				else throw new RuntimeException("TODO");
            	    dbg.location(241,55);
            	    match(input,28,FOLLOW_28_in_array_read1940); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);
            } finally {dbg.exitSubRule(30);}

            dbg.location(242,9);
            ast = new ArrayRead(new Position(), new Identifier((IDENT45!=null?IDENT45.getText():null)), l.toArray(new ArithmeticExpression[l.size()]));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(243, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_read");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "array_read"



    // $ANTLR start "literal_expression"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:245:1: literal_expression returns [ ASTRoot ast ] : ( INT_LITERAL | BOOL_LITERAL );
    public final ASTRoot literal_expression() throws RecognitionException {
        ASTRoot ast = null;


        Token INT_LITERAL46=null;
        Token BOOL_LITERAL47=null;

        try { dbg.enterRule(getGrammarFileName(), "literal_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(245, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:246:9: ( INT_LITERAL | BOOL_LITERAL )
            int alt31=2;
            try { dbg.enterDecision(31, decisionCanBacktrack[31]);

            int LA31_0 = input.LA(1);

            if ( (LA31_0==INT_LITERAL) ) {
                alt31=1;
            }
            else if ( (LA31_0==BOOL_LITERAL) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(31);}

            switch (alt31) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:246:11: INT_LITERAL
                    {
                    dbg.location(246,11);
                    INT_LITERAL46=(Token)match(input,INT_LITERAL,FOLLOW_INT_LITERAL_in_literal_expression1983); 
                    dbg.location(246,23);
                    ast = new NumericLiteral(new Position(), (INT_LITERAL46!=null?INT_LITERAL46.getText():null));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:247:11: BOOL_LITERAL
                    {
                    dbg.location(247,11);
                    BOOL_LITERAL47=(Token)match(input,BOOL_LITERAL,FOLLOW_BOOL_LITERAL_in_literal_expression1997); 
                    dbg.location(247,24);
                    ast = new BooleanLiteral(new Position(), (BOOL_LITERAL47!=null?BOOL_LITERAL47.getText():null));

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
        dbg.location(248, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "literal_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ast;
    }
    // $ANTLR end "literal_expression"



    // $ANTLR start "type"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:250:1: type returns [ Type type ] : ( 'int' | 'bool' ) ( '[' ']' )* ;
    public final Type type() throws RecognitionException {
        Type type = null;


        try { dbg.enterRule(getGrammarFileName(), "type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(250, 0);

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:251:9: ( ( 'int' | 'bool' ) ( '[' ']' )* )
            dbg.enterAlt(1);

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:251:11: ( 'int' | 'bool' ) ( '[' ']' )*
            {
            dbg.location(251,11);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:251:11: ( 'int' | 'bool' )
            int alt32=2;
            try { dbg.enterSubRule(32);
            try { dbg.enterDecision(32, decisionCanBacktrack[32]);

            int LA32_0 = input.LA(1);

            if ( (LA32_0==37) ) {
                alt32=1;
            }
            else if ( (LA32_0==31) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(32);}

            switch (alt32) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:251:12: 'int'
                    {
                    dbg.location(251,12);
                    match(input,37,FOLLOW_37_in_type2029); 
                    dbg.location(251,18);
                    type = new IntegerType();

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:251:49: 'bool'
                    {
                    dbg.location(251,49);
                    match(input,31,FOLLOW_31_in_type2035); 
                    dbg.location(251,55);
                    type = new BooleanType();

                    }
                    break;

            }
            } finally {dbg.exitSubRule(32);}

            dbg.location(251,85);
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:251:85: ( '[' ']' )*
            try { dbg.enterSubRule(33);

            loop33:
            do {
                int alt33=2;
                try { dbg.enterDecision(33, decisionCanBacktrack[33]);

                int LA33_0 = input.LA(1);

                if ( (LA33_0==27) ) {
                    alt33=1;
                }


                } finally {dbg.exitDecision(33);}

                switch (alt33) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:251:87: '[' ']'
            	    {
            	    dbg.location(251,87);
            	    match(input,27,FOLLOW_27_in_type2041); 
            	    dbg.location(251,91);
            	    match(input,28,FOLLOW_28_in_type2043); 
            	    dbg.location(251,95);
            	    type = new ArrayType(type);

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);
            } finally {dbg.exitSubRule(33);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(252, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return type;
    }
    // $ANTLR end "type"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\15\uffff";
    static final String DFA8_eofS =
        "\15\uffff";
    static final String DFA8_minS =
        "\1\6\1\uffff\2\6\4\uffff\1\34\1\24\1\6\2\uffff";
    static final String DFA8_maxS =
        "\1\51\1\uffff\2\33\4\uffff\1\34\2\33\2\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\6\1\7\3\uffff\1\2\1\3";
    static final String DFA8_specialS =
        "\15\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\4\26\uffff\1\1\1\uffff\1\3\4\uffff\1\5\1\2\2\uffff\1\7\1"+
            "\6",
            "",
            "\1\11\24\uffff\1\10",
            "\1\11\24\uffff\1\10",
            "",
            "",
            "",
            "",
            "\1\12",
            "\1\13\2\uffff\1\13\3\uffff\1\14",
            "\1\11\24\uffff\1\10",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "65:1: statement returns [ ASTRoot ast ] : ( assert_statement | variable_declaration | array_declaration | assignment | if_statement | while_statement | 'return' expression ';' );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_assume_statement_in_program49 = new BitSet(new long[]{0x000000A0C0000000L});
    public static final BitSet FOLLOW_method_declaration_in_program67 = new BitSet(new long[]{0x000000A080000000L});
    public static final BitSet FOLLOW_main_method_in_program74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_single_expression106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_method_declaration130 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_method_declaration132 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_method_declaration134 = new BitSet(new long[]{0x0000002080004000L});
    public static final BitSet FOLLOW_parameter_list_in_method_declaration136 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_method_declaration139 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_method_body_in_method_declaration141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_main_method180 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_main_method182 = new BitSet(new long[]{0x0000002080004000L});
    public static final BitSet FOLLOW_parameter_list_in_main_method184 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_main_method187 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_method_body_in_main_method189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_parameter_list239 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parameter_list245 = new BitSet(new long[]{0x0000002080000000L});
    public static final BitSet FOLLOW_parameter_in_parameter_list249 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_type_in_parameter282 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_parameter284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_method_body324 = new BitSet(new long[]{0x0000040040000000L});
    public static final BitSet FOLLOW_assume_statement_in_method_body329 = new BitSet(new long[]{0x0000040040000000L});
    public static final BitSet FOLLOW_statement_block_in_method_body343 = new BitSet(new long[]{0x0000100200000000L});
    public static final BitSet FOLLOW_ensure_statement_in_method_body357 = new BitSet(new long[]{0x0000100200000000L});
    public static final BitSet FOLLOW_44_in_method_body363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_declaration_in_statement416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_declaration_in_statement430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_statement486 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_statement488 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_statement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_invariant_statement521 = new BitSet(new long[]{0x0000000C000522D0L});
    public static final BitSet FOLLOW_quantified_expression_in_invariant_statement523 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_invariant_statement525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_assert_statement556 = new BitSet(new long[]{0x0000000C000522D0L});
    public static final BitSet FOLLOW_quantified_expression_in_assert_statement558 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assert_statement560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_assume_statement591 = new BitSet(new long[]{0x0000000C000522D0L});
    public static final BitSet FOLLOW_quantified_expression_in_assume_statement593 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assume_statement595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ensure_statement626 = new BitSet(new long[]{0x0000000C000522D0L});
    public static final BitSet FOLLOW_quantified_expression_in_ensure_statement628 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ensure_statement630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignment670 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_27_in_assignment674 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_assignment678 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_assignment680 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_23_in_assignment687 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_assignment691 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assignment693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_variable_declaration732 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_variable_declaration734 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_23_in_variable_declaration738 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_variable_declaration740 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_variable_declaration745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_array_declaration793 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_array_declaration795 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_array_declaration799 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_array_declaration803 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_declaration807 = new BitSet(new long[]{0x0000000008100000L});
    public static final BitSet FOLLOW_20_in_array_declaration812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_if_statement851 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_if_statement853 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_if_statement855 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_statement857 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_statement_block_in_if_statement861 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_if_statement865 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_statement_block_in_if_statement869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_while_statement919 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_while_statement921 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_while_statement923 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_statement925 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_loop_body_in_while_statement927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_loop_body975 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_invariant_statement_in_loop_body980 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_statement_block_in_loop_body994 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_loop_body996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_statement_block1044 = new BitSet(new long[]{0x00001330A0000040L});
    public static final BitSet FOLLOW_statement_in_statement_block1050 = new BitSet(new long[]{0x00001330A0000040L});
    public static final BitSet FOLLOW_44_in_statement_block1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quantifier_in_quantified_expression1095 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_quantified_expression1097 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_quantified_expression1099 = new BitSet(new long[]{0x00000000000562D0L});
    public static final BitSet FOLLOW_range_in_quantified_expression1101 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_quantified_expression1104 = new BitSet(new long[]{0x0000000C000522D0L});
    public static final BitSet FOLLOW_quantified_expression_in_quantified_expression1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_quantified_expression1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_quantifier1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_quantifier1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_range1208 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_range1210 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_range1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_expression_in_expression1247 = new BitSet(new long[]{0x0000000001000402L});
    public static final BitSet FOLLOW_24_in_expression1263 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_10_in_expression1277 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_rel_expression_in_expression1292 = new BitSet(new long[]{0x0000000001000402L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1327 = new BitSet(new long[]{0x0000000006600002L});
    public static final BitSet FOLLOW_21_in_rel_expression1343 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_22_in_rel_expression1357 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_25_in_rel_expression1371 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_26_in_rel_expression1385 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression1400 = new BitSet(new long[]{0x0000000006600002L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1434 = new BitSet(new long[]{0x0000080000050002L});
    public static final BitSet FOLLOW_43_in_add_expression1450 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_16_in_add_expression1464 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_18_in_add_expression1478 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression1493 = new BitSet(new long[]{0x0000080000050002L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1527 = new BitSet(new long[]{0x0000000000089802L});
    public static final BitSet FOLLOW_12_in_mul_expression1542 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_15_in_mul_expression1556 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_19_in_mul_expression1570 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_11_in_mul_expression1584 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression1599 = new BitSet(new long[]{0x0000000000089802L});
    public static final BitSet FOLLOW_9_in_unary_expression1642 = new BitSet(new long[]{0x00000000000020D0L});
    public static final BitSet FOLLOW_16_in_unary_expression1656 = new BitSet(new long[]{0x00000000000020D0L});
    public static final BitSet FOLLOW_18_in_unary_expression1668 = new BitSet(new long[]{0x00000000000020D0L});
    public static final BitSet FOLLOW_parenthesized_expression_in_unary_expression1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parenthesized_expression1721 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_parenthesized_expression1723 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parenthesized_expression1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_parenthesized_expression1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_read_in_parenthesized_expression1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_parenthesized_expression1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_expression_in_parenthesized_expression1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_function_call1812 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_function_call1814 = new BitSet(new long[]{0x00000000000562D0L});
    public static final BitSet FOLLOW_arglist_in_function_call1816 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_function_call1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_arglist1858 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_arglist1864 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_arglist1868 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_IDENT_in_array_read1908 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_array_read1910 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_array_read1914 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_read1918 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_array_read1932 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_array_read1936 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_read1940 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_INT_LITERAL_in_literal_expression1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_LITERAL_in_literal_expression1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_type2029 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_31_in_type2035 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_type2041 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_type2043 = new BitSet(new long[]{0x0000000008000002L});

}