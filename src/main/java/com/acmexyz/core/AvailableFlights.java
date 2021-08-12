package com.acmexyz.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class AvailableFlights {
    @NotEmpty
    private final List<Flight> flightsFound;

    @JsonCreator
    public AvailableFlights(@JsonProperty("flightsFound") List<Flight> flightsFound) {
        this.flightsFound = flightsFound;
    }

    @JsonProperty("flightsFound")
    public List<Flight> getFlightsFound() {
        return flightsFound;
    }
}
