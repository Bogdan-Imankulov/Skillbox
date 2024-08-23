import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;

        int sum = sumDigits(7843);

        System.out.println(sum);
    }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

    public static int sumDigits(Integer number) {
        //@TODO: write code here and delete TODO line
        // если передали null возвращает -1
        if (number == null)
            return -1;
        //переводим Integer в String
        String numToStr = number.toString();
//     создаем  ArrayList<Character> numToChar куда поместим все символы по порядку
        ArrayList<Character> numToChar = new ArrayList<>();
        //добавляем  elements
        for (int i = 0; i < numToStr.length(); i++) {
            numToChar.add(numToStr.charAt(i));
        }
        //создаем список Integer
        ArrayList<Integer> numToInt = new ArrayList<>();
        // добавляем туда элементые numToChar преобразовав в int при помощи метода parseInt()
        for (int i = 0; i < numToChar.size(); i++) {
            numToInt.add(Integer.parseInt(numToChar.get(i).toString()));
        }
        // суммируем
        int sum = 0;
        for (int i = 0; i < numToInt.size(); i++) {
            sum = sum + numToInt.get(i);
        }

        return sum;
    }

}
