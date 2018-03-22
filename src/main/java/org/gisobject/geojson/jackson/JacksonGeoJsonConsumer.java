package org.gisobject.geojson.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.gisobject.geojson.GeoJsonConsumer;
import org.gisobject.rest.playground.geometry.Point;

import java.math.BigDecimal;

public class JacksonGeoJsonConsumer implements GeoJsonConsumer<JsonNode> {

    private ObjectReader objectReader = new ObjectMapper().reader();

    @Override
    public Point toPoint(JsonNode jsonInstance) {
        ArrayNode arrayNode = (ArrayNode)jsonInstance.path("coordinates");
        BigDecimal x = new BigDecimal(arrayNode.get(0).asText());
        BigDecimal y = new BigDecimal(arrayNode.get(1).asText());
        return Point.of(x,y);
    }
}
