package com.acmexyz.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class FlightSearchCriteria {
    @NotEmpty
    private final String from;

    @NotEmpty
    private final String to;

    @JsonCreator
    public FlightSearchCriteria(@JsonProperty("from") String from,
                                @JsonProperty("to") String to) {
        this.from = from;
        this.to = to;
    }

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }
}
