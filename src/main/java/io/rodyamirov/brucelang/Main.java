package io.rodyamirov.brucelang;

import io.rodyamirov.brucelang.ast.ASTBuilder;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.evaluation.Evaluator;
import io.rodyamirov.brucelang.lexparse.BrucelangLexer;
import io.rodyamirov.brucelang.lexparse.BrucelangParser;
import io.rodyamirov.brucelang.staticanalysis.NameRegistrar;
import io.rodyamirov.brucelang.staticanalysis.ReturnChecker;
import io.rodyamirov.brucelang.staticanalysis.TreePrinter;
import io.rodyamirov.brucelang.types.TypeChecker;
import io.rodyamirov.brucelang.util.collections.Stack;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

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

        NameRegistrar.registerNames(program);
        ReturnChecker.checkFunctionsReturn(program);
        TypeChecker.assignAndCheckTypes(program);

        System.out.println(TreePrinter.printTree(program, true));

        Evaluator.evaluate(program, makeNativeExprs());
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

    // TODO: obviously this is not how we want to do this moving forward
    private static Map<String, Consumer<Stack<Object>>> makeNativeExprs() {
        Map<String, Consumer<Stack<Object>>> out = new HashMap<>();

        out.put("global.add", makeTwoArg(BigInteger::add));
        out.put("global.subtract", makeTwoArg(BigInteger::subtract));
        out.put("global.multiply", makeTwoArg(BigInteger::multiply));
        out.put("global.divide", makeTwoArg(BigInteger::divide));

        out.put("global.lt", makeTwoArg((BigInteger l, BigInteger r) -> l.compareTo(r) < 0));
        out.put("global.lte", makeTwoArg((BigInteger l, BigInteger r) -> l.compareTo(r) <= 0));
        out.put("global.gt", makeTwoArg((BigInteger l, BigInteger r) -> l.compareTo(r) > 0));
        out.put("global.gte", makeTwoArg((BigInteger l, BigInteger r) -> l.compareTo(r) >= 0));

        out.put("global.eq", makeTwoArg((BigInteger l, BigInteger r) -> l.compareTo(r) == 0));
        out.put("global.neq", makeTwoArg((BigInteger l, BigInteger r) -> l.compareTo(r) != 0));

        out.put("global.neg", makeOneArg(BigInteger::negate));

        out.put("global.and", makeTwoArg(Boolean::logicalAnd));
        out.put("global.or", makeTwoArg(Boolean::logicalOr));
        out.put("global.not", makeOneArg((Boolean b) -> !b));

        return out;
    }

    private static <T> Consumer<Stack<Object>> makeOneArg(Function<T, Object> function) {
        return evalStack -> {
            List<T> args = getArgs(1, evalStack);
            evalStack.push(function.apply(args.get(0)));
        };
    }

    private static <T> Consumer<Stack<Object>> makeTwoArg(BiFunction<T, T, Object> biFunction) {
        return evalStack -> {
            List<T> args = getArgs(2, evalStack);
            evalStack.push(biFunction.apply(args.get(0), args.get(1)));
        };
    }

    private static <T> List<T> getArgs(int numArgs, Stack<Object> evalStack) {
        // this is a fairly lazy way to reverse a list
        List<T> tempStack = new ArrayList<>();
        for (int i = 0; i < numArgs; i++) {
            tempStack.add((T) evalStack.pop());
        }

        List<T> out = new ArrayList<>();
        for (int i = 0; i < numArgs; i++) {
            out.add(tempStack.get(numArgs - i - 1));
        }

        return out;
    }
}
