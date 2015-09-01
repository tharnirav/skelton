package com.skelton.cc.rest;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

import static org.junit.Assert.fail;

/**
 * Created by nthar on 8/31/2015.
 */
public class BaseJerseyTest extends JerseyTest {

    protected static final String CONTEXT_PATH = "fra-cnc";
    protected static final String REST_SERVICES_PACKAGE = "com.skelton.cc.rest";

    public BaseJerseyTest() throws Exception {
        super(new WebAppDescriptor.Builder("com.skelton.cc.rest")
                .contextPath("fra-cnc")
                .build());
    }

    public static void assertHttpStatus(final ClientResponse.Status expectedStatus, final ClientResponse actualResponse) {
        int actualStatus = actualResponse.getStatus();
        if (actualStatus != expectedStatus.getStatusCode()) {
            String responseBody = actualResponse.getEntity(String.class);
            fail("Expected status " + expectedStatus.getStatusCode() + " but got " + actualStatus
                    + "; response body: '" + responseBody + "'" + "\nheaders:" + actualResponse.getHeaders());
        }

    }
}
