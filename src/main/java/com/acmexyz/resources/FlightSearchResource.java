package com.acmexyz.resources;

import com.acmexyz.api.Flight;
import com.acmexyz.api.FlightSearchCriteria;
import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class FlightSearchResource {
    public FlightSearchResource() {
    }

    @POST
    @Timed
    public List<Flight> searchAvailableFlights(@NotNull @Valid FlightSearchCriteria criteria) {
        return Collections.singletonList(new Flight("OS375", 65, 120));
    }
}
