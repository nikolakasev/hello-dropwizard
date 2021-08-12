package com.acmexyz.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Represents a different kind of search where the customer wants to reach a destination within a budget.
 * The logic will identify the closest airports, available flights within the budget and the amount of tickets.
 * When travelling with kids, focus on reduced travel time. When travelling alone, show cheapest flights first.
 * Present the result as a calendar, with the total amount on each day.
 * Give tips about airports close to the departure city (I might not now that Dusseldorf or Eindhoven are an option).
 */
public class DreamVacationCriteria {
    private final String departureCity;
    private final String destinationCity;
    private final Float flightBudget;
    private final Byte numberOfAdults;
    private final List<Byte> childrenAges;
    private final DateTime departureDate;
    private final Byte tripDurationInDays;

    @JsonCreator
    public DreamVacationCriteria(@JsonProperty("departureCity") String departureCity,
                                 @JsonProperty("destinationCity") String destinationCity,
                                 @JsonProperty("flightBudget") Float flightBudget,
                                 @JsonProperty("numberOfAdults") Byte numberOfAdults,
                                 @JsonProperty("childrenAges") List<Byte> childrenAges,
                                 @JsonProperty("departureDate") DateTime departureDate,
                                 @JsonProperty("tripDurationInDays") Byte tripDurationInDays
    ) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.flightBudget = flightBudget;
        this.numberOfAdults = numberOfAdults;
        this.childrenAges = childrenAges;
        this.departureDate = departureDate;
        this.tripDurationInDays = tripDurationInDays;
    }
}
