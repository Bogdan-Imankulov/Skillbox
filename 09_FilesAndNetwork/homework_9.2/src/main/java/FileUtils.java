import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        Path pathSrc = Paths.get(sourceDirectory);  //создаем объкт типа Path c исходной директорией
        Path pathForCopy = Paths.get(destinationDirectory);//создаем объкт типа Path c директорией места копирования

        try {
            Files.walk(pathSrc).forEach(path -> {  // перебираем исходную директорию по Элементам
                Path copyPath = Paths.get((pathForCopy.toString() + "\\" + path.getFileName())); //куда копируем
                try {
                    Files.copy(path, copyPath, REPLACE_EXISTING);// копируем
                    // если скопируемый файл null или пустой, получается, что это папка
                    if (copyPath.toFile().listFiles() == null || Objects.requireNonNull(copyPath.toFile().listFiles()).length == 0) {
                        // вновь вызываем метод copyFolder, но уже поправка куда копируем
                        copyFolder(pathSrc.toString() + "\\" + path.getFileName(), copyPath.toString());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}