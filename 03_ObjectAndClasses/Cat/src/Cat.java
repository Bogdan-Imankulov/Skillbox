public class Cat {
    private double originWeight;
    private double weight;
    final int EYES_COUNT = 2;


    private double minWeight;
    private double maxWeight;
    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    static int count = 0;
    public static boolean isDead;
    private CatColor catColor;
    private String catName;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
        isDead = false;
    }

    public Cat(double weight) {
        originWeight = weight;
        this.weight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }

    public Cat(double weight, String catName, CatColor catColor)
    {
        this();
        this.weight = weight;
        this.catName = catName;
        this.catColor = catColor;
    }

    public static int getCount() {
        if (isDead == true) {
            count--;
            isDead = false;
        }
        return count;
    }

    public void meow() {
        if (isWeightNormal() && !isDead) {
            weight = weight - 2500;

        } else {
            System.out.println("Ваша кошка не может мяукать!");
        }
        if (!isWeightNormal()) {
            setIsDead(true);
        }
    }

    public void feed(Double amount) {
        if (isWeightNormal() && !isDead) {
            weight = weight + amount * 50;

        } else {
            System.out.println("Ваша кошка не может есть!");
        }
        if (!isWeightNormal()) {
            setIsDead(true);
        }
    }

    public void drink(Double amount) {
        if (isWeightNormal() && !isDead) {
            weight = weight + amount * 50;

        } else {
            System.out.println("Ваша кошка не может пить!");
        }
        if (!isWeightNormal()) {
            setIsDead(true);
        }
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

    public boolean isWeightNormal() {
        return (weight > minWeight && weight < maxWeight);
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public void setCatColor(CatColor catColor)
    {
        this.catColor = catColor;
    }

    public CatColor getCatColor() {
        return catColor;
    }

    public void setCatName(String catName)
    {
        this.catName = catName;
    }

    public String getCatName()
    {
        return catName;
    }
}