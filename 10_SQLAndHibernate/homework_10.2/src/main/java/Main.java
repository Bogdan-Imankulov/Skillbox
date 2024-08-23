import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try {
            Session session = DataBaseConnection.getSessionFactory().openSession();
            CoursesTable coursesTable = session.get(CoursesTable.class, 4);
            System.out.println("Students count: " + coursesTable.getStudentsCount() + "; Course name: " + coursesTable.getName());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
