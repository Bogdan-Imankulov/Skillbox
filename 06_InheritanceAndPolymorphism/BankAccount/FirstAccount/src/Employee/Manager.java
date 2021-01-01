package Employee;

public class Manager implements Employee {
//    Имя менеджера
    private String name = "";
//    Фамилия менеджера
    private String surname = "";
//    Доход для компании от менеджера выбирается случайно, от 115000 до 14000 рублей, затем это округляется до 2 знаков после запятой
    private double salaryForCompany = Math.round((115000 + Math.random() * 35000) * Math.pow(10, 2)) / Math.pow(10, 2);
//    Зарплата равна 25000 рублей, и 5 процентам от дохода для компании, затем это округляется до 2 знаков после запятой
    private double salary = Math.round((25000 + 0.05 * salaryForCompany) * Math.pow(10, 2)) / Math.pow(10, 2);
//    Рабочая компания
    private Company company;

//    В конструктор передается имя и фамилия нового менеджера
    public Manager(String name, String surname, Company company) {
//        Имя и фамилия менеджера убирается от пробелов в начале и в конце
        this.name = name.trim();
        this.surname = surname.trim();
        company.hire(this);
    }

//    Метод toString(), для того что бы вывести все данные менеджера: имя, фамилию, зарплату, доход для компании,
//    Рабочую компанию
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Manager. Name: ").append(name).append(", Surname: ").append(surname)
                .append(", Salary: ").append(salary).append(", Salary for company: ").append(salaryForCompany)
                .append(", Working company's name: ").append(company.getCompanyName());
        return result.toString();
    }

    //    Геттеры и Сеттеры...
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
