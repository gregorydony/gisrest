package org.gisobject.rest.playground;

import org.glassfish.jersey.server.ResourceConfig;

@javax.ws.rs.ApplicationPath("webresources")
public class RestAppConfig extends ResourceConfig {
    // Get a set of root resource and provider classes

    public RestAppConfig() {
        packages("org.gisobject.rest.playground.controller");
    }
}
