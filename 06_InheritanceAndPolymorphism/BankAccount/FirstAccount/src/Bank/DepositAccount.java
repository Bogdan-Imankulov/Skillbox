package Bank;

import java.time.LocalDate;

public class DepositAccount extends BankClass {
    private LocalDate moneyAddTime;

    public DepositAccount(double moneyAmount) {
        super(moneyAmount);
        moneyAddTime = LocalDate.now();
        System.out.println("Это депозитный счет, " +
                "обратите внимание, деньги с депозитного счета нельзя будет снимать с момента предыдущего пополнения!");
    }

    public void bankMoneyAdd(double moneyAmount){
        bankMoneyAmount = bankMoneyAmount + moneyAmount;
        moneyAddTime = LocalDate.now();
        System.out.println("Деньги были добавлены на счет, их невозможно будет снять в течении месяца!");
        System.out.println("Счет данного банковского аккаунта после пополнения равен " + bankMoneyAmount + " рублей");
    }

    public void moneyWithdraw(double moneyAmount) {
        if (canWithdraw(moneyAmount)){
            bankMoneyAmount -= moneyAmount;
            System.out.println("После снятия " + bankMoneyAmount + " рублей осталось на счету");
            System.out.println("С счета было снято " + moneyAmount + " рублей");
        }
    }
    public boolean canWithdraw(double moneyAmount){
        LocalDate withdrawDate = LocalDate.now();
        if (withdrawDate.toEpochDay() - moneyAddTime.toEpochDay() < 30){
            System.out.println("С момента предыдущего пополнения не прошло 1 месяца, ожидайте!");
            return false;
        }else if (bankMoneyAmount < moneyAmount){
            System.out.println("Недостаточно денег на счету!");
            return false;
        }else {
            return true;
        }
    }
}
