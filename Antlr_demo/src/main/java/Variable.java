
// Variables will reference the data that was returned by the program

public class Variable {
    private final String text;
    private final String url;

    public Variable(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    public static Variable variableFactory(String url, String text) {
        return new Variable(url, text);
    }

    public String getURL() {
        return this.url;
    }
}
