package io.rodyamirov.brucelang.ast;

import static io.rodyamirov.brucelang.types.UnknownType.UNKNOWN_TYPE;

public final class VariableDeclarationNode extends TypedNode {
    private final String varName;

    public VariableDeclarationNode(String varName) {
        super(UNKNOWN_TYPE);

        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitVariableDeclaration(this);
    }

    public String getCanonicalName() {
        return getNamespace().getFullName() + "." + getVarName();
    }
}
