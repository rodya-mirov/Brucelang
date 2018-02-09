package io.rodyamirov.brucelang.types;

import java.util.List;

public interface TypeDeclaration {
    String typeName();
    boolean isSimpleType();
    List<TypeDeclaration> typeArguments();

    static boolean equalTypes(TypeDeclaration a, TypeDeclaration b) {
        if (a.isSimpleType()) {
            if (b.isSimpleType()) {
                return a.typeName().equals(b.typeName());
            } else {
                return false;
            }
        } else if (b.isSimpleType()) {
            return false;
        }

        if (!a.typeName().equals(b.typeName())) {
            return false;
        }

        if (a.typeArguments().size() != b.typeArguments().size()) {
            return false;
        }

        for (int i = 0; i < a.typeArguments().size(); i++) {
            if (!equalTypes(a.typeArguments().get(i), b.typeArguments().get(i))) {
                return false;
            }
        }
        return true;
    }

    default void writePrettyString(StringBuilder sb) {
        sb.append(typeName());
        if (isSimpleType()) {
            return;
        }

        int numArgs = typeArguments().size();
        sb.append("<");

        if (numArgs > 0) {
            typeArguments().get(0).writePrettyString(sb);
        }

        for (int i = 1; i < numArgs; i++) {
            sb.append(", ");
            typeArguments().get(i).writePrettyString(sb);
        }

        sb.append(">");
    }

    default String toPrettyString() {
        StringBuilder sb = new StringBuilder();
        writePrettyString(sb);
        return sb.toString();
    }
}
