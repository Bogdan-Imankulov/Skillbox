
public class Organization extends Client {
    Organization(double amount) {
        super(amount);
    }
    @Override
    public void depositAmount(double value) {
        amount += value;
        double scale = Math.pow(10, 2);
        amount = Math.round(amount * scale) / scale;
    }
    @Override
    public void withdrawAmount(double value) {
        if (value * 1.01 > amount){
            System.out.println("Вы не можете снять такую сумму, недостаточно средств");
        }else {
            amount -= value * 1.01;
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
        System.out.println("Пополнение происходит без комиссии.\nЗа снятие удерживается комиссия в 1% .\n" +
                "Баланс счета: " + amount);
    }
}
