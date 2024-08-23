import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.

            // обозначаю разделитель
            char delimiter = ' ';
            String cutInput = "";
            int count = 0;
            boolean digitHere = false;
            // в валидной строке должно быть два пробела. Считаем пробелы
            // и если не равно 2 то выводим предупреждение
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == delimiter) {
                    count++;
                }
                //проверяем есть ли цифры в строке
                if (Character.isDigit(input.charAt(i))) {
//                digitHere = true;
                    break;
                }
            }
            // проверяем правильность ввода данных в противном случае останавливаем программу
            if (count != 2 || digitHere) {
                System.out.println("Введенная строка не является ФИО");
                return;
            }


            // в первую очередь находим фамилию
            String fullName = input.substring(input.indexOf(delimiter));
            cutInput = input.substring(0, input.indexOf(delimiter));
            String lastName = cutInput;
            input = fullName.trim();
            // во вторую очередь находим имя
            fullName = input.substring(input.indexOf(delimiter));
            cutInput = input.substring(0, input.indexOf(delimiter));
            String name = cutInput;
            // в третью очередь находим отчество
            String middleName = fullName.trim();
//            System.out.println("Фамилия: " + lastName);
//            System.out.println("Имя: " + name);
//            System.out.println("Отчество: " + middleName);
          System.out.println("Фамилия: " + lastName + "\n" + "Имя: " + name + "\n" + "Отчество: " + middleName);

        }
    }
}

