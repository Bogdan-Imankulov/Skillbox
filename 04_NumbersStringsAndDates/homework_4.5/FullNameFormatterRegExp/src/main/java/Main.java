import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
            //Устанавливаем шаблон: русские буквы, дефис за ними следует пробел
            Pattern pattern = Pattern.compile("[а-яА-Я\\-]\\s");
            // устанваливаем шаблон: цифры после пробел или пробел перед цифрами
            // пользователь может набрать цифры в любой строке при наборе, чего нет в тесте
            // имеется в виду первая строка Кирилица, вторая будет цифры, ну и тому подобное
            Pattern pattern1 = Pattern.compile("([ 0-9]\\s)|(\\s[ 0-9])");
            //получаем объект Matcher, результат поиска наших шаблонов в input
            Matcher matcher = pattern.matcher(input);
            Matcher matcher1 = pattern1.matcher(input);
            // получаем массив, путем деления введенных данных используя пробел
            String[] arrFullName = input.split(" ");
            // проверяем input должен иметь только кирилицу, не должен иметь цифр  должен иметь
            // только 3 елемента
            if (matcher.find() && !matcher1.find() && arrFullName.length == 3) {
                // полученный массив не должен иметь одинаковых значений
                if (arrFullName[0].equals(arrFullName[1]) || arrFullName[1].equals(arrFullName[2]) || arrFullName[0].equals(arrFullName[2])) {
                    System.out.println("Введенная строка не является ФИО");
                } else
                    System.out.printf("Фамилия: %s\nИмя: %s\nОтчество: %s\n", arrFullName[0], arrFullName[1], arrFullName[2]);
            } else
                System.out.println("Введенная строка не является ФИО");
        }
    }

}

