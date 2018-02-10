package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.lexparse.BrucelangParser;
import io.rodyamirov.brucelang.lexparse.BrucelangVisitor;
import io.rodyamirov.brucelang.types.ComplexTypeDeclaration;
import io.rodyamirov.brucelang.types.SimpleTypeDeclaration;
import io.rodyamirov.brucelang.types.StandardTypeDeclarations;
import io.rodyamirov.brucelang.types.TypeDeclaration;
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
        } else if (ctx.doStmt() != null) {
            return visitDoStmt(ctx.doStmt());
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
                .ofNullable(ctx.blockStmt(conditions.size()))
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
        VariableDeclarationNode declarationNode = (VariableDeclarationNode) ctx.varDecl().accept(this);
        ExpressionNode definition = (ExpressionNode) ctx.expr().accept(this);
        definition.assignToName(declarationNode);

        return new VariableDefinitionNode(declarationNode, definition);
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#fnDef}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public VariableDefinitionNode visitFnDef(BrucelangParser.FnDefContext ctx) {

        FunctionExprNode definition = new FunctionExprNode(
                (List<VariableDeclarationNode>) ctx.varDeclList().accept(this),
                visitBlockStmt(ctx.blockStmt()).getStatements()
        );

        TypeDeclaration typeDeclaration = StandardTypeDeclarations.makeFunctionType(
                definition.getParameterNodes().stream()
                        .map(param -> param.getType())
                        .collect(Collectors.toList()),
                (TypeDeclaration) ctx.typeExpr().accept(this)
        );

        VariableDeclarationNode declarationNode = new VariableDeclarationNode(
                ctx.ID().getText(), typeDeclaration);

        definition.assignToName(declarationNode);
        return new VariableDefinitionNode(declarationNode, definition);
    }

    @Override
    public VariableDeclarationNode visitVarDecl(BrucelangParser.VarDeclContext ctx) {
        String name = ctx.ID().getText();
        TypeDeclaration type = (TypeDeclaration) ctx.typeExpr().accept(this);

        return new VariableDeclarationNode(name, type);
    }

    @Override
    public List<VariableDeclarationNode> visitNoVarDecls(BrucelangParser.NoVarDeclsContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public List<VariableDeclarationNode> visitSomeVarDecls(BrucelangParser.SomeVarDeclsContext ctx) {
        return ctx.varDecl().stream()
                .map(vd -> (VariableDeclarationNode) vd.accept(this))
                .collect(Collectors.toList());
    }

    @Override
    public SimpleTypeDeclaration visitSimpleType(BrucelangParser.SimpleTypeContext ctx) {
        return new SimpleTypeDeclaration(ctx.ID().getText());
    }

    @Override
    public ComplexTypeDeclaration visitComplexType(BrucelangParser.ComplexTypeContext ctx) {
        String name = ctx.ID().getText();
        List<TypeDeclaration> args = (List<TypeDeclaration>) ctx.typeExprList().accept(this);

        return new ComplexTypeDeclaration(name, args);
    }

    @Override
    public List<TypeDeclaration> visitNoTypes(BrucelangParser.NoTypesContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public List<TypeDeclaration> visitSomeTypes(BrucelangParser.SomeTypesContext ctx) {
        return ctx.typeExpr().stream()
                .map(vd -> (TypeDeclaration) vd.accept(this))
                .collect(Collectors.toList());
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

    @Override
    public FunctionExprNode visitOneArgLambda(BrucelangParser.OneArgLambdaContext ctx) {
        List<VariableDeclarationNode> args = Collections.singletonList(
                (VariableDeclarationNode) ctx.varDecl().accept(this)
        );
        BlockStatementNode eval = this.visitBlockStmt(ctx.blockStmt());

        return new FunctionExprNode(args, eval.getStatements());
    }

    @Override
    public FunctionExprNode visitMultiArgLambda(BrucelangParser.MultiArgLambdaContext ctx) {
        List<VariableDeclarationNode> args =
                (List<VariableDeclarationNode>) ctx.varDeclList().accept(this);
        BlockStatementNode eval = this.visitBlockStmt(ctx.blockStmt());

        return new FunctionExprNode(args, eval.getStatements());
    }

    @Override
    public FunctionExprNode visitOneArgExprLambda(BrucelangParser.OneArgExprLambdaContext ctx) {
        List<VariableDeclarationNode> args = Collections.singletonList(
                (VariableDeclarationNode) ctx.varDecl().accept(this)
        );
        ReturnStatementNode eval =
                new ReturnStatementNode((ExpressionNode) ctx.expr().accept(this));

        return new FunctionExprNode(args, Collections.singletonList(eval));
    }

    @Override
    public FunctionExprNode visitMultiArgExprLambda(BrucelangParser.MultiArgExprLambdaContext ctx) {
        List<VariableDeclarationNode> args =
                (List<VariableDeclarationNode>) ctx.varDeclList().accept(this);

        ReturnStatementNode eval =
                new ReturnStatementNode((ExpressionNode) ctx.expr().accept(this));

        return new FunctionExprNode(args, Collections.singletonList(eval));
    }

    @Override
    public FunctionExprNode visitLambdaExpression(BrucelangParser.LambdaExpressionContext ctx) {
        return (FunctionExprNode) ctx.lambda().accept(this);
    }

    @Override
    public ExpressionNode visitBooleanExpression(BrucelangParser.BooleanExpressionContext ctx) {
        return (ExpressionNode) ctx.linkedBoolExpr().accept(this);
    }

    @Override
    public ExpressionNode visitFallThroughCompExpr(BrucelangParser.FallThroughCompExprContext ctx) {
        return (ExpressionNode) ctx.compExpr().accept(this);
    }

    @Override
    public ExpressionNode visitBoolOpExpr(BrucelangParser.BoolOpExprContext ctx) {
        if (ctx.compExpr().size() != 2) {
            throw new RuntimeException("Wrong parse?");
        }

        return new BinOpExprNode(
                visitBoolOp(ctx.boolOp()),
                (ExpressionNode) ctx.compExpr(0).accept(this),
                (ExpressionNode) ctx.compExpr(1).accept(this)
        );
    }

    @Override
    public ExpressionNode visitFallThroughAddExpr(BrucelangParser.FallThroughAddExprContext ctx) {
        return (ExpressionNode) ctx.addExpr().accept(this);
    }

    @Override
    public ExpressionNode visitCompOpExpr(BrucelangParser.CompOpExprContext ctx) {
        if (ctx.addExpr().size() != 2) {
            throw new RuntimeException("Wrong parse?");
        }

        return new BinOpExprNode(
                visitCompOp(ctx.compOp()),
                (ExpressionNode) ctx.addExpr(0).accept(this),
                (ExpressionNode) ctx.addExpr(1).accept(this)
        );
    }

    /**
     * Visit a parse tree produced by {@link BrucelangParser#addExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public ExpressionNode visitAddExpr(BrucelangParser.AddExprContext ctx) {
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

    @Override
    public ExpressionNode visitFallThroughAccessOrCall(BrucelangParser.FallThroughAccessOrCallContext ctx) {
        return (ExpressionNode) ctx.accessOrCall().accept(this);
    }

    @Override
    public FunctionCallNode visitFnCall(BrucelangParser.FnCallContext ctx) {
        return new FunctionCallNode(
                (ExpressionNode) ctx.accessOrCall().accept(this),
                (List<ExpressionNode>) ctx.exprList().accept(this)
        );
    }

    @Override
    public FieldAccessNode visitNamedFieldAccess(BrucelangParser.NamedFieldAccessContext ctx) {
        ExpressionNode ownerObject = (ExpressionNode) ctx.accessOrCall().accept(this);
        String fieldName = ctx.ID().getText();

        return new FieldAccessNode(ownerObject, fieldName);
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
