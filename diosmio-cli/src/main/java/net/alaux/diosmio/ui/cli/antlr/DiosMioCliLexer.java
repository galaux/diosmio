// $ANTLR 3.4 src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g 2012-08-12 14:24:41

package net.alaux.diosmio.ui.cli.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class DiosMioCliLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ADD=4;
    public static final int ARTIFACT=5;
    public static final int CMD_ADD_ARTIFACT=6;
    public static final int CMD_ADD_CONFIG=7;
    public static final int CMD_DELETE_ARTIFACT=8;
    public static final int CMD_DELETE_CONFIG=9;
    public static final int CMD_GET_ARTIFACT=10;
    public static final int CMD_GET_CONFIG=11;
    public static final int CMD_HELP=12;
    public static final int CMD_LOAD=13;
    public static final int CMD_NO_OP=14;
    public static final int CMD_PARSE=15;
    public static final int CONFIG=16;
    public static final int DELETE=17;
    public static final int DIGIT=18;
    public static final int FILEPATH=19;
    public static final int GET=20;
    public static final int HELP=21;
    public static final int LOAD=22;
    public static final int NUMBER=23;
    public static final int PARSE=24;
    public static final int WHITESPACE=25;
    public static final int WORD=26;

        public void reportError(RecognitionException e) {
            String errorMessage = "Syntax error at position " + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames());
            throw new RuntimeException(errorMessage);
        }


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public DiosMioCliLexer() {} 
    public DiosMioCliLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DiosMioCliLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g"; }

    // $ANTLR start "HELP"
    public final void mHELP() throws RecognitionException {
        try {
            int _type = HELP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:139:13: ( 'help' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:139:15: 'help'
            {
            match("help"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HELP"

    // $ANTLR start "ADD"
    public final void mADD() throws RecognitionException {
        try {
            int _type = ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:140:13: ( 'add' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:140:15: 'add'
            {
            match("add"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ADD"

    // $ANTLR start "GET"
    public final void mGET() throws RecognitionException {
        try {
            int _type = GET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:141:13: ( 'get' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:141:15: 'get'
            {
            match("get"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GET"

    // $ANTLR start "DELETE"
    public final void mDELETE() throws RecognitionException {
        try {
            int _type = DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:142:13: ( 'delete' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:142:15: 'delete'
            {
            match("delete"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DELETE"

    // $ANTLR start "LOAD"
    public final void mLOAD() throws RecognitionException {
        try {
            int _type = LOAD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:144:13: ( 'load' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:144:15: 'load'
            {
            match("load"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOAD"

    // $ANTLR start "PARSE"
    public final void mPARSE() throws RecognitionException {
        try {
            int _type = PARSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:145:13: ( 'parse' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:145:15: 'parse'
            {
            match("parse"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARSE"

    // $ANTLR start "ARTIFACT"
    public final void mARTIFACT() throws RecognitionException {
        try {
            int _type = ARTIFACT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:147:13: ( 'artifact' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:147:15: 'artifact'
            {
            match("artifact"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ARTIFACT"

    // $ANTLR start "CONFIG"
    public final void mCONFIG() throws RecognitionException {
        try {
            int _type = CONFIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:148:13: ( 'config' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:148:15: 'config'
            {
            match("config"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONFIG"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:150:9: ( ( DIGIT )+ )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:150:11: ( DIGIT )+
            {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:150:11: ( DIGIT )+
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
            	    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:
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
    // $ANTLR end "NUMBER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:152:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:152:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:152:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||(LA2_0 >= '\f' && LA2_0 <= '\r')||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:154:17: ( '0' .. '9' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:
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


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            int _type = WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:157:6: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:157:8: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:157:8: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
    // $ANTLR end "WORD"

    // $ANTLR start "FILEPATH"
    public final void mFILEPATH() throws RecognitionException {
        try {
            int _type = FILEPATH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:160:10: ( ( 'a' .. 'z' | 'A' .. 'Z' | '/' | '.' | '-' )+ )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:160:12: ( 'a' .. 'z' | 'A' .. 'Z' | '/' | '.' | '-' )+
            {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:160:12: ( 'a' .. 'z' | 'A' .. 'Z' | '/' | '.' | '-' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '-' && LA4_0 <= '/')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:
            	    {
            	    if ( (input.LA(1) >= '-' && input.LA(1) <= '/')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FILEPATH"

    public void mTokens() throws RecognitionException {
        // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:8: ( HELP | ADD | GET | DELETE | LOAD | PARSE | ARTIFACT | CONFIG | NUMBER | WHITESPACE | WORD | FILEPATH )
        int alt5=12;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:10: HELP
                {
                mHELP(); 


                }
                break;
            case 2 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:15: ADD
                {
                mADD(); 


                }
                break;
            case 3 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:19: GET
                {
                mGET(); 


                }
                break;
            case 4 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:23: DELETE
                {
                mDELETE(); 


                }
                break;
            case 5 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:30: LOAD
                {
                mLOAD(); 


                }
                break;
            case 6 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:35: PARSE
                {
                mPARSE(); 


                }
                break;
            case 7 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:41: ARTIFACT
                {
                mARTIFACT(); 


                }
                break;
            case 8 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:50: CONFIG
                {
                mCONFIG(); 


                }
                break;
            case 9 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:57: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 10 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:64: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 11 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:75: WORD
                {
                mWORD(); 


                }
                break;
            case 12 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:80: FILEPATH
                {
                mFILEPATH(); 


                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\7\15\2\uffff\1\15\1\uffff\1\15\1\uffff\10\15\1\36\1\15"+
        "\1\40\4\15\1\45\1\uffff\1\15\1\uffff\1\15\1\50\2\15\1\uffff\2\15"+
        "\1\uffff\1\55\2\15\1\60\1\uffff\1\61\1\15\2\uffff\1\63\1\uffff";
    static final String DFA5_eofS =
        "\64\uffff";
    static final String DFA5_minS =
        "\1\11\7\55\2\uffff\1\55\1\uffff\1\55\1\uffff\20\55\1\uffff\1\55"+
        "\1\uffff\4\55\1\uffff\2\55\1\uffff\4\55\1\uffff\2\55\2\uffff\1\55"+
        "\1\uffff";
    static final String DFA5_maxS =
        "\10\172\2\uffff\1\172\1\uffff\1\172\1\uffff\20\172\1\uffff\1\172"+
        "\1\uffff\4\172\1\uffff\2\172\1\uffff\4\172\1\uffff\2\172\2\uffff"+
        "\1\172\1\uffff";
    static final String DFA5_acceptS =
        "\10\uffff\1\11\1\12\1\uffff\1\14\1\uffff\1\13\20\uffff\1\2\1\uffff"+
        "\1\3\4\uffff\1\1\2\uffff\1\5\4\uffff\1\6\2\uffff\1\4\1\10\1\uffff"+
        "\1\7";
    static final String DFA5_specialS =
        "\64\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\11\1\uffff\2\11\22\uffff\1\11\14\uffff\3\13\12\10\7\uffff"+
            "\32\12\6\uffff\1\2\1\12\1\7\1\4\2\12\1\3\1\1\3\12\1\5\3\12\1"+
            "\6\12\12",
            "\3\13\21\uffff\32\12\6\uffff\4\12\1\14\25\12",
            "\3\13\21\uffff\32\12\6\uffff\3\12\1\16\15\12\1\17\10\12",
            "\3\13\21\uffff\32\12\6\uffff\4\12\1\20\25\12",
            "\3\13\21\uffff\32\12\6\uffff\4\12\1\21\25\12",
            "\3\13\21\uffff\32\12\6\uffff\16\12\1\22\13\12",
            "\3\13\21\uffff\32\12\6\uffff\1\23\31\12",
            "\3\13\21\uffff\32\12\6\uffff\16\12\1\24\13\12",
            "",
            "",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            "",
            "\3\13\21\uffff\32\12\6\uffff\13\12\1\25\16\12",
            "",
            "\3\13\21\uffff\32\12\6\uffff\3\12\1\26\26\12",
            "\3\13\21\uffff\32\12\6\uffff\23\12\1\27\6\12",
            "\3\13\21\uffff\32\12\6\uffff\23\12\1\30\6\12",
            "\3\13\21\uffff\32\12\6\uffff\13\12\1\31\16\12",
            "\3\13\21\uffff\32\12\6\uffff\1\32\31\12",
            "\3\13\21\uffff\32\12\6\uffff\21\12\1\33\10\12",
            "\3\13\21\uffff\32\12\6\uffff\15\12\1\34\14\12",
            "\3\13\21\uffff\32\12\6\uffff\17\12\1\35\12\12",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            "\3\13\21\uffff\32\12\6\uffff\10\12\1\37\21\12",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            "\3\13\21\uffff\32\12\6\uffff\4\12\1\41\25\12",
            "\3\13\21\uffff\32\12\6\uffff\3\12\1\42\26\12",
            "\3\13\21\uffff\32\12\6\uffff\22\12\1\43\7\12",
            "\3\13\21\uffff\32\12\6\uffff\5\12\1\44\24\12",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            "",
            "\3\13\21\uffff\32\12\6\uffff\5\12\1\46\24\12",
            "",
            "\3\13\21\uffff\32\12\6\uffff\23\12\1\47\6\12",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            "\3\13\21\uffff\32\12\6\uffff\4\12\1\51\25\12",
            "\3\13\21\uffff\32\12\6\uffff\10\12\1\52\21\12",
            "",
            "\3\13\21\uffff\32\12\6\uffff\1\53\31\12",
            "\3\13\21\uffff\32\12\6\uffff\4\12\1\54\25\12",
            "",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            "\3\13\21\uffff\32\12\6\uffff\6\12\1\56\23\12",
            "\3\13\21\uffff\32\12\6\uffff\2\12\1\57\27\12",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            "",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            "\3\13\21\uffff\32\12\6\uffff\23\12\1\62\6\12",
            "",
            "",
            "\3\13\21\uffff\32\12\6\uffff\32\12",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( HELP | ADD | GET | DELETE | LOAD | PARSE | ARTIFACT | CONFIG | NUMBER | WHITESPACE | WORD | FILEPATH );";
        }
    }
 

}