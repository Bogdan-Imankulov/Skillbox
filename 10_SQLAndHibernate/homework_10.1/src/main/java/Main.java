import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection connection = new DataBaseConnection("jdbc:mysql://localhost:3306/skillbox",
                "root", "asdf0FDSA");
        ResultSet resultSet = connection.executeQuery("""
                SELECT course_name, 
                        EXTRACT(MONTH FROM MAX(PurchaseList.subscription_date)), 
                        COUNT(PurchaseList.subscription_date), 
                        COUNT(PurchaseList.subscription_date) / 
                        EXTRACT(MONTH FROM MAX(PurchaseList.subscription_date))
                        FROM PurchaseList 
                        GROUP BY course_name 
                        ORDER BY subscription_date DESC
                        """);
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
