import java.io.File;
import java.nio.file.Path;

public class AutomaticUpdater {

    private static void getMDFiles() {
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains("_MD.txt"))
                System.out.println(file.getName());
        }
    }

    public static void main (String[] arg) {
        getMDFiles();
    }

}
