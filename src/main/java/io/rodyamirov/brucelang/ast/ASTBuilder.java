package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.lexparse.BrucelangParser;
import io.rodyamirov.brucelang.lexparse.BrucelangVisitor;
import io.rodyamirov.brucelang.util.ProgrammerError;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ASTBuilder extends AbstractParseTreeVisitor<Object> implements BrucelangVisitor<Object> {
    /**
     * Visit a program node produced by {@link BrucelangParser#program}.
     * @param ctx the parse tree
     * @return A fully formed AST (with a ProgramNode at the head)
     */
    @Override
    public ProgramNode visitProgram(BrucelangParser.ProgramContext ctx) {
        List<StatementNode> statements = ctx.stmt().stream()
                .map(this::visitStmt)
                .collect(Collectors.toList());

        return new ProgramNode(statements);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#stmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public StatementNode visitStmt(BrucelangParser.StmtContext ctx) {
        if (ctx.blockStmt() != null) {
            return visitBlockStmt(ctx.blockStmt());
        } else if (ctx.ifStmt() != null) {
            return visitIfStmt(ctx.ifStmt());
        } else if (ctx.fnDef() != null) {
            return visitFnDef(ctx.fnDef());
        } else if (ctx.varDef() != null) {
            return visitVarDef(ctx.varDef());
        } else if (ctx.returnStmt() != null) {
            return visitReturnStmt(ctx.returnStmt());
        } else {
            throw new ProgrammerError("Unrecognized statement context subrule: '%s'", ctx);
        }
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#returnStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ReturnStatementNode visitReturnStmt(BrucelangParser.ReturnStmtContext ctx) {
        ExpressionNode evalExpression = (ExpressionNode) ctx.expr().accept(this);

        return new ReturnStatementNode(evalExpression);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#blockStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public BlockStatementNode visitBlockStmt(BrucelangParser.BlockStmtContext ctx) {
        List<StatementNode> statements = ctx.stmt().stream()
                .map(this::visitStmt).collect(Collectors.toList());

        return new BlockStatementNode(statements);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#ifStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public IfStatementNode visitIfStmt(BrucelangParser.IfStmtContext ctx) {
        List<ExpressionNode> conditions = ctx.expr().stream()
                .map(node -> (ExpressionNode) node.accept(this))
                .collect(Collectors.toList());

        List<BlockStatementNode> resultStatements = new ArrayList<>(conditions.size());

        // note bounds; this may or may not leave one extra off the end, which is the else statement
        for (int i = 0; i < conditions.size(); i++) {
            resultStatements.add(visitBlockStmt(ctx.blockStmt(i)));
        }

        // this returns null if there isn't one, which is great
        BlockStatementNode maybeElse = Optional
                .ofNullable(ctx.blockStmt(conditions.size() + 1))
                .map(this::visitBlockStmt)
                .orElse(null);

        return new IfStatementNode(conditions, resultStatements, maybeElse);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#varDef}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public VariableDefinitionNode visitVarDef(BrucelangParser.VarDefContext ctx) {
        ExpressionNode definition = (ExpressionNode) ctx.expr().accept(this);
        definition.setDefExpr(true);

        return new VariableDefinitionNode(ctx.ID().getText(), definition);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#fnDef}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public StatementNode visitFnDef(BrucelangParser.FnDefContext ctx) {
        FunctionExprNode definition = FunctionExprNode.makeNamedFunction(
                ctx.ID().getText(),
                visitIdList(ctx.idList()),
                visitBlockStmt(ctx.blockStmt()).getStatements()
        );

        definition.setDefExpr(true);
        return new VariableDefinitionNode(ctx.ID().getText(), definition);
    }

    @Override
    public List<ExpressionNode> visitNoExprs(BrucelangParser.NoExprsContext ctx) {
        return Collections.emptyList();
    }

    @Override
    public List<ExpressionNode> visitSomeExprs(BrucelangParser.SomeExprsContext ctx) {
        return ctx.expr().stream()
                .map(node -> (ExpressionNode) node.accept(this))
                .collect(Collectors.toList());
    }

    private List<VariableDeclarationNode> visitIdList(BrucelangParser.IdListContext ctx) {
        return (List<VariableDeclarationNode>) ctx.accept(this);
    }

    @Override
    public List<VariableDeclarationNode> visitNoIds(BrucelangParser.NoIdsContext ctx) {
        return Collections.emptyList();
    }

    @Override
    public List<VariableDeclarationNode> visitSomeIds(BrucelangParser.SomeIdsContext ctx) {
        return ctx.ID().stream()
                .map(node -> new VariableDeclarationNode(node.getText()))
                .collect(Collectors.toList());
    }

    @Override
    public Object visitOneArgLambda(BrucelangParser.OneArgLambdaContext ctx) {
        List<VariableDeclarationNode> args = Collections.singletonList(
                new VariableDeclarationNode(ctx.ID().getText())
        );
        BlockStatementNode eval = this.visitBlockStmt(ctx.blockStmt());

        return FunctionExprNode.makeAnonymousFunction(args, eval.getStatements());
    }

    @Override
    public Object visitMultiArgLambda(BrucelangParser.MultiArgLambdaContext ctx) {
        List<VariableDeclarationNode> args = this.visitIdList(ctx.idList());
        BlockStatementNode eval = this.visitBlockStmt(ctx.blockStmt());

        return FunctionExprNode.makeAnonymousFunction(args, eval.getStatements());
    }

    @Override
    public Object visitOneArgExprLambda(BrucelangParser.OneArgExprLambdaContext ctx) {
        List<VariableDeclarationNode> args = Collections.singletonList(
                new VariableDeclarationNode(ctx.ID().getText())
        );
        ReturnStatementNode eval =
                new ReturnStatementNode((ExpressionNode) ctx.expr().accept(this));

        return FunctionExprNode.makeAnonymousFunction(args, Collections.singletonList(eval));
    }

    @Override
    public Object visitMultiArgExprLambda(BrucelangParser.MultiArgExprLambdaContext ctx) {
        List<VariableDeclarationNode> args = this.visitIdList(ctx.idList());
        ReturnStatementNode eval =
                new ReturnStatementNode((ExpressionNode) ctx.expr().accept(this));

        return FunctionExprNode.makeAnonymousFunction(args, Collections.singletonList(eval));
    }

    @Override
    public FunctionExprNode visitLambdaExpression(BrucelangParser.LambdaExpressionContext ctx) {
        return (FunctionExprNode) ctx.lambda().accept(this);
    }

    @Override
    public ExpressionNode visitBooleanExpression(BrucelangParser.BooleanExpressionContext ctx) {
        return (ExpressionNode) ctx.boolExpr().accept(this);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#fnCall}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public FunctionCallNode visitNamedFnCall(BrucelangParser.NamedFnCallContext ctx) {
        return new FunctionCallNode(
                new VariableReferenceNode(ctx.ID().getText()),
                (List<ExpressionNode>) ctx.exprList().accept(this)
        );
    }

    @Override
    public FunctionCallNode visitAnonFnCall(BrucelangParser.AnonFnCallContext ctx) {
        FunctionExprNode fnExpr = (FunctionExprNode) ctx.lambda().accept(this);
        return new FunctionCallNode(
                fnExpr, (List<ExpressionNode>) ctx.exprList().accept(this));
    }

    /**
     * Visit a parse tree produced by the {@code fallThroughAddExpr}
     * labeled alternative in {@link BrucelangParser#boolExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ExpressionNode visitFallThroughAddExpr(BrucelangParser.FallThroughAddExprContext ctx) {
        return visitAddExpr(ctx.addExpr());
    }

    /**
     * Visit a parse tree produced by the {@code boolOpExpr}
     * labeled alternative in {@link BrucelangParser#boolExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ExpressionNode visitBoolOpExpr(BrucelangParser.BoolOpExprContext ctx) {
        return new BinOpExprNode(
                visitBoolOp(ctx.boolOp()),
                visitAddExpr(ctx.addExpr(0)),
                visitAddExpr(ctx.addExpr(1))
        );
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#addExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ExpressionNode visitAddExpr(BrucelangParser.AddExprContext ctx) {
        // TODO: currently this is chained as binary operations -- but maybe we could improve it
        ExpressionNode current = visitMulExpr(ctx.mulExpr(0));

        // TODO: this should probably be reversed in order (otherwise a*b*c will parse as a*(b*c) which is not intuitive)
        for (int i = 1; i < ctx.mulExpr().size(); i++) {
            current = new BinOpExprNode(
                    visitAddOp(ctx.addOp(i-1)),
                    current,
                    visitMulExpr(ctx.mulExpr(i))
            );
        }

        return current;
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#mulExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ExpressionNode visitMulExpr(BrucelangParser.MulExprContext ctx) {
        // TODO: currently this is chained as binary operations -- but maybe we could improve it

        ExpressionNode current = (ExpressionNode) ctx.unaryExpr(0).accept(this);

        // TODO: this should probably be reversed in order (otherwise a*b*c will parse as a*(b*c) which is not intuitive)
        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            current = new BinOpExprNode(
                    visitMulOp(ctx.mulOp(i-1)),
                    current,
                    (ExpressionNode) ctx.unaryExpr(i).accept(this)
            );
        }

        return current;
    }

    /**
     * Visit a parse tree produced by the {@code fallThroughBaseExpr}
     * labeled alternative in {@link BrucelangParser#unaryExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ExpressionNode visitFallThroughBaseExpr(BrucelangParser.FallThroughBaseExprContext ctx) {
        return (ExpressionNode) ctx.baseExpr().accept(this);
    }

    /**
     * Visit a parse tree produced by the {@code nestedUnaryExpr}
     * labeled alternative in {@link BrucelangParser#unaryExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public UnaryOpExprNode visitNestedUnaryExpr(BrucelangParser.NestedUnaryExprContext ctx) {
        return new UnaryOpExprNode(visitUnaryOp(ctx.unaryOp()), (ExpressionNode) ctx.unaryExpr().accept(this));
    }

    /**
     * Visit a parse tree produced by the {@code parenExpr}
     * labeled alternative in {@link BrucelangParser#baseExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ExpressionNode visitParenExpr(BrucelangParser.ParenExprContext ctx) {
        return (ExpressionNode) ctx.expr().accept(this);
    }

    /**
     * Visit a parse tree produced by the {@code fallThroughFnCall}
     * labeled alternative in {@link BrucelangParser#baseExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public FunctionCallNode visitFallThroughFnCall(BrucelangParser.FallThroughFnCallContext ctx) {
        return (FunctionCallNode) ctx.fnCall().accept(this);
    }

    /**
     * Visit a parse tree produced by the {@code variableReference}
     * labeled alternative in {@link BrucelangParser#baseExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public VariableReferenceNode visitVariableReference(BrucelangParser.VariableReferenceContext ctx) {
        return new VariableReferenceNode(ctx.ID().getText());
    }

    /**
     * Visit a parse tree produced by the {@code numConst}
     * labeled alternative in {@link BrucelangParser#baseExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public IntExprNode visitNumConst(BrucelangParser.NumConstContext ctx) {
        String toParse = ctx.INT().getText();

        try {
            BigInteger value = new BigInteger(toParse);
            return new IntExprNode(value);
        } catch (NumberFormatException nfe) {
            // ProgrammerError because the parser/lexer grammar should guarantee this is possible
            throw new ProgrammerError("Could not parse '%s' as integer", toParse);
        }
    }

    /**
     * Visit a parse tree produced by the {@code stringConst}
     * labeled alternative in {@link BrucelangParser#baseExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public StringExprNode visitStringConst(BrucelangParser.StringConstContext ctx) {
        return new StringExprNode(ctx.STRING_CONST().getText());
    }

    /**
     * Visit a parse tree produced by the {@code boolConst}
     * labeled alternative in {@link BrucelangParser#baseExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public BoolExprNode visitBoolConst(BrucelangParser.BoolConstContext ctx) {
        return new BoolExprNode(visitBoolVal(ctx.boolVal()));
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#boolOp}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Operators.BinOp visitBoolOp(BrucelangParser.BoolOpContext ctx) {
        if (ctx.AND() != null) {
            return Operators.BinOp.AND;
        } else if (ctx.OR() != null) {
            return Operators.BinOp.OR;
        } else {
            throw new ProgrammerError("Unrecognized boolean operator: '%s'", ctx);
        }
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#compOp}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Operators.BinOp visitCompOp(BrucelangParser.CompOpContext ctx) {
        if (ctx.EQ() != null) {
            return Operators.BinOp.EQ;
        } else if (ctx.NEQ() != null) {
            return Operators.BinOp.NEQ;
        } else if (ctx.GT() != null) {
            return Operators.BinOp.GT;
        } else if (ctx.GTE() != null) {
            return Operators.BinOp.GTE;
        } else if (ctx.LT() != null) {
            return Operators.BinOp.LT;
        } else if (ctx.LTE() != null) {
            return Operators.BinOp.LTE;
        } else {
            throw new ProgrammerError("Unrecognized comparison operator: '%s'", ctx);
        }
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#boolVal}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Boolean visitBoolVal(BrucelangParser.BoolValContext ctx) {
        if (ctx.TRUE() != null) {
            return true;
        } else if (ctx.FALSE() != null) {
            return false;
        } else {
            throw new ProgrammerError("Unrecognized boolean value: '%s'", ctx);
        }
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#addOp}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Operators.BinOp visitAddOp(BrucelangParser.AddOpContext ctx) {
        if (ctx.PLUS() != null) {
            return Operators.BinOp.PLUS;
        } else if (ctx.MINUS() != null) {
            return Operators.BinOp.MINUS;
        } else {
            throw new ProgrammerError("Unrecognized additive operation: '%s'", ctx);
        }
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#mulOp}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Operators.BinOp visitMulOp(BrucelangParser.MulOpContext ctx) {
        if (ctx.TIMES() != null) {
            return Operators.BinOp.TIMES;
        } else if (ctx.DIVIDE() != null) {
            return Operators.BinOp.DIVIDE;
        } else {
            throw new ProgrammerError("Unrecognized multiplicative operation: '%s'", ctx);
        }
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#unaryOp}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Operators.UnOp visitUnaryOp(BrucelangParser.UnaryOpContext ctx) {
        if (ctx.MINUS() != null) {
            return Operators.UnOp.NEG;
        } else {
            throw new ProgrammerError("Unrecognized unary operator: '%s'", ctx);
        }
    }
}
