import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    private final String NAME_OF_COMPANY;
    private final long WORK_CAPITAL;
    double inCome;
    // создаю список  сотрудников
    ArrayList<Employee> listEmployees = new ArrayList<>();
    // задаю компараторы для необходимой сортировки списков
    Comparator<Employee> topComparator = (o1, o2) -> {
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return 1;
        }
        if (o1.getMonthSalary() > o2.getMonthSalary())
            return -1;
        return 0;
    };
    Comparator<Employee> lowComparator = (o1, o2) -> {
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return -1;
        }
        if (o1.getMonthSalary() > o2.getMonthSalary())
            return 1;
        return 0;
    };

    // конструктор создания компании, название, оборотный капитал
    public Company(String name_of_company, long work_capital) {
        NAME_OF_COMPANY = name_of_company;
        WORK_CAPITAL = work_capital;
    }

    // метод возвращающий прибыль компании
    public double getInCome() {
        inCome = WORK_CAPITAL * Math.random();
        return Main.roundingSalary(inCome);
    }

    // метод принимающий единичного сотрудника на работу
    public ArrayList<Employee> hire(Employee employee) {
        listEmployees.add(employee);
        return listEmployees;
    }
    //метод принимающий сотрудников списком
    public ArrayList<Employee> hireAll( ArrayList<Employee> listCandidate){
        listEmployees.addAll(listCandidate);
        return listEmployees;
    }
    // метод увольняющий единичного сотрудника
    public ArrayList<Employee> fire( Employee employee){
        listEmployees.remove(employee);
        return listEmployees;
    }
    // метод увольняющий сотрудников списком (в зададнии не было, но подумал, что не помешало бы)
    public ArrayList<Employee>fireAll(ArrayList<Employee> listCandidate){
        listEmployees.removeAll(listCandidate);
        return listEmployees;
    }

    // метод возварщающий самые высокие зарплаты
    List<Employee> getTopSalaryStaff(int count) {
        if (count <= 0 || count >= listEmployees.size()){
            System.out.println("Вы ввели неправильное число, оно должно быть положительным и не больше количества" +
                    "сотрудников в компании");
        }
            List<Employee> topSalaryStaff = new ArrayList<>();
        listEmployees.sort(topComparator);
        for (int i = 0; i < count; i++) {
            topSalaryStaff.add(listEmployees.get(i));
        }
        return topSalaryStaff;
    }

    // метод возвращающий самые низкие зарплаты
    List<Employee> getLowSalaryStaff(int count) {
        if (count <= 0 || count >= listEmployees.size()){
            System.out.println("Вы ввели неправильное число, оно должно быть положительным и не больше количества" +
                    "сотрудников в компании");
        }
        List<Employee> lowSalaryStaff = new ArrayList<>();
        listEmployees.sort(lowComparator);
        for (int i = 0; i < count; i++) {
            lowSalaryStaff.add(listEmployees.get(i));
        }
        return lowSalaryStaff;
    }
}
