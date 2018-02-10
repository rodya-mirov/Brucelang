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
    | doStmt
    | ifStmt
    ;

returnStmt
    : RETURN expr ';'
    ;

doStmt
    : DO expr ';'
    ;

blockStmt
    : '{' (stmt)* '}'
    ;

ifStmt
    : IF '(' expr ')' blockStmt ( ELSE IF '(' expr ')' blockStmt )* ( ELSE blockStmt )?
    ;

varDef
    : LET varDecl '=' expr ';'
    ;

fnDef
    : DEFINE ID '(' varDeclList ')' ':' typeExpr AS blockStmt
    ;

varDecl
    : ID ':' typeExpr
    ;

varDeclList
    :                           # noVarDecls
    | varDecl (',' varDecl)*    # someVarDecls
    ;

typeExpr
    : ID                        # simpleType
    | ID '<' typeExprList '>'   # complexType
    ;

typeExprList
    :                           # noTypes
    | typeExpr (',' typeExpr)*  # someTypes
    ;

exprList
    :                   # noExprs
    | expr (',' expr)*  # someExprs
    ;

expr // top-level expression class
    : lambda          # lambdaExpression
    | linkedBoolExpr  # booleanExpression
    ;

lambda
    : varDecl '=>' blockStmt                # oneArgLambda
    | '(' varDeclList ')' '=>' blockStmt    # multiArgLambda
    | varDecl '=>' expr                     # oneArgExprLambda
    | '(' varDeclList ')' '=>' expr         # multiArgExprLambda
    ;

linkedBoolExpr
    : compExpr                  # fallThroughCompExpr
    | compExpr boolOp compExpr  # boolOpExpr
    ;

compExpr
    : addExpr                   # fallThroughAddExpr
    | addExpr compOp addExpr    # compOpExpr
    ;

addExpr
    : mulExpr (addOp mulExpr)*
    ;

mulExpr
    : unaryExpr (mulOp unaryExpr)*
    ;

unaryExpr
    : accessOrCall         # fallThroughAccessOrCall
    | unaryOp unaryExpr    # nestedUnaryExpr
    ;

accessOrCall
    : accessOrCall '.' ID           # namedFieldAccess
    | accessOrCall '(' exprList ')' # fnCall
    | baseExpr                      # fallThroughBaseExpr
    ;

baseExpr
    : '(' expr ')'                     # parenExpr
    | ID                               # variableReference
    | INT                              # numConst
    // | '"' (STRING_CONST)? '"'          # stringConst // TODO: This is commented out because it's broken -- should be done at the lexer level
    | boolVal                          # boolConst
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
