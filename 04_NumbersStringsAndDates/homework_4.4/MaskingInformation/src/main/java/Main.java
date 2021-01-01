public class Main {

    public static void main(String[] args) {
        System.out.println(searchAndReplaceDiamonds("<1234>5678<9012>3456", "*"));
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        String s = " ";
        String newText = text;
        int rightDiamond = 0;
        int leftDiamond = 0;
        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == '<') {
                leftDiamond = leftDiamond + 1;
            }
            if (text.charAt(i) == '>') {
                rightDiamond = rightDiamond + 1;
            }
        }
        if (text.length() == 0 || placeholder.length() == 0)
        {
             s = "";
             return s;
        }
        newText = newText + " ";
        while (leftDiamond != 0 && rightDiamond != 0)
        {
            newText = (newText.replace(newText.substring(newText.indexOf('<'), newText.indexOf('>')+1), placeholder)).trim();
            leftDiamond = leftDiamond - 1;
            rightDiamond = rightDiamond -1;
            s = newText;
        }
        if (!text.contains("<") && !text.contains(">") || text.contains("<") && !text.contains(">") || !text.contains("<") && text.contains(">")){
            s = text.trim();
        }
        return s;
    }

}