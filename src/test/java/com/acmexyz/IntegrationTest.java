package com.acmexyz;

import com.acmexyz.api.FlightSearchCriteria;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(DropwizardExtensionsSupport.class)
public class IntegrationTest {

    static final DropwizardAppExtension<FlightSearchAPIConfiguration> APP = new DropwizardAppExtension<>(FlightSearchAPIApplication.class);

    @Test
    void helloWorldShouldSucceed() {
        final Response healthCheckResponse =
                APP.client().target("http://localhost:" + APP.getLocalPort() + "/hello-world")
                        .request()
                        .get();

        assertThat(healthCheckResponse)
                .extracting(Response::getStatus)
                .isEqualTo(Response.Status.OK.getStatusCode());
    }

    @Test
    void searchShouldSucceed() {
        final FlightSearchCriteria criteria = new FlightSearchCriteria("AMS", "VIE");
        final Response healthCheckResponse =
                APP.client().target("http://localhost:" + APP.getLocalPort() + "/search")
                        .request()
                        .post(Entity.json(criteria));

        assertThat(healthCheckResponse)
                .extracting(Response::getStatus)
                .isEqualTo(Response.Status.OK.getStatusCode());
    }
}
