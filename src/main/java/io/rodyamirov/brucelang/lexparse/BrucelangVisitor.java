// Generated from /Users/richard.rast/personal/brucelang/src/main/antlr/Brucelang.g4 by ANTLR 4.7

package io.rodyamirov.brucelang.lexparse;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BrucelangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BrucelangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BrucelangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(BrucelangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#doStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStmt(BrucelangParser.DoStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(BrucelangParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#blockStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(BrucelangParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(BrucelangParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(BrucelangParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#fnDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnDef(BrucelangParser.FnDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(BrucelangParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(BrucelangParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(BrucelangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#fnCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnCall(BrucelangParser.FnCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fallThroughAddExpr}
	 * labeled alternative in {@link BrucelangParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallThroughAddExpr(BrucelangParser.FallThroughAddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolOpExpr}
	 * labeled alternative in {@link BrucelangParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOpExpr(BrucelangParser.BoolOpExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(BrucelangParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(BrucelangParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fallThroughBaseExpr}
	 * labeled alternative in {@link BrucelangParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallThroughBaseExpr(BrucelangParser.FallThroughBaseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nestedUnaryExpr}
	 * labeled alternative in {@link BrucelangParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedUnaryExpr(BrucelangParser.NestedUnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link BrucelangParser#baseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(BrucelangParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fallThroughFnCall}
	 * labeled alternative in {@link BrucelangParser#baseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallThroughFnCall(BrucelangParser.FallThroughFnCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableReference}
	 * labeled alternative in {@link BrucelangParser#baseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(BrucelangParser.VariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numConst}
	 * labeled alternative in {@link BrucelangParser#baseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumConst(BrucelangParser.NumConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConst}
	 * labeled alternative in {@link BrucelangParser#baseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConst(BrucelangParser.StringConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolConst}
	 * labeled alternative in {@link BrucelangParser#baseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolConst(BrucelangParser.BoolConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(BrucelangParser.BoolOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(BrucelangParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#boolVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolVal(BrucelangParser.BoolValContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(BrucelangParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#mulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(BrucelangParser.MulOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(BrucelangParser.UnaryOpContext ctx);
}