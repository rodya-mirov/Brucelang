package io.rodyamirov.brucelang.ast;

public abstract class StatementNode extends ASTNode {
    private boolean doesReturn = false;

    public boolean doesReturn() {
        return doesReturn;
    }

    public void setReturns(boolean doesReturn) {
        this.doesReturn = doesReturn;
    }
}
