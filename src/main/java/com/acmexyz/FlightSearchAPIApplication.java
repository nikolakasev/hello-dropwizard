package com.acmexyz;

import com.acmexyz.health.ServiceHealthCheck;
import com.acmexyz.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FlightSearchAPIApplication extends Application<FlightSearchAPIConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FlightSearchAPIApplication().run(args);
    }

    @Override
    public String getName() {
        return "FlightSearchAPI";
    }

    @Override
    public void initialize(final Bootstrap<FlightSearchAPIConfiguration> bootstrap) {
    }

    @Override
    public void run(final FlightSearchAPIConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource("John");
        environment.jersey().register(resource);
        final ServiceHealthCheck healthCheck = new ServiceHealthCheck();
        environment.healthChecks().register("service", healthCheck);
    }

}
