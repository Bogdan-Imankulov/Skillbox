import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Для возможного дальнейшего использования создал Map
//        Map<String, Double> map = new HashMap<>();
        try {
            //подключаемся к БД
            Connection connection = DriverManager.getConnection("jdbc:mysql://" +
                    "localhost:3306/skillbox", "root", "asdf0FDSA");
            Statement statement = connection.createStatement();
            ResultSet resultSetCourses = statement.executeQuery("SELECT name FROM Courses");
            //Создаю arrayList для хранения и использования имен курсов
            ArrayList<String> coursesNames = new ArrayList<>();
            while (resultSetCourses.next()) {
                String nameOfCourse = resultSetCourses.getString("name");
                coursesNames.add(nameOfCourse);
            }
            //перебираю имена курсов
            coursesNames.forEach(name -> {
                try {
                    ResultSet resultSet = statement.executeQuery("SELECT pl.course_name, pl.subscription_date FROM PurchaseList pl " +
                            "WHERE pl.course_name = \"" + name + "\" ORDER BY pl.subscription_date");
                    //переменная для подсчета кол-ва покупок
                    double count = 0;
                    //среднее кол-во покупок в месяц
                    double avgPurchasesPerMonth;
                    //месяц последней покупки
                    double month;
                    ArrayList<Date> arrayList = new ArrayList<>();
                    while (resultSet.next()) {
                        arrayList.add(resultSet.getDate(2));
                        count++;
                    }
                    if (arrayList.size() != 0){
                        //получаю номер месяца последней покупки, getMonth() возвращает январь - 0, поэтому +1
                         month = arrayList.get(arrayList.size() - 1).getMonth() + 1;
                        avgPurchasesPerMonth = count / month;
                        //для возможного дальнейшего использования
//                        map.put(name, avgPurchasesPerMonth);
                        System.out.println(name + "; " + avgPurchasesPerMonth);
                    }else {
                        //если не было покупок
                        avgPurchasesPerMonth = 0.0;
                        System.out.println(name + "; " + avgPurchasesPerMonth);
                        //для возможного дальнейшего использования
//                        map.put(name, avgPurchasesPerMonth);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
//
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
