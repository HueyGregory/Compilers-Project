package updater;

import Visitor.TestGoobScraperVisitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
            if (extractNewHash(this.mdFile) != hash) {
                alertUser();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long extractNewHash(File mdFile) {
        try {
            String text;
            BufferedReader br = new BufferedReader(new FileReader(mdFile));
            while ((text = br.readLine()) != null && !(text.equals("hash:"))) {
                return Long.valueOf(text.substring(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return 0L;
    }

    private void alertUser() {
        System.out.println("Alert User");
        // NEED TO DO
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

    enum UpdateType {
        append, replace
    }

    private File mdFile;
    private double updateTime;
    private TimeUnit timeType;
    private UpdateType updateType;
    private boolean alert;
    private long hash;

    FileUpdateInformation(File mdFile, double updateTime, TimeUnit timeType, String updateType, boolean alert, long hash) {
        this.mdFile = mdFile;
        this.updateTime = updateTime;
        this.timeType = timeType;
        this.alert = alert;
        this.hash = hash;

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
