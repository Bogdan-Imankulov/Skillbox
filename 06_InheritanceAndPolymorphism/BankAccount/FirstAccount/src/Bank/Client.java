package Bank;

public abstract class Client {

    public  double moneyAmount = 0;

    public abstract void moneyWithdraw(double moneyAmount);
    public abstract void moneyAdd(double moneyAmount);
    public abstract double getMoneyAmount();
}
