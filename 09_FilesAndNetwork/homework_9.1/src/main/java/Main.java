import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "D:/Skillbox";
        long size = FileUtils.calculateFolderSize(path);
        if (size < 512)
            System.out.println("Размер папки = " + size + " Байт");
        else if (size < Math.pow(1024, 2)/2) {
            System.out.println("Размер папки = " + (size * Math.pow(1024, 1)) + " КБайт");
        }
        else if (size < Math.pow(1024, 3)/2) {
            System.out.println("Размер папки = " + (size * Math.pow(1024, 2)) + " МБайт");
        }
        else if (size < Math.pow(1024, 4)/2) {
            double red = Math.round((size * Math.pow(1024, 3))*Math.pow(10, 2)) / Math.pow(10, 2);
            System.out.println("Размер папки = " + red + " ГБайт");
        }
    }
}
