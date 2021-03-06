package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FieldAccessNode;
import io.rodyamirov.brucelang.ast.FieldDeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionExprNode;
import io.rodyamirov.brucelang.ast.FunctionTypeReferenceNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.NativeVarDefNode;
import io.rodyamirov.brucelang.ast.ParametrizedTypeReferenceNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.SimpleTypeReferenceNode;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.TypeDeclarationNode;
import io.rodyamirov.brucelang.ast.TypeDefinitionNode;
import io.rodyamirov.brucelang.ast.TypeFieldsNode;
import io.rodyamirov.brucelang.ast.TypeFuncCallNode;
import io.rodyamirov.brucelang.ast.TypeFuncExprNode;
import io.rodyamirov.brucelang.ast.TypeFuncTypeRefNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
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
        private final Stack<Boolean> nextShouldNewline = new ArrayStack<>();

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
        public void visitTypeFuncCall(TypeFuncCallNode typeFuncCall) {
            typeFuncCall.getBaseNode().accept(this);

            stringBuilder.append('<');

            commaSepList(typeFuncCall.getTypeArguments());

            stringBuilder.append('>');
        }

        @Override
        public void visitTypeFuncExpr(TypeFuncExprNode typeFuncExpr) {
            stringBuilder.append('<');

            commaSepList(typeFuncExpr.getTypeParameters());

            stringBuilder.append("> => {");

            typeFuncExpr.getDefinitionStatements().forEach(node -> node.accept(this));

            indent(typeFuncExpr.getNamespace().getDepth());
            stringBuilder.append('}');
            newline();
        }

        @Override
        public void visitNativeVarDef(NativeVarDefNode nativeVarDefNode) {
            indent(nativeVarDefNode.getNamespace().getDepth());
            stringBuilder.append("declare native ");
            nativeVarDefNode.getDeclarationNode().accept(this);
            stringBuilder.append(';');
            newline();
        }

        @Override
        public void visitTypeDefinition(TypeDefinitionNode typeDefinition) {
            indent(typeDefinition.getNamespace().getDepth());
            stringBuilder.append("declare type ");
            typeDefinition.getDeclaration().accept(this);
            stringBuilder.append(" {");

            typeDefinition.getFields().accept(this);

            indent(typeDefinition.getNamespace().getDepth());
            stringBuilder.append("}");
            newline();
        }

        @Override
        public void visitTypeFields(TypeFieldsNode typeFieldsNode) {
            typeFieldsNode.getChildren().forEach(field -> field.accept(this));
        }

        @Override
        public void visitFieldDeclaration(FieldDeclarationNode fieldDeclaration) {
            indent(fieldDeclaration.getNamespace().getDepth());
            stringBuilder.append(fieldDeclaration.getName());
            stringBuilder.append(": ");
            fieldDeclaration.getType().accept(this);
            stringBuilder.append(';');
            newline();
        }

        @Override
        public void visitTypeDeclaration(TypeDeclarationNode typeDeclarationNode) {
            stringBuilder.append(typeDeclarationNode.getName());
        }

        @Override
        public void visitSimpleTypeReference(SimpleTypeReferenceNode simpleTypeReferenceNode) {
            stringBuilder.append(simpleTypeReferenceNode.getName());
        }

        @Override
        public void visitParametrizedTypeReference(ParametrizedTypeReferenceNode parametrizedTypeReferenceNode) {
            parametrizedTypeReferenceNode.getBaseReference().accept(this);

            stringBuilder.append('<');

            commaSepList(parametrizedTypeReferenceNode.getArguments());

            stringBuilder.append('>');
        }

        @Override
        public void visitFunctionTypeReference(FunctionTypeReferenceNode functionTypeReferenceNode) {
            stringBuilder.append("Fn(");

            commaSepList(functionTypeReferenceNode.getArguments());

            stringBuilder.append(") -> ");
            functionTypeReferenceNode.getReturnType().accept(this);
        }

        @Override
        public void visitTypeFuncTypeRef(TypeFuncTypeRefNode typeFuncTypeRef) {
            stringBuilder.append("TypeFn(");

            commaSepList(typeFuncTypeRef.getTypeParameters());

            stringBuilder.append(") -> ");

            typeFuncTypeRef.getResultType().accept(this);
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

            variableDeclarationNode.getType().accept(this);
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

            if (nextShouldNewline.popOr(true)) {
                newline();
            }
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

            indent(depth);
            stringBuilder.append("if (");
            ifStatementNode.getConditions().get(0).accept(this);
            stringBuilder.append(") ");
            nextShouldIndent.push(false);
            nextShouldNewline.push(false);
            ifStatementNode.getResultingStatements().get(0).accept(this);

            for (int i = 1; i < ifStatementNode.getConditions().size(); i++) {
                stringBuilder.append(" else if (");
                ifStatementNode.getConditions().get(i).accept(this);
                stringBuilder.append(") ");
                nextShouldIndent.push(false);
                nextShouldNewline.push(false);
                ifStatementNode.getResultingStatements().get(i).accept(this);
            }

            if (ifStatementNode.getElseStatement() != null) {
                stringBuilder.append(" else ");
                nextShouldIndent.push(false);
                nextShouldNewline.push(false);
                ifStatementNode.getElseStatement().accept(this);
            }

            newline();
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
