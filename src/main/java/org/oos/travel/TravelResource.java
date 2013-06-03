package org.oos.travel;

import com.google.common.collect.Lists;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return dao.findAll();
    }

    @POST
    public Visa addVisa(Visa visa) {
        dao.insert(visa.getId(), visa.getCompanyName());
        return visa;
    }

    @Path("bla")
    @GET
    public Visa createOne() {
        dao.insert(2, "bla2");
        dao.insert(3, "bla3");
        dao.insert(4, "bla4");
        dao.insert(5, "bla5");
        dao.insert(6, "bla6");
        dao.insert(7, "bla7");
        return new Visa(1, "bla", "");
    }

}
