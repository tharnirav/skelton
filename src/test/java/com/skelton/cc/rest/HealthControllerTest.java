package com.skelton.cc.rest;


import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertEquals;


public class HealthControllerTest  extends BaseJerseyTest {

    public HealthControllerTest() throws Exception {
        super();
    }

    @Override
    public ResourceConfig getResourceConfig() {
        return new ResourceConfig(HealthController.class);
    }


    /**
     * Test that the expected response is sent back.
     * @throws java.lang.Exception
     */
    @Test
    public void testHelloWorld() throws Exception {
        WebTarget target = target("/health/status");
        final Response response = target("/health/status").request("application/json").get();
        String responseStr = target.request().get(String.class);
        Assert.assertEquals("Application is running", responseStr);
        assertEquals(200, response.getStatus());
    }


}
