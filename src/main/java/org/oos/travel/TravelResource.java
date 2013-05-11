package org.oos.travel;

import com.google.common.collect.Lists;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/travel")
@Produces(MediaType.APPLICATION_JSON)
public class TravelResource {

    private VisaDAO dao;

    public TravelResource(VisaDAO dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    public List<Visa> listVisa() {
        return Lists.newArrayList();
    }

}