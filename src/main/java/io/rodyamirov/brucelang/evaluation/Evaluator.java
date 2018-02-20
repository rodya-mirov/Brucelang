package io.rodyamirov.brucelang.evaluation;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BinOpExprNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.ExpressionNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astexceptions.AstException;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;

public class Evaluator {
    private Evaluator() {
    }

    public static void evaluate(ProgramNode programNode) {
        programNode.accept(new ValueTableBuilder());
    }

    private static class Closure {
        private final ValueTable valueTable;
        private final FunctionExprNode function;

        public Closure(ValueTable valueTable, FunctionExprNode function) {
            this.valueTable = valueTable;
            this.function = function;
        }
    }

    // visitor, not walker, because we're going to be bouncing all around the tree
    private static class ValueTableBuilder implements ASTNode.ASTVisitor {
        private ValueTable valueTable;

        // This has a lot of typecasting -- we have to trust the typechecker really did work :)
        private final Stack<Object> evalStack = new ArrayStack<>();

        private Object evaluate(ExpressionNode expressionNode) {
            expressionNode.accept(this);
            return evalStack.pop();
        }

        public ValueTableBuilder() {
            this.valueTable = new ValueTable();
        }

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNode.getStatements().forEach(stmt -> stmt.accept(this));
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            evalStack.push(new Closure(valueTable, functionDefinitionNode));
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            Object evalValue = evaluate(variableDefinitionNode.getEvalExpr());

            valueTable = valueTable.withChanges()
                    .storeValue(variableDefinitionNode.getVariableDeclarationNode(), evalValue)
                    .build();
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            // no op
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            blockStatementNode.getStatements().forEach(stmt -> stmt.accept(this));
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            Object doValue = evaluate(doStatementNode.getEvalExpression());

            System.out.println("We 'DO' this: " + doValue.toString());
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            Object returnValue = evaluate(returnStatementNode.getEvalExpression());
            throw new ReturnException(returnValue);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            for (int i = 0; i < ifStatementNode.getConditions().size(); i++) {
                Object condition = evaluate(ifStatementNode.getConditions().get(i));

                if ((Boolean) condition) {
                    ifStatementNode.getResultingStatements().get(i).accept(this);
                    return;
                }
            }

            if (ifStatementNode.getElseStatement() != null) {
                ifStatementNode.getElseStatement().accept(this);
            }
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            Closure closure =
                    (Closure) evaluate(functionCallNode.getFunctionNode());

            FunctionExprNode actualFunction = closure.function;

            int numArgs = actualFunction.getParameterNodes().size();

            ValueTable original = valueTable;

            ValueTable.ValueTableModifier builder = closure.valueTable.withChanges();

            for (int i = 0; i < numArgs; i++) {
                Object arg = evaluate(functionCallNode.getArguments().get(i));
                builder.storeValue(actualFunction.getParameterNodes().get(i), arg);
            }

            valueTable = builder.build();

            try {
                actualFunction.getDefinitionStatements().forEach(stmt -> stmt.accept(this));
            } catch (ReturnException re) {
                evalStack.push(re.value);
                valueTable = original;
                return;
            }

            throw new NoReturnException(functionCallNode);
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            // TODO: what about short-circuit evaluation?
            TypedValue left = new TypedValue(
                    binOpExprNode.getLeftChild().getType(),
                    evaluate(binOpExprNode.getLeftChild()));

            TypedValue right = new TypedValue(
                    binOpExprNode.getRightChild().getType(),
                    evaluate(binOpExprNode.getRightChild()));

            Object output = binOpExprNode.getOperation().evaluate(left, right);
            evalStack.push(output);
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            TypedValue childValue = new TypedValue(
                    unaryOpExprNode.getChild().getType(),
                    evaluate(unaryOpExprNode.getChild()));

            Object output = unaryOpExprNode.getOperation().evaluate(childValue);
            evalStack.push(output);
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            throw new RuntimeException("I don't know about fields rn!");
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            evalStack.push(integerNode.getValue());
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            evalStack.push(booleanNode.getValue());
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            evalStack.push(stringExprNode.getValue());
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            evalStack.push(valueTable.getValue(variableReferenceNode.getDefinition()));
        }

        // thrown when we return from a function
        private static class ReturnException extends RuntimeException {
            private final Object value;

            public ReturnException(Object value) {
                this.value = value;
            }
        }

        private static class NoReturnException extends AstException {
            public NoReturnException(FunctionCallNode functionCallNode) {
                super(functionCallNode, "Function did not return!");
            }
        }
    }
}
