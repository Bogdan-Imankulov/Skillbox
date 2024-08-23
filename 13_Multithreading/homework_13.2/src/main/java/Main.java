import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static File file;
    private static FileWriter writer;

    static {
        try {
            file = new File("D:\\Skillbox\\Module3\\Dad\\java_basics\\" +
                    "13_Multithreading\\homework_13.2\\src\\main\\resources\\file.txt");
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Connection connection = new Connection("https://online-timer.ru/");
            ForkJoinPool pool = new ForkJoinPool();
            URL url = pool.invoke(connection);
            ArrayList<String> list = toWrite(url);
            for (String s : list)
                writer.write(s);
            writer.flush();
            writer.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public static ArrayList<String> toWrite(URL url) {
        ArrayList<String> resultList = new ArrayList<>();
        String tab = "\t";
        resultList.add(tab.repeat(Math.max(0, url.getUrlLevel())) + url.getUrl() + "\n");
        if (url.getSubUrlList() != null)
            for (URL el : url.getSubUrlList())
                resultList.addAll(toWrite(el));
        return resultList;
    }
}
