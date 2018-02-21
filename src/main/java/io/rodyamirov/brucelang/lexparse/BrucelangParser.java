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
		TRUE=1, FALSE=2, DEFINE=3, DO=4, RETURN=5, AS=6, IS=7, IF=8, ELSE=9, LET=10, 
		AND=11, OR=12, PLUS=13, MINUS=14, TIMES=15, DIVIDE=16, LT=17, LTE=18, 
		GT=19, GTE=20, EQ=21, NEQ=22, SEMI=23, L_CURLY=24, R_CURLY=25, L_PAREN=26, 
		R_PAREN=27, ARROW=28, SET_EQ=29, COLON=30, COMMA=31, DOT=32, LINE_COMMENT=33, 
		BLOCK_COMMENT=34, ID=35, INT=36, STRING_CONST=37, ESC_SEQ=38, OCTAL_ESC=39, 
		UNICODE_ESC=40, HEX_DIGIT=41, WS=42;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_returnStmt = 2, RULE_doStmt = 3, 
		RULE_blockStmt = 4, RULE_ifStmt = 5, RULE_varDef = 6, RULE_fnDef = 7, 
		RULE_varDecl = 8, RULE_varDeclList = 9, RULE_typeExpr = 10, RULE_typeExprList = 11, 
		RULE_exprList = 12, RULE_expr = 13, RULE_lambda = 14, RULE_linkedBoolExpr = 15, 
		RULE_compExpr = 16, RULE_addExpr = 17, RULE_mulExpr = 18, RULE_unaryExpr = 19, 
		RULE_accessOrCall = 20, RULE_baseExpr = 21, RULE_boolOp = 22, RULE_compOp = 23, 
		RULE_boolVal = 24, RULE_addOp = 25, RULE_mulOp = 26, RULE_unaryOp = 27;
	public static final String[] ruleNames = {
		"program", "stmt", "returnStmt", "doStmt", "blockStmt", "ifStmt", "varDef", 
		"fnDef", "varDecl", "varDeclList", "typeExpr", "typeExprList", "exprList", 
		"expr", "lambda", "linkedBoolExpr", "compExpr", "addExpr", "mulExpr", 
		"unaryExpr", "accessOrCall", "baseExpr", "boolOp", "compOp", "boolVal", 
		"addOp", "mulOp", "unaryOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'true'", "'false'", "'define'", "'do'", "'return'", "'as'", "'is'", 
		"'if'", "'else'", "'let'", "'and'", "'or'", "'+'", "'-'", "'*'", "'/'", 
		"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "';'", "'{'", "'}'", "'('", 
		"')'", "'=>'", "'='", "':'", "','", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "DEFINE", "DO", "RETURN", "AS", "IS", "IF", "ELSE", 
		"LET", "AND", "OR", "PLUS", "MINUS", "TIMES", "DIVIDE", "LT", "LTE", "GT", 
		"GTE", "EQ", "NEQ", "SEMI", "L_CURLY", "R_CURLY", "L_PAREN", "R_PAREN", 
		"ARROW", "SET_EQ", "COLON", "COMMA", "DOT", "LINE_COMMENT", "BLOCK_COMMENT", 
		"ID", "INT", "STRING_CONST", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", "HEX_DIGIT", 
		"WS"
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << DO) | (1L << RETURN) | (1L << IF) | (1L << LET) | (1L << L_CURLY))) != 0)) {
				{
				{
				setState(56);
				stmt();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDefBranchContext extends StmtContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarDefBranchContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitVarDefBranch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoStmtBranchContext extends StmtContext {
		public DoStmtContext doStmt() {
			return getRuleContext(DoStmtContext.class,0);
		}
		public DoStmtBranchContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitDoStmtBranch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtBranchContext extends StmtContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public IfStmtBranchContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitIfStmtBranch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmtBranchContext extends StmtContext {
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public BlockStmtBranchContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitBlockStmtBranch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtBranchContext extends StmtContext {
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ReturnStmtBranchContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitReturnStmtBranch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FnDefBranchContext extends StmtContext {
		public FnDefContext fnDef() {
			return getRuleContext(FnDefContext.class,0);
		}
		public FnDefBranchContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFnDefBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CURLY:
				_localctx = new BlockStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				blockStmt();
				}
				break;
			case DEFINE:
				_localctx = new FnDefBranchContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				fnDef();
				}
				break;
			case LET:
				_localctx = new VarDefBranchContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				varDef();
				}
				break;
			case RETURN:
				_localctx = new ReturnStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				returnStmt();
				}
				break;
			case DO:
				_localctx = new DoStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				doStmt();
				}
				break;
			case IF:
				_localctx = new IfStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
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
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
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
			setState(72);
			match(RETURN);
			setState(73);
			expr();
			setState(74);
			match(SEMI);
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

	public static class DoStmtContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(BrucelangParser.DO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
		public DoStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitDoStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoStmtContext doStmt() throws RecognitionException {
		DoStmtContext _localctx = new DoStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_doStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(DO);
			setState(77);
			expr();
			setState(78);
			match(SEMI);
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
		public TerminalNode L_CURLY() { return getToken(BrucelangParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(BrucelangParser.R_CURLY, 0); }
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
		enterRule(_localctx, 8, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(L_CURLY);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << DO) | (1L << RETURN) | (1L << IF) | (1L << LET) | (1L << L_CURLY))) != 0)) {
				{
				{
				setState(81);
				stmt();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(R_CURLY);
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
		public List<TerminalNode> L_PAREN() { return getTokens(BrucelangParser.L_PAREN); }
		public TerminalNode L_PAREN(int i) {
			return getToken(BrucelangParser.L_PAREN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> R_PAREN() { return getTokens(BrucelangParser.R_PAREN); }
		public TerminalNode R_PAREN(int i) {
			return getToken(BrucelangParser.R_PAREN, i);
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
		enterRule(_localctx, 10, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(IF);
			setState(90);
			match(L_PAREN);
			setState(91);
			expr();
			setState(92);
			match(R_PAREN);
			setState(93);
			blockStmt();
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94);
					match(ELSE);
					setState(95);
					match(IF);
					setState(96);
					match(L_PAREN);
					setState(97);
					expr();
					setState(98);
					match(R_PAREN);
					setState(99);
					blockStmt();
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(106);
				match(ELSE);
				setState(107);
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
		public TerminalNode SET_EQ() { return getToken(BrucelangParser.SET_EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
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
		enterRule(_localctx, 12, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(LET);
			setState(111);
			varDecl();
			setState(112);
			match(SET_EQ);
			setState(113);
			expr();
			setState(114);
			match(SEMI);
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
		public TerminalNode L_PAREN() { return getToken(BrucelangParser.L_PAREN, 0); }
		public VarDeclListContext varDeclList() {
			return getRuleContext(VarDeclListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(BrucelangParser.R_PAREN, 0); }
		public TerminalNode COLON() { return getToken(BrucelangParser.COLON, 0); }
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
		enterRule(_localctx, 14, RULE_fnDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(DEFINE);
			setState(117);
			match(ID);
			setState(118);
			match(L_PAREN);
			setState(119);
			varDeclList();
			setState(120);
			match(R_PAREN);
			setState(121);
			match(COLON);
			setState(122);
			typeExpr();
			setState(123);
			match(AS);
			setState(124);
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
		public TerminalNode COLON() { return getToken(BrucelangParser.COLON, 0); }
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
		enterRule(_localctx, 16, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(ID);
			setState(127);
			match(COLON);
			setState(128);
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
		public List<TerminalNode> COMMA() { return getTokens(BrucelangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BrucelangParser.COMMA, i);
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
		enterRule(_localctx, 18, RULE_varDeclList);
		int _la;
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case R_PAREN:
				_localctx = new NoVarDeclsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				_localctx = new SomeVarDeclsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				varDecl();
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(132);
					match(COMMA);
					setState(133);
					varDecl();
					}
					}
					setState(138);
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
		public TerminalNode LT() { return getToken(BrucelangParser.LT, 0); }
		public TypeExprListContext typeExprList() {
			return getRuleContext(TypeExprListContext.class,0);
		}
		public TerminalNode GT() { return getToken(BrucelangParser.GT, 0); }
		public ComplexTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitComplexType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeExprContext typeExpr() throws RecognitionException {
		TypeExprContext _localctx = new TypeExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeExpr);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new SimpleTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ComplexTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(ID);
				setState(143);
				match(LT);
				setState(144);
				typeExprList();
				setState(145);
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
		public List<TerminalNode> COMMA() { return getTokens(BrucelangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BrucelangParser.COMMA, i);
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
		enterRule(_localctx, 22, RULE_typeExprList);
		int _la;
		try {
			setState(158);
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
				setState(150);
				typeExpr();
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(151);
					match(COMMA);
					setState(152);
					typeExpr();
					}
					}
					setState(157);
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
		public List<TerminalNode> COMMA() { return getTokens(BrucelangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BrucelangParser.COMMA, i);
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
		enterRule(_localctx, 24, RULE_exprList);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case R_PAREN:
				_localctx = new NoExprsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TRUE:
			case FALSE:
			case MINUS:
			case L_PAREN:
			case ID:
			case INT:
			case STRING_CONST:
				_localctx = new SomeExprsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				expr();
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(162);
					match(COMMA);
					setState(163);
					expr();
					}
					}
					setState(168);
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
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new LambdaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				lambda();
				}
				break;
			case 2:
				_localctx = new BooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
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
		public TerminalNode ARROW() { return getToken(BrucelangParser.ARROW, 0); }
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
		public TerminalNode L_PAREN() { return getToken(BrucelangParser.L_PAREN, 0); }
		public VarDeclListContext varDeclList() {
			return getRuleContext(VarDeclListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(BrucelangParser.R_PAREN, 0); }
		public TerminalNode ARROW() { return getToken(BrucelangParser.ARROW, 0); }
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
		public TerminalNode ARROW() { return getToken(BrucelangParser.ARROW, 0); }
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
		public TerminalNode L_PAREN() { return getToken(BrucelangParser.L_PAREN, 0); }
		public VarDeclListContext varDeclList() {
			return getRuleContext(VarDeclListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(BrucelangParser.R_PAREN, 0); }
		public TerminalNode ARROW() { return getToken(BrucelangParser.ARROW, 0); }
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
		enterRule(_localctx, 28, RULE_lambda);
		try {
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new OneArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				varDecl();
				setState(176);
				match(ARROW);
				setState(177);
				blockStmt();
				}
				break;
			case 2:
				_localctx = new MultiArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(L_PAREN);
				setState(180);
				varDeclList();
				setState(181);
				match(R_PAREN);
				setState(182);
				match(ARROW);
				setState(183);
				blockStmt();
				}
				break;
			case 3:
				_localctx = new OneArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				varDecl();
				setState(186);
				match(ARROW);
				setState(187);
				expr();
				}
				break;
			case 4:
				_localctx = new MultiArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(189);
				match(L_PAREN);
				setState(190);
				varDeclList();
				setState(191);
				match(R_PAREN);
				setState(192);
				match(ARROW);
				setState(193);
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
		enterRule(_localctx, 30, RULE_linkedBoolExpr);
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new FallThroughCompExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				compExpr();
				}
				break;
			case 2:
				_localctx = new BoolOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				compExpr();
				setState(199);
				boolOp();
				setState(200);
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
		enterRule(_localctx, 32, RULE_compExpr);
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new FallThroughAddExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				addExpr();
				}
				break;
			case 2:
				_localctx = new CompOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				addExpr();
				setState(206);
				compOp();
				setState(207);
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
		enterRule(_localctx, 34, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			mulExpr();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(212);
				addOp();
				setState(213);
				mulExpr();
				}
				}
				setState(219);
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
		enterRule(_localctx, 36, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			unaryExpr();
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIVIDE) {
				{
				{
				setState(221);
				mulOp();
				setState(222);
				unaryExpr();
				}
				}
				setState(228);
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
		enterRule(_localctx, 38, RULE_unaryExpr);
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case L_PAREN:
			case ID:
			case INT:
			case STRING_CONST:
				_localctx = new FallThroughAccessOrCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				accessOrCall(0);
				}
				break;
			case MINUS:
				_localctx = new NestedUnaryExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				unaryOp();
				setState(231);
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
		public TerminalNode L_PAREN() { return getToken(BrucelangParser.L_PAREN, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(BrucelangParser.R_PAREN, 0); }
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
		public TerminalNode DOT() { return getToken(BrucelangParser.DOT, 0); }
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_accessOrCall, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FallThroughBaseExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(236);
			baseExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new NamedFieldAccessContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(238);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(239);
						match(DOT);
						setState(240);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new FnCallContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(241);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(242);
						match(L_PAREN);
						setState(243);
						exprList();
						setState(244);
						match(R_PAREN);
						}
						break;
					}
					} 
				}
				setState(250);
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
		public TerminalNode L_PAREN() { return getToken(BrucelangParser.L_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(BrucelangParser.R_PAREN, 0); }
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
		enterRule(_localctx, 42, RULE_baseExpr);
		try {
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_PAREN:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(L_PAREN);
				setState(252);
				expr();
				setState(253);
				match(R_PAREN);
				}
				break;
			case ID:
				_localctx = new VariableReferenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(ID);
				}
				break;
			case INT:
				_localctx = new NumConstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(INT);
				}
				break;
			case STRING_CONST:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				match(STRING_CONST);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolConstContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
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
		enterRule(_localctx, 44, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
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
		enterRule(_localctx, 46, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
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
		enterRule(_localctx, 48, RULE_boolVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
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
		enterRule(_localctx, 50, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
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
		enterRule(_localctx, 52, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
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
		enterRule(_localctx, 54, RULE_unaryOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
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
		case 20:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3I\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\7\6U\n\6\f\6\16\6X\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7h\n\7\f\7\16\7k\13\7\3\7\3\7\5\7o\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c\13\13\5\13\u008e"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0096\n\f\3\r\3\r\3\r\3\r\7\r\u009c"+
		"\n\r\f\r\16\r\u009f\13\r\5\r\u00a1\n\r\3\16\3\16\3\16\3\16\7\16\u00a7"+
		"\n\16\f\16\16\16\u00aa\13\16\5\16\u00ac\n\16\3\17\3\17\5\17\u00b0\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c6\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00cd\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u00d4\n\22\3\23\3\23\3"+
		"\23\3\23\7\23\u00da\n\23\f\23\16\23\u00dd\13\23\3\24\3\24\3\24\3\24\7"+
		"\24\u00e3\n\24\f\24\16\24\u00e6\13\24\3\25\3\25\3\25\3\25\5\25\u00ec\n"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00f9"+
		"\n\26\f\26\16\26\u00fc\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5"+
		"\27\u0106\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\35\2\3*\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668\2\7\3\2\r\16\3\2\23\30\3\2\3\4\3\2\17\20\3\2\21\22\2\u0116"+
		"\2=\3\2\2\2\4H\3\2\2\2\6J\3\2\2\2\bN\3\2\2\2\nR\3\2\2\2\f[\3\2\2\2\16"+
		"p\3\2\2\2\20v\3\2\2\2\22\u0080\3\2\2\2\24\u008d\3\2\2\2\26\u0095\3\2\2"+
		"\2\30\u00a0\3\2\2\2\32\u00ab\3\2\2\2\34\u00af\3\2\2\2\36\u00c5\3\2\2\2"+
		" \u00cc\3\2\2\2\"\u00d3\3\2\2\2$\u00d5\3\2\2\2&\u00de\3\2\2\2(\u00eb\3"+
		"\2\2\2*\u00ed\3\2\2\2,\u0105\3\2\2\2.\u0107\3\2\2\2\60\u0109\3\2\2\2\62"+
		"\u010b\3\2\2\2\64\u010d\3\2\2\2\66\u010f\3\2\2\28\u0111\3\2\2\2:<\5\4"+
		"\3\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\2"+
		"\2\3A\3\3\2\2\2BI\5\n\6\2CI\5\20\t\2DI\5\16\b\2EI\5\6\4\2FI\5\b\5\2GI"+
		"\5\f\7\2HB\3\2\2\2HC\3\2\2\2HD\3\2\2\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2I"+
		"\5\3\2\2\2JK\7\7\2\2KL\5\34\17\2LM\7\31\2\2M\7\3\2\2\2NO\7\6\2\2OP\5\34"+
		"\17\2PQ\7\31\2\2Q\t\3\2\2\2RV\7\32\2\2SU\5\4\3\2TS\3\2\2\2UX\3\2\2\2V"+
		"T\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\33\2\2Z\13\3\2\2\2[\\\7\n"+
		"\2\2\\]\7\34\2\2]^\5\34\17\2^_\7\35\2\2_i\5\n\6\2`a\7\13\2\2ab\7\n\2\2"+
		"bc\7\34\2\2cd\5\34\17\2de\7\35\2\2ef\5\n\6\2fh\3\2\2\2g`\3\2\2\2hk\3\2"+
		"\2\2ig\3\2\2\2ij\3\2\2\2jn\3\2\2\2ki\3\2\2\2lm\7\13\2\2mo\5\n\6\2nl\3"+
		"\2\2\2no\3\2\2\2o\r\3\2\2\2pq\7\f\2\2qr\5\22\n\2rs\7\37\2\2st\5\34\17"+
		"\2tu\7\31\2\2u\17\3\2\2\2vw\7\5\2\2wx\7%\2\2xy\7\34\2\2yz\5\24\13\2z{"+
		"\7\35\2\2{|\7 \2\2|}\5\26\f\2}~\7\b\2\2~\177\5\n\6\2\177\21\3\2\2\2\u0080"+
		"\u0081\7%\2\2\u0081\u0082\7 \2\2\u0082\u0083\5\26\f\2\u0083\23\3\2\2\2"+
		"\u0084\u008e\3\2\2\2\u0085\u008a\5\22\n\2\u0086\u0087\7!\2\2\u0087\u0089"+
		"\5\22\n\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2"+
		"\u008a\u008b\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0084"+
		"\3\2\2\2\u008d\u0085\3\2\2\2\u008e\25\3\2\2\2\u008f\u0096\7%\2\2\u0090"+
		"\u0091\7%\2\2\u0091\u0092\7\23\2\2\u0092\u0093\5\30\r\2\u0093\u0094\7"+
		"\25\2\2\u0094\u0096\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0090\3\2\2\2\u0096"+
		"\27\3\2\2\2\u0097\u00a1\3\2\2\2\u0098\u009d\5\26\f\2\u0099\u009a\7!\2"+
		"\2\u009a\u009c\5\26\f\2\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u00a0\u0097\3\2\2\2\u00a0\u0098\3\2\2\2\u00a1\31\3\2\2\2\u00a2\u00ac"+
		"\3\2\2\2\u00a3\u00a8\5\34\17\2\u00a4\u00a5\7!\2\2\u00a5\u00a7\5\34\17"+
		"\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00a2\3\2\2\2\u00ab"+
		"\u00a3\3\2\2\2\u00ac\33\3\2\2\2\u00ad\u00b0\5\36\20\2\u00ae\u00b0\5 \21"+
		"\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\35\3\2\2\2\u00b1\u00b2"+
		"\5\22\n\2\u00b2\u00b3\7\36\2\2\u00b3\u00b4\5\n\6\2\u00b4\u00c6\3\2\2\2"+
		"\u00b5\u00b6\7\34\2\2\u00b6\u00b7\5\24\13\2\u00b7\u00b8\7\35\2\2\u00b8"+
		"\u00b9\7\36\2\2\u00b9\u00ba\5\n\6\2\u00ba\u00c6\3\2\2\2\u00bb\u00bc\5"+
		"\22\n\2\u00bc\u00bd\7\36\2\2\u00bd\u00be\5\34\17\2\u00be\u00c6\3\2\2\2"+
		"\u00bf\u00c0\7\34\2\2\u00c0\u00c1\5\24\13\2\u00c1\u00c2\7\35\2\2\u00c2"+
		"\u00c3\7\36\2\2\u00c3\u00c4\5\34\17\2\u00c4\u00c6\3\2\2\2\u00c5\u00b1"+
		"\3\2\2\2\u00c5\u00b5\3\2\2\2\u00c5\u00bb\3\2\2\2\u00c5\u00bf\3\2\2\2\u00c6"+
		"\37\3\2\2\2\u00c7\u00cd\5\"\22\2\u00c8\u00c9\5\"\22\2\u00c9\u00ca\5.\30"+
		"\2\u00ca\u00cb\5\"\22\2\u00cb\u00cd\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc"+
		"\u00c8\3\2\2\2\u00cd!\3\2\2\2\u00ce\u00d4\5$\23\2\u00cf\u00d0\5$\23\2"+
		"\u00d0\u00d1\5\60\31\2\u00d1\u00d2\5$\23\2\u00d2\u00d4\3\2\2\2\u00d3\u00ce"+
		"\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d4#\3\2\2\2\u00d5\u00db\5&\24\2\u00d6"+
		"\u00d7\5\64\33\2\u00d7\u00d8\5&\24\2\u00d8\u00da\3\2\2\2\u00d9\u00d6\3"+
		"\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"%\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e4\5(\25\2\u00df\u00e0\5\66\34"+
		"\2\u00e0\u00e1\5(\25\2\u00e1\u00e3\3\2\2\2\u00e2\u00df\3\2\2\2\u00e3\u00e6"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\'\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e7\u00ec\5*\26\2\u00e8\u00e9\58\35\2\u00e9\u00ea\5("+
		"\25\2\u00ea\u00ec\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00e8\3\2\2\2\u00ec"+
		")\3\2\2\2\u00ed\u00ee\b\26\1\2\u00ee\u00ef\5,\27\2\u00ef\u00fa\3\2\2\2"+
		"\u00f0\u00f1\f\5\2\2\u00f1\u00f2\7\"\2\2\u00f2\u00f9\7%\2\2\u00f3\u00f4"+
		"\f\4\2\2\u00f4\u00f5\7\34\2\2\u00f5\u00f6\5\32\16\2\u00f6\u00f7\7\35\2"+
		"\2\u00f7\u00f9\3\2\2\2\u00f8\u00f0\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f9\u00fc"+
		"\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb+\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fd\u00fe\7\34\2\2\u00fe\u00ff\5\34\17\2\u00ff\u0100"+
		"\7\35\2\2\u0100\u0106\3\2\2\2\u0101\u0106\7%\2\2\u0102\u0106\7&\2\2\u0103"+
		"\u0106\7\'\2\2\u0104\u0106\5\62\32\2\u0105\u00fd\3\2\2\2\u0105\u0101\3"+
		"\2\2\2\u0105\u0102\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106"+
		"-\3\2\2\2\u0107\u0108\t\2\2\2\u0108/\3\2\2\2\u0109\u010a\t\3\2\2\u010a"+
		"\61\3\2\2\2\u010b\u010c\t\4\2\2\u010c\63\3\2\2\2\u010d\u010e\t\5\2\2\u010e"+
		"\65\3\2\2\2\u010f\u0110\t\6\2\2\u0110\67\3\2\2\2\u0111\u0112\7\20\2\2"+
		"\u01129\3\2\2\2\30=HVin\u008a\u008d\u0095\u009d\u00a0\u00a8\u00ab\u00af"+
		"\u00c5\u00cc\u00d3\u00db\u00e4\u00eb\u00f8\u00fa\u0105";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}