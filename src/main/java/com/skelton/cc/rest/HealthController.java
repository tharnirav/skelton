package com.skelton.cc.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by nthar on 8/29/2015.
 */

@Component
@Path("/health")
public class HealthController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/status")
    public Response getApplicationStatus() {
        return Response.status(200).entity("Application is running").build();
    }
}
