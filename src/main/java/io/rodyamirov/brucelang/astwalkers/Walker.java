package io.rodyamirov.brucelang.astwalkers;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FieldDeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.FunctionTypeReferenceNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.NativeVarDefNode;
import io.rodyamirov.brucelang.ast.ParametrizedTypeReferenceNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.SimpleTypeReferenceNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeDefinitionNode;
import io.rodyamirov.brucelang.ast.TypeFieldsNode;
import io.rodyamirov.brucelang.ast.TypeFuncCallNode;
import io.rodyamirov.brucelang.ast.TypeFuncExprNode;
import io.rodyamirov.brucelang.ast.TypeFuncTypeRefNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astwalkers.ASTWalker.WalkFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class Walker {
    private final List<ASTNode.ASTVisitor> preWalkers = new ArrayList<>();
    private final List<ASTNode.ASTVisitor> postWalkers = new ArrayList<>();

    private final WalkerVisitor walkerVisitor = new WalkerVisitor();

    public Walker() {
    }

    public void walkTree(ASTNode node) {
        node.accept(walkerVisitor);
    }

    public Walker withWalker(ASTWalker walker) {
        preWalkers.add(new PreWalkerVisitor(walker));
        postWalkers.add(new PostWalkerVisitor(walker));

        return this;
    }

    // it's a visitor that does the traversal in an organized way, and invokes its owned visitors
    // at the appropriate times
    private class WalkerVisitor implements ASTNode.ASTVisitor {
        private void visit(ASTNode astNode) {
            for (ASTNode.ASTVisitor preWalker : preWalkers) {
                astNode.accept(preWalker);
            }

            for (ASTNode child : astNode.getChildren()) {
                if (child != null) {
                    child.accept(this);
                }
            }

            for (ASTNode.ASTVisitor postWalker : postWalkers) {
                astNode.accept(postWalker);
            }
        }

        @Override
        public void visitProgram(ProgramNode programNode) {
            visit(programNode);
        }

        @Override
        public void visitTypeFuncExpr(TypeFuncExprNode typeFuncExpr) {
            visit(typeFuncExpr);
        }

        @Override
        public void visitTypeFuncTypeRef(TypeFuncTypeRefNode typeFuncTypeRef) {
            visit(typeFuncTypeRef);
        }

        @Override
        public void visitTypeFuncCall(TypeFuncCallNode typeFuncCall) {
            visit(typeFuncCall);
        }

        @Override
        public void visitNativeVarDef(NativeVarDefNode nativeVarDefNode) {
            visit(nativeVarDefNode);
        }

        @Override
        public void visitTypeDefinition(TypeDefinitionNode typeDefinition) {
            visit(typeDefinition);
        }

        @Override
        public void visitTypeFields(TypeFieldsNode typeFieldsNode) {
            visit(typeFieldsNode);
        }

        @Override
        public void visitFieldDeclaration(FieldDeclarationNode fieldDeclaration) {
            visit(fieldDeclaration);
        }

        @Override
        public void visitTypeDeclaration(TypeDeclarationNode typeDeclarationNode) {
            visit(typeDeclarationNode);
        }

        @Override
        public void visitSimpleTypeReference(SimpleTypeReferenceNode simpleTypeReferenceNode) {
            visit(simpleTypeReferenceNode);
        }

        @Override
        public void visitParametrizedTypeReference(ParametrizedTypeReferenceNode parametrizedTypeReferenceNode) {
            visit(parametrizedTypeReferenceNode);
        }

        @Override
        public void visitFunctionTypeReference(FunctionTypeReferenceNode functionTypeReferenceNode) {
            visit(functionTypeReferenceNode);
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            visit(functionDefinitionNode);
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            visit(variableDefinitionNode);
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            visit(variableDeclarationNode);
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            visit(blockStatementNode);
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            visit(doStatementNode);
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            visit(returnStatementNode);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            visit(ifStatementNode);
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            visit(functionCallNode);
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            visit(fieldAccessNode);
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            visit(integerNode);
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            visit(booleanNode);
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            visit(stringExprNode);
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            visit(variableReferenceNode);
        }
    }

    private static class PreWalkerVisitor extends InferredWalker implements ASTNode.ASTVisitor {
        public PreWalkerVisitor(ASTWalker walker) {
            super(walker);
        }

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNodeWalkFunctions.getPreWalker().accept(programNode);
        }

        @Override
        public void visitTypeFuncExpr(TypeFuncExprNode typeFuncExpr) {
            typeFuncExprNodeWalkFunctions.getPreWalker().accept(typeFuncExpr);
        }

        @Override
        public void visitTypeFuncTypeRef(TypeFuncTypeRefNode typeFuncTypeRef) {
            typeFuncTypeRefNodeWalkFunctions.getPreWalker().accept(typeFuncTypeRef);
        }

        @Override
        public void visitTypeFuncCall(TypeFuncCallNode typeFuncCall) {
            typeFuncCallNodeWalkFunctions.getPreWalker().accept(typeFuncCall);
        }

        @Override
        public void visitNativeVarDef(NativeVarDefNode nativeVarDefNode) {
            nativeVarDefNodeWalkFunctions.getPreWalker().accept(nativeVarDefNode);
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionExprNode) {
            functionExprNodeWalkFunctions.getPreWalker().accept(functionExprNode);
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            variableDefinitionNodeWalkFunctions.getPreWalker().accept(variableDefinitionNode);
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            variableDeclarationNodeWalkFunctions.getPreWalker().accept(variableDeclarationNode);
        }

        @Override
        public void visitTypeDefinition(TypeDefinitionNode typeDefinition) {
            typeDefinitionNodeWalkFunctions.getPreWalker().accept(typeDefinition);
        }

        @Override
        public void visitTypeFields(TypeFieldsNode typeFieldsNode) {
            typeFieldsNodeWalkFunctions.getPreWalker().accept(typeFieldsNode);
        }

        @Override
        public void visitFieldDeclaration(FieldDeclarationNode fieldDeclaration) {
            fieldDeclarationNodeWalkFunctions.getPreWalker().accept(fieldDeclaration);
        }

        @Override
        public void visitTypeDeclaration(TypeDeclarationNode typeDeclarationNode) {
            typeDeclarationNodeWalkFunctions.getPreWalker().accept(typeDeclarationNode);
        }

        @Override
        public void visitSimpleTypeReference(SimpleTypeReferenceNode simpleTypeReferenceNode) {
            simpleTypeReferenceNodeWalkFunctions.getPreWalker().accept(simpleTypeReferenceNode);
        }

        @Override
        public void visitParametrizedTypeReference(ParametrizedTypeReferenceNode parametrizedTypeReferenceNode) {
            parametrizedTypeReferenceNodeWalkFunctions.getPreWalker().accept(parametrizedTypeReferenceNode);
        }

        @Override
        public void visitFunctionTypeReference(FunctionTypeReferenceNode functionTypeReferenceNode) {
            functionTypeReferenceNodeWalkFunctions.getPreWalker().accept(functionTypeReferenceNode);
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            blockStatementNodeWalkFunctions.getPreWalker().accept(blockStatementNode);
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            doStatementNodeWalkFunctions.getPreWalker().accept(doStatementNode);
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            returnStatementNodeWalkFunctions.getPreWalker().accept(returnStatementNode);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            ifStatementNodeWalkFunctions.getPreWalker().accept(ifStatementNode);
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            functionCallNodeWalkFunctions.getPreWalker().accept(functionCallNode);
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            fieldAccessNodeWalkFunctions.getPreWalker().accept(fieldAccessNode);
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            intExprNodeWalkFunctions.getPreWalker().accept(integerNode);
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            boolExprNodeWalkFunctions.getPreWalker().accept(booleanNode);
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            stringExprNodeWalkFunctions.getPreWalker().accept(stringExprNode);
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            variableReferenceNodeWalkFunctions.getPreWalker().accept(variableReferenceNode);
        }
    }

    private static class PostWalkerVisitor extends InferredWalker implements ASTNode.ASTVisitor {
        public PostWalkerVisitor(ASTWalker walker) {
            super(walker);
        }

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNodeWalkFunctions.getPostWalker().accept(programNode);
        }

        @Override
        public void visitTypeFuncExpr(TypeFuncExprNode typeFuncExpr) {
            typeFuncExprNodeWalkFunctions.getPostWalker().accept(typeFuncExpr);
        }

        @Override
        public void visitTypeFuncTypeRef(TypeFuncTypeRefNode typeFuncTypeRef) {
            typeFuncTypeRefNodeWalkFunctions.getPostWalker().accept(typeFuncTypeRef);
        }

        @Override
        public void visitTypeFuncCall(TypeFuncCallNode typeFuncCall) {
            typeFuncCallNodeWalkFunctions.getPostWalker().accept(typeFuncCall);
        }

        @Override
        public void visitNativeVarDef(NativeVarDefNode nativeVarDefNode) {
            nativeVarDefNodeWalkFunctions.getPostWalker().accept(nativeVarDefNode);
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionExprNode) {
            functionExprNodeWalkFunctions.getPostWalker().accept(functionExprNode);
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            variableDefinitionNodeWalkFunctions.getPostWalker().accept(variableDefinitionNode);
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            variableDeclarationNodeWalkFunctions.getPostWalker().accept(variableDeclarationNode);
        }

        @Override
        public void visitTypeDefinition(TypeDefinitionNode typeDefinition) {
            typeDefinitionNodeWalkFunctions.getPostWalker().accept(typeDefinition);
        }

        @Override
        public void visitTypeFields(TypeFieldsNode typeFieldsNode) {
            typeFieldsNodeWalkFunctions.getPostWalker().accept(typeFieldsNode);
        }

        @Override
        public void visitFieldDeclaration(FieldDeclarationNode fieldDeclaration) {
            fieldDeclarationNodeWalkFunctions.getPostWalker().accept(fieldDeclaration);
        }

        @Override
        public void visitTypeDeclaration(TypeDeclarationNode typeDeclarationNode) {
            typeDeclarationNodeWalkFunctions.getPostWalker().accept(typeDeclarationNode);
        }

        @Override
        public void visitSimpleTypeReference(SimpleTypeReferenceNode simpleTypeReferenceNode) {
            simpleTypeReferenceNodeWalkFunctions.getPostWalker().accept(simpleTypeReferenceNode);
        }

        @Override
        public void visitParametrizedTypeReference(ParametrizedTypeReferenceNode parametrizedTypeReferenceNode) {
            parametrizedTypeReferenceNodeWalkFunctions.getPostWalker().accept(parametrizedTypeReferenceNode);
        }

        @Override
        public void visitFunctionTypeReference(FunctionTypeReferenceNode functionTypeReferenceNode) {
            functionTypeReferenceNodeWalkFunctions.getPostWalker().accept(functionTypeReferenceNode);
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            blockStatementNodeWalkFunctions.getPostWalker().accept(blockStatementNode);
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            doStatementNodeWalkFunctions.getPostWalker().accept(doStatementNode);
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            returnStatementNodeWalkFunctions.getPostWalker().accept(returnStatementNode);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            ifStatementNodeWalkFunctions.getPostWalker().accept(ifStatementNode);
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            functionCallNodeWalkFunctions.getPostWalker().accept(functionCallNode);
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            fieldAccessNodeWalkFunctions.getPostWalker().accept(fieldAccessNode);
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            intExprNodeWalkFunctions.getPostWalker().accept(integerNode);
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            boolExprNodeWalkFunctions.getPostWalker().accept(booleanNode);
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            stringExprNodeWalkFunctions.getPostWalker().accept(stringExprNode);
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            variableReferenceNodeWalkFunctions.getPostWalker().accept(variableReferenceNode);
        }
    }

    private static class InferredWalker {
        final WalkFunctions<ProgramNode> programNodeWalkFunctions;
        final WalkFunctions<TypeFuncExprNode> typeFuncExprNodeWalkFunctions;
        final WalkFunctions<TypeFuncTypeRefNode> typeFuncTypeRefNodeWalkFunctions;
        final WalkFunctions<TypeFuncCallNode> typeFuncCallNodeWalkFunctions;
        final WalkFunctions<NativeVarDefNode> nativeVarDefNodeWalkFunctions;
        final WalkFunctions<TypeDefinitionNode> typeDefinitionNodeWalkFunctions;
        final WalkFunctions<TypeFieldsNode> typeFieldsNodeWalkFunctions;
        final WalkFunctions<FieldDeclarationNode> fieldDeclarationNodeWalkFunctions;
        final WalkFunctions<TypeDeclarationNode> typeDeclarationNodeWalkFunctions;
        final WalkFunctions<SimpleTypeReferenceNode> simpleTypeReferenceNodeWalkFunctions;
        final WalkFunctions<ParametrizedTypeReferenceNode> parametrizedTypeReferenceNodeWalkFunctions;
        final WalkFunctions<FunctionTypeReferenceNode> functionTypeReferenceNodeWalkFunctions;
        final WalkFunctions<FunctionExprNode> functionExprNodeWalkFunctions;
        final WalkFunctions<VariableDefinitionNode> variableDefinitionNodeWalkFunctions;
        final WalkFunctions<VariableDeclarationNode> variableDeclarationNodeWalkFunctions;
        final WalkFunctions<ReturnStatementNode> returnStatementNodeWalkFunctions;
        final WalkFunctions<FunctionCallNode> functionCallNodeWalkFunctions;
        final WalkFunctions<DoStatementNode> doStatementNodeWalkFunctions;
        final WalkFunctions<IfStatementNode> ifStatementNodeWalkFunctions;
        final WalkFunctions<FieldAccessNode> fieldAccessNodeWalkFunctions;
        final WalkFunctions<IntExprNode> intExprNodeWalkFunctions;
        final WalkFunctions<BoolExprNode> boolExprNodeWalkFunctions;
        final WalkFunctions<StringExprNode> stringExprNodeWalkFunctions;
        final WalkFunctions<VariableReferenceNode> variableReferenceNodeWalkFunctions;
        final WalkFunctions<BlockStatementNode> blockStatementNodeWalkFunctions;

        public InferredWalker(ASTWalker astWalker) {
            this.programNodeWalkFunctions = getWalker(astWalker::programWalk);
            this.typeFuncExprNodeWalkFunctions = getWalker(astWalker::typeFuncWalk);
            this.typeFuncTypeRefNodeWalkFunctions = getWalker(astWalker::typeFuncRefWalk);
            this.typeFuncCallNodeWalkFunctions = getWalker(astWalker::typeFuncCallWalk);
            this.nativeVarDefNodeWalkFunctions = getWalker(astWalker::nativeVarDefWalk);
            this.typeDefinitionNodeWalkFunctions = getWalker(astWalker::typeDefnWalk);
            this.typeFieldsNodeWalkFunctions = getWalker(astWalker::typeFieldsWalk);
            this.fieldDeclarationNodeWalkFunctions = getWalker(astWalker::fieldDeclWalk);
            this.typeDeclarationNodeWalkFunctions = getWalker(astWalker::typeDeclWalk);
            this.simpleTypeReferenceNodeWalkFunctions = getWalker(astWalker::simpleTypeRefWalk);
            this.parametrizedTypeReferenceNodeWalkFunctions = getWalker(astWalker::parTypeRefWalk);
            this.functionTypeReferenceNodeWalkFunctions = getWalker(astWalker::funcTypeRefWalk);
            this.functionExprNodeWalkFunctions = getWalker(astWalker::functionExprWalk);
            this.variableDefinitionNodeWalkFunctions = getWalker(astWalker::varDefnWalk);
            this.variableDeclarationNodeWalkFunctions = getWalker(astWalker::varDeclWalk);
            this.returnStatementNodeWalkFunctions = getWalker(astWalker::returnWalk);
            this.doStatementNodeWalkFunctions = getWalker(astWalker::doWalk);
            this.functionCallNodeWalkFunctions = getWalker(astWalker::fnCallWalk);
            this.ifStatementNodeWalkFunctions = getWalker(astWalker::ifStmtWalk);
            this.fieldAccessNodeWalkFunctions = getWalker(astWalker::fieldAccessWalk);
            this.intExprNodeWalkFunctions = getWalker(astWalker::intExprWalk);
            this.boolExprNodeWalkFunctions = getWalker(astWalker::boolExprWalk);
            this.stringExprNodeWalkFunctions = getWalker(astWalker::stringExprWalk);
            this.variableReferenceNodeWalkFunctions = getWalker(astWalker::varRefWalk);
            this.blockStatementNodeWalkFunctions = getWalker(astWalker::blockStmtWalk);
        }

        private <T extends ASTNode> WalkFunctions<T> getWalker(Consumer<WalkFunctions<T>> walkModifier) {
            WalkFunctions<T> blank = new WalkFunctions<>();
            walkModifier.accept(blank);
            return blank;
        }
    }
}
