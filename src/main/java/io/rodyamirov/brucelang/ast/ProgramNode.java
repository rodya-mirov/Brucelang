package io.rodyamirov.brucelang.ast;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Top level node of the entire program.
 */
public final class ProgramNode extends ASTNode implements StatementListHolder {
    private final List<StatementNode> statements;

    public ProgramNode(@Nonnull List<StatementNode> statements) {
        this.statements = statements;
    }

    @Override
    public void insertStatementNode(int index, StatementNode statementNode) {
        statements.add(index, statementNode);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitProgram(this);
    }

    public List<StatementNode> getStatements() {
        return statements;
    }
}
