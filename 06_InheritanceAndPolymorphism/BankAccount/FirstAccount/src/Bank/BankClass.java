package Bank;


public class BankClass {

    protected double bankMoneyAmount;
    public BankClass(double moneyAmount) {
        bankMoneyAmount = moneyAmount;
        System.out.println("На данный момент на счету " + bankMoneyAmount + " рублей");
    }

    public void moneyWithdraw(double moneyAmount) {
        if (canWithdraw(moneyAmount)){
            bankMoneyAmount -= moneyAmount;
            System.out.println("После снятия " + bankMoneyAmount + " рублей осталось на счету");
            System.out.println("С счета было снято " + moneyAmount + " рублей");
        }else {
            System.out.println("Недостаточно денег на счету!");
        }
    }

    public double getBankMoneyAmount() {
        return bankMoneyAmount;
    }

    public void bankMoneyAdd(double moneyAmount) {
        bankMoneyAmount = bankMoneyAmount + moneyAmount;
        System.out.println("Счет данного банковского аккаунта после пополнения равен " + bankMoneyAmount + " рублей");
    }

    public boolean canWithdraw(double moneyAmount){
        if (bankMoneyAmount >= moneyAmount){
            return true;
        }else{
            System.out.println("Недостаточно денег на счету!");
            return false;
        }
    }

    public boolean sendMoney(BankClass receiverAccount, double moneyAmount) {
        if (moneyAmount > 0) {
            if (canWithdraw(moneyAmount)) {
                receiverAccount.bankMoneyAdd(moneyAmount);
                this.moneyWithdraw(moneyAmount);
                return true;
            }
        }
        return false;
    }

    public boolean sendMoney(DepositAccount receiverAccount, double moneyAmount) {
        if (moneyAmount > 0) {
            if (canWithdraw(moneyAmount)) {
                receiverAccount.bankMoneyAdd(moneyAmount);
                this.moneyWithdraw(moneyAmount);
                return true;
            }
        }
        return false;

    }
    public boolean sendMoney(CardBankAccount receiverAccount, double moneyAmount) {
        if (moneyAmount > 0) {
            if (canWithdraw(moneyAmount)) {
                receiverAccount.bankMoneyAdd(moneyAmount);
                this.moneyWithdraw(moneyAmount);
                return true;
            }
        }
        return false;
    }
}
