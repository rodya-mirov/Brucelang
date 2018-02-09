package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BinOpExprNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.types.TypeDeclaration;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.Stack;

import java.util.List;

public class TreePrinter {
    private static final String NEW_LINE = System.lineSeparator();
    private static final int spacesPerTab = 2;

    private TreePrinter() {
    }

    /**
     * Get a string representation of the AST node supplied.
     *
     * @param node The node to print out
     * @param excessiveParens If true, will insert parens everywhere, even if they aren't really
     *                        necessary. If false, will use fewer, but probably still more than
     *                        you really need.
     * @return A string representation of the program, which is (almost!) valid source code.
     *          Note that due to desugaring some variables may have illegal names, so the code
     *          may not compile.
     */
    public static String printTree(ASTNode node, boolean excessiveParens) {
        PrintVisitor printVisitor = new PrintVisitor(excessiveParens);
        node.accept(printVisitor);
        return printVisitor.stringBuilder.toString();
    }

    private interface StatementProcessor {
        void process();
    }

    private static class PrintVisitor implements ASTNode.ASTVisitor {
        private final StringBuilder stringBuilder = new StringBuilder();
        private final Stack<Boolean> nextShouldIndent = new ArrayStack<>();
        private final boolean excessiveParens;

        public PrintVisitor(boolean excessiveParens) {
            this.excessiveParens = excessiveParens;
        }

        private void indent(int scopeDepth) {
            for (int i = 0; i < scopeDepth * spacesPerTab; i++) {
                stringBuilder.append(' ');
            }
        }

        private void newline() {
            stringBuilder.append(NEW_LINE);
        }

        private void simpleStatement(StatementNode node, StatementProcessor processor) {
            indent(node.getNamespace().getDepth());

            processor.process();

            stringBuilder.append(';');
            newline();
        }

        private <T extends ASTNode> void commaSepList(List<T> toVisit) {
            if (toVisit.size() > 0) {
                toVisit.get(0).accept(this);
            }

            for (int i = 1; i < toVisit.size(); i++) {
                stringBuilder.append(", ");
                toVisit.get(i).accept(this);
            }
        }

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNode.getStatements().forEach(node -> node.accept(this));
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            if (functionDefinitionNode.getParameterNodes().size() == 1) {
                functionDefinitionNode.getParameterNodes().get(0).accept(this);
            } else {
                stringBuilder.append('(');
                commaSepList(functionDefinitionNode.getParameterNodes());
                stringBuilder.append(')');
            }

            stringBuilder.append(" => {");
            newline();
            functionDefinitionNode.getDefinitionStatements().forEach(stmt -> stmt.accept(this));
            indent(functionDefinitionNode.getNamespace().getDepth());
            stringBuilder.append('}');
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            simpleStatement(
                    variableDefinitionNode,
                    () -> {
                        stringBuilder.append("let ");
                        variableDefinitionNode.getVariableDeclarationNode().accept(this);
                        stringBuilder.append(" = ");
                        variableDefinitionNode.getEvalExpr().accept(this);
                    }
            );
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            stringBuilder.append(variableDeclarationNode.getVarName());
            stringBuilder.append(": ");

            variableDeclarationNode.getType().writePrettyString(stringBuilder);
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            if (nextShouldIndent.popOr(true)) { // unless specifically told to not indent, indent
                indent(blockStatementNode.getNamespace().getDepth());
            }

            stringBuilder.append('{');
            newline();

            blockStatementNode.getStatements().forEach(node -> node.accept(this));

            indent(blockStatementNode.getNamespace().getDepth());
            stringBuilder.append('}');
            newline();
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            simpleStatement(
                    doStatementNode,
                    () -> {
                        stringBuilder.append("do ");
                        doStatementNode.getEvalExpression().accept(this);
                    }
            );
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            simpleStatement(
                    returnStatementNode,
                    () -> {
                        stringBuilder.append("return ");
                        returnStatementNode.getEvalExpression().accept(this);
                    }
            );
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            int depth = ifStatementNode.getNamespace().getDepth();

            // TODO: this does braces on the next line (gross), fix this later
            indent(depth);
            stringBuilder.append("if (");
            ifStatementNode.getConditions().get(0).accept(this);
            stringBuilder.append(") ");
            nextShouldIndent.push(false);
            ifStatementNode.getResultingStatements().get(0).accept(this);

            for (int i = 1; i < ifStatementNode.getConditions().size(); i++) {
                indent(depth);
                stringBuilder.append(" else if (");
                ifStatementNode.getConditions().get(i).accept(this);
                stringBuilder.append(") ");
                nextShouldIndent.push(false);
                ifStatementNode.getResultingStatements().get(i).accept(this);
            }

            if (ifStatementNode.getElseStatement() != null) {
                indent(depth);
                stringBuilder.append("else ");
                nextShouldIndent.push(false);
                ifStatementNode.getElseStatement().accept(this);
            }
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            if (excessiveParens) {
                stringBuilder.append('(');
            }

            functionCallNode.getFunctionNode().accept(this);
            stringBuilder.append('(');
            commaSepList(functionCallNode.getArguments());
            stringBuilder.append(')');

            if (excessiveParens) {
                stringBuilder.append(')');
            }
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            // TODO: these parens can sometimes, but not always, be omitted. Not sure how to nicify
            // TODO: without doing a LOT of extra work
            stringBuilder.append('(');
            binOpExprNode.getLeftChild().accept(this);
            stringBuilder.append(' ');
            stringBuilder.append(binOpExprNode.getOperation().toString());
            stringBuilder.append(' ');
            binOpExprNode.getRightChild().accept(this);
            stringBuilder.append(')');
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            if (excessiveParens) {
                stringBuilder.append('(');
            }

            fieldAccessNode.getBaseNode().accept(this);
            stringBuilder.append('.');
            stringBuilder.append(fieldAccessNode.getFieldName());

            if (excessiveParens) {
                stringBuilder.append(')');
            }
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            stringBuilder.append('(');
            stringBuilder.append(unaryOpExprNode.getOperation().toString());
            stringBuilder.append(' ');
            unaryOpExprNode.getChild().accept(this);
            stringBuilder.append(')');
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            stringBuilder.append(integerNode.getValue().toString());
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            stringBuilder.append(booleanNode.getValue());
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            stringBuilder.append(stringExprNode.getValue());
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            stringBuilder.append(variableReferenceNode.getVarName());
        }
    }
}
