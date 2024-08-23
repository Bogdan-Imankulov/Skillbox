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
      
      String phoneNumber = input.replaceAll("[^0-9]", "");
      phoneNumber = phoneNumber.replaceAll("^8","7");
      char [] chars = phoneNumber.toCharArray();
      if (chars.length == 10) {
        phoneNumber = "7" + phoneNumber;
        System.out.println(phoneNumber);
        return;
      }

      if (chars.length != 11 || chars[0] != '7')
        System.out.println("Неверный формат номера");
      else System.out.println(phoneNumber);
    }
  }

}
