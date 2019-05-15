package Visitor;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListenerTestGoobScraper extends GoobScraperBaseListener {

    private static Map<String,Variable> varMem = new HashMap<>();
    private static Variable lastVar;

    public ListenerTestGoobScraper() {  }

    @Override
    public void exitGetURL(GoobScraperParser.GetURLContext ctx) {
        System.out.println("In exitGetURL");
        System.out.println(ctx.word().getText());
        URLConnection connection = null;
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testGoober.js"), "utf-8"));
            String url = ctx.word().getText().replace("\"", "");
            String jsCode = "const getURL = function (url) {\n" +
                    "    const request = require('request');\n" +
                    "    url = url.replace(/['\";]+/g, '');\n" +
                    "    console.log(url);\n" +
                    "    request(url, (err, res, body) => {\n" +
                    "        if (err) {\n" +
                    "            return console.log(err);\n" +
                    "        }\n" +
                    "        console.log(body);\n" +
                    "    });\n" +
                    "};\n" +
                    "getURL(" + "\"" + url + "\");";

            String js2 = "    request(url, (err, res, body) => {\n" +
                    "        if (err) {\n" +
                    "            return console.log(err);\n" +
                    "        }\n" +
                    "        console.log(body);\n" +
                    "    });\n";
            writer.write(jsCode);
            writer.close();
            /*connection = new URL(url).openConnection();
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
            lastVar = Variable.variableFactory(url, responseBody);
            varMem.put(lastVar.getName(), lastVar);
            lastVar.addStep("/get url " + ctx.word().getText());
            System.out.println("Visitor.Variable reference name: " + lastVar.getName());
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        while(true){
            //System.out.print("~$: ");
            try {
                Scanner sc = new Scanner(System.in);
                //String fileName = sc.next();
                String fileName = "./src/main/java/Visitor/input.txt";
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String inputLine = br.readLine();
                parseAndRunLine(inputLine);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    private static void parseAndRunLine(String inputLine) {
        System.out.println("In Listener");
        CharStream input = CharStreams.fromString(inputLine);
        GoobScraperLexer lexer = new GoobScraperLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        GoobScraperParser parser = new GoobScraperParser(commonTokenStream);
        ParseTree tree = parser.program();
        // Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(new ListenerTestGoobScraper(), tree);
    }

}
