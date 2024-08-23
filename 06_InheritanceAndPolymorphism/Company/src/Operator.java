public class Operator implements Employee {
    private final String NAME;        // Имя менеджера
    private final String SURNAME;     // Фамилия менеджера
    private double monthSalary; // месячная зарплата
    private Company company;      // компания в которой будет работать оператор


    // конструкот Оператора
    Operator(Company company) {
        this.company = company;
        SURNAME = new GeneratingName().getSurname();
        NAME = new GeneratingName().getName();
        //генерирует месячную зарплату, от 15000 до 20000 руб, т.к. оклад равет месячной зарплате имеется только одна переменная
        monthSalary = Main.roundingSalary(15000 + 5000 * Math.random());

    }

    @Override
    public double getMonthSalary() {
        return Main.roundingSalary(monthSalary);
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    @Override
    public String getSURNAME() {
        return SURNAME;
    }

    @Override
    public Company getCompany() {
        return company;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }
}
