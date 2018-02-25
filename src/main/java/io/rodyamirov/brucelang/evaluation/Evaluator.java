package io.rodyamirov.brucelang.evaluation;

import io.rodyamirov.brucelang.NotImplementedException;
import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FieldDeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.NativeVarDefNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeDefinitionNode;
import io.rodyamirov.brucelang.ast.TypeFieldsNode;
import io.rodyamirov.brucelang.ast.TypeReferenceNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astexceptions.AstException;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Evaluator {
    private Evaluator() {
    }

    public static void evaluate(ProgramNode programNode, Map<String, Consumer<Stack<Object>>> nativeExprs) {
        programNode.accept(new ValueTableBuilder(nativeExprs));
    }

    // visitor, not walker, because we're going to be bouncing all around the tree
    private static class ValueTableBuilder implements ASTNode.ASTVisitor {
        private ValueTable valueTable;

        // This has a lot of typecasting -- we have to trust the typechecker really did work :)
        private final Stack<Object> evalStack = new ArrayStack<>();

        // shorthand for visiting a node which pushes _exactly one_ value to the stack
        // this can't be enforced with the type system so only call this if you're sure :|
        private <T> T evaluate(ASTNode evaluatableNode) {
            evaluatableNode.accept(this);
            return (T) evalStack.pop();
        }

        public ValueTableBuilder(Map<String, Consumer<Stack<Object>>> nativeExprs) {
            this.valueTable = new ValueTable(nativeExprs);
        }

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNode.getStatements().forEach(stmt -> stmt.accept(this));
        }

        @Override
        public void visitNativeVarDef(NativeVarDefNode nativeVarDefNode) {
            // this just checks all the native functions are loaded
            valueTable.getValue(nativeVarDefNode.getDeclarationNode());
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            ValueTable closure = this.valueTable;

            Consumer<Stack<Object>> fnCaller = evalStack -> {
                // all functions are closures, so we need to use the context the function was
                // created with, not the one surrounding the function call. So we'll need to save
                // the current context and restore it at the end.
                ValueTable original = this.valueTable;

                // assume the function call arguments have been called _in order_
                // because it's a stack, we need to peel them off in reverse order
                ValueTable.ValueTableModifier builder = closure.withChanges();
                List<VariableDeclarationNode> params = functionDefinitionNode.getParameterNodes();
                int numArgs = params.size();

                for (int i = numArgs - 1; i >= 0; i--) {
                    builder.storeValue(params.get(i), evalStack.pop());
                }

                this.valueTable = builder.build();
                try {
                    for (StatementNode stmt : functionDefinitionNode.getDefinitionStatements()) {
                        stmt.accept(this);
                    }
                } catch (ReturnException re) {
                    evalStack.push(re.value);
                    this.valueTable = original;
                    return;
                }

                throw new NoReturnException(functionDefinitionNode);
            };

            evalStack.push(fnCaller);
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
        public void visitTypeDeclaration(TypeDeclarationNode typeDeclarationNode) {
            // no op
        }

        @Override
        public void visitTypeDefinition(TypeDefinitionNode typeDefinition) {
            // no op
            // TODO: currently type definitions are ONLY used for type checking, but at some point there will be native fields in there
        }

        @Override
        public void visitTypeFields(TypeFieldsNode typeFieldsNode) {
            // TODO: currently type definitions are ONLY used for type checking, but at some point there will be native fields in there
            throw new NotImplementedException();
        }

        @Override
        public void visitFieldDeclaration(FieldDeclarationNode fieldDeclaration) {
            // TODO: currently type definitions are ONLY used for type checking, but at some point there will be native fields in there
            throw new NotImplementedException();
        }

        @Override
        public void visitSimpleTypeReference(TypeReferenceNode.SimpleTypeReferenceNode simpleTypeReferenceNode) {
            throw new NotImplementedException();
        }

        @Override
        public void visitParametrizedTypeReference(TypeReferenceNode.ParametrizedTypeReferenceNode parametrizedTypeReferenceNode) {
            throw new NotImplementedException();
        }

        @Override
        public void visitFunctionTypeReference(TypeReferenceNode.FunctionTypeReferenceNode functionTypeReferenceNode) {
            throw new NotImplementedException();
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            Object returnValue = evaluate(returnStatementNode.getEvalExpression());
            throw new ReturnException(returnValue);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            for (int i = 0; i < ifStatementNode.getConditions().size(); i++) {
                Boolean condition = evaluate(ifStatementNode.getConditions().get(i));

                if (condition) {
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
            Consumer<Stack<Object>> functionObject = evaluate(functionCallNode.getFunctionNode());

            functionCallNode.getArguments().forEach(node -> node.accept(this));

            functionObject.accept(evalStack);
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
            public NoReturnException(FunctionExprNode functionCallNode) {
                super(functionCallNode, "Function did not return!");
            }
        }
    }
}
