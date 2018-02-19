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

public class DefaultASTWalker implements ASTWalker {
    @Override
    public void programWalk(WalkFunctions<ProgramNode> walkFunctions) {
    }

    @Override
    public void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions) {
    }

    @Override
    public void varDefnWalk(WalkFunctions<VariableDefinitionNode> walkFunctions) {
    }

    @Override
    public void varDeclWalk(WalkFunctions<VariableDeclarationNode> walkFunctions) {
    }

    @Override
    public void returnWalk(WalkFunctions<ReturnStatementNode> walkFunctions) {
    }

    @Override
    public void doWalk(WalkFunctions<DoStatementNode> walkFunctions) {
    }

    @Override
    public void fnCallWalk(WalkFunctions<FunctionCallNode> walkFunctions) {
    }

    @Override
    public void ifStmtWalk(WalkFunctions<IfStatementNode> walkFunctions) {
    }

    @Override
    public void binOpWalk(WalkFunctions<BinOpExprNode> walkFunctions) {
    }

    @Override
    public void unaryOpWalk(WalkFunctions<UnaryOpExprNode> walkFunctions) {
    }

    @Override
    public void fieldAccessWalk(WalkFunctions<FieldAccessNode> walkFunctions) {
    }

    @Override
    public void intExprWalk(WalkFunctions<IntExprNode> walkFunctions) {
    }

    @Override
    public void boolExprWalk(WalkFunctions<BoolExprNode> walkFunctions) {
    }

    @Override
    public void stringExprWalk(WalkFunctions<StringExprNode> walkFunctions) {
    }

    @Override
    public void varRefWalk(WalkFunctions<VariableReferenceNode> walkFunctions) {
    }

    @Override
    public void blockStmtWalk(WalkFunctions<BlockStatementNode> walkFunctions) {
    }
}
