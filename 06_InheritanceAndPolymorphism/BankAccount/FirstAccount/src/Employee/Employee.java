package Employee;

public interface Employee {
    String name = "";
    String surname = "";
    Company company = null;
    double salaryForCompany = 0.0;
    String getName();
    String getSurname();
    double getSalaryForCompany();
    double getSalary();
    void setCompany(Company company);
    Company getCompany();
    String toString();
}
