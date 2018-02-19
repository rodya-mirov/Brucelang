package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.astexceptions.WrongOrderException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FunctionExprNode extends ExpressionNode implements StatementListHolder {
    private static final AtomicInteger canonicalIds = new AtomicInteger(0);

    private final List<VariableDeclarationNode> parameterNodes;
    private final List<StatementNode> definitionStatements;

    public FunctionExprNode(List<VariableDeclarationNode> parameterNodes, List<StatementNode> definitionStatements) {
        this.definitionStatements = new ArrayList<>(definitionStatements);
        this.parameterNodes = new ArrayList<>(parameterNodes);
    }

    public List<VariableDeclarationNode> getParameterNodes() {
        return parameterNodes;
    }

    public List<StatementNode> getDefinitionStatements() {
        return definitionStatements;
    }

    public static String makeAnonName() {
        return "$lambda$" + canonicalIds.getAndIncrement();
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
        if (!isDefExpr()) {
            throw new WrongOrderException(this, "Does not have a name to refer to!");
        }
        return getDefinedName().getCanonicalName();
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> out = new ArrayList<>(parameterNodes.size() + definitionStatements.size());

        out.addAll(parameterNodes);
        out.addAll(definitionStatements);

        return out;
    }
}
