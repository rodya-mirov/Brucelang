package io.rodyamirov.brucelang.astexceptions;

import io.rodyamirov.brucelang.staticanalysis.Namespace;

public class NameNotDefinedException extends RuntimeException {
    public NameNotDefinedException(Namespace namespace, String name) {
        super(String.format("Name '%s' not defined in namespace '%s'", name, namespace.getFullName()));
    }
}
