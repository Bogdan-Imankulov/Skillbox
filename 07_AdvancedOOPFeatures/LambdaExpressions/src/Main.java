import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();
        staff.stream()
                .filter(employee -> employee.getWorkStart().getYear() == 117)
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(1).collect(Collectors.toList()).forEach(System.out::println);
        /*Comparator<Employee> comparatorSalary = (Comparator.comparingInt(Employee::getSalary));
        Comparator<Employee> comparatorName = (Comparator.comparing(Employee::getName));
        staff.sort(comparatorSalary.thenComparing(comparatorName));
        for (Employee employee:staff) {
            System.out.println(employee.toString());
        }*/
        Date date = new Date(116,11,31);
        Date date1 = new Date(118,0,1);
        staff.stream()
                .filter(employee -> employee.getWorkStart().after(date))
                .filter(employee -> employee.getWorkStart().before(date1))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}