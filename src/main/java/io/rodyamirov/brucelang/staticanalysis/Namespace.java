package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeFieldsNode;
import io.rodyamirov.brucelang.ast.TypeFuncExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.astexceptions.DoubleDefinitionException;
import io.rodyamirov.brucelang.astexceptions.NameNotDefinedException;
import io.rodyamirov.brucelang.util.ProgrammerError;
import io.rodyamirov.brucelang.util.functional.Maybe;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Namespace {
    private final Namespace parent;
    private final String localName;
    private final int depth; // 0 for root, parent.depth+1 otherwise

    private final Set<String> localNames = new HashSet<>();
    private final Map<String, VariableDeclarationNode> registeredVariables = new HashMap<>();
    private final Map<String, TypeDeclarationNode> registeredTypes = new HashMap<>();
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

    private void registerChild(String childName, Namespace child) {
        if (childSpaces.containsKey(childName)) {
            throw new ProgrammerError("Double definition of scope name '%s' -> '%s'",
                    getFullName(), childName);
        }

        childSpaces.put(childName, child);
    }

    public int getDepth() {
        return depth;
    }

    public Collection<Namespace> getChildSpaces() {
        return childSpaces.values();
    }

    /**
     * Make a new child scope, with an anonymous name of the form $n where n is some integer.
     */
    public Namespace makeBlockChild() {
        String localName = Integer.toString(anonCounter.getAndIncrement());

        while (childSpaces.containsKey(localName)) {
            localName = Integer.toString(anonCounter.getAndIncrement());
        }

        return makeNamedChild("$block$" + localName);
    }

    public Namespace makeFunctionChild(FunctionExprNode functionExprNode) {
        return makeNamedChild(functionExprNode.getLocalName());
    }

    public Namespace makeTypeFunctionChild(TypeFuncExprNode typeFuncExprNode) {
        return makeNamedChild(typeFuncExprNode.getLocalName());
    }

    public Namespace makeTypeChild(TypeFieldsNode typeFieldsNode) {
        String localName = typeFieldsNode.getName();

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

    public Collection<String> getLocalNames() {
        return localNames;
    }

    public boolean nameIsDefined(String name) {
        Predicate<Namespace> nameLocallyDefined = namespace ->
            namespace.localNames.contains(name);

        Namespace namespace = this;

        while (namespace != null) {
            if (nameLocallyDefined.test(namespace)) {
                return true;
            }
            namespace = namespace.parent;
        }

        return false;
    }

    /**
     * Register the given node.
     *
     * Note that this does not check for shadowing, although it will blow up if the same name is
     * registered twice in the same namespace.
     *
     * @param declarationNode VariableDeclarationNode to be registered
     */
    public void register(VariableDeclarationNode declarationNode) {
        String name = declarationNode.getVarName();

        if (localNames.contains(name)) {
            throw new DoubleDefinitionException(
                    declarationNode,
                    "Name '%s' in '%s' is already in use!",
                    name, this.getFullName()
            );
        }

        localNames.add(name);
        registeredVariables.put(name, declarationNode);
    }

    /**
     * Register the given node.
     *
     * Note that this does not check for shadowing, although it will blow up if the same name is
     * registered twice in the same namespace.
     *
     * @param declarationNode VariableDeclarationNode to be registered
     */
    public void register(TypeDeclarationNode declarationNode) {
        String name = declarationNode.getName();

        if (localNames.contains(name)) {
            throw new DoubleDefinitionException(
                    declarationNode,
                    "Name '%s' in '%s' is already in use!",
                    name, this.getFullName()
            );
        }

        localNames.add(name);
        registeredTypes.put(name, declarationNode);
    }

    @Nonnull
    public VariableDeclarationNode getVariableDeclaration(String varName) {
        Namespace toSearch = this;
        while (toSearch != null) {
            VariableDeclarationNode declarationNode = toSearch.registeredVariables.get(varName);
            if (declarationNode != null) {
                return declarationNode;
            } else {
                toSearch = toSearch.parent;
            }
        }

        throw new NameNotDefinedException(this, varName);
    }

    @Nonnull
    public TypeDeclarationNode getTypeDeclaration(String varName) {
        Namespace toSearch = this;
        while (toSearch != null) {
            TypeDeclarationNode declarationNode = toSearch.registeredTypes.get(varName);
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
