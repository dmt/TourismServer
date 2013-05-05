package org.oos.travel;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TravelService extends Service<TravelConfiguration> {
    @java.lang.Override
    public void initialize(Bootstrap<TravelConfiguration> travelConfigurationBootstrap) {
    }

    @java.lang.Override
    public void run(TravelConfiguration travelConfiguration, Environment environment) throws Exception {
        environment.addResource(Visa.class);

    }
}
