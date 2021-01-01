import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(2019, 10, 31));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
//        0 - 31.12.1990 - Mon
//        1 - 31.12.1991 - Tue
        Locale.setDefault(Locale.forLanguageTag("en"));
        Calendar currentDate = new GregorianCalendar(2020, 10, 30);
        Calendar bornDate = new GregorianCalendar(year, month - 1, day);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" - dd.MM.y - E");
        String str = "";
        int difference = 0;
        if (currentDate.get(Calendar.YEAR) - bornDate.get(Calendar.YEAR) >= 0 && currentDate.get(Calendar.MONTH) - bornDate.get(Calendar.MONTH) >= 0)
        {
            difference = currentDate.get(Calendar.YEAR) - bornDate.get(Calendar.YEAR);
        }

        for (int i = 0; i < currentDate.compareTo(bornDate) + difference; i++) {
            str = str + i + simpleDateFormat.format(bornDate.getTime()) + "\n";
            bornDate.add(Calendar.YEAR, difference);
        }
        return str;
    }
}
