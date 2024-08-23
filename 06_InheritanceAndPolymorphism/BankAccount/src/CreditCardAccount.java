public class CreditCardAccount extends BankAccount {
    CreditCardAccount(double amount) {
       super(amount);

       System.out.println("Ваша карта созданна с балансом " + amount + " рублей");

    }
    @Override
    public void withdrawAmount(double value) {
        double amount = this.amount;
        amount -= value * 1.01;
        double scale = Math.pow(10,2);
        amount = Math.round(amount * scale) / scale;
        System.out.println("С вашей карты списанно " + value + " рублей.");
    }
    @Override
    public void depositAmount(double value) {
        double amount = this.amount;
        amount += value;
        double scale = Math.pow(10,2);
        amount = Math.round(amount * scale) / scale;
        System.out.println("На вашу карту поступило " + value + " рублей.");
    }
    @Override
    protected double getAmount() {
        double amount = this.amount;
        double scale = Math.pow(10,2);
        amount = Math.round(amount * scale) / scale;
        System.out.println("На вашей карте " + amount + " рублей.");
        return amount;
    }
}
