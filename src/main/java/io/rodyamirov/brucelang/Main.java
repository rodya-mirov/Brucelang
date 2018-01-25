package io.rodyamirov.brucelang;

import io.rodyamirov.brucelang.ast.ASTBuilder;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.lexparse.BrucelangLexer;
import io.rodyamirov.brucelang.lexparse.BrucelangParser;
import io.rodyamirov.brucelang.staticanalysis.FunctionDependencyAnalyzer;
import io.rodyamirov.brucelang.staticanalysis.NameRegistrar;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: [run] fileName.bl");
            return;
        }

        final CharStream input;
        try {
            input = CharStreams.fromFileName(args[0]);
        } catch (IOException e) {
            System.out.println(String.format("Could not read file '%s'", args[0]));
            return;
        }

        BrucelangLexer lexer = new BrucelangLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        BrucelangParser parser = new BrucelangParser(tokenStream);

        ASTBuilder builder = new ASTBuilder();
        ProgramNode program = builder.visitProgram(parser.program());

        NameRegistrar.registerNames(program);
        program.getNamespace().getVariableDeclaration("main"); // throws Exception if not defined

        FunctionDependencyAnalyzer.Path
                worstPath = FunctionDependencyAnalyzer.getWorstPath(program, "global.main");
        System.out.println("Most expensive path under 'main':");
        System.out.println("  Cost (method calls): " + worstPath.totalCost);
        System.out.println("  Call path: " + worstPath.nicePathString());
    }
}
