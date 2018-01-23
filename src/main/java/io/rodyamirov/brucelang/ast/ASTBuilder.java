package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.lexparse.BrucelangParser;
import io.rodyamirov.brucelang.lexparse.BrucelangVisitor;
import io.rodyamirov.brucelang.util.ProgrammerError;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
        } else if (ctx.doStmt() != null) {
            return visitDoStmt(ctx.doStmt());
        } else if (ctx.returnStmt() != null) {
            return visitReturnStmt(ctx.returnStmt());
        } else {
            throw new ProgrammerError("Unrecognized statement context subrule: '%s'", ctx);
        }
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#doStmt}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public DoStatementNode visitDoStmt(BrucelangParser.DoStmtContext ctx) {
        ExpressionNode evalExpression = (ExpressionNode) ctx.expr().accept(this);

        return new DoStatementNode(evalExpression);
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
                .map(this::visitExpr)
                .collect(Collectors.toList());

        List<BlockStatementNode> resultStatements = new ArrayList<>(conditions.size());

        // note bounds; this may or may not leave one extra off the end, which is the else statement
        for (int i = 0; i < conditions.size(); i++) {
            resultStatements.add(visitBlockStmt(ctx.blockStmt(i)));
        }

        // this returns null if there isn't one, which is great
        BlockStatementNode elseStatement = visitBlockStmt(ctx.blockStmt(conditions.size() + 1));

        return new IfStatementNode(conditions, resultStatements, elseStatement);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#varDef}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public VariableDefinitionNode visitVarDef(BrucelangParser.VarDefContext ctx) {
        return new VariableDefinitionNode(ctx.ID().getText(), visitExpr(ctx.expr()));
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#fnDef}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public FunctionDefinitionNode visitFnDef(BrucelangParser.FnDefContext ctx) {
        return new FunctionDefinitionNode(
                ctx.ID().getText(),
                visitParamList(ctx.paramList()),
                visitBlockStmt(ctx.blockStmt())
        );
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#paramList}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public List<ParameterNode> visitParamList(BrucelangParser.ParamListContext ctx) {
        return ctx.ID().stream()
                .map(terminal -> new ParameterNode(terminal.getText()))
                .collect(Collectors.toList());
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#exprList}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public List<ExpressionNode> visitExprList(BrucelangParser.ExprListContext ctx) {
        return ctx.expr().stream()
                .map(this::visitExpr)
                .collect(Collectors.toList());
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ExpressionNode visitExpr(BrucelangParser.ExprContext ctx) {
        return (ExpressionNode) ctx.boolExpr().accept(this);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#fnCall}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public FunctionCallNode visitFnCall(BrucelangParser.FnCallContext ctx) {
        return new FunctionCallNode(ctx.ID().getText(), visitExprList(ctx.exprList()));
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
        return visitExpr(ctx.expr());
    }

    /**
     * Visit a parse tree produced by the {@code fallThroughFnCall}
     * labeled alternative in {@link BrucelangParser#baseExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public FunctionCallNode visitFallThroughFnCall(BrucelangParser.FallThroughFnCallContext ctx) {
        return this.visitFnCall(ctx.fnCall());
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