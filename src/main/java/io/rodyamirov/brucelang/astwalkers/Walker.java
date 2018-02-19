package io.rodyamirov.brucelang.astwalkers;

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
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.astwalkers.ASTWalker.WalkFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class Walker {
    private final List<ASTPreWalker> preWalkers = new ArrayList<>();
    private final List<ASTPostWalker> postWalkers = new ArrayList<>();

    private final WalkerVisitor walkerVisitor = new WalkerVisitor();

    public Walker() {
    }

    public void walkTree(ASTNode node) {
        node.accept(walkerVisitor);
    }

    public Walker withWalker(ASTWalker walker) {
        InferredWalker inferredWalker = new InferredWalker(walker);

        preWalkers.add(inferredWalker);
        postWalkers.add(inferredWalker);

        return this;
    }

    public Walker withPreWalker(ASTPreWalker walker) {
        preWalkers.add(walker);

        return this;
    }

    public Walker withPostWalker(ASTPostWalker walker) {
        postWalkers.add(walker);

        return this;
    }

    private class WalkerVisitor implements ASTNode.ASTVisitor {
        private void visitChildren(ASTNode node) {
            for (ASTNode child : node.getChildren()) {
                child.accept(this);
            }
        }

        @Override
        public void visitProgram(ProgramNode programNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkProgram(programNode);
            }

            visitChildren(programNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkProgram(programNode);
            }
        }

        @Override
        public void visitFunctionExpr(FunctionExprNode functionDefinitionNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkFunctionExpr(functionDefinitionNode);
            }

            visitChildren(functionDefinitionNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkFunctionExpr(functionDefinitionNode);
            }
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkVariableDefn(variableDefinitionNode);
            }

            visitChildren(variableDefinitionNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkVariableDefn(variableDefinitionNode);
            }
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkVariableDecl(variableDeclarationNode);
            }

            visitChildren(variableDeclarationNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkVariableDecl(variableDeclarationNode);
            }
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkBlockStmt(blockStatementNode);
            }

            visitChildren(blockStatementNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkBlockStmt(blockStatementNode);
            }
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkDoStmt(doStatementNode);
            }

            visitChildren(doStatementNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkDoStmt(doStatementNode);
            }
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkReturnStmt(returnStatementNode);
            }

            visitChildren(returnStatementNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkReturnStmt(returnStatementNode);
            }
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkIfStmt(ifStatementNode);
            }

            visitChildren(ifStatementNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkIfStmt(ifStatementNode);
            }
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkFnCall(functionCallNode);
            }

            visitChildren(functionCallNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkFnCall(functionCallNode);
            }
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkBinOp(binOpExprNode);
            }

            visitChildren(binOpExprNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkBinOp(binOpExprNode);
            }
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkUnaryOp(unaryOpExprNode);
            }

            visitChildren(unaryOpExprNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkUnaryOp(unaryOpExprNode);
            }
        }

        @Override
        public void visitFieldAccess(FieldAccessNode fieldAccessNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkFieldAccess(fieldAccessNode);
            }

            visitChildren(fieldAccessNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkFieldAccess(fieldAccessNode);
            }
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkIntExpr(integerNode);
            }

            visitChildren(integerNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkIntExpr(integerNode);
            }
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkBoolExpr(booleanNode);
            }

            visitChildren(booleanNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkBoolExpr(booleanNode);
            }
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkStringExpr(stringExprNode);
            }

            visitChildren(stringExprNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkStringExpr(stringExprNode);
            }
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            for (ASTPreWalker preWalker : preWalkers) {
                preWalker.preWalkVarRef(variableReferenceNode);
            }

            visitChildren(variableReferenceNode);

            for (ASTPostWalker postWalker : postWalkers) {
                postWalker.postWalkVarRef(variableReferenceNode);
            }
        }
    }

    private static class InferredWalker implements ASTPreWalker, ASTPostWalker {
        private final WalkFunctions<ProgramNode> programNodeWalkFunctions;
        private final WalkFunctions<FunctionExprNode> functionExprNodeWalkFunctions;
        private final WalkFunctions<VariableDefinitionNode> variableDefinitionNodeWalkFunctions;
        private final WalkFunctions<VariableDeclarationNode> variableDeclarationNodeWalkFunctions;
        private final WalkFunctions<ReturnStatementNode> returnStatementNodeWalkFunctions;
        private final WalkFunctions<FunctionCallNode> functionCallNodeWalkFunctions;
        private final WalkFunctions<DoStatementNode> doStatementNodeWalkFunctions;
        private final WalkFunctions<IfStatementNode> ifStatementNodeWalkFunctions;
        private final WalkFunctions<BinOpExprNode> binOpExprNodeWalkFunctions;
        private final WalkFunctions<UnaryOpExprNode> unaryOpExprNodeWalkFunctions;
        private final WalkFunctions<FieldAccessNode> fieldAccessNodeWalkFunctions;
        private final WalkFunctions<IntExprNode> intExprNodeWalkFunctions;
        private final WalkFunctions<BoolExprNode> boolExprNodeWalkFunctions;
        private final WalkFunctions<StringExprNode> stringExprNodeWalkFunctions;
        private final WalkFunctions<VariableReferenceNode> variableReferenceNodeWalkFunctions;
        private final WalkFunctions<BlockStatementNode> blockStatementNodeWalkFunctions;

        public InferredWalker(ASTWalker astWalker) {
            this.programNodeWalkFunctions = getWalker(astWalker::programWalk);
            this.functionExprNodeWalkFunctions = getWalker(astWalker::functionExprWalk);
            this.variableDefinitionNodeWalkFunctions = getWalker(astWalker::varDefnWalk);
            this.variableDeclarationNodeWalkFunctions = getWalker(astWalker::varDeclWalk);
            this.returnStatementNodeWalkFunctions = getWalker(astWalker::returnWalk);
            this.doStatementNodeWalkFunctions = getWalker(astWalker::doWalk);
            this.functionCallNodeWalkFunctions = getWalker(astWalker::fnCallWalk);
            this.ifStatementNodeWalkFunctions = getWalker(astWalker::ifStmtWalk);
            this.binOpExprNodeWalkFunctions = getWalker(astWalker::binOpWalk);
            this.unaryOpExprNodeWalkFunctions = getWalker(astWalker::unaryOpWalk);
            this.fieldAccessNodeWalkFunctions = getWalker(astWalker::fieldAccessWalk);
            this.intExprNodeWalkFunctions = getWalker(astWalker::intExprWalk);
            this.boolExprNodeWalkFunctions = getWalker(astWalker::boolExprWalk);
            this.stringExprNodeWalkFunctions = getWalker(astWalker::stringExprWalk);
            this.variableReferenceNodeWalkFunctions = getWalker(astWalker::varRefWalk);
            this.blockStatementNodeWalkFunctions = getWalker(astWalker::blockStmtWalk);
        }

        private <T extends ASTNode> WalkFunctions<T> getWalker(
                Consumer<WalkFunctions<T>> walkModifier) {

            WalkFunctions<T> blank = new WalkFunctions<>();
            walkModifier.accept(blank);
            return blank;
        }

        @Override
        public void preWalkProgram(ProgramNode programNode) {
            programNodeWalkFunctions.getPreWalker().accept(programNode);
        }

        @Override
        public void preWalkFunctionExpr(FunctionExprNode functionExprNode) {
            functionExprNodeWalkFunctions.getPreWalker().accept(functionExprNode);
        }

        @Override
        public void preWalkVariableDefn(VariableDefinitionNode variableDefinitionNode) {
            variableDefinitionNodeWalkFunctions.getPreWalker().accept(variableDefinitionNode);
        }

        @Override
        public void preWalkVariableDecl(VariableDeclarationNode variableDeclarationNode) {
            variableDeclarationNodeWalkFunctions.getPreWalker().accept(variableDeclarationNode);
        }

        @Override
        public void preWalkReturnStmt(ReturnStatementNode returnStatementNode) {
            returnStatementNodeWalkFunctions.getPreWalker().accept(returnStatementNode);
        }

        @Override
        public void preWalkFnCall(FunctionCallNode functionCallNode) {
            functionCallNodeWalkFunctions.getPreWalker().accept(functionCallNode);
        }

        @Override
        public void preWalkIfStmt(IfStatementNode ifStatementNode) {
            ifStatementNodeWalkFunctions.getPreWalker().accept(ifStatementNode);
        }

        @Override
        public void preWalkBinOp(BinOpExprNode binOpExprNode) {
            binOpExprNodeWalkFunctions.getPreWalker().accept(binOpExprNode);
        }

        @Override
        public void preWalkUnaryOp(UnaryOpExprNode unaryOpExprNode) {
            unaryOpExprNodeWalkFunctions.getPreWalker().accept(unaryOpExprNode);
        }

        @Override
        public void preWalkFieldAccess(FieldAccessNode fieldAccessNode) {
            fieldAccessNodeWalkFunctions.getPreWalker().accept(fieldAccessNode);
        }

        @Override
        public void preWalkIntExpr(IntExprNode integerNode) {
            intExprNodeWalkFunctions.getPreWalker().accept(integerNode);
        }

        @Override
        public void preWalkBoolExpr(BoolExprNode booleanNode) {
            boolExprNodeWalkFunctions.getPreWalker().accept(booleanNode);
        }

        @Override
        public void preWalkStringExpr(StringExprNode stringExprNode) {
            stringExprNodeWalkFunctions.getPreWalker().accept(stringExprNode);
        }

        @Override
        public void preWalkVarRef(VariableReferenceNode variableReferenceNode) {
            variableReferenceNodeWalkFunctions.getPreWalker().accept(variableReferenceNode);
        }

        @Override
        public void preWalkDoStmt(DoStatementNode doStatementNode) {
            doStatementNodeWalkFunctions.getPreWalker().accept(doStatementNode);
        }

        @Override
        public void preWalkBlockStmt(BlockStatementNode blockStatementNode) {
            blockStatementNodeWalkFunctions.getPreWalker().accept(blockStatementNode);
        }

        @Override
        public void postWalkProgram(ProgramNode programNode) {
            programNodeWalkFunctions.getPostWalker().accept(programNode);
        }

        @Override
        public void postWalkFunctionExpr(FunctionExprNode functionExprNode) {
            functionExprNodeWalkFunctions.getPostWalker().accept(functionExprNode);
        }

        @Override
        public void postWalkVariableDefn(VariableDefinitionNode variableDefinitionNode) {
            variableDefinitionNodeWalkFunctions.getPostWalker().accept(variableDefinitionNode);
        }

        @Override
        public void postWalkVariableDecl(VariableDeclarationNode variableDeclarationNode) {
            variableDeclarationNodeWalkFunctions.getPostWalker().accept(variableDeclarationNode);
        }

        @Override
        public void postWalkReturnStmt(ReturnStatementNode returnStatementNode) {
            returnStatementNodeWalkFunctions.getPostWalker().accept(returnStatementNode);
        }

        @Override
        public void postWalkFnCall(FunctionCallNode functionCallNode) {
            functionCallNodeWalkFunctions.getPostWalker().accept(functionCallNode);
        }

        @Override
        public void postWalkIfStmt(IfStatementNode ifStatementNode) {
            ifStatementNodeWalkFunctions.getPostWalker().accept(ifStatementNode);
        }

        @Override
        public void postWalkBinOp(BinOpExprNode binOpExprNode) {
            binOpExprNodeWalkFunctions.getPostWalker().accept(binOpExprNode);
        }

        @Override
        public void postWalkUnaryOp(UnaryOpExprNode unaryOpExprNode) {
            unaryOpExprNodeWalkFunctions.getPostWalker().accept(unaryOpExprNode);
        }

        @Override
        public void postWalkFieldAccess(FieldAccessNode fieldAccessNode) {
            fieldAccessNodeWalkFunctions.getPostWalker().accept(fieldAccessNode);
        }

        @Override
        public void postWalkIntExpr(IntExprNode integerNode) {
            intExprNodeWalkFunctions.getPostWalker().accept(integerNode);
        }

        @Override
        public void postWalkBoolExpr(BoolExprNode booleanNode) {
            boolExprNodeWalkFunctions.getPostWalker().accept(booleanNode);
        }

        @Override
        public void postWalkStringExpr(StringExprNode stringExprNode) {
            stringExprNodeWalkFunctions.getPostWalker().accept(stringExprNode);
        }

        @Override
        public void postWalkVarRef(VariableReferenceNode variableReferenceNode) {
            variableReferenceNodeWalkFunctions.getPostWalker().accept(variableReferenceNode);
        }

        @Override
        public void postWalkDoStmt(DoStatementNode doStatementNode) {
            doStatementNodeWalkFunctions.getPostWalker().accept(doStatementNode);
        }

        @Override
        public void postWalkBlockStmt(BlockStatementNode blockStatementNode) {
            blockStatementNodeWalkFunctions.getPostWalker().accept(blockStatementNode);
        }
    }
}
