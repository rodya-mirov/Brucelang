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
    : LET varDecl SET_EQ expr SEMI                  # simpleVarDef
    | LET varDecl LT idList GT SET_EQ expr SEMI     # parametrizedVarDef
    ;

fnDef
    : DEFINE ID L_PAREN varDeclList R_PAREN COLON typeExpr AS blockStmt (SEMI)?
    ;

varDecl
    : ID COLON typeExpr             # explicitVarDecl
    | ID                            # inferredVarDecl
    ;

varDeclList
    :                               # noVarDecls
    | varDecl (COMMA varDecl)*      # someVarDecls
    ;

typeExpr
    : ID                                                    # simpleType
    | ID LT typeExprList GT                                 # complexType
    | FN L_PAREN typeExprList R_PAREN SM_ARROW typeExpr     # fnType
    | TYPE_FN L_PAREN idList R_PAREN SM_ARROW typeExpr      # typeFnType
    // I suspect parens aren't necessary for ambiguity prevention,
    // but it felt right to be able to use them if I wanted to
    | L_PAREN typeExpr R_PAREN                              # parenType
    ;

typeExprList
    :                               # noTypes
    | typeExpr (COMMA typeExpr)*    # someTypes
    ;

idList
    :                               # noIds
    | ID (COMMA ID)*                # someIds
    ;

exprList
    :                               # noExprs
    | expr (COMMA expr)*            # someExprs
    ;

expr // top-level expression class
    : lambda                        # lambdaExpr
    | typeLambda                    # typeLambdaExpr
    | linkedBoolExpr                # booleanExpression
    ;

typeLambda
    // note there is no "no parens" option; the <T> syntax helps remind you it's a type function
    : LT idList GT BIG_ARROW blockStmt                  # stmtTypeLambda
    | LT idList GT BIG_ARROW expr                       # exprTypeLambda
    ;

lambda
    : varDecl BIG_ARROW blockStmt                       # oneArgLambda
    | L_PAREN varDeclList R_PAREN BIG_ARROW blockStmt   # multiArgLambda
    | varDecl BIG_ARROW expr                            # oneArgExprLambda
    | L_PAREN varDeclList R_PAREN BIG_ARROW expr        # multiArgExprLambda
    ;

linkedBoolExpr
    : compExpr                  # fallThroughCompExpr
    | compExpr boolOp compExpr # boolOpExpr
    ;

compExpr
    : addExpr                   # fallThroughAddExpr
    | addExpr compOp addExpr   # compOpExpr
    ;

addExpr
    : mulExpr (addOp mulExpr)*
    ;

mulExpr
    : unaryExpr (mulOp unaryExpr)*
    ;

unaryExpr
    : accessOrCall         # fallThroughAccessOrCall
    | unaryOp unaryExpr   # nestedUnaryExpr
    ;

accessOrCall
    : accessOrCall DOT ID                   # namedFieldAccess
    | accessOrCall L_PAREN exprList R_PAREN # fnCall
    | accessOrCall LT typeExprList GT       # typeFnCall
    | baseExpr                              # fallThroughBaseExpr
    ;

baseExpr
    : L_PAREN expr R_PAREN             # parenExpr
    | ID                               # variableReference
    | INT                              # numConst
    | STRING_CONST                     # stringConst
    | boolVal                         # boolConst
    ;

boolOp  : AND | OR ;
compOp  : GT | GTE | LT | LTE | EQ | NEQ ;
boolVal : TRUE  | FALSE  ;
addOp   : PLUS  | MINUS  ;
mulOp   : TIMES | DIVIDE ;
unaryOp : MINUS | NOT    ;


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
TYPE_FN : 'TypeFn' ;

AND    : '&&' ;
OR     : '||' ;
PLUS   : '+'  ;
MINUS  : '-'  ;
TIMES  : '*'  ;
DIVIDE : '/'  ;
LTE    : '<=' ;
LT     : '<'  ;
GTE    : '>=' ;
GT     : '>'  ;
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

