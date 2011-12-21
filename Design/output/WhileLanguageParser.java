// $ANTLR 3.4 /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g 2011-12-14 12:23:11

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class WhileLanguageParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL_LITERAL", "COMMENT", "IDENT", "INT_LITERAL", "WS", "'!'", "'!='", "'%'", "'&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'assert'", "'assume'", "'bool'", "'else'", "'ensure'", "'if'", "'int'", "'invariant'", "'main'", "'return'", "'while'", "'{'", "'|'", "'}'"
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
    "invalidRule", "literal_expression", "add_expression", "variable_declaration", 
    "array_declaration", "while_statement", "expression", "assignment", 
    "parenthesized_expression", "mul_expression", "parameter_list", "unary_expression", 
    "method_call", "type", "assert_statement", "method_body", "invariant_statement", 
    "rel_expression", "ensure_statement", "if_statement", "assume_statement", 
    "parameter", "statement_block", "program", "main_method", "loop_body", 
    "arglist", "method_declaration", "array_access", "statement"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false
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
    public String getGrammarFileName() { return "/home/stud/s_bischo/PSE2011/Design/WhileLanguage.g"; }



    // $ANTLR start "program"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:3:1: program : ( assume_statement )* ( method_declaration )* main_method ;
    public final void program() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "program");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(3, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:4:2: ( ( assume_statement )* ( method_declaration )* main_method )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:4:4: ( assume_statement )* ( method_declaration )* main_method
            {
            dbg.location(4,4);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:4:4: ( assume_statement )*
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

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:4:4: assume_statement
            	    {
            	    dbg.location(4,4);
            	    pushFollow(FOLLOW_assume_statement_in_program11);
            	    assume_statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(4,22);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:4:22: ( method_declaration )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==31||LA2_0==35) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:4:22: method_declaration
            	    {
            	    dbg.location(4,22);
            	    pushFollow(FOLLOW_method_declaration_in_program14);
            	    method_declaration();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}

            dbg.location(4,42);
            pushFollow(FOLLOW_main_method_in_program17);
            main_method();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(5, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "program");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "method_declaration"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:7:1: method_declaration : type IDENT '(' ( parameter_list )? ')' method_body ;
    public final void method_declaration() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "method_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(7, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:8:2: ( type IDENT '(' ( parameter_list )? ')' method_body )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:8:4: type IDENT '(' ( parameter_list )? ')' method_body
            {
            dbg.location(8,4);
            pushFollow(FOLLOW_type_in_method_declaration29);
            type();

            state._fsp--;

            dbg.location(8,9);
            match(input,IDENT,FOLLOW_IDENT_in_method_declaration31); 
            dbg.location(8,15);
            match(input,13,FOLLOW_13_in_method_declaration33); 
            dbg.location(8,19);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:8:19: ( parameter_list )?
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3, decisionCanBacktrack[3]);

            int LA3_0 = input.LA(1);

            if ( (LA3_0==31||LA3_0==35) ) {
                alt3=1;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:8:19: parameter_list
                    {
                    dbg.location(8,19);
                    pushFollow(FOLLOW_parameter_list_in_method_declaration35);
                    parameter_list();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}

            dbg.location(8,35);
            match(input,14,FOLLOW_14_in_method_declaration38); 
            dbg.location(8,39);
            pushFollow(FOLLOW_method_body_in_method_declaration40);
            method_body();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(9, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "method_declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "method_declaration"



    // $ANTLR start "main_method"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:11:1: main_method : 'main' '(' ( parameter_list )? ')' method_body ;
    public final void main_method() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "main_method");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(11, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:12:2: ( 'main' '(' ( parameter_list )? ')' method_body )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:12:4: 'main' '(' ( parameter_list )? ')' method_body
            {
            dbg.location(12,4);
            match(input,37,FOLLOW_37_in_main_method51); 
            dbg.location(12,11);
            match(input,13,FOLLOW_13_in_main_method53); 
            dbg.location(12,15);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:12:15: ( parameter_list )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==31||LA4_0==35) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:12:15: parameter_list
                    {
                    dbg.location(12,15);
                    pushFollow(FOLLOW_parameter_list_in_main_method55);
                    parameter_list();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}

            dbg.location(12,31);
            match(input,14,FOLLOW_14_in_main_method58); 
            dbg.location(12,35);
            pushFollow(FOLLOW_method_body_in_main_method60);
            method_body();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(13, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "main_method");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "main_method"



    // $ANTLR start "parameter_list"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:15:1: parameter_list : parameter ( ',' parameter )* ;
    public final void parameter_list() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "parameter_list");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(15, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:16:2: ( parameter ( ',' parameter )* )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:16:4: parameter ( ',' parameter )*
            {
            dbg.location(16,4);
            pushFollow(FOLLOW_parameter_in_parameter_list72);
            parameter();

            state._fsp--;

            dbg.location(16,14);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:16:14: ( ',' parameter )*
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

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:16:16: ',' parameter
            	    {
            	    dbg.location(16,16);
            	    match(input,17,FOLLOW_17_in_parameter_list76); 
            	    dbg.location(16,20);
            	    pushFollow(FOLLOW_parameter_in_parameter_list78);
            	    parameter();

            	    state._fsp--;


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
        dbg.location(17, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameter_list");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "parameter_list"



    // $ANTLR start "parameter"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:19:1: parameter : type IDENT ;
    public final void parameter() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "parameter");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(19, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:20:2: ( type IDENT )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:20:4: type IDENT
            {
            dbg.location(20,4);
            pushFollow(FOLLOW_type_in_parameter94);
            type();

            state._fsp--;

            dbg.location(20,9);
            match(input,IDENT,FOLLOW_IDENT_in_parameter96); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(21, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parameter");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "parameter"



    // $ANTLR start "method_body"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:23:1: method_body : '{' ( assume_statement )* ( statement )* ( ensure_statement )* '}' ;
    public final void method_body() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "method_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(23, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:24:2: ( '{' ( assume_statement )* ( statement )* ( ensure_statement )* '}' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:24:4: '{' ( assume_statement )* ( statement )* ( ensure_statement )* '}'
            {
            dbg.location(24,4);
            match(input,40,FOLLOW_40_in_method_body109); 
            dbg.location(24,8);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:24:8: ( assume_statement )*
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

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:24:8: assume_statement
            	    {
            	    dbg.location(24,8);
            	    pushFollow(FOLLOW_assume_statement_in_method_body111);
            	    assume_statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}

            dbg.location(24,26);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:24:26: ( statement )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT||LA7_0==29||LA7_0==31||(LA7_0 >= 34 && LA7_0 <= 35)||(LA7_0 >= 38 && LA7_0 <= 39)) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:24:26: statement
            	    {
            	    dbg.location(24,26);
            	    pushFollow(FOLLOW_statement_in_method_body114);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}

            dbg.location(24,37);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:24:37: ( ensure_statement )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=2;
                try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==33) ) {
                    alt8=1;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:24:37: ensure_statement
            	    {
            	    dbg.location(24,37);
            	    pushFollow(FOLLOW_ensure_statement_in_method_body117);
            	    ensure_statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}

            dbg.location(24,55);
            match(input,42,FOLLOW_42_in_method_body120); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(25, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "method_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "method_body"



    // $ANTLR start "statement"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:27:1: statement : ( assert_statement | variable_declaration | array_declaration | assignment | if_statement | while_statement | 'return' expression ';' );
    public final void statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(27, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:28:2: ( assert_statement | variable_declaration | array_declaration | assignment | if_statement | while_statement | 'return' expression ';' )
            int alt9=7;
            try { dbg.enterDecision(9, decisionCanBacktrack[9]);

            try {
                isCyclicDecision = true;
                alt9 = dfa9.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(9);}

            switch (alt9) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:28:4: assert_statement
                    {
                    dbg.location(28,4);
                    pushFollow(FOLLOW_assert_statement_in_statement133);
                    assert_statement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:29:4: variable_declaration
                    {
                    dbg.location(29,4);
                    pushFollow(FOLLOW_variable_declaration_in_statement138);
                    variable_declaration();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:30:4: array_declaration
                    {
                    dbg.location(30,4);
                    pushFollow(FOLLOW_array_declaration_in_statement143);
                    array_declaration();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:31:4: assignment
                    {
                    dbg.location(31,4);
                    pushFollow(FOLLOW_assignment_in_statement148);
                    assignment();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:32:4: if_statement
                    {
                    dbg.location(32,4);
                    pushFollow(FOLLOW_if_statement_in_statement153);
                    if_statement();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:33:4: while_statement
                    {
                    dbg.location(33,4);
                    pushFollow(FOLLOW_while_statement_in_statement158);
                    while_statement();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:34:4: 'return' expression ';'
                    {
                    dbg.location(34,4);
                    match(input,38,FOLLOW_38_in_statement163); 
                    dbg.location(34,13);
                    pushFollow(FOLLOW_expression_in_statement165);
                    expression();

                    state._fsp--;

                    dbg.location(34,24);
                    match(input,20,FOLLOW_20_in_statement167); 

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
        dbg.location(35, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "invariant_statement"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:37:1: invariant_statement : 'invariant' expression ';' ;
    public final void invariant_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "invariant_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(37, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:38:2: ( 'invariant' expression ';' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:38:4: 'invariant' expression ';'
            {
            dbg.location(38,4);
            match(input,36,FOLLOW_36_in_invariant_statement179); 
            dbg.location(38,16);
            pushFollow(FOLLOW_expression_in_invariant_statement181);
            expression();

            state._fsp--;

            dbg.location(38,27);
            match(input,20,FOLLOW_20_in_invariant_statement183); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(39, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "invariant_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "invariant_statement"



    // $ANTLR start "assert_statement"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:41:1: assert_statement : 'assert' expression ';' ;
    public final void assert_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "assert_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(41, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:42:2: ( 'assert' expression ';' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:42:4: 'assert' expression ';'
            {
            dbg.location(42,4);
            match(input,29,FOLLOW_29_in_assert_statement195); 
            dbg.location(42,13);
            pushFollow(FOLLOW_expression_in_assert_statement197);
            expression();

            state._fsp--;

            dbg.location(42,24);
            match(input,20,FOLLOW_20_in_assert_statement199); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(43, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assert_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "assert_statement"



    // $ANTLR start "assume_statement"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:45:1: assume_statement : 'assume' expression ';' ;
    public final void assume_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "assume_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(45, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:46:2: ( 'assume' expression ';' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:46:4: 'assume' expression ';'
            {
            dbg.location(46,4);
            match(input,30,FOLLOW_30_in_assume_statement210); 
            dbg.location(46,13);
            pushFollow(FOLLOW_expression_in_assume_statement212);
            expression();

            state._fsp--;

            dbg.location(46,24);
            match(input,20,FOLLOW_20_in_assume_statement214); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(47, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assume_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "assume_statement"



    // $ANTLR start "ensure_statement"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:49:1: ensure_statement : 'ensure' expression ';' ;
    public final void ensure_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "ensure_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(49, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:50:2: ( 'ensure' expression ';' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:50:4: 'ensure' expression ';'
            {
            dbg.location(50,4);
            match(input,33,FOLLOW_33_in_ensure_statement226); 
            dbg.location(50,13);
            pushFollow(FOLLOW_expression_in_ensure_statement228);
            expression();

            state._fsp--;

            dbg.location(50,24);
            match(input,20,FOLLOW_20_in_ensure_statement230); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(51, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ensure_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "ensure_statement"



    // $ANTLR start "assignment"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:53:1: assignment : IDENT ( '[' expression ']' )* '=' expression ';' ;
    public final void assignment() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:54:2: ( IDENT ( '[' expression ']' )* '=' expression ';' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:54:4: IDENT ( '[' expression ']' )* '=' expression ';'
            {
            dbg.location(54,4);
            match(input,IDENT,FOLLOW_IDENT_in_assignment241); 
            dbg.location(54,10);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:54:10: ( '[' expression ']' )*
            try { dbg.enterSubRule(10);

            loop10:
            do {
                int alt10=2;
                try { dbg.enterDecision(10, decisionCanBacktrack[10]);

                int LA10_0 = input.LA(1);

                if ( (LA10_0==27) ) {
                    alt10=1;
                }


                } finally {dbg.exitDecision(10);}

                switch (alt10) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:54:12: '[' expression ']'
            	    {
            	    dbg.location(54,12);
            	    match(input,27,FOLLOW_27_in_assignment245); 
            	    dbg.location(54,16);
            	    pushFollow(FOLLOW_expression_in_assignment247);
            	    expression();

            	    state._fsp--;

            	    dbg.location(54,27);
            	    match(input,28,FOLLOW_28_in_assignment249); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);
            } finally {dbg.exitSubRule(10);}

            dbg.location(54,34);
            match(input,23,FOLLOW_23_in_assignment254); 
            dbg.location(54,38);
            pushFollow(FOLLOW_expression_in_assignment256);
            expression();

            state._fsp--;

            dbg.location(54,49);
            match(input,20,FOLLOW_20_in_assignment258); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(55, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "assignment"



    // $ANTLR start "variable_declaration"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:57:1: variable_declaration : type IDENT ( '=' expression )? ';' ;
    public final void variable_declaration() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "variable_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(57, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:58:2: ( type IDENT ( '=' expression )? ';' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:58:4: type IDENT ( '=' expression )? ';'
            {
            dbg.location(58,4);
            pushFollow(FOLLOW_type_in_variable_declaration270);
            type();

            state._fsp--;

            dbg.location(58,9);
            match(input,IDENT,FOLLOW_IDENT_in_variable_declaration272); 
            dbg.location(58,15);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:58:15: ( '=' expression )?
            int alt11=2;
            try { dbg.enterSubRule(11);
            try { dbg.enterDecision(11, decisionCanBacktrack[11]);

            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:58:17: '=' expression
                    {
                    dbg.location(58,17);
                    match(input,23,FOLLOW_23_in_variable_declaration276); 
                    dbg.location(58,21);
                    pushFollow(FOLLOW_expression_in_variable_declaration278);
                    expression();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(11);}

            dbg.location(58,35);
            match(input,20,FOLLOW_20_in_variable_declaration283); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(59, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "variable_declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "variable_declaration"



    // $ANTLR start "array_declaration"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:61:1: array_declaration : type IDENT ( '[' ']' )+ ';' ;
    public final void array_declaration() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "array_declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(61, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:62:2: ( type IDENT ( '[' ']' )+ ';' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:62:4: type IDENT ( '[' ']' )+ ';'
            {
            dbg.location(62,4);
            pushFollow(FOLLOW_type_in_array_declaration295);
            type();

            state._fsp--;

            dbg.location(62,9);
            match(input,IDENT,FOLLOW_IDENT_in_array_declaration297); 
            dbg.location(62,15);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:62:15: ( '[' ']' )+
            int cnt12=0;
            try { dbg.enterSubRule(12);

            loop12:
            do {
                int alt12=2;
                try { dbg.enterDecision(12, decisionCanBacktrack[12]);

                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                } finally {dbg.exitDecision(12);}

                switch (alt12) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:62:17: '[' ']'
            	    {
            	    dbg.location(62,17);
            	    match(input,27,FOLLOW_27_in_array_declaration301); 
            	    dbg.location(62,21);
            	    match(input,28,FOLLOW_28_in_array_declaration303); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt12++;
            } while (true);
            } finally {dbg.exitSubRule(12);}

            dbg.location(62,28);
            match(input,20,FOLLOW_20_in_array_declaration308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(63, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "array_declaration"



    // $ANTLR start "if_statement"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:65:1: if_statement : 'if' '(' expression ')' statement_block ( 'else' statement_block )? ;
    public final void if_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "if_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(65, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:66:2: ( 'if' '(' expression ')' statement_block ( 'else' statement_block )? )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:66:4: 'if' '(' expression ')' statement_block ( 'else' statement_block )?
            {
            dbg.location(66,4);
            match(input,34,FOLLOW_34_in_if_statement321); 
            dbg.location(66,9);
            match(input,13,FOLLOW_13_in_if_statement323); 
            dbg.location(66,13);
            pushFollow(FOLLOW_expression_in_if_statement325);
            expression();

            state._fsp--;

            dbg.location(66,24);
            match(input,14,FOLLOW_14_in_if_statement327); 
            dbg.location(66,28);
            pushFollow(FOLLOW_statement_block_in_if_statement329);
            statement_block();

            state._fsp--;

            dbg.location(66,44);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:66:44: ( 'else' statement_block )?
            int alt13=2;
            try { dbg.enterSubRule(13);
            try { dbg.enterDecision(13, decisionCanBacktrack[13]);

            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            } finally {dbg.exitDecision(13);}

            switch (alt13) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:66:46: 'else' statement_block
                    {
                    dbg.location(66,46);
                    match(input,32,FOLLOW_32_in_if_statement333); 
                    dbg.location(66,53);
                    pushFollow(FOLLOW_statement_block_in_if_statement335);
                    statement_block();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(13);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(67, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "if_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "if_statement"



    // $ANTLR start "statement_block"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:69:1: statement_block : '{' ( statement )* '}' ;
    public final void statement_block() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "statement_block");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(69, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:70:2: ( '{' ( statement )* '}' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:70:4: '{' ( statement )* '}'
            {
            dbg.location(70,4);
            match(input,40,FOLLOW_40_in_statement_block349); 
            dbg.location(70,8);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:70:8: ( statement )*
            try { dbg.enterSubRule(14);

            loop14:
            do {
                int alt14=2;
                try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                int LA14_0 = input.LA(1);

                if ( (LA14_0==IDENT||LA14_0==29||LA14_0==31||(LA14_0 >= 34 && LA14_0 <= 35)||(LA14_0 >= 38 && LA14_0 <= 39)) ) {
                    alt14=1;
                }


                } finally {dbg.exitDecision(14);}

                switch (alt14) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:70:8: statement
            	    {
            	    dbg.location(70,8);
            	    pushFollow(FOLLOW_statement_in_statement_block351);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);
            } finally {dbg.exitSubRule(14);}

            dbg.location(70,19);
            match(input,42,FOLLOW_42_in_statement_block354); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(71, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement_block");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "statement_block"



    // $ANTLR start "while_statement"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:73:1: while_statement : 'while' '(' expression ')' loop_body ;
    public final void while_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "while_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(73, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:74:2: ( 'while' '(' expression ')' loop_body )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:74:4: 'while' '(' expression ')' loop_body
            {
            dbg.location(74,4);
            match(input,39,FOLLOW_39_in_while_statement367); 
            dbg.location(74,12);
            match(input,13,FOLLOW_13_in_while_statement369); 
            dbg.location(74,16);
            pushFollow(FOLLOW_expression_in_while_statement371);
            expression();

            state._fsp--;

            dbg.location(74,27);
            match(input,14,FOLLOW_14_in_while_statement373); 
            dbg.location(74,31);
            pushFollow(FOLLOW_loop_body_in_while_statement375);
            loop_body();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(75, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "while_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "while_statement"



    // $ANTLR start "loop_body"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:77:1: loop_body : '{' ( invariant_statement )* ( statement )* ( ensure_statement )* '}' ;
    public final void loop_body() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "loop_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(77, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:78:2: ( '{' ( invariant_statement )* ( statement )* ( ensure_statement )* '}' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:78:4: '{' ( invariant_statement )* ( statement )* ( ensure_statement )* '}'
            {
            dbg.location(78,4);
            match(input,40,FOLLOW_40_in_loop_body386); 
            dbg.location(78,8);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:78:8: ( invariant_statement )*
            try { dbg.enterSubRule(15);

            loop15:
            do {
                int alt15=2;
                try { dbg.enterDecision(15, decisionCanBacktrack[15]);

                int LA15_0 = input.LA(1);

                if ( (LA15_0==36) ) {
                    alt15=1;
                }


                } finally {dbg.exitDecision(15);}

                switch (alt15) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:78:8: invariant_statement
            	    {
            	    dbg.location(78,8);
            	    pushFollow(FOLLOW_invariant_statement_in_loop_body388);
            	    invariant_statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);
            } finally {dbg.exitSubRule(15);}

            dbg.location(78,29);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:78:29: ( statement )*
            try { dbg.enterSubRule(16);

            loop16:
            do {
                int alt16=2;
                try { dbg.enterDecision(16, decisionCanBacktrack[16]);

                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDENT||LA16_0==29||LA16_0==31||(LA16_0 >= 34 && LA16_0 <= 35)||(LA16_0 >= 38 && LA16_0 <= 39)) ) {
                    alt16=1;
                }


                } finally {dbg.exitDecision(16);}

                switch (alt16) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:78:29: statement
            	    {
            	    dbg.location(78,29);
            	    pushFollow(FOLLOW_statement_in_loop_body391);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);
            } finally {dbg.exitSubRule(16);}

            dbg.location(78,40);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:78:40: ( ensure_statement )*
            try { dbg.enterSubRule(17);

            loop17:
            do {
                int alt17=2;
                try { dbg.enterDecision(17, decisionCanBacktrack[17]);

                int LA17_0 = input.LA(1);

                if ( (LA17_0==33) ) {
                    alt17=1;
                }


                } finally {dbg.exitDecision(17);}

                switch (alt17) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:78:40: ensure_statement
            	    {
            	    dbg.location(78,40);
            	    pushFollow(FOLLOW_ensure_statement_in_loop_body394);
            	    ensure_statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);
            } finally {dbg.exitSubRule(17);}

            dbg.location(78,58);
            match(input,42,FOLLOW_42_in_loop_body397); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(79, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "loop_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "loop_body"



    // $ANTLR start "expression"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:81:1: expression : rel_expression ( ( '==' | '!=' ) rel_expression )* ;
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(81, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:82:2: ( rel_expression ( ( '==' | '!=' ) rel_expression )* )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:82:4: rel_expression ( ( '==' | '!=' ) rel_expression )*
            {
            dbg.location(82,4);
            pushFollow(FOLLOW_rel_expression_in_expression409);
            rel_expression();

            state._fsp--;

            dbg.location(82,19);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:82:19: ( ( '==' | '!=' ) rel_expression )*
            try { dbg.enterSubRule(18);

            loop18:
            do {
                int alt18=2;
                try { dbg.enterDecision(18, decisionCanBacktrack[18]);

                int LA18_0 = input.LA(1);

                if ( (LA18_0==10||LA18_0==24) ) {
                    alt18=1;
                }


                } finally {dbg.exitDecision(18);}

                switch (alt18) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:82:21: ( '==' | '!=' ) rel_expression
            	    {
            	    dbg.location(82,21);
            	    if ( input.LA(1)==10||input.LA(1)==24 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(82,37);
            	    pushFollow(FOLLOW_rel_expression_in_expression423);
            	    rel_expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);
            } finally {dbg.exitSubRule(18);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(83, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expression"



    // $ANTLR start "rel_expression"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:86:1: rel_expression : add_expression ( ( '<' | '<=' | '>' | '>=' ) add_expression )* ;
    public final void rel_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "rel_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(86, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:87:2: ( add_expression ( ( '<' | '<=' | '>' | '>=' ) add_expression )* )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:87:4: add_expression ( ( '<' | '<=' | '>' | '>=' ) add_expression )*
            {
            dbg.location(87,4);
            pushFollow(FOLLOW_add_expression_in_rel_expression440);
            add_expression();

            state._fsp--;

            dbg.location(87,19);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:87:19: ( ( '<' | '<=' | '>' | '>=' ) add_expression )*
            try { dbg.enterSubRule(19);

            loop19:
            do {
                int alt19=2;
                try { dbg.enterDecision(19, decisionCanBacktrack[19]);

                int LA19_0 = input.LA(1);

                if ( ((LA19_0 >= 21 && LA19_0 <= 22)||(LA19_0 >= 25 && LA19_0 <= 26)) ) {
                    alt19=1;
                }


                } finally {dbg.exitDecision(19);}

                switch (alt19) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:87:21: ( '<' | '<=' | '>' | '>=' ) add_expression
            	    {
            	    dbg.location(87,21);
            	    if ( (input.LA(1) >= 21 && input.LA(1) <= 22)||(input.LA(1) >= 25 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(87,49);
            	    pushFollow(FOLLOW_add_expression_in_rel_expression462);
            	    add_expression();

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
        dbg.location(88, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "rel_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "rel_expression"



    // $ANTLR start "add_expression"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:90:1: add_expression : mul_expression ( ( '|' | '+' | '-' ) mul_expression )* ;
    public final void add_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "add_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(90, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:91:2: ( mul_expression ( ( '|' | '+' | '-' ) mul_expression )* )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:91:4: mul_expression ( ( '|' | '+' | '-' ) mul_expression )*
            {
            dbg.location(91,4);
            pushFollow(FOLLOW_mul_expression_in_add_expression477);
            mul_expression();

            state._fsp--;

            dbg.location(91,19);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:91:19: ( ( '|' | '+' | '-' ) mul_expression )*
            try { dbg.enterSubRule(20);

            loop20:
            do {
                int alt20=2;
                try { dbg.enterDecision(20, decisionCanBacktrack[20]);

                int LA20_0 = input.LA(1);

                if ( (LA20_0==16||LA20_0==18||LA20_0==41) ) {
                    alt20=1;
                }


                } finally {dbg.exitDecision(20);}

                switch (alt20) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:91:21: ( '|' | '+' | '-' ) mul_expression
            	    {
            	    dbg.location(91,21);
            	    if ( input.LA(1)==16||input.LA(1)==18||input.LA(1)==41 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(91,41);
            	    pushFollow(FOLLOW_mul_expression_in_add_expression495);
            	    mul_expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);
            } finally {dbg.exitSubRule(20);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(92, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "add_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "add_expression"



    // $ANTLR start "mul_expression"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:94:1: mul_expression : unary_expression ( ( '&' | '*' | '/' | '%' ) unary_expression )* ;
    public final void mul_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "mul_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(94, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:95:2: ( unary_expression ( ( '&' | '*' | '/' | '%' ) unary_expression )* )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:95:4: unary_expression ( ( '&' | '*' | '/' | '%' ) unary_expression )*
            {
            dbg.location(95,4);
            pushFollow(FOLLOW_unary_expression_in_mul_expression510);
            unary_expression();

            state._fsp--;

            dbg.location(95,21);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:95:21: ( ( '&' | '*' | '/' | '%' ) unary_expression )*
            try { dbg.enterSubRule(21);

            loop21:
            do {
                int alt21=2;
                try { dbg.enterDecision(21, decisionCanBacktrack[21]);

                int LA21_0 = input.LA(1);

                if ( ((LA21_0 >= 11 && LA21_0 <= 12)||LA21_0==15||LA21_0==19) ) {
                    alt21=1;
                }


                } finally {dbg.exitDecision(21);}

                switch (alt21) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:95:23: ( '&' | '*' | '/' | '%' ) unary_expression
            	    {
            	    dbg.location(95,23);
            	    if ( (input.LA(1) >= 11 && input.LA(1) <= 12)||input.LA(1)==15||input.LA(1)==19 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(95,47);
            	    pushFollow(FOLLOW_unary_expression_in_mul_expression530);
            	    unary_expression();

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
        dbg.location(96, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mul_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "mul_expression"



    // $ANTLR start "unary_expression"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:98:1: unary_expression : ( '!' | '+' | '-' )? parenthesized_expression ;
    public final void unary_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "unary_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(98, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:99:2: ( ( '!' | '+' | '-' )? parenthesized_expression )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:99:4: ( '!' | '+' | '-' )? parenthesized_expression
            {
            dbg.location(99,4);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:99:4: ( '!' | '+' | '-' )?
            int alt22=2;
            try { dbg.enterSubRule(22);
            try { dbg.enterDecision(22, decisionCanBacktrack[22]);

            int LA22_0 = input.LA(1);

            if ( (LA22_0==9||LA22_0==16||LA22_0==18) ) {
                alt22=1;
            }
            } finally {dbg.exitDecision(22);}

            switch (alt22) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:
                    {
                    dbg.location(99,4);
                    if ( input.LA(1)==9||input.LA(1)==16||input.LA(1)==18 ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        dbg.recognitionException(mse);
                        throw mse;
                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(22);}

            dbg.location(99,25);
            pushFollow(FOLLOW_parenthesized_expression_in_unary_expression561);
            parenthesized_expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(100, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "unary_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "unary_expression"



    // $ANTLR start "parenthesized_expression"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:102:1: parenthesized_expression : ( '(' expression ')' | method_call | array_access | IDENT | literal_expression );
    public final void parenthesized_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "parenthesized_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(102, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:103:2: ( '(' expression ')' | method_call | array_access | IDENT | literal_expression )
            int alt23=5;
            try { dbg.enterDecision(23, decisionCanBacktrack[23]);

            switch ( input.LA(1) ) {
            case 13:
                {
                alt23=1;
                }
                break;
            case IDENT:
                {
                switch ( input.LA(2) ) {
                case 13:
                    {
                    alt23=2;
                    }
                    break;
                case 27:
                    {
                    alt23=3;
                    }
                    break;
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
                case 41:
                    {
                    alt23=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }

                }
                break;
            case BOOL_LITERAL:
            case INT_LITERAL:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(23);}

            switch (alt23) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:103:4: '(' expression ')'
                    {
                    dbg.location(103,4);
                    match(input,13,FOLLOW_13_in_parenthesized_expression573); 
                    dbg.location(103,8);
                    pushFollow(FOLLOW_expression_in_parenthesized_expression575);
                    expression();

                    state._fsp--;

                    dbg.location(103,19);
                    match(input,14,FOLLOW_14_in_parenthesized_expression577); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:104:4: method_call
                    {
                    dbg.location(104,4);
                    pushFollow(FOLLOW_method_call_in_parenthesized_expression582);
                    method_call();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:105:4: array_access
                    {
                    dbg.location(105,4);
                    pushFollow(FOLLOW_array_access_in_parenthesized_expression587);
                    array_access();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:106:4: IDENT
                    {
                    dbg.location(106,4);
                    match(input,IDENT,FOLLOW_IDENT_in_parenthesized_expression592); 

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:107:4: literal_expression
                    {
                    dbg.location(107,4);
                    pushFollow(FOLLOW_literal_expression_in_parenthesized_expression597);
                    literal_expression();

                    state._fsp--;


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
        dbg.location(108, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parenthesized_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "parenthesized_expression"



    // $ANTLR start "method_call"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:110:1: method_call : IDENT '(' ( arglist )? ')' ;
    public final void method_call() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "method_call");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(110, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:111:2: ( IDENT '(' ( arglist )? ')' )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:111:4: IDENT '(' ( arglist )? ')'
            {
            dbg.location(111,4);
            match(input,IDENT,FOLLOW_IDENT_in_method_call609); 
            dbg.location(111,10);
            match(input,13,FOLLOW_13_in_method_call611); 
            dbg.location(111,14);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:111:14: ( arglist )?
            int alt24=2;
            try { dbg.enterSubRule(24);
            try { dbg.enterDecision(24, decisionCanBacktrack[24]);

            int LA24_0 = input.LA(1);

            if ( (LA24_0==BOOL_LITERAL||(LA24_0 >= IDENT && LA24_0 <= INT_LITERAL)||LA24_0==9||LA24_0==13||LA24_0==16||LA24_0==18) ) {
                alt24=1;
            }
            } finally {dbg.exitDecision(24);}

            switch (alt24) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:111:14: arglist
                    {
                    dbg.location(111,14);
                    pushFollow(FOLLOW_arglist_in_method_call613);
                    arglist();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(24);}

            dbg.location(111,23);
            match(input,14,FOLLOW_14_in_method_call616); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(112, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "method_call");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "method_call"



    // $ANTLR start "arglist"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:114:1: arglist : expression ( ',' expression )* ;
    public final void arglist() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "arglist");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(114, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:115:2: ( expression ( ',' expression )* )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:115:4: expression ( ',' expression )*
            {
            dbg.location(115,4);
            pushFollow(FOLLOW_expression_in_arglist629);
            expression();

            state._fsp--;

            dbg.location(115,15);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:115:15: ( ',' expression )*
            try { dbg.enterSubRule(25);

            loop25:
            do {
                int alt25=2;
                try { dbg.enterDecision(25, decisionCanBacktrack[25]);

                int LA25_0 = input.LA(1);

                if ( (LA25_0==17) ) {
                    alt25=1;
                }


                } finally {dbg.exitDecision(25);}

                switch (alt25) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:115:17: ',' expression
            	    {
            	    dbg.location(115,17);
            	    match(input,17,FOLLOW_17_in_arglist633); 
            	    dbg.location(115,21);
            	    pushFollow(FOLLOW_expression_in_arglist635);
            	    expression();

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
        dbg.location(116, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "arglist");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "arglist"



    // $ANTLR start "array_access"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:118:1: array_access : IDENT '[' expression ']' ( '[' expression ']' )* ;
    public final void array_access() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "array_access");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(118, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:119:2: ( IDENT '[' expression ']' ( '[' expression ']' )* )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:119:4: IDENT '[' expression ']' ( '[' expression ']' )*
            {
            dbg.location(119,4);
            match(input,IDENT,FOLLOW_IDENT_in_array_access650); 
            dbg.location(119,10);
            match(input,27,FOLLOW_27_in_array_access652); 
            dbg.location(119,14);
            pushFollow(FOLLOW_expression_in_array_access654);
            expression();

            state._fsp--;

            dbg.location(119,25);
            match(input,28,FOLLOW_28_in_array_access656); 
            dbg.location(119,29);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:119:29: ( '[' expression ']' )*
            try { dbg.enterSubRule(26);

            loop26:
            do {
                int alt26=2;
                try { dbg.enterDecision(26, decisionCanBacktrack[26]);

                int LA26_0 = input.LA(1);

                if ( (LA26_0==27) ) {
                    alt26=1;
                }


                } finally {dbg.exitDecision(26);}

                switch (alt26) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:119:31: '[' expression ']'
            	    {
            	    dbg.location(119,31);
            	    match(input,27,FOLLOW_27_in_array_access660); 
            	    dbg.location(119,35);
            	    pushFollow(FOLLOW_expression_in_array_access662);
            	    expression();

            	    state._fsp--;

            	    dbg.location(119,46);
            	    match(input,28,FOLLOW_28_in_array_access664); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);
            } finally {dbg.exitSubRule(26);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(120, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_access");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "array_access"



    // $ANTLR start "literal_expression"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:122:1: literal_expression : ( INT_LITERAL | BOOL_LITERAL );
    public final void literal_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "literal_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(122, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:123:2: ( INT_LITERAL | BOOL_LITERAL )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:
            {
            dbg.location(123,2);
            if ( input.LA(1)==BOOL_LITERAL||input.LA(1)==INT_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(125, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "literal_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "literal_expression"



    // $ANTLR start "type"
    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:127:1: type : ( 'int' | 'bool' ) ( '[' ']' )* ;
    public final void type() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(127, 0);

        try {
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:128:2: ( ( 'int' | 'bool' ) ( '[' ']' )* )
            dbg.enterAlt(1);

            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:128:4: ( 'int' | 'bool' ) ( '[' ']' )*
            {
            dbg.location(128,4);
            if ( input.LA(1)==31||input.LA(1)==35 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(128,21);
            // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:128:21: ( '[' ']' )*
            try { dbg.enterSubRule(27);

            loop27:
            do {
                int alt27=2;
                try { dbg.enterDecision(27, decisionCanBacktrack[27]);

                int LA27_0 = input.LA(1);

                if ( (LA27_0==27) ) {
                    alt27=1;
                }


                } finally {dbg.exitDecision(27);}

                switch (alt27) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/stud/s_bischo/PSE2011/Design/WhileLanguage.g:128:23: '[' ']'
            	    {
            	    dbg.location(128,23);
            	    match(input,27,FOLLOW_27_in_type706); 
            	    dbg.location(128,27);
            	    match(input,28,FOLLOW_28_in_type708); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);
            } finally {dbg.exitSubRule(27);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(129, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "type"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\14\uffff";
    static final String DFA9_eofS =
        "\14\uffff";
    static final String DFA9_minS =
        "\1\6\1\uffff\1\6\4\uffff\1\34\1\24\1\6\2\uffff";
    static final String DFA9_maxS =
        "\1\47\1\uffff\1\33\4\uffff\1\34\2\33\2\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\3\uffff\1\2\1\3";
    static final String DFA9_specialS =
        "\14\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\3\26\uffff\1\1\1\uffff\1\2\2\uffff\1\4\1\2\2\uffff\1\6\1"+
            "\5",
            "",
            "\1\10\24\uffff\1\7",
            "",
            "",
            "",
            "",
            "\1\11",
            "\1\12\2\uffff\1\12\3\uffff\1\13",
            "\1\10\24\uffff\1\7",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "27:1: statement : ( assert_statement | variable_declaration | array_declaration | assignment | if_statement | while_statement | 'return' expression ';' );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_assume_statement_in_program11 = new BitSet(new long[]{0x00000028C0000000L});
    public static final BitSet FOLLOW_method_declaration_in_program14 = new BitSet(new long[]{0x0000002880000000L});
    public static final BitSet FOLLOW_main_method_in_program17 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_method_declaration29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_method_declaration31 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_method_declaration33 = new BitSet(new long[]{0x0000000880004000L});
    public static final BitSet FOLLOW_parameter_list_in_method_declaration35 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_method_declaration38 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_method_body_in_method_declaration40 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_main_method51 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_main_method53 = new BitSet(new long[]{0x0000000880004000L});
    public static final BitSet FOLLOW_parameter_list_in_main_method55 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_main_method58 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_method_body_in_main_method60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_parameter_list72 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parameter_list76 = new BitSet(new long[]{0x0000000880000000L});
    public static final BitSet FOLLOW_parameter_in_parameter_list78 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_type_in_parameter94 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_parameter96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_method_body109 = new BitSet(new long[]{0x000004CEE0000040L});
    public static final BitSet FOLLOW_assume_statement_in_method_body111 = new BitSet(new long[]{0x000004CEE0000040L});
    public static final BitSet FOLLOW_statement_in_method_body114 = new BitSet(new long[]{0x000004CEA0000040L});
    public static final BitSet FOLLOW_ensure_statement_in_method_body117 = new BitSet(new long[]{0x0000040200000000L});
    public static final BitSet FOLLOW_42_in_method_body120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_declaration_in_statement138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_declaration_in_statement143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_statement163 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_statement165 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_statement167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_invariant_statement179 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_invariant_statement181 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_invariant_statement183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_assert_statement195 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_assert_statement197 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assert_statement199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_assume_statement210 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_assume_statement212 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assume_statement214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ensure_statement226 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_ensure_statement228 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ensure_statement230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignment241 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_27_in_assignment245 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_assignment247 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_assignment249 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_23_in_assignment254 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_assignment256 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assignment258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_variable_declaration270 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_variable_declaration272 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_23_in_variable_declaration276 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_variable_declaration278 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_variable_declaration283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_array_declaration295 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_array_declaration297 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_array_declaration301 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_declaration303 = new BitSet(new long[]{0x0000000008100000L});
    public static final BitSet FOLLOW_20_in_array_declaration308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_if_statement321 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_if_statement323 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_if_statement325 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_if_statement327 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_statement_block_in_if_statement329 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_if_statement333 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_statement_block_in_if_statement335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_statement_block349 = new BitSet(new long[]{0x000004CCA0000040L});
    public static final BitSet FOLLOW_statement_in_statement_block351 = new BitSet(new long[]{0x000004CCA0000040L});
    public static final BitSet FOLLOW_42_in_statement_block354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_while_statement367 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_while_statement369 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_while_statement371 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_while_statement373 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_loop_body_in_while_statement375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_loop_body386 = new BitSet(new long[]{0x000004DEA0000040L});
    public static final BitSet FOLLOW_invariant_statement_in_loop_body388 = new BitSet(new long[]{0x000004DEA0000040L});
    public static final BitSet FOLLOW_statement_in_loop_body391 = new BitSet(new long[]{0x000004CEA0000040L});
    public static final BitSet FOLLOW_ensure_statement_in_loop_body394 = new BitSet(new long[]{0x0000040200000000L});
    public static final BitSet FOLLOW_42_in_loop_body397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_expression_in_expression409 = new BitSet(new long[]{0x0000000001000402L});
    public static final BitSet FOLLOW_set_in_expression413 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_rel_expression_in_expression423 = new BitSet(new long[]{0x0000000001000402L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression440 = new BitSet(new long[]{0x0000000006600002L});
    public static final BitSet FOLLOW_set_in_rel_expression444 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_add_expression_in_rel_expression462 = new BitSet(new long[]{0x0000000006600002L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression477 = new BitSet(new long[]{0x0000020000050002L});
    public static final BitSet FOLLOW_set_in_add_expression481 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_mul_expression_in_add_expression495 = new BitSet(new long[]{0x0000020000050002L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression510 = new BitSet(new long[]{0x0000000000089802L});
    public static final BitSet FOLLOW_set_in_mul_expression514 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_unary_expression_in_mul_expression530 = new BitSet(new long[]{0x0000000000089802L});
    public static final BitSet FOLLOW_parenthesized_expression_in_unary_expression561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parenthesized_expression573 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_parenthesized_expression575 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parenthesized_expression577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_call_in_parenthesized_expression582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_access_in_parenthesized_expression587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_parenthesized_expression592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_expression_in_parenthesized_expression597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_method_call609 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_method_call611 = new BitSet(new long[]{0x00000000000562D0L});
    public static final BitSet FOLLOW_arglist_in_method_call613 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_method_call616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_arglist629 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_arglist633 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_arglist635 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_IDENT_in_array_access650 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_array_access652 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_array_access654 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_access656 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_array_access660 = new BitSet(new long[]{0x00000000000522D0L});
    public static final BitSet FOLLOW_expression_in_array_access662 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_array_access664 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_set_in_type696 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_type706 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_type708 = new BitSet(new long[]{0x0000000008000002L});

}