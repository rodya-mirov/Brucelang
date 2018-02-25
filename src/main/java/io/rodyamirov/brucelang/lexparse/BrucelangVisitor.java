// Generated from /Users/richard.rast/personal/Brucelang/src/main/antlr/Brucelang.g4 by ANTLR 4.7

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
	 * Visit a parse tree produced by the {@code blockStmtBranch}
	 * labeled alternative in {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmtBranch(BrucelangParser.BlockStmtBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fnDefBranch}
	 * labeled alternative in {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnDefBranch(BrucelangParser.FnDefBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDefBranch}
	 * labeled alternative in {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefBranch(BrucelangParser.VarDefBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmtBranch}
	 * labeled alternative in {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmtBranch(BrucelangParser.ReturnStmtBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doStmtBranch}
	 * labeled alternative in {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStmtBranch(BrucelangParser.DoStmtBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmtBranch}
	 * labeled alternative in {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmtBranch(BrucelangParser.IfStmtBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDefnStmtBranch}
	 * labeled alternative in {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefnStmtBranch(BrucelangParser.TypeDefnStmtBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nativeDeclStmtBranch}
	 * labeled alternative in {@link BrucelangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeDeclStmtBranch(BrucelangParser.NativeDeclStmtBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#nativeDeclStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeDeclStmt(BrucelangParser.NativeDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#typeDefnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefnStmt(BrucelangParser.TypeDefnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(BrucelangParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(BrucelangParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#doStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStmt(BrucelangParser.DoStmtContext ctx);
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
	 * Visit a parse tree produced by the {@code fullVarDef}
	 * labeled alternative in {@link BrucelangParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullVarDef(BrucelangParser.FullVarDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inferredVarDef}
	 * labeled alternative in {@link BrucelangParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInferredVarDef(BrucelangParser.InferredVarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#fnDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnDef(BrucelangParser.FnDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(BrucelangParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BrucelangParser#inferredVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInferredVarDecl(BrucelangParser.InferredVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noVarDecls}
	 * labeled alternative in {@link BrucelangParser#varDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoVarDecls(BrucelangParser.NoVarDeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someVarDecls}
	 * labeled alternative in {@link BrucelangParser#varDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeVarDecls(BrucelangParser.SomeVarDeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleType}
	 * labeled alternative in {@link BrucelangParser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(BrucelangParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complexType}
	 * labeled alternative in {@link BrucelangParser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexType(BrucelangParser.ComplexTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fnType}
	 * labeled alternative in {@link BrucelangParser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnType(BrucelangParser.FnTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noTypes}
	 * labeled alternative in {@link BrucelangParser#typeExprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoTypes(BrucelangParser.NoTypesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someTypes}
	 * labeled alternative in {@link BrucelangParser#typeExprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeTypes(BrucelangParser.SomeTypesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noExprs}
	 * labeled alternative in {@link BrucelangParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoExprs(BrucelangParser.NoExprsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someExprs}
	 * labeled alternative in {@link BrucelangParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeExprs(BrucelangParser.SomeExprsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExpression}
	 * labeled alternative in {@link BrucelangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(BrucelangParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link BrucelangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(BrucelangParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneArgLambda}
	 * labeled alternative in {@link BrucelangParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneArgLambda(BrucelangParser.OneArgLambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiArgLambda}
	 * labeled alternative in {@link BrucelangParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiArgLambda(BrucelangParser.MultiArgLambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneArgExprLambda}
	 * labeled alternative in {@link BrucelangParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneArgExprLambda(BrucelangParser.OneArgExprLambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiArgExprLambda}
	 * labeled alternative in {@link BrucelangParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiArgExprLambda(BrucelangParser.MultiArgExprLambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fallThroughCompExpr}
	 * labeled alternative in {@link BrucelangParser#linkedBoolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallThroughCompExpr(BrucelangParser.FallThroughCompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolOpExpr}
	 * labeled alternative in {@link BrucelangParser#linkedBoolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOpExpr(BrucelangParser.BoolOpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fallThroughAddExpr}
	 * labeled alternative in {@link BrucelangParser#compExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallThroughAddExpr(BrucelangParser.FallThroughAddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compOpExpr}
	 * labeled alternative in {@link BrucelangParser#compExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOpExpr(BrucelangParser.CompOpExprContext ctx);
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
	 * Visit a parse tree produced by the {@code fallThroughAccessOrCall}
	 * labeled alternative in {@link BrucelangParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallThroughAccessOrCall(BrucelangParser.FallThroughAccessOrCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nestedUnaryExpr}
	 * labeled alternative in {@link BrucelangParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedUnaryExpr(BrucelangParser.NestedUnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fnCall}
	 * labeled alternative in {@link BrucelangParser#accessOrCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnCall(BrucelangParser.FnCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fallThroughBaseExpr}
	 * labeled alternative in {@link BrucelangParser#accessOrCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallThroughBaseExpr(BrucelangParser.FallThroughBaseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namedFieldAccess}
	 * labeled alternative in {@link BrucelangParser#accessOrCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedFieldAccess(BrucelangParser.NamedFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link BrucelangParser#baseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(BrucelangParser.ParenExprContext ctx);
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
}