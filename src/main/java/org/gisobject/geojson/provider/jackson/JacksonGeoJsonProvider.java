package org.gisobject.geojson.provider.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.gisobject.geojson.provider.GeoJsonProvider;
import org.gisobject.rest.playground.geometry.Point;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

public class JacksonGeoJsonProvider implements GeoJsonProvider<JsonNode> {

    private ObjectWriter objectWriter = new ObjectMapper().writer();

    @Override
    public JsonNode fromPoint(Point point) {
        return JsonNodeFactory.instance.objectNode()
                .put("type", "Point")
                .set("coordinates", JsonNodeFactory.instance.arrayNode(2).add(point.getX()).add(point.getY()));
    }
}
