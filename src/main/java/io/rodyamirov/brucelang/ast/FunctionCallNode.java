package io.rodyamirov.brucelang.ast;

import com.google.common.collect.ImmutableList;

import java.util.List;

public final class FunctionCallNode extends ExpressionNode {
    private final String functionId;
    private final ImmutableList<ExpressionNode> arguments;

    private FunctionDeclarationNode reference;

    public FunctionCallNode(String functionId, List<ExpressionNode> arguments) {
        this.functionId = functionId;
        this.arguments = ImmutableList.copyOf(arguments);

        this.arguments.forEach(arg -> arg.setParent(this));
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFunctionCallNode(this);
    }

    public String getFunctionId() {
        return functionId;
    }

    public ImmutableList<ExpressionNode> getArguments() {
        return arguments;
    }

    public FunctionDeclarationNode getReference() {
        return getNamespace().getFunctionDeclaration(functionId);
    }
}
