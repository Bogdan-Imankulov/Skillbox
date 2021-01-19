import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Movements {
    private String pathMovementCsv;
    private double expenseSum = 0;
    private double incomeSum = 0;
    private String companyExpense;

    public Movements(String pathMovementCsv) {
        this.pathMovementCsv = pathMovementCsv;
        companyExpense = "";
        setUp();
    }

    private void setUp() {
        try {
            boolean doesStartWithSlash = pathMovementCsv.startsWith("\\")
                    || pathMovementCsv.startsWith("/");
            if (doesStartWithSlash) {
                pathMovementCsv = pathMovementCsv.substring(1);
            }
            Path pathToCSV = Path.of(pathMovementCsv/*.trim()*/);
            List<String> list = Files.readAllLines(pathToCSV);
            list.remove(0);
            parseLines(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLines(List<String> list) {
        list.forEach(line -> {
            String[] strings;
            try {
                strings = line.split(",");
                String[] normalStrings = new String[strings.length];
                Arrays.fill(normalStrings, "0");
                for (int i = 0; i < strings.length; i++) {
                    String s = strings[i];
                    if (s.contains("\"")) {
                        s += "." + strings[i + 1];
                        s = s.replaceAll("\"", "");
                        normalStrings[i] = s;
                        break;
                    }
                    normalStrings[i] = s;
                }
                Arrays.stream(normalStrings).forEach(string -> {
                    if (!normalStrings[7].equalsIgnoreCase("0")) {
                        String s = strings[5].split("\\s{2}")[strings[5].split("\\s{2}").length - 1].trim();
                        companyExpense = s + "\t" + normalStrings[7] + " руб.\n";
                    }
                });
                expenseSum += Double.parseDouble(normalStrings[7]);
                incomeSum += Double.parseDouble(normalStrings[6]);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }


    public double getExpenseSum() {
        return expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    @Override
    public String toString() {
        return "Сумма доходов: " +
                incomeSum +
                " руб\n" +
                "Сумма расходов: " +
                expenseSum +
                " руб \n" +
                getCompanyExpense();
    }

    public String getCompanyExpense() {
        return companyExpense;
    }
}
