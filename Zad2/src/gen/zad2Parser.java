package gen;// Generated from /home/adam/Uczelnia/JFTT/L3/Zad2/zad2.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class zad2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, ENDLINE=2, BACKSLASH=3, WHITESPACE=4, CHARACTERS=5, LBRACKET=6, 
		RBRACKET=7, PWR=8, MUL=9, DIV=10, MOD=11, ADD=12, SUB=13, NUMBER=14;
	public static final int
		RULE_start = 0, RULE_line = 1, RULE_comment = 2, RULE_expression = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "line", "comment", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#'", null, "'\\'", null, null, "'('", "')'", "'^'", "'*'", "'/'", 
			"'%'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "ENDLINE", "BACKSLASH", "WHITESPACE", "CHARACTERS", 
			"LBRACKET", "RBRACKET", "PWR", "MUL", "DIV", "MOD", "ADD", "SUB", "NUMBER"
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
	public String getGrammarFileName() { return "zad2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public zad2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(zad2Parser.EOF, 0); }
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		return start(0);
	}

	private StartContext start(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StartContext _localctx = new StartContext(_ctx, _parentState);
		StartContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_start, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(10);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(9);
				match(EOF);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(16);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StartContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_start);
					setState(12);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(13);
					line();
					}
					} 
				}
				setState(18);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	 
		public LineContext() { }
		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CommentaryContext extends LineContext {
		public TerminalNode COMMENT() { return getToken(zad2Parser.COMMENT, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public CommentaryContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterCommentary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitCommentary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitCommentary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends LineContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(zad2Parser.ENDLINE, 0); }
		public PrintContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NothingContext extends LineContext {
		public TerminalNode ENDLINE() { return getToken(zad2Parser.ENDLINE, 0); }
		public NothingContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterNothing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitNothing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitNothing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(25);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENDLINE:
				_localctx = new NothingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(ENDLINE);
				}
				break;
			case COMMENT:
				_localctx = new CommentaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				match(COMMENT);
				setState(21);
				comment();
				}
				break;
			case LBRACKET:
			case SUB:
			case NUMBER:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				expression(0);
				setState(23);
				match(ENDLINE);
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode BACKSLASH() { return getToken(zad2Parser.BACKSLASH, 0); }
		public TerminalNode ENDLINE() { return getToken(zad2Parser.ENDLINE, 0); }
		public TerminalNode EOF() { return getToken(zad2Parser.EOF, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TerminalNode CHARACTERS() { return getToken(zad2Parser.CHARACTERS, 0); }
		public TerminalNode NUMBER() { return getToken(zad2Parser.NUMBER, 0); }
		public TerminalNode PWR() { return getToken(zad2Parser.PWR, 0); }
		public TerminalNode ADD() { return getToken(zad2Parser.ADD, 0); }
		public TerminalNode SUB() { return getToken(zad2Parser.SUB, 0); }
		public TerminalNode DIV() { return getToken(zad2Parser.DIV, 0); }
		public TerminalNode MUL() { return getToken(zad2Parser.MUL, 0); }
		public TerminalNode MOD() { return getToken(zad2Parser.MOD, 0); }
		public TerminalNode COMMENT() { return getToken(zad2Parser.COMMENT, 0); }
		public TerminalNode LBRACKET() { return getToken(zad2Parser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(zad2Parser.RBRACKET, 0); }
		public TerminalNode WHITESPACE() { return getToken(zad2Parser.WHITESPACE, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comment);
		int _la;
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BACKSLASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(BACKSLASH);
				setState(28);
				match(ENDLINE);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				match(EOF);
				setState(30);
				comment();
				}
				break;
			case COMMENT:
			case WHITESPACE:
			case CHARACTERS:
			case LBRACKET:
			case RBRACKET:
			case PWR:
			case MUL:
			case DIV:
			case MOD:
			case ADD:
			case SUB:
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << WHITESPACE) | (1L << CHARACTERS) | (1L << LBRACKET) | (1L << RBRACKET) | (1L << PWR) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << ADD) | (1L << SUB) | (1L << NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(32);
				comment();
				}
				break;
			case ENDLINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				match(ENDLINE);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumerContext extends ExpressionContext {
		public Token operator;
		public TerminalNode NUMBER() { return getToken(zad2Parser.NUMBER, 0); }
		public TerminalNode SUB() { return getToken(zad2Parser.SUB, 0); }
		public NumerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterNumer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitNumer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitNumer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(zad2Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(zad2Parser.DIV, 0); }
		public TerminalNode MOD() { return getToken(zad2Parser.MOD, 0); }
		public MulDivModContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitMulDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(zad2Parser.ADD, 0); }
		public TerminalNode SUB() { return getToken(zad2Parser.SUB, 0); }
		public AddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PwrContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PWR() { return getToken(zad2Parser.PWR, 0); }
		public PwrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterPwr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitPwr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitPwr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesesContext extends ExpressionContext {
		public ExpressionContext inner;
		public TerminalNode LBRACKET() { return getToken(zad2Parser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(zad2Parser.RBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
			case NUMBER:
				{
				_localctx = new NumerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUB) {
					{
					setState(37);
					((NumerContext)_localctx).operator = match(SUB);
					}
				}

				setState(40);
				match(NUMBER);
				}
				break;
			case LBRACKET:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(LBRACKET);
				setState(42);
				((ParenthesesContext)_localctx).inner = expression(0);
				setState(43);
				match(RBRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(56);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new PwrContext(new ExpressionContext(_parentctx, _parentState));
						((PwrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(47);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(48);
						((PwrContext)_localctx).operator = match(PWR);
						setState(49);
						((PwrContext)_localctx).right = expression(4);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModContext(new ExpressionContext(_parentctx, _parentState));
						((MulDivModContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(50);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(51);
						((MulDivModContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(52);
						((MulDivModContext)_localctx).right = expression(3);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(53);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(54);
						((AddSubContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(55);
						((AddSubContext)_localctx).right = expression(2);
						}
						break;
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return start_sempred((StartContext)_localctx, predIndex);
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean start_sempred(StartContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\5\2\r\n\2\3\2\3\2\7\2\21\n\2\f\2\16\2\24\13"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"%\n\4\3\5\3\5\5\5)\n\5\3\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\3\5\2\4\2\b\6\2\4\6\b\2\5"+
		"\4\2\3\3\6\20\3\2\13\r\3\2\16\17\2G\2\n\3\2\2\2\4\33\3\2\2\2\6$\3\2\2"+
		"\2\b/\3\2\2\2\n\f\b\2\1\2\13\r\7\2\2\3\f\13\3\2\2\2\f\r\3\2\2\2\r\22\3"+
		"\2\2\2\16\17\f\4\2\2\17\21\5\4\3\2\20\16\3\2\2\2\21\24\3\2\2\2\22\20\3"+
		"\2\2\2\22\23\3\2\2\2\23\3\3\2\2\2\24\22\3\2\2\2\25\34\7\4\2\2\26\27\7"+
		"\3\2\2\27\34\5\6\4\2\30\31\5\b\5\2\31\32\7\4\2\2\32\34\3\2\2\2\33\25\3"+
		"\2\2\2\33\26\3\2\2\2\33\30\3\2\2\2\34\5\3\2\2\2\35\36\7\5\2\2\36%\7\4"+
		"\2\2\37 \7\2\2\3 %\5\6\4\2!\"\t\2\2\2\"%\5\6\4\2#%\7\4\2\2$\35\3\2\2\2"+
		"$\37\3\2\2\2$!\3\2\2\2$#\3\2\2\2%\7\3\2\2\2&(\b\5\1\2\')\7\17\2\2(\'\3"+
		"\2\2\2()\3\2\2\2)*\3\2\2\2*\60\7\20\2\2+,\7\b\2\2,-\5\b\5\2-.\7\t\2\2"+
		".\60\3\2\2\2/&\3\2\2\2/+\3\2\2\2\60<\3\2\2\2\61\62\f\5\2\2\62\63\7\n\2"+
		"\2\63;\5\b\5\6\64\65\f\4\2\2\65\66\t\3\2\2\66;\5\b\5\5\678\f\3\2\289\t"+
		"\4\2\29;\5\b\5\4:\61\3\2\2\2:\64\3\2\2\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2"+
		"\2<=\3\2\2\2=\t\3\2\2\2><\3\2\2\2\n\f\22\33$(/:<";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}