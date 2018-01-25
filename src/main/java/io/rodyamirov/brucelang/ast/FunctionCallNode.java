package io.rodyamirov.brucelang.ast;

import com.google.common.collect.ImmutableList;

import java.util.List;

public final class FunctionCallNode extends ExpressionNode {
    private final ExpressionNode functionNode;
    private final ImmutableList<ExpressionNode> arguments;

    public FunctionCallNode(ExpressionNode functionNode, List<ExpressionNode> arguments) {
        this.functionNode = functionNode;
        this.arguments = ImmutableList.copyOf(arguments);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFunctionCallNode(this);
    }

    public ExpressionNode getFunctionNode() {
        return functionNode;
    }

    public ImmutableList<ExpressionNode> getArguments() {
        return arguments;
    }
}
