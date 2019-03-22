
// Variables will reference the data that was returned by the program

public class Variable {
    private String text;
    private String url;

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

}
