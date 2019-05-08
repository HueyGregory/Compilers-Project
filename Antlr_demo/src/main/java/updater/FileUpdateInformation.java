package updater;

import Visitor.GoobScraperLexer;
import Visitor.GoobScraperParser;
import Visitor.TestGoobScraperVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jboss.arquillian.test.spi.event.suite.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static updater.AutomaticUpdater.matchTime;

public class FileUpdateInformation implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(this.mdFile);

            // extract steps from metadata file
            List<String> steps = extractSteps(this.mdFile);

            for (String step : steps) {
                System.out.println(step);
                if (step.startsWith("/extract")) {
                    // call extract depending on the updateType
                    if (updateType == UpdateType.replace) {
                        step = "/extract new " + step.split(" ")[2];
                    } else if (updateType == UpdateType.append) {
                        step = "/extract append " + step.split(" ")[2];
                    }
                }
                if (!step.endsWith(";")) step += ";";
                TestGoobScraperVisitor.parseAndRunLine(step);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> extractSteps(File mdFile) {
        List<String> steps = new LinkedList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(mdFile));
            String text;
            while ((text = br.readLine()) != null && !(text.startsWith("Steps:"))) {
            }
            while ((text = br.readLine()) != null && !(text.startsWith("End Steps"))) {
                if (text.startsWith("/get") || text.startsWith("/extract")) {
                    steps.add(text);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return steps;

    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public TimeUnit getTimeType() {
        return timeType;
    }

    public void setTimeType(TimeUnit timeType) {
        this.timeType = timeType;
    }

    public double getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(double updateTime) {
        this.updateTime = updateTime;
    }

    enum UpdateType {
        append, replace
    }

    private File mdFile;
    private double updateTime;
    private TimeUnit timeType;
    private UpdateType updateType;
    private boolean alert;
    private

    FileUpdateInformation(File mdFile, double updateTime, TimeUnit timeType, String updateType) {
        this.mdFile = mdFile;
        this.updateTime = updateTime;
        this.timeType = timeType;

        switch(updateType) {
            case "append":
                this.updateType = UpdateType.append;
                break;
            case "new":
            case "replace":
                this.updateType = UpdateType.replace;
                break;
            default:
                throw new RuntimeException();
        }
    }

}
