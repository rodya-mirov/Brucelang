// Generated from /Users/richard.rast/personal/Brucelang/src/main/antlr/Brucelang.g4 by ANTLR 4.7

package io.rodyamirov.brucelang.lexparse;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BrucelangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BOOL_OP", "COMP_OP", "BOOL_VAL", "ADD_OP", "MUL_OP", "UNARY_OP", "TRUE", 
		"FALSE", "DECLARE", "NATIVE", "DEFINE", "DO", "RETURN", "AS", "IS", "IF", 
		"ELSE", "LET", "TYPE", "FN", "AND", "OR", "PLUS", "MINUS", "TIMES", "DIVIDE", 
		"LT", "LTE", "GT", "GTE", "EQ", "NEQ", "NOT", "SEMI", "L_CURLY", "R_CURLY", 
		"L_PAREN", "R_PAREN", "SM_ARROW", "BIG_ARROW", "SET_EQ", "COLON", "COMMA", 
		"DOT", "LINE_COMMENT", "BLOCK_COMMENT", "ID", "INT", "STRING_CONST", "ESC_SEQ", 
		"OCTAL_ESC", "UNICODE_ESC", "HEX_DIGIT", "WS"
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


	public BrucelangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Brucelang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u015d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\5\2r\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3z\n\3\3\4\3\4\5\4~\n\4\3\5\3\5\5\5\u0082\n\5\3\6\3\6\5\6\u0086"+
		"\n\6\3\7\3\7\5\7\u008a\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3"+
		"-\3-\3.\3.\3.\3.\7.\u010d\n.\f.\16.\u0110\13.\3.\5.\u0113\n.\3.\3.\3."+
		"\3.\3/\3/\3/\3/\7/\u011d\n/\f/\16/\u0120\13/\3/\3/\3/\3/\3/\3\60\3\60"+
		"\7\60\u0129\n\60\f\60\16\60\u012c\13\60\3\61\6\61\u012f\n\61\r\61\16\61"+
		"\u0130\3\62\3\62\3\62\7\62\u0136\n\62\f\62\16\62\u0139\13\62\3\62\3\62"+
		"\3\63\3\63\3\63\3\63\5\63\u0141\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\5\64\u014c\n\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\67\6\67\u0158\n\67\r\67\16\67\u0159\3\67\3\67\3\u011e\28\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8\3\2\n\4\2"+
		"\f\f\17\17\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\4\2$$^^\n\2$$))^^ddhhppttv"+
		"v\5\2\62;CHch\5\2\13\f\17\17\"\"\2\u0172\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3q\3\2\2\2\5y\3\2\2\2\7}\3"+
		"\2\2\2\t\u0081\3\2\2\2\13\u0085\3\2\2\2\r\u0089\3\2\2\2\17\u008b\3\2\2"+
		"\2\21\u0090\3\2\2\2\23\u0096\3\2\2\2\25\u009e\3\2\2\2\27\u00a5\3\2\2\2"+
		"\31\u00ac\3\2\2\2\33\u00af\3\2\2\2\35\u00b6\3\2\2\2\37\u00b9\3\2\2\2!"+
		"\u00bc\3\2\2\2#\u00bf\3\2\2\2%\u00c4\3\2\2\2\'\u00c8\3\2\2\2)\u00cd\3"+
		"\2\2\2+\u00d0\3\2\2\2-\u00d3\3\2\2\2/\u00d6\3\2\2\2\61\u00d8\3\2\2\2\63"+
		"\u00da\3\2\2\2\65\u00dc\3\2\2\2\67\u00de\3\2\2\29\u00e0\3\2\2\2;\u00e3"+
		"\3\2\2\2=\u00e5\3\2\2\2?\u00e8\3\2\2\2A\u00eb\3\2\2\2C\u00ee\3\2\2\2E"+
		"\u00f0\3\2\2\2G\u00f2\3\2\2\2I\u00f4\3\2\2\2K\u00f6\3\2\2\2M\u00f8\3\2"+
		"\2\2O\u00fa\3\2\2\2Q\u00fd\3\2\2\2S\u0100\3\2\2\2U\u0102\3\2\2\2W\u0104"+
		"\3\2\2\2Y\u0106\3\2\2\2[\u0108\3\2\2\2]\u0118\3\2\2\2_\u0126\3\2\2\2a"+
		"\u012e\3\2\2\2c\u0132\3\2\2\2e\u0140\3\2\2\2g\u014b\3\2\2\2i\u014d\3\2"+
		"\2\2k\u0154\3\2\2\2m\u0157\3\2\2\2or\5+\26\2pr\5-\27\2qo\3\2\2\2qp\3\2"+
		"\2\2r\4\3\2\2\2sz\5;\36\2tz\5=\37\2uz\5\67\34\2vz\59\35\2wz\5? \2xz\5"+
		"A!\2ys\3\2\2\2yt\3\2\2\2yu\3\2\2\2yv\3\2\2\2yw\3\2\2\2yx\3\2\2\2z\6\3"+
		"\2\2\2{~\5\17\b\2|~\5\21\t\2}{\3\2\2\2}|\3\2\2\2~\b\3\2\2\2\177\u0082"+
		"\5/\30\2\u0080\u0082\5\61\31\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082"+
		"\n\3\2\2\2\u0083\u0086\5\63\32\2\u0084\u0086\5\65\33\2\u0085\u0083\3\2"+
		"\2\2\u0085\u0084\3\2\2\2\u0086\f\3\2\2\2\u0087\u008a\5\61\31\2\u0088\u008a"+
		"\5C\"\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\16\3\2\2\2\u008b"+
		"\u008c\7v\2\2\u008c\u008d\7t\2\2\u008d\u008e\7w\2\2\u008e\u008f\7g\2\2"+
		"\u008f\20\3\2\2\2\u0090\u0091\7h\2\2\u0091\u0092\7c\2\2\u0092\u0093\7"+
		"n\2\2\u0093\u0094\7u\2\2\u0094\u0095\7g\2\2\u0095\22\3\2\2\2\u0096\u0097"+
		"\7f\2\2\u0097\u0098\7g\2\2\u0098\u0099\7e\2\2\u0099\u009a\7n\2\2\u009a"+
		"\u009b\7c\2\2\u009b\u009c\7t\2\2\u009c\u009d\7g\2\2\u009d\24\3\2\2\2\u009e"+
		"\u009f\7p\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7k\2\2"+
		"\u00a2\u00a3\7x\2\2\u00a3\u00a4\7g\2\2\u00a4\26\3\2\2\2\u00a5\u00a6\7"+
		"f\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa"+
		"\7p\2\2\u00aa\u00ab\7g\2\2\u00ab\30\3\2\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae"+
		"\7q\2\2\u00ae\32\3\2\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2"+
		"\7v\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7p\2\2\u00b5"+
		"\34\3\2\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7u\2\2\u00b8\36\3\2\2\2\u00b9"+
		"\u00ba\7k\2\2\u00ba\u00bb\7u\2\2\u00bb \3\2\2\2\u00bc\u00bd\7k\2\2\u00bd"+
		"\u00be\7h\2\2\u00be\"\3\2\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7n\2\2\u00c1"+
		"\u00c2\7u\2\2\u00c2\u00c3\7g\2\2\u00c3$\3\2\2\2\u00c4\u00c5\7n\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6\u00c7\7v\2\2\u00c7&\3\2\2\2\u00c8\u00c9\7v\2\2\u00c9"+
		"\u00ca\7{\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7g\2\2\u00cc(\3\2\2\2\u00cd"+
		"\u00ce\7H\2\2\u00ce\u00cf\7p\2\2\u00cf*\3\2\2\2\u00d0\u00d1\7(\2\2\u00d1"+
		"\u00d2\7(\2\2\u00d2,\3\2\2\2\u00d3\u00d4\7~\2\2\u00d4\u00d5\7~\2\2\u00d5"+
		".\3\2\2\2\u00d6\u00d7\7-\2\2\u00d7\60\3\2\2\2\u00d8\u00d9\7/\2\2\u00d9"+
		"\62\3\2\2\2\u00da\u00db\7,\2\2\u00db\64\3\2\2\2\u00dc\u00dd\7\61\2\2\u00dd"+
		"\66\3\2\2\2\u00de\u00df\7>\2\2\u00df8\3\2\2\2\u00e0\u00e1\7>\2\2\u00e1"+
		"\u00e2\7?\2\2\u00e2:\3\2\2\2\u00e3\u00e4\7@\2\2\u00e4<\3\2\2\2\u00e5\u00e6"+
		"\7@\2\2\u00e6\u00e7\7?\2\2\u00e7>\3\2\2\2\u00e8\u00e9\7?\2\2\u00e9\u00ea"+
		"\7?\2\2\u00ea@\3\2\2\2\u00eb\u00ec\7#\2\2\u00ec\u00ed\7?\2\2\u00edB\3"+
		"\2\2\2\u00ee\u00ef\7#\2\2\u00efD\3\2\2\2\u00f0\u00f1\7=\2\2\u00f1F\3\2"+
		"\2\2\u00f2\u00f3\7}\2\2\u00f3H\3\2\2\2\u00f4\u00f5\7\177\2\2\u00f5J\3"+
		"\2\2\2\u00f6\u00f7\7*\2\2\u00f7L\3\2\2\2\u00f8\u00f9\7+\2\2\u00f9N\3\2"+
		"\2\2\u00fa\u00fb\7/\2\2\u00fb\u00fc\7@\2\2\u00fcP\3\2\2\2\u00fd\u00fe"+
		"\7?\2\2\u00fe\u00ff\7@\2\2\u00ffR\3\2\2\2\u0100\u0101\7?\2\2\u0101T\3"+
		"\2\2\2\u0102\u0103\7<\2\2\u0103V\3\2\2\2\u0104\u0105\7.\2\2\u0105X\3\2"+
		"\2\2\u0106\u0107\7\60\2\2\u0107Z\3\2\2\2\u0108\u0109\7\61\2\2\u0109\u010a"+
		"\7\61\2\2\u010a\u010e\3\2\2\2\u010b\u010d\n\2\2\2\u010c\u010b\3\2\2\2"+
		"\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0112"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\7\17\2\2\u0112\u0111\3\2\2\2"+
		"\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\7\f\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\u0117\b.\2\2\u0117\\\3\2\2\2\u0118\u0119\7\61\2\2\u0119"+
		"\u011a\7,\2\2\u011a\u011e\3\2\2\2\u011b\u011d\13\2\2\2\u011c\u011b\3\2"+
		"\2\2\u011d\u0120\3\2\2\2\u011e\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7,\2\2\u0122\u0123\7\61"+
		"\2\2\u0123\u0124\3\2\2\2\u0124\u0125\b/\2\2\u0125^\3\2\2\2\u0126\u012a"+
		"\t\3\2\2\u0127\u0129\t\4\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b`\3\2\2\2\u012c\u012a\3\2\2\2"+
		"\u012d\u012f\t\5\2\2\u012e\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u012e"+
		"\3\2\2\2\u0130\u0131\3\2\2\2\u0131b\3\2\2\2\u0132\u0137\7$\2\2\u0133\u0136"+
		"\5e\63\2\u0134\u0136\n\6\2\2\u0135\u0133\3\2\2\2\u0135\u0134\3\2\2\2\u0136"+
		"\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u013a\u013b\7$\2\2\u013bd\3\2\2\2\u013c\u013d"+
		"\7^\2\2\u013d\u0141\t\7\2\2\u013e\u0141\5i\65\2\u013f\u0141\5g\64\2\u0140"+
		"\u013c\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141f\3\2\2\2"+
		"\u0142\u0143\7^\2\2\u0143\u0144\4\62\65\2\u0144\u0145\4\629\2\u0145\u014c"+
		"\4\629\2\u0146\u0147\7^\2\2\u0147\u0148\4\629\2\u0148\u014c\4\629\2\u0149"+
		"\u014a\7^\2\2\u014a\u014c\4\629\2\u014b\u0142\3\2\2\2\u014b\u0146\3\2"+
		"\2\2\u014b\u0149\3\2\2\2\u014ch\3\2\2\2\u014d\u014e\7^\2\2\u014e\u014f"+
		"\7w\2\2\u014f\u0150\5k\66\2\u0150\u0151\5k\66\2\u0151\u0152\5k\66\2\u0152"+
		"\u0153\5k\66\2\u0153j\3\2\2\2\u0154\u0155\t\b\2\2\u0155l\3\2\2\2\u0156"+
		"\u0158\t\t\2\2\u0157\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2"+
		"\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\b\67\2\2\u015c"+
		"n\3\2\2\2\23\2qy}\u0081\u0085\u0089\u010e\u0112\u011e\u012a\u0130\u0135"+
		"\u0137\u0140\u014b\u0159\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}