package org.gisobject.geojson.provider.gson;

import com.google.gson.*;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.gisobject.geojson.provider.GeoJsonProvider;
import org.gisobject.rest.playground.geometry.Point;

import java.io.IOException;

public class GsonGeoJsonProvider implements GeoJsonProvider<JsonElement> {

    private Gson gson = new GsonBuilder().registerTypeAdapter(Point.class, new TypeAdapter<Point>() {
        @Override
        public void write(JsonWriter out, Point value) throws IOException {
            JsonArray jsonCoordinates = new JsonArray(2);
            jsonCoordinates.add(value.getX());
            jsonCoordinates.add(value.getY());
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", "Point");
            jsonObject.add("coordinates", jsonCoordinates);
            TypeAdapters.JSON_ELEMENT.write(out, jsonObject);
        }

        @Override
        public Point read(JsonReader in) throws IOException {
            JsonElement jsonElement = TypeAdapters.JSON_ELEMENT.read(in);
            JsonObject jsonObject = (JsonObject) jsonElement;
            JsonArray jsonCoordinates = jsonObject.getAsJsonArray("coordinates");
            return Point.of(jsonCoordinates.get(0).getAsBigDecimal(), jsonCoordinates.get(0).getAsBigDecimal());
        }
    }).create();

    @Override
    public JsonElement fromPoint(Point point) {
        return gson.toJsonTree(point);
    }
}
