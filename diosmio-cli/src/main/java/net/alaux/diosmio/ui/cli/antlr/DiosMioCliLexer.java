// $ANTLR 3.4 src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g 2012-08-09 18:05:27

package net.alaux.diosmio.ui.cli.antlr;


import org.antlr.runtime.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class DiosMioCliLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int ADD=4;
    public static final int ARTIFACT=5;
    public static final int CONFIG=6;
    public static final int DELETE=7;
    public static final int DIGIT=8;
    public static final int EXIT=9;
    public static final int FILEPATH=10;
    public static final int GET=11;
    public static final int HELP=12;
    public static final int NO_OP=13;
    public static final int NUMBER=14;
    public static final int WHITESPACE=15;

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

    // $ANTLR start "ADD"
    public final void mADD() throws RecognitionException {
        try {
            int _type = ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:12:5: ( 'add' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:12:7: 'add'
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

    // $ANTLR start "ARTIFACT"
    public final void mARTIFACT() throws RecognitionException {
        try {
            int _type = ARTIFACT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:13:10: ( 'artifact' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:13:12: 'artifact'
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
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:14:8: ( 'config' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:14:10: 'config'
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

    // $ANTLR start "DELETE"
    public final void mDELETE() throws RecognitionException {
        try {
            int _type = DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:15:8: ( 'delete' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:15:10: 'delete'
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

    // $ANTLR start "GET"
    public final void mGET() throws RecognitionException {
        try {
            int _type = GET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:16:5: ( 'get' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:16:7: 'get'
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

    // $ANTLR start "HELP"
    public final void mHELP() throws RecognitionException {
        try {
            int _type = HELP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:17:6: ( 'help' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:17:8: 'help'
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

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:18:7: ( 'exit' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:18:9: 'exit'
            {
            match("exit"); 



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
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:19:7: ( 'quit' )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:19:9: 'quit'
            {
            match("quit"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:103:9: ( ( DIGIT )+ )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:103:11: ( DIGIT )+
            {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:103:11: ( DIGIT )+
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
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:105:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:105:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:105:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
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
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:107:17: ( '0' .. '9' )
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

    // $ANTLR start "FILEPATH"
    public final void mFILEPATH() throws RecognitionException {
        try {
            int _type = FILEPATH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:109:10: ( ( 'a' .. 'z' | 'A' .. 'Z' | '/' | '.' | '-' )+ )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:109:12: ( 'a' .. 'z' | 'A' .. 'Z' | '/' | '.' | '-' )+
            {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:109:12: ( 'a' .. 'z' | 'A' .. 'Z' | '/' | '.' | '-' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '-' && LA3_0 <= '/')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
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
    // $ANTLR end "FILEPATH"

    public void mTokens() throws RecognitionException {
        // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:8: ( ADD | ARTIFACT | CONFIG | DELETE | GET | HELP | T__16 | T__17 | NUMBER | WHITESPACE | FILEPATH )
        int alt4=11;
        switch ( input.LA(1) ) {
        case 'a':
            {
            switch ( input.LA(2) ) {
            case 'd':
                {
                int LA4_11 = input.LA(3);

                if ( (LA4_11=='d') ) {
                    int LA4_19 = input.LA(4);

                    if ( ((LA4_19 >= '-' && LA4_19 <= '/')||(LA4_19 >= 'A' && LA4_19 <= 'Z')||(LA4_19 >= 'a' && LA4_19 <= 'z')) ) {
                        alt4=11;
                    }
                    else {
                        alt4=1;
                    }
                }
                else {
                    alt4=11;
                }
                }
                break;
            case 'r':
                {
                int LA4_12 = input.LA(3);

                if ( (LA4_12=='t') ) {
                    int LA4_20 = input.LA(4);

                    if ( (LA4_20=='i') ) {
                        int LA4_28 = input.LA(5);

                        if ( (LA4_28=='f') ) {
                            int LA4_35 = input.LA(6);

                            if ( (LA4_35=='a') ) {
                                int LA4_41 = input.LA(7);

                                if ( (LA4_41=='c') ) {
                                    int LA4_44 = input.LA(8);

                                    if ( (LA4_44=='t') ) {
                                        int LA4_47 = input.LA(9);

                                        if ( ((LA4_47 >= '-' && LA4_47 <= '/')||(LA4_47 >= 'A' && LA4_47 <= 'Z')||(LA4_47 >= 'a' && LA4_47 <= 'z')) ) {
                                            alt4=11;
                                        }
                                        else {
                                            alt4=2;
                                        }
                                    }
                                    else {
                                        alt4=11;
                                    }
                                }
                                else {
                                    alt4=11;
                                }
                            }
                            else {
                                alt4=11;
                            }
                        }
                        else {
                            alt4=11;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
                }
                break;
            default:
                alt4=11;
            }

            }
            break;
        case 'c':
            {
            int LA4_2 = input.LA(2);

            if ( (LA4_2=='o') ) {
                int LA4_13 = input.LA(3);

                if ( (LA4_13=='n') ) {
                    int LA4_21 = input.LA(4);

                    if ( (LA4_21=='f') ) {
                        int LA4_29 = input.LA(5);

                        if ( (LA4_29=='i') ) {
                            int LA4_36 = input.LA(6);

                            if ( (LA4_36=='g') ) {
                                int LA4_42 = input.LA(7);

                                if ( ((LA4_42 >= '-' && LA4_42 <= '/')||(LA4_42 >= 'A' && LA4_42 <= 'Z')||(LA4_42 >= 'a' && LA4_42 <= 'z')) ) {
                                    alt4=11;
                                }
                                else {
                                    alt4=3;
                                }
                            }
                            else {
                                alt4=11;
                            }
                        }
                        else {
                            alt4=11;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'd':
            {
            int LA4_3 = input.LA(2);

            if ( (LA4_3=='e') ) {
                int LA4_14 = input.LA(3);

                if ( (LA4_14=='l') ) {
                    int LA4_22 = input.LA(4);

                    if ( (LA4_22=='e') ) {
                        int LA4_30 = input.LA(5);

                        if ( (LA4_30=='t') ) {
                            int LA4_37 = input.LA(6);

                            if ( (LA4_37=='e') ) {
                                int LA4_43 = input.LA(7);

                                if ( ((LA4_43 >= '-' && LA4_43 <= '/')||(LA4_43 >= 'A' && LA4_43 <= 'Z')||(LA4_43 >= 'a' && LA4_43 <= 'z')) ) {
                                    alt4=11;
                                }
                                else {
                                    alt4=4;
                                }
                            }
                            else {
                                alt4=11;
                            }
                        }
                        else {
                            alt4=11;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'g':
            {
            int LA4_4 = input.LA(2);

            if ( (LA4_4=='e') ) {
                int LA4_15 = input.LA(3);

                if ( (LA4_15=='t') ) {
                    int LA4_23 = input.LA(4);

                    if ( ((LA4_23 >= '-' && LA4_23 <= '/')||(LA4_23 >= 'A' && LA4_23 <= 'Z')||(LA4_23 >= 'a' && LA4_23 <= 'z')) ) {
                        alt4=11;
                    }
                    else {
                        alt4=5;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'h':
            {
            int LA4_5 = input.LA(2);

            if ( (LA4_5=='e') ) {
                int LA4_16 = input.LA(3);

                if ( (LA4_16=='l') ) {
                    int LA4_24 = input.LA(4);

                    if ( (LA4_24=='p') ) {
                        int LA4_32 = input.LA(5);

                        if ( ((LA4_32 >= '-' && LA4_32 <= '/')||(LA4_32 >= 'A' && LA4_32 <= 'Z')||(LA4_32 >= 'a' && LA4_32 <= 'z')) ) {
                            alt4=11;
                        }
                        else {
                            alt4=6;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'e':
            {
            int LA4_6 = input.LA(2);

            if ( (LA4_6=='x') ) {
                int LA4_17 = input.LA(3);

                if ( (LA4_17=='i') ) {
                    int LA4_25 = input.LA(4);

                    if ( (LA4_25=='t') ) {
                        int LA4_33 = input.LA(5);

                        if ( ((LA4_33 >= '-' && LA4_33 <= '/')||(LA4_33 >= 'A' && LA4_33 <= 'Z')||(LA4_33 >= 'a' && LA4_33 <= 'z')) ) {
                            alt4=11;
                        }
                        else {
                            alt4=7;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'q':
            {
            int LA4_7 = input.LA(2);

            if ( (LA4_7=='u') ) {
                int LA4_18 = input.LA(3);

                if ( (LA4_18=='i') ) {
                    int LA4_26 = input.LA(4);

                    if ( (LA4_26=='t') ) {
                        int LA4_34 = input.LA(5);

                        if ( ((LA4_34 >= '-' && LA4_34 <= '/')||(LA4_34 >= 'A' && LA4_34 <= 'Z')||(LA4_34 >= 'a' && LA4_34 <= 'z')) ) {
                            alt4=11;
                        }
                        else {
                            alt4=8;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
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
        case '8':
        case '9':
            {
            alt4=9;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt4=10;
            }
            break;
        case '-':
        case '.':
        case '/':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'b':
        case 'f':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt4=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
            case 1 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:10: ADD
                {
                mADD(); 


                }
                break;
            case 2 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:14: ARTIFACT
                {
                mARTIFACT(); 


                }
                break;
            case 3 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:23: CONFIG
                {
                mCONFIG(); 


                }
                break;
            case 4 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:30: DELETE
                {
                mDELETE(); 


                }
                break;
            case 5 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:37: GET
                {
                mGET(); 


                }
                break;
            case 6 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:41: HELP
                {
                mHELP(); 


                }
                break;
            case 7 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:46: T__16
                {
                mT__16(); 


                }
                break;
            case 8 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:52: T__17
                {
                mT__17(); 


                }
                break;
            case 9 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:58: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 10 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:65: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 11 :
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:1:76: FILEPATH
                {
                mFILEPATH(); 


                }
                break;

        }

    }


 

}