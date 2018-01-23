package io.rodyamirov.brucelang.ast;

import static io.rodyamirov.brucelang.types.UnknownType.UNKNOWN_TYPE;

public final class VariableReferenceNode extends TypedNode<ASTNode> {
    private final String varName;

    public VariableReferenceNode(String varName) {
        super(UNKNOWN_TYPE);
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
}
