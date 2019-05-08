import Visitor.GoobScraperLexer;
import Visitor.GoobScraperParser;
import org.junit.Test;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CommonTokenStream;


public class GoobScraperTester {

    @Test
    public void testExtarctNew() throws IOException {
        String inputLine = "";
        //CharStream input = CharStreams.fromString(inputLine);
        CharStream inputStream = CharStreams.fromFileName("/home/noah/Documents/CS_HW/Compilers/Compilers-Project/Antlr_demo/src/test/java/input.txt");
        GoobScraperLexer lexer = new GoobScraperLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        GoobScraperParser parser = new GoobScraperParser(commonTokenStream);
        ParseTree tree = parser.program();
        TestGoobScraperVisitor testGoobScraperVisitor = new TestGoobScraperVisitor();
        testGoobScraperVisitor.visit(tree);
    }
}
