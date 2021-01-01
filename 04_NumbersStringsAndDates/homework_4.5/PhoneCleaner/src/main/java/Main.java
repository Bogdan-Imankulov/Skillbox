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
            String phone = input.replaceAll("[^\\d]", "");
            phone = phone.replaceAll("^8", "7");
            char[] phoneAsCharArr = phone.toCharArray();
            if (phoneAsCharArr.length == 10) {
                phone = "7" + phone;
                System.out.println(phone);
                return;
            }
            if (phoneAsCharArr.length != 11 || phoneAsCharArr[0] != '7')
                System.out.println("Неверный формат номера");
            else System.out.println(phone);
        }
    }

}
