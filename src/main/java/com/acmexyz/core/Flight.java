package com.acmexyz.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class Flight {
    @NotEmpty
    public final String number;

    @NotEmpty
    public final String from;

    @NotEmpty
    public final String to;

    public final LocalDate date;

    @Min(value = 1, message = "From must be greater than zero")
    public final Integer durationInMinutes;

    @Min(value = 1, message = "From must be greater than zero")
    public final Integer costInEuro;

    @JsonCreator
    public Flight(@JsonProperty("number") String number,
                  @JsonProperty("from") String from,
                  @JsonProperty("to") String to,
                  @JsonProperty("date") LocalDate date,
                  @JsonProperty("durationInMinutes") Integer durationInMinutes,
                  @JsonProperty("costInEuro") Integer costInEuro
    ) {
        this.number = number;
        this.from = from;
        this.to = to;
        this.date = date;
        this.durationInMinutes = durationInMinutes;
        this.costInEuro = costInEuro;
    }
}
