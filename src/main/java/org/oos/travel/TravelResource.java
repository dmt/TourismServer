package org.oos.travel;

import com.google.common.collect.Lists;
import com.yammer.metrics.annotation.Metered;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/travel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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

    @GET
    @Path("{id}")
    @Timed
    public Visa getVisa(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @POST
    @Timed
    public Response addVisa(Visa visa) {
        dao.insert(visa.getCompanyName(), visa.getAddress());
        long id = dao.insertedId();
        return Response.created(UriBuilder.fromPath("{id}").build(id)).build();
    }

}
