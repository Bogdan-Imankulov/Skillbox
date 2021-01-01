import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
    }

    public static String splitTextInToWords(String text) {
        //TODO реализуйте метод
        String newText = text.replaceAll("[\\-\\d]", " ");
        newText = newText.replaceAll("[\\.!\\?;,:]", "");
        newText = newText.replaceAll("\\s+", "\n");
        if (!text.equals("")) {
            return newText;
        }
        return "";
    }
}