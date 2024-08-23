import java.util.ArrayList;

public class Main {
    private static final String MOVEMENT_LIST_INTEGER = "D:\\Skillbox\\Module3\\Dad\\java_basics\\09_FilesAndNetwork\\homework_9.3\\src\\test\\resources\\movementListInteger.csv";
    private static final String MOVEMENT_LIST_FLOAT = "D:\\Skillbox\\Module3\\Dad\\java_basics\\09_FilesAndNetwork\\homework_9.3\\src\\test\\resources\\movementListFloat.csv";
    private static final String MOVEMENT_LIST = "D:\\Skillbox\\Module3\\Dad\\java_basics\\09_FilesAndNetwork\\homework_9.3\\src\\test\\resources\\movementList.csv";

    public static void main(String[] args) {
        String incoming = "Сумма доходов: ";
        String expensive = "Сумма расходов: ";
        String currency = " руб.";
        String organization = "Сумма расходов по организациям: ";
        Movements movementsInteger = new Movements(MOVEMENT_LIST_INTEGER);
        ArrayList<BankStatement> bankStatementsInt = movementsInteger.loadFromCSv();
        Movements movementsFloat = new Movements(MOVEMENT_LIST_FLOAT);
        ArrayList<BankStatement> bankStatementsFloat = movementsFloat.loadFromCSv();
        Movements movementsList = new Movements(MOVEMENT_LIST);
        ArrayList<BankStatement> bankStatementsList = movementsList.loadFromCSv();

        System.out.println(incoming + movementsFloat.getIncomeSum() + currency);
        System.out.println(expensive + movementsFloat.getExpenseSum() + currency +"\n");
        System.out.println(organization+ "\n" + movementsFloat.getDescriptionList());


        System.out.println(incoming + movementsInteger.getIncomeSum() + currency);
        System.out.println(expensive + movementsInteger.getExpenseSum() + currency+"\n");

        System.out.println(incoming + movementsList.getIncomeSum() + currency);
        System.out.println(expensive + movementsList.getExpenseSum() + currency+"\n");


    }
}
