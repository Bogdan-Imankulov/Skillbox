import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pathToFolder = scanner.nextLine();
        long size = FileUtils.calculateFolderSize(pathToFolder);
        System.out.println(size);
    }
}
