package updater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutomaticUpdater {

    private static Map<Double, FileUpdateInformation> timesForUpdate;    // key is in terms of hours

    private static List<File> getMDFiles() {
        List<File> files = new ArrayList<File>();
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains("_MD.txt"))
                files.add(file);
        }
        return files;
    }

    private static Long matchTime(String text) {
        Long time = null;
        Pattern intPattern = Pattern.compile("\\w+([0-9]+)");
        Matcher matcher = intPattern.matcher(text);

        for (int i = 0; i < matcher.groupCount(); i++) {
            if (!matcher.find()) {
                return null;
            }
            time = Long.valueOf(matcher.group());
        }
        return time;
    }

    private static String matchType(String text, String prior) {
        Pattern strPattern = Pattern.compile("([a-zA-Z]+)");
        Matcher matcher = strPattern.matcher(text);
        for (int i = 0; i < matcher.groupCount(); i++) {
            do {
                if (!matcher.find()) {
                    return null;
                }
            } while (matcher.group().equals(prior));
            return matcher.group();
        }
        return null;
    }

    private static void extractAndRunUpdates(List<File> files, ScheduledExecutorService es) {
        for (File file : files) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String text;
                while (!(text = br.readLine()).contains("update:")) {
                }
                text = text.substring(7);
                Long time = matchTime(text);
                String updateType = matchType(text, null);
                String strTimeType = matchType(text, updateType);
                TimeUnit timeType = getTimeType(strTimeType);
                if (time == null || strTimeType == null || timeType == null || updateType == null) continue;
                addFileToExecutor(file, time, timeType, updateType, es);
                System.out.println(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void addFileToExecutor(File file, Long time, TimeUnit timeType, String updateType, ScheduledExecutorService es) {
        es.scheduleWithFixedDelay(new FileUpdateInformation(file, time, timeType, updateType), time, time, timeType);
    }

    private static TimeUnit getTimeType(String numStr) {
        if (numStr == null) return null;
        try {
            switch(numStr){
                case "sec":
                    return TimeUnit.SECONDS;
                case "min":
                    return TimeUnit.MINUTES;
                case "hrs":
                    return TimeUnit.HOURS;
                case "day":
                    return TimeUnit.DAYS;
                default:
                    return TimeUnit.valueOf(numStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main (String[] arg) {
        List<File> files = getMDFiles();
        int numCores = Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3*numCores);
        extractAndRunUpdates(files, es);
    }
}
