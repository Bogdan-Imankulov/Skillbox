import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        searchAndReplaceDiamonds("1234 <1234> 1234", "***");
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений

        String pat1 = "(<[0-9\\s]>)|<(\\d{4}\\s){2}\\d{4}>|<\\d{4}>|<\\d+\\s\\d+\\s\\d+>";
        Pattern pattern = Pattern.compile(pat1);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()){
//            System.out.println("До замены: " + text);
            text =  text.replaceAll(pat1, placeholder);
//            System.out.println("После замены: " + text);
        }else{
            return text;
        }
        return text;
    }

}