import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Company company1 = new Company("The dogs of War", 256000L);
        for (int i = 0; i < 180; i++) {
            company1.hire(new Operator(company1)); //создаю и принимаю на работу 180 операторов
        }
        for (int i = 0; i < 80; i++) {
            company1.hire(new Manager(company1)); //создаю и принимаю на работу 80 менедждеров
        }
        for (int i = 0; i < 10; i++){
            company1.hire(new TopManager(company1)); // создаю и принимаю на работу 10 Топменеджеров
        }
        // распечатываю самые высокие зарплаты
        for (Employee e : company1.getTopSalaryStaff(15)){
            System.out.println(e.getMonthSalary());
        }

        System.out.println();
        // распечатываю самые низкие зарплаты
        for (Employee e : company1.getLowSalaryStaff(30)){
            System.out.println(e.getMonthSalary());
        }
        System.out.println();
        // увольнение 50% сотрудников
        for (int i = 0; i < company1.listEmployees.size() ; i++) {
            company1.listEmployees.remove(company1.listEmployees.get((int) (company1.listEmployees.size() * Math.random())));
        }
        for(Employee e : company1.getTopSalaryStaff(10)){
            System.out.println(e.getMonthSalary());
        }
        System.out.println();
        for (Employee e : company1.getLowSalaryStaff(30)){
            System.out.println(e.getMonthSalary());
        }
    }

    // метод округления зарплат, доходов, до второго знака после запятой (копеек, тиинов, центов)
    public static double roundingSalary(double value) {
        double scale = Math.pow(10, 2);
        value = Math.round(value * scale) / scale;
        return value;
    }
}
