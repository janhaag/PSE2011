// $ANTLR 3.4 C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g 2012-01-31 13:42:51

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL", "IDENT", "INT", "TYPE", "WS", "'!'", "'('", "'(Array'", "'(_as-array'", "'(and'", "'(define-fun'", "'(model'", "')'", "'='", "'sat'", "'unknown'", "'unsat'"
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
    public String getGrammarFileName() { return "C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g"; }



    // $ANTLR start "start"
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:15:1: start returns [LinkedList<Pair<Boolean,String>> list] : (pair= block )+ ;
    public final LinkedList<Pair<Boolean,String>> start() throws RecognitionException {
        LinkedList<Pair<Boolean,String>> list = null;


        Pair<Boolean, String> pair =null;


        list = new LinkedList<Pair<Boolean,String>>();
        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:16:2: ( (pair= block )+ )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:16:3: (pair= block )+
            {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:16:3: (pair= block )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 18 && LA1_0 <= 20)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:16:4: pair= block
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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:19:1: block returns [Pair<Boolean, String> result] : ( 'unsat' ( . )* | 'sat' example= model | 'unknown' ( . )* );
    public final Pair<Boolean, String> block() throws RecognitionException {
        Pair<Boolean, String> result = null;


        String example =null;


        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:20:2: ( 'unsat' ( . )* | 'sat' example= model | 'unknown' ( . )* )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt4=1;
                }
                break;
            case 18:
                {
                alt4=2;
                }
                break;
            case 19:
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
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:20:3: 'unsat' ( . )*
                    {
                    match(input,20,FOLLOW_20_in_block53); 

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:21:5: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        switch ( input.LA(1) ) {
                        case EOF:
                            {
                            alt2=2;
                            }
                            break;
                        case 20:
                            {
                            alt2=2;
                            }
                            break;
                        case 18:
                            {
                            alt2=2;
                            }
                            break;
                        case 19:
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
                            {
                            alt2=1;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:21:5: .
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
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:22:5: 'sat' example= model
                    {
                    match(input,18,FOLLOW_18_in_block68); 

                    pushFollow(FOLLOW_model_in_block78);
                    example=model();

                    state._fsp--;


                    result = new Pair(false, example);

                    }
                    break;
                case 3 :
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:24:4: 'unknown' ( . )*
                    {
                    match(input,19,FOLLOW_19_in_block85); 

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:25:3: ( . )*
                    loop3:
                    do {
                        int alt3=2;
                        switch ( input.LA(1) ) {
                        case EOF:
                            {
                            alt3=2;
                            }
                            break;
                        case 20:
                            {
                            alt3=2;
                            }
                            break;
                        case 18:
                            {
                            alt3=2;
                            }
                            break;
                        case 19:
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
                            {
                            alt3=1;
                            }
                            break;

                        }

                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:25:3: .
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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:28:1: model returns [String example] : '(model' ( '(define-fun' id= IDENT '(' ( IDENT '!' TYPE )* ')' TYPE val= value ')' )* ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) ')' ')' )* ( '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite[(String)m.get($id3.text)] ')' ')' )* ')' ;
    public final String model() throws RecognitionException {
        String example = null;


        Token id=null;
        Token id2=null;
        Token id3=null;
        String val =null;

        String ass =null;


        example = "";
        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:29:2: ( '(model' ( '(define-fun' id= IDENT '(' ( IDENT '!' TYPE )* ')' TYPE val= value ')' )* ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) ')' ')' )* ( '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite[(String)m.get($id3.text)] ')' ')' )* ')' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:29:4: '(model' ( '(define-fun' id= IDENT '(' ( IDENT '!' TYPE )* ')' TYPE val= value ')' )* ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) ')' ')' )* ( '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite[(String)m.get($id3.text)] ')' ')' )* ')'
            {
            match(input,15,FOLLOW_15_in_model111); 

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:30:3: ( '(define-fun' id= IDENT '(' ( IDENT '!' TYPE )* ')' TYPE val= value ')' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==IDENT) ) {
                        int LA6_3 = input.LA(3);

                        if ( (LA6_3==10) ) {
                            int LA6_4 = input.LA(4);

                            if ( (LA6_4==16) ) {
                                int LA6_5 = input.LA(5);

                                if ( (LA6_5==TYPE) ) {
                                    alt6=1;
                                }


                            }
                            else if ( (LA6_4==IDENT) ) {
                                alt6=1;
                            }


                        }


                    }


                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:30:4: '(define-fun' id= IDENT '(' ( IDENT '!' TYPE )* ')' TYPE val= value ')'
            	    {
            	    match(input,14,FOLLOW_14_in_model116); 

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_model122); 

            	    match(input,10,FOLLOW_10_in_model125); 

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:30:33: ( IDENT '!' TYPE )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==IDENT) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:30:34: IDENT '!' TYPE
            	    	    {
            	    	    match(input,IDENT,FOLLOW_IDENT_in_model127); 

            	    	    match(input,9,FOLLOW_9_in_model129); 

            	    	    match(input,TYPE,FOLLOW_TYPE_in_model132); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);


            	    match(input,16,FOLLOW_16_in_model135); 

            	    match(input,TYPE,FOLLOW_TYPE_in_model137); 

            	    pushFollow(FOLLOW_value_in_model143);
            	    val=value();

            	    state._fsp--;


            	    match(input,16,FOLLOW_16_in_model145); 

            	    example += (id!=null?id.getText():null) + "=" + val + "\n";

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            HashMap m = new HashMap();

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:33:3: ( '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) ')' ')' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==IDENT) ) {
                        int LA8_3 = input.LA(3);

                        if ( (LA8_3==10) ) {
                            alt8=1;
                        }


                    }


                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:33:4: '(define-fun' id= IDENT '(' ')' '(Array' ( TYPE )+ TYPE ')' '(_as-array' id2= ( IDENT '!' INT ) ')' ')'
            	    {
            	    match(input,14,FOLLOW_14_in_model170); 

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_model177); 

            	    match(input,10,FOLLOW_10_in_model179); 

            	    match(input,16,FOLLOW_16_in_model181); 

            	    example = (id!=null?id.getText():null);

            	    match(input,11,FOLLOW_11_in_model195); 

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:34:19: ( TYPE )+
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
            	    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:34:20: TYPE
            	    	    {
            	    	    match(input,TYPE,FOLLOW_TYPE_in_model197); 

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


            	    match(input,TYPE,FOLLOW_TYPE_in_model203); 

            	    match(input,16,FOLLOW_16_in_model206); 

            	    match(input,12,FOLLOW_12_in_model210); 

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:35:23: ( IDENT '!' INT )
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:35:24: IDENT '!' INT
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_model218); 

            	    match(input,9,FOLLOW_9_in_model220); 

            	    match(input,INT,FOLLOW_INT_in_model222); 

            	    }


            	    match(input,16,FOLLOW_16_in_model224); 

            	    match(input,16,FOLLOW_16_in_model225); 

            	    m.put((id2!=null?id2.getText():null),(id!=null?id.getText():null));

            	    example += "\n";

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:36:3: ( '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite[(String)m.get($id3.text)] ')' ')' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:36:4: '(define-fun' id3= ( IDENT '!' INT ) '(' ( '(' IDENT '!' INT TYPE ')' )+ ')' TYPE '(' ass= ite[(String)m.get($id3.text)] ')' ')'
            	    {
            	    match(input,14,FOLLOW_14_in_model235); 

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:36:24: ( IDENT '!' INT )
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:36:25: IDENT '!' INT
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_model242); 

            	    match(input,9,FOLLOW_9_in_model244); 

            	    match(input,INT,FOLLOW_INT_in_model246); 

            	    }


            	    match(input,10,FOLLOW_10_in_model249); 

            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:36:43: ( '(' IDENT '!' INT TYPE ')' )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==10) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:36:44: '(' IDENT '!' INT TYPE ')'
            	    	    {
            	    	    match(input,10,FOLLOW_10_in_model251); 

            	    	    match(input,IDENT,FOLLOW_IDENT_in_model252); 

            	    	    match(input,9,FOLLOW_9_in_model254); 

            	    	    match(input,INT,FOLLOW_INT_in_model256); 

            	    	    match(input,TYPE,FOLLOW_TYPE_in_model258); 

            	    	    match(input,16,FOLLOW_16_in_model259); 

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


            	    match(input,16,FOLLOW_16_in_model262); 

            	    match(input,TYPE,FOLLOW_TYPE_in_model264); 

            	    match(input,10,FOLLOW_10_in_model274); 

            	    pushFollow(FOLLOW_ite_in_model279);
            	    ass=ite((String)m.get((id3!=null?id3.getText():null)));

            	    state._fsp--;


            	    example += ass;

            	    match(input,16,FOLLOW_16_in_model283); 

            	    match(input,16,FOLLOW_16_in_model284); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(input,16,FOLLOW_16_in_model290); 

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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:41:1: ite[String id] returns [String assignment] : ( '(' '=' IDENT '!' INT i= INT ')' val= value ( value | '(' as= ite[id] ')' ) | '(and' ( '(' '=' IDENT '!' INT i= INT ')' )+ ')' val= value ( value | '(' as= ite[id] ')' ) );
    public final String ite(String id) throws RecognitionException {
        String assignment = null;


        Token i=null;
        String val =null;

        String as =null;


        assignment = id;
        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:42:2: ( '(' '=' IDENT '!' INT i= INT ')' val= value ( value | '(' as= ite[id] ')' ) | '(and' ( '(' '=' IDENT '!' INT i= INT ')' )+ ')' val= value ( value | '(' as= ite[id] ')' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==10) ) {
                alt14=1;
            }
            else if ( (LA14_0==13) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:42:4: '(' '=' IDENT '!' INT i= INT ')' val= value ( value | '(' as= ite[id] ')' )
                    {
                    match(input,10,FOLLOW_10_in_ite310); 

                    match(input,17,FOLLOW_17_in_ite311); 

                    match(input,IDENT,FOLLOW_IDENT_in_ite313); 

                    match(input,9,FOLLOW_9_in_ite315); 

                    match(input,INT,FOLLOW_INT_in_ite317); 

                    i=(Token)match(input,INT,FOLLOW_INT_in_ite323); 

                    match(input,16,FOLLOW_16_in_ite324); 

                    pushFollow(FOLLOW_value_in_ite331);
                    val=value();

                    state._fsp--;


                    assignment = "[" + (i!=null?i.getText():null) + "]" + "=" + val + "\n";

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:44:9: ( value | '(' as= ite[id] ')' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==BOOL||LA11_0==INT) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==10) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;

                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:44:10: value
                            {
                            pushFollow(FOLLOW_value_in_ite352);
                            value();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:44:18: '(' as= ite[id] ')'
                            {
                            match(input,10,FOLLOW_10_in_ite356); 

                            pushFollow(FOLLOW_ite_in_ite359);
                            as=ite(id);

                            state._fsp--;


                            match(input,16,FOLLOW_16_in_ite361); 

                            assignment += as;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:45:4: '(and' ( '(' '=' IDENT '!' INT i= INT ')' )+ ')' val= value ( value | '(' as= ite[id] ')' )
                    {
                    match(input,13,FOLLOW_13_in_ite368); 

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:45:10: ( '(' '=' IDENT '!' INT i= INT ')' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==10) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:45:11: '(' '=' IDENT '!' INT i= INT ')'
                    	    {
                    	    match(input,10,FOLLOW_10_in_ite370); 

                    	    match(input,17,FOLLOW_17_in_ite371); 

                    	    match(input,IDENT,FOLLOW_IDENT_in_ite373); 

                    	    match(input,9,FOLLOW_9_in_ite375); 

                    	    match(input,INT,FOLLOW_INT_in_ite377); 

                    	    i=(Token)match(input,INT,FOLLOW_INT_in_ite383); 

                    	    match(input,16,FOLLOW_16_in_ite384); 

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


                    match(input,16,FOLLOW_16_in_ite388); 

                    pushFollow(FOLLOW_value_in_ite400);
                    val=value();

                    state._fsp--;


                    assignment += "=" + val + "\n";

                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:46:62: ( value | '(' as= ite[id] ')' )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==BOOL||LA13_0==INT) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==10) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;

                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:46:63: value
                            {
                            pushFollow(FOLLOW_value_in_ite404);
                            value();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:46:71: '(' as= ite[id] ')'
                            {
                            match(input,10,FOLLOW_10_in_ite408); 

                            pushFollow(FOLLOW_ite_in_ite411);
                            as=ite(id);

                            state._fsp--;


                            match(input,16,FOLLOW_16_in_ite413); 

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
    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:49:1: value returns [String content] : ( INT | BOOL );
    public final String value() throws RecognitionException {
        String content = null;


        Token INT1=null;
        Token BOOL2=null;

        try {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:50:2: ( INT | BOOL )
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
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:50:4: INT
                    {
                    INT1=(Token)match(input,INT,FOLLOW_INT_in_value430); 

                    content =(INT1!=null?INT1.getText():null);

                    }
                    break;
                case 2 :
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\z3.g:51:4: BOOL
                    {
                    BOOL2=(Token)match(input,BOOL,FOLLOW_BOOL_in_value437); 

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


 

    public static final BitSet FOLLOW_block_in_start37 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_20_in_block53 = new BitSet(new long[]{0x00000000001FFFF2L});
    public static final BitSet FOLLOW_18_in_block68 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_model_in_block78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_block85 = new BitSet(new long[]{0x00000000001FFFF2L});
    public static final BitSet FOLLOW_15_in_model111 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_model116 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model122 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_model125 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_IDENT_in_model127 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_model129 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model132 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_16_in_model135 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model137 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_value_in_model143 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model145 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_model170 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model177 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_model179 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model181 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_model195 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model197 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model203 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model206 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_model210 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model218 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_model220 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_model222 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model224 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model225 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_model235 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model242 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_model244 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_model246 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_model249 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_model251 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_model252 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_model254 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_model256 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model258 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model259 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_16_in_model262 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_model264 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_model274 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_ite_in_model279 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model283 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_model284 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_model290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ite310 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ite311 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_ite313 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ite315 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_ite317 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_ite323 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ite324 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_value_in_ite331 = new BitSet(new long[]{0x0000000000000450L});
    public static final BitSet FOLLOW_value_in_ite352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ite356 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_ite_in_ite359 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ite361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ite368 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ite370 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ite371 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_ite373 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ite375 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_ite377 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_ite383 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ite384 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_16_in_ite388 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_value_in_ite400 = new BitSet(new long[]{0x0000000000000450L});
    public static final BitSet FOLLOW_value_in_ite404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ite408 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_ite_in_ite411 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ite413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_value430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_value437 = new BitSet(new long[]{0x0000000000000002L});

}