package org.gisobject.geojson.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.gisobject.geojson.GeoJsonConsumer;
import org.gisobject.rest.playground.geometry.Point;

public class GsonGeoJsonConsumer implements GeoJsonConsumer<JsonElement> {

    private Gson gson = new GsonBuilder().registerTypeAdapter(Point.class, GsonGeoJsonTypeAdapters.POINT).create();

    @Override
    public Point toPoint(JsonElement jsonInstance) {
        return gson.fromJson(jsonInstance, Point.class);
    }
}
