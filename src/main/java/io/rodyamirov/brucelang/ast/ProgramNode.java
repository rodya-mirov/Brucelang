package io.rodyamirov.brucelang.ast;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Top level node of the entire program.
 */
public final class ProgramNode extends ASTNode {
    private final ImmutableList<StatementNode> statements;

    public ProgramNode(@Nonnull List<StatementNode> statements) {
        this.statements = ImmutableList.copyOf(statements);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitProgram(this);
    }

    public ImmutableList<StatementNode> getStatements() {
        return statements;
    }
}
