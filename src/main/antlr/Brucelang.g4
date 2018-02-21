grammar Brucelang;

@header {
package io.rodyamirov.brucelang.lexparse;
}

program
    : (stmt)* EOF
    ;

stmt
    : blockStmt         # blockStmtBranch
    | fnDef             # fnDefBranch
    | varDef            # varDefBranch
    | returnStmt        # returnStmtBranch
    | doStmt            # doStmtBranch
    | ifStmt            # ifStmtBranch
    ;

returnStmt
    : RETURN expr SEMI
    ;

doStmt
    : DO expr SEMI
    ;

blockStmt
    : L_CURLY (stmt)* R_CURLY
    ;

ifStmt
    : IF L_PAREN expr R_PAREN blockStmt ( ELSE IF L_PAREN expr R_PAREN blockStmt )* ( ELSE blockStmt )?
    ;

varDef
    : LET varDecl SET_EQ expr SEMI              # fullVarDef
    | LET inferredVarDecl SET_EQ expr SEMI      # inferredVarDef
    ;

fnDef
    : DEFINE ID L_PAREN varDeclList R_PAREN COLON typeExpr AS blockStmt
    ;

varDecl
    : ID COLON typeExpr
    ;

inferredVarDecl
    : ID
    ;

varDeclList
    :                               # noVarDecls
    | varDecl (COMMA varDecl)*      # someVarDecls
    ;

typeExpr
    : ID                            # simpleType
    | ID LT typeExprList GT         # complexType
    ;

typeExprList
    :                               # noTypes
    | typeExpr (COMMA typeExpr)*    # someTypes
    ;

exprList
    :                               # noExprs
    | expr (COMMA expr)*            # someExprs
    ;

expr // top-level expression class
    : lambda                        # lambdaExpression
    | linkedBoolExpr                # booleanExpression
    ;

lambda
    : varDecl ARROW blockStmt                       # oneArgLambda
    | L_PAREN varDeclList R_PAREN ARROW blockStmt   # multiArgLambda
    | varDecl ARROW expr                            # oneArgExprLambda
    | L_PAREN varDeclList R_PAREN ARROW expr        # multiArgExprLambda
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
    : accessOrCall DOT ID                   # namedFieldAccess
    | accessOrCall L_PAREN exprList R_PAREN # fnCall
    | baseExpr                              # fallThroughBaseExpr
    ;

baseExpr
    : L_PAREN expr R_PAREN             # parenExpr
    | ID                               # variableReference
    | INT                              # numConst
    | STRING_CONST                     # stringConst
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

SEMI   : ';' ;
L_CURLY : '{' ;
R_CURLY : '}' ;
L_PAREN : '(' ;
R_PAREN : ')' ;
ARROW  : '=>' ;
SET_EQ : '=' ;
COLON  : ':' ;
COMMA  : ',' ;
DOT    : '.' ;

LINE_COMMENT  : '//' ~('\n' | '\r')* '\r'? '\n' -> skip ;
BLOCK_COMMENT : '/*' (.)*? '*/'                 -> skip ; // note non-greedy regex

ID : [A-Za-z][A-Za-z0-9_]* ; // ids have to start with a letter, then letter/num/underscore all good

INT: [0-9]+ ;             // int

STRING_CONST
    : '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

ESC_SEQ
    : '\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')
    | UNICODE_ESC
    | OCTAL_ESC
    ;

OCTAL_ESC
    : '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    | '\\' ('0'..'7') ('0'..'7')
    | '\\' ('0'..'7')
    ;

UNICODE_ESC
    : '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

