import java.time.LocalDate;

public class DepositAccount extends BankAccount{
    LocalDate openDeposit;
     DepositAccount(double amount) {
        super(amount);
         openDeposit = LocalDate.now();
    }
    @Override
    public void withdrawAmount(double value) {
        LocalDate withdrawDay = LocalDate.now();
        if (withdrawDay.toEpochDay() - openDeposit.toEpochDay() >= 30) {
            double amount = getAmount();
            amount -= value;
            double scale = Math.pow(10, 2);
            amount = Math.round(amount * scale) / scale;
            System.out.println("С вашего счета списанно " + value + " рублей.");
        }else System.out.println("Вы не можете снять денег, еще не прошел календарный месяц");
    }
    @Override
    public void depositAmount(double value) {
        openDeposit = LocalDate.now();
        double amount = getAmount();
        amount += value;
        double scale = Math.pow(10,2);
        amount = Math.round(amount * scale) / scale;
        System.out.println("На ваш счет поступило " + value + " рублей.");
    }
}
