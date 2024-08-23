//доступ к банковскому счету может быть и из других банков, перводы, проверка кредитной истории и т.д. модификатор public
public class BankAccount {
    //наверное сумма на счету должна быть известна тольо в банке, protected
    protected double amount;
    // все операции с банковскими счетами производятся не только в банке, пополнение снятие могут производится из других
    // банков, поэтому public
    public BankAccount(double amount) {
        this.amount = amount;
        System.out.println("Вы создали банковский счет с балансом в "+ amount + " на счету.");
    }


    public void withdrawAmount(double value) {
        amount -= value;
        double scale = Math.pow(10,2);
        amount = Math.round(amount * scale) / scale;
        System.out.println("С вашего счета списанно " + value + " рублей.");
    }

    public void depositAmount(double value) {
        amount += value;
        double scale = Math.pow(10,2);
        amount = Math.round(amount * scale) / scale;
        System.out.println("На ваш счет поступило " + value + " рублей.");
    }

    protected double getAmount() {
        double scale = Math.pow(10,2);
        amount = Math.round(amount * scale) / scale;
        System.out.println("На вашем счету " + amount + " рублей.");
        return amount;
    }
    protected boolean send(BankAccount receiver, double amount){
        //добавил то, что если сумма перевода с коммиссией больше, чем сумма на счету
        if (this.amount < 1.1 * amount) {
            System.out.println("Перевод неводможен, не достаточно средств");
            return false;
        } else {
            double beforeReceive = receiver.getAmount();
            double scale = Math.pow(10, 2);
            amount = Math.round(amount * scale) / scale;
            receiver.depositAmount(amount);
            this.amount -=  amount*1.01;
            double afterReceive = receiver.getAmount();
            if (afterReceive - beforeReceive == amount)
                return true;
        }
        return false;
    }

}
