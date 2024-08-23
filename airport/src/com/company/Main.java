package com.company;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //создаем аэропорт
        Airport domodedovo = Airport.getInstance();
        //создаю список количества самолетов, написал int Idea подсказала переделать
        List<Aircraft> aircraftCount = domodedovo.getAllAircrafts();
        // вывожу список на экран
        System.out.println(aircraftCount);
        //можно было бы сделать сразу
        System.out.println(domodedovo.getAllAircrafts());
        //размер списка, соответствует количеству самолетов
        int count = aircraftCount.size();
        //вывожу на экран
        System.out.println(count);
        // можно так
        System.out.println(aircraftCount.size());

    }
}
