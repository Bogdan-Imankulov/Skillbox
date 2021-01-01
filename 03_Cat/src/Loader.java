
public class Loader
{
    public static void main(String[] args)
    {
        Cat murzik = new Cat();
        Cat vasya = new Cat();
        Cat musya = new Cat();
        Cat misha = new Cat();
        Cat murka = new Cat();
        //Создаем кошек

        System.out.println("Вес Мурзика: " + murzik.getWeight());
        System.out.println("Вес Васи: " + vasya.getWeight());
        System.out.println("Вес Муси: " + musya.getWeight());
        System.out.println("Вес Миши: " + misha.getWeight());
        System.out.println("Вес Мурки: " + murka.getWeight());
        //Выводим в консоль вес всех кошек

        murzik.feed(156.054);
        vasya.feed(354.5563);
        //Кормим кошек

        System.out.println("Вес Мурзика после обеда: " + murzik.getWeight());
        System.out.println("Вес Васи после обеда: " + vasya.getWeight());
        //Проверяем изменился ли вес кошек и выводим их вес в консоль

        while (!musya.getStatus().equals("Dead"))
        {
            musya.meow();
            System.out.println(musya.getStatus());
        }
        //Играем с мусей, очень долго играем.

        while (!misha.getStatus().equals("Exploded"))
        {
            misha.feed(100.0);
            System.out.println(misha.getStatus());
        }
        //Откармливаем мишу пока он не лопнет

        System.out.println("Мурка до еды: " + murka.getWeight());
        murka.pee();
        System.out.println("Вес Мурки после похода в туалет: " + murka.getWeight());
        //System.out.println("Вес съеденного корма: " + murka.food());
        murka.pee();
        System.out.println("Вес Мурки после еще одного похода в туалет: " + murka.getWeight());
        murka.feed(153.50);
        System.out.println("Мурка съела: " + murka.food());
        murka.feed(1535.5463);
        System.out.println("Мурка съела: " + murka.food());
        //Кормим Мурку, отправляем в туалет и выводим в консоль вес Мурки
    }
}