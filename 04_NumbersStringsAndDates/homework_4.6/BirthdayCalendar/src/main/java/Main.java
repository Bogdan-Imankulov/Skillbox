import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {


    public static void main(String[] args) {
       /*
       0 - 31.12.1990 - Mon
       1 - 31.12.1991 - Tue
       */
    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        // Устанавливаем язык шаблона
        //Locale.setDefault(Locale.forLanguageTag("en"));
        // а можно здесь установить язык шаблона, устанавливая Locale.US or Locale.UK or Locale.ENGLISH
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(" - dd.MM.yyy - E", Locale.ENGLISH);
        LocalDate dateOfBorn = LocalDate.of(year, month, day);
        LocalDate dateNow = LocalDate.now();
        // проверяем дата рождения раньше или позже или совпадает с текещей датой
        // отрицательное число - раньше, 0 - совпадает , положительное - позже текущей даты
        int currentDate = dateOfBorn.compareTo(dateNow);
        // разница в годах от рождения до текущей даты
        int differenceYears = dateNow.getYear() - dateOfBorn.getYear();
        // разница в днях года от дня рождения до текущей даты
        int differenceDays = dateNow.getDayOfYear() - dateOfBorn.getDayOfYear();
        String text = "";
        //проверяем введенная дата больше, чем текущая
        if (currentDate > 0)
            return text;
        //проверяем если прошлый год, но полный год еще не закончился, можно добавить (|| currentDate == 0), но тогда
        // differenceDays < 0
        if (differenceYears == 1 && differenceDays <= 0)
            differenceYears = 0;
        // прогоняем по циклу
        for (int i = 0; i <= differenceYears; i++) {
            text = text + i + dateOfBorn.format(dateTimeFormatter) + "\n";
            // добавляем год
            dateOfBorn = dateOfBorn.plusYears(1);
        }

        return text;
    }
}

