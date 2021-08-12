package com.acmexyz.resources;

import com.acmexyz.core.AvailableFlights;
import com.acmexyz.core.Flight;
import com.acmexyz.core.FlightSearchCriteria;
import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class FlightSearchResource {
    public FlightSearchResource() {
    }

    @POST
    @Timed
    public AvailableFlights searchAvailableFlights(@NotNull @Valid FlightSearchCriteria criteria) {
        return new AvailableFlights(Collections.singletonList(new Flight("OS375", 65, 120)));
    }
}
