package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.astexceptions.DoubleDefinitionException;
import io.rodyamirov.brucelang.astexceptions.NameNotDefinedException;
import io.rodyamirov.brucelang.util.ProgrammerError;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Namespace {
    private final Namespace parent;
    private final String localName;
    private final int depth; // 0 for root, parent.depth+1 otherwise

    private final Map<String, VariableDeclarationNode> registeredNames = new HashMap<>();
    private final Map<String, Namespace> childSpaces = new HashMap<>();

    private final AtomicInteger anonCounter = new AtomicInteger(0);

    private Namespace(@Nonnull Namespace parent, @Nonnull String localName) {
        this.parent = parent;
        this.localName = localName;
        this.depth = parent.depth + 1;

        this.parent.registerChild(localName, this);
    }

    public Namespace(@Nonnull String localName) {
        this.parent = null;
        this.localName = localName;
        this.depth = 0;
    }

    private Namespace makeNamedChild(@Nonnull String localName) {
        return new Namespace(this, localName);
    }

    private synchronized void registerChild(String childName, Namespace child) {
        if (childSpaces.containsKey(childName)) {
            throw new ProgrammerError("Double definition of scope name '%s' -> '%s'",
                    getFullName(), childName);
        }

        childSpaces.put(childName, child);
    }

    public int getDepth() {
        return depth;
    }

    /**
     * Make a new child scope, with an anonymous name of the form $n where n is some integer.
     */
    public synchronized Namespace makeBlockChild() {
        String localName = Integer.toString(anonCounter.getAndIncrement());

        while (childSpaces.containsKey(localName)) {
            localName = Integer.toString(anonCounter.getAndIncrement());
        }

        return makeNamedChild("$block$" + localName);
    }

    public synchronized Namespace makeFunctionChild(FunctionExprNode functionExprNode) {
        String localName = functionExprNode.getDefinedName().getVarName();

        return makeNamedChild(localName);
    }

    public String getFullName() {
        Namespace parent = getParent();
        if (parent == null) {
            return this.localName;
        } else {
            return parent.getFullName() + "." + this.localName;
        }
    }

    public void register(String name, VariableDeclarationNode definitionNode) {
        if (registeredNames.containsKey(name)) {
            throw new DoubleDefinitionException(
                    definitionNode,
                    "Name '%s' is already in use in '%s'",
                    name, this.getFullName()
            );
        }

        registeredNames.put(name, definitionNode);
    }

    @Nonnull
    public VariableDeclarationNode getVariableDeclaration(String varName) {
        Namespace toSearch = this;
        while (toSearch != null) {
            VariableDeclarationNode declarationNode = toSearch.registeredNames.get(varName);
            if (declarationNode != null) {
                return declarationNode;
            } else {
                toSearch = toSearch.parent;
            }
        }

        throw new NameNotDefinedException(this, varName);
    }

    @Nullable
    public Namespace getParent() {
        return parent;
    }
}
