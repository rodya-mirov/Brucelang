package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FieldDeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.NativeVarDefNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeDefinitionNode;
import io.rodyamirov.brucelang.ast.TypeFieldsNode;
import io.rodyamirov.brucelang.ast.TypeReferenceNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astexceptions.AstException;
import io.rodyamirov.brucelang.astexceptions.NameNotDefinedException;
import io.rodyamirov.brucelang.astwalkers.ASTWalker;
import io.rodyamirov.brucelang.astwalkers.Walker;
import io.rodyamirov.brucelang.util.collections.LinkedQueue;
import io.rodyamirov.brucelang.util.collections.Queue;

public class NameRegistrar {
    // the name of the root namespace
    public static final String GLOBAL = "global";

    private NameRegistrar() {
    }

    public static void registerNames(ProgramNode programNode) {
        new Walker().withWalker(new RegistrarWalker()).walkTree(programNode);

        Namespace root = programNode.getNamespace();
        checkForShadowing(root);
    }

    public static class UseBeforeDefinedException extends AstException {
        public UseBeforeDefinedException(ASTNode referenceNode, String name) {
            super(referenceNode,
                    "Reference '%s' in namespace '%s' is not yet defined!",
                    name, referenceNode.getNamespace().getFullName());
        }
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
                this.currentContext = new Namespace(GLOBAL);
                useContext(programNode);
            });
        }

        @Override
        public void nativeVarDefWalk(WalkFunctions<NativeVarDefNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void typeDefnWalk(WalkFunctions<TypeDefinitionNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void typeFieldsWalk(WalkFunctions<TypeFieldsNode> walkFunctions) {
            walkFunctions.preWalker(typeFieldsNode -> {
                useContext(typeFieldsNode);
                this.currentContext = currentContext.makeTypeChild(typeFieldsNode);
            });

            walkFunctions.postWalker(typeFieldsNode -> {
                currentContext = currentContext.getParent();
            });
        }

        @Override
        public void fieldDeclWalk(WalkFunctions<FieldDeclarationNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void typeDeclWalk(WalkFunctions<TypeDeclarationNode> walkFunctions) {
            walkFunctions.preWalker(typeDeclarationNode -> {
                useContext(typeDeclarationNode);
                currentContext.register(typeDeclarationNode);
            });
        }

        @Override
        public void simpleTypeRefWalk(WalkFunctions<TypeReferenceNode.SimpleTypeReferenceNode> walkFunctions) {
            walkFunctions.preWalker(simpleTypeReferenceNode -> {
                useContext(simpleTypeReferenceNode);

                try {
                    currentContext.getTypeDeclaration(simpleTypeReferenceNode.getName());
                } catch (NameNotDefinedException nnde) {
                    throw new UseBeforeDefinedException(simpleTypeReferenceNode, simpleTypeReferenceNode.getName());
                }
            });
        }

        @Override
        public void parTypeRefWalk(WalkFunctions<TypeReferenceNode.ParametrizedTypeReferenceNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
        }

        @Override
        public void funcTypeRefWalk(WalkFunctions<TypeReferenceNode.FunctionTypeReferenceNode> walkFunctions) {
            walkFunctions.preWalker(this::useContext);
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
            walkFunctions.preWalker(variableReferenceNode -> {
                useContext(variableReferenceNode);

                try {
                    currentContext.getVariableDeclaration(variableReferenceNode.getVarName());
                } catch (NameNotDefinedException nnde) {
                    throw new UseBeforeDefinedException(variableReferenceNode, variableReferenceNode.getVarName());
                }
            });
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
