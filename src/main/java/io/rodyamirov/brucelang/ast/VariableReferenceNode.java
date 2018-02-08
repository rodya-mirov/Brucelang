package io.rodyamirov.brucelang.ast;

public final class VariableReferenceNode extends ExpressionNode {
    private final String varName;

    public VariableReferenceNode(String varName) {
        super();
        this.varName = varName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitVariableReferenceNode(this);
    }

    public String getVarName() {
        return varName;
    }

    public VariableDeclarationNode getDefinition() {
        return getNamespace().getVariableDeclaration(varName);
    }

    public String getCanonicalName() {
        return getDefinition().getNamespace().getFullName() + "." + varName;
    }
}
