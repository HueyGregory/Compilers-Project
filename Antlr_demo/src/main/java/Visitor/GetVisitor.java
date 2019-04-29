package Visitor;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class GetVisitor<T> extends GoobScraperBaseVisitor {

    @Override public T visitRegularGet(GoobScraperParser.RegularGetContext ctx) {
        System.out.println("Entered visitRegularGet(): " + ctx.getText());
        return null;

    }

    @Override public T visitGetURL(GoobScraperParser.GetURLContext ctx) {
        System.out.println("Entered visitGetURL(): " + ctx.getText());

        return null;
    }



    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        // create a lexer that feeds off of input CharStream
        GoobScraperLexer lexer = new GoobScraperLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        GoobScraperParser parser = new GoobScraperParser(tokens);
        // begin parsing at program rule
        ParseTree tree = parser.program();
        GetVisitor calc = new GetVisitor();
        calc.visit(tree);

    }

}
