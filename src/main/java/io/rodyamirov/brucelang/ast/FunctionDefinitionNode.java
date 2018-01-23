package io.rodyamirov.brucelang.ast;

import java.util.List;

public final class FunctionDefinitionNode extends StatementNode {
    private final FunctionDeclarationNode functionDeclarationNode;
    private final StatementNode definitionStatement;

    public FunctionDefinitionNode(String functionName, List<ParameterNode> parameterNodes, StatementNode definitionStatement) {
        this.functionDeclarationNode = new FunctionDeclarationNode(functionName, parameterNodes);
        this.definitionStatement = definitionStatement;

        this.functionDeclarationNode.setParent(this);
        this.definitionStatement.setParent(this);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFunctionDefinition(this);
    }

    public FunctionDeclarationNode getFunctionDeclarationNode() {
        return functionDeclarationNode;
    }

    public StatementNode getDefinitionStatement() {
        return definitionStatement;
    }
}
