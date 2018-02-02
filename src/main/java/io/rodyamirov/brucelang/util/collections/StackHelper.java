package io.rodyamirov.brucelang.util.collections;

public class StackHelper<T> {
    private final Stack<T> stack;

    public StackHelper(Stack<T> stack) {
        this.stack = stack;
    }

    /**
     * Helper method for the familiar pattern of "push something onto the stack, do something, then
     * pop that value back off the stack," which comes up in ASTVisitors frequently.
     *
     * This includes checks at the end to make sure that after the pop, you get the same value back,
     * and the stack is the same size as it started.
     */
    public void safePushPop(T toPush, Procedure toRun) {
        int startSize = stack.size();

        stack.push(toPush);

        toRun.doSomething();

        T end = stack.pop();

        if (end != toPush) {
            throw new RuntimeException("Got a different popped value than I pushed in!");
        } else if (stack.size() != startSize) {
            String message = String.format(
                    "Started with size '%d' but ended with size '%d'", startSize, stack.size());
            throw new RuntimeException(message);
        }
    }

    public interface Procedure {
        void doSomething();
    }
}
