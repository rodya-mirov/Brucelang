package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.astexceptions.WrongOrderException;
import io.rodyamirov.brucelang.staticanalysis.Namespace;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class ASTNode {
    private Namespace namespace;

    protected ASTNode() {
    }

    public abstract void accept(ASTVisitor visitor);

    public abstract List<? extends ASTNode> getChildren();

    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    @Nonnull
    public Namespace getNamespace() {
        if (namespace == null) {
            throw new WrongOrderException(this, "Namespace accessed before assignment!");
        }

        return namespace;
    }

    public interface ASTVisitor {
        void visitProgram(ProgramNode programNode);

        void visitFunctionExpr(FunctionExprNode functionExprNode);
        void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode);

        void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode);

        void visitTypeDeclaration(TypeDeclarationNode typeDeclarationNode);
        void visitTypeDefinition(TypeDefinitionNode typeDefinition);
        void visitTypeFields(TypeFieldsNode typeFieldsNode);
        void visitFieldDeclaration(FieldDeclarationNode fieldDeclaration);

        void visitSimpleTypeReference(TypeReferenceNode.SimpleTypeReferenceNode simpleTypeReferenceNode);
        void visitParametrizedTypeReference(TypeReferenceNode.ParametrizedTypeReferenceNode parametrizedTypeReferenceNode);
        void visitFunctionTypeReference(TypeReferenceNode.FunctionTypeReferenceNode functionTypeReferenceNode);

        void visitNativeVarDef(NativeVarDefNode nativeVarDefNode);

        void visitBlockStatement(BlockStatementNode blockStatementNode);
        void visitDoStatement(DoStatementNode doStatementNode);
        void visitReturnStatement(ReturnStatementNode returnStatementNode);
        void visitIfStatement(IfStatementNode ifStatementNode);

        void visitFunctionCallNode(FunctionCallNode functionCallNode);

        void visitFieldAccess(FieldAccessNode fieldAccessNode);

        void visitIntExprNode(IntExprNode integerNode);
        void visitBoolExprNode(BoolExprNode booleanNode);
        void visitStringExprNode(StringExprNode stringExprNode);
        void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode);
    }
}
