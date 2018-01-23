package io.rodyamirov.brucelang.ast;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nullable;
import java.util.List;

public final class IfStatementNode extends StatementNode {
    private final ImmutableList<ExpressionNode> conditions;
    private final ImmutableList<StatementNode> resultingStatements;

    @Nullable
    private final StatementNode elseStatement;

    public IfStatementNode(List<? extends ExpressionNode> conditions,
            List<? extends StatementNode> resultStatements,
            @Nullable StatementNode elseStatement) {

        this.conditions = ImmutableList.copyOf(conditions);
        this.resultingStatements = ImmutableList.copyOf(resultStatements);
        this.elseStatement = elseStatement;

        this.conditions.forEach(cond -> cond.setParent(this));
        this.resultingStatements.forEach(rs -> rs.setParent(this));
        if (this.elseStatement != null) {
            this.elseStatement.setParent(this);
        }
    }

    public ImmutableList<ExpressionNode> getConditions() {
        return conditions;
    }

    public ImmutableList<StatementNode> getResultingStatements() {
        return resultingStatements;
    }

    @Nullable
    public StatementNode getElseStatement() {
        return elseStatement;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitIfStatement(this);
    }
}
