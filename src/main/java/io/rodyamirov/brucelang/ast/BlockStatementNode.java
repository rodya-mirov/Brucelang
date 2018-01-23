package io.rodyamirov.brucelang.ast;

import com.google.common.collect.ImmutableList;

import java.util.List;

public final class BlockStatementNode extends StatementNode {
    private final ImmutableList<StatementNode> statements;

    public BlockStatementNode(List<StatementNode> statements) {
        this.statements = ImmutableList.copyOf(statements);

        this.statements.forEach(sn -> sn.setParent(this));
    }

    public ImmutableList<StatementNode> getStatements() {
        return statements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitBlockStatement(this);
    }
}
