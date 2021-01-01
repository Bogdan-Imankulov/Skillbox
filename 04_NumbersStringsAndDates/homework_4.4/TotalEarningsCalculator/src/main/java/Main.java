public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        char separate = ' ';
        int salary = 0;
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            String str = text.substring(text.indexOf(separate));
            word = text.substring(0, text.indexOf(separate));
            text = str.trim();
            if (Character.isDigit(word.charAt(0))) {
                salary = salary + Integer.parseInt(word);
            }
        }
        System.out.println(salary);
    }
}