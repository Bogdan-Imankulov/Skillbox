public class Main {

    public static void main(String[] args) {

    }

    public static String splitTextInToWords(String text) {
        //TODO реализуйте метод
        if (text.length() == 0) {
            return "";
        }
        // меняю все дефисы на пробелы
        text = text.replaceAll("-", " ");
        // удаляю все цифры и знаки препинания, которые вспомнил
        text = text.replaceAll("[.,;!?:\\d]", "");
        // заменяю пробелы между словами на перенос строки.
        // если заменить перенос строки на возврат каретки \r, тоже не проходит тест
        text = text.replaceAll("\\s+", "\n");
        return text;
    }

}