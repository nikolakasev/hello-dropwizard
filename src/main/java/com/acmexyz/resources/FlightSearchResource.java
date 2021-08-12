package com.acmexyz.resources;

import com.acmexyz.core.AvailableFlights;
import com.acmexyz.core.Flight;
import com.acmexyz.core.FlightSearchCriteria;
import com.acmexyz.db.FlightDAO;
import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class FlightSearchResource {
    private FlightDAO flights;

    public FlightSearchResource() {
        this.flights = new FlightDAO();
    }

    @POST
    @Timed
    public AvailableFlights searchAvailableFlights(@NotNull @Valid FlightSearchCriteria criteria) {
        List<Flight> flightList = flights.getAllAvailableFlightsFromMemory();
        Stream<Flight> outbound = flightList
                .stream()
                .filter(
                        f -> (f.date.equals(criteria.getFromDate())
                                && f.from.equals(criteria.getDepartureAirport())
                                && f.to.equals(criteria.getDestinationAirport())
                        )
                );

        Stream<Flight> inbound = flightList
                .stream()
                .filter(
                        f -> (f.date.equals(criteria.getToDate())
                                && f.from.equals(criteria.getDestinationAirport())
                                && f.to.equals(criteria.getDepartureAirport())
                        )
                );

        return new AvailableFlights(
                Stream.concat(outbound, inbound).collect(Collectors.toList())
        );
    }
}
