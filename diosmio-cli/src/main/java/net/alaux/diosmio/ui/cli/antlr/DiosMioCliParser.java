// $ANTLR 3.4 src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g 2012-09-24 18:34:00

package net.alaux.diosmio.ui.cli.antlr;

import net.alaux.diosmio.ui.cli.Main;
import java.text.MessageFormat;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class DiosMioCliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ARTIFACT", "CMD_ADD_ARTIFACT", "CMD_ADD_CONFIG", "CMD_DELETE_ARTIFACT", "CMD_DELETE_CONFIG", "CMD_GET_ARTIFACT", "CMD_GET_CONFIG", "CMD_HELP", "CMD_LOAD", "CMD_NO_OP", "CMD_PARSE", "CONFIG", "DELETE", "DIGIT", "FILEPATH", "GET", "HELP", "LOAD", "NUMBER", "PARSE", "WHITESPACE", "WORD"
    };

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

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public DiosMioCliParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public DiosMioCliParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return DiosMioCliParser.tokenNames; }
    public String getGrammarFileName() { return "src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g"; }


        public void reportError(RecognitionException e) {
            String errorMessage = MessageFormat.format(Main.bundle.getString("error.syntax"), e.charPositionInLine, this.getErrorMessage(e, this.getTokenNames()));
            throw new RuntimeException(errorMessage);
        }


    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:61:1: parse : action EOF -> action ;
    public final DiosMioCliParser.parse_return parse() throws RecognitionException {
        DiosMioCliParser.parse_return retval = new DiosMioCliParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF2=null;
        DiosMioCliParser.action_return action1 =null;


        CommonTree EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:62:5: ( action EOF -> action )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:62:7: action EOF
            {
            pushFollow(FOLLOW_action_in_parse162);
            action1=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action1.getTree());

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse164); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF2);


            // AST REWRITE
            // elements: action
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 63:9: -> action
            {
                adaptor.addChild(root_0, stream_action.nextTree());

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parse"


    public static class action_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "action"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:66:1: action : ( help | addArtifact | getArtifact | deleteArtifact | addConfig | getConfig | deleteConfig | loadFile | parseFile | -> ^( CMD_NO_OP ) );
    public final DiosMioCliParser.action_return action() throws RecognitionException {
        DiosMioCliParser.action_return retval = new DiosMioCliParser.action_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        DiosMioCliParser.help_return help3 =null;

        DiosMioCliParser.addArtifact_return addArtifact4 =null;

        DiosMioCliParser.getArtifact_return getArtifact5 =null;

        DiosMioCliParser.deleteArtifact_return deleteArtifact6 =null;

        DiosMioCliParser.addConfig_return addConfig7 =null;

        DiosMioCliParser.getConfig_return getConfig8 =null;

        DiosMioCliParser.deleteConfig_return deleteConfig9 =null;

        DiosMioCliParser.loadFile_return loadFile10 =null;

        DiosMioCliParser.parseFile_return parseFile11 =null;



        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:67:5: ( help | addArtifact | getArtifact | deleteArtifact | addConfig | getConfig | deleteConfig | loadFile | parseFile | -> ^( CMD_NO_OP ) )
            int alt1=10;
            switch ( input.LA(1) ) {
            case HELP:
                {
                alt1=1;
                }
                break;
            case ADD:
                {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==ARTIFACT) ) {
                    alt1=2;
                }
                else if ( (LA1_2==CONFIG) ) {
                    alt1=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;

                }
                }
                break;
            case GET:
                {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==ARTIFACT) ) {
                    alt1=3;
                }
                else if ( (LA1_3==CONFIG) ) {
                    alt1=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;

                }
                }
                break;
            case DELETE:
                {
                int LA1_4 = input.LA(2);

                if ( (LA1_4==ARTIFACT) ) {
                    alt1=4;
                }
                else if ( (LA1_4==CONFIG) ) {
                    alt1=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;

                }
                }
                break;
            case LOAD:
                {
                alt1=8;
                }
                break;
            case PARSE:
                {
                alt1=9;
                }
                break;
            case EOF:
                {
                alt1=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:67:7: help
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_help_in_action193);
                    help3=help();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, help3.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:68:7: addArtifact
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_addArtifact_in_action201);
                    addArtifact4=addArtifact();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addArtifact4.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:69:7: getArtifact
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_getArtifact_in_action209);
                    getArtifact5=getArtifact();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, getArtifact5.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:70:7: deleteArtifact
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_deleteArtifact_in_action217);
                    deleteArtifact6=deleteArtifact();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteArtifact6.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:71:7: addConfig
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_addConfig_in_action225);
                    addConfig7=addConfig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addConfig7.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:72:7: getConfig
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_getConfig_in_action233);
                    getConfig8=getConfig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, getConfig8.getTree());

                    }
                    break;
                case 7 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:73:7: deleteConfig
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_deleteConfig_in_action241);
                    deleteConfig9=deleteConfig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteConfig9.getTree());

                    }
                    break;
                case 8 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:74:7: loadFile
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_loadFile_in_action249);
                    loadFile10=loadFile();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, loadFile10.getTree());

                    }
                    break;
                case 9 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:75:7: parseFile
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_parseFile_in_action257);
                    parseFile11=parseFile();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parseFile11.getTree());

                    }
                    break;
                case 10 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:76:7: 
                    {
                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 76:7: -> ^( CMD_NO_OP )
                    {
                        // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:76:10: ^( CMD_NO_OP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CMD_NO_OP, "CMD_NO_OP")
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "action"


    public static class help_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "help"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:79:1: help : HELP -> ^( CMD_HELP ) ;
    public final DiosMioCliParser.help_return help() throws RecognitionException {
        DiosMioCliParser.help_return retval = new DiosMioCliParser.help_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token HELP12=null;

        CommonTree HELP12_tree=null;
        RewriteRuleTokenStream stream_HELP=new RewriteRuleTokenStream(adaptor,"token HELP");

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:80:5: ( HELP -> ^( CMD_HELP ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:80:7: HELP
            {
            HELP12=(Token)match(input,HELP,FOLLOW_HELP_in_help286); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_HELP.add(HELP12);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 81:9: -> ^( CMD_HELP )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:81:12: ^( CMD_HELP )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_HELP, "CMD_HELP")
                , root_1);

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "help"


    public static class addArtifact_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "addArtifact"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:85:1: addArtifact : ADD ARTIFACT filepath -> ^( CMD_ADD_ARTIFACT filepath ) ;
    public final DiosMioCliParser.addArtifact_return addArtifact() throws RecognitionException {
        DiosMioCliParser.addArtifact_return retval = new DiosMioCliParser.addArtifact_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ADD13=null;
        Token ARTIFACT14=null;
        DiosMioCliParser.filepath_return filepath15 =null;


        CommonTree ADD13_tree=null;
        CommonTree ARTIFACT14_tree=null;
        RewriteRuleTokenStream stream_ADD=new RewriteRuleTokenStream(adaptor,"token ADD");
        RewriteRuleTokenStream stream_ARTIFACT=new RewriteRuleTokenStream(adaptor,"token ARTIFACT");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:86:5: ( ADD ARTIFACT filepath -> ^( CMD_ADD_ARTIFACT filepath ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:86:7: ADD ARTIFACT filepath
            {
            ADD13=(Token)match(input,ADD,FOLLOW_ADD_in_addArtifact318); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ADD.add(ADD13);


            ARTIFACT14=(Token)match(input,ARTIFACT,FOLLOW_ARTIFACT_in_addArtifact320); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ARTIFACT.add(ARTIFACT14);


            pushFollow(FOLLOW_filepath_in_addArtifact322);
            filepath15=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath15.getTree());

            // AST REWRITE
            // elements: filepath
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 87:9: -> ^( CMD_ADD_ARTIFACT filepath )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:87:12: ^( CMD_ADD_ARTIFACT filepath )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_ADD_ARTIFACT, "CMD_ADD_ARTIFACT")
                , root_1);

                adaptor.addChild(root_1, stream_filepath.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "addArtifact"


    public static class getArtifact_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "getArtifact"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:90:1: getArtifact : GET ARTIFACT ( id )? -> ^( CMD_GET_ARTIFACT ( id )? ) ;
    public final DiosMioCliParser.getArtifact_return getArtifact() throws RecognitionException {
        DiosMioCliParser.getArtifact_return retval = new DiosMioCliParser.getArtifact_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token GET16=null;
        Token ARTIFACT17=null;
        DiosMioCliParser.id_return id18 =null;


        CommonTree GET16_tree=null;
        CommonTree ARTIFACT17_tree=null;
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleTokenStream stream_ARTIFACT=new RewriteRuleTokenStream(adaptor,"token ARTIFACT");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:91:5: ( GET ARTIFACT ( id )? -> ^( CMD_GET_ARTIFACT ( id )? ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:91:7: GET ARTIFACT ( id )?
            {
            GET16=(Token)match(input,GET,FOLLOW_GET_in_getArtifact355); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GET.add(GET16);


            ARTIFACT17=(Token)match(input,ARTIFACT,FOLLOW_ARTIFACT_in_getArtifact357); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ARTIFACT.add(ARTIFACT17);


            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:91:20: ( id )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NUMBER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:91:20: id
                    {
                    pushFollow(FOLLOW_id_in_getArtifact359);
                    id18=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id18.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 92:9: -> ^( CMD_GET_ARTIFACT ( id )? )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:92:12: ^( CMD_GET_ARTIFACT ( id )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_GET_ARTIFACT, "CMD_GET_ARTIFACT")
                , root_1);

                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:92:31: ( id )?
                if ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "getArtifact"


    public static class deleteArtifact_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deleteArtifact"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:95:1: deleteArtifact : DELETE ARTIFACT id -> ^( CMD_DELETE_ARTIFACT id ) ;
    public final DiosMioCliParser.deleteArtifact_return deleteArtifact() throws RecognitionException {
        DiosMioCliParser.deleteArtifact_return retval = new DiosMioCliParser.deleteArtifact_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DELETE19=null;
        Token ARTIFACT20=null;
        DiosMioCliParser.id_return id21 =null;


        CommonTree DELETE19_tree=null;
        CommonTree ARTIFACT20_tree=null;
        RewriteRuleTokenStream stream_DELETE=new RewriteRuleTokenStream(adaptor,"token DELETE");
        RewriteRuleTokenStream stream_ARTIFACT=new RewriteRuleTokenStream(adaptor,"token ARTIFACT");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:96:5: ( DELETE ARTIFACT id -> ^( CMD_DELETE_ARTIFACT id ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:96:7: DELETE ARTIFACT id
            {
            DELETE19=(Token)match(input,DELETE,FOLLOW_DELETE_in_deleteArtifact394); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DELETE.add(DELETE19);


            ARTIFACT20=(Token)match(input,ARTIFACT,FOLLOW_ARTIFACT_in_deleteArtifact396); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ARTIFACT.add(ARTIFACT20);


            pushFollow(FOLLOW_id_in_deleteArtifact398);
            id21=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id21.getTree());

            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 97:9: -> ^( CMD_DELETE_ARTIFACT id )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:97:12: ^( CMD_DELETE_ARTIFACT id )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_DELETE_ARTIFACT, "CMD_DELETE_ARTIFACT")
                , root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "deleteArtifact"


    public static class addConfig_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "addConfig"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:101:1: addConfig : ADD CONFIG hostname sshPort sshUser -> ^( CMD_ADD_CONFIG hostname sshPort sshUser ) ;
    public final DiosMioCliParser.addConfig_return addConfig() throws RecognitionException {
        DiosMioCliParser.addConfig_return retval = new DiosMioCliParser.addConfig_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ADD22=null;
        Token CONFIG23=null;
        DiosMioCliParser.hostname_return hostname24 =null;

        DiosMioCliParser.sshPort_return sshPort25 =null;

        DiosMioCliParser.sshUser_return sshUser26 =null;


        CommonTree ADD22_tree=null;
        CommonTree CONFIG23_tree=null;
        RewriteRuleTokenStream stream_CONFIG=new RewriteRuleTokenStream(adaptor,"token CONFIG");
        RewriteRuleTokenStream stream_ADD=new RewriteRuleTokenStream(adaptor,"token ADD");
        RewriteRuleSubtreeStream stream_hostname=new RewriteRuleSubtreeStream(adaptor,"rule hostname");
        RewriteRuleSubtreeStream stream_sshPort=new RewriteRuleSubtreeStream(adaptor,"rule sshPort");
        RewriteRuleSubtreeStream stream_sshUser=new RewriteRuleSubtreeStream(adaptor,"rule sshUser");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:102:5: ( ADD CONFIG hostname sshPort sshUser -> ^( CMD_ADD_CONFIG hostname sshPort sshUser ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:102:7: ADD CONFIG hostname sshPort sshUser
            {
            ADD22=(Token)match(input,ADD,FOLLOW_ADD_in_addConfig433); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ADD.add(ADD22);


            CONFIG23=(Token)match(input,CONFIG,FOLLOW_CONFIG_in_addConfig435); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONFIG.add(CONFIG23);


            pushFollow(FOLLOW_hostname_in_addConfig437);
            hostname24=hostname();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_hostname.add(hostname24.getTree());

            pushFollow(FOLLOW_sshPort_in_addConfig439);
            sshPort25=sshPort();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sshPort.add(sshPort25.getTree());

            pushFollow(FOLLOW_sshUser_in_addConfig441);
            sshUser26=sshUser();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sshUser.add(sshUser26.getTree());

            // AST REWRITE
            // elements: sshUser, sshPort, hostname
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 103:9: -> ^( CMD_ADD_CONFIG hostname sshPort sshUser )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:103:12: ^( CMD_ADD_CONFIG hostname sshPort sshUser )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_ADD_CONFIG, "CMD_ADD_CONFIG")
                , root_1);

                adaptor.addChild(root_1, stream_hostname.nextTree());

                adaptor.addChild(root_1, stream_sshPort.nextTree());

                adaptor.addChild(root_1, stream_sshUser.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "addConfig"


    public static class getConfig_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "getConfig"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:106:1: getConfig : GET CONFIG ( id )? -> ^( CMD_GET_CONFIG ( id )? ) ;
    public final DiosMioCliParser.getConfig_return getConfig() throws RecognitionException {
        DiosMioCliParser.getConfig_return retval = new DiosMioCliParser.getConfig_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token GET27=null;
        Token CONFIG28=null;
        DiosMioCliParser.id_return id29 =null;


        CommonTree GET27_tree=null;
        CommonTree CONFIG28_tree=null;
        RewriteRuleTokenStream stream_CONFIG=new RewriteRuleTokenStream(adaptor,"token CONFIG");
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:107:5: ( GET CONFIG ( id )? -> ^( CMD_GET_CONFIG ( id )? ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:107:7: GET CONFIG ( id )?
            {
            GET27=(Token)match(input,GET,FOLLOW_GET_in_getConfig478); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GET.add(GET27);


            CONFIG28=(Token)match(input,CONFIG,FOLLOW_CONFIG_in_getConfig480); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONFIG.add(CONFIG28);


            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:107:18: ( id )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NUMBER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:107:18: id
                    {
                    pushFollow(FOLLOW_id_in_getConfig482);
                    id29=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id29.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 108:9: -> ^( CMD_GET_CONFIG ( id )? )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:108:12: ^( CMD_GET_CONFIG ( id )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_GET_CONFIG, "CMD_GET_CONFIG")
                , root_1);

                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:108:29: ( id )?
                if ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "getConfig"


    public static class deleteConfig_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deleteConfig"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:111:1: deleteConfig : DELETE CONFIG id -> ^( CMD_DELETE_CONFIG id ) ;
    public final DiosMioCliParser.deleteConfig_return deleteConfig() throws RecognitionException {
        DiosMioCliParser.deleteConfig_return retval = new DiosMioCliParser.deleteConfig_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DELETE30=null;
        Token CONFIG31=null;
        DiosMioCliParser.id_return id32 =null;


        CommonTree DELETE30_tree=null;
        CommonTree CONFIG31_tree=null;
        RewriteRuleTokenStream stream_CONFIG=new RewriteRuleTokenStream(adaptor,"token CONFIG");
        RewriteRuleTokenStream stream_DELETE=new RewriteRuleTokenStream(adaptor,"token DELETE");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:112:5: ( DELETE CONFIG id -> ^( CMD_DELETE_CONFIG id ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:112:7: DELETE CONFIG id
            {
            DELETE30=(Token)match(input,DELETE,FOLLOW_DELETE_in_deleteConfig517); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DELETE.add(DELETE30);


            CONFIG31=(Token)match(input,CONFIG,FOLLOW_CONFIG_in_deleteConfig519); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONFIG.add(CONFIG31);


            pushFollow(FOLLOW_id_in_deleteConfig521);
            id32=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id32.getTree());

            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 113:9: -> ^( CMD_DELETE_CONFIG id )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:113:12: ^( CMD_DELETE_CONFIG id )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_DELETE_CONFIG, "CMD_DELETE_CONFIG")
                , root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "deleteConfig"


    public static class loadFile_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "loadFile"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:117:1: loadFile : LOAD filepath -> ^( CMD_LOAD filepath ) ;
    public final DiosMioCliParser.loadFile_return loadFile() throws RecognitionException {
        DiosMioCliParser.loadFile_return retval = new DiosMioCliParser.loadFile_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LOAD33=null;
        DiosMioCliParser.filepath_return filepath34 =null;


        CommonTree LOAD33_tree=null;
        RewriteRuleTokenStream stream_LOAD=new RewriteRuleTokenStream(adaptor,"token LOAD");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:118:5: ( LOAD filepath -> ^( CMD_LOAD filepath ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:118:7: LOAD filepath
            {
            LOAD33=(Token)match(input,LOAD,FOLLOW_LOAD_in_loadFile556); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LOAD.add(LOAD33);


            pushFollow(FOLLOW_filepath_in_loadFile558);
            filepath34=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath34.getTree());

            // AST REWRITE
            // elements: filepath
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 119:9: -> ^( CMD_LOAD filepath )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:119:12: ^( CMD_LOAD filepath )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_LOAD, "CMD_LOAD")
                , root_1);

                adaptor.addChild(root_1, stream_filepath.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "loadFile"


    public static class parseFile_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parseFile"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:122:1: parseFile : PARSE filepath -> ^( CMD_PARSE filepath ) ;
    public final DiosMioCliParser.parseFile_return parseFile() throws RecognitionException {
        DiosMioCliParser.parseFile_return retval = new DiosMioCliParser.parseFile_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PARSE35=null;
        DiosMioCliParser.filepath_return filepath36 =null;


        CommonTree PARSE35_tree=null;
        RewriteRuleTokenStream stream_PARSE=new RewriteRuleTokenStream(adaptor,"token PARSE");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:123:5: ( PARSE filepath -> ^( CMD_PARSE filepath ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:123:7: PARSE filepath
            {
            PARSE35=(Token)match(input,PARSE,FOLLOW_PARSE_in_parseFile591); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARSE.add(PARSE35);


            pushFollow(FOLLOW_filepath_in_parseFile593);
            filepath36=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath36.getTree());

            // AST REWRITE
            // elements: filepath
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 124:9: -> ^( CMD_PARSE filepath )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:124:12: ^( CMD_PARSE filepath )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CMD_PARSE, "CMD_PARSE")
                , root_1);

                adaptor.addChild(root_1, stream_filepath.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parseFile"


    public static class id_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "id"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:127:1: id : NUMBER ;
    public final DiosMioCliParser.id_return id() throws RecognitionException {
        DiosMioCliParser.id_return retval = new DiosMioCliParser.id_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NUMBER37=null;

        CommonTree NUMBER37_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:128:5: ( NUMBER )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:128:7: NUMBER
            {
            root_0 = (CommonTree)adaptor.nil();


            NUMBER37=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_id626); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NUMBER37_tree = 
            (CommonTree)adaptor.create(NUMBER37)
            ;
            adaptor.addChild(root_0, NUMBER37_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "id"


    public static class filepath_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filepath"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:131:1: filepath : FILEPATH ;
    public final DiosMioCliParser.filepath_return filepath() throws RecognitionException {
        DiosMioCliParser.filepath_return retval = new DiosMioCliParser.filepath_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token FILEPATH38=null;

        CommonTree FILEPATH38_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:131:10: ( FILEPATH )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:131:12: FILEPATH
            {
            root_0 = (CommonTree)adaptor.nil();


            FILEPATH38=(Token)match(input,FILEPATH,FOLLOW_FILEPATH_in_filepath639); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILEPATH38_tree = 
            (CommonTree)adaptor.create(FILEPATH38)
            ;
            adaptor.addChild(root_0, FILEPATH38_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filepath"


    public static class hostname_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hostname"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:133:1: hostname : WORD ;
    public final DiosMioCliParser.hostname_return hostname() throws RecognitionException {
        DiosMioCliParser.hostname_return retval = new DiosMioCliParser.hostname_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token WORD39=null;

        CommonTree WORD39_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:133:10: ( WORD )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:133:12: WORD
            {
            root_0 = (CommonTree)adaptor.nil();


            WORD39=(Token)match(input,WORD,FOLLOW_WORD_in_hostname647); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WORD39_tree = 
            (CommonTree)adaptor.create(WORD39)
            ;
            adaptor.addChild(root_0, WORD39_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "hostname"


    public static class sshPort_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sshPort"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:135:1: sshPort : NUMBER ;
    public final DiosMioCliParser.sshPort_return sshPort() throws RecognitionException {
        DiosMioCliParser.sshPort_return retval = new DiosMioCliParser.sshPort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NUMBER40=null;

        CommonTree NUMBER40_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:135:9: ( NUMBER )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:135:11: NUMBER
            {
            root_0 = (CommonTree)adaptor.nil();


            NUMBER40=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_sshPort655); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NUMBER40_tree = 
            (CommonTree)adaptor.create(NUMBER40)
            ;
            adaptor.addChild(root_0, NUMBER40_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sshPort"


    public static class sshUser_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sshUser"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:137:1: sshUser : WORD ;
    public final DiosMioCliParser.sshUser_return sshUser() throws RecognitionException {
        DiosMioCliParser.sshUser_return retval = new DiosMioCliParser.sshUser_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token WORD41=null;

        CommonTree WORD41_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:137:9: ( WORD )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:137:11: WORD
            {
            root_0 = (CommonTree)adaptor.nil();


            WORD41=(Token)match(input,WORD,FOLLOW_WORD_in_sshUser663); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WORD41_tree = 
            (CommonTree)adaptor.create(WORD41)
            ;
            adaptor.addChild(root_0, WORD41_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sshUser"

    // Delegated rules


 

    public static final BitSet FOLLOW_action_in_parse162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_help_in_action193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addArtifact_in_action201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getArtifact_in_action209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteArtifact_in_action217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addConfig_in_action225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getConfig_in_action233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteConfig_in_action241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loadFile_in_action249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseFile_in_action257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_help286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_addArtifact318 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ARTIFACT_in_addArtifact320 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_filepath_in_addArtifact322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getArtifact355 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ARTIFACT_in_getArtifact357 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_id_in_getArtifact359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_deleteArtifact394 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ARTIFACT_in_deleteArtifact396 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_id_in_deleteArtifact398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_addConfig433 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_CONFIG_in_addConfig435 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_hostname_in_addConfig437 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_sshPort_in_addConfig439 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_sshUser_in_addConfig441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getConfig478 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_CONFIG_in_getConfig480 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_id_in_getConfig482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_deleteConfig517 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_CONFIG_in_deleteConfig519 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_id_in_deleteConfig521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_loadFile556 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_filepath_in_loadFile558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARSE_in_parseFile591 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_filepath_in_parseFile593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_id626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILEPATH_in_filepath639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_hostname647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_sshPort655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_sshUser663 = new BitSet(new long[]{0x0000000000000002L});

}