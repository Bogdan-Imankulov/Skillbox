public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        String delimiter1 = "<";
        String delimiter2 = ">";
        String cutText = "";
        String cutText1 = "";
        String cutText2 = "";
        if (text.indexOf(delimiter1) == -1 || text.indexOf(delimiter2) == -1)
            return text;
        int index1start = text.indexOf(delimiter1);
        int index2start = text.indexOf(delimiter2);
        int index1finish = text.lastIndexOf(delimiter1);
        int index2finish = text.lastIndexOf(delimiter2);
        if (index1start == index1finish) {
            cutText = text.substring(0, index1start);
            cutText1 = text.substring(index2start +1);
            text = cutText + placeholder + cutText1;
        }
        else {
            cutText = text.substring(0, index1start);
            cutText1 = text.substring(index2start +1, index1finish);
            cutText2 = text.substring(index2finish +1);
            text = cutText + placeholder + cutText1 + placeholder + cutText2;
        }
        return text;
    }


}