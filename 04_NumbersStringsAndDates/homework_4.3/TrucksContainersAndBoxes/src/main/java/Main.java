import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t
        /* Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт. */

        //================================================================================
        Scanner scanner = new Scanner(System.in);
        String userBoxes = scanner.nextLine();
        int boxNumber = Integer.parseInt(userBoxes);
        int containers  = 0;
        int trucks = 0;
        if (boxNumber == 0)
        {
            trucks = 0;
            containers = 0;
            System.out.println("Грузовик: " + trucks);
            System.out.println("\tКонтейнер: " + containers);
            System.out.println("\t\tЯщик: " + boxNumber);
        }else
            for (int i = 1; i <= boxNumber; i++)
            {
                if ((i-1) % (12*27) == 0)
                {
                    trucks++;
                    System.out.println("Грузовик: " + trucks);
                }
                if ((i-1) % 27 == 0)
                {
                    containers++;
                    System.out.println("\tКонтейнер: " + containers);
                }
                System.out.println("\t\tЯщик: " + i);
            }
        System.out.println("Необходимо: ");
        System.out.println("грузовиков: " + trucks);
        System.out.println("контейнеров: " + containers);
    }
}
