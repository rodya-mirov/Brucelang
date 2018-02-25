package io.rodyamirov.brucelang.ast;

import java.util.Collections;
import java.util.List;

public class NativeVarDefNode extends StatementNode {
    private VariableDeclarationNode declarationNode;

    public NativeVarDefNode(VariableDeclarationNode variableDeclarationNode) {
        this.declarationNode = variableDeclarationNode;
    }

    public VariableDeclarationNode getDeclarationNode() {
        return declarationNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitNativeVarDef(this);
    }

    @Override
    public List<? extends ASTNode> getChildren() {
        return Collections.singletonList(declarationNode);
    }
}
