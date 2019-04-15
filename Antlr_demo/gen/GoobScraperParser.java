// Generated from C:/Users/yaeav/Documents/YU/YU Classes/Spring 2019/Compiler/Git Repository/Compilers-Project/Antlr_demo/src/main/java\GoobScraper.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GoobScraperParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, STRING=16, 
		ID=17, NUMBER=18, WS=19;
	public static final int
		RULE_program = 0, RULE_statment = 1, RULE_get = 2, RULE_extract = 3, RULE_update = 4, 
		RULE_alert = 5, RULE_time = 6, RULE_word = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statment", "get", "extract", "update", "alert", "time", "word"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/get'", "';'", "'/extract'", "'/update'", "'/alert'", "'/quit'", 
			"'url'", "'tables'", "'table'", "'append'", "'new'", "'sec'", "'min'", 
			"'hrs'", "'day'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "STRING", "ID", "NUMBER", "WS"
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

	@Override
	public String getGrammarFileName() { return "GoobScraper.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GoobScraperParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				statment();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0) );
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

	public static class StatmentContext extends ParserRuleContext {
		public StatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statment; }
	 
		public StatmentContext() { }
		public void copyFrom(StatmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GetStatmentContext extends StatmentContext {
		public GetContext get() {
			return getRuleContext(GetContext.class,0);
		}
		public GetStatmentContext(StatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterGetStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitGetStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitGetStatment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UpdateStatmentContext extends StatmentContext {
		public UpdateContext update() {
			return getRuleContext(UpdateContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public UpdateStatmentContext(StatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterUpdateStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitUpdateStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitUpdateStatment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtractStatmentContext extends StatmentContext {
		public ExtractContext extract() {
			return getRuleContext(ExtractContext.class,0);
		}
		public ExtractStatmentContext(StatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterExtractStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitExtractStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitExtractStatment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlertStatmentContext extends StatmentContext {
		public AlertContext alert() {
			return getRuleContext(AlertContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public AlertStatmentContext(StatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterAlertStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitAlertStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitAlertStatment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuitStatmentContext extends StatmentContext {
		public QuitStatmentContext(StatmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterQuitStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitQuitStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitQuitStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatmentContext statment() throws RecognitionException {
		StatmentContext _localctx = new StatmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statment);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new GetStatmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				match(T__0);
				setState(22);
				get();
				setState(23);
				match(T__1);
				}
				break;
			case T__2:
				_localctx = new ExtractStatmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(T__2);
				setState(26);
				extract();
				setState(27);
				match(T__1);
				}
				break;
			case T__3:
				_localctx = new UpdateStatmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				match(T__3);
				setState(30);
				update();
				setState(32);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(31);
					word();
					}
					break;
				}
				setState(34);
				time();
				setState(35);
				match(T__1);
				}
				break;
			case T__4:
				_localctx = new AlertStatmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				match(T__4);
				setState(38);
				alert();
				setState(39);
				time();
				setState(40);
				match(T__1);
				}
				break;
			case T__5:
				_localctx = new QuitStatmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				match(T__5);
				setState(43);
				match(T__1);
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

	public static class GetContext extends ParserRuleContext {
		public GetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get; }
	 
		public GetContext() { }
		public void copyFrom(GetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GetTableContext extends GetContext {
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public GetTableContext(GetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterGetTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitGetTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitGetTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetURLContext extends GetContext {
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public GetURLContext(GetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterGetURL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitGetURL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitGetURL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RegularGetContext extends GetContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public RegularGetContext(GetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterRegularGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitRegularGet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitRegularGet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetContext get() throws RecognitionException {
		GetContext _localctx = new GetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_get);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case ID:
			case NUMBER:
				_localctx = new RegularGetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(46);
				word();
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << ID) | (1L << NUMBER))) != 0)) {
					{
					setState(47);
					word();
					}
				}

				}
				break;
			case T__6:
				_localctx = new GetURLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(T__6);
				{
				setState(51);
				word();
				}
				}
				break;
			case T__7:
			case T__8:
				_localctx = new GetTableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << ID) | (1L << NUMBER))) != 0)) {
					{
					setState(53);
					word();
					}
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

	public static class ExtractContext extends ParserRuleContext {
		public ExtractContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract; }
	 
		public ExtractContext() { }
		public void copyFrom(ExtractContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExtractAppendContext extends ExtractContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public ExtractAppendContext(ExtractContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterExtractAppend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitExtractAppend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitExtractAppend(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtractNewContext extends ExtractContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public ExtractNewContext(ExtractContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterExtractNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitExtractNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitExtractNew(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtractContext extract() throws RecognitionException {
		ExtractContext _localctx = new ExtractContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_extract);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				_localctx = new ExtractAppendContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__9);
				setState(60);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(59);
					word();
					}
					break;
				}
				{
				setState(62);
				word();
				}
				}
				break;
			case T__10:
				_localctx = new ExtractNewContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__10);
				setState(65);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(64);
					word();
					}
					break;
				}
				{
				setState(67);
				word();
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

	public static class UpdateContext extends ParserRuleContext {
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
	 
		public UpdateContext() { }
		public void copyFrom(UpdateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UpdateNewContext extends UpdateContext {
		public UpdateNewContext(UpdateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterUpdateNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitUpdateNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitUpdateNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UpdateAppendContext extends UpdateContext {
		public UpdateAppendContext(UpdateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterUpdateAppend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitUpdateAppend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitUpdateAppend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_update);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				_localctx = new UpdateAppendContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new UpdateNewContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(T__10);
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

	public static class AlertContext extends ParserRuleContext {
		public AlertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alert; }
	 
		public AlertContext() { }
		public void copyFrom(AlertContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AlertEmptyContext extends AlertContext {
		public AlertEmptyContext(AlertContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterAlertEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitAlertEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitAlertEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlertWordContext extends AlertContext {
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public AlertWordContext(AlertContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterAlertWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitAlertWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitAlertWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlertContext alert() throws RecognitionException {
		AlertContext _localctx = new AlertContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_alert);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new AlertWordContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				word();
				}
				break;
			case 2:
				_localctx = new AlertEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
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

	public static class TimeContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(GoobScraperParser.NUMBER, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(NUMBER);
			setState(79);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
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

	public static class WordContext extends ParserRuleContext {
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
	 
		public WordContext() { }
		public void copyFrom(WordContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WordIDContext extends WordContext {
		public TerminalNode ID() { return getToken(GoobScraperParser.ID, 0); }
		public WordIDContext(WordContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterWordID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitWordID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitWordID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WordNumberContext extends WordContext {
		public TerminalNode NUMBER() { return getToken(GoobScraperParser.NUMBER, 0); }
		public WordNumberContext(WordContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterWordNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitWordNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitWordNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WordStringContext extends WordContext {
		public TerminalNode STRING() { return getToken(GoobScraperParser.STRING, 0); }
		public WordStringContext(WordContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).enterWordString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoobScraperListener ) ((GoobScraperListener)listener).exitWordString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GoobScraperVisitor ) return ((GoobScraperVisitor<? extends T>)visitor).visitWordString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_word);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new WordIDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(ID);
				}
				break;
			case NUMBER:
				_localctx = new WordNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new WordStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				match(STRING);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25Y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n\2\r\2"+
		"\16\2\25\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\5\4\63\n\4\3\4\3\4\3"+
		"\4\3\4\5\49\n\4\5\4;\n\4\3\5\3\5\5\5?\n\5\3\5\3\5\3\5\5\5D\n\5\3\5\5\5"+
		"G\n\5\3\6\3\6\5\6K\n\6\3\7\3\7\5\7O\n\7\3\b\3\b\3\b\3\t\3\t\3\t\5\tW\n"+
		"\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\4\3\2\n\13\3\2\16\21\2a\2\23\3\2\2\2"+
		"\4.\3\2\2\2\6:\3\2\2\2\bF\3\2\2\2\nJ\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20"+
		"V\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26"+
		"\3\2\2\2\26\3\3\2\2\2\27\30\7\3\2\2\30\31\5\6\4\2\31\32\7\4\2\2\32/\3"+
		"\2\2\2\33\34\7\5\2\2\34\35\5\b\5\2\35\36\7\4\2\2\36/\3\2\2\2\37 \7\6\2"+
		"\2 \"\5\n\6\2!#\5\20\t\2\"!\3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\5\16\b\2%&"+
		"\7\4\2\2&/\3\2\2\2\'(\7\7\2\2()\5\f\7\2)*\5\16\b\2*+\7\4\2\2+/\3\2\2\2"+
		",-\7\b\2\2-/\7\4\2\2.\27\3\2\2\2.\33\3\2\2\2.\37\3\2\2\2.\'\3\2\2\2.,"+
		"\3\2\2\2/\5\3\2\2\2\60\62\5\20\t\2\61\63\5\20\t\2\62\61\3\2\2\2\62\63"+
		"\3\2\2\2\63;\3\2\2\2\64\65\7\t\2\2\65;\5\20\t\2\668\t\2\2\2\679\5\20\t"+
		"\28\67\3\2\2\289\3\2\2\29;\3\2\2\2:\60\3\2\2\2:\64\3\2\2\2:\66\3\2\2\2"+
		";\7\3\2\2\2<>\7\f\2\2=?\5\20\t\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@G\5\20"+
		"\t\2AC\7\r\2\2BD\5\20\t\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EG\5\20\t\2F<\3"+
		"\2\2\2FA\3\2\2\2G\t\3\2\2\2HK\7\f\2\2IK\7\r\2\2JH\3\2\2\2JI\3\2\2\2K\13"+
		"\3\2\2\2LO\5\20\t\2MO\3\2\2\2NL\3\2\2\2NM\3\2\2\2O\r\3\2\2\2PQ\7\24\2"+
		"\2QR\t\3\2\2R\17\3\2\2\2SW\7\23\2\2TW\7\24\2\2UW\7\22\2\2VS\3\2\2\2VT"+
		"\3\2\2\2VU\3\2\2\2W\21\3\2\2\2\16\25\".\628:>CFJNV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}