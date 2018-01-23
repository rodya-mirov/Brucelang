package io.rodyamirov.brucelang.ast;

import com.google.common.collect.ImmutableList;
import io.rodyamirov.brucelang.types.FunctionType;

import java.util.List;

public final class FunctionDeclarationNode extends DeclarationNode<FunctionDefinitionNode> {

    private final String functionName;
    private final ImmutableList<ParameterNode> parameters;

    public FunctionDeclarationNode(String functionName, List<ParameterNode> parameters) {
        super(new FunctionType(parameters.size()));

        this.functionName = functionName;
        this.parameters = ImmutableList.copyOf(parameters);

        parameters.forEach(par -> par.setParent(this));
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitFunctionDeclaration(this);
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getCanonicalName() {
        return getNamespace().getFullName() + "." + functionName;
    }

    public ImmutableList<ParameterNode> getParameters() {
        return parameters;
    }

    public FunctionDefinitionNode getDefinition() {
        return this.getParent();
    }
}
