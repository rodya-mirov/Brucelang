package io.rodyamirov.brucelang.types;

import io.rodyamirov.brucelang.NotImplementedException;
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
import io.rodyamirov.brucelang.astwalkers.ASTWalker;
import io.rodyamirov.brucelang.astwalkers.Walker;

public class TypeRegistrar {
    private TypeRegistrar() {
    }

    public static void registerTypes(ProgramNode programNode) {
        new Walker().withWalker(new TypeRegistrarWalker()).walkTree(programNode);
    }

    // This is a SUPER simple walker where every node (but one) just gets the current "context" (state
    // of the type registry) as a pre-walk. The only exception is a type definition, which registers
    // the
    private static class TypeRegistrarWalker implements ASTWalker {
        private TypeRegistry typeRegistry;

        private TypeRegistrarWalker() {
            this.typeRegistry = new TypeRegistry();
        }

        private void useCurrent(ASTNode astNode) {
            astNode.setTypeRegistry(typeRegistry);
        }

        @Override
        public void programWalk(WalkFunctions<ProgramNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void nativeVarDefWalk(WalkFunctions<NativeVarDefNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void typeDefnWalk(WalkFunctions<TypeDefinitionNode> walkFunctions) {
            walkFunctions.preWalker(typeDefinitionNode -> {
                this.typeRegistry = typeRegistry.withChanges()
                        .storeValue(typeDefinitionNode.getDeclaration(), typeDefinitionNode.getFields())
                        .build();

                useCurrent(typeDefinitionNode);
            });
        }

        @Override
        public void typeFieldsWalk(WalkFunctions<TypeFieldsNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void fieldDeclWalk(WalkFunctions<FieldDeclarationNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void typeDeclWalk(WalkFunctions<TypeDeclarationNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void simpleTypeRefWalk(WalkFunctions<TypeReferenceNode.SimpleTypeReferenceNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void parTypeRefWalk(WalkFunctions<TypeReferenceNode.ParametrizedTypeReferenceNode> walkFunctions) {
            walkFunctions.preWalker(NotImplementedException.thrown());
            walkFunctions.postWalker(NotImplementedException.thrown());
        }

        @Override
        public void funcTypeRefWalk(WalkFunctions<TypeReferenceNode.FunctionTypeReferenceNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void functionExprWalk(WalkFunctions<FunctionExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void varDefnWalk(WalkFunctions<VariableDefinitionNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void varDeclWalk(WalkFunctions<VariableDeclarationNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void returnWalk(WalkFunctions<ReturnStatementNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void doWalk(WalkFunctions<DoStatementNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void fnCallWalk(WalkFunctions<FunctionCallNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void ifStmtWalk(WalkFunctions<IfStatementNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void fieldAccessWalk(WalkFunctions<FieldAccessNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void intExprWalk(WalkFunctions<IntExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void boolExprWalk(WalkFunctions<BoolExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void stringExprWalk(WalkFunctions<StringExprNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void varRefWalk(WalkFunctions<VariableReferenceNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }

        @Override
        public void blockStmtWalk(WalkFunctions<BlockStatementNode> walkFunctions) {
            walkFunctions.preWalker(this::useCurrent);
        }
    }
}
