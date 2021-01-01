import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println(calculateSalarySum("Вася - 3000 рублей, Петя - 15686 рублей, А Маша заработала - 55715 рублей"));
  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    String[] strArr = text.split("\\s+");
    int totalSalary = 0;
    for (int i = 0; i < strArr.length; i++)
    {
      if (Character.isDigit(strArr[i].charAt(0)))
      {
        totalSalary = totalSalary + Integer.parseInt(strArr[i]);
      }
    }
    return totalSalary;
  }
}