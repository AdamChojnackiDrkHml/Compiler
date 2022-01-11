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
		RULE_start = 0, RULE_line = 1, RULE_comment = 2, RULE_expression = 3, 
		RULE_afterpwr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "line", "comment", "expression", "afterpwr"
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
			setState(12);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(11);
				match(EOF);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(18);
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
					setState(14);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(15);
					line();
					}
					} 
				}
				setState(20);
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
			setState(27);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENDLINE:
				_localctx = new NothingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				match(ENDLINE);
				}
				break;
			case COMMENT:
				_localctx = new CommentaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(COMMENT);
				setState(23);
				comment();
				}
				break;
			case LBRACKET:
			case SUB:
			case NUMBER:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				expression(0);
				setState(25);
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
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BACKSLASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(BACKSLASH);
				setState(30);
				match(ENDLINE);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(EOF);
				setState(32);
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
			case ADD:
			case SUB:
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << WHITESPACE) | (1L << CHARACTERS) | (1L << LBRACKET) | (1L << RBRACKET) | (1L << PWR) | (1L << MUL) | (1L << DIV) | (1L << ADD) | (1L << SUB) | (1L << NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(34);
				comment();
				}
				break;
			case ENDLINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
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
	public static class MulDivContext extends ExpressionContext {
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
		public MulDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitMulDiv(this);
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
		public AfterpwrContext left;
		public Token operator;
		public AfterpwrContext right;
		public List<AfterpwrContext> afterpwr() {
			return getRuleContexts(AfterpwrContext.class);
		}
		public AfterpwrContext afterpwr(int i) {
			return getRuleContext(AfterpwrContext.class,i);
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
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new NumerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUB) {
					{
					setState(39);
					((NumerContext)_localctx).operator = match(SUB);
					}
				}

				setState(42);
				match(NUMBER);
				}
				break;
			case 2:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(LBRACKET);
				setState(44);
				((ParenthesesContext)_localctx).inner = expression(0);
				setState(45);
				match(RBRACKET);
				}
				break;
			case 3:
				{
				_localctx = new PwrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				((PwrContext)_localctx).left = afterpwr(0);
				setState(48);
				((PwrContext)_localctx).operator = match(PWR);
				setState(49);
				((PwrContext)_localctx).right = afterpwr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(59);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExpressionContext(_parentctx, _parentState));
						((MulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(53);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(54);
						((MulDivContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(55);
						((MulDivContext)_localctx).right = expression(3);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(56);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(57);
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
						setState(58);
						((AddSubContext)_localctx).right = expression(2);
						}
						break;
					}
					} 
				}
				setState(63);
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

	public static class AfterpwrContext extends ParserRuleContext {
		public AfterpwrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterpwr; }
	 
		public AfterpwrContext() { }
		public void copyFrom(AfterpwrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class APwrMulDivContext extends AfterpwrContext {
		public AfterpwrContext left;
		public Token operator;
		public AfterpwrContext right;
		public List<AfterpwrContext> afterpwr() {
			return getRuleContexts(AfterpwrContext.class);
		}
		public AfterpwrContext afterpwr(int i) {
			return getRuleContext(AfterpwrContext.class,i);
		}
		public TerminalNode MUL() { return getToken(zad2Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(zad2Parser.DIV, 0); }
		public APwrMulDivContext(AfterpwrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterAPwrMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitAPwrMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitAPwrMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class APwrNumerContext extends AfterpwrContext {
		public Token operator;
		public TerminalNode NUMBER() { return getToken(zad2Parser.NUMBER, 0); }
		public TerminalNode SUB() { return getToken(zad2Parser.SUB, 0); }
		public APwrNumerContext(AfterpwrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterAPwrNumer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitAPwrNumer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitAPwrNumer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class APwrAddSubContext extends AfterpwrContext {
		public AfterpwrContext left;
		public Token operator;
		public AfterpwrContext right;
		public List<AfterpwrContext> afterpwr() {
			return getRuleContexts(AfterpwrContext.class);
		}
		public AfterpwrContext afterpwr(int i) {
			return getRuleContext(AfterpwrContext.class,i);
		}
		public TerminalNode ADD() { return getToken(zad2Parser.ADD, 0); }
		public TerminalNode SUB() { return getToken(zad2Parser.SUB, 0); }
		public APwrAddSubContext(AfterpwrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterAPwrAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitAPwrAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitAPwrAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class APwrParenthesesContext extends AfterpwrContext {
		public AfterpwrContext inner;
		public TerminalNode LBRACKET() { return getToken(zad2Parser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(zad2Parser.RBRACKET, 0); }
		public AfterpwrContext afterpwr() {
			return getRuleContext(AfterpwrContext.class,0);
		}
		public APwrParenthesesContext(AfterpwrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).enterAPwrParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof zad2Listener ) ((zad2Listener)listener).exitAPwrParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof zad2Visitor ) return ((zad2Visitor<? extends T>)visitor).visitAPwrParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterpwrContext afterpwr() throws RecognitionException {
		return afterpwr(0);
	}

	private AfterpwrContext afterpwr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AfterpwrContext _localctx = new AfterpwrContext(_ctx, _parentState);
		AfterpwrContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_afterpwr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
			case NUMBER:
				{
				_localctx = new APwrNumerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUB) {
					{
					setState(65);
					((APwrNumerContext)_localctx).operator = match(SUB);
					}
				}

				setState(68);
				match(NUMBER);
				}
				break;
			case LBRACKET:
				{
				_localctx = new APwrParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(LBRACKET);
				setState(70);
				((APwrParenthesesContext)_localctx).inner = afterpwr(0);
				setState(71);
				match(RBRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(81);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new APwrMulDivContext(new AfterpwrContext(_parentctx, _parentState));
						((APwrMulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_afterpwr);
						setState(75);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(76);
						((APwrMulDivContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((APwrMulDivContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(77);
						((APwrMulDivContext)_localctx).right = afterpwr(3);
						}
						break;
					case 2:
						{
						_localctx = new APwrAddSubContext(new AfterpwrContext(_parentctx, _parentState));
						((APwrAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_afterpwr);
						setState(78);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(79);
						((APwrAddSubContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((APwrAddSubContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(80);
						((APwrAddSubContext)_localctx).right = afterpwr(2);
						}
						break;
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		case 4:
			return afterpwr_sempred((AfterpwrContext)_localctx, predIndex);
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
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean afterpwr_sempred(AfterpwrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20Y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\5\2\17\n\2\3\2\3\2\7\2\23\n\2\f\2\16"+
		"\2\26\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4\'\n\4\3\5\3\5\5\5+\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\66\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\3\6\3\6\5\6"+
		"E\n\6\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6T\n\6\f"+
		"\6\16\6W\13\6\3\6\2\5\2\b\n\7\2\4\6\b\n\2\5\5\2\3\3\6\f\16\20\3\2\13\f"+
		"\3\2\16\17\2c\2\f\3\2\2\2\4\35\3\2\2\2\6&\3\2\2\2\b\65\3\2\2\2\nK\3\2"+
		"\2\2\f\16\b\2\1\2\r\17\7\2\2\3\16\r\3\2\2\2\16\17\3\2\2\2\17\24\3\2\2"+
		"\2\20\21\f\4\2\2\21\23\5\4\3\2\22\20\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2"+
		"\2\24\25\3\2\2\2\25\3\3\2\2\2\26\24\3\2\2\2\27\36\7\4\2\2\30\31\7\3\2"+
		"\2\31\36\5\6\4\2\32\33\5\b\5\2\33\34\7\4\2\2\34\36\3\2\2\2\35\27\3\2\2"+
		"\2\35\30\3\2\2\2\35\32\3\2\2\2\36\5\3\2\2\2\37 \7\5\2\2 \'\7\4\2\2!\""+
		"\7\2\2\3\"\'\5\6\4\2#$\t\2\2\2$\'\5\6\4\2%\'\7\4\2\2&\37\3\2\2\2&!\3\2"+
		"\2\2&#\3\2\2\2&%\3\2\2\2\'\7\3\2\2\2(*\b\5\1\2)+\7\17\2\2*)\3\2\2\2*+"+
		"\3\2\2\2+,\3\2\2\2,\66\7\20\2\2-.\7\b\2\2./\5\b\5\2/\60\7\t\2\2\60\66"+
		"\3\2\2\2\61\62\5\n\6\2\62\63\7\n\2\2\63\64\5\n\6\2\64\66\3\2\2\2\65(\3"+
		"\2\2\2\65-\3\2\2\2\65\61\3\2\2\2\66?\3\2\2\2\678\f\4\2\289\t\3\2\29>\5"+
		"\b\5\5:;\f\3\2\2;<\t\4\2\2<>\5\b\5\4=\67\3\2\2\2=:\3\2\2\2>A\3\2\2\2?"+
		"=\3\2\2\2?@\3\2\2\2@\t\3\2\2\2A?\3\2\2\2BD\b\6\1\2CE\7\17\2\2DC\3\2\2"+
		"\2DE\3\2\2\2EF\3\2\2\2FL\7\20\2\2GH\7\b\2\2HI\5\n\6\2IJ\7\t\2\2JL\3\2"+
		"\2\2KB\3\2\2\2KG\3\2\2\2LU\3\2\2\2MN\f\4\2\2NO\t\3\2\2OT\5\n\6\5PQ\f\3"+
		"\2\2QR\t\4\2\2RT\5\n\6\4SM\3\2\2\2SP\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2"+
		"\2\2V\13\3\2\2\2WU\3\2\2\2\16\16\24\35&*\65=?DKSU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}