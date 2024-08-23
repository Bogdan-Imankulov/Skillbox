

public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        char delimiter = ' ';
        int salary = 0;
        String str = "";
        System.out.println(text.length());
        for (int i = 0 ; i < text.length(); i ++){
            // находим первый пробел и оставляем строку после пробела
            String word = text.substring(text.indexOf(delimiter));

// в переменную str вносим первую строку до пробела
            str = text.substring(0,text.indexOf(delimiter));

// обрезаем пробел в начале строки
            text = word.trim();

// является ли первая строка числом достаточно проверить только первый элемент строки
            if (Character.isDigit(str.charAt(0))){
                salary = salary + Integer.parseInt(str);
            }
        }
        System.out.println(salary);







    }

}

