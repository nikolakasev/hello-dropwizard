package com.acmexyz.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Flight {
    @NotEmpty
    public final String number;

    @Min(value = 1, message = "From must be greater than zero")
    public final Integer durationInMinutes;

    @Min(value = 1, message = "From must be greater than zero")
    public final Integer costInEuro;

    @JsonCreator
    public Flight(@JsonProperty("number") String number,
                  @JsonProperty("durationInMinutes") Integer durationInMinutes,
                  @JsonProperty("costInEuro") Integer costInEuro
    ) {
        this.number = number;
        this.durationInMinutes = durationInMinutes;
        this.costInEuro = costInEuro;
    }
}
