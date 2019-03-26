import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.util.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

public class TestGoobScraperVisitor<T> extends GoobScraperBaseVisitor {
    private Map<String,Variable> varMem = new HashMap<>();
    private Variable lastVar;


    @Override
    public Variable visitUpdateStatment(GoobScraperParser.UpdateStatmentContext ctx) {
        // the metadata of each file will be stored in a separate file with a MD.txt
        String fileName = ctx.word().getText() + "_MD.txt";
        String timeStr = ctx.time().getText();
        String updateType = ctx.update().getText();
        File file = null;
        try {
            file = getFile(fileName);
            updateMetaDataFile(updateType, timeStr, file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        System.out.println("updateType: ");
        return null;
    }

    private void updateMetaDataFile(String updateType, String updateTime, File file) throws IOException {
        System.out.println("updateAppendType; file: " + file.getName());
        // From https://stackoverflow.com/questions/20753600/creating-writing-and-editing-same-text-file-in-java
        String line;StringBuilder content = new StringBuilder();
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

    private void insertURLMetaDataFile(String url, File file) throws IOException {
        System.out.println("updateAppendType; file: " + file.getName());
        // From https://stackoverflow.com/questions/20753600/creating-writing-and-editing-same-text-file-in-java
        String line, content = "";
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String theLine = "URL: " + url + ";\n";
        while ((line = br.readLine()) != null) {
            if (line.contains("URL: "))  content += "\n" + theLine;
            else content+=line + "\n";
        }
        br.close();
        if (!content.contains(theLine)) content += theLine;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
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

    @Override
    public Object visitRegularGet(GoobScraperParser.RegularGetContext ctx) {
        return visitChildren(ctx);
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
            return Variable.variableFactory(url, responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
            writer.append("ID");writer.append(',');writer.append("name");writer.append('\n');
            if (var != null) {
                insertURLMetaDataFile(varMem.get(var).getURL(), getFile(file.replace("\"","") + "_MD.txt"));
            }
            writer.flush();
            writer.close();
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
                insertURLMetaDataFile(varMem.get(var).getURL(), getFile(file.replace("\"","") + "_MD.txt"));
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


    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("~$: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = br.readLine();
            CharStream input = CharStreams.fromString(inputLine);
            GoobScraperLexer lexer = new GoobScraperLexer(input);
            CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
            GoobScraperParser parser = new GoobScraperParser(commonTokenStream);
            ParseTree tree = parser.program();
            TestGoobScraperVisitor testGoobScraperVisitor = new TestGoobScraperVisitor();
            testGoobScraperVisitor.visit(tree);
        }

    }

}
