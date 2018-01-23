// Generated from /Users/richard.rast/personal/brucelang/src/main/antlr/Brucelang.g4 by ANTLR 4.7

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, TRUE=9, 
		FALSE=10, DEFINE=11, DO=12, RETURN=13, AS=14, IS=15, IF=16, ELSE=17, LET=18, 
		STRING_CONST=19, AND=20, OR=21, PLUS=22, MINUS=23, TIMES=24, DIVIDE=25, 
		LT=26, LTE=27, GT=28, GTE=29, EQ=30, NEQ=31, ID=32, INT=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "TRUE", 
		"FALSE", "DEFINE", "DO", "RETURN", "AS", "IS", "IF", "ELSE", "LET", "STRING_CONST", 
		"AND", "OR", "PLUS", "MINUS", "TIMES", "DIVIDE", "LT", "LTE", "GT", "GTE", 
		"EQ", "NEQ", "ID", "INT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'{'", "'}'", "'('", "')'", "'='", "','", "'\"'", "'true'", 
		"'false'", "'define'", "'do'", "'return'", "'as'", "'is'", "'if'", "'else'", 
		"'let'", null, "'and'", "'or'", "'+'", "'-'", "'*'", "'/'", "'<'", "'<='", 
		"'>'", "'>='", "'=='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "TRUE", "FALSE", 
		"DEFINE", "DO", "RETURN", "AS", "IS", "IF", "ELSE", "LET", "STRING_CONST", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00bc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\24\6\24\u0087\n\24\r\24\16\24\u0088\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3"+
		"!\7!\u00ac\n!\f!\16!\u00af\13!\3\"\6\"\u00b2\n\"\r\"\16\"\u00b3\3#\6#"+
		"\u00b7\n#\r#\16#\u00b8\3#\3#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\7\4\2$$``\6\2CC\\\\aa"+
		"c|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2\u00bf\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2\7K\3"+
		"\2\2\2\tM\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17S\3\2\2\2\21U\3\2\2\2\23W\3"+
		"\2\2\2\25\\\3\2\2\2\27b\3\2\2\2\31i\3\2\2\2\33l\3\2\2\2\35s\3\2\2\2\37"+
		"v\3\2\2\2!y\3\2\2\2#|\3\2\2\2%\u0081\3\2\2\2\'\u0086\3\2\2\2)\u008a\3"+
		"\2\2\2+\u008e\3\2\2\2-\u0091\3\2\2\2/\u0093\3\2\2\2\61\u0095\3\2\2\2\63"+
		"\u0097\3\2\2\2\65\u0099\3\2\2\2\67\u009b\3\2\2\29\u009e\3\2\2\2;\u00a0"+
		"\3\2\2\2=\u00a3\3\2\2\2?\u00a6\3\2\2\2A\u00a9\3\2\2\2C\u00b1\3\2\2\2E"+
		"\u00b6\3\2\2\2GH\7=\2\2H\4\3\2\2\2IJ\7}\2\2J\6\3\2\2\2KL\7\177\2\2L\b"+
		"\3\2\2\2MN\7*\2\2N\n\3\2\2\2OP\7+\2\2P\f\3\2\2\2QR\7?\2\2R\16\3\2\2\2"+
		"ST\7.\2\2T\20\3\2\2\2UV\7$\2\2V\22\3\2\2\2WX\7v\2\2XY\7t\2\2YZ\7w\2\2"+
		"Z[\7g\2\2[\24\3\2\2\2\\]\7h\2\2]^\7c\2\2^_\7n\2\2_`\7u\2\2`a\7g\2\2a\26"+
		"\3\2\2\2bc\7f\2\2cd\7g\2\2de\7h\2\2ef\7k\2\2fg\7p\2\2gh\7g\2\2h\30\3\2"+
		"\2\2ij\7f\2\2jk\7q\2\2k\32\3\2\2\2lm\7t\2\2mn\7g\2\2no\7v\2\2op\7w\2\2"+
		"pq\7t\2\2qr\7p\2\2r\34\3\2\2\2st\7c\2\2tu\7u\2\2u\36\3\2\2\2vw\7k\2\2"+
		"wx\7u\2\2x \3\2\2\2yz\7k\2\2z{\7h\2\2{\"\3\2\2\2|}\7g\2\2}~\7n\2\2~\177"+
		"\7u\2\2\177\u0080\7g\2\2\u0080$\3\2\2\2\u0081\u0082\7n\2\2\u0082\u0083"+
		"\7g\2\2\u0083\u0084\7v\2\2\u0084&\3\2\2\2\u0085\u0087\t\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"(\3\2\2\2\u008a\u008b\7c\2\2\u008b\u008c\7p\2\2\u008c\u008d\7f\2\2\u008d"+
		"*\3\2\2\2\u008e\u008f\7q\2\2\u008f\u0090\7t\2\2\u0090,\3\2\2\2\u0091\u0092"+
		"\7-\2\2\u0092.\3\2\2\2\u0093\u0094\7/\2\2\u0094\60\3\2\2\2\u0095\u0096"+
		"\7,\2\2\u0096\62\3\2\2\2\u0097\u0098\7\61\2\2\u0098\64\3\2\2\2\u0099\u009a"+
		"\7>\2\2\u009a\66\3\2\2\2\u009b\u009c\7>\2\2\u009c\u009d\7?\2\2\u009d8"+
		"\3\2\2\2\u009e\u009f\7@\2\2\u009f:\3\2\2\2\u00a0\u00a1\7@\2\2\u00a1\u00a2"+
		"\7?\2\2\u00a2<\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4\u00a5\7?\2\2\u00a5>\3"+
		"\2\2\2\u00a6\u00a7\7#\2\2\u00a7\u00a8\7?\2\2\u00a8@\3\2\2\2\u00a9\u00ad"+
		"\t\3\2\2\u00aa\u00ac\t\4\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00aeB\3\2\2\2\u00af\u00ad\3\2\2\2"+
		"\u00b0\u00b2\t\5\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4D\3\2\2\2\u00b5\u00b7\t\6\2\2\u00b6"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\b#\2\2\u00bbF\3\2\2\2\7\2\u0088\u00ad"+
		"\u00b3\u00b8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}