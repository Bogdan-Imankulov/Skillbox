abstract class Client {
    double amount;
    Client(double amount){
        this.amount = amount;
    }
//    метод getAmount()во всех классах имеет одинаковый код.
//
    public abstract void depositAmount(double value);

    public abstract void withdrawAmount(double value);
    public abstract double getAmount();
    public abstract void information();

}
