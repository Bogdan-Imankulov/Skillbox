package com.company;

import com.skillbox.airport.*;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //Создаем объект класса LocalTime, выставляем дату через 2 часа после текущей
        LocalTime date = LocalTime.now().plusHours(2);
        //Создаем объект класса LocalTime
        LocalTime newDate = LocalTime.now();
        //Создаем аэропорт
        Airport airport = Airport.getInstance();
        //Создаем пустой спискок для моделей самолетов, которые будут вылетать в ближайшие 2 часа
        List<Aircraft> airCrafts = new ArrayList<>();
        //Создаем список для треминалов Аэропорта, в них есть данные о вылетах
        List<Terminal> terminals = airport.getTerminals();
        // Создаем список вылетов, для способа через for'ы
         List<Flight> flights = new ArrayList<>();
        //Прогоняем терминалы, создаем список вылетов с каждого терминала

        terminals.forEach(terminal -> new ArrayList<>(terminal.getFlights())
                //Оставляем в списке только те самолеты, которые вылетают в ближайшие 2 часа
            .stream().filter(flight -> toLocalTime(flight.getDate()).isBefore(date))
                //Убираем все самолеты которые улетели
                .filter(flight -> toLocalTime(flight.getDate()).isAfter(newDate))
                //Выполняем действия с каждым вылетом
                .forEach(flight -> {
                    //Выводим в консоль время вылета самолета
                    System.out.println("Flight date: " + flight.getDate() + "; " + flight.getAircraft());
                    //Выводим в консоль текущее время
                    System.out.println("Date: " + newDate.getHour() + ":" + newDate.getMinute()
                            + ":" + newDate.getSecond());
                    //Добавляем модель самолета в список
                    airCrafts.add(flight.getAircraft());
                }));
            /*

//        Тот же самый код, но через for'ы -->
            for (Terminal terminal : terminals) {
                flights = terminal.getFlights();
                  for (Flight flight : flights) {
                       if (toLocalTime(flight.getDate()).isBefore(date)
                            && toLocalTime(flight.getDate()).isAfter(LocalTime.now())) {
                        System.out.println("Flight date: " + flight.getDate() + "; " + flight.getAircraft());
                        System.out.println("Date: " + date.getHour() + ":" + date.getMinute()
                                + ":" + date.getSecond());
                        airCrafts.add(flight.getAircraft());
                        }
                 }
            }
            */

    }
    public static LocalTime toLocalTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }
}
