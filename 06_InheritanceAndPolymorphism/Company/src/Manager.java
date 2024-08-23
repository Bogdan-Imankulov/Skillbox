public class Manager implements Employee {
    private final String NAME;        // Имя менеджера
    private final String SURNAME;     // Фамилия менеджера
    private Company company;
    private double fixedSalary; // оклад
    private double monthSalary; // месячная зарплата

    Manager(Company company) {
        this.company = company;
        SURNAME = new GeneratingName().getSurname();
        NAME = new GeneratingName().getName();
        // оклад менеджера от 25000 до 30000 руб
        fixedSalary = Main.roundingSalary(35000 + 10000 * Math.random());

    }
 // метод возвращает месячную зарплату в зависимости от заработанных денег от 115000 до 140000,
 // с премией 5% от заработанной суммы, прибавленной к окладу
    @Override
    public double getMonthSalary() {
        double earnedMoney = (115000 + 25000 * Math.random());
        monthSalary = fixedSalary + 0.05 * earnedMoney;
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
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public Company getCompany(){
        return company;
    }
}
