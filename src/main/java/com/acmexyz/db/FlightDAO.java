package com.acmexyz.db;

import com.acmexyz.core.Flight;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FlightDAO {
    public List<Flight> getAllAvailableFlightsFromMemory() {
        return Arrays.asList(
                new Flight("OS375", "AMS", "VIE", LocalDate.parse("2021-08-21"), 115, 116),
                new Flight("OS378", "VIE", "AMS", LocalDate.parse("2021-08-29"), 110, 114)
        );
    }
}
