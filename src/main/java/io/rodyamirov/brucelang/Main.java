package io.rodyamirov.brucelang;

import io.rodyamirov.brucelang.ast.ASTBuilder;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.evaluation.Evaluator;
import io.rodyamirov.brucelang.lexparse.BrucelangLexer;
import io.rodyamirov.brucelang.lexparse.BrucelangParser;
import io.rodyamirov.brucelang.staticanalysis.LambdaDesugarer;
import io.rodyamirov.brucelang.staticanalysis.NameRegistrar;
import io.rodyamirov.brucelang.staticanalysis.ReturnChecker;
import io.rodyamirov.brucelang.staticanalysis.TreePrinter;
import io.rodyamirov.brucelang.types.TypeWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: [run] library1.bl library2.bl ... mainFile.bl");
            return;
        }

        ProgramNode program = parseFile("libraries/StandardLib.bl");

        for (String fileName : args) {
            concatenate(program, parseFile(fileName));
        }

        LambdaDesugarer.removeAnonymousFunctions(program);

        NameRegistrar.registerNames(program);
        ReturnChecker.checkFunctionsReturn(program);
        TypeWalker.assignAndCheckTypes(program);

        System.out.println(TreePrinter.printTree(program, true));

        Evaluator.evaluate(program);
    }

    private static ProgramNode parseFile(String fileName) throws IOException {
        final CharStream input;
        try {
            input = CharStreams.fromFileName(fileName);
        } catch (IOException e) {
            System.out.println(String.format("Could not read file '%s'", fileName));
            throw e;
        }

        BrucelangLexer lexer = new BrucelangLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        BrucelangParser parser = new BrucelangParser(tokenStream);

        ASTBuilder builder = new ASTBuilder();
        return builder.visitProgram(parser.program());
    }

    // call this immediately after parsing, if at all
    private static void concatenate(ProgramNode base, ProgramNode toAppend) {
        base.getStatements().addAll(toAppend.getStatements());
    }
}
