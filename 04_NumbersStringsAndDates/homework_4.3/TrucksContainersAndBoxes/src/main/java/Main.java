import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
        // переводим входящие данные типа String в int
        int countOfBoxes = Integer.parseInt(boxes);

        // количество коробок в контейнере
        int boxesInContainer = 27;

        // количество контейнеров в грузовике
        int containerInTrucks = 12;

        // необходимое количество контейнеров
        int countOfContainers =0;

        // необходимое количество грузовиков
        int countOfTrucks = 0;

        if (countOfBoxes <= 0) {  // пользователь может ошибиться  и ввести отрицательное значение
            countOfContainers = 0; //это если нет ящиков, то и не нужны контейнеры
            countOfTrucks = 0;      // грузовики тоже не нужны

        }else
//
        for (int i = 1; i <= countOfBoxes; i ++){
           if ((i-1)%(containerInTrucks * boxesInContainer) == 0 ){// если грузовик заполнился контейнерами
                countOfTrucks ++;  // добавляем новый грузовик
                System.out.println("Грузовик: " + countOfTrucks);
           }
           if ((i-1) % boxesInContainer == 0) {  // если контейнер заполнился ящиками
               countOfContainers ++; // добавляем новый контейнер
               System.out.println("\tКонтейнер: " + countOfContainers);
           }
                System.out.println("\t\tЯщик: " + (i ));




        }
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + countOfTrucks + " шт.");
        System.out.println("контейнеров - " + countOfContainers + " шт.");

    }
}

