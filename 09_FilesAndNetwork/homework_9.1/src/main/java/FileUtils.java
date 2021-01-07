import java.io.File;
import java.util.Arrays;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        final long[] size = {0};
        File dir = new File(path);
        try {
            if (dir.isDirectory()) {
                Arrays.stream(dir.listFiles()).forEach(file -> {
                    if (file.isFile())
                        size[0] += file.length();
                    else
                        size[0] += calculateFolderSize(file.getAbsolutePath());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size[0];
    }
}
