package io.rodyamirov.brucelang.astwalkers;

import io.rodyamirov.brucelang.ast.ASTNode;
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

import java.util.function.Consumer;

public interface ASTWalker {
    void programWalk(WalkFunctions<ProgramNode> walkFunctions);
    void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions);
    void varDefnWalk(WalkFunctions<VariableDefinitionNode> walkFunctions);
    void varDeclWalk(WalkFunctions<VariableDeclarationNode> walkFunctions);
    void returnWalk(WalkFunctions<ReturnStatementNode> walkFunctions);
    void doWalk(WalkFunctions<DoStatementNode> walkFunctions);
    void fnCallWalk(WalkFunctions<FunctionCallNode> walkFunctions);
    void ifStmtWalk(WalkFunctions<IfStatementNode> walkFunctions);
    void binOpWalk(WalkFunctions<BinOpExprNode> walkFunctions);
    void unaryOpWalk(WalkFunctions<UnaryOpExprNode> walkFunctions);
    void fieldAccessWalk(WalkFunctions<FieldAccessNode> walkFunctions);
    void intExprWalk(WalkFunctions<IntExprNode> walkFunctions);
    void boolExprWalk(WalkFunctions<BoolExprNode> walkFunctions);
    void stringExprWalk(WalkFunctions<StringExprNode> walkFunctions);
    void varRefWalk(WalkFunctions<VariableReferenceNode> walkFunctions);
    void blockStmtWalk(WalkFunctions<BlockStatementNode> walkFunctions);

    // We use this class so that each call to a "walk" function doesn't have to recreate the
    // lambdas each time -- they can be created one time and assigned, then used later on in
    // a pre- or post- walker.
    class WalkFunctions<T extends ASTNode> {
        private static final Consumer EMPTY_CONSUMER = c -> {};

        // if not otherwise assigned, the pre- and post- walkers are non-null but do nothing
        private Consumer<T> preWalker = EMPTY_CONSUMER;
        private Consumer<T> postWalker = EMPTY_CONSUMER;

        public Consumer<T> getPreWalker() {
            return preWalker;
        }

        public Consumer<T> getPostWalker() {
            return postWalker;
        }

        public WalkFunctions<T> preWalker(Consumer<T> preWalker) {
            this.preWalker = preWalker;
            return this;
        }

        public WalkFunctions<T> postWalker(Consumer<T> postWalker) {
            this.postWalker = postWalker;
            return this;
        }
    }
}
