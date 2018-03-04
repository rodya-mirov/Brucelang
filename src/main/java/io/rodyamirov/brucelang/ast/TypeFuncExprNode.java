package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.staticanalysis.Namespace;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Expression indicating this is a "function" which takes a type reference (or several)
 * and outputs an actual expression (typically without type parameters).
 */
public class TypeFuncExprNode extends ExpressionNode {
    private static final AtomicInteger canonicalIds = new AtomicInteger(0);

    private final List<TypeDeclarationNode> typeParameters;
    private final List<StatementNode> definitionStatements;

    private String anonName = null;

    public TypeFuncExprNode(
            List<TypeDeclarationNode> typeParameters,
            List<StatementNode> definitionStatements) {
        this.typeParameters = typeParameters;
        this.definitionStatements = definitionStatements;
    }

    private static String makeAnonName() {
        return "$typeLambda$" + canonicalIds.getAndIncrement();
    }

    private String getAnonName() {
        if (this.anonName == null) {
            this.anonName = makeAnonName();
        }

        return this.anonName;
    }

    public String getLocalName() {
        if (isDefExpr()) {
            return getDefinedName().getVarName();
        } else {
            return getAnonName();
        }
    }

    public String getFullName() {
        if (isDefExpr()) {
            return getDefinedName().getCanonicalName();
        } else {
            return getNamespace().getFullName() + "." + getAnonName();
        }
    }

    public List<TypeDeclarationNode> getTypeParameters() {
        return typeParameters;
    }

    public List<StatementNode> getDefinitionStatements() {
        return definitionStatements;
    }

    public Namespace getChildNamespace() {
        return definitionStatements.get(0).getNamespace();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitTypeFuncExpr(this);
    }

    @Override
    protected List<? extends ASTNode> getExtendedChildren() {
        List<ASTNode> out = new ArrayList<>(typeParameters.size() + definitionStatements.size());
        out.addAll(typeParameters);
        out.addAll(definitionStatements);
        return out;
    }
}
