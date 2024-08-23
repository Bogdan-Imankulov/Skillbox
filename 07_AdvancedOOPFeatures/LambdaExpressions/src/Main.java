import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();

       /* for (Employee employee : staff){
            System.out.println(employee.toString());
        }
        Collections.sort(staff, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        System.out.println();
        for (Employee employee : staff){
            System.out.println(employee.toString());
        }*/
//        staff.stream().filter(employee -> employee.getWorkStart().getYear()==(2017-1900)).max(Comparator
//              .comparing(Employee::getSalary)).ifPresent(System.out :: println);
        // создаем дату 1 января 2017 года
        LocalDate date = LocalDate.of(2017, 01, 1);
        staff.stream()
                .filter(employee -> Main.ld(employee.getWorkStart()).isAfter(date))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);


    }

    // метод преобразоватия Date to LocalDate
    public static LocalDate ld(Date date) {
        return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}