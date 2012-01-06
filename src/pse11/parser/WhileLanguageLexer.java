// $ANTLR 3.4 C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g 2012-01-06 14:28:30

	package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class WhileLanguageLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public WhileLanguageLexer() {} 
    public WhileLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public WhileLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:6:6: ( '!' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:6:8: '!'
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:7:7: ( '!=' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:7:9: '!='
            {
            match("!="); 



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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:8:7: ( '%' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:8:9: '%'
            {
            match('%'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:9:7: ( '&' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:9:9: '&'
            {
            match('&'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:10:7: ( '(' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:10:9: '('
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:11:7: ( ')' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:11:9: ')'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:12:7: ( '*' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:12:9: '*'
            {
            match('*'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:13:7: ( '+' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:13:9: '+'
            {
            match('+'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:14:7: ( ',' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:14:9: ','
            {
            match(','); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:15:7: ( '-' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:15:9: '-'
            {
            match('-'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:7: ( '/' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:16:9: '/'
            {
            match('/'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:17:7: ( ';' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:17:9: ';'
            {
            match(';'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:18:7: ( '<' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:18:9: '<'
            {
            match('<'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:19:7: ( '<=' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:19:9: '<='
            {
            match("<="); 



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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:20:7: ( '=' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:20:9: '='
            {
            match('='); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:21:7: ( '==' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:21:9: '=='
            {
            match("=="); 



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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:22:7: ( '>' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:22:9: '>'
            {
            match('>'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:23:7: ( '>=' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:23:9: '>='
            {
            match(">="); 



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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:24:7: ( '[' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:24:9: '['
            {
            match('['); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:25:7: ( ']' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:25:9: ']'
            {
            match(']'); 

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
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:26:7: ( 'assert' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:26:9: 'assert'
            {
            match("assert"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:27:7: ( 'assume' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:27:9: 'assume'
            {
            match("assume"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:28:7: ( 'bool' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:28:9: 'bool'
            {
            match("bool"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:29:7: ( 'else' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:29:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:30:7: ( 'ensure' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:30:9: 'ensure'
            {
            match("ensure"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:31:7: ( 'exists' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:31:9: 'exists'
            {
            match("exists"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:32:7: ( 'forall' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:32:9: 'forall'
            {
            match("forall"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:33:7: ( 'if' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:33:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:34:7: ( 'int' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:34:9: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:35:7: ( 'invariant' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:35:9: 'invariant'
            {
            match("invariant"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:36:7: ( 'main' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:36:9: 'main'
            {
            match("main"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:37:7: ( 'return' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:37:9: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:38:7: ( 'while' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:38:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:39:7: ( '{' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:39:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:40:7: ( '|' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:40:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:41:7: ( '}' )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:41:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "INT_LITERAL"
    public final void mINT_LITERAL() throws RecognitionException {
        try {
            int _type = INT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:254:14: ( ( '0' .. '9' )+ )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:254:16: ( '0' .. '9' )+
            {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:254:16: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT_LITERAL"

    // $ANTLR start "BOOL_LITERAL"
    public final void mBOOL_LITERAL() throws RecognitionException {
        try {
            int _type = BOOL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:255:14: ( 'true' | 'false' )
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
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:255:16: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:255:25: 'false'
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
    // $ANTLR end "BOOL_LITERAL"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:256:14: ( '#' ( . )* ( '\\n' | '\\r' ) )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:256:16: '#' ( . )* ( '\\n' | '\\r' )
            {
            match('#'); 

            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:256:20: ( . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                    alt3=2;
                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:256:20: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:257:14: ( ( '\\n' | '\\r' | ' ' | '\\t' )+ )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:257:16: ( '\\n' | '\\r' | ' ' | '\\t' )+
            {
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:257:16: ( '\\n' | '\\r' | ' ' | '\\t' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:258:14: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:258:16: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:258:44: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:
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

    public void mTokens() throws RecognitionException {
        // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | INT_LITERAL | BOOL_LITERAL | COMMENT | WS | IDENT )
        int alt6=41;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:39: T__14
                {
                mT__14(); 


                }
                break;
            case 7 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:45: T__15
                {
                mT__15(); 


                }
                break;
            case 8 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:51: T__16
                {
                mT__16(); 


                }
                break;
            case 9 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:57: T__17
                {
                mT__17(); 


                }
                break;
            case 10 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:63: T__18
                {
                mT__18(); 


                }
                break;
            case 11 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:69: T__19
                {
                mT__19(); 


                }
                break;
            case 12 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:75: T__20
                {
                mT__20(); 


                }
                break;
            case 13 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:81: T__21
                {
                mT__21(); 


                }
                break;
            case 14 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:87: T__22
                {
                mT__22(); 


                }
                break;
            case 15 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:93: T__23
                {
                mT__23(); 


                }
                break;
            case 16 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:99: T__24
                {
                mT__24(); 


                }
                break;
            case 17 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:105: T__25
                {
                mT__25(); 


                }
                break;
            case 18 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:111: T__26
                {
                mT__26(); 


                }
                break;
            case 19 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:117: T__27
                {
                mT__27(); 


                }
                break;
            case 20 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:123: T__28
                {
                mT__28(); 


                }
                break;
            case 21 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:129: T__29
                {
                mT__29(); 


                }
                break;
            case 22 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:135: T__30
                {
                mT__30(); 


                }
                break;
            case 23 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:141: T__31
                {
                mT__31(); 


                }
                break;
            case 24 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:147: T__32
                {
                mT__32(); 


                }
                break;
            case 25 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:153: T__33
                {
                mT__33(); 


                }
                break;
            case 26 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:159: T__34
                {
                mT__34(); 


                }
                break;
            case 27 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:165: T__35
                {
                mT__35(); 


                }
                break;
            case 28 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:171: T__36
                {
                mT__36(); 


                }
                break;
            case 29 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:177: T__37
                {
                mT__37(); 


                }
                break;
            case 30 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:183: T__38
                {
                mT__38(); 


                }
                break;
            case 31 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:189: T__39
                {
                mT__39(); 


                }
                break;
            case 32 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:195: T__40
                {
                mT__40(); 


                }
                break;
            case 33 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:201: T__41
                {
                mT__41(); 


                }
                break;
            case 34 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:207: T__42
                {
                mT__42(); 


                }
                break;
            case 35 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:213: T__43
                {
                mT__43(); 


                }
                break;
            case 36 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:219: T__44
                {
                mT__44(); 


                }
                break;
            case 37 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:225: INT_LITERAL
                {
                mINT_LITERAL(); 


                }
                break;
            case 38 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:237: BOOL_LITERAL
                {
                mBOOL_LITERAL(); 


                }
                break;
            case 39 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:250: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 40 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:258: WS
                {
                mWS(); 


                }
                break;
            case 41 :
                // C:\\Users\\simon\\Studium\\PSE\\src\\grammar\\WhileLanguage.g:1:261: IDENT
                {
                mIDENT(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\1\42\12\uffff\1\44\1\46\1\50\2\uffff\10\40\4\uffff\1\40"+
        "\13\uffff\7\40\1\75\14\40\1\uffff\1\114\7\40\1\124\1\125\4\40\1"+
        "\uffff\1\40\1\133\2\40\1\136\2\40\2\uffff\3\40\1\136\1\40\1\uffff"+
        "\1\40\1\146\1\uffff\1\147\1\150\1\151\1\152\1\153\1\40\1\155\6\uffff"+
        "\1\40\1\uffff\1\40\1\160\1\uffff";
    static final String DFA6_eofS =
        "\161\uffff";
    static final String DFA6_minS =
        "\1\11\1\75\12\uffff\3\75\2\uffff\1\163\1\157\1\154\1\141\1\146\1"+
        "\141\1\145\1\150\4\uffff\1\162\13\uffff\1\163\1\157\2\163\1\151"+
        "\1\162\1\154\1\60\1\164\1\151\1\164\1\151\1\165\1\145\1\154\1\145"+
        "\1\165\1\163\1\141\1\163\1\uffff\1\60\1\141\1\156\1\165\1\154\1"+
        "\145\1\162\1\155\2\60\1\162\1\164\1\154\1\145\1\uffff\1\162\1\60"+
        "\1\162\1\145\1\60\1\164\1\145\2\uffff\1\145\1\163\1\154\1\60\1\151"+
        "\1\uffff\1\156\1\60\1\uffff\5\60\1\141\1\60\6\uffff\1\156\1\uffff"+
        "\1\164\1\60\1\uffff";
    static final String DFA6_maxS =
        "\1\175\1\75\12\uffff\3\75\2\uffff\1\163\1\157\1\170\1\157\1\156"+
        "\1\141\1\145\1\150\4\uffff\1\162\13\uffff\1\163\1\157\2\163\1\151"+
        "\1\162\1\154\1\172\1\166\1\151\1\164\1\151\2\165\1\154\1\145\1\165"+
        "\1\163\1\141\1\163\1\uffff\1\172\1\141\1\156\1\165\1\154\1\145\1"+
        "\162\1\155\2\172\1\162\1\164\1\154\1\145\1\uffff\1\162\1\172\1\162"+
        "\1\145\1\172\1\164\1\145\2\uffff\1\145\1\163\1\154\1\172\1\151\1"+
        "\uffff\1\156\1\172\1\uffff\5\172\1\141\1\172\6\uffff\1\156\1\uffff"+
        "\1\164\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\3\uffff\1"+
        "\23\1\24\10\uffff\1\42\1\43\1\44\1\45\1\uffff\1\47\1\50\1\51\1\2"+
        "\1\1\1\16\1\15\1\20\1\17\1\22\1\21\24\uffff\1\34\16\uffff\1\35\7"+
        "\uffff\1\27\1\30\5\uffff\1\37\2\uffff\1\46\7\uffff\1\41\1\25\1\26"+
        "\1\31\1\32\1\33\1\uffff\1\40\2\uffff\1\36";
    static final String DFA6_specialS =
        "\161\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\37\2\uffff\1\37\22\uffff\1\37\1\1\1\uffff\1\36\1\uffff\1"+
            "\2\1\3\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\12\12\34"+
            "\1\uffff\1\13\1\14\1\15\1\16\2\uffff\32\40\1\17\1\uffff\1\20"+
            "\1\uffff\1\40\1\uffff\1\21\1\22\2\40\1\23\1\24\2\40\1\25\3\40"+
            "\1\26\4\40\1\27\1\40\1\35\2\40\1\30\3\40\1\31\1\32\1\33",
            "\1\41",
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
            "\1\43",
            "\1\45",
            "\1\47",
            "",
            "",
            "\1\51",
            "\1\52",
            "\1\53\1\uffff\1\54\11\uffff\1\55",
            "\1\57\15\uffff\1\56",
            "\1\60\7\uffff\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "",
            "",
            "",
            "\1\65",
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
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\76\1\uffff\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104\17\uffff\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "",
            "\1\132",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\134",
            "\1\135",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\137",
            "\1\140",
            "",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\144",
            "",
            "\1\145",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\154",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\156",
            "",
            "\1\157",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | INT_LITERAL | BOOL_LITERAL | COMMENT | WS | IDENT );";
        }
    }
 

}