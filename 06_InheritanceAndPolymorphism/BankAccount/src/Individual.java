public class Individual extends Client{
    Individual(double amount) {
        super(amount);
    }
    @Override
    public void depositAmount(double value){
        amount += value;
        double scale = Math.pow(10,2);
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
        double scale = Math.pow(10,2);
        amount = Math.round(amount * scale) / scale;
        return amount;
    }
    @Override
    public void information(){
        System.out.println("Пополнение и снятие происходит без комиссии.\n" +
                "Баланс счета: "+ amount);
    }
}
