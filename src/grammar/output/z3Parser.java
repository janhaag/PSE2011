// $ANTLR 3.4 C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g 2012-03-08 01:55:01

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL", "IDENT", "INT", "TYPE", "WS", "'!'", "'('", "'(Array'", "'(define-fun'", "'(model'", "')'", "'='", "'_'", "'and'", "'as-array'", "'ite'", "'sat'", "'unknown'", "'unsat'"
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
    public static final int BOOL=4;
    public static final int IDENT=5;
    public static final int INT=6;
    public static final int TYPE=7;
    public static final int WS=8;

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
    public String getGrammarFileName() { return "C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g"; }


    	HashMap<String,String> m = new HashMap<String,String>();



    // $ANTLR start "start"
    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:18:1: start returns [LinkedList<Pair<Boolean,String>> list] : (pair= block )+ ;
    public final LinkedList<Pair<Boolean,String>> start() throws RecognitionException {
        LinkedList<Pair<Boolean,String>> list = null;


        Pair<Boolean, String> pair =null;


        list = new LinkedList<Pair<Boolean,String>>();
        try {
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:19:2: ( (pair= block )+ )
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:19:3: (pair= block )+
            {
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:19:3: (pair= block )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 20 && LA1_0 <= 22)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:19:4: pair= block
            	    {
            	    pushFollow(FOLLOW_block_in_start42);
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
    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:22:1: block returns [Pair<Boolean, String> result] : ( 'unsat' ( . )* | 'sat' example= model | 'unknown' ( . )* );
    public final Pair<Boolean, String> block() throws RecognitionException {
        Pair<Boolean, String> result = null;


        String example =null;


        try {
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:23:2: ( 'unsat' ( . )* | 'sat' example= model | 'unknown' ( . )* )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case 21:
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
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:23:3: 'unsat' ( . )*
                    {
                    match(input,22,FOLLOW_22_in_block58); 

                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:24:5: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        switch ( input.LA(1) ) {
                        case EOF:
                            {
                            alt2=2;
                            }
                            break;
                        case 22:
                            {
                            alt2=2;
                            }
                            break;
                        case 20:
                            {
                            alt2=2;
                            }
                            break;
                        case 21:
                            {
                            alt2=2;
                            }
                            break;
                        case BOOL:
                        case IDENT:
                        case INT:
                        case TYPE:
                        case WS:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            {
                            alt2=1;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:24:5: .
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
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:25:5: 'sat' example= model
                    {
                    match(input,20,FOLLOW_20_in_block73); 

                    pushFollow(FOLLOW_model_in_block83);
                    example=model();

                    state._fsp--;


                    result = new Pair(false, example);

                    }
                    break;
                case 3 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:27:4: 'unknown' ( . )*
                    {
                    match(input,21,FOLLOW_21_in_block90); 

                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:28:3: ( . )*
                    loop3:
                    do {
                        int alt3=2;
                        switch ( input.LA(1) ) {
                        case EOF:
                            {
                            alt3=2;
                            }
                            break;
                        case 22:
                            {
                            alt3=2;
                            }
                            break;
                        case 20:
                            {
                            alt3=2;
                            }
                            break;
                        case 21:
                            {
                            alt3=2;
                            }
                            break;
                        case BOOL:
                        case IDENT:
                        case INT:
                        case TYPE:
                        case WS:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            {
                            alt3=1;
                            }
                            break;

                        }

                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:28:3: .
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
    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:31:1: model returns [String example] : '(model' ( ( '(define-fun' id= IDENT '(' ( '(' IDENT ( '!' INT )* TYPE ')' )* ')' TYPE val= value ')' ) | ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(' '_' 'as-array' id2= ( IDENT ( '!' INT )* ) ')' ')' ) | ( '(define-fun' id3= IDENT ( '!' INT )+ '(' ( '(' IDENT ( '!' INT )+ TYPE ')' )* ')' TYPE ( '(' ass= ite[h] ')' | '(' f= function[h] ')' )? (v= value )? ')' ) )* ')' ;
    public final String model() throws RecognitionException {
        String example = null;


        Token id=null;
        Token id2=null;
        Token id3=null;
        String val =null;

        String ass =null;

        String f =null;

        String v =null;


        example = "";  String h; int i; int man = 0;
        try {
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:32:2: ( '(model' ( ( '(define-fun' id= IDENT '(' ( '(' IDENT ( '!' INT )* TYPE ')' )* ')' TYPE val= value ')' ) | ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(' '_' 'as-array' id2= ( IDENT ( '!' INT )* ) ')' ')' ) | ( '(define-fun' id3= IDENT ( '!' INT )+ '(' ( '(' IDENT ( '!' INT )+ TYPE ')' )* ')' TYPE ( '(' ass= ite[h] ')' | '(' f= function[h] ')' )? (v= value )? ')' ) )* ')' )
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:32:4: '(model' ( ( '(define-fun' id= IDENT '(' ( '(' IDENT ( '!' INT )* TYPE ')' )* ')' TYPE val= value ')' ) | ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(' '_' 'as-array' id2= ( IDENT ( '!' INT )* ) ')' ')' ) | ( '(define-fun' id3= IDENT ( '!' INT )+ '(' ( '(' IDENT ( '!' INT )+ TYPE ')' )* ')' TYPE ( '(' ass= ite[h] ')' | '(' f= function[h] ')' )? (v= value )? ')' ) )* ')'
            {
            match(input,13,FOLLOW_13_in_model116); 

            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:32:13: ( ( '(define-fun' id= IDENT '(' ( '(' IDENT ( '!' INT )* TYPE ')' )* ')' TYPE val= value ')' ) | ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(' '_' 'as-array' id2= ( IDENT ( '!' INT )* ) ')' ')' ) | ( '(define-fun' id3= IDENT ( '!' INT )+ '(' ( '(' IDENT ( '!' INT )+ TYPE ')' )* ')' TYPE ( '(' ass= ite[h] ')' | '(' f= function[h] ')' )? (v= value )? ')' ) )*
            loop14:
            do {
                int alt14=4;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==12) ) {
                    int LA14_2 = input.LA(2);

                    if ( (LA14_2==IDENT) ) {
                        int LA14_3 = input.LA(3);

                        if ( (LA14_3==10) ) {
                            int LA14_4 = input.LA(4);

                            if ( (LA14_4==14) ) {
                                int LA14_6 = input.LA(5);

                                if ( (LA14_6==TYPE) ) {
                                    alt14=1;
                                }
                                else if ( (LA14_6==11) ) {
                                    alt14=2;
                                }


                            }
                            else if ( (LA14_4==10) ) {
                                alt14=1;
                            }


                        }
                        else if ( (LA14_3==9) ) {
                            alt14=3;
                        }


                    }


                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:33:3: ( '(define-fun' id= IDENT '(' ( '(' IDENT ( '!' INT )* TYPE ')' )* ')' TYPE val= value ')' )
            	    {
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:33:3: ( '(define-fun' id= IDENT '(' ( '(' IDENT ( '!' INT )* TYPE ')' )* ')' TYPE val= value ')' )
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:33:4: '(define-fun' id= IDENT '(' ( '(' IDENT ( '!' INT )* TYPE ')' )* ')' TYPE val= value ')'
            	    {
            	    match(input,12,FOLLOW_12_in_model123); 

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_model129); 

            	    match(input,10,FOLLOW_10_in_model132); 

            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:33:33: ( '(' IDENT ( '!' INT )* TYPE ')' )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==10) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:33:34: '(' IDENT ( '!' INT )* TYPE ')'
            	    	    {
            	    	    match(input,10,FOLLOW_10_in_model134); 

            	    	    match(input,IDENT,FOLLOW_IDENT_in_model135); 

            	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:33:42: ( '!' INT )*
            	    	    loop5:
            	    	    do {
            	    	        int alt5=2;
            	    	        int LA5_0 = input.LA(1);

            	    	        if ( (LA5_0==9) ) {
            	    	            alt5=1;
            	    	        }


            	    	        switch (alt5) {
            	    	    	case 1 :
            	    	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:33:43: '!' INT
            	    	    	    {
            	    	    	    match(input,9,FOLLOW_9_in_model137); 

            	    	    	    match(input,INT,FOLLOW_INT_in_model139); 

            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    break loop5;
            	    	        }
            	    	    } while (true);


            	    	    match(input,TYPE,FOLLOW_TYPE_in_model144); 

            	    	    match(input,14,FOLLOW_14_in_model145); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);


            	    match(input,14,FOLLOW_14_in_model148); 

            	    match(input,TYPE,FOLLOW_TYPE_in_model150); 

            	    pushFollow(FOLLOW_value_in_model156);
            	    val=value();

            	    state._fsp--;


            	    match(input,14,FOLLOW_14_in_model158); 

            	    example += (id!=null?id.getText():null) + "=" + val + "; ";

            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:35:4: ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(' '_' 'as-array' id2= ( IDENT ( '!' INT )* ) ')' ')' )
            	    {
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:35:4: ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(' '_' 'as-array' id2= ( IDENT ( '!' INT )* ) ')' ')' )
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:35:5: '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(' '_' 'as-array' id2= ( IDENT ( '!' INT )* ) ')' ')'
            	    {
            	    match(input,12,FOLLOW_12_in_model179); 

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_model186); 

            	    match(input,10,FOLLOW_10_in_model188); 

            	    match(input,14,FOLLOW_14_in_model190); 

            	    example = (id!=null?id.getText():null);

            	    match(input,11,FOLLOW_11_in_model204); 

            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:36:19: ( TYPE )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==TYPE) ) {
            	            int LA7_1 = input.LA(2);

            	            if ( (LA7_1==TYPE) ) {
            	                alt7=1;
            	            }


            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:36:20: TYPE
            	    	    {
            	    	    match(input,TYPE,FOLLOW_TYPE_in_model206); 

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


            	    match(input,TYPE,FOLLOW_TYPE_in_model212); 

            	    match(input,14,FOLLOW_14_in_model215); 

            	    match(input,10,FOLLOW_10_in_model219); 

            	    match(input,16,FOLLOW_16_in_model221); 

            	    match(input,18,FOLLOW_18_in_model223); 

            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:37:29: ( IDENT ( '!' INT )* )
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:37:30: IDENT ( '!' INT )*
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_model231); 

            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:37:36: ( '!' INT )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==9) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:37:37: '!' INT
            	    	    {
            	    	    match(input,9,FOLLOW_9_in_model234); 

            	    	    match(input,INT,FOLLOW_INT_in_model236); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);


            	    }


            	    match(input,14,FOLLOW_14_in_model240); 

            	    match(input,14,FOLLOW_14_in_model241); 

            	    m.put((id2!=null?id2.getText():null),(id!=null?id.getText():null));

            	    example += "; ";

            	    }


            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:4: ( '(define-fun' id3= IDENT ( '!' INT )+ '(' ( '(' IDENT ( '!' INT )+ TYPE ')' )* ')' TYPE ( '(' ass= ite[h] ')' | '(' f= function[h] ')' )? (v= value )? ')' )
            	    {
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:4: ( '(define-fun' id3= IDENT ( '!' INT )+ '(' ( '(' IDENT ( '!' INT )+ TYPE ')' )* ')' TYPE ( '(' ass= ite[h] ')' | '(' f= function[h] ')' )? (v= value )? ')' )
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:5: '(define-fun' id3= IDENT ( '!' INT )+ '(' ( '(' IDENT ( '!' INT )+ TYPE ')' )* ')' TYPE ( '(' ass= ite[h] ')' | '(' f= function[h] ')' )? (v= value )? ')'
            	    {
            	    match(input,12,FOLLOW_12_in_model251); 

            	    id3=(Token)match(input,IDENT,FOLLOW_IDENT_in_model257); 

            	    i = 0;

            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:40: ( '!' INT )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==9) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:41: '!' INT
            	    	    {
            	    	    match(input,9,FOLLOW_9_in_model262); 

            	    	    match(input,INT,FOLLOW_INT_in_model264); 

            	    	    i++;

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


            	    match(input,10,FOLLOW_10_in_model268); 

            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:59: ( '(' IDENT ( '!' INT )+ TYPE ')' )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==10) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:60: '(' IDENT ( '!' INT )+ TYPE ')'
            	    	    {
            	    	    match(input,10,FOLLOW_10_in_model270); 

            	    	    match(input,IDENT,FOLLOW_IDENT_in_model271); 

            	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:69: ( '!' INT )+
            	    	    int cnt10=0;
            	    	    loop10:
            	    	    do {
            	    	        int alt10=2;
            	    	        int LA10_0 = input.LA(1);

            	    	        if ( (LA10_0==9) ) {
            	    	            alt10=1;
            	    	        }


            	    	        switch (alt10) {
            	    	    	case 1 :
            	    	    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:38:70: '!' INT
            	    	    	    {
            	    	    	    match(input,9,FOLLOW_9_in_model274); 

            	    	    	    match(input,INT,FOLLOW_INT_in_model276); 

            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    if ( cnt10 >= 1 ) break loop10;
            	    	                EarlyExitException eee =
            	    	                    new EarlyExitException(10, input);
            	    	                throw eee;
            	    	        }
            	    	        cnt10++;
            	    	    } while (true);


            	    	    match(input,TYPE,FOLLOW_TYPE_in_model280); 

            	    	    match(input,14,FOLLOW_14_in_model281); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop11;
            	        }
            	    } while (true);


            	    match(input,14,FOLLOW_14_in_model284); 

            	    match(input,TYPE,FOLLOW_TYPE_in_model286); 

            	    h = m.get((id3!=null?id3.getText():null));
            	    		h = (h != null? h : (id3!=null?id3.getText():null)); if(i > 1){h += "!" + Integer.toString(man++); m.put((id3!=null?id3.getText():null), h);}

            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:40:10: ( '(' ass= ite[h] ')' | '(' f= function[h] ')' )?
            	    int alt12=3;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==10) ) {
            	        int LA12_1 = input.LA(2);

            	        if ( (LA12_1==19) ) {
            	            alt12=1;
            	        }
            	        else if ( (LA12_1==IDENT) ) {
            	            alt12=2;
            	        }
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:40:12: '(' ass= ite[h] ')'
            	            {
            	            match(input,10,FOLLOW_10_in_model301); 

            	            pushFollow(FOLLOW_ite_in_model308);
            	            ass=ite(h);

            	            state._fsp--;


            	            example += ass;

            	            match(input,14,FOLLOW_14_in_model312); 

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:41:12: '(' f= function[h] ')'
            	            {
            	            match(input,10,FOLLOW_10_in_model326); 

            	            pushFollow(FOLLOW_function_in_model331);
            	            f=function(h);

            	            state._fsp--;


            	            example += f;

            	            match(input,14,FOLLOW_14_in_model335); 

            	            }
            	            break;

            	    }


            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:41:64: (v= value )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==BOOL||LA13_0==INT) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:41:65: v= value
            	            {
            	            pushFollow(FOLLOW_value_in_model343);
            	            v=value();

            	            state._fsp--;


            	            example += h + "=" + v;

            	            }
            	            break;

            	    }


            	    match(input,14,FOLLOW_14_in_model347); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input,14,FOLLOW_14_in_model354); 

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
    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:45:1: ite[String id] returns [String assignment] : ( 'ite' '(' '=' IDENT '!' INT i= INT ')' val= value (v= value | '(' as= ite[id] ')' ) | 'ite' '(' 'and' ( '(' '=' IDENT '!' INT i= INT ')' )+ ')' val= value (v= value | '(' as= ite[id] ')' ) );
    public final String ite(String id) throws RecognitionException {
        String assignment = null;


        Token i=null;
        String val =null;

        String v =null;

        String as =null;


        assignment = id;
        try {
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:46:2: ( 'ite' '(' '=' IDENT '!' INT i= INT ')' val= value (v= value | '(' as= ite[id] ')' ) | 'ite' '(' 'and' ( '(' '=' IDENT '!' INT i= INT ')' )+ ')' val= value (v= value | '(' as= ite[id] ')' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==10) ) {
                    int LA18_2 = input.LA(3);

                    if ( (LA18_2==15) ) {
                        alt18=1;
                    }
                    else if ( (LA18_2==17) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:46:4: 'ite' '(' '=' IDENT '!' INT i= INT ')' val= value (v= value | '(' as= ite[id] ')' )
                    {
                    match(input,19,FOLLOW_19_in_ite374); 

                    match(input,10,FOLLOW_10_in_ite376); 

                    match(input,15,FOLLOW_15_in_ite378); 

                    match(input,IDENT,FOLLOW_IDENT_in_ite380); 

                    match(input,9,FOLLOW_9_in_ite382); 

                    match(input,INT,FOLLOW_INT_in_ite384); 

                    i=(Token)match(input,INT,FOLLOW_INT_in_ite390); 

                    match(input,14,FOLLOW_14_in_ite391); 

                    pushFollow(FOLLOW_value_in_ite398);
                    val=value();

                    state._fsp--;


                    assignment += "[" + (i!=null?i.getText():null) + "]" + "=" + val;

                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:48:10: (v= value | '(' as= ite[id] ')' )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==BOOL||LA15_0==INT) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==10) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;

                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:48:11: v= value
                            {
                            pushFollow(FOLLOW_value_in_ite425);
                            v=value();

                            state._fsp--;


                            assignment += " else " + v + "; ";

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:48:70: '(' as= ite[id] ')'
                            {
                            match(input,10,FOLLOW_10_in_ite431); 

                            pushFollow(FOLLOW_ite_in_ite434);
                            as=ite(id);

                            state._fsp--;


                            match(input,14,FOLLOW_14_in_ite436); 

                            assignment += as;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:49:4: 'ite' '(' 'and' ( '(' '=' IDENT '!' INT i= INT ')' )+ ')' val= value (v= value | '(' as= ite[id] ')' )
                    {
                    match(input,19,FOLLOW_19_in_ite443); 

                    match(input,10,FOLLOW_10_in_ite445); 

                    match(input,17,FOLLOW_17_in_ite447); 

                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:49:19: ( '(' '=' IDENT '!' INT i= INT ')' )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==10) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:49:20: '(' '=' IDENT '!' INT i= INT ')'
                    	    {
                    	    match(input,10,FOLLOW_10_in_ite449); 

                    	    match(input,15,FOLLOW_15_in_ite450); 

                    	    match(input,IDENT,FOLLOW_IDENT_in_ite452); 

                    	    match(input,9,FOLLOW_9_in_ite454); 

                    	    match(input,INT,FOLLOW_INT_in_ite456); 

                    	    i=(Token)match(input,INT,FOLLOW_INT_in_ite462); 

                    	    match(input,14,FOLLOW_14_in_ite463); 

                    	    assignment += "["+(i!=null?i.getText():null)+"]";

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


                    match(input,14,FOLLOW_14_in_ite467); 

                    pushFollow(FOLLOW_value_in_ite482);
                    val=value();

                    state._fsp--;


                    assignment += "=" + val + "; ";

                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:50:65: (v= value | '(' as= ite[id] ')' )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==BOOL||LA17_0==INT) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==10) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;

                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:50:66: v= value
                            {
                            pushFollow(FOLLOW_value_in_ite490);
                            v=value();

                            state._fsp--;


                            assignment += " else " + v + "; ";

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:50:124: '(' as= ite[id] ')'
                            {
                            match(input,10,FOLLOW_10_in_ite495); 

                            pushFollow(FOLLOW_ite_in_ite498);
                            as=ite(id);

                            state._fsp--;


                            match(input,14,FOLLOW_14_in_ite500); 

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



    // $ANTLR start "function"
    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:55:1: function[String id] returns [String assignment] :id1= IDENT ( '!' INT )* (val= value |id2= IDENT ( '!' INT )* | '(' f= functionvalue ')' ) ;
    public final String function(String id) throws RecognitionException {
        String assignment = null;


        Token id1=null;
        Token id2=null;
        String val =null;

        String f =null;


        int i;
        try {
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:56:2: (id1= IDENT ( '!' INT )* (val= value |id2= IDENT ( '!' INT )* | '(' f= functionvalue ')' ) )
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:56:4: id1= IDENT ( '!' INT )* (val= value |id2= IDENT ( '!' INT )* | '(' f= functionvalue ')' )
            {
            i=0;

            id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_function531); 

            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:56:23: ( '!' INT )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==9) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:56:24: '!' INT
            	    {
            	    match(input,9,FOLLOW_9_in_function534); 

            	    match(input,INT,FOLLOW_INT_in_function536); 

            	    i++;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            if(i > 1) {assignment = m.get((id1!=null?id1.getText():null));} else{ assignment = (id1!=null?id1.getText():null);}

            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:57:4: (val= value |id2= IDENT ( '!' INT )* | '(' f= functionvalue ')' )
            int alt21=3;
            switch ( input.LA(1) ) {
            case BOOL:
            case INT:
                {
                alt21=1;
                }
                break;
            case IDENT:
                {
                alt21=2;
                }
                break;
            case 10:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }

            switch (alt21) {
                case 1 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:57:5: val= value
                    {
                    pushFollow(FOLLOW_value_in_function552);
                    val=value();

                    state._fsp--;


                    assignment += val;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:58:4: id2= IDENT ( '!' INT )*
                    {
                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_function564); 

                    assignment += (id2!=null?id2.getText():null);

                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:58:43: ( '!' INT )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==9) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:58:44: '!' INT
                    	    {
                    	    match(input,9,FOLLOW_9_in_function568); 

                    	    match(input,INT,FOLLOW_INT_in_function570); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:59:4: '(' f= functionvalue ')'
                    {
                    match(input,10,FOLLOW_10_in_function578); 

                    pushFollow(FOLLOW_functionvalue_in_function583);
                    f=functionvalue();

                    state._fsp--;


                    match(input,14,FOLLOW_14_in_function584); 

                    assignment += "(" + f + ")";

                    }
                    break;

            }


            assignment += "; ";

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
    // $ANTLR end "function"



    // $ANTLR start "functionvalue"
    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:61:1: functionvalue returns [String assignment] :id1= IDENT ( '!' INT )* (val= value |id2= IDENT ( '!' INT )* | '(' f= functionvalue ')' ) ;
    public final String functionvalue() throws RecognitionException {
        String assignment = null;


        Token id1=null;
        Token id2=null;
        String val =null;

        String f =null;


        int i;
        try {
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:62:2: (id1= IDENT ( '!' INT )* (val= value |id2= IDENT ( '!' INT )* | '(' f= functionvalue ')' ) )
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:62:4: id1= IDENT ( '!' INT )* (val= value |id2= IDENT ( '!' INT )* | '(' f= functionvalue ')' )
            {
            i=0;

            id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionvalue614); 

            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:62:23: ( '!' INT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==9) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:62:24: '!' INT
            	    {
            	    match(input,9,FOLLOW_9_in_functionvalue617); 

            	    match(input,INT,FOLLOW_INT_in_functionvalue619); 

            	    i++;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            if(i > 1) {assignment = m.get((id1!=null?id1.getText():null));} else{ assignment = (id1!=null?id1.getText():null);}

            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:63:3: (val= value |id2= IDENT ( '!' INT )* | '(' f= functionvalue ')' )
            int alt24=3;
            switch ( input.LA(1) ) {
            case BOOL:
            case INT:
                {
                alt24=1;
                }
                break;
            case IDENT:
                {
                alt24=2;
                }
                break;
            case 10:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:63:4: val= value
                    {
                    pushFollow(FOLLOW_value_in_functionvalue633);
                    val=value();

                    state._fsp--;


                    assignment += '('+ val + ')';

                    }
                    break;
                case 2 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:64:4: id2= IDENT ( '!' INT )*
                    {
                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionvalue644); 

                    assignment +='(' + (id2!=null?id2.getText():null) + ')';

                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:64:54: ( '!' INT )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==9) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:64:55: '!' INT
                    	    {
                    	    match(input,9,FOLLOW_9_in_functionvalue648); 

                    	    match(input,INT,FOLLOW_INT_in_functionvalue650); 

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:65:4: '(' f= functionvalue ')'
                    {
                    match(input,10,FOLLOW_10_in_functionvalue658); 

                    pushFollow(FOLLOW_functionvalue_in_functionvalue663);
                    f=functionvalue();

                    state._fsp--;


                    match(input,14,FOLLOW_14_in_functionvalue664); 

                    assignment +='(' + f + ")";

                    }
                    break;

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
        return assignment;
    }
    // $ANTLR end "functionvalue"



    // $ANTLR start "value"
    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:68:1: value returns [String content] : ( INT | BOOL );
    public final String value() throws RecognitionException {
        String content = null;


        Token INT1=null;
        Token BOOL2=null;

        try {
            // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:69:2: ( INT | BOOL )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==INT) ) {
                alt25=1;
            }
            else if ( (LA25_0==BOOL) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:69:4: INT
                    {
                    INT1=(Token)match(input,INT,FOLLOW_INT_in_value683); 

                    content =(INT1!=null?INT1.getText():null);

                    }
                    break;
                case 2 :
                    // C:\\Users\\Lin\\Git\\PSE2011\\src\\grammar\\z3.g:70:4: BOOL
                    {
                    BOOL2=(Token)match(input,BOOL,FOLLOW_BOOL_in_value690); 

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


 

    public static final BitSet FOLLOW_block_in_start42 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_22_in_block58 = new BitSet(new long[]{0x00000000007FFFF2L});
    public static final BitSet FOLLOW_20_in_block73 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_model_in_block83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_block90 = new BitSet(new long[]{0x00000000007FFFF2L});
    public static final BitSet FOLLOW_13_in_model116 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_12_in_model123 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model129 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_model132 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_10_in_model134 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model135 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_9_in_model137 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_model139 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_TYPE_in_model144 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model145 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_14_in_model148 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model150 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_value_in_model156 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model158 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_12_in_model179 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model186 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_model188 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model190 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_model204 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model206 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model212 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model215 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_model219 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model221 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_model223 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model231 = new BitSet(new long[]{0x0000000000004200L});
    public static final BitSet FOLLOW_9_in_model234 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_model236 = new BitSet(new long[]{0x0000000000004200L});
    public static final BitSet FOLLOW_14_in_model240 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model241 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_12_in_model251 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model257 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_model262 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_model264 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_10_in_model268 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_10_in_model270 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model271 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_model274 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_model276 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_TYPE_in_model280 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model281 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_14_in_model284 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model286 = new BitSet(new long[]{0x0000000000004450L});
    public static final BitSet FOLLOW_10_in_model301 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ite_in_model308 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model312 = new BitSet(new long[]{0x0000000000004050L});
    public static final BitSet FOLLOW_10_in_model326 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_function_in_model331 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model335 = new BitSet(new long[]{0x0000000000004050L});
    public static final BitSet FOLLOW_value_in_model343 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_model347 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_14_in_model354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ite374 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ite376 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ite378 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_ite380 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ite382 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_ite384 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_ite390 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ite391 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_value_in_ite398 = new BitSet(new long[]{0x0000000000000450L});
    public static final BitSet FOLLOW_value_in_ite425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ite431 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ite_in_ite434 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ite436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ite443 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ite445 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ite447 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ite449 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ite450 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_ite452 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ite454 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_ite456 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_ite462 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ite463 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_14_in_ite467 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_value_in_ite482 = new BitSet(new long[]{0x0000000000000450L});
    public static final BitSet FOLLOW_value_in_ite490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ite495 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ite_in_ite498 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ite500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_function531 = new BitSet(new long[]{0x0000000000000670L});
    public static final BitSet FOLLOW_9_in_function534 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_function536 = new BitSet(new long[]{0x0000000000000670L});
    public static final BitSet FOLLOW_value_in_function552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_function564 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_function568 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_function570 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_10_in_function578 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_functionvalue_in_function583 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_function584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_functionvalue614 = new BitSet(new long[]{0x0000000000000670L});
    public static final BitSet FOLLOW_9_in_functionvalue617 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_functionvalue619 = new BitSet(new long[]{0x0000000000000670L});
    public static final BitSet FOLLOW_value_in_functionvalue633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_functionvalue644 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_functionvalue648 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_functionvalue650 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_10_in_functionvalue658 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_functionvalue_in_functionvalue663 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_functionvalue664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_value683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_value690 = new BitSet(new long[]{0x0000000000000002L});

}