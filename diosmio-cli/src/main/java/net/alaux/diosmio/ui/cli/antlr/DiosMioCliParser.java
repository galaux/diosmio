// $ANTLR 3.4 src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g 2012-08-09 11:05:09

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ARTIFACT", "CONFIG", "DELETE", "DIGIT", "FILEPATH", "GET", "HELP", "NO_OP", "NUMBER", "WHITESPACE"
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
    public static final int NO_OP=12;
    public static final int NUMBER=13;
    public static final int WHITESPACE=14;

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


    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:34:1: parse : action EOF -> action ;
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
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:35:5: ( action EOF -> action )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:35:7: action EOF
            {
            pushFollow(FOLLOW_action_in_parse187);
            action1=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action1.getTree());

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse189); if (state.failed) return retval; 
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
            // 36:9: -> action
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:39:1: action : ( help | addElement | getElement | deleteElement | -> ^( NO_OP ) );
    public final DiosMioCliParser.action_return action() throws RecognitionException {
        DiosMioCliParser.action_return retval = new DiosMioCliParser.action_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        DiosMioCliParser.help_return help3 =null;

        DiosMioCliParser.addElement_return addElement4 =null;

        DiosMioCliParser.getElement_return getElement5 =null;

        DiosMioCliParser.deleteElement_return deleteElement6 =null;



        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:40:5: ( help | addElement | getElement | deleteElement | -> ^( NO_OP ) )
            int alt1=5;
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
            case EOF:
                {
                alt1=5;
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
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:40:7: help
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_help_in_action218);
                    help3=help();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, help3.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:41:7: addElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_addElement_in_action226);
                    addElement4=addElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addElement4.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:42:7: getElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_getElement_in_action234);
                    getElement5=getElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, getElement5.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:43:7: deleteElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_deleteElement_in_action242);
                    deleteElement6=deleteElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteElement6.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:44:7: 
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
                    // 44:7: -> ^( NO_OP )
                    {
                        // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:44:10: ^( NO_OP )
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:47:1: help : HELP -> ^( HELP ) ;
    public final DiosMioCliParser.help_return help() throws RecognitionException {
        DiosMioCliParser.help_return retval = new DiosMioCliParser.help_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token HELP7=null;

        CommonTree HELP7_tree=null;
        RewriteRuleTokenStream stream_HELP=new RewriteRuleTokenStream(adaptor,"token HELP");

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:48:5: ( HELP -> ^( HELP ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:48:7: HELP
            {
            HELP7=(Token)match(input,HELP,FOLLOW_HELP_in_help271); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_HELP.add(HELP7);


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
            // 49:9: -> ^( HELP )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:49:12: ^( HELP )
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:52:1: addElement : ADD element filepath -> ^( ADD element filepath ) ;
    public final DiosMioCliParser.addElement_return addElement() throws RecognitionException {
        DiosMioCliParser.addElement_return retval = new DiosMioCliParser.addElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ADD8=null;
        DiosMioCliParser.element_return element9 =null;

        DiosMioCliParser.filepath_return filepath10 =null;


        CommonTree ADD8_tree=null;
        RewriteRuleTokenStream stream_ADD=new RewriteRuleTokenStream(adaptor,"token ADD");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:53:5: ( ADD element filepath -> ^( ADD element filepath ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:53:7: ADD element filepath
            {
            ADD8=(Token)match(input,ADD,FOLLOW_ADD_in_addElement302); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ADD.add(ADD8);


            pushFollow(FOLLOW_element_in_addElement304);
            element9=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element9.getTree());

            pushFollow(FOLLOW_filepath_in_addElement306);
            filepath10=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath10.getTree());

            // AST REWRITE
            // elements: filepath, ADD, element
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 54:9: -> ^( ADD element filepath )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:54:12: ^( ADD element filepath )
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:57:1: getElement : GET element id -> ^( GET element id ) ;
    public final DiosMioCliParser.getElement_return getElement() throws RecognitionException {
        DiosMioCliParser.getElement_return retval = new DiosMioCliParser.getElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token GET11=null;
        DiosMioCliParser.element_return element12 =null;

        DiosMioCliParser.id_return id13 =null;


        CommonTree GET11_tree=null;
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:58:5: ( GET element id -> ^( GET element id ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:58:7: GET element id
            {
            GET11=(Token)match(input,GET,FOLLOW_GET_in_getElement341); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GET.add(GET11);


            pushFollow(FOLLOW_element_in_getElement343);
            element12=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element12.getTree());

            pushFollow(FOLLOW_id_in_getElement345);
            id13=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id13.getTree());

            // AST REWRITE
            // elements: GET, id, element
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 59:9: -> ^( GET element id )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:59:12: ^( GET element id )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_GET.nextNode()
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
    // $ANTLR end "getElement"


    public static class deleteElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deleteElement"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:62:1: deleteElement : DELETE element id -> ^( DELETE element id ) ;
    public final DiosMioCliParser.deleteElement_return deleteElement() throws RecognitionException {
        DiosMioCliParser.deleteElement_return retval = new DiosMioCliParser.deleteElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DELETE14=null;
        DiosMioCliParser.element_return element15 =null;

        DiosMioCliParser.id_return id16 =null;


        CommonTree DELETE14_tree=null;
        RewriteRuleTokenStream stream_DELETE=new RewriteRuleTokenStream(adaptor,"token DELETE");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:63:5: ( DELETE element id -> ^( DELETE element id ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:63:7: DELETE element id
            {
            DELETE14=(Token)match(input,DELETE,FOLLOW_DELETE_in_deleteElement380); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DELETE.add(DELETE14);


            pushFollow(FOLLOW_element_in_deleteElement382);
            element15=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element15.getTree());

            pushFollow(FOLLOW_id_in_deleteElement384);
            id16=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id16.getTree());

            // AST REWRITE
            // elements: id, element, DELETE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 64:9: -> ^( DELETE element id )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:64:12: ^( DELETE element id )
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


    public static class element_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "element"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:67:1: element : ( ARTIFACT | CONFIG ) ;
    public final DiosMioCliParser.element_return element() throws RecognitionException {
        DiosMioCliParser.element_return retval = new DiosMioCliParser.element_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set17=null;

        CommonTree set17_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:68:5: ( ( ARTIFACT | CONFIG ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set17=(Token)input.LT(1);

            if ( (input.LA(1) >= ARTIFACT && input.LA(1) <= CONFIG) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set17)
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:71:1: id : NUMBER ;
    public final DiosMioCliParser.id_return id() throws RecognitionException {
        DiosMioCliParser.id_return retval = new DiosMioCliParser.id_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NUMBER18=null;

        CommonTree NUMBER18_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:72:5: ( NUMBER )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:72:7: NUMBER
            {
            root_0 = (CommonTree)adaptor.nil();


            NUMBER18=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_id445); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NUMBER18_tree = 
            (CommonTree)adaptor.create(NUMBER18)
            ;
            adaptor.addChild(root_0, NUMBER18_tree);
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:75:1: filepath : FILEPATH ;
    public final DiosMioCliParser.filepath_return filepath() throws RecognitionException {
        DiosMioCliParser.filepath_return retval = new DiosMioCliParser.filepath_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token FILEPATH19=null;

        CommonTree FILEPATH19_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:75:10: ( FILEPATH )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:75:12: FILEPATH
            {
            root_0 = (CommonTree)adaptor.nil();


            FILEPATH19=(Token)match(input,FILEPATH,FOLLOW_FILEPATH_in_filepath458); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILEPATH19_tree = 
            (CommonTree)adaptor.create(FILEPATH19)
            ;
            adaptor.addChild(root_0, FILEPATH19_tree);
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


 

    public static final BitSet FOLLOW_action_in_parse187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_help_in_action218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addElement_in_action226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getElement_in_action234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteElement_in_action242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_help271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_addElement302 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_addElement304 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_filepath_in_addElement306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getElement341 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_getElement343 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_id_in_getElement345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_deleteElement380 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_deleteElement382 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_id_in_deleteElement384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_id445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILEPATH_in_filepath458 = new BitSet(new long[]{0x0000000000000002L});

}