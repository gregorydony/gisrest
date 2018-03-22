package org.gisobject.geojson.consumer;

import org.gisobject.rest.playground.geometry.Point;

public interface GeoJsonConsumer<E> {

    Point toPoint(E jsonInstance);

}
