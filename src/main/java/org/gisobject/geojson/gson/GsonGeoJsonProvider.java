package org.gisobject.geojson.gson;

import com.google.gson.*;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.gisobject.geojson.GeoJsonProvider;
import org.gisobject.rest.playground.geometry.Point;

import java.io.IOException;

public class GsonGeoJsonProvider implements GeoJsonProvider<JsonElement> {

    private Gson gson = new GsonBuilder().registerTypeAdapter(Point.class, GsonGeoJsonTypeAdapters.POINT).create();

    @Override
    public JsonElement fromPoint(Point point) {
        return gson.toJsonTree(point);
    }
}
