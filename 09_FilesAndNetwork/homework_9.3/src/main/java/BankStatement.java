import java.util.Date;

public class BankStatement {
    private String typeAccount;
    private String numberAccount;
    private String currency;
    private Date date;
    private String reference;
    private String description;
    private double income;
    private double expense;

    public BankStatement(String typeAccount, String numberAccount, String currency, Date date, String reference,
                         String description, double income, double expense) {
        this.typeAccount = typeAccount;
        this.numberAccount = numberAccount;
        this.currency = currency;
        this.date = date;
        this.reference = reference;
        this.description = description;
        this.income = income;
        this.expense = expense;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "description='" + description + '\'' +
                ", income=" + income +
                ", expense=" + expense + "\n";
    }
}
