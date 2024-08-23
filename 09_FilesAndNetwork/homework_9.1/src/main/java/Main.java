import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        long size = FileUtils.calculateFolderSize(path);
        double reduced;
        String b = "байт";
        String exp = "Размер папки: ";
        String exp1 = " cоставляет ";
        String kilo = "Kб";
        String mega = "Mб";
        String giga = "Мб";
        final double KILO = Math.pow(2, 10);
        final double MEGA = Math.pow(2, 20);
        final double GIGA = Math.pow(2, 30);

        if (size > 0 && size < KILO / 2) {
            System.out.println(exp + path + exp1 + size + b);
        } else if (size < MEGA / 2) {
            reduced = size / KILO;
            System.out.println(exp + path + exp1 + reduced + kilo);
        } else if (size < GIGA / 2) {
            reduced = size / MEGA;
            System.out.println(exp + path + exp1 + reduced + mega);
        } else {
            reduced = size / GIGA;
            System.out.println(exp + path + exp1 + reduced + giga);
        }
    }
}

