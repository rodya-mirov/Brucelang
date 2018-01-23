package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.DeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionDeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.astexceptions.DoubleDefinitionException;
import io.rodyamirov.brucelang.astexceptions.NameNotDefinedException;
import io.rodyamirov.brucelang.util.ProgrammerError;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Namespace {
    private final Namespace parent;
    private final String localName;

    private final Map<String, DeclarationNode> registeredNames = new HashMap<>();
    private final Map<String, Namespace> childSpaces = new HashMap<>();

    private final AtomicInteger anonCounter = new AtomicInteger(0);

    private Namespace(@Nonnull Namespace parent, @Nonnull String localName) {
        this.parent = parent;
        this.localName = localName;

        this.parent.registerChild(localName, this);
    }

    public Namespace(@Nonnull String localName) {
        this.parent = null;
        this.localName = localName;
    }

    public Namespace makeNamedChild(@Nonnull String localName) {
        return new Namespace(this, localName);
    }

    private synchronized void registerChild(String childName, Namespace child) {
        if (childSpaces.containsKey(childName)) {
            throw new ProgrammerError("Double definition of scope name '%s' -> '%s'",
                    getFullName(), childName);
        }

        childSpaces.put(childName, child);
    }

    /**
     * Make a new child scope, with an anonymous name of the form $n where n is some integer.
     */
    public synchronized Namespace makeBlockChild() {
        String localName = Integer.toString(anonCounter.getAndIncrement());

        while (childSpaces.containsKey(localName)) {
            localName = Integer.toString(anonCounter.getAndIncrement());
        }

        return makeNamedChild("$" + localName);
    }

    @Nonnull
    public Namespace getChild(String childName) {
        Namespace child = childSpaces.get(childName);
        if (child == null) {
            throw new NullPointerException("Child not defined!");
        }

        return child;
    }

    public String getLocalName() {
        return localName;
    }

    public String getFullName() {
        Namespace parent = getParent();
        if (parent == null) {
            return this.localName;
        } else {
            return parent.getFullName() + "." + this.localName;
        }
    }

    public void register(String name, DeclarationNode definitionNode) {
        if (registeredNames.containsKey(name)) {
            throw new DoubleDefinitionException(definitionNode, "Name '%s' is already in use in '%s'",
                    name, this.getFullName());
        }

        registeredNames.put(name, definitionNode);
    }

    @Nullable
    private static DeclarationNode findDeclaration(Namespace namespace, String varName) {
        do {
            DeclarationNode declaration = namespace.registeredNames.get(varName);
            if (declaration != null) {
                return declaration;
            } else {
                namespace = namespace.parent;
            }
        } while (namespace != null);

        return null;
    }

    @Nonnull // TODO: either unify functions and variables or give a better exception here
    public VariableDeclarationNode getVariableDeclaration(String varName) {
        DeclarationNode declaration = findDeclaration(this, varName);

        if (declaration == null) {
            throw new NameNotDefinedException(this, varName);
        } else {
            return (VariableDeclarationNode) declaration;
        }
    }

    @Nonnull // TODO: either unify functions and variables or give a better exception here
    public FunctionDeclarationNode getFunctionDeclaration(String functionName) {
        DeclarationNode declaration = findDeclaration(this, functionName);

        if (declaration == null) {
            throw new NameNotDefinedException(this, functionName);
        } else {
            return (FunctionDeclarationNode) declaration;
        }
    }

    @Nullable
    public Namespace getParent() {
        return parent;
    }
}
