package com.acmexyz.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class FlightSearchCriteria {
    @NotEmpty
    private final String departureAirport;

    @NotEmpty
    private final String destinationAirport;

    @Future
    private final LocalDate fromDate;

    @Future
    private final LocalDate toDate;

    @JsonCreator
    public FlightSearchCriteria(@JsonProperty("departureAirport") String departureAirport,
                                @JsonProperty("destinationAirport") String destinationAirport,
                                @JsonProperty("fromDate") LocalDate fromDate,
                                @JsonProperty("toDate") LocalDate toDate) {
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    @JsonProperty("departureAirport")
    public String getDepartureAirport() {
        return departureAirport;
    }

    @JsonProperty("destinationAirport")
    public String getDestinationAirport() {
        return destinationAirport;
    }

    @JsonProperty("fromDate")
    public LocalDate getFromDate() {
        return fromDate;
    }

    @JsonProperty("toDate")
    public LocalDate getToDate() {
        return toDate;
    }
}
