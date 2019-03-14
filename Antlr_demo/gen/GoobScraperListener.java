// Generated from C:/Users/yaeav/Documents/YU/YU Classes/Spring 2019/Compiler/Git Repository/Compilers-Project/Antlr_demo/src/main/java\GoobScraper.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GoobScraperParser}.
 */
public interface GoobScraperListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GoobScraperParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GoobScraperParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoobScraperParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GoobScraperParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 */
	void enterGetStatment(GoobScraperParser.GetStatmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 */
	void exitGetStatment(GoobScraperParser.GetStatmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExtractStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 */
	void enterExtractStatment(GoobScraperParser.ExtractStatmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExtractStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 */
	void exitExtractStatment(GoobScraperParser.ExtractStatmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UpdateStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatment(GoobScraperParser.UpdateStatmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UpdateStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatment(GoobScraperParser.UpdateStatmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AlertStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 */
	void enterAlertStatment(GoobScraperParser.AlertStatmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AlertStatment}
	 * labeled alternative in {@link GoobScraperParser#statment}.
	 * @param ctx the parse tree
	 */
	void exitAlertStatment(GoobScraperParser.AlertStatmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RegularGet}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 */
	void enterRegularGet(GoobScraperParser.RegularGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RegularGet}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 */
	void exitRegularGet(GoobScraperParser.RegularGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetURL}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 */
	void enterGetURL(GoobScraperParser.GetURLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetURL}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 */
	void exitGetURL(GoobScraperParser.GetURLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetTable}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 */
	void enterGetTable(GoobScraperParser.GetTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetTable}
	 * labeled alternative in {@link GoobScraperParser#get}.
	 * @param ctx the parse tree
	 */
	void exitGetTable(GoobScraperParser.GetTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExtractAppend}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 */
	void enterExtractAppend(GoobScraperParser.ExtractAppendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExtractAppend}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 */
	void exitExtractAppend(GoobScraperParser.ExtractAppendContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExtractMerge}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 */
	void enterExtractMerge(GoobScraperParser.ExtractMergeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExtractMerge}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 */
	void exitExtractMerge(GoobScraperParser.ExtractMergeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExtractReplace}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 */
	void enterExtractReplace(GoobScraperParser.ExtractReplaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExtractReplace}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 */
	void exitExtractReplace(GoobScraperParser.ExtractReplaceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExtractEmpty}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 */
	void enterExtractEmpty(GoobScraperParser.ExtractEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExtractEmpty}
	 * labeled alternative in {@link GoobScraperParser#extract}.
	 * @param ctx the parse tree
	 */
	void exitExtractEmpty(GoobScraperParser.ExtractEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UpdateAppend}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdateAppend(GoobScraperParser.UpdateAppendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UpdateAppend}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdateAppend(GoobScraperParser.UpdateAppendContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UpdateMerge}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdateMerge(GoobScraperParser.UpdateMergeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UpdateMerge}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdateMerge(GoobScraperParser.UpdateMergeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UpdateReplace}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdateReplace(GoobScraperParser.UpdateReplaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UpdateReplace}
	 * labeled alternative in {@link GoobScraperParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdateReplace(GoobScraperParser.UpdateReplaceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AlertWord}
	 * labeled alternative in {@link GoobScraperParser#alert}.
	 * @param ctx the parse tree
	 */
	void enterAlertWord(GoobScraperParser.AlertWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AlertWord}
	 * labeled alternative in {@link GoobScraperParser#alert}.
	 * @param ctx the parse tree
	 */
	void exitAlertWord(GoobScraperParser.AlertWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AlertEmpty}
	 * labeled alternative in {@link GoobScraperParser#alert}.
	 * @param ctx the parse tree
	 */
	void enterAlertEmpty(GoobScraperParser.AlertEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AlertEmpty}
	 * labeled alternative in {@link GoobScraperParser#alert}.
	 * @param ctx the parse tree
	 */
	void exitAlertEmpty(GoobScraperParser.AlertEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoobScraperParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(GoobScraperParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoobScraperParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(GoobScraperParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WordID}
	 * labeled alternative in {@link GoobScraperParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWordID(GoobScraperParser.WordIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WordID}
	 * labeled alternative in {@link GoobScraperParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWordID(GoobScraperParser.WordIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WordNumber}
	 * labeled alternative in {@link GoobScraperParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWordNumber(GoobScraperParser.WordNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WordNumber}
	 * labeled alternative in {@link GoobScraperParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWordNumber(GoobScraperParser.WordNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WordString}
	 * labeled alternative in {@link GoobScraperParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWordString(GoobScraperParser.WordStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WordString}
	 * labeled alternative in {@link GoobScraperParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWordString(GoobScraperParser.WordStringContext ctx);
}