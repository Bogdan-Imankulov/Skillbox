package Bank;

public class CardBankAccount extends BankClass{
    public CardBankAccount(double moneyAmount) {
        super(moneyAmount);
        bankMoneyAmount = moneyAmount;
        System.out.println("Это карточный счет, " +
                "обратите внимание, при снятии или отправке денег на другой счет будет браться комиссия 1%");
    }

    public void moneyWithdraw(double moneyAmount){
        if (canWithdraw(moneyAmount)){
            bankMoneyAmount -= moneyAmount * 1.01;
            System.out.println("После снятия " + bankMoneyAmount + " рублей осталось на счету");
            System.out.println("С счета было снято " + moneyAmount + " рублей");
        }
    }
    public boolean canWithdraw(double moneyAmount){
        if (bankMoneyAmount >= moneyAmount*1.01){
            return true;
        }else{
            System.out.println("Недостаточно денег на счету!");
            return false;
        }
    }

    @Override
    public double getBankMoneyAmount() {
        return bankMoneyAmount;
    }
}
