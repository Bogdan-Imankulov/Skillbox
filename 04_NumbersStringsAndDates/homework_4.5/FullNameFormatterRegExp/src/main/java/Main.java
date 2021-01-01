import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String text = scanner.nextLine();
      if (text.equals("0")) {
        break;
      }
      Pattern pattern = Pattern.compile("[а-яА-Я\\-]\\s");
      Matcher matcher = pattern.matcher(text);
      String[] fullNameAsArr = text.split("\\s");
      if (matcher.find())
      {
        if (fullNameAsArr[0].equals(fullNameAsArr[1]) || fullNameAsArr[0].equals(fullNameAsArr[2]) || fullNameAsArr[1].equals(fullNameAsArr[2]))
        {
          System.out.println("Введенная строка не является ФИО");
        }else{
          System.out.printf("Фамилия: %s\nИмя: %s\nОтчество: %s", fullNameAsArr[0], fullNameAsArr[1], fullNameAsArr[2]);
        }
      }else{
        System.out.println("Введенная строка не является ФИО");
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }

}