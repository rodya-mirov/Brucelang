package io.rodyamirov.brucelang.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FunctionExprNode extends ExpressionNode implements StatementListHolder {
    private static final AtomicInteger canonicalIds = new AtomicInteger(0);
    private final int myId = canonicalIds.getAndIncrement();

    private final String selfName;
    private final List<VariableDeclarationNode> parameterNodes;
    private final List<StatementNode> definitionStatements;

    private FunctionExprNode(List<VariableDeclarationNode> parameterNodes, List<StatementNode> definitionStatements) {
        this.selfName = "$lambda$" + myId;
        this.definitionStatements = new ArrayList<>(definitionStatements);
        this.parameterNodes = new ArrayList<>(parameterNodes);
    }

    private FunctionExprNode(String localName, List<VariableDeclarationNode> parameterNodes, List<StatementNode> definitionStatements) {
        this.selfName = localName;
        this.definitionStatements = new ArrayList<>(definitionStatements);
        this.parameterNodes = new ArrayList<>(parameterNodes);
    }

    public static FunctionExprNode makeNamedFunction(String localName,
            List<VariableDeclarationNode> parameterNodes, List<StatementNode> definitionStatements) {

        return new FunctionExprNode(localName, parameterNodes, definitionStatements);
    }

    public static FunctionExprNode makeAnonymousFunction(
            List<VariableDeclarationNode> parameterNodes, List<StatementNode> definitionStatements) {

        return new FunctionExprNode(parameterNodes, definitionStatements);
    }

    public String getSelfName() {
        return selfName;
    }

    public List<VariableDeclarationNode> getParameterNodes() {
        return parameterNodes;
    }

    public List<StatementNode> getDefinitionStatements() {
        return definitionStatements;
    }

    @Override
    public void insertStatementNode(int index, StatementNode statementNode) {
        this.definitionStatements.add(index, statementNode);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFunctionExpr(this);
    }

    public String getCanonicalName() {
        return getNamespace().getFullName() + "." + this.selfName;
    }
}
