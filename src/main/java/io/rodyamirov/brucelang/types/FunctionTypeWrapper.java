package io.rodyamirov.brucelang.types;

import java.util.List;

import static io.rodyamirov.brucelang.types.StandardTypeDeclarations.FUNCTION;

// TODO: nicer error handling in validation
public class FunctionTypeWrapper implements TypeDeclaration {
    private List<TypeDeclaration> allParameters;

    private List<TypeDeclaration> argTypes;
    private TypeDeclaration returnType;

    public FunctionTypeWrapper(TypeDeclaration typeDeclaration) {
        if (!typeDeclaration.typeName().equals(FUNCTION)) {
            throw new RuntimeException("Expected type " + FUNCTION);
        }
        if (typeDeclaration.isSimpleType()) {
            throw new RuntimeException("Expected to have a fully specified function!");
        }
        if (typeDeclaration.typeArguments().size() < 1) {
            throw new RuntimeException("Need multiple arguments!");
        }

        this.allParameters = typeDeclaration.typeArguments();

        int numParameters = typeDeclaration.typeArguments().size() - 1;
        this.argTypes = typeDeclaration.typeArguments().subList(0, numParameters);
        this.returnType = typeDeclaration.typeArguments().get(numParameters);
    }

    public List<TypeDeclaration> getArgTypes() {
        return argTypes;
    }

    public TypeDeclaration getReturnType() {
        return returnType;
    }

    @Override
    public String typeName() {
        return FUNCTION;
    }

    @Override
    public boolean isSimpleType() {
        return false;
    }

    @Override
    public List<TypeDeclaration> typeArguments() {
        return allParameters;
    }
}
