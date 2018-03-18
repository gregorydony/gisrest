package org.gisobject.rest.playground.geojson.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.gisobject.rest.playground.geometry.Point;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;

@Provider
public class PointMessageBodyReader implements MessageBodyReader<Point> {

    private ObjectReader objectReader = new ObjectMapper().reader();

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == Point.class;
    }

    @Override
    public Point readFrom(Class<Point> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        JsonNode jsonNode = objectReader.readTree(entityStream);
        return fromGeoJson(jsonNode);
    }

    private Point fromGeoJson(JsonNode jsonNode) {
        ArrayNode arrayNode = (ArrayNode)jsonNode.path("coordinates");
        BigDecimal x = new BigDecimal(arrayNode.get(0).asText());
        BigDecimal y = new BigDecimal(arrayNode.get(1).asText());
        return Point.from(x,y);
    }
}
