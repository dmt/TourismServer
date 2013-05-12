package org.oos.travel;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import org.skife.jdbi.v2.DBI;

public class TravelService extends Service<TravelConfiguration> {
    @java.lang.Override
    public void initialize(Bootstrap<TravelConfiguration> travelConfigurationBootstrap) {

        travelConfigurationBootstrap.addBundle(new DBIExceptionsBundle());
    }

    @java.lang.Override
    public void run(TravelConfiguration travelConfiguration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, travelConfiguration.getDatabaseConfiguration(), "example");
        final VisaDAO dao = jdbi.onDemand(VisaDAO.class);
        environment.addResource(new TravelResource(dao));
        environment.addResource(TravelResource.class);
    }
    public static void main(String[] args) throws Exception {
        new TravelService().run(args);
    }

}
