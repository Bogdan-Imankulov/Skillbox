package Bank;

public class SelfEmployed extends Client {

    public SelfEmployed(double moneyAmount){
        if (moneyAmount >= 1000){
            this.moneyAmount = moneyAmount*0.995;
        }else if (moneyAmount < 1000 && moneyAmount > 0){
            this.moneyAmount = moneyAmount*0.99;
        } else {
            System.out.println("На счет нельзя добавить 0 или меньше рублей!");
        }
        System.out.println("Был успешно создан счет для ИП с " + this.moneyAmount +  " рублей на счету");
    }
    public SelfEmployed(){
        this.moneyAmount = 0;
        System.out.println("Был успешно создан счет для ИП с " + this.moneyAmount +  " рублей на счету");
    }

    @Override
    public  void moneyWithdraw(double moneyAmount) {
        this.moneyAmount -= moneyAmount;
    }

    @Override
    public  void moneyAdd(double moneyAmount) {
        if (moneyAmount >= 1000){
            this.moneyAmount += moneyAmount*0.995;
        }else if (moneyAmount < 1000 && moneyAmount > 0){
            this.moneyAmount += moneyAmount*0.99;
        } else {
            System.out.println("На счет нельзя добавить 0 или меньше рублей!");
        }
    }

    @Override
    public double getMoneyAmount() {
        return this.moneyAmount;
    }
}
