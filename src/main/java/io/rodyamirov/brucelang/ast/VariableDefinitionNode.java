package io.rodyamirov.brucelang.ast;

import java.util.ArrayList;
import java.util.List;

public final class VariableDefinitionNode extends StatementNode {
    private VariableDeclarationNode variableDeclarationNode;
    private ExpressionNode evalExpr;

    public VariableDefinitionNode(VariableDeclarationNode varDecl, ExpressionNode evalExpr) {
        this.variableDeclarationNode = varDecl;
        this.evalExpr = evalExpr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitVariableDefinition(this);
    }

    public VariableDeclarationNode getVariableDeclarationNode() {
        return variableDeclarationNode;
    }

    public void setVariableDeclarationNode(
            VariableDeclarationNode variableDeclarationNode) {
        this.variableDeclarationNode = variableDeclarationNode;
    }

    public ExpressionNode getEvalExpr() {
        return evalExpr;
    }

    public void setEvalExpr(ExpressionNode evalExpr) {
        this.evalExpr = evalExpr;
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> out = new ArrayList<>(2);

        out.add(variableDeclarationNode);
        out.add(evalExpr);

        return out;
    }
}
