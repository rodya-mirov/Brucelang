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
    | typeDefnStmt      # typeDefnStmtBranch
    | nativeDeclStmt    # nativeDeclStmtBranch
    ;

nativeDeclStmt
    : DECLARE NATIVE ID COLON typeExpr SEMI
    ;

typeDefnStmt
    : DECLARE NATIVE TYPE ID L_CURLY (fieldDecl)* R_CURLY (SEMI)?
    ;

fieldDecl
    : ID COLON typeExpr SEMI
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
    : DEFINE ID L_PAREN varDeclList R_PAREN COLON typeExpr AS blockStmt (SEMI)?
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
    : ID                                                    # simpleType
    | ID LT typeExprList GT                                 # complexType
    | FN L_PAREN typeExprList R_PAREN SM_ARROW typeExpr     # fnType
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
    : varDecl BIG_ARROW blockStmt                       # oneArgLambda
    | L_PAREN varDeclList R_PAREN BIG_ARROW blockStmt   # multiArgLambda
    | varDecl BIG_ARROW expr                            # oneArgExprLambda
    | L_PAREN varDeclList R_PAREN BIG_ARROW expr        # multiArgExprLambda
    ;

linkedBoolExpr
    : compExpr                  # fallThroughCompExpr
    | compExpr BOOL_OP compExpr # boolOpExpr
    ;

compExpr
    : addExpr                   # fallThroughAddExpr
    | addExpr COMP_OP addExpr   # compOpExpr
    ;

addExpr
    : mulExpr (ADD_OP mulExpr)*
    ;

mulExpr
    : unaryExpr (MUL_OP unaryExpr)*
    ;

unaryExpr
    : accessOrCall         # fallThroughAccessOrCall
    | UNARY_OP unaryExpr   # nestedUnaryExpr
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
    | BOOL_VAL                         # boolConst
    ;

BOOL_OP   : AND | OR ;
COMP_OP   : GT | GTE | LT | LTE | EQ | NEQ ;
BOOL_VAL  : TRUE  | FALSE  ;
ADD_OP    : PLUS  | MINUS  ;
MUL_OP    : TIMES | DIVIDE ;
UNARY_OP  : MINUS | NOT    ;


TRUE   : 'true' ;
FALSE  : 'false' ;

DECLARE : 'declare' ;
NATIVE  : 'native' ;
DEFINE : 'define' ;
DO     : 'do' ;
RETURN : 'return' ;
AS     : 'as' ;
IS     : 'is' ;
IF     : 'if' ;
ELSE   : 'else' ;
LET    : 'let' ;
TYPE   : 'type' ;

FN     : 'Fn' ;

AND    : '&&' ;
OR     : '||' ;
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
NOT    : '!'  ;

SEMI   : ';' ;
L_CURLY : '{' ;
R_CURLY : '}' ;
L_PAREN : '(' ;
R_PAREN : ')' ;
SM_ARROW   : '->' ;
BIG_ARROW  : '=>' ;
SET_EQ : '=' ;
COLON  : ':' ;
COMMA  : ',' ;
DOT    : '.' ;

LINE_COMMENT  : '//' ~('\n' | '\r')* '\r'? '\n' -> skip ;
BLOCK_COMMENT : '/*' (.)*? '*/'                 -> skip ; // note non-greedy regex

// note that keywords _cannot_ parse as IDs; they have priority in the lexer, by design
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

