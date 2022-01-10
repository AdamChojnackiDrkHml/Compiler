package gen;// Generated from /home/adam/Uczelnia/JFTT/L3/Zad2/zad2.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link zad2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface zad2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link zad2Parser#dupa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDupa(zad2Parser.DupaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Nothing}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNothing(zad2Parser.NothingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Commentary}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentary(zad2Parser.CommentaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link zad2Parser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(zad2Parser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link zad2Parser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(zad2Parser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numer}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumer(zad2Parser.NumerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(zad2Parser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(zad2Parser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pwr}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPwr(zad2Parser.PwrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link zad2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(zad2Parser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code APwrMulDiv}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAPwrMulDiv(zad2Parser.APwrMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code APwrNumer}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAPwrNumer(zad2Parser.APwrNumerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code APwrAddSub}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAPwrAddSub(zad2Parser.APwrAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code APwrParentheses}
	 * labeled alternative in {@link zad2Parser#afterpwr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAPwrParentheses(zad2Parser.APwrParenthesesContext ctx);
}