package io.rodyamirov.brucelang.astwalkers;

import io.rodyamirov.brucelang.ast.BinOpExprNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;

public interface ASTPreWalker {
    void preWalkProgram(ProgramNode programNode);
    void preWalkFunctionExpr(FunctionExprNode functionExprNode);
    void preWalkVariableDefn(VariableDefinitionNode variableDefinitionNode);
    void preWalkVariableDecl(VariableDeclarationNode variableDeclarationNode);
    void preWalkReturnStmt(ReturnStatementNode returnStatementNode);
    void preWalkFnCall(FunctionCallNode functionCallNode);
    void preWalkIfStmt(IfStatementNode ifStatementNode);
    void preWalkBinOp(BinOpExprNode binOpExprNode);
    void preWalkUnaryOp(UnaryOpExprNode unaryOpExprNode);
    void preWalkFieldAccess(FieldAccessNode fieldAccessNode);
    void preWalkIntExpr(IntExprNode integerNode);
    void preWalkBoolExpr(BoolExprNode booleanNode);
    void preWalkStringExpr(StringExprNode stringExprNode);
    void preWalkVarRef(VariableReferenceNode variableReferenceNode);
    void preWalkDoStmt(DoStatementNode doStatementNode);
    void preWalkBlockStmt(BlockStatementNode blockStatementNode);
}
