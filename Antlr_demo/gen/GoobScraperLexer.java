// Generated from C:/Users/yaeav/Documents/YU/YU Classes/Spring 2019/Compiler/Git Repository/Compilers-Project/Antlr_demo/src/main/java\GoobScraper.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GoobScraperLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		STRING=18, ID=19, NUMBER=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"STRING", "ID", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/get'", "';'", "'/extract'", "'/update'", "'/alert'", "'url'", 
			"'tables'", "'table'", "'append'", "'merge'", "'replace'", "'new'", "'sec'", 
			"'min'", "'hrs'", "'day'", "'mon'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "STRING", "ID", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public GoobScraperLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GoobScraper.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00a4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\23\3\23\7\23\u008d\n\23\f\23\16\23\u0090\13"+
		"\23\3\23\3\23\3\24\6\24\u0095\n\24\r\24\16\24\u0096\3\25\6\25\u009a\n"+
		"\25\r\25\16\25\u009b\3\26\6\26\u009f\n\26\r\26\16\26\u00a0\3\26\3\26\2"+
		"\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\6\5\2\f\f\17\17$$\4\2C\\c|\3\2"+
		"\62;\5\2\13\f\17\17\"\"\2\u00a7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\3-\3\2\2\2\5\62\3\2\2\2\7\64\3\2\2\2\t=\3\2\2\2\13E\3\2\2"+
		"\2\rL\3\2\2\2\17P\3\2\2\2\21W\3\2\2\2\23]\3\2\2\2\25d\3\2\2\2\27j\3\2"+
		"\2\2\31r\3\2\2\2\33v\3\2\2\2\35z\3\2\2\2\37~\3\2\2\2!\u0082\3\2\2\2#\u0086"+
		"\3\2\2\2%\u008a\3\2\2\2\'\u0094\3\2\2\2)\u0099\3\2\2\2+\u009e\3\2\2\2"+
		"-.\7\61\2\2./\7i\2\2/\60\7g\2\2\60\61\7v\2\2\61\4\3\2\2\2\62\63\7=\2\2"+
		"\63\6\3\2\2\2\64\65\7\61\2\2\65\66\7g\2\2\66\67\7z\2\2\678\7v\2\289\7"+
		"t\2\29:\7c\2\2:;\7e\2\2;<\7v\2\2<\b\3\2\2\2=>\7\61\2\2>?\7w\2\2?@\7r\2"+
		"\2@A\7f\2\2AB\7c\2\2BC\7v\2\2CD\7g\2\2D\n\3\2\2\2EF\7\61\2\2FG\7c\2\2"+
		"GH\7n\2\2HI\7g\2\2IJ\7t\2\2JK\7v\2\2K\f\3\2\2\2LM\7w\2\2MN\7t\2\2NO\7"+
		"n\2\2O\16\3\2\2\2PQ\7v\2\2QR\7c\2\2RS\7d\2\2ST\7n\2\2TU\7g\2\2UV\7u\2"+
		"\2V\20\3\2\2\2WX\7v\2\2XY\7c\2\2YZ\7d\2\2Z[\7n\2\2[\\\7g\2\2\\\22\3\2"+
		"\2\2]^\7c\2\2^_\7r\2\2_`\7r\2\2`a\7g\2\2ab\7p\2\2bc\7f\2\2c\24\3\2\2\2"+
		"de\7o\2\2ef\7g\2\2fg\7t\2\2gh\7i\2\2hi\7g\2\2i\26\3\2\2\2jk\7t\2\2kl\7"+
		"g\2\2lm\7r\2\2mn\7n\2\2no\7c\2\2op\7e\2\2pq\7g\2\2q\30\3\2\2\2rs\7p\2"+
		"\2st\7g\2\2tu\7y\2\2u\32\3\2\2\2vw\7u\2\2wx\7g\2\2xy\7e\2\2y\34\3\2\2"+
		"\2z{\7o\2\2{|\7k\2\2|}\7p\2\2}\36\3\2\2\2~\177\7j\2\2\177\u0080\7t\2\2"+
		"\u0080\u0081\7u\2\2\u0081 \3\2\2\2\u0082\u0083\7f\2\2\u0083\u0084\7c\2"+
		"\2\u0084\u0085\7{\2\2\u0085\"\3\2\2\2\u0086\u0087\7o\2\2\u0087\u0088\7"+
		"q\2\2\u0088\u0089\7p\2\2\u0089$\3\2\2\2\u008a\u008e\7$\2\2\u008b\u008d"+
		"\n\2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7$"+
		"\2\2\u0092&\3\2\2\2\u0093\u0095\t\3\2\2\u0094\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097(\3\2\2\2\u0098"+
		"\u009a\t\4\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c*\3\2\2\2\u009d\u009f\t\5\2\2\u009e\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a3\b\26\2\2\u00a3,\3\2\2\2\7\2\u008e\u0096\u009b"+
		"\u00a0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}