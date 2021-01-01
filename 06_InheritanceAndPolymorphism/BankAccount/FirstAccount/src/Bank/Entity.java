package Bank;

public class Entity extends Client {

    public Entity(double moneyAmount){
        this.moneyAmount = moneyAmount;
        System.out.println("Был успешно создан счет для юридического лица с " + this.moneyAmount +  " рублей на счету");
    }
    public Entity(){
        this.moneyAmount = 0;
        System.out.println("Был успешно создан счет для юридического лица с " + this.moneyAmount +  " рублей на счету");
    }


    @Override
    public  void moneyWithdraw(double moneyAmount) {
        this.moneyAmount -= moneyAmount*1.01;
    }

    @Override
    public  void moneyAdd(double moneyAmount) {
        this.moneyAmount += moneyAmount;
    }

    @Override
    public  double getMoneyAmount() {
        return this.moneyAmount;
    }
}
