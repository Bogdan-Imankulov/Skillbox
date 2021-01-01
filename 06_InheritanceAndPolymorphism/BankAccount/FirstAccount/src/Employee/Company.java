package Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
//    Список сотрудников компании
    private ArrayList<Employee> employees = new ArrayList<>();
//    Имя компании
    private String companyName;
//    Доход компании
    private double income;

//    В конструктор передается имя компании
    public Company(String companyName){
        this.companyName = companyName;
    }
//    Метод toString() для того что бы вывести все данные компании: название компании, доход, кол-во сотрудников
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Company. Name: ").append(companyName).append(", Income: ").append(income).append(", Employees count: ")
                .append(employees.size());
        return result.toString();
    }
//    Метод, нанимающий сотрудника: Менеджера | Оператора | Топ-менеджера
    public void hire(Employee employee){
        employees.add(employee);
        income += employee.getSalaryForCompany();
        employee.setCompany(this);
    }
//    Метод, нанимающий список сотрудников: Менеджеров | Операторов | Топ-менеджеров
    public void hireAll(List<Employee> employees){
        for (Employee employee : employees) {
            income += employee.getSalaryForCompany();
            employee.setCompany(this);
            this.employees.add(employee);
        }
    }
    public void fire(Employee employee){
        employees.remove(employee);
        income -= employee.getSalaryForCompany();
    }
//    Компаратор на убывание
    private Comparator<Employee> comparatorTop = ((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
//    Сортировка списка на убывание, от самых больших до самых маленьких ЗП, размер списка зарплат равен count
    public List<Employee> getTopSalaryStaff(int count){
        if (count <= 0 || count > employees.size()) {
            System.out.println("Неверное число сотрудников, " +
                    "пожалуйста введите число в пределе от 1 до " + employees.size());
            return employees;
        }else{
            List<Employee> employeeList = new ArrayList<>(employees);
            employeeList.sort(comparatorTop);
            List<Employee> result = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                result.add(employeeList.get(i));
            }
            return result;
        }
    }
//    Компаратор на возрастание, можно заменить на (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())
    private Comparator<Employee> comparatorLow = (Comparator.comparingDouble(o -> o.getSalary()));
//    Сортировка списка на возрастание, от самых маленьких до самых больших ЗП, размер списка зарплат равен count
    public List<Employee> getLowestSalaryStaff(int count){
        if (count <= 0 || count > employees.size()) {
            System.out.println("Неверное число сотрудников, " +
                    "пожалуйста введите число в пределе от 1 до " + employees.size());
            return employees;
        }else{
            List<Employee> employeeList = new ArrayList<>(employees);
            employeeList.sort(comparatorLow);
            List<Employee> result = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                result.add(employeeList.get(i));
            }
            return result;
        }
    }
//    Метод для того что бы список сотрудников без For
    public String getListAsString(List<Employee> employees){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < employees.size(); i++) {
            result.append(i).append(" - ").append(employees.get(i).toString()).append("\n");
        }
        return result.toString();
    }
//    Геттер для списка сотрудников
    public ArrayList<Employee> getEmployeesList(){
        return employees;
    }
//    Геттер для имени компании
    public String getCompanyName(){
        return companyName;
    }
    public double getIncome(){
        return income;
    }
}
