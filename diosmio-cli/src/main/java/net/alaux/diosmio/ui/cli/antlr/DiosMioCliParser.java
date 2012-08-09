// $ANTLR 3.4 src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g 2012-08-09 18:05:27

package net.alaux.diosmio.ui.cli.antlr;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class DiosMioCliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ARTIFACT", "CONFIG", "DELETE", "DIGIT", "EXIT", "FILEPATH", "GET", "HELP", "NO_OP", "NUMBER", "WHITESPACE", "'exit'", "'quit'"
    };

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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:51:1: parse : action EOF -> action ;
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
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:52:5: ( action EOF -> action )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:52:7: action EOF
            {
            pushFollow(FOLLOW_action_in_parse206);
            action1=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action1.getTree());

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse208); if (state.failed) return retval; 
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
            // 53:9: -> action
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:56:1: action : ( help | exit | addElement | getElement | deleteElement | -> ^( NO_OP ) );
    public final DiosMioCliParser.action_return action() throws RecognitionException {
        DiosMioCliParser.action_return retval = new DiosMioCliParser.action_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        DiosMioCliParser.help_return help3 =null;

        DiosMioCliParser.exit_return exit4 =null;

        DiosMioCliParser.addElement_return addElement5 =null;

        DiosMioCliParser.getElement_return getElement6 =null;

        DiosMioCliParser.deleteElement_return deleteElement7 =null;



        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:57:5: ( help | exit | addElement | getElement | deleteElement | -> ^( NO_OP ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case HELP:
                {
                alt1=1;
                }
                break;
            case 16:
            case 17:
                {
                alt1=2;
                }
                break;
            case ADD:
                {
                alt1=3;
                }
                break;
            case GET:
                {
                alt1=4;
                }
                break;
            case DELETE:
                {
                alt1=5;
                }
                break;
            case EOF:
                {
                alt1=6;
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
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:57:7: help
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_help_in_action237);
                    help3=help();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, help3.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:58:7: exit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_exit_in_action245);
                    exit4=exit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exit4.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:59:7: addElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_addElement_in_action253);
                    addElement5=addElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addElement5.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:60:7: getElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_getElement_in_action261);
                    getElement6=getElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, getElement6.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:61:7: deleteElement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_deleteElement_in_action269);
                    deleteElement7=deleteElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, deleteElement7.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:62:7: 
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
                    // 62:7: -> ^( NO_OP )
                    {
                        // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:62:10: ^( NO_OP )
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:65:1: help : HELP -> ^( HELP ) ;
    public final DiosMioCliParser.help_return help() throws RecognitionException {
        DiosMioCliParser.help_return retval = new DiosMioCliParser.help_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token HELP8=null;

        CommonTree HELP8_tree=null;
        RewriteRuleTokenStream stream_HELP=new RewriteRuleTokenStream(adaptor,"token HELP");

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:66:5: ( HELP -> ^( HELP ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:66:7: HELP
            {
            HELP8=(Token)match(input,HELP,FOLLOW_HELP_in_help298); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_HELP.add(HELP8);


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
            // 67:9: -> ^( HELP )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:67:12: ^( HELP )
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


    public static class exit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "exit"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:70:1: exit : ( 'exit' | 'quit' ) -> EXIT ;
    public final DiosMioCliParser.exit_return exit() throws RecognitionException {
        DiosMioCliParser.exit_return retval = new DiosMioCliParser.exit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal9=null;
        Token string_literal10=null;

        CommonTree string_literal9_tree=null;
        CommonTree string_literal10_tree=null;
        RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:71:5: ( ( 'exit' | 'quit' ) -> EXIT )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:71:7: ( 'exit' | 'quit' )
            {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:71:7: ( 'exit' | 'quit' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==17) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:71:9: 'exit'
                    {
                    string_literal9=(Token)match(input,16,FOLLOW_16_in_exit331); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_16.add(string_literal9);


                    }
                    break;
                case 2 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:71:18: 'quit'
                    {
                    string_literal10=(Token)match(input,17,FOLLOW_17_in_exit335); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_17.add(string_literal10);


                    }
                    break;

            }


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
            // 72:9: -> EXIT
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(EXIT, "EXIT")
                );

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
    // $ANTLR end "exit"


    public static class addElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "addElement"
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:74:1: addElement : ADD element filepath -> ^( ADD element filepath ) ;
    public final DiosMioCliParser.addElement_return addElement() throws RecognitionException {
        DiosMioCliParser.addElement_return retval = new DiosMioCliParser.addElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ADD11=null;
        DiosMioCliParser.element_return element12 =null;

        DiosMioCliParser.filepath_return filepath13 =null;


        CommonTree ADD11_tree=null;
        RewriteRuleTokenStream stream_ADD=new RewriteRuleTokenStream(adaptor,"token ADD");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        RewriteRuleSubtreeStream stream_filepath=new RewriteRuleSubtreeStream(adaptor,"rule filepath");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:75:5: ( ADD element filepath -> ^( ADD element filepath ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:75:7: ADD element filepath
            {
            ADD11=(Token)match(input,ADD,FOLLOW_ADD_in_addElement361); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ADD.add(ADD11);


            pushFollow(FOLLOW_element_in_addElement363);
            element12=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element12.getTree());

            pushFollow(FOLLOW_filepath_in_addElement365);
            filepath13=filepath();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_filepath.add(filepath13.getTree());

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
            // 76:9: -> ^( ADD element filepath )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:76:12: ^( ADD element filepath )
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:79:1: getElement : GET element ( id )? -> ^( GET element ( id )? ) ;
    public final DiosMioCliParser.getElement_return getElement() throws RecognitionException {
        DiosMioCliParser.getElement_return retval = new DiosMioCliParser.getElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token GET14=null;
        DiosMioCliParser.element_return element15 =null;

        DiosMioCliParser.id_return id16 =null;


        CommonTree GET14_tree=null;
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:80:5: ( GET element ( id )? -> ^( GET element ( id )? ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:80:7: GET element ( id )?
            {
            GET14=(Token)match(input,GET,FOLLOW_GET_in_getElement400); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GET.add(GET14);


            pushFollow(FOLLOW_element_in_getElement402);
            element15=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element15.getTree());

            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:80:19: ( id )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NUMBER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:80:19: id
                    {
                    pushFollow(FOLLOW_id_in_getElement404);
                    id16=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id16.getTree());

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
            // 81:9: -> ^( GET element ( id )? )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:81:12: ^( GET element ( id )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_GET.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_element.nextTree());

                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:81:26: ( id )?
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:84:1: deleteElement : DELETE element id -> ^( DELETE element id ) ;
    public final DiosMioCliParser.deleteElement_return deleteElement() throws RecognitionException {
        DiosMioCliParser.deleteElement_return retval = new DiosMioCliParser.deleteElement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DELETE17=null;
        DiosMioCliParser.element_return element18 =null;

        DiosMioCliParser.id_return id19 =null;


        CommonTree DELETE17_tree=null;
        RewriteRuleTokenStream stream_DELETE=new RewriteRuleTokenStream(adaptor,"token DELETE");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:85:5: ( DELETE element id -> ^( DELETE element id ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:85:7: DELETE element id
            {
            DELETE17=(Token)match(input,DELETE,FOLLOW_DELETE_in_deleteElement441); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DELETE.add(DELETE17);


            pushFollow(FOLLOW_element_in_deleteElement443);
            element18=element();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_element.add(element18.getTree());

            pushFollow(FOLLOW_id_in_deleteElement445);
            id19=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id19.getTree());

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
            // 86:9: -> ^( DELETE element id )
            {
                // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:86:12: ^( DELETE element id )
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:89:1: element : ( ARTIFACT | CONFIG ) ;
    public final DiosMioCliParser.element_return element() throws RecognitionException {
        DiosMioCliParser.element_return retval = new DiosMioCliParser.element_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set20=null;

        CommonTree set20_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:90:5: ( ( ARTIFACT | CONFIG ) )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set20=(Token)input.LT(1);

            if ( (input.LA(1) >= ARTIFACT && input.LA(1) <= CONFIG) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set20)
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:93:1: id : NUMBER ;
    public final DiosMioCliParser.id_return id() throws RecognitionException {
        DiosMioCliParser.id_return retval = new DiosMioCliParser.id_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NUMBER21=null;

        CommonTree NUMBER21_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:94:5: ( NUMBER )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:94:7: NUMBER
            {
            root_0 = (CommonTree)adaptor.nil();


            NUMBER21=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_id506); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NUMBER21_tree = 
            (CommonTree)adaptor.create(NUMBER21)
            ;
            adaptor.addChild(root_0, NUMBER21_tree);
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
    // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:97:1: filepath : FILEPATH ;
    public final DiosMioCliParser.filepath_return filepath() throws RecognitionException {
        DiosMioCliParser.filepath_return retval = new DiosMioCliParser.filepath_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token FILEPATH22=null;

        CommonTree FILEPATH22_tree=null;

        try {
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:97:10: ( FILEPATH )
            // src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g:97:12: FILEPATH
            {
            root_0 = (CommonTree)adaptor.nil();


            FILEPATH22=(Token)match(input,FILEPATH,FOLLOW_FILEPATH_in_filepath519); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILEPATH22_tree = 
            (CommonTree)adaptor.create(FILEPATH22)
            ;
            adaptor.addChild(root_0, FILEPATH22_tree);
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


 

    public static final BitSet FOLLOW_action_in_parse206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_help_in_action237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exit_in_action245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addElement_in_action253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getElement_in_action261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteElement_in_action269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_help298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_exit331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_exit335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_addElement361 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_addElement363 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_filepath_in_addElement365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getElement400 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_getElement402 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_id_in_getElement404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_deleteElement441 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_element_in_deleteElement443 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_id_in_deleteElement445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_id506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILEPATH_in_filepath519 = new BitSet(new long[]{0x0000000000000002L});

}