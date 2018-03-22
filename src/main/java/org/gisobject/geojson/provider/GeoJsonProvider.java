package org.gisobject.geojson.provider;

import org.gisobject.rest.playground.geometry.Point;

public interface GeoJsonProvider<E> {

    E fromPoint(Point point);

}
