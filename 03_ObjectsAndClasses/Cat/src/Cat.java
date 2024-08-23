
public class Cat {
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double totalFood;
    private static int count;
    static boolean isAlive = true;
    static final int EYES_COUNT = 2;
    static final double MIN_WEIGHT = 1000.0;
    static final double MAX_WEIGHT = 9000.0;

    private ColorOfCats catColor;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }
    public Cat(double weight){
        this();
        this.weight = weight;
        originWeight = weight;
    }

    public static int getCount() {
        if (isAlive == false)
            count--;
        isAlive = true;
        return count;
    }

    public void meow() {
        //делаем проверку веса и ограничиваем возможность мяукания, если все ОК кошка мяукает
        if (isWeightNormal() && isAlive == true) {
            weight = weight - 1;
            System.out.println("Meow");


        } else {
            System.out.println("Кошка в таком состоянии не может мяукать! ");
        }
        if (!isWeightNormal())
            setIsAlive(false);

    }

    public void feed(Double amount) {

        //делаем проверку веса кошки и ограничиваем возможность приема пищи, если все ОК кошка кушает

        if (isWeightNormal() && isAlive == true) {
            weight = weight + amount;
            totalFood = totalFood + amount;

        } else {
            System.out.println("Кошка в таком состоянии не может кушать! ");
        }
        if (!isWeightNormal())
            setIsAlive(false);
    }


    public void drink(Double amount) {
        if (isWeightNormal() && isAlive == true) {
            weight = weight + amount;

        } else {
            System.out.println("Кошка в таком состоянии не может пить! ");
        }
        if (!isWeightNormal())
            setIsAlive(false);
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    //метод, возвращающий вес съеденной еды
    public Double totalFood() {
        return totalFood;
    }

    //метод котоый уменьшает вес кошки после туалета, и советует что делать дальше.
    public void pee() {
        if (isWeightNormal() && isAlive == true) {
            weight = weight - 0.02 * weight;
            System.out.println("Это срочно надо закопать!!!");
        } else {
            System.out.println("Кошка в таком состоянии не может ходить в туалет! ");
        }
        if (!isWeightNormal())
            setIsAlive(false);

    }

    public boolean isWeightNormal() {
        return (weight > minWeight && weight < maxWeight);
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    //сеттер установки цвета кошки из перечисленных в enum
    public void setCatColor(ColorOfCats catColor){
        this.catColor = catColor;
    }

    //геттер возвращающий цвет кошки из перечисленных в enum
    public ColorOfCats getCatColor(){
        return catColor;
    }
    /*
    у нас имееются несколько переменных, которые харрактеризуют кошку при "рождении".
    private double originWeight;
    private ColorOfCats catColor;
    Для создания новой кошки, необходимо создань геттеры и сеттеры для этих переменных
    */

    //так как для веса у нас уже есть геттер, то создаем только сеттер.
    public void setWeight(double weight){
        this.weight = weight;
    }
    // метод копирования кошки
    public Cat copyCat(Cat cat){
        Cat cat1 = new Cat();
        weight = cat.getWeight();
        cat1.setWeight(weight);
        catColor = cat.getCatColor();
        cat1.setCatColor(catColor);
        return cat1;
    }
}
