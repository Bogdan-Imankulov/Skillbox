import com.mongodb.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class App {

    private static String pathToCSV = "D:\\Skillbox\\Module3\\Dad\\java_basics\\15_NoSQL\\homework_15.3\\src\\main\\resources\\mongo.csv";
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToCSV));
            String line = null;
            MongoClient mongo = new MongoClient();
            DB db = mongo.getDB("Students");
            DBCollection collection = db.getCollection("Students");
            while ((line = reader.readLine()) != null){
                String[] lineSplit = line.split(",", 2);
                String courses = line.substring(line.indexOf("\""))
                        .replaceAll("\"", "");
                String[] coursesArr = courses.split(",");
                String studentName = lineSplit[0].replaceAll(",", "");
                int studentAge = Integer.parseInt(lineSplit[1].split(",")[0]);
                DBObject dbObject = new BasicDBObject("StudentName", studentName)
                        .append("StudentAge", studentAge)
                        .append("StudentCourses", coursesArr);
                System.out.println(dbObject);
                collection.insert(dbObject);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
