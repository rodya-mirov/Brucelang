package io.rodyamirov.brucelang.ast;

import static io.rodyamirov.brucelang.types.UnknownType.UNKNOWN_TYPE;

/**
 * AST Node for the named parameter of a function
 */
public final class ParameterNode extends DeclarationNode<FunctionDeclarationNode> {
    private final String parameterName;

    public ParameterNode(String parameterName) {
        super(UNKNOWN_TYPE);

        this.parameterName = parameterName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitParameterNode(this);
    }

    public String getParameterName() {
        return parameterName;
    }
}
