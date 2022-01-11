package gen;// Generated from /home/adam/Uczelnia/JFTT/L3/Zad2/zad2.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link zad2Parser}.
 */
public interface zad2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link zad2Parser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(zad2Parser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link zad2Parser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(zad2Parser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Nothing}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 */
	void enterNothing(zad2Parser.NothingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Nothing}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 */
	void exitNothing(zad2Parser.NothingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Commentary}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 */
	void enterCommentary(zad2Parser.CommentaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Commentary}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 */
	void exitCommentary(zad2Parser.CommentaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 */
	void enterPrint(zad2Parser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 */
	void exitPrint(zad2Parser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link zad2Parser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(zad2Parser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link zad2Parser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(zad2Parser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Numer}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumer(zad2Parser.NumerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Numer}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumer(zad2Parser.NumerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(zad2Parser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(zad2Parser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(zad2Parser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(zad2Parser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pwr}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPwr(zad2Parser.PwrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pwr}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPwr(zad2Parser.PwrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(zad2Parser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(zad2Parser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code APwrMulDiv}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 */
	void enterAPwrMulDiv(zad2Parser.APwrMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code APwrMulDiv}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 */
	void exitAPwrMulDiv(zad2Parser.APwrMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code APwrNumer}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 */
	void enterAPwrNumer(zad2Parser.APwrNumerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code APwrNumer}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 */
	void exitAPwrNumer(zad2Parser.APwrNumerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code APwrAddSub}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 */
	void enterAPwrAddSub(zad2Parser.APwrAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code APwrAddSub}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 */
	void exitAPwrAddSub(zad2Parser.APwrAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code APwrParentheses}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 */
	void enterAPwrParentheses(zad2Parser.APwrParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code APwrParentheses}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 */
	void exitAPwrParentheses(zad2Parser.APwrParenthesesContext ctx);
}