package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        Airport airport = new Airport("Rigos oro uostas", "Rigas iela 11", "Riga");
        Airport airport2 = new Airport(13,"Vilniaus oro uostas", "Rigas iela 11", "Riga");
        AirportDAO.create(airport);
        AirportDAO.update(airport2);

        ArrayList<Airport> airports = AirportDAO.searchByAirportName("Ri");
        if (airports.isEmpty()) {
            System.out.println("Nothing found");
        } else {
            for (Airport a : airports) {
                System.out.println(a.toString());
            }
        }
        AirportDAO.delete(2);
    }
}