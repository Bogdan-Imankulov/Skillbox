package Bank;

public class Individual extends Client {

    public Individual(double moneyAmount){
        this.moneyAmount = moneyAmount;
        System.out.println("Был успешно создан счет для физического лица с " + this.moneyAmount +  " рублей на счету");
    }
    public Individual(){
        this.moneyAmount = 0;
        System.out.println("Был успешно создан счет для физического лица с " + this.moneyAmount +  " рублей на счету");
    }

    @Override
    public void moneyWithdraw(double moneyAmount) {
        this.moneyAmount -= moneyAmount;
    }

    @Override
    public void moneyAdd(double moneyAmount) {
        this.moneyAmount += moneyAmount;
    }

    @Override
    public  double getMoneyAmount() {
        return this.moneyAmount;
    }
}
