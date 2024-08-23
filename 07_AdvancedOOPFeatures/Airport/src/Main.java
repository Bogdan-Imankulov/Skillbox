import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        //устанавливаем текущую дату
//        Date date = new Date();
//        // устанавливаем дату через два часа
//        Date date1 = new Date(date.getHours()+2);
//        // создаем аэропорт
//        Airport airport = Airport.getInstance();
//       //  получаем териминалы аэропорта, заносим в список
//        List<Terminal> terminals = airport.getTerminals();
//        //прогоняем терминалы чтобы получить списки вылетов
//        terminals.forEach(terminal -> terminal.getFlights()
//                //убираем самолеты которые уже улетели
//                .stream().filter(flight -> flight.getDate().after(date))
//                //убираем самолеты которые улетят через два часа
//                .filter(flight -> flight.getDate().before(date1))
//                //распечатываем список даты и времени вылета, и марки самолета
//                .forEach(flight -> System.out.println(flight.getDate() +
//                        "; " + flight.getAircraft())));
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after2Hours = now.plusHours(2);
        Airport airport = Airport.getInstance();
        List<Terminal> terminals = airport.getTerminals();
         //прогоняем терминалы чтобы получить списки вылетов
        terminals.forEach(terminal -> terminal.getFlights()
                //убираем самолеты которые уже улетели
                .stream().filter(flight -> Main.dateToLocalDataTime(flight.getDate()).isAfter(now))
                //убираем самолеты которые улетят через два часа
                .filter(flight -> Main.dateToLocalDataTime(flight.getDate()).isBefore(after2Hours))
                //распечатываем список даты и времени вылета, и марки самолета
                .forEach(flight -> System.out.println(flight.getDate() +
                        "; " + flight.getAircraft())));


    }

    public static LocalDateTime dateToLocalDataTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}

