import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Movements {
    ArrayList<BankStatement> bankStatementArrayList;
    private String pathMovementsCsv;
    private double expenseSum;
    private double incomeSum;
    private String dateFormat = "dd.MM.yy";

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv/*.substring(1)*/;
        bankStatementArrayList = loadFromCSv();
//        for (BankStatement line : bankStatementArrayList){
//            incomeSum += line.getIncome();
//            expenseSum += line.getExpense();
        bankStatementArrayList.forEach(bankStatement -> {
            incomeSum += bankStatement.getIncome();
            expenseSum += bankStatement.getExpense();
        });
    }

    public ArrayList<BankStatement> loadFromCSv() {
        ArrayList<BankStatement> bankStatements = new ArrayList<>();
        //этот if()для теста
        if (pathMovementsCsv.startsWith("\\") || pathMovementsCsv.startsWith("/")) {
            pathMovementsCsv = pathMovementsCsv.substring(1);
        }
        try {
            // создаю список строк, считывая файл по ссылке полученную прои создании объекта
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            // удаляю первую строку, потомучто там наииенования, дата, описание, приход, расход и т.д.
            lines.remove(0);
            //перебираю список строк по строкам
            for (String line : lines) {
                //каждую строку помещаю в массив, разделитель запятая
                String[] elements = line.split(",");
                //если елементов меньше 8
                if (elements.length < 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }

                //этот for() для обработки списка float, так как там запятые и двойные ковычки
                for (int i = 0; i < elements.length ; i++) {
                    //если встречает данный шаблон
                    if (elements[i].matches("^\"\\d+")) {
                        //к данному елемнту прибавляет точку и следующиц елемент, вместо 1500,5 будет 1500.5
                        elements[i] += "." + elements[i + 1];
                        //елемент i+1 в следующей итерации будет 5 при сложении дает ошибку, поэтому мы обнуляем его
                        elements[i+1] = String.valueOf(0);
                        elements[i] = elements[i].replaceAll("\"", "");
                    }

                }
                // созданный объект BankStatement получает данные со строки
                bankStatements.add(new BankStatement(elements[0], elements[1],
                        elements[2], new SimpleDateFormat(dateFormat).parse(elements[3]), elements[4],
                        elements[5], Double.parseDouble(elements[6]), Double.parseDouble(elements[7])));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bankStatements;
    }

    public double getExpenseSum() {

        return expenseSum;
    }

    public double getIncomeSum() {

        return incomeSum;
    }
    public String getDescriptionList(){
        StringBuilder builder = new StringBuilder();
        bankStatementArrayList.forEach(bankStatement -> {
            builder.append(bankStatement + "\n");
        });
        return String.valueOf(builder);
    }
}
