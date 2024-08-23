import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class App {

    private static final int DELETE_SECONDS_AGO = 5;
    private static final int USERS_ON_MAIN_PAGE = 20;
    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        try {
            RedisStorage storage = new RedisStorage();
            storage.init();
            int lastUserId = 0;
            while (true) {
                int userId = new Random().nextInt(20);
                while (userId == lastUserId){
                    userId = new Random().nextInt(20);
                }
                boolean mustBuy = new Random().nextInt(10) == 5;
                storage.logPageVisit(userId);
                if (mustBuy)
                    printBuyLog(userId);
                printRegistrationLog(userId);
                storage.moveToTheEnd(userId);
                lastUserId = userId;
                Thread.sleep((int)(100 + Math.random()*1900));
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private static void printRegistrationLog(int userId) {
        System.out.printf("[%s]> Пользователь с id %d посетил главную страницу.\n",
                DF.format(new Date()), userId);
    }

    private static void printBuyLog(int userId) {
        System.out.printf("[%s]>>> Пользователь с id %d оплатил платную услугу.\n",
                DF.format(new Date()), userId);
    }
}
