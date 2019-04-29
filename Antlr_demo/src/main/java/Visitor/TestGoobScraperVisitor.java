package Visitor;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestGoobScraperVisitor<T> extends GoobScraperBaseVisitor {
    private static Map<String,Variable> varMem = new HashMap<>();
    private static Variable lastVar;


    @Override
    public Variable visitUpdateStatment(GoobScraperParser.UpdateStatmentContext ctx) {
        // the metadata of each file will be stored in a separate file with a MD.txt
        String fileName;
        if (ctx.word() == null ) {
            fileName = lastVar.getFileName();
        }
        else if (Files.exists(Paths.get(ctx.word().getText()))) {
            fileName = ctx.word().getText();
        }
        else {
            fileName = getVar(ctx.word()).getFileName();
        }
        String timeStr = ctx.time().getText();
        System.out.println(timeStr);
        String updateType = ctx.update().getText();
        File file;
        try {
            file = getFile(getMDFileName(fileName));
            updateMetaDataFile(updateType, timeStr, file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        System.out.println("updateType: ");
        return null;
    }

    private void updateMetaDataFile(String updateType, String updateTime, File file) throws IOException {
        System.out.println("updateMetaDataFile; file: " + file.getName());
        // From https://stackoverflow.com/questions/20753600/creating-writing-and-editing-same-text-file-in-java
        String line;StringBuilder content = new StringBuilder();
        System.out.println(file.getName());
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String theLine = "update: " + updateType + "; " + updateTime + "\n";
        while ((line = br.readLine()) != null) {
            if (line.contains("update: "))  content.append("\n").append(theLine);
            else content.append(line).append("\n");
        }
        br.close();
        if (!content.toString().contains(theLine)) content.append(theLine);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content.toString());
        bw.close();
    }

    private void insertVarMetaDataFile(Variable var, File file) throws IOException {
        System.out.println("insertVarMetaDataFile: updateAppendType; file: " + file.getName());
        // From https://stackoverflow.com/questions/20753600/creating-writing-and-editing-same-text-file-in-java
        String line;
        boolean hadURL = false, hadSteps = false, readingSteps = false;
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String theLine = "URL: " + var.getURL() + ";\n";
        while ((line = br.readLine()) != null) {
            if (readingSteps && !(line.startsWith("End Steps"))) continue;
            readingSteps = false;
            if (line.equals("") || line.equals("End Steps")) continue;
            if (line.startsWith("URL: ")) {
                if(hadURL) continue;
                content.append("\n").append(theLine).append("\n");
                hadURL = true;
            }
            else if (line.startsWith("Steps: ")) {
                if (hadSteps) continue;
                content.append("\n").append("Steps: \n");
                readingSteps = true;
                hadSteps = true;
                for (String step : var.getSteps()) {
                    content.append(step).append("\n");
                }
                content.append("End Steps").append("\n\n");
            }

            else content.append(line).append("\n");
        }
        if (!hadURL) content.append("\n").append(theLine).append("\n");
        if (!hadSteps) {
            content.append("Steps: \n");
            for (String step : var.getSteps()) {
                content.append(step).append("\n");
            }
            content.append("End Steps").append("\n\n");
        }
        br.close();
        if (!content.toString().contains(theLine)) content.append(theLine);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content.toString());
        bw.close();
    }

    private File getFile(String fileName) throws IOException {
        File file = new File(fileName);
        // find the variable in the file which will indicate whether to append, replace, or merge
        if (!file.exists()) { file.createNewFile(); }
        if (!file.canRead() || !file.canWrite()) {
            file.delete();
            file.createNewFile();
        }
        return file;
    }
    //ex. "/get table VAR" or "/get table";
    @Override
    public Void visitGetTable(GoobScraperParser.GetTableContext ctx){
        //TODO: instead of printing write to csv file for each table
        String html;
        Variable var;
        if ((var = getVar(ctx.word())) == null) {
            html = lastVar.getText();
        }
        else {
            html = var.getText();
        }

        try {
              // String urlTest = "https://www.w3schools.com/html/html_tables.asp";
             // String url = ctx.getChild(1).getText().replace("\"", "");
            // Document doc = Jsoup.connect(urlTest).get();
            Document doc = Jsoup.parse(html);
            Elements tables = doc.getElementsByTag("table");

            StringBuilder contentTxt = new StringBuilder();

            for(Element table : tables){
                Elements rows = table.select("tr");
                Elements ths = rows.select("th");

                String thstr = "";
                for (Element th : ths) {
                    thstr += th.text() + ",";
                }
                System.out.print(thstr);
                contentTxt.append(thstr);

                for (Element row : rows) {
                    Elements tds = row.select("td");
                    for (Element td : tds) {
                        System.out.print(td.text() + ",");  // --> This will print them individually
                        contentTxt.append(td.text()).append(",");
                    }
                    System.out.println(); //next row
                    contentTxt.append("\n");
                }
                //separates tables when being displayed
                System.out.println("---------------------------------------------------------------");
                contentTxt.append("-:-").append("\n");
            }
            var.setText(contentTxt.toString());// set content to var
        } catch (Exception e) {
            e.printStackTrace();
        }
        var.addStep("/get table");
        lastVar = var;
        return null;
    }

    // ex. /get <any tag> <url>
    @Override
    public Object visitRegularGet(GoobScraperParser.RegularGetContext ctx) {
        try {
            String url = ctx.getChild(1).getText();
            String searchWord = ctx.getChild(0).getText();
            // "https://www.simplyhired.com/search?q=software+engineer+internship&l=&job=n7bNHcC6SCTRXJm6oS_OARzDwQVbKXWHX21n6YVrcdjMNKBO1E1QwQ"
            Document doc = Jsoup.connect(url).get();
            Elements searchWords = doc.getElementsByTag("a");
            List<Element> foundElements = new ArrayList<>();
            for(Element word : searchWords){
                String txt = word.toString();
                if(txt.contains(searchWord)){
                    foundElements.add(word);
                }
            }
            //String bob  = elements.toString();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return visitChildren(ctx);
    }

    @Override
    public Variable visitGetURL(GoobScraperParser.GetURLContext ctx) {
        //https://en.wikipedia.org/wiki/Oversampling_and_undersampling_in_data_analysis
        URLConnection connection = null;
        try {
            String url = ctx.word().getText().replace("\"", "");
            connection = new URL(url).openConnection();
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
            lastVar = Variable.variableFactory(url, responseBody);
            varMem.put(lastVar.getName(), lastVar);
            lastVar.addStep("/get url " + ctx.word().getText());
            System.out.println("Visitor.Variable reference name: " + lastVar.getName());
            return lastVar;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Extracts the data to a new file creating the file in process
     * ex. /extract new (variable)? file.extension;/r -> <EOF> -> <ctrl-D>
     * @param ctx
     * @return
     */
    @Override
    public Variable visitExtractNew(GoobScraperParser.ExtractNewContext ctx) {
        String file = "";
        Variable var = null;
        System.out.println("visitExtractNew; lastVar: " + lastVar.getName());
        int wordNum = ctx.word().size();
        if(wordNum == 1){
            file = ctx.getChild(1).getText();
            var = lastVar;
        }else if(wordNum == 2){
            var = varMem.get(ctx.getChild(1).getText());
            file = ctx.getChild(2).getText();
        }

        try {
            FileWriter writer = new FileWriter(file.replace("\"",""),false);
            //test example:
            //writer.append("ID");writer.append(',');writer.append("name");writer.append('\n');
            assert var != null;
            String htmlTxt = var.getText();
            String[] tables = htmlTxt.split("-:-");
            for (String table : tables) {
                if(table.length() > 1){
                    table = table.substring(0, table.length() -2);//remove the ',' at the end so table ends
                    writer.append(table);
                }
            }
            writer.flush();
            writer.close();
            /*EX:
                Company,Contact,Country,
                Alfreds Futterkiste,Maria Anders,Germany,
                Centro comercial Moctezuma,Francisco Chang,Mexico,
                Ernst Handel,Roland Mendel,Austria,
                Island Trading,Helen Bennett,UK,
                Laughing Bacchus Winecellars,Yoshi Tannamuri,Canada,
                Magazzini Alimentari Riuniti,Giovanni Rovelli,Italy,
                ---------------------------------------------------------------
                Tag,Description,
                <table>,Defines a table,
                <th>,Defines a header cell in a table,
                <tr>,Defines a row in a table,
                <td>,Defines a cell in a table,
                <caption>,Defines a table caption,
                <colgroup>,Specifies a group of one or more columns in a table for formatting,
                <col>,Specifies column properties for each column within a <colgroup> element,
                <thead>,Groups the header content in a table,
                <tbody>,Groups the body content in a table,
                <tfoot>,Groups the footer content in a table,
                ---------------------------------------------------------------
             */


            if (var != null) {
                var.addStep("/extract new " + file.replace("\"",""));
                insertVarMetaDataFile(varMem.get(var.getName()), getFile(getMDFileName(file.replace("\"",""))));
                var.setFileName(file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Void visitExtractAppend(GoobScraperParser.ExtractAppendContext ctx) {
        String file = "";
        Variable var = null;
        int wordNum = ctx.word().size();
        if(wordNum == 1){
            file = ctx.getChild(1).getText();
            var = lastVar;
        }else if(wordNum == 2){
            var = varMem.get(ctx.getChild(1).getText());
            file = ctx.getChild(2).getText();
        }
        try {
            FileWriter writer = new FileWriter(file.replace("\"",""),true);
            //test example:
            writer.append("1");writer.append(',');writer.append("bob");writer.append('\n');

            writer.flush();
            writer.close();

            if (var != null) {
                var.addStep("/extract append " + file.replace("\"",""));
                insertVarMetaDataFile(varMem.get(var), getFile(getMDFileName(file.replace("\"",""))));
                var.setFileName(file);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Void visitQuitStatment(GoobScraperParser.QuitStatmentContext ctx){
        System.out.println("Quitting");
        System.exit(0);
        return null;
    }

    private Variable getVar(GoobScraperParser.WordContext ctxWord) {
        if (ctxWord != null){
            if (varMem.get(ctxWord.getText()) != null)
                return varMem.get(ctxWord.getText());
        }
        if (lastVar == null)
            throw new RuntimeException();
        return lastVar;
    }

    private static String getMDFileName(String fileName) {
        return fileName + "_MD.txt";
    }


    public static void main(String[] args){
        while (true) {
            System.out.print("~$: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = null;
            try {
                inputLine = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            parseAndRunLine(inputLine);
        }

    }

    public static void parseAndRunLine(String inputLine) {
        CharStream input = CharStreams.fromString(inputLine);
        GoobScraperLexer lexer = new GoobScraperLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        GoobScraperParser parser = new GoobScraperParser(commonTokenStream);
        ParseTree tree = parser.program();
        TestGoobScraperVisitor testGoobScraperVisitor = new TestGoobScraperVisitor();
        testGoobScraperVisitor.visit(tree);
    }

}
