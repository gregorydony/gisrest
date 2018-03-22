package org.gisobject.rest.playground.geojson.provider;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.gisobject.rest.playground.geometry.Point;
import org.gisobject.rest.playground.geometry.impl.BasePoint;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces("application/json")
public final class PointMessageBodyWriter implements MessageBodyWriter<Point> {

    private ObjectWriter objectWriter = new ObjectMapper().writer();

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == BasePoint.class;
    }

    /**
     * {
     * "type": "Point",
     * "coordinates": [100.0, 0.0]
     * }
     * <a href=https://tools.ietf.org/html/rfc7946#appendix-A>RFC</a>
     *
     * @param point
     * @param type
     * @param genericType
     * @param annotations
     * @param mediaType
     * @param httpHeaders
     * @param entityStream
     * @throws IOException
     * @throws WebApplicationException
     */
    @Override
    public void writeTo(Point point, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        try {
            objectWriter.writeValue(entityStream, toGeoJson(point));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private JsonNode toGeoJson(Point point) {
        return JsonNodeFactory.instance.objectNode()
                .put("type", "Point")
                .set("coordinates", JsonNodeFactory.instance.arrayNode(2).add(point.getX()).add(point.getY()));
    }
}

