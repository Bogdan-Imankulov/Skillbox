import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        FileUtil.copyFolder("../homework_9.1",
                "src/src");
        FileUtil.copyFolder("lib",
                "src");
        System.out.println(Files.exists(Path.of("src/lib/Fules")));

    }
}
