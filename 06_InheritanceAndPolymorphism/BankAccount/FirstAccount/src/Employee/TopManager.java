package Employee;

public class TopManager implements Employee {
//    Имя топ-менеджера
    private String name = "";
//    фамилия топ-менеджера
    private String surname = "";
//    Место работы, компания
    private Company company;
//    Доход для компании от топ-менеджера
    private double salaryForCompany = 299000;
//    Изначальная зарплата топ-менеджера
    private double salary = 65000;

//    В конструктор передается имя и фамилия нового топ-менеджера
    public TopManager(String name, String surname, Company company){
        this.name = name.trim();
        this.surname = surname.trim();
        company.hire(this);
    }
//    Метод toString(), для того что бы вывести все данные топ-менеджера: имя, фамилию, зарплату, доход для компании
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Top-Manager. Name: ").append(name).append(", Surname: ").append(surname)
                .append(", Salary: ").append(salary).append(", Salary for company: ").append(salaryForCompany)
                .append(", Working company's name: ").append(company.getCompanyName());
        return result.toString();
    }

//    Геттеры...
    public double getSalaryForCompany() {
        return salaryForCompany;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        if (company != null && company.getIncome() > 1000000){
            return salary + salary * 1.5;
        }
        return salary;
    }

    @Override
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
