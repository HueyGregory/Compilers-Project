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
        String url = ctx.word().getText().replace("\"", "");

        String code =
                "import requests\n" +
                "from bs4 import BeautifulSoup\n" +
                "memory = {} # map for memory\n" +
                "varNumStrt = 0\n" +
                "global lastVar\n" +
                "lastVar = -1\n" +
                "def getURL(url):\n" +
                "    global lastVar\n" +
                "    lastVar += 1\n" +
                "    response = requests.get(url)\n" +
                "    memory[lastVar] = response.text\n" +
                "    print(\"Variable reference name: \" + str(lastVar))\n" +
                "    return response\n" +
                "\n" +
                "res = getURL(\""+ url + "\")";

        try(FileWriter fw = new FileWriter("testGoober.py", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            out.print(code);
            //fw.close();
        } catch (IOException e) {
            //exception handling
        }
    }

    //ex. "/get table VAR" or "/get table";
    @Override
    public void exitGetTable(GoobScraperParser.GetTableContext ctx) {
        String pyLine = "";
        System.out.println("In exitGetTable");
        int wordNum = ctx.children.size() - 2;
        if(wordNum == 1){//extract new "asdf.csv";
            pyLine = "    html = memory[lastVar]\n";

        }else if(wordNum == 2){//extract new 0 "asdf.csv";
            String varNum = ctx.getChild(2).getText();//get from memory
            pyLine = "    html = memory[" + varNum + "]\n";

        }
        String code =
                    "def getTable():\n" +
                    "    try:\n" +
                    "        data = []\n" +
                    "        var= lastVar\n" +
                             pyLine +
                    "        soup = BeautifulSoup(html,\"lxml\")\n" +
                    "        table = soup.find( \"table\")\n" +
                    "        rows = table.find_all('tr')\n" +
                    "        for row in rows:\n" +
                    "            cols = row.findAll('td')\n" +
                    "            if cols != []:\n" +
                    "                cols = [ele.text.strip() for ele in cols]\n" +
                    "                data.append([ele for ele in cols if ele != []])  # Get rid of empty values\n" +
                    "        memory[lastVar] = data\n" +
                    "    except ValueError:\n" +
                    "        \"No variable there\"\n" +
                    "tables = getTable()";
        try(FileWriter fw = new FileWriter("testGoober.py", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            out.print(code);
            //fw.close();
        } catch (IOException e) {
            //exception handling
        }

    }

    @Override
    public void exitExtractStatment(GoobScraperParser.ExtractStatmentContext ctx) {
        String file = "";
        String pyStatment = "";
        int wordNum = ctx.word().size();
        if(wordNum == 1){//extract new "asdf.csv";
            file = ctx.getChild(2).getText();
            pyStatment = "    lister = memory[lastVar]\n";

        }else if(wordNum == 2){//extract new 0 "asdf.csv";
            String varNum = ctx.getChild(2).getText();//get from memory
            file = ctx.getChild(3).getText();
            pyStatment = "    lister = memory[" + varNum + "]\n";

        }
        System.out.println();
        String code = "def extractStat():\n" +
                "    import pandas as pd\n" +
                     pyStatment +
                "    my_df = pd.DataFrame(lister)\n" +
                "    my_df.to_csv(" + "\"" + file + "\"" + ", index=False, header=False)\n" +
                "extractStat()";

        try(FileWriter fw = new FileWriter("testGoober.py", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            out.print(code);
            //fw.close();
        } catch (IOException e) {
            //exception handling
        }

    }

    public static void main(String[] args) throws IOException {
        String fileName = "./src/main/java/Visitor/input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                parseAndRunLine(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
