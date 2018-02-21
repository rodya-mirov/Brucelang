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
		TRUE=1, FALSE=2, DEFINE=3, DO=4, RETURN=5, AS=6, IS=7, IF=8, ELSE=9, LET=10, 
		AND=11, OR=12, PLUS=13, MINUS=14, TIMES=15, DIVIDE=16, LT=17, LTE=18, 
		GT=19, GTE=20, EQ=21, NEQ=22, SEMI=23, L_CURLY=24, R_CURLY=25, L_PAREN=26, 
		R_PAREN=27, ARROW=28, SET_EQ=29, COLON=30, COMMA=31, DOT=32, LINE_COMMENT=33, 
		BLOCK_COMMENT=34, ID=35, INT=36, STRING_CONST=37, ESC_SEQ=38, OCTAL_ESC=39, 
		UNICODE_ESC=40, HEX_DIGIT=41, WS=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TRUE", "FALSE", "DEFINE", "DO", "RETURN", "AS", "IS", "IF", "ELSE", "LET", 
		"AND", "OR", "PLUS", "MINUS", "TIMES", "DIVIDE", "LT", "LTE", "GT", "GTE", 
		"EQ", "NEQ", "SEMI", "L_CURLY", "R_CURLY", "L_PAREN", "R_PAREN", "ARROW", 
		"SET_EQ", "COLON", "COMMA", "DOT", "LINE_COMMENT", "BLOCK_COMMENT", "ID", 
		"INT", "STRING_CONST", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", "HEX_DIGIT", 
		"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0112\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3\"\3\"\7\"\u00be\n\"\f\"\16\"\u00c1\13\"\3\"\5\""+
		"\u00c4\n\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u00ce\n#\f#\16#\u00d1\13#\3"+
		"#\3#\3#\3#\3#\3$\3$\7$\u00da\n$\f$\16$\u00dd\13$\3%\6%\u00e0\n%\r%\16"+
		"%\u00e1\3&\3&\3&\7&\u00e7\n&\f&\16&\u00ea\13&\3&\3&\3\'\3\'\3\'\3\'\5"+
		"\'\u00f2\n\'\3\'\3\'\5\'\u00f6\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0101"+
		"\n(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3+\6+\u010d\n+\r+\16+\u010e\3+\3+\3\u00cf"+
		"\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\13\4\2\f\f\17\17\4\2C\\c|\6\2\62"+
		";C\\aac|\3\2\62;\4\2$$^^\7\2ddhhppttvv\4\2))^^\5\2\62;CHch\5\2\13\f\17"+
		"\17\"\"\2\u011f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5\\\3\2\2\2\7b\3\2\2\2\ti\3\2\2\2"+
		"\13l\3\2\2\2\rs\3\2\2\2\17v\3\2\2\2\21y\3\2\2\2\23|\3\2\2\2\25\u0081\3"+
		"\2\2\2\27\u0085\3\2\2\2\31\u0089\3\2\2\2\33\u008c\3\2\2\2\35\u008e\3\2"+
		"\2\2\37\u0090\3\2\2\2!\u0092\3\2\2\2#\u0094\3\2\2\2%\u0096\3\2\2\2\'\u0099"+
		"\3\2\2\2)\u009b\3\2\2\2+\u009e\3\2\2\2-\u00a1\3\2\2\2/\u00a4\3\2\2\2\61"+
		"\u00a6\3\2\2\2\63\u00a8\3\2\2\2\65\u00aa\3\2\2\2\67\u00ac\3\2\2\29\u00ae"+
		"\3\2\2\2;\u00b1\3\2\2\2=\u00b3\3\2\2\2?\u00b5\3\2\2\2A\u00b7\3\2\2\2C"+
		"\u00b9\3\2\2\2E\u00c9\3\2\2\2G\u00d7\3\2\2\2I\u00df\3\2\2\2K\u00e3\3\2"+
		"\2\2M\u00f5\3\2\2\2O\u0100\3\2\2\2Q\u0102\3\2\2\2S\u0109\3\2\2\2U\u010c"+
		"\3\2\2\2WX\7v\2\2XY\7t\2\2YZ\7w\2\2Z[\7g\2\2[\4\3\2\2\2\\]\7h\2\2]^\7"+
		"c\2\2^_\7n\2\2_`\7u\2\2`a\7g\2\2a\6\3\2\2\2bc\7f\2\2cd\7g\2\2de\7h\2\2"+
		"ef\7k\2\2fg\7p\2\2gh\7g\2\2h\b\3\2\2\2ij\7f\2\2jk\7q\2\2k\n\3\2\2\2lm"+
		"\7t\2\2mn\7g\2\2no\7v\2\2op\7w\2\2pq\7t\2\2qr\7p\2\2r\f\3\2\2\2st\7c\2"+
		"\2tu\7u\2\2u\16\3\2\2\2vw\7k\2\2wx\7u\2\2x\20\3\2\2\2yz\7k\2\2z{\7h\2"+
		"\2{\22\3\2\2\2|}\7g\2\2}~\7n\2\2~\177\7u\2\2\177\u0080\7g\2\2\u0080\24"+
		"\3\2\2\2\u0081\u0082\7n\2\2\u0082\u0083\7g\2\2\u0083\u0084\7v\2\2\u0084"+
		"\26\3\2\2\2\u0085\u0086\7c\2\2\u0086\u0087\7p\2\2\u0087\u0088\7f\2\2\u0088"+
		"\30\3\2\2\2\u0089\u008a\7q\2\2\u008a\u008b\7t\2\2\u008b\32\3\2\2\2\u008c"+
		"\u008d\7-\2\2\u008d\34\3\2\2\2\u008e\u008f\7/\2\2\u008f\36\3\2\2\2\u0090"+
		"\u0091\7,\2\2\u0091 \3\2\2\2\u0092\u0093\7\61\2\2\u0093\"\3\2\2\2\u0094"+
		"\u0095\7>\2\2\u0095$\3\2\2\2\u0096\u0097\7>\2\2\u0097\u0098\7?\2\2\u0098"+
		"&\3\2\2\2\u0099\u009a\7@\2\2\u009a(\3\2\2\2\u009b\u009c\7@\2\2\u009c\u009d"+
		"\7?\2\2\u009d*\3\2\2\2\u009e\u009f\7?\2\2\u009f\u00a0\7?\2\2\u00a0,\3"+
		"\2\2\2\u00a1\u00a2\7#\2\2\u00a2\u00a3\7?\2\2\u00a3.\3\2\2\2\u00a4\u00a5"+
		"\7=\2\2\u00a5\60\3\2\2\2\u00a6\u00a7\7}\2\2\u00a7\62\3\2\2\2\u00a8\u00a9"+
		"\7\177\2\2\u00a9\64\3\2\2\2\u00aa\u00ab\7*\2\2\u00ab\66\3\2\2\2\u00ac"+
		"\u00ad\7+\2\2\u00ad8\3\2\2\2\u00ae\u00af\7?\2\2\u00af\u00b0\7@\2\2\u00b0"+
		":\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2<\3\2\2\2\u00b3\u00b4\7<\2\2\u00b4>"+
		"\3\2\2\2\u00b5\u00b6\7.\2\2\u00b6@\3\2\2\2\u00b7\u00b8\7\60\2\2\u00b8"+
		"B\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00bb\7\61\2\2\u00bb\u00bf\3\2\2"+
		"\2\u00bc\u00be\n\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2"+
		"\u00c4\7\17\2\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3"+
		"\2\2\2\u00c5\u00c6\7\f\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\"\2\2\u00c8"+
		"D\3\2\2\2\u00c9\u00ca\7\61\2\2\u00ca\u00cb\7,\2\2\u00cb\u00cf\3\2\2\2"+
		"\u00cc\u00ce\13\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2"+
		"\u00d3\7,\2\2\u00d3\u00d4\7\61\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\b#"+
		"\2\2\u00d6F\3\2\2\2\u00d7\u00db\t\3\2\2\u00d8\u00da\t\4\2\2\u00d9\u00d8"+
		"\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"H\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\t\5\2\2\u00df\u00de\3\2\2\2"+
		"\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2J\3"+
		"\2\2\2\u00e3\u00e8\7$\2\2\u00e4\u00e7\5M\'\2\u00e5\u00e7\n\6\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\7$\2\2\u00ecL\3\2\2\2\u00ed\u00f1\7^\2\2\u00ee\u00f2\t\7\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00f2\t\b\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f6\3\2\2\2\u00f3\u00f6\5Q)\2\u00f4\u00f6"+
		"\5O(\2\u00f5\u00ed\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"N\3\2\2\2\u00f7\u00f8\7^\2\2\u00f8\u00f9\4\62\65\2\u00f9\u00fa\4\629\2"+
		"\u00fa\u0101\4\629\2\u00fb\u00fc\7^\2\2\u00fc\u00fd\4\629\2\u00fd\u0101"+
		"\4\629\2\u00fe\u00ff\7^\2\2\u00ff\u0101\4\629\2\u0100\u00f7\3\2\2\2\u0100"+
		"\u00fb\3\2\2\2\u0100\u00fe\3\2\2\2\u0101P\3\2\2\2\u0102\u0103\7^\2\2\u0103"+
		"\u0104\7w\2\2\u0104\u0105\5S*\2\u0105\u0106\5S*\2\u0106\u0107\5S*\2\u0107"+
		"\u0108\5S*\2\u0108R\3\2\2\2\u0109\u010a\t\t\2\2\u010aT\3\2\2\2\u010b\u010d"+
		"\t\n\2\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\b+\2\2\u0111V\3\2\2\2\16"+
		"\2\u00bf\u00c3\u00cf\u00db\u00e1\u00e6\u00e8\u00f1\u00f5\u0100\u010e\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}