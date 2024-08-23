import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileUtils {

    public static long calculateFolderSize(String path) throws IOException {
/*        //емкость объекта в байтах, подсказала Idea. почему просто long, не массив не проходит?
        final long[] size = {0};
        //определяем объект для папки
        File file = new File(path);
//отлавливаем исключения
        try {
            //проверяем является ли этот объект директорией
            if (file.isDirectory()) {
                //если директория то проверяем кадждый файл преребирая массив файлов или каталогов
                Arrays.stream(file.listFiles()).forEach(file1 -> {
                    //если файл, а не каталог
                    if (file1.isFile())
                        // прибавляем длину этого файла
                        size[0] += file1.length();
                    //а если это каталог
                    else
                            // метод вызывает сам себя, но уже текущий каталог по абсолютному пути
                        size[0] += calculateFolderSize(file1.getAbsolutePath());
                });
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return size[0];*/
        File file = new File(path);                        //устанавливаем путь
        Long size =0L;
        try {
             size = Files.walk(file.toPath())          //поток всех файлов по введеному пути
                    .map(Path::toFile).filter(File::isFile)//проверяет файл
                    .mapToLong(File::length).sum();        //считает размер файла и суммирует
        }catch (Exception e){
            e.printStackTrace();
        }
        return size;
    }
}
