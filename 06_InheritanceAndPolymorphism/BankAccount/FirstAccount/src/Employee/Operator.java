package Employee;

public class Operator implements Employee {
//    Имя оператора
    private String name = "";
//    Фамилия оператора
    private String surname = "";
//    Доход для компани от оператора
    private double salaryForCompany = 57500;
//    Зарплата оператора
    private double salary = 12500;
//    Место работы, компания
    private Company company;

//    В конструктор передается имя и фамилия нового оператора
    public Operator(String name, String surname, Company company){
//        Имя и фамилия убирается от пробелов в начале и в конце
        this.name = name.trim();
        this.surname = surname.trim();
        company.hire(this);
    }
//    Метод toString(), для того что бы вывести все данные оператора: имя, фамилию, зарплату, доход для компании
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Operator. Name: ").append(name).append(", Surname: ").append(surname)
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
