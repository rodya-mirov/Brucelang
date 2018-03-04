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
		TRUE=1, FALSE=2, DECLARE=3, NATIVE=4, DEFINE=5, DO=6, RETURN=7, AS=8, 
		IS=9, IF=10, ELSE=11, LET=12, TYPE=13, FN=14, TYPE_FN=15, AND=16, OR=17, 
		PLUS=18, MINUS=19, TIMES=20, DIVIDE=21, LTE=22, LT=23, GTE=24, GT=25, 
		EQ=26, NEQ=27, NOT=28, SEMI=29, L_CURLY=30, R_CURLY=31, L_PAREN=32, R_PAREN=33, 
		SM_ARROW=34, BIG_ARROW=35, SET_EQ=36, COLON=37, COMMA=38, DOT=39, LINE_COMMENT=40, 
		BLOCK_COMMENT=41, ID=42, INT=43, STRING_CONST=44, ESC_SEQ=45, OCTAL_ESC=46, 
		UNICODE_ESC=47, HEX_DIGIT=48, WS=49;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_nativeDeclStmt = 2, RULE_typeDefnStmt = 3, 
		RULE_fieldDecl = 4, RULE_returnStmt = 5, RULE_doStmt = 6, RULE_blockStmt = 7, 
		RULE_ifStmt = 8, RULE_varDef = 9, RULE_fnDef = 10, RULE_varDecl = 11, 
		RULE_varDeclList = 12, RULE_typeExpr = 13, RULE_typeExprList = 14, RULE_idList = 15, 
		RULE_exprList = 16, RULE_expr = 17, RULE_typeLambda = 18, RULE_lambda = 19, 
		RULE_linkedBoolExpr = 20, RULE_compExpr = 21, RULE_addExpr = 22, RULE_mulExpr = 23, 
		RULE_unaryExpr = 24, RULE_accessOrCall = 25, RULE_baseExpr = 26, RULE_boolOp = 27, 
		RULE_compOp = 28, RULE_boolVal = 29, RULE_addOp = 30, RULE_mulOp = 31, 
		RULE_unaryOp = 32;
	public static final String[] ruleNames = {
		"program", "stmt", "nativeDeclStmt", "typeDefnStmt", "fieldDecl", "returnStmt", 
		"doStmt", "blockStmt", "ifStmt", "varDef", "fnDef", "varDecl", "varDeclList", 
		"typeExpr", "typeExprList", "idList", "exprList", "expr", "typeLambda", 
		"lambda", "linkedBoolExpr", "compExpr", "addExpr", "mulExpr", "unaryExpr", 
		"accessOrCall", "baseExpr", "boolOp", "compOp", "boolVal", "addOp", "mulOp", 
		"unaryOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'true'", "'false'", "'declare'", "'native'", "'define'", "'do'", 
		"'return'", "'as'", "'is'", "'if'", "'else'", "'let'", "'type'", "'Fn'", 
		"'TypeFn'", "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", "'<='", "'<'", 
		"'>='", "'>'", "'=='", "'!='", "'!'", "';'", "'{'", "'}'", "'('", "')'", 
		"'->'", "'=>'", "'='", "':'", "','", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "DECLARE", "NATIVE", "DEFINE", "DO", "RETURN", 
		"AS", "IS", "IF", "ELSE", "LET", "TYPE", "FN", "TYPE_FN", "AND", "OR", 
		"PLUS", "MINUS", "TIMES", "DIVIDE", "LTE", "LT", "GTE", "GT", "EQ", "NEQ", 
		"NOT", "SEMI", "L_CURLY", "R_CURLY", "L_PAREN", "R_PAREN", "SM_ARROW", 
		"BIG_ARROW", "SET_EQ", "COLON", "COMMA", "DOT", "LINE_COMMENT", "BLOCK_COMMENT", 
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
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECLARE) | (1L << DEFINE) | (1L << DO) | (1L << RETURN) | (1L << IF) | (1L << LET) | (1L << L_CURLY))) != 0)) {
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
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new BlockStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				blockStmt();
				}
				break;
			case 2:
				_localctx = new FnDefBranchContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				fnDef();
				}
				break;
			case 3:
				_localctx = new VarDefBranchContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				varDef();
				}
				break;
			case 4:
				_localctx = new ReturnStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				returnStmt();
				}
				break;
			case 5:
				_localctx = new DoStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				doStmt();
				}
				break;
			case 6:
				_localctx = new IfStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				ifStmt();
				}
				break;
			case 7:
				_localctx = new TypeDefnStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				typeDefnStmt();
				}
				break;
			case 8:
				_localctx = new NativeDeclStmtBranchContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
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
			setState(84);
			match(DECLARE);
			setState(85);
			match(NATIVE);
			setState(86);
			match(ID);
			setState(87);
			match(COLON);
			setState(88);
			typeExpr();
			setState(89);
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
			setState(91);
			match(DECLARE);
			setState(92);
			match(NATIVE);
			setState(93);
			match(TYPE);
			setState(94);
			match(ID);
			setState(95);
			match(L_CURLY);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(96);
				fieldDecl();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(R_CURLY);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(103);
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
			setState(106);
			match(ID);
			setState(107);
			match(COLON);
			setState(108);
			typeExpr();
			setState(109);
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
			setState(111);
			match(RETURN);
			setState(112);
			expr();
			setState(113);
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
			setState(115);
			match(DO);
			setState(116);
			expr();
			setState(117);
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
			setState(119);
			match(L_CURLY);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECLARE) | (1L << DEFINE) | (1L << DO) | (1L << RETURN) | (1L << IF) | (1L << LET) | (1L << L_CURLY))) != 0)) {
				{
				{
				setState(120);
				stmt();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
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
			setState(128);
			match(IF);
			setState(129);
			match(L_PAREN);
			setState(130);
			expr();
			setState(131);
			match(R_PAREN);
			setState(132);
			blockStmt();
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(133);
					match(ELSE);
					setState(134);
					match(IF);
					setState(135);
					match(L_PAREN);
					setState(136);
					expr();
					setState(137);
					match(R_PAREN);
					setState(138);
					blockStmt();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(145);
				match(ELSE);
				setState(146);
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
	public static class SimpleVarDefContext extends VarDefContext {
		public TerminalNode LET() { return getToken(BrucelangParser.LET, 0); }
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public TerminalNode SET_EQ() { return getToken(BrucelangParser.SET_EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
		public SimpleVarDefContext(VarDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitSimpleVarDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParametrizedVarDefContext extends VarDefContext {
		public TerminalNode LET() { return getToken(BrucelangParser.LET, 0); }
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public TerminalNode LT() { return getToken(BrucelangParser.LT, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode GT() { return getToken(BrucelangParser.GT, 0); }
		public TerminalNode SET_EQ() { return getToken(BrucelangParser.SET_EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BrucelangParser.SEMI, 0); }
		public ParametrizedVarDefContext(VarDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitParametrizedVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varDef);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new SimpleVarDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(LET);
				setState(150);
				varDecl();
				setState(151);
				match(SET_EQ);
				setState(152);
				expr();
				setState(153);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new ParametrizedVarDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(LET);
				setState(156);
				varDecl();
				setState(157);
				match(LT);
				setState(158);
				idList();
				setState(159);
				match(GT);
				setState(160);
				match(SET_EQ);
				setState(161);
				expr();
				setState(162);
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
			setState(166);
			match(DEFINE);
			setState(167);
			match(ID);
			setState(168);
			match(L_PAREN);
			setState(169);
			varDeclList();
			setState(170);
			match(R_PAREN);
			setState(171);
			match(COLON);
			setState(172);
			typeExpr();
			setState(173);
			match(AS);
			setState(174);
			blockStmt();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(175);
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
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	 
		public VarDeclContext() { }
		public void copyFrom(VarDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InferredVarDeclContext extends VarDeclContext {
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public InferredVarDeclContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitInferredVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplicitVarDeclContext extends VarDeclContext {
		public TerminalNode ID() { return getToken(BrucelangParser.ID, 0); }
		public TerminalNode COLON() { return getToken(BrucelangParser.COLON, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public ExplicitVarDeclContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitExplicitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varDecl);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new ExplicitVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(ID);
				setState(179);
				match(COLON);
				setState(180);
				typeExpr();
				}
				break;
			case 2:
				_localctx = new InferredVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(ID);
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
		enterRule(_localctx, 24, RULE_varDeclList);
		int _la;
		try {
			setState(193);
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
				setState(185);
				varDecl();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(186);
					match(COMMA);
					setState(187);
					varDecl();
					}
					}
					setState(192);
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
	public static class ParenTypeContext extends TypeExprContext {
		public TerminalNode L_PAREN() { return getToken(BrucelangParser.L_PAREN, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(BrucelangParser.R_PAREN, 0); }
		public ParenTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitParenType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeFnTypeContext extends TypeExprContext {
		public TerminalNode TYPE_FN() { return getToken(BrucelangParser.TYPE_FN, 0); }
		public TerminalNode L_PAREN() { return getToken(BrucelangParser.L_PAREN, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(BrucelangParser.R_PAREN, 0); }
		public TerminalNode SM_ARROW() { return getToken(BrucelangParser.SM_ARROW, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TypeFnTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitTypeFnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeExprContext typeExpr() throws RecognitionException {
		TypeExprContext _localctx = new TypeExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeExpr);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new SimpleTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ComplexTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(ID);
				setState(197);
				match(LT);
				setState(198);
				typeExprList();
				setState(199);
				match(GT);
				}
				break;
			case 3:
				_localctx = new FnTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(FN);
				setState(202);
				match(L_PAREN);
				setState(203);
				typeExprList();
				setState(204);
				match(R_PAREN);
				setState(205);
				match(SM_ARROW);
				setState(206);
				typeExpr();
				}
				break;
			case 4:
				_localctx = new TypeFnTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				match(TYPE_FN);
				setState(209);
				match(L_PAREN);
				setState(210);
				idList();
				setState(211);
				match(R_PAREN);
				setState(212);
				match(SM_ARROW);
				setState(213);
				typeExpr();
				}
				break;
			case 5:
				_localctx = new ParenTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(215);
				match(L_PAREN);
				setState(216);
				typeExpr();
				setState(217);
				match(R_PAREN);
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
		enterRule(_localctx, 28, RULE_typeExprList);
		int _la;
		try {
			setState(230);
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
			case TYPE_FN:
			case L_PAREN:
			case ID:
				_localctx = new SomeTypesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				typeExpr();
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(223);
					match(COMMA);
					setState(224);
					typeExpr();
					}
					}
					setState(229);
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
		public List<TerminalNode> COMMA() { return getTokens(BrucelangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BrucelangParser.COMMA, i);
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
		enterRule(_localctx, 30, RULE_idList);
		int _la;
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GT:
			case R_PAREN:
				_localctx = new NoIdsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				_localctx = new SomeIdsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(ID);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(234);
					match(COMMA);
					setState(235);
					match(ID);
					}
					}
					setState(240);
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
			setState(252);
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
			case LT:
			case NOT:
			case L_PAREN:
			case ID:
			case INT:
			case STRING_CONST:
				_localctx = new SomeExprsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				expr();
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(245);
					match(COMMA);
					setState(246);
					expr();
					}
					}
					setState(251);
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
	public static class LambdaExprContext extends ExprContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeLambdaExprContext extends ExprContext {
		public TypeLambdaContext typeLambda() {
			return getRuleContext(TypeLambdaContext.class,0);
		}
		public TypeLambdaExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitTypeLambdaExpr(this);
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
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new LambdaExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				lambda();
				}
				break;
			case 2:
				_localctx = new TypeLambdaExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				typeLambda();
				}
				break;
			case 3:
				_localctx = new BooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
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

	public static class TypeLambdaContext extends ParserRuleContext {
		public TypeLambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeLambda; }
	 
		public TypeLambdaContext() { }
		public void copyFrom(TypeLambdaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmtTypeLambdaContext extends TypeLambdaContext {
		public TerminalNode LT() { return getToken(BrucelangParser.LT, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode GT() { return getToken(BrucelangParser.GT, 0); }
		public TerminalNode BIG_ARROW() { return getToken(BrucelangParser.BIG_ARROW, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public StmtTypeLambdaContext(TypeLambdaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitStmtTypeLambda(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTypeLambdaContext extends TypeLambdaContext {
		public TerminalNode LT() { return getToken(BrucelangParser.LT, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode GT() { return getToken(BrucelangParser.GT, 0); }
		public TerminalNode BIG_ARROW() { return getToken(BrucelangParser.BIG_ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprTypeLambdaContext(TypeLambdaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitExprTypeLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeLambdaContext typeLambda() throws RecognitionException {
		TypeLambdaContext _localctx = new TypeLambdaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeLambda);
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new StmtTypeLambdaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(LT);
				setState(260);
				idList();
				setState(261);
				match(GT);
				setState(262);
				match(BIG_ARROW);
				setState(263);
				blockStmt();
				}
				break;
			case 2:
				_localctx = new ExprTypeLambdaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(LT);
				setState(266);
				idList();
				setState(267);
				match(GT);
				setState(268);
				match(BIG_ARROW);
				setState(269);
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
		enterRule(_localctx, 38, RULE_lambda);
		try {
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new OneArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				varDecl();
				setState(274);
				match(BIG_ARROW);
				setState(275);
				blockStmt();
				}
				break;
			case 2:
				_localctx = new MultiArgLambdaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				match(L_PAREN);
				setState(278);
				varDeclList();
				setState(279);
				match(R_PAREN);
				setState(280);
				match(BIG_ARROW);
				setState(281);
				blockStmt();
				}
				break;
			case 3:
				_localctx = new OneArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				varDecl();
				setState(284);
				match(BIG_ARROW);
				setState(285);
				expr();
				}
				break;
			case 4:
				_localctx = new MultiArgExprLambdaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(287);
				match(L_PAREN);
				setState(288);
				varDeclList();
				setState(289);
				match(R_PAREN);
				setState(290);
				match(BIG_ARROW);
				setState(291);
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
		enterRule(_localctx, 40, RULE_linkedBoolExpr);
		try {
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new FallThroughCompExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				compExpr();
				}
				break;
			case 2:
				_localctx = new BoolOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				compExpr();
				setState(297);
				boolOp();
				setState(298);
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
		enterRule(_localctx, 42, RULE_compExpr);
		try {
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new FallThroughAddExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				addExpr();
				}
				break;
			case 2:
				_localctx = new CompOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				addExpr();
				setState(304);
				compOp();
				setState(305);
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
		enterRule(_localctx, 44, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			mulExpr();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(310);
				addOp();
				setState(311);
				mulExpr();
				}
				}
				setState(317);
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
		enterRule(_localctx, 46, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			unaryExpr();
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIVIDE) {
				{
				{
				setState(319);
				mulOp();
				setState(320);
				unaryExpr();
				}
				}
				setState(326);
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
		enterRule(_localctx, 48, RULE_unaryExpr);
		try {
			setState(331);
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
				setState(327);
				accessOrCall(0);
				}
				break;
			case MINUS:
			case NOT:
				_localctx = new NestedUnaryExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				unaryOp();
				setState(329);
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
	public static class TypeFnCallContext extends AccessOrCallContext {
		public AccessOrCallContext accessOrCall() {
			return getRuleContext(AccessOrCallContext.class,0);
		}
		public TerminalNode LT() { return getToken(BrucelangParser.LT, 0); }
		public TypeExprListContext typeExprList() {
			return getRuleContext(TypeExprListContext.class,0);
		}
		public TerminalNode GT() { return getToken(BrucelangParser.GT, 0); }
		public TypeFnCallContext(AccessOrCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BrucelangVisitor ) return ((BrucelangVisitor<? extends T>)visitor).visitTypeFnCall(this);
			else return visitor.visitChildren(this);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_accessOrCall, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FallThroughBaseExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(334);
			baseExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(349);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new NamedFieldAccessContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(336);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(337);
						match(DOT);
						setState(338);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new FnCallContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(339);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(340);
						match(L_PAREN);
						setState(341);
						exprList();
						setState(342);
						match(R_PAREN);
						}
						break;
					case 3:
						{
						_localctx = new TypeFnCallContext(new AccessOrCallContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_accessOrCall);
						setState(344);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(345);
						match(LT);
						setState(346);
						typeExprList();
						setState(347);
						match(GT);
						}
						break;
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		enterRule(_localctx, 52, RULE_baseExpr);
		try {
			setState(362);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_PAREN:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(L_PAREN);
				setState(355);
				expr();
				setState(356);
				match(R_PAREN);
				}
				break;
			case ID:
				_localctx = new VariableReferenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
				match(ID);
				}
				break;
			case INT:
				_localctx = new NumConstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
				match(INT);
				}
				break;
			case STRING_CONST:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(360);
				match(STRING_CONST);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolConstContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(361);
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
		enterRule(_localctx, 54, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
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
		enterRule(_localctx, 56, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LTE) | (1L << LT) | (1L << GTE) | (1L << GT) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
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
		enterRule(_localctx, 58, RULE_boolVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
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
		enterRule(_localctx, 60, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
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
		enterRule(_localctx, 62, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
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
		public TerminalNode NOT() { return getToken(BrucelangParser.NOT, 0); }
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
		enterRule(_localctx, 64, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==NOT) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return accessOrCall_sempred((AccessOrCallContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean accessOrCall_sempred(AccessOrCallContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u017b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3U\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5d\n\5\f\5\16\5g\13\5\3\5\3\5\5\5k\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\7\t|\n\t\f\t\16\t\177\13\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u008f\n\n\f\n\16"+
		"\n\u0092\13\n\3\n\3\n\5\n\u0096\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a7\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b3\n\f\3\r\3\r\3\r\3\r\5\r\u00b9\n\r"+
		"\3\16\3\16\3\16\3\16\7\16\u00bf\n\16\f\16\16\16\u00c2\13\16\5\16\u00c4"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00de\n\17"+
		"\3\20\3\20\3\20\3\20\7\20\u00e4\n\20\f\20\16\20\u00e7\13\20\5\20\u00e9"+
		"\n\20\3\21\3\21\3\21\3\21\7\21\u00ef\n\21\f\21\16\21\u00f2\13\21\5\21"+
		"\u00f4\n\21\3\22\3\22\3\22\3\22\7\22\u00fa\n\22\f\22\16\22\u00fd\13\22"+
		"\5\22\u00ff\n\22\3\23\3\23\3\23\5\23\u0104\n\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0112\n\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u0128\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u012f\n"+
		"\26\3\27\3\27\3\27\3\27\3\27\5\27\u0136\n\27\3\30\3\30\3\30\3\30\7\30"+
		"\u013c\n\30\f\30\16\30\u013f\13\30\3\31\3\31\3\31\3\31\7\31\u0145\n\31"+
		"\f\31\16\31\u0148\13\31\3\32\3\32\3\32\3\32\5\32\u014e\n\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\7\33\u0160\n\33\f\33\16\33\u0163\13\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u016d\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3\"\2\3\64#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@B\2\b\3\2\22\23\3\2\30\35\3\2\3\4\3\2\24\25\3\2\26\27\4"+
		"\2\25\25\36\36\2\u0187\2G\3\2\2\2\4T\3\2\2\2\6V\3\2\2\2\b]\3\2\2\2\nl"+
		"\3\2\2\2\fq\3\2\2\2\16u\3\2\2\2\20y\3\2\2\2\22\u0082\3\2\2\2\24\u00a6"+
		"\3\2\2\2\26\u00a8\3\2\2\2\30\u00b8\3\2\2\2\32\u00c3\3\2\2\2\34\u00dd\3"+
		"\2\2\2\36\u00e8\3\2\2\2 \u00f3\3\2\2\2\"\u00fe\3\2\2\2$\u0103\3\2\2\2"+
		"&\u0111\3\2\2\2(\u0127\3\2\2\2*\u012e\3\2\2\2,\u0135\3\2\2\2.\u0137\3"+
		"\2\2\2\60\u0140\3\2\2\2\62\u014d\3\2\2\2\64\u014f\3\2\2\2\66\u016c\3\2"+
		"\2\28\u016e\3\2\2\2:\u0170\3\2\2\2<\u0172\3\2\2\2>\u0174\3\2\2\2@\u0176"+
		"\3\2\2\2B\u0178\3\2\2\2DF\5\4\3\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2"+
		"\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\2\2\3K\3\3\2\2\2LU\5\20\t\2MU\5\26\f\2NU"+
		"\5\24\13\2OU\5\f\7\2PU\5\16\b\2QU\5\22\n\2RU\5\b\5\2SU\5\6\4\2TL\3\2\2"+
		"\2TM\3\2\2\2TN\3\2\2\2TO\3\2\2\2TP\3\2\2\2TQ\3\2\2\2TR\3\2\2\2TS\3\2\2"+
		"\2U\5\3\2\2\2VW\7\5\2\2WX\7\6\2\2XY\7,\2\2YZ\7\'\2\2Z[\5\34\17\2[\\\7"+
		"\37\2\2\\\7\3\2\2\2]^\7\5\2\2^_\7\6\2\2_`\7\17\2\2`a\7,\2\2ae\7 \2\2b"+
		"d\5\n\6\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2"+
		"hj\7!\2\2ik\7\37\2\2ji\3\2\2\2jk\3\2\2\2k\t\3\2\2\2lm\7,\2\2mn\7\'\2\2"+
		"no\5\34\17\2op\7\37\2\2p\13\3\2\2\2qr\7\t\2\2rs\5$\23\2st\7\37\2\2t\r"+
		"\3\2\2\2uv\7\b\2\2vw\5$\23\2wx\7\37\2\2x\17\3\2\2\2y}\7 \2\2z|\5\4\3\2"+
		"{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2"+
		"\2\u0080\u0081\7!\2\2\u0081\21\3\2\2\2\u0082\u0083\7\f\2\2\u0083\u0084"+
		"\7\"\2\2\u0084\u0085\5$\23\2\u0085\u0086\7#\2\2\u0086\u0090\5\20\t\2\u0087"+
		"\u0088\7\r\2\2\u0088\u0089\7\f\2\2\u0089\u008a\7\"\2\2\u008a\u008b\5$"+
		"\23\2\u008b\u008c\7#\2\2\u008c\u008d\5\20\t\2\u008d\u008f\3\2\2\2\u008e"+
		"\u0087\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0095\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\r\2\2\u0094"+
		"\u0096\5\20\t\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\23\3\2\2"+
		"\2\u0097\u0098\7\16\2\2\u0098\u0099\5\30\r\2\u0099\u009a\7&\2\2\u009a"+
		"\u009b\5$\23\2\u009b\u009c\7\37\2\2\u009c\u00a7\3\2\2\2\u009d\u009e\7"+
		"\16\2\2\u009e\u009f\5\30\r\2\u009f\u00a0\7\31\2\2\u00a0\u00a1\5 \21\2"+
		"\u00a1\u00a2\7\33\2\2\u00a2\u00a3\7&\2\2\u00a3\u00a4\5$\23\2\u00a4\u00a5"+
		"\7\37\2\2\u00a5\u00a7\3\2\2\2\u00a6\u0097\3\2\2\2\u00a6\u009d\3\2\2\2"+
		"\u00a7\25\3\2\2\2\u00a8\u00a9\7\7\2\2\u00a9\u00aa\7,\2\2\u00aa\u00ab\7"+
		"\"\2\2\u00ab\u00ac\5\32\16\2\u00ac\u00ad\7#\2\2\u00ad\u00ae\7\'\2\2\u00ae"+
		"\u00af\5\34\17\2\u00af\u00b0\7\n\2\2\u00b0\u00b2\5\20\t\2\u00b1\u00b3"+
		"\7\37\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\27\3\2\2\2\u00b4"+
		"\u00b5\7,\2\2\u00b5\u00b6\7\'\2\2\u00b6\u00b9\5\34\17\2\u00b7\u00b9\7"+
		",\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\31\3\2\2\2\u00ba\u00c4"+
		"\3\2\2\2\u00bb\u00c0\5\30\r\2\u00bc\u00bd\7(\2\2\u00bd\u00bf\5\30\r\2"+
		"\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00ba\3\2\2\2\u00c3"+
		"\u00bb\3\2\2\2\u00c4\33\3\2\2\2\u00c5\u00de\7,\2\2\u00c6\u00c7\7,\2\2"+
		"\u00c7\u00c8\7\31\2\2\u00c8\u00c9\5\36\20\2\u00c9\u00ca\7\33\2\2\u00ca"+
		"\u00de\3\2\2\2\u00cb\u00cc\7\20\2\2\u00cc\u00cd\7\"\2\2\u00cd\u00ce\5"+
		"\36\20\2\u00ce\u00cf\7#\2\2\u00cf\u00d0\7$\2\2\u00d0\u00d1\5\34\17\2\u00d1"+
		"\u00de\3\2\2\2\u00d2\u00d3\7\21\2\2\u00d3\u00d4\7\"\2\2\u00d4\u00d5\5"+
		" \21\2\u00d5\u00d6\7#\2\2\u00d6\u00d7\7$\2\2\u00d7\u00d8\5\34\17\2\u00d8"+
		"\u00de\3\2\2\2\u00d9\u00da\7\"\2\2\u00da\u00db\5\34\17\2\u00db\u00dc\7"+
		"#\2\2\u00dc\u00de\3\2\2\2\u00dd\u00c5\3\2\2\2\u00dd\u00c6\3\2\2\2\u00dd"+
		"\u00cb\3\2\2\2\u00dd\u00d2\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\35\3\2\2"+
		"\2\u00df\u00e9\3\2\2\2\u00e0\u00e5\5\34\17\2\u00e1\u00e2\7(\2\2\u00e2"+
		"\u00e4\5\34\17\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3"+
		"\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8"+
		"\u00df\3\2\2\2\u00e8\u00e0\3\2\2\2\u00e9\37\3\2\2\2\u00ea\u00f4\3\2\2"+
		"\2\u00eb\u00f0\7,\2\2\u00ec\u00ed\7(\2\2\u00ed\u00ef\7,\2\2\u00ee\u00ec"+
		"\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00ea\3\2\2\2\u00f3\u00eb\3\2"+
		"\2\2\u00f4!\3\2\2\2\u00f5\u00ff\3\2\2\2\u00f6\u00fb\5$\23\2\u00f7\u00f8"+
		"\7(\2\2\u00f8\u00fa\5$\23\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fe\u00f5\3\2\2\2\u00fe\u00f6\3\2\2\2\u00ff#\3\2\2\2\u0100\u0104"+
		"\5(\25\2\u0101\u0104\5&\24\2\u0102\u0104\5*\26\2\u0103\u0100\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104%\3\2\2\2\u0105\u0106\7\31\2\2"+
		"\u0106\u0107\5 \21\2\u0107\u0108\7\33\2\2\u0108\u0109\7%\2\2\u0109\u010a"+
		"\5\20\t\2\u010a\u0112\3\2\2\2\u010b\u010c\7\31\2\2\u010c\u010d\5 \21\2"+
		"\u010d\u010e\7\33\2\2\u010e\u010f\7%\2\2\u010f\u0110\5$\23\2\u0110\u0112"+
		"\3\2\2\2\u0111\u0105\3\2\2\2\u0111\u010b\3\2\2\2\u0112\'\3\2\2\2\u0113"+
		"\u0114\5\30\r\2\u0114\u0115\7%\2\2\u0115\u0116\5\20\t\2\u0116\u0128\3"+
		"\2\2\2\u0117\u0118\7\"\2\2\u0118\u0119\5\32\16\2\u0119\u011a\7#\2\2\u011a"+
		"\u011b\7%\2\2\u011b\u011c\5\20\t\2\u011c\u0128\3\2\2\2\u011d\u011e\5\30"+
		"\r\2\u011e\u011f\7%\2\2\u011f\u0120\5$\23\2\u0120\u0128\3\2\2\2\u0121"+
		"\u0122\7\"\2\2\u0122\u0123\5\32\16\2\u0123\u0124\7#\2\2\u0124\u0125\7"+
		"%\2\2\u0125\u0126\5$\23\2\u0126\u0128\3\2\2\2\u0127\u0113\3\2\2\2\u0127"+
		"\u0117\3\2\2\2\u0127\u011d\3\2\2\2\u0127\u0121\3\2\2\2\u0128)\3\2\2\2"+
		"\u0129\u012f\5,\27\2\u012a\u012b\5,\27\2\u012b\u012c\58\35\2\u012c\u012d"+
		"\5,\27\2\u012d\u012f\3\2\2\2\u012e\u0129\3\2\2\2\u012e\u012a\3\2\2\2\u012f"+
		"+\3\2\2\2\u0130\u0136\5.\30\2\u0131\u0132\5.\30\2\u0132\u0133\5:\36\2"+
		"\u0133\u0134\5.\30\2\u0134\u0136\3\2\2\2\u0135\u0130\3\2\2\2\u0135\u0131"+
		"\3\2\2\2\u0136-\3\2\2\2\u0137\u013d\5\60\31\2\u0138\u0139\5> \2\u0139"+
		"\u013a\5\60\31\2\u013a\u013c\3\2\2\2\u013b\u0138\3\2\2\2\u013c\u013f\3"+
		"\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e/\3\2\2\2\u013f\u013d"+
		"\3\2\2\2\u0140\u0146\5\62\32\2\u0141\u0142\5@!\2\u0142\u0143\5\62\32\2"+
		"\u0143\u0145\3\2\2\2\u0144\u0141\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147\61\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\u014e\5\64\33\2\u014a\u014b\5B\"\2\u014b\u014c\5\62\32\2\u014c\u014e"+
		"\3\2\2\2\u014d\u0149\3\2\2\2\u014d\u014a\3\2\2\2\u014e\63\3\2\2\2\u014f"+
		"\u0150\b\33\1\2\u0150\u0151\5\66\34\2\u0151\u0161\3\2\2\2\u0152\u0153"+
		"\f\6\2\2\u0153\u0154\7)\2\2\u0154\u0160\7,\2\2\u0155\u0156\f\5\2\2\u0156"+
		"\u0157\7\"\2\2\u0157\u0158\5\"\22\2\u0158\u0159\7#\2\2\u0159\u0160\3\2"+
		"\2\2\u015a\u015b\f\4\2\2\u015b\u015c\7\31\2\2\u015c\u015d\5\36\20\2\u015d"+
		"\u015e\7\33\2\2\u015e\u0160\3\2\2\2\u015f\u0152\3\2\2\2\u015f\u0155\3"+
		"\2\2\2\u015f\u015a\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\65\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165\7\"\2"+
		"\2\u0165\u0166\5$\23\2\u0166\u0167\7#\2\2\u0167\u016d\3\2\2\2\u0168\u016d"+
		"\7,\2\2\u0169\u016d\7-\2\2\u016a\u016d\7.\2\2\u016b\u016d\5<\37\2\u016c"+
		"\u0164\3\2\2\2\u016c\u0168\3\2\2\2\u016c\u0169\3\2\2\2\u016c\u016a\3\2"+
		"\2\2\u016c\u016b\3\2\2\2\u016d\67\3\2\2\2\u016e\u016f\t\2\2\2\u016f9\3"+
		"\2\2\2\u0170\u0171\t\3\2\2\u0171;\3\2\2\2\u0172\u0173\t\4\2\2\u0173=\3"+
		"\2\2\2\u0174\u0175\t\5\2\2\u0175?\3\2\2\2\u0176\u0177\t\6\2\2\u0177A\3"+
		"\2\2\2\u0178\u0179\t\7\2\2\u0179C\3\2\2\2 GTej}\u0090\u0095\u00a6\u00b2"+
		"\u00b8\u00c0\u00c3\u00dd\u00e5\u00e8\u00f0\u00f3\u00fb\u00fe\u0103\u0111"+
		"\u0127\u012e\u0135\u013d\u0146\u014d\u015f\u0161\u016c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}