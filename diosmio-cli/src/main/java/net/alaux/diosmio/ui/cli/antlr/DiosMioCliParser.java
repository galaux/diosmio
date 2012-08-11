// $ANTLR 3.4 src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g 2012-08-10 17:23:25

package net.alaux.diosmio.ui.cli.antlr;


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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ARTIFACT", "CONFIG", "DELETE", "DIGIT", "FILEPATH", "GET", "HELP", "LOAD", "NO_OP", "NUMBER", "PARSE", "WHITESPACE"
    };

    public static final int EOF=-1;
    public static final int ADD=4;
    public static final int ARTIFACT=5;
    public static final int CONFIG=6;
    public static final int DELETE=7;
    public static final int DIGIT=8;
    public static final int FILEPATH=9;
    public static final int GET=10;
    public static final int HELP=11;
    public static final int LOAD=12;
    public static final int NO_OP=13;
    public static final int NUMBER=14;
    public static final int PARSE=15;
    public static final int WHITESPACE=16;

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
            String errorMessage = "Syntax error at position " + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames());
            throw new RuntimeException(errorMessage);
        }


    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:53:1: parse : action EOF -> action ;
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
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:54:5: ( action EOF -> action )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:54:7: action EOF
            {
            pushFollow(FOLLOW_action_in_parse235);
            action1=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action1.getTree());

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse237); if (state.failed) return retval; 
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
            // 55:9: -> action
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:58:1: action : ( help | addElement | getElement | deleteElement | loadFile | parseFile | -> ^( NO_OP ) );
    public final DiosMioCliParser.action_return action() throws RecognitionException {
        DiosMioCliParser.action_return retval = new DiosMioCliParser.action_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        DiosMioCliParser.help_return help3 =null;

        DiosMioCliParser.addElement_return addElement4 =null;

        DiosMioCliParser.getElement_return getElement5 =null;

        DiosMioCliParser.deleteElement_return deleteElement6 =null;

        DiosMioCliParser.loadFile_return loadFile7 =null;

        DiosMioCliParser.parseFile_return parseFile8 =null;



        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:59:5: ( help | addElement | getElement | deleteElement | loadFile | parseFile | -> ^( NO_OP ) )
            int alt1=7;
            switch ( input.LA(1) ) {
            case HELP:
                {
                alt1=1;
                }
                break;
            case ADD:
                {
                alt1=2;
                }
                break;
            case GET:
                {
                alt1=3;
                }
                break;
            case DELETE:
                {
                alt1=4;
                }
                break;
            case LOAD:
                {
                alt1=5;
                }
                break;
            case PARSE:
                {
                alt1=6;
                }
                break;
            case EOF:
                {
                alt1=7;
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
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:59:7: help
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_help_in_action266);
                    help3=help();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, help3.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:60:7: addElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_addElement_in_action274);
                    addElement4=addElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addElement4.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:61:7: getElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_getElement_in_action282);
                    getElement5=getElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, getElement5.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:62:7: deleteElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_deleteElement_in_action290);
                    deleteElement6=deleteElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteElement6.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:63:7: loadFile
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_loadFile_in_action298);
                    loadFile7=loadFile();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, loadFile7.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:64:7: parseFile
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_parseFile_in_action306);
                    parseFile8=parseFile();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parseFile8.getTree());

                    }
                    break;
                case 7 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:65:7: 
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
                    // 65:7: -> ^( NO_OP )
                    {
                        // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:65:10: ^( NO_OP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(NO_OP, "NO_OP")
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:68:1: help : HELP -> ^( HELP ) ;
    public final DiosMioCliParser.help_return help() throws RecognitionException {
        DiosMioCliParser.help_return retval = new DiosMioCliParser.help_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token HELP9=null;

        CommonTree HELP9_tree=null;
        RewriteRuleTokenStream stream_HELP=new RewriteRuleTokenStream(adaptor,"token HELP");

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:69:5: ( HELP -> ^( HELP ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:69:7: HELP
            {
            HELP9=(Token)match(input,HELP,FOLLOW_HELP_in_help335); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_HELP.add(HELP9);


            // AST REWRITE
            // elements: HELP
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 70:9: -> ^( HELP )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:70:12: ^( HELP )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_HELP.nextNode()
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


    public static class addElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "addElement"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:73:1: addElement : ADD element filepath -> ^( ADD element filepath ) ;
    public final DiosMioCliParser.addElement_return addElement() throws RecognitionException {
        DiosMioCliParser.addElement_return retval = new DiosMioCliParser.addElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ADD10=null;
        DiosMioCliParser.element_return element11 =null;

        DiosMioCliParser.filepath_return filepath12 =null;


        CommonTree ADD10_tree=null;
        RewriteRuleTokenStream stream_ADD=new RewriteRuleTokenStream(adaptor,"token ADD");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:74:5: ( ADD element filepath -> ^( ADD element filepath ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:74:7: ADD element filepath
            {
            ADD10=(Token)match(input,ADD,FOLLOW_ADD_in_addElement366); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ADD.add(ADD10);


            pushFollow(FOLLOW_element_in_addElement368);
            element11=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element11.getTree());

            pushFollow(FOLLOW_filepath_in_addElement370);
            filepath12=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath12.getTree());

            // AST REWRITE
            // elements: ADD, filepath, element
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 75:9: -> ^( ADD element filepath )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:75:12: ^( ADD element filepath )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_ADD.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_element.nextTree());

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
    // $ANTLR end "addElement"


    public static class getElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "getElement"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:78:1: getElement : GET element ( id )? -> ^( GET element ( id )? ) ;
    public final DiosMioCliParser.getElement_return getElement() throws RecognitionException {
        DiosMioCliParser.getElement_return retval = new DiosMioCliParser.getElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token GET13=null;
        DiosMioCliParser.element_return element14 =null;

        DiosMioCliParser.id_return id15 =null;


        CommonTree GET13_tree=null;
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:79:5: ( GET element ( id )? -> ^( GET element ( id )? ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:79:7: GET element ( id )?
            {
            GET13=(Token)match(input,GET,FOLLOW_GET_in_getElement405); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GET.add(GET13);


            pushFollow(FOLLOW_element_in_getElement407);
            element14=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element14.getTree());

            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:79:19: ( id )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NUMBER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:79:19: id
                    {
                    pushFollow(FOLLOW_id_in_getElement409);
                    id15=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id15.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: element, id, GET
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 80:9: -> ^( GET element ( id )? )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:80:12: ^( GET element ( id )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_GET.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_element.nextTree());

                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:80:26: ( id )?
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
    // $ANTLR end "getElement"


    public static class deleteElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deleteElement"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:83:1: deleteElement : DELETE element id -> ^( DELETE element id ) ;
    public final DiosMioCliParser.deleteElement_return deleteElement() throws RecognitionException {
        DiosMioCliParser.deleteElement_return retval = new DiosMioCliParser.deleteElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DELETE16=null;
        DiosMioCliParser.element_return element17 =null;

        DiosMioCliParser.id_return id18 =null;


        CommonTree DELETE16_tree=null;
        RewriteRuleTokenStream stream_DELETE=new RewriteRuleTokenStream(adaptor,"token DELETE");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:84:5: ( DELETE element id -> ^( DELETE element id ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:84:7: DELETE element id
            {
            DELETE16=(Token)match(input,DELETE,FOLLOW_DELETE_in_deleteElement446); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DELETE.add(DELETE16);


            pushFollow(FOLLOW_element_in_deleteElement448);
            element17=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element17.getTree());

            pushFollow(FOLLOW_id_in_deleteElement450);
            id18=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id18.getTree());

            // AST REWRITE
            // elements: id, DELETE, element
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 85:9: -> ^( DELETE element id )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:85:12: ^( DELETE element id )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_DELETE.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_element.nextTree());

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
    // $ANTLR end "deleteElement"


    public static class loadFile_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "loadFile"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:88:1: loadFile : LOAD filepath -> ^( LOAD filepath ) ;
    public final DiosMioCliParser.loadFile_return loadFile() throws RecognitionException {
        DiosMioCliParser.loadFile_return retval = new DiosMioCliParser.loadFile_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LOAD19=null;
        DiosMioCliParser.filepath_return filepath20 =null;


        CommonTree LOAD19_tree=null;
        RewriteRuleTokenStream stream_LOAD=new RewriteRuleTokenStream(adaptor,"token LOAD");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:89:5: ( LOAD filepath -> ^( LOAD filepath ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:89:7: LOAD filepath
            {
            LOAD19=(Token)match(input,LOAD,FOLLOW_LOAD_in_loadFile486); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LOAD.add(LOAD19);


            pushFollow(FOLLOW_filepath_in_loadFile488);
            filepath20=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath20.getTree());

            // AST REWRITE
            // elements: filepath, LOAD
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 90:9: -> ^( LOAD filepath )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:90:12: ^( LOAD filepath )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_LOAD.nextNode()
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:93:1: parseFile : PARSE filepath -> ^( PARSE filepath ) ;
    public final DiosMioCliParser.parseFile_return parseFile() throws RecognitionException {
        DiosMioCliParser.parseFile_return retval = new DiosMioCliParser.parseFile_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PARSE21=null;
        DiosMioCliParser.filepath_return filepath22 =null;


        CommonTree PARSE21_tree=null;
        RewriteRuleTokenStream stream_PARSE=new RewriteRuleTokenStream(adaptor,"token PARSE");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:94:5: ( PARSE filepath -> ^( PARSE filepath ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:94:7: PARSE filepath
            {
            PARSE21=(Token)match(input,PARSE,FOLLOW_PARSE_in_parseFile521); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARSE.add(PARSE21);


            pushFollow(FOLLOW_filepath_in_parseFile523);
            filepath22=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath22.getTree());

            // AST REWRITE
            // elements: filepath, PARSE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 95:9: -> ^( PARSE filepath )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:95:12: ^( PARSE filepath )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_PARSE.nextNode()
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


    public static class element_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "element"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:98:1: element : ( ARTIFACT | CONFIG ) ;
    public final DiosMioCliParser.element_return element() throws RecognitionException {
        DiosMioCliParser.element_return retval = new DiosMioCliParser.element_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set23=null;

        CommonTree set23_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:99:5: ( ( ARTIFACT | CONFIG ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set23=(Token)input.LT(1);

            if ( (input.LA(1) >= ARTIFACT && input.LA(1) <= CONFIG) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set23)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "element"


    public static class id_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "id"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:102:1: id : NUMBER ;
    public final DiosMioCliParser.id_return id() throws RecognitionException {
        DiosMioCliParser.id_return retval = new DiosMioCliParser.id_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NUMBER24=null;

        CommonTree NUMBER24_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:103:5: ( NUMBER )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:103:7: NUMBER
            {
            root_0 = (CommonTree)adaptor.nil();


            NUMBER24=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_id581); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NUMBER24_tree = 
            (CommonTree)adaptor.create(NUMBER24)
            ;
            adaptor.addChild(root_0, NUMBER24_tree);
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:106:1: filepath : FILEPATH ;
    public final DiosMioCliParser.filepath_return filepath() throws RecognitionException {
        DiosMioCliParser.filepath_return retval = new DiosMioCliParser.filepath_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token FILEPATH25=null;

        CommonTree FILEPATH25_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:106:10: ( FILEPATH )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:106:12: FILEPATH
            {
            root_0 = (CommonTree)adaptor.nil();


            FILEPATH25=(Token)match(input,FILEPATH,FOLLOW_FILEPATH_in_filepath594); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILEPATH25_tree = 
            (CommonTree)adaptor.create(FILEPATH25)
            ;
            adaptor.addChild(root_0, FILEPATH25_tree);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_action_in_parse235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_help_in_action266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addElement_in_action274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getElement_in_action282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteElement_in_action290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loadFile_in_action298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseFile_in_action306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_help335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_addElement366 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_addElement368 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_filepath_in_addElement370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getElement405 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_getElement407 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_id_in_getElement409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_deleteElement446 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_deleteElement448 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_id_in_deleteElement450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_loadFile486 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_filepath_in_loadFile488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARSE_in_parseFile521 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_filepath_in_parseFile523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_id581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILEPATH_in_filepath594 = new BitSet(new long[]{0x0000000000000002L});

}