package com.skelton.cc.rest;

//import com.sun.jersey.api.client.ClientResponse;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.ws.rs.core.Application;

import static org.junit.Assert.fail;

/**
 * Created by nthar on 8/31/2015.
 */
public abstract class BaseJerseyTest extends JerseyTest {

    protected static final String CONTEXT_PATH = "fra-cnc";
    protected static final String REST_SERVICES_PACKAGE = "com.skelton.cc.rest";

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    protected DeploymentContext configureDeployment() {
        return ServletDeploymentContext
                .forServlet(new ServletContainer(getResourceConfig()))
                .addListener(ContextLoaderListener.class)
                .contextPath(CONTEXT_PATH)
                .initParam("jersey.config.server.provider.packages", "com.skelton.cc.rest")
                .contextParam("contextConfigLocation", "classpath:spring/application-config.xml")
                .build();
    }

    public static void assertHttpStatus(final ClientResponse expectedStatus, final ClientResponse actualResponse) {
        int actualStatus = actualResponse.getStatus();
        if (actualStatus != expectedStatus.getStatus()) {
            String responseBody = actualResponse.toString();
            fail("Expected status " + expectedStatus.getStatus() + " but got " + actualStatus
                    + "; response body: '" + responseBody + "'" + "\nheaders:" + actualResponse.getHeaders());
        }

    }

    abstract ResourceConfig getResourceConfig();
}
