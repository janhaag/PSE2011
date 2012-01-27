// $ANTLR 3.4 ../src/grammar/z3.g 2012-01-19 22:25:52

    package verifier.smtlib.z3;

    import java.util.LinkedList;
    import java.util.HashMap;
    import misc.Pair;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class z3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL", "CHAR", "ESC_SEQ", "HEX_DIGIT", "IDENT", "INT", "OCTAL_ESC", "TYPE", "UNICODE_ESC", "WS", "'!'", "'('", "'()'", "'(='", "'(Array'", "'(_as-array'", "'(and'", "'(define-fun'", "'(model'", "')'", "'))'", "'Int'", "'sat'", "'unknown'", "'unsat'"
    };

    public static final int EOF=-1;
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
    public static final int BOOL=4;
    public static final int CHAR=5;
    public static final int ESC_SEQ=6;
    public static final int HEX_DIGIT=7;
    public static final int IDENT=8;
    public static final int INT=9;
    public static final int OCTAL_ESC=10;
    public static final int TYPE=11;
    public static final int UNICODE_ESC=12;
    public static final int WS=13;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public z3Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public z3Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return z3Parser.tokenNames; }
    public String getGrammarFileName() { return "../src/grammar/z3.g"; }



    // $ANTLR start "start"
    // ../src/grammar/z3.g:15:1: start returns [LinkedList<Pair> list] : (pair= block )+ ;
    public final LinkedList<Pair<Boolean, String>> start() throws RecognitionException {
        LinkedList<Pair<Boolean,String>> list = null;


        Pair<Boolean, String> pair =null;


        list = new LinkedList();
        try {
            // ../src/grammar/z3.g:16:2: ( (pair= block )+ )
            // ../src/grammar/z3.g:16:3: (pair= block )+
            {
            // ../src/grammar/z3.g:16:3: (pair= block )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 26 && LA1_0 <= 28)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../src/grammar/z3.g:16:4: pair= block
            	    {
            	    pushFollow(FOLLOW_block_in_start37);
            	    pair=block();

            	    state._fsp--;


            	    list.add(pair);

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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
        return list;
    }
    // $ANTLR end "start"



    // $ANTLR start "block"
    // ../src/grammar/z3.g:19:1: block returns [Pair<Boolean, String> result] : ( 'unsat' ( . )* | 'sat' example= model | 'unknown' ( . )* );
    public final Pair<Boolean, String> block() throws RecognitionException {
        Pair<Boolean, String> result = null;


        String example =null;


        try {
            // ../src/grammar/z3.g:20:2: ( 'unsat' ( . )* | 'sat' example= model | 'unknown' ( . )* )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt4=1;
                }
                break;
            case 26:
                {
                alt4=2;
                }
                break;
            case 27:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // ../src/grammar/z3.g:20:3: 'unsat' ( . )*
                    {
                    match(input,28,FOLLOW_28_in_block53); 

                    // ../src/grammar/z3.g:21:5: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        switch ( input.LA(1) ) {
                        case EOF:
                            {
                            alt2=2;
                            }
                            break;
                        case 28:
                            {
                            alt2=2;
                            }
                            break;
                        case 26:
                            {
                            alt2=2;
                            }
                            break;
                        case 27:
                            {
                            alt2=2;
                            }
                            break;
                        case BOOL:
                        case CHAR:
                        case ESC_SEQ:
                        case HEX_DIGIT:
                        case IDENT:
                        case INT:
                        case OCTAL_ESC:
                        case TYPE:
                        case UNICODE_ESC:
                        case WS:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            {
                            alt2=1;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // ../src/grammar/z3.g:21:5: .
                    	    {
                    	    matchAny(input); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    result = new Pair(true,"");

                    }
                    break;
                case 2 :
                    // ../src/grammar/z3.g:22:5: 'sat' example= model
                    {
                    match(input,26,FOLLOW_26_in_block68); 

                    pushFollow(FOLLOW_model_in_block78);
                    example=model();

                    state._fsp--;


                    result = new Pair(false, example);

                    }
                    break;
                case 3 :
                    // ../src/grammar/z3.g:24:4: 'unknown' ( . )*
                    {
                    match(input,27,FOLLOW_27_in_block85); 

                    // ../src/grammar/z3.g:25:3: ( . )*
                    loop3:
                    do {
                        int alt3=2;
                        switch ( input.LA(1) ) {
                        case EOF:
                            {
                            alt3=2;
                            }
                            break;
                        case 28:
                            {
                            alt3=2;
                            }
                            break;
                        case 26:
                            {
                            alt3=2;
                            }
                            break;
                        case 27:
                            {
                            alt3=2;
                            }
                            break;
                        case BOOL:
                        case CHAR:
                        case ESC_SEQ:
                        case HEX_DIGIT:
                        case IDENT:
                        case INT:
                        case OCTAL_ESC:
                        case TYPE:
                        case UNICODE_ESC:
                        case WS:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            {
                            alt3=1;
                            }
                            break;

                        }

                        switch (alt3) {
                    	case 1 :
                    	    // ../src/grammar/z3.g:25:3: .
                    	    {
                    	    matchAny(input); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    result = new Pair(true,"unknown");

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
        return result;
    }
    // $ANTLR end "block"



    // $ANTLR start "model"
    // ../src/grammar/z3.g:28:1: model returns [String example] : '(model' ( '(define-fun' id= IDENT '(' ( IDENT TYPE )* ')' TYPE val= value ')' )* ( '(define-fun' id= IDENT '()' '(Array' ( 'Int' )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) '))' )* ( '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite '))' )* ')' ;
    public final String model() throws RecognitionException {
        String example = null;


        Token id=null;
        Token id2=null;
        Token id3=null;
        String val =null;

        String ass =null;


        try {
            // ../src/grammar/z3.g:29:2: ( '(model' ( '(define-fun' id= IDENT '(' ( IDENT TYPE )* ')' TYPE val= value ')' )* ( '(define-fun' id= IDENT '()' '(Array' ( 'Int' )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) '))' )* ( '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite '))' )* ')' )
            // ../src/grammar/z3.g:29:4: '(model' ( '(define-fun' id= IDENT '(' ( IDENT TYPE )* ')' TYPE val= value ')' )* ( '(define-fun' id= IDENT '()' '(Array' ( 'Int' )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) '))' )* ( '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite '))' )* ')'
            {
            match(input,22,FOLLOW_22_in_model107); 

            // ../src/grammar/z3.g:30:3: ( '(define-fun' id= IDENT '(' ( IDENT TYPE )* ')' TYPE val= value ')' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==21) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==IDENT) ) {
                        int LA6_3 = input.LA(3);

                        if ( (LA6_3==15) ) {
                            alt6=1;
                        }


                    }


                }


                switch (alt6) {
            	case 1 :
            	    // ../src/grammar/z3.g:30:4: '(define-fun' id= IDENT '(' ( IDENT TYPE )* ')' TYPE val= value ')'
            	    {
            	    match(input,21,FOLLOW_21_in_model112); 

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_model118); 

            	    match(input,15,FOLLOW_15_in_model121); 

            	    // ../src/grammar/z3.g:30:33: ( IDENT TYPE )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==IDENT) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // ../src/grammar/z3.g:30:34: IDENT TYPE
            	    	    {
            	    	    match(input,IDENT,FOLLOW_IDENT_in_model123); 

            	    	    match(input,TYPE,FOLLOW_TYPE_in_model126); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);


            	    match(input,23,FOLLOW_23_in_model129); 

            	    match(input,TYPE,FOLLOW_TYPE_in_model131); 

            	    pushFollow(FOLLOW_value_in_model137);
            	    val=value();

            	    state._fsp--;


            	    match(input,23,FOLLOW_23_in_model139); 

            	    example += (id!=null?id.getText():null) + "=" + val + "\n";

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            HashMap m = new HashMap();

            // ../src/grammar/z3.g:32:31: ( '(define-fun' id= IDENT '()' '(Array' ( 'Int' )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) '))' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==IDENT) ) {
                        int LA8_3 = input.LA(3);

                        if ( (LA8_3==16) ) {
                            alt8=1;
                        }


                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../src/grammar/z3.g:32:32: '(define-fun' id= IDENT '()' '(Array' ( 'Int' )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) '))'
            	    {
            	    match(input,21,FOLLOW_21_in_model158); 

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_model165); 

            	    match(input,16,FOLLOW_16_in_model167); 

            	    example = (id!=null?id.getText():null);

            	    match(input,18,FOLLOW_18_in_model179); 

            	    // ../src/grammar/z3.g:33:17: ( 'Int' )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==25) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../src/grammar/z3.g:33:18: 'Int'
            	    	    {
            	    	    match(input,25,FOLLOW_25_in_model181); 

            	    	    example += "[ ]";

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt7 >= 1 ) break loop7;
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);


            	    match(input,TYPE,FOLLOW_TYPE_in_model186); 

            	    match(input,23,FOLLOW_23_in_model189); 

            	    match(input,19,FOLLOW_19_in_model193); 

            	    // ../src/grammar/z3.g:34:23: ( IDENT '!' INT )
            	    // ../src/grammar/z3.g:34:24: IDENT '!' INT
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_model201); 

            	    match(input,14,FOLLOW_14_in_model203); 

            	    match(input,INT,FOLLOW_INT_in_model205); 

            	    }


            	    match(input,24,FOLLOW_24_in_model207); 

            	    m.put((id2!=null?id2.getText():null),(id!=null?id.getText():null));

            	    example += "\n";

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // ../src/grammar/z3.g:35:3: ( '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite '))' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==21) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../src/grammar/z3.g:35:4: '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite '))'
            	    {
            	    match(input,21,FOLLOW_21_in_model217); 

            	    // ../src/grammar/z3.g:35:24: ( IDENT '!' INT )
            	    // ../src/grammar/z3.g:35:25: IDENT '!' INT
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_model224); 

            	    match(input,14,FOLLOW_14_in_model226); 

            	    match(input,INT,FOLLOW_INT_in_model228); 

            	    }


            	    match(input,15,FOLLOW_15_in_model231); 

            	    // ../src/grammar/z3.g:35:43: ( '(' IDENT '!' INT TYPE ')' )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==15) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../src/grammar/z3.g:35:44: '(' IDENT '!' INT TYPE ')'
            	    	    {
            	    	    match(input,15,FOLLOW_15_in_model233); 

            	    	    match(input,IDENT,FOLLOW_IDENT_in_model234); 

            	    	    match(input,14,FOLLOW_14_in_model236); 

            	    	    match(input,INT,FOLLOW_INT_in_model238); 

            	    	    match(input,TYPE,FOLLOW_TYPE_in_model240); 

            	    	    match(input,23,FOLLOW_23_in_model241); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);


            	    match(input,23,FOLLOW_23_in_model244); 

            	    match(input,TYPE,FOLLOW_TYPE_in_model246); 

            	    match(input,15,FOLLOW_15_in_model256); 

            	    pushFollow(FOLLOW_ite_in_model261);
            	    ass=ite();

            	    state._fsp--;


            	    example += m.get((id3!=null?id3.getText():null)) + ass;

            	    match(input,24,FOLLOW_24_in_model264); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(input,23,FOLLOW_23_in_model270); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return example;
    }
    // $ANTLR end "model"



    // $ANTLR start "ite"
    // ../src/grammar/z3.g:40:1: ite returns [String assignment] : ( '(=' IDENT '!' INT i= INT ')' val= value ( value | '(' as= ite ')' ) | '(and' ( '(=' IDENT '!' INT i= INT ')' )+ ')' val= value ( value | '(' as= ite ')' ) );
    public final String ite() throws RecognitionException {
        String assignment = null;


        Token i=null;
        String val =null;

        String as =null;


        try {
            // ../src/grammar/z3.g:41:2: ( '(=' IDENT '!' INT i= INT ')' val= value ( value | '(' as= ite ')' ) | '(and' ( '(=' IDENT '!' INT i= INT ')' )+ ')' val= value ( value | '(' as= ite ')' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            else if ( (LA14_0==20) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // ../src/grammar/z3.g:41:4: '(=' IDENT '!' INT i= INT ')' val= value ( value | '(' as= ite ')' )
                    {
                    match(input,17,FOLLOW_17_in_ite284); 

                    match(input,IDENT,FOLLOW_IDENT_in_ite286); 

                    match(input,14,FOLLOW_14_in_ite288); 

                    match(input,INT,FOLLOW_INT_in_ite290); 

                    i=(Token)match(input,INT,FOLLOW_INT_in_ite296); 

                    match(input,23,FOLLOW_23_in_ite297); 

                    pushFollow(FOLLOW_value_in_ite304);
                    val=value();

                    state._fsp--;


                    assignment = "[" + (i!=null?i.getText():null) + "]" + "=" + val + "\n";

                    // ../src/grammar/z3.g:43:9: ( value | '(' as= ite ')' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==BOOL||LA11_0==INT) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==15) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;

                    }
                    switch (alt11) {
                        case 1 :
                            // ../src/grammar/z3.g:43:10: value
                            {
                            pushFollow(FOLLOW_value_in_ite325);
                            value();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // ../src/grammar/z3.g:43:18: '(' as= ite ')'
                            {
                            match(input,15,FOLLOW_15_in_ite329); 

                            pushFollow(FOLLOW_ite_in_ite332);
                            as=ite();

                            state._fsp--;


                            match(input,23,FOLLOW_23_in_ite333); 

                            assignment += as;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../src/grammar/z3.g:44:4: '(and' ( '(=' IDENT '!' INT i= INT ')' )+ ')' val= value ( value | '(' as= ite ')' )
                    {
                    match(input,20,FOLLOW_20_in_ite340); 

                    // ../src/grammar/z3.g:44:10: ( '(=' IDENT '!' INT i= INT ')' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==17) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../src/grammar/z3.g:44:11: '(=' IDENT '!' INT i= INT ')'
                    	    {
                    	    match(input,17,FOLLOW_17_in_ite342); 

                    	    match(input,IDENT,FOLLOW_IDENT_in_ite344); 

                    	    match(input,14,FOLLOW_14_in_ite346); 

                    	    match(input,INT,FOLLOW_INT_in_ite348); 

                    	    i=(Token)match(input,INT,FOLLOW_INT_in_ite354); 

                    	    match(input,23,FOLLOW_23_in_ite355); 

                    	    assignment += "["+(i!=null?i.getText():null)+"]";

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    match(input,23,FOLLOW_23_in_ite359); 

                    pushFollow(FOLLOW_value_in_ite371);
                    val=value();

                    state._fsp--;


                    assignment += "=" + val + "\n";

                    // ../src/grammar/z3.g:45:62: ( value | '(' as= ite ')' )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==BOOL||LA13_0==INT) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==15) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;

                    }
                    switch (alt13) {
                        case 1 :
                            // ../src/grammar/z3.g:45:63: value
                            {
                            pushFollow(FOLLOW_value_in_ite375);
                            value();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // ../src/grammar/z3.g:45:71: '(' as= ite ')'
                            {
                            match(input,15,FOLLOW_15_in_ite379); 

                            pushFollow(FOLLOW_ite_in_ite382);
                            as=ite();

                            state._fsp--;


                            match(input,23,FOLLOW_23_in_ite383); 

                            assignment += as;

                            }
                            break;

                    }


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
        return assignment;
    }
    // $ANTLR end "ite"



    // $ANTLR start "value"
    // ../src/grammar/z3.g:48:1: value returns [String content] : ( INT | BOOL );
    public final String value() throws RecognitionException {
        String content = null;


        Token INT1=null;
        Token BOOL2=null;

        try {
            // ../src/grammar/z3.g:49:2: ( INT | BOOL )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==INT) ) {
                alt15=1;
            }
            else if ( (LA15_0==BOOL) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // ../src/grammar/z3.g:49:4: INT
                    {
                    INT1=(Token)match(input,INT,FOLLOW_INT_in_value400); 

                    content =(INT1!=null?INT1.getText():null);

                    }
                    break;
                case 2 :
                    // ../src/grammar/z3.g:50:4: BOOL
                    {
                    BOOL2=(Token)match(input,BOOL,FOLLOW_BOOL_in_value407); 

                    content = (BOOL2!=null?BOOL2.getText():null);

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
        return content;
    }
    // $ANTLR end "value"

    // Delegated rules


 

    public static final BitSet FOLLOW_block_in_start37 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_28_in_block53 = new BitSet(new long[]{0x000000001FFFFFF2L});
    public static final BitSet FOLLOW_26_in_block68 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_model_in_block78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_block85 = new BitSet(new long[]{0x000000001FFFFFF2L});
    public static final BitSet FOLLOW_22_in_model107 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_21_in_model112 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_model118 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_model121 = new BitSet(new long[]{0x0000000000800100L});
    public static final BitSet FOLLOW_IDENT_in_model123 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_TYPE_in_model126 = new BitSet(new long[]{0x0000000000800100L});
    public static final BitSet FOLLOW_23_in_model129 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_TYPE_in_model131 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_value_in_model137 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_model139 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_21_in_model158 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_model165 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model167 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_model179 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_model181 = new BitSet(new long[]{0x0000000002000800L});
    public static final BitSet FOLLOW_TYPE_in_model186 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_model189 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_model193 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_model201 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model203 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_model205 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_model207 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_21_in_model217 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_model224 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model226 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_model228 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_model231 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_model233 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_model234 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model236 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_model238 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_TYPE_in_model240 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_model241 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_23_in_model244 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_TYPE_in_model246 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_model256 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_ite_in_model261 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_model264 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_23_in_model270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ite284 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_ite286 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ite288 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_ite290 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_ite296 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ite297 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_value_in_ite304 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_value_in_ite325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ite329 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_ite_in_ite332 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ite333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ite340 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ite342 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_ite344 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ite346 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_ite348 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_ite354 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ite355 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_23_in_ite359 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_value_in_ite371 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_value_in_ite375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ite379 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_ite_in_ite382 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ite383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_value400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_value407 = new BitSet(new long[]{0x0000000000000002L});

}