package com.skelton.cc.rest;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.junit.Assert;
import org.junit.Test;


public class HealthControllerTest  extends BaseJerseyTest {

    public HealthControllerTest() throws Exception {
        super();
    }



    /**
     * Test that the expected response is sent back.
     * @throws java.lang.Exception
     */
    @Test
    public void testHelloWorld() throws Exception {
        WebResource webResource = resource().path("status");
        ClientResponse clientResponse = webResource.head();
        String responseMsg = webResource.get(String.class);
        Assert.assertEquals("Application is running", responseMsg);
        assertHttpStatus(ClientResponse.Status.OK, clientResponse);
    }

//    @Test
//    public void helloWorld() throws Exception {
//        mockMvc.perform(get("/status").accept(MediaType.APPLICATION_JSON))
//                .andDo(print()) // print the request/response in the console
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().string("Application is running"));
//    }

}
