import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Movements {
    private double expenseSum = 0;
    private double incomeSum = 0;

    public Movements(String pathMovementsCsv) {
        try {
            boolean doesStartWithSlash = pathMovementsCsv.startsWith("\\")
                    || pathMovementsCsv.startsWith("/");
            if (doesStartWithSlash) {
                pathMovementsCsv = pathMovementsCsv.substring(1);
            }
            Path pathToCSV = Path.of(pathMovementsCsv.trim());
            List<String> list = Files.readAllLines(pathToCSV);
            list.remove(0);
            list.forEach(line -> {
                String[] strings = line.split(",");
                String[] normalStrings = new String[strings.length];
                for (int i = 0; i < strings.length; i++) {
                    String s = strings[i];
                    if (s.contains("\"")) {
                        s += "." + strings[i+1];
                        s = s.replaceAll("\"", "");
                        normalStrings[i] = s;
                        break;
                    }
                    normalStrings[i] = s;
                }
                expenseSum += Double.parseDouble(normalStrings[7]);
                incomeSum += Double.parseDouble(normalStrings[6]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        return expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }
}
