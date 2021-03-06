package io.rodyamirov.brucelang.ast;

import io.rodyamirov.brucelang.lexparse.BrucelangParser;
import io.rodyamirov.brucelang.lexparse.BrucelangVisitor;
import io.rodyamirov.brucelang.types.StandardTypeReferences;
import io.rodyamirov.brucelang.util.ProgrammerError;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ASTBuilder extends AbstractParseTreeVisitor<Object> implements BrucelangVisitor<Object> {
    private static final Map<String, String> binOpLookupTable;
    private static final Map<String, String> unaryOpLookupTable;

    static {
        binOpLookupTable = new HashMap<>();

        binOpLookupTable.put("+", "add");
        binOpLookupTable.put("-", "subtract");
        binOpLookupTable.put("*", "multiply");
        binOpLookupTable.put("/", "divide");

        binOpLookupTable.put("<", "lt");
        binOpLookupTable.put("<=", "lte");
        binOpLookupTable.put(">", "gt");
        binOpLookupTable.put(">=", "gte");
        binOpLookupTable.put("==", "eq");
        binOpLookupTable.put("!=", "neq");
    }

    @Nonnull
    private static String lookupBinOp(String token) {
        String out = binOpLookupTable.get(token);
        if (out == null) {
            throw new RuntimeException(String.format("Unknown binary operation '%s'", token));
        }
        return out;
    }

    static {
        unaryOpLookupTable = new HashMap<>();

        unaryOpLookupTable.put("-", "neg");
        unaryOpLookupTable.put("!", "not");
    }

    @Nonnull
    private static String lookupUnaryOp(String token) {
        String out = unaryOpLookupTable.get(token);
        if (out == null) {
            throw new RuntimeException(String.format("Unknown unary operation '%s'", token));
        }
        return out;
    }

    /**
     * Visit a program node produced by {@link BrucelangParser#program}.
     * @param ctx the parse tree
     * @return A fully formed AST (with a ProgramNode at the head)
     */
    @Override
    public ProgramNode visitProgram(BrucelangParser.ProgramContext ctx) {
        List<StatementNode> statements = ctx.stmt().stream()
                .map(stmt -> (StatementNode) stmt.accept(this))
                .collect(Collectors.toList());

        return new ProgramNode(statements);
    }

    @Override
    public VariableDefinitionNode visitSimpleVarDef(BrucelangParser.SimpleVarDefContext ctx) {
        VariableDeclarationNode declaration = (VariableDeclarationNode) ctx.varDecl().accept(this);
        ExpressionNode expr = (ExpressionNode) ctx.expr().accept(this);

        return new VariableDefinitionNode(declaration, expr);
    }

    @Override
    public VariableDefinitionNode visitParametrizedVarDef(BrucelangParser.ParametrizedVarDefContext ctx) {
        List<String> ids = (List<String>) ctx.idList().accept(this);
        List<TypeDeclarationNode> params = ids.stream()
                .map(TypeDeclarationNode::new)
                .collect(Collectors.toList());

        ExpressionNode expr = (ExpressionNode) ctx.expr().accept(this);
        ReturnStatementNode returnStatement = new ReturnStatementNode(expr);

        ExpressionNode typeFn = new TypeFuncExprNode(params, Collections.singletonList(returnStatement));

        VariableDeclarationNode declaration = (VariableDeclarationNode) ctx.varDecl().accept(this);

        return new VariableDefinitionNode(declaration, typeFn);
    }

    @Override
    public VariableDeclarationNode visitExplicitVarDecl(BrucelangParser.ExplicitVarDeclContext ctx) {
        String name = ctx.ID().getText();
        TypeReferenceNode typeReferenceNode = (TypeReferenceNode) ctx.typeExpr().accept(this);

        return new VariableDeclarationNode(name, typeReferenceNode);
    }

    @Override
    public List<String> visitNoIds(BrucelangParser.NoIdsContext ctx) {
        return Collections.emptyList();
    }

    @Override
    public List<String> visitSomeIds(BrucelangParser.SomeIdsContext ctx) {
        return ctx.ID().stream().map(TerminalNode::getText).collect(Collectors.toList());
    }

    @Override
    public TypeDefinitionNode visitTypeDefnStmtBranch(BrucelangParser.TypeDefnStmtBranchContext ctx) {
        return (TypeDefinitionNode) ctx.typeDefnStmt().accept(this);
    }

    @Override
    public FieldDeclarationNode visitFieldDecl(BrucelangParser.FieldDeclContext ctx) {
        return new FieldDeclarationNode(
                ctx.ID().getText(),
                (TypeReferenceNode) ctx.typeExpr().accept(this)
        );
    }

    @Override
    public TypeDefinitionNode visitTypeDefnStmt(BrucelangParser.TypeDefnStmtContext ctx) {
        String typeName = ctx.ID().getText();

        TypeDeclarationNode typeDecl = new TypeDeclarationNode(ctx.ID().getText());

        List<FieldDeclarationNode> fields = ctx.fieldDecl().stream()
                .map(fieldDecl -> (FieldDeclarationNode) fieldDecl.accept(this))
                .collect(Collectors.toList());

        TypeFieldsNode typeFieldsNode = new TypeFieldsNode(typeName, fields);

        return new TypeDefinitionNode(typeDecl, typeFieldsNode);
    }

    @Override
    public BlockStatementNode visitBlockStmtBranch(BrucelangParser.BlockStmtBranchContext ctx) {
        return (BlockStatementNode) ctx.blockStmt().accept(this);
    }

    @Override
    public VariableDefinitionNode visitFnDefBranch(BrucelangParser.FnDefBranchContext ctx) {
        return (VariableDefinitionNode) ctx.fnDef().accept(this);
    }

    @Override
    public VariableDefinitionNode visitVarDefBranch(BrucelangParser.VarDefBranchContext ctx) {
        return (VariableDefinitionNode) ctx.varDef().accept(this);
    }

    @Override
    public ReturnStatementNode visitReturnStmtBranch(BrucelangParser.ReturnStmtBranchContext ctx) {
        return (ReturnStatementNode) ctx.returnStmt().accept(this);
    }

    @Override
    public DoStatementNode visitDoStmtBranch(BrucelangParser.DoStmtBranchContext ctx) {
        return (DoStatementNode) ctx.doStmt().accept(this);
    }

    @Override
    public IfStatementNode visitIfStmtBranch(BrucelangParser.IfStmtBranchContext ctx) {
        return (IfStatementNode) ctx.ifStmt().accept(this);
    }

    @Override
    public NativeVarDefNode visitNativeDeclStmtBranch(BrucelangParser.NativeDeclStmtBranchContext ctx) {
        return (NativeVarDefNode) ctx.nativeDeclStmt().accept(this);
    }

    @Override
    public NativeVarDefNode visitNativeDeclStmt(BrucelangParser.NativeDeclStmtContext ctx) {
        String name = ctx.ID().getText();
        TypeReferenceNode typeRef = (TypeReferenceNode) ctx.typeExpr().accept(this);

        VariableDeclarationNode decl = new VariableDeclarationNode(name, typeRef);

        return new NativeVarDefNode(decl);
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
                .map(stmt -> (StatementNode) stmt.accept(this))
                .collect(Collectors.toList());

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

    @Override
    public VariableDeclarationNode visitInferredVarDecl(BrucelangParser.InferredVarDeclContext ctx) {
        return new VariableDeclarationNode(ctx.ID().getText(),null);
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

        TypeReferenceNode typeDeclaration = StandardTypeReferences.makeFunctionType(
                definition.getParameterNodes().stream()
                        .map(param -> param.getType())
                        .collect(Collectors.toList()),
                (TypeReferenceNode) ctx.typeExpr().accept(this),
                null
        );

        VariableDeclarationNode declarationNode = new VariableDeclarationNode(
                ctx.ID().getText(), typeDeclaration);

        return new VariableDefinitionNode(declarationNode, definition);
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
    public SimpleTypeReferenceNode visitSimpleType(BrucelangParser.SimpleTypeContext ctx) {
        return new SimpleTypeReferenceNode(ctx.ID().getText());
    }

    @Override
    public ParametrizedTypeReferenceNode visitComplexType(BrucelangParser.ComplexTypeContext ctx) {
        SimpleTypeReferenceNode base = new SimpleTypeReferenceNode(ctx.ID().getText());
        List<TypeReferenceNode> args = (List<TypeReferenceNode>) ctx.typeExprList().accept(this);

        return new ParametrizedTypeReferenceNode(base, args);
    }

    @Override
    public FunctionTypeReferenceNode visitFnType(BrucelangParser.FnTypeContext ctx) {
        List<TypeReferenceNode> args = (List<TypeReferenceNode>) ctx.typeExprList().accept(this);
        TypeReferenceNode returnType = (TypeReferenceNode) ctx.typeExpr().accept(this);

        return new FunctionTypeReferenceNode(args, returnType);
    }

    @Override
    public TypeReferenceNode visitParenType(BrucelangParser.ParenTypeContext ctx) {
        return (TypeReferenceNode) ctx.typeExpr().accept(this);
    }

    @Override
    public TypeFuncTypeRefNode visitTypeFnType(BrucelangParser.TypeFnTypeContext ctx) {
        List<SimpleTypeReferenceNode> params = ((List<String>) ctx.idList().accept(this))
                .stream().map(SimpleTypeReferenceNode::new).collect(Collectors.toList());
        TypeReferenceNode returnType = (TypeReferenceNode) ctx.typeExpr().accept(this);

        return new TypeFuncTypeRefNode(params, returnType);
    }

    @Override
    public List<TypeReferenceNode> visitNoTypes(BrucelangParser.NoTypesContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public List<TypeReferenceNode> visitSomeTypes(BrucelangParser.SomeTypesContext ctx) {
        return ctx.typeExpr().stream()
                .map(typeExpr -> (TypeReferenceNode) typeExpr.accept(this))
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
    public TypeFuncExprNode visitTypeLambdaExpr(BrucelangParser.TypeLambdaExprContext ctx) {
        return (TypeFuncExprNode) ctx.typeLambda().accept(this);
    }

    @Override
    public TypeFuncExprNode visitStmtTypeLambda(BrucelangParser.StmtTypeLambdaContext ctx) {
        List<TypeDeclarationNode> typeParams =
                ((List<String>) ctx.idList().accept(this)).stream()
                        .map(TypeDeclarationNode::new)
                        .collect(Collectors.toList());

        List<StatementNode> definitionStatements =
                ((BlockStatementNode) ctx.blockStmt().accept(this)).getStatements();

        return new TypeFuncExprNode(typeParams, definitionStatements);
    }

    @Override
    public TypeFuncExprNode visitExprTypeLambda(BrucelangParser.ExprTypeLambdaContext ctx) {
        List<TypeDeclarationNode> typeParams =
                ((List<String>) ctx.idList().accept(this)).stream()
                        .map(TypeDeclarationNode::new)
                        .collect(Collectors.toList());

        ExpressionNode evalExpr = (ExpressionNode) ctx.expr().accept(this);

        return new TypeFuncExprNode(
                typeParams,
                Collections.singletonList(new ReturnStatementNode(evalExpr)));
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
    public FunctionExprNode visitLambdaExpr(BrucelangParser.LambdaExprContext ctx) {
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

        ExpressionNode left = (ExpressionNode) ctx.compExpr(0).accept(this);
        ExpressionNode right = (ExpressionNode) ctx.compExpr(1).accept(this);
        String opName = (String) ctx.boolOp().accept(this);

        return new FunctionCallNode(
                new FieldAccessNode(left, opName),
                Collections.singletonList(right));
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

        ExpressionNode left = (ExpressionNode) ctx.addExpr(0).accept(this);
        ExpressionNode right = (ExpressionNode) ctx.addExpr(1).accept(this);
        String opName = (String) ctx.compOp().accept(this);

        return new FunctionCallNode(
                new FieldAccessNode(left, opName),
                Collections.singletonList(right));
    }

    @Override
    public String visitBoolOp(BrucelangParser.BoolOpContext ctx) {
        return lookupBinOp(ctx.getText());
    }

    @Override
    public String visitCompOp(BrucelangParser.CompOpContext ctx) {
        return lookupBinOp(ctx.getText());
    }

    @Override
    public String visitBoolVal(BrucelangParser.BoolValContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitAddOp(BrucelangParser.AddOpContext ctx) {
        return lookupBinOp(ctx.getText());
    }

    @Override
    public String visitMulOp(BrucelangParser.MulOpContext ctx) {
        return lookupBinOp(ctx.getText());
    }

    @Override
    public String visitUnaryOp(BrucelangParser.UnaryOpContext ctx) {
        return lookupUnaryOp(ctx.getText());
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
            // desugar this to (leftArg).opName(rightArg)
            String opName = (String)ctx.addOp(i-1).accept(this);

            ExpressionNode rightArg = (ExpressionNode) ctx.mulExpr(i).accept(this);

            current = new FunctionCallNode(
                    new FieldAccessNode(current, opName),
                    Collections.singletonList(rightArg));
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
            String opName = (String) ctx.mulOp(i-1).accept(this);
            ExpressionNode rightArg = (ExpressionNode) ctx.unaryExpr(i).accept(this);

            current = new FunctionCallNode(
                    new FieldAccessNode(current, opName),
                    Collections.singletonList(rightArg));
        }

        return current;
    }

    @Override
    public ExpressionNode visitFallThroughAccessOrCall(BrucelangParser.FallThroughAccessOrCallContext ctx) {
        return (ExpressionNode) ctx.accessOrCall().accept(this);
    }

    @Override
    public TypeFuncCallNode visitTypeFnCall(BrucelangParser.TypeFnCallContext ctx) {
        return new TypeFuncCallNode(
                (ExpressionNode) ctx.accessOrCall().accept(this),
                (List<TypeReferenceNode>) ctx.typeExprList().accept(this)
        );
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
    public FunctionCallNode visitNestedUnaryExpr(BrucelangParser.NestedUnaryExprContext ctx) {
        return new FunctionCallNode(
                new FieldAccessNode(
                        (ExpressionNode) ctx.unaryExpr().accept(this),
                        (String) ctx.unaryOp().accept(this)),
                Collections.emptyList());
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
            Integer value = new Integer(toParse);
            return new IntExprNode(value);
        } catch (NumberFormatException nfe) {
            // ProgrammerError because the parser/lexer grammar should guarantee this is possible
            throw new ProgrammerError("Could not parse '%s' as integer", toParse);
        }
    }

    @Override
    public StringExprNode visitStringConst(BrucelangParser.StringConstContext ctx) {
        String value = ctx.STRING_CONST().getText();

        return new StringExprNode(value.substring(1, value.length()-1));
    }

    /**
     * Visit a parse tree produced by the {@code boolConst}
     * labeled alternative in {@link BrucelangParser#baseExpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public BoolExprNode visitBoolConst(BrucelangParser.BoolConstContext ctx) {
        boolean value = Boolean.parseBoolean((String) ctx.boolVal().accept(this));
        return new BoolExprNode(value);
    }
}
