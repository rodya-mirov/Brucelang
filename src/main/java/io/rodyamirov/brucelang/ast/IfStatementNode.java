package io.rodyamirov.brucelang.ast;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class IfStatementNode extends StatementNode {
    private final List<ExpressionNode> conditions;
    private final List<BlockStatementNode> resultingStatements;

    @Nullable
    private BlockStatementNode elseStatement;

    public IfStatementNode(List<? extends ExpressionNode> conditions,
            List<? extends BlockStatementNode> resultStatements,
            @Nullable BlockStatementNode elseStatement) {

        this.conditions = new ArrayList<>(conditions);
        this.resultingStatements = new ArrayList<>(resultStatements);
        this.elseStatement = elseStatement;
    }

    public List<ExpressionNode> getConditions() {
        return conditions;
    }

    public List<BlockStatementNode> getResultingStatements() {
        return resultingStatements;
    }

    @Nullable
    public BlockStatementNode getElseStatement() {
        return elseStatement;
    }

    public void setElseStatement(@Nullable BlockStatementNode elseStatement) {
        this.elseStatement = elseStatement;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitIfStatement(this);
    }
}
