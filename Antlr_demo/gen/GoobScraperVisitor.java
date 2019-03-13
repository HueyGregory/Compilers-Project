// Generated from C:/Users/yaeav/Documents/YU/YU Classes/Spring 2019/Compiler/Git Repository/Compilers-Project/Antlr_demo/src/main/java\GoobScraper.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GoobScraperParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GoobScraperVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GoobScraperParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GoobScraperParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetStatment(GoobScraperParser.GetStatmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtractStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractStatment(GoobScraperParser.ExtractStatmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UpdateStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatment(GoobScraperParser.UpdateStatmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AlertStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlertStatment(GoobScraperParser.AlertStatmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RegularGet}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularGet(GoobScraperParser.RegularGetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetURL}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetURL(GoobScraperParser.GetURLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetTable}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetTable(GoobScraperParser.GetTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtractAppend}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractAppend(GoobScraperParser.ExtractAppendContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtractMerge}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractMerge(GoobScraperParser.ExtractMergeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtractReplace}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractReplace(GoobScraperParser.ExtractReplaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtractEmpty}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractEmpty(GoobScraperParser.ExtractEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UpdateAppend}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateAppend(GoobScraperParser.UpdateAppendContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UpdateMerge}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateMerge(GoobScraperParser.UpdateMergeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UpdateReplace}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateReplace(GoobScraperParser.UpdateReplaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AlertWord}
	 * labeled alternative in {@link GoobScraperParser#alert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlertWord(GoobScraperParser.AlertWordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AlertEmpty}
	 * labeled alternative in {@link GoobScraperParser#alert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlertEmpty(GoobScraperParser.AlertEmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoobScraperParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(GoobScraperParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoobScraperParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(GoobScraperParser.WordContext ctx);
}