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
		T__9=10, TRUE=11, FALSE=12, DEFINE=13, DO=14, RETURN=15, AS=16, IS=17, 
		IF=18, ELSE=19, LET=20, STRING_CONST=21, AND=22, OR=23, PLUS=24, MINUS=25, 
		TIMES=26, DIVIDE=27, LT=28, LTE=29, GT=30, GTE=31, EQ=32, NEQ=33, ID=34, 
		INT=35, WS=36;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_returnStmt = 2, RULE_blockStmt = 3, 
		RULE_ifStmt = 4, RULE_varDef = 5, RULE_fnDef = 6, RULE_idList = 7, RULE_exprList = 8, 
		RULE_expr = 9, RULE_lambda = 10, RULE_boolExpr = 11, RULE_addExpr = 12, 
		RULE_mulExpr = 13, RULE_unaryExpr = 14, RULE_accessOrCall = 15, RULE_baseExpr = 16, 
		RULE_boolOp = 17, RULE_compOp = 18, RULE_boolVal = 19, RULE_addOp = 20, 
		RULE_mulOp = 21, RULE_unaryOp = 22;
	public static final String[] ruleNames = {
		"program", "stmt", "returnStmt", "blockStmt", "ifStmt", "varDef", "fnDef", 
		"idList", "exprList", "expr", "lambda", "boolExpr", "addExpr", "mulExpr", 
		"unaryExpr", "accessOrCall", "baseExpr", "boolOp", "compOp", "boolVal", 
		"addOp", "mulOp", "unaryOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'{'", "'}'", "'('", "')'", "'='", "','", "'=>'", "'.'", 
		"'\"'", "'true'", "'false'", "'define'", "'do'", "'return'", "'as'", "'is'", 
		"'if'", "'else'", "'let'", null, "'and'", "'or'", "'+'", "'-'", "'*'", 
		"'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "TRUE", 
		"FALSE", "DEFINE", "DO", "RETURN", "AS", "IS", "IF", "ELSE", "LET", "STRING_CONST", 
		"AND", "OR", "PLUS", "MINUS", "TIMES", "DIVIDE", "LT", "LTE", "GT", "GTE", 
		"EQ", "NEQ", "ID", "INT", "WS"
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << DEFINE) | (1L << RETURN) | (1L << IF) | (1L << LET))) != 0)) {
				{
				{
				setState(46);
				stmt();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				blockStmt();
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				fnDef();
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				varDef();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				returnStmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
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
			setState(61);
			match(RETURN);
			setState(62);
			expr();
			setState(63);
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
			setState(65);
			match(T__1);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << DEFINE) | (1L << RETURN) | (1L << IF) | (1L << LET))) != 0)) {
				{
				{
				setState(66);
				stmt();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
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
			setState(74);
			match(IF);
			setState(75);
			match(T__3);
			setState(76);
			expr();
			setState(77);
			match(T__4);
			setState(78);
			blockStmt();
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(79);
					match(ELSE);
					setState(80);
					match(IF);
					setState(81);
					match(T__3);
					setState(82);
					expr();
					setState(83);
					match(T__4);
					setState(84);
					blockStmt();
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(91);
				match(ELSE);
				setState(92);
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
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
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
			setState(95);
			match(LET);
			setState(96);
			match(ID);
			setState(97);
			match(T__5);
			setState(98);
			expr();
			setState(99);
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
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
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
			setState(101);
			match(DEFINE);
			setState(102);
			match(ID);
			setState(103);
			match(T__3);
			setState(104);
			idList();
			setState(105);
			match(T__4);
			setState(106);
			match(AS);
			setState(107);
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

	public static class IdListContext extends ParserRuleContext {
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
	 
		public IdListContext() { }
		public void copyFrom(IdListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SomeIdsContext extends IdListContext {
		public List<TerminalNode> ID() { return getTokens(BrucelangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BrucelangParser.ID, i);
		}
		public SomeIdsContext(IdListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitSomeIds(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoIdsContext extends IdListContext {
		public NoIdsContext(IdListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNoIds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_idList);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new NoIdsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				_localctx = new SomeIdsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(ID);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(111);
					match(T__6);
					setState(112);
					match(ID);
					}
					}
					setState(117);
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
		enterRule(_localctx, 16, RULE_exprList);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new NoExprsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__3:
			case T__9:
			case TRUE:
			case FALSE:
			case MINUS:
			case ID:
			case INT:
				_localctx = new SomeExprsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				expr();
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(122);
					match(T__6);
					setState(123);
					expr();
					}
					}
					setState(128);
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
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
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
		enterRule(_localctx, 18, RULE_expr);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new LambdaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				lambda();
				}
				break;
			case 2:
				_localctx = new BooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				boolExpr();
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
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
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
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
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
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
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
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
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
		enterRule(_localctx, 20, RULE_lambda);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new OneArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(ID);
				setState(136);
				match(T__7);
				setState(137);
				blockStmt();
				}
				break;
			case 2:
				_localctx = new MultiArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(T__3);
				setState(139);
				idList();
				setState(140);
				match(T__4);
				setState(141);
				match(T__7);
				setState(142);
				blockStmt();
				}
				break;
			case 3:
				_localctx = new OneArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				match(ID);
				setState(145);
				match(T__7);
				setState(146);
				expr();
				}
				break;
			case 4:
				_localctx = new MultiArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				match(T__3);
				setState(148);
				idList();
				setState(149);
				match(T__4);
				setState(150);
				match(T__7);
				setState(151);
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

	public static class BoolExprContext extends ParserRuleContext {
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
	 
		public BoolExprContext() { }
		public void copyFrom(BoolExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FallThroughAddExprContext extends BoolExprContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public FallThroughAddExprContext(BoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFallThroughAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolOpExprContext extends BoolExprContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public BoolOpExprContext(BoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitBoolOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_boolExpr);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new FallThroughAddExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				addExpr();
				}
				break;
			case 2:
				_localctx = new BoolOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				addExpr();
				setState(157);
				boolOp();
				setState(158);
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
		enterRule(_localctx, 24, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			mulExpr();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(163);
				addOp();
				setState(164);
				mulExpr();
				}
				}
				setState(170);
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
		enterRule(_localctx, 26, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			unaryExpr();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIVIDE) {
				{
				{
				setState(172);
				mulOp();
				setState(173);
				unaryExpr();
				}
				}
				setState(179);
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
		enterRule(_localctx, 28, RULE_unaryExpr);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__9:
			case TRUE:
			case FALSE:
			case ID:
			case INT:
				_localctx = new FallThroughAccessOrCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				accessOrCall(0);
				}
				break;
			case MINUS:
				_localctx = new NestedUnaryExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				unaryOp();
				setState(182);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_accessOrCall, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FallThroughBaseExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(187);
			baseExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new NamedFieldAccessContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(189);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(190);
						match(T__8);
						setState(191);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new FnCallContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(192);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(193);
						match(T__3);
						setState(194);
						exprList();
						setState(195);
						match(T__4);
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		enterRule(_localctx, 32, RULE_baseExpr);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(T__3);
				setState(203);
				expr();
				setState(204);
				match(T__4);
				}
				break;
			case ID:
				_localctx = new VariableReferenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(ID);
				}
				break;
			case INT:
				_localctx = new NumConstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(INT);
				}
				break;
			case T__9:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				match(T__9);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_CONST) {
					{
					setState(209);
					match(STRING_CONST);
					}
				}

				setState(212);
				match(T__9);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolConstContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
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
		enterRule(_localctx, 34, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
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
		enterRule(_localctx, 36, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
		enterRule(_localctx, 38, RULE_boolVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
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
		enterRule(_localctx, 40, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
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
		enterRule(_localctx, 42, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
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
		enterRule(_localctx, 44, RULE_unaryOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
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
		case 15:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00e7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\7\5F\n\5\f\5\16\5I\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\6\3\6\5\6`\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7\t"+
		"t\n\t\f\t\16\tw\13\t\5\ty\n\t\3\n\3\n\3\n\3\n\7\n\177\n\n\f\n\16\n\u0082"+
		"\13\n\5\n\u0084\n\n\3\13\3\13\5\13\u0088\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009c\n\f\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u00a3\n\r\3\16\3\16\3\16\3\16\7\16\u00a9\n\16\f\16\16"+
		"\16\u00ac\13\16\3\17\3\17\3\17\3\17\7\17\u00b2\n\17\f\17\16\17\u00b5\13"+
		"\17\3\20\3\20\3\20\3\20\5\20\u00bb\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u00c8\n\21\f\21\16\21\u00cb\13\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00d5\n\22\3\22\3\22\5\22\u00d9"+
		"\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\2\3 \31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\7\3\2\30\31"+
		"\3\2\36#\3\2\r\16\3\2\32\33\3\2\34\35\2\u00ea\2\63\3\2\2\2\4=\3\2\2\2"+
		"\6?\3\2\2\2\bC\3\2\2\2\nL\3\2\2\2\fa\3\2\2\2\16g\3\2\2\2\20x\3\2\2\2\22"+
		"\u0083\3\2\2\2\24\u0087\3\2\2\2\26\u009b\3\2\2\2\30\u00a2\3\2\2\2\32\u00a4"+
		"\3\2\2\2\34\u00ad\3\2\2\2\36\u00ba\3\2\2\2 \u00bc\3\2\2\2\"\u00d8\3\2"+
		"\2\2$\u00da\3\2\2\2&\u00dc\3\2\2\2(\u00de\3\2\2\2*\u00e0\3\2\2\2,\u00e2"+
		"\3\2\2\2.\u00e4\3\2\2\2\60\62\5\4\3\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61"+
		"\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\2\2\3\67\3"+
		"\3\2\2\28>\5\b\5\29>\5\16\b\2:>\5\f\7\2;>\5\6\4\2<>\5\n\6\2=8\3\2\2\2"+
		"=9\3\2\2\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\5\3\2\2\2?@\7\21\2\2@A\5\24"+
		"\13\2AB\7\3\2\2B\7\3\2\2\2CG\7\4\2\2DF\5\4\3\2ED\3\2\2\2FI\3\2\2\2GE\3"+
		"\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\5\2\2K\t\3\2\2\2LM\7\24\2\2M"+
		"N\7\6\2\2NO\5\24\13\2OP\7\7\2\2PZ\5\b\5\2QR\7\25\2\2RS\7\24\2\2ST\7\6"+
		"\2\2TU\5\24\13\2UV\7\7\2\2VW\5\b\5\2WY\3\2\2\2XQ\3\2\2\2Y\\\3\2\2\2ZX"+
		"\3\2\2\2Z[\3\2\2\2[_\3\2\2\2\\Z\3\2\2\2]^\7\25\2\2^`\5\b\5\2_]\3\2\2\2"+
		"_`\3\2\2\2`\13\3\2\2\2ab\7\26\2\2bc\7$\2\2cd\7\b\2\2de\5\24\13\2ef\7\3"+
		"\2\2f\r\3\2\2\2gh\7\17\2\2hi\7$\2\2ij\7\6\2\2jk\5\20\t\2kl\7\7\2\2lm\7"+
		"\22\2\2mn\5\b\5\2n\17\3\2\2\2oy\3\2\2\2pu\7$\2\2qr\7\t\2\2rt\7$\2\2sq"+
		"\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2\2xo\3\2\2\2x"+
		"p\3\2\2\2y\21\3\2\2\2z\u0084\3\2\2\2{\u0080\5\24\13\2|}\7\t\2\2}\177\5"+
		"\24\13\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083z\3\2\2\2\u0083{\3\2\2"+
		"\2\u0084\23\3\2\2\2\u0085\u0088\5\26\f\2\u0086\u0088\5\30\r\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0086\3\2\2\2\u0088\25\3\2\2\2\u0089\u008a\7$\2\2\u008a"+
		"\u008b\7\n\2\2\u008b\u009c\5\b\5\2\u008c\u008d\7\6\2\2\u008d\u008e\5\20"+
		"\t\2\u008e\u008f\7\7\2\2\u008f\u0090\7\n\2\2\u0090\u0091\5\b\5\2\u0091"+
		"\u009c\3\2\2\2\u0092\u0093\7$\2\2\u0093\u0094\7\n\2\2\u0094\u009c\5\24"+
		"\13\2\u0095\u0096\7\6\2\2\u0096\u0097\5\20\t\2\u0097\u0098\7\7\2\2\u0098"+
		"\u0099\7\n\2\2\u0099\u009a\5\24\13\2\u009a\u009c\3\2\2\2\u009b\u0089\3"+
		"\2\2\2\u009b\u008c\3\2\2\2\u009b\u0092\3\2\2\2\u009b\u0095\3\2\2\2\u009c"+
		"\27\3\2\2\2\u009d\u00a3\5\32\16\2\u009e\u009f\5\32\16\2\u009f\u00a0\5"+
		"$\23\2\u00a0\u00a1\5\32\16\2\u00a1\u00a3\3\2\2\2\u00a2\u009d\3\2\2\2\u00a2"+
		"\u009e\3\2\2\2\u00a3\31\3\2\2\2\u00a4\u00aa\5\34\17\2\u00a5\u00a6\5*\26"+
		"\2\u00a6\u00a7\5\34\17\2\u00a7\u00a9\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\33\3\2\2"+
		"\2\u00ac\u00aa\3\2\2\2\u00ad\u00b3\5\36\20\2\u00ae\u00af\5,\27\2\u00af"+
		"\u00b0\5\36\20\2\u00b0\u00b2\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b2\u00b5\3"+
		"\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\35\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\u00bb\5 \21\2\u00b7\u00b8\5.\30\2\u00b8\u00b9\5\36"+
		"\20\2\u00b9\u00bb\3\2\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7\3\2\2\2\u00bb"+
		"\37\3\2\2\2\u00bc\u00bd\b\21\1\2\u00bd\u00be\5\"\22\2\u00be\u00c9\3\2"+
		"\2\2\u00bf\u00c0\f\5\2\2\u00c0\u00c1\7\13\2\2\u00c1\u00c8\7$\2\2\u00c2"+
		"\u00c3\f\4\2\2\u00c3\u00c4\7\6\2\2\u00c4\u00c5\5\22\n\2\u00c5\u00c6\7"+
		"\7\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c8"+
		"\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca!\3\2\2\2"+
		"\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\6\2\2\u00cd\u00ce\5\24\13\2\u00ce\u00cf"+
		"\7\7\2\2\u00cf\u00d9\3\2\2\2\u00d0\u00d9\7$\2\2\u00d1\u00d9\7%\2\2\u00d2"+
		"\u00d4\7\f\2\2\u00d3\u00d5\7\27\2\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3"+
		"\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d9\7\f\2\2\u00d7\u00d9\5(\25\2\u00d8"+
		"\u00cc\3\2\2\2\u00d8\u00d0\3\2\2\2\u00d8\u00d1\3\2\2\2\u00d8\u00d2\3\2"+
		"\2\2\u00d8\u00d7\3\2\2\2\u00d9#\3\2\2\2\u00da\u00db\t\2\2\2\u00db%\3\2"+
		"\2\2\u00dc\u00dd\t\3\2\2\u00dd\'\3\2\2\2\u00de\u00df\t\4\2\2\u00df)\3"+
		"\2\2\2\u00e0\u00e1\t\5\2\2\u00e1+\3\2\2\2\u00e2\u00e3\t\6\2\2\u00e3-\3"+
		"\2\2\2\u00e4\u00e5\7\33\2\2\u00e5/\3\2\2\2\25\63=GZ_ux\u0080\u0083\u0087"+
		"\u009b\u00a2\u00aa\u00b3\u00ba\u00c7\u00c9\u00d4\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}