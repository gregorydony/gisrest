package org.gisobject.rest.playground;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by GIS Object on 23/02/2018.
 */
@Path("departments")
public class ShowPointController {

    @GET
    @Path("/showPoint/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Point showCoordinates(@PathParam("name") String name) {
        if ("New York".equals(name)) {
            return new Point(40.7142700, -74.0059700);
        } else {
            throw new UnknownLocation("Unable to find coordinates of " + name);
        }
    }
}