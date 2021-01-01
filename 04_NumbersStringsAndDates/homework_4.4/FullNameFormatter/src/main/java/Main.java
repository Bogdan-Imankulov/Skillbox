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
      char separator = ' ';
      String newInput = "";
      int count = 0;
      boolean hasDigit = false;
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == separator) {
          count++;
        }
        if (Character.isDigit(input.charAt(i))) {
          hasDigit = true;
          break;
        }
      }
      if (count != 2 || hasDigit) {
        System.out.println("Введенная строка не является ФИО");
        return;
      }
      String name = input.substring(input.indexOf(separator));
      newInput = input.substring(0, input.indexOf(separator));
      String lastName = newInput;
      input = name.trim();
      name = input.substring(input.indexOf(separator));
      newInput = input.substring(0, input.indexOf(separator));
      String firstName = newInput;
      String thirdName = name.trim();
      System.out.println("Фамилия: " + lastName + "\n" + "Имя: " + firstName + "\n" + "Отчество: " + thirdName);
    }
  }
}