
// Variables will reference the data that was returned by the program

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Variable {
    private String text;
    private String url;
    private String name;
    private String fileName;
    private static AtomicInteger number = new AtomicInteger(0);

    public Variable(String url, String text) {
        this.name = newName();
        this.url = url;
        this.text = text;
    }

    private String newName() { return String.valueOf(number.getAndIncrement()); }

    public final String getText() {
        return this.text;
    }
    public final void setText(String text) { this.text = text; }

    public static final Variable variableFactory(String url, String text) {
        return new Variable(url, text);
    }

    public final String getURL() { return this.url; }

    /**
     *
     * @return
     */
    public final String getName() { return this.getName(); }

    // only used by /update
    public String getFileName() {
        return fileName;
    }

    // only used by /extract
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
