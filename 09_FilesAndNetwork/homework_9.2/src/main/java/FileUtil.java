import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileUtil {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        try {
            File src = new File(Paths.get(sourceDirectory).toString());
            File dst = new File(Paths.get(destinationDirectory).toString());
            Files.walk(src.toPath()).forEach(path -> {
                try {
                    File file = path.toFile();
                    File copyOfFile = new File(Path.of(dst.getPath() + "/" + file.getName()).toString());
                    Files.copy(file.toPath(), Path.of(copyOfFile.getAbsolutePath()),
                            REPLACE_EXISTING);
                    if (copyOfFile.listFiles() == null || copyOfFile.listFiles().length == 0) {
                        copyFolder(src.getAbsolutePath() + "/" + file.getName(),
                                copyOfFile.getAbsolutePath());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

