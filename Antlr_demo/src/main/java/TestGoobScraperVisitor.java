import java.io.IOException;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TestGoobScraperVisitor extends GoobScraperBaseVisitor {
    //Map<String,String> props = new HashMap<>();​

    @Override
    public Object visitRegularGet(GoobScraperParser.RegularGetContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Void visitWord(GoobScraperParser.WordContext ctx) {
        String id = ctx.ID().getText();
        String number = ctx.NUMBER().getText();
        String string = ctx.STRING().getText();
        return null;
    }

    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        GoobScraperLexer lexer = new GoobScraperLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        GoobScraperParser parser = new GoobScraperParser(commonTokenStream);
        ParseTree tree = parser.program();
        TestGoobScraperVisitor testGoobScraperVisitor = new TestGoobScraperVisitor();
        testGoobScraperVisitor.visit(tree);

    }

}
