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
		BOOL_OP=1, COMP_OP=2, BOOL_VAL=3, ADD_OP=4, MUL_OP=5, UNARY_OP=6, TRUE=7, 
		FALSE=8, DECLARE=9, NATIVE=10, DEFINE=11, DO=12, RETURN=13, AS=14, IS=15, 
		IF=16, ELSE=17, LET=18, TYPE=19, FN=20, AND=21, OR=22, PLUS=23, MINUS=24, 
		TIMES=25, DIVIDE=26, LT=27, LTE=28, GT=29, GTE=30, EQ=31, NEQ=32, NOT=33, 
		SEMI=34, L_CURLY=35, R_CURLY=36, L_PAREN=37, R_PAREN=38, SM_ARROW=39, 
		BIG_ARROW=40, SET_EQ=41, COLON=42, COMMA=43, DOT=44, LINE_COMMENT=45, 
		BLOCK_COMMENT=46, ID=47, INT=48, STRING_CONST=49, ESC_SEQ=50, OCTAL_ESC=51, 
		UNICODE_ESC=52, HEX_DIGIT=53, WS=54;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_nativeDeclStmt = 2, RULE_typeDefnStmt = 3, 
		RULE_fieldDecl = 4, RULE_returnStmt = 5, RULE_doStmt = 6, RULE_blockStmt = 7, 
		RULE_ifStmt = 8, RULE_varDef = 9, RULE_fnDef = 10, RULE_varDecl = 11, 
		RULE_inferredVarDecl = 12, RULE_varDeclList = 13, RULE_typeExpr = 14, 
		RULE_typeExprList = 15, RULE_exprList = 16, RULE_expr = 17, RULE_lambda = 18, 
		RULE_linkedBoolExpr = 19, RULE_compExpr = 20, RULE_addExpr = 21, RULE_mulExpr = 22, 
		RULE_unaryExpr = 23, RULE_accessOrCall = 24, RULE_baseExpr = 25;
	public static final String[] ruleNames = {
		"program", "stmt", "nativeDeclStmt", "typeDefnStmt", "fieldDecl", "returnStmt", 
		"doStmt", "blockStmt", "ifStmt", "varDef", "fnDef", "varDecl", "inferredVarDecl", 
		"varDeclList", "typeExpr", "typeExprList", "exprList", "expr", "lambda", 
		"linkedBoolExpr", "compExpr", "addExpr", "mulExpr", "unaryExpr", "accessOrCall", 
		"baseExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'true'", "'false'", "'declare'", 
		"'native'", "'define'", "'do'", "'return'", "'as'", "'is'", "'if'", "'else'", 
		"'let'", "'type'", "'Fn'", "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", 
		"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'!'", "';'", "'{'", "'}'", 
		"'('", "')'", "'->'", "'=>'", "'='", "':'", "','", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOL_OP", "COMP_OP", "BOOL_VAL", "ADD_OP", "MUL_OP", "UNARY_OP", 
		"TRUE", "FALSE", "DECLARE", "NATIVE", "DEFINE", "DO", "RETURN", "AS", 
		"IS", "IF", "ELSE", "LET", "TYPE", "FN", "AND", "OR", "PLUS", "MINUS", 
		"TIMES", "DIVIDE", "LT", "LTE", "GT", "GTE", "EQ", "NEQ", "NOT", "SEMI", 
		"L_CURLY", "R_CURLY", "L_PAREN", "R_PAREN", "SM_ARROW", "BIG_ARROW", "SET_EQ", 
		"COLON", "COMMA", "DOT", "LINE_COMMENT", "BLOCK_COMMENT", "ID", "INT", 
		"STRING_CONST", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", "HEX_DIGIT", "WS"
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
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECLARE) | (1L << DEFINE) | (1L << DO) | (1L << RETURN) | (1L << IF) | (1L << LET) | (1L << L_CURLY))) != 0)) {
				{
				{
				setState(52);
				stmt();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
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
	public static class NativeDeclStmtBranchContext extends StmtContext {
		public NativeDeclStmtContext nativeDeclStmt() {
			return getRuleContext(NativeDeclStmtContext.class,0);
		}
		public NativeDeclStmtBranchContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNativeDeclStmtBranch(this);
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
	public static class TypeDefnStmtBranchContext extends StmtContext {
		public TypeDefnStmtContext typeDefnStmt() {
			return getRuleContext(TypeDefnStmtContext.class,0);
		}
		public TypeDefnStmtBranchContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitTypeDefnStmtBranch(this);
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new BlockStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				blockStmt();
				}
				break;
			case 2:
				_localctx = new FnDefBranchContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				fnDef();
				}
				break;
			case 3:
				_localctx = new VarDefBranchContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				varDef();
				}
				break;
			case 4:
				_localctx = new ReturnStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				returnStmt();
				}
				break;
			case 5:
				_localctx = new DoStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				doStmt();
				}
				break;
			case 6:
				_localctx = new IfStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(65);
				ifStmt();
				}
				break;
			case 7:
				_localctx = new TypeDefnStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(66);
				typeDefnStmt();
				}
				break;
			case 8:
				_localctx = new NativeDeclStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(67);
				nativeDeclStmt();
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

	public static class NativeDeclStmtContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(BrucelangParser.DECLARE, 0); }
		public TerminalNode NATIVE() { return getToken(BrucelangParser.NATIVE, 0); }
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public TerminalNode COLON() { return getToken(BrucelangParser.COLON, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
		public NativeDeclStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeDeclStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitNativeDeclStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeDeclStmtContext nativeDeclStmt() throws RecognitionException {
		NativeDeclStmtContext _localctx = new NativeDeclStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nativeDeclStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(DECLARE);
			setState(71);
			match(NATIVE);
			setState(72);
			match(ID);
			setState(73);
			match(COLON);
			setState(74);
			typeExpr();
			setState(75);
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

	public static class TypeDefnStmtContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(BrucelangParser.DECLARE, 0); }
		public TerminalNode NATIVE() { return getToken(BrucelangParser.NATIVE, 0); }
		public TerminalNode TYPE() { return getToken(BrucelangParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public TerminalNode L_CURLY() { return getToken(BrucelangParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(BrucelangParser.R_CURLY, 0); }
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
		public TypeDefnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefnStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitTypeDefnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefnStmtContext typeDefnStmt() throws RecognitionException {
		TypeDefnStmtContext _localctx = new TypeDefnStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeDefnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(DECLARE);
			setState(78);
			match(NATIVE);
			setState(79);
			match(TYPE);
			setState(80);
			match(ID);
			setState(81);
			match(L_CURLY);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(82);
				fieldDecl();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(R_CURLY);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(89);
				match(SEMI);
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

	public static class FieldDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public TerminalNode COLON() { return getToken(BrucelangParser.COLON, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ID);
			setState(93);
			match(COLON);
			setState(94);
			typeExpr();
			setState(95);
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
		enterRule(_localctx, 10, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(RETURN);
			setState(98);
			expr();
			setState(99);
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
		enterRule(_localctx, 12, RULE_doStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(DO);
			setState(102);
			expr();
			setState(103);
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
		enterRule(_localctx, 14, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(L_CURLY);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECLARE) | (1L << DEFINE) | (1L << DO) | (1L << RETURN) | (1L << IF) | (1L << LET) | (1L << L_CURLY))) != 0)) {
				{
				{
				setState(106);
				stmt();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
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
		enterRule(_localctx, 16, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(IF);
			setState(115);
			match(L_PAREN);
			setState(116);
			expr();
			setState(117);
			match(R_PAREN);
			setState(118);
			blockStmt();
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					match(ELSE);
					setState(120);
					match(IF);
					setState(121);
					match(L_PAREN);
					setState(122);
					expr();
					setState(123);
					match(R_PAREN);
					setState(124);
					blockStmt();
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(131);
				match(ELSE);
				setState(132);
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
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	 
		public VarDefContext() { }
		public void copyFrom(VarDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InferredVarDefContext extends VarDefContext {
		public TerminalNode LET() { return getToken(BrucelangParser.LET, 0); }
		public InferredVarDeclContext inferredVarDecl() {
			return getRuleContext(InferredVarDeclContext.class,0);
		}
		public TerminalNode SET_EQ() { return getToken(BrucelangParser.SET_EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
		public InferredVarDefContext(VarDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitInferredVarDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FullVarDefContext extends VarDefContext {
		public TerminalNode LET() { return getToken(BrucelangParser.LET, 0); }
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public TerminalNode SET_EQ() { return getToken(BrucelangParser.SET_EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
		public FullVarDefContext(VarDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFullVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varDef);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new FullVarDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(LET);
				setState(136);
				varDecl();
				setState(137);
				match(SET_EQ);
				setState(138);
				expr();
				setState(139);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new InferredVarDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(LET);
				setState(142);
				inferredVarDecl();
				setState(143);
				match(SET_EQ);
				setState(144);
				expr();
				setState(145);
				match(SEMI);
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
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
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
		enterRule(_localctx, 20, RULE_fnDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(DEFINE);
			setState(150);
			match(ID);
			setState(151);
			match(L_PAREN);
			setState(152);
			varDeclList();
			setState(153);
			match(R_PAREN);
			setState(154);
			match(COLON);
			setState(155);
			typeExpr();
			setState(156);
			match(AS);
			setState(157);
			blockStmt();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(158);
				match(SEMI);
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
		enterRule(_localctx, 22, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(ID);
			setState(162);
			match(COLON);
			setState(163);
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

	public static class InferredVarDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public InferredVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inferredVarDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitInferredVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InferredVarDeclContext inferredVarDecl() throws RecognitionException {
		InferredVarDeclContext _localctx = new InferredVarDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inferredVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(ID);
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
		enterRule(_localctx, 26, RULE_varDeclList);
		int _la;
		try {
			setState(176);
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
				setState(168);
				varDecl();
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(169);
					match(COMMA);
					setState(170);
					varDecl();
					}
					}
					setState(175);
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
	public static class FnTypeContext extends TypeExprContext {
		public TerminalNode FN() { return getToken(BrucelangParser.FN, 0); }
		public TerminalNode L_PAREN() { return getToken(BrucelangParser.L_PAREN, 0); }
		public TypeExprListContext typeExprList() {
			return getRuleContext(TypeExprListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(BrucelangParser.R_PAREN, 0); }
		public TerminalNode SM_ARROW() { return getToken(BrucelangParser.SM_ARROW, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public FnTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitFnType(this);
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
		enterRule(_localctx, 28, RULE_typeExpr);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new SimpleTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ComplexTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(ID);
				setState(180);
				match(LT);
				setState(181);
				typeExprList();
				setState(182);
				match(GT);
				}
				break;
			case 3:
				_localctx = new FnTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(FN);
				setState(185);
				match(L_PAREN);
				setState(186);
				typeExprList();
				setState(187);
				match(R_PAREN);
				setState(188);
				match(SM_ARROW);
				setState(189);
				typeExpr();
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
		enterRule(_localctx, 30, RULE_typeExprList);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GT:
			case R_PAREN:
				_localctx = new NoTypesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case FN:
			case ID:
				_localctx = new SomeTypesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				typeExpr();
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(195);
					match(COMMA);
					setState(196);
					typeExpr();
					}
					}
					setState(201);
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
		enterRule(_localctx, 32, RULE_exprList);
		int _la;
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case R_PAREN:
				_localctx = new NoExprsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case BOOL_VAL:
			case UNARY_OP:
			case L_PAREN:
			case ID:
			case INT:
			case STRING_CONST:
				_localctx = new SomeExprsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				expr();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(206);
					match(COMMA);
					setState(207);
					expr();
					}
					}
					setState(212);
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
		enterRule(_localctx, 34, RULE_expr);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new LambdaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				lambda();
				}
				break;
			case 2:
				_localctx = new BooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
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
		public TerminalNode BIG_ARROW() { return getToken(BrucelangParser.BIG_ARROW, 0); }
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
		public TerminalNode BIG_ARROW() { return getToken(BrucelangParser.BIG_ARROW, 0); }
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
		public TerminalNode BIG_ARROW() { return getToken(BrucelangParser.BIG_ARROW, 0); }
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
		public TerminalNode BIG_ARROW() { return getToken(BrucelangParser.BIG_ARROW, 0); }
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
		enterRule(_localctx, 36, RULE_lambda);
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new OneArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				varDecl();
				setState(220);
				match(BIG_ARROW);
				setState(221);
				blockStmt();
				}
				break;
			case 2:
				_localctx = new MultiArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(L_PAREN);
				setState(224);
				varDeclList();
				setState(225);
				match(R_PAREN);
				setState(226);
				match(BIG_ARROW);
				setState(227);
				blockStmt();
				}
				break;
			case 3:
				_localctx = new OneArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				varDecl();
				setState(230);
				match(BIG_ARROW);
				setState(231);
				expr();
				}
				break;
			case 4:
				_localctx = new MultiArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				match(L_PAREN);
				setState(234);
				varDeclList();
				setState(235);
				match(R_PAREN);
				setState(236);
				match(BIG_ARROW);
				setState(237);
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
		public TerminalNode BOOL_OP() { return getToken(BrucelangParser.BOOL_OP, 0); }
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
		enterRule(_localctx, 38, RULE_linkedBoolExpr);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new FallThroughCompExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				compExpr();
				}
				break;
			case 2:
				_localctx = new BoolOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				compExpr();
				setState(243);
				match(BOOL_OP);
				setState(244);
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
		public TerminalNode COMP_OP() { return getToken(BrucelangParser.COMP_OP, 0); }
		public CompOpExprContext(CompExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitCompOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompExprContext compExpr() throws RecognitionException {
		CompExprContext _localctx = new CompExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_compExpr);
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new FallThroughAddExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				addExpr();
				}
				break;
			case 2:
				_localctx = new CompOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				addExpr();
				setState(250);
				match(COMP_OP);
				setState(251);
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
		public List<TerminalNode> ADD_OP() { return getTokens(BrucelangParser.ADD_OP); }
		public TerminalNode ADD_OP(int i) {
			return getToken(BrucelangParser.ADD_OP, i);
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
		enterRule(_localctx, 42, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			mulExpr();
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD_OP) {
				{
				{
				setState(256);
				match(ADD_OP);
				setState(257);
				mulExpr();
				}
				}
				setState(262);
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
		public List<TerminalNode> MUL_OP() { return getTokens(BrucelangParser.MUL_OP); }
		public TerminalNode MUL_OP(int i) {
			return getToken(BrucelangParser.MUL_OP, i);
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
		enterRule(_localctx, 44, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			unaryExpr();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL_OP) {
				{
				{
				setState(264);
				match(MUL_OP);
				setState(265);
				unaryExpr();
				}
				}
				setState(270);
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
		public TerminalNode UNARY_OP() { return getToken(BrucelangParser.UNARY_OP, 0); }
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
		enterRule(_localctx, 46, RULE_unaryExpr);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_VAL:
			case L_PAREN:
			case ID:
			case INT:
			case STRING_CONST:
				_localctx = new FallThroughAccessOrCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				accessOrCall(0);
				}
				break;
			case UNARY_OP:
				_localctx = new NestedUnaryExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(UNARY_OP);
				setState(273);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_accessOrCall, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FallThroughBaseExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(277);
			baseExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(287);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new NamedFieldAccessContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(279);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(280);
						match(DOT);
						setState(281);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new FnCallContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(282);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(283);
						match(L_PAREN);
						setState(284);
						exprList();
						setState(285);
						match(R_PAREN);
						}
						break;
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		public TerminalNode BOOL_VAL() { return getToken(BrucelangParser.BOOL_VAL, 0); }
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
		enterRule(_localctx, 50, RULE_baseExpr);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_PAREN:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(L_PAREN);
				setState(293);
				expr();
				setState(294);
				match(R_PAREN);
				}
				break;
			case ID:
				_localctx = new VariableReferenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				match(ID);
				}
				break;
			case INT:
				_localctx = new NumConstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				match(INT);
				}
				break;
			case STRING_CONST:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(298);
				match(STRING_CONST);
				}
				break;
			case BOOL_VAL:
				_localctx = new BoolConstContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(299);
				match(BOOL_VAL);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u0131\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3G\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\7\5V\n\5\f\5\16\5Y\13\5\3\5\3\5\5\5]\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\7\tn\n\t\f\t\16\tq\13\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0081\n\n\f\n"+
		"\16\n\u0084\13\n\3\n\3\n\5\n\u0088\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u0096\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00a2\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\7\17\u00ae\n\17\f\17\16\17\u00b1\13\17\5\17\u00b3\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c2\n\20"+
		"\3\21\3\21\3\21\3\21\7\21\u00c8\n\21\f\21\16\21\u00cb\13\21\5\21\u00cd"+
		"\n\21\3\22\3\22\3\22\3\22\7\22\u00d3\n\22\f\22\16\22\u00d6\13\22\5\22"+
		"\u00d8\n\22\3\23\3\23\5\23\u00dc\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5"+
		"\24\u00f2\n\24\3\25\3\25\3\25\3\25\3\25\5\25\u00f9\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u0100\n\26\3\27\3\27\3\27\7\27\u0105\n\27\f\27\16\27\u0108"+
		"\13\27\3\30\3\30\3\30\7\30\u010d\n\30\f\30\16\30\u0110\13\30\3\31\3\31"+
		"\3\31\5\31\u0115\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\7\32\u0122\n\32\f\32\16\32\u0125\13\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u012f\n\33\3\33\2\3\62\34\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\2\2\2\u013c\29\3\2\2\2\4F\3\2\2\2\6"+
		"H\3\2\2\2\bO\3\2\2\2\n^\3\2\2\2\fc\3\2\2\2\16g\3\2\2\2\20k\3\2\2\2\22"+
		"t\3\2\2\2\24\u0095\3\2\2\2\26\u0097\3\2\2\2\30\u00a3\3\2\2\2\32\u00a7"+
		"\3\2\2\2\34\u00b2\3\2\2\2\36\u00c1\3\2\2\2 \u00cc\3\2\2\2\"\u00d7\3\2"+
		"\2\2$\u00db\3\2\2\2&\u00f1\3\2\2\2(\u00f8\3\2\2\2*\u00ff\3\2\2\2,\u0101"+
		"\3\2\2\2.\u0109\3\2\2\2\60\u0114\3\2\2\2\62\u0116\3\2\2\2\64\u012e\3\2"+
		"\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2"+
		"\2;9\3\2\2\2<=\7\2\2\3=\3\3\2\2\2>G\5\20\t\2?G\5\26\f\2@G\5\24\13\2AG"+
		"\5\f\7\2BG\5\16\b\2CG\5\22\n\2DG\5\b\5\2EG\5\6\4\2F>\3\2\2\2F?\3\2\2\2"+
		"F@\3\2\2\2FA\3\2\2\2FB\3\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2G\5\3\2\2"+
		"\2HI\7\13\2\2IJ\7\f\2\2JK\7\61\2\2KL\7,\2\2LM\5\36\20\2MN\7$\2\2N\7\3"+
		"\2\2\2OP\7\13\2\2PQ\7\f\2\2QR\7\25\2\2RS\7\61\2\2SW\7%\2\2TV\5\n\6\2U"+
		"T\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z\\\7&\2\2"+
		"[]\7$\2\2\\[\3\2\2\2\\]\3\2\2\2]\t\3\2\2\2^_\7\61\2\2_`\7,\2\2`a\5\36"+
		"\20\2ab\7$\2\2b\13\3\2\2\2cd\7\17\2\2de\5$\23\2ef\7$\2\2f\r\3\2\2\2gh"+
		"\7\16\2\2hi\5$\23\2ij\7$\2\2j\17\3\2\2\2ko\7%\2\2ln\5\4\3\2ml\3\2\2\2"+
		"nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7&\2\2s\21\3\2\2"+
		"\2tu\7\22\2\2uv\7\'\2\2vw\5$\23\2wx\7(\2\2x\u0082\5\20\t\2yz\7\23\2\2"+
		"z{\7\22\2\2{|\7\'\2\2|}\5$\23\2}~\7(\2\2~\177\5\20\t\2\177\u0081\3\2\2"+
		"\2\u0080y\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0087\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\23\2\2"+
		"\u0086\u0088\5\20\t\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\23"+
		"\3\2\2\2\u0089\u008a\7\24\2\2\u008a\u008b\5\30\r\2\u008b\u008c\7+\2\2"+
		"\u008c\u008d\5$\23\2\u008d\u008e\7$\2\2\u008e\u0096\3\2\2\2\u008f\u0090"+
		"\7\24\2\2\u0090\u0091\5\32\16\2\u0091\u0092\7+\2\2\u0092\u0093\5$\23\2"+
		"\u0093\u0094\7$\2\2\u0094\u0096\3\2\2\2\u0095\u0089\3\2\2\2\u0095\u008f"+
		"\3\2\2\2\u0096\25\3\2\2\2\u0097\u0098\7\r\2\2\u0098\u0099\7\61\2\2\u0099"+
		"\u009a\7\'\2\2\u009a\u009b\5\34\17\2\u009b\u009c\7(\2\2\u009c\u009d\7"+
		",\2\2\u009d\u009e\5\36\20\2\u009e\u009f\7\20\2\2\u009f\u00a1\5\20\t\2"+
		"\u00a0\u00a2\7$\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\27\3"+
		"\2\2\2\u00a3\u00a4\7\61\2\2\u00a4\u00a5\7,\2\2\u00a5\u00a6\5\36\20\2\u00a6"+
		"\31\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8\33\3\2\2\2\u00a9\u00b3\3\2\2\2"+
		"\u00aa\u00af\5\30\r\2\u00ab\u00ac\7-\2\2\u00ac\u00ae\5\30\r\2\u00ad\u00ab"+
		"\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00aa\3\2"+
		"\2\2\u00b3\35\3\2\2\2\u00b4\u00c2\7\61\2\2\u00b5\u00b6\7\61\2\2\u00b6"+
		"\u00b7\7\35\2\2\u00b7\u00b8\5 \21\2\u00b8\u00b9\7\37\2\2\u00b9\u00c2\3"+
		"\2\2\2\u00ba\u00bb\7\26\2\2\u00bb\u00bc\7\'\2\2\u00bc\u00bd\5 \21\2\u00bd"+
		"\u00be\7(\2\2\u00be\u00bf\7)\2\2\u00bf\u00c0\5\36\20\2\u00c0\u00c2\3\2"+
		"\2\2\u00c1\u00b4\3\2\2\2\u00c1\u00b5\3\2\2\2\u00c1\u00ba\3\2\2\2\u00c2"+
		"\37\3\2\2\2\u00c3\u00cd\3\2\2\2\u00c4\u00c9\5\36\20\2\u00c5\u00c6\7-\2"+
		"\2\u00c6\u00c8\5\36\20\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cc\u00c3\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cd!\3\2\2\2\u00ce\u00d8"+
		"\3\2\2\2\u00cf\u00d4\5$\23\2\u00d0\u00d1\7-\2\2\u00d1\u00d3\5$\23\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00ce\3\2\2\2\u00d7"+
		"\u00cf\3\2\2\2\u00d8#\3\2\2\2\u00d9\u00dc\5&\24\2\u00da\u00dc\5(\25\2"+
		"\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc%\3\2\2\2\u00dd\u00de\5"+
		"\30\r\2\u00de\u00df\7*\2\2\u00df\u00e0\5\20\t\2\u00e0\u00f2\3\2\2\2\u00e1"+
		"\u00e2\7\'\2\2\u00e2\u00e3\5\34\17\2\u00e3\u00e4\7(\2\2\u00e4\u00e5\7"+
		"*\2\2\u00e5\u00e6\5\20\t\2\u00e6\u00f2\3\2\2\2\u00e7\u00e8\5\30\r\2\u00e8"+
		"\u00e9\7*\2\2\u00e9\u00ea\5$\23\2\u00ea\u00f2\3\2\2\2\u00eb\u00ec\7\'"+
		"\2\2\u00ec\u00ed\5\34\17\2\u00ed\u00ee\7(\2\2\u00ee\u00ef\7*\2\2\u00ef"+
		"\u00f0\5$\23\2\u00f0\u00f2\3\2\2\2\u00f1\u00dd\3\2\2\2\u00f1\u00e1\3\2"+
		"\2\2\u00f1\u00e7\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f2\'\3\2\2\2\u00f3\u00f9"+
		"\5*\26\2\u00f4\u00f5\5*\26\2\u00f5\u00f6\7\3\2\2\u00f6\u00f7\5*\26\2\u00f7"+
		"\u00f9\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f8\u00f4\3\2\2\2\u00f9)\3\2\2\2"+
		"\u00fa\u0100\5,\27\2\u00fb\u00fc\5,\27\2\u00fc\u00fd\7\4\2\2\u00fd\u00fe"+
		"\5,\27\2\u00fe\u0100\3\2\2\2\u00ff\u00fa\3\2\2\2\u00ff\u00fb\3\2\2\2\u0100"+
		"+\3\2\2\2\u0101\u0106\5.\30\2\u0102\u0103\7\6\2\2\u0103\u0105\5.\30\2"+
		"\u0104\u0102\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107-\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010e\5\60\31\2\u010a"+
		"\u010b\7\7\2\2\u010b\u010d\5\60\31\2\u010c\u010a\3\2\2\2\u010d\u0110\3"+
		"\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f/\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0111\u0115\5\62\32\2\u0112\u0113\7\b\2\2\u0113\u0115\5\60\31"+
		"\2\u0114\u0111\3\2\2\2\u0114\u0112\3\2\2\2\u0115\61\3\2\2\2\u0116\u0117"+
		"\b\32\1\2\u0117\u0118\5\64\33\2\u0118\u0123\3\2\2\2\u0119\u011a\f\5\2"+
		"\2\u011a\u011b\7.\2\2\u011b\u0122\7\61\2\2\u011c\u011d\f\4\2\2\u011d\u011e"+
		"\7\'\2\2\u011e\u011f\5\"\22\2\u011f\u0120\7(\2\2\u0120\u0122\3\2\2\2\u0121"+
		"\u0119\3\2\2\2\u0121\u011c\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0123\u0124\3\2\2\2\u0124\63\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127"+
		"\7\'\2\2\u0127\u0128\5$\23\2\u0128\u0129\7(\2\2\u0129\u012f\3\2\2\2\u012a"+
		"\u012f\7\61\2\2\u012b\u012f\7\62\2\2\u012c\u012f\7\63\2\2\u012d\u012f"+
		"\7\5\2\2\u012e\u0126\3\2\2\2\u012e\u012a\3\2\2\2\u012e\u012b\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f\65\3\2\2\2\349FW\\o\u0082\u0087"+
		"\u0095\u00a1\u00af\u00b2\u00c1\u00c9\u00cc\u00d4\u00d7\u00db\u00f1\u00f8"+
		"\u00ff\u0106\u010e\u0114\u0121\u0123\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}