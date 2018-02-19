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

public interface ASTPostWalker {
    void postWalkProgram(ProgramNode programNode);
    void postWalkFunctionExpr(FunctionExprNode functionExprNode);
    void postWalkVariableDefn(VariableDefinitionNode variableDefinitionNode);
    void postWalkVariableDecl(VariableDeclarationNode variableDeclarationNode);
    void postWalkReturnStmt(ReturnStatementNode returnStatementNode);
    void postWalkFnCall(FunctionCallNode functionCallNode);
    void postWalkIfStmt(IfStatementNode ifStatementNode);
    void postWalkBinOp(BinOpExprNode binOpExprNode);
    void postWalkUnaryOp(UnaryOpExprNode unaryOpExprNode);
    void postWalkFieldAccess(FieldAccessNode fieldAccessNode);
    void postWalkIntExpr(IntExprNode integerNode);
    void postWalkBoolExpr(BoolExprNode booleanNode);
    void postWalkStringExpr(StringExprNode stringExprNode);
    void postWalkVarRef(VariableReferenceNode variableReferenceNode);
    void postWalkDoStmt(DoStatementNode doStatementNode);
    void postWalkBlockStmt(BlockStatementNode blockStatementNode);
}
