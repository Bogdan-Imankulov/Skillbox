//import picocli.CommandLine;

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
//      если нулл то ретурн -1
        if (number == null) {
            return -1;
        }
//      Нумбер переводим в стринг
        String numToStr = number.toString();
//      Лист класса инт
        ArrayList<Integer> numToList = new ArrayList<>();
//      Сумма цифр числа
        int sum = 0;
        for (int i = 0; i < numToStr.length(); i++) {
            numToList.add(Integer.parseInt(String.valueOf(numToStr.charAt(i))));
            sum = sum + numToList.get(i);

        }
        return sum;
    }
}
