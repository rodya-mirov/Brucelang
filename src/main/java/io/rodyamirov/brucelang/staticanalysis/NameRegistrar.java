package io.rodyamirov.brucelang.staticanalysis;

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
import io.rodyamirov.brucelang.astwalkers.ASTWalker;
import io.rodyamirov.brucelang.astwalkers.DefaultASTWalker;
import io.rodyamirov.brucelang.astwalkers.Walker;
import io.rodyamirov.brucelang.util.collections.LinkedQueue;
import io.rodyamirov.brucelang.util.collections.Queue;

public class NameRegistrar {
    private NameRegistrar() {
    }

    public static void registerNames(ProgramNode programNode) {
        new Walker().withWalker(new RegistrarWalker()).walkTree(programNode);

        Namespace root = programNode.getNamespace();
        checkForShadowing(root);
    }

    private static void checkForShadowing(Namespace root) {
        Queue<Namespace> toProcess = new LinkedQueue<>();
        toProcess.enqueue(root);

        toProcess.process((namespace, enqueuer) -> {
            namespace.getChildSpaces().forEach(enqueuer);

            Namespace parent = namespace.getParent();
            if (parent != null) {
                for (String registeredName : namespace.getLocalNames()) {
                    if (parent.nameIsDefined(registeredName)) {
                        throw new RuntimeException(
                                String.format(
                                        "Name '%s.%s' is shadows a variable at a higher scope!",
                                        namespace.getFullName(), registeredName)
                        );
                    }
                }
            }
        });
    }

    // ASTWalker because we need pre- and post- hooks in some cases; many methods are empty
    private static class RegistrarWalker implements ASTWalker {
        private Namespace currentContext;

        private void useContext(ASTNode node) {
            node.setNamespace(currentContext);
        }

        @Override
        public void programWalk(WalkFunctions<ProgramNode> walkFunctions) {
            walkFunctions.preWalker(programNode -> {
                this.currentContext = new Namespace("global");
                useContext(programNode);
            });
        }

        @Override
        public void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions) {
            walkFunctions.preWalker(functionExprNode -> {
                useContext(functionExprNode);
                this.currentContext = currentContext.makeFunctionChild(functionExprNode);
            });

            walkFunctions.postWalker(functionExprNode -> {
                this.currentContext = currentContext.getParent();
            });
        }

        @Override
        public void varDefnWalk(WalkFunctions<VariableDefinitionNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void varDeclWalk(WalkFunctions<VariableDeclarationNode> walkFunctions) {
            walkFunctions.preWalker(variableDeclarationNode -> {
                useContext(variableDeclarationNode);
                currentContext.register(variableDeclarationNode);
            });
        }

        @Override
        public void returnWalk(WalkFunctions<ReturnStatementNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void doWalk(WalkFunctions<DoStatementNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void fnCallWalk(WalkFunctions<FunctionCallNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void ifStmtWalk(WalkFunctions<IfStatementNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void binOpWalk(WalkFunctions<BinOpExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void unaryOpWalk(WalkFunctions<UnaryOpExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void fieldAccessWalk(WalkFunctions<FieldAccessNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void intExprWalk(WalkFunctions<IntExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void boolExprWalk(WalkFunctions<BoolExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void stringExprWalk(WalkFunctions<StringExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void varRefWalk(WalkFunctions<VariableReferenceNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void blockStmtWalk(WalkFunctions<BlockStatementNode> walkFunctions) {
            walkFunctions.preWalker(blockStatementNode -> {
                useContext(blockStatementNode);
                currentContext = currentContext.makeBlockChild();
            });

            walkFunctions.postWalker(blockStatementNode -> {
                currentContext = currentContext.getParent();
            });
        }
    }
}
