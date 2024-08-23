import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        ResultSet resultSet = dataBaseConnection
                //выбираю имя курса, месяц последней покупки, кол-во покупок
                //затем делю кол-во покупок на месяц последней покупки
                //получая тем самым среднее кол-во покупок в месяц
                .executeQuery(""" 
                        SELECT course_name, 
                        EXTRACT(MONTH FROM MAX(PurchaseList.subscription_date)), 
                        COUNT(PurchaseList.subscription_date), 
                        COUNT(PurchaseList.subscription_date) / 
                        EXTRACT(MONTH FROM MAX(PurchaseList.subscription_date))
                        FROM PurchaseList 
                        GROUP BY course_name 
                        ORDER BY subscription_date DESC""");
        try {
            while(resultSet.next()){
                System.out.println("Course name: " + resultSet.getString(1) + ";  " +
                        "Average purchases per month for course: " + resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
