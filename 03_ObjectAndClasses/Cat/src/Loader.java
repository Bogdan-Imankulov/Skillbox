
public class Loader {
    public static Cat getKitten() {
        Cat kittenVasya = new Cat(1100);
        return kittenVasya;
    }

    public static void main(String[] args) {

        Cat vasya = new Cat();
        vasya.setCatName("Вася");
        vasya.setCatColor(CatColor.WHITE);
        System.out.println("Вася: " + vasya.getStatus());
        System.out.println(Cat.getCount());
        vasya.feed(185.354);
        System.out.println("Вася: " + vasya.getStatus());
        System.out.println(Cat.getCount());
        System.out.println("=================================================================");

        Cat musya = new Cat();
        System.out.println("Муся: " + musya.getStatus());
        System.out.println(Cat.getCount());
        musya.feed(185.354);
        System.out.println("Муся: " + musya.getStatus());
        System.out.println(Cat.getCount());
        System.out.println("=================================================================");

        Cat murzik = new Cat();
        System.out.println("Мурзик: " + murzik.getStatus());
        System.out.println(Cat.getCount());
        System.out.println("Мурзик: " + murzik.getStatus());
        System.out.println(Cat.getCount());
        System.out.println("=================================================================");

        Cat misha = new Cat();
        System.out.println("Миша: " + misha.getStatus());
        System.out.println(Cat.getCount());
        misha.meow();
        System.out.println("Миша: " + misha.getStatus());
        System.out.println(Cat.getCount());
        System.out.println("Миша: " + misha.getStatus());
        System.out.println(Cat.getCount());
        System.out.println("=================================================================");

        Cat barsik = new Cat();
        System.out.println("Барсик: " + barsik.getStatus());
        System.out.println(Cat.getCount());
        System.out.println("Барсик: " + barsik.getStatus());
        System.out.println(Cat.getCount());
        System.out.println("=================================================================");

        Cat kitten1 = Loader.getKitten();
        Cat kitten2 = Loader.getKitten();
        Cat kitten3 = Loader.getKitten();
        System.out.println(kitten1.getWeight());
        System.out.println(barsik.getWeight());
        System.out.println(kitten2.getWeight());
        System.out.println(kitten3.getWeight());

        Cat newVasya = new Cat(2500.0,"Вася", CatColor.WHITE);
        System.out.println(newVasya.getWeight());
        System.out.println(newVasya.getCatName());
        System.out.println(newVasya.getCatColor());
    }
}