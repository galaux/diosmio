grammar DiosMioCli;

options {
    output=AST;
    ASTLabelType=CommonTree;
    backtrack=true;
}

tokens {
    HELP        = 'help';

    ADD         = 'add';
    GET         = 'get';
    DELETE      = 'delete';

    ARTIFACT    = 'artifact';
    CONFIG      = 'config';

    NO_OP;
}

@header {
package net.alaux.diosmio.ui.cli.antlr;
}

@lexer::header {
package net.alaux.diosmio.ui.cli.antlr;
}

@parser::members
{
    public void reportError(RecognitionException e) {
        String errorMessage = "Syntax error at position " + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames());
        throw new RuntimeException(errorMessage);
    }
}

@lexer::members
{
    public void reportError(RecognitionException e) {
        String errorMessage = "Syntax error at position " + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames());
        throw new RuntimeException(errorMessage);
    }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

parse
    : action EOF
        -> action
    ;

action
    : help
    | addElement
    | getElement
    | deleteElement
    | -> ^(NO_OP)
    ;

help
    : HELP
        -> ^(HELP)
    ;

addElement
    : ADD element filepath
        -> ^(ADD element filepath)
    ;

getElement
    : GET element id?
        -> ^(GET element id?)
    ;

deleteElement
    : DELETE element id
        -> ^(DELETE element id)
     ;

element
    : ( ARTIFACT | CONFIG )
    ;

id
    : NUMBER
    ;

filepath : FILEPATH;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

NUMBER  : (DIGIT)+ ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;

fragment DIGIT  : '0'..'9' ;

FILEPATH : ( 'a'..'z' | 'A'..'Z' | '/' | '.' | '-' )+;
