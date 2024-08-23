import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourceDirectory = scanner.nextLine();
        String destinationDirectory = scanner.nextLine();
        FileUtils.copyFolder(sourceDirectory, destinationDirectory);

    }
}
