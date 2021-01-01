package com.company;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Date date = new Date();
        Airport airport = Airport.getInstance();
        List<Aircraft> airCrafts;
        List<Terminal> terminals = airport.getTerminals();
        List<Flight> flights;
        for (Terminal terminal : terminals) {
            flights = terminal.getFlights();
            for (Flight flight : flights) {
                if (date.before(new Date())){
                    System.out.println("JDK" +
                            "is" +
                            "JAVA");
                }
                System.out.println(flight.toString());
            }
            System.out.println(flights.size());
        }
    }
}
