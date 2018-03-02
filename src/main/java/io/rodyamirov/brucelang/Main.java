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
import io.rodyamirov.brucelang.types.TypeRegistrar;
import io.rodyamirov.brucelang.util.collections.Stack;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
        TypeRegistrar.registerTypes(program);
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

        out.put("global.Boolean.not", makeNoArgMethod((Boolean b) -> !b));
        out.put("global.Boolean.and", makeOneArgMethod((Boolean a, Boolean b) -> a && b));
        out.put("global.Boolean.or", makeOneArgMethod((Boolean a, Boolean b) -> a || b));

        out.put("global.Integer.neg", makeNoArgMethod((Integer a) -> -a));

        out.put("global.Integer.add", makeOneArgMethod((Integer a, Integer b) -> a + b));
        out.put("global.Integer.subtract", makeOneArgMethod((Integer a, Integer b) -> a - b));
        out.put("global.Integer.multiply", makeOneArgMethod((Integer a, Integer b) -> a * b));
        out.put("global.Integer.divide", makeOneArgMethod((Integer a, Integer b) -> a / b));

        out.put("global.Integer.lt", makeOneArgMethod((Integer self, Integer other) -> self < other));
        out.put("global.Integer.lte", makeOneArgMethod((Integer self, Integer other) -> self <= other));
        out.put("global.Integer.gt", makeOneArgMethod((Integer self, Integer other) -> self > other));
        out.put("global.Integer.gte", makeOneArgMethod((Integer self, Integer other) -> self >= other));
        out.put("global.Integer.eq", makeOneArgMethod((Integer self, Integer other) -> self.equals(other)));
        out.put("global.Integer.neq", makeOneArgMethod((Integer self, Integer other) -> !self.equals(other)));

        return out;
    }

    private static <T> Consumer<Stack<Object>> makeNoArgMethod(Function<T, Object> function) {
        return evalStack -> {
            T baseValue = (T) evalStack.pop();
            evalStack.push(id(stack2 -> stack2.push(function.apply(baseValue))));
        };
    }

    private static <T, A1> Consumer<Stack<Object>> makeOneArgMethod(BiFunction<T, A1, Object> function) {
        return evalStack -> {
            T baseValue = (T) evalStack.pop();
            evalStack.push(id(stack2 -> {
                A1 arg1 = (A1) stack2.pop();
                stack2.push(function.apply(baseValue, arg1));
            }));
        };
    }

    // just used to force java to parse lambdas as consumers
    private static Consumer<Stack<Object>> id(Consumer<Stack<Object>> fn) {
        return fn;
    }

    private static <T> Consumer<Stack<Object>> makeField(BiConsumer<T, Stack<Object>> fieldStackProcessor) {
        return evalStack -> {
            T baseObjValue = (T) evalStack.pop();
            fieldStackProcessor.accept(baseObjValue, evalStack);
        };
    }

    private static Consumer<Stack> makeZeroArg(Supplier<?> function) {
        return evalStack -> {
            evalStack.push(function.get());
        };
    }

    private static <T> Consumer<Stack<Object>> makeOneArg(Function<T, Object> function) {
        return evalStack -> {
            List<T> args = getArgs(1, evalStack);
            evalStack.push(function.apply(args.get(0)));
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
