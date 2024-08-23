public class SelfEmployed extends Client {
    SelfEmployed(double amount) {
        super(amount);
    }
    public void depositAmount(double value) {
        if (value < 1000) {
            value *= 0.99;
        } else  value *= 0.995;
        amount += value;
        double scale = Math.pow(10, 2);
        amount = Math.round(amount * scale) / scale;
    }
    @Override
    public void withdrawAmount(double value) {
        if (value > amount){
            System.out.println("Вы не можете снять такую сумму, недостаточно средств");
        }else {
            amount -= value;
            double scale = Math.pow(10, 2);
            amount = Math.round(amount * scale) / scale;
        }
    }
    @Override
    public double getAmount() {
        double scale = Math.pow(10, 2);
        amount = Math.round(amount * scale) / scale;
        return amount;
    }
    @Override
    public void information() {
        System.out.println("За пополнение меньше 1000 рублей, удерживается комиссия в 1%, начиная с 1000 рублей комиссия 0.5%." +
                "\nСнятие происходит без комиссии.\n" +
                "Баланс счета: " + amount);
    }
}
