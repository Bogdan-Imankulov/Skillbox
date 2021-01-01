import java.util.Date;
import lombok.*;

public class Main {
    public static void main(String[] args) {
        Employee sanya = new Employee("Sanya", 1555, new Date());
        Employee employee = new Employee();
        System.err.println(sanya);
        System.out.println(sanya);
        employee.setName("vasYA");
        System.out.println(employee.getName());
        System.out.println(sanya.hashCode());
    }
}
