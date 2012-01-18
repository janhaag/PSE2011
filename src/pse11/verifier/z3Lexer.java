// $ANTLR 3.4 ../src/grammar/z3.g 2012-01-18 17:12:22

    package verifier;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class z3Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__8=8;
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
    public static final int BOOL=4;
    public static final int IDENT=5;
    public static final int INT=6;
    public static final int TYPE=7;

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

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:6:6: ( '!' )
            // ../src/grammar/z3.g:6:8: '!'
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
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../src/grammar/z3.g:7:6: ( '(' )
            // ../src/grammar/z3.g:7:8: '('
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

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

    public void mTokens() throws RecognitionException {
        // ../src/grammar/z3.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | TYPE | BOOL )
        int alt3=18;
        switch ( input.LA(1) ) {
        case '!':
            {
            alt3=1;
            }
            break;
        case '(':
            {
            switch ( input.LA(2) ) {
            case ')':
                {
                alt3=3;
                }
                break;
            case '=':
                {
                alt3=4;
                }
                break;
            case 'A':
                {
                alt3=5;
                }
                break;
            case '_':
                {
                alt3=6;
                }
                break;
            case 'a':
                {
                alt3=7;
                }
                break;
            case 'd':
                {
                alt3=8;
                }
                break;
            case 'm':
                {
                alt3=9;
                }
                break;
            default:
                alt3=2;
            }

            }
            break;
        case ')':
            {
            int LA3_3 = input.LA(2);

            if ( (LA3_3==')') ) {
                alt3=11;
            }
            else {
                alt3=10;
            }
            }
            break;
        case 'I':
            {
            int LA3_4 = input.LA(2);

            if ( (LA3_4=='n') ) {
                int LA3_20 = input.LA(3);

                if ( (LA3_20=='t') ) {
                    alt3=12;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 20, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 4, input);

                throw nvae;

            }
            }
            break;
        case 'd':
            {
            alt3=13;
            }
            break;
        case 's':
            {
            alt3=14;
            }
            break;
        case 'u':
            {
            int LA3_7 = input.LA(2);

            if ( (LA3_7=='n') ) {
                int LA3_21 = input.LA(3);

                if ( (LA3_21=='k') ) {
                    alt3=15;
                }
                else if ( (LA3_21=='s') ) {
                    alt3=16;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 21, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 7, input);

                throw nvae;

            }
            }
            break;
        case 'B':
            {
            alt3=17;
            }
            break;
        case 'f':
        case 't':
            {
            alt3=18;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // ../src/grammar/z3.g:1:10: T__8
                {
                mT__8(); 


                }
                break;
            case 2 :
                // ../src/grammar/z3.g:1:15: T__9
                {
                mT__9(); 


                }
                break;
            case 3 :
                // ../src/grammar/z3.g:1:20: T__10
                {
                mT__10(); 


                }
                break;
            case 4 :
                // ../src/grammar/z3.g:1:26: T__11
                {
                mT__11(); 


                }
                break;
            case 5 :
                // ../src/grammar/z3.g:1:32: T__12
                {
                mT__12(); 


                }
                break;
            case 6 :
                // ../src/grammar/z3.g:1:38: T__13
                {
                mT__13(); 


                }
                break;
            case 7 :
                // ../src/grammar/z3.g:1:44: T__14
                {
                mT__14(); 


                }
                break;
            case 8 :
                // ../src/grammar/z3.g:1:50: T__15
                {
                mT__15(); 


                }
                break;
            case 9 :
                // ../src/grammar/z3.g:1:56: T__16
                {
                mT__16(); 


                }
                break;
            case 10 :
                // ../src/grammar/z3.g:1:62: T__17
                {
                mT__17(); 


                }
                break;
            case 11 :
                // ../src/grammar/z3.g:1:68: T__18
                {
                mT__18(); 


                }
                break;
            case 12 :
                // ../src/grammar/z3.g:1:74: T__19
                {
                mT__19(); 


                }
                break;
            case 13 :
                // ../src/grammar/z3.g:1:80: T__20
                {
                mT__20(); 


                }
                break;
            case 14 :
                // ../src/grammar/z3.g:1:86: T__21
                {
                mT__21(); 


                }
                break;
            case 15 :
                // ../src/grammar/z3.g:1:92: T__22
                {
                mT__22(); 


                }
                break;
            case 16 :
                // ../src/grammar/z3.g:1:98: T__23
                {
                mT__23(); 


                }
                break;
            case 17 :
                // ../src/grammar/z3.g:1:104: TYPE
                {
                mTYPE(); 


                }
                break;
            case 18 :
                // ../src/grammar/z3.g:1:109: BOOL
                {
                mBOOL(); 


                }
                break;

        }

    }


 

}