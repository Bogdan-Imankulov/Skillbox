import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            DataBaseConnection dbs = new DataBaseConnection();
            Session session = dbs.getSessionFactory().openSession();
            Course course = session.get(Course.class, 4);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
