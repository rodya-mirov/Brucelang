package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.astexceptions.WrongOrderException;

import javax.annotation.Nonnull;
import java.util.List;

public final class BlockStatementNode extends StatementNode {
    private final List<StatementNode> statements;

    private String localName;

    public BlockStatementNode(List<StatementNode> statements) {
        this.statements = statements;
        this.localName = null; // to be named later
    }

    @Nonnull
    public String getLocalName() {
        if (localName == null) {
            throw new WrongOrderException(this, "Name not yet defined for this block!");
        }
        return localName;
    }

    public void setLocalName(@Nonnull String localName) {
        this.localName = localName;
    }

    public List<StatementNode> getStatements() {
        return statements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitBlockStatement(this);
    }

    @Override
    public List<StatementNode> getChildren() {
        return statements;
    }
}
