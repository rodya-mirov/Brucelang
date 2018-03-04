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
		TRUE=1, FALSE=2, DECLARE=3, NATIVE=4, DEFINE=5, DO=6, RETURN=7, AS=8, 
		IS=9, IF=10, ELSE=11, LET=12, TYPE=13, FN=14, TYPE_FN=15, AND=16, OR=17, 
		PLUS=18, MINUS=19, TIMES=20, DIVIDE=21, LTE=22, LT=23, GTE=24, GT=25, 
		EQ=26, NEQ=27, NOT=28, SEMI=29, L_CURLY=30, R_CURLY=31, L_PAREN=32, R_PAREN=33, 
		SM_ARROW=34, BIG_ARROW=35, SET_EQ=36, COLON=37, COMMA=38, DOT=39, LINE_COMMENT=40, 
		BLOCK_COMMENT=41, ID=42, INT=43, STRING_CONST=44, ESC_SEQ=45, OCTAL_ESC=46, 
		UNICODE_ESC=47, HEX_DIGIT=48, WS=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TRUE", "FALSE", "DECLARE", "NATIVE", "DEFINE", "DO", "RETURN", "AS", 
		"IS", "IF", "ELSE", "LET", "TYPE", "FN", "TYPE_FN", "AND", "OR", "PLUS", 
		"MINUS", "TIMES", "DIVIDE", "LTE", "LT", "GTE", "GT", "EQ", "NEQ", "NOT", 
		"SEMI", "L_CURLY", "R_CURLY", "L_PAREN", "R_PAREN", "SM_ARROW", "BIG_ARROW", 
		"SET_EQ", "COLON", "COMMA", "DOT", "LINE_COMMENT", "BLOCK_COMMENT", "ID", 
		"INT", "STRING_CONST", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", "HEX_DIGIT", 
		"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u013e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3)\3)\7)\u00ee\n)\f)\16)\u00f1\13)\3)\5)\u00f4\n)\3)\3)\3)\3)\3*\3*"+
		"\3*\3*\7*\u00fe\n*\f*\16*\u0101\13*\3*\3*\3*\3*\3*\3+\3+\7+\u010a\n+\f"+
		"+\16+\u010d\13+\3,\6,\u0110\n,\r,\16,\u0111\3-\3-\3-\7-\u0117\n-\f-\16"+
		"-\u011a\13-\3-\3-\3.\3.\3.\3.\5.\u0122\n.\3/\3/\3/\3/\3/\3/\3/\3/\3/\5"+
		"/\u012d\n/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\62\6\62\u0139"+
		"\n\62\r\62\16\62\u013a\3\62\3\62\3\u00ff\2\63\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63\3\2\n\4\2\f\f\17\17\4\2C\\c|\6\2\62;C\\aac|"+
		"\3\2\62;\4\2$$^^\n\2$$))^^ddhhppttvv\5\2\62;CHch\5\2\13\f\17\17\"\"\2"+
		"\u0149\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5j\3\2\2\2\7p\3\2\2\2\tx\3\2\2\2\13"+
		"\177\3\2\2\2\r\u0086\3\2\2\2\17\u0089\3\2\2\2\21\u0090\3\2\2\2\23\u0093"+
		"\3\2\2\2\25\u0096\3\2\2\2\27\u0099\3\2\2\2\31\u009e\3\2\2\2\33\u00a2\3"+
		"\2\2\2\35\u00a7\3\2\2\2\37\u00aa\3\2\2\2!\u00b1\3\2\2\2#\u00b4\3\2\2\2"+
		"%\u00b7\3\2\2\2\'\u00b9\3\2\2\2)\u00bb\3\2\2\2+\u00bd\3\2\2\2-\u00bf\3"+
		"\2\2\2/\u00c2\3\2\2\2\61\u00c4\3\2\2\2\63\u00c7\3\2\2\2\65\u00c9\3\2\2"+
		"\2\67\u00cc\3\2\2\29\u00cf\3\2\2\2;\u00d1\3\2\2\2=\u00d3\3\2\2\2?\u00d5"+
		"\3\2\2\2A\u00d7\3\2\2\2C\u00d9\3\2\2\2E\u00db\3\2\2\2G\u00de\3\2\2\2I"+
		"\u00e1\3\2\2\2K\u00e3\3\2\2\2M\u00e5\3\2\2\2O\u00e7\3\2\2\2Q\u00e9\3\2"+
		"\2\2S\u00f9\3\2\2\2U\u0107\3\2\2\2W\u010f\3\2\2\2Y\u0113\3\2\2\2[\u0121"+
		"\3\2\2\2]\u012c\3\2\2\2_\u012e\3\2\2\2a\u0135\3\2\2\2c\u0138\3\2\2\2e"+
		"f\7v\2\2fg\7t\2\2gh\7w\2\2hi\7g\2\2i\4\3\2\2\2jk\7h\2\2kl\7c\2\2lm\7n"+
		"\2\2mn\7u\2\2no\7g\2\2o\6\3\2\2\2pq\7f\2\2qr\7g\2\2rs\7e\2\2st\7n\2\2"+
		"tu\7c\2\2uv\7t\2\2vw\7g\2\2w\b\3\2\2\2xy\7p\2\2yz\7c\2\2z{\7v\2\2{|\7"+
		"k\2\2|}\7x\2\2}~\7g\2\2~\n\3\2\2\2\177\u0080\7f\2\2\u0080\u0081\7g\2\2"+
		"\u0081\u0082\7h\2\2\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084\u0085"+
		"\7g\2\2\u0085\f\3\2\2\2\u0086\u0087\7f\2\2\u0087\u0088\7q\2\2\u0088\16"+
		"\3\2\2\2\u0089\u008a\7t\2\2\u008a\u008b\7g\2\2\u008b\u008c\7v\2\2\u008c"+
		"\u008d\7w\2\2\u008d\u008e\7t\2\2\u008e\u008f\7p\2\2\u008f\20\3\2\2\2\u0090"+
		"\u0091\7c\2\2\u0091\u0092\7u\2\2\u0092\22\3\2\2\2\u0093\u0094\7k\2\2\u0094"+
		"\u0095\7u\2\2\u0095\24\3\2\2\2\u0096\u0097\7k\2\2\u0097\u0098\7h\2\2\u0098"+
		"\26\3\2\2\2\u0099\u009a\7g\2\2\u009a\u009b\7n\2\2\u009b\u009c\7u\2\2\u009c"+
		"\u009d\7g\2\2\u009d\30\3\2\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7g\2\2\u00a0"+
		"\u00a1\7v\2\2\u00a1\32\3\2\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4\7{\2\2\u00a4"+
		"\u00a5\7r\2\2\u00a5\u00a6\7g\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\7H\2\2\u00a8"+
		"\u00a9\7p\2\2\u00a9\36\3\2\2\2\u00aa\u00ab\7V\2\2\u00ab\u00ac\7{\2\2\u00ac"+
		"\u00ad\7r\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7H\2\2\u00af\u00b0\7p\2\2"+
		"\u00b0 \3\2\2\2\u00b1\u00b2\7(\2\2\u00b2\u00b3\7(\2\2\u00b3\"\3\2\2\2"+
		"\u00b4\u00b5\7~\2\2\u00b5\u00b6\7~\2\2\u00b6$\3\2\2\2\u00b7\u00b8\7-\2"+
		"\2\u00b8&\3\2\2\2\u00b9\u00ba\7/\2\2\u00ba(\3\2\2\2\u00bb\u00bc\7,\2\2"+
		"\u00bc*\3\2\2\2\u00bd\u00be\7\61\2\2\u00be,\3\2\2\2\u00bf\u00c0\7>\2\2"+
		"\u00c0\u00c1\7?\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7>\2\2\u00c3\60\3\2\2\2"+
		"\u00c4\u00c5\7@\2\2\u00c5\u00c6\7?\2\2\u00c6\62\3\2\2\2\u00c7\u00c8\7"+
		"@\2\2\u00c8\64\3\2\2\2\u00c9\u00ca\7?\2\2\u00ca\u00cb\7?\2\2\u00cb\66"+
		"\3\2\2\2\u00cc\u00cd\7#\2\2\u00cd\u00ce\7?\2\2\u00ce8\3\2\2\2\u00cf\u00d0"+
		"\7#\2\2\u00d0:\3\2\2\2\u00d1\u00d2\7=\2\2\u00d2<\3\2\2\2\u00d3\u00d4\7"+
		"}\2\2\u00d4>\3\2\2\2\u00d5\u00d6\7\177\2\2\u00d6@\3\2\2\2\u00d7\u00d8"+
		"\7*\2\2\u00d8B\3\2\2\2\u00d9\u00da\7+\2\2\u00daD\3\2\2\2\u00db\u00dc\7"+
		"/\2\2\u00dc\u00dd\7@\2\2\u00ddF\3\2\2\2\u00de\u00df\7?\2\2\u00df\u00e0"+
		"\7@\2\2\u00e0H\3\2\2\2\u00e1\u00e2\7?\2\2\u00e2J\3\2\2\2\u00e3\u00e4\7"+
		"<\2\2\u00e4L\3\2\2\2\u00e5\u00e6\7.\2\2\u00e6N\3\2\2\2\u00e7\u00e8\7\60"+
		"\2\2\u00e8P\3\2\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00eb\7\61\2\2\u00eb\u00ef"+
		"\3\2\2\2\u00ec\u00ee\n\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f2\u00f4\7\17\2\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\7\f\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\b)"+
		"\2\2\u00f8R\3\2\2\2\u00f9\u00fa\7\61\2\2\u00fa\u00fb\7,\2\2\u00fb\u00ff"+
		"\3\2\2\2\u00fc\u00fe\13\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2"+
		"\u00ff\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0102\u0103\7,\2\2\u0103\u0104\7\61\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\b*\2\2\u0106T\3\2\2\2\u0107\u010b\t\3\2\2\u0108\u010a\t\4\2\2\u0109"+
		"\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2"+
		"\2\2\u010cV\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0110\t\5\2\2\u010f\u010e"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"X\3\2\2\2\u0113\u0118\7$\2\2\u0114\u0117\5[.\2\u0115\u0117\n\6\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011c\7$\2\2\u011cZ\3\2\2\2\u011d\u011e\7^\2\2\u011e\u0122\t\7\2\2\u011f"+
		"\u0122\5_\60\2\u0120\u0122\5]/\2\u0121\u011d\3\2\2\2\u0121\u011f\3\2\2"+
		"\2\u0121\u0120\3\2\2\2\u0122\\\3\2\2\2\u0123\u0124\7^\2\2\u0124\u0125"+
		"\4\62\65\2\u0125\u0126\4\629\2\u0126\u012d\4\629\2\u0127\u0128\7^\2\2"+
		"\u0128\u0129\4\629\2\u0129\u012d\4\629\2\u012a\u012b\7^\2\2\u012b\u012d"+
		"\4\629\2\u012c\u0123\3\2\2\2\u012c\u0127\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"^\3\2\2\2\u012e\u012f\7^\2\2\u012f\u0130\7w\2\2\u0130\u0131\5a\61\2\u0131"+
		"\u0132\5a\61\2\u0132\u0133\5a\61\2\u0133\u0134\5a\61\2\u0134`\3\2\2\2"+
		"\u0135\u0136\t\b\2\2\u0136b\3\2\2\2\u0137\u0139\t\t\2\2\u0138\u0137\3"+
		"\2\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\b\62\2\2\u013dd\3\2\2\2\r\2\u00ef\u00f3\u00ff"+
		"\u010b\u0111\u0116\u0118\u0121\u012c\u013a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}