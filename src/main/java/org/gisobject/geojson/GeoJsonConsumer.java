package org.gisobject.geojson;

import org.gisobject.rest.playground.geometry.Point;

public interface GeoJsonConsumer<E> {

    Point toPoint(E jsonInstance);

}
