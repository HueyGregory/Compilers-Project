
// Variables will reference the data that was returned by the program

public class Variable {
    private String text;

    public Variable(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    public static Variable variableFactory(String text) {
        return new Variable(text);
    }

}
