
public class Loader {
    public static void main(String[] args) {
        //boolean isAlive = false;

        //создаем несколько кошек
        Cat caric = new Cat();
        Cat murka = new Cat();
        Cat murzic = new Cat();
        Cat vacyuta = new Cat();
        Cat vaska = new Cat();
        Cat mashka = new Cat();
        // выводим вес кошек в консоль
        System.out.println("Вес Карика: " + caric.getWeight());
        System.out.println("Вес Мурки: " + murka.getWeight());
        System.out.println("Вес Мурзика: " + murzic.getWeight());
        System.out.println("Вес Васюты: " + vacyuta.getWeight());
        System.out.println("Вес Васьки: " + vaska.getWeight());
        System.out.println("Вес Машки: " + mashka.getWeight());
        //проверяем количество объектов
        System.out.println(Cat.getCount() + " Cats");
        //кормим Машку и Мурку
        mashka.feed(300.2);
        murka.feed(350.22);
        vacyuta.drink(200.0);
        murzic.drink(230.021);
        //выводим в консоль вес Машки и Мурки и проверяем изменился ли вес
        System.out.println("Вес Машки после кормежки: " + mashka.getWeight());
        System.out.println("Вес Мурки после кормежки: " + murka.getWeight());
        //сильно - сильно кормим кота Карика :)
        while (!caric.getStatus().equals("Exploded")) {
            caric.feed(360.55);
            System.out.println(caric.getStatus());
        }
        System.out.println("Карик умирает остается " + Cat.getCount() + "кошек");
        //Щекотим Ваську до последнего издыхания :)
        while (!vaska.getStatus().equals("Dead")) {
            vaska.meow();
            System.out.println(vaska.getStatus());
        }
        System.out.println(Cat.getCount() + " Cats");
        vaska.feed(2300.00);

        //создаем кота Малой , кормим и отправляем в туалет
        Cat maloy = new Cat();
        System.out.println(maloy.totalFood());
        maloy.feed(500.55);
        maloy.pee();
        maloy.feed(645.32);
        maloy.pee();
        System.out.println(maloy.totalFood());
        Cat kitten1 = Loader.getKitten();
        Cat kitten2 = Loader.getKitten();
        Cat kitten3 = Loader.getKitten();
        System.out.println(kitten1.getWeight());
        System.out.println(kitten2.getWeight());
        System.out.println(kitten3.getWeight());
    }
    private static Cat getKitten(){
        Cat kitten = new Cat(1100.0);
        return kitten;
    }
}


