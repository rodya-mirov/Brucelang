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

    private String getAnonName() {
        if (this.anonName == null) {
            this.anonName = makeAnonName();
        }

        return this.anonName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFunctionExpr(this);
    }

    public String getLocalName() {
        if (isDefExpr()) {
            return getDefinedName().getVarName();
        } else {
            return getAnonName();
        }
    }

    public String getFullName() {
        if (isDefExpr()) {
            return getDefinedName().getCanonicalName();
        } else {
            return getNamespace().getFullName() + "." + getAnonName();
        }
    }

    @Override
    public List<ASTNode> getExtendedChildren() {
        List<ASTNode> out = new ArrayList<>(parameterNodes.size() + definitionStatements.size());

        out.addAll(parameterNodes);
        out.addAll(definitionStatements);

        return out;
    }
}
