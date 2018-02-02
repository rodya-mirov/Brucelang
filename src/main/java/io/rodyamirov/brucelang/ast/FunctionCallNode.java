package io.rodyamirov.brucelang.ast;

import java.util.ArrayList;
import java.util.List;

public final class FunctionCallNode extends ExpressionNode {
    private ExpressionNode functionNode;
    private final List<ExpressionNode> arguments;

    public FunctionCallNode(ExpressionNode functionNode, List<ExpressionNode> arguments) {
        this.functionNode = functionNode;
        this.arguments = new ArrayList<>(arguments);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFunctionCallNode(this);
    }

    public ExpressionNode getFunctionNode() {
        return functionNode;
    }

    public void setFunctionNode(ExpressionNode functionNode) {
        this.functionNode = functionNode;
    }

    public List<ExpressionNode> getArguments() {
        return arguments;
    }
}
