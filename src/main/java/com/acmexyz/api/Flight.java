package com.acmexyz.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Flight {
    @NotEmpty
    public final String number;

    @Min(value = 1, message = "From must be greater than zero")
    public final int durationInMinutes;

    @Min(value = 1, message = "From must be greater than zero")
    public final float costInEuro;

    @JsonCreator
    public Flight(@JsonProperty("number") String number,
                  @JsonProperty("durationInMinutes") int durationInMinutes,
                  @JsonProperty("costInEuro") float costInEuro
    ) {
        this.number = number;
        this.durationInMinutes = durationInMinutes;
        this.costInEuro = costInEuro;
    }
}
