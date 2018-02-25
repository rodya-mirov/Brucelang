package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.astexceptions.WrongOrderException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FunctionExprNode extends ExpressionNode {
    private static final AtomicInteger canonicalIds = new AtomicInteger(0);

    private final List<VariableDeclarationNode> parameterNodes;
    private final List<StatementNode> definitionStatements;

    private String anonName = null;

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

    private static String makeAnonName() {
        return "$lambda$" + canonicalIds.getAndIncrement();
    }

    public String getAnonName() {
        if (this.anonName == null) {
            this.anonName = makeAnonName();
        }

        return this.anonName;
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
    public List<ASTNode> getExtendedChildren() {
        List<ASTNode> out = new ArrayList<>(parameterNodes.size() + definitionStatements.size());

        out.addAll(parameterNodes);
        out.addAll(definitionStatements);

        return out;
    }
}
