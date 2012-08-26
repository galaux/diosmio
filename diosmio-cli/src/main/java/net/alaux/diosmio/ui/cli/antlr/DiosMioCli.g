grammar DiosMioCli;

options {
    output=AST;
    ASTLabelType=CommonTree;
    backtrack=true;
}

tokens {
    CMD_HELP;

    CMD_ADD_ARTIFACT;
    CMD_GET_ARTIFACT;
    CMD_DELETE_ARTIFACT;

    CMD_ADD_CONFIG;
    CMD_GET_CONFIG;
    CMD_DELETE_CONFIG;

    CMD_LOAD;
    CMD_PARSE;

    CMD_NO_OP;
}

@header {
package net.alaux.diosmio.ui.cli.antlr;

import net.alaux.diosmio.ui.cli.Main;
import java.text.MessageFormat;
}

@lexer::header {
package net.alaux.diosmio.ui.cli.antlr;

import net.alaux.diosmio.ui.cli.Main;
import java.text.MessageFormat;
}

@parser::members
{
    public void reportError(RecognitionException e) {
        String errorMessage = MessageFormat.format(Main.bundle.getString("error.syntax"), e.charPositionInLine, this.getErrorMessage(e, this.getTokenNames()));
        throw new RuntimeException(errorMessage);
    }
}

@lexer::members
{
    public void reportError(RecognitionException e) {
        String errorMessage = MessageFormat.format(Main.bundle.getString("error.syntax"), e.charPositionInLine, this.getErrorMessage(e, this.getTokenNames()));
        throw new RuntimeException(errorMessage);
    }
}


/* ***************************************************************** *
 *                          PARSER RULES                             *
 * ***************************************************************** */

parse
    : action EOF
        -> action
    ;

action
    : help
    | addArtifact
    | getArtifact
    | deleteArtifact
    | addConfig
    | getConfig
    | deleteConfig
    | loadFile
    | parseFile
    | -> ^(CMD_NO_OP)
    ;

help
    : HELP
        -> ^(CMD_HELP)
    ;

// Artifacts ********************************************************
addArtifact
    : ADD ARTIFACT filepath
        -> ^(CMD_ADD_ARTIFACT filepath)
    ;

getArtifact
    : GET ARTIFACT id?
        -> ^(CMD_GET_ARTIFACT id?)
    ;

deleteArtifact
    : DELETE ARTIFACT id
        -> ^(CMD_DELETE_ARTIFACT id)
     ;

// Configurations ***************************************************
addConfig
    : ADD CONFIG hostname sshPort sshUser
        -> ^(CMD_ADD_CONFIG hostname sshPort sshUser)
    ;

getConfig
    : GET CONFIG id?
        -> ^(CMD_GET_CONFIG id?)
    ;

deleteConfig
    : DELETE CONFIG id
        -> ^(CMD_DELETE_CONFIG id)
     ;

// Misc *************************************************************
loadFile
    : LOAD filepath
        -> ^(CMD_LOAD filepath)
    ;

parseFile
    : PARSE filepath
        -> ^(CMD_PARSE filepath)
    ;

id
    : NUMBER
    ;

filepath : FILEPATH;

hostname : WORD;

sshPort : NUMBER;

sshUser : WORD;

/* ***************************************************************** *
 *                          LEXER RULES                              *
 * ***************************************************************** */

HELP        : 'help';
ADD         : 'add';
GET         : 'get';
DELETE      : 'delete';

LOAD        : 'load';
PARSE       : 'parse';

ARTIFACT    : 'artifact';
CONFIG      : 'config';

NUMBER  : (DIGIT)+ ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;

fragment DIGIT  : '0'..'9' ;

// TODO get a better "word" definition
WORD : ( 'a'..'z' | 'A'..'Z' )+;

// TODO get a better "filepath" definition
FILEPATH : ( 'a'..'z' | 'A'..'Z' | '/' | '.' | '-' | DIGIT )+;