package com.skelton.cc.rest;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
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
@Path("/batch")
public class LaunchBatchJobController {

    @Autowired
    private JobLauncher jobLauncher;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/start")
    public Response startSpingBatchJob() {
        return Response.status(200).entity("Spring Batch is launched...").build();
    }
}
