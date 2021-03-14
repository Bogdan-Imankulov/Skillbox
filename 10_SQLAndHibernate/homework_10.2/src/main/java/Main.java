import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection connection = new DataBaseConnection("jdbc:mysql://localhost:3306/skillbox",
                "root", "asdf0FDSA");
       SessionFactory sessionFactory = connection.factory("hibernate.sfg.xml");
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class,1);
        System.out.println(course.getName());

       sessionFactory.close();
    }

}
