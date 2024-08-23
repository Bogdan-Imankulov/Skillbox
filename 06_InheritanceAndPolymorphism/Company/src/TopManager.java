public class TopManager implements Employee {
    private final String NAME;        // Имя топ менеджера,один раз созданное не меняется
    private final String SURNAME;     // Фамилия топ менеджера,один раз созданное не меняется
    private double fixedSalary;               // оклад
    private Company company;          // компания в которой будет работать оператор
    private double monthSalary;       // месячная зарплата

    TopManager (Company company){
        this.company = company;
        fixedSalary = 150000 + 50000*Math.random();
        NAME = new GeneratingName().getName();
        SURNAME = new GeneratingName().getSurname();
    }
    @Override
    public String getNAME(){
        return NAME;
    }

    @Override
    public String getSURNAME(){
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

    @Override
    public double getMonthSalary() {
        if (company.getInCome() > 10000000) {
            monthSalary += 1.5 * fixedSalary;
            return Main.roundingSalary( monthSalary);
        }else
            return Main.roundingSalary( fixedSalary);
    }

}
