public class Account {

    private long money;
    private String accNumber;
    private boolean isBlocked;

    public Account(long money, String accNumber, boolean isBlocked) {
        this.money = money;
        this.accNumber = accNumber;
        this.isBlocked = isBlocked;
    }

    public long getMoney() {
        return isBlocked ? 0 : money;
    }

    public void setMoney(long money) {
        this.money = isBlocked ? 0 : money;
    }

    public String getAccNumber() {
        return isBlocked ? "Account blocked" : accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = isBlocked ? "" : accNumber;
    }

    public void block() {
        isBlocked = true;
    }
    public boolean isBlocked(){
        return isBlocked;
    }
}
