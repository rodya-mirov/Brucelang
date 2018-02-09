// Generated from /Users/richard.rast/personal/Brucelang/src/main/antlr/Brucelang.g4 by ANTLR 4.7

package io.rodyamirov.brucelang.lexparse;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BrucelangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TRUE=12, FALSE=13, DEFINE=14, DO=15, RETURN=16, AS=17, 
		IS=18, IF=19, ELSE=20, LET=21, STRING_CONST=22, AND=23, OR=24, PLUS=25, 
		MINUS=26, TIMES=27, DIVIDE=28, LT=29, LTE=30, GT=31, GTE=32, EQ=33, NEQ=34, 
		ID=35, INT=36, WS=37;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_returnStmt = 2, RULE_blockStmt = 3, 
		RULE_ifStmt = 4, RULE_varDef = 5, RULE_fnDef = 6, RULE_varDecl = 7, RULE_varDeclList = 8, 
		RULE_typeExpr = 9, RULE_typeExprList = 10, RULE_exprList = 11, RULE_expr = 12, 
		RULE_lambda = 13, RULE_linkedBoolExpr = 14, RULE_compExpr = 15, RULE_addExpr = 16, 
		RULE_mulExpr = 17, RULE_unaryExpr = 18, RULE_accessOrCall = 19, RULE_baseExpr = 20, 
		RULE_boolOp = 21, RULE_compOp = 22, RULE_boolVal = 23, RULE_addOp = 24, 
		RULE_mulOp = 25, RULE_unaryOp = 26;
	public static final String[] ruleNames = {
		"program", "stmt", "returnStmt", "blockStmt", "ifStmt", "varDef", "fnDef", 
		"varDecl", "varDeclList", "typeExpr", "typeExprList", "exprList", "expr", 
		"lambda", "linkedBoolExpr", "compExpr", "addExpr", "mulExpr", "unaryExpr", 
		"accessOrCall", "baseExpr", "boolOp", "compOp", "boolVal", "addOp", "mulOp", 
		"unaryOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'{'", "'}'", "'('", "')'", "'='", "':'", "','", "'=>'", 
		"'.'", "'\"'", "'true'", "'false'", "'define'", "'do'", "'return'", "'as'", 
		"'is'", "'if'", "'else'", "'let'", null, "'and'", "'or'", "'+'", "'-'", 
		"'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"TRUE", "FALSE", "DEFINE", "DO", "RETURN", "AS", "IS", "IF", "ELSE", "LET", 
		"STRING_CONST", "AND", "OR", "PLUS", "MINUS", "TIMES", "DIVIDE", "LT", 
		"LTE", "GT", "GTE", "EQ", "NEQ", "ID", "INT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Brucelang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BrucelangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BrucelangParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << DEFINE) | (1L << RETURN) | (1L << IF) | (1L << LET))) != 0)) {
				{
				{
				setState(54);
				stmt();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public FnDefContext fnDef() {
			return getRuleContext(FnDefContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				blockStmt();
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				fnDef();
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				varDef();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				returnStmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				ifStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(BrucelangParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(RETURN);
			setState(70);
			expr();
			setState(71);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStmtContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__1);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << DEFINE) | (1L << RETURN) | (1L << IF) | (1L << LET))) != 0)) {
				{
				{
				setState(74);
				stmt();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(BrucelangParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(BrucelangParser.IF, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<BlockStmtContext> blockStmt() {
			return getRuleContexts(BlockStmtContext.class);
		}
		public BlockStmtContext blockStmt(int i) {
			return getRuleContext(BlockStmtContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(BrucelangParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(BrucelangParser.ELSE, i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(IF);
			setState(83);
			match(T__3);
			setState(84);
			expr();
			setState(85);
			match(T__4);
			setState(86);
			blockStmt();
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(87);
					match(ELSE);
					setState(88);
					match(IF);
					setState(89);
					match(T__3);
					setState(90);
					expr();
					setState(91);
					match(T__4);
					setState(92);
					blockStmt();
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(99);
				match(ELSE);
				setState(100);
				blockStmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(BrucelangParser.LET, 0); }
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(LET);
			setState(104);
			varDecl();
			setState(105);
			match(T__5);
			setState(106);
			expr();
			setState(107);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnDefContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(BrucelangParser.DEFINE, 0); }
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public VarDeclListContext varDeclList() {
			return getRuleContext(VarDeclListContext.class,0);
		}
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TerminalNode AS() { return getToken(BrucelangParser.AS, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public FnDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFnDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnDefContext fnDef() throws RecognitionException {
		FnDefContext _localctx = new FnDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fnDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(DEFINE);
			setState(110);
			match(ID);
			setState(111);
			match(T__3);
			setState(112);
			varDeclList();
			setState(113);
			match(T__4);
			setState(114);
			match(T__6);
			setState(115);
			typeExpr();
			setState(116);
			match(AS);
			setState(117);
			blockStmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(ID);
			setState(120);
			match(T__6);
			setState(121);
			typeExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclListContext extends ParserRuleContext {
		public VarDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclList; }
	 
		public VarDeclListContext() { }
		public void copyFrom(VarDeclListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoVarDeclsContext extends VarDeclListContext {
		public NoVarDeclsContext(VarDeclListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNoVarDecls(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeVarDeclsContext extends VarDeclListContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public SomeVarDeclsContext(VarDeclListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitSomeVarDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclListContext varDeclList() throws RecognitionException {
		VarDeclListContext _localctx = new VarDeclListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDeclList);
		int _la;
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new NoVarDeclsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				_localctx = new SomeVarDeclsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				varDecl();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(125);
					match(T__7);
					setState(126);
					varDecl();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeExprContext extends ParserRuleContext {
		public TypeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeExpr; }
	 
		public TypeExprContext() { }
		public void copyFrom(TypeExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleTypeContext extends TypeExprContext {
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public SimpleTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitSimpleType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComplexTypeContext extends TypeExprContext {
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public TypeExprListContext typeExprList() {
			return getRuleContext(TypeExprListContext.class,0);
		}
		public ComplexTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitComplexType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeExprContext typeExpr() throws RecognitionException {
		TypeExprContext _localctx = new TypeExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeExpr);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new SimpleTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ComplexTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(ID);
				setState(136);
				match(LT);
				setState(137);
				typeExprList();
				setState(138);
				match(GT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeExprListContext extends ParserRuleContext {
		public TypeExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeExprList; }
	 
		public TypeExprListContext() { }
		public void copyFrom(TypeExprListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoTypesContext extends TypeExprListContext {
		public NoTypesContext(TypeExprListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNoTypes(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeTypesContext extends TypeExprListContext {
		public List<TypeExprContext> typeExpr() {
			return getRuleContexts(TypeExprContext.class);
		}
		public TypeExprContext typeExpr(int i) {
			return getRuleContext(TypeExprContext.class,i);
		}
		public SomeTypesContext(TypeExprListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitSomeTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeExprListContext typeExprList() throws RecognitionException {
		TypeExprListContext _localctx = new TypeExprListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeExprList);
		int _la;
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GT:
				_localctx = new NoTypesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				_localctx = new SomeTypesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				typeExpr();
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(144);
					match(T__7);
					setState(145);
					typeExpr();
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	 
		public ExprListContext() { }
		public void copyFrom(ExprListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoExprsContext extends ExprListContext {
		public NoExprsContext(ExprListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNoExprs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeExprsContext extends ExprListContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SomeExprsContext(ExprListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitSomeExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprList);
		int _la;
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new NoExprsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__3:
			case T__10:
			case TRUE:
			case FALSE:
			case MINUS:
			case ID:
			case INT:
				_localctx = new SomeExprsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				expr();
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(155);
					match(T__7);
					setState(156);
					expr();
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LambdaExpressionContext extends ExprContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExpressionContext extends ExprContext {
		public LinkedBoolExprContext linkedBoolExpr() {
			return getRuleContext(LinkedBoolExprContext.class,0);
		}
		public BooleanExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new LambdaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				lambda();
				}
				break;
			case 2:
				_localctx = new BooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				linkedBoolExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
	 
		public LambdaContext() { }
		public void copyFrom(LambdaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OneArgLambdaContext extends LambdaContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public OneArgLambdaContext(LambdaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitOneArgLambda(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiArgLambdaContext extends LambdaContext {
		public VarDeclListContext varDeclList() {
			return getRuleContext(VarDeclListContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public MultiArgLambdaContext(LambdaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitMultiArgLambda(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OneArgExprLambdaContext extends LambdaContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OneArgExprLambdaContext(LambdaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitOneArgExprLambda(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiArgExprLambdaContext extends LambdaContext {
		public VarDeclListContext varDeclList() {
			return getRuleContext(VarDeclListContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MultiArgExprLambdaContext(LambdaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitMultiArgExprLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lambda);
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new OneArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				varDecl();
				setState(169);
				match(T__8);
				setState(170);
				blockStmt();
				}
				break;
			case 2:
				_localctx = new MultiArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(T__3);
				setState(173);
				varDeclList();
				setState(174);
				match(T__4);
				setState(175);
				match(T__8);
				setState(176);
				blockStmt();
				}
				break;
			case 3:
				_localctx = new OneArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				varDecl();
				setState(179);
				match(T__8);
				setState(180);
				expr();
				}
				break;
			case 4:
				_localctx = new MultiArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(T__3);
				setState(183);
				varDeclList();
				setState(184);
				match(T__4);
				setState(185);
				match(T__8);
				setState(186);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LinkedBoolExprContext extends ParserRuleContext {
		public LinkedBoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkedBoolExpr; }
	 
		public LinkedBoolExprContext() { }
		public void copyFrom(LinkedBoolExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolOpExprContext extends LinkedBoolExprContext {
		public List<CompExprContext> compExpr() {
			return getRuleContexts(CompExprContext.class);
		}
		public CompExprContext compExpr(int i) {
			return getRuleContext(CompExprContext.class,i);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public BoolOpExprContext(LinkedBoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitBoolOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FallThroughCompExprContext extends LinkedBoolExprContext {
		public CompExprContext compExpr() {
			return getRuleContext(CompExprContext.class,0);
		}
		public FallThroughCompExprContext(LinkedBoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFallThroughCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinkedBoolExprContext linkedBoolExpr() throws RecognitionException {
		LinkedBoolExprContext _localctx = new LinkedBoolExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_linkedBoolExpr);
		try {
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new FallThroughCompExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				compExpr();
				}
				break;
			case 2:
				_localctx = new BoolOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				compExpr();
				setState(192);
				boolOp();
				setState(193);
				compExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompExprContext extends ParserRuleContext {
		public CompExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compExpr; }
	 
		public CompExprContext() { }
		public void copyFrom(CompExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FallThroughAddExprContext extends CompExprContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public FallThroughAddExprContext(CompExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFallThroughAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompOpExprContext extends CompExprContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public CompOpExprContext(CompExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitCompOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompExprContext compExpr() throws RecognitionException {
		CompExprContext _localctx = new CompExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_compExpr);
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new FallThroughAddExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				addExpr();
				}
				break;
			case 2:
				_localctx = new CompOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				addExpr();
				setState(199);
				compOp();
				setState(200);
				addExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddExprContext extends ParserRuleContext {
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public List<AddOpContext> addOp() {
			return getRuleContexts(AddOpContext.class);
		}
		public AddOpContext addOp(int i) {
			return getRuleContext(AddOpContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			mulExpr();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(205);
				addOp();
				setState(206);
				mulExpr();
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public List<MulOpContext> mulOp() {
			return getRuleContexts(MulOpContext.class);
		}
		public MulOpContext mulOp(int i) {
			return getRuleContext(MulOpContext.class,i);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			unaryExpr();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIVIDE) {
				{
				{
				setState(214);
				mulOp();
				setState(215);
				unaryExpr();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	 
		public UnaryExprContext() { }
		public void copyFrom(UnaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FallThroughAccessOrCallContext extends UnaryExprContext {
		public AccessOrCallContext accessOrCall() {
			return getRuleContext(AccessOrCallContext.class,0);
		}
		public FallThroughAccessOrCallContext(UnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFallThroughAccessOrCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedUnaryExprContext extends UnaryExprContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public NestedUnaryExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNestedUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unaryExpr);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__10:
			case TRUE:
			case FALSE:
			case ID:
			case INT:
				_localctx = new FallThroughAccessOrCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				accessOrCall(0);
				}
				break;
			case MINUS:
				_localctx = new NestedUnaryExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				unaryOp();
				setState(224);
				unaryExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessOrCallContext extends ParserRuleContext {
		public AccessOrCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessOrCall; }
	 
		public AccessOrCallContext() { }
		public void copyFrom(AccessOrCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FnCallContext extends AccessOrCallContext {
		public AccessOrCallContext accessOrCall() {
			return getRuleContext(AccessOrCallContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FnCallContext(AccessOrCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFnCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FallThroughBaseExprContext extends AccessOrCallContext {
		public BaseExprContext baseExpr() {
			return getRuleContext(BaseExprContext.class,0);
		}
		public FallThroughBaseExprContext(AccessOrCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFallThroughBaseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NamedFieldAccessContext extends AccessOrCallContext {
		public AccessOrCallContext accessOrCall() {
			return getRuleContext(AccessOrCallContext.class,0);
		}
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public NamedFieldAccessContext(AccessOrCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNamedFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessOrCallContext accessOrCall() throws RecognitionException {
		return accessOrCall(0);
	}

	private AccessOrCallContext accessOrCall(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AccessOrCallContext _localctx = new AccessOrCallContext(_ctx, _parentState);
		AccessOrCallContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_accessOrCall, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FallThroughBaseExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(229);
			baseExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(239);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new NamedFieldAccessContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(231);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(232);
						match(T__9);
						setState(233);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new FnCallContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(234);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(235);
						match(T__3);
						setState(236);
						exprList();
						setState(237);
						match(T__4);
						}
						break;
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BaseExprContext extends ParserRuleContext {
		public BaseExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseExpr; }
	 
		public BaseExprContext() { }
		public void copyFrom(BaseExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolConstContext extends BaseExprContext {
		public BoolValContext boolVal() {
			return getRuleContext(BoolValContext.class,0);
		}
		public BoolConstContext(BaseExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitBoolConst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumConstContext extends BaseExprContext {
		public TerminalNode INT() { return getToken(BrucelangParser.INT, 0); }
		public NumConstContext(BaseExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNumConst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableReferenceContext extends BaseExprContext {
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public VariableReferenceContext(BaseExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends BaseExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(BaseExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConstContext extends BaseExprContext {
		public TerminalNode STRING_CONST() { return getToken(BrucelangParser.STRING_CONST, 0); }
		public StringConstContext(BaseExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitStringConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseExprContext baseExpr() throws RecognitionException {
		BaseExprContext _localctx = new BaseExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_baseExpr);
		int _la;
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(T__3);
				setState(245);
				expr();
				setState(246);
				match(T__4);
				}
				break;
			case ID:
				_localctx = new VariableReferenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				match(ID);
				}
				break;
			case INT:
				_localctx = new NumConstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				match(INT);
				}
				break;
			case T__10:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				match(T__10);
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_CONST) {
					{
					setState(251);
					match(STRING_CONST);
					}
				}

				setState(254);
				match(T__10);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolConstContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(255);
				boolVal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(BrucelangParser.AND, 0); }
		public TerminalNode OR() { return getToken(BrucelangParser.OR, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitBoolOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(BrucelangParser.GT, 0); }
		public TerminalNode GTE() { return getToken(BrucelangParser.GTE, 0); }
		public TerminalNode LT() { return getToken(BrucelangParser.LT, 0); }
		public TerminalNode LTE() { return getToken(BrucelangParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(BrucelangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(BrucelangParser.NEQ, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LTE) | (1L << GT) | (1L << GTE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolValContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(BrucelangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BrucelangParser.FALSE, 0); }
		public BoolValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolVal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitBoolVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValContext boolVal() throws RecognitionException {
		BoolValContext _localctx = new BoolValContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_boolVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(BrucelangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BrucelangParser.MINUS, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(BrucelangParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(BrucelangParser.DIVIDE, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitMulOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_la = _input.LA(1);
			if ( !(_la==TIMES || _la==DIVIDE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(BrucelangParser.MINUS, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_unaryOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(MINUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return accessOrCall_sempred((AccessOrCallContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean accessOrCall_sempred(AccessOrCallContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0111\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4\3\4\3\5\3\5\7\5N\n\5\f\5\16\5Q\13"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6a\n\6\f"+
		"\6\16\6d\13\6\3\6\3\6\5\6h\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u0082\n\n"+
		"\f\n\16\n\u0085\13\n\5\n\u0087\n\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u008f\n\13\3\f\3\f\3\f\3\f\7\f\u0095\n\f\f\f\16\f\u0098\13\f\5\f\u009a"+
		"\n\f\3\r\3\r\3\r\3\r\7\r\u00a0\n\r\f\r\16\r\u00a3\13\r\5\r\u00a5\n\r\3"+
		"\16\3\16\5\16\u00a9\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00bf\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00c6\n\20\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00cd\n\21\3\22\3\22\3\22\3\22\7\22\u00d3\n\22\f\22\16\22\u00d6\13\22"+
		"\3\23\3\23\3\23\3\23\7\23\u00dc\n\23\f\23\16\23\u00df\13\23\3\24\3\24"+
		"\3\24\3\24\5\24\u00e5\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\7\25\u00f2\n\25\f\25\16\25\u00f5\13\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u00ff\n\26\3\26\3\26\5\26\u0103\n\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\2\3(\35\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\7\3\2\31\32"+
		"\3\2\37$\3\2\16\17\3\2\33\34\3\2\35\36\2\u0114\2;\3\2\2\2\4E\3\2\2\2\6"+
		"G\3\2\2\2\bK\3\2\2\2\nT\3\2\2\2\fi\3\2\2\2\16o\3\2\2\2\20y\3\2\2\2\22"+
		"\u0086\3\2\2\2\24\u008e\3\2\2\2\26\u0099\3\2\2\2\30\u00a4\3\2\2\2\32\u00a8"+
		"\3\2\2\2\34\u00be\3\2\2\2\36\u00c5\3\2\2\2 \u00cc\3\2\2\2\"\u00ce\3\2"+
		"\2\2$\u00d7\3\2\2\2&\u00e4\3\2\2\2(\u00e6\3\2\2\2*\u0102\3\2\2\2,\u0104"+
		"\3\2\2\2.\u0106\3\2\2\2\60\u0108\3\2\2\2\62\u010a\3\2\2\2\64\u010c\3\2"+
		"\2\2\66\u010e\3\2\2\28:\5\4\3\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2"+
		"\2<>\3\2\2\2=;\3\2\2\2>?\7\2\2\3?\3\3\2\2\2@F\5\b\5\2AF\5\16\b\2BF\5\f"+
		"\7\2CF\5\6\4\2DF\5\n\6\2E@\3\2\2\2EA\3\2\2\2EB\3\2\2\2EC\3\2\2\2ED\3\2"+
		"\2\2F\5\3\2\2\2GH\7\22\2\2HI\5\32\16\2IJ\7\3\2\2J\7\3\2\2\2KO\7\4\2\2"+
		"LN\5\4\3\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2"+
		"RS\7\5\2\2S\t\3\2\2\2TU\7\25\2\2UV\7\6\2\2VW\5\32\16\2WX\7\7\2\2Xb\5\b"+
		"\5\2YZ\7\26\2\2Z[\7\25\2\2[\\\7\6\2\2\\]\5\32\16\2]^\7\7\2\2^_\5\b\5\2"+
		"_a\3\2\2\2`Y\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cg\3\2\2\2db\3\2\2\2"+
		"ef\7\26\2\2fh\5\b\5\2ge\3\2\2\2gh\3\2\2\2h\13\3\2\2\2ij\7\27\2\2jk\5\20"+
		"\t\2kl\7\b\2\2lm\5\32\16\2mn\7\3\2\2n\r\3\2\2\2op\7\20\2\2pq\7%\2\2qr"+
		"\7\6\2\2rs\5\22\n\2st\7\7\2\2tu\7\t\2\2uv\5\24\13\2vw\7\23\2\2wx\5\b\5"+
		"\2x\17\3\2\2\2yz\7%\2\2z{\7\t\2\2{|\5\24\13\2|\21\3\2\2\2}\u0087\3\2\2"+
		"\2~\u0083\5\20\t\2\177\u0080\7\n\2\2\u0080\u0082\5\20\t\2\u0081\177\3"+
		"\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086}\3\2\2\2\u0086~\3\2\2\2\u0087"+
		"\23\3\2\2\2\u0088\u008f\7%\2\2\u0089\u008a\7%\2\2\u008a\u008b\7\37\2\2"+
		"\u008b\u008c\5\26\f\2\u008c\u008d\7!\2\2\u008d\u008f\3\2\2\2\u008e\u0088"+
		"\3\2\2\2\u008e\u0089\3\2\2\2\u008f\25\3\2\2\2\u0090\u009a\3\2\2\2\u0091"+
		"\u0096\5\24\13\2\u0092\u0093\7\n\2\2\u0093\u0095\5\24\13\2\u0094\u0092"+
		"\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u0090\3\2\2\2\u0099\u0091\3\2"+
		"\2\2\u009a\27\3\2\2\2\u009b\u00a5\3\2\2\2\u009c\u00a1\5\32\16\2\u009d"+
		"\u009e\7\n\2\2\u009e\u00a0\5\32\16\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3"+
		"\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4\u009b\3\2\2\2\u00a4\u009c\3\2\2\2\u00a5\31\3\2\2"+
		"\2\u00a6\u00a9\5\34\17\2\u00a7\u00a9\5\36\20\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\33\3\2\2\2\u00aa\u00ab\5\20\t\2\u00ab\u00ac\7\13"+
		"\2\2\u00ac\u00ad\5\b\5\2\u00ad\u00bf\3\2\2\2\u00ae\u00af\7\6\2\2\u00af"+
		"\u00b0\5\22\n\2\u00b0\u00b1\7\7\2\2\u00b1\u00b2\7\13\2\2\u00b2\u00b3\5"+
		"\b\5\2\u00b3\u00bf\3\2\2\2\u00b4\u00b5\5\20\t\2\u00b5\u00b6\7\13\2\2\u00b6"+
		"\u00b7\5\32\16\2\u00b7\u00bf\3\2\2\2\u00b8\u00b9\7\6\2\2\u00b9\u00ba\5"+
		"\22\n\2\u00ba\u00bb\7\7\2\2\u00bb\u00bc\7\13\2\2\u00bc\u00bd\5\32\16\2"+
		"\u00bd\u00bf\3\2\2\2\u00be\u00aa\3\2\2\2\u00be\u00ae\3\2\2\2\u00be\u00b4"+
		"\3\2\2\2\u00be\u00b8\3\2\2\2\u00bf\35\3\2\2\2\u00c0\u00c6\5 \21\2\u00c1"+
		"\u00c2\5 \21\2\u00c2\u00c3\5,\27\2\u00c3\u00c4\5 \21\2\u00c4\u00c6\3\2"+
		"\2\2\u00c5\u00c0\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c6\37\3\2\2\2\u00c7\u00cd"+
		"\5\"\22\2\u00c8\u00c9\5\"\22\2\u00c9\u00ca\5.\30\2\u00ca\u00cb\5\"\22"+
		"\2\u00cb\u00cd\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd!"+
		"\3\2\2\2\u00ce\u00d4\5$\23\2\u00cf\u00d0\5\62\32\2\u00d0\u00d1\5$\23\2"+
		"\u00d1\u00d3\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5#\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00dd\5&\24\2\u00d8\u00d9\5\64\33\2\u00d9\u00da\5&\24\2\u00da\u00dc\3"+
		"\2\2\2\u00db\u00d8\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de%\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e5\5(\25\2"+
		"\u00e1\u00e2\5\66\34\2\u00e2\u00e3\5&\24\2\u00e3\u00e5\3\2\2\2\u00e4\u00e0"+
		"\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e5\'\3\2\2\2\u00e6\u00e7\b\25\1\2\u00e7"+
		"\u00e8\5*\26\2\u00e8\u00f3\3\2\2\2\u00e9\u00ea\f\5\2\2\u00ea\u00eb\7\f"+
		"\2\2\u00eb\u00f2\7%\2\2\u00ec\u00ed\f\4\2\2\u00ed\u00ee\7\6\2\2\u00ee"+
		"\u00ef\5\30\r\2\u00ef\u00f0\7\7\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00e9\3"+
		"\2\2\2\u00f1\u00ec\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4)\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7\6\2\2"+
		"\u00f7\u00f8\5\32\16\2\u00f8\u00f9\7\7\2\2\u00f9\u0103\3\2\2\2\u00fa\u0103"+
		"\7%\2\2\u00fb\u0103\7&\2\2\u00fc\u00fe\7\r\2\2\u00fd\u00ff\7\30\2\2\u00fe"+
		"\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0103\7\r"+
		"\2\2\u0101\u0103\5\60\31\2\u0102\u00f6\3\2\2\2\u0102\u00fa\3\2\2\2\u0102"+
		"\u00fb\3\2\2\2\u0102\u00fc\3\2\2\2\u0102\u0101\3\2\2\2\u0103+\3\2\2\2"+
		"\u0104\u0105\t\2\2\2\u0105-\3\2\2\2\u0106\u0107\t\3\2\2\u0107/\3\2\2\2"+
		"\u0108\u0109\t\4\2\2\u0109\61\3\2\2\2\u010a\u010b\t\5\2\2\u010b\63\3\2"+
		"\2\2\u010c\u010d\t\6\2\2\u010d\65\3\2\2\2\u010e\u010f\7\34\2\2\u010f\67"+
		"\3\2\2\2\31;EObg\u0083\u0086\u008e\u0096\u0099\u00a1\u00a4\u00a8\u00be"+
		"\u00c5\u00cc\u00d4\u00dd\u00e4\u00f1\u00f3\u00fe\u0102";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}