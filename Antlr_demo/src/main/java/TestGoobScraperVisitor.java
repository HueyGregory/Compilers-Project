import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TestGoobScraperVisitor extends GoobScraperBaseVisitor {
    //Map<String,String> props = new HashMap<>();​

    @Override public Variable visitUpdateStatment(GoobScraperParser.UpdateStatmentContext ctx) {
        String updateType = ctx.update().getText();
        System.out.println(updateType);
        return null;
    }


    public Variable visitUpdateAppend(String file, int time) {

        return null;
    }


    @Override
    public Object visitRegularGet(GoobScraperParser.RegularGetContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Void visitWordID(GoobScraperParser.WordIDContext ctx) {
        String id = ctx.ID().getText();
        return null;
    }

    @Override
    public Void visitWordNumber(GoobScraperParser.WordNumberContext ctx) {
        String number = ctx.NUMBER().getText();
        return null;
    }

    @Override
    public Void visitWordString(GoobScraperParser.WordStringContext ctx) {
        String string = ctx.STRING().getText();
        return null;
    }


    @Override
    public Void visitExtractNew(GoobScraperParser.ExtractNewContext ctx) {
        String file = "",var = "";
        int wordNum = ctx.word().size();
        if(wordNum == 1){
            file = ctx.getChild(1).getText();
        }else if(wordNum == 2){
            var = ctx.getChild(1).getText();
            file = ctx.getChild(2).getText();
        }

        return null;
    }

    @Override
    public Void visitExtractAppend(GoobScraperParser.ExtractAppendContext ctx) {
        //String string = ctx
        return null;
    }

    @Override
    public Variable visitGetURL(GoobScraperParser.GetURLContext ctx) {
        //https://en.wikipedia.org/wiki/Oversampling_and_undersampling_in_data_analysis
        URLConnection connection = null;
        try {
            String url = ctx.word().getText().replace("\"","");
            connection = new URL(url).openConnection();
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
            return Variable.variableFactory(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
