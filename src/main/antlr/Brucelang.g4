// Define a grammar called Expression
grammar Brucelang;
@header {
package io.rodyamirov.brucelang.lexparse;
}

program
    : (stmt)* EOF
    ;

stmt // TODO: named branches
    : blockStmt
    | fnDef
    | varDef
    | returnStmt
    | ifStmt
    ;

returnStmt
    : RETURN expr ';'
    ;

blockStmt
    : '{' (stmt)* '}'
    ;

ifStmt
    : IF '(' expr ')' blockStmt ( ELSE IF '(' expr ')' blockStmt )* ( ELSE blockStmt )?
    ;

varDef
    : LET ID '=' expr ';'
    ;

fnDef
    : DEFINE ID '(' idList ')' AS blockStmt
    ;

idList
    :                # noIds
    | ID (',' ID)*   # someIds
    ;

exprList
    : expr (',' expr)*
    ;

expr // top-level expression class
    : lambda          # lambdaExpression
    | boolExpr        # booleanExpression
    ;

lambda
    : ID '=>' blockStmt                # oneArgLambda
    | '(' idList ')' '=>' blockStmt    # multiArgLambda
    | ID '=>' expr                     # oneArgExprLambda
    | '(' idList ')' '=>' expr         # multiArgExprLambda
    ;

boolExpr // expressions involving a boolean operation, not necessarily those which evaluate to a boolean value
    : addExpr                   # fallThroughAddExpr
    | addExpr boolOp addExpr    # boolOpExpr // note not a list; attempts to chain must be parenthetized (this may change)
    ;

addExpr
    : mulExpr (addOp mulExpr)*
    ;

mulExpr
    : unaryExpr (mulOp unaryExpr)*
    ;

unaryExpr
    : baseExpr          # fallThroughBaseExpr
    | unaryOp unaryExpr # nestedUnaryExpr
    ;

baseExpr
    : '(' expr ')'                     # parenExpr
    | fnCall                           # fallThroughFnCall
    | ID                               # variableReference
    | INT                              # numConst
    | '"' (STRING_CONST)? '"'          # stringConst
    | boolVal                          # boolConst
    ;

fnCall
    : ID '(' exprList ')'              # namedFnCall
    | '(' lambda ')' '(' exprList ')'  # anonFnCall
    ;

boolOp    : AND | OR ;
compOp    : GT | GTE | LT | LTE | EQ | NEQ ;
boolVal   : TRUE  | FALSE  ;
addOp     : PLUS  | MINUS  ;
mulOp     : TIMES | DIVIDE ;
unaryOp   : MINUS          ;

TRUE   : 'true' ;
FALSE  : 'false' ;

DEFINE : 'define' ;
DO     : 'do' ;
RETURN : 'return' ;
AS     : 'as' ;
IS     : 'is' ;
IF     : 'if' ;
ELSE   : 'else' ;
LET    : 'let' ;

STRING_CONST : ([^"])+ ; // TODO: I don't think this actually works, see what happens with escaped quotes

AND    : 'and' ;
OR     : 'or' ;
PLUS   : '+'  ;
MINUS  : '-'  ;
TIMES  : '*'  ;
DIVIDE : '/'  ;
LT     : '<'  ;
LTE    : '<=' ;
GT     : '>'  ;
GTE    : '>=' ;
EQ     : '==' ;
NEQ    : '!=' ;

ID : [A-Za-z][A-Za-z0-9_]* ; // ids have to start with a letter, then letter/num/underscore all good
INT: [0-9]+ ;             // int
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
