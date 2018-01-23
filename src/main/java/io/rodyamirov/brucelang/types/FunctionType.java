package io.rodyamirov.brucelang.types;

import java.util.ArrayList;
import java.util.List;

import static io.rodyamirov.brucelang.types.UnknownType.UNKNOWN_TYPE;

public class FunctionType implements Type {
    private List<Type> parameterTypes;
    private Type outputType;

    private boolean nameStale = true;
    private String typeName = null;

    public FunctionType(List<Type> parameterTypes, Type outputType) {
        this.parameterTypes = new ArrayList<>(parameterTypes);
        this.outputType = outputType;
    }

    public FunctionType(int numArgs) {
        this.parameterTypes = new ArrayList<>(numArgs);
        for (int i = 0; i < numArgs; i++) {
            this.parameterTypes.add(UNKNOWN_TYPE);
        }

        this.outputType = UNKNOWN_TYPE;
    }

    @Override
    public boolean isSameType(Type o) {
        if (o instanceof FunctionType) {
            FunctionType other = (FunctionType) o;

            if (this.parameterTypes.size() != other.parameterTypes.size()) {
                return false;
            } else if (!this.outputType.isSameType(other.outputType)) {
                return false;
            } else {
                int length = this.parameterTypes.size();
                for (int i = 0; i < length; i++) {
                    if (!this.parameterTypes.get(i).isSameType(other.parameterTypes.get(i))) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public Type getParameterType(int parameterIndex) {
        return parameterTypes.get(parameterIndex);
    }

    public void setParameterType(int parameterType, Type actualType) {
        parameterTypes.set(parameterType, actualType);
    }

    public Type getOutputType() {
        return outputType;
    }

    public void setOutputType(Type outputType) {
        this.outputType = outputType;
    }

    private void makeTypeName() {
        nameStale = false;

        StringBuilder sb = new StringBuilder();

        if (parameterTypes.size() == 0) {
            sb.append("Function () => ");
        } else if (parameterTypes.size() == 1) {
            sb.append("Function (").append(parameterTypes.get(0).getTypeName()).append(") => ");
        } else {
            sb.append("Function (").append(parameterTypes.get(0).getTypeName());

            for (int i = 1; i < parameterTypes.size(); i++) {
                sb.append(", ").append(parameterTypes.get(i).getTypeName());
            }

            sb.append(") => ");
        }

        typeName = sb.append(sb.append(outputType.getTypeName())).toString();
    }

    @Override
    public String getTypeName() {
        if (nameStale) {
            makeTypeName();
        }

        return typeName;
    }

    @Override
    public boolean isUnknown() {
        // TODO -- cache (stale/make)
        if (outputType.isUnknown()) {
            return true;
        }

        for (Type parameter : parameterTypes) {
            if (parameter.isUnknown()) {
                return true;
            }
        }

        return false;
    }
}
