// $ANTLR 3.4 ../src/grammar/z3.g 2012-01-18 17:18:48

    package verifier;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class z3Lexer extends Lexer {
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
    public static final int T__29=29;
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public z3Lexer() {} 
    public z3Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public z3Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "../src/grammar/z3.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:6:7: ( '!' )
            // ../src/grammar/z3.g:6:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:7:7: ( '(' )
            // ../src/grammar/z3.g:7:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:8:7: ( '()' )
            // ../src/grammar/z3.g:8:9: '()'
            {
            match("()"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:9:7: ( '(=' )
            // ../src/grammar/z3.g:9:9: '(='
            {
            match("(="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:10:7: ( '(Array' )
            // ../src/grammar/z3.g:10:9: '(Array'
            {
            match("(Array"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:11:7: ( '(_as-array' )
            // ../src/grammar/z3.g:11:9: '(_as-array'
            {
            match("(_as-array"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:12:7: ( '(and' )
            // ../src/grammar/z3.g:12:9: '(and'
            {
            match("(and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:13:7: ( '(define-fun' )
            // ../src/grammar/z3.g:13:9: '(define-fun'
            {
            match("(define-fun"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:14:7: ( '(model' )
            // ../src/grammar/z3.g:14:9: '(model'
            {
            match("(model"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:15:7: ( ')' )
            // ../src/grammar/z3.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:16:7: ( '))' )
            // ../src/grammar/z3.g:16:9: '))'
            {
            match("))"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:17:7: ( 'Int' )
            // ../src/grammar/z3.g:17:9: 'Int'
            {
            match("Int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:18:7: ( 'define-fun' )
            // ../src/grammar/z3.g:18:9: 'define-fun'
            {
            match("define-fun"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:19:7: ( 'sat' )
            // ../src/grammar/z3.g:19:9: 'sat'
            {
            match("sat"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:20:7: ( 'unknown' )
            // ../src/grammar/z3.g:20:9: 'unknown'
            {
            match("unknown"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:21:7: ( 'unsat' )
            // ../src/grammar/z3.g:21:9: 'unsat'
            {
            match("unsat"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:40:6: ( 'Int' | 'Bool' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='I') ) {
                alt1=1;
            }
            else if ( (LA1_0=='B') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // ../src/grammar/z3.g:40:8: 'Int'
                    {
                    match("Int"); 



                    }
                    break;
                case 2 :
                    // ../src/grammar/z3.g:41:4: 'Bool'
                    {
                    match("Bool"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:45:6: ( 'true' | 'false' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='t') ) {
                alt2=1;
            }
            else if ( (LA2_0=='f') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // ../src/grammar/z3.g:45:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // ../src/grammar/z3.g:45:17: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOL"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:48:5: ( ( '0' .. '9' )+ )
            // ../src/grammar/z3.g:48:7: ( '0' .. '9' )+
            {
            // ../src/grammar/z3.g:48:7: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../src/grammar/z3.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:51:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // ../src/grammar/z3.g:51:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:58:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // ../src/grammar/z3.g:58:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // ../src/grammar/z3.g:58:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\\') ) {
                alt4=1;
            }
            else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '&')||(LA4_0 >= '(' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // ../src/grammar/z3.g:58:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // ../src/grammar/z3.g:58:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:61:6: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // ../src/grammar/z3.g:61:8: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // ../src/grammar/z3.g:61:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../src/grammar/z3.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // ../src/grammar/z3.g:66:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // ../src/grammar/z3.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // ../src/grammar/z3.g:70:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt6=1;
                    }
                    break;
                case 'u':
                    {
                    alt6=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt6=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // ../src/grammar/z3.g:70:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // ../src/grammar/z3.g:71:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // ../src/grammar/z3.g:72:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // ../src/grammar/z3.g:77:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\\') ) {
                int LA7_1 = input.LA(2);

                if ( ((LA7_1 >= '0' && LA7_1 <= '3')) ) {
                    int LA7_2 = input.LA(3);

                    if ( ((LA7_2 >= '0' && LA7_2 <= '7')) ) {
                        int LA7_4 = input.LA(4);

                        if ( ((LA7_4 >= '0' && LA7_4 <= '7')) ) {
                            alt7=1;
                        }
                        else {
                            alt7=2;
                        }
                    }
                    else {
                        alt7=3;
                    }
                }
                else if ( ((LA7_1 >= '4' && LA7_1 <= '7')) ) {
                    int LA7_3 = input.LA(3);

                    if ( ((LA7_3 >= '0' && LA7_3 <= '7')) ) {
                        alt7=2;
                    }
                    else {
                        alt7=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // ../src/grammar/z3.g:77:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // ../src/grammar/z3.g:78:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // ../src/grammar/z3.g:79:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // ../src/grammar/z3.g:84:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // ../src/grammar/z3.g:84:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // ../src/grammar/z3.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | TYPE | BOOL | INT | WS | CHAR | IDENT )
        int alt8=22;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // ../src/grammar/z3.g:1:10: T__14
                {
                mT__14(); 


                }
                break;
            case 2 :
                // ../src/grammar/z3.g:1:16: T__15
                {
                mT__15(); 


                }
                break;
            case 3 :
                // ../src/grammar/z3.g:1:22: T__16
                {
                mT__16(); 


                }
                break;
            case 4 :
                // ../src/grammar/z3.g:1:28: T__17
                {
                mT__17(); 


                }
                break;
            case 5 :
                // ../src/grammar/z3.g:1:34: T__18
                {
                mT__18(); 


                }
                break;
            case 6 :
                // ../src/grammar/z3.g:1:40: T__19
                {
                mT__19(); 


                }
                break;
            case 7 :
                // ../src/grammar/z3.g:1:46: T__20
                {
                mT__20(); 


                }
                break;
            case 8 :
                // ../src/grammar/z3.g:1:52: T__21
                {
                mT__21(); 


                }
                break;
            case 9 :
                // ../src/grammar/z3.g:1:58: T__22
                {
                mT__22(); 


                }
                break;
            case 10 :
                // ../src/grammar/z3.g:1:64: T__23
                {
                mT__23(); 


                }
                break;
            case 11 :
                // ../src/grammar/z3.g:1:70: T__24
                {
                mT__24(); 


                }
                break;
            case 12 :
                // ../src/grammar/z3.g:1:76: T__25
                {
                mT__25(); 


                }
                break;
            case 13 :
                // ../src/grammar/z3.g:1:82: T__26
                {
                mT__26(); 


                }
                break;
            case 14 :
                // ../src/grammar/z3.g:1:88: T__27
                {
                mT__27(); 


                }
                break;
            case 15 :
                // ../src/grammar/z3.g:1:94: T__28
                {
                mT__28(); 


                }
                break;
            case 16 :
                // ../src/grammar/z3.g:1:100: T__29
                {
                mT__29(); 


                }
                break;
            case 17 :
                // ../src/grammar/z3.g:1:106: TYPE
                {
                mTYPE(); 


                }
                break;
            case 18 :
                // ../src/grammar/z3.g:1:111: BOOL
                {
                mBOOL(); 


                }
                break;
            case 19 :
                // ../src/grammar/z3.g:1:116: INT
                {
                mINT(); 


                }
                break;
            case 20 :
                // ../src/grammar/z3.g:1:120: WS
                {
                mWS(); 


                }
                break;
            case 21 :
                // ../src/grammar/z3.g:1:123: CHAR
                {
                mCHAR(); 


                }
                break;
            case 22 :
                // ../src/grammar/z3.g:1:128: IDENT
                {
                mIDENT(); 


                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\2\uffff\1\26\1\30\7\16\16\uffff\7\16\1\50\1\16\1\52\5\16\1\uffff"+
        "\1\16\1\uffff\2\16\1\63\1\64\3\16\1\70\2\uffff\1\64\2\16\2\uffff"+
        "\1\73\1\uffff";
    static final String DFA8_eofS =
        "\74\uffff";
    static final String DFA8_minS =
        "\1\11\1\uffff\2\51\1\156\1\145\1\141\1\156\1\157\1\162\1\141\16"+
        "\uffff\1\164\1\146\1\164\1\153\1\157\1\165\1\154\1\60\1\151\1\60"+
        "\1\156\1\141\1\154\1\145\1\163\1\uffff\1\156\1\uffff\1\157\1\164"+
        "\2\60\2\145\1\167\1\60\2\uffff\1\60\1\55\1\156\2\uffff\1\60\1\uffff";
    static final String DFA8_maxS =
        "\1\172\1\uffff\1\155\1\51\1\156\1\145\1\141\1\156\1\157\1\162\1"+
        "\141\16\uffff\1\164\1\146\1\164\1\163\1\157\1\165\1\154\1\172\1"+
        "\151\1\172\1\156\1\141\1\154\1\145\1\163\1\uffff\1\156\1\uffff\1"+
        "\157\1\164\2\172\2\145\1\167\1\172\2\uffff\1\172\1\55\1\156\2\uffff"+
        "\1\172\1\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\11\uffff\1\23\1\24\1\25\1\26\1\3\1\4\1\5\1\6\1\7\1"+
        "\10\1\11\1\2\1\13\1\12\17\uffff\1\14\1\uffff\1\16\10\uffff\1\21"+
        "\1\22\3\uffff\1\20\1\15\1\uffff\1\17";
    static final String DFA8_specialS =
        "\74\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\14\2\uffff\1\14\22\uffff\1\14\1\1\5\uffff\1\15\1\2\1\3\6"+
            "\uffff\12\13\7\uffff\1\16\1\10\6\16\1\4\21\16\4\uffff\1\16\1"+
            "\uffff\3\16\1\5\1\16\1\12\14\16\1\6\1\11\1\7\5\16",
            "",
            "\1\17\23\uffff\1\20\3\uffff\1\21\35\uffff\1\22\1\uffff\1\23"+
            "\2\uffff\1\24\10\uffff\1\25",
            "\1\27",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43\7\uffff\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\51",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "\1\60",
            "",
            "\1\61",
            "\1\62",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\65",
            "\1\66",
            "\1\67",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\71",
            "\1\72",
            "",
            "",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
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
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | TYPE | BOOL | INT | WS | CHAR | IDENT );";
        }
    }
 

}